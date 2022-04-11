package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.Color;
import io.github.srjohnathan.gdx.effekseer.core.RibbonAllColorParameterCore;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;
import io.github.srjohnathan.gdx.effekseer.wrapped.struct.EasingColor;
import io.github.srjohnathan.gdx.effekseer.wrapped.struct.RandomColor;

import java.util.function.Function;

public class RibbonAllColorParameter {

    //region State

    public final RibbonAllColorParameterCore core;

    //region Field Wrappers

    private EffekseerFieldWrapper<Color> fixedAllColor = new EffekseerFieldWrapper<Color>(new Function<Void, Color>() {
        @Override
        public Color apply(Void unused) {
            return core.getFixedAllColor();
        }
    }, new Function<Color, Void>() {
        @Override
        public Void apply(Color value) {
            core.setFixedAllColor(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<RandomColor> randomAllColor = new EffekseerFieldWrapper<RandomColor>(new Function<Void, RandomColor>() {
        @Override
        public RandomColor apply(Void unused) {
            return new RandomColor(core.getRandomAllColor());
        }
    }, new Function<RandomColor, Void>() {
        @Override
        public Void apply(RandomColor value) {
            core.setRandomAllColor(value.core);
            return null;
        }
    });

    private EffekseerFieldWrapper<EasingColor> easingAllColor = new EffekseerFieldWrapper<EasingColor>(new Function<Void, EasingColor>() {
        @Override
        public EasingColor apply(Void unused) {
            return new EasingColor(core.getEasingAllColor());
        }
    }, new Function<EasingColor, Void>() {
        @Override
        public Void apply(EasingColor value) {
            core.setEasingAllColor(value.core);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public RibbonAllColorParameter(RibbonAllColorParameterCore core) {
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

    public Color getFixedAllColor() {
        return this.fixedAllColor.get();
    }

    public void setFixedAllColor(Color value) {
        this.fixedAllColor.set(value);
    }

    public RandomColor getRandomAllColor() {
        return this.randomAllColor.get();
    }

    public void setRandomAllColor(RandomColor value) {
        this.randomAllColor.set(value);
    }

    public EasingColor getEasingAllColor() {
        return this.easingAllColor.get();
    }

    public void setEasingAllColor(EasingColor value) {
        this.easingAllColor.set(value);
    }


    //endregion
}
