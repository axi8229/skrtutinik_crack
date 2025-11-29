package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.ProtobufStateStorage;
import com.yandex.metrica.impl.ob.InterfaceC1231s0;
import com.yandex.metrica.impl.ob.InterfaceC1303v0;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.r0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1207r0<CANDIDATE, CHOSEN extends InterfaceC1303v0, STORAGE extends InterfaceC1231s0<CANDIDATE, CHOSEN>> {
    private final Context a;
    private final ProtobufStateStorage b;
    private final AbstractC1255t0<CHOSEN> c;
    private final InterfaceC1401z2<CANDIDATE, CHOSEN> d;
    private final InterfaceC1209r2<CANDIDATE, CHOSEN, STORAGE> e;
    private final InterfaceC0813b2<CHOSEN> f;
    private final Y1 g;
    private final InterfaceC0886e0 h;
    private STORAGE i;

    /* JADX WARN: Multi-variable type inference failed */
    public C1207r0(Context context, ProtobufStateStorage protobufStateStorage, AbstractC1255t0 abstractC1255t0, InterfaceC1401z2 interfaceC1401z2, InterfaceC1209r2 interfaceC1209r2, InterfaceC0813b2 interfaceC0813b2, Y1 y1, InterfaceC0886e0 interfaceC0886e0, InterfaceC1231s0 interfaceC1231s0, String str) {
        this.a = context;
        this.b = protobufStateStorage;
        this.c = abstractC1255t0;
        this.d = interfaceC1401z2;
        this.e = interfaceC1209r2;
        this.f = interfaceC0813b2;
        this.g = y1;
        this.h = interfaceC0886e0;
        this.i = interfaceC1231s0;
    }

    private final synchronized CHOSEN c() {
        try {
            if (!this.g.a()) {
                CHOSEN chosenInvoke = this.f.invoke();
                this.g.b();
                if (chosenInvoke != null) {
                    b(chosenInvoke);
                }
            }
            C0963h2.a("Choosing distribution data: %s", this.i);
        } catch (Throwable th) {
            throw th;
        }
        return (CHOSEN) this.i.b();
    }

    public final synchronized STORAGE a() {
        return this.i;
    }

    public final synchronized boolean b(CHOSEN chosen) {
        boolean z = false;
        if (chosen.a() == EnumC1279u0.UNDEFINED) {
            return false;
        }
        List<? extends CANDIDATE> listInvoke = this.d.invoke(this.i.a(), chosen);
        boolean z2 = listInvoke != null;
        if (listInvoke == null) {
            listInvoke = this.i.a();
        }
        if (this.c.a(chosen, this.i.b())) {
            z = true;
        } else {
            chosen = (CHOSEN) this.i.b();
        }
        if (z || z2) {
            STORAGE storageInvoke = this.e.invoke(chosen, listInvoke);
            this.i = storageInvoke;
            this.b.save(storageInvoke);
        }
        return z;
    }

    public final CHOSEN a(CHOSEN chosen) {
        CHOSEN chosen2;
        this.h.a(this.a);
        synchronized (this) {
            b(chosen);
            chosen2 = (CHOSEN) c();
        }
        return chosen2;
    }

    public final CHOSEN b() {
        this.h.a(this.a);
        return (CHOSEN) c();
    }
}
