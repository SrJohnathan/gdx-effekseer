package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.RingShapeParameterCore;
import io.github.srjohnathan.gdx.effekseer.core.RingShapeType;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;

import java.util.function.Function;

public class RingShapeParameter {

    //region State

    public final RingShapeParameterCore core;

    //region Field Wrappers

    private EffekseerFieldWrapper<RingSingleParameter> startingAngle = new EffekseerFieldWrapper<RingSingleParameter>(new Function<Void, RingSingleParameter>() {
        @Override
        public RingSingleParameter apply(Void unused) {
            return new RingSingleParameter(core.getStartingAngle());
        }
    }, new Function<RingSingleParameter, Void>() {
        @Override
        public Void apply(RingSingleParameter value) {
            core.setStartingAngle(value.core);
            return null;
        }
    });

    private EffekseerFieldWrapper<RingSingleParameter> endingAngle = new EffekseerFieldWrapper<RingSingleParameter>(new Function<Void, RingSingleParameter>() {
        @Override
        public RingSingleParameter apply(Void unused) {
            return new RingSingleParameter(core.getEndingAngle());
        }
    }, new Function<RingSingleParameter, Void>() {
        @Override
        public Void apply(RingSingleParameter value) {
            core.setEndingAngle(value.core);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public RingShapeParameter(RingShapeParameterCore core) {
        this.core = core;
    }

    //endregion

    //region Wrapper Methods

    public void delete() {
        this.core.delete();
    }

    public void setType(RingShapeType value) {
        this.core.setType(value);
    }

    public RingShapeType getType() {
        return this.core.getType();
    }

    public void setStartingFade(float value) {
        this.core.setStartingFade(value);
    }

    public float getStartingFade() {
        return this.core.getStartingFade();
    }

    public void setEndingFade(float value) {
        this.core.setEndingFade(value);
    }

    public float getEndingFade() {
        return this.core.getEndingFade();
    }

    public void setStartingAngle(RingSingleParameter value) {
        this.startingAngle.set(value);
    }

    public RingSingleParameter getStartingAngle() {
        return this.startingAngle.get();
    }

    public void setEndingAngle(RingSingleParameter value) {
        this.endingAngle.set(value);
    }

    public RingSingleParameter getEndingAngle() {
        return this.endingAngle.get();
    }

    //endregion

}