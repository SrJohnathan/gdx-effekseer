package io.github.srjohnathan.gdx.effekseer.core;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import java.util.Objects;

public class ParticleEffekseer {

    //region State

    public final Matrix4 transform = new Matrix4();

    private final EffekseerEffectCore effekseerEffectCore;
    // private int nodeSize = 0;
    // private ArrayList<EffekseerNode> nodes;

    private final float[] mtx = new float[12];
    private EffekseerManager manager;
    private OnAnimationComplete onAnimationComplete;
    private int handle;
    private boolean play;
    private float magnification = 1.0f;

    private boolean isMatrixUpdateQueued = false;

    //endregion

    //region Constructors

    public ParticleEffekseer( EffekseerManager manager) {
        this.manager = Objects.requireNonNull(manager);
        this.manager.addParticleEffekseer(this);
        this.effekseerEffectCore = new EffekseerEffectCore();
        // nodes = new ArrayList<>();
    }

    //endregion

    //region Transform Matrix Methods

    protected void updateTransformMatrixIfQueued() {
        if (this.isMatrixUpdateQueued) {
            this.transform.extract4x3Matrix(this.mtx);
            this.manager.effekseerManagerCore.SetMatrix(this.handle, this.mtx);
        }
    }

    /**
     * Queues an update (calls Effekseer's SetMatrix()) of the transform matrix call for this effect the next time this effect is drawn.
     */
    private void queueUpdateTransformMatrix() {
        float[] dst = this.manager.effekseerManagerCore.GetMatrix(handle);

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

        this.isMatrixUpdateQueued = true;
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

    public void scale(float x, float y, float z) {
        this.transform.scale(x, y, z);
        this.queueUpdateTransformMatrix();
    }

    public void setScale(float x, float y, float z) {
        this.transform.setToScaling(x, y, z);
        this.queueUpdateTransformMatrix();
    }

    //endregion

    //region Private Methods

    private FileHandle getPathAsFileHandle(String path, Files.FileType fileType) {
        switch (fileType) {
            case Classpath:
                return Gdx.files.classpath(path);
            case Internal:
                return Gdx.files.internal(path);
            case External:
                return Gdx.files.external(path);
            case Absolute:
                return Gdx.files.absolute(path);
            case Local:
                return Gdx.files.local(path);
        }

        return Gdx.files.internal(path);
    }

    //endregion

    //region Protected Methods

    protected void update(float delta) {
     /*   if (nodes.size() > 0) {
            nodes.forEach(effekseerNode -> {
                effekseerNode.update(delta);
            });
        }    */
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

   /* public ArrayList<EffekseerNode> getNodes() {
        return nodes;
    }
    */

  /*  public EffekseerNode getNode() {
        return effekseerEffectCore.getNode();
    }
    */

    public void load(FileHandle effectFileHandle) throws IllegalStateException {
        // Check that the manager core is available
        if (this.manager.effekseerManagerCore == null) {
            throw new IllegalStateException("add particle on manager");
        }

        byte[] byt = effectFileHandle.readBytes();

        try {
            if (!this.effekseerEffectCore.load(manager.effekseerManagerCore, byt, byt.length, this.magnification)) {
                System.out.print("Failed to load.");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // load textures
        EffekseerTextureType[] textureTypes = new EffekseerTextureType[]{
            EffekseerTextureType.Color,
            EffekseerTextureType.Normal,
            EffekseerTextureType.Distortion,
        };

        for (int t = 0; t < 3; t++) {
            for (int i = 0; i < this.effekseerEffectCore.GetTextureCount(textureTypes[t]); i++) {
                String path = effectFileHandle.file().getParent();
                if (path != null) {
                    path += "/" + this.effekseerEffectCore.GetTexturePath(i, textureTypes[t]);
                }
                else {
                    path = this.effekseerEffectCore.GetTexturePath(i, textureTypes[t]);
                }

                FileHandle textureFileHandle = this.getPathAsFileHandle(path, effectFileHandle.type());
                byte[] bytes = textureFileHandle.readBytes();
                this.effekseerEffectCore.LoadTexture(bytes, bytes.length, i, textureTypes[t]);
            }
        }

        for (int i = 0; i < this.effekseerEffectCore.GetModelCount(); i++) {
            String path = effectFileHandle.file().getParent();
            if (path != null) {
                path += "/" + this.effekseerEffectCore.GetModelPath(i);
            }
            else {
                path = this.effekseerEffectCore.GetModelPath(i);
            }

            FileHandle modelFileHandle = this.getPathAsFileHandle(path, effectFileHandle.type());
            byte[] bytes = modelFileHandle.readBytes();
            this.effekseerEffectCore.LoadModel(bytes, bytes.length, i);
        }

        for (int i = 0; i < effekseerEffectCore.GetMaterialCount(); i++) {
            String path = effectFileHandle.file().getParent();
            if (path != null) {
                path += "/" + effekseerEffectCore.GetMaterialPath(i);
            }
            else {
                path = effekseerEffectCore.GetMaterialPath(i);
            }

            FileHandle materialFileHandle = this.getPathAsFileHandle(path, effectFileHandle.type());
            byte[] bytes = materialFileHandle.readBytes();
            effekseerEffectCore.LoadMaterial(bytes, bytes.length, i);
        }

        // TODO sound

        /*
        nodeSize = effekseerEffectCore.getNodesSize();
        for (int i = 0; i < nodeSize; i++) {
            EffekseerNode node = new EffekseerNode(effekseerEffectCore.swigCPtr, i, true);
            node.setMagnification(magnification);
            node.setManager(manager);
            nodes.add(node);
        }
         */
    }

    public void load(String path, boolean isInternalStorage) throws IllegalStateException {
        // Get the file handle
        FileHandle effectFileHandle = null;
        if (isInternalStorage) {
            effectFileHandle = Gdx.files.internal(path);
        } else {
            effectFileHandle = Gdx.files.external(path);
        }

        // Call load() with the generated file handle
        this.load(effectFileHandle);
    }

    public void setOnAnimationComplete(OnAnimationComplete onAnimationComplete) {
        this.onAnimationComplete = onAnimationComplete;
    }

    //region Wrapper Methods

    public int play() {
        this.play = true;
        this.handle = this.manager.play(this.effekseerEffectCore);

        this.queueUpdateTransformMatrix();

      /*  if (nodes.size() > 0) {
            nodes.forEach(effekseerNode -> {
                effekseerNode.setPlay(play);
            });
        }
            */

        return this.handle;
    }

    public void pause() {
        this.manager.setPaused(handle, true);
    }

    public void resume() {
        this.manager.setPaused(handle, false);
    }

    public void stop() {
        this.manager.stopEffect(this.handle);
        this.setToStopState();
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

    //endregion

  /*  public interface EffekseerXYZListener {
        void fixed(VectorFixed Class);

        void pva(VectorPVA Class);

        void easing(EasingVector3d Class);

        void single(VectorPVASingle Class);
    }     */
}
