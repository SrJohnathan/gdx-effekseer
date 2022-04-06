/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.srjohnathan.gdx.effekseer.core;

public class EffectNodeSprite extends EffectNodeImplemented {
  private transient long swigCPtr;

  protected EffectNodeSprite(long cPtr, boolean cMemoryOwn) {
    super(GDXJNI.EffectNodeSprite_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(EffectNodeSprite obj) {
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
        GDXJNI.delete_EffectNodeSprite(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public void setAlphaBlend(AlphaBlendType value) {
    GDXJNI.EffectNodeSprite_AlphaBlend_set(swigCPtr, this, value.swigValue());
  }

  public AlphaBlendType getAlphaBlend() {
    return AlphaBlendType.swigToEnum(GDXJNI.EffectNodeSprite_AlphaBlend_get(swigCPtr, this));
  }

  public void setBillboard(BillboardType value) {
    GDXJNI.EffectNodeSprite_Billboard_set(swigCPtr, this, value.swigValue());
  }

  public BillboardType getBillboard() {
    return BillboardType.swigToEnum(GDXJNI.EffectNodeSprite_Billboard_get(swigCPtr, this));
  }

  public void setSpriteAllColor(StandardColorParameterCore value) {
    GDXJNI.EffectNodeSprite_SpriteAllColor_set(swigCPtr, this, StandardColorParameterCore.getCPtr(value), value);
  }

  public StandardColorParameterCore getSpriteAllColor() {
    long cPtr = GDXJNI.EffectNodeSprite_SpriteAllColor_get(swigCPtr, this);
    return (cPtr == 0) ? null : new StandardColorParameterCore(cPtr, false);
  }

  public void setSpriteColor(SpriteColorParameterCore value) {
    GDXJNI.EffectNodeSprite_SpriteColor_set(swigCPtr, this, SpriteColorParameterCore.getCPtr(value), value);
  }

  public SpriteColorParameterCore getSpriteColor() {
    long cPtr = GDXJNI.EffectNodeSprite_SpriteColor_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SpriteColorParameterCore(cPtr, false);
  }

  public void setSpritePosition(SpritePositionParameterCore value) {
    GDXJNI.EffectNodeSprite_SpritePosition_set(swigCPtr, this, SpritePositionParameterCore.getCPtr(value), value);
  }

  public SpritePositionParameterCore getSpritePosition() {
    long cPtr = GDXJNI.EffectNodeSprite_SpritePosition_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SpritePositionParameterCore(cPtr, false);
  }

  public void setSpriteTexture(int value) {
    GDXJNI.EffectNodeSprite_SpriteTexture_set(swigCPtr, this, value);
  }

  public int getSpriteTexture() {
    return GDXJNI.EffectNodeSprite_SpriteTexture_get(swigCPtr, this);
  }

  public EffectNodeSprite(EffekseerEffect effect, SWIGTYPE_p_p_unsigned_char pos) {
    this(GDXJNI.new_EffectNodeSprite(EffekseerEffect.getCPtr(effect), effect, SWIGTYPE_p_p_unsigned_char.getCPtr(pos)), true);
  }

}
