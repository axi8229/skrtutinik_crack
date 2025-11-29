package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class DataSpec {

    @Deprecated
    public final long absoluteStreamPosition;
    public final Object customData;
    public final int flags;
    public final byte[] httpBody;
    public final int httpMethod;
    public final Map<String, String> httpRequestHeaders;
    public final String key;
    public final long length;
    public final long position;
    public final Uri uri;
    public final long uriPositionOffset;

    public static final class Builder {
        private Object customData;
        private int flags;
        private byte[] httpBody;
        private String key;
        private long position;
        private Uri uri;
        private long uriPositionOffset;
        private int httpMethod = 1;
        private Map<String, String> httpRequestHeaders = Collections.emptyMap();
        private long length = -1;

        public Builder setUri(String uriString) {
            this.uri = Uri.parse(uriString);
            return this;
        }

        public Builder setUri(Uri uri) {
            this.uri = uri;
            return this;
        }

        public Builder setHttpMethod(int httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }

        public Builder setHttpBody(byte[] httpBody) {
            this.httpBody = httpBody;
            return this;
        }

        public Builder setHttpRequestHeaders(Map<String, String> httpRequestHeaders) {
            this.httpRequestHeaders = httpRequestHeaders;
            return this;
        }

        public Builder setPosition(long position) {
            this.position = position;
            return this;
        }

        public Builder setLength(long length) {
            this.length = length;
            return this;
        }

        public Builder setKey(String key) {
            this.key = key;
            return this;
        }

        public Builder setFlags(int flags) {
            this.flags = flags;
            return this;
        }

        public DataSpec build() {
            Assertions.checkStateNotNull(this.uri, "The uri must be set.");
            return new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, this.httpRequestHeaders, this.position, this.length, this.key, this.flags, this.customData);
        }
    }

    public static String getStringForHttpMethod(int httpMethod) {
        if (httpMethod == 1) {
            return "GET";
        }
        if (httpMethod == 2) {
            return "POST";
        }
        if (httpMethod == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    private DataSpec(Uri uri, long uriPositionOffset, int httpMethod, byte[] httpBody, Map<String, String> httpRequestHeaders, long position, long length, String key, int flags, Object customData) {
        byte[] bArr = httpBody;
        long j = uriPositionOffset + position;
        Assertions.checkArgument(j >= 0);
        Assertions.checkArgument(position >= 0);
        Assertions.checkArgument(length > 0 || length == -1);
        this.uri = uri;
        this.uriPositionOffset = uriPositionOffset;
        this.httpMethod = httpMethod;
        this.httpBody = (bArr == null || bArr.length == 0) ? null : bArr;
        this.httpRequestHeaders = Collections.unmodifiableMap(new HashMap(httpRequestHeaders));
        this.position = position;
        this.absoluteStreamPosition = j;
        this.length = length;
        this.key = key;
        this.flags = flags;
        this.customData = customData;
    }

    public boolean isFlagSet(int flag) {
        return (this.flags & flag) == flag;
    }

    public final String getHttpMethodString() {
        return getStringForHttpMethod(this.httpMethod);
    }

    public DataSpec subrange(long offset) {
        long j = this.length;
        return subrange(offset, j != -1 ? j - offset : -1L);
    }

    public DataSpec subrange(long offset, long length) {
        return (offset == 0 && this.length == length) ? this : new DataSpec(this.uri, this.uriPositionOffset, this.httpMethod, this.httpBody, this.httpRequestHeaders, this.position + offset, length, this.key, this.flags, this.customData);
    }

    public String toString() {
        return "DataSpec[" + getHttpMethodString() + " " + this.uri + ", " + this.position + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
    }
}
