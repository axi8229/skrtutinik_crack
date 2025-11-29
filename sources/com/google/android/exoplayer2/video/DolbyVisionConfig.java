package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes2.dex */
public final class DolbyVisionConfig {
    public final String codecs;
    public final int level;
    public final int profile;

    public static DolbyVisionConfig parse(ParsableByteArray data) {
        String str;
        data.skipBytes(2);
        int unsignedByte = data.readUnsignedByte();
        int i = unsignedByte >> 1;
        int unsignedByte2 = ((data.readUnsignedByte() >> 3) & 31) | ((unsignedByte & 1) << 5);
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = "avc3";
        }
        return new DolbyVisionConfig(i, unsignedByte2, str + ".0" + i + ".0" + unsignedByte2);
    }

    private DolbyVisionConfig(int profile, int level, String codecs) {
        this.profile = profile;
        this.level = level;
        this.codecs = codecs;
    }
}
