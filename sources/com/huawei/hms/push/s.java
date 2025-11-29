package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;
import java.net.URISyntaxException;

/* compiled from: SelfShowType.java */
/* loaded from: classes3.dex */
public class s {
    private static final String[] c = {"url", "app", "cosa", "rp"};
    private Context a;
    private m b;

    public s(Context context, m mVar) {
        this.a = context;
        this.b = mVar;
    }

    public static boolean a(String str) {
        for (String str2 : c) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void b() throws URISyntaxException {
        Intent uri;
        HMSLog.i("PushSelfShowLog", "run into launchCosaApp");
        try {
            HMSLog.i("PushSelfShowLog", "enter launchExistApp cosa, appPackageName =" + this.b.d() + ",and msg.intentUri is " + this.b.n());
            Intent intentB = d.b(this.a, this.b.d());
            boolean zBooleanValue = false;
            if (this.b.n() != null) {
                try {
                    uri = Intent.parseUri(this.b.n(), 0);
                    uri.setSelector(null);
                    HMSLog.i("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + uri.getAction());
                    zBooleanValue = d.a(this.a, this.b.d(), uri).booleanValue();
                    if (zBooleanValue) {
                        intentB = uri;
                    }
                } catch (Exception e) {
                    HMSLog.w("PushSelfShowLog", "intentUri error." + e.toString());
                }
            } else if (this.b.a() != null) {
                uri = new Intent(this.b.a());
                if (d.a(this.a, this.b.d(), uri).booleanValue()) {
                    intentB = uri;
                }
            }
            if (intentB == null) {
                HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");
                return;
            }
            intentB.setPackage(this.b.d());
            if (zBooleanValue) {
                intentB.addFlags(268435456);
            } else {
                intentB.setFlags(805437440);
            }
            this.a.startActivity(intentB);
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "launch Cosa App exception." + e2.toString());
        }
    }

    public void c() throws URISyntaxException {
        m mVar;
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.a == null || (mVar = this.b) == null) {
            HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
            return;
        }
        if ("app".equals(mVar.i())) {
            a();
            return;
        }
        if ("cosa".equals(this.b.i())) {
            b();
            return;
        }
        if ("rp".equals(this.b.i())) {
            HMSLog.w("PushSelfShowLog", this.b.i() + " not support rich message.");
            return;
        }
        if ("url".equals(this.b.i())) {
            HMSLog.w("PushSelfShowLog", this.b.i() + " not support URL.");
            return;
        }
        HMSLog.d("PushSelfShowLog", this.b.i() + " is not exist in hShowType");
    }

    private void a() {
        try {
            HMSLog.i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.b.d());
            if (d.c(this.a, this.b.d())) {
                b();
            }
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", "launchApp error:" + e.toString());
        }
    }
}
