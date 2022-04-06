/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class ForceFieldVortexParameter {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ForceFieldVortexParameter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ForceFieldVortexParameter obj) {
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
        GDXJNI.delete_ForceFieldVortexParameter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setType(ForceFieldVortexType value) {
    GDXJNI.ForceFieldVortexParameter_Type_set(swigCPtr, this, value.swigValue());
  }

  public ForceFieldVortexType getType() {
    return ForceFieldVortexType.swigToEnum(GDXJNI.ForceFieldVortexParameter_Type_get(swigCPtr, this));
  }

  public void setPower(float value) {
    GDXJNI.ForceFieldVortexParameter_Power_set(swigCPtr, this, value);
  }

  public float getPower() {
    return GDXJNI.ForceFieldVortexParameter_Power_get(swigCPtr, this);
  }

  public ForceFieldVortexParameter() {
    this(GDXJNI.new_ForceFieldVortexParameter(), true);
  }

}
