package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.RingLocationValuesCore;
import io.github.srjohnathan.gdx.effekseer.core.SIMDVec2f;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;

import java.util.function.Function;

public class RingLocationValues {

    //region State

    public final RingLocationValuesCore core;

    //region Field Wrappers

    private EffekseerFieldWrapper<SIMDVec2f> current = new EffekseerFieldWrapper<SIMDVec2f>(new Function<Void, SIMDVec2f>() {
        @Override
        public SIMDVec2f apply(Void unused) {
            return core.getCurrent();
        }
    }, new Function<SIMDVec2f, Void>() {
        @Override
        public Void apply(SIMDVec2f value) {
            core.setCurrent(value);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public RingLocationValues(RingLocationValuesCore core) {
        this.core = core;
    }

    //endregion

    //region Wrapper Methods

    public void delete() {
        this.core.delete();
    }

    public void setCurrent(SIMDVec2f value) {
        this.current.set(value);
    }

    public SIMDVec2f getCurrent() {
        return this.current.get();
    }

    //endregion

}