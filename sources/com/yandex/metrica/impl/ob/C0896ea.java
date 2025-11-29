package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufStateSerializer;

/* renamed from: com.yandex.metrica.impl.ob.ea, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0896ea {
    private C1325vm a;

    C0896ea(C1325vm c1325vm) {
        this.a = c1325vm;
    }

    public ProtobufStateSerializer a() {
        return new C1019j9(new C0945g9(), new C1349wm("AES/CBC/PKCS5Padding", this.a.b(), this.a.a()));
    }

    public ProtobufStateSerializer b() {
        return new C1019j9(new Z2(), new C1349wm("AES/CBC/PKCS5Padding", this.a.b(), this.a.a()));
    }

    public ProtobufStateSerializer c() {
        return new C1019j9(new C0995i9(), new C1349wm("AES/CBC/PKCS5Padding", this.a.b(), this.a.a()));
    }

    public ProtobufStateSerializer d() {
        return new C1019j9(new C1044k9(), new C1349wm("AES/CBC/PKCS5Padding", this.a.b(), this.a.a()));
    }

    public ProtobufStateSerializer e() {
        return new C1019j9(new Zd(), new C1349wm("AES/CBC/PKCS5Padding", this.a.b(), this.a.a()));
    }

    @Deprecated
    public ProtobufStateSerializer f() {
        return new C1019j9(new C0975he(), new C1349wm("AES/CBC/PKCS5Padding", this.a.b(), this.a.a()));
    }

    public ProtobufStateSerializer g() {
        return new C1019j9(new C1094m9(), new C1349wm("AES/CBC/PKCS5Padding", this.a.b(), this.a.a()));
    }

    public ProtobufStateSerializer h() {
        return new C1019j9(new C1144o9(), new C1349wm("AES/CBC/PKCS5Padding", this.a.b(), this.a.a()));
    }

    public ProtobufStateSerializer i() {
        return new C1019j9(new C1169p9(), new C1349wm("AES/CBC/PKCS5Padding", this.a.b(), this.a.a()));
    }
}
