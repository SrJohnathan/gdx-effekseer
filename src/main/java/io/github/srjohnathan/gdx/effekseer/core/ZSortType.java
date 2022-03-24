/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public final class ZSortType {
  public final static ZSortType None = new ZSortType("None");
  public final static ZSortType NormalOrder = new ZSortType("NormalOrder");
  public final static ZSortType ReverseOrder = new ZSortType("ReverseOrder");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static ZSortType swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + ZSortType.class + " with value " + swigValue);
  }

  private ZSortType(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private ZSortType(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private ZSortType(String swigName, ZSortType swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static ZSortType[] swigValues = { None, NormalOrder, ReverseOrder };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

