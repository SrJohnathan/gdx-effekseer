// Vector3D with only the fields and constructor and destructor
%rename("Vector2D", fullname=1) "Effekseer::Vector2D";
%rename("x", fullname=1) "Effekseer::Vector2D::X";
%rename("y", fullname=1) "Effekseer::Vector2D::Y";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.Vector2D.h"

// Vector3D with only the fields and constructor and destructor
%rename("Vector3D", fullname=1) "Effekseer::Vector3D";
%rename("x", fullname=1) "Effekseer::Vector3D::X";
%rename("y", fullname=1) "Effekseer::Vector3D::Y";
%rename("z", fullname=1) "Effekseer::Vector3D::Z";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.Vector3D.h"

// Matrix43 with only the fields and constructor and destructor
%rename("Matrix43", fullname=1) "Effekseer::Matrix43";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.Matrix43.h"

// Matrix44 with only the fields and constructor and destructor
%rename("Matrix44", fullname=1) "Effekseer::Matrix44";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/Effekseer.Matrix44.h"

// SIMD::Vec2f
%rename("SIMDVec2f", fullname=1) "Effekseer::SIMD::Vec2f";
// Ignore the SIMD fields in Vec2f because I can't seem to figure out why the preprocessor definitions in Effekseer/SIMD/Base.h won't work.
%rename($ignore, fullname=1) "Effekseer::SIMD::Vec2f::s";
%rename($ignore, fullname=1) Effekseer::SIMD::Vec2f::Vec2f(const Float4&);
// Ignore boost data structures
%rename($ignore, fullname=1) Effekseer::SIMD::Vec2f::Vec2f(const std::array<float, 2>&);
// Getters and Setters
%rename("getX", fullname=1) "Effekseer::SIMD::Vec3f::GetX";
%rename("getY", fullname=1) "Effekseer::SIMD::Vec3f::GetY";
%rename("setX", fullname=1) "Effekseer::SIMD::Vec3f::SetX";
%rename("setY", fullname=1) "Effekseer::SIMD::Vec3f::SetY";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/SIMD/Vec2f.h"
// SIMD::Vec3f
%rename("SIMDVec3f", fullname=1) "Effekseer::SIMD::Vec3f";
// Ignore the SIMD fields in Vec3f because I can't seem to figure out why the preprocessor definitions in Effekseer/SIMD/Base.h won't work.
%rename($ignore, fullname=1) "Effekseer::SIMD::Vec3f::s";
%rename($ignore, fullname=1) Effekseer::SIMD::Vec3f::Vec3f(const Float4&);
// Ignore boost data structures
%rename($ignore, fullname=1) Effekseer::SIMD::Vec3f::Vec3f(const std::array<float, 3>&);
// Getters and Setters
%rename("getX", fullname=1) "Effekseer::SIMD::Vec3f::GetX";
%rename("getY", fullname=1) "Effekseer::SIMD::Vec3f::GetY";
%rename("getZ", fullname=1) "Effekseer::SIMD::Vec3f::GetZ";
%rename("setX", fullname=1) "Effekseer::SIMD::Vec3f::SetX";
%rename("setY", fullname=1) "Effekseer::SIMD::Vec3f::SetY";
%rename("setZ", fullname=1) "Effekseer::SIMD::Vec3f::SetZ";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/SIMD/Vec3f.h"
// SIMD::Mat43f
%rename("SIMDMat43f", fullname=1) "Effekseer::SIMD::Mat43f";
// Ignore the SIMD fields in Mat43f because I can't seem to figure out why the preprocessor definitions in Effekseer/SIMD/Base.h won't work.
%rename($ignore, fullname=1) "Effekseer::SIMD::Mat43f::X";
%rename($ignore, fullname=1) "Effekseer::SIMD::Mat43f::Y";
%rename($ignore, fullname=1) "Effekseer::SIMD::Mat43f::Z";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/SIMD/Mat43f.h"
// SIMD::Mat44f
%rename("SIMDMat44f", fullname=1) "Effekseer::SIMD::Mat44f";
// Ignore the SIMD fields in Vec3f because I can't seem to figure out why the preprocessor definitions in Effekseer/SIMD/Base.h won't work.
%rename($ignore, fullname=1) "Effekseer::SIMD::Mat44f::X";
%rename($ignore, fullname=1) "Effekseer::SIMD::Mat44f::Y";
%rename($ignore, fullname=1) "Effekseer::SIMD::Mat44f::Z";
%rename($ignore, fullname=1) "Effekseer::SIMD::Mat44f::W";
%include "/cpp/Effekseer/Dev/Cpp/Effekseer/Effekseer/SIMD/Mat44f.h"