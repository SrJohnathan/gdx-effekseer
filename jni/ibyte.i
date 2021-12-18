%typemap(jni) unsigned char *UBYTE "jbyteArray"
%typemap(jtype) unsigned char *UBYTE "byte[]"
%typemap(jstype) unsigned char *UBYTE "byte[]"
%typemap(in) unsigned char *UBYTE {
  $1 = (unsigned char *) JCALL2(GetByteArrayElements, jenv, $input, 0);
}

%typemap(argout) unsigned char *UBYTE {
  JCALL3(ReleaseByteArrayElements, jenv, $input, (jbyte *) $1, 0);
}

%typemap(javain) unsigned char *UBYTE "$javainput"

/* Prevent default freearg typemap from being used */
%typemap(freearg) unsigned char *UBYTE ""

/*
namespace Effekseer{

enum ParameterTranslationType
{
	ParameterTranslationType_Fixed = 0,
	ParameterTranslationType_PVA = 1,
	ParameterTranslationType_Easing = 2,
	ParameterTranslationType_FCurve = 3,
	ParameterTranslationType_NurbsCurve = 4,
	ParameterTranslationType_ViewOffset = 5,
	ParameterTranslationType_None = 0x7fffffff - 1,
	ParameterTranslationType_DWORD = 0x7fffffff,
};


enum ParameterRotationType
{
	ParameterRotationType_Fixed = 0,
	ParameterRotationType_PVA = 1,
	ParameterRotationType_Easing = 2,
	ParameterRotationType_AxisPVA = 3,
	ParameterRotationType_AxisEasing = 4,
	ParameterRotationType_FCurve = 5,
	ParameterRotationType_None = 0x7fffffff - 1,
	ParameterRotationType_DWORD = 0x7fffffff,
};

enum ParameterScalingType
{
	ParameterScalingType_Fixed = 0,
	ParameterScalingType_PVA = 1,
	ParameterScalingType_Easing = 2,
	ParameterScalingType_SinglePVA = 3,
	ParameterScalingType_SingleEasing = 4,
	ParameterScalingType_FCurve = 5,
	ParameterScalingType_None = 0x7fffffff - 1,
	ParameterScalingType_DWORD = 0x7fffffff,
};

}  */