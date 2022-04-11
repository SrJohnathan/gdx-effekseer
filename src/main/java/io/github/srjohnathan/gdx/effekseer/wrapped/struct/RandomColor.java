package io.github.srjohnathan.gdx.effekseer.wrapped.struct;

import io.github.srjohnathan.gdx.effekseer.core.Color;
import io.github.srjohnathan.gdx.effekseer.core.ColorMode;
import io.github.srjohnathan.gdx.effekseer.core.InternalStructRandomColor;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;

import java.util.function.Function;

public class RandomColor {

    //region State

    final InternalStructRandomColor core;

    //region Field Wrappers

    private EffekseerFieldWrapper<Color> min = new EffekseerFieldWrapper<Color>(new Function<Void, Color>() {
        @Override
        public Color apply(Void unused) {
            return core.getMin();
        }
    }, new Function<Color, Void>() {
        @Override
        public Void apply(Color value) {
            core.setMin(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<Color> max = new EffekseerFieldWrapper<Color>(new Function<Void, Color>() {
        @Override
        public Color apply(Void unused) {
            return core.getMax();
        }
    }, new Function<Color, Void>() {
        @Override
        public Void apply(Color value) {
            core.setMax(value);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public RandomColor(InternalStructRandomColor core) {
        this.core = core;
    }

    //endregion

    //region Wrapper Methods

    public void delete() {
        this.core.delete();
    }

    public void setMode(ColorMode value) {
        this.core.setMode(value);
    }

    public ColorMode getMode() {
        return this.core.getMode();
    }

    public void setMax(Color value) {
        this.max.set(value);
    }

    public Color getMax() {
        return this.max.get();
    }

    public void setMin(Color value) {
        this.min.set(value);
    }

    public Color getMin() {
        return this.min.get();
    }


    //endregion
}
