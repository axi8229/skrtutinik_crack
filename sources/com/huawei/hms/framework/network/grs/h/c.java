package com.huawei.hms.framework.network.grs.h;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class c {
    private static final String a = "c";

    public static String a(String str, Context context) throws IOException {
        Logger.d(a, "Io getConfigContent, fileName: " + str);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStreamOpen = null;
        try {
            try {
                if (!new File(str).isDirectory()) {
                    inputStreamOpen = context.getAssets().open(str);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = inputStreamOpen.read(bArr);
                        if (i == -1) {
                            byteArrayOutputStream.flush();
                            String string = byteArrayOutputStream.toString("UTF-8");
                            IoUtils.closeSecure((OutputStream) byteArrayOutputStream);
                            IoUtils.closeSecure(inputStreamOpen);
                            return string;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                }
            } catch (IOException unused) {
                Logger.w(a, "local config file is not exist.filename is {%s}", str);
            }
            IoUtils.closeSecure((OutputStream) byteArrayOutputStream);
            IoUtils.closeSecure(inputStreamOpen);
            return "";
        } catch (Throwable th) {
            IoUtils.closeSecure((OutputStream) byteArrayOutputStream);
            IoUtils.closeSecure(inputStreamOpen);
            throw th;
        }
    }
}
