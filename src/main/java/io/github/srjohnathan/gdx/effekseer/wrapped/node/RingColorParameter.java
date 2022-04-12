package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.Color;
import io.github.srjohnathan.gdx.effekseer.core.RingColorParameterCore;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;
import io.github.srjohnathan.gdx.effekseer.wrapped.struct.EasingColor;
import io.github.srjohnathan.gdx.effekseer.wrapped.struct.RandomColor;

import java.util.function.Function;

public class RingColorParameter {

    //region State

    public final RingColorParameterCore core;

    //region Field Wrappers

    private EffekseerFieldWrapper<Color> fixedColor = new EffekseerFieldWrapper<Color>(new Function<Void, Color>() {
        @Override
        public Color apply(Void unused) {
            return core.getFixed();
        }
    }, new Function<Color, Void>() {
        @Override
        public Void apply(Color value) {
            core.setFixed(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<RandomColor> randomColor = new EffekseerFieldWrapper<RandomColor>(new Function<Void, RandomColor>() {
        @Override
        public RandomColor apply(Void unused) {
            return new RandomColor(core.getRandom());
        }
    }, new Function<RandomColor, Void>() {
        @Override
        public Void apply(RandomColor value) {
            core.setRandom(value.core);
            return null;
        }
    });

    private EffekseerFieldWrapper<EasingColor> easingColor = new EffekseerFieldWrapper<EasingColor>(new Function<Void, EasingColor>() {
        @Override
        public EasingColor apply(Void unused) {
            return new EasingColor(core.getEasing());
        }
    }, new Function<EasingColor, Void>() {
        @Override
        public Void apply(EasingColor value) {
            core.setEasing(value.core);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public RingColorParameter(RingColorParameterCore core) {
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

    public void setFixed(Color value) {
        this.fixedColor.set(value);
    }

    public Color getFixed() {
        return this.fixedColor.get();
    }

    public void setRandom(RandomColor value) {
        this.randomColor.set(value);
    }

    public RandomColor getRandom() {
        return this.randomColor.get();
    }

    public void setEasing(EasingColor value) {
        this.easingColor.set(value);
    }

    public EasingColor getEasing() {
        return this.easingColor.get();
    }

    //endregion

}
