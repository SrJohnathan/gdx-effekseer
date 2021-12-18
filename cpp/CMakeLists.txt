cmake_minimum_required(VERSION 3.15)

project(src)


set(BUILD_EXAMPLES OFF)
add_subdirectory(Effekseer)
add_subdirectory(lib)

add_library(src SHARED

                dll.cpp
                utiil.h
		)




find_package(JNI)
SET(CMAKE_EXE_LINKER_FLAGS "-ljvm")

include_directories(${CMAKE_CURRENT_SOURCE_DIR})


target_include_directories(
		src
        PRIVATE
        Effekseer/Dev/Cpp/Effekseer/
        Effekseer/Dev/Cpp/EffekseerRendererGL/
        ${JNI_INCLUDE_DIRS}
)

target_link_libraries(src
        PRIVATE
        Effekseer
        EffekseerRendererGL
        lib
        )




