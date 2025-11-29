package bz;

import java.io.Serializable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* loaded from: classes.dex */
public final class V0 extends AbstractC0538n1 {
    public V0() {
        super(zone.bi.mobile.fingerprint.api.f.LocalIPv4);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws SocketException, C0564w1 {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if ((inetAddressNextElement instanceof Inet4Address) && !inetAddressNextElement.isLoopbackAddress()) {
                        String hostAddress = inetAddressNextElement.getHostAddress();
                        return hostAddress == null ? "" : hostAddress;
                    }
                }
            }
            throw new C0564w1("Uncaught exception");
        } catch (SocketException e) {
            throw new C0564w1(e.getMessage(), e);
        }
    }
}
