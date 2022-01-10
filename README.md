# LibGDX + Effekseer



Dedicated library for using Effekseer particle tools in libGDX

![Alt text](https://thumbs.gfycat.com/ThickDistinctDunnart-size_restricted.gif?raw=true "Title")

https://effekseer.github.io/en/

https://libgdx.badlogicgames.com/

### Supported platforms

Android,
Windows and
Linux



sourceCompatibility = 1.8


###Core

[![Maven Central](https://img.shields.io/maven-central/v/io.github.srjohnathan/gdx-effekseer.svg?label=Maven%20Central&style=for-the-badge&logo=appveyor)](https://search.maven.org/search?q=g:%22io.github.srjohnathan%22%20AND%20a:%22gdx-effekseer%22)

```groovy
api 'io.github.srjohnathan:gdx-effekseer:2.1'
```

###Desktop

[![Maven Central](https://img.shields.io/maven-central/v/io.github.srjohnathan/gdx-effekseer-desktop.svg?label=Maven%20Central&style=for-the-badge&logo=appveyor)](https://search.maven.org/search?q=g:%22io.github.srjohnathan%22%20AND%20a:%22gdx-effekseer-desktop%22)

```groovy
api 'io.github.srjohnathan:gdx-effekseer-desktop:2.1'
```

###Android

[![Maven Central](https://img.shields.io/maven-central/v/io.github.srjohnathan/gdx-effekseer-android.svg?label=Maven%20Central&style=for-the-badge&logo=appveyor)](https://search.maven.org/search?q=g:%22io.github.srjohnathan%22%20AND%20a:%22gdx-effekseer-android%22)

```groovy
natives 'io.github.srjohnathan:gdx-effekseer-android:2.1'
```

build.gradle :android

```groovy
task copyEffekseerNatives {
    doFirst {
        configurations.natives.copy().files.each { jar ->

            if (jar.name.endsWith("gdx-effekseer-android-2.1-SNAPSHOT.jar")){

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
  PerspectiveCamera  perspectiveCamera = new PerspectiveCamera(67, 1280f, 720);

  // Create a new manager for the particles
  EffekseerManager  manager = new EffekseerManager(perspectiveCamera);

        // create a new particle
        effekseer = new ParticleEffekseer(manager);
        effekseer.setMagnification(20f);
        try {
            
            // true = InternalStorage
            // false = ExternalStorage

            effekseer.load("data/tu.efk",false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    effekseer.play();
```


#### Render function

``` java
@Override
        public void render() {

...

        manager.draw(Gdx.graphics.getDeltaTime());
} 
```

#### dispose function

```java  
@Override
    public void dispose() {
manager.dispose();
} 
```

#### 2D Effects  orthographicCamera
```java
  OrthographicCamera  orthographicCamera = new OrthographicCamera(1280f,720f);
  EffekseerManager  manager = new EffekseerManager(orthographicCamera);
```

### animation functions

```java
  effekseer = new ParticleEffekseer(manager);



try {
            effekseer.load("data/ring.efk",true);
        } catch (Exception e) {
            e.printStackTrace();
        }

effekseer.play();

// called after the play function

effekseer.setPosition2D(); //2d animation;
effekseer.getScale(); 
effekseer.setScale();
effekseer.getNodeSize();
effekseer.rotate();
effekseer.translate();
effekseer.getNode();
effekseer.pause();
effekseer.resume();
effekseer.setOnAnimationComplete();
effekseer.transform    //3d animation;
```

[![paypal](https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=ZESRVEEVLLCY6)

### Contributors:
* Antonio Johnathan       https://github.com/SrJohnathan
* Durswd                 https://github.com/durswd

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
