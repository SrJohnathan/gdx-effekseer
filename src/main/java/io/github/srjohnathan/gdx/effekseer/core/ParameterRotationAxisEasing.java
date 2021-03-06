/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class ParameterRotationAxisEasing {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ParameterRotationAxisEasing(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ParameterRotationAxisEasing obj) {
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
        GDXJNI.delete_ParameterRotationAxisEasing(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setAxis(InternalStructRandomVector3D value) {
    GDXJNI.ParameterRotationAxisEasing_axis_set(swigCPtr, this, InternalStructRandomVector3D.getCPtr(value), value);
  }

  public InternalStructRandomVector3D getAxis() {
    long cPtr = GDXJNI.ParameterRotationAxisEasing_axis_get(swigCPtr, this);
    return (cPtr == 0) ? null : new InternalStructRandomVector3D(cPtr, false);
  }

  public void setEasing(ParameterEasingFloatCore value) {
    GDXJNI.ParameterRotationAxisEasing_easing_set(swigCPtr, this, ParameterEasingFloatCore.getCPtr(value), value);
  }

  public ParameterEasingFloatCore getEasing() {
    long cPtr = GDXJNI.ParameterRotationAxisEasing_easing_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterEasingFloatCore(cPtr, false);
  }

  public ParameterRotationAxisEasing() {
    this(GDXJNI.new_ParameterRotationAxisEasing(), true);
  }

}
