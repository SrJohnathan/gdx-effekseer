package io.github.srjohnathan.gdx.effekseer.loader;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pool;
import io.github.srjohnathan.gdx.effekseer.core.EffekseerEffectCore;
import io.github.srjohnathan.gdx.effekseer.core.MaterialRefWrapper;
import io.github.srjohnathan.gdx.effekseer.core.ModelRefWrapper;
import io.github.srjohnathan.gdx.effekseer.core.TextureRefWrapper;

/**
 * Loads the assets needed for particle effects and loads them into a given {@link EffekseerEffectCore}.
 */
public class EffekseerParticleSubAssetLoader extends AsynchronousAssetLoader<EffekseerParticleSubAssetLoader.Result, EffekseerParticleSubAssetLoader.Parameters> {

    //region Static

    //region Classes

    /**
     * Parameters needed to load EffekseerParticleLoader.
     * Call {@link #recycle} when this instance is no longer needed.
     */
    static class Parameters extends AssetLoaderParameters<Result> {
        /**
         * This is used for caching an existing result into an {@link AssetManager} that doesn't have it or tracking the data of a loaded sub asset.
         */
        public Result loadedResult = null;

        public void resetWithoutRecycling() {
            this.loadedResult = null;
            this.loadedCallback = null;
        }

        public void recycle() {
            synchronized (parametersPool) {
                parametersPool.free(this);
            }
        }
    }

    /**
     * Contains the data for any file loaded that is used in an Effekseer effect.
     */
    public static class Result implements Disposable {
        public final FileHandle fileHandle;
        public final byte[] data;
        /**
         * Contains the wrapped c++ reference pointer to the type of Effekseer asset loaded. For example if this result hold
         * texture data then this must be a {@link io.github.srjohnathan.gdx.effekseer.core.TextureRefWrapper}.
         * Possible values:
         * {@link io.github.srjohnathan.gdx.effekseer.core.TextureRefWrapper}
         * {@link io.github.srjohnathan.gdx.effekseer.core.ModelRefWrapper}
         * {@link io.github.srjohnathan.gdx.effekseer.core.MaterialRefWrapper}
         */
        public Object referenceWrapper = null;

        private Result(FileHandle fileHandle, byte[] data) {
            this.fileHandle = fileHandle;
            this.data = data;
        }

        //region Disposable

        @Override
        public void dispose() {
            // Remove loaded reference wrappers
            if (this.referenceWrapper instanceof TextureRefWrapper) {
                ((TextureRefWrapper) this.referenceWrapper).delete();
            }
            else if (this.referenceWrapper instanceof ModelRefWrapper) {
                ((ModelRefWrapper) this.referenceWrapper).delete();
            }
            else if (this.referenceWrapper instanceof MaterialRefWrapper) {
                ((MaterialRefWrapper) this.referenceWrapper).delete();
            }
        }

        //endregion
    }

    //endregion

    //region Pool

    private static Pool<Parameters> parametersPool = new Pool<Parameters>(16, 100) {
        @Override
        protected Parameters newObject() {
            return new Parameters();
        }

        @Override
        protected void reset(Parameters object) {
            object.resetWithoutRecycling();
        }
    };

    public static Parameters obtainParametersInstance() {
        synchronized (parametersPool) {
            return parametersPool.obtain();
        }
    }

    //endregion

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
        if (parameter.loadedResult == null) {
            parameter.loadedResult = new Result(file, file.readBytes());
        }
    }

    @Override
    public Result loadSync(AssetManager manager, String fileName, FileHandle file, Parameters parameter) {
        Result result = parameter.loadedResult;

        // Recycle instances now if there is no loaded callback
        if (parameter.loadedCallback == null) {
            parameter.recycle();
        }

        return result;
    }

    //endregion

}
