// All classes in Parameter/Effekseer.Parameters.h
%rename("NodeRendererTextureUVTypeParameter", fullname=1) "Effekseer::NodeRendererTextureUVTypeParameter";
%rename("FalloffParameter", fullname=1) "Effekseer::FalloffParameter";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Parameter/Effekseer.Parameters.h"

// All structs in Parameter/DynamicParameter.h
%rename("RefMinMax", fullname=1) "Effekseer::RefMinMax";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Parameter/DynamicParameter.h"

// ParameterEasingFloat in Parameter/Easing.h
%rename("ParameterEasingFloatCore", fullname=1) "Effekseer::ParameterEasingFloat";
// ParameterEasingSIMDVec3 in Parameter/Easing.h
%rename("ParameterEasingSIMDVec3Core", fullname=1) "Effekseer::ParameterEasingSIMDVec3";

%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Parameter/Easing.h"
// InstanceEasing in Parameter/Easing.h
namespace Effekseer {
    // InstanceEasing<float>
    %rename(InstanceEasingFloat) InstanceEasing<float>;
    struct InstanceEasing<float> {
        float start;
        float middle;
        float end;
        float Rate;
    };
    // InstanceEasing<SIMD::Vec3f>
    %rename(InstanceEasingSIMDVec3f) InstanceEasing<SIMD::Vec3f>;
    struct InstanceEasing<SIMD::Vec3f> {
        SIMD::Vec3f start;
        SIMD::Vec3f middle;
        SIMD::Vec3f end;
        float Rate;
    };

    // ParameterEasing<float>
    %rename(ParameterEasingFloatBaseCore) ParameterEasing<float>;
    struct ParameterEasing<float> {
        RefMinMax RefEqS;
        RefMinMax RefEqE;
        RefMinMax RefEqM;

        Easing3Type type_ = Easing3Type::StartEndSpeed;
        std::array<float, 4> params;

        int32_t channelCount = 0;

        bool isMiddleEnabled = false;

        bool isIndividualEnabled = false;

        virtual float GetValue(const InstanceEasing<float>& instance, float time) const = 0;
    };
    // ParameterEasing<SIMD::Vec3f>
    %rename(ParameterEasingSIMDVec3BaseCore) ParameterEasing<SIMD::Vec3f>;
    struct ParameterEasing<SIMD::Vec3f> {
        RefMinMax RefEqS;
        RefMinMax RefEqE;
        RefMinMax RefEqM;

        Easing3Type type_ = Easing3Type::StartEndSpeed;
        std::array<float, 4> params;

        int32_t channelCount = 0;

        bool isMiddleEnabled = false;

        bool isIndividualEnabled = false;

        virtual SIMD::Vec3f GetValue(const InstanceEasing<SIMD::Vec3f>& instance, float time) const = 0;
    };
}