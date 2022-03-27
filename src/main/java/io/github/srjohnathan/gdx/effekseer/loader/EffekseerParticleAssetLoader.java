package io.github.srjohnathan.gdx.effekseer.loader;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import io.github.srjohnathan.gdx.effekseer.core.EffekseerEffectCore;
import io.github.srjohnathan.gdx.effekseer.core.EffekseerManagerCore;
import io.github.srjohnathan.gdx.effekseer.core.EffekseerTextureType;
import java.util.Random;

/**
 * Loads the particle effect and its dependencies and produces a {@link Result} which can then load the assets into a given {@link EffekseerEffectCore}.
 */
public class EffekseerParticleAssetLoader extends AsynchronousAssetLoader<EffekseerParticleAssetLoader.Result, EffekseerParticleAssetLoader.Parameters> {

    //region Static

    //region Private

    /**
     * Used for prefixing the path for the main file so that {@link AssetManager} doesn't complain about existing path even though
     * we're loading a different result.
     */
    private static String prefixForMainFilePath = "";
    static  {
        Random random = new Random();
        char[] array = new char[6];
        for (int i = 0; i < array.length; i++) {
            array[i] = (char)(random.nextFloat() * 26 + 65);
        }
        prefixForMainFilePath = new String(array);
    }

    /**
     * All types of textures.
     */
    private static EffekseerTextureType[] textureTypes = new EffekseerTextureType[]{
            EffekseerTextureType.Color,
            EffekseerTextureType.Normal,
            EffekseerTextureType.Distortion,
    };

    //region File Paths

