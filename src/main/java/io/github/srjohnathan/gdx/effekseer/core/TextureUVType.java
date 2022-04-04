/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public final class TextureUVType {
  public final static TextureUVType Strech = new TextureUVType("Strech");
  public final static TextureUVType Tile = new TextureUVType("Tile");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static TextureUVType swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + TextureUVType.class + " with value " + swigValue);
  }

  private TextureUVType(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private TextureUVType(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private TextureUVType(String swigName, TextureUVType swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static TextureUVType[] swigValues = { Strech, Tile };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

