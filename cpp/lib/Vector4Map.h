#pragma once

#include <Effekseer.h>
class Vector4Map {




public:
    Vector4Map();
    ~Vector4Map();

    static Effekseer::Matrix44 getConvert44( float flat[]);
    static float *setConvert44( Effekseer::Matrix44 flat);

    static Effekseer::Matrix43 getConvert43( float flat[]);
      static float *setConvert43( Effekseer::Matrix43 flat);

};



