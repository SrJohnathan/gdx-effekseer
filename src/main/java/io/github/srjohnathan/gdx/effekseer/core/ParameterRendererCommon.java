/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class ParameterRendererCommon {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected ParameterRendererCommon(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(ParameterRendererCommon obj) {
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
        GDXJNI.delete_ParameterRendererCommon(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setMaterialType(RendererMaterialType value) {
    GDXJNI.ParameterRendererCommon_MaterialType_set(swigCPtr, this, value.swigValue());
  }

  public RendererMaterialType getMaterialType() {
    return RendererMaterialType.swigToEnum(GDXJNI.ParameterRendererCommon_MaterialType_get(swigCPtr, this));
  }

  public void setColorTextureIndex(int value) {
    GDXJNI.ParameterRendererCommon_ColorTextureIndex_set(swigCPtr, this, value);
  }

  public int getColorTextureIndex() {
    return GDXJNI.ParameterRendererCommon_ColorTextureIndex_get(swigCPtr, this);
  }

  public void setTexture2Index(int value) {
    GDXJNI.ParameterRendererCommon_Texture2Index_set(swigCPtr, this, value);
  }

  public int getTexture2Index() {
    return GDXJNI.ParameterRendererCommon_Texture2Index_get(swigCPtr, this);
  }

  public void setAlphaTextureIndex(int value) {
    GDXJNI.ParameterRendererCommon_AlphaTextureIndex_set(swigCPtr, this, value);
  }

  public int getAlphaTextureIndex() {
    return GDXJNI.ParameterRendererCommon_AlphaTextureIndex_get(swigCPtr, this);
  }

  public void setUVDistortionTextureIndex(int value) {
    GDXJNI.ParameterRendererCommon_UVDistortionTextureIndex_set(swigCPtr, this, value);
  }

  public int getUVDistortionTextureIndex() {
    return GDXJNI.ParameterRendererCommon_UVDistortionTextureIndex_get(swigCPtr, this);
  }

  public void setBlendTextureIndex(int value) {
    GDXJNI.ParameterRendererCommon_BlendTextureIndex_set(swigCPtr, this, value);
  }

  public int getBlendTextureIndex() {
    return GDXJNI.ParameterRendererCommon_BlendTextureIndex_get(swigCPtr, this);
  }

  public void setBlendAlphaTextureIndex(int value) {
    GDXJNI.ParameterRendererCommon_BlendAlphaTextureIndex_set(swigCPtr, this, value);
  }

  public int getBlendAlphaTextureIndex() {
    return GDXJNI.ParameterRendererCommon_BlendAlphaTextureIndex_get(swigCPtr, this);
  }

  public void setBlendUVDistortionTextureIndex(int value) {
    GDXJNI.ParameterRendererCommon_BlendUVDistortionTextureIndex_set(swigCPtr, this, value);
  }

  public int getBlendUVDistortionTextureIndex() {
    return GDXJNI.ParameterRendererCommon_BlendUVDistortionTextureIndex_get(swigCPtr, this);
  }

  public void setMaterialData(MaterialRenderData value) {
    GDXJNI.ParameterRendererCommon_MaterialData_set(swigCPtr, this, MaterialRenderData.getCPtr(value), value);
  }

  public MaterialRenderData getMaterialData() {
    long cPtr = GDXJNI.ParameterRendererCommon_MaterialData_get(swigCPtr, this);
    return (cPtr == 0) ? null : new MaterialRenderData(cPtr, false);
  }

  public void setAlphaBlend(AlphaBlendType value) {
    GDXJNI.ParameterRendererCommon_AlphaBlend_set(swigCPtr, this, value.swigValue());
  }

  public AlphaBlendType getAlphaBlend() {
    return AlphaBlendType.swigToEnum(GDXJNI.ParameterRendererCommon_AlphaBlend_get(swigCPtr, this));
  }

  public void setFilterTypes(ArrayTextureFilters value) {
    GDXJNI.ParameterRendererCommon_FilterTypes_set(swigCPtr, this, ArrayTextureFilters.getCPtr(value), value);
  }

  public ArrayTextureFilters getFilterTypes() {
    long cPtr = GDXJNI.ParameterRendererCommon_FilterTypes_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ArrayTextureFilters(cPtr, false);
  }

  public void setWrapTypes(ArrayTextureWraps value) {
    GDXJNI.ParameterRendererCommon_WrapTypes_set(swigCPtr, this, ArrayTextureWraps.getCPtr(value), value);
  }

  public ArrayTextureWraps getWrapTypes() {
    long cPtr = GDXJNI.ParameterRendererCommon_WrapTypes_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ArrayTextureWraps(cPtr, false);
  }

  public void setUVDistortionIntensity(float value) {
    GDXJNI.ParameterRendererCommon_UVDistortionIntensity_set(swigCPtr, this, value);
  }

  public float getUVDistortionIntensity() {
    return GDXJNI.ParameterRendererCommon_UVDistortionIntensity_get(swigCPtr, this);
  }

  public void setTextureBlendType(int value) {
    GDXJNI.ParameterRendererCommon_TextureBlendType_set(swigCPtr, this, value);
  }

  public int getTextureBlendType() {
    return GDXJNI.ParameterRendererCommon_TextureBlendType_get(swigCPtr, this);
  }

  public void setBlendUVDistortionIntensity(float value) {
    GDXJNI.ParameterRendererCommon_BlendUVDistortionIntensity_set(swigCPtr, this, value);
  }

  public float getBlendUVDistortionIntensity() {
    return GDXJNI.ParameterRendererCommon_BlendUVDistortionIntensity_get(swigCPtr, this);
  }

  public void setEmissiveScaling(float value) {
    GDXJNI.ParameterRendererCommon_EmissiveScaling_set(swigCPtr, this, value);
  }

  public float getEmissiveScaling() {
    return GDXJNI.ParameterRendererCommon_EmissiveScaling_get(swigCPtr, this);
  }

  public void setZWrite(boolean value) {
    GDXJNI.ParameterRendererCommon_ZWrite_set(swigCPtr, this, value);
  }

  public boolean getZWrite() {
    return GDXJNI.ParameterRendererCommon_ZWrite_get(swigCPtr, this);
  }

  public void setZTest(boolean value) {
    GDXJNI.ParameterRendererCommon_ZTest_set(swigCPtr, this, value);
  }

  public boolean getZTest() {
    return GDXJNI.ParameterRendererCommon_ZTest_get(swigCPtr, this);
  }

  public void setDistortion(boolean value) {
    GDXJNI.ParameterRendererCommon_Distortion_set(swigCPtr, this, value);
  }

  public boolean getDistortion() {
    return GDXJNI.ParameterRendererCommon_Distortion_get(swigCPtr, this);
  }

  public void setDistortionIntensity(float value) {
    GDXJNI.ParameterRendererCommon_DistortionIntensity_set(swigCPtr, this, value);
  }

  public float getDistortionIntensity() {
    return GDXJNI.ParameterRendererCommon_DistortionIntensity_get(swigCPtr, this);
  }

  public void setColorBindType(BindType value) {
    GDXJNI.ParameterRendererCommon_ColorBindType_set(swigCPtr, this, value.swigValue());
  }

  public BindType getColorBindType() {
    return BindType.swigToEnum(GDXJNI.ParameterRendererCommon_ColorBindType_get(swigCPtr, this));
  }

  public void setBasicParameter(NodeRendererBasicParameter value) {
    GDXJNI.ParameterRendererCommon_BasicParameter_set(swigCPtr, this, NodeRendererBasicParameter.getCPtr(value), value);
  }

  public NodeRendererBasicParameter getBasicParameter() {
    long cPtr = GDXJNI.ParameterRendererCommon_BasicParameter_get(swigCPtr, this);
    return (cPtr == 0) ? null : new NodeRendererBasicParameter(cPtr, false);
  }

  public void setCustomData1(ParameterCustomData value) {
    GDXJNI.ParameterRendererCommon_CustomData1_set(swigCPtr, this, ParameterCustomData.getCPtr(value), value);
  }

  public ParameterCustomData getCustomData1() {
    long cPtr = GDXJNI.ParameterRendererCommon_CustomData1_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterCustomData(cPtr, false);
  }

  public void setCustomData2(ParameterCustomData value) {
    GDXJNI.ParameterRendererCommon_CustomData2_set(swigCPtr, this, ParameterCustomData.getCPtr(value), value);
  }

  public ParameterCustomData getCustomData2() {
    long cPtr = GDXJNI.ParameterRendererCommon_CustomData2_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ParameterCustomData(cPtr, false);
  }

  public void setFadeInType(int value) {
    GDXJNI.ParameterRendererCommon_FadeInType_set(swigCPtr, this, value);
  }

  public int getFadeInType() {
    return GDXJNI.ParameterRendererCommon_FadeInType_get(swigCPtr, this);
  }

  public void setFadeOutType(int value) {
    GDXJNI.ParameterRendererCommon_FadeOutType_set(swigCPtr, this, value);
  }

  public int getFadeOutType() {
    return GDXJNI.ParameterRendererCommon_FadeOutType_get(swigCPtr, this);
  }

  public ParameterRendererCommon() {
    this(GDXJNI.new_ParameterRendererCommon(), true);
  }

  public int getUVTypes(int index) {
    return GDXJNI.ParameterRendererCommon_getUVTypes(swigCPtr, this, index);
  }

  public void setUVTypes(int index, int value) {
    GDXJNI.ParameterRendererCommon_setUVTypes(swigCPtr, this, index, value);
  }

  public final static int UVParameterNum = GDXJNI.ParameterRendererCommon_UVParameterNum_get();
  public final static int FADEIN_ON = GDXJNI.ParameterRendererCommon_FADEIN_ON_get();
  public final static int FADEIN_OFF = GDXJNI.ParameterRendererCommon_FADEIN_OFF_get();
  public final static int FADEIN_DWORD = GDXJNI.ParameterRendererCommon_FADEIN_DWORD_get();

  public final static int FADEOUT_ON = GDXJNI.ParameterRendererCommon_FADEOUT_ON_get();
  public final static int FADEOUT_OFF = GDXJNI.ParameterRendererCommon_FADEOUT_OFF_get();
  public final static int FADEOUT_DWORD = GDXJNI.ParameterRendererCommon_FADEOUT_DWORD_get();

  public final static int UV_DEFAULT = GDXJNI.ParameterRendererCommon_UV_DEFAULT_get();
  public final static int UV_FIXED = GDXJNI.ParameterRendererCommon_UV_FIXED_get();
  public final static int UV_ANIMATION = GDXJNI.ParameterRendererCommon_UV_ANIMATION_get();
  public final static int UV_SCROLL = GDXJNI.ParameterRendererCommon_UV_SCROLL_get();
  public final static int UV_FCURVE = GDXJNI.ParameterRendererCommon_UV_FCURVE_get();
  public final static int UV_DWORD = GDXJNI.ParameterRendererCommon_UV_DWORD_get();

}
