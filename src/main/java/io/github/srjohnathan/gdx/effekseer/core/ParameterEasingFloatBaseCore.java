/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class ParameterEasingFloatBaseCore {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ParameterEasingFloatBaseCore(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ParameterEasingFloatBaseCore obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        GDXJNI.delete_ParameterEasingFloatBaseCore(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setRefEqS(RefMinMax value) {
    GDXJNI.ParameterEasingFloatBaseCore_RefEqS_set(swigCPtr, this, RefMinMax.getCPtr(value), value);
  }

  public RefMinMax getRefEqS() {
    long cPtr = GDXJNI.ParameterEasingFloatBaseCore_RefEqS_get(swigCPtr, this);
    return (cPtr == 0) ? null : new RefMinMax(cPtr, false);
  }

  public void setRefEqE(RefMinMax value) {
    GDXJNI.ParameterEasingFloatBaseCore_RefEqE_set(swigCPtr, this, RefMinMax.getCPtr(value), value);
  }

  public RefMinMax getRefEqE() {
    long cPtr = GDXJNI.ParameterEasingFloatBaseCore_RefEqE_get(swigCPtr, this);
    return (cPtr == 0) ? null : new RefMinMax(cPtr, false);
  }

  public void setRefEqM(RefMinMax value) {
    GDXJNI.ParameterEasingFloatBaseCore_RefEqM_set(swigCPtr, this, RefMinMax.getCPtr(value), value);
  }

  public RefMinMax getRefEqM() {
    long cPtr = GDXJNI.ParameterEasingFloatBaseCore_RefEqM_get(swigCPtr, this);
    return (cPtr == 0) ? null : new RefMinMax(cPtr, false);
  }

  public void setType_(Easing3Type value) {
    GDXJNI.ParameterEasingFloatBaseCore_type__set(swigCPtr, this, value.swigValue());
  }

  public Easing3Type getType_() {
    return Easing3Type.swigToEnum(GDXJNI.ParameterEasingFloatBaseCore_type__get(swigCPtr, this));
  }

  public void setParams(FloatArray4 value) {
    GDXJNI.ParameterEasingFloatBaseCore_params_set(swigCPtr, this, FloatArray4.getCPtr(value), value);
  }

  public FloatArray4 getParams() {
    long cPtr = GDXJNI.ParameterEasingFloatBaseCore_params_get(swigCPtr, this);
    return (cPtr == 0) ? null : new FloatArray4(cPtr, false);
  }

  public void setChannelCount(int value) {
    GDXJNI.ParameterEasingFloatBaseCore_channelCount_set(swigCPtr, this, value);
  }

  public int getChannelCount() {
    return GDXJNI.ParameterEasingFloatBaseCore_channelCount_get(swigCPtr, this);
  }

  public void setIsMiddleEnabled(boolean value) {
    GDXJNI.ParameterEasingFloatBaseCore_isMiddleEnabled_set(swigCPtr, this, value);
  }

  public boolean getIsMiddleEnabled() {
    return GDXJNI.ParameterEasingFloatBaseCore_isMiddleEnabled_get(swigCPtr, this);
  }

  public void setIsIndividualEnabled(boolean value) {
    GDXJNI.ParameterEasingFloatBaseCore_isIndividualEnabled_set(swigCPtr, this, value);
  }

  public boolean getIsIndividualEnabled() {
    return GDXJNI.ParameterEasingFloatBaseCore_isIndividualEnabled_get(swigCPtr, this);
  }

}
