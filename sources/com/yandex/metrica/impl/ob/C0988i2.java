package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.ResultReceiver;
import com.yandex.metrica.CounterConfiguration;

/* renamed from: com.yandex.metrica.impl.ob.i2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0988i2 {
    private final String a;
    private final Context b;
    private final CounterConfiguration.b c;
    private final C1037k2 d;

    public C0988i2(String str, Context context, CounterConfiguration.b bVar, C1037k2 c1037k2) {
        this.a = str;
        this.b = context;
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0) {
            this.c = CounterConfiguration.b.SELF_DIAGNOSTIC_MAIN;
        } else if (iOrdinal != 1) {
            this.c = null;
        } else {
            this.c = CounterConfiguration.b.SELF_DIAGNOSTIC_MANUAL;
        }
        this.d = c1037k2;
    }

    public void a(C0836c0 c0836c0) {
        if (this.c != null) {
            try {
                String str = this.a;
                CounterConfiguration counterConfiguration = new CounterConfiguration();
                synchronized (counterConfiguration) {
                    counterConfiguration.b(str);
                }
                counterConfiguration.a(this.c);
                this.d.a(c0836c0.b(new Q1(new A3(this.b, (ResultReceiver) null), counterConfiguration, null).c()));
            } catch (Throwable unused) {
            }
        }
    }
}
