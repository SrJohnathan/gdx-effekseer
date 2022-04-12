// All needed enum classes and structs in Effekseer.EffectNode.h
%rename("StandardColorParameterCore", fullname=1) "Effekseer::StandardColorParameter";
%rename("ParameterCommonValues_8", fullname=1) "Effekseer::ParameterCommonValues_8";
%rename("ParameterCommonValues", fullname=1) "Effekseer::ParameterCommonValues";
%rename("ParameterDepthValues", fullname=1) "Effekseer::ParameterDepthValues";
%rename("SteeringBehaviorParameter", fullname=1) "Effekseer::SteeringBehaviorParameter";
%rename("ParameterTranslationType", fullname=1) "Effekseer::ParameterTranslationType";
%rename("ParameterTranslationFixed", fullname=1) "Effekseer::ParameterTranslationFixed";
%rename("ParameterTranslationPVA", fullname=1) "Effekseer::ParameterTranslationPVA";
%rename("ParameterTranslationEasing", fullname=1) "Effekseer::ParameterTranslationEasing";
%rename("ParameterTranslationNurbsCurve", fullname=1) "Effekseer::ParameterTranslationNurbsCurve";
%rename("ParameterTranslationViewOffset", fullname=1) "Effekseer::ParameterTranslationViewOffset";
%rename("LocationAbsParameter", fullname=1) "Effekseer::LocationAbsParameter";
%rename("ParameterRotationFixed", fullname=1) "Effekseer::ParameterRotationFixed";
%rename("ParameterRotationPVA", fullname=1) "Effekseer::ParameterRotationPVA";
%rename("ParameterRotationEasing", fullname=1) "Effekseer::ParameterRotationEasing";
%rename("ParameterRotationAxisPVA", fullname=1) "Effekseer::ParameterRotationAxisPVA";
%rename("ParameterRotationAxisEasing", fullname=1) "Effekseer::ParameterRotationAxisEasing";
%rename("ParameterScalingFixed", fullname=1) "Effekseer::ParameterScalingFixed";
%rename("ParameterScalingPVA", fullname=1) "Effekseer::ParameterScalingPVA";
%rename("ParameterScalingEasing", fullname=1) "Effekseer::ParameterScalingEasing";
%rename("ParameterScalingSinglePVA", fullname=1) "Effekseer::ParameterScalingSinglePVA";
%rename("ParameterGenerationLocation", fullname=1) "Effekseer::ParameterGenerationLocation";
%rename("ParameterCustomDataFixed", fullname=1) "Effekseer::ParameterCustomDataFixed";
%rename("ParameterCustomDataRandom", fullname=1) "Effekseer::ParameterCustomDataRandom";
%rename("ParameterCustomDataEasing", fullname=1) "Effekseer::ParameterCustomDataEasing";
%rename("ParameterCustomDataFCurve", fullname=1) "Effekseer::ParameterCustomDataFCurve";
%rename("ParameterCustomDataFCurveColor", fullname=1) "Effekseer::ParameterCustomDataFCurveColor";
%rename("ParameterCustomData", fullname=1) "Effekseer::ParameterCustomData";
%rename("ParameterRendererCommon", fullname=1) "Effekseer::ParameterRendererCommon";
// Ignore UVTypes and extend instead so that we can use an index for accessing/modifying this array
%rename($ignore, fullname=1) "Effekseer::ParameterRendererCommon::UVTypes";
%rename("ParameterAlphaCutoff", fullname=1) "Effekseer::ParameterAlphaCutoff";
%rename("ParameterSound", fullname=1) "Effekseer::ParameterSound";
%rename("DynamicFactorParameter", fullname=1) "Effekseer::DynamicFactorParameter";
%rename("EffectNodeImplemented", fullname=1) "Effekseer::EffectNodeImplemented";
%rename("getType", fullname=1) "Effekseer::EffectNodeImplemented::GetType";
%rename($ignore, fullname=1) "Effekseer::EffectNodeImplemented::LocalForceField";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.EffectNode.h"

// Root node
%rename("EffectNodeRoot", fullname=1) "Effekseer::EffectNodeRoot";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.EffectNodeRoot.h"

// Sprite node
%rename("SpriteColorParameterCore", fullname=1) "Effekseer::SpriteColorParameter";
%rename("SpritePositionParameterCore", fullname=1) "Effekseer::SpritePositionParameter";
%rename("EffectNodeSprite", fullname=1) "Effekseer::EffectNodeSprite";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.EffectNodeSprite.h"

// Ribbon node
// Don't know why NodeParameter and InstanceParameter are not being wrapped
%rename("RibbonRendererNodeParameter", fullname=1) "Effekseer::RibbonRenderer::NodeParameter";
%rename("RibbonRendererInstanceParameter", fullname=1) "Effekseer::RibbonRenderer::InstanceParameter";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Renderer/Effekseer.RibbonRenderer.h"
%rename("RibbonAllColorParameterCore", fullname=1) "Effekseer::RibbonAllColorParameter";
%rename("RibbonColorParameterCore", fullname=1) "Effekseer::RibbonColorParameter";
%rename("RibbonPositionParameterCore", fullname=1) "Effekseer::RibbonPositionParameter";
%rename("EffectNodeRibbon", fullname=1) "Effekseer::EffectNodeRibbon";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.EffectNodeRibbon.h"

// Track node
%rename("TrackSizeParameterCore", fullname=1) "Effekseer::TrackSizeParameter";
%rename("EffectNodeTrack", fullname=1) "Effekseer::EffectNodeTrack";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.EffectNodeTrack.h"

// Ring node
%rename("RingSingleParameterCore", fullname=1) "Effekseer::RingSingleParameter";
%rename("RingLocationParameterCore", fullname=1) "Effekseer::RingLocationParameter";
%rename("RingColorParameterCore", fullname=1) "Effekseer::RingColorParameter";
%rename("RingSingleValuesCore", fullname=1) "Effekseer::RingSingleValues";
%rename("RingLocationValuesCore", fullname=1) "Effekseer::RingLocationValues";
%rename("RingColorValuesCore", fullname=1) "Effekseer::RingColorValues";
%rename("RingShapeParameterCore", fullname=1) "Effekseer::RingShapeParameter";
%rename("EffectNodeRing", fullname=1) "Effekseer::EffectNodeRing";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.EffectNodeRing.h"

// Model node
%rename("EffectNodeModel", fullname=1) "Effekseer::EffectNodeModel";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.EffectNodeModel.h"