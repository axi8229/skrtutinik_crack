package bz;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.Serializable;

/* renamed from: bz.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0517h extends AbstractC0538n1 {
    public final ConnectivityManager c;

    public C0517h(ConnectivityManager connectivityManager) {
        super(zone.bi.mobile.fingerprint.api.f.AgentConnectionType);
        this.c = connectivityManager;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws e2 {
        ConnectivityManager connectivityManager = this.c;
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "Not connected";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() != 0) {
            throw new e2("info.getType() != ConnectivityManager.TYPE_MOBILE");
        }
        int subtype = activeNetworkInfo.getSubtype();
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
            case 18:
            case 19:
                return "4G";
            case 16:
            default:
                throw new e2("no case for networkType: " + subtype);
        }
    }
}
