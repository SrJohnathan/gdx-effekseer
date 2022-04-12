package io.github.srjohnathan.gdx.effekseer.wrapped.struct;

import io.github.srjohnathan.gdx.effekseer.core.*;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;

import java.util.function.Function;

public class ParameterEasingFloat extends ParameterEasingFloatCore {

    /**
     * Extends {@link ParameterEasingFloatBaseCore} to make its constructor public.
     */
    private static class ParameterEasingFloatBaseCorePrivate extends ParameterEasingFloatBaseCore {
        public ParameterEasingFloatBaseCorePrivate(long cPtr, boolean cMemoryOwn) {
            super(cPtr, cMemoryOwn);
        }
    }

    //region State

    public final ParameterEasingFloatBaseCorePrivate baseCore;
    public final ParameterEasingFloatCore core;

    //region Field Wrappers

    private EffekseerFieldWrapper<RefMinMax> refEqS = new EffekseerFieldWrapper<RefMinMax>(new Function<Void, RefMinMax>() {
        @Override
        public RefMinMax apply(Void unused) {
            return baseCore.getRefEqS();
        }
    }, new Function<RefMinMax, Void>() {
        @Override
        public Void apply(RefMinMax value) {
            baseCore.setRefEqS(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<RefMinMax> refEqE = new EffekseerFieldWrapper<RefMinMax>(new Function<Void, RefMinMax>() {
        @Override
        public RefMinMax apply(Void unused) {
            return baseCore.getRefEqE();
        }
    }, new Function<RefMinMax, Void>() {
        @Override
        public Void apply(RefMinMax value) {
            baseCore.setRefEqE(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<RefMinMax> refEqM = new EffekseerFieldWrapper<RefMinMax>(new Function<Void, RefMinMax>() {
        @Override
        public RefMinMax apply(Void unused) {
            return baseCore.getRefEqM();
        }
    }, new Function<RefMinMax, Void>() {
        @Override
        public Void apply(RefMinMax value) {
            baseCore.setRefEqM(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<FloatArray4> params = new EffekseerFieldWrapper<FloatArray4>(new Function<Void, FloatArray4>() {
        @Override
        public FloatArray4 apply(Void unused) {
            return baseCore.getParams();
        }
    }, new Function<FloatArray4, Void>() {
        @Override
        public Void apply(FloatArray4 value) {
            baseCore.setParams(value);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public ParameterEasingFloat(ParameterEasingFloatCore core) {
        super(getCPtr(core), false);
        this.baseCore = new ParameterEasingFloatBaseCorePrivate(getCPtr(core), true);
        this.core = core;
    }

    //endregion

    //region Wrapper Methods

    public void delete() {
        this.baseCore.delete();
        this.core.delete();
    }

    public void setRefEqS(RefMinMax value) {
        this.refEqS.set(value);
    }

    public RefMinMax getRefEqS() {
        return this.refEqS.get();
    }

    public void setRefEqE(RefMinMax value) {
        this.refEqE.set(value);
    }

    public RefMinMax getRefEqE() {
        return this.refEqE.get();
    }

    public void setRefEqM(RefMinMax value) {
        this.refEqM.set(value);
    }

    public RefMinMax getRefEqM() {
        return this.refEqM.get();
    }

    public void setType_(Easing3Type value) {
        this.baseCore.setType_(value);
    }

    public Easing3Type getType_() {
        return this.baseCore.getType_();
    }

    public void setParams(FloatArray4 value) {
        this.params.set(value);
    }

    public FloatArray4 getParams() {
        return this.params.get();
    }

    public void setChannelCount(int value) {
        this.baseCore.setChannelCount(value);
    }

    public int getChannelCount() {
        return this.baseCore.getChannelCount();
    }

    public void setIsMiddleEnabled(boolean value) {
        this.baseCore.setIsMiddleEnabled(value);
    }

    public boolean getIsMiddleEnabled() {
        return this.baseCore.getIsMiddleEnabled();
    }

    public void setIsIndividualEnabled(boolean value) {
        this.baseCore.setIsIndividualEnabled(value);
    }

    public boolean getIsIndividualEnabled() {
        return this.baseCore.getIsIndividualEnabled();
    }

    //endregion
}
