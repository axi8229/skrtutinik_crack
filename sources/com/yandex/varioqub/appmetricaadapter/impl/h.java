package com.yandex.varioqub.appmetricaadapter.impl;

import com.yandex.metrica.IIdentifierCallback;
import com.yandex.varioqub.analyticadapter.AdapterIdentifiersCallback;
import java.util.Map;

/* loaded from: classes3.dex */
public final class h implements IIdentifierCallback {
    public final /* synthetic */ AdapterIdentifiersCallback a;

    public h(AdapterIdentifiersCallback adapterIdentifiersCallback) {
        this.a = adapterIdentifiersCallback;
    }

    @Override // com.yandex.metrica.IIdentifierCallback
    public final void onReceive(Map map) {
        AdapterIdentifiersCallback adapterIdentifiersCallback = this.a;
        String str = (String) map.get("yandex_mobile_metrica_uuid");
        if (str == null) {
            str = "";
        }
        adapterIdentifiersCallback.onSuccess(str);
    }

    @Override // com.yandex.metrica.IIdentifierCallback
    public final void onRequestError(IIdentifierCallback.Reason reason) {
        this.a.onError(reason.toString());
    }
}
