package com.yandex.metrica.network;

import android.text.TextUtils;
import com.yandex.metrica.network.impl.e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Request {
    private final String a;
    private final String b;
    private final byte[] c;
    private final Map d;

    public class Builder {
        private final String a;
        private String b;
        private byte[] c = new byte[0];
        private final Map d = new HashMap();

        public Builder(String str) {
            this.a = str;
        }

        public Builder addHeader(String str, String str2) {
            this.d.put(str, str2);
            return this;
        }

        public Request build() {
            return new Request(this.a, this.b, this.c, this.d);
        }

        public Builder post(byte[] bArr) {
            this.c = bArr;
            return withMethod("POST");
        }

        public Builder withMethod(String str) {
            this.b = str;
            return this;
        }
    }

    private Request(String str, String str2, byte[] bArr, Map map) {
        this.a = str;
        this.b = TextUtils.isEmpty(str2) ? "GET" : str2;
        this.c = bArr;
        this.d = e.a(map);
    }

    public byte[] getBody() {
        return this.c;
    }

    public Map getHeaders() {
        return this.d;
    }

    public String getMethod() {
        return this.b;
    }

    public String getUrl() {
        return this.a;
    }

    public String toString() {
        return "Request{url=" + this.a + ", method='" + this.b + "', bodyLength=" + this.c.length + ", headers=" + this.d + '}';
    }
}
