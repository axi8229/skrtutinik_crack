package com.yandex.metrica.impl.ob;

import java.io.File;

/* renamed from: com.yandex.metrica.impl.ob.t6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class RunnableC1261t6<Output> implements Runnable {
    private final File a;
    private final InterfaceC1132nm<File, Output> b;
    private final InterfaceC1107mm<File> c;
    private final InterfaceC1107mm<Output> d;

    public RunnableC1261t6(File file, InterfaceC1132nm<File, Output> interfaceC1132nm, InterfaceC1107mm<File> interfaceC1107mm, InterfaceC1107mm<Output> interfaceC1107mm2) {
        this.a = file;
        this.b = interfaceC1132nm;
        this.c = interfaceC1107mm;
        this.d = interfaceC1107mm2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.exists()) {
            try {
                Output outputA = this.b.a(this.a);
                if (outputA != null) {
                    this.d.b(outputA);
                }
            } catch (Throwable unused) {
            }
            this.c.b(this.a);
        }
    }
}
