package com.huawei.updatesdk.a.a.b;

import java.util.ArrayDeque;
import java.util.Queue;
import org.pjsip.pjsua2.pj_ssl_sock_proto;

/* loaded from: classes3.dex */
public final class a {
    private static final a b = new a();
    private final Queue<byte[]> a = new ArrayDeque(0);

    private a() {
    }

    public static a b() {
        return b;
    }

    public void a(byte[] bArr) {
        if (bArr.length == 65536) {
            synchronized (this.a) {
                try {
                    if (this.a.size() < 32 && !this.a.offer(bArr)) {
                        com.huawei.updatesdk.a.a.c.a.a.a.a("ByteArrayPool", "releaseBytes false");
                    }
                } finally {
                }
            }
        }
    }

    public byte[] a() {
        byte[] bArrPoll;
        synchronized (this.a) {
            bArrPoll = this.a.poll();
        }
        return bArrPoll == null ? new byte[pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1] : bArrPoll;
    }
}
