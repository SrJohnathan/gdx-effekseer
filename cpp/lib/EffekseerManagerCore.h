#pragma once

#include "EffekseerBackendCore.h"
#include "EffekseerEffectCore.h"
#include "Effekseer.h"
#include "distortion.h"
#include "Vector4Map.h"
#include <array>






class EffekseerEffectCore;





class EffekseerManagerCore {
private:
     Effekseer::RefPtr<EffekseerSettingCore> settingCore = nullptr;
     EffekseerRenderer::RendererRef renderer_ = nullptr;
    float restDeltaTime_ = 0.0f;
    DistortingCallbackGL *disto = nullptr;
    ::Effekseer::Backend::TextureRef backgroundtx_;
    ::Effekseer::Backend::TextureRef depthtx_;
    EffekseerRendererGL::OpenGLDeviceType openglDeviceType = EffekseerRendererGL::OpenGLDeviceType::OpenGL2;
    ::EffekseerRenderer::DistortingCallback* distortingCallback = nullptr;

public:
    EffekseerManagerCore() = default;

    ~EffekseerManagerCore();

#ifndef SWIG
    Effekseer::ManagerRef manager_ = nullptr;
#endif
    bool Initialize(int32_t spriteMaxCount, int32_t id, bool isSrgbMode);
    void Update(float deltaFrames);
    int Play(EffekseerEffectCore *effect);
    bool isPlaying(int handle);
    float Speed(int handle);
 /*   bool Exists(int handle);
    void SetDynamicInput(int handle, int32_t index, float value);
    float GetDynamicInput(int handle, int32_t index);
    void LaunchWorkerThreads(int32_t n); */
    void DrawBack();
    void DrawFront();
    void SetPause(int handle,bool pause);
    void SetProjectionMatrix(float matrix44[],float matrix44C[], bool view,float width,float heith);
    void SetEffectRotateAxis(int handle, float x, float y, float z,float angle);
    void SetEffectPosition(int handle, float x, float y, float z);
    void SetEffectScale(int handle, float x, float y, float z);
    void Stop(int i);
    int32_t InstanceCount(int handle);


    float* GetMatrix(int handle);


    void SetMatrix(int handle,float matrix43[]);


 /*   void SetBackground(uint32_t glid,bool hasMipmap);
    void UnsetBackground();
    void SetDepth(uint32_t glid, bool hasMipmap);
    void UnsetDepth(); */

};
