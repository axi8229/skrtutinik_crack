package com.yandex.varioqub.config.impl;

import android.util.Log;
import com.yandex.varioqub.analyticadapter.AdapterIdentifiersCallback;

/* loaded from: classes3.dex */
public final class f implements AdapterIdentifiersCallback {
    public final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    @Override // com.yandex.varioqub.analyticadapter.AdapterIdentifiersCallback
    public final void onError(String str) {
        this.a.b.countDown();
        this.a.getClass();
        boolean z = C.a;
        if (z && z) {
            Log.e("Varioqub/Varioqub/IdentifierProvider", str, null);
        }
    }

    @Override // com.yandex.varioqub.analyticadapter.AdapterIdentifiersCallback
    public final void onSuccess(String str) {
        this.a.getClass();
        String str2 = "received userId from adapter - " + str;
        if (C.a) {
            Log.d("Varioqub/IdentifierProvider", str2);
        }
        g gVar = this.a;
        gVar.c = str;
        gVar.b.countDown();
    }
}
