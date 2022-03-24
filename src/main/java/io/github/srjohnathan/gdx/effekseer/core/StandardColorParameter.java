/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class StandardColorParameter {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected StandardColorParameter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(StandardColorParameter obj) {
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
        GDXJNI.delete_StandardColorParameter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setType(int value) {
    GDXJNI.StandardColorParameter_type_set(swigCPtr, this, value);
  }

  public int getType() {
    return GDXJNI.StandardColorParameter_type_get(swigCPtr, this);
  }

  public StandardColorParameter() {
    this(GDXJNI.new_StandardColorParameter(), true);
  }

  public final static int Fixed = GDXJNI.StandardColorParameter_Fixed_get();
  public final static int Random = GDXJNI.StandardColorParameter_Random_get();
  public final static int Easing = GDXJNI.StandardColorParameter_Easing_get();
  public final static int FCurve_RGBA = GDXJNI.StandardColorParameter_FCurve_RGBA_get();
  public final static int Parameter_DWORD = GDXJNI.StandardColorParameter_Parameter_DWORD_get();

}