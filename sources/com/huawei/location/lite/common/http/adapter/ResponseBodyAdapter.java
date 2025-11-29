package com.huawei.location.lite.common.http.adapter;

import java.nio.charset.StandardCharsets;

/* loaded from: classes3.dex */
public class ResponseBodyAdapter {
    private long contentLength;
    private String contentType;
    private byte[] responseByte;

    public static final class Builder {
        private long contentLength;
        private String contentType;
        private byte[] responseByte;

        public ResponseBodyAdapter build() {
            return new ResponseBodyAdapter(this);
        }

        public Builder bytes(byte[] bArr) {
            this.responseByte = bArr;
            return this;
        }

        public Builder contentLength(long j) {
            this.contentLength = j;
            return this;
        }

        public Builder contentType(String str) {
            this.contentType = str;
            return this;
        }
    }

    private ResponseBodyAdapter(Builder builder) {
        this.contentType = builder.contentType;
        this.contentLength = builder.contentLength;
        this.responseByte = builder.responseByte;
    }

    public final byte[] bytes() {
        return this.responseByte;
    }

    public String toString() {
        return "ResponseBodyAdapter{contentType='" + this.contentType + "', contentLength=" + this.contentLength + ", responseByte=" + new String(this.responseByte, StandardCharsets.UTF_8) + '}';
    }
}
