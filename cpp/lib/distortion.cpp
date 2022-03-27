#include "distortion.h"


Distortion::Distortion(EffekseerRendererGL::Renderer* ref,Effekseer::Backend::GraphicsDeviceRef graphicsDevice_):
    EffekseerRenderer::DistortingCallback(),ref(ref),graphicsDevice_(graphicsDevice_)

{
    glGenTextures(1, &backGroundTexture);
    glBindTexture(GL_TEXTURE_2D, backGroundTexture);

/*
#ifndef _WIN32
    glGenFramebuffers(1, &framebufferForCopy);
    std::cout << "entrou win" << std::endl;
#endif


#if defined(__linux__)
    std::cout << "entrou linux" << std::endl;
    glGenFramebuffers(1, &framebufferForCopy);
#endif */

}


Distortion::~Distortion()
{
    ReleaseTexture();
}

void Distortion::ReleaseTexture()
{
#ifndef _WIN32
    glDeleteFramebuffers(1, &framebufferForCopy);
#endif 

/*
#if defined(__linux__) 
    glDeleteFramebuffers(1, &framebufferForCopy);
#endif */
    glDeleteTextures(1, &backGroundTexture);
} 

void Distortion::PrepareTexture(uint32_t width, uint32_t height, GLint internalFormat)
{
    glBindTexture(GL_TEXTURE_2D, backGroundTexture);
    glTexImage2D(GL_TEXTURE_2D, 0, internalFormat, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, 0);
    glBindTexture(GL_TEXTURE_2D, 0);


    backGroundTextureWidth = width;
    backGroundTextureHeight = height;
    backGroundTextureInternalFormat = internalFormat;
}

bool Distortion::OnDistorting(EffekseerRenderer::Renderer* renderer)
{

 /*   
#ifndef _WIN32
    GLint backupFramebuffer;
    glGetIntegerv(GL_FRAMEBUFFER_BINDING, &backupFramebuffer);
    if (backupFramebuffer <= 0) return false;

#endif    



#if defined(__linux__) 
    GLint backupFramebuffer;
    glGetIntegerv(GL_FRAMEBUFFER_BINDING, &backupFramebuffer);
    if (backupFramebuffer <= 0) return false;


#endif */

    GLint viewport[4];
    glGetIntegerv(GL_VIEWPORT, viewport);
    uint32_t width = viewport[2];
    uint32_t height = viewport[3];

    if (backGroundTextureWidth != width ||
        backGroundTextureHeight != height)
    {
        PrepareTexture(width, height, GL_RGBA);
    }
/*
#ifndef _WIN32

    

    GLint rbtype;
    glGetFramebufferAttachmentParameteriv(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0,
        GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE, &rbtype);

    if (rbtype == GL_RENDERBUFFER) {
        GLint renderbuffer;
        glGetFramebufferAttachmentParameteriv(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0,
            GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME, &renderbuffer);

        glBindFramebuffer(GL_FRAMEBUFFER, framebufferForCopy);
        glFramebufferRenderbuffer(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_RENDERBUFFER, renderbuffer);
    }
    else if (rbtype == GL_TEXTURE_2D) {
        GLint renderTexture;
        glGetFramebufferAttachmentParameteriv(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0,
            GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME, &renderTexture);

        glBindFramebuffer(GL_FRAMEBUFFER, framebufferForCopy);
        glFramebufferTexture2D(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_TEXTURE_2D, renderTexture, 0);
    } 


#endif   

#if defined(__linux__) 

    GLint rbtype;

    glGetFramebufferAttachmentParameteriv(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE, &rbtype);

    if (rbtype == GL_RENDERBUFFER) {
        GLint renderbuffer;
        glGetFramebufferAttachmentParameteriv(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME, &renderbuffer);

        glBindFramebuffer(GL_FRAMEBUFFER, framebufferForCopy);
        glFramebufferRenderbuffer(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_RENDERBUFFER, renderbuffer);
    }
    else if (rbtype == GL_TEXTURE_2D) {
        GLint renderTexture;
        glGetFramebufferAttachmentParameteriv(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0,
                                              GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME, &renderTexture);

        glBindFramebuffer(GL_FRAMEBUFFER, framebufferForCopy);
        glFramebufferTexture2D(GL_FRAMEBUFFER, GL_COLOR_ATTACHMENT0, GL_TEXTURE_2D, renderTexture, 0);
    }


#endif
*/

    glBindTexture(GL_TEXTURE_2D, backGroundTexture);
    //glCopyTexSubImage2D( GL_TEXTURE_2D, 0, 0, 0, 0, 0, width, height );
    glCopyTexSubImage2D(GL_TEXTURE_2D, 0, 0, 0, viewport[0], viewport[1], width, height);
    glBindTexture(GL_TEXTURE_2D, 0);

/*
#ifndef _WIN32
    glBindFramebuffer(GL_FRAMEBUFFER, backupFramebuffer);


#endif    
#if defined(__linux__)
 
    glBindFramebuffer(GL_FRAMEBUFFER, backupFramebuffer);


#endif  */


   // auto r = static_cast<EffekseerRendererGL::RendererRef>(this->ref);





    reinterpret_cast<::EffekseerRendererGL::Renderer*>(renderer)->SetBackground( backGroundTexture);


    return true;
}


