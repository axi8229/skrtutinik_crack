package com.yandex.metrica.impl.ob;

import com.yandex.metrica.networktasks.api.CacheControlHttpsConnectionPerformer;

/* renamed from: com.yandex.metrica.impl.ob.ch, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C0853ch implements CacheControlHttpsConnectionPerformer.Client {
    final /* synthetic */ C0903eh a;
    final /* synthetic */ C0803ah b;
    final /* synthetic */ C0828bh c;

    C0853ch(C0828bh c0828bh, C0903eh c0903eh, C0803ah c0803ah) {
        this.c = c0828bh;
        this.a = c0903eh;
        this.b = c0803ah;
    }

    @Override // com.yandex.metrica.networktasks.api.CacheControlHttpsConnectionPerformer.Client
    public String getOldETag() {
        return this.a.b;
    }

    @Override // com.yandex.metrica.networktasks.api.CacheControlHttpsConnectionPerformer.Client
    public void onError() {
        this.b.a();
    }

    @Override // com.yandex.metrica.networktasks.api.CacheControlHttpsConnectionPerformer.Client
    public void onNotModified() {
        C0803ah c0803ah = this.b;
        C0903eh c0903eh = this.a;
        c0803ah.a(new C0903eh(c0903eh.a, c0903eh.b, this.c.f.currentTimeMillis(), true, false));
    }

    @Override // com.yandex.metrica.networktasks.api.CacheControlHttpsConnectionPerformer.Client
    public void onResponse(String str, byte[] bArr) {
        this.b.a(new C0903eh(this.c.c.a(this.c.d.a(bArr, "af9202nao18gswqp")), str, this.c.f.currentTimeMillis(), true, false));
    }
}
