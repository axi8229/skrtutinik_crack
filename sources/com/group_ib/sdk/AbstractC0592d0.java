package com.group_ib.sdk;

import java.nio.ByteBuffer;
import java.util.HashMap;

/* renamed from: com.group_ib.sdk.d0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC0592d0 {
    public static Integer a(byte[] bArr, HashMap map, Integer num, int i) {
        map.put(num, ByteBuffer.wrap(bArr));
        return Integer.valueOf(i);
    }
}
