/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class EffectModelParameter {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected EffectModelParameter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(EffectModelParameter obj) {
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
        GDXJNI.delete_EffectModelParameter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setLighting(boolean value) {
    GDXJNI.EffectModelParameter_Lighting_set(swigCPtr, this, value);
  }

  public boolean getLighting() {
    return GDXJNI.EffectModelParameter_Lighting_get(swigCPtr, this);
  }

  public EffectModelParameter() {
    this(GDXJNI.new_EffectModelParameter(), true);
  }

}
