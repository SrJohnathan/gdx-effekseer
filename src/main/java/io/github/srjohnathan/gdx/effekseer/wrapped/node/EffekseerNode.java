package io.github.srjohnathan.gdx.effekseer.wrapped.node;

import com.badlogic.gdx.utils.Array;
import io.github.srjohnathan.gdx.effekseer.core.*;
import io.github.srjohnathan.gdx.effekseer.wrapped.EffekseerFieldWrapper;
import io.github.srjohnathan.gdx.effekseer.wrapped.ParticleEffekseer;

import java.util.function.Function;

/**
 * Wrapper class that wraps an {@link EffectNodeImplemented} to avoid instance creation of wrapped Effekseer classes/structs
 * everytime a get method is called.
 */
@SuppressWarnings("Convert2Lambda")
public class EffekseerNode<T extends EffectNodeImplemented> {

    //region State

    protected ParticleEffekseer effect;
    protected T coreNode;
    private Array<EffekseerNode> children = new Array<>(0);

    //region Field Wrappers

    private EffekseerFieldWrapper<EffectBasicRenderParameter> effectBasicRenderParameter = new EffekseerFieldWrapper<EffectBasicRenderParameter>(new Function<Void, EffectBasicRenderParameter>() {
        @Override
        public EffectBasicRenderParameter apply(Void unused) {
            return coreNode.getBasicRenderParameter();
        }
    }, new Function<EffectBasicRenderParameter, Void>() {
        @Override
        public Void apply(EffectBasicRenderParameter value) {
            coreNode.setBasicRenderParameter(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<EffectModelParameter> effectModelParameter = new EffekseerFieldWrapper<EffectModelParameter>(new Function<Void, EffectModelParameter>() {
        @Override
        public EffectModelParameter apply(Void unused) {
            return coreNode.getEffectModelParameter();
        }
    }, new Function<EffectModelParameter, Void>() {
        @Override
        public Void apply(EffectModelParameter value) {
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterCommonValues> commonValues = new EffekseerFieldWrapper<ParameterCommonValues>(new Function<Void, ParameterCommonValues>() {
        @Override
        public ParameterCommonValues apply(Void unused) {
            return coreNode.getCommonValues();
        }
    }, new Function<ParameterCommonValues, Void>() {
        @Override
        public Void apply(ParameterCommonValues value) {
            coreNode.setCommonValues(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<SteeringBehaviorParameter> steeringBehaviorParameter = new EffekseerFieldWrapper<SteeringBehaviorParameter>(new Function<Void, SteeringBehaviorParameter>() {
        @Override
        public SteeringBehaviorParameter apply(Void unused) {
            return coreNode.getSteeringBehaviorParam();
        }
    }, new Function<SteeringBehaviorParameter, Void>() {
        @Override
        public Void apply(SteeringBehaviorParameter value) {
            coreNode.setSteeringBehaviorParam(value);
            return null;
        }
    });

    //region Translation

    private EffekseerFieldWrapper<ParameterTranslationFixed> translationFixed = new EffekseerFieldWrapper<ParameterTranslationFixed>(new Function<Void, ParameterTranslationFixed>() {
        @Override
        public ParameterTranslationFixed apply(Void unused) {
            return coreNode.getTranslationFixed();
        }
    }, new Function<ParameterTranslationFixed, Void>() {
        @Override
        public Void apply(ParameterTranslationFixed value) {
            coreNode.setTranslationFixed(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterTranslationPVA> translationPVA = new EffekseerFieldWrapper<ParameterTranslationPVA>(new Function<Void, ParameterTranslationPVA>() {
        @Override
        public ParameterTranslationPVA apply(Void unused) {
            return coreNode.getTranslationPVA();
        }
    }, new Function<ParameterTranslationPVA, Void>() {
        @Override
        public Void apply(ParameterTranslationPVA value) {
            coreNode.setTranslationPVA(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterEasingSIMDVec3> translationEasing = new EffekseerFieldWrapper<ParameterEasingSIMDVec3>(new Function<Void, ParameterEasingSIMDVec3>() {
        @Override
        public ParameterEasingSIMDVec3 apply(Void unused) {
            return coreNode.getTranslationEasing();
        }
    }, new Function<ParameterEasingSIMDVec3, Void>() {
        @Override
        public Void apply(ParameterEasingSIMDVec3 value) {
            coreNode.setTranslationEasing(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<FCurveVector3D> translationFCurve = new EffekseerFieldWrapper<FCurveVector3D>(new Function<Void, FCurveVector3D>() {
        @Override
        public FCurveVector3D apply(Void unused) {
            return coreNode.getTranslationFCurve();
        }
    }, new Function<FCurveVector3D, Void>() {
        @Override
        public Void apply(FCurveVector3D value) {
            coreNode.setTranslationFCurve(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterTranslationNurbsCurve> translationNurbsCurve = new EffekseerFieldWrapper<ParameterTranslationNurbsCurve>(new Function<Void, ParameterTranslationNurbsCurve>() {
        @Override
        public ParameterTranslationNurbsCurve apply(Void unused) {
            return coreNode.getTranslationNurbsCurve();
        }
    }, new Function<ParameterTranslationNurbsCurve, Void>() {
        @Override
        public Void apply(ParameterTranslationNurbsCurve value) {
            coreNode.setTranslationNurbsCurve(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterTranslationViewOffset> translationViewOffset = new EffekseerFieldWrapper<ParameterTranslationViewOffset>(new Function<Void, ParameterTranslationViewOffset>() {
        @Override
        public ParameterTranslationViewOffset apply(Void unused) {
            return coreNode.getTranslationViewOffset();
        }
    }, new Function<ParameterTranslationViewOffset, Void>() {
        @Override
        public Void apply(ParameterTranslationViewOffset value) {
            coreNode.setTranslationViewOffset(value);
            return null;
        }
    });

    //endregion

    //region Rotation

    private EffekseerFieldWrapper<ParameterRotationFixed> rotationFixed = new EffekseerFieldWrapper<ParameterRotationFixed>(new Function<Void, ParameterRotationFixed>() {
        @Override
        public ParameterRotationFixed apply(Void unused) {
            return coreNode.getRotationFixed();
        }
    }, new Function<ParameterRotationFixed, Void>() {
        @Override
        public Void apply(ParameterRotationFixed value) {
            coreNode.setRotationFixed(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterRotationPVA> rotationPVA = new EffekseerFieldWrapper<ParameterRotationPVA>(new Function<Void, ParameterRotationPVA>() {
        @Override
        public ParameterRotationPVA apply(Void unused) {
            return coreNode.getRotationPVA();
        }
    }, new Function<ParameterRotationPVA, Void>() {
        @Override
        public Void apply(ParameterRotationPVA value) {
            coreNode.setRotationPVA(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterEasingSIMDVec3> rotationEasing = new EffekseerFieldWrapper<ParameterEasingSIMDVec3>(new Function<Void, ParameterEasingSIMDVec3>() {
        @Override
        public ParameterEasingSIMDVec3 apply(Void unused) {
            return coreNode.getRotationEasing();
        }
    }, new Function<ParameterEasingSIMDVec3, Void>() {
        @Override
        public Void apply(ParameterEasingSIMDVec3 value) {
            coreNode.setRotationEasing(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<FCurveVector3D> rotationFCurve = new EffekseerFieldWrapper<FCurveVector3D>(new Function<Void, FCurveVector3D>() {
        @Override
        public FCurveVector3D apply(Void unused) {
            return coreNode.getRotationFCurve();
        }
    }, new Function<FCurveVector3D, Void>() {
        @Override
        public Void apply(FCurveVector3D value) {
            coreNode.setRotationFCurve(value);
            return null;
        }
    });

    //endregion

    //region Rotation Axis

    private EffekseerFieldWrapper<ParameterRotationAxisPVA> rotationAxisPVA = new EffekseerFieldWrapper<ParameterRotationAxisPVA>(new Function<Void, ParameterRotationAxisPVA>() {
        @Override
        public ParameterRotationAxisPVA apply(Void unused) {
            return coreNode.getRotationAxisPVA();
        }
    }, new Function<ParameterRotationAxisPVA, Void>() {
        @Override
        public Void apply(ParameterRotationAxisPVA value) {
            coreNode.setRotationAxisPVA(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterRotationAxisEasing> rotationAxisEasing = new EffekseerFieldWrapper<ParameterRotationAxisEasing>(new Function<Void, ParameterRotationAxisEasing>() {
        @Override
        public ParameterRotationAxisEasing apply(Void unused) {
            return coreNode.getRotationAxisEasing();
        }
    }, new Function<ParameterRotationAxisEasing, Void>() {
        @Override
        public Void apply(ParameterRotationAxisEasing value) {
            coreNode.setRotationAxisEasing(value);
            return null;
        }
    });

    //endregion

    //region Scaling

    private EffekseerFieldWrapper<ParameterScalingFixed> scalingFixed = new EffekseerFieldWrapper<ParameterScalingFixed>(new Function<Void, ParameterScalingFixed>() {
        @Override
        public ParameterScalingFixed apply(Void unused) {
            return coreNode.getScalingFixed();
        }
    }, new Function<ParameterScalingFixed, Void>() {
        @Override
        public Void apply(ParameterScalingFixed value) {
            coreNode.setScalingFixed(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterScalingPVA> scalingPVA = new EffekseerFieldWrapper<ParameterScalingPVA>(new Function<Void, ParameterScalingPVA>() {
        @Override
        public ParameterScalingPVA apply(Void unused) {
            return coreNode.getScalingPVA();
        }
    }, new Function<ParameterScalingPVA, Void>() {
        @Override
        public Void apply(ParameterScalingPVA value) {
            coreNode.setScalingPVA(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterScalingSinglePVA> scalingSinglePVA = new EffekseerFieldWrapper<ParameterScalingSinglePVA>(new Function<Void, ParameterScalingSinglePVA>() {
        @Override
        public ParameterScalingSinglePVA apply(Void unused) {
            return coreNode.getScalingSinglePVA();
        }
    }, new Function<ParameterScalingSinglePVA, Void>() {
        @Override
        public Void apply(ParameterScalingSinglePVA value) {
            coreNode.setScalingSinglePVA(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterEasingSIMDVec3> scalingEasing = new EffekseerFieldWrapper<ParameterEasingSIMDVec3>(new Function<Void, ParameterEasingSIMDVec3>() {
        @Override
        public ParameterEasingSIMDVec3 apply(Void unused) {
            return coreNode.getScalingEasing();
        }
    }, new Function<ParameterEasingSIMDVec3, Void>() {
        @Override
        public Void apply(ParameterEasingSIMDVec3 value) {
            coreNode.setScalingEasing(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterEasingFloat> scalingSingleEasing = new EffekseerFieldWrapper<ParameterEasingFloat>(new Function<Void, ParameterEasingFloat>() {
        @Override
        public ParameterEasingFloat apply(Void unused) {
            return coreNode.getScalingSingleEasing();
        }
    }, new Function<ParameterEasingFloat, Void>() {
        @Override
        public Void apply(ParameterEasingFloat value) {
            coreNode.setScalingSingleEasing(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<FCurveVector3D> scalingFCurve = new EffekseerFieldWrapper<FCurveVector3D>(new Function<Void, FCurveVector3D>() {
        @Override
        public FCurveVector3D apply(Void unused) {
            return coreNode.getScalingFCurve();
        }
    }, new Function<FCurveVector3D, Void>() {
        @Override
        public Void apply(FCurveVector3D value) {
            coreNode.setScalingFCurve(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<FCurveScalar> scalingSingleFCurve = new EffekseerFieldWrapper<FCurveScalar>(new Function<Void, FCurveScalar>() {
        @Override
        public FCurveScalar apply(Void unused) {
            return coreNode.getScalingSingleFCurve();
        }
    }, new Function<FCurveScalar, Void>() {
        @Override
        public Void apply(FCurveScalar value) {
            coreNode.setScalingSingleFCurve(value);
            return null;
        }
    });

    //endregion

    private EffekseerFieldWrapper<ParameterGenerationLocation> generationLocation = new EffekseerFieldWrapper<ParameterGenerationLocation>(new Function<Void, ParameterGenerationLocation>() {
        @Override
        public ParameterGenerationLocation apply(Void unused) {
            return coreNode.getGenerationLocation();
        }
    }, new Function<ParameterGenerationLocation, Void>() {
        @Override
        public Void apply(ParameterGenerationLocation value) {
            coreNode.setGenerationLocation(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterDepthValues> depthValues = new EffekseerFieldWrapper<ParameterDepthValues>(new Function<Void, ParameterDepthValues>() {
        @Override
        public ParameterDepthValues apply(Void unused) {
            return coreNode.getDepthValues();
        }
    }, new Function<ParameterDepthValues, Void>() {
        @Override
        public Void apply(ParameterDepthValues value) {
            coreNode.setDepthValues(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterRendererCommon> rendererCommon = new EffekseerFieldWrapper<ParameterRendererCommon>(new Function<Void, ParameterRendererCommon>() {
        @Override
        public ParameterRendererCommon apply(Void unused) {
            return coreNode.getRendererCommon();
        }
    }, new Function<ParameterRendererCommon, Void>() {
        @Override
        public Void apply(ParameterRendererCommon value) {
            coreNode.setRendererCommon(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<ParameterAlphaCutoff> alphaCutoff = new EffekseerFieldWrapper<ParameterAlphaCutoff>(new Function<Void, ParameterAlphaCutoff>() {
        @Override
        public ParameterAlphaCutoff apply(Void unused) {
            return coreNode.getAlphaCutoff();
        }
    }, new Function<ParameterAlphaCutoff, Void>() {
        @Override
        public Void apply(ParameterAlphaCutoff value) {
            coreNode.setAlphaCutoff(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<FalloffParameter> falloffParameter = new EffekseerFieldWrapper<FalloffParameter>(new Function<Void, FalloffParameter>() {
        @Override
        public FalloffParameter apply(Void unused) {
            return coreNode.getFalloffParam();
        }
    }, new Function<FalloffParameter, Void>() {
        @Override
        public Void apply(FalloffParameter value) {
            coreNode.setFalloffParam(value);
            return null;
        }
    });

    private EffekseerFieldWrapper<DynamicFactorParameter> dynamicFactorParameter = new EffekseerFieldWrapper<DynamicFactorParameter>(new Function<Void, DynamicFactorParameter>() {
        @Override
        public DynamicFactorParameter apply(Void unused) {
            return coreNode.getDynamicFactor();
        }
    }, new Function<DynamicFactorParameter, Void>() {
        @Override
        public Void apply(DynamicFactorParameter value) {
            coreNode.setDynamicFactor(value);
            return null;
        }
    });

    //endregion

    //endregion

    //region Constructors

    public EffekseerNode(ParticleEffekseer effect, T coreNode) {
        this.effect = effect;
        this.coreNode = coreNode;
    }

    //endregion

    //region Private Methods

    private void ensureChildrenArraySize() {
        int childCount = this.coreNode.getChildrenCount();

        // Make sure the children array is sized to fit all children
        if (childCount > 0 && this.children.size < childCount) {
            this.children.ensureCapacity(childCount);

            // Fill all empty slots with nulls
            var currentIndexToFill = this.children.size;
            while (currentIndexToFill < childCount) {
                this.children.add(null);
                currentIndexToFill += 1;
            }
        }
    }

    //endregion

    //region Public Methods

    public ParticleEffekseer getEffect() {
        return this.effect;
    }

    //endregion

    //region Wrapper Methods

    public int getType() {
        return 0;
    }

    public int getGeneration() {
        return this.coreNode.getGeneration();
    }

    public int getChildrenCount() {
        return this.coreNode.getChildrenCount();
    }

    public EffekseerNode<?> getChild(int index) {
        // First make sure the cached children array is sized properly (should only be needed the first time this gets called
        // after this node is loaded from an effect).
        this.ensureChildrenArraySize();

        // Get if already cached.
        EffekseerNode<?> cachedNode = this.children.get(index);

        // If it wasn't cached get the node from Effekseer and cache it
        if (cachedNode == null) {
            EffectNodeImplemented coreChildNode = this.coreNode.getChild(index);

            // Check for specific node type
            eEffectNodeType childNodeType = coreChildNode.getType();
            if (childNodeType == eEffectNodeType.EFFECT_NODE_TYPE_SPRITE) {
                // Set the cached sprite node
                cachedNode = new EffekseerNodeSprite(this.effect, this.coreNode.getChildAsSprite(index));
            }
            else if (childNodeType == eEffectNodeType.EFFECT_NODE_TYPE_TRACK) {
                // Set the cached track node
                cachedNode = new EffekseerNodeTrack(this.effect, this.coreNode.getChildAsTrack(index));
            }
            else {
                // Default node instance
                cachedNode = new EffekseerNode<EffectNodeImplemented>(this.effect, this.coreNode.getChild(index));
            }

            this.children.set(index, cachedNode);
        }

        return cachedNode;
    }

    public EffectBasicRenderParameter getBasicRenderParameter() {
        return this.effectBasicRenderParameter.get();
    }

    public void setBasicRenderParameter(EffectBasicRenderParameter param) {
        this.effectBasicRenderParameter.set(param);
    }

    public EffectModelParameter getEffectModelParameter() {
        return this.effectModelParameter.get();
    }

    public EffectInstanceTerm calculateInstanceTerm(EffectInstanceTerm parentTerm) {
        return this.coreNode.calculateInstanceTerm(parentTerm);
    }

    public void setIsRendered(boolean value) {
        this.coreNode.setIsRendered(value);
    }

    public boolean getIsRendered() {
        return coreNode.getIsRendered();
    }

    public void setCommonValues(ParameterCommonValues value) {
        this.commonValues.set(value);
    }

    public ParameterCommonValues getCommonValues() {
        return this.commonValues.get();
    }

    public void setSteeringBehaviorParam(SteeringBehaviorParameter value) {
        this.steeringBehaviorParameter.set(value);
    }

    public SteeringBehaviorParameter getSteeringBehaviorParam() {
        return this.steeringBehaviorParameter.get();
    }

    public void setTranslationType(ParameterTranslationType value) {
        this.coreNode.setTranslationType(value);
    }

    public ParameterTranslationType getTranslationType() {
        return this.coreNode.getTranslationType();
    }

    public void setTranslationFixed(ParameterTranslationFixed value) {
        this.translationFixed.set(value);
    }

    public ParameterTranslationFixed getTranslationFixed() {
        return this.translationFixed.get();
    }

    public void setTranslationPVA(ParameterTranslationPVA value) {
        this.translationPVA.set(value);
    }

    public ParameterTranslationPVA getTranslationPVA() {
        return this.translationPVA.get();
    }

    public void setTranslationEasing(ParameterEasingSIMDVec3 value) {
        this.translationEasing.set(value);
    }

    public ParameterEasingSIMDVec3 getTranslationEasing() {
        return this.translationEasing.get();
    }

    public void setTranslationFCurve(FCurveVector3D value) {
        this.translationFCurve.set(value);
    }

    public FCurveVector3D getTranslationFCurve() {
        return this.translationFCurve.get();
    }

    public void setTranslationNurbsCurve(ParameterTranslationNurbsCurve value) {
        this.translationNurbsCurve.set(value);
    }

    public ParameterTranslationNurbsCurve getTranslationNurbsCurve() {
        return this.translationNurbsCurve.get();
    }

    public void setTranslationViewOffset(ParameterTranslationViewOffset value) {
        this.translationViewOffset.set(value);
    }

    public ParameterTranslationViewOffset getTranslationViewOffset() {
        return this.translationViewOffset.get();
    }

    public void setRotationType(ParameterRotationType value) {
        this.coreNode.setRotationType(value);
    }

    public ParameterRotationType getRotationType() {
        return this.coreNode.getRotationType();
    }

    public void setRotationFixed(ParameterRotationFixed value) {
        this.rotationFixed.set(value);
    }

    public ParameterRotationFixed getRotationFixed() {
        return this.rotationFixed.get();
    }

    public void setRotationPVA(ParameterRotationPVA value) {
        this.rotationPVA.set(value);
    }

    public ParameterRotationPVA getRotationPVA() {
        return this.rotationPVA.get();
    }

    public void setRotationEasing(ParameterEasingSIMDVec3 value) {
        this.rotationEasing.set(value);
    }

    public ParameterEasingSIMDVec3 getRotationEasing() {
        return this.rotationEasing.get();
    }

    public void setRotationFCurve(FCurveVector3D value) {
        this.rotationFCurve.set(value);
    }

    public FCurveVector3D getRotationFCurve() {
        return this.rotationFCurve.get();
    }

    public void setRotationAxisPVA(ParameterRotationAxisPVA value) {
        this.rotationAxisPVA.set(value);
    }

    public ParameterRotationAxisPVA getRotationAxisPVA() {
        return this.rotationAxisPVA.get();
    }

    public void setRotationAxisEasing(ParameterRotationAxisEasing value) {
        this.rotationAxisEasing.set(value);
    }

    public ParameterRotationAxisEasing getRotationAxisEasing() {
        return this.rotationAxisEasing.get();
    }

    public void setScalingType(ParameterScalingType value) {
        this.coreNode.setScalingType(value);
    }

    public ParameterScalingType getScalingType() {
        return this.coreNode.getScalingType();
    }

    public void setScalingFixed(ParameterScalingFixed value) {
        this.scalingFixed.set(value);
    }

    public ParameterScalingFixed getScalingFixed() {
        return this.scalingFixed.get();
    }

    public void setScalingPVA(ParameterScalingPVA value) {
        this.scalingPVA.set(value);
    }

    public ParameterScalingPVA getScalingPVA() {
        return this.scalingPVA.get();
    }

    public void setScalingEasing(ParameterEasingSIMDVec3 value) {
        this.scalingEasing.set(value);
    }

    public ParameterEasingSIMDVec3 getScalingEasing() {
        return this.scalingEasing.get();
    }

    public void setScalingSinglePVA(ParameterScalingSinglePVA value) {
        this.scalingSinglePVA.set(value);
    }

    public ParameterScalingSinglePVA getScalingSinglePVA() {
        return this.scalingSinglePVA.get();
    }

    public void setScalingSingleEasing(ParameterEasingFloat value) {
        this.scalingSingleEasing.set(value);
    }

    public ParameterEasingFloat getScalingSingleEasing() {
        return this.scalingSingleEasing.get();
    }

    public void setScalingFCurve(FCurveVector3D value) {
        this.scalingFCurve.set(value);
    }

    public FCurveVector3D getScalingFCurve() {
        return this.scalingFCurve.get();
    }

    public void setScalingSingleFCurve(FCurveScalar value) {
        this.scalingSingleFCurve.set(value);
    }

    public FCurveScalar getScalingSingleFCurve() {
        return this.scalingSingleFCurve.get();
    }

    public void setGenerationLocation(ParameterGenerationLocation value) {
        this.generationLocation.set(value);
    }

    public ParameterGenerationLocation getGenerationLocation() {
        return this.generationLocation.get();
    }

    public void setDepthValues(ParameterDepthValues value) {
        this.depthValues.set(value);
    }

    public ParameterDepthValues getDepthValues() {
        return this.depthValues.get();
    }

    public void setRendererCommon(ParameterRendererCommon value) {
        this.rendererCommon.set(value);
    }

    public ParameterRendererCommon getRendererCommon() {
        return this.rendererCommon.get();
    }

    public void setAlphaCutoff(ParameterAlphaCutoff value) {
        this.alphaCutoff.set(value);
    }

    public ParameterAlphaCutoff getAlphaCutoff() {
        return this.alphaCutoff.get();
    }

    public void setEnableFalloff(boolean value) {
        coreNode.setEnableFalloff(value);
    }

    public boolean getEnableFalloff() {
        return coreNode.getEnableFalloff();
    }

    public void setFalloffParam(FalloffParameter value) {
        this.falloffParameter.set(value);
    }

    public FalloffParameter getFalloffParam() {
        return this.falloffParameter.get();
    }

    public void setSoundType(ParameterSoundType value) {
        coreNode.setSoundType(value);
    }

    public ParameterSoundType getSoundType() {
        return coreNode.getSoundType();
    }

    public void setSound(ParameterSound value) {

    }

    public ParameterSound getSound() {
        return null;
    }

    public void setRenderingOrder(eRenderingOrder value) {
        coreNode.setRenderingOrder(value);
    }

    public eRenderingOrder getRenderingOrder() {
        return coreNode.getRenderingOrder();
    }

    public void setRenderingPriority(int value) {
        coreNode.setRenderingPriority(value);
    }

    public int getRenderingPriority() {
        return coreNode.getRenderingPriority();
    }

    public void setDynamicFactor(DynamicFactorParameter value) {
        this.dynamicFactorParameter.set(value);
    }

    public DynamicFactorParameter getDynamicFactor() {
        return this.dynamicFactorParameter.get();
    }


    //endregion

}
