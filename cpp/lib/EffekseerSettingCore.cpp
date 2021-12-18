//
// Created by Johnathan on 27/06/2020.
//

#include "EffekseerSettingCore.h"
#include "EffekseerRendererGL.h"
#include "EffekseerBackendCore.h"
#include <Effekseer.h>





class CustomTextureLoader : public Effekseer::TextureLoader
{
    Effekseer::TextureLoaderRef internalLoader_ = nullptr;

public:
    CustomTextureLoader(Effekseer::Backend::GraphicsDeviceRef graphicsDevice, bool isSrgbMode = false)
    {
        internalLoader_ = EffekseerRenderer::CreateTextureLoader(
            graphicsDevice, nullptr, isSrgbMode ? Effekseer::ColorSpaceType::Linear : Effekseer::ColorSpaceType::Gamma);
    }

    ~CustomTextureLoader() override = default;

public:
    Effekseer::TextureRef Load(const EFK_CHAR* path, Effekseer::TextureType textureType) override
    {
        // Invalid
        return nullptr;
    }

    Effekseer::TextureRef Load(const void* data, int32_t size, Effekseer::TextureType textureType, bool isMipMapEnabled) override
    {
        return internalLoader_->Load(data, size, textureType, isMipMapEnabled);
    }

    void Unload(Effekseer::TextureRef data) override { internalLoader_->Unload(data); }
};

class CustomModelLoader : public Effekseer::ModelLoader
{
    Effekseer::ModelLoaderRef internalLoader_ = nullptr;

public:
    CustomModelLoader(Effekseer::Backend::GraphicsDeviceRef graphicsDevice)
    {
        internalLoader_ = EffekseerRenderer::CreateModelLoader(graphicsDevice);
    }

    ~CustomModelLoader() override = default;

public:
    Effekseer::ModelRef Load(const EFK_CHAR* path) override
    {
        // Invalid
        return nullptr;
    }

    Effekseer::ModelRef Load(const void* data, int32_t size) override { return internalLoader_->Load(data, size); }

    void Unload(Effekseer::ModelRef data) override { internalLoader_->Unload(data); }
};

class CustomMaterialLoader : public Effekseer::MaterialLoader
{
    Effekseer::MaterialLoaderRef internalLoader_ = nullptr;

public:
    CustomMaterialLoader(Effekseer::Backend::GraphicsDeviceRef graphicsDevice)
    {
        internalLoader_ = EffekseerRendererGL::CreateMaterialLoader(graphicsDevice);
    }

    ~CustomMaterialLoader() override = default;

public:
    Effekseer::MaterialRef Load(const EFK_CHAR* path) override
    {
        // Invalid
        return nullptr;
    }

    Effekseer::MaterialRef Load(const void* data, int32_t size, Effekseer::MaterialFileType fileType) override
    {
        return internalLoader_->Load(data, size, fileType);
    }

    void Unload(Effekseer::MaterialRef data) override { internalLoader_->Unload(data); }
};









EffekseerSettingCore* EffekseerBackendCore::setting_ = nullptr;
Effekseer::RefPtr<EffekseerSettingCore> EffekseerSettingCore::effekseerSetting_ = nullptr;

EffekseerSettingCore::EffekseerSettingCore(bool isSrgbMode)
{

           // SetTextureLoader(Effekseer::MakeRefPtr<CustomTextureLoader>(this->graphicsDevice_, isSrgbMode));
           // SetModelLoader(Effekseer::MakeRefPtr<CustomModelLoader>(this->graphicsDevice_));
           // SetMaterialLoader(Effekseer::MakeRefPtr<CustomMaterialLoader>(this->graphicsDevice_));
           // SetCurveLoader(Effekseer::MakeRefPtr<Effekseer::CurveLoader>());

}

EffekseerSettingCore::~EffekseerSettingCore() {
       graphicsDevice_.Reset();


}

bool EffekseerSettingCore::IsValid() const
{
    return graphicsDevice_ != nullptr;
}

int EffekseerSettingCore::Release()
{
    auto ret = Effekseer::Setting::Release();
        if (ret == 1)
        {
            effekseerSetting_ = nullptr;
        }

        return ret;
}

Effekseer::RefPtr<EffekseerSettingCore> EffekseerSettingCore::create(bool isSrgbMode,Effekseer::Backend::GraphicsDeviceRef gra)
{
    if (effekseerSetting_ == nullptr)
        {
            effekseerSetting_ = Effekseer::MakeRefPtr<EffekseerSettingCore>(isSrgbMode);
            effekseerSetting_->graphicsDevice_ = gra;
            if (!effekseerSetting_->IsValid())
            {
                effekseerSetting_.Reset();
            }
        }

        return effekseerSetting_;
}

Effekseer::Backend::GraphicsDeviceRef EffekseerSettingCore::GetGraphicsDevice() const {
    return this->graphicsDevice_;
}







