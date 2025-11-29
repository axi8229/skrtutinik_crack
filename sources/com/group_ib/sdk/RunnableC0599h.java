package com.group_ib.sdk;

/* renamed from: com.group_ib.sdk.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0599h implements Runnable {
    public final /* synthetic */ InterfaceC0609m a;
    public final /* synthetic */ String b;

    public RunnableC0599h(InterfaceC0609m interfaceC0609m, String str) {
        this.a = interfaceC0609m;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.a(this.b);
        } catch (Exception e) {
            c1.b(MobileSdkService.O, "Exception in SessionListener", e);
        }
    }
}
