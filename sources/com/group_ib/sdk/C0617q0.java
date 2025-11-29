package com.group_ib.sdk;

import android.telephony.TelephonyManager;

/* renamed from: com.group_ib.sdk.q0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0617q0 implements d1 {
    public final MobileSdkService a;
    public C0616p0 b = null;

    public C0617q0(MobileSdkService mobileSdkService) {
        this.a = mobileSdkService;
    }

    @Override // com.group_ib.sdk.d1
    public final void a() {
    }

    @Override // com.group_ib.sdk.d1
    public final void a(int i) {
    }

    @Override // com.group_ib.sdk.d1
    public final void run() {
        if (!AbstractC0604j0.a(this.a, "android.permission.READ_PHONE_STATE")) {
            c1.a(4, 4, "UssdProvider", "READ_PHONE_STATE permission NOT granted");
            return;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
            if (this.b == null) {
                this.b = new C0616p0(this);
            }
            telephonyManager.listen(this.b, 8);
        } catch (Exception e) {
            c1.b("UssdProvider", "failed to send ussd command", e);
        }
    }
}
