#ifndef EFFEKSEERNODE_H
#define EFFEKSEERNODE_H


#include "Effekseer.h"
#include "Effekseer/Effekseer.EffectNode.h"
#include <iostream>
#include <vector>
#include <array>



class EffekseerNode
{

private:

    Effekseer::EffectNodeImplemented *node;



    std::vector<float> array_fixed;
    std::vector<float> array_PVA;
    std::vector<float> array_Easing;
    std::vector<float> array_PVA_single;

public:

    


    EffekseerNode(EffekseerNode *effct, int index);

#ifndef SWIG
    EffekseerNode(Effekseer::EffectNode* effct);
#endif

    ~EffekseerNode();

   
    int GetPositionType();
    int GetScaleType();
    int GetRotacionType();
    int32_t getNodes();
    EffekseerNode getNode(int32_t index);
    const char16_t * GetName();

    void SetPosition(Effekseer::ParameterTranslationType  type ,float * array );
    std::vector<float> GetPosition(Effekseer::ParameterTranslationType  type);
    void SetScale(Effekseer::ParameterScalingType  type ,float * array );
    std::vector<float> GetScale(Effekseer::ParameterScalingType   type);
    void SetRotation(Effekseer::ParameterRotationType  type ,float * array );
    std::vector<float> GetRotation(Effekseer::ParameterRotationType   type);



    Effekseer::ParameterTranslationType TranslationType() const;
    Effekseer::ParameterRotationType RotationType() const;
    Effekseer::ParameterScalingType ScalingType() const;




};

#endif // EFFEKSEERNODE_H
