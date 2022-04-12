package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.InstanceEasingFloat;
import io.github.srjohnathan.gdx.effekseer.core.RingSingleValuesCore;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;

import java.util.function.Function;

public class RingSingleValues {

    //region State

    public final RingSingleValuesCore core;

    //region Field Wrappers

    private EffekseerFieldWrapper<InstanceEasingFloat> easing = new EffekseerFieldWrapper<InstanceEasingFloat>(new Function<Void, InstanceEasingFloat>() {
        @Override
        public InstanceEasingFloat apply(Void unused) {
            return core.getEasing();
        }
    }, new Function<InstanceEasingFloat, Void>() {
        @Override
        public Void apply(InstanceEasingFloat value) {
            core.setEasing(value);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public RingSingleValues(RingSingleValuesCore core) {
        this.core = core;
    }

    //endregion

    //region Wrapper Methods

    public void delete() {
        this.core.delete();
    }

    public void setCurrent(float value) {
        this.core.setCurrent(value);
    }

    public float getCurrent() {
        return this.core.getCurrent();
    }

    public void setEasing(InstanceEasingFloat value) {
        this.easing.set(value);
    }

    public InstanceEasingFloat getEasing() {
        return this.easing.get();
    }

    //endregion

}
