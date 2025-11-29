package bz;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okio.Utf8;
import zone.bi.mobile.fingerprint.impl.cs.FpWorkerService;
import zone.bi.mobile.fingerprint.impl.ntl.Brg;

/* loaded from: classes.dex */
public final class V extends AbstractC0538n1 {
    public static final long k = TimeUnit.SECONDS.toMillis(3);
    public static final String[] l = {AbstractC0569y0.a(new byte[]{124, 55, 83, 113, -86, -20, 95, -52, 10, 87, 17, 0, 66, -82, -19, -43, -77, 52, 122, -98, -102, -39, 45, 68, -63, 53, -82, -71, 77, ByteSourceJsonBootstrapper.UTF8_BOM_1, 119, -108}), AbstractC0569y0.a(new byte[]{57, -115, -84, 23, 90, -103, 21, 120, -43, 26, -5, -121, 67, 4, 49, 80}), AbstractC0569y0.a(new byte[]{-125, 55, -37, -127, -75, -16, 35, 96, 49, -53, 22, 116, 127, 19, -103, 72}), AbstractC0569y0.a(new byte[]{-35, -37, 54, 14, 39, -79, 71, -88, -21, 89, -111, 60, -27, 112, -6, -90, 115, -39, -99, 54, -24, -49, 25, -78, -84, -52, 47, -79, 33, 55, -33, -9}), AbstractC0569y0.a(new byte[]{-77, -79, -117, -126, 8, 92, 100, -81, -93, -87, 116, 98, 3, 23, -128, 116}), AbstractC0569y0.a(new byte[]{79, 105, 123, 17, -67, -61, 71, 69, -12, 96, 11, Utf8.REPLACEMENT_BYTE, -66, 85, -108, 29, 62, -57, -123, -106, -104, -125, 119, 37, -41, 68, 12, -75, -27, -7, -110, 0}), AbstractC0569y0.a(new byte[]{89, 21, -48, -67, -125, 39, 112, -90, -34, 61, 90, -36, -15, 79, 76, -12, 5, 117, 44, -122, -6, 4, -96, 91, 49, 75, -15, -31, 82, 106, 123, 74}), AbstractC0569y0.a(new byte[]{-60, 19, -92, -79, -39, 110, 111, 97, 66, -5, -113, -20, -14, 15, 68, 81, 125, 53, -118, -99, 107, 101, -116, 30, -96, 97, -52, -98, 43, 69, 75, -41}), AbstractC0569y0.a(new byte[]{122, -117, -64, 57, 18, 48, -9, 112, 7, 77, -33, -16, ByteSourceJsonBootstrapper.UTF8_BOM_3, -124, 14, 24, 59, -71, -92, 68, -9, -119, -24, 10, 108, -14, 126, 126, -105, -127, 97, -7}), AbstractC0569y0.a(new byte[]{-114, -73, 0, -110, -123, -120, 56, -127, -45, 81, -95, -101, 51, 26, 92, 46, -59, -83, 75, -25, 24, 75, 15, 69, 47, -98, -7, 79, -79, -8, 39, 84}), AbstractC0569y0.a(new byte[]{82, 99, -12, -44, 82, 78, -119, -70, 114, -116, -25, 101, -122, 7, -60, 36}), AbstractC0569y0.a(new byte[]{-35, 62, -80, 102, 82, 17, -71, -90, 5, -109, 64, 13, -52, 59, 75, 62}), AbstractC0569y0.a(new byte[]{48, -41, -33, -30, 112, -77, 75, 66, 49, -82, 116, -21, -15, -10, 22, -31, -67, 15, 24, -119, -47, -124, 57, 40, 60, 30, -66, -39, 92, -39, 75, 7, 28, -23, -46, -8, 83, 13, 2, 19, 86, 44, 79, 9, 65, 94, 30, -124}), AbstractC0569y0.a(new byte[]{115, 39, -19, -90, 31, -63, -19, 42, -75, -33, -62, -26, -102, 86, 114, 121, -20, -66, -31, -50, 77, 43, 47, 57, -107, -70, 44, 36, 56, -59, 60, ByteSourceJsonBootstrapper.UTF8_BOM_1}), AbstractC0569y0.a(new byte[]{-100, 65, 12, -7, 89, 113, -12, 112, 23, 104, -36, -95, -119, -76, 71, -91}), AbstractC0569y0.a(new byte[]{-50, 99, -111, 40, 3, 61, -45, -105, -128, -16, 85, -92, 125, -73, -46, 67}), AbstractC0569y0.a(new byte[]{-22, -52, 77, -20, 71, 0, -78, -85, 53, 47, 12, 44, 107, 74, -60, 78})};
    public static final String m = AbstractC0569y0.a(new byte[]{-123, 98, -81, 6, 100, -23, 0, -76, -70, -103, -72, 75, 41, 122, -111, 80});
    public static final String p = AbstractC0569y0.a(new byte[]{-8, -57, -20, 106, 6, -15, -94, -12, -89, -5, -114, 98, 73, -24, -92, -85});
    public static final String[] q = {AbstractC0569y0.a(new byte[]{-121, -45, -35, 20, 65, 66, -79, -55, 104, -113, ByteSourceJsonBootstrapper.UTF8_BOM_3, -71, 113, -14, 29, 92}), AbstractC0569y0.a(new byte[]{-114, 59, -62, -121, -127, 3, -33, -124, 77, 48, -74, 94, 33, -86, -57, 7}), AbstractC0569y0.a(new byte[]{92, -94, 62, -2, -84, 83, -72, -44, -39, 31, 31, -126, 107, -124, -33, 96, 123, -112, 54, 45, 11, -35, 125, -86, 54, 49, -80, -113, -53, -107, -4, 120}), AbstractC0569y0.a(new byte[]{49, 86, -93, 9, -3, -113, -52, -52, -12, -99, -30, 74, -50, 69, -57, -22, 124, -67, 46, 13, -13, 57, 110, -78, 48, 9, -28, 28, -74, -116, -60, -37}), AbstractC0569y0.a(new byte[]{-83, -36, -105, -54, -91, -27, -38, 8, 65, -16, -80, 110, 21, -108, -9, -10}), AbstractC0569y0.a(new byte[]{102, -72, -3, -71, -18, 85, -9, 127, -35, 29, -89, -24, 1, 25, -104, -127}), AbstractC0569y0.a(new byte[]{-53, 123, -89, 11, -106, -78, 14, -95, -9, -106, -63, -77, 97, -24, -94, -10})};
    public static int r = -1;
    public final U0 c;
    public final Handler d;
    public final ConcurrentHashMap e;
    public final Context f;
    public final int g;
    public final C0551s0 h;
    public final InterfaceC0544p1 i;
    public final C0573z1 j;

