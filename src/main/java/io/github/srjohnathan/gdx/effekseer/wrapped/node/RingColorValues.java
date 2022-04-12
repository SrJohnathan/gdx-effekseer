package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.Color;
import io.github.srjohnathan.gdx.effekseer.core.RingColorValuesCore;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;

import java.util.function.Function;

public class RingColorValues {

    //region State

    public final RingColorValuesCore core;

    //region Field Wrappers

    private EffekseerFieldWrapper<Color> currentColor = new EffekseerFieldWrapper<Color>(new Function<Void, Color>() {
        @Override
        public Color apply(Void unused) {
            return core.getCurrent();
        }
    }, new Function<Color, Void>() {
        @Override
        public Void apply(Color value) {
            core.setCurrent(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<Color> originalColor = new EffekseerFieldWrapper<Color>(new Function<Void, Color>() {
        @Override
        public Color apply(Void unused) {
            return core.getOriginal();
        }
    }, new Function<Color, Void>() {
        @Override
        public Void apply(Color value) {
            core.setOriginal(value);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public RingColorValues(RingColorValuesCore core) {
        this.core = core;
    }

    //endregion

    //region Wrapper Methods

    public void delete() {
        this.core.delete();
    }

    public void setCurrent(Color value) {
        this.currentColor.set(value);
    }

    public Color getCurrent() {
        return this.currentColor.get();
    }

    public void setOriginal(Color value) {
        this.originalColor.set(value);
    }

    public Color getOriginal() {
        return this.originalColor.get();
    }

    //endregion

}