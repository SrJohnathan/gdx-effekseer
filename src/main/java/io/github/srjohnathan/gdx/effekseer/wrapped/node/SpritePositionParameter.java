package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.*;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;

import java.util.function.Function;

/**
 * Wraps {@link SpritePositionParameterCore}
 */
public class SpritePositionParameter {

    public static enum Type {
        Default(SpritePositionParameterCore.Default),
        Fixed(SpritePositionParameterCore.Fixed),
        Parameter_DWORD(SpritePositionParameterCore.Parameter_DWORD);

        private int value;
        private Type(int value) {
            this.value = value;
        }
    }

    //region State

    private SpritePositionParameterCore core;

    //region Field Wrappers

    private EffekseerFieldWrapper<Type> type = new EffekseerFieldWrapper<Type>(new Function<Void, Type>() {
        @Override
        public Type apply(Void unused) {
            int coreType = core.getType();

            if (coreType == SpritePositionParameterCore.Default) {
                return Type.Default;
            }
            else if (coreType == SpritePositionParameterCore.Fixed) {
                return Type.Fixed;
            }
            else if (coreType == SpritePositionParameterCore.Parameter_DWORD) {
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

    private EffekseerFieldWrapper<SIMDVec2f> fixedLowerLeftPos = new EffekseerFieldWrapper<SIMDVec2f>(new Function<Void, SIMDVec2f>() {
        @Override
        public SIMDVec2f apply(Void unused) {
            return core.getFixedLowerLeftPos();
        }
    }, new Function<SIMDVec2f, Void>() {
        @Override
        public Void apply(SIMDVec2f value) {
            core.setFixedLowerLeftPos(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<SIMDVec2f> fixedLowerRightPos = new EffekseerFieldWrapper<SIMDVec2f>(new Function<Void, SIMDVec2f>() {
        @Override
        public SIMDVec2f apply(Void unused) {
            return core.getFixedLowerRightPos();
        }
    }, new Function<SIMDVec2f, Void>() {
        @Override
        public Void apply(SIMDVec2f value) {
            core.setFixedLowerRightPos(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<SIMDVec2f> fixedUpperLeftPos = new EffekseerFieldWrapper<SIMDVec2f>(new Function<Void, SIMDVec2f>() {
        @Override
        public SIMDVec2f apply(Void unused) {
            return core.getFixedUpperLeftPos();
        }
    }, new Function<SIMDVec2f, Void>() {
        @Override
        public Void apply(SIMDVec2f value) {
            core.setFixedUpperLeftPos(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<SIMDVec2f> fixedUpperRightPos = new EffekseerFieldWrapper<SIMDVec2f>(new Function<Void, SIMDVec2f>() {
        @Override
        public SIMDVec2f apply(Void unused) {
            return core.getFixedUpperRightPos();
        }
    }, new Function<SIMDVec2f, Void>() {
        @Override
        public Void apply(SIMDVec2f value) {
            core.setFixedUpperRightPos(value);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public SpritePositionParameter(SpritePositionParameterCore core) {
        this.core = core;
    }

    //endregion

    //region Public Methods

    public SpritePositionParameterCore getCore() {
        return this.core;
    }

    public Type getType() {
        return this.type.get();
    }

    public void setType(Type type) {
        this.type.set(type);
    }

    SIMDVec2f getFixedLowerLeftPos() {
        return this.fixedLowerLeftPos.get();
    }

    void setFixedLowerLeftPos(SIMDVec2f value) {
        this.fixedLowerLeftPos.set(value);
    }

    SIMDVec2f getFixedLowerRightPos() {
        return this.fixedLowerRightPos.get();
    }

    void setFixedLowerRightPos(SIMDVec2f value) {
        this.fixedLowerRightPos.set(value);
    }

    SIMDVec2f getFixedUpperLeftPos() {
        return this.fixedUpperLeftPos.get();
    }

    void setFixedUpperLeftPos(SIMDVec2f value) {
        this.fixedUpperLeftPos.set(value);
    }

    SIMDVec2f getFixedUpperRightPos() {
        return this.fixedUpperRightPos.get();
    }

    void setFixedUpperRightPos(SIMDVec2f value) {
        this.fixedUpperRightPos.set(value);
    }

    //endregion

}