package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.database.Cursor;
import com.yandex.metrica.impl.ob.C1126ng;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* renamed from: com.yandex.metrica.impl.ob.gg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0952gg {
    private final Context a;
    private Cursor b;

    public C0952gg(Context context) {
        this.a = context;
    }

    public void a(InterfaceC1319vg interfaceC1319vg) {
        try {
            try {
                FutureTask futureTask = new FutureTask(new CallableC0927fg(this));
                F0.g().q().a(futureTask).start();
                C0877dg c0877dg = (C0877dg) futureTask.get(5L, TimeUnit.SECONDS);
                A2.a(this.b);
                ((C1126ng.a) interfaceC1319vg).a(c0877dg);
            } catch (Throwable unused) {
                C1101mg c1101mg = C1101mg.this;
                C1101mg.a(c1101mg, null, C1101mg.c(c1101mg));
            }
        } finally {
            A2.a(this.b);
        }
    }
}
