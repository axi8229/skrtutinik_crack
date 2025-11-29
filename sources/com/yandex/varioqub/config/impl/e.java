package com.yandex.varioqub.config.impl;

import android.util.Log;
import com.yandex.varioqub.analyticadapter.AdapterIdentifiersCallback;

/* loaded from: classes3.dex */
public final class e implements AdapterIdentifiersCallback {
    public final /* synthetic */ g a;

    public e(g gVar) {
        this.a = gVar;
    }

    @Override // com.yandex.varioqub.analyticadapter.AdapterIdentifiersCallback
    public final void onError(String str) {
        this.a.getClass();
        boolean z = C.a;
        if (z && z) {
            Log.e("Varioqub/Varioqub/IdentifierProvider", str, null);
        }
        l.a(3);
    }

    @Override // com.yandex.varioqub.analyticadapter.AdapterIdentifiersCallback
    public final void onSuccess(String str) {
        this.a.getClass();
        String str2 = "received deviceId from adapter - " + str;
        if (C.a) {
            Log.d("Varioqub/IdentifierProvider", str2);
        }
        this.a.d = str;
        l.a(3);
    }
}
