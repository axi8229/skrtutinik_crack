package bz;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.io.Serializable;

/* renamed from: bz.f1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0513f1 extends AbstractC0538n1 {
    public final Context c;
    public final TelephonyManager d;

    public C0513f1(Context context, TelephonyManager telephonyManager) {
        super(zone.bi.mobile.fingerprint.api.f.PhoneNumber);
        this.c = context;
        this.d = telephonyManager;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws C0564w1 {
        if (this.d == null) {
            throw new C0564w1("tel == null");
        }
        if (!K0.a(this.c, "android.permission.READ_PHONE_STATE") || (Build.VERSION.SDK_INT >= 26 && !K0.a(this.c, "android.permission.READ_PHONE_NUMBERS"))) {
            throw new C0564w1("permission not granted");
        }
        String line1Number = this.d.getLine1Number();
        if (line1Number != null) {
            return line1Number;
        }
        throw new C0564w1("phoneNumber == null");
    }
}
