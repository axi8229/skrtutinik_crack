package com.yandex.metrica.network.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class e {
    public static final e a = new e();

    private e() {
    }

    public static final Map a(Map original) {
        Intrinsics.checkNotNullParameter(original, "original");
        Map mapUnmodifiableMap = Collections.unmodifiableMap(new HashMap(original));
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "Collections.unmodifiableMap(HashMap(original))");
        return mapUnmodifiableMap;
    }

    public final byte[] a(int i, Function0 inputStreamProvider) {
        Intrinsics.checkNotNullParameter(inputStreamProvider, "inputStreamProvider");
        try {
            InputStream inputStream = (InputStream) inputStreamProvider.invoke();
            if (inputStream != null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[8192];
                        int i2 = 0;
                        while (true) {
                            int i3 = inputStream.read(bArr);
                            if (-1 == i3 || i2 > i) {
                                break;
                            }
                            if (i3 > 0) {
                                byteArrayOutputStream.write(bArr, 0, i3);
                                i2 += i3;
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        Intrinsics.checkNotNullExpressionValue(byteArray, "it.toByteArray()");
                        CloseableKt.closeFinally(byteArrayOutputStream, null);
                        CloseableKt.closeFinally(inputStream, null);
                        return byteArray;
                    } catch (Throwable unused) {
                        CloseableKt.closeFinally(byteArrayOutputStream, null);
                        CloseableKt.closeFinally(inputStream, null);
                    }
                } finally {
                }
            }
        } catch (Throwable unused2) {
        }
        return new byte[0];
    }
}
