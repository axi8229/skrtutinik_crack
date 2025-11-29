package com.yandex.metrica.network.impl;

import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
final class b extends Lambda implements Function0 {
    final /* synthetic */ HttpsURLConnection a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b(HttpsURLConnection httpsURLConnection) {
        super(0);
        this.a = httpsURLConnection;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return this.a.getErrorStream();
    }
}
