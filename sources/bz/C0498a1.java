package bz;

import java.io.Serializable;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* renamed from: bz.a1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0498a1 extends AbstractC0538n1 {
    public C0498a1() {
        super(zone.bi.mobile.fingerprint.api.f.LocalIPv6);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws SocketException, C0564w1 {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if ((inetAddressNextElement instanceof Inet6Address) && !inetAddressNextElement.isLoopbackAddress()) {
                        String hostAddress = inetAddressNextElement.getHostAddress();
                        if (hostAddress != null) {
                            try {
                                if (!hostAddress.isEmpty() && hostAddress.contains("%")) {
                                    return hostAddress.substring(0, hostAddress.indexOf(37));
                                }
                            } catch (Error unused) {
                                return hostAddress;
                            }
                        }
                        return "";
                    }
                }
            }
            throw new C0564w1("Uncaught exception");
        } catch (SocketException e) {
            throw new C0564w1(e.getMessage(), e);
        }
    }
}
