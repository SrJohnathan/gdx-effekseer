package io.github.srjohnathan.gdx.effekseer.wrapped.struct;

import io.github.srjohnathan.gdx.effekseer.core.InternalStructRandomVector2D;
import io.github.srjohnathan.gdx.effekseer.core.InternalStructVector2D;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;

import java.util.function.Function;

public class RandomVector2D {

    //region State

    public final InternalStructRandomVector2D core;

    //region Field Wrappers

    private EffekseerFieldWrapper<InternalStructVector2D> min = new EffekseerFieldWrapper<InternalStructVector2D>(new Function<Void, InternalStructVector2D>() {
        @Override
        public InternalStructVector2D apply(Void unused) {
            return core.getMin();
        }
    }, new Function<InternalStructVector2D, Void>() {
        @Override
        public Void apply(InternalStructVector2D value) {
            core.setMin(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<InternalStructVector2D> max = new EffekseerFieldWrapper<InternalStructVector2D>(new Function<Void, InternalStructVector2D>() {
        @Override
        public InternalStructVector2D apply(Void unused) {
            return core.getMax();
        }
    }, new Function<InternalStructVector2D, Void>() {
        @Override
        public Void apply(InternalStructVector2D value) {
            core.setMax(value);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public RandomVector2D(InternalStructRandomVector2D core) {
        this.core = core;
    }

    //endregion

    //region Wrapper Methods

    public void delete() {
        this.core.delete();
    }

    public void setMax(InternalStructVector2D value) {
        this.max.set(value);
    }

    public InternalStructVector2D getMax() {
        return this.max.get();
    }

    public void setMin(InternalStructVector2D value) {
        this.min.set(value);
    }

    public InternalStructVector2D getMin() {
        return this.min.get();
    }

    //endregion

}