package com.yandex.metrica.impl.ob;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.yandex.metrica.impl.ob.lb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1071lb implements InterfaceC1096mb, InterfaceC1121nb {
    private final Set<Integer> a;
    private AtomicLong b;

    public C1071lb(L7 l7) {
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        hashSet.add(Integer.valueOf(EnumC0787a1.EVENT_TYPE_FIRST_ACTIVATION.b()));
        hashSet.add(Integer.valueOf(EnumC0787a1.EVENT_TYPE_APP_UPDATE.b()));
        hashSet.add(Integer.valueOf(EnumC0787a1.EVENT_TYPE_INIT.b()));
        hashSet.add(Integer.valueOf(EnumC0787a1.EVENT_TYPE_IDENTITY.b()));
        hashSet.add(Integer.valueOf(EnumC0787a1.EVENT_TYPE_SEND_REFERRER.b()));
        l7.a(this);
        this.b = new AtomicLong(l7.a(hashSet));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1096mb
    public boolean a() {
        return this.b.get() > 0;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1121nb
    public void b(List<Integer> list) {
        int i = 0;
        for (Integer num : list) {
            num.intValue();
            if (this.a.contains(num)) {
                i++;
            }
        }
        this.b.addAndGet(-i);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1121nb
    public void a(List<Integer> list) {
        int i = 0;
        for (Integer num : list) {
            num.intValue();
            if (this.a.contains(num)) {
                i++;
            }
        }
        this.b.addAndGet(i);
    }
}
