package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.yandex.metrica.impl.ob.gj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0955gj implements InterfaceC0855cj {
    private final Context a;
    private final B0 b;

    C0955gj(Context context, B0 b0) {
        this.a = context;
        this.b = b0;
    }

    private boolean b() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        boolean zExists;
        File fileC = this.b.c(this.a);
        if (fileC != null) {
            this.b.getClass();
            zExists = new File(fileC, "metrica_data.db").exists();
        } else {
            zExists = false;
        }
        if (!zExists && A2.a(21)) {
            B0 b0 = this.b;
            Context context = this.a;
            b0.getClass();
            File noBackupFilesDir = context.getNoBackupFilesDir();
            File file = noBackupFilesDir == null ? null : new File(noBackupFilesDir, "metrica_data.db");
            zExists = file != null && file.exists();
        }
        if (zExists) {
            return zExists;
        }
        B0 b02 = this.b;
        Context context2 = this.a;
        b02.getClass();
        File databasePath = context2.getDatabasePath("metrica_data.db");
        return databasePath != null && databasePath.exists();
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0855cj
    public boolean a() {
        return !b();
    }
}
