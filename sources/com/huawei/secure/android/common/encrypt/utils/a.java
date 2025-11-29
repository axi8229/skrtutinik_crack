package com.huawei.secure.android.common.encrypt.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class a {
    public static void a(InputStream inputStream) throws IOException {
        a((Closeable) inputStream);
    }

    public static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                b.b("IOUtil", "closeSecure IOException");
            }
        }
    }
}
