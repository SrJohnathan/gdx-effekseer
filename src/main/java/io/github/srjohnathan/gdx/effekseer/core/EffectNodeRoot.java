/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class EffectNodeRoot extends EffectNodeImplemented {
  private transient long swigCPtr;

  protected EffectNodeRoot(long cPtr, boolean cMemoryOwn) {
    super(GDXJNI.EffectNodeRoot_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(EffectNodeRoot obj) {
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
        GDXJNI.delete_EffectNodeRoot(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public EffectNodeRoot(EffekseerEffect effect, SWIGTYPE_p_p_unsigned_char pos) {
    this(GDXJNI.new_EffectNodeRoot(EffekseerEffect.getCPtr(effect), effect, SWIGTYPE_p_p_unsigned_char.getCPtr(pos)), true);
  }

}
