package bz;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes.dex */
public final class E1 extends AbstractC0538n1 {
    public static final String[] d = {AbstractC0569y0.a(new byte[]{80, -70, -94, -54, 99, 105, 32, -26, -84, -46, 54, -59, 48, 23, -57, 126}), AbstractC0569y0.a(new byte[]{94, 30, -99, 53, 86, 88, 5, 53, -40, 91, -61, -42, -74, -48, 58, 105}), AbstractC0569y0.a(new byte[]{76, -77, -14, 91, -3, -72, -123, 17, -12, 0, -114, -39, 104, 84, 100, 114}), AbstractC0569y0.a(new byte[]{-95, -122, -18, -20, 60, 57, 43, -100, -34, 30, -78, -84, -76, -79, 98, 64})};
    public final ConnectivityManager c;

    public E1(ConnectivityManager connectivityManager) {
        super(zone.bi.mobile.fingerprint.api.f.DnsIP);
        this.c = connectivityManager;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, C0564w1, InvalidAlgorithmParameterException {
        AbstractC0569y0.a(new byte[]{-3, 82, 117, -79, -115, 98, 9, 11, -72, -1, 49, -90, -44, -20, 96, -81});
        try {
            String strL = l();
            if (!strL.isEmpty()) {
                strL = strL.substring(0, strL.length() - 1);
            }
            return strL.replaceAll(AbstractC0569y0.a(new byte[]{81, 47, 80, -15, -20, -7, -46, 1, 95, 110, -21, -125, -37, 4, 26, 37}), AbstractC0569y0.a(new byte[]{-3, 82, 117, -79, -115, 98, 9, 11, -72, -1, 49, -90, -44, -20, 96, -81}));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | NullPointerException | InvocationTargetException e) {
            throw new C0564w1(e.getMessage(), e);
        }
    }

    public final String l() throws C0564w1 {
        LinkProperties linkProperties;
        if (this.c == null) {
            throw new C0564w1(AbstractC0569y0.a(new byte[]{-24, 83, 111, 39, 127, 23, 45, -121, 11, 93, -54, 118, 109, -7, -76, 28, 41, -55, -56, 17, 2, -108, -71, 74, 36, 43, 101, 18, -118, -14, 116, 69}));
        }
        StringBuilder sb = new StringBuilder();
        for (Network network : this.c.getAllNetworks()) {
            NetworkInfo networkInfo = this.c.getNetworkInfo(network);
            if (networkInfo != null && networkInfo.isConnected() && (linkProperties = this.c.getLinkProperties(network)) != null) {
                Iterator<InetAddress> it = linkProperties.getDnsServers().iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(AbstractC0569y0.a(new byte[]{-80, 100, 120, -77, 101, 33, 34, 65, -101, 11, 89, 121, -73, -4, 19, -14}));
                }
            }
        }
        return sb.toString();
    }
}
