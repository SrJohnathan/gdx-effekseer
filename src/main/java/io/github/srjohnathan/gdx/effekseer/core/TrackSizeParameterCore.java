/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class TrackSizeParameterCore {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected TrackSizeParameterCore(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(TrackSizeParameterCore obj) {
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
        GDXJNI.delete_TrackSizeParameterCore(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setType(int value) {
    GDXJNI.TrackSizeParameterCore_type_set(swigCPtr, this, value);
  }

  public int getType() {
    return GDXJNI.TrackSizeParameterCore_type_get(swigCPtr, this);
  }

  public float getFixedSize() {
    return GDXJNI.TrackSizeParameterCore_getFixedSize(swigCPtr, this);
  }

  public void setFixedSize(float value) {
    GDXJNI.TrackSizeParameterCore_setFixedSize(swigCPtr, this, value);
  }

  public TrackSizeParameterCore() {
    this(GDXJNI.new_TrackSizeParameterCore(), true);
  }

  public final static int Fixed = GDXJNI.TrackSizeParameterCore_Fixed_get();
  public final static int Parameter_DWORD = GDXJNI.TrackSizeParameterCore_Parameter_DWORD_get();

}
