package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.EffectNodeRoot;
import io.github.srjohnathan.gdx.effekseer.wrapped.ParticleEffekseer;

/**
 * An Effekseer Root node that contains no special node properties.
 */
public class EffekseerNodeRoot extends EffekseerNode<EffectNodeRoot> {

    //region Constructors

    public EffekseerNodeRoot(ParticleEffekseer effect, EffectNodeRoot coreNode) {
        super(effect, coreNode);
    }

    //endregion
}