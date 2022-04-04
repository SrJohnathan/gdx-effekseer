// All needed enum classes and structs in Effekseer.Base.Pre.h
%rename("MaterialTextureParameter", fullname=1) "Effekseer::MaterialTextureParameter";
%rename("MaterialRenderData", fullname=1) "Effekseer::MaterialRenderData";
// Ignore boost data structures
%rename($ignore, fullname=1) "Effekseer::MaterialRenderData::MaterialTextures";
%rename($ignore, fullname=1) "Effekseer::MaterialRenderData::MaterialUniforms";
%rename("NodeRendererDepthParameter", fullname=1) "Effekseer::NodeRendererDepthParameter";
%rename("NodeRendererBasicParameter", fullname=1) "Effekseer::NodeRendererBasicParameter";
// Ignore boost data structures
%rename($ignore, fullname=1) "Effekseer::NodeRendererBasicParameter::TextureIndexes";
%rename($ignore, fullname=1) "Effekseer::NodeRendererBasicParameter::TextureFilters";
%rename($ignore, fullname=1) "Effekseer::NodeRendererBasicParameter::TextureWraps";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.Base.Pre.h"

// All enum classes in Effekseer.Base.h
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.Base.h"

// All structs in Effekseer.Internal.h
%rename("InternalStructRandomFloat", fullname=1) "Effekseer::random_float";
%rename("InternalStructRandomInt", fullname=1) "Effekseer::random_int";
%rename("InternalStructVector2D", fullname=1) "Effekseer::vector2d";
%rename("InternalStructRectF", fullname=1) "Effekseer::rectf";
%rename("InternalStructRandomVector2D", fullname=1) "Effekseer::random_vector2d";
%rename("InternalStructFloatWithoutRandom", fullname=1) "Effekseer::easing_float_without_random";
%rename("InternalStructEasingFloat", fullname=1) "Effekseer::easing_float";
%rename("InternalStructEasingVector2D", fullname=1) "Effekseer::easing_vector2d";
%rename("InternalStructVector3D", fullname=1) "Effekseer::vector3d";
%rename("InternalStructRandomVector3D", fullname=1) "Effekseer::random_vector3d";
%rename("InternalStructEasingVector3D", fullname=1) "Effekseer::easing_vector3d";
%rename("InternalStructRandomColor", fullname=1) "Effekseer::random_color";
%rename("InternalStructEasingColor", fullname=1) "Effekseer::easing_color";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.InternalStruct.h"