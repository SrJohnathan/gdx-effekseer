package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.*;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerParticle;

import java.util.function.Function;

/**
 * An Effekseer Ring node that contains the specific Ring properties.
 */
public class EffekseerNodeRing extends EffekseerNode<EffectNodeRing> {

    //region Field Wrappers

    private EffekseerFieldWrapper<RingShapeParameter> shape = new EffekseerFieldWrapper<RingShapeParameter>(new Function<Void, RingShapeParameter>() {
        @Override
        public RingShapeParameter apply(Void unused) {
            return new RingShapeParameter(coreNode.getShape());
        }
    }, new Function<RingShapeParameter, Void>() {
        @Override
        public Void apply(RingShapeParameter value) {
            coreNode.setShape(value.core);
            return null;
        }
    });

    private EffekseerFieldWrapper<RingLocationParameter> outerLocation = new EffekseerFieldWrapper<RingLocationParameter>(new Function<Void, RingLocationParameter>() {
        @Override
        public RingLocationParameter apply(Void unused) {
            return new RingLocationParameter(coreNode.getOuterLocation());
        }
    }, new Function<RingLocationParameter, Void>() {
        @Override
        public Void apply(RingLocationParameter value) {
            coreNode.setOuterLocation(value.core);
            return null;
        }
    });

    private EffekseerFieldWrapper<RingLocationParameter> innerLocation = new EffekseerFieldWrapper<RingLocationParameter>(new Function<Void, RingLocationParameter>() {
        @Override
        public RingLocationParameter apply(Void unused) {
            return new RingLocationParameter(coreNode.getInnerLocation());
        }
    }, new Function<RingLocationParameter, Void>() {
        @Override
        public Void apply(RingLocationParameter value) {
            coreNode.setInnerLocation(value.core);
            return null;
        }
    });

    private EffekseerFieldWrapper<RingSingleParameter> centerRatio = new EffekseerFieldWrapper<RingSingleParameter>(new Function<Void, RingSingleParameter>() {
        @Override
        public RingSingleParameter apply(Void unused) {
            return new RingSingleParameter(coreNode.getCenterRatio());
        }
    }, new Function<RingSingleParameter, Void>() {
        @Override
        public Void apply(RingSingleParameter value) {
            coreNode.setCenterRatio(value.core);
            return null;
        }
    });

    private EffekseerFieldWrapper<RingColorParameter> outerColor = new EffekseerFieldWrapper<RingColorParameter>(new Function<Void, RingColorParameter>() {
        @Override
        public RingColorParameter apply(Void unused) {
            return new RingColorParameter(coreNode.getOuterColor());
        }
    }, new Function<RingColorParameter, Void>() {
        @Override
        public Void apply(RingColorParameter value) {
            coreNode.setOuterColor(value.core);
            return null;
        }
    });

    private EffekseerFieldWrapper<RingColorParameter> centerColor = new EffekseerFieldWrapper<RingColorParameter>(new Function<Void, RingColorParameter>() {
        @Override
        public RingColorParameter apply(Void unused) {
            return new RingColorParameter(coreNode.getCenterColor());
        }
    }, new Function<RingColorParameter, Void>() {
        @Override
        public Void apply(RingColorParameter value) {
            coreNode.setCenterColor(value.core);
            return null;
        }
    });

    private EffekseerFieldWrapper<RingColorParameter> innerColor = new EffekseerFieldWrapper<RingColorParameter>(new Function<Void, RingColorParameter>() {
        @Override
        public RingColorParameter apply(Void unused) {
            return new RingColorParameter(coreNode.getInnerColor());
        }
    }, new Function<RingColorParameter, Void>() {
        @Override
        public Void apply(RingColorParameter value) {
            coreNode.setInnerColor(value.core);
            return null;
        }
    });

    private EffekseerFieldWrapper<SWIGTYPE_p_Effekseer__RingRenderer__NodeParameter> nodeParam = new EffekseerFieldWrapper<SWIGTYPE_p_Effekseer__RingRenderer__NodeParameter>(new Function<Void, SWIGTYPE_p_Effekseer__RingRenderer__NodeParameter>() {
        @Override
        public SWIGTYPE_p_Effekseer__RingRenderer__NodeParameter apply(Void unused) {
            return coreNode.getNodeParameter();
        }
    }, new Function<SWIGTYPE_p_Effekseer__RingRenderer__NodeParameter, Void>() {
        @Override
        public Void apply(SWIGTYPE_p_Effekseer__RingRenderer__NodeParameter value) {
            coreNode.setNodeParameter(value);
            return null;
        }
    });

    //endregion

    //region Constructors

    public EffekseerNodeRing(EffekseerParticle effect, EffectNodeRing coreNode) {
        super(effect, coreNode);
    }

    //endregion

    //region Wrapper Methods

    public void delete() {
        this.coreNode.delete();
    }

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

    public void setVertexCount(int value) {
        this.coreNode.setVertexCount(value);
    }

    public int getVertexCount() {
        return this.coreNode.getVertexCount();
    }

    public void setShape(RingShapeParameter value) {
        this.shape.set(value);
    }

    public RingShapeParameter getShape() {
        return this.shape.get();
    }

    public void setOuterLocation(RingLocationParameter value) {
        this.outerLocation.set(value);
    }

    public RingLocationParameter getOuterLocation() {
        return this.outerLocation.get();
    }

    public void setInnerLocation(RingLocationParameter value) {
        this.innerLocation.set(value);
    }

    public RingLocationParameter getInnerLocation() {
        return this.innerLocation.get();
    }

    public void setCenterRatio(RingSingleParameter value) {
        this.centerRatio.set(value);
    }

    public RingSingleParameter getCenterRatio() {
        return this.centerRatio.get();
    }

    public void setOuterColor(RingColorParameter value) {
        this.outerColor.set(value);
    }

    public RingColorParameter getOuterColor() {
        return this.outerColor.get();
    }

    public void setCenterColor(RingColorParameter value) {
        this.centerColor.set(value);
    }

    public RingColorParameter getCenterColor() {
        return this.centerColor.get();
    }

    public void setInnerColor(RingColorParameter value) {
        this.innerColor.set(value);
    }

    public RingColorParameter getInnerColor() {
        return this.innerColor.get();
    }

    public void setRingTexture(int value) {
        this.coreNode.setRingTexture(value);
    }

    public int getRingTexture() {
        return this.coreNode.getRingTexture();
    }

    public void setNodeParameter(SWIGTYPE_p_Effekseer__RingRenderer__NodeParameter value) {
        this.nodeParam.set(value);
    }

    public SWIGTYPE_p_Effekseer__RingRenderer__NodeParameter getNodeParameter() {
        return this.nodeParam.get();
    }


    //endregion
}
