// All classes in Parameter/Effekseer.Parameters.h
%rename("NodeRendererTextureUVTypeParameter", fullname=1) "Effekseer::NodeRendererTextureUVTypeParameter";
%rename("FalloffParameter", fullname=1) "Effekseer::FalloffParameter";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Parameter/Effekseer.Parameters.h"

// All structs in Parameter/DynamicParameter.h
%rename("RefMinMax", fullname=1) "Effekseer::RefMinMax";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Parameter/DynamicParameter.h"

// InstanceEasing in Parameter/Easing.h
%rename("InstanceEasingFloat", fullname=1) Effekseer::InstanceEasing<float>;
%rename("InstanceEasingSIMDVec3", fullname=1) Effekseer::InstanceEasing<SIMD::Vec3f>;
// ParameterEasingFloat in Parameter/Easing.h
%rename("ParameterEasingFloat", fullname=1) "Effekseer::ParameterEasingFloat";
// ParameterEasingSIMDVec3 in Parameter/Easing.h
%rename("ParameterEasingSIMDVec3", fullname=1) "Effekseer::ParameterEasingSIMDVec3";

%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Parameter/Easing.h"