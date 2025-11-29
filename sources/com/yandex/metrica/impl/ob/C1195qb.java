package com.yandex.metrica.impl.ob;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.yandex.metrica.impl.ob.qb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1195qb implements InterfaceC1096mb, InterfaceC1121nb {
    private final Z3 a;
    private AtomicLong b;

    public C1195qb(L7 l7, Z3 z3) {
        this.a = z3;
        this.b = new AtomicLong(l7.c());
        l7.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.metrica.impl.ob.InterfaceC1096mb
    public boolean a() {
        return this.b.get() >= ((long) ((Lg) this.a.b()).I());
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1121nb
    public void b(List<Integer> list) {
        this.b.addAndGet(-list.size());
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1121nb
    public void a(List<Integer> list) {
        this.b.addAndGet(list.size());
    }
}
