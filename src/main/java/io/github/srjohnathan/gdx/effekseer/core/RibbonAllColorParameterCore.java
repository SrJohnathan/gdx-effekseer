/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class RibbonAllColorParameterCore {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected RibbonAllColorParameterCore(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(RibbonAllColorParameterCore obj) {
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
        GDXJNI.delete_RibbonAllColorParameterCore(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setType(int value) {
    GDXJNI.RibbonAllColorParameterCore_type_set(swigCPtr, this, value);
  }

  public int getType() {
    return GDXJNI.RibbonAllColorParameterCore_type_get(swigCPtr, this);
  }

  public Color getFixedAllColor() {
    return new Color(GDXJNI.RibbonAllColorParameterCore_getFixedAllColor(swigCPtr, this), true);
  }

  public void setFixedAllColor(Color value) {
    GDXJNI.RibbonAllColorParameterCore_setFixedAllColor(swigCPtr, this, Color.getCPtr(value), value);
  }

  public InternalStructRandomColor getRandomAllColor() {
    return new InternalStructRandomColor(GDXJNI.RibbonAllColorParameterCore_getRandomAllColor(swigCPtr, this), true);
  }

  public void setRandomAllColor(InternalStructRandomColor value) {
    GDXJNI.RibbonAllColorParameterCore_setRandomAllColor(swigCPtr, this, InternalStructRandomColor.getCPtr(value), value);
  }

  public InternalStructEasingColor getEasingAllColor() {
    return new InternalStructEasingColor(GDXJNI.RibbonAllColorParameterCore_getEasingAllColor(swigCPtr, this), true);
  }

  public void setEasingAllColor(InternalStructEasingColor value) {
    GDXJNI.RibbonAllColorParameterCore_setEasingAllColor(swigCPtr, this, InternalStructEasingColor.getCPtr(value), value);
  }

  public RibbonAllColorParameterCore() {
    this(GDXJNI.new_RibbonAllColorParameterCore(), true);
  }

  public final static int Fixed = GDXJNI.RibbonAllColorParameterCore_Fixed_get();
  public final static int Random = GDXJNI.RibbonAllColorParameterCore_Random_get();
  public final static int Easing = GDXJNI.RibbonAllColorParameterCore_Easing_get();
  public final static int Parameter_DWORD = GDXJNI.RibbonAllColorParameterCore_Parameter_DWORD_get();

}
