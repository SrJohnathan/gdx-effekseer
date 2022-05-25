package io.github.srjohnathan.gdx.effekseer.loader;

/**
 * Used to add a given asset directly to an {@link com.badlogic.gdx.assets.AssetManager}. Subclass {@link com.badlogic.gdx.assets.AssetManager}
 * and implement this by calling the {@link com.badlogic.gdx.assets.AssetManager#addAsset(String, Class, Object)} to extend
 * its functionality for use in loading Effekseer effects.
 */
public interface DirectAssetAdder {
    <T> void addAssetDirectly(final String fileName, Class<T> type, T asset);
}
