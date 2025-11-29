package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;

/* loaded from: classes2.dex */
public final class WavUtil {
    public static int getPcmEncodingForType(int type, int bitsPerSample) {
        if (type != 1) {
            if (type == 3) {
                return bitsPerSample == 32 ? 4 : 0;
            }
            if (type != 65534) {
                return 0;
            }
        }
        return Util.getPcmEncoding(bitsPerSample);
    }
}
