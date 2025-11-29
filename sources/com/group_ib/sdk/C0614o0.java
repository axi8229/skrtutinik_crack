package com.group_ib.sdk;

import java.io.BufferedWriter;
import java.io.File;

/* renamed from: com.group_ib.sdk.o0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0614o0 {
    public final File a;
    public final String b;
    public String c = null;
    public BufferedWriter d = null;

    public C0614o0(MobileSdkService mobileSdkService) {
        File file = new File(mobileSdkService.getCacheDir() + File.separator + "logs");
        this.a = file;
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        this.b = file.getAbsolutePath();
    }

    public final void a(long j, String str) {
        BufferedWriter bufferedWriter = this.d;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.write("I," + str + "," + j + '\n');
                this.d.flush();
            } catch (Exception e) {
                c1.b("PackageDb", "failed to update packages cache", e);
            }
        }
    }

    public final void b(long j, String str) {
        if (this.d != null) {
            try {
                c1.a(4, 4, "PackageDb", "Package removed: " + str + " at " + j);
                this.d.write("D," + str + "," + j + '\n');
                this.d.flush();
            } catch (Exception e) {
                c1.b("PackageDb", "failed to update packages cache", e);
            }
        }
    }

    public final String a() {
        String name;
        File[] fileArrListFiles = this.a.listFiles(new C0612n0());
        if (fileArrListFiles != null) {
            long j = Long.MIN_VALUE;
            name = null;
            for (int i = 0; i < fileArrListFiles.length; i++) {
                long jLastModified = fileArrListFiles[i].lastModified();
                if (jLastModified > j) {
                    name = fileArrListFiles[i].getName();
                    j = jLastModified;
                }
            }
            for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                if (fileArrListFiles[i2].lastModified() != j) {
                    fileArrListFiles[i2].delete();
                }
            }
        } else {
            name = null;
        }
        if (name == null) {
            return null;
        }
        return this.b + File.separator + name;
    }
}
