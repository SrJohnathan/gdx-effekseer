

%module GDX
%{

#include "lib/EffekseerBackendCore.h"
#include "lib/EffekseerEffectCore.h"
#include "lib/EffekseerManagerCore.h"
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.Base.h"
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/SIMD/Vec2f.h"
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/SIMD/Vec3f.h"
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.InternalStruct.h"
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/Parameter/Effekseer.Parameters.h"
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/Parameter/DynamicParameter.h"
// Undefine min/max function
#ifdef max
    #undef max
#endif
#ifdef min
    #undef min
#endif
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/Parameter/Easing.h"
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.FCurves.h"
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/Noise/CurlNoise.h"
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/ForceField/ForceFields.h"
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.EffectNode.h"
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.EffectNodeRoot.h"
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.EffectNodeSprite.h"
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.EffectNodeTrack.h"
#include "Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.EffectNodeModel.h"

#define FillMeInAsSizeCannotBeDeterminedAutomatically = 16;

%}


%include "stdint.i"

%include "typemaps.i"
%include "./char16.i"
%include "various.i"
%include "arrays_java.i"
%include "std_vector.i"
%include "std_array.i"

%include "carrays.i"

%apply float[] {float *};


%apply char *BYTE { char* data };


%include "./ibyte.i"
%apply unsigned char *UBYTE { unsigned char *data };

// void* from c++ to Object in Java
/*
%typemap(jni) void* "java.lang.Object"
%typemap(jtype) void* "java.lang.Object"
%typemap(jstype) void* "java.lang.Object"
%typemap(javain) void* "$javainput"
%typemap(javaout) void* {
    return $jnicall;
}
*/


namespace std {
    %template(VectorFloat) vector<float>;
    %template(FloatArray2) array<float, 2>;
    %template(FloatArray3) array<float, 3>;
    %template(FloatArray4) array<float, 4>;
    %template(VectorFloatArray4) vector<array<float, 4>>;
};

// Forward declaration of classes/structs that will be included later on in this file
struct Effekseer::Manager::UpdateParameter;
struct Effekseer::Manager::DrawParameter;
struct Effekseer::Vector3D;
struct Effekseer::Color;

%include "/cpp/lib/EffekseerBackendCore.h"
%include "/cpp/lib/EffekseerEffectCore.h"
%include "/cpp/lib/EffekseerManagerCore.h"

%include "extensions.i"

// Ignore all classes
%rename($ignore, %$isclass) "";
// Ignore all functions
%rename($ignore, %$isfunction) "";
// Un-ignore all methods in std vector classes
%rename("%s") "std::vector::reserve";
%rename("%s") "std::vector::doGet";
%rename("%s") "std::vector::doSet";
%rename("%s") "std::vector::doAdd";
%rename("%s") "std::vector::doRemove";
%rename("%s") "std::vector::doRemoveRange";
%rename("%s") "std::vector::doSize";
// Un-ignore all methods in std array classes
%rename("%s") "std::array::size";
%rename("%s") "std::array::isEmpty";
%rename("%s") "std::array::fill";
%rename("%s") "std::array::get";
%rename("%s") "std::array::set";

%include "effekseer_math.i"

// Color with only the fields and constructor and destructor
%rename("Color", fullname=1) "Effekseer::Color";
%rename("Color", fullname=1) "Effekseer::Color::Color";
%rename("~Color", fullname=1) "Effekseer::Color::~Color";
%rename("r", fullname=1) "Effekseer::Color::R";
%rename("g", fullname=1) "Effekseer::Color::G";
%rename("b", fullname=1) "Effekseer::Color::B";
%rename("a", fullname=1) "Effekseer::Color::A";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.Color.h"

%include "effekseer_base.i"

%include "effekseer_parameters.i"

// All needed enum classes and structs in Effekseer.FCurves.h
%rename("EffectNodeImplemented", fullname=1) "Effekseer::EffectNodeImplemented";
%rename("FCurve", fullname=1) "Effekseer::FCurve";
%rename("FCurveScalar", fullname=1) "Effekseer::FCurveScalar";
%rename("FCurveVector2D", fullname=1) "Effekseer::FCurveVector2D";
%rename("FCurveVector3D", fullname=1) "Effekseer::FCurveVector3D";
%rename("FCurveVectorColor", fullname=1) "Effekseer::FCurveVectorColor";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.FCurves.h"

%include "effekseer_noise.i"

%include "effekseer_force_fields.i"

%include "effekseer_effect.i"
%include "effekseer_effect_nodes.i"


// The Effekseer Manager, with just the parameter structs
%rename("EffekseerManagerParameters", fullname=1) "Effekseer::Manager";
%rename("UpdateParameter", fullname=1) "Effekseer::Manager::UpdateParameter";
%rename("UpdateParameter", fullname=1) "Effekseer::Manager::UpdateParameter::UpdateParameter";
%rename("DrawParameter", fullname=1) "Effekseer::Manager::DrawParameter";
%rename("DrawParameter", fullname=1) "Effekseer::Manager::DrawParameter::DrawParameter";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.Manager.h"