package io.github.srjohnathan.gdx.effekseer.loader;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;

/**
 * An {@link AssetManager} that implements {@link DirectAssetAdder}.
 */
public class AssetManagerWithDirectAssetAdder extends AssetManager implements DirectAssetAdder {

    //region Constructors

    public AssetManagerWithDirectAssetAdder() {
    }

    public AssetManagerWithDirectAssetAdder(FileHandleResolver resolver) {
        super(resolver);
    }

    public AssetManagerWithDirectAssetAdder(FileHandleResolver resolver, boolean defaultLoaders) {
        super(resolver, defaultLoaders);
    }

    //endregion

    //region Overrides

    @Override
    public <T> void addAssetDirectly(String fileName, Class<T> type, T asset) {
        this.addAsset(fileName, type, asset);
    }

    //endregion

}
