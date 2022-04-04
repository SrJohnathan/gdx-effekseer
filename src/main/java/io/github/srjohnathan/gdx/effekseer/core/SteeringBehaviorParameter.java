/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class SteeringBehaviorParameter {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected SteeringBehaviorParameter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SteeringBehaviorParameter obj) {
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
        GDXJNI.delete_SteeringBehaviorParameter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setMaxFollowSpeed(InternalStructRandomFloat value) {
    GDXJNI.SteeringBehaviorParameter_MaxFollowSpeed_set(swigCPtr, this, InternalStructRandomFloat.getCPtr(value), value);
  }

  public InternalStructRandomFloat getMaxFollowSpeed() {
    long cPtr = GDXJNI.SteeringBehaviorParameter_MaxFollowSpeed_get(swigCPtr, this);
    return (cPtr == 0) ? null : new InternalStructRandomFloat(cPtr, false);
  }

  public void setSteeringSpeed(InternalStructRandomFloat value) {
    GDXJNI.SteeringBehaviorParameter_SteeringSpeed_set(swigCPtr, this, InternalStructRandomFloat.getCPtr(value), value);
  }

  public InternalStructRandomFloat getSteeringSpeed() {
    long cPtr = GDXJNI.SteeringBehaviorParameter_SteeringSpeed_get(swigCPtr, this);
    return (cPtr == 0) ? null : new InternalStructRandomFloat(cPtr, false);
  }

  public SteeringBehaviorParameter() {
    this(GDXJNI.new_SteeringBehaviorParameter(), true);
  }

}
