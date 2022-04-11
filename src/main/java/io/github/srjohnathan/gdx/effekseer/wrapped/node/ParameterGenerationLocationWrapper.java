package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import io.github.srjohnathan.gdx.effekseer.core.*;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;

import java.util.function.Function;

public class ParameterGenerationLocationWrapper {

    //region State

    public final ParameterGenerationLocation core;

    //region Field Wrappers

    //region Point

    private EffekseerFieldWrapper<InternalStructRandomVector3D> pointLocation = new EffekseerFieldWrapper<InternalStructRandomVector3D>(new Function<Void, InternalStructRandomVector3D>() {
        @Override
        public InternalStructRandomVector3D apply(Void unused) {
            return core.getPointLocation();
        }
    }, new Function<InternalStructRandomVector3D, Void>() {
        @Override
        public Void apply(InternalStructRandomVector3D value) {
            core.setPointLocation(value);
            return null;
        }
    });

    //endregion

    //region Sphere

    private EffekseerFieldWrapper<InternalStructRandomFloat> sphereRadius = new EffekseerFieldWrapper<InternalStructRandomFloat>(new Function<Void, InternalStructRandomFloat>() {
        @Override
        public InternalStructRandomFloat apply(Void unused) {
            return core.getSphereRadius();
        }
    }, new Function<InternalStructRandomFloat, Void>() {
        @Override
        public Void apply(InternalStructRandomFloat value) {
            core.setSphereRadius(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<InternalStructRandomFloat> sphereRotationX = new EffekseerFieldWrapper<InternalStructRandomFloat>(new Function<Void, InternalStructRandomFloat>() {
        @Override
        public InternalStructRandomFloat apply(Void unused) {
            return core.getSphereRotationX();
        }
    }, new Function<InternalStructRandomFloat, Void>() {
        @Override
        public Void apply(InternalStructRandomFloat value) {
            core.setSphereRotationX(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<InternalStructRandomFloat> sphereRotationY = new EffekseerFieldWrapper<InternalStructRandomFloat>(new Function<Void, InternalStructRandomFloat>() {
        @Override
        public InternalStructRandomFloat apply(Void unused) {
            return core.getSphereRotationY();
        }
    }, new Function<InternalStructRandomFloat, Void>() {
        @Override
        public Void apply(InternalStructRandomFloat value) {
            core.setSphereRotationY(value);
            return null;
        }
    });

    //endregion

    //region Circle

    private EffekseerFieldWrapper<InternalStructRandomFloat> circleRadius = new EffekseerFieldWrapper<InternalStructRandomFloat>(new Function<Void, InternalStructRandomFloat>() {
        @Override
        public InternalStructRandomFloat apply(Void unused) {
            return core.getCircleRadius();
        }
    }, new Function<InternalStructRandomFloat, Void>() {
        @Override
        public Void apply(InternalStructRandomFloat value) {
            core.setCircleRadius(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<InternalStructRandomFloat> circleAngleStart = new EffekseerFieldWrapper<InternalStructRandomFloat>(new Function<Void, InternalStructRandomFloat>() {
        @Override
        public InternalStructRandomFloat apply(Void unused) {
            return core.getCircleAngleStart();
        }
    }, new Function<InternalStructRandomFloat, Void>() {
        @Override
        public Void apply(InternalStructRandomFloat value) {
            core.setCircleAngleStart(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<InternalStructRandomFloat> circleAngleEnd = new EffekseerFieldWrapper<InternalStructRandomFloat>(new Function<Void, InternalStructRandomFloat>() {
        @Override
        public InternalStructRandomFloat apply(Void unused) {
            return core.getCircleAngleEnd();
        }
    }, new Function<InternalStructRandomFloat, Void>() {
        @Override
        public Void apply(InternalStructRandomFloat value) {
            core.setCircleAngleEnd(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<InternalStructRandomFloat> circleAngleNoise = new EffekseerFieldWrapper<InternalStructRandomFloat>(new Function<Void, InternalStructRandomFloat>() {
        @Override
        public InternalStructRandomFloat apply(Void unused) {
            return core.getCircleAngleNoise();
        }
    }, new Function<InternalStructRandomFloat, Void>() {
        @Override
        public Void apply(InternalStructRandomFloat value) {
            core.setCircleAngleNoise(value);
            return null;
        }
    });

    //endregion

    //region Line

    //endregion

    //endregion

    //region Constructors

    public ParameterGenerationLocationWrapper(ParameterGenerationLocation core) {
        this.core = core;
    }

    //endregion

    //region Wrapper Methods

    public void setEffectsRotation(int value) {
        core.setEffectsRotation(value);
    }

    public int getEffectsRotation() {
        return core.getEffectsRotation();
    }

    public void setType(int value) {
        core.setType(value);
    }

    public int getType() {
        return core.getType();
    }

    //region Point

    public InternalStructRandomVector3D getPointLocation() {
        return this.pointLocation.get();
    }

    public void setPointLocation(InternalStructRandomVector3D value) {
        this.pointLocation.set(value);
    }

    //endregion

    //region Sphere

    public InternalStructRandomFloat getSphereRadius() {
        return this.sphereRadius.get();
    }

    public void setSphereRadius(InternalStructRandomFloat value) {
        this.sphereRadius.set(value);
    }

    public InternalStructRandomFloat getSphereRotationX() {
        return this.sphereRotationX.get();
    }

    public void setSphereRotationX(InternalStructRandomFloat value) {
        this.sphereRotationX.set(value);
    }

    public InternalStructRandomFloat getSphereRotationY() {
        return this.sphereRotationY.get();
    }

    public void setSphereRotationY(InternalStructRandomFloat value) {
        this.sphereRotationY.set(value);
    }

    //endregion

    //region Model

    public ModelReferenceType getModelReferenceType() {
        return core.getModelReferenceType();
    }

    public void setModelReferenceType(ModelReferenceType value) {
        core.setModelReferenceType(value);
    }

    public int getModelIndex() {
        return core.getModelIndex();
    }

    public void setModelIndex(int value) {
        core.setModelIndex(value);
    }

    public ParameterGenerationLocation.eModelType getModelType() {
        return core.getModelType();
    }

    public void setModelType(ParameterGenerationLocation.eModelType value) {
        core.setModelType(value);
    }

    //endregion

    //region Circle

    public int getCircleDivision() {
        return core.getCircleDivision();
    }

    public void setCircleDivision(int value) {
        core.setCircleDivision(value);
    }

    public InternalStructRandomFloat getCircleRadius() {
        return this.circleRadius.get();
    }

    public void setCircleRadius(InternalStructRandomFloat value) {
        this.circleRadius.set(value);
    }

    public InternalStructRandomFloat getCircleAngleStart() {
        return this.circleAngleStart.get();
    }

    public void setCircleAngleStart(InternalStructRandomFloat value) {
        this.circleAngleStart.set(value);
    }

    public InternalStructRandomFloat getCircleAngleEnd() {
        return this.circleAngleEnd.get();
    }

    public void setCircleAngleEnd(InternalStructRandomFloat value) {
        this.circleAngleEnd.set(value);
    }

    public ParameterGenerationLocation.eCircleType getCircleType() {
        return core.getCircleType();
    }

    public void setCircleType(ParameterGenerationLocation.eCircleType value) {
        core.setCircleType(value);
    }

    public ParameterGenerationLocation.AxisType getCircleAxisDirection() {
        return core.getCircleAxisDirection();
    }

    public void setCircleAxisDirection(ParameterGenerationLocation.AxisType value) {
        core.setCircleAxisDirection(value);
    }

    public InternalStructRandomFloat getCircleAngleNoise() {
        return this.circleAngleNoise.get();
    }

    public void setCircleAngleNoise(InternalStructRandomFloat value) {
        this.circleAngleNoise.set(value);
    }

    //endregion

    //region Line

    public int getLineDivision() {
        return core.getLineDivision();
    }

    public void setLineDivision(int value) {
        core.setLineDivision(value);
    }

    public InternalStructRandomVector3D getLinePositionStart() {
        return core.getLinePositionStart();
    }

    public void setLinePositionStart(InternalStructRandomVector3D value) {
        core.setLinePositionStart(value);
    }

    public InternalStructRandomVector3D getLinePositionEnd() {
        return core.getLinePositionEnd();
    }

    public void setLinePositionEnd(InternalStructRandomVector3D value) {
        core.setLinePositionEnd(value);
    }

    public InternalStructRandomFloat getLinePositionNoise() {
        return core.getLinePositionNoise();
    }

    public void setLinePositionNoise(InternalStructRandomFloat value) {
        core.setLinePositionNoise(value);
    }

    public ParameterGenerationLocation.LineType getLineType() {
        return core.getLineType();
    }

    public void setLineType(ParameterGenerationLocation.LineType value) {
        core.setLineType(value);
    }

    //endregion

    //endregion
}
