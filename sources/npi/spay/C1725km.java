package npi.spay;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.km, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1725km {
    public final Context a;
    public final T3 b;

    public C1725km(Context context, T3 settings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.a = context;
        this.b = settings;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a() {
        /*
            r12 = this;
            android.content.Context r0 = r12.a
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r0 = npi.spay.AbstractC1952u0.a(r0, r1)
            java.lang.String r1 = ""
            if (r0 != 0) goto Ld
            return r1
        Ld:
            android.content.Context r0 = r12.a
            java.lang.String r2 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            if (r0 == 0) goto L67
            android.net.Network[] r2 = r0.getAllNetworks()
            java.lang.String r3 = "cm.allNetworks"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            int r3 = r2.length
            r4 = 0
            java.lang.String r5 = "CELLULAR"
            java.lang.String r6 = "WIFI"
            r7 = 1
            if (r3 != 0) goto L2c
            goto L52
        L2c:
            int r3 = r2.length
            r8 = 0
            r9 = r8
        L2f:
            if (r9 >= r3) goto L52
            r10 = r2[r9]
            android.net.NetworkCapabilities r10 = r0.getNetworkCapabilities(r10)
            if (r10 != 0) goto L3a
            goto L4a
        L3a:
            boolean r11 = r10.hasTransport(r7)
            if (r11 == 0) goto L42
            r10 = r6
            goto L4b
        L42:
            boolean r10 = r10.hasTransport(r8)
            if (r10 == 0) goto L4a
            r10 = r5
            goto L4b
        L4a:
            r10 = r4
        L4b:
            if (r10 == 0) goto L4f
            r4 = r10
            goto L52
        L4f:
            int r9 = r9 + 1
            goto L2f
        L52:
            if (r4 == 0) goto L55
            return r4
        L55:
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            if (r0 == 0) goto L67
            int r0 = r0.getType()
            if (r0 == 0) goto L66
            if (r0 == r7) goto L64
            goto L67
        L64:
            r1 = r6
            goto L67
        L66:
            r1 = r5
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1725km.a():java.lang.String");
    }
}
