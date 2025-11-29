package com.google.android.exoplayer2.util;

/* loaded from: classes2.dex */
public final class RepeatModeUtil {
    public static boolean isRepeatModeEnabled(int repeatMode, int enabledModes) {
        if (repeatMode != 0) {
            return repeatMode != 1 ? repeatMode == 2 && (enabledModes & 2) != 0 : (enabledModes & 1) != 0;
        }
        return true;
    }

    public static int getNextRepeatMode(int currentMode, int enabledModes) {
        for (int i = 1; i <= 2; i++) {
            int i2 = (currentMode + i) % 3;
            if (isRepeatModeEnabled(i2, enabledModes)) {
                return i2;
            }
        }
        return currentMode;
    }
}
