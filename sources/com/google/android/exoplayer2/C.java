package com.google.android.exoplayer2;

import java.util.UUID;

/* loaded from: classes2.dex */
public final class C {
    public static final UUID UUID_NIL = new UUID(0, 0);
    public static final UUID COMMON_PSSH_UUID = new UUID(1186680826959645954L, -5988876978535335093L);
    public static final UUID CLEARKEY_UUID = new UUID(-2129748144642739255L, 8654423357094679310L);
    public static final UUID WIDEVINE_UUID = new UUID(-1301668207276963122L, -6645017420763422227L);
    public static final UUID PLAYREADY_UUID = new UUID(-7348484286925749626L, -6083546864340672619L);

    public static long msToUs(long timeMs) {
        return (timeMs == -9223372036854775807L || timeMs == Long.MIN_VALUE) ? timeMs : timeMs * 1000;
    }

    public static long usToMs(long timeUs) {
        return (timeUs == -9223372036854775807L || timeUs == Long.MIN_VALUE) ? timeUs : timeUs / 1000;
    }
}
