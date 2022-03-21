#define NOMINMAX

#include "EffekseerManagerCore.h"
#include "EffekseerRendererGL.h"
#include "Effekseer.h"
#include <assert.h>
#include <iostream>
#include "distortion.h"


#if   defined(__EFFEKSEER_RENDERER_GLES2__)

#include <android/log.h>

#define TAG "PARTICLES"

#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,    TAG, __VA_ARGS__)
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,     TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,     TAG, __VA_ARGS__)
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,    TAG, __VA_ARGS__)

#endif


const float DistanceBase = 15.0f;
const float OrthoScaleBase = 16.0f;
const float ZoomDistanceFactor = 1.125f;

static Effekseer::Vector3D g_lightDirection = Effekseer::Vector3D(1, 1, 1);
const float PI = 3.14159265f;


using  namespace std;

static ::Effekseer::Matrix44 projectionmatrix,cameramatrix;


::EffekseerRenderer::DistortingCallback * CreateDistortingCallback(EffekseerRenderer::RendererRef renderer, Effekseer::Backend::GraphicsDeviceRef ptr)
{

    auto renderGL = static_cast<::EffekseerRendererGL::Renderer *>(renderer.Get());
    return new Distortion(renderGL,ptr);

}

void ResetBackground(::EffekseerRenderer::Renderer* renderer)
{
    auto r = static_cast<::EffekseerRendererGL::Renderer*>(renderer);
    r->SetBackground(0);
}


EffekseerManagerCore::~EffekseerManagerCore() {
    manager_.Reset();
    renderer_.Reset();
}

bool EffekseerManagerCore::Initialize(int32_t spriteMaxCount, int32_t id,bool sgdb) {
    if (manager_ != nullptr || renderer_ != nullptr) {
        return false;
    }

    this->manager_  = ::Effekseer::Manager::Create(spriteMaxCount);

    if (id == 2) {
        openglDeviceType = EffekseerRendererGL::OpenGLDeviceType::OpenGL2;


    }

    if (id == 3) {
        openglDeviceType = EffekseerRendererGL::OpenGLDeviceType::OpenGL3;

    }


    if (id == 4) {
        openglDeviceType = EffekseerRendererGL::OpenGLDeviceType::OpenGLES2;


    }


    if (id == 5) {
        openglDeviceType = EffekseerRendererGL::OpenGLDeviceType::OpenGLES3;

    }





     renderer_ = ::EffekseerRendererGL::Renderer::Create(spriteMaxCount, openglDeviceType);



    if (manager_ == nullptr || renderer_ == nullptr) {
        manager_.Reset();
        renderer_.Reset();
        return false;
    }





     this->manager_->SetSpriteRenderer(renderer_->CreateSpriteRenderer());
     this->manager_->SetRibbonRenderer(renderer_->CreateRibbonRenderer());
     this->manager_->SetRingRenderer(renderer_->CreateRingRenderer());
     this->manager_->SetTrackRenderer(renderer_->CreateTrackRenderer());
     this->manager_->SetModelRenderer(renderer_->CreateModelRenderer());


    this->settingCore =  EffekseerSettingCore::create(sgdb,  EffekseerRendererGL::CreateGraphicsDevice(openglDeviceType) );

    settingCore->SetModelLoader(renderer_->CreateModelLoader());
    settingCore->SetMaterialLoader(renderer_->CreateMaterialLoader());
    settingCore->SetTextureLoader(renderer_->CreateTextureLoader());
    this->manager_->SetCurveLoader(Effekseer::MakeRefPtr<Effekseer::CurveLoader>());

    this->distortingCallback = CreateDistortingCallback(renderer_, settingCore->GetGraphicsDevice());
    //disto = new DistortingCallbackGL(0,0);
    this->renderer_->SetDistortingCallback(this->distortingCallback);
     this->manager_->SetSetting(settingCore);
     this->renderer_->SetRenderMode(Effekseer::RenderMode::Normal);
     this->settingCore->SetCoordinateSystem(Effekseer::CoordinateSystem::RH);



    return true;
}

void EffekseerManagerCore::Update(float deltaFrames) {
    if (manager_ == nullptr) {
        return;
    }

    deltaFrames += restDeltaTime_;
    restDeltaTime_ = deltaFrames - int(deltaFrames);
    for (int loop = 0; loop < int(deltaFrames); loop++) {
        manager_->Update(1);
    }
}

int EffekseerManagerCore::Play(EffekseerEffectCore *effect) {
    if (manager_ == nullptr)
        {
            return -1;
        }



        return manager_->Play(effect->GetInternal(), ::Effekseer::Vector3D());
}


bool EffekseerManagerCore::isPlaying(int handle) {
    if (manager_ == nullptr) {
        return false;
    }

    return manager_->GetShown(handle);
}

float EffekseerManagerCore::Speed(int handle)
{
    return manager_->GetSpeed(handle);
}




void EffekseerManagerCore::SetEffectRotateAxis(int handle, float x, float y, float z,float angle) {

    Effekseer::Vector3D vec(x,y,z);
    manager_->SetRotation(handle,vec,angle);
}

void EffekseerManagerCore::SetEffectPosition(int handle, float x, float y, float z)
{
    manager_->SetLocation(handle,x,y,z);
}

void EffekseerManagerCore::SetEffectScale(int handle, float x, float y, float z)
{
    manager_->SetScale(handle, x, y, z);
}




void EffekseerManagerCore::SetMatrix(int handle, float *matrix43)
{

    auto mat43 = Vector4Map::getConvert43(matrix43);
    mat43.Value[3][1] = mat43.Value[3][1] /2;
    manager_->SetMatrix(handle, mat43);
}


void EffekseerManagerCore::DrawBack() {
    if (manager_ == nullptr) {
        return;
    }


    renderer_->BeginRendering();

    manager_->DrawBack();

    renderer_->EndRendering();

}

void EffekseerManagerCore::DrawFront() {
    if (manager_ == nullptr) {
        return;
    }

    renderer_->BeginRendering();
    manager_->DrawFront();
    renderer_->EndRendering();

}

void EffekseerManagerCore::SetPause(int i,bool pause) {
    manager_->SetPaused(i,pause);
}

void EffekseerManagerCore::SetProjectionMatrix(float *matrix44, float *matrix44C, bool view, float width, float heith)
{

   // disto->update();
    projectionmatrix = Vector4Map::getConvert44( matrix44 );
    cameramatrix = Vector4Map::getConvert44(matrix44C);


    if (manager_ == nullptr) {
        return;
    }

    if(view){
        renderer_->SetProjectionMatrix(projectionmatrix);
    }else{
        renderer_->SetProjectionMatrix( ::Effekseer::Matrix44().OrthographicRH(width,heith , 0.0f, 100.0f));
    }


    renderer_->SetCameraMatrix(cameramatrix);

}


void EffekseerManagerCore::Stop(int i) {
    manager_->StopEffect(i);
}

int32_t EffekseerManagerCore::InstanceCount(int handle)
{
    return manager_->GetInstanceCount(handle);
}

float* EffekseerManagerCore::GetMatrix(int handle)
{
    auto f = Vector4Map::setConvert43(manager_->GetMatrix(handle));
    return f;
}







