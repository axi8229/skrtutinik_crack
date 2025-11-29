package com.yandex.metrica.impl.ob;

import com.yandex.metrica.networktasks.api.ConfigProvider;

/* loaded from: classes3.dex */
public final class C0 implements ConfigProvider {
    private final Object a;

    public C0(Object obj) {
        this.a = obj;
    }

    @Override // com.yandex.metrica.networktasks.api.ConfigProvider
    public Object getConfig() {
        return this.a;
    }
}
