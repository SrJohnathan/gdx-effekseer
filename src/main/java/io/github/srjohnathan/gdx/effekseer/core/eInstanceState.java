/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public final class eInstanceState {
  public final static eInstanceState INSTANCE_STATE_ACTIVE = new eInstanceState("INSTANCE_STATE_ACTIVE");
  public final static eInstanceState INSTANCE_STATE_REMOVING = new eInstanceState("INSTANCE_STATE_REMOVING");
  public final static eInstanceState INSTANCE_STATE_REMOVED = new eInstanceState("INSTANCE_STATE_REMOVED");
  public final static eInstanceState INSTANCE_STATE_DWORD = new eInstanceState("INSTANCE_STATE_DWORD", GDXJNI.INSTANCE_STATE_DWORD_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static eInstanceState swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + eInstanceState.class + " with value " + swigValue);
  }

  private eInstanceState(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private eInstanceState(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private eInstanceState(String swigName, eInstanceState swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static eInstanceState[] swigValues = { INSTANCE_STATE_ACTIVE, INSTANCE_STATE_REMOVING, INSTANCE_STATE_REMOVED, INSTANCE_STATE_DWORD };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

