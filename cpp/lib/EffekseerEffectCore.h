#pragma once


#if defined(__EFFEKSEER_RENDERER_GLES2__)

#include <android/log.h>

#define TAG "PARTICLES"

#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,    TAG, __VA_ARGS__)
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,     TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,     TAG, __VA_ARGS__)
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,    TAG, __VA_ARGS__)

#endif


#include "EffekseerBackendCore.h"
#include "Effekseer.h"
#include "EffekseerManagerCore.h"
#include "EffekseerSettingCore.h"
// Undefine min/max function
#ifdef max
    #undef max
#endif
#ifdef min
    #undef min
#endif
#include "Effekseer/Effekseer.EffectNode.h"
#include "Effekseer/Effekseer.EffectNodeRoot.h"

class EffekseerManagerCore;

enum class EffekseerTextureType
{
    Color,
    Normal,
    Distortion,
};

class EffekseerEffectCore
{
private:
    Effekseer::EffectRef effect_ = nullptr;

public:
    EffekseerEffectCore();
    ~EffekseerEffectCore();

    const char16_t* GetName();
    void SetName(const char16_t*name);
    int GetVersion();

    bool load(EffekseerManagerCore *manager,const unsigned char* data, int len, float magnification);
    // bool load(EffekseerManagerCore *manager);

    int32_t GetTextureCount(EffekseerTextureType type) const;
    const char16_t* GetTexturePath(int32_t index, EffekseerTextureType type) const;
    bool LoadTexture(const unsigned char* data, int len, int32_t index, EffekseerTextureType type);
    // bool LoadTexturePath(const EFK_CHAR *data, EffekseerTextureType type);
    bool HasTextureLoaded(int32_t index, EffekseerTextureType type);

    int32_t GetModelCount() const;
    const char16_t* GetModelPath(int32_t index) const;
    bool LoadModel(const unsigned char* data, int len, int32_t index);
    bool HasModelLoaded(int32_t index);

    int32_t GetMaterialCount() const;
    const char16_t* GetMaterialPath(int32_t index) const;
    bool LoadMaterial(const unsigned char* data, int len, int32_t index);
    bool HasMaterialLoaded(int32_t index);

    int32_t NodeCount();
    Effekseer::EffectNodeRoot* GetRootNode();

#ifndef SWIG
    Effekseer::EffectRef GetInternal() const;
    static Effekseer::Manager::DrawParameter drawParameter;
#endif

};
