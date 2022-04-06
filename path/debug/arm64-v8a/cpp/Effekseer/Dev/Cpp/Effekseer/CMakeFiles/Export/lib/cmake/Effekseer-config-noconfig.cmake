#----------------------------------------------------------------
# Generated CMake target import file.
#----------------------------------------------------------------

# Commands may need to know the format version.
set(CMAKE_IMPORT_FILE_VERSION 1)

# Import target "Effekseer" for configuration ""
set_property(TARGET Effekseer APPEND PROPERTY IMPORTED_CONFIGURATIONS NOCONFIG)
set_target_properties(Effekseer PROPERTIES
  IMPORTED_LINK_INTERFACE_LANGUAGES_NOCONFIG "CXX"
  IMPORTED_LOCATION_NOCONFIG "${_IMPORT_PREFIX}/lib/libEffekseer.a"
  )

list(APPEND _IMPORT_CHECK_TARGETS Effekseer )
list(APPEND _IMPORT_CHECK_FILES_FOR_Effekseer "${_IMPORT_PREFIX}/lib/libEffekseer.a" )

# Commands beyond this point should not need to know the version.
set(CMAKE_IMPORT_FILE_VERSION)
