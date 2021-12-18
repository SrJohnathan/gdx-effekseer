//
// Created by Johnathan on 30/06/2020.
//

#include "Vector4Map.h"

Vector4Map::Vector4Map() {

}

Vector4Map::~Vector4Map() {

}

Effekseer::Matrix44 Vector4Map::getConvert44(float flat[])
{
    auto vec = Effekseer::Matrix44();

  vec.Values[0][0] = flat[0];
  vec.Values[0][1] = flat[1];
  vec.Values[0][2] = flat[2];
  vec.Values[0][3] = flat[3];

  vec.Values[1][0] = flat[4];
  vec.Values[1][1] = flat[5];
  vec.Values[1][2] = flat[6];
  vec.Values[1][3] = flat[7];

  vec.Values[2][0] = flat[8];
  vec.Values[2][1] = flat[9];
  vec.Values[2][2] = flat[10];
  vec.Values[2][3] = flat[11];

  vec.Values[3][0] = flat[12];
  vec.Values[3][1] = flat[13];
  vec.Values[3][2] = flat[14];
  vec.Values[3][3] = flat[15];


  return vec;
}

float *Vector4Map::setConvert44(Effekseer::Matrix44 flat)
{
    static float vec[16];

    auto m = flat.Values;


    vec[0] = m[0][0];
    vec[1] = m[0][1];
    vec[2] = m[0][2];
    vec[3] = m[0][3];

    vec[4] = m[1][0];
    vec[5] = m[1][1];
    vec[6] = m[1][2];
    vec[7] = m[1][3];

    vec[8] = m[2][0];
    vec[9] = m[2][1];
    vec[10] = m[2][2];
    vec[11] = m[2][3];

    vec[12] = m[3][0];
    vec[13] = m[3][1];
    vec[14] = m[3][2];
    vec[15] = m[3][3];


    return vec;

}


float* Vector4Map::setConvert43(Effekseer::Matrix43 flat)
{

    static float vec[12];

    auto m = flat.Value;

    vec[0] = m[0][0];
    vec[1] = m[0][1];
    vec[2] = m[0][2];

    vec[3] = m[1][0];
    vec[4] = m[1][1];
    vec[5] = m[1][2];

    vec[6] = m[2][0];
    vec[7] = m[2][1];
    vec[8] = m[2][2];

    vec[9] =  m[3][0];
    vec[10] = m[3][1];
    vec[11] = m[3][2];


    return vec;

}

Effekseer::Matrix43 Vector4Map::getConvert43(float flat[])
{

     auto vec = Effekseer::Matrix43();


     vec.Value[0][0] = flat[0];
     vec.Value[0][1] = flat[1];
     vec.Value[0][2] = flat[2];

     vec.Value[1][0] = flat[3];
     vec.Value[1][1] = flat[4];
     vec.Value[1][2] = flat[5];

     vec.Value[2][0] = flat[6];
     vec.Value[2][1] = flat[7];
     vec.Value[2][2] = flat[8];

     vec.Value[3][0] = flat[9];
     vec.Value[3][1] = flat[10];
     vec.Value[3][2] = flat[11];




     return vec;
}


