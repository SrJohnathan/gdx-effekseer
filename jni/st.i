

%module GDX
%{

#include "lib/EffekseerBackendCore.h"
#include "lib/EffekseerEffectCore.h"
#include "lib/EffekseerManagerCore.h"

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


namespace std {
    %template(VectorFloat) vector<float>;
};

// Forward declaration of classes/structs that will be included later on in this file
struct Effekseer::Manager::DrawParameter;

%include "/cpp/lib/EffekseerBackendCore.h"
%include "/cpp/lib/EffekseerEffectCore.h"
%include "/cpp/lib/EffekseerManagerCore.h"

// Ignore all classes
%rename($ignore, %$isclass) "";
// Ignore all functions
%rename($ignore, %$isfunction) "";

// Vector3D with only the fields and constructor and destructor
%rename("Vector3D", fullname=1) "Effekseer::Vector3D";
%rename("Vector3D", fullname=1) "Effekseer::Vector3D::Vector3D";
%rename("~Vector3D", fullname=1) "Effekseer::Vector3D::~Vector3D";
%rename("X", fullname=1) "Effekseer::Vector3D::X";
%rename("Y", fullname=1) "Effekseer::Vector3D::Y";
%rename("Z", fullname=1) "Effekseer::Vector3D::Z";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.Vector3D.h"

// Color with only the fields and constructor and destructor
%rename("Color", fullname=1) "Effekseer::Color";
%rename("Color", fullname=1) "Effekseer::Color::Vector3D";
%rename("~Color", fullname=1) "Effekseer::Color::~Vector3D";
%rename("R", fullname=1) "Effekseer::Color::R";
%rename("G", fullname=1) "Effekseer::Color::G";
%rename("B", fullname=1) "Effekseer::Color::B";
%rename("A", fullname=1) "Effekseer::Color::A";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.Color.h"

// The Effekseer Manager, with just the parameter structs
%rename("EffekseerManagerParameters", fullname=1) "Effekseer::Manager";
%rename("UpdateParameter", fullname=1) "Effekseer::Manager::UpdateParameter";
%rename("DrawParameter", fullname=1) "Effekseer::Manager::DrawParameter";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.Manager.h"






