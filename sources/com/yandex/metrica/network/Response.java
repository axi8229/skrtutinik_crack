package com.yandex.metrica.network;

import com.yandex.metrica.network.impl.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Response {
    private final boolean a;
    private final int b;
    private final byte[] c;
    private final byte[] d;
    private final Map e;
    private final Throwable f;

    public Response(Throwable th) {
        this(false, 0, new byte[0], new byte[0], new HashMap(), th);
    }

    public Response(boolean z, int i, byte[] bArr, byte[] bArr2, Map map, Throwable th) {
        this.a = z;
        this.b = i;
        this.c = bArr;
        this.d = bArr2;
        this.e = map == null ? Collections.emptyMap() : e.a(map);
        this.f = th;
    }

    public int getCode() {
        return this.b;
    }

    public byte[] getErrorData() {
        return this.d;
    }

    public Throwable getException() {
        return this.f;
    }

    public Map getHeaders() {
        return this.e;
    }

    public byte[] getResponseData() {
        return this.c;
    }

    public boolean isCompleted() {
        return this.a;
    }

    public String toString() {
        return "Response{completed=" + this.a + ", code=" + this.b + ", responseDataLength=" + this.c.length + ", errorDataLength=" + this.d.length + ", headers=" + this.e + ", exception=" + this.f + '}';
    }
}
