#pragma once

#include <Effekseer.h>
#include "EffekseerRendererGL.h"


class EffekseerSettingCore : public ::Effekseer::Setting {


private:
    static Effekseer::RefPtr<EffekseerSettingCore> effekseerSetting_;
    Effekseer::Backend::GraphicsDeviceRef graphicsDevice_ = nullptr;

public:

    EffekseerSettingCore(bool isSrgbMode = false);

    ~EffekseerSettingCore() override;



    bool IsValid() const;

    int Release() override;

    Effekseer::Backend::GraphicsDeviceRef GetGraphicsDevice() const;

    static Effekseer::RefPtr<EffekseerSettingCore> create(bool isSrgbMode = false,Effekseer::Backend::GraphicsDeviceRef gra = nullptr);


};



