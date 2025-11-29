package com.group_ib.sdk;

import android.telephony.PhoneStateListener;

/* renamed from: com.group_ib.sdk.p0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0616p0 extends PhoneStateListener {
    public final C0617q0 a;
    public boolean b = false;
    public boolean c = false;

    public C0616p0(C0617q0 c0617q0) {
        this.a = c0617q0;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallForwardingIndicatorChanged(boolean z) {
        boolean z2 = this.b;
        if (!z2 || this.c != z) {
            if (!z2) {
                this.b = true;
            }
            this.c = z;
            b1 b1Var = new b1();
            b1Var.put("CallForwarding", Boolean.valueOf(z));
            this.a.a.a(b1Var, false);
            c1.a(4, 4, "UssdProvider", "onCallForwardingIndicatorChanged CFI=" + z);
        }
        super.onCallForwardingIndicatorChanged(z);
    }
}
