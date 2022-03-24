#define NOMINMAX

#include "EffekseerEffectCore.h"
#include "EffekseerManagerCore.h"
#include<iostream>
#include <string>



static std::string convert(const char16_t* path)
{
    int start = 0;
    int end = 0;

    for (int i = 0; path[i] != 0; i++)
    {
        if (path[i] == u'/' || path[i] == u'\\')
        {
            start = i + 1;
        }
    }

    for (int i = start; path[i] != 0; i++)
    {
        if (path[i] == u'.')
        {
            end = i;
        }
    }

    std::vector<char> ret;

    for (int i = start; i < end; i++)
    {
        ret.push_back(path[i]);
    }
    ret.push_back(0);

    return std::string(ret.data());
}



EffekseerEffectCore::EffekseerEffectCore() {}

EffekseerEffectCore::~EffekseerEffectCore() {   }



const char16_t* EffekseerEffectCore::GetName() {
    if (effect_ == nullptr) {
        return nullptr;
    }

    return effect_->GetName();
}

void EffekseerEffectCore::SetName(const char16_t*name) {
    if (effect_ == nullptr) {
        return;
    }

    return effect_->SetName(name);
}

int EffekseerEffectCore::GetVersion() {
    if (effect_ == nullptr) {
        return -1;
    }

    return effect_->GetVersion();
}




/*
bool EffekseerEffectCore::load(EffekseerManagerCore *maneger,char* data, int len, float magnification) { return load((const unsigned char*)data, len, magnification); }

bool EffekseerEffectCore::load(EffekseerManagerCore *maneger,const unsigned char* data, int len, float magnification)
{
    effect_ = ::Effekseer::Effect::Create(EffekseerSettingCore::create().DownCast<Effekseer::Setting>(), (void*)data, len, magnification);
    return effect_ != nullptr;
} */

bool EffekseerEffectCore::load(EffekseerManagerCore *maneger, const unsigned char *data, int len, float magnification) {

 effect_ =  ::Effekseer:: Effect::Create (  maneger->manager_  , (void *) data, len, magnification);
    return effect_ != nullptr;

}





const char16_t *EffekseerEffectCore::GetTexturePath(int32_t index, EffekseerTextureType type) const {
    if (type == EffekseerTextureType::Color) {
        return effect_->GetColorImagePath(index);
    } else if (type == EffekseerTextureType::Normal) {
        return effect_->GetNormalImagePath(index);
    } else if (type == EffekseerTextureType::Distortion) {
        return effect_->GetDistortionImagePath(index);
    }



    return nullptr;
}

int32_t EffekseerEffectCore::GetTextureCount(EffekseerTextureType type) const {
    if (type == EffekseerTextureType::Color) {




        return effect_->GetColorImageCount();
    } else if (type == EffekseerTextureType::Normal) {
        return effect_->GetNormalImageCount();
    } else if (type == EffekseerTextureType::Distortion) {
        return effect_->GetDistortionImageCount();
    }



    return 0;
}


/*
bool EffekseerEffectCore::LoadTexturePath(const EFK_CHAR *data, EffekseerTextureType type) {

    auto loader = effect_->GetSetting()->GetTextureLoader();
    if (loader == nullptr) {
        return false;
    }

    auto texture = loader->Load(data, (Effekseer::TextureType) type);

    if (texture == nullptr) {
        return false;
    }


    return true;
}

*/

bool EffekseerEffectCore::LoadTexture(const unsigned char *data, int len, int32_t index, EffekseerTextureType type) {
    auto loader = effect_->GetSetting()->GetTextureLoader();

    if (loader == nullptr) {

#if defined(__EFFEKSEER_RENDERER_GLES2__)
        LOGD("nullptr effectLouder ");
#endif

        return false;

    }



    auto texture = loader->Load((const void *) data, len, (Effekseer::TextureType) type,true);

    if (texture == nullptr) {


#if defined(__EFFEKSEER_RENDERER_GLES2__)
        LOGD("not Loading texture ");
#endif
        return false;
    }

    effect_->SetTexture(index, (Effekseer::TextureType) type, texture);


    return true;
}

bool EffekseerEffectCore::HasTextureLoaded(int32_t index, EffekseerTextureType type) {

    if (type != EffekseerTextureType::Color)
        return effect_->GetColorImage(index) != nullptr;

    if (type != EffekseerTextureType::Normal)
        return effect_->GetNormalImage(index) != nullptr;

    if (type != EffekseerTextureType::Distortion)
        return effect_->GetDistortionImage(index) != nullptr;

    return false;
}

const char16_t * EffekseerEffectCore::GetModelPath(int32_t index) const { return effect_->GetModelPath(index); }

int32_t EffekseerEffectCore::GetModelCount() const { return effect_->GetModelCount(); }

bool EffekseerEffectCore::LoadModel(const unsigned char *data, int len, int32_t index) {
    auto loader = effect_->GetSetting()->GetModelLoader();
    if (loader == nullptr) {
        return false;
    }

    auto model = loader->Load((const void *) data, len);

    if (model == nullptr) {
        return false;
    }


    effect_->SetModel(index, model);

    return true;
}

bool EffekseerEffectCore::HasModelLoaded(int32_t index) { return effect_->GetModel(index) != nullptr; }


bool EffekseerEffectCore::LoadMaterial(const unsigned char *data, int len, int32_t index) {
    auto loader = effect_->GetSetting()->GetMaterialLoader();
    if (loader == nullptr) {
        return false;
    }

    auto material = loader->Load((const void *) data, len, Effekseer::MaterialFileType::Code);

    if (material == nullptr) {
        return false;
    }

    effect_->SetMaterial(index, material);

    return true;
}

bool EffekseerEffectCore::HasMaterialLoaded(int32_t index) { return effect_->GetMaterial(index) != nullptr; }

int32_t EffekseerEffectCore::GetMaterialCount() const { return effect_->GetMaterialCount(); }

int32_t EffekseerEffectCore::NodeCount()
{
    int i = effect_->GetRoot()->GetChildrenCount();
    return i;
}


Effekseer::EffectNodeImplemented* EffekseerEffectCore::GetRootNode() {
    return static_cast<Effekseer::EffectNodeImplemented*>(effect_->GetRoot());
}

Effekseer::EffectRef EffekseerEffectCore::GetInternal() const { return effect_; }

const char16_t * EffekseerEffectCore::GetMaterialPath(int32_t index) const { return effect_->GetMaterialPath(index); }




