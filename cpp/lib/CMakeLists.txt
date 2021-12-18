
cmake_minimum_required(VERSION 3.15)

project(lib CXX)

add_library(
  lib
  STATIC
  EffekseerBackendCore.h
  EffekseerBackendCore.cpp
  EffekseerEffectCore.h
  EffekseerEffectCore.cpp
  EffekseerManagerCore.h
  EffekseerManagerCore.cpp
  EffekseerSettingCore.h
  EffekseerSettingCore.cpp
  distotion.h
  distotion.cpp


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
