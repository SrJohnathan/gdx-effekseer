/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class LocationAbsParameter {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected LocationAbsParameter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(LocationAbsParameter obj) {
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
        GDXJNI.delete_LocationAbsParameter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setType(LocationAbsType value) {
    GDXJNI.LocationAbsParameter_type_set(swigCPtr, this, value.swigValue());
  }

  public LocationAbsType getType() {
    return LocationAbsType.swigToEnum(GDXJNI.LocationAbsParameter_type_get(swigCPtr, this));
  }

  public void setGravity(SIMDVec3f value) {
    GDXJNI.LocationAbsParameter_gravity_set(swigCPtr, this, SIMDVec3f.getCPtr(value), value);
  }

  public SIMDVec3f getGravity() {
    long cPtr = GDXJNI.LocationAbsParameter_gravity_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SIMDVec3f(cPtr, false);
  }

  public LocationAbsParameter() {
    this(GDXJNI.new_LocationAbsParameter(), true);
  }

}
