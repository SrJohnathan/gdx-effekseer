/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class ForceFieldWindParameter {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ForceFieldWindParameter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ForceFieldWindParameter obj) {
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
        GDXJNI.delete_ForceFieldWindParameter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setPower(float value) {
    GDXJNI.ForceFieldWindParameter_Power_set(swigCPtr, this, value);
  }

  public float getPower() {
    return GDXJNI.ForceFieldWindParameter_Power_get(swigCPtr, this);
  }

  public ForceFieldWindParameter() {
    this(GDXJNI.new_ForceFieldWindParameter(), true);
  }

}
