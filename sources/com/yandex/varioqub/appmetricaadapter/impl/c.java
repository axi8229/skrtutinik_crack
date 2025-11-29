package com.yandex.varioqub.appmetricaadapter.impl;

import android.content.Context;
import com.yandex.varioqub.analyticadapter.AdapterIdentifiersCallback;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.IModuleReporter;
import io.appmetrica.analytics.ModulesFacade;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;

/* loaded from: classes3.dex */
public final class c implements d {
    public IModuleReporter a;

    @Override // com.yandex.varioqub.appmetricaadapter.impl.d
    public final void a(Context context, AdapterIdentifiersCallback adapterIdentifiersCallback) {
        AppMetrica.requestStartupParams(context, new a(adapterIdentifiersCallback), CollectionsKt.listOf("appmetrica_device_id"));
    }

    @Override // com.yandex.varioqub.appmetricaadapter.impl.d
    public final void b(Context context, AdapterIdentifiersCallback adapterIdentifiersCallback) {
        AppMetrica.requestStartupParams(context, new b(adapterIdentifiersCallback), CollectionsKt.listOf("appmetrica_uuid"));
    }

    @Override // com.yandex.varioqub.appmetricaadapter.impl.d
    public final void a(byte[] bArr) {
        IModuleReporter iModuleReporter = this.a;
        if (iModuleReporter != null) {
            iModuleReporter.setSessionExtra("varioqub", bArr);
        } else {
            ModulesFacade.setSessionExtra("varioqub", bArr);
        }
    }

    @Override // com.yandex.varioqub.appmetricaadapter.impl.d
    public final void a(LinkedHashMap linkedHashMap) {
        AppMetrica.reportEvent("com.yandex.varioqub.activate_config", linkedHashMap);
    }
}
