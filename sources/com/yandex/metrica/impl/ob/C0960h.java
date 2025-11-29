package com.yandex.metrica.impl.ob;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0960h implements InterfaceC1134o {
    private final com.yandex.metrica.billing_interface.g a;

    public C0960h(com.yandex.metrica.billing_interface.g systemTimeProvider) {
        Intrinsics.checkNotNullParameter(systemTimeProvider, "systemTimeProvider");
        this.a = systemTimeProvider;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1134o
    public Map<String, com.yandex.metrica.billing_interface.a> a(C0985i config, Map<String, ? extends com.yandex.metrica.billing_interface.a> history, InterfaceC1059l storage) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(history, "history");
        Intrinsics.checkNotNullParameter(storage, "storage");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends com.yandex.metrica.billing_interface.a> entry : history.entrySet()) {
            com.yandex.metrica.billing_interface.a value = entry.getValue();
            this.a.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (value.a != com.yandex.metrica.billing_interface.e.INAPP || storage.a()) {
                com.yandex.metrica.billing_interface.a aVarA = storage.a(value.b);
                if (aVarA != null) {
                    Intrinsics.checkNotNullExpressionValue(aVarA, "storage[historyEntry.sku] ?: return true");
                    if (Intrinsics.areEqual(aVarA.c, value.c) && (value.a != com.yandex.metrica.billing_interface.e.SUBS || jCurrentTimeMillis - aVarA.e < TimeUnit.SECONDS.toMillis(config.a))) {
                    }
                }
                linkedHashMap.put(entry.getKey(), entry.getValue());
            } else if (jCurrentTimeMillis - value.d <= TimeUnit.SECONDS.toMillis(config.b)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public /* synthetic */ C0960h(com.yandex.metrica.billing_interface.g gVar, int i) {
        this((i & 1) != 0 ? new com.yandex.metrica.billing_interface.g() : null);
    }
}
