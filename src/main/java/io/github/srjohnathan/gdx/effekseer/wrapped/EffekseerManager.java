package io.github.srjohnathan.gdx.effekseer.wrapped;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.Viewport;
import io.github.srjohnathan.gdx.effekseer.core.*;

/**
 * The base class used to manage an Effekseer particle system instance.
 * Override the following protected methods for customizing what happens during a draw call:
 *  {@link #shouldCameraBeUpdatedInDraw()},
 *  {@link #onPreDraw()},
 *  {@link #onPostDraw()}
 */
public class EffekseerManager implements Disposable {

    //region Static

    private static final float SINGLE_FRAME_TIME_SECONDS = 1.0f / 60.0f;
    private static final float SINGLE_FRAME_TIME_SECONDS_INV = 1.0f / SINGLE_FRAME_TIME_SECONDS;

    private static final int MAX_BATCH_SIZE_PENDING_PARTICLE_TRANSFORM = 4;

    //endregion

    //region Properties

    protected EffekseerManagerCore effekseerManagerCore;
    protected Camera camera;
    private Viewport viewport;
    /**
     * Contains all the added Effekseer particle effects.
     */
    private final Array<EffekseerParticle> effekseers;

    //endregion

    //region State

    /**
     * An optional {@link RenderContext} used to reduce graphics calls.
     */
    private RenderContext renderContext = null;

    /**
     * The DrawParameter instance to use for calling the {@link EffekseerManagerCore#Draw(EffekseerManagerParameters.DrawParameter)} method.
     */
    private final EffekseerManagerParameters.DrawParameter drawParameter;

    /**
     * The time passed in seconds since the start.
     */
    private float timeInSeconds = 0f;

    /**
     * Keep track of effects that have transform changes that need to be sent to Effekseer. Using this allows for batch updating
     * to reduce JNI calls.
     */
    private Array<EffekseerParticle> pendingEffectsWithTransformChanges = new Array<>(false, 4);

    //endregion

    //region Constructors

    /**
     * @param renderContext Optional instance to a {@link RenderContext} to try to reduce calls to the graphics api.
     */
    public EffekseerManager(Camera camera, EffekseerCore.TypeOpenGL core, int maxSpriteCount, RenderContext renderContext) {
        EffekseerBackendCore.InitializeAsOpenGL();

        // Set the render context if available
        this.renderContext = renderContext;

        // Set the properties/state
        this.effekseerManagerCore = new EffekseerManagerCore();
        this.camera = camera;
        this.effekseers = new Array<>(false, 16);
        this.drawParameter = new EffekseerManagerParameters.DrawParameter();

        // Initialize the core manager
        if (!this.effekseerManagerCore.Initialize(maxSpriteCount, core.getId(),true)) {
            throw new RuntimeException("Failed to initialize the Effekseer manager instance with " + core.name() + " and max sprite count of " + maxSpriteCount);
        }
    }

    public EffekseerManager(Camera camera, EffekseerCore.TypeOpenGL core, int maxSpriteCount) {
        this(camera, core, maxSpriteCount, null);
    }

    //endregion

    //region Protected Methods

    protected RenderContext getRenderContext() {
        return this.renderContext;
    }

    protected void addParticleEffekseer(EffekseerParticle effekseer) {
        this.effekseers.add(effekseer);
    }

    protected void removeParticleEffekseer(EffekseerParticle effekseer) {
        this.effekseers.removeValue(effekseer, true);
    }

    protected boolean shouldCameraBeUpdatedInDraw() {
        return false;
    }

    /**
     * Called at the start of the draw call.
     */
    protected void onPreDraw() {
        if (this.renderContext != null) {
            this.renderContext.setBlending(true, GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
            this.renderContext.setDepthTest(GL20.GL_LESS, 0f, 1f);
        }
        else {
            Gdx.gl.glEnable(GL20.GL_BLEND);
            Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);
        }
    }

    /**
     * Called at the end of the draw call.
     */
    protected void onPostDraw() {
        // Do nothing
    }

    //endregion

    //region Public Methods

