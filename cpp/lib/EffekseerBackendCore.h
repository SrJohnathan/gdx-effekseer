#pragma once


#include "EffekseerRendererGL.h"
#include "Effekseer.h"
#include "EffekseerSettingCore.h"

enum class EffekseerCoreDeviceType
{
	Unknown,
	OpenGL,

};


class EffekseerBackendCore
{
     #ifndef SWIG
	static EffekseerCoreDeviceType deviceType_;
    static EffekseerSettingCore* setting_;
     #endif

public:
	EffekseerBackendCore() = default;
	~EffekseerBackendCore() = default;

    #ifndef SWIG
	static EffekseerCoreDeviceType GetDevice();
    #endif

	static bool InitializeAsOpenGL();

	static void Terminate();
};
