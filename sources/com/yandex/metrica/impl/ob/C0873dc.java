package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.LocationListener;
import android.os.Looper;
import com.yandex.metrica.core.api.executors.IHandlerExecutor;

/* renamed from: com.yandex.metrica.impl.ob.dc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0873dc extends Dc<C0848cc> {
    private final com.yandex.metrica.gpllibrary.b f;

    public C0873dc(Context context, Pc pc, IHandlerExecutor iHandlerExecutor, C1388yd c1388yd) {
        this(context, pc, iHandlerExecutor, c1388yd, new G1());
    }

    @Override // com.yandex.metrica.impl.ob.Dc
    public boolean a(C0848cc c0848cc) {
        C0848cc c0848cc2 = c0848cc;
        if (c0848cc2.b != null && this.b.a(this.a)) {
            try {
                this.f.startLocationUpdates(c0848cc2.b.a);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.yandex.metrica.impl.ob.Dc
    public void b() {
        if (this.b.a(this.a)) {
            try {
                this.f.updateLastKnownLocation();
            } catch (Throwable unused) {
            }
        }
    }

    private C0873dc(Context context, Pc pc, IHandlerExecutor iHandlerExecutor, C1388yd c1388yd, G1 g1) {
        this(context, iHandlerExecutor, new C1411zc(pc), g1.a(c1388yd));
    }

    @Override // com.yandex.metrica.impl.ob.Dc
    public void a() {
        try {
            this.f.stopLocationUpdates();
        } catch (Throwable unused) {
        }
    }

    private static com.yandex.metrica.gpllibrary.b a(Context context, LocationListener locationListener, IHandlerExecutor iHandlerExecutor) {
        if (C0963h2.a("com.google.android.gms.location.LocationRequest")) {
            try {
                return new com.yandex.metrica.gpllibrary.a(context, locationListener, iHandlerExecutor.getLooper(), iHandlerExecutor, Dc.e);
            } catch (Throwable unused) {
            }
        }
        return new Tb();
    }

    C0873dc(Context context, IHandlerExecutor iHandlerExecutor, LocationListener locationListener, InterfaceC1412zd interfaceC1412zd) {
        this(context, iHandlerExecutor.getLooper(), locationListener, interfaceC1412zd, a(context, locationListener, iHandlerExecutor));
    }

    C0873dc(Context context, Looper looper, LocationListener locationListener, InterfaceC1412zd interfaceC1412zd, com.yandex.metrica.gpllibrary.b bVar) {
        super(context, locationListener, interfaceC1412zd, looper);
        this.f = bVar;
    }
}
