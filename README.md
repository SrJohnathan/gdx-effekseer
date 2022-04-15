# LibGDX + Effekseer



Dedicated library for using Effekseer particle tools in libGDX

![Alt text](https://thumbs.gfycat.com/ThickDistinctDunnart-size_restricted.gif?raw=true "Title")


### outras libs
LibGDX Water (in development) https://github.com/SrJohnathan/libgdx-water



https://effekseer.github.io/en/

https://libgdx.badlogicgames.com/

### Supported platforms

Android,
Windows and
Linux



sourceCompatibility = 1.8


### Core

[![Maven Central](https://img.shields.io/maven-central/v/io.github.srjohnathan/gdx-effekseer.svg?label=Maven%20Central&style=for-the-badge&logo=appveyor)](https://search.maven.org/search?q=g:%22io.github.srjohnathan%22%20AND%20a:%22gdx-effekseer%22)

```groovy
api 'io.github.srjohnathan:gdx-effekseer:2.1'
```

### Desktop

[![Maven Central](https://img.shields.io/maven-central/v/io.github.srjohnathan/gdx-effekseer-desktop.svg?label=Maven%20Central&style=for-the-badge&logo=appveyor)](https://search.maven.org/search?q=g:%22io.github.srjohnathan%22%20AND%20a:%22gdx-effekseer-desktop%22)

```groovy
api 'io.github.srjohnathan:gdx-effekseer-desktop:2.1'
```

### Android

[![Maven Central](https://img.shields.io/maven-central/v/io.github.srjohnathan/gdx-effekseer-android.svg?label=Maven%20Central&style=for-the-badge&logo=appveyor)](https://search.maven.org/search?q=g:%22io.github.srjohnathan%22%20AND%20a:%22gdx-effekseer-android%22)

```groovy
natives 'io.github.srjohnathan:gdx-effekseer-android:2.1'
```

build.gradle :android

```groovy
task copyEffekseerNatives {
    doFirst {
        configurations.natives.copy().files.each { jar ->
                                                        // 2.1-SNAPSHOT - version snapshot
            if (jar.name.endsWith("gdx-effekseer-android-2.2.1.jar")){

                zipTree(jar).files.each {file  ->
                    if( file.path.contains("arm64-v8a") ){
                        copy {
                            from file.path
                            into "${projectDir}/libs/arm64-v8a"
                            include "*.so"
                        }
                    }

                    if( file.path.contains("armeabi-v7a") ){
                        copy {
                            from file.path
                            into "${projectDir}/libs/armeabi-v7a"
                            include "*.so"
                        }
                    }
                    if( file.path.contains("x86") ){
                        copy {
                            from file.path
                            into "${projectDir}/libs/x86"
                            include "*.so"
                        }
                    }
                }
            }

        }
    }
}
```
run copyEffekseerNatives


### Starting

#### 3D Effects  perspectiveCamera

```java
// Effekseer start
EffekseerGdx.init()
        
AssetManager assetManager = new AssetManager(fileHandleResolver);

ModelBatch modelBatch = new ModelBatch();
RenderContext renderContext = modelBatch.getRenderContext();

// set Loader
assetManager.setLoader(EffekseerParticleSubAssetLoader.Result.class, null, new EffekseerParticleSubAssetLoader(fileHandleResolver));
assetManager.setLoader(EffekseerParticleAssetLoader.Result.class, null, new EffekseerParticleAssetLoader(fileHandleResolver));
    
PerspectiveCamera  perspectiveCamera = new PerspectiveCamera(67, 1280f, 720);

// Create a new manager for the particles
if (Gdx.app.type == Application.ApplicationType.Android) {
    manager = EffekseerManager(perspectiveCamera, EffekseerCore.TypeOpenGL.OPEN_GLES2, 600);
    --OR--
    manager = EffekseerManager(perspectiveCamera, EffekseerCore.TypeOpenGL.OPEN_GLES2, 600, renderContext);
}
else {
    manager = EffekseerManager(perspectiveCamera, EffekseerCore.TypeOpenGL.OPEN_GL2, 1000);
    --OR--
    manager = EffekseerManager(perspectiveCamera, EffekseerCore.TypeOpenGL.OPEN_GL2, 1000, renderContext);
}
// create a new particle
effekseer = new EffekseerParticle(manager);
effekseer.setMagnification(20f);
try {
    effekseer.syncLoad(assetManager, "data/tu.efk");
} catch (Exception e) {
    e.printStackTrace();
}

effekseer.play();
```

### Loading Effects
```java
effekseer = new EffekseerParticle(manager);
AssetManager assetManager = new AssetManager(fileHandleResolver);

// Register the following asset loaders for the asset manager instance once before any loading is executed
assetManager.setLoader(EffekseerParticleSubAssetLoader.Result.class, null, new EffekseerParticleSubAssetLoader(fileHandleResolver));
assetManager.setLoader(EffekseerParticleAssetLoader.Result.class, null, new EffekseerParticleAssetLoader(fileHandleResolver));

// Pass in an instance of EffekseerIsMipMapEnabledDecider to override if an effect texture should use mimaps. By default all textures use mipmaps. 
new EffekseerParticleSubAssetLoader(fileHandleResolver, new EffekseerIsMipMapEnabledDecider() {
    @Override
    public void isMipMapEnabledForTextureFile() {
        ...
    }
});


// For immediate loading
effekseer.syncLoad(assetManager, "data/tu.efk", false);
// For asynchronous loading
effekseer.asyncLoad(assetManager, "data/tu.efk", false, new LoadedListener() {
    @Override
    public void onEffectLoaded() {
        ...
    }
});
```

#### Render function

``` java
@Override
public void render() {

    ...

    manager.draw(Gdx.graphics.getDeltaTime());
    --OR--
    manager.update(Gdx.graphics.getDeltaTime());
    
    // Can call this draw as many times as needed. For example one draw for post-processing and then the normal draw.
    manager.drawAfterUpdate();
} 
```

#### Dispose function

```java  
@Override
public void dispose() {
    // Dispose a single effect
    effekseerParticle.dispose();
    
    // Dispose entire manager
    manager.dispose();
} 
```

#### 2D Effects  orthographicCamera
```java
  OrthographicCamera  orthographicCamera = new OrthographicCamera(1280f,720f);
  EffekseerManager  manager = new EffekseerManager(orthographicCamera);
```

### Animation functions

```java
effekseer = new EffekseerParticle(manager);


try {
    effekseer.syncLoad("data/ring.efk",true);
} catch (Exception e) {
    e.printStackTrace();
}

effekseer.play();

// Following is a subset of the methods in EffekseerParticle

effekseer.play();
effekseer.pause();
effekseer.resume();
effekseer.stop();
effekseer.setOnAnimationComplete();

effekseer.setTranslation();
effekseer.translate();
effekseer.setRotation();
effekseer.roatate();
effekseer.setScale();
effekseer.scale();
effekseer.getTransform(); // For direct access for transformation

effekseer.getNodeCount();
effekseer.getRootNode();


        
```

```
// The following are the supported node classes for accessing/modification.

EffekseerNode // The base node class for all node classes below
EffekseerNodeRoot // The root node of an effect
EffekseerNodeSprite
EffekseerNodeRibbon
EffekseerNodeTrack
EffekseerNodeRing
EffekseerNodeModel
```

[![paypal](https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=ZESRVEEVLLCY6)

### Contributors:
* Antonio Johnathan       https://github.com/SrJohnathan
* Durswd                 https://github.com/durswd
* niraj-rayalla          https://github.com/niraj-rayalla

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
