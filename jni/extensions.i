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

// ParameterGenerationLocation
%extend Effekseer::ParameterGenerationLocation {
    // Point
    random_vector3d getPointLocation() { return self->point.location; }
    void setPointLocation(random_vector3d value) { self->point.location = value; }

    // Sphere
    random_float getSphereRadius() { return self->sphere.radius; }
    void setSphereRadius(random_float value) { self->sphere.radius = value; }
    random_float getSphereRotationX() { return self->sphere.rotation_x; }
    void setSphereRotationX(random_float value) { self->sphere.rotation_x = value; }
    random_float getSphereRotationY() { return self->sphere.rotation_y; }
    void setSphereRotationY(random_float value) { self->sphere.rotation_y = value; }

    // Model
    ModelReferenceType getModelReferenceType() { return self->model.Reference; }
    void setModelReferenceType(ModelReferenceType value) { self->model.Reference = value; }
    int32_t getModelIndex() { return self->model.index; }
    void setModelIndex(int32_t value) { self->model.index = value; }
    eModelType getModelType() { return self->model.type; }
    void setModelType(eModelType value) { self->model.type = value; }

    // Circle
    int32_t getCircleDivision() { return self->circle.division; }
    void setCircleDivision(int32_t value) { self->circle.division = value; }
    random_float getCircleRadius() { return self->circle.radius; }
    void setCircleRadius(random_float value) { self->circle.radius = value; }
    random_float getCircleAngleStart() { return self->circle.angle_start; }
    void setCircleAngleStart(random_float value) { self->circle.angle_start = value; }
    random_float getCircleAngleEnd() { return self->circle.angle_end; }
    void setCircleAngleEnd(random_float value) { self->circle.angle_end = value; }
    eCircleType getCircleType() { return self->circle.type; }
    void setCircleType(eCircleType value) { self->circle.type = value; }
    AxisType getCircleAxisDirection() { return self->circle.axisDirection; }
    void setCircleAxisDirection(AxisType value) { self->circle.axisDirection = value; }
    random_float getCircleAngleNoise() { return self->circle.angle_noize; }
    void setCircleAngleNoise(random_float value) { self->circle.angle_noize = value; }

    // Line
    int32_t getLineDivision() { return self->line.division; }
    void setLineDivision(int32_t value) { self->line.division = value; }
    random_vector3d getLinePositionStart() { return self->line.position_start; }
    void setLinePositionStart(random_vector3d value) { self->line.position_start = value; }
    random_vector3d getLinePositionEnd() { return self->line.position_end; }
    void setLinePositionEnd(random_vector3d value) { self->line.position_end = value; }
    random_float getLinePositionNoise() { return self->line.position_noize; }
    void setLinePositionNoise(random_float value) { self->line.position_noize = value; }
    LineType getLineType() { return self->line.type; }
    void setLineType(LineType value) { self->line.type = value; }
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