    /**
     * @return {@link FileHandle} that represents the given file path and file type for loading an effect related file.
     */
    private static FileHandle getPathAsFileHandle(String path, Files.FileType fileType) {
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

    private static String getTexturePath(FileHandle effectFileHandle, int textureIndex, EffekseerTextureType textureType, EffekseerEffectCore effekseerEffectCore) {
        String path = effectFileHandle.file().getParent();
        if (path != null) {
            path += "/" + effekseerEffectCore.GetTexturePath(textureIndex, textureType);
        }
        else {
            path = effekseerEffectCore.GetTexturePath(textureIndex, textureType);
        }
        return path;
    }

    private static String getModelPath(FileHandle effectFileHandle, int modelIndex, EffekseerEffectCore effekseerEffectCore) {
        String path = effectFileHandle.file().getParent();
        if (path != null) {
            path += "/" + effekseerEffectCore.GetModelPath(modelIndex);
        }
        else {
            path = effekseerEffectCore.GetModelPath(modelIndex);
        }
        return path;
    }

    private static String getMaterialPath(FileHandle effectFileHandle, int materialIndex, EffekseerEffectCore effekseerEffectCore) {
        String path = effectFileHandle.file().getParent();
        if (path != null) {
            path += "/" + effekseerEffectCore.GetMaterialPath(materialIndex);
        }
        else {
            path = effekseerEffectCore.GetMaterialPath(materialIndex);
        }
        return path;
    }

    //endregion

    //region Asset Descriptors

    /**
     * @return The {@link AssetDescriptor} to use for the main effect file.
     */
    public static AssetDescriptor<Result> getMainFileAssetDescriptor(FileHandle effectFileHandle, EffekseerManagerCore effekseerManagerCore, EffekseerEffectCore effekseerEffectCore, float magnification) throws IllegalStateException {
        return new AssetDescriptor<>(new FileHandle(prefixForMainFilePath + effectFileHandle.path()), Result.class, new Parameters(effectFileHandle, effekseerManagerCore, effekseerEffectCore, magnification));
    }

    /**
     * @return A {@link AssetDescriptor} for loading the given effect related file handle.
     */
    private static AssetDescriptor<EffekseerParticleSubAssetLoader.Result> getAssetDescriptorForSubAssetFileHandle(FileHandle fileHandle, EffekseerParticleSubAssetLoader.Parameters parameters) {
        return new AssetDescriptor<>(fileHandle, EffekseerParticleSubAssetLoader.Result.class, parameters);
    }

    //endregion

    //endregion

    //region Classes

    /**
     * Parameters needed to load EffekseerParticleLoader.
     */
    public static class Parameters extends AssetLoaderParameters<Result> {
        public final FileHandle effectFileHandle;
        public final EffekseerManagerCore effekseerManagerCore;
        public final EffekseerEffectCore effekseerEffectCore;
        public final float magnification;
        public Parameters(FileHandle effectFileHandle, EffekseerManagerCore effekseerManagerCore, EffekseerEffectCore effekseerEffectCore, float magnification) {
            this.effectFileHandle = effectFileHandle;
            this.effekseerEffectCore = effekseerEffectCore;
            this.effekseerManagerCore = effekseerManagerCore;
            this.magnification = magnification;
        }
    }

    private static class LoadedTextureResult {
        private final EffekseerTextureType textureType;
        private final int textureIndex;
        private final EffekseerParticleSubAssetLoader.Result assetData;

        private LoadedTextureResult(EffekseerTextureType textureType, int textureIndex, EffekseerParticleSubAssetLoader.Result data) {
            this.textureType = textureType;
            this.textureIndex = textureIndex;
            this.assetData = data;
        }
    }

    /**
     * Keeps track of the file data loaded for an effect.
     */
    public static class Result {
        public final EffekseerEffectCore loadedWithEffekseerEffectCore;

        private Result(EffekseerEffectCore loadedWithEffekseerEffectCore) {
            this.loadedWithEffekseerEffectCore = loadedWithEffekseerEffectCore;
        }

        private EffekseerParticleSubAssetLoader.Result effectFileData;
        private Array<LoadedTextureResult> textures;
        private Array<EffekseerParticleSubAssetLoader.Result> models;
        private Array<EffekseerParticleSubAssetLoader.Result> materials;

        private void loadSubAssetsIntoEffect(EffekseerManagerCore effekseerManagerCore, EffekseerEffectCore effekseerEffectCore, float magnification) {
            // Textures load
            for (LoadedTextureResult textureAsset : this.textures) {
                if (!effekseerEffectCore.LoadTexture(textureAsset.assetData.data, textureAsset.assetData.data.length, textureAsset.textureIndex, textureAsset.textureType)) {
                    System.out.printf("Failed to load Effekseer particle texture file %s.\n", textureAsset.assetData.fileHandle.toString());
                }
            }

            // Models load
            var currentIndex = 0;
            for (EffekseerParticleSubAssetLoader.Result modelAsset : this.models) {
                if (!effekseerEffectCore.LoadModel(modelAsset.data, modelAsset.data.length, currentIndex)) {
                    System.out.printf("Failed to load Effekseer particle model file %s.\n", modelAsset.fileHandle.toString());
                }
                currentIndex += 1;
            }

            // Materials load
            currentIndex = 0;
            for (EffekseerParticleSubAssetLoader.Result materialAsset : this.materials) {
                if (!effekseerEffectCore.LoadMaterial(materialAsset.data, materialAsset.data.length, currentIndex)) {
                    System.out.printf("Failed to load Effekseer particle material file %s.\n", materialAsset.fileHandle.toString());
                }
                currentIndex += 1;
            }

            // TODO sound
        }

        /**
         * Loads the effect files data in this result instance into the given {@link EffekseerManagerCore}.
         */
        public void loadInfoEffect(EffekseerManagerCore effekseerManagerCore, EffekseerEffectCore effekseerEffectCore, float magnification) {
            // Check that the manager and effect cores are available
            if (effekseerManagerCore == null) {
                throw new IllegalStateException("EffekseerManagerCore is needed to load Effekseer effects.");
            }
            if (effekseerEffectCore == null) {
                throw new IllegalStateException("EffekseerEffectCore is needed to load Effekseer effects.");
            }

            try {
                // Main file load
                if (!effekseerEffectCore.load(effekseerManagerCore, this.effectFileData.data, this.effectFileData.data.length, magnification)) {
                    System.out.printf("Failed to load main Effekseer particle file %s.", this.effectFileData.fileHandle.toString());
                }

                // Sub assets load
                this.loadSubAssetsIntoEffect(effekseerManagerCore, effekseerEffectCore, magnification);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Synchronously loads the given Effekseer effect.
     */
    public static void syncLoad(AssetManager assetManager, FileHandle effectFileHandle, EffekseerManagerCore effekseerManagerCore, EffekseerEffectCore effekseerEffectCore, float magnification) throws IllegalStateException {
        // Request load
        AssetDescriptor<Result> mainAssetDescriptor = getMainFileAssetDescriptor(effectFileHandle, effekseerManagerCore, effekseerEffectCore, magnification);
        assetManager.load(mainAssetDescriptor);

        // Wait for load to finish
        assetManager.finishLoading();

        // Now send the loaded file data to the effect if it wasn't already sent
        Result loadedData = assetManager.get(mainAssetDescriptor);
        if (loadedData.loadedWithEffekseerEffectCore != effekseerEffectCore) {
            loadedData.loadInfoEffect(effekseerManagerCore, effekseerEffectCore, magnification);
        }
    }

    //endregion

    //endregion

    //region State

    /**
     * Used for loading the sub assets of an effect without calling the AssetManager. This is needed because the sub assets
     * are not known until the main body data is loaded into the effect object, and thus we can't add the sub assets to
     * the dependencies list. When the main body data is loaded, all the sub assets are retrieved and loaded using this loader.
     */
    private final EffekseerParticleSubAssetLoader subAssetLoader = new EffekseerParticleSubAssetLoader(null);

    /**
     * Result being built in the async method and returned from the sync method.
     */
    private Result result;

    //endregion

    //region Constructors

    public EffekseerParticleAssetLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    //endregion

    //region Private Methods

    private void cacheSubAssetInAssetManager(EffekseerParticleSubAssetLoader.Result asset, AssetManager manager) {
        EffekseerParticleSubAssetLoader.Parameters parameters = new EffekseerParticleSubAssetLoader.Parameters();
        parameters.alreadyLoadedResult = asset;
        manager.load(getAssetDescriptorForSubAssetFileHandle(asset.fileHandle, parameters));
    }

    //endregion

    //region Overrides

    @Override
    public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, Parameters parameter) {
        // Check that the manager and effect cores are available
        if (parameter.effekseerManagerCore == null) {
            throw new IllegalStateException("EffekseerManagerCore is needed to load Effekseer effects.");
        }
        if (parameter.effekseerEffectCore == null) {
            throw new IllegalStateException("EffekseerEffectCore is needed to load Effekseer effects.");
        }

        // Now create the result list with the found capacity
        Array<AssetDescriptor> assets = new Array<>(false, 1);

        // Add the main file
        assets.add(getAssetDescriptorForSubAssetFileHandle(parameter.effectFileHandle, null));

        return assets;
    }

    @Override
    public void loadAsync(AssetManager manager, String fileName, FileHandle file, Parameters parameter) {
        FileHandle effectFileHandle = parameter.effectFileHandle;
        EffekseerEffectCore effekseerEffectCore = parameter.effekseerEffectCore;

        // Load main file data into the effect instance
        EffekseerParticleSubAssetLoader.Result mainFileAsset = manager.get(getAssetDescriptorForSubAssetFileHandle(effectFileHandle, null));
        parameter.effekseerEffectCore.load(parameter.effekseerManagerCore, mainFileAsset.data, mainFileAsset.data.length, parameter.magnification);

        // Create the result object that will be returned at the end
        this.result = new Result(effekseerEffectCore);

        // Load main file data into the effect instance
        if (manager.contains(effectFileHandle.path(), EffekseerParticleSubAssetLoader.Result.class)) {
            this.result.effectFileData = manager.get(effectFileHandle.path(), EffekseerParticleSubAssetLoader.Result.class);
        }
        else {
            this.subAssetLoader.loadAsync(manager, "", effectFileHandle, null);
            this.result.effectFileData = this.subAssetLoader.loadSync(manager, "", effectFileHandle, null);
        }
        parameter.effekseerEffectCore.load(parameter.effekseerManagerCore, this.result.effectFileData.data, this.result.effectFileData.data.length, parameter.magnification);

        // Load and add the textures
        int texturesCount = 0;
        for (EffekseerTextureType textureType : textureTypes) {
            texturesCount += effekseerEffectCore.GetTextureCount(textureType);
        }
        this.result.textures = new Array<>(false, texturesCount);
        for (EffekseerTextureType textureType : textureTypes) {
            int currentTextureCount = effekseerEffectCore.GetTextureCount(textureType);
            for (int i = 0; i < currentTextureCount; i++) {
                String path = getTexturePath(effectFileHandle, i, textureType, effekseerEffectCore);
                FileHandle textureFileHandle = getPathAsFileHandle(path, effectFileHandle.type());
                if (manager.contains(textureFileHandle.path(), EffekseerParticleSubAssetLoader.Result.class)) {
                    EffekseerParticleSubAssetLoader.Result loadedAsset = manager.get(textureFileHandle.path(), EffekseerParticleSubAssetLoader.Result.class);
                    this.result.textures.add(new LoadedTextureResult(textureType, i, loadedAsset));
                }
                else {
                    this.subAssetLoader.loadAsync(manager, "", textureFileHandle, null);
                    EffekseerParticleSubAssetLoader.Result loadedAsset = this.subAssetLoader.loadSync(manager, "", textureFileHandle, null);
                    this.result.textures.add(new LoadedTextureResult(textureType, i, loadedAsset));
                }
            }
        }

        // Add the models
        this.result.models = new Array<>(false, effekseerEffectCore.GetModelCount());
        for (int i = 0; i < this.result.models.size; i++) {
            String path = getModelPath(effectFileHandle, i, effekseerEffectCore);
            FileHandle modelFileHandle = getPathAsFileHandle(path, effectFileHandle.type());
            if (manager.contains(modelFileHandle.path(), EffekseerParticleSubAssetLoader.Result.class)) {
                this.result.models.add(manager.get(modelFileHandle.path(), EffekseerParticleSubAssetLoader.Result.class));
            }
            else {
                this.subAssetLoader.loadAsync(manager, "", modelFileHandle, null);
                EffekseerParticleSubAssetLoader.Result loadedAsset = this.subAssetLoader.loadSync(manager, "", modelFileHandle, null);
                this.result.models.add(loadedAsset);
            }
        }

        // Add the materials
        this.result.materials = new Array<>(false, effekseerEffectCore.GetMaterialCount());
        for (int i = 0; i < this.result.materials.size; i++) {
            String path = getMaterialPath(effectFileHandle, i, effekseerEffectCore);
            FileHandle materialFileHandle = getPathAsFileHandle(path, effectFileHandle.type());
            if (manager.contains(materialFileHandle.path(), EffekseerParticleSubAssetLoader.Result.class)) {
                this.result.materials.add(manager.get(materialFileHandle.path(), EffekseerParticleSubAssetLoader.Result.class));
            }
            else {
                this.subAssetLoader.loadAsync(manager, "", materialFileHandle, null);
                EffekseerParticleSubAssetLoader.Result loadedAsset = this.subAssetLoader.loadSync(manager, "", materialFileHandle, null);
                this.result.materials.add(loadedAsset);
            }
        }

        // TODO sound

    }

    @Override
    public Result loadSync(AssetManager manager, String fileName, FileHandle file, Parameters parameter) {
        // Send sub assets to the effect
        this.result.loadSubAssetsIntoEffect(parameter.effekseerManagerCore, parameter.effekseerEffectCore, parameter.magnification);

        // Now cache each sub asset into the given AssetManager because the dependencies list did not have it, and thus it
        // doesn't exist in the AssetManager. This is done so that multiple effects that reference the same file don't have
        // to be loaded multiple times.
        this.cacheSubAssetInAssetManager(this.result.effectFileData, manager);
        for (LoadedTextureResult asset : this.result.textures) {
            this.cacheSubAssetInAssetManager(asset.assetData, manager);
        }
        for (EffekseerParticleSubAssetLoader.Result asset : this.result.models) {
            this.cacheSubAssetInAssetManager(asset, manager);
        }
        for (EffekseerParticleSubAssetLoader.Result asset : this.result.materials) {
            this.cacheSubAssetInAssetManager(asset, manager);
        }
        // TODO sound

        return this.result;
    }

    //endregion
}


