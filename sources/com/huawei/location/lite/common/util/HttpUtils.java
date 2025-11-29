package com.huawei.location.lite.common.util;

import com.huawei.location.lite.common.log.LogLocation;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

/* loaded from: classes3.dex */
public class HttpUtils {
    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null || outputStream == null) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        try {
            if (inputStream == null) {
                return new byte[0];
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    copy(inputStream, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                } finally {
                }
            } catch (IOException unused) {
                LogLocation.d("HttpUtils", "toByteArray error");
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    LogLocation.e("HttpUtils", "toByteArray close error");
                }
                return new byte[0];
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused3) {
                LogLocation.e("HttpUtils", "toByteArray close error");
            }
        }
    }

    public static String urlDecode(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }
}
