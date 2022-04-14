#pragma once

#include "Effekseer.h"

// TextureRef
class TextureRefWrapper {
private:
    Effekseer::TextureRef textureRef = nullptr;
    TextureRefWrapper(Effekseer::TextureRef textureRef);

public:
    bool hasRef = false;
    ~TextureRefWrapper();

friend class EffekseerEffectCore;
};

// ModelRef
class ModelRefWrapper {
private:
    Effekseer::ModelRef modelRef = nullptr;
    ModelRefWrapper(Effekseer::ModelRef modelRef);

public:
    bool hasRef = false;
    ~ModelRefWrapper();

friend class EffekseerEffectCore;
};

// MaterialRef
class MaterialRefWrapper {
private:
    Effekseer::MaterialRef materialRef = nullptr;
    MaterialRefWrapper(Effekseer::MaterialRef materialRef);

public:
    bool hasRef = false;
    ~MaterialRefWrapper();

friend class EffekseerEffectCore;
};
