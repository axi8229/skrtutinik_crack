package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.google.protobuf.nano.ym.MessageNano;

/* loaded from: classes3.dex */
public class Q5 {
    private final O5 a;
    private final P5 b;
    private final R7 c;

    public Q5(Context context, I3 i3) {
        this(new P5(), new O5(), C1020ja.a(context).a(i3), "event_hashes");
    }

    public N5 a() {
        try {
            byte[] bArrA = this.c.a("event_hashes");
            if (A2.a(bArrA)) {
                O5 o5 = this.a;
                this.b.getClass();
                return o5.toModel(new Af());
            }
            O5 o52 = this.a;
            this.b.getClass();
            return o52.toModel((Af) MessageNano.mergeFrom(new Af(), bArrA));
        } catch (Throwable unused) {
            O5 o53 = this.a;
            this.b.getClass();
            return o53.toModel(new Af());
        }
    }

    Q5(P5 p5, O5 o5, R7 r7, String str) {
        this.b = p5;
        this.a = o5;
        this.c = r7;
    }

    public void a(N5 n5) {
        R7 r7 = this.c;
        P5 p5 = this.b;
        Af afFromModel = this.a.fromModel(n5);
        p5.getClass();
        r7.a("event_hashes", MessageNano.toByteArray(afFromModel));
    }
}
