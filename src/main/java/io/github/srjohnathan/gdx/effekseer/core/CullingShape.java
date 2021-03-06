/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public final class CullingShape {
  public final static CullingShape NoneShape = new CullingShape("NoneShape", GDXJNI.CullingShape_NoneShape_get());
  public final static CullingShape Sphere = new CullingShape("Sphere", GDXJNI.CullingShape_Sphere_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static CullingShape swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + CullingShape.class + " with value " + swigValue);
  }

  private CullingShape(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private CullingShape(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private CullingShape(String swigName, CullingShape swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static CullingShape[] swigValues = { NoneShape, Sphere };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

