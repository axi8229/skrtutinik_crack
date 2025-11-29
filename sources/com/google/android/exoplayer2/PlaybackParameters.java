package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;

@Deprecated
/* loaded from: classes2.dex */
public final class PlaybackParameters {
    public static final PlaybackParameters DEFAULT = new PlaybackParameters(1.0f);
    private final int scaledUsPerMs;
    public final float speed;

    public PlaybackParameters(float speed) {
        Assertions.checkArgument(speed > 0.0f);
        this.speed = speed;
        this.scaledUsPerMs = Math.round(speed * 1000.0f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && PlaybackParameters.class == obj.getClass() && this.speed == ((PlaybackParameters) obj).speed;
    }

    public int hashCode() {
        return Float.floatToRawIntBits(this.speed);
    }
}
