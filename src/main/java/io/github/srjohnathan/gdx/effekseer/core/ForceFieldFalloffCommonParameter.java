/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class ForceFieldFalloffCommonParameter {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ForceFieldFalloffCommonParameter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ForceFieldFalloffCommonParameter obj) {
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
        GDXJNI.delete_ForceFieldFalloffCommonParameter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setPower(float value) {
    GDXJNI.ForceFieldFalloffCommonParameter_Power_set(swigCPtr, this, value);
  }

  public float getPower() {
    return GDXJNI.ForceFieldFalloffCommonParameter_Power_get(swigCPtr, this);
  }

  public void setMinDistance(float value) {
    GDXJNI.ForceFieldFalloffCommonParameter_MinDistance_set(swigCPtr, this, value);
  }

  public float getMinDistance() {
    return GDXJNI.ForceFieldFalloffCommonParameter_MinDistance_get(swigCPtr, this);
  }

  public void setMaxDistance(float value) {
    GDXJNI.ForceFieldFalloffCommonParameter_MaxDistance_set(swigCPtr, this, value);
  }

  public float getMaxDistance() {
    return GDXJNI.ForceFieldFalloffCommonParameter_MaxDistance_get(swigCPtr, this);
  }

  public ForceFieldFalloffCommonParameter() {
    this(GDXJNI.new_ForceFieldFalloffCommonParameter(), true);
  }

}
