package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1113n3;

/* renamed from: com.yandex.metrica.impl.ob.p3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1163p3<T extends C1113n3> {
    private final InterfaceC1138o3<T> a;
    private final InterfaceC1088m3<T> b;

    /* renamed from: com.yandex.metrica.impl.ob.p3$b */
    public static final class b<T extends C1113n3> {
        final InterfaceC1138o3<T> a;
        InterfaceC1088m3<T> b;

        b(InterfaceC1138o3<T> interfaceC1138o3) {
            this.a = interfaceC1138o3;
        }

        public b<T> a(InterfaceC1088m3<T> interfaceC1088m3) {
            this.b = interfaceC1088m3;
            return this;
        }

        public C1163p3<T> a() {
            return new C1163p3<>(this);
        }
    }

    final boolean a(C1113n3 c1113n3) {
        InterfaceC1088m3<T> interfaceC1088m3 = this.b;
        if (interfaceC1088m3 == null) {
            return false;
        }
        return interfaceC1088m3.a(c1113n3);
    }

    public void b(C1113n3 c1113n3) {
        this.a.a(c1113n3);
    }

    private C1163p3(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
    }

    public static <T extends C1113n3> b<T> a(InterfaceC1138o3<T> interfaceC1138o3) {
        return new b<>(interfaceC1138o3);
    }
}
