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
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.Pool;
import io.github.srjohnathan.gdx.effekseer.core.*;

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
        Parameters parameters = obtainParametersInstance();
        parameters.set(effectFileHandle, effekseerManagerCore, effekseerEffectCore, magnification);
        return new AssetDescriptor<Result>(new FileHandle(prefixForMainFilePath + effectFileHandle.path()), Result.class, parameters);
    }

    /**
     * @return A {@link AssetDescriptor} for loading the given effect related file handle.
     */
    private static AssetDescriptor<EffekseerParticleSubAssetLoader.Result> getAssetDescriptorForSubAssetFileHandle(FileHandle fileHandle, EffekseerParticleSubAssetLoader.Parameters parameters) {
        return new AssetDescriptor<>(fileHandle, EffekseerParticleSubAssetLoader.Result.class, parameters);
    }

    //endregion

    //region Cache

    private static ObjectMap<String, EffekseerParticleSubAssetLoader.Result> loaderCachedAssets = new ObjectMap<String, EffekseerParticleSubAssetLoader.Result>(24);

    private static void cacheAssetInLoaderUntilInAssetManager(String itemPath, EffekseerParticleSubAssetLoader.Result asset) {
        synchronized (loaderCachedAssets) {
            loaderCachedAssets.put(itemPath, asset);
        }
    }

    private static EffekseerParticleSubAssetLoader.Result getCachedAssetInLoaderOrAssetManager(AssetManager assetManager, String itemPath) {
        synchronized (loaderCachedAssets) {
            EffekseerParticleSubAssetLoader.Result loaderCachedResult = loaderCachedAssets.get(itemPath);
            if (loaderCachedResult == null) {
                // Get from asset manager
                if (assetManager.contains(itemPath, EffekseerParticleSubAssetLoader.Result.class)) {
                    return assetManager.get(itemPath, EffekseerParticleSubAssetLoader.Result.class);
                }
                else {
                    return null;
                }
            }
            else {
                return loaderCachedResult;
            }
        }
    }

    private static void removeCacheAssetInLoader(String itemPath) {
        synchronized (loaderCachedAssets) {
            loaderCachedAssets.remove(itemPath);
        }
    }

    //endregion

    //endregion

    //region Classes

    /**
     * Parameters needed to load EffekseerParticleLoader.
     */
    public static class Parameters extends AssetLoaderParameters<Result> {
        public FileHandle effectFileHandle;
        public EffekseerManagerCore effekseerManagerCore;
        public EffekseerEffectCore effekseerEffectCore;
        public float magnification;
        private Result result = null;

        Parameters() { }

        void set(FileHandle effectFileHandle, EffekseerManagerCore effekseerManagerCore, EffekseerEffectCore effekseerEffectCore, float magnification) {
            this.effectFileHandle = effectFileHandle;
            this.effekseerEffectCore = effekseerEffectCore;
            this.effekseerManagerCore = effekseerManagerCore;
            this.magnification = magnification;
            this.result = null;
        }

        public void resetWithoutRecycling() {
            this.set(null, null, null, 0f);
            this.loadedCallback = null;
        }

        public void recycle() {
            synchronized (parametersPool) {
                parametersPool.free(this);
            }
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

        //region Private Methods

        private void loadSubAssetsIntoEffekseer(EffekseerEffectCore effekseerEffectCore, EffekseerIsMipMapEnabledDecider effekseerIsMipMapEnabledDecider) {
            // Load textures that haven't already been loaded into Effekseer
            for (LoadedTextureResult textureAsset : this.textures) {
                if (textureAsset.assetData.referenceWrapper == null) {
                    // First get if mipmaps should be used for the current texture asset
                    boolean shouldUseMipMaps;
                    if (effekseerIsMipMapEnabledDecider == null) {
                        shouldUseMipMaps = true;
                    }
                    else {
                        shouldUseMipMaps = effekseerIsMipMapEnabledDecider.isMipMapEnabledForTextureFile(textureAsset.assetData.fileHandle);
                    }

                    // Load into effekseer
                    textureAsset.assetData.referenceWrapper = effekseerEffectCore.LoadTexture(textureAsset.assetData.data, textureAsset.assetData.data.length, textureAsset.textureIndex, textureAsset.textureType, shouldUseMipMaps);
                    if (textureAsset.assetData.referenceWrapper == null || !((TextureRefWrapper)textureAsset.assetData.referenceWrapper).getHasRef()) {
                        System.out.printf("Failed to load Effekseer particle texture file %s.\n", textureAsset.assetData.fileHandle.toString());
                    }
                }
            }

            // Load models that haven't already been loaded into Effekseer
            int currentIndex = 0;
            for (EffekseerParticleSubAssetLoader.Result modelAsset : this.models) {
                if (modelAsset.referenceWrapper == null) {
                    modelAsset.referenceWrapper = effekseerEffectCore.LoadModel(modelAsset.data, modelAsset.data.length, currentIndex);
                    if (modelAsset.referenceWrapper == null || !((ModelRefWrapper)modelAsset.referenceWrapper).getHasRef()) {
                        System.out.printf("Failed to load Effekseer particle model file %s.\n", modelAsset.fileHandle.toString());
                    }
                }
                currentIndex += 1;
            }

            // Load materials that haven't already been loaded into Effekseer
            currentIndex = 0;
            for (EffekseerParticleSubAssetLoader.Result materialAsset : this.materials) {
                if (materialAsset.referenceWrapper == null) {
                    materialAsset.referenceWrapper = effekseerEffectCore.LoadMaterial(materialAsset.data, materialAsset.data.length, currentIndex);
                    if (materialAsset.referenceWrapper == null || !((MaterialRefWrapper)materialAsset.referenceWrapper).getHasRef()) {
                        System.out.printf("Failed to load Effekseer particle material file %s.\n", materialAsset.fileHandle.toString());
                    }
                }
                currentIndex += 1;
            }
        }

        private void setSubAssetsInEffect(EffekseerEffectCore effekseerEffectCore) {
            // Textures set
            for (LoadedTextureResult textureAsset : this.textures) {
                effekseerEffectCore.SetTexture(textureAsset.textureIndex, textureAsset.textureType, (TextureRefWrapper)textureAsset.assetData.referenceWrapper);
            }

            // Models load
            int currentIndex = 0;
            for (EffekseerParticleSubAssetLoader.Result modelAsset : this.models) {
                effekseerEffectCore.SetModel(currentIndex, (ModelRefWrapper) modelAsset.referenceWrapper);
                currentIndex += 1;
            }

            // Materials load
            currentIndex = 0;
            for (EffekseerParticleSubAssetLoader.Result materialAsset : this.materials) {
                effekseerEffectCore.SetMaterial(currentIndex, (MaterialRefWrapper) materialAsset.referenceWrapper);
                currentIndex += 1;
            }

            // TODO sound
        }

        //endregion

        //region Public Methods

        /**
         * Loads the effect sub asset references in this result instance into the given {@link EffekseerManagerCore}.
         */
        public void loadIntoEffect(EffekseerManagerCore effekseerManagerCore, EffekseerEffectCore effekseerEffectCore, float magnification) {
            // Check that the manager and effect cores are available
            if (effekseerManagerCore == null) {
                throw new IllegalStateException("EffekseerManagerCore is needed to load Effekseer effects.");
            }
            if (effekseerEffectCore == null) {
                throw new IllegalStateException("EffekseerEffectCore is needed to load Effekseer effects.");
            }

            try {
                if (this.loadedWithEffekseerEffectCore != effekseerEffectCore) {
                    // Main file load
                    if (!effekseerEffectCore.load(effekseerManagerCore, this.effectFileData.data, this.effectFileData.data.length, magnification)) {
                        throw new Exception("Failed to load main Effekseer particle file " + this.effectFileData.fileHandle.toString());
                    }

                    // Sub assets load
                    this.setSubAssetsInEffect(effekseerEffectCore);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        //endregion
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
        loadedData.loadIntoEffect(effekseerManagerCore, effekseerEffectCore, magnification);

        // Recycle the obtained parameters object
        ((Parameters)mainAssetDescriptor.params).recycle();
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

    //region State

    /**
     * Used for loading the sub assets of an effect without calling the AssetManager. This is needed because the sub assets
     * are not known until the main body data is loaded into the effect object, and thus we can't add the sub assets to
     * the dependencies list. When the main body data is loaded, all the sub assets are retrieved and loaded using this loader.
     */
    private final EffekseerParticleSubAssetLoader subAssetLoader = new EffekseerParticleSubAssetLoader(null);

    /**
     * Use this to determine if a texture should use mipmaps.
     */
    private final EffekseerIsMipMapEnabledDecider effekseerIsMipMapEnabledDecider;

    //endregion

    //region Constructors

    /**
     * @param effekseerIsMipMapEnabledDecider Pass in to override if a texture should use mipmaps. If this is null, then mipmaps will always be true.
     */
    public EffekseerParticleAssetLoader(FileHandleResolver fileHandleResolver, EffekseerIsMipMapEnabledDecider effekseerIsMipMapEnabledDecider) {
        super(fileHandleResolver);
        this.effekseerIsMipMapEnabledDecider = effekseerIsMipMapEnabledDecider;
    }

    public EffekseerParticleAssetLoader(FileHandleResolver fileHandleResolver) {
        this(fileHandleResolver, null);
    }

    //endregion

    //region Private Methods

    private void cacheSubAssetInAssetManager(EffekseerParticleSubAssetLoader.Result asset, AssetManager manager) {
        if (manager instanceof DirectAssetAdder) {
            ((DirectAssetAdder)manager).addAssetDirectly(asset.fileHandle.path(), EffekseerParticleSubAssetLoader.Result.class, asset);
        }
        else {
            // Cache the asset in memory until the AssetManager puts the asset in its state
            cacheAssetInLoaderUntilInAssetManager(asset.fileHandle.path(), asset);

            // Create the instances for loading
            EffekseerParticleSubAssetLoader.Parameters parameters = EffekseerParticleSubAssetLoader.obtainParametersInstance();
            parameters.loadedResult = asset;
            parameters.loadedCallback = new AssetLoaderParameters.LoadedCallback() {
                @Override
                public void finishedLoading(AssetManager assetManager, String fileName, Class type) {
                    removeCacheAssetInLoader(fileName);
                    parameters.recycle();
                }
            };
            // Start load
            manager.load(getAssetDescriptorForSubAssetFileHandle(asset.fileHandle, parameters));
        }
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
        assets.add(getAssetDescriptorForSubAssetFileHandle(parameter.effectFileHandle, EffekseerParticleSubAssetLoader.obtainParametersInstance()));

        return assets;
    }

    @Override
    public void loadAsync(AssetManager manager, String fileName, FileHandle file, Parameters parameter) {
        FileHandle effectFileHandle = parameter.effectFileHandle;
        EffekseerEffectCore effekseerEffectCore = parameter.effekseerEffectCore;

        // Create the result object that will be returned at the end
        Result result = new Result(effekseerEffectCore);
        parameter.result = result;

        // Load main file data into the effect instance
        EffekseerParticleSubAssetLoader.Result mainFileAsset = manager.get(getAssetDescriptorForSubAssetFileHandle(effectFileHandle, null));
        result.effectFileData = mainFileAsset;
        parameter.effekseerEffectCore.load(parameter.effekseerManagerCore, mainFileAsset.data, mainFileAsset.data.length, parameter.magnification);

        // Load and add the textures
        int texturesCount = 0;
        for (EffekseerTextureType textureType : textureTypes) {
            texturesCount += effekseerEffectCore.GetTextureCount(textureType);
        }
        result.textures = new Array<>(false, texturesCount);
        for (EffekseerTextureType textureType : textureTypes) {
            int currentTextureCount = effekseerEffectCore.GetTextureCount(textureType);
            for (int i = 0; i < currentTextureCount; i++) {
                String path = getTexturePath(effectFileHandle, i, textureType, effekseerEffectCore);
                FileHandle textureFileHandle = getPathAsFileHandle(path, effectFileHandle.type());
                EffekseerParticleSubAssetLoader.Result cachedLoadedAsset = getCachedAssetInLoaderOrAssetManager(manager, textureFileHandle.path());
                if (cachedLoadedAsset != null) {
                    result.textures.add(new LoadedTextureResult(textureType, i, cachedLoadedAsset));
                }
                else {
                    // Load asset
                    EffekseerParticleSubAssetLoader.Parameters subAssetParam = EffekseerParticleSubAssetLoader.obtainParametersInstance();
                    this.subAssetLoader.loadAsync(manager, "", textureFileHandle, subAssetParam);
                    EffekseerParticleSubAssetLoader.Result loadedAsset = this.subAssetLoader.loadSync(manager, "", textureFileHandle, subAssetParam);
                    // Cache asset
                    this.cacheSubAssetInAssetManager(loadedAsset, manager);
                    result.textures.add(new LoadedTextureResult(textureType, i, loadedAsset));
                }
            }
        }

        // Add the models
        int modelCount = effekseerEffectCore.GetModelCount();
        result.models = new Array<>(false, modelCount);
        for (int i = 0; i < modelCount; i++) {
            String path = getModelPath(effectFileHandle, i, effekseerEffectCore);
            FileHandle modelFileHandle = getPathAsFileHandle(path, effectFileHandle.type());
            EffekseerParticleSubAssetLoader.Result cachedLoadedAsset = getCachedAssetInLoaderOrAssetManager(manager, modelFileHandle.path());
            if (cachedLoadedAsset != null) {
                result.models.add(cachedLoadedAsset);
            }
            else {
                // Load asset
                EffekseerParticleSubAssetLoader.Parameters subAssetParam = EffekseerParticleSubAssetLoader.obtainParametersInstance();
                this.subAssetLoader.loadAsync(manager, "", modelFileHandle, subAssetParam);
                EffekseerParticleSubAssetLoader.Result loadedAsset = this.subAssetLoader.loadSync(manager, "", modelFileHandle, subAssetParam);
                // Cache asset
                this.cacheSubAssetInAssetManager(loadedAsset, manager);
                result.models.add(loadedAsset);
            }
        }

        // Add the materials
        int materialCount = effekseerEffectCore.GetMaterialCount();
        result.materials = new Array<>(false, materialCount);
        for (int i = 0; i < materialCount; i++) {
            String path = getMaterialPath(effectFileHandle, i, effekseerEffectCore);
            FileHandle materialFileHandle = getPathAsFileHandle(path, effectFileHandle.type());
            EffekseerParticleSubAssetLoader.Result cachedLoadedAsset = getCachedAssetInLoaderOrAssetManager(manager, materialFileHandle.path());
            if (cachedLoadedAsset != null) {
                result.materials.add(cachedLoadedAsset);
            }
            else {
                // Load asset
                EffekseerParticleSubAssetLoader.Parameters subAssetParam = EffekseerParticleSubAssetLoader.obtainParametersInstance();
                this.subAssetLoader.loadAsync(manager, "", materialFileHandle, subAssetParam);
                EffekseerParticleSubAssetLoader.Result loadedAsset = this.subAssetLoader.loadSync(manager, "", materialFileHandle, subAssetParam);
                // Cache asset
                this.cacheSubAssetInAssetManager(loadedAsset, manager);
                result.materials.add(loadedAsset);
            }
        }

        // TODO sound

    }

    @Override
    public Result loadSync(AssetManager manager, String fileName, FileHandle file, Parameters parameter) {
        Result result = parameter.result;

        // Load the sub assets needed in this effect into Effekseer
        result.loadSubAssetsIntoEffekseer(parameter.effekseerEffectCore, this.effekseerIsMipMapEnabledDecider);
        // Set the sub asset references needed in this effect
        result.setSubAssetsInEffect(parameter.effekseerEffectCore);

        return parameter.result;
    }

    //endregion
}