    //region Getters/Setters

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public Camera getCamera() {
        return this.camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    /**
     *
     * @return The {@link EffekseerManagerParameters.DrawParameter} being used for every draw call. Update the state of this
     * instance for affecting how the particles are drawn (culling and render sorting).
     */
    public EffekseerManagerParameters.DrawParameter getDrawParameter() {
        return drawParameter;
    }

    //endregion

    //region Wrapper Methods

    public void launchWorkerThreads(long threadCount) {
        effekseerManagerCore.LaunchWorkerThreads(threadCount);
    }

    public boolean exists(int handle) {
        return effekseerManagerCore.Exists(handle);
    }

    public int play(EffekseerEffectCore effect) {
        return effekseerManagerCore.Play(effect);
    }

    public void stopEffect(int handle) {
        effekseerManagerCore.StopEffect(handle);
    }

    public void stopAllEffects() {
        effekseerManagerCore.StopAllEffects();
    }

    public void stopRoot(int handle) {
        effekseerManagerCore.StopRoot(handle);
    }

    public int getInstanceCount(int handle) {
        return effekseerManagerCore.GetInstanceCount(handle);
    }

    public int getTotalInstanceCount() {
        return effekseerManagerCore.GetTotalInstanceCount();
    }

    public float[] getMatrix(int handle) {
        return effekseerManagerCore.GetMatrix(handle);
    }

    public float[] getBaseMatrix(int handle) {
        return effekseerManagerCore.GetBaseMatrix(handle);
    }

    /**
     * To avoid multiple ways of setting the transform of a particle effect these methods are commented out.
     * Use {@link EffekseerParticle}'s transform methods instead.
     */
    /*
    public void setMatrix(int handle, float[] matrix43) {
        effekseerManagerCore.SetMatrix(handle, matrix43);
    }

    public void setBaseMatrix(int handle, float[] matrix43) {
        effekseerManagerCore.SetBaseMatrix(handle, matrix43);
    }

    public Vector3D getLocation(int handle) {
        return effekseerManagerCore.GetLocation(handle);
    }

    public void setLocation(int handle, float x, float y, float z) {
        effekseerManagerCore.SetLocation(handle, x, y, z);
    }

    public void setLocation(int handle, Vector3D location) {
        effekseerManagerCore.SetLocation(handle, location);
    }

    public void addLocation(int handle, Vector3D location) {
        effekseerManagerCore.AddLocation(handle, location);
    }

    public void setRotation(int handle, float x, float y, float z) {
        effekseerManagerCore.SetRotation(handle, x, y, z);
    }

    public void setRotation(int handle, Vector3D axis, float angle) {
        effekseerManagerCore.SetRotation(handle, axis, angle);
    }

    public void setScale(int handle, float x, float y, float z) {
        effekseerManagerCore.SetScale(handle, x, y, z);
    }
     */

    public void setAllColor(int handle, Color color) {
        effekseerManagerCore.SetAllColor(handle, color);
    }

    public void setTargetLocation(int handle, float x, float y, float z) {
        effekseerManagerCore.SetTargetLocation(handle, x, y, z);
    }

    public void setTargetLocation(int handle, Vector3D location) {
        effekseerManagerCore.SetTargetLocation(handle, location);
    }

    public float getDynamicInput(int handle, int index) {
        return effekseerManagerCore.GetDynamicInput(handle, index);
    }

    public void setDynamicInput(int handle, int index, float value) {
        effekseerManagerCore.SetDynamicInput(handle, index, value);
    }

    public boolean isPlaying(EffekseerParticle effekseer) {
        return this.effekseerManagerCore.GetShown(effekseer.getHandle());
    }

    public boolean getShown(int handle) {
        return effekseerManagerCore.GetShown(handle);
    }

    public void setShown(int handle, boolean shown) {
        effekseerManagerCore.SetShown(handle, shown);
    }

    public boolean getPaused(int handle) {
        return effekseerManagerCore.GetPaused(handle);
    }

    public void setPaused(int handle, boolean paused) {
        effekseerManagerCore.SetPaused(handle, paused);
    }

    public void setPausedToAllEffects(boolean paused) {
        effekseerManagerCore.SetPausedToAllEffects(paused);
    }

    public int getLayer(int handle) {
        return effekseerManagerCore.GetLayer(handle);
    }

    public void setLayer(int handle, int layer) {
        effekseerManagerCore.SetLayer(handle, layer);
    }

    public long getGroupMask(int handle) {
        return effekseerManagerCore.GetGroupMask(handle);
    }

    public void setGroupMask(int handle, long groupmask) {
        effekseerManagerCore.SetGroupMask(handle, groupmask);
    }

    public float getSpeed(int handle) {
        return effekseerManagerCore.GetSpeed(handle);
    }

    public void setSpeed(int handle, float speed) {
        effekseerManagerCore.SetSpeed(handle, speed);
    }

    public void setTimeScaleByGroup(long groupmask, float timeScale) {
        effekseerManagerCore.SetTimeScaleByGroup(groupmask, timeScale);
    }

    public void setTimeScaleByHandle(int handle, float timeScale) {
        effekseerManagerCore.SetTimeScaleByHandle(handle, timeScale);
    }

    public void setAutoDrawing(int handle, boolean autoDraw) {
        effekseerManagerCore.SetAutoDrawing(handle, autoDraw);
    }

    public void flip() {
        effekseerManagerCore.Flip();
    }

    public void updateHandleToMoveToFrame(int handle, float frame) {
        effekseerManagerCore.UpdateHandleToMoveToFrame(handle, frame);
    }

    //endregion

    /**
     * Batches multiple pending effect transforms to a single JNI call.
     */
    private void sendPendingEffectTransformsToEffekseer() {
        while (!this.pendingEffectsWithTransformChanges.isEmpty()) {
            if (this.pendingEffectsWithTransformChanges.size >= MAX_BATCH_SIZE_PENDING_PARTICLE_TRANSFORM) {
                EffekseerParticle particle1 = this.pendingEffectsWithTransformChanges.pop();
                EffekseerParticle particle2 = this.pendingEffectsWithTransformChanges.pop();
                EffekseerParticle particle3 = this.pendingEffectsWithTransformChanges.pop();
                EffekseerParticle particle4 = this.pendingEffectsWithTransformChanges.pop();

                this.effekseerManagerCore.SetMatrixBatch4(
                        particle1.getHandle(), particle1.getTransformValuesForEffekseer(),
                        particle2.getHandle(), particle2.getTransformValuesForEffekseer(),
                        particle3.getHandle(), particle3.getTransformValuesForEffekseer(),
                        particle4.getHandle(), particle4.getTransformValuesForEffekseer());
            }
            else if (this.pendingEffectsWithTransformChanges.size >= 2) {
                EffekseerParticle particle1 = this.pendingEffectsWithTransformChanges.pop();
                EffekseerParticle particle2 = this.pendingEffectsWithTransformChanges.pop();

                this.effekseerManagerCore.SetMatrixBatch2(
                        particle1.getHandle(), particle1.getTransformValuesForEffekseer(),
                        particle2.getHandle(), particle2.getTransformValuesForEffekseer());
            }
            else {
                EffekseerParticle particle = this.pendingEffectsWithTransformChanges.pop();
                this.effekseerManagerCore.SetMatrix(particle.getHandle(), particle.getTransformValuesForEffekseer());
            }
        }
    }

    /**
     * Updates all state needed for the current step in the simulation. Call this only once per frame.
     * If you only draw the simulation once per frame, you can call @link #draw(float)} instead which calls this
     * update method and then the draw method.
     * @param delta The time in seconds since the last frame.
     */
    public void update(float delta) {
        this.timeInSeconds += delta;

        // If the LibGDX camera state should be updated here
        if (this.shouldCameraBeUpdatedInDraw()) {
            this.camera.update();
        }

        // Update and draw each particle effect
        for (EffekseerParticle particle : this.effekseers) {
            // Only update the particle effect if it is playing
            if (particle.isInPlayingState()) {
                particle.update(delta);

                // Check if the current effect has just finished playing. If so, call its animation completed callback if available.
                if (!this.isPlaying(particle)) {
                    particle.setToStopState();
                    if (particle.getOnAnimationComplete() != null) {
                        particle.getOnAnimationComplete().finish();
                    }
                }

                if (this.camera instanceof PerspectiveCamera) {
                    if (particle.updateTransformMatrixIfQueued()) {
                        this.pendingEffectsWithTransformChanges.add(particle);

                        // Send if there are enough for batching
                        if (this.pendingEffectsWithTransformChanges.size >= MAX_BATCH_SIZE_PENDING_PARTICLE_TRANSFORM) {
                            this.sendPendingEffectTransformsToEffekseer();
                        }
                    }
                }
            }
        }

        if (!this.pendingEffectsWithTransformChanges.isEmpty()) {
            this.sendPendingEffectTransformsToEffekseer();
        }

        // Get the camera width and height
        float cameraWidth = 0f;
        float cameraHeight = 0f;
        if (this.camera instanceof OrthographicCamera) {
            if (this.viewport != null) {
                cameraWidth = this.viewport.getWorldWidth();
                cameraHeight = this.viewport.getWorldHeight();
                this.effekseerManagerCore.SetProjectionMatrix((camera).projection.val, (camera).view.val, false, viewport.getWorldWidth(), viewport.getWorldHeight());
            }
            else {
                cameraWidth = this.camera.viewportWidth;
                cameraHeight = this.camera.viewportHeight;
            }
        }

        // Update the manager core
        this.effekseerManagerCore.UpdateCombined(
                delta * SINGLE_FRAME_TIME_SECONDS_INV,
                this.timeInSeconds,
                this.camera.projection.val, this.camera.view.val, this.camera instanceof PerspectiveCamera, cameraWidth, cameraHeight);
    }

    /**
     * This draws all added particle effects. This should only be called after a {@link #update(float)} call and can be called
     * multiple times without affecting the update step.
     */
    public void drawAfterUpdate() {
        this.onPreDraw();

        // Draw
        this.effekseerManagerCore.DrawCombined(this.drawParameter);

        this.onPostDraw();
    }

    /**
     * This calls the updates methods and then draws all added particle effects. Call {@link #getDrawParameter()} before this call, and update its state to further affect
     * how the particles are drawn.
     * If you want to draw multiple times do NOT use this method. Call {@link #update(float)} and then call {@link #drawAfterUpdate()} however many times draw calls are needed.
     * @param delta The time in seconds since the last frame.
     */
    public void draw(float delta) {
        // Update
        this.update(delta);

        // Draw
        this.drawAfterUpdate();
    }

    //endregion

    //region Disposable

    @Override
    public void dispose() {
        // Delete all added effect instances. Use while loop to avoid nested iterator usages of LibGDX Array.
        while (!this.effekseers.isEmpty()) {
            this.effekseers.first().dispose();
        }
        // Delete the manager core
        this.effekseerManagerCore.delete();
        // Terminate the backend
        EffekseerBackendCore.Terminate();
    }

    //endregion
}
