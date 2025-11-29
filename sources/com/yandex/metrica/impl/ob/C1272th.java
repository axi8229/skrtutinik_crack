package com.yandex.metrica.impl.ob;

import com.yandex.metrica.networktasks.api.CacheControlHttpsConnectionPerformer;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;

/* renamed from: com.yandex.metrica.impl.ob.th, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1272th implements CacheControlHttpsConnectionPerformer.Client {
    final /* synthetic */ C0879di a;
    final /* synthetic */ File b;
    final /* synthetic */ Eh c;
    final /* synthetic */ C1296uh d;

    C1272th(C1296uh c1296uh, C0879di c0879di, File file, Eh eh) {
        this.d = c1296uh;
        this.a = c0879di;
        this.b = file;
        this.c = eh;
    }

    @Override // com.yandex.metrica.networktasks.api.CacheControlHttpsConnectionPerformer.Client
    public String getOldETag() {
        return this.d.e.b();
    }

    @Override // com.yandex.metrica.networktasks.api.CacheControlHttpsConnectionPerformer.Client
    public void onError() {
        C1296uh.a(this.d, this.a.h);
        C1296uh.c(this.d);
    }

    @Override // com.yandex.metrica.networktasks.api.CacheControlHttpsConnectionPerformer.Client
    public void onNotModified() {
        C1296uh.a(this.d, this.a.i);
        C1296uh.c(this.d);
        this.c.a(this.b);
    }

    @Override // com.yandex.metrica.networktasks.api.CacheControlHttpsConnectionPerformer.Client
    public void onResponse(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        C1296uh.a(this.d, this.a.i);
        C1296uh.c(this.d);
        this.d.e.b(str);
        C1296uh c1296uh = this.d;
        File file = this.b;
        c1296uh.getClass();
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fileOutputStream = null;
        }
        A2.a((Closeable) fileOutputStream);
        this.c.a(this.b);
    }
}
