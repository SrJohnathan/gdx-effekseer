/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class ParameterGenerationLocation {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ParameterGenerationLocation(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ParameterGenerationLocation obj) {
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
        GDXJNI.delete_ParameterGenerationLocation(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setEffectsRotation(int value) {
    GDXJNI.ParameterGenerationLocation_EffectsRotation_set(swigCPtr, this, value);
  }

  public int getEffectsRotation() {
    return GDXJNI.ParameterGenerationLocation_EffectsRotation_get(swigCPtr, this);
  }

  public void setType(int value) {
    GDXJNI.ParameterGenerationLocation_type_set(swigCPtr, this, value);
  }

  public int getType() {
    return GDXJNI.ParameterGenerationLocation_type_get(swigCPtr, this);
  }

  public ParameterGenerationLocation() {
    this(GDXJNI.new_ParameterGenerationLocation(), true);
  }

  public final static class AxisType {
    public final static ParameterGenerationLocation.AxisType X = new ParameterGenerationLocation.AxisType("X");
    public final static ParameterGenerationLocation.AxisType Y = new ParameterGenerationLocation.AxisType("Y");
    public final static ParameterGenerationLocation.AxisType Z = new ParameterGenerationLocation.AxisType("Z");

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static AxisType swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + AxisType.class + " with value " + swigValue);
    }

    private AxisType(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private AxisType(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private AxisType(String swigName, AxisType swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static AxisType[] swigValues = { X, Y, Z };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

  public final static int TYPE_POINT = GDXJNI.ParameterGenerationLocation_TYPE_POINT_get();
  public final static int TYPE_SPHERE = GDXJNI.ParameterGenerationLocation_TYPE_SPHERE_get();
  public final static int TYPE_MODEL = GDXJNI.ParameterGenerationLocation_TYPE_MODEL_get();
  public final static int TYPE_CIRCLE = GDXJNI.ParameterGenerationLocation_TYPE_CIRCLE_get();
  public final static int TYPE_LINE = GDXJNI.ParameterGenerationLocation_TYPE_LINE_get();
  public final static int TYPE_DWORD = GDXJNI.ParameterGenerationLocation_TYPE_DWORD_get();

  public final static class eModelType {
    public final static ParameterGenerationLocation.eModelType MODELTYPE_RANDOM = new ParameterGenerationLocation.eModelType("MODELTYPE_RANDOM", GDXJNI.ParameterGenerationLocation_MODELTYPE_RANDOM_get());
    public final static ParameterGenerationLocation.eModelType MODELTYPE_VERTEX = new ParameterGenerationLocation.eModelType("MODELTYPE_VERTEX", GDXJNI.ParameterGenerationLocation_MODELTYPE_VERTEX_get());
    public final static ParameterGenerationLocation.eModelType MODELTYPE_VERTEX_RANDOM = new ParameterGenerationLocation.eModelType("MODELTYPE_VERTEX_RANDOM", GDXJNI.ParameterGenerationLocation_MODELTYPE_VERTEX_RANDOM_get());
    public final static ParameterGenerationLocation.eModelType MODELTYPE_FACE = new ParameterGenerationLocation.eModelType("MODELTYPE_FACE", GDXJNI.ParameterGenerationLocation_MODELTYPE_FACE_get());
    public final static ParameterGenerationLocation.eModelType MODELTYPE_FACE_RANDOM = new ParameterGenerationLocation.eModelType("MODELTYPE_FACE_RANDOM", GDXJNI.ParameterGenerationLocation_MODELTYPE_FACE_RANDOM_get());
    public final static ParameterGenerationLocation.eModelType MODELTYPE_DWORD = new ParameterGenerationLocation.eModelType("MODELTYPE_DWORD", GDXJNI.ParameterGenerationLocation_MODELTYPE_DWORD_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static eModelType swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + eModelType.class + " with value " + swigValue);
    }

    private eModelType(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private eModelType(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private eModelType(String swigName, eModelType swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static eModelType[] swigValues = { MODELTYPE_RANDOM, MODELTYPE_VERTEX, MODELTYPE_VERTEX_RANDOM, MODELTYPE_FACE, MODELTYPE_FACE_RANDOM, MODELTYPE_DWORD };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

  public final static class eCircleType {
    public final static ParameterGenerationLocation.eCircleType CIRCLE_TYPE_RANDOM = new ParameterGenerationLocation.eCircleType("CIRCLE_TYPE_RANDOM", GDXJNI.ParameterGenerationLocation_CIRCLE_TYPE_RANDOM_get());
    public final static ParameterGenerationLocation.eCircleType CIRCLE_TYPE_ORDER = new ParameterGenerationLocation.eCircleType("CIRCLE_TYPE_ORDER", GDXJNI.ParameterGenerationLocation_CIRCLE_TYPE_ORDER_get());
    public final static ParameterGenerationLocation.eCircleType CIRCLE_TYPE_REVERSE_ORDER = new ParameterGenerationLocation.eCircleType("CIRCLE_TYPE_REVERSE_ORDER", GDXJNI.ParameterGenerationLocation_CIRCLE_TYPE_REVERSE_ORDER_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static eCircleType swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + eCircleType.class + " with value " + swigValue);
    }

    private eCircleType(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private eCircleType(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private eCircleType(String swigName, eCircleType swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static eCircleType[] swigValues = { CIRCLE_TYPE_RANDOM, CIRCLE_TYPE_ORDER, CIRCLE_TYPE_REVERSE_ORDER };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

  public final static class LineType {
    public final static ParameterGenerationLocation.LineType Random = new ParameterGenerationLocation.LineType("Random", GDXJNI.ParameterGenerationLocation_LineType_Random_get());
    public final static ParameterGenerationLocation.LineType Order = new ParameterGenerationLocation.LineType("Order", GDXJNI.ParameterGenerationLocation_LineType_Order_get());

    public final int swigValue() {
      return swigValue;
    }

    public String toString() {
      return swigName;
    }

    public static LineType swigToEnum(int swigValue) {
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (int i = 0; i < swigValues.length; i++)
        if (swigValues[i].swigValue == swigValue)
          return swigValues[i];
      throw new IllegalArgumentException("No enum " + LineType.class + " with value " + swigValue);
    }

    private LineType(String swigName) {
      this.swigName = swigName;
      this.swigValue = swigNext++;
    }

    private LineType(String swigName, int swigValue) {
      this.swigName = swigName;
      this.swigValue = swigValue;
      swigNext = swigValue+1;
    }

    private LineType(String swigName, LineType swigEnum) {
      this.swigName = swigName;
      this.swigValue = swigEnum.swigValue;
      swigNext = this.swigValue+1;
    }

    private static LineType[] swigValues = { Random, Order };
    private static int swigNext = 0;
    private final int swigValue;
    private final String swigName;
  }

}