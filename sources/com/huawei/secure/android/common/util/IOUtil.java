package com.huawei.secure.android.common.util;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class IOUtil {
    public static void deleteSecure(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        Log.e("IOUtil", "deleteSecure exception");
    }

    public static void closeSecure(InputStream inputStream) throws IOException {
        closeSecure((Closeable) inputStream);
    }

    public static void closeSecure(OutputStream outputStream) throws IOException {
        closeSecure((Closeable) outputStream);
    }

    public static void closeSecure(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.e("IOUtil", "closeSecure IOException");
            }
        }
    }
}
