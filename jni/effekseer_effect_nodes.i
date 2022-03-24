// All needed enum classes and structs in Effekseer.EffectNode.h
%rename("StandardColorParameter", fullname=1) "Effekseer::StandardColorParameter";
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
// Ignore boost data structures
%rename($ignore, fullname=1) "Effekseer::ParameterCustomData::Fixed4D";
%rename("ParameterRendererCommon", fullname=1) "Effekseer::ParameterRendererCommon";
// Ignore boost data structures
%rename($ignore, fullname=1) "Effekseer::ParameterRendererCommon::FilterTypes";
%rename($ignore, fullname=1) "Effekseer::ParameterRendererCommon::WrapTypes";
%rename("ParameterAlphaCutoff", fullname=1) "Effekseer::ParameterAlphaCutoff";
%rename("ParameterSound", fullname=1) "Effekseer::ParameterSound";
%rename("DynamicFactorParameter", fullname=1) "Effekseer::DynamicFactorParameter";
// Ignore boost data structures
%rename($ignore, fullname=1) "Effekseer::DynamicFactorParameter::Tra";
%rename($ignore, fullname=1) "Effekseer::DynamicFactorParameter::TraInv";
%rename($ignore, fullname=1) "Effekseer::DynamicFactorParameter::Rot";
%rename($ignore, fullname=1) "Effekseer::DynamicFactorParameter::RotInv";
%rename($ignore, fullname=1) "Effekseer::DynamicFactorParameter::Scale";
%rename($ignore, fullname=1) "Effekseer::DynamicFactorParameter::ScaleInv";
%rename("EffectNodeImplemented", fullname=1) "Effekseer::EffectNodeImplemented";
%rename($ignore, fullname=1) "Effekseer::EffectNodeImplemented::LocalForceField";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.EffectNode.h"