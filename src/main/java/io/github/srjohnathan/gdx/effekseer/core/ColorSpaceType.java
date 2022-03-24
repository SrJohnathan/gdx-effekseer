/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public final class ColorSpaceType {
  public final static ColorSpaceType Gamma = new ColorSpaceType("Gamma");
  public final static ColorSpaceType Linear = new ColorSpaceType("Linear");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static ColorSpaceType swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + ColorSpaceType.class + " with value " + swigValue);
  }

  private ColorSpaceType(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private ColorSpaceType(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private ColorSpaceType(String swigName, ColorSpaceType swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static ColorSpaceType[] swigValues = { Gamma, Linear };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}
