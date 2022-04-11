package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.Color;
import io.github.srjohnathan.gdx.effekseer.core.RibbonColorParameterCore;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;

import java.util.function.Function;

public class RibbonColorParameter {

    //region State

    public final RibbonColorParameterCore core;

    //region Field Wrappers

    private EffekseerFieldWrapper<Color> fixedLeftColor = new EffekseerFieldWrapper<Color>(new Function<Void, Color>() {
        @Override
        public Color apply(Void unused) {
            return core.getFixedLeftColor();
        }
    }, new Function<Color, Void>() {
        @Override
        public Void apply(Color value) {
            core.setFixedLeftColor(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<Color> fixedRightColor = new EffekseerFieldWrapper<Color>(new Function<Void, Color>() {
        @Override
        public Color apply(Void unused) {
            return core.getFixedRightColor();
        }
    }, new Function<Color, Void>() {
        @Override
        public Void apply(Color value) {
            core.setFixedRightColor(value);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public RibbonColorParameter(RibbonColorParameterCore core) {
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

    public Color getFixedLeftColor() {
        return this.fixedLeftColor.get();
    }

    public void setFixedLeftColor(Color value) {
        this.fixedLeftColor.set(value);
    }

    public Color getFixedRightColor() {
        return this.fixedRightColor.get();
    }

    public void setFixedRightColor(Color value) {
        this.fixedRightColor.set(value);
    }


    //endregion

}
