package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.LocationListener;
import android.os.Looper;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class Dc<T> {
    static final long e = TimeUnit.SECONDS.toMillis(1);
    protected final Context a;
    protected final InterfaceC1412zd b;
    protected final LocationListener c;
    protected final Looper d;

    public Dc(Context context, LocationListener locationListener, InterfaceC1412zd interfaceC1412zd, Looper looper) {
        this.a = context;
        this.c = locationListener;
        this.b = interfaceC1412zd;
        this.d = looper;
    }

    public abstract void a();

    public abstract boolean a(T t);

    public abstract void b();
}
