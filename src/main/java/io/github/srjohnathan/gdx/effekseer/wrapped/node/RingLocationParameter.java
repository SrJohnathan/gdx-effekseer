package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.RingLocationParameterCore;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;
import io.github.srjohnathan.gdx.effekseer.wrapped.struct.EasingVector2D;

import java.util.function.Function;

public class RingLocationParameter {

    //region State

    public final RingLocationParameterCore core;

    //region Field Wrappers

    private EffekseerFieldWrapper<EasingVector2D> easing = new EffekseerFieldWrapper<EasingVector2D>(new Function<Void, EasingVector2D>() {
        @Override
        public EasingVector2D apply(Void unused) {
            return new EasingVector2D(core.getEasing());
        }
    }, new Function<EasingVector2D, Void>() {
        @Override
        public Void apply(EasingVector2D value) {
            core.setEasing(value.core);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public RingLocationParameter(RingLocationParameterCore core) {
        this.core = core;
    }

    //endregion

    //region Wrapper Methods

    public void delete() {
        this.core.delete();
    }

    public void setType(int value) {
        this.core.setType(value);
    }

    public int getType() {
        return this.core.getType();
    }

    public void setEasing(EasingVector2D value) {
        this.easing.set(value);
    }

    public EasingVector2D getEasing() {
        return this.easing.get();
    }

    //endregion

}