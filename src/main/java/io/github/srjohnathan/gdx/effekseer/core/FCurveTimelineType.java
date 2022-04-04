/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public final class FCurveTimelineType {
  public final static FCurveTimelineType Time = new FCurveTimelineType("Time", GDXJNI.FCurveTimelineType_Time_get());
  public final static FCurveTimelineType Percent = new FCurveTimelineType("Percent", GDXJNI.FCurveTimelineType_Percent_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static FCurveTimelineType swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + FCurveTimelineType.class + " with value " + swigValue);
  }

  private FCurveTimelineType(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private FCurveTimelineType(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private FCurveTimelineType(String swigName, FCurveTimelineType swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static FCurveTimelineType[] swigValues = { Time, Percent };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

