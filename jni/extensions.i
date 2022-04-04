// StandardColorParameter
%extend Effekseer::StandardColorParameter {
    Effekseer::Color getFixed() { return self->fixed.all; }
    void setFixed(Effekseer::Color value) { self->fixed.all = value; }
    Effekseer::random_color getRandom() { return self->random.all; }
    void setRandom(Effekseer::random_color value) { self->random.all = value; }
    Effekseer::easing_color getEasing() { return self->easing.all; }
    void setEasing(Effekseer::easing_color value) { self->easing.all = value; }
    Effekseer::FCurveVectorColor* getFCurveRGBA() { return self->fcurve_rgba.FCurve; }
    void setFCurveRGBA(Effekseer::FCurveVectorColor* value) { self->fcurve_rgba.FCurve = value; }
};

// ParameterRendererCommon
%extend Effekseer::ParameterRendererCommon {
    int getUVTypes(int index) { return self->UVTypes[index]; }
    void setUVTypes(int index, int value) {
        if (value == Effekseer::ParameterRendererCommon::UV_DEFAULT) {
            self->UVTypes[index] = Effekseer::ParameterRendererCommon::UV_DEFAULT;
        }
        else if (value == Effekseer::ParameterRendererCommon::UV_FIXED) {
            self->UVTypes[index] = Effekseer::ParameterRendererCommon::UV_FIXED;
        }
        else if (value == Effekseer::ParameterRendererCommon::UV_ANIMATION) {
            self->UVTypes[index] = Effekseer::ParameterRendererCommon::UV_ANIMATION;
        }
        else if (value == Effekseer::ParameterRendererCommon::UV_SCROLL) {
            self->UVTypes[index] = Effekseer::ParameterRendererCommon::UV_SCROLL;
        }
        else if (value == Effekseer::ParameterRendererCommon::UV_FCURVE) {
            self->UVTypes[index] = Effekseer::ParameterRendererCommon::UV_FCURVE;
        }
        else if (value == Effekseer::ParameterRendererCommon::UV_DWORD) {
            self->UVTypes[index] = Effekseer::ParameterRendererCommon::UV_DWORD;
        }
        else {
            self->UVTypes[index] = Effekseer::ParameterRendererCommon::UV_DEFAULT;
        }
    }
};

// EffectNode
%extend Effekseer::EffectNode {
    Effekseer::EffectNodeImplemented* getChild(int index) {
        if (index >= self->GetChildrenCount())
            return nullptr;
        return static_cast<Effekseer::EffectNodeImplemented*>(self->GetChild(index));
    }

    Effekseer::EffectNodeSprite* getChildAsSprite(int index) {
        if (index >= self->GetChildrenCount())
            return nullptr;
        return static_cast<Effekseer::EffectNodeSprite*>(self->GetChild(index));
    }

    Effekseer::EffectNodeTrack* getChildAsTrack(int index) {
        if (index >= self->GetChildrenCount())
            return nullptr;
        return static_cast<Effekseer::EffectNodeTrack*>(self->GetChild(index));
    }
};

// SpriteColorParameter
%extend Effekseer::SpriteColorParameter {
    Effekseer::Color getFixedLowerLeftColor() { return self->fixed.ll; }
    void setFixedLowerLeftColor(Effekseer::Color value) { self->fixed.ll = value; }
    Effekseer::Color getFixedLowerRightColor() { return self->fixed.lr; }
    void setFixedLowerRightColor(Effekseer::Color value) { self->fixed.lr = value; }
    Effekseer::Color getFixedUpperLeftColor() { return self->fixed.ul; }
    void setFixedUpperLeftColor(Effekseer::Color value) { self->fixed.ul = value; }
    Effekseer::Color getFixedUpperRightColor() { return self->fixed.ur; }
    void setFixedUpperRightColor(Effekseer::Color value) { self->fixed.ur = value; }
};
// SpritePositionParameter
%extend Effekseer::SpritePositionParameter {
    Effekseer::SIMD::Vec2f getFixedLowerLeftPos() { return self->fixed.ll; }
    void setFixedLowerLeftPos(Effekseer::SIMD::Vec2f value) { self->fixed.ll = value; }
    Effekseer::SIMD::Vec2f getFixedLowerRightPos() { return self->fixed.lr; }
    void setFixedLowerRightPos(Effekseer::SIMD::Vec2f value) { self->fixed.lr = value; }
    Effekseer::SIMD::Vec2f getFixedUpperLeftPos() { return self->fixed.ul; }
    void setFixedUpperLeftPos(Effekseer::SIMD::Vec2f value) { self->fixed.ul = value; }
    Effekseer::SIMD::Vec2f getFixedUpperRightPos() { return self->fixed.ur; }
    void setFixedUpperRightPos(Effekseer::SIMD::Vec2f value) { self->fixed.ur = value; }
};

// TrackSizeParameter
%extend Effekseer::TrackSizeParameter {
    float getFixedSize() { return self->fixed.size; }
    void setFixedSize(float value) { self->fixed.size = value; }
};