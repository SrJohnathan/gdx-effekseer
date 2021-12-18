#include "effekseernode.h"
#include "Effekseer.h"
#include "Effekseer/Effekseer.EffectNode.h"
#include "Effekseer/Effekseer.EffectImplemented.h"
#include <iostream>



enum class  PVA {

    LOCATION,
    VELOCITY,
    ACCELERATION

};




void getFixed(Effekseer::Vector3D vec, std::vector<float> &array){

    array.push_back(vec.X) ;
    array.push_back(vec.Y) ;
    array.push_back(vec.Z) ;

}
void getPVA(Effekseer::random_vector3d vec, std::vector<float>&array,PVA pva){

    array.push_back(vec.max.x);
    array.push_back(vec.max.y);
    array.push_back(vec.max.z);
    array.push_back(vec.min.x);
    array.push_back(vec.min.y);
    array.push_back(vec.min.z);

}

void getPVA_Single(Effekseer::random_float vec, std::vector< float>&array){

    array.push_back(vec.max);
    array.push_back(vec.min);

}

void getEasing(Effekseer::ParameterEasing3 vec, std::vector<float>array){



    array[0] =  vec.start.max.x;
    array[1] =  vec.start.max.y;
    array[2] =  vec.start.max.z;

    array[3] =  vec.start.min.x;
    array[4] =  vec.start.min.y;
    array[5] =  vec.start.min.z;

    array[6] =  vec.end.max.x;
    array[7] =  vec.end.max.y;
    array[8] =  vec.end.max.z;

    array[9] =  vec.end.min.x;
    array[10] =  vec.end.min.y;
    array[11] = vec.end.min.z;

    array[12] =  0;
    array[13] =  0;
    array[14] =  0;





}
void setFixed(Effekseer::Vector3D vec,float *array){

    vec.X = array[0];
    vec.Y = array[1];
    vec.Z = array[2];

}
void setPVA(Effekseer::random_vector3d vec,float *array,PVA pva){

    if(pva == PVA::LOCATION){

        vec.max.x= array[0];
        vec.max.y= array[1];
        vec.max.z= array[2];

        vec.min.x= array[3];
        vec.min.y= array[4];
        vec.min.z= array[5];

    }

    if(pva == PVA::VELOCITY){


        vec.max.x= array[6];
        vec.max.y= array[7];
        vec.max.z= array[8];

        vec.min.x= array[9];
        vec.min.y= array[10];
        vec.min.z= array[11];


    }

    if(pva == PVA::ACCELERATION){


        vec.max.x= array[12];
        vec.max.y= array[13];
        vec.max.z= array[14];

        vec.min.x= array[15];
        vec.min.y= array[16];
        vec.min.z= array[17];

    }
}
void setEasing(Effekseer::ParameterEasing3 vec,float *array){





    vec.start.max.x=  array[0]  ;
    vec.start.max.y=  array[1]  ;
    vec.start.max.z=  array[2]  ;

    vec.start.min.x=  array[3]  ;
    vec.start.min.y=  array[4]  ;
    vec.start.min.z=  array[5]  ;


    vec.end.max.x=  array[6]  ;
    vec.end.max.y=  array[7]  ;
    vec.end.max.z=  array[8]  ;

    vec.end.min.x=  array[9]  ;
    vec.end.min.y=  array[10]  ;
    vec.end.min.z=  array[11]  ;

 /*   vec.params=  array[12];
    vec.easingB = array[13];
    vec.easingC = array[14];  */

}




EffekseerNode::EffekseerNode(EffekseerNode *effct,int index)
{
    node = (Effekseer::EffectNodeImplemented*)  effct->node->GetChild(index);
}

EffekseerNode::EffekseerNode(Effekseer::EffectNode* effct)
{
    node = (Effekseer::EffectNodeImplemented*) effct;
}



EffekseerNode::~EffekseerNode()
{



}

int32_t EffekseerNode::getNodes()
{
    int i =  node->GetChildrenCount();
    return  i;
}





EffekseerNode EffekseerNode::getNode(int32_t index)
{
    return  EffekseerNode(  node->GetChild(index) );
}  


const char16_t *EffekseerNode::GetName()
{

    return node->GetEffect()->GetName();
} 

Effekseer::ParameterTranslationType EffekseerNode::TranslationType() const
{
    return   node->TranslationType;
}

Effekseer::ParameterScalingType EffekseerNode::ScalingType() const
{
    return   node->ScalingType;
}

Effekseer::ParameterRotationType EffekseerNode::RotationType() const
{
    return   node->RotationType;
}

std::vector<float> EffekseerNode::GetPosition(Effekseer::ParameterTranslationType type)
{

    if(type == Effekseer::ParameterTranslationType::ParameterTranslationType_Fixed ){



        getFixed(node->TranslationFixed.Position,array_fixed);

        return array_fixed;

    } else if (type == Effekseer::ParameterTranslationType::ParameterTranslationType_PVA) {




        getPVA(node->TranslationPVA.location,array_PVA,PVA::LOCATION);
        getPVA(node->TranslationPVA.velocity,array_PVA,PVA::VELOCITY);
        getPVA(node->TranslationPVA.acceleration,array_PVA,PVA::ACCELERATION);


        return array_PVA;

    } else if (type == Effekseer::ParameterTranslationType::ParameterTranslationType_Easing) {





        getEasing(node->TranslationEasing,array_Easing);

        return  array_Easing;

    }

    return array_fixed;



}

int EffekseerNode::GetPositionType()
{
    int type = 0;

    if(node->TranslationType == Effekseer::ParameterTranslationType::ParameterTranslationType_Fixed ){

        type = 1;
    }

    if(node->TranslationType == Effekseer::ParameterTranslationType::ParameterTranslationType_PVA ){
        type = 2;
    }

    if(node->TranslationType == Effekseer::ParameterTranslationType::ParameterTranslationType_Easing ){
        type = 3;
    }

    return type;
}

