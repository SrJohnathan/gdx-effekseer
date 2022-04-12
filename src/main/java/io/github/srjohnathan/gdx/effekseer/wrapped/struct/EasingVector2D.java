package io.github.srjohnathan.gdx.effekseer.wrapped.struct;

import io.github.srjohnathan.gdx.effekseer.core.InternalStructEasingVector2D;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;

import java.util.function.Function;

public class EasingVector2D {

    //region State

    public final InternalStructEasingVector2D core;

    //region Field Wrappers

    private EffekseerFieldWrapper<RandomVector2D> start = new EffekseerFieldWrapper<RandomVector2D>(new Function<Void, RandomVector2D>() {
        @Override
        public RandomVector2D apply(Void unused) {
            return new RandomVector2D(core.getStart());
        }
    }, new Function<RandomVector2D, Void>() {
        @Override
        public Void apply(RandomVector2D value) {
            core.setStart(value.core);
            return null;
        }
    });

    private EffekseerFieldWrapper<RandomVector2D> end = new EffekseerFieldWrapper<RandomVector2D>(new Function<Void, RandomVector2D>() {
        @Override
        public RandomVector2D apply(Void unused) {
            return new RandomVector2D(core.getEnd());
        }
    }, new Function<RandomVector2D, Void>() {
        @Override
        public Void apply(RandomVector2D value) {
            core.setEnd(value.core);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public EasingVector2D(InternalStructEasingVector2D core) {
        this.core = core;
    }

    //endregion

    //region Wrapper Methods

    public void delete() {
        this.core.delete();
    }

    public void setStart(RandomVector2D value) {
        this.start.set(value);
    }

    public RandomVector2D getStart() {
        return this.start.get();
    }

    public void setEnd(RandomVector2D value) {
        this.end.set(value);
    }

    public RandomVector2D getEnd() {
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