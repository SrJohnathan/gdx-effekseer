package io.github.srjohnathan.gdx.effekseer.core;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EffekseerGdx  implements Disposable {

    private  static   String className;

    public static void init (){
        if(Gdx.app.getType() == Application.ApplicationType.Android){
            System.loadLibrary("libgdx");
        }else {
            className = "io.github.srjohnathan.gdx.effekseer.desktop.EffekseerGdxLouder";
            try {
                Class cls = ClassReflection.forName(className);
                try {
                    Method m = cls.getMethod("init");
                    m.invoke(null);
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (ReflectionException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public void dispose() {

    }
}
