#include "EffekseerBackendCore.h"
#include "Effekseer.h"
#include "EffekseerRendererGL.h"


EffekseerCoreDeviceType EffekseerBackendCore::deviceType_ = EffekseerCoreDeviceType::Unknown;
EffekseerCoreDeviceType EffekseerBackendCore::GetDevice() { return deviceType_; }

bool EffekseerBackendCore::InitializeAsOpenGL()
{
    deviceType_ = EffekseerCoreDeviceType::OpenGL;
    return true;
}

void EffekseerBackendCore::Terminate() {}


