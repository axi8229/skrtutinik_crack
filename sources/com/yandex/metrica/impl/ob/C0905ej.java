package com.yandex.metrica.impl.ob;

import android.content.Context;

/* renamed from: com.yandex.metrica.impl.ob.ej, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0905ej {
    private static volatile C0905ej b;
    private final C1253sm a;

    C0905ej(C1253sm c1253sm) {
        this.a = c1253sm;
    }

    public static C0905ej a(Context context) {
        if (b == null) {
            synchronized (C0905ej.class) {
                try {
                    if (b == null) {
                        b = new C0905ej(new C1253sm(context, "uuid.dat"));
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public C0880dj b(Context context, InterfaceC0830bj interfaceC0830bj) {
        return new C0880dj(interfaceC0830bj, new C0805aj(), this.a, new C0930fj(context, new B0(), new C1032jm()));
    }

    public C0880dj a(Context context, InterfaceC0830bj interfaceC0830bj) {
        return new C0880dj(interfaceC0830bj, new C0955gj(context, new B0()), this.a, new C0930fj(context, new B0(), new C1032jm()));
    }
}
