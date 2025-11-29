package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* renamed from: com.yandex.metrica.impl.ob.da, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0871da implements ProtobufConverter {
    private final C0821ba a;

    public C0871da() {
        this(new C0821ba());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.w fromModel(C1348wl c1348wl) {
        If.w wVar = new If.w();
        wVar.a = c1348wl.a;
        wVar.b = c1348wl.b;
        wVar.c = c1348wl.c;
        wVar.d = c1348wl.d;
        wVar.e = c1348wl.e;
        wVar.f = c1348wl.f;
        wVar.g = c1348wl.g;
        wVar.h = this.a.fromModel(c1348wl.h);
        return wVar;
    }

    C0871da(C0821ba c0821ba) {
        this.a = c0821ba;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1348wl toModel(If.w wVar) {
        return new C1348wl(wVar.a, wVar.b, wVar.c, wVar.d, wVar.e, wVar.f, wVar.g, this.a.toModel(wVar.h));
    }
}
