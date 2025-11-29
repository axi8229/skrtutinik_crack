package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.ActivationBarrier;
import com.yandex.metrica.networktasks.api.CacheControlHttpsConnectionPerformer;
import java.io.File;

/* renamed from: com.yandex.metrica.impl.ob.sh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1248sh implements ActivationBarrier.IActivationBarrierCallback {
    final /* synthetic */ String a;
    final /* synthetic */ File b;
    final /* synthetic */ Eh c;
    final /* synthetic */ C0879di d;
    final /* synthetic */ C1296uh e;

    C1248sh(C1296uh c1296uh, String str, File file, Eh eh, C0879di c0879di) {
        this.e = c1296uh;
        this.a = str;
        this.b = file;
        this.c = eh;
        this.d = c0879di;
    }

    @Override // com.yandex.metrica.coreutils.services.ActivationBarrier.IActivationBarrierCallback
    public void onWaitFinished() {
        CacheControlHttpsConnectionPerformer cacheControlHttpsConnectionPerformer = this.e.d;
        String str = this.a;
        C1296uh c1296uh = this.e;
        File file = this.b;
        Eh eh = this.c;
        C0879di c0879di = this.d;
        c1296uh.getClass();
        cacheControlHttpsConnectionPerformer.performConnection(str, new C1272th(c1296uh, c0879di, file, eh));
    }
}
