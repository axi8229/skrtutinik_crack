package com.group_ib.sdk;

/* renamed from: com.group_ib.sdk.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0591d implements S0 {
    public final /* synthetic */ C0595f a;

    public C0591d(C0595f c0595f) {
        this.a = c0595f;
    }

    @Override // com.group_ib.sdk.S0
    public final void a(int i, Object obj) {
        if (i == 4) {
            C0595f.k = true;
            this.a.b();
            c1.a(4, 4, "MobileSdk", "Activity created, logs sending enabled");
        }
    }
}
