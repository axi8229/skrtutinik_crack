package androidx.core.net;

import android.net.ConnectivityManager;

/* loaded from: classes.dex */
public final class ConnectivityManagerCompat {
    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        return connectivityManager.isActiveNetworkMetered();
    }
}
