/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class InternalStructRectF {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected InternalStructRectF(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(InternalStructRectF obj) {
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
        GDXJNI.delete_InternalStructRectF(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setX(float value) {
    GDXJNI.InternalStructRectF_x_set(swigCPtr, this, value);
  }

  public float getX() {
    return GDXJNI.InternalStructRectF_x_get(swigCPtr, this);
  }

  public void setY(float value) {
    GDXJNI.InternalStructRectF_y_set(swigCPtr, this, value);
  }

  public float getY() {
    return GDXJNI.InternalStructRectF_y_get(swigCPtr, this);
  }

  public void setW(float value) {
    GDXJNI.InternalStructRectF_w_set(swigCPtr, this, value);
  }

  public float getW() {
    return GDXJNI.InternalStructRectF_w_get(swigCPtr, this);
  }

  public void setH(float value) {
    GDXJNI.InternalStructRectF_h_set(swigCPtr, this, value);
  }

  public float getH() {
    return GDXJNI.InternalStructRectF_h_get(swigCPtr, this);
  }

  public InternalStructRectF() {
    this(GDXJNI.new_InternalStructRectF(), true);
  }

}
