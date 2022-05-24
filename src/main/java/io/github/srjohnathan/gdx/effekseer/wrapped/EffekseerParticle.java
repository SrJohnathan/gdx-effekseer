package io.github.srjohnathan.gdx.effekseer.wrapped;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;
import io.github.srjohnathan.gdx.effekseer.core.*;
import io.github.srjohnathan.gdx.effekseer.loader.EffekseerParticleAssetLoader;
import io.github.srjohnathan.gdx.effekseer.wrapped.node.EffekseerNode;
import io.github.srjohnathan.gdx.effekseer.wrapped.node.EffekseerNodeRoot;

import java.util.Objects;
import java.util.function.Function;

public class EffekseerParticle implements Disposable {

    //region State

    private final Matrix4 transform = new Matrix4();

    private final EffekseerEffectCore effekseerEffectCore;

    private final float[] mtx = new float[12];
    private EffekseerManager manager;
    private OnAnimationComplete onAnimationComplete;
    private int handle;
    private boolean play;
    private float magnification = 1.0f;

    private boolean isTransformMatrixUpdateQueued = false;
    private boolean isGetTransformMatrixFromEffekseerQueued = true;

    private AssetManager loadingInAssetManager;

    private EffekseerFieldWrapper<EffekseerNode> rootNode = new EffekseerFieldWrapper<>(new Function<Void, EffekseerNode>() {
        @Override
        public EffekseerNode apply(Void unused) {
            return new EffekseerNodeRoot(EffekseerParticle.this, effekseerEffectCore.GetRootNode());
        }
    }, new Function<EffekseerNode, Void>() {
        @Override
        public Void apply(EffekseerNode effekseerNode) {
            // Can't set root node
            return null;
        }
    });

    //endregion

    //region Constructors

    public EffekseerParticle(EffekseerManager manager) {
        this.manager = Objects.requireNonNull(manager);
        this.manager.addParticleEffekseer(this);
        this.effekseerEffectCore = new EffekseerEffectCore();
    }

    //endregion

    //region Transform Matrix Methods

    /**
     * @return True if there were transform changes that were applied. Call {@link #getTransformValuesForEffekseer} to the transform floats to send to Effekseer.
     */
    protected boolean updateTransformMatrixIfQueued() {
        if (this.isTransformMatrixUpdateQueued) {
            this.transform.extract4x3Matrix(this.mtx);
            this.isTransformMatrixUpdateQueued = false;

            return true;
        }

        return false;
    }

    protected final float[] getTransformValuesForEffekseer() {
        return this.mtx;
    }

    private void getTransformFromEffekseer() {
        float[] dst = this.manager.effekseerManagerCore.GetMatrix(this.handle);

        this.transform.val[Matrix4.M00] = dst[0];
        this.transform.val[Matrix4.M10] = dst[1];
        this.transform.val[Matrix4.M20] = dst[2];
        this.transform.val[Matrix4.M01] = dst[3];
        this.transform.val[Matrix4.M11] = dst[4];
        this.transform.val[Matrix4.M21] = dst[5];
        this.transform.val[Matrix4.M02] = dst[6];
        this.transform.val[Matrix4.M12] = dst[7];
        this.transform.val[Matrix4.M22] = dst[8];
        this.transform.val[Matrix4.M03] = dst[9];
        this.transform.val[Matrix4.M13] = dst[10];
        this.transform.val[Matrix4.M23] = dst[11];
    }

    /**
     * Queues an update (calls Effekseer's SetMatrix()) of the transform matrix call for this effect the next time this effect is drawn.
     */
    private void queueUpdateTransformMatrix() {
        this.isTransformMatrixUpdateQueued = true;
    }

    /**
     *
     * @return The {@link Matrix4} instance used for transforming this particle. Calling this will also queue a transform update
     * for Effekseer so that this transform is reflected in Effekseer.
     */
    public Matrix4 getTransform() {
        this.queueUpdateTransformMatrix();
        return this.transform;
    }

    public void setTranslation(float x, float y, float z) {
        this.transform.setTranslation(x, y, z);
        this.queueUpdateTransformMatrix();
    }

    public void translate(float x, float y, float z) {
        this.transform.translate(x, y, z);
        this.queueUpdateTransformMatrix();
    }

