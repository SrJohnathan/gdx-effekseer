/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class InternalStructFloatWithoutRandom {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected InternalStructFloatWithoutRandom(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(InternalStructFloatWithoutRandom obj) {
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
        GDXJNI.delete_InternalStructFloatWithoutRandom(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setEasingA(float value) {
    GDXJNI.InternalStructFloatWithoutRandom_easingA_set(swigCPtr, this, value);
  }

  public float getEasingA() {
    return GDXJNI.InternalStructFloatWithoutRandom_easingA_get(swigCPtr, this);
  }

  public void setEasingB(float value) {
    GDXJNI.InternalStructFloatWithoutRandom_easingB_set(swigCPtr, this, value);
  }

  public float getEasingB() {
    return GDXJNI.InternalStructFloatWithoutRandom_easingB_get(swigCPtr, this);
  }

  public void setEasingC(float value) {
    GDXJNI.InternalStructFloatWithoutRandom_easingC_set(swigCPtr, this, value);
  }

  public float getEasingC() {
    return GDXJNI.InternalStructFloatWithoutRandom_easingC_get(swigCPtr, this);
  }

  public InternalStructFloatWithoutRandom() {
    this(GDXJNI.new_InternalStructFloatWithoutRandom(), true);
  }

}
