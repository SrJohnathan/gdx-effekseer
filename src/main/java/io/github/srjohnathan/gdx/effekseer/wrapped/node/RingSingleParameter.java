package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.*;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;
import io.github.srjohnathan.gdx.effekseer.wrapped.struct.ParameterEasingFloat;

import java.util.function.Function;

public class RingSingleParameter {

    //region State

    public final RingSingleParameterCore core;

    //region Field Wrappers

    private EffekseerFieldWrapper<InternalStructRandomFloat> random = new EffekseerFieldWrapper<InternalStructRandomFloat>(new Function<Void, InternalStructRandomFloat>() {
        @Override
        public InternalStructRandomFloat apply(Void unused) {
            return core.getRandom();
        }
    }, new Function<InternalStructRandomFloat, Void>() {
        @Override
        public Void apply(InternalStructRandomFloat value) {
            core.setRandom(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterEasingFloat> easing = new EffekseerFieldWrapper<ParameterEasingFloat>(new Function<Void, ParameterEasingFloat>() {
        @Override
        public ParameterEasingFloat apply(Void unused) {
            return new ParameterEasingFloat(core.getEasing());
        }
    }, new Function<ParameterEasingFloat, Void>() {
        @Override
        public Void apply(ParameterEasingFloat value) {
            core.setEasing(value);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public RingSingleParameter(RingSingleParameterCore core) {
        this.core = core;
    }

    //endregion

    //region Wrapper Methods

    public void delete() {
        this.core.delete();
    }

    public void setType(int value) {
        core.setType(value);
    }

    public int getType() {
        return core.getType();
    }

    public void setFixed(float value) {
        core.setFixed(value);
    }

    public float getFixed() {
        return core.getFixed();
    }

    public void setRandom(InternalStructRandomFloat value) {
        this.random.set(value);
    }

    public InternalStructRandomFloat getRandom() {
        return this.random.get();
    }

    public void setEasing(ParameterEasingFloat value) {
        this.easing.set(value);
    }

    public ParameterEasingFloat getEasing() {
        return this.easing.get();
    }

    //endregion

}