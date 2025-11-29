package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.ProtobufStateStorage;
import com.yandex.metrica.impl.ob.InterfaceC0921fa;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.c3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0839c3 implements InterfaceC1109n {
    private final ProtobufStateStorage a;
    private X2 b;

    public C0839c3(Context context) {
        this(InterfaceC0921fa.b.a(X2.class).a(context));
    }

    public void a(List<com.yandex.metrica.billing_interface.a> list, boolean z) {
        for (com.yandex.metrica.billing_interface.a aVar : list) {
        }
        X2 x2 = new X2(list, z);
        this.b = x2;
        this.a.save(x2);
    }

    public boolean b() {
        return this.b.b;
    }

    C0839c3(ProtobufStateStorage protobufStateStorage) {
        this.a = protobufStateStorage;
        this.b = (X2) protobufStateStorage.read();
    }

    public List<com.yandex.metrica.billing_interface.a> a() {
        return this.b.a;
    }
}
