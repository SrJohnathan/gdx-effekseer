@echo off

rem build & copy Android x86
set OPTIONS=^
NDK_PROJECT_PATH=. ^
NDK_APPLICATION_MK=jni/Application_x86.mk

call ndk-build clean %OPTIONS%
call ndk-build -j4 %OPTIONS%


rem build & copy Android armeabi-v7a
set OPTIONS=^
NDK_PROJECT_PATH=. ^
NDK_APPLICATION_MK=jni/Application_armeabi-v7a.mk

call ndk-build clean %OPTIONS%
call ndk-build -j4 %OPTIONS%




rem build & copy Android arm64-v8a
set OPTIONS=^
NDK_PROJECT_PATH=. ^
NDK_APPLICATION_MK=jni/Application_arm64-v8a.mk

call ndk-build clean %OPTIONS%
call ndk-build -j4 %OPTIONS%


