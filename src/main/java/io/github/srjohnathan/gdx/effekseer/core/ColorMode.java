/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public final class ColorMode {
  public final static ColorMode COLOR_MODE_RGBA = new ColorMode("COLOR_MODE_RGBA");
  public final static ColorMode COLOR_MODE_HSVA = new ColorMode("COLOR_MODE_HSVA");
  public final static ColorMode COLOR_MODE_DWORD = new ColorMode("COLOR_MODE_DWORD", GDXJNI.COLOR_MODE_DWORD_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static ColorMode swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + ColorMode.class + " with value " + swigValue);
  }

  private ColorMode(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private ColorMode(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private ColorMode(String swigName, ColorMode swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static ColorMode[] swigValues = { COLOR_MODE_RGBA, COLOR_MODE_HSVA, COLOR_MODE_DWORD };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

