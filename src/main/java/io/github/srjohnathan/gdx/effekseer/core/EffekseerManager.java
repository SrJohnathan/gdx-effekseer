package io.github.srjohnathan.gdx.effekseer.core;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.ModelBatch;

import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

public class EffekseerManager implements Disposable {

    protected EffekseerManagerCore effekseerManagerCore;
    protected Camera camera;
    private ArrayList<ParticleEffekseer> effekseers;
    private Viewport viewport;
    private ModelBuilder mb;
    protected ModelBatch modelBatch;

    public static void init() {
        try {
            System.loadLibrary("src");
        } catch (Error | Exception exception) {
            exception.printStackTrace();
        }
    }


    public EffekseerManager(Camera camera,EffekseerCore.TypeOpenGL core) {


        this.camera = camera;
        effekseers = new ArrayList<>();
        EffekseerBackendCore.InitializeAsOpenGL();
        effekseerManagerCore = new EffekseerManagerCore();

        if (Gdx.app.getType() == Application.ApplicationType.Android) {

            effekseerManagerCore.Initialize(600, core.getId(),true);

        } else {
            effekseerManagerCore.Initialize(2000, core.getId(),true);

        }


    }

    protected void setModelBatch(ModelBatch modelBatch) {
        this.modelBatch = modelBatch;
    }

    protected ModelBuilder getMb() {
        return mb;
    }

    public boolean IsPlaing(ParticleEffekseer effekseer ){
       return effekseerManagerCore.IsPlaing(effekseer.getHandle());

    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    protected void addParticleEffekseer(ParticleEffekseer effekseers) {
        this.effekseers.add(effekseers);
    }


    public void draw(float delta) {
        camera.update();

        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);
        Gdx.gl.glCullFace(GL20.GL_FRONT);


        for (ParticleEffekseer effekseer : effekseers) {


            effekseer.update(delta);


            if (effekseer.isPlay()) {

                if (!effekseerManagerCore.IsPlaing(effekseer.getHandle())) {
                    effekseer.setPlay(false);
                    if (effekseer.getOnAnimationComplete() != null) {
                        effekseer.getOnAnimationComplete().finish();
                    }


                }
            }

            if (camera instanceof PerspectiveCamera) {
                effekseer.setMatrix4();
            }


        }


        if (camera instanceof OrthographicCamera) {

            if (viewport != null) {
                effekseerManagerCore.SetProjectionMatrix((camera).projection.val, (camera).view.val, false, viewport.getWorldWidth(), viewport.getWorldHeight());

            } else {
                effekseerManagerCore.SetProjectionMatrix((camera).projection.val, (camera).view.val, false, camera.viewportWidth, camera.viewportHeight);

            }


        }

        if (camera instanceof PerspectiveCamera) {
            effekseerManagerCore.SetProjectionMatrix((camera).projection.val, (camera).view.val, true, 0, 0);

        }


        effekseerManagerCore.Update(delta / (1.0f / 60.0f));
        effekseerManagerCore.DrawBack();
        effekseerManagerCore.DrawFront();


        Gdx.gl.glCullFace(GL20.GL_BACK);
        Gdx.gl.glDisable(GL20.GL_DEPTH_TEST);
        Gdx.gl.glDisable(GL20.GL_BLEND);


    }


    @Override
    public void dispose() {

        effekseerManagerCore.delete();
        for (ParticleEffekseer effekseer : this.effekseers) {
            effekseer.delete();
        }
        EffekseerBackendCore.Terminate();

    }
}
