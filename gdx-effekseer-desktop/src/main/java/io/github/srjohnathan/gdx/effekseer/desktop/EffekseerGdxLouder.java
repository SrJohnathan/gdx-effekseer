package io.github.srjohnathan.gdx.effekseer.desktop;

import java.io.IOException;

 public class EffekseerGdxLouder  {

    public static boolean init() {
        {
            try {
                if (OsCheck.getOperatingSystemType() == OsCheck.OSType.Windows) {
                    NativeUtils.loadLibraryFromJar("/src.dll");
                    return  true;
                } else {
                    NativeUtils.loadLibraryFromJar("/libsrc.so");
                    return  true;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return  false;
            }



        }
    }
}
