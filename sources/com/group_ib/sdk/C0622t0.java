package com.group_ib.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.HashMap;

/* renamed from: com.group_ib.sdk.t0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0622t0 extends BroadcastReceiver {
    public HandlerC0626v0 a;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        String action = intent.getAction();
        if (data == null || action == null) {
            return;
        }
        if (action.equals("android.intent.action.PACKAGE_ADDED")) {
            HandlerC0626v0.a(this.a, data.getEncodedSchemeSpecificPart());
            return;
        }
        if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
            HandlerC0626v0 handlerC0626v0 = this.a;
            String encodedSchemeSpecificPart = data.getEncodedSchemeSpecificPart();
            synchronized (handlerC0626v0) {
                if (encodedSchemeSpecificPart != null) {
                    try {
                        if (handlerC0626v0.d != null && handlerC0626v0.b != null) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            handlerC0626v0.d.b(jCurrentTimeMillis, encodedSchemeSpecificPart);
                            C0630x0 c0630x0 = handlerC0626v0.b;
                            if (c0630x0.d == null) {
                                c0630x0.d = new HashMap();
                            }
                            c0630x0.d.put(encodedSchemeSpecificPart, Long.valueOf(jCurrentTimeMillis));
                            handlerC0626v0.sendEmptyMessage(4096);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }
}
