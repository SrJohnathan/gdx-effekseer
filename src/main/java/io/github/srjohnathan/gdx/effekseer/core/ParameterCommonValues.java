/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class ParameterCommonValues {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ParameterCommonValues(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ParameterCommonValues obj) {
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
        GDXJNI.delete_ParameterCommonValues(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setRefEqMaxGeneration(int value) {
    GDXJNI.ParameterCommonValues_RefEqMaxGeneration_set(swigCPtr, this, value);
  }

  public int getRefEqMaxGeneration() {
    return GDXJNI.ParameterCommonValues_RefEqMaxGeneration_get(swigCPtr, this);
  }

  public void setRefEqLife(RefMinMax value) {
    GDXJNI.ParameterCommonValues_RefEqLife_set(swigCPtr, this, RefMinMax.getCPtr(value), value);
  }

  public RefMinMax getRefEqLife() {
    long cPtr = GDXJNI.ParameterCommonValues_RefEqLife_get(swigCPtr, this);
    return (cPtr == 0) ? null : new RefMinMax(cPtr, false);
  }

  public void setRefEqGenerationTime(RefMinMax value) {
    GDXJNI.ParameterCommonValues_RefEqGenerationTime_set(swigCPtr, this, RefMinMax.getCPtr(value), value);
  }

  public RefMinMax getRefEqGenerationTime() {
    long cPtr = GDXJNI.ParameterCommonValues_RefEqGenerationTime_get(swigCPtr, this);
    return (cPtr == 0) ? null : new RefMinMax(cPtr, false);
  }

  public void setRefEqGenerationTimeOffset(RefMinMax value) {
    GDXJNI.ParameterCommonValues_RefEqGenerationTimeOffset_set(swigCPtr, this, RefMinMax.getCPtr(value), value);
  }

  public RefMinMax getRefEqGenerationTimeOffset() {
    long cPtr = GDXJNI.ParameterCommonValues_RefEqGenerationTimeOffset_get(swigCPtr, this);
    return (cPtr == 0) ? null : new RefMinMax(cPtr, false);
  }

  public void setMaxGeneration(int value) {
    GDXJNI.ParameterCommonValues_MaxGeneration_set(swigCPtr, this, value);
  }

  public int getMaxGeneration() {
    return GDXJNI.ParameterCommonValues_MaxGeneration_get(swigCPtr, this);
  }

  public void setTranslationBindType(TranslationParentBindType value) {
    GDXJNI.ParameterCommonValues_TranslationBindType_set(swigCPtr, this, value.swigValue());
  }

  public TranslationParentBindType getTranslationBindType() {
    return TranslationParentBindType.swigToEnum(GDXJNI.ParameterCommonValues_TranslationBindType_get(swigCPtr, this));
  }

  public void setRotationBindType(BindType value) {
    GDXJNI.ParameterCommonValues_RotationBindType_set(swigCPtr, this, value.swigValue());
  }

  public BindType getRotationBindType() {
    return BindType.swigToEnum(GDXJNI.ParameterCommonValues_RotationBindType_get(swigCPtr, this));
  }

  public void setScalingBindType(BindType value) {
    GDXJNI.ParameterCommonValues_ScalingBindType_set(swigCPtr, this, value.swigValue());
  }

  public BindType getScalingBindType() {
    return BindType.swigToEnum(GDXJNI.ParameterCommonValues_ScalingBindType_get(swigCPtr, this));
  }

  public void setRemoveWhenLifeIsExtinct(int value) {
    GDXJNI.ParameterCommonValues_RemoveWhenLifeIsExtinct_set(swigCPtr, this, value);
  }

  public int getRemoveWhenLifeIsExtinct() {
    return GDXJNI.ParameterCommonValues_RemoveWhenLifeIsExtinct_get(swigCPtr, this);
  }

  public void setRemoveWhenParentIsRemoved(int value) {
    GDXJNI.ParameterCommonValues_RemoveWhenParentIsRemoved_set(swigCPtr, this, value);
  }

  public int getRemoveWhenParentIsRemoved() {
    return GDXJNI.ParameterCommonValues_RemoveWhenParentIsRemoved_get(swigCPtr, this);
  }

  public void setRemoveWhenChildrenIsExtinct(int value) {
    GDXJNI.ParameterCommonValues_RemoveWhenChildrenIsExtinct_set(swigCPtr, this, value);
  }

  public int getRemoveWhenChildrenIsExtinct() {
    return GDXJNI.ParameterCommonValues_RemoveWhenChildrenIsExtinct_get(swigCPtr, this);
  }

  public void setLife(InternalStructRandomInt value) {
    GDXJNI.ParameterCommonValues_life_set(swigCPtr, this, InternalStructRandomInt.getCPtr(value), value);
  }

  public InternalStructRandomInt getLife() {
    long cPtr = GDXJNI.ParameterCommonValues_life_get(swigCPtr, this);
    return (cPtr == 0) ? null : new InternalStructRandomInt(cPtr, false);
  }

  public void setGenerationTime(InternalStructRandomFloat value) {
    GDXJNI.ParameterCommonValues_GenerationTime_set(swigCPtr, this, InternalStructRandomFloat.getCPtr(value), value);
  }

  public InternalStructRandomFloat getGenerationTime() {
    long cPtr = GDXJNI.ParameterCommonValues_GenerationTime_get(swigCPtr, this);
    return (cPtr == 0) ? null : new InternalStructRandomFloat(cPtr, false);
  }

  public void setGenerationTimeOffset(InternalStructRandomFloat value) {
    GDXJNI.ParameterCommonValues_GenerationTimeOffset_set(swigCPtr, this, InternalStructRandomFloat.getCPtr(value), value);
  }

  public InternalStructRandomFloat getGenerationTimeOffset() {
    long cPtr = GDXJNI.ParameterCommonValues_GenerationTimeOffset_get(swigCPtr, this);
    return (cPtr == 0) ? null : new InternalStructRandomFloat(cPtr, false);
  }

  public ParameterCommonValues() {
    this(GDXJNI.new_ParameterCommonValues(), true);
  }

}
