/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class EffectBasicRenderParameter {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected EffectBasicRenderParameter(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(EffectBasicRenderParameter obj) {
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
        GDXJNI.delete_EffectBasicRenderParameter(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setMaterialIndex(int value) {
    GDXJNI.EffectBasicRenderParameter_MaterialIndex_set(swigCPtr, this, value);
  }

  public int getMaterialIndex() {
    return GDXJNI.EffectBasicRenderParameter_MaterialIndex_get(swigCPtr, this);
  }

  public void setColorTextureIndex(int value) {
    GDXJNI.EffectBasicRenderParameter_ColorTextureIndex_set(swigCPtr, this, value);
  }

  public int getColorTextureIndex() {
    return GDXJNI.EffectBasicRenderParameter_ColorTextureIndex_get(swigCPtr, this);
  }

  public void setAlphaTextureIndex(int value) {
    GDXJNI.EffectBasicRenderParameter_AlphaTextureIndex_set(swigCPtr, this, value);
  }

  public int getAlphaTextureIndex() {
    return GDXJNI.EffectBasicRenderParameter_AlphaTextureIndex_get(swigCPtr, this);
  }

  public void setAlphaTexWrapType(TextureWrapType value) {
    GDXJNI.EffectBasicRenderParameter_AlphaTexWrapType_set(swigCPtr, this, value.swigValue());
  }

  public TextureWrapType getAlphaTexWrapType() {
    return TextureWrapType.swigToEnum(GDXJNI.EffectBasicRenderParameter_AlphaTexWrapType_get(swigCPtr, this));
  }

  public void setUVDistortionIndex(int value) {
    GDXJNI.EffectBasicRenderParameter_UVDistortionIndex_set(swigCPtr, this, value);
  }

  public int getUVDistortionIndex() {
    return GDXJNI.EffectBasicRenderParameter_UVDistortionIndex_get(swigCPtr, this);
  }

  public void setUVDistortionTexWrapType(TextureWrapType value) {
    GDXJNI.EffectBasicRenderParameter_UVDistortionTexWrapType_set(swigCPtr, this, value.swigValue());
  }

  public TextureWrapType getUVDistortionTexWrapType() {
    return TextureWrapType.swigToEnum(GDXJNI.EffectBasicRenderParameter_UVDistortionTexWrapType_get(swigCPtr, this));
  }

  public void setBlendTextureIndex(int value) {
    GDXJNI.EffectBasicRenderParameter_BlendTextureIndex_set(swigCPtr, this, value);
  }

  public int getBlendTextureIndex() {
    return GDXJNI.EffectBasicRenderParameter_BlendTextureIndex_get(swigCPtr, this);
  }

  public void setBlendTexWrapType(TextureWrapType value) {
    GDXJNI.EffectBasicRenderParameter_BlendTexWrapType_set(swigCPtr, this, value.swigValue());
  }

  public TextureWrapType getBlendTexWrapType() {
    return TextureWrapType.swigToEnum(GDXJNI.EffectBasicRenderParameter_BlendTexWrapType_get(swigCPtr, this));
  }

  public void setBlendAlphaTextureIndex(int value) {
    GDXJNI.EffectBasicRenderParameter_BlendAlphaTextureIndex_set(swigCPtr, this, value);
  }

  public int getBlendAlphaTextureIndex() {
    return GDXJNI.EffectBasicRenderParameter_BlendAlphaTextureIndex_get(swigCPtr, this);
  }

  public void setBlendAlphaTexWrapType(TextureWrapType value) {
    GDXJNI.EffectBasicRenderParameter_BlendAlphaTexWrapType_set(swigCPtr, this, value.swigValue());
  }

  public TextureWrapType getBlendAlphaTexWrapType() {
    return TextureWrapType.swigToEnum(GDXJNI.EffectBasicRenderParameter_BlendAlphaTexWrapType_get(swigCPtr, this));
  }

  public void setBlendUVDistortionTextureIndex(int value) {
    GDXJNI.EffectBasicRenderParameter_BlendUVDistortionTextureIndex_set(swigCPtr, this, value);
  }

  public int getBlendUVDistortionTextureIndex() {
    return GDXJNI.EffectBasicRenderParameter_BlendUVDistortionTextureIndex_get(swigCPtr, this);
  }

  public void setBlendUVDistortionTexWrapType(TextureWrapType value) {
    GDXJNI.EffectBasicRenderParameter_BlendUVDistortionTexWrapType_set(swigCPtr, this, value.swigValue());
  }

  public TextureWrapType getBlendUVDistortionTexWrapType() {
    return TextureWrapType.swigToEnum(GDXJNI.EffectBasicRenderParameter_BlendUVDistortionTexWrapType_get(swigCPtr, this));
  }

  static public class FlipbookParameters {
    private transient long swigCPtr;
    protected transient boolean swigCMemOwn;
  
    protected FlipbookParameters(long cPtr, boolean cMemoryOwn) {
      swigCMemOwn = cMemoryOwn;
      swigCPtr = cPtr;
    }
  
    protected static long getCPtr(FlipbookParameters obj) {
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
          GDXJNI.delete_EffectBasicRenderParameter_FlipbookParameters(swigCPtr);
        }
        swigCPtr = 0;
      }
    }
  
    public void setEnable(boolean value) {
      GDXJNI.EffectBasicRenderParameter_FlipbookParameters_Enable_set(swigCPtr, this, value);
    }
  
    public boolean getEnable() {
      return GDXJNI.EffectBasicRenderParameter_FlipbookParameters_Enable_get(swigCPtr, this);
    }
  
    public void setLoopType(int value) {
      GDXJNI.EffectBasicRenderParameter_FlipbookParameters_LoopType_set(swigCPtr, this, value);
    }
  
    public int getLoopType() {
      return GDXJNI.EffectBasicRenderParameter_FlipbookParameters_LoopType_get(swigCPtr, this);
    }
  
    public void setDivideX(int value) {
      GDXJNI.EffectBasicRenderParameter_FlipbookParameters_DivideX_set(swigCPtr, this, value);
    }
  
    public int getDivideX() {
      return GDXJNI.EffectBasicRenderParameter_FlipbookParameters_DivideX_get(swigCPtr, this);
    }
  
    public void setDivideY(int value) {
      GDXJNI.EffectBasicRenderParameter_FlipbookParameters_DivideY_set(swigCPtr, this, value);
    }
  
    public int getDivideY() {
      return GDXJNI.EffectBasicRenderParameter_FlipbookParameters_DivideY_get(swigCPtr, this);
    }
  
    public FlipbookParameters() {
      this(GDXJNI.new_EffectBasicRenderParameter_FlipbookParameters(), true);
    }
  
  }

  public void setFlipbookParams(EffectBasicRenderParameter.FlipbookParameters value) {
    GDXJNI.EffectBasicRenderParameter_FlipbookParams_set(swigCPtr, this, EffectBasicRenderParameter.FlipbookParameters.getCPtr(value), value);
  }

  public EffectBasicRenderParameter.FlipbookParameters getFlipbookParams() {
    long cPtr = GDXJNI.EffectBasicRenderParameter_FlipbookParams_get(swigCPtr, this);
    return (cPtr == 0) ? null : new EffectBasicRenderParameter.FlipbookParameters(cPtr, false);
  }

  public void setMaterialType(RendererMaterialType value) {
    GDXJNI.EffectBasicRenderParameter_MaterialType_set(swigCPtr, this, value.swigValue());
  }

  public RendererMaterialType getMaterialType() {
    return RendererMaterialType.swigToEnum(GDXJNI.EffectBasicRenderParameter_MaterialType_get(swigCPtr, this));
  }

  public void setUVDistortionIntensity(float value) {
    GDXJNI.EffectBasicRenderParameter_UVDistortionIntensity_set(swigCPtr, this, value);
  }

  public float getUVDistortionIntensity() {
    return GDXJNI.EffectBasicRenderParameter_UVDistortionIntensity_get(swigCPtr, this);
  }

  public void setTextureBlendType(int value) {
    GDXJNI.EffectBasicRenderParameter_TextureBlendType_set(swigCPtr, this, value);
  }

  public int getTextureBlendType() {
    return GDXJNI.EffectBasicRenderParameter_TextureBlendType_get(swigCPtr, this);
  }

  public void setBlendUVDistortionIntensity(float value) {
    GDXJNI.EffectBasicRenderParameter_BlendUVDistortionIntensity_set(swigCPtr, this, value);
  }

  public float getBlendUVDistortionIntensity() {
    return GDXJNI.EffectBasicRenderParameter_BlendUVDistortionIntensity_get(swigCPtr, this);
  }

  public void setEnableFalloff(boolean value) {
    GDXJNI.EffectBasicRenderParameter_EnableFalloff_set(swigCPtr, this, value);
  }

  public boolean getEnableFalloff() {
    return GDXJNI.EffectBasicRenderParameter_EnableFalloff_get(swigCPtr, this);
  }

  public void setEmissiveScaling(float value) {
    GDXJNI.EffectBasicRenderParameter_EmissiveScaling_set(swigCPtr, this, value);
  }

  public float getEmissiveScaling() {
    return GDXJNI.EffectBasicRenderParameter_EmissiveScaling_get(swigCPtr, this);
  }

  public void setAlphaBlend(AlphaBlendType value) {
    GDXJNI.EffectBasicRenderParameter_AlphaBlend_set(swigCPtr, this, value.swigValue());
  }

  public AlphaBlendType getAlphaBlend() {
    return AlphaBlendType.swigToEnum(GDXJNI.EffectBasicRenderParameter_AlphaBlend_get(swigCPtr, this));
  }

  public void setFilterType(TextureFilterType value) {
    GDXJNI.EffectBasicRenderParameter_FilterType_set(swigCPtr, this, value.swigValue());
  }

  public TextureFilterType getFilterType() {
    return TextureFilterType.swigToEnum(GDXJNI.EffectBasicRenderParameter_FilterType_get(swigCPtr, this));
  }

  public void setWrapType(TextureWrapType value) {
    GDXJNI.EffectBasicRenderParameter_WrapType_set(swigCPtr, this, value.swigValue());
  }

  public TextureWrapType getWrapType() {
    return TextureWrapType.swigToEnum(GDXJNI.EffectBasicRenderParameter_WrapType_get(swigCPtr, this));
  }

  public void setZWrite(boolean value) {
    GDXJNI.EffectBasicRenderParameter_ZWrite_set(swigCPtr, this, value);
  }

  public boolean getZWrite() {
    return GDXJNI.EffectBasicRenderParameter_ZWrite_get(swigCPtr, this);
  }

  public void setZTest(boolean value) {
    GDXJNI.EffectBasicRenderParameter_ZTest_set(swigCPtr, this, value);
  }

  public boolean getZTest() {
    return GDXJNI.EffectBasicRenderParameter_ZTest_get(swigCPtr, this);
  }

  public void setDistortion(boolean value) {
    GDXJNI.EffectBasicRenderParameter_Distortion_set(swigCPtr, this, value);
  }

  public boolean getDistortion() {
    return GDXJNI.EffectBasicRenderParameter_Distortion_get(swigCPtr, this);
  }

  public void setDistortionIntensity(float value) {
    GDXJNI.EffectBasicRenderParameter_DistortionIntensity_set(swigCPtr, this, value);
  }

  public float getDistortionIntensity() {
    return GDXJNI.EffectBasicRenderParameter_DistortionIntensity_get(swigCPtr, this);
  }

  public void setSoftParticleDistanceFar(float value) {
    GDXJNI.EffectBasicRenderParameter_SoftParticleDistanceFar_set(swigCPtr, this, value);
  }

  public float getSoftParticleDistanceFar() {
    return GDXJNI.EffectBasicRenderParameter_SoftParticleDistanceFar_get(swigCPtr, this);
  }

  public void setSoftParticleDistanceNear(float value) {
    GDXJNI.EffectBasicRenderParameter_SoftParticleDistanceNear_set(swigCPtr, this, value);
  }

  public float getSoftParticleDistanceNear() {
    return GDXJNI.EffectBasicRenderParameter_SoftParticleDistanceNear_get(swigCPtr, this);
  }

  public void setSoftParticleDistanceNearOffset(float value) {
    GDXJNI.EffectBasicRenderParameter_SoftParticleDistanceNearOffset_set(swigCPtr, this, value);
  }

  public float getSoftParticleDistanceNearOffset() {
    return GDXJNI.EffectBasicRenderParameter_SoftParticleDistanceNearOffset_get(swigCPtr, this);
  }

  public EffectBasicRenderParameter() {
    this(GDXJNI.new_EffectBasicRenderParameter(), true);
  }

}
