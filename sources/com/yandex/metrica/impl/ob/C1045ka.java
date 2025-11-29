package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;

/* renamed from: com.yandex.metrica.impl.ob.ka, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1045ka {
    private final Context a;
    private final B0 b;

    C1045ka(Context context, B0 b0) {
        this.a = context;
        this.b = b0;
    }

    private String b(String str, File file) {
        this.b.getClass();
        File file2 = new File(file, str);
        if (!file2.exists() && a(this.a.getDatabasePath(str), file, str)) {
            String str2 = str + "-journal";
            a(this.a.getDatabasePath(str2), file, str2);
            String str3 = str + "-shm";
            a(this.a.getDatabasePath(str3), file, str3);
            String str4 = str + "-wal";
            a(this.a.getDatabasePath(str4), file, str4);
        }
        return file2.getAbsolutePath();
    }

    String a(String str, File file) {
        File noBackupFilesDir;
        try {
            this.b.getClass();
            File file2 = new File(file, str);
            if (file2.exists()) {
                return file2.getAbsolutePath();
            }
            if (A2.a(21) && (noBackupFilesDir = this.a.getNoBackupFilesDir()) != null) {
                this.b.getClass();
                if (a(new File(noBackupFilesDir, str), file, str)) {
                    String str2 = str + "-journal";
                    this.b.getClass();
                    a(new File(noBackupFilesDir, str2), file, str2);
                    String str3 = str + "-shm";
                    this.b.getClass();
                    a(new File(noBackupFilesDir, str3), file, str3);
                    String str4 = str + "-wal";
                    this.b.getClass();
                    a(new File(noBackupFilesDir, str4), file, str4);
                    return file2.getAbsolutePath();
                }
            }
            return b(str, file);
        } catch (Throwable unused) {
            return null;
        }
    }

    @TargetApi(21)
    String a(String str) {
        try {
            File noBackupFilesDir = this.a.getNoBackupFilesDir();
            return noBackupFilesDir == null ? str : b(str, noBackupFilesDir);
        } catch (Throwable unused) {
            return str;
        }
    }

    private boolean a(File file, File file2, String str) {
        if (file == null || !file.exists()) {
            return false;
        }
        this.b.getClass();
        File file3 = new File(file2, str);
        boolean zRenameTo = file.renameTo(file3);
        return !zRenameTo ? C0810b.a(file, file3) : zRenameTo;
    }
}
