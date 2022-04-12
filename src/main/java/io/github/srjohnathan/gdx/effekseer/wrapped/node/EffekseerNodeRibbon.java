package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.*;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerParticle;

import java.util.function.Function;

/**
 * An Effekseer Ribbon node that contains the specific Ribbon properties.
 */
public class EffekseerNodeRibbon extends EffekseerNode<EffectNodeRibbon> {

    //region Field Wrappers

    private EffekseerFieldWrapper<SWIGTYPE_p_Effekseer__RibbonRenderer__NodeParameter> nodeParam = new EffekseerFieldWrapper<SWIGTYPE_p_Effekseer__RibbonRenderer__NodeParameter>(new Function<Void, SWIGTYPE_p_Effekseer__RibbonRenderer__NodeParameter>() {
        @Override
        public SWIGTYPE_p_Effekseer__RibbonRenderer__NodeParameter apply(Void unused) {
            return coreNode.getM_nodeParameter();
        }
    }, new Function<SWIGTYPE_p_Effekseer__RibbonRenderer__NodeParameter, Void>() {
        @Override
        public Void apply(SWIGTYPE_p_Effekseer__RibbonRenderer__NodeParameter value) {
            coreNode.setM_nodeParameter(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<SWIGTYPE_p_Effekseer__RibbonRenderer__InstanceParameter> instanceParam = new EffekseerFieldWrapper<SWIGTYPE_p_Effekseer__RibbonRenderer__InstanceParameter>(new Function<Void, SWIGTYPE_p_Effekseer__RibbonRenderer__InstanceParameter>() {
        @Override
        public SWIGTYPE_p_Effekseer__RibbonRenderer__InstanceParameter apply(Void unused) {
            return coreNode.getM_instanceParameter();
        }
    }, new Function<SWIGTYPE_p_Effekseer__RibbonRenderer__InstanceParameter, Void>() {
        @Override
        public Void apply(SWIGTYPE_p_Effekseer__RibbonRenderer__InstanceParameter value) {
            coreNode.setM_instanceParameter(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<RibbonAllColorParameter> allColor = new EffekseerFieldWrapper<RibbonAllColorParameter>(new Function<Void, RibbonAllColorParameter>() {
        @Override
        public RibbonAllColorParameter apply(Void unused) {
            return new RibbonAllColorParameter(coreNode.getRibbonAllColor());
        }
    }, new Function<RibbonAllColorParameter, Void>() {
        @Override
        public Void apply(RibbonAllColorParameter value) {
            coreNode.setRibbonAllColor(value.core);
            return null;
        }
    });

    private EffekseerFieldWrapper<RibbonColorParameter> color = new EffekseerFieldWrapper<RibbonColorParameter>(new Function<Void, RibbonColorParameter>() {
        @Override
        public RibbonColorParameter apply(Void unused) {
            return new RibbonColorParameter(coreNode.getRibbonColor());
        }
    }, new Function<RibbonColorParameter, Void>() {
        @Override
        public Void apply(RibbonColorParameter value) {
            coreNode.setRibbonColor(value.core);
            return null;
        }
    });

    private EffekseerFieldWrapper<NodeRendererTextureUVTypeParameter> textureUVType = new EffekseerFieldWrapper<NodeRendererTextureUVTypeParameter>(new Function<Void, NodeRendererTextureUVTypeParameter>() {
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

    public EffekseerNodeRibbon(EffekseerParticle effect, EffectNodeRibbon coreNode) {
        super(effect, coreNode);
    }

    //endregion

    //region Wrapper Methods

    public void delete() {
        this.coreNode.delete();
    }

    public void setNodeParameter(SWIGTYPE_p_Effekseer__RibbonRenderer__NodeParameter value) {
        this.nodeParam.set(value);
    }

    public SWIGTYPE_p_Effekseer__RibbonRenderer__NodeParameter getNodeParameter() {
        return this.nodeParam.get();
    }

    public void setInstanceParameter(SWIGTYPE_p_Effekseer__RibbonRenderer__InstanceParameter value) {
        this.instanceParam.set(value);
    }

    public SWIGTYPE_p_Effekseer__RibbonRenderer__InstanceParameter getInstanceParameter() {
        return this.instanceParam.get();
    }

    public void setAlphaBlend(AlphaBlendType value) {
        this.coreNode.setAlphaBlend(value);
    }

    public AlphaBlendType getAlphaBlend() {
        return this.coreNode.getAlphaBlend();
    }

    public void setViewpointDependent(int value) {
        this.coreNode.setViewpointDependent(value);
    }

    public int getViewpointDependent() {
        return this.coreNode.getViewpointDependent();
    }

    public void setRibbonAllColor(RibbonAllColorParameter value) {
        this.allColor.set(value);
    }

    public RibbonAllColorParameter getRibbonAllColor() {
        return this.allColor.get();
    }

    public void setRibbonColor(RibbonColorParameter value) {
        this.color.set(value);
    }

    public RibbonColorParameter getRibbonColor() {
        return this.color.get();
    }

    public void setRibbonPosition(RibbonPositionParameterCore value) {
        this.coreNode.setRibbonPosition(value);
    }

    public RibbonPositionParameterCore getRibbonPosition() {
        return this.coreNode.getRibbonPosition();
    }

    public void setRibbonTexture(int value) {
        this.coreNode.setRibbonTexture(value);
    }

    public int getRibbonTexture() {
        return this.coreNode.getRibbonTexture();
    }

    public void setSplineDivision(int value) {
        this.coreNode.setSplineDivision(value);
    }

    public int getSplineDivision() {
        return this.coreNode.getSplineDivision();
    }

    public void setTextureUVType(NodeRendererTextureUVTypeParameter value) {
        this.textureUVType.set(value);
    }

    public NodeRendererTextureUVTypeParameter getTextureUVType() {
        return this.textureUVType.get();
    }


    //endregion
}
