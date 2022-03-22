package io.github.srjohnathan.gdx.effekseer.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.Viewport;

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

    //endregion

    //region Properties

    protected EffekseerManagerCore effekseerManagerCore;
    protected Camera camera;
    private Viewport viewport;
    /**
     * Contains all the added Effekseer particle effects.
     */
    private final Array<ParticleEffekseer> effekseers;

    //endregion

    //region State

    /**
     * The DrawParameter instance to use for calling the {@link EffekseerManagerCore#Draw(EffekseerManagerParameters.DrawParameter)} method.
     */
    private final EffekseerManagerParameters.DrawParameter drawParameter;

    //endregion

    //region Constructors

    public EffekseerManager(Camera camera, EffekseerCore.TypeOpenGL core, int maxSpriteCount) {
        EffekseerBackendCore.InitializeAsOpenGL();

        // Set the properties/state
        this.effekseerManagerCore = new EffekseerManagerCore();
        this.camera = camera;
        this.effekseers = new Array<>(false, 16);
        this.drawParameter = new EffekseerManagerParameters.DrawParameter();

        // Initialize the core manager
        this.effekseerManagerCore.Initialize(maxSpriteCount, core.getId(),true);
    }

    //endregion

    //region Protected Methods

    protected void addParticleEffekseer(ParticleEffekseer effekseer) {
        this.effekseers.add(effekseer);
    }

    protected void removeParticleEffekseer(ParticleEffekseer effekseer) {
        this.effekseers.removeValue(effekseer, true);
    }

    protected boolean shouldCameraBeUpdatedInDraw() {
        return false;
    }

    /**
     * Called at the start of the draw call.
     */
    protected void onPreDraw() {
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);
    }

    /**
     * Called at the end of the draw call.
     */
    protected void onPostDraw() {
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);
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

    /**
     *
     * @return The {@link EffekseerManagerParameters.DrawParameter} being used for every draw call. Update the state of this
     * instance for affecting how the particles are drawn (culling and render sorting).
     */
    public EffekseerManagerParameters.DrawParameter getDrawParameter() {
        return drawParameter;
    }

    //endregion

    public boolean isPlaying(ParticleEffekseer effekseer) {
        return this.effekseerManagerCore.isPlaying(effekseer.getHandle());
    }

    /**
     * Draws all added particle effects. Call {@link #getDrawParameter()} before this call, and update its state to further affect
     * how the particles are drawn.
     * @param delta The time in seconds since the last frame.
     */
    public void draw(float delta) {
        this.onPreDraw();

        // If the LibGDX camera state should be updated here
        if (this.shouldCameraBeUpdatedInDraw()) {
            this.camera.update();
        }

        // Update and draw each particle effect
        for (ParticleEffekseer effekseer : this.effekseers) {
            effekseer.update(delta);

            // Check if the current effect has just finished playing. If so, call its animation completed callback if available.
            if (effekseer.isPlay()) {
                if (!this.isPlaying(effekseer)) {
                    effekseer.setPlay(false);
                    if (effekseer.getOnAnimationComplete() != null) {
                        effekseer.getOnAnimationComplete().finish();
                    }
                }
            }

            if (this.camera instanceof PerspectiveCamera) {
                effekseer.setMatrix4();
            }
        }

        // Set the projection matrix
        if (this.camera instanceof OrthographicCamera) {
            if (this.viewport != null) {
                this.effekseerManagerCore.SetProjectionMatrix((camera).projection.val, (camera).view.val, false, viewport.getWorldWidth(), viewport.getWorldHeight());
            }
            else {
                this.effekseerManagerCore.SetProjectionMatrix((camera).projection.val, (camera).view.val, false, camera.viewportWidth, camera.viewportHeight);

            }
        }
        else if (this.camera instanceof PerspectiveCamera) {
            this.effekseerManagerCore.SetProjectionMatrix((camera).projection.val, (camera).view.val, true, 0, 0);
        }

        // Update the manager core
        this.effekseerManagerCore.Update(delta * SINGLE_FRAME_TIME_SECONDS_INV);
        // Draw
        this.effekseerManagerCore.BeginRendering();
        this.effekseerManagerCore.Draw(this.drawParameter);
        this.effekseerManagerCore.EndRendering();

        this.onPostDraw();
    }

    //endregion

    //region Disposable

    @Override
    public void dispose() {
        // Delete the manager color
        this.effekseerManagerCore.delete();
        // Delete all added effect instances. Use while loop to avoid nested iterator usages of LibGDX Array.
        while (!this.effekseers.isEmpty()) {
            this.effekseers.first().delete();
        }
        // Terminate the backend
        EffekseerBackendCore.Terminate();
    }

    //endregion
}
