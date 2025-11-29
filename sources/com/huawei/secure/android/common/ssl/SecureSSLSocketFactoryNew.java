package com.huawei.secure.android.common.ssl;

import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes3.dex */
public class SecureSSLSocketFactoryNew extends SSLSocketFactory {
    protected SSLContext a;
    protected SSLSocket b = null;
    protected String[] d;
    protected X509TrustManager e;
    protected String[] f;
    protected String[] g;
    protected String[] h;

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (a.a(this.h)) {
            z = false;
        } else {
            e.c("SSLFNew", "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.h);
            z = true;
        }
        if (a.a(this.g) && a.a(this.f)) {
            z2 = false;
        } else {
            e.c("SSLFNew", "set cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (a.a(this.g)) {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f);
            } else {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.g);
            }
        }
        if (!z) {
            e.c("SSLFNew", "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.c("SSLFNew", "set default cipher");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        e.c("SSLFNew", "createSocket: host , port");
        Socket socketCreateSocket = this.a.getSocketFactory().createSocket(str, i);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.b = sSLSocket;
            this.d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.d;
        return strArr != null ? strArr : new String[0];
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.e = x509TrustManager;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return createSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        e.c("SSLFNew", "createSocket");
        Socket socketCreateSocket = this.a.getSocketFactory().createSocket(socket, str, i, z);
        if (socketCreateSocket instanceof SSLSocket) {
            a(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.b = sSLSocket;
            this.d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    @Deprecated
    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.a = null;
        this.a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }
}
