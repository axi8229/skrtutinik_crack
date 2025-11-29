package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.zn;
import java.util.Map;

/* loaded from: classes3.dex */
public class rn<T, R> implements vn<T, R> {
    @Override // com.yandex.metrica.impl.ob.vn
    public zn<Map<T, R>> a(Map<T, R> map) {
        return new zn<>(zn.a.NEW, map);
    }

    @Override // com.yandex.metrica.impl.ob.wn
    public zn get(Object obj) {
        return new zn(zn.a.NEW, (Map) obj);
    }
}
