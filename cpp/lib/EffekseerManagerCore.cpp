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

typedef ::Effekseer::Vector3D Vector3D;
typedef ::Effekseer::Color Color;
typedef ::Effekseer::Manager::UpdateParameter UpdateParameter;
typedef ::Effekseer::Manager::DrawParameter DrawParameter;


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

bool EffekseerManagerCore::Initialize(int32_t spriteMaxCount, int32_t id,bool isSrgbMode) {
    if (manager_ != nullptr || renderer_ != nullptr) {
        return false;
    }

    this->manager_  = ::Effekseer::Manager::Create(spriteMaxCount);

    // GL version
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

    // Create renderer
    renderer_ = ::EffekseerRendererGL::Renderer::Create(spriteMaxCount, openglDeviceType);

    // Check successful creation
    if (manager_ == nullptr || renderer_ == nullptr) {
        manager_.Reset();
        renderer_.Reset();
        return false;
    }

    // Set all renderer instances for each type by using the created renderer object
    this->manager_->SetSpriteRenderer(renderer_->CreateSpriteRenderer());
    this->manager_->SetRibbonRenderer(renderer_->CreateRibbonRenderer());
    this->manager_->SetRingRenderer(renderer_->CreateRingRenderer());
    this->manager_->SetTrackRenderer(renderer_->CreateTrackRenderer());
    this->manager_->SetModelRenderer(renderer_->CreateModelRenderer());

    this->settingCore =  EffekseerSettingCore::create(isSrgbMode,  EffekseerRendererGL::CreateGraphicsDevice(openglDeviceType) );

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

void EffekseerManagerCore::LaunchWorkerThreads(uint32_t threadCount) {
    if (manager_ == nullptr) {
        return;
    }

     manager_->LaunchWorkerThreads(threadCount);
}

bool EffekseerManagerCore::Exists(int handle) {
    return manager_->Exists(handle);
}

int EffekseerManagerCore::Play(EffekseerEffectCore *effect) {
    if (manager_ == nullptr) {
        return -1;
    }

    return manager_->Play(effect->GetInternal(), ::Effekseer::Vector3D());
}

void EffekseerManagerCore::StopEffect(int handle) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->StopEffect(handle);
}

void EffekseerManagerCore::StopAllEffects() {
    if (manager_ == nullptr) {
        return;
    }

    manager_->StopAllEffects();
}

void EffekseerManagerCore::StopRoot(int handle) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->StopRoot(handle);
}

int32_t EffekseerManagerCore::GetInstanceCount(int handle) {
    if (manager_ == nullptr) {
        return -1;
    }

    return manager_->GetInstanceCount(handle);
}

int32_t EffekseerManagerCore::GetTotalInstanceCount() {
    if (manager_ == nullptr) {
        return -1;
    }

    return manager_->GetTotalInstanceCount();
}

float* EffekseerManagerCore::GetMatrix(int handle) {
    if (manager_ == nullptr) {
        return nullptr;
    }

    auto f = Vector4Map::setConvert43(manager_->GetMatrix(handle));
    return f;
}

void EffekseerManagerCore::SetMatrix(int handle, float *matrix43) {
    if (manager_ == nullptr) {
        return;
    }

    auto mat43 = Vector4Map::getConvert43(matrix43);
    mat43.Value[3][1] = mat43.Value[3][1] /2;
    manager_->SetMatrix(handle, mat43);
}

float* EffekseerManagerCore::GetBaseMatrix(int handle) {
    if (manager_ == nullptr) {
        return nullptr;
    }

    auto f = Vector4Map::setConvert43(manager_->GetBaseMatrix(handle));
    return f;
}

void EffekseerManagerCore::SetBaseMatrix(int handle, float *matrix43) {
    if (manager_ == nullptr) {
        return;
    }

    auto mat43 = Vector4Map::getConvert43(matrix43);
    mat43.Value[3][1] = mat43.Value[3][1] /2;
    manager_->SetBaseMatrix(handle, mat43);
}

Vector3D EffekseerManagerCore::GetLocation(int handle) {
    if (manager_ == nullptr) {
        return ::Effekseer::Vector3D();
    }

    return manager_->GetLocation(handle);
}

void EffekseerManagerCore::SetLocation(int handle, float x, float y, float z) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetLocation(handle, x, y, z);
}

void EffekseerManagerCore::SetLocation(int handle, const Vector3D& location) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetLocation(handle, location);
}

void EffekseerManagerCore::AddLocation(int handle, const Vector3D& location) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->AddLocation(handle,location);
}

void EffekseerManagerCore::SetRotation(int handle, float x, float y, float z) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetRotation(handle, x, y, z);
}

void EffekseerManagerCore::SetRotation(int handle, const Vector3D& axis, float angle) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetRotation(handle, axis, angle);
}

void EffekseerManagerCore::SetScale(int handle, float x, float y, float z) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetScale(handle, x, y, z);
}

void EffekseerManagerCore::SetAllColor(int handle, Color color) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetAllColor(handle, color);
}

void EffekseerManagerCore::SetTargetLocation(int handle, float x, float y, float z) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetTargetLocation(handle, x, y, z);
}

