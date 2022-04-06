// All needed enum classes and structs in ForceField/ForceFields.h
%rename("ForceFieldCommonParameter", fullname=1) "Effekseer::ForceFieldCommonParameter";
%rename("ForceFieldFalloffCommonParameter", fullname=1) "Effekseer::ForceFieldFalloffCommonParameter";
%rename("ForceFieldFalloffSphereParameter", fullname=1) "Effekseer::ForceFieldFalloffSphereParameter";
%rename("ForceFieldFalloffTubeParameter", fullname=1) "Effekseer::ForceFieldFalloffTubeParameter";
%rename("ForceFieldFalloffConeParameter", fullname=1) "Effekseer::ForceFieldFalloffConeParameter";
%rename("ForceFieldForceParameter", fullname=1) "Effekseer::ForceFieldForceParameter";
%rename("ForceFieldWindParameter", fullname=1) "Effekseer::ForceFieldWindParameter";
%rename("ForceFieldVortexParameter", fullname=1) "Effekseer::ForceFieldVortexParameter";
%rename("ForceFieldTurbulenceParameter", fullname=1) "Effekseer::ForceFieldTurbulenceParameter";
// Ignore boost std::unique_ptr members
%rename($ignore, fullname=1) "Effekseer::ForceFieldTurbulenceParameter::Noise";
%rename($ignore, fullname=1) "Effekseer::ForceFieldTurbulenceParameter::LightNoise";
%rename("ForceFieldDragParameter", fullname=1) "Effekseer::ForceFieldDragParameter";
%rename("ForceFieldGravityParameter", fullname=1) "Effekseer::ForceFieldGravityParameter";
%rename("ForceFieldAttractiveForceParameter", fullname=1) "Effekseer::ForceFieldAttractiveForceParameter";
%rename("ForceFieldFalloff", fullname=1) "Effekseer::ForceFieldFalloff";
%rename("ForceField", fullname=1) "Effekseer::ForceField";
%rename("LocalForceFieldElementParameter", fullname=1) "Effekseer::LocalForceFieldElementParameter";
// Ignore boost std::unique_ptr members
%rename($ignore, fullname=1) "Effekseer::LocalForceFieldElementParameter::Force";
%rename($ignore, fullname=1) "Effekseer::LocalForceFieldElementParameter::Wind";
%rename($ignore, fullname=1) "Effekseer::LocalForceFieldElementParameter::Vortex";
%rename($ignore, fullname=1) "Effekseer::LocalForceFieldElementParameter::Turbulence";
%rename($ignore, fullname=1) "Effekseer::LocalForceFieldElementParameter::Drag";
%rename($ignore, fullname=1) "Effekseer::LocalForceFieldElementParameter::Gravity";
%rename($ignore, fullname=1) "Effekseer::LocalForceFieldElementParameter::AttractiveForce";
%rename($ignore, fullname=1) "Effekseer::LocalForceFieldElementParameter::FalloffCommon";
%rename($ignore, fullname=1) "Effekseer::LocalForceFieldElementParameter::FalloffSphere";
%rename($ignore, fullname=1) "Effekseer::LocalForceFieldElementParameter::FalloffTube";
%rename($ignore, fullname=1) "Effekseer::LocalForceFieldElementParameter::FalloffCone";
%rename("LocalForceFieldParameter", fullname=1) "Effekseer::LocalForceFieldParameter";
// Ignore boost data structures
%rename($ignore, fullname=1) "Effekseer::LocalForceFieldParameter::LocalForceFields";
%rename("LocalForceFieldInstance", fullname=1) "Effekseer::LocalForceFieldInstance";
%rename($ignore, fullname=1) "Effekseer::LocalForceFieldParameter::LocalForceFields";
// std wrappers
namespace Effekseer {
    const int32_t LocalFieldSlotMax = 4;
    namespace SIMD {
        struct Vec3f;
    }
};
namespace std {
   %template(ArrayLocalForceFieldVelocities) array<Effekseer::SIMD::Vec3f, Effekseer::LocalFieldSlotMax>;
};
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/ForceField/ForceFields.h"