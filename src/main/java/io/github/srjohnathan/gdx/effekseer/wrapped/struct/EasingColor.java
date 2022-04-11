package io.github.srjohnathan.gdx.effekseer.wrapped.struct;

import io.github.srjohnathan.gdx.effekseer.core.InternalStructEasingColor;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;

import java.util.function.Function;

public class EasingColor {

    //region State

    final InternalStructEasingColor core;

    //region Field Wrappers

    private EffekseerFieldWrapper<RandomColor> start = new EffekseerFieldWrapper<RandomColor>(new Function<Void, RandomColor>() {
        @Override
        public RandomColor apply(Void unused) {
            return new RandomColor(core.getStart());
        }
    }, new Function<RandomColor, Void>() {
        @Override
        public Void apply(RandomColor value) {
            core.setStart(value.core);
            return null;
        }
    });

    private EffekseerFieldWrapper<RandomColor> end = new EffekseerFieldWrapper<RandomColor>(new Function<Void, RandomColor>() {
        @Override
        public RandomColor apply(Void unused) {
            return new RandomColor(core.getEnd());
        }
    }, new Function<RandomColor, Void>() {
        @Override
        public Void apply(RandomColor value) {
            core.setEnd(value.core);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public EasingColor(InternalStructEasingColor core) {
        this.core = core;
    }

    //endregion

    //region Wrapper Methods

    public void delete() {
        this.core.delete();
    }

    public void setStart(RandomColor value) {
        this.start.set(value);
    }

    public RandomColor getStart() {
        return this.start.get();
    }

    public void setEnd(RandomColor value) {
        this.end.set(value);
    }

    public RandomColor getEnd() {
        return this.end.get();
    }

    public void setEasingA(float value) {
        this.core.setEasingA(value);
    }

    public float getEasingA() {
        return this.core.getEasingA();
    }

    public void setEasingB(float value) {
        this.core.setEasingB(value);
    }

    public float getEasingB() {
        return this.core.getEasingB();
    }

    public void setEasingC(float value) {
        this.core.setEasingC(value);
    }

    public float getEasingC() {
        return this.core.getEasingC();
    }

    //endregion
}
