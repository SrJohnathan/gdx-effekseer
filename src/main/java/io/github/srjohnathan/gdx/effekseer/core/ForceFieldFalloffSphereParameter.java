/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class ForceFieldFalloffSphereParameter {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ForceFieldFalloffSphereParameter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ForceFieldFalloffSphereParameter obj) {
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
        GDXJNI.delete_ForceFieldFalloffSphereParameter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public ForceFieldFalloffSphereParameter() {
    this(GDXJNI.new_ForceFieldFalloffSphereParameter(), true);
  }

}
