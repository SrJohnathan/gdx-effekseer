package io.github.srjohnathan.gdx.effekseer.loader;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import io.github.srjohnathan.gdx.effekseer.core.EffekseerEffectCore;

/**
 * Loads the assets needed for particle effects and loads them into a given {@link EffekseerEffectCore}.
 */
public class EffekseerParticleSubAssetLoader extends AsynchronousAssetLoader<EffekseerParticleSubAssetLoader.Result, EffekseerParticleSubAssetLoader.Parameters> {

    //region Static

    /**
     * Parameters needed to load EffekseerParticleLoader.
     */
    static class Parameters extends AssetLoaderParameters<Result> {
        /**
         * If this is not null, then it will be passed as the final result without doing any file loading. This is used for
         * caching an existing result into an {@link AssetManager} that doesn't have it.
         */
        public Result alreadyLoadedResult = null;
    }

    /**
     * Contains the data for any file loaded that is used in an Effekseer effect.
     */
    public static class Result {
        public final FileHandle fileHandle;
        public final byte[] data;

        private Result(FileHandle fileHandle, byte[] data) {
            this.fileHandle = fileHandle;
            this.data = data;
        }
    }

    //endregion

    //region State

    private byte[] loadedData = null;

    //endregion

    //region Constructors

    public EffekseerParticleSubAssetLoader(FileHandleResolver resolver) {
        super(resolver);
    }

    //endregion

    //region Overrides

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, Parameters parameter) {
        return null;
    }

    @Override
    public void loadAsync(AssetManager manager, String fileName, FileHandle file, Parameters parameter) {
        if (parameter == null || parameter.alreadyLoadedResult == null) {
            this.loadedData = file.readBytes();
        }
    }

    @Override
    public Result loadSync(AssetManager manager, String fileName, FileHandle file, Parameters parameter) {
        if (parameter == null || parameter.alreadyLoadedResult == null) {
            Result result = new Result(file, this.loadedData);
            this.loadedData = null;
            return result;
        }
        else {
            return parameter.alreadyLoadedResult;
        }
    }

    //endregion

}
