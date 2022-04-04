package io.github.srjohnathan.gdx.effekseer.wrapped;

import io.github.srjohnathan.gdx.effekseer.core.*;

import java.util.function.Function;

/**
 * Wraps {@link StandardColorParameterCore}
 */
public class StandardColorParameter {

    public static enum Type {
        Fixed(StandardColorParameterCore.Fixed),
        Random(StandardColorParameterCore.Random),
        Easing(StandardColorParameterCore.Easing),
        FCurve_RGBA(StandardColorParameterCore.FCurve_RGBA),
        Parameter_DWORD(StandardColorParameterCore.Parameter_DWORD);

        private int value;
        private Type(int value) {
            this.value = value;
        }
    }

    //region State

    private StandardColorParameterCore core;

    //region Field Wrappers

    private EffekseerFieldWrapper<Type> type = new EffekseerFieldWrapper<Type>(new Function<Void, Type>() {
        @Override
        public Type apply(Void unused) {
            int coreType = core.getType();

            if (coreType == StandardColorParameterCore.Fixed) {
                return Type.Fixed;
            }
            else if (coreType == StandardColorParameterCore.Random) {
                return Type.Random;
            }
            else if (coreType == StandardColorParameterCore.Easing) {
                return Type.Easing;
            }
            else if (coreType == StandardColorParameterCore.FCurve_RGBA) {
                return Type.FCurve_RGBA;
            }
            else if (coreType == StandardColorParameterCore.Parameter_DWORD) {
                return Type.Parameter_DWORD;
            }
            else {
                return Type.Fixed;
            }
        }
    }, new Function<Type, Void>() {
        @Override
        public Void apply(Type value) {
            core.setType(value.value);
            return null;
        }
    });

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

    private EffekseerFieldWrapper<InternalStructRandomColor> randomColor = new EffekseerFieldWrapper<InternalStructRandomColor>(new Function<Void, InternalStructRandomColor>() {
        @Override
        public InternalStructRandomColor apply(Void unused) {
            return core.getRandom();
        }
    }, new Function<InternalStructRandomColor, Void>() {
        @Override
        public Void apply(InternalStructRandomColor value) {
            core.setRandom(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<InternalStructEasingColor> easingColor = new EffekseerFieldWrapper<InternalStructEasingColor>(new Function<Void, InternalStructEasingColor>() {
        @Override
        public InternalStructEasingColor apply(Void unused) {
            return core.getEasing();
        }
    }, new Function<InternalStructEasingColor, Void>() {
        @Override
        public Void apply(InternalStructEasingColor value) {
            core.setEasing(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<FCurveVectorColor> fCurveRGBAColor = new EffekseerFieldWrapper<FCurveVectorColor>(new Function<Void, FCurveVectorColor>() {
        @Override
        public FCurveVectorColor apply(Void unused) {
            return core.getFCurveRGBA();
        }
    }, new Function<FCurveVectorColor, Void>() {
        @Override
        public Void apply(FCurveVectorColor value) {
            core.setFCurveRGBA(value);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public StandardColorParameter(StandardColorParameterCore core) {
        this.core = core;
    }

    //endregion

    //region Public Methods

    public StandardColorParameterCore getCore() {
        return this.core;
    }

    public Type getType() {
        return this.type.get();
    }

    public void setType(Type type) {
        this.type.set(type);
    }

    public Color getFixedColor() {
        return this.fixedColor.get();
    }

    public void setFixedColor(Color color) {
        this.fixedColor.set(color);
    }

    public InternalStructRandomColor getRandomColor() {
        return this.randomColor.get();
    }

    public void setRandomColor(InternalStructRandomColor color) {
        this.randomColor.set(color);
    }

    public InternalStructEasingColor getEasingColor() {
        return this.easingColor.get();
    }

    public void setEasingColor(InternalStructEasingColor color) {
        this.easingColor.set(color);
    }

    public FCurveVectorColor getFCurveRGBAColor() {
        return this.fCurveRGBAColor.get();
    }

    public void setFCurveRGBAColor(FCurveVectorColor color) {
        this.fCurveRGBAColor.set(color);
    }

    //endregion

}