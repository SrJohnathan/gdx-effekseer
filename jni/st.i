

%module GDX
%{

#include "lib/EffekseerBackendCore.h"
#include "lib/EffekseerEffectCore.h"
#include "lib/EffekseerManagerCore.h"
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

#define FillMeInAsSizeCannotBeDeterminedAutomatically = 16;

%}


%include "stdint.i"

%include "typemaps.i"
%include "./char16.i"
%include "various.i"
%include "arrays_java.i"
%include "std_vector.i"

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
};

// Forward declaration of classes/structs that will be included later on in this file
struct Effekseer::Manager::UpdateParameter;
struct Effekseer::Manager::DrawParameter;
struct Effekseer::Vector3D;
struct Effekseer::Color;

%include "/cpp/lib/EffekseerBackendCore.h"
%include "/cpp/lib/EffekseerEffectCore.h"
%include "/cpp/lib/EffekseerManagerCore.h"

// Ignore all classes
%rename($ignore, %$isclass) "";
// Ignore all functions
%rename($ignore, %$isfunction) "";

%include "effekseer_math.i"

// Color with only the fields and constructor and destructor
%rename("Color", fullname=1) "Effekseer::Color";
%rename("Color", fullname=1) "Effekseer::Color::Color";
%rename("~Color", fullname=1) "Effekseer::Color::~Color";
%rename("R", fullname=1) "Effekseer::Color::R";
%rename("G", fullname=1) "Effekseer::Color::G";
%rename("B", fullname=1) "Effekseer::Color::B";
%rename("A", fullname=1) "Effekseer::Color::A";
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