void EffekseerManagerCore::SetTargetLocation(int handle, const Vector3D& location) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetTargetLocation(handle, location);
}

void EffekseerManagerCore::SetProjectionMatrix(float *matrix44, float *matrix44C, bool view, float width, float height) {
    // disto->update();
    projectionmatrix = Vector4Map::getConvert44( matrix44 );
    cameramatrix = Vector4Map::getConvert44(matrix44C);


    if (manager_ == nullptr) {
        return;
    }

    if(view){
        renderer_->SetProjectionMatrix(projectionmatrix);
    }else{
        renderer_->SetProjectionMatrix( ::Effekseer::Matrix44().OrthographicRH(width, height, 0.0f, 100.0f));
    }

    renderer_->SetCameraMatrix(cameramatrix);
}

float EffekseerManagerCore::GetDynamicInput(int handle, int32_t index) {
    if (manager_ == nullptr) {
        return 0.0f;
    }

    return manager_->GetDynamicInput(handle, index);
}

void EffekseerManagerCore::SetDynamicInput(int handle, int32_t index, float value) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetDynamicInput(handle, index, value);
}

bool EffekseerManagerCore::GetShown(int handle) {
    if (manager_ == nullptr) {
        return false;
    }

    return manager_->GetShown(handle);
}

void EffekseerManagerCore::SetShown(int handle, bool shown) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetShown(handle, shown);
}

bool EffekseerManagerCore::GetPaused(int handle) {
    if (manager_ == nullptr) {
        return false;
    }

    return manager_->GetPaused(handle);
}

void EffekseerManagerCore::SetPaused(int handle, bool paused) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetPaused(handle, paused);
}

void EffekseerManagerCore::SetPausedToAllEffects(bool paused) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetPausedToAllEffects(paused);
}

int EffekseerManagerCore::GetLayer(int handle) {
    if (manager_ == nullptr) {
        return -1;
    }

    return manager_->GetLayer(handle);
}

void EffekseerManagerCore::SetLayer(int handle, int32_t layer) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetLayer(handle, layer);
}

int64_t EffekseerManagerCore::GetGroupMask(int handle) {
    if (manager_ == nullptr) {
        return -1;
    }

    return manager_->GetGroupMask(handle);
}

void EffekseerManagerCore::SetGroupMask(int handle, int64_t groupmask) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetGroupMask(handle, groupmask);
}

float EffekseerManagerCore::GetSpeed(int handle) {
    if (manager_ == nullptr) {
        return -1.0f;
    }

    return manager_->GetSpeed(handle);
}

void EffekseerManagerCore::SetSpeed(int handle, float speed) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetSpeed(handle, speed);
}

void EffekseerManagerCore::SetTimeScaleByGroup(int64_t groupmask, float timeScale) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetTimeScaleByGroup(groupmask, timeScale);
}

void EffekseerManagerCore::SetTimeScaleByHandle(int handle, float timeScale) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetTimeScaleByHandle(handle, timeScale);
}

void EffekseerManagerCore::SetAutoDrawing(int handle, bool autoDraw) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetAutoDrawing(handle, autoDraw);
}

/*
void* EffekseerManagerCore::GetUserData(int handle) {
    if (manager_ == nullptr) {
        return nullptr;
    }

    return manager_->GetUserData(handle);
}

void EffekseerManagerCore::SetUserData(int handle, void* userData) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->SetUserData(handle, userData);
}
*/

void EffekseerManagerCore::Flip() {
    if (manager_ == nullptr) {
        return;
    }

    manager_->Flip();
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

void EffekseerManagerCore::Update(const UpdateParameter& parameter) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->Update(parameter);
}

void EffekseerManagerCore::BeginUpdate() {
    if (manager_ == nullptr) {
        return;
    }

    manager_->BeginUpdate();
}

void EffekseerManagerCore::EndUpdate() {
    if (manager_ == nullptr) {
        return;
    }

    manager_->EndUpdate();
}

void EffekseerManagerCore::UpdateHandle(int handle, float deltaFrame) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->UpdateHandle(handle, deltaFrame);
}

void EffekseerManagerCore::UpdateHandleToMoveToFrame(int handle, float frame) {
    if (manager_ == nullptr) {
        return;
    }

    manager_->UpdateHandleToMoveToFrame(handle, frame);
}

void EffekseerManagerCore::SetTime(float time) {
    renderer_->SetTime(time);
}

void EffekseerManagerCore::UpdateCombined(float deltaFrames, float time, float projectionMatrix44[],float viewMatrix44C[], bool view, float width, float height) {
    SetProjectionMatrix(projectionMatrix44, viewMatrix44C, view, width, height);
    SetTime(time);
    Update(deltaFrames);
}

void EffekseerManagerCore::BeginRendering() {
    renderer_->BeginRendering();
}

void EffekseerManagerCore::Draw(const Effekseer::Manager::DrawParameter& drawParameter) {
    manager_->Draw(drawParameter);
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

void EffekseerManagerCore::EndRendering() {
    renderer_->EndRendering();
}

void EffekseerManagerCore::DrawCombined(const Effekseer::Manager::DrawParameter& drawParameter) {
    BeginRendering();
    Draw(drawParameter);
    EndRendering();
}







