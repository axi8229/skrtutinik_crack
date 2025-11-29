package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.yandex.metrica.impl.ob.x7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1358x7 {
    private final Context a;
    private final File b;
    private final B0 c;

    C1358x7(Context context, File file) {
        this(context, file, new B0());
    }

    @SuppressLint({"SetWorldReadable"})
    String a(String str, String str2) throws IOException {
        ZipFile zipFile;
        String str3 = this.a.getApplicationInfo().sourceDir;
        File fileB = this.c.b(this.b, str2);
        if (fileB == null) {
            return null;
        }
        if (fileB.exists()) {
            return fileB.getAbsolutePath();
        }
        Rm rmA = Rm.a(this.a, "crpad_ext");
        try {
            rmA.a();
            if (fileB.exists()) {
                String absolutePath = fileB.getAbsolutePath();
                rmA.b();
                return absolutePath;
            }
            zipFile = new ZipFile(str3);
            try {
                ZipEntry entry = zipFile.getEntry(str);
                if (entry == null) {
                    throw new RuntimeException("Cannot find ZipEntry" + str);
                }
                InputStream inputStream = zipFile.getInputStream(entry);
                FileOutputStream fileOutputStream = new FileOutputStream(fileB);
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = inputStream.read(bArr, 0, 4096);
                    if (-1 == i) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
                if (!fileB.setReadable(true, false)) {
                    rmA.b();
                    try {
                        zipFile.close();
                    } catch (IOException unused) {
                    }
                    return null;
                }
                if (!fileB.setExecutable(true, false)) {
                    rmA.b();
                    try {
                        zipFile.close();
                    } catch (IOException unused2) {
                    }
                    return null;
                }
                String absolutePath2 = fileB.getAbsolutePath();
                rmA.b();
                try {
                    zipFile.close();
                } catch (IOException unused3) {
                }
                return absolutePath2;
            } catch (Throwable unused4) {
                rmA.b();
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException unused5) {
                    }
                }
                return null;
            }
        } catch (Throwable unused6) {
            zipFile = null;
        }
    }

    C1358x7(Context context, File file, B0 b0) {
        this.a = context;
        this.b = file;
        this.c = b0;
    }
}
