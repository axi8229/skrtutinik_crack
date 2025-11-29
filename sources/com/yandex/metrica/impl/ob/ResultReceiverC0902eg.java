package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/* renamed from: com.yandex.metrica.impl.ob.eg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class ResultReceiverC0902eg extends ResultReceiver {
    public static final /* synthetic */ int b = 0;
    private final InterfaceC0852cg a;

    public ResultReceiverC0902eg(Handler handler, InterfaceC0852cg interfaceC0852cg) {
        super(handler);
        this.a = interfaceC0852cg;
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i, Bundle bundle) {
        C0877dg c0877dgA;
        if (i == 1) {
            try {
                c0877dgA = C0877dg.a(bundle.getByteArray("referrer"));
            } catch (Throwable unused) {
                c0877dgA = null;
            }
            this.a.a(c0877dgA);
        }
    }
}
