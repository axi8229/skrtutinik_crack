package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.log.HMSLog;
import java.net.URISyntaxException;

/* compiled from: PushSelfShowThread.java */
/* loaded from: classes3.dex */
public class n extends Thread {
    private Context a;
    private m b;

    public n(Context context, m mVar) {
        this.a = context;
        this.b = mVar;
    }

    private static Intent a(Context context, m mVar) throws URISyntaxException {
        if (mVar == null) {
            return null;
        }
        Intent intentB = d.b(context, mVar.d());
        if (mVar.n() == null) {
            if (mVar.a() != null) {
                Intent intent = new Intent(mVar.a());
                if (d.a(context, mVar.d(), intent).booleanValue()) {
                    intentB = intent;
                }
            }
            intentB.setPackage(mVar.d());
            return intentB;
        }
        try {
            Intent uri = Intent.parseUri(mVar.n(), 0);
            uri.setSelector(null);
            HMSLog.d("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + uri.getAction());
            return d.a(context, mVar.d(), uri).booleanValue() ? uri : intentB;
        } catch (Exception e) {
            HMSLog.w("PushSelfShowLog", "intentUri error," + e.toString());
            return intentB;
        }
    }

    private boolean b(Context context) {
        if ("cosa".equals(this.b.i())) {
            return a(context);
        }
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HMSLog.i("PushSelfShowLog", "enter run()");
        try {
            if (!b(this.a) || b(this.a, this.b)) {
                return;
            }
            l.a(this.a, this.b);
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", e.toString());
        }
    }

    private boolean b(Context context, m mVar) {
        if (!"cosa".equals(mVar.i()) || a(context, mVar) != null) {
            return false;
        }
        HMSLog.d("PushSelfShowLog", "launchCosaApp,intent == null");
        return true;
    }

    private boolean a(Context context) {
        return d.c(context, this.b.d());
    }
}
