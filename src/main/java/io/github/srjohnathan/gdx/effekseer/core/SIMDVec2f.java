/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class SIMDVec2f {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected SIMDVec2f(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(SIMDVec2f obj) {
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
        GDXJNI.delete_SIMDVec2f(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public SIMDVec2f() {
    this(GDXJNI.new_SIMDVec2f__SWIG_0(), true);
  }

  public SIMDVec2f(SIMDVec2f vec) {
    this(GDXJNI.new_SIMDVec2f__SWIG_1(SIMDVec2f.getCPtr(vec), vec), true);
  }

  public SIMDVec2f(float x, float y) {
    this(GDXJNI.new_SIMDVec2f__SWIG_2(x, y), true);
  }

  public SIMDVec2f(Vector2D vec) {
    this(GDXJNI.new_SIMDVec2f__SWIG_3(Vector2D.getCPtr(vec), vec), true);
  }

  public SIMDVec2f(InternalStructVector2D vec) {
    this(GDXJNI.new_SIMDVec2f__SWIG_4(InternalStructVector2D.getCPtr(vec), vec), true);
  }

}