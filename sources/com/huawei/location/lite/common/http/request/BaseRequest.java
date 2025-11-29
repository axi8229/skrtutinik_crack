package com.huawei.location.lite.common.http.request;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.location.BuildConfig;
import com.huawei.location.lite.common.grs.LocationNlpGrsHelper;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.HttpUtils;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class BaseRequest {
    private String baseUrl;
    private final byte[] body;
    private final String contentType;
    private final HeadBuilder heads;
    private final String method;
    private String path;
    private SortedMap<String, String> queryMap;

    public static final class Builder {
        private String baseUrl;
        private byte[] body;
        private String contentType;
        private HeadBuilder heads;
        private String method = "POST";
        private String path;
        private SortedMap<String, String> queryMap;

        public Builder(String str) {
            this.path = str;
        }

        public Builder addAllQuery(SortedMap<String, String> sortedMap) {
            if (sortedMap == null) {
                return this;
            }
            if (this.queryMap == null) {
                this.queryMap = new TreeMap();
            }
            this.queryMap.putAll(sortedMap);
            return this;
        }

        public Builder addHeader(String str, String str2) {
            if (this.heads == null) {
                this.heads = new HeadBuilder();
            }
            this.heads.add(str, str2);
            return this;
        }

        public Builder addQuery(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (this.queryMap == null) {
                    this.queryMap = new TreeMap();
                }
                this.queryMap.put(str, str2);
            }
            return this;
        }

        public BaseRequest build() {
            if (TextUtils.isEmpty(this.baseUrl)) {
                this.baseUrl = LocationNlpGrsHelper.getGrsHostAddress(BuildConfig.LIBRARY_PACKAGE_NAME);
            }
            return new BaseRequest(this);
        }

        public Builder removeHeader(String str) {
            HeadBuilder headBuilder = this.heads;
            if (headBuilder == null) {
                return this;
            }
            headBuilder.remove(str);
            return this;
        }

        public Builder setBaseUrl(String str) {
            this.baseUrl = str;
            return this;
        }

        public Builder setBody(RequestJsonBody requestJsonBody) {
            this.body = requestJsonBody.getBody().getBytes();
            this.contentType = requestJsonBody.contentType();
            return this;
        }

        public Builder setBody(byte[] bArr, String str) {
            this.body = bArr;
            this.contentType = str;
            return this;
        }

        public Builder setHeads(HeadBuilder headBuilder) {
            this.heads = headBuilder;
            return this;
        }

        public Builder setMethod(String str) {
            this.method = str;
            return this;
        }
    }

    public BaseRequest(Builder builder) {
        this.baseUrl = builder.baseUrl;
        this.heads = builder.heads;
        this.body = builder.body;
        this.method = builder.method;
        this.contentType = builder.contentType;
        this.path = builder.path;
        this.queryMap = builder.queryMap;
        parsePathQuery();
    }

    private void parsePathQuery() {
        if (this.path.contains("?")) {
            if (this.queryMap == null) {
                this.queryMap = new TreeMap();
            }
            try {
                URI uriCreate = URI.create(HttpUtils.urlDecode(this.baseUrl + this.path));
                String query = uriCreate.getQuery();
                if (query == null) {
                    return;
                }
                this.baseUrl = uriCreate.getScheme() + "://" + uriCreate.getHost();
                this.path = uriCreate.getPath();
                String[] strArrSplit = query.split(ContainerUtils.FIELD_DELIMITER);
                int length = strArrSplit.length;
                for (int i = 0; i < length; i++) {
                    String[] strArrSplit2 = strArrSplit[i].split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (strArrSplit2.length == 2) {
                        this.queryMap.put(strArrSplit2[0], strArrSplit2[1]);
                    }
                }
            } catch (IllegalArgumentException unused) {
                LogLocation.e("BaseRequest", "parse query failed");
            }
        }
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public byte[] getBody() {
        return this.body;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getFullUrl() {
        Uri.Builder builderBuildUpon = Uri.parse(this.baseUrl).buildUpon();
        if (!TextUtils.isEmpty(this.path)) {
            builderBuildUpon.path(this.path);
        }
        SortedMap<String, String> sortedMap = this.queryMap;
        if (sortedMap != null) {
            for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
                builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return HttpUtils.urlDecode(builderBuildUpon.build().toString());
    }

    public HeadBuilder getHeads() {
        return this.heads;
    }

    public String getMethod() {
        return this.method;
    }

    public String getPath() {
        return this.path;
    }

    public String getQueryString() {
        if (this.queryMap == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.queryMap.entrySet()) {
            if (sb.length() > 0) {
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb.append(entry.getKey());
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public Builder newBuilder() {
        return new Builder(this.path).setBaseUrl(this.baseUrl).setBody(this.body, this.contentType).setHeads(this.heads).setMethod(this.method).addAllQuery(this.queryMap);
    }

    public String toString() {
        return "BaseRequest{method='" + this.method + "', baseUrl='" + this.baseUrl + "', path='" + this.path + "', heads=" + this.heads + ", contentType='" + this.contentType + "', body=" + new String(this.body, StandardCharsets.UTF_8) + '}';
    }
}
