package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.*;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerParticle;
import io.github.srjohnathan.gdx.effekseer.wrapped.StandardColorParameter;

import java.util.function.Function;

/**
 * An Effekseer Model node that contains the specific Model properties.
 */
public class EffekseerNodeModel extends EffekseerNode<EffectNodeModel> {

    //region Field Wrappers

    private EffekseerFieldWrapper<StandardColorParameter> allColor = new EffekseerFieldWrapper<StandardColorParameter>(new Function<Void, StandardColorParameter>() {
        @Override
        public StandardColorParameter apply(Void unused) {
            return new StandardColorParameter(coreNode.getAllColor());
        }
    }, new Function<StandardColorParameter, Void>() {
        @Override
        public Void apply(StandardColorParameter value) {
            coreNode.setAllColor(value.getCore());
            return null;
        }
    });

    //endregion

    //region Constructors

    public EffekseerNodeModel(EffekseerParticle effect, EffectNodeModel coreNode) {
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

    public void setModelIndex(int value) {
        this.coreNode.setModelIndex(value);
    }

    public int getModelIndex() {
        return this.coreNode.getModelIndex();
    }

    public void setNormalTextureIndex(int value) {
        this.coreNode.setNormalTextureIndex(value);
    }

    public int getNormalTextureIndex() {
        return this.coreNode.getNormalTextureIndex();
    }

    public void setBillboard(BillboardType value) {
        this.coreNode.setBillboard(value);
    }

    public BillboardType getBillboard() {
        return this.coreNode.getBillboard();
    }

    public void setLighting(boolean value) {
        this.coreNode.setLighting(value);
    }

    public boolean getLighting() {
        return this.coreNode.getLighting();
    }

    public void setCulling(CullingType value) {
        this.coreNode.setCulling(value);
    }

    public CullingType getCulling() {
        return this.coreNode.getCulling();
    }

    public void setAllColor(StandardColorParameter value) {
        this.allColor.set(value);
    }

    public StandardColorParameter getAllColor() {
        return this.allColor.get();
    }

    public void setMode(ModelReferenceType value) {
        this.coreNode.setMode(value);
    }

    public ModelReferenceType getMode() {
        return this.coreNode.getMode();
    }


    //endregion
}
