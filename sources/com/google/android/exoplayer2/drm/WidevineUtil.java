package com.google.android.exoplayer2.drm;

import android.util.Pair;
import java.util.Map;

/* loaded from: classes2.dex */
public final class WidevineUtil {
    public static Pair<Long, Long> getLicenseDurationRemainingSec(DrmSession drmSession) {
        Map<String, String> mapQueryKeyStatus = drmSession.queryKeyStatus();
        if (mapQueryKeyStatus == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(getDurationRemainingSec(mapQueryKeyStatus, "LicenseDurationRemaining")), Long.valueOf(getDurationRemainingSec(mapQueryKeyStatus, "PlaybackDurationRemaining")));
    }

    private static long getDurationRemainingSec(Map<String, String> keyStatus, String property) {
        if (keyStatus == null) {
            return -9223372036854775807L;
        }
        try {
            String str = keyStatus.get(property);
            if (str != null) {
                return Long.parseLong(str);
            }
            return -9223372036854775807L;
        } catch (NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }
}
