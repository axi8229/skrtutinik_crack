package bz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import java.util.Date;

/* renamed from: bz.a0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0497a0 extends BroadcastReceiver {
    public final Z a;
    public int b = 0;
    public Date c;
    public boolean d;

    public C0497a0(Z z) {
        this.a = z;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PHONE_STATE")) {
            String string = intent.getExtras().getString("state");
            int i = string.equals(TelephonyManager.EXTRA_STATE_OFFHOOK) ? 2 : string.equals(TelephonyManager.EXTRA_STATE_RINGING) ? 1 : 0;
            if (this.b != i) {
                Date date = new Date();
                if (i == 1) {
                    this.d = true;
                    this.c = date;
                    this.a.b(date);
                } else if (i == 2) {
                    this.c = date;
                    if (this.b != 1) {
                        this.d = false;
                        this.a.d(date);
                    } else {
                        this.d = true;
                        this.a.c(date);
                    }
                } else if (this.b == 1) {
                    this.a.a(this.c);
                } else if (this.d) {
                    this.a.e(date);
                } else {
                    this.a.f(date);
                }
                this.b = i;
            }
        }
    }
}
