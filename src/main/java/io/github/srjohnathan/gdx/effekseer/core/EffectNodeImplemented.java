/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class EffectNodeImplemented extends EffectNode {
  private transient long swigCPtr;

  protected EffectNodeImplemented(long cPtr, boolean cMemoryOwn) {
    super(GDXJNI.EffectNodeImplemented_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(EffectNodeImplemented obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        throw new UnsupportedOperationException("C++ destructor does not have public access");
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public void setIsRendered(boolean value) {
    GDXJNI.EffectNodeImplemented_IsRendered_set(swigCPtr, this, value);
  }

  public boolean getIsRendered() {
    return GDXJNI.EffectNodeImplemented_IsRendered_get(swigCPtr, this);
  }

  public void setCommonValues(ParameterCommonValues value) {
    GDXJNI.EffectNodeImplemented_CommonValues_set(swigCPtr, this, ParameterCommonValues.getCPtr(value), value);
  }

  public ParameterCommonValues getCommonValues() {
    long cPtr = GDXJNI.EffectNodeImplemented_CommonValues_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterCommonValues(cPtr, false);
  }

  public void setSteeringBehaviorParam(SteeringBehaviorParameter value) {
    GDXJNI.EffectNodeImplemented_SteeringBehaviorParam_set(swigCPtr, this, SteeringBehaviorParameter.getCPtr(value), value);
  }

  public SteeringBehaviorParameter getSteeringBehaviorParam() {
    long cPtr = GDXJNI.EffectNodeImplemented_SteeringBehaviorParam_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SteeringBehaviorParameter(cPtr, false);
  }

  public void setTranslationType(ParameterTranslationType value) {
    GDXJNI.EffectNodeImplemented_TranslationType_set(swigCPtr, this, value.swigValue());
  }

  public ParameterTranslationType getTranslationType() {
    return ParameterTranslationType.swigToEnum(GDXJNI.EffectNodeImplemented_TranslationType_get(swigCPtr, this));
  }

  public void setTranslationFixed(ParameterTranslationFixed value) {
    GDXJNI.EffectNodeImplemented_TranslationFixed_set(swigCPtr, this, ParameterTranslationFixed.getCPtr(value), value);
  }

  public ParameterTranslationFixed getTranslationFixed() {
    long cPtr = GDXJNI.EffectNodeImplemented_TranslationFixed_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterTranslationFixed(cPtr, false);
  }

  public void setTranslationPVA(ParameterTranslationPVA value) {
    GDXJNI.EffectNodeImplemented_TranslationPVA_set(swigCPtr, this, ParameterTranslationPVA.getCPtr(value), value);
  }

  public ParameterTranslationPVA getTranslationPVA() {
    long cPtr = GDXJNI.EffectNodeImplemented_TranslationPVA_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterTranslationPVA(cPtr, false);
  }

  public void setTranslationEasing(ParameterEasingSIMDVec3 value) {
    GDXJNI.EffectNodeImplemented_TranslationEasing_set(swigCPtr, this, ParameterEasingSIMDVec3.getCPtr(value), value);
  }

  public ParameterEasingSIMDVec3 getTranslationEasing() {
    long cPtr = GDXJNI.EffectNodeImplemented_TranslationEasing_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterEasingSIMDVec3(cPtr, false);
  }

  public void setTranslationFCurve(FCurveVector3D value) {
    GDXJNI.EffectNodeImplemented_TranslationFCurve_set(swigCPtr, this, FCurveVector3D.getCPtr(value), value);
  }

  public FCurveVector3D getTranslationFCurve() {
    long cPtr = GDXJNI.EffectNodeImplemented_TranslationFCurve_get(swigCPtr, this);
    return (cPtr == 0) ? null : new FCurveVector3D(cPtr, false);
  }

  public void setTranslationNurbsCurve(ParameterTranslationNurbsCurve value) {
    GDXJNI.EffectNodeImplemented_TranslationNurbsCurve_set(swigCPtr, this, ParameterTranslationNurbsCurve.getCPtr(value), value);
  }

  public ParameterTranslationNurbsCurve getTranslationNurbsCurve() {
    long cPtr = GDXJNI.EffectNodeImplemented_TranslationNurbsCurve_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterTranslationNurbsCurve(cPtr, false);
  }

  public void setTranslationViewOffset(ParameterTranslationViewOffset value) {
    GDXJNI.EffectNodeImplemented_TranslationViewOffset_set(swigCPtr, this, ParameterTranslationViewOffset.getCPtr(value), value);
  }

  public ParameterTranslationViewOffset getTranslationViewOffset() {
    long cPtr = GDXJNI.EffectNodeImplemented_TranslationViewOffset_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterTranslationViewOffset(cPtr, false);
  }

  public void setRotationType(ParameterRotationType value) {
    GDXJNI.EffectNodeImplemented_RotationType_set(swigCPtr, this, value.swigValue());
  }

  public ParameterRotationType getRotationType() {
    return ParameterRotationType.swigToEnum(GDXJNI.EffectNodeImplemented_RotationType_get(swigCPtr, this));
  }

  public void setRotationFixed(ParameterRotationFixed value) {
    GDXJNI.EffectNodeImplemented_RotationFixed_set(swigCPtr, this, ParameterRotationFixed.getCPtr(value), value);
  }

  public ParameterRotationFixed getRotationFixed() {
    long cPtr = GDXJNI.EffectNodeImplemented_RotationFixed_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterRotationFixed(cPtr, false);
  }

  public void setRotationPVA(ParameterRotationPVA value) {
    GDXJNI.EffectNodeImplemented_RotationPVA_set(swigCPtr, this, ParameterRotationPVA.getCPtr(value), value);
  }

  public ParameterRotationPVA getRotationPVA() {
    long cPtr = GDXJNI.EffectNodeImplemented_RotationPVA_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterRotationPVA(cPtr, false);
  }

  public void setRotationEasing(ParameterEasingSIMDVec3 value) {
    GDXJNI.EffectNodeImplemented_RotationEasing_set(swigCPtr, this, ParameterEasingSIMDVec3.getCPtr(value), value);
  }

  public ParameterEasingSIMDVec3 getRotationEasing() {
    long cPtr = GDXJNI.EffectNodeImplemented_RotationEasing_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterEasingSIMDVec3(cPtr, false);
  }

  public void setRotationFCurve(FCurveVector3D value) {
    GDXJNI.EffectNodeImplemented_RotationFCurve_set(swigCPtr, this, FCurveVector3D.getCPtr(value), value);
  }

  public FCurveVector3D getRotationFCurve() {
    long cPtr = GDXJNI.EffectNodeImplemented_RotationFCurve_get(swigCPtr, this);
    return (cPtr == 0) ? null : new FCurveVector3D(cPtr, false);
  }

  public void setRotationAxisPVA(ParameterRotationAxisPVA value) {
    GDXJNI.EffectNodeImplemented_RotationAxisPVA_set(swigCPtr, this, ParameterRotationAxisPVA.getCPtr(value), value);
  }

  public ParameterRotationAxisPVA getRotationAxisPVA() {
    long cPtr = GDXJNI.EffectNodeImplemented_RotationAxisPVA_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterRotationAxisPVA(cPtr, false);
  }

  public void setRotationAxisEasing(ParameterRotationAxisEasing value) {
    GDXJNI.EffectNodeImplemented_RotationAxisEasing_set(swigCPtr, this, ParameterRotationAxisEasing.getCPtr(value), value);
  }

  public ParameterRotationAxisEasing getRotationAxisEasing() {
    long cPtr = GDXJNI.EffectNodeImplemented_RotationAxisEasing_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterRotationAxisEasing(cPtr, false);
  }

  public void setScalingType(ParameterScalingType value) {
    GDXJNI.EffectNodeImplemented_ScalingType_set(swigCPtr, this, value.swigValue());
  }

  public ParameterScalingType getScalingType() {
    return ParameterScalingType.swigToEnum(GDXJNI.EffectNodeImplemented_ScalingType_get(swigCPtr, this));
  }

  public void setScalingFixed(ParameterScalingFixed value) {
    GDXJNI.EffectNodeImplemented_ScalingFixed_set(swigCPtr, this, ParameterScalingFixed.getCPtr(value), value);
  }

  public ParameterScalingFixed getScalingFixed() {
    long cPtr = GDXJNI.EffectNodeImplemented_ScalingFixed_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterScalingFixed(cPtr, false);
  }

  public void setScalingPVA(ParameterScalingPVA value) {
    GDXJNI.EffectNodeImplemented_ScalingPVA_set(swigCPtr, this, ParameterScalingPVA.getCPtr(value), value);
  }

  public ParameterScalingPVA getScalingPVA() {
    long cPtr = GDXJNI.EffectNodeImplemented_ScalingPVA_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterScalingPVA(cPtr, false);
  }

  public void setScalingEasing(ParameterEasingSIMDVec3 value) {
    GDXJNI.EffectNodeImplemented_ScalingEasing_set(swigCPtr, this, ParameterEasingSIMDVec3.getCPtr(value), value);
  }

  public ParameterEasingSIMDVec3 getScalingEasing() {
    long cPtr = GDXJNI.EffectNodeImplemented_ScalingEasing_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterEasingSIMDVec3(cPtr, false);
  }

  public void setScalingSinglePVA(ParameterScalingSinglePVA value) {
    GDXJNI.EffectNodeImplemented_ScalingSinglePVA_set(swigCPtr, this, ParameterScalingSinglePVA.getCPtr(value), value);
  }

  public ParameterScalingSinglePVA getScalingSinglePVA() {
    long cPtr = GDXJNI.EffectNodeImplemented_ScalingSinglePVA_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterScalingSinglePVA(cPtr, false);
  }

  public void setScalingSingleEasing(ParameterEasingFloat value) {
    GDXJNI.EffectNodeImplemented_ScalingSingleEasing_set(swigCPtr, this, ParameterEasingFloat.getCPtr(value), value);
  }

  public ParameterEasingFloat getScalingSingleEasing() {
    long cPtr = GDXJNI.EffectNodeImplemented_ScalingSingleEasing_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterEasingFloat(cPtr, false);
  }

  public void setScalingFCurve(FCurveVector3D value) {
    GDXJNI.EffectNodeImplemented_ScalingFCurve_set(swigCPtr, this, FCurveVector3D.getCPtr(value), value);
  }

  public FCurveVector3D getScalingFCurve() {
    long cPtr = GDXJNI.EffectNodeImplemented_ScalingFCurve_get(swigCPtr, this);
    return (cPtr == 0) ? null : new FCurveVector3D(cPtr, false);
  }

  public void setScalingSingleFCurve(FCurveScalar value) {
    GDXJNI.EffectNodeImplemented_ScalingSingleFCurve_set(swigCPtr, this, FCurveScalar.getCPtr(value), value);
  }

  public FCurveScalar getScalingSingleFCurve() {
    long cPtr = GDXJNI.EffectNodeImplemented_ScalingSingleFCurve_get(swigCPtr, this);
    return (cPtr == 0) ? null : new FCurveScalar(cPtr, false);
  }

  public void setGenerationLocation(ParameterGenerationLocation value) {
    GDXJNI.EffectNodeImplemented_GenerationLocation_set(swigCPtr, this, ParameterGenerationLocation.getCPtr(value), value);
  }

  public ParameterGenerationLocation getGenerationLocation() {
    long cPtr = GDXJNI.EffectNodeImplemented_GenerationLocation_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterGenerationLocation(cPtr, false);
  }

  public void setDepthValues(ParameterDepthValues value) {
    GDXJNI.EffectNodeImplemented_DepthValues_set(swigCPtr, this, ParameterDepthValues.getCPtr(value), value);
  }

  public ParameterDepthValues getDepthValues() {
    long cPtr = GDXJNI.EffectNodeImplemented_DepthValues_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterDepthValues(cPtr, false);
  }

  public void setRendererCommon(ParameterRendererCommon value) {
    GDXJNI.EffectNodeImplemented_RendererCommon_set(swigCPtr, this, ParameterRendererCommon.getCPtr(value), value);
  }

  public ParameterRendererCommon getRendererCommon() {
    long cPtr = GDXJNI.EffectNodeImplemented_RendererCommon_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterRendererCommon(cPtr, false);
  }

  public void setAlphaCutoff(ParameterAlphaCutoff value) {
    GDXJNI.EffectNodeImplemented_AlphaCutoff_set(swigCPtr, this, ParameterAlphaCutoff.getCPtr(value), value);
  }

  public ParameterAlphaCutoff getAlphaCutoff() {
    long cPtr = GDXJNI.EffectNodeImplemented_AlphaCutoff_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterAlphaCutoff(cPtr, false);
  }

  public void setEnableFalloff(boolean value) {
    GDXJNI.EffectNodeImplemented_EnableFalloff_set(swigCPtr, this, value);
  }

  public boolean getEnableFalloff() {
    return GDXJNI.EffectNodeImplemented_EnableFalloff_get(swigCPtr, this);
  }

  public void setFalloffParam(FalloffParameter value) {
    GDXJNI.EffectNodeImplemented_FalloffParam_set(swigCPtr, this, FalloffParameter.getCPtr(value), value);
  }

  public FalloffParameter getFalloffParam() {
    long cPtr = GDXJNI.EffectNodeImplemented_FalloffParam_get(swigCPtr, this);
    return (cPtr == 0) ? null : new FalloffParameter(cPtr, false);
  }

  public void setSoundType(ParameterSoundType value) {
    GDXJNI.EffectNodeImplemented_SoundType_set(swigCPtr, this, value.swigValue());
  }

  public ParameterSoundType getSoundType() {
    return ParameterSoundType.swigToEnum(GDXJNI.EffectNodeImplemented_SoundType_get(swigCPtr, this));
  }

  public void setSound(ParameterSound value) {
    GDXJNI.EffectNodeImplemented_Sound_set(swigCPtr, this, ParameterSound.getCPtr(value), value);
  }

  public ParameterSound getSound() {
    long cPtr = GDXJNI.EffectNodeImplemented_Sound_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterSound(cPtr, false);
  }

  public void setRenderingOrder(eRenderingOrder value) {
    GDXJNI.EffectNodeImplemented_RenderingOrder_set(swigCPtr, this, value.swigValue());
  }

  public eRenderingOrder getRenderingOrder() {
    return eRenderingOrder.swigToEnum(GDXJNI.EffectNodeImplemented_RenderingOrder_get(swigCPtr, this));
  }

  public void setRenderingPriority(int value) {
    GDXJNI.EffectNodeImplemented_RenderingPriority_set(swigCPtr, this, value);
  }

  public int getRenderingPriority() {
    return GDXJNI.EffectNodeImplemented_RenderingPriority_get(swigCPtr, this);
  }

  public void setDynamicFactor(DynamicFactorParameter value) {
    GDXJNI.EffectNodeImplemented_DynamicFactor_set(swigCPtr, this, DynamicFactorParameter.getCPtr(value), value);
  }

  public DynamicFactorParameter getDynamicFactor() {
    long cPtr = GDXJNI.EffectNodeImplemented_DynamicFactor_get(swigCPtr, this);
    return (cPtr == 0) ? null : new DynamicFactorParameter(cPtr, false);
  }

}
