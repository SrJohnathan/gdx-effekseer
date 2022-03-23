#pragma once

#include "EffekseerBackendCore.h"
#include "EffekseerEffectCore.h"
#include "Effekseer.h"
#include "distortion.h"
#include "Vector4Map.h"
#include <array>






class EffekseerEffectCore;

typedef ::Effekseer::Vector3D Vector3D;
typedef ::Effekseer::Color Color;
typedef ::Effekseer::Manager::UpdateParameter UpdateParameter;
typedef ::Effekseer::Manager::DrawParameter DrawParameter;





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
    void LaunchWorkerThreads(uint32_t threadCount);

    bool Exists(int handle);

    int Play(EffekseerEffectCore *effect);
    void StopEffect(int handle);
    void StopAllEffects();
    void StopRoot(int handle);

    int32_t GetInstanceCount(int handle);
    int32_t GetTotalInstanceCount();

    float* GetMatrix(int handle);
    void SetMatrix(int handle,float matrix43[]);
    float* GetBaseMatrix(int handle);
    void SetBaseMatrix(int handle, float matrix43[]);
    Vector3D GetLocation(int handle);
    void SetLocation(int handle, float x, float y, float z);
    void SetLocation(int handle, const Vector3D& location);
    void AddLocation(int handle, const Vector3D& location);
    void SetRotation(int handle, float x, float y, float z);
    void SetRotation(int handle, const Vector3D& axis, float angle);
    void SetScale(int handle, float x, float y, float z);
    void SetAllColor(int handle, Color color);
    void SetTargetLocation(int handle, float x, float y, float z);
    void SetTargetLocation(int handle, const Vector3D& location);
    void SetProjectionMatrix(float matrix44[],float matrix44C[], bool view,float width,float height);

    float GetDynamicInput(int handle, int32_t index);
    void SetDynamicInput(int handle, int32_t index, float value);

    bool GetShown(int handle);
    void SetShown(int handle, bool shown);
    bool GetPaused(int handle);
    void SetPaused(int handle, bool paused);
    void SetPausedToAllEffects(bool paused);
    int GetLayer(int handle);
    void SetLayer(int handle, int32_t layer);
    int64_t GetGroupMask(int handle);
    void SetGroupMask(int handle, int64_t groupmask);

    float GetSpeed(int handle);
    void SetSpeed(int handle, float speed);
    void SetTimeScaleByGroup(int64_t groupmask, float timeScale);
    void SetTimeScaleByHandle(int handle, float timeScale);
    void SetAutoDrawing(int handle, bool autoDraw);
    //void* GetUserData(int handle);
    //void SetUserData(int handle, void* userData);

    void Flip();
    void Update(float deltaFrames);
    void Update(const UpdateParameter& parameter);
	void BeginUpdate();
	void EndUpdate();
	void UpdateHandle(int handle, float deltaFrame = 1.0f);
	void UpdateHandleToMoveToFrame(int handle, float frame);

    void BeginRendering();
    void Draw(const Effekseer::Manager::DrawParameter& drawParameter);
    void DrawBack();
    void DrawFront();
    void EndRendering();


 /*   void SetBackground(uint32_t glid,bool hasMipmap);
    void UnsetBackground();
    void SetDepth(uint32_t glid, bool hasMipmap);
    void UnsetDepth(); */

};
