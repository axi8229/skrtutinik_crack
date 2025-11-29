package bz;

import android.content.Context;
import android.content.IntentFilter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* renamed from: bz.b1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0501b1 extends AbstractC0538n1 implements U1, Z {
    public static final long g = TimeUnit.MINUTES.toMillis(15);
    public final Context c;
    public Date d;
    public int e;
    public C0497a0 f;

    public C0501b1(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.PhoneCallState);
        this.c = context;
    }

    @Override // bz.Z
    public final void a(Date date) {
        this.e = 0;
        this.d = date;
    }

    @Override // bz.Z
    public final void b(Date date) {
        this.e = 1;
        this.d = date;
    }

    @Override // bz.Z
    public final void c(Date date) {
        this.e = 2;
        this.d = date;
    }

    @Override // bz.Z
    public final void d(Date date) {
        this.e = 2;
        this.d = date;
    }

    @Override // bz.Z
    public final void e(Date date) {
        this.e = 0;
        this.d = date;
    }

    @Override // bz.Z
    public final void f(Date date) {
        this.e = 0;
        this.d = date;
    }

    @Override // bz.U1
    public final void g() {
        if (K0.a(this.c, "android.permission.READ_PHONE_STATE")) {
            if (this.f != null) {
                d();
            }
            C0497a0 c0497a0 = new C0497a0(this);
            this.f = c0497a0;
            Context context = this.c;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PHONE_STATE");
            context.registerReceiver(c0497a0, intentFilter);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    @Override // bz.AbstractC0538n1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable h() {
        /*
            r9 = this;
            android.content.Context r0 = r9.c
            java.lang.String r1 = "audio"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.media.AudioManager r0 = (android.media.AudioManager) r0
            r1 = 3
            r2 = 0
            if (r0 == 0) goto L1f
            int r0 = r0.getMode()
            if (r0 == 0) goto L1f
            r3 = 1
            if (r0 == r3) goto L20
            r3 = 2
            if (r0 == r3) goto L20
            if (r0 == r1) goto L20
            r4 = 4
            if (r0 == r4) goto L20
        L1f:
            r3 = r2
        L20:
            if (r3 == 0) goto L2b
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            r9.d = r0
            r2 = r3
            goto L68
        L2b:
            int r0 = r9.e
            if (r0 != 0) goto L45
            java.util.Date r0 = r9.d
            if (r0 == 0) goto L45
            long r3 = java.lang.System.currentTimeMillis()
            java.util.Date r0 = r9.d
            long r5 = r0.getTime()
            long r7 = bz.C0501b1.g
            long r5 = r5 + r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L45
            goto L64
        L45:
            android.content.Context r0 = r9.c
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            boolean r0 = bz.K0.a(r0, r3)
            if (r0 != 0) goto L66
            java.util.Date r0 = r9.d
            if (r0 == 0) goto L68
            long r3 = java.lang.System.currentTimeMillis()
            java.util.Date r0 = r9.d
            long r5 = r0.getTime()
            long r7 = bz.C0501b1.g
            long r5 = r5 + r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L68
        L64:
            r2 = r1
            goto L68
        L66:
            int r2 = r9.e
        L68:
            if (r2 == r1) goto L6c
            r9.e = r2
        L6c:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bz.C0501b1.h():java.io.Serializable");
    }

    @Override // bz.U1
    public final void d() {
        C0497a0 c0497a0 = this.f;
        if (c0497a0 != null) {
            this.c.unregisterReceiver(c0497a0);
        }
        this.f = null;
    }
}
