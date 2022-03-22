package io.github.srjohnathan.gdx.effekseer.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;


import java.io.File;
import java.util.Objects;


public class ParticleEffekseer {

    public final Matrix4 transform = new Matrix4();

    private final EffekseerEffectCore effekseerEffectCore;
    private int nodeSize = 0;
    // private ArrayList<EffekseerNode> nodes;

    private final float[] mtx = new float[12];
    private EffekseerManager manager;
    private OnAnimationComplete onAnimationComplete;
    private int handle;
    private boolean play;
    private float magnification = 1.0f;
    private float scale = 1f;


    private boolean getmatrix = false;





    public ParticleEffekseer(  EffekseerManager manager) {



        this.manager = Objects.requireNonNull(manager);
        this.manager.addParticleEffekseer(this);
        effekseerEffectCore = new EffekseerEffectCore();
        // nodes = new ArrayList<>();

    }


    public void setMagnification(float magnification) {
        this.magnification = magnification;
    }

    public boolean isPlay() {
        return play;
    }

    protected void setPlay(boolean play) {
        this.play = play;

     /*  if (nodes.size() > 0) {
            nodes.forEach(effekseerNode -> {
                effekseerNode.setPlay(play);
            });
        }     */
    }

    protected void delete() {
        manager.removeParticleEffekseer(this);
        effekseerEffectCore.delete();
    }


   /* public ArrayList<EffekseerNode> getNodes() {
        return nodes;
    }  */

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
        manager.effekseerManagerCore.SetEffectScale(handle, scale, scale, scale);

    }

    protected void setMatrix4() {


        if (getmatrix) {
            transform.extract4x3Matrix(mtx);
            manager.effekseerManagerCore.SetMatrix(handle, mtx);
        }
    }

    private void getmatrix() {


        float[] dst = manager.effekseerManagerCore.GetMatrix(handle);


        transform.val[Matrix4.M00] = dst[0];
        transform.val[Matrix4.M10] = dst[1];
        transform.val[Matrix4.M20] = dst[2];
        transform.val[Matrix4.M01] = dst[3];
        transform.val[Matrix4.M11] = dst[4];
        transform.val[Matrix4.M21] = dst[5];
        transform.val[Matrix4.M02] = dst[6];
        transform.val[Matrix4.M12] = dst[7];
        transform.val[Matrix4.M22] = dst[8];
        transform.val[Matrix4.M03] = dst[9];
        transform.val[Matrix4.M13] = dst[10];
        transform.val[Matrix4.M23] = dst[11];

        getmatrix = true;


    }

    public int getHandle() {
        return handle;
    }

    public void play() {
        play = true;
        handle = manager.effekseerManagerCore.Play(effekseerEffectCore);


        getmatrix();




      /*  if (nodes.size() > 0) {
            nodes.forEach(effekseerNode -> {
                effekseerNode.setPlay(play);
            });
        }
            */


    }

    public int getNodeSize() {
        return effekseerEffectCore.NodeCount();
    }

    /**
     * @param axis  The vector axis to rotate around.
     * @param angle
     */
    public void rotate(Vector3 axis, float angle) {
        transform.rotate(axis, angle);

    }

    public void translate(float x, float y, float z) {
        transform.translate(x, y, z);
    }

  /*  public EffekseerNode getNode() {
        return effekseerEffectCore.getNode();
    }
*/
    public void load(String path, boolean internalStorage) throws Exception {


        FileHandle handle = null;
        if (internalStorage) {
            handle = Gdx.files.internal(path);
        } else {
            handle = Gdx.files.external(path);
        }

        byte[] byt = handle.readBytes();


        if (manager.effekseerManagerCore == null) {
            throw new Exception("add particle on manager");
        }


        try {


            if (!effekseerEffectCore.load(manager.effekseerManagerCore, byt, byt.length, magnification)) {
                System.out.print("Failed to load.");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        // load textures
        EffekseerTextureType[] textureTypes = new EffekseerTextureType[]{
                EffekseerTextureType.Color,
                EffekseerTextureType.Normal,
                EffekseerTextureType.Distortion,
        };

        for (int t = 0; t < 3; t++) {
            for (int i = 0; i < effekseerEffectCore.GetTextureCount(textureTypes[t]); i++) {

                String pathh = null;
                pathh = (new File(path)).getParent();


                if (pathh != null) {
                    pathh += "/" + effekseerEffectCore.GetTexturePath(i, textureTypes[t]);
                } else {
                    pathh = effekseerEffectCore.GetTexturePath(i, textureTypes[t]);
                }

                FileHandle handle1 = null;
                if (internalStorage) {
                    handle1 = Gdx.files.internal(pathh);
                } else {
                    handle1 = Gdx.files.external(pathh);
                }


                byte[] bytes = handle1.readBytes();
                effekseerEffectCore.LoadTexture(bytes, bytes.length, i, textureTypes[t]);
            }
        }

        for (int i = 0; i < effekseerEffectCore.GetModelCount(); i++) {
            String pathh = (new File(path)).getParent();

            if (pathh != null) {
                pathh += "/" + effekseerEffectCore.GetModelPath(i);
            } else {
                pathh = effekseerEffectCore.GetModelPath(i);
            }


            FileHandle handle1 = null;
            if (internalStorage) {
                handle1 = Gdx.files.internal(pathh);
            } else {
                handle1 = Gdx.files.external(pathh);
            }


            byte[] bytes = handle1.readBytes();

            effekseerEffectCore.LoadModel(bytes, bytes.length, i);

        }

        for (int i = 0; i < effekseerEffectCore.GetMaterialCount(); i++) {
            String pathh = (new File(path)).getParent();
            if (pathh != null) {
                pathh += "/" + effekseerEffectCore.GetMaterialPath(i);
            } else {
                pathh = effekseerEffectCore.GetMaterialPath(i);
            }


            FileHandle handle1 = null;
            if (internalStorage) {
                handle1 = Gdx.files.internal(pathh);
            } else {
                handle1 = Gdx.files.external(pathh);
            }


            byte[] bytes = handle1.readBytes();
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


    protected void update(float delta) {



     /*   if (nodes.size() > 0) {
            nodes.forEach(effekseerNode -> {
                effekseerNode.update(delta);
            });
        }    */
    }


    public void setPosition2D(Vector2 position) {

      /*  vector2.set(position);
        transform.getTranslation(vector2);
        transform.translate((-(manager.camera.viewportWidth / 2) + vector2.x), (-(manager.camera.viewportHeight / 2) + vector2.y), 0.0f);

*/
        manager.effekseerManagerCore.SetEffectPosition(handle, ((-(manager.camera.viewportWidth / 2)) + position.x), ((-(manager.camera.viewportHeight / 2)) + position.y), 0.0f);
    }

    public void pause() {
        manager.effekseerManagerCore.SetPaused(handle, true);
    }

    public void resume() {
        manager.effekseerManagerCore.SetPaused(handle, false);
    }

    protected OnAnimationComplete getOnAnimationComplete() {
        return onAnimationComplete;
    }

    public void setOnAnimationComplete(OnAnimationComplete onAnimationComplete) {
        this.onAnimationComplete = onAnimationComplete;

    }




  /*  public interface EffekseerXYZListener {
        void fixed(VectorFixed Class);

        void pva(VectorPVA Class);

        void easing(EasingVector3d Class);

        void single(VectorPVASingle Class);
    }     */
}
