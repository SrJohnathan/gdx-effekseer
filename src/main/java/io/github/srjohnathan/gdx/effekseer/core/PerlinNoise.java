/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class PerlinNoise {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected PerlinNoise(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(PerlinNoise obj) {
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
        GDXJNI.delete_PerlinNoise(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public PerlinNoise() {
    this(GDXJNI.new_PerlinNoise__SWIG_0(), true);
  }

  public PerlinNoise(long seed) {
    this(GDXJNI.new_PerlinNoise__SWIG_1(seed), true);
  }

}
