package io.github.srjohnathan.gdx.effekseer.desktop;

import java.io.IOException;

 public class EffekseerGdxLouder {

    public static void init() {
        {
            try {
                if (OsCheck.getOperatingSystemType() == OsCheck.OSType.Windows) {
                    NativeUtils.loadLibraryFromJar("/resources/src.dll");
                } else {
                    NativeUtils.loadLibraryFromJar("/resources/libsrc.so");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
