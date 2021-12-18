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
//#include "effekseernode.h"

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
    Effekseer::EffectNode* node = nullptr;
  //  EffekseerNode *efknode = nullptr;

public:
    EffekseerEffectCore();
    ~EffekseerEffectCore();


    bool load(EffekseerManagerCore *maneger,const unsigned char* data, int len, float magnification);


  //  bool load(EffekseerManagerCore *maneger);

    const char16_t* GetTexturePath(int32_t index, EffekseerTextureType type) const;

    int32_t GetTextureCount(EffekseerTextureType type) const;


    bool LoadTexture(const unsigned char* data, int len, int32_t index, EffekseerTextureType type);

   // bool LoadTexturePath(const EFK_CHAR *data, EffekseerTextureType type);

    bool HasTextureLoaded(int32_t index, EffekseerTextureType type);

    const char16_t* GetModelPath(int32_t index) const;

    int32_t GetModelCount() const;

  //  EffekseerNode getNode();


    bool LoadModel(const unsigned char* data, int len, int32_t index);


    bool HasModelLoaded(int32_t index);

    const char16_t* GetMaterialPath(int32_t index) const;


    bool LoadMaterial(const unsigned char* data, int len, int32_t index);


    bool HasMaterialLoaded(int32_t index);

    int32_t GetMaterialCount() const;
    int32_t NodeCount();

#ifndef SWIG
    Effekseer::EffectRef GetInternal() const;
     static Effekseer::Manager::DrawParameter drawParameter;
#endif

};