    public void setRotation(Vector3 axis, float angle) {
        this.transform.setToRotation(axis, angle);
        this.queueUpdateTransformMatrix();
    }

    public void setRotation(float axisX, float axisY, float axisZ, float degrees) {
        this.transform.setToRotation(axisX, axisY, axisZ, degrees);
        this.queueUpdateTransformMatrix();
    }

    public void rotate(Vector3 axis, float angle) {
        this.transform.rotate(axis, angle);
        this.queueUpdateTransformMatrix();
    }

    public void rotate(float axisX, float axisY, float axisZ, float degrees) {
        this.transform.rotate(axisX, axisY, axisZ, degrees);
        this.queueUpdateTransformMatrix();
    }

    public void setScale(float x, float y, float z) {
        this.transform.setToScaling(x, y, z);
        this.queueUpdateTransformMatrix();
    }

    public void scale(float x, float y, float z) {
        this.transform.scale(x, y, z);
        this.queueUpdateTransformMatrix();
    }

    //endregion

    //region Overrides

    @Override
    public void dispose() {
        this.stop();
        this.delete();
    }

    //endregion

    //region Protected Methods

    protected void update(float delta) {
        // Check for loading
        if (this.loadingInAssetManager != null) {
            this.loadingInAssetManager.update();
        }
    }

    protected void setToStopState() {
        this.play = false;
    }

    protected OnAnimationComplete getOnAnimationComplete() {
        return onAnimationComplete;
    }

    protected void delete() {
        manager.removeParticleEffekseer(this);
        effekseerEffectCore.delete();
    }

    //endregion

    //region Public Methods

    public int getHandle() {
        return this.handle;
    }

    public int getNodeCount() {
        return this.effekseerEffectCore.NodeCount();
    }

    public void setMagnification(float magnification) {
        this.magnification = magnification;
    }

    public boolean isInPlayingState() {
        return play;
    }

    //region Loading

    /**
     * @return The {@link AssetDescriptor} used for loading the particle effect at the given {@link FileHandle} into this instance.
     * The {@link AssetDescriptor} returned will have its {@link com.badlogic.gdx.assets.AssetLoaderParameters#loadedCallback} set.
     */
    public AssetDescriptor<EffekseerParticleAssetLoader.Result> getAssetDescriptorWithoutLoading(FileHandle effectFileHandle, LoadedListener loadedListener) {
        // Create the asset descriptor for sending to the given AssetManager
        AssetDescriptor<EffekseerParticleAssetLoader.Result> assetDescriptor = EffekseerParticleAssetLoader.getMainFileAssetDescriptor(effectFileHandle, this.manager.effekseerManagerCore, this.effekseerEffectCore, this.magnification);

        // Listen for finished loading
        assetDescriptor.params.loadedCallback = (assetManager1, fileName, type) -> {
            // Reset the tracked asset manager
            loadingInAssetManager = null;
            // Load the data into the effect
            EffekseerParticleAssetLoader.Result loadedData = assetManager1.get(assetDescriptor);
            loadFromEffectAssetResult(loadedData);

            // Call listener
            if (loadedListener != null) {
                loadedListener.onEffectLoaded();
            }

            // Recycle the parameter instance
            ((EffekseerParticleAssetLoader.Parameters)assetDescriptor.params).recycle();
        };

        return assetDescriptor;
    }

    /**
     * Loads the particle loaded effect data ({@link EffekseerParticleAssetLoader.Result}) into this instance.
     */
    public void loadFromEffectAssetResult(EffekseerParticleAssetLoader.Result result) {
        result.loadInfoEffect(manager.effekseerManagerCore, effekseerEffectCore, magnification);
    }

    /**
     * Asynchronously loads the given effect file. An optional {@link LoadedListener} can be given for listening to when the
     * effect has finished loading.
     */
    public void asyncLoad(AssetManager assetManager, FileHandle effectFileHandle, LoadedListener loadedListener) {
        // Track the asset manager for updating load state
        this.loadingInAssetManager = assetManager;

        AssetDescriptor<EffekseerParticleAssetLoader.Result> assetDescriptor = this.getAssetDescriptorWithoutLoading(effectFileHandle, loadedListener);

        // Now start the load
        assetManager.load(assetDescriptor);
    }

