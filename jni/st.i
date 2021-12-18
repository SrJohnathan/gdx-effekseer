

%module GDX
%{

#include "lib/EffekseerBackendCore.h"
#include "lib/EffekseerEffectCore.h"
#include "lib/EffekseerManagerCore.h"


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






%include "/cpp/lib/EffekseerBackendCore.h"
%include "/cpp/lib/EffekseerEffectCore.h"
%include "/cpp/lib/EffekseerManagerCore.h"







