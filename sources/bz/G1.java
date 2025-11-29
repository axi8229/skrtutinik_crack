package bz;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class G1 extends AbstractC0538n1 {
    public final Context c;

    public G1(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.VpnConnection);
        this.c = context;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.c.getSystemService("connectivity");
        boolean z = false;
        if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null && networkCapabilities.hasTransport(4)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
