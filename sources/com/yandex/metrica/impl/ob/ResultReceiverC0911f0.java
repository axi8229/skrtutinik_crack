package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

@SuppressLint({"ParcelCreator"})
/* renamed from: com.yandex.metrica.impl.ob.f0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class ResultReceiverC0911f0 extends ResultReceiver {
    public static final /* synthetic */ int b = 0;
    private final a a;

    /* renamed from: com.yandex.metrica.impl.ob.f0$a */
    public interface a {
        void a(int i, Bundle bundle);
    }

    public ResultReceiverC0911f0(Handler handler, a aVar) {
        super(handler);
        this.a = aVar;
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.setClassLoader(C0932fl.class.getClassLoader());
        this.a.a(i, bundle);
    }
}
