package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.*;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;
import io.github.srjohnathan.gdx.effekseer.wrapped.ParticleEffekseer;
import io.github.srjohnathan.gdx.effekseer.wrapped.StandardColorParameter;

import java.util.function.Function;

/**
 * An Effekseer Sprite node that contains the specific Sprite properties.
 */
public class EffekseerNodeSprite extends EffekseerNode<EffectNodeSprite> {

    //region Field Wrappers

    private EffekseerFieldWrapper<StandardColorParameter> spriteAllColor = new EffekseerFieldWrapper<StandardColorParameter>(new Function<Void, StandardColorParameter>() {
        @Override
        public StandardColorParameter apply(Void unused) {
            return new StandardColorParameter(coreNode.getSpriteAllColor());
        }
    }, new Function<StandardColorParameter, Void>() {
        @Override
        public Void apply(StandardColorParameter value) {
            coreNode.setSpriteAllColor(value.getCore());
            return null;
        }
    });

    private EffekseerFieldWrapper<SpriteColorParameter> spriteColor = new EffekseerFieldWrapper<SpriteColorParameter>(new Function<Void, SpriteColorParameter>() {
        @Override
        public SpriteColorParameter apply(Void unused) {
            return new SpriteColorParameter(coreNode.getSpriteColor());
        }
    }, new Function<SpriteColorParameter, Void>() {
        @Override
        public Void apply(SpriteColorParameter value) {
            coreNode.setSpriteColor(value.getCore());
            return null;
        }
    });

    private EffekseerFieldWrapper<SpritePositionParameter> spritePosition = new EffekseerFieldWrapper<SpritePositionParameter>(new Function<Void, SpritePositionParameter>() {
        @Override
        public SpritePositionParameter apply(Void unused) {
            return new SpritePositionParameter(coreNode.getSpritePosition());
        }
    }, new Function<SpritePositionParameter, Void>() {
        @Override
        public Void apply(SpritePositionParameter value) {
            coreNode.setSpritePosition(value.getCore());
            return null;
        }
    });

    //endregion

    //region Constructors

    public EffekseerNodeSprite(ParticleEffekseer effect, EffectNodeSprite coreNode) {
        super(effect, coreNode);
    }

    //endregion

    //region Wrapper Methods

    public void setAlphaBlend(AlphaBlendType value) {
        this.coreNode.setAlphaBlend(value);
    }

    public AlphaBlendType getAlphaBlend() {
        return this.coreNode.getAlphaBlend();
    }

    public void setBillboard(BillboardType value) {
        this.coreNode.setBillboard(value);
    }

    public BillboardType getBillboard() {
        return this.coreNode.getBillboard();
    }

    public void setSpriteAllColor(StandardColorParameter value) {
        this.spriteAllColor.set(value);
    }

    public StandardColorParameter getSpriteAllColor() {
        return this.spriteAllColor.get();
    }

    public void setSpriteColor(SpriteColorParameter value) {
        this.spriteColor.set(value);
    }

    public SpriteColorParameter getSpriteColor() {
        return this.spriteColor.get();
    }

    public void setSpritePosition(SpritePositionParameter value) {
        this.spritePosition.set(value);
    }

    public SpritePositionParameter getSpritePosition() {
        return this.spritePosition.get();
    }

    public void setSpriteTexture(int value) {
        this.coreNode.setSpriteTexture(value);
    }

    public int getSpriteTexture() {
        return this.coreNode.getSpriteTexture();
    }


    //endregion
}
