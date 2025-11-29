package com.group_ib.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes3.dex */
public final class Z extends BroadcastReceiver {
    public final HandlerC0586a0 a;

    public Z(HandlerC0586a0 handlerC0586a0) {
        this.a = handlerC0586a0;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (!"android.intent.action.SIM_STATE_CHANGED".equals(intent.getAction()) || (extras = intent.getExtras()) == null || !"LOADED".equals(extras.getString("ss")) || isInitialStickyBroadcast()) {
            return;
        }
        this.a.sendEmptyMessage(1024);
    }
}
