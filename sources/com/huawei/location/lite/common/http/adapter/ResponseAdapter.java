package com.huawei.location.lite.common.http.adapter;

import com.huawei.location.lite.common.http.request.HeadBuilder;

/* loaded from: classes3.dex */
public class ResponseAdapter {
    private ResponseBodyAdapter body;
    private int code;
    private HeadBuilder headers;
    private String message;
    private long receivedResponseAtMillis;
    private long sentRequestAtMillis;
    private String url;

    public static final class Builder {
        private ResponseBodyAdapter body;
        private int code;
        private HeadBuilder headers;
        private String message;
        private long receivedResponseAtMillis;
        private long sentRequestAtMillis;
        private String url;

        public Builder() {
        }

        private Builder(ResponseAdapter responseAdapter) {
            this.body = responseAdapter.body;
            this.headers = responseAdapter.headers;
            this.code = responseAdapter.code;
            this.message = responseAdapter.message;
            this.sentRequestAtMillis = responseAdapter.sentRequestAtMillis;
            this.receivedResponseAtMillis = responseAdapter.receivedResponseAtMillis;
            this.url = responseAdapter.url;
        }

        public Builder body(ResponseBodyAdapter responseBodyAdapter) {
            this.body = responseBodyAdapter;
            return this;
        }

        public ResponseAdapter build() {
            return new ResponseAdapter(this);
        }

        public Builder code(int i) {
            this.code = i;
            return this;
        }

        public Builder headers(HeadBuilder headBuilder) {
            this.headers = headBuilder;
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder receivedResponseAtMillis(long j) {
            this.receivedResponseAtMillis = j;
            return this;
        }

        public Builder sentRequestAtMillis(long j) {
            this.sentRequestAtMillis = j;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }
    }

    private ResponseAdapter(Builder builder) {
        this.body = builder.body;
        this.headers = builder.headers;
        this.code = builder.code;
        this.message = builder.message;
        this.sentRequestAtMillis = builder.sentRequestAtMillis;
        this.receivedResponseAtMillis = builder.receivedResponseAtMillis;
        this.url = builder.url;
    }

    public ResponseBodyAdapter getBody() {
        return this.body;
    }

    public int getCode() {
        return this.code;
    }

    public long getSDKCostTime() {
        return this.receivedResponseAtMillis - this.sentRequestAtMillis;
    }

    public boolean isSuccessful() {
        int i = this.code;
        return i >= 200 && i < 300;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public String toString() {
        return "ResponseAdapter{body=" + this.body.toString() + ", headers=" + this.headers.toString() + ", code=" + this.code + ", message='" + this.message + "', sentRequestAtMillis=" + this.sentRequestAtMillis + ", receivedResponseAtMillis=" + this.receivedResponseAtMillis + ", url='" + this.url + "'}";
    }
}
