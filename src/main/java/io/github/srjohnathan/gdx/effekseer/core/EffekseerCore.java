

package io.github.srjohnathan.gdx.effekseer.core;

public class EffekseerCore {

    public static enum TypeOpenGL{
        OPEN_GL2(2),
        OPEN_GL3(3),
        OPEN_GLES2(4),
        OPEN_GLES3(5);

        private int id;
        TypeOpenGL(int i) {
            id = i;
        }
        public int getId() {
            return id;
        }

    }


}
