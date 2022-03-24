/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class InternalStructEasingColor {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected InternalStructEasingColor(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(InternalStructEasingColor obj) {
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
        GDXJNI.delete_InternalStructEasingColor(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setStart(InternalStructRandomColor value) {
    GDXJNI.InternalStructEasingColor_start_set(swigCPtr, this, InternalStructRandomColor.getCPtr(value), value);
  }

  public InternalStructRandomColor getStart() {
    long cPtr = GDXJNI.InternalStructEasingColor_start_get(swigCPtr, this);
    return (cPtr == 0) ? null : new InternalStructRandomColor(cPtr, false);
  }

  public void setEnd(InternalStructRandomColor value) {
    GDXJNI.InternalStructEasingColor_end_set(swigCPtr, this, InternalStructRandomColor.getCPtr(value), value);
  }

  public InternalStructRandomColor getEnd() {
    long cPtr = GDXJNI.InternalStructEasingColor_end_get(swigCPtr, this);
    return (cPtr == 0) ? null : new InternalStructRandomColor(cPtr, false);
  }

  public void setEasingA(float value) {
    GDXJNI.InternalStructEasingColor_easingA_set(swigCPtr, this, value);
  }

  public float getEasingA() {
    return GDXJNI.InternalStructEasingColor_easingA_get(swigCPtr, this);
  }

  public void setEasingB(float value) {
    GDXJNI.InternalStructEasingColor_easingB_set(swigCPtr, this, value);
  }

  public float getEasingB() {
    return GDXJNI.InternalStructEasingColor_easingB_get(swigCPtr, this);
  }

  public void setEasingC(float value) {
    GDXJNI.InternalStructEasingColor_easingC_set(swigCPtr, this, value);
  }

  public float getEasingC() {
    return GDXJNI.InternalStructEasingColor_easingC_get(swigCPtr, this);
  }

  public InternalStructEasingColor() {
    this(GDXJNI.new_InternalStructEasingColor(), true);
  }

}