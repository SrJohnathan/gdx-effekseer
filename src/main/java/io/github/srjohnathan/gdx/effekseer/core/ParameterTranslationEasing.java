/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class ParameterTranslationEasing {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ParameterTranslationEasing(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ParameterTranslationEasing obj) {
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
        GDXJNI.delete_ParameterTranslationEasing(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setRefEqS(RefMinMax value) {
    GDXJNI.ParameterTranslationEasing_RefEqS_set(swigCPtr, this, RefMinMax.getCPtr(value), value);
  }

  public RefMinMax getRefEqS() {
    long cPtr = GDXJNI.ParameterTranslationEasing_RefEqS_get(swigCPtr, this);
    return (cPtr == 0) ? null : new RefMinMax(cPtr, false);
  }

  public void setRefEqE(RefMinMax value) {
    GDXJNI.ParameterTranslationEasing_RefEqE_set(swigCPtr, this, RefMinMax.getCPtr(value), value);
  }

  public RefMinMax getRefEqE() {
    long cPtr = GDXJNI.ParameterTranslationEasing_RefEqE_get(swigCPtr, this);
    return (cPtr == 0) ? null : new RefMinMax(cPtr, false);
  }

  public void setLocation(InternalStructEasingVector3D value) {
    GDXJNI.ParameterTranslationEasing_location_set(swigCPtr, this, InternalStructEasingVector3D.getCPtr(value), value);
  }

  public InternalStructEasingVector3D getLocation() {
    long cPtr = GDXJNI.ParameterTranslationEasing_location_get(swigCPtr, this);
    return (cPtr == 0) ? null : new InternalStructEasingVector3D(cPtr, false);
  }

  public ParameterTranslationEasing() {
    this(GDXJNI.new_ParameterTranslationEasing(), true);
  }

}
