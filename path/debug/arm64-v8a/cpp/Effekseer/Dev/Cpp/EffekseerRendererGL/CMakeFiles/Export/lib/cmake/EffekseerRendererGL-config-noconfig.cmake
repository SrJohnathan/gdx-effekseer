#----------------------------------------------------------------
# Generated CMake target import file.
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "EffekseerRendererGL" for configuration ""
set_property(TARGET EffekseerRendererGL APPEND PROPERTY IMPORTED_CONFIGURATIONS NOCONFIG)
set_target_properties(EffekseerRendererGL PROPERTIES
  IMPORTED_LINK_INTERFACE_LANGUAGES_NOCONFIG "CXX"
  IMPORTED_LOCATION_NOCONFIG "${_IMPORT_PREFIX}/lib/libEffekseerRendererGL.a"
  )

list(APPEND _IMPORT_CHECK_TARGETS EffekseerRendererGL )
list(APPEND _IMPORT_CHECK_FILES_FOR_EffekseerRendererGL "${_IMPORT_PREFIX}/lib/libEffekseerRendererGL.a" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
