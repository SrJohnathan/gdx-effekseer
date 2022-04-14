package io.github.srjohnathan.gdx.effekseer.loader;

import com.badlogic.gdx.files.FileHandle;

/**
 * Used to determine if a texture at the given texture path should utilize mipmaps.
 */
public interface EffekseerIsMipMapEnabledDecider {

    /**
     * @return True, if the texture at the given {@link FileHandle} should utilize mipmaps, otherwise false.
     */
    boolean isMipMapEnabledForTextureFile(FileHandle textureFileHandle);

}
