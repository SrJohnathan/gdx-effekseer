/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class ForceFieldGravityParameter {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ForceFieldGravityParameter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ForceFieldGravityParameter obj) {
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
        GDXJNI.delete_ForceFieldGravityParameter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setGravity(SIMDVec3f value) {
    GDXJNI.ForceFieldGravityParameter_Gravity_set(swigCPtr, this, SIMDVec3f.getCPtr(value), value);
  }

  public SIMDVec3f getGravity() {
    long cPtr = GDXJNI.ForceFieldGravityParameter_Gravity_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SIMDVec3f(cPtr, false);
  }

  public ForceFieldGravityParameter() {
    this(GDXJNI.new_ForceFieldGravityParameter(), true);
  }

}
