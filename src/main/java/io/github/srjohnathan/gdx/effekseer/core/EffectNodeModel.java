/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class EffectNodeModel extends EffectNodeImplemented {
  private transient long swigCPtr;

  protected EffectNodeModel(long cPtr, boolean cMemoryOwn) {
    super(GDXJNI.EffectNodeModel_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(EffectNodeModel obj) {
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
        GDXJNI.delete_EffectNodeModel(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public void setAlphaBlend(AlphaBlendType value) {
    GDXJNI.EffectNodeModel_AlphaBlend_set(swigCPtr, this, value.swigValue());
  }

  public AlphaBlendType getAlphaBlend() {
    return AlphaBlendType.swigToEnum(GDXJNI.EffectNodeModel_AlphaBlend_get(swigCPtr, this));
  }

  public void setModelIndex(int value) {
    GDXJNI.EffectNodeModel_ModelIndex_set(swigCPtr, this, value);
  }

  public int getModelIndex() {
    return GDXJNI.EffectNodeModel_ModelIndex_get(swigCPtr, this);
  }

  public void setNormalTextureIndex(int value) {
    GDXJNI.EffectNodeModel_NormalTextureIndex_set(swigCPtr, this, value);
  }

  public int getNormalTextureIndex() {
    return GDXJNI.EffectNodeModel_NormalTextureIndex_get(swigCPtr, this);
  }

  public void setBillboard(BillboardType value) {
    GDXJNI.EffectNodeModel_Billboard_set(swigCPtr, this, value.swigValue());
  }

  public BillboardType getBillboard() {
    return BillboardType.swigToEnum(GDXJNI.EffectNodeModel_Billboard_get(swigCPtr, this));
  }

  public void setLighting(boolean value) {
    GDXJNI.EffectNodeModel_Lighting_set(swigCPtr, this, value);
  }

  public boolean getLighting() {
    return GDXJNI.EffectNodeModel_Lighting_get(swigCPtr, this);
  }

  public void setCulling(CullingType value) {
    GDXJNI.EffectNodeModel_Culling_set(swigCPtr, this, value.swigValue());
  }

  public CullingType getCulling() {
    return CullingType.swigToEnum(GDXJNI.EffectNodeModel_Culling_get(swigCPtr, this));
  }

  public void setAllColor(StandardColorParameterCore value) {
    GDXJNI.EffectNodeModel_AllColor_set(swigCPtr, this, StandardColorParameterCore.getCPtr(value), value);
  }

  public StandardColorParameterCore getAllColor() {
    long cPtr = GDXJNI.EffectNodeModel_AllColor_get(swigCPtr, this);
    return (cPtr == 0) ? null : new StandardColorParameterCore(cPtr, false);
  }

  public void setMode(ModelReferenceType value) {
    GDXJNI.EffectNodeModel_Mode_set(swigCPtr, this, value.swigValue());
  }

  public ModelReferenceType getMode() {
    return ModelReferenceType.swigToEnum(GDXJNI.EffectNodeModel_Mode_get(swigCPtr, this));
  }

  public EffectNodeModel(EffekseerEffect effect, SWIGTYPE_p_p_unsigned_char pos) {
    this(GDXJNI.new_EffectNodeModel(EffekseerEffect.getCPtr(effect), effect, SWIGTYPE_p_p_unsigned_char.getCPtr(pos)), true);
  }

}
