package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;

/* renamed from: com.yandex.metrica.impl.ob.ca, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0846ca implements ProtobufConverter {
    private final C0821ba a;

    public C0846ca() {
        this(new C0821ba());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.v fromModel(C0982hl c0982hl) {
        If.v vVar = new If.v();
        vVar.a = c0982hl.a;
        vVar.b = c0982hl.b;
        vVar.c = c0982hl.c;
        vVar.d = c0982hl.d;
        vVar.i = c0982hl.e;
        vVar.j = c0982hl.f;
        vVar.k = c0982hl.g;
        vVar.l = c0982hl.h;
        vVar.n = c0982hl.i;
        vVar.o = c0982hl.j;
        vVar.e = c0982hl.k;
        vVar.f = c0982hl.l;
        vVar.g = c0982hl.m;
        vVar.h = c0982hl.n;
        vVar.p = c0982hl.o;
        vVar.m = this.a.fromModel(c0982hl.p);
        return vVar;
    }

    C0846ca(C0821ba c0821ba) {
        this.a = c0821ba;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0982hl toModel(If.v vVar) {
        return new C0982hl(vVar.a, vVar.b, vVar.c, vVar.d, vVar.i, vVar.j, vVar.k, vVar.l, vVar.n, vVar.o, vVar.e, vVar.f, vVar.g, vVar.h, vVar.p, this.a.toModel(vVar.m));
    }
}
