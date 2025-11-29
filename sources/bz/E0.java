package bz;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;

/* loaded from: classes.dex */
public abstract class E0 {
    public static AbstractC0538n1 a(zone.bi.mobile.fingerprint.api.f fVar, Context context, zone.bi.mobile.fingerprint.api.settings.a aVar, InterfaceC0544p1 interfaceC0544p1, C0573z1 c0573z1, zone.bi.mobile.fingerprint.api.b bVar) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        W1 w1 = new W1(context);
        if (F0.a == null) {
            synchronized (F0.class) {
                F0.a = new C0556u(new Y0());
            }
        }
        X0 x0 = new X0(context, F0.a);
        C0551s0 c0551s0 = new C0551s0(context);
        switch (D0.a[fVar.ordinal()]) {
            case 1:
                return new C0512f0(context);
            case 2:
                return new C0552s1(context);
            case 3:
                return new C0533m0(context, aVar);
            case 4:
                return new C0571z(context, AbstractC0570y1.a(1, context));
            case 5:
                return new C1(context, AbstractC0570y1.a(1, context), telephonyManager, aVar);
            case 6:
                return new C0541o1();
            case 7:
                return new C0503c0(context, telephonyManager);
            case 8:
                return new C0540o0(context, telephonyManager);
            case 9:
                return new C0513f1(context, telephonyManager);
            case 10:
                return new C0528k1();
            case 11:
                return new O(context, defaultAdapter);
            case 12:
                return new M1();
            case 13:
                return new C();
            case 14:
                return new G0();
            case 15:
                return new K1(context, telephonyManager);
            case 16:
                return new C0510e1(context, telephonyManager);
            case 17:
                return new A(context);
            case 18:
                return new V1(context, telephonyManager);
            case 19:
                return new X1(context, telephonyManager);
            case 20:
                return new P0(AbstractC0570y1.a(2, context));
            case 21:
                return new H();
            case 22:
                return new V(context, x0, c0551s0, interfaceC0544p1, c0573z1);
            case 23:
                return new b2();
            case 24:
                return new C0499b(context, AbstractC0570y1.a(2, context));
            case 25:
                return new C0522i1(context, AbstractC0570y1.a(2, context));
            case 26:
                return new C0526k(context, AbstractC0570y1.a(2, context));
            case 27:
                return new C0537n0(context);
            case 28:
                Z0 z0A = AbstractC0570y1.a(2, context);
                return new d2(context, AbstractC0570y1.a(1, context), bVar, locationManager, new O1(context, z0A, locationManager, bVar), new J0(context, z0A, locationManager, bVar), new M(context, z0A, locationManager, bVar), new C0565x(context, z0A, locationManager, bVar), new C0529l(context, z0A, locationManager, bVar), new C0518h0(context, z0A, locationManager, bVar), new C0554t0(context, z0A, locationManager, bVar), new J(context, locationManager), new W(context, z0A, locationManager, bVar));
            case 29:
                return new c2(context);
            case 30:
                return new C0532m();
            case 31:
                return new C0539o();
            case 32:
                return new C0516g1();
            case 33:
                return new L0();
            case 34:
                return new X();
            case 35:
                return new C0542p(context, aVar);
            case 36:
                return new N0(context, AbstractC0570y1.a(1, context), aVar);
            case 37:
                return new C0521i0(AbstractC0570y1.a(1, context));
            case 38:
                return new C0506d0(AbstractC0570y1.a(1, context));
            case 39:
                return new f2(context);
            case 40:
                return new C0504c1();
            case 41:
                return new C0524j0(AbstractC0570y1.a(1, context), telephonyManager);
            case 42:
                return new C0562w(context, AbstractC0570y1.a(1, context), telephonyManager);
            case 43:
                return new C0517h(connectivityManager);
            case 44:
                return new C0536n(AbstractC0570y1.a(1, context));
            case 45:
                return new V0();
            case 46:
                return new C0498a1();
            case 47:
                return new E1(connectivityManager);
            case 48:
                return new F1(context);
            case 49:
                return new C0561v1(new F1(context));
            case 50:
                return new C0535m1();
            case 51:
                return new C0511f(context, AbstractC0570y1.a(1, context), aVar);
            case 52:
                return new C0548r0(context);
            case 53:
                return new C0501b1(context);
            case 54:
                return new W0(context);
            case 55:
                return new F(context, AbstractC0570y1.a(1, context));
            case 56:
                return new C0559v(context);
            case 57:
                return new C0514g(context);
            case 58:
                return new Y(w1);
            case 59:
                return new K(w1);
            case 60:
                return new P(context);
            case 61:
                return new G1(context);
            case 62:
                return new I();
            case 63:
                return new C0530l0(context);
            default:
                throw new IllegalArgumentException("Not found provider for parameter type: " + fVar);
        }
    }
}
