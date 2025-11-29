package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.io.File;

/* renamed from: com.yandex.metrica.impl.ob.u6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class RunnableC1285u6 implements Runnable {
    private final File a;
    private final InterfaceC1107mm<File> b;
    private final C1301um c;

    public RunnableC1285u6(Context context, File file, InterfaceC1107mm<File> interfaceC1107mm) {
        this(file, interfaceC1107mm, C1301um.a(context));
    }

    @Override // java.lang.Runnable
    public void run() {
        File[] fileArrListFiles;
        if (this.a.exists() && this.a.isDirectory() && (fileArrListFiles = this.a.listFiles()) != null) {
            for (File file : fileArrListFiles) {
                C1253sm c1253smA = this.c.a(file.getName());
                try {
                    c1253smA.a();
                    this.b.b(file);
                } catch (Throwable unused) {
                }
                c1253smA.c();
            }
        }
    }

    RunnableC1285u6(File file, InterfaceC1107mm<File> interfaceC1107mm, C1301um c1301um) {
        this.a = file;
        this.b = interfaceC1107mm;
        this.c = c1301um;
    }
}
