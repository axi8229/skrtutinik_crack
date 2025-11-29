package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufStateStorage;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.impl.ob.C0878dh;

/* renamed from: com.yandex.metrica.impl.ob.ah, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0803ah {
    private ProtobufStateStorage a;
    private C0903eh b;
    private SystemTimeProvider c;
    private C0953gh d;
    private a e;

    /* renamed from: com.yandex.metrica.impl.ob.ah$a */
    interface a {
    }

    public C0803ah(ProtobufStateStorage protobufStateStorage, a aVar) {
        this(protobufStateStorage, aVar, new SystemTimeProvider(), new C0953gh(protobufStateStorage));
    }

    public void a(C0903eh c0903eh) {
        this.a.save(c0903eh);
        this.b = c0903eh;
        this.d.a();
        C0878dh.a aVar = (C0878dh.a) this.e;
        C0878dh.this.b();
        C0878dh.this.h = false;
    }

    C0803ah(ProtobufStateStorage protobufStateStorage, a aVar, SystemTimeProvider systemTimeProvider, C0953gh c0953gh) {
        this.a = protobufStateStorage;
        this.b = (C0903eh) protobufStateStorage.read();
        this.c = systemTimeProvider;
        this.d = c0953gh;
        this.e = aVar;
    }

    public void a() {
        C0903eh c0903eh = this.b;
        C0903eh c0903eh2 = new C0903eh(c0903eh.a, c0903eh.b, this.c.currentTimeMillis(), true, true);
        this.a.save(c0903eh2);
        this.b = c0903eh2;
        C0878dh.a aVar = (C0878dh.a) this.e;
        C0878dh.this.b();
        C0878dh.this.h = false;
    }
}