    /**
     * Asynchronously loads the given effect file. An optional {@link LoadedListener} can be given for listening to when the
     * effect has finished loading.
     */
    public void asyncLoad(AssetManager assetManager, String path, LoadedListener loadedListener) {
        // Get the file handle
        FileHandle effectFileHandle = assetManager.getFileHandleResolver().resolve(path);

        // Call load() with the generated file handle
        this.asyncLoad(assetManager, effectFileHandle, loadedListener);
    }

    /**
     * Synchronously loads the given effect file.
     */
    public void syncLoad(AssetManager assetManager, FileHandle effectFileHandle) throws IllegalStateException {
        EffekseerParticleAssetLoader.syncLoad(assetManager, effectFileHandle, this.manager.effekseerManagerCore, this.effekseerEffectCore, this.magnification);
    }

    /**
     * Synchronously loads the given effect file.
     */
    public void syncLoad(AssetManager assetManager, String path) throws IllegalStateException {
        // Get the file handle
        FileHandle effectFileHandle = assetManager.getFileHandleResolver().resolve(path);

        // Call load() with the generated file handle
        this.syncLoad(assetManager, effectFileHandle);
    }

    //endregion

    public void setOnAnimationComplete(OnAnimationComplete onAnimationComplete) {
        this.onAnimationComplete = onAnimationComplete;
    }

    //region Manager Wrapper Methods

    public int play() {
        this.play = true;
        this.handle = this.manager.play(this.effekseerEffectCore);

        if (this.isGetTransformMatrixFromEffekseerQueued) {
            // Get the initial transforms from Effekseer
            this.getTransformFromEffekseer();
            this.isGetTransformMatrixFromEffekseerQueued = false;
        }
        this.queueUpdateTransformMatrix();

        return this.handle;
    }

    public void pause() {
        this.manager.setPaused(handle, true);
    }

    public void resume() {
        this.manager.setPaused(handle, false);
    }

    public void stop() {
        if (this.play) {
            this.manager.stopEffect(this.handle);
            this.setToStopState();
        }
    }

    public int getInstanceCount() {
        return this.manager.getInstanceCount(this.handle);
    }

    public void setTargetLocation(float x, float y, float z) {
        this.manager.setTargetLocation(this.handle, x, y, z);
    }

    public void setTargetLocation(Vector3D location) {
        this.manager.setTargetLocation(this.handle, location);
    }

    public float getDynamicInput(int index) {
        return this.manager.getDynamicInput(this.handle, index);
    }

    public void setDynamicInput(int index, float value) {
        this.manager.setDynamicInput(this.handle, index, value);
    }

    public boolean getIsShown() {
        return this.manager.getShown(this.handle);
    }

    public void setIsShown(boolean shown) {
        this.manager.setShown(this.handle, shown);
    }

    public boolean getIsPaused() {
        return this.manager.getPaused(this.handle);
    }

    public void setIsPaused(boolean paused) {
        this.manager.setPaused(this.handle, paused);
    }

    public int getLayer() {
        return this.manager.getLayer(this.handle);
    }

    public void setLayer(int layer) {
        this.manager.setLayer(this.handle, layer);
    }

    public long getGroupMask() {
        return this.manager.getGroupMask(this.handle);
    }

    public void setGroupMask(long groupmask) {
        this.manager.setGroupMask(this.handle, groupmask);
    }

    public float getSpeed() {
        return this.manager.getSpeed(this.handle);
    }

    public void setSpeed(float speed) {
        this.manager.setSpeed(this.handle, speed);
    }

    public void setTimeScale(float timeScale) {
        this.manager.setTimeScaleByHandle(this.handle, timeScale);
    }

    //endregion

    //region Effect Wrapper Methods

    public String getName() {
        return this.effekseerEffectCore.GetName();
    }

    public void setName(String name) {
        this.effekseerEffectCore.SetName(name);
    }

    public int getVersion() {
        return this.effekseerEffectCore.GetVersion();
    }

    public EffekseerNode getRootNode() {
        return this.rootNode.get();
    }

    //endregion

    //endregion

    //region Interfaces

    public interface LoadedListener {
        void onEffectLoaded();
    }

    //endregion
}
