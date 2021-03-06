/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class NodeRendererBasicParameter {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected NodeRendererBasicParameter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(NodeRendererBasicParameter obj) {
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
        GDXJNI.delete_NodeRendererBasicParameter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setMaterialType(RendererMaterialType value) {
    GDXJNI.NodeRendererBasicParameter_MaterialType_set(swigCPtr, this, value.swigValue());
  }

  public RendererMaterialType getMaterialType() {
    return RendererMaterialType.swigToEnum(GDXJNI.NodeRendererBasicParameter_MaterialType_get(swigCPtr, this));
  }

  public void setTextureIndexes(ArrayTextureIndexes value) {
    GDXJNI.NodeRendererBasicParameter_TextureIndexes_set(swigCPtr, this, ArrayTextureIndexes.getCPtr(value), value);
  }

  public ArrayTextureIndexes getTextureIndexes() {
    long cPtr = GDXJNI.NodeRendererBasicParameter_TextureIndexes_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ArrayTextureIndexes(cPtr, false);
  }

  public void setDistortionIntensity(float value) {
    GDXJNI.NodeRendererBasicParameter_DistortionIntensity_set(swigCPtr, this, value);
  }

  public float getDistortionIntensity() {
    return GDXJNI.NodeRendererBasicParameter_DistortionIntensity_get(swigCPtr, this);
  }

  public void setMaterialRenderDataPtr(MaterialRenderData value) {
    GDXJNI.NodeRendererBasicParameter_MaterialRenderDataPtr_set(swigCPtr, this, MaterialRenderData.getCPtr(value), value);
  }

  public MaterialRenderData getMaterialRenderDataPtr() {
    long cPtr = GDXJNI.NodeRendererBasicParameter_MaterialRenderDataPtr_get(swigCPtr, this);
    return (cPtr == 0) ? null : new MaterialRenderData(cPtr, false);
  }

  public void setAlphaBlend(AlphaBlendType value) {
    GDXJNI.NodeRendererBasicParameter_AlphaBlend_set(swigCPtr, this, value.swigValue());
  }

  public AlphaBlendType getAlphaBlend() {
    return AlphaBlendType.swigToEnum(GDXJNI.NodeRendererBasicParameter_AlphaBlend_get(swigCPtr, this));
  }

  public void setTextureFilters(ArrayTextureFilters value) {
    GDXJNI.NodeRendererBasicParameter_TextureFilters_set(swigCPtr, this, ArrayTextureFilters.getCPtr(value), value);
  }

  public ArrayTextureFilters getTextureFilters() {
    long cPtr = GDXJNI.NodeRendererBasicParameter_TextureFilters_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ArrayTextureFilters(cPtr, false);
  }

  public void setTextureWraps(ArrayTextureWraps value) {
    GDXJNI.NodeRendererBasicParameter_TextureWraps_set(swigCPtr, this, ArrayTextureWraps.getCPtr(value), value);
  }

  public ArrayTextureWraps getTextureWraps() {
    long cPtr = GDXJNI.NodeRendererBasicParameter_TextureWraps_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ArrayTextureWraps(cPtr, false);
  }

  public void setUVDistortionIntensity(float value) {
    GDXJNI.NodeRendererBasicParameter_UVDistortionIntensity_set(swigCPtr, this, value);
  }

  public float getUVDistortionIntensity() {
    return GDXJNI.NodeRendererBasicParameter_UVDistortionIntensity_get(swigCPtr, this);
  }

  public void setTextureBlendType(int value) {
    GDXJNI.NodeRendererBasicParameter_TextureBlendType_set(swigCPtr, this, value);
  }

  public int getTextureBlendType() {
    return GDXJNI.NodeRendererBasicParameter_TextureBlendType_get(swigCPtr, this);
  }

  public void setBlendUVDistortionIntensity(float value) {
    GDXJNI.NodeRendererBasicParameter_BlendUVDistortionIntensity_set(swigCPtr, this, value);
  }

  public float getBlendUVDistortionIntensity() {
    return GDXJNI.NodeRendererBasicParameter_BlendUVDistortionIntensity_get(swigCPtr, this);
  }

  public void setEnableInterpolation(boolean value) {
    GDXJNI.NodeRendererBasicParameter_EnableInterpolation_set(swigCPtr, this, value);
  }

  public boolean getEnableInterpolation() {
    return GDXJNI.NodeRendererBasicParameter_EnableInterpolation_get(swigCPtr, this);
  }

  public void setUVLoopType(int value) {
    GDXJNI.NodeRendererBasicParameter_UVLoopType_set(swigCPtr, this, value);
  }

  public int getUVLoopType() {
    return GDXJNI.NodeRendererBasicParameter_UVLoopType_get(swigCPtr, this);
  }

  public void setInterpolationType(int value) {
    GDXJNI.NodeRendererBasicParameter_InterpolationType_set(swigCPtr, this, value);
  }

  public int getInterpolationType() {
    return GDXJNI.NodeRendererBasicParameter_InterpolationType_get(swigCPtr, this);
  }

  public void setFlipbookDivideX(int value) {
    GDXJNI.NodeRendererBasicParameter_FlipbookDivideX_set(swigCPtr, this, value);
  }

  public int getFlipbookDivideX() {
    return GDXJNI.NodeRendererBasicParameter_FlipbookDivideX_get(swigCPtr, this);
  }

  public void setFlipbookDivideY(int value) {
    GDXJNI.NodeRendererBasicParameter_FlipbookDivideY_set(swigCPtr, this, value);
  }

  public int getFlipbookDivideY() {
    return GDXJNI.NodeRendererBasicParameter_FlipbookDivideY_get(swigCPtr, this);
  }

  public void setEmissiveScaling(float value) {
    GDXJNI.NodeRendererBasicParameter_EmissiveScaling_set(swigCPtr, this, value);
  }

  public float getEmissiveScaling() {
    return GDXJNI.NodeRendererBasicParameter_EmissiveScaling_get(swigCPtr, this);
  }

  public void setEdgeThreshold(float value) {
    GDXJNI.NodeRendererBasicParameter_EdgeThreshold_set(swigCPtr, this, value);
  }

  public float getEdgeThreshold() {
    return GDXJNI.NodeRendererBasicParameter_EdgeThreshold_get(swigCPtr, this);
  }

  public void setEdgeColor(short[] value) {
    GDXJNI.NodeRendererBasicParameter_EdgeColor_set(swigCPtr, this, value);
  }

  public short[] getEdgeColor() {
    return GDXJNI.NodeRendererBasicParameter_EdgeColor_get(swigCPtr, this);
  }

  public void setEdgeColorScaling(float value) {
    GDXJNI.NodeRendererBasicParameter_EdgeColorScaling_set(swigCPtr, this, value);
  }

  public float getEdgeColorScaling() {
    return GDXJNI.NodeRendererBasicParameter_EdgeColorScaling_get(swigCPtr, this);
  }

  public void setIsAlphaCutoffEnabled(boolean value) {
    GDXJNI.NodeRendererBasicParameter_IsAlphaCutoffEnabled_set(swigCPtr, this, value);
  }

  public boolean getIsAlphaCutoffEnabled() {
    return GDXJNI.NodeRendererBasicParameter_IsAlphaCutoffEnabled_get(swigCPtr, this);
  }

  public void setSoftParticleDistanceFar(float value) {
    GDXJNI.NodeRendererBasicParameter_SoftParticleDistanceFar_set(swigCPtr, this, value);
  }

  public float getSoftParticleDistanceFar() {
    return GDXJNI.NodeRendererBasicParameter_SoftParticleDistanceFar_get(swigCPtr, this);
  }

  public void setSoftParticleDistanceNear(float value) {
    GDXJNI.NodeRendererBasicParameter_SoftParticleDistanceNear_set(swigCPtr, this, value);
  }

  public float getSoftParticleDistanceNear() {
    return GDXJNI.NodeRendererBasicParameter_SoftParticleDistanceNear_get(swigCPtr, this);
  }

  public void setSoftParticleDistanceNearOffset(float value) {
    GDXJNI.NodeRendererBasicParameter_SoftParticleDistanceNearOffset_set(swigCPtr, this, value);
  }

  public float getSoftParticleDistanceNearOffset() {
    return GDXJNI.NodeRendererBasicParameter_SoftParticleDistanceNearOffset_get(swigCPtr, this);
  }

  public NodeRendererBasicParameter() {
    this(GDXJNI.new_NodeRendererBasicParameter(), true);
  }

}
