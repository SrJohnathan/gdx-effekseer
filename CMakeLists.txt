cmake_minimum_required(VERSION 3.15)

set(CMAKE_POSITION_INDEPENDENT_CODE ON)

project(GdxEffekseer LANGUAGES C CXX )



option(USE_MSVC_RUNTIME_LIBRARY_DLL "Whether Multithreaded DLL" OFF)

# Flags
if (WIN32)
  if(USE_MSVC_RUNTIME_LIBRARY_DLL)
    cmake_policy(SET CMP0091 NEW)
    set(CMAKE_MSVC_RUNTIME_LIBRARY "MultiThreaded$<$<CONFIG:Debug>:Debug>DLL")
  else()
    cmake_policy(SET CMP0091 NEW)
    set(CMAKE_MSVC_RUNTIME_LIBRARY "MultiThreaded$<$<CONFIG:Debug>:Debug>")
  endif()
  message(${CMAKE_MSVC_RUNTIME_LIBRARY})
endif()

if(UNIX AND NOT APPLE)
  set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -Wl,--start-group ")
endif()

add_subdirectory(cpp)



