package bz;

import android.content.Context;
import android.content.IntentFilter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class W0 extends AbstractC0538n1 implements U1, Z {
    public static final long g = TimeUnit.MINUTES.toMillis(15);
    public Date c;
    public final Context d;
    public C0497a0 e;
    public int f;

    public W0(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.PhoneCallDirection);
        this.f = 0;
        this.d = context;
    }

    @Override // bz.Z
    public final void a(Date date) {
        this.c = date;
        this.f = 1;
    }

    @Override // bz.Z
    public final void b(Date date) {
        this.c = date;
        this.f = 1;
    }

    @Override // bz.Z
    public final void c(Date date) {
        this.c = date;
        this.f = 1;
    }

    @Override // bz.Z
    public final void d(Date date) {
        this.c = date;
        this.f = 2;
    }

    @Override // bz.Z
    public final void e(Date date) {
        this.c = date;
        this.f = 1;
    }

    @Override // bz.Z
    public final void f(Date date) {
        this.c = date;
        this.f = 2;
    }

    @Override // bz.U1
    public final void g() {
        if (K0.a(this.d, "android.permission.READ_PHONE_STATE")) {
            if (this.e != null) {
                d();
            }
            C0497a0 c0497a0 = new C0497a0(this);
            this.e = c0497a0;
            Context context = this.d;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PHONE_STATE");
            context.registerReceiver(c0497a0, intentFilter);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
    @Override // bz.AbstractC0538n1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable h() {
        /*
            r6 = this;
            android.content.Context r0 = r6.d
            java.lang.String r1 = "audio"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.media.AudioManager r0 = (android.media.AudioManager) r0
            r1 = 0
            if (r0 == 0) goto L30
            int r0 = r0.getMode()
            if (r0 == 0) goto L30
            r2 = 1
            if (r0 == r2) goto L31
            r3 = 2
            if (r0 == r3) goto L20
            r3 = 3
            if (r0 == r3) goto L20
            r3 = 4
            if (r0 == r3) goto L20
            goto L30
        L20:
            android.content.Context r0 = r6.d
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            boolean r0 = bz.K0.a(r0, r3)
            if (r0 == 0) goto L31
            int r0 = r6.f
            if (r0 == 0) goto L31
            r2 = r0
            goto L31
        L30:
            r2 = r1
        L31:
            if (r2 == 0) goto L3c
            java.util.Date r0 = new java.util.Date
            r0.<init>()
            r6.c = r0
            r1 = r2
            goto L52
        L3c:
            java.util.Date r0 = r6.c
            if (r0 == 0) goto L50
            long r2 = r0.getTime()
            long r4 = bz.W0.g
            long r2 = r2 + r4
            long r4 = java.lang.System.currentTimeMillis()
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L50
            goto L52
        L50:
            int r1 = r6.f
        L52:
            if (r1 == 0) goto L56
            r6.f = r1
        L56:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bz.W0.h():java.io.Serializable");
    }

    @Override // bz.U1
    public final void d() {
        C0497a0 c0497a0 = this.e;
        if (c0497a0 != null) {
            this.d.unregisterReceiver(c0497a0);
        }
        this.e = null;
    }
}
