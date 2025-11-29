package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.en, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0909en<T> implements InterfaceC0934fn<T> {
    private final InterfaceC0934fn<T> a;

    public C0909en(InterfaceC0934fn<T> interfaceC0934fn, T t) {
        this.a = interfaceC0934fn;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0934fn
    public T a(T t) {
        return t != this.a.a(t) ? "<truncated data was not sent, see METRIKALIB-4568>" : t;
    }
}