void EffekseerNode::SetScale(Effekseer::ParameterScalingType type, float *array)
{
    if(type == Effekseer::ParameterScalingType::ParameterScalingType_Fixed ){


        setFixed(node->ScalingFixed.Position,array);


    } else if (type == Effekseer::ParameterScalingType::ParameterScalingType_PVA) {



        setPVA(node->ScalingPVA.Position,array,PVA::LOCATION);
        setPVA(node->ScalingPVA.Velocity,array,PVA::VELOCITY);
        setPVA(node->ScalingPVA.Acceleration,array,PVA::ACCELERATION);





    } else if (type == Effekseer::ParameterScalingType::ParameterScalingType_Easing) {



        setEasing(node->ScalingEasing,array);
        setEasing(node->ScalingEasing,array);




    }
}

std::vector<float> EffekseerNode::GetScale(Effekseer::ParameterScalingType type)
{
    if(type == Effekseer::ParameterScalingType::ParameterScalingType_Fixed ){

        getFixed(node->ScalingFixed.Position,array_fixed);

        return array_fixed;

    } else if (type == Effekseer::ParameterScalingType::ParameterScalingType_PVA) {


        getPVA(node->ScalingPVA.Position,array_PVA,PVA::LOCATION);
        getPVA(node->ScalingPVA.Velocity,array_PVA,PVA::VELOCITY);
        getPVA(node->ScalingPVA.Acceleration,array_PVA,PVA::ACCELERATION);


        return array_PVA;

    } else if (type == Effekseer::ParameterScalingType::ParameterScalingType_Easing) {

        getEasing(node->ScalingEasing,array_Easing);

        return  array_Easing;



    } else if (type == Effekseer::ParameterScalingType::ParameterScalingType_SinglePVA) {

        getPVA_Single(node->ScalingSinglePVA.Position,array_PVA_single);
        getPVA_Single(node->ScalingSinglePVA.Velocity,array_PVA_single);
        getPVA_Single(node->ScalingSinglePVA.Acceleration,array_PVA_single);



        return  array_PVA_single;

    }

    return  array_fixed;
}

int EffekseerNode::GetScaleType()
{
    int type = 0;

    if(node->ScalingType == Effekseer::ParameterScalingType::ParameterScalingType_Fixed ){

        type = 1;
    }

    if(node->ScalingType == Effekseer::ParameterScalingType::ParameterScalingType_PVA ){
        type = 2;
    }

    if(node->ScalingType == Effekseer::ParameterScalingType::ParameterScalingType_Easing ){
        type = 3;
    }

    if(node->ScalingType == Effekseer::ParameterScalingType::ParameterScalingType_SinglePVA ){
        type = 4;
    }

    return type;
}

void EffekseerNode::SetRotation(Effekseer::ParameterRotationType type, float *array)
{
    if(type == Effekseer::ParameterRotationType::ParameterRotationType_Fixed ){


        setFixed(node->RotationFixed.Position,array);


    } else if (type == Effekseer::ParameterRotationType::ParameterRotationType_PVA) {



        setPVA(node->RotationPVA.rotation,array,PVA::LOCATION);
        setPVA(node->RotationPVA.velocity,array,PVA::VELOCITY);
        setPVA(node->RotationPVA.acceleration,array,PVA::ACCELERATION);





    } else if (type == Effekseer::ParameterRotationType::ParameterRotationType_Easing) {


        setEasing(node->RotationEasing,array);


    }
}

std::vector<float> EffekseerNode::GetRotation(Effekseer::ParameterRotationType type)
{

    if(type == Effekseer::ParameterRotationType::ParameterRotationType_Fixed ){

        getFixed(node->RotationFixed.Position,array_fixed);

        return array_fixed;

    } else if (type == Effekseer::ParameterRotationType::ParameterRotationType_PVA) {


        getPVA(node->RotationPVA.rotation,array_PVA,PVA::LOCATION);
        getPVA(node->RotationPVA.velocity,array_PVA,PVA::VELOCITY);
        getPVA(node->RotationPVA.acceleration,array_PVA,PVA::ACCELERATION);


        return array_PVA;

    } else if (type == Effekseer::ParameterRotationType::ParameterRotationType_Easing) {

        getEasing(node->RotationEasing,array_Easing);

        return  array_Easing;

    }

    return  array_fixed;


}

int EffekseerNode::GetRotacionType()
{

    int type = 0;

    if(node->RotationType == Effekseer::ParameterRotationType::ParameterRotationType_Fixed ){

        type = 1;
    }

    if(node->RotationType == Effekseer::ParameterRotationType::ParameterRotationType_PVA ){
        type = 2;
    }

    if(node->RotationType == Effekseer::ParameterRotationType::ParameterRotationType_Easing ){
        type = 3;
    }

    return type;

}

void EffekseerNode::SetPosition(Effekseer::ParameterTranslationType type, float *array)
{

    if(type == Effekseer::ParameterTranslationType::ParameterTranslationType_Fixed ){


        setFixed(node->TranslationFixed.Position,array);


    } else if (type == Effekseer::ParameterTranslationType::ParameterTranslationType_PVA) {



        setPVA(node->TranslationPVA.location,array,PVA::LOCATION);
        setPVA(node->TranslationPVA.velocity,array,PVA::VELOCITY);
        setPVA(node->TranslationPVA.acceleration,array,PVA::ACCELERATION);





    } else if (type == Effekseer::ParameterTranslationType::ParameterTranslationType_Easing) {


        setEasing(node->TranslationEasing,array);


    }

}



