package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.AlphaBlendType;
import io.github.srjohnathan.gdx.effekseer.core.EffectNodeTrack;
import io.github.srjohnathan.gdx.effekseer.core.NodeRendererTextureUVTypeParameter;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;
import io.github.srjohnathan.gdx.effekseer.wrapped.ParticleEffekseer;
import io.github.srjohnathan.gdx.effekseer.wrapped.StandardColorParameter;

import java.util.function.Function;

/**
 * An Effekseer Track node that contains the specific Track properties.
 */
public class EffekseerNodeTrack extends EffekseerNode<EffectNodeTrack> {

    //region Field Wrappers

    private EffekseerFieldWrapper<StandardColorParameter> trackColorLeft = new EffekseerFieldWrapper<StandardColorParameter>(new Function<Void, StandardColorParameter>() {
        @Override
        public StandardColorParameter apply(Void unused) {
            return new StandardColorParameter(coreNode.getTrackColorLeft());
        }
    }, new Function<StandardColorParameter, Void>() {
        @Override
        public Void apply(StandardColorParameter value) {
            coreNode.setTrackColorLeft(value.getCore());
            return null;
        }
    });

    private EffekseerFieldWrapper<StandardColorParameter> trackColorCenter = new EffekseerFieldWrapper<StandardColorParameter>(new Function<Void, StandardColorParameter>() {
        @Override
        public StandardColorParameter apply(Void unused) {
            return new StandardColorParameter(coreNode.getTrackColorCenter());
        }
    }, new Function<StandardColorParameter, Void>() {
        @Override
        public Void apply(StandardColorParameter value) {
            coreNode.setTrackColorCenter(value.getCore());
            return null;
        }
    });

    private EffekseerFieldWrapper<StandardColorParameter> trackColorRight = new EffekseerFieldWrapper<StandardColorParameter>(new Function<Void, StandardColorParameter>() {
        @Override
        public StandardColorParameter apply(Void unused) {
            return new StandardColorParameter(coreNode.getTrackColorRight());
        }
    }, new Function<StandardColorParameter, Void>() {
        @Override
        public Void apply(StandardColorParameter value) {
            coreNode.setTrackColorRight(value.getCore());
            return null;
        }
    });

    private EffekseerFieldWrapper<StandardColorParameter> trackColorLeftMiddle = new EffekseerFieldWrapper<StandardColorParameter>(new Function<Void, StandardColorParameter>() {
        @Override
        public StandardColorParameter apply(Void unused) {
            return new StandardColorParameter(coreNode.getTrackColorLeftMiddle());
        }
    }, new Function<StandardColorParameter, Void>() {
        @Override
        public Void apply(StandardColorParameter value) {
            coreNode.setTrackColorLeftMiddle(value.getCore());
            return null;
        }
    });

    private EffekseerFieldWrapper<StandardColorParameter> trackColorCenterMiddle = new EffekseerFieldWrapper<StandardColorParameter>(new Function<Void, StandardColorParameter>() {
        @Override
        public StandardColorParameter apply(Void unused) {
            return new StandardColorParameter(coreNode.getTrackColorCenterMiddle());
        }
    }, new Function<StandardColorParameter, Void>() {
        @Override
        public Void apply(StandardColorParameter value) {
            coreNode.setTrackColorCenterMiddle(value.getCore());
            return null;
        }
    });

    private EffekseerFieldWrapper<StandardColorParameter> trackColorRightMiddle = new EffekseerFieldWrapper<StandardColorParameter>(new Function<Void, StandardColorParameter>() {
        @Override
        public StandardColorParameter apply(Void unused) {
            return new StandardColorParameter(coreNode.getTrackColorRightMiddle());
        }
    }, new Function<StandardColorParameter, Void>() {
        @Override
        public Void apply(StandardColorParameter value) {
            coreNode.setTrackColorRightMiddle(value.getCore());
            return null;
        }
    });

    private EffekseerFieldWrapper<NodeRendererTextureUVTypeParameter> textureUVTypeParameter = new EffekseerFieldWrapper<NodeRendererTextureUVTypeParameter>(new Function<Void, NodeRendererTextureUVTypeParameter>() {
        @Override
        public NodeRendererTextureUVTypeParameter apply(Void unused) {
            return coreNode.getTextureUVType();
        }
    }, new Function<NodeRendererTextureUVTypeParameter, Void>() {
        @Override
        public Void apply(NodeRendererTextureUVTypeParameter value) {
            coreNode.setTextureUVType(value);
            return null;
        }
    });

    //endregion

    //region Constructors

    public EffekseerNodeTrack(ParticleEffekseer effect, EffectNodeTrack coreNode) {
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

    public void setTrackColorLeft(StandardColorParameter value) {
        this.trackColorLeft.set(value);
    }

    public StandardColorParameter getTrackColorLeft() {
        return this.trackColorLeft.get();
    }

    public void setTrackColorCenter(StandardColorParameter value) {
        this.trackColorCenter.set(value);
    }

    public StandardColorParameter getTrackColorCenter() {
        return this.trackColorCenter.get();
    }

    public void setTrackColorRight(StandardColorParameter value) {
        this.trackColorRight.set(value);
    }

    public StandardColorParameter getTrackColorRight() {
        return this.trackColorRight.get();
    }

    public void setTrackColorLeftMiddle(StandardColorParameter value) {
        this.trackColorLeftMiddle.set(value);
    }

    public StandardColorParameter getTrackColorLeftMiddle() {
        return this.trackColorLeftMiddle.get();
    }

    public void setTrackColorCenterMiddle(StandardColorParameter value) {
        this.trackColorCenterMiddle.set(value);
    }

    public StandardColorParameter getTrackColorCenterMiddle() {
        return this.trackColorCenterMiddle.get();
    }

    public void setTrackColorRightMiddle(StandardColorParameter value) {
        this.trackColorRightMiddle.set(value);
    }

    public StandardColorParameter getTrackColorRightMiddle() {
        return this.trackColorRightMiddle.get();
    }

    public void setTrackTexture(int value) {
        this.coreNode.setTrackTexture(value);
    }

    public int getTrackTexture() {
        return this.coreNode.getTrackTexture();
    }

    public void setNumberOfSplineDivisions(int value) {
        this.coreNode.setSplineDivision(value);
    }

    public int getNumberOfSplineDivisions() {
        return this.coreNode.getSplineDivision();
    }

    public void setTextureUVTypeParameter(NodeRendererTextureUVTypeParameter value) {
        this.textureUVTypeParameter.set(value);
    }

    public NodeRendererTextureUVTypeParameter getTextureUVTypeParameter() {
        return this.textureUVTypeParameter.get();
    }

    //endregion
}