    public V(Context context, X0 x0, C0551s0 c0551s0, InterfaceC0544p1 interfaceC0544p1, C0573z1 c0573z1) {
        super(zone.bi.mobile.fingerprint.api.f.Compromised);
        this.d = new Handler(Looper.getMainLooper());
        this.e = new ConcurrentHashMap(S.values().length);
        this.f = context;
        this.g = 1;
        this.c = x0;
        this.h = c0551s0;
        this.i = interfaceC0544p1;
        this.j = c0573z1;
    }

    public static EnumSet o() throws Exception {
        EnumSet enumSetNoneOf = EnumSet.noneOf(U.class);
        try {
            throw new Exception(AbstractC0569y0.a(new byte[]{-70, 26, 57, -96, 58, 3, 52, -117, -105, 13, -32, 107, 20, 42, 117, 49, -90, -10, -56, -115, 5, 126, 99, 126, -58, 48, -91, 41, 4, -50, 55, -81, 42, -37, -29, 35, -29, -14, 49, 59, -124, -23, -127, -40, 7, 88, 0, 99}));
        } catch (Exception e) {
            int i = 0;
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                String className = stackTraceElement.getClassName();
                String fileName = stackTraceElement.getFileName();
                for (U u : U.values()) {
                    if (U.a(u, className, fileName) && (!u.equals(U.TwiceZygoteInit) || (i = i + 1) > 1)) {
                        enumSetNoneOf.add(u);
                    }
                }
            }
            return enumSetNoneOf;
        }
    }

    public final void a(int i) {
        if (i == -1) {
            this.j.a(zone.bi.mobile.fingerprint.api.g.Critical, AbstractC0569y0.a(new byte[]{-74, -118, 96, -20, 13, 93, -39, 23, 10, 106, 75, 40, -25, -22, 104, 16, -121, 107, -23, -125, -94, -79, -41, -32, 58, 24, -90, -93, -101, -16, -21, 97}), 6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c7  */
    @Override // bz.AbstractC0538n1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable h() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bz.V.h():java.io.Serializable");
    }

    public final boolean l() {
        final zone.bi.mobile.fingerprint.impl.cs.b bVar;
        if (this.h.a(((X0) this.c).a(0))) {
            return true;
        }
        if (n()) {
            InterfaceC0544p1 interfaceC0544p1 = this.i;
            Context context = this.f;
            ((C0519h1) interfaceC0544p1).a();
            bVar = new zone.bi.mobile.fingerprint.impl.cs.b(context);
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return false;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final int[] iArr = {0};
        this.d.post(new Runnable() { // from class: bz.V$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                V.a(bVar, iArr, countDownLatch);
            }
        });
        try {
            if (!countDownLatch.await(k, TimeUnit.MILLISECONDS)) {
                this.j.a(zone.bi.mobile.fingerprint.api.g.Warning, AbstractC0569y0.a(new byte[]{67, 78, -77, -83, -114, 85, -109, -108, -73, 18, -25, -41, -50, -68, 119, 123, 120, -93, -92, 14, -98, -74, 5, 34, -87, 76, ByteSourceJsonBootstrapper.UTF8_BOM_2, -62, 45, 69, 80, -81, -12, -87, 102, 125, -117, 12, 89, 126, -50, 42, -13, -123, 115, 119, 79, -33, -47, 33, 114, 89, -96, 1, -102, -105, -81, 89, -28, -100, 69, 62, -120, -96}), 7);
            }
        } catch (InterruptedException unused) {
        }
        a(iArr[0]);
        return iArr[0] == 2;
    }

    public final boolean m() throws InterruptedException {
        if (!Looper.getMainLooper().isCurrentThread()) {
            S s = S.WorkerThread;
            if (((EnumSet) this.e.get(s)) == null) {
                this.e.put(s, o());
            }
        }
        final S s2 = S.MainThread;
        if (((EnumSet) this.e.get(s2)) == null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.d.post(new Runnable() { // from class: bz.V$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(s2, countDownLatch);
                }
            });
            try {
                countDownLatch.await(500L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
            }
        }
        Iterator it = this.e.values().iterator();
        while (it.hasNext()) {
            if (!((EnumSet) it.next()).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final boolean n() {
        boolean zA;
        boolean zA2 = ((C0519h1) this.i).a();
        if (zA2) {
            return zA2;
        }
        InterfaceC0544p1 interfaceC0544p1 = this.i;
        Context context = this.f;
        C0519h1 c0519h1 = (C0519h1) interfaceC0544p1;
        synchronized (c0519h1) {
            boolean zA3 = c0519h1.a();
            if (zA3) {
                zA = zA3;
            } else {
                c0519h1.a.getClass();
                Brg brg = new Brg();
                zA = brg.a(context);
                if (zA) {
                    c0519h1.b = brg;
                }
            }
        }
        if (!zA) {
            this.j.a(zone.bi.mobile.fingerprint.api.g.Critical, AbstractC0569y0.a(new byte[]{66, -122, 126, 45, -82, 76, 85, 57, -44, 72, ByteSourceJsonBootstrapper.UTF8_BOM_1, 47, 28, -71, 115, -2, 95, -81, -125, -1, -87, -1, 104, -30, -66, 127, Utf8.REPLACEMENT_BYTE, -27, -2, -78, -73, -43, 27, 16, -26, 10, Utf8.REPLACEMENT_BYTE, 46, 43, -87, -7, -51, 106, -85, 76, -98, 25, 103}), 5);
        }
        return zA;
    }

    public final /* synthetic */ void a(S s, CountDownLatch countDownLatch) {
        this.e.put(s, o());
        countDownLatch.countDown();
    }

    public static void a(final zone.bi.mobile.fingerprint.impl.cs.g gVar, final int[] iArr, final CountDownLatch countDownLatch) {
        int iA;
        zone.bi.mobile.fingerprint.impl.cs.f fVar = new zone.bi.mobile.fingerprint.impl.cs.f() { // from class: bz.V$$ExternalSyntheticLambda4
            @Override // zone.bi.mobile.fingerprint.impl.cs.f
            public final void a(int i) {
                V.a(iArr, gVar, countDownLatch, i);
            }
        };
        zone.bi.mobile.fingerprint.impl.cs.b bVar = (zone.bi.mobile.fingerprint.impl.cs.b) gVar;
        bVar.b = fVar;
        if (!bVar.d) {
            bVar.a.bindService(new Intent(bVar.a, (Class<?>) FpWorkerService.class), bVar.e, 1);
            return;
        }
        zone.bi.mobile.fingerprint.impl.cs.e eVar = bVar.c;
        if (eVar != null) {
            try {
                iA = eVar.a();
            } catch (RemoteException unused) {
                iA = -1;
            }
            bVar.b.a(iA);
        }
    }

    public static void a(int[] iArr, zone.bi.mobile.fingerprint.impl.cs.g gVar, CountDownLatch countDownLatch, int i) {
        iArr[0] = i;
        zone.bi.mobile.fingerprint.impl.cs.b bVar = (zone.bi.mobile.fingerprint.impl.cs.b) gVar;
        bVar.b = null;
        bVar.c = null;
        if (bVar.d) {
            bVar.a.unbindService(bVar.e);
            bVar.d = false;
        }
        countDownLatch.countDown();
    }
}
