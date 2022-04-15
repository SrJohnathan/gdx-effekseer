
cmake_minimum_required(VERSION 3.15)

project(lib CXX)

add_library(
    lib
    STATIC
    EffekseerBackendCore.h
    EffekseerBackendCore.cpp
    EffekseerEffectCore.h
    EffekseerEffectCore.cpp
    RefWrappers.h
    RefWrappers.cpp
    EffekseerManagerCore.h
    EffekseerManagerCore.cpp
    EffekseerSettingCore.h
    EffekseerSettingCore.cpp
    distortion.h
    distortion.cpp

    Vector4Map.cpp
    Vector4Map.h
)

target_include_directories(
  lib
  PUBLIC
  ../Effekseer/Dev/Cpp/Effekseer/
  ../Effekseer/Dev/Cpp/EffekseerRendererGL/


)

add_dependencies(lib Effekseer  EffekseerRendererGL   )
