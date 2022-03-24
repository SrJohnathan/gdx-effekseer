/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class FalloffParameter {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected FalloffParameter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(FalloffParameter obj) {
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
        GDXJNI.delete_FalloffParameter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setColorBlendType(FalloffParameter.BlendType value) {
    GDXJNI.FalloffParameter_ColorBlendType_set(swigCPtr, this, value.swigValue());
  }

  public FalloffParameter.BlendType getColorBlendType() {
    return FalloffParameter.BlendType.swigToEnum(GDXJNI.FalloffParameter_ColorBlendType_get(swigCPtr, this));
  }

  public void setBeginColor(Color value) {
    GDXJNI.FalloffParameter_BeginColor_set(swigCPtr, this, Color.getCPtr(value), value);
  }

  public Color getBeginColor() {
    long cPtr = GDXJNI.FalloffParameter_BeginColor_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Color(cPtr, false);
  }

  public void setEndColor(Color value) {
    GDXJNI.FalloffParameter_EndColor_set(swigCPtr, this, Color.getCPtr(value), value);
  }

  public Color getEndColor() {
    long cPtr = GDXJNI.FalloffParameter_EndColor_get(swigCPtr, this);
    return (cPtr == 0) ? null : new Color(cPtr, false);
  }

  public void setPow(float value) {
    GDXJNI.FalloffParameter_Pow_set(swigCPtr, this, value);
  }

  public float getPow() {
    return GDXJNI.FalloffParameter_Pow_get(swigCPtr, this);
  }

  public FalloffParameter() {
    this(GDXJNI.new_FalloffParameter(), true);
  }

  public final static class BlendType {
    public final static FalloffParameter.BlendType Add = new FalloffParameter.BlendType("Add", GDXJNI.FalloffParameter_Add_get());
    public final static FalloffParameter.BlendType Sub = new FalloffParameter.BlendType("Sub", GDXJNI.FalloffParameter_Sub_get());
    public final static FalloffParameter.BlendType Mul = new FalloffParameter.BlendType("Mul", GDXJNI.FalloffParameter_Mul_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static BlendType swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + BlendType.class + " with value " + swigValue);
    }

    private BlendType(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private BlendType(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private BlendType(String swigName, BlendType swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static BlendType[] swigValues = { Add, Sub, Mul };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}