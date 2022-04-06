package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.*;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;

import java.util.function.Function;

/**
 * Wraps {@link SpriteColorParameterCore}
 */
public class SpriteColorParameter {

    public static enum Type {
        Default(SpriteColorParameterCore.Default),
        Fixed(SpriteColorParameterCore.Fixed),
        Parameter_DWORD(SpriteColorParameterCore.Parameter_DWORD);

        private int value;
        private Type(int value) {
            this.value = value;
        }
    }

    //region State

    private SpriteColorParameterCore core;

    //region Field Wrappers

    private EffekseerFieldWrapper<Type> type = new EffekseerFieldWrapper<Type>(new Function<Void, Type>() {
        @Override
        public Type apply(Void unused) {
            int coreType = core.getType();

            if (coreType == StandardColorParameterCore.Fixed) {
                return Type.Default;
            }
            else if (coreType == StandardColorParameterCore.Random) {
                return Type.Fixed;
            }
            else if (coreType == StandardColorParameterCore.Parameter_DWORD) {
                return Type.Parameter_DWORD;
            }
            else {
                return Type.Default;
            }
        }
    }, new Function<Type, Void>() {
        @Override
        public Void apply(Type value) {
            core.setType(value.value);
            return null;
        }
    });

    private EffekseerFieldWrapper<Color> fixedLowerLeftColor = new EffekseerFieldWrapper<Color>(new Function<Void, Color>() {
        @Override
        public Color apply(Void unused) {
            return core.getFixedLowerLeftColor();
        }
    }, new Function<Color, Void>() {
        @Override
        public Void apply(Color value) {
            core.setFixedLowerLeftColor(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<Color> fixedLowerRightColor = new EffekseerFieldWrapper<Color>(new Function<Void, Color>() {
        @Override
        public Color apply(Void unused) {
            return core.getFixedLowerRightColor();
        }
    }, new Function<Color, Void>() {
        @Override
        public Void apply(Color value) {
            core.setFixedLowerRightColor(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<Color> fixedUpperLeftColor = new EffekseerFieldWrapper<Color>(new Function<Void, Color>() {
        @Override
        public Color apply(Void unused) {
            return core.getFixedUpperLeftColor();
        }
    }, new Function<Color, Void>() {
        @Override
        public Void apply(Color value) {
            core.setFixedUpperLeftColor(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<Color> fixedUpperRightColor = new EffekseerFieldWrapper<Color>(new Function<Void, Color>() {
        @Override
        public Color apply(Void unused) {
            return core.getFixedUpperRightColor();
        }
    }, new Function<Color, Void>() {
        @Override
        public Void apply(Color value) {
            core.setFixedUpperRightColor(value);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public SpriteColorParameter(SpriteColorParameterCore core) {
        this.core = core;
    }

    //endregion

    //region Public Methods

    public SpriteColorParameterCore getCore() {
        return this.core;
    }

    public Type getType() {
        return this.type.get();
    }

    public void setType(Type type) {
        this.type.set(type);
    }

    Color getFixedLowerLeftColor() {
        return this.fixedLowerLeftColor.get();
    }

    void setFixedLowerLeftColor(Color value) {
        this.fixedLowerLeftColor.set(value);
    }

    Color getFixedLowerRightColor() {
        return this.fixedLowerRightColor.get();
    }

    void setFixedLowerRightColor(Color value) {
        this.fixedLowerRightColor.set(value);
    }

    Color getFixedUpperLeftColor() {
        return this.fixedUpperLeftColor.get();
    }

    void setFixedUpperLeftColor(Color value) {
        this.fixedUpperLeftColor.set(value);
    }

    Color getFixedUpperRightColor() {
        return this.fixedUpperRightColor.get();
    }

    void setFixedUpperRightColor(Color value) {
        this.fixedUpperRightColor.set(value);
    }

    //endregion

}