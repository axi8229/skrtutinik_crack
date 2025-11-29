package com.group_ib.sdk;

import android.net.ConnectivityManager;
import android.net.Network;

/* loaded from: classes3.dex */
public final class P extends ConnectivityManager.NetworkCallback {
    public final S a;

    public P(S s) {
        this.a = s;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        S.a(this.a);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        S.a(this.a);
    }
}
