package com.yandex.metrica.impl.ob;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0910f implements InterfaceC1059l {
    private boolean a;
    private final Map<String, com.yandex.metrica.billing_interface.a> b;
    private final InterfaceC1109n c;

    public C0910f(InterfaceC1109n storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        this.c = storage;
        C0839c3 c0839c3 = (C0839c3) storage;
        this.a = c0839c3.b();
        List<com.yandex.metrica.billing_interface.a> listA = c0839c3.a();
        Intrinsics.checkNotNullExpressionValue(listA, "storage.billingInfo");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : listA) {
            linkedHashMap.put(((com.yandex.metrica.billing_interface.a) obj).b, obj);
        }
        this.b = linkedHashMap;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1059l
    public void a(Map<String, ? extends com.yandex.metrica.billing_interface.a> history) {
        Intrinsics.checkNotNullParameter(history, "history");
        for (com.yandex.metrica.billing_interface.a aVar : history.values()) {
            Map<String, com.yandex.metrica.billing_interface.a> map = this.b;
            String str = aVar.b;
            Intrinsics.checkNotNullExpressionValue(str, "billingInfo.sku");
            map.put(str, aVar);
        }
        ((C0839c3) this.c).a(CollectionsKt.toList(this.b.values()), this.a);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1059l
    public void b() {
        if (this.a) {
            return;
        }
        this.a = true;
        ((C0839c3) this.c).a(CollectionsKt.toList(this.b.values()), this.a);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1059l
    public com.yandex.metrica.billing_interface.a a(String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        return this.b.get(sku);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1059l
    public boolean a() {
        return this.a;
    }
}
