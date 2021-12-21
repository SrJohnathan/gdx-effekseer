#ifndef DISTOTION_H
#define DISTOTION_H


#include<EffekseerRendererGL.h>
#include<Effekseer.h>
#include <EffekseerRenderer/EffekseerRendererGL.GLExtension.h>
#include <iostream>

using namespace EffekseerRendererGL::GLExt;

class DistortingCallbackGL : public EffekseerRenderer::DistortingCallback
{
    GLuint texture = 0;
    int32_t width_ = 0;
    int32_t height_ = 0;


    GLuint framebufferForCopy = 0;
    uint32_t backGroundTextureWidth = 0;
    uint32_t backGroundTextureHeight = 0;
    GLuint backGroundTextureInternalFormat = 0;

public:
    DistortingCallbackGL(int width, int height)
       // : width_(width)
       // , height_(height)
    {

        GLint viewport[4];
        glGetIntegerv(GL_VIEWPORT, viewport);
        width_ = viewport[2];
        height_ = viewport[3];

        glGenTextures(1, &texture);
        glBindTexture(GL_TEXTURE_2D, texture);

#if defined(__linux__)
        glTexImage2D(GL_TEXTURE_2D, 0,  GL_RGBA,width_, height_, 0, GL_RGBA, GL_UNSIGNED_BYTE, 0);

#else
        glTexImage2D(GL_TEXTURE_2D, 0,  GL_RGBA8,width_, height_, 0, GL_RGBA, GL_UNSIGNED_BYTE, 0);

#endif

        glBindTexture(GL_TEXTURE_2D, 0);



    }



    virtual ~DistortingCallbackGL()
    {
        glDeleteTextures(1, &texture);
    }

    virtual bool OnDistorting(EffekseerRenderer::Renderer* renderer) override
    {

        glBindTexture(GL_TEXTURE_2D, texture);
        glCopyTexSubImage2D(GL_TEXTURE_2D, 0, 0, 0, 0, 0, width_, height_);
        glBindTexture(GL_TEXTURE_2D, 0);

        reinterpret_cast<::EffekseerRendererGL::Renderer*>(renderer)->SetBackground(texture);

        return true;
    }
};



class Distotion : public EffekseerRenderer::DistortingCallback
{

private:

    Effekseer::Backend::GraphicsDeviceRef graphicsDevice_ = nullptr;
public:



    Distotion(EffekseerRendererGL::Renderer *,Effekseer::Backend::GraphicsDeviceRef graphicsDevice_);




    GLuint framebufferForCopy = 0;
    GLuint backGroundTexture = 0;
    uint32_t backGroundTextureWidth = 0;
    uint32_t backGroundTextureHeight = 0;
    GLuint backGroundTextureInternalFormat = 0;
    EffekseerRendererGL::Renderer *ref = nullptr;


    virtual ~Distotion();

    void ReleaseTexture();

    // prepare a taget
    void PrepareTexture(uint32_t width, uint32_t height, GLint internalFormat);

    virtual bool OnDistorting(EffekseerRenderer::Renderer* renderer) override;

};

#endif // DISTOTION_H



