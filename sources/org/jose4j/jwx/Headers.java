package org.jose4j.jwx;

import java.util.LinkedHashMap;
import java.util.Map;
import org.jose4j.base64url.Base64Url;
import org.jose4j.json.JsonUtil;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.JsonHelp;

/* loaded from: classes4.dex */
public class Headers {
    private String encodedHeader;
    private String header;
    protected Base64Url base64url = new Base64Url();
    private Map<String, Object> headerMap = new LinkedHashMap();

    public String getFullHeaderAsJsonString() {
        if (this.header == null) {
            this.header = JsonUtil.toJson(this.headerMap);
        }
        return this.header;
    }

    public String getEncodedHeader() {
        if (this.encodedHeader == null) {
            this.encodedHeader = this.base64url.base64UrlEncodeUtf8ByteRepresentation(getFullHeaderAsJsonString());
        }
        return this.encodedHeader;
    }

    public void setStringHeaderValue(String str, String str2) {
        setObjectHeaderValue(str, str2);
    }

    public void setObjectHeaderValue(String str, Object obj) {
        this.headerMap.put(str, obj);
        this.header = null;
        this.encodedHeader = null;
    }

    public String getStringHeaderValue(String str) {
        return JsonHelp.getString(this.headerMap, str);
    }

    public Object getObjectHeaderValue(String str) {
        return this.headerMap.get(str);
    }

    void setEncodedHeader(String str) throws JoseException {
        this.encodedHeader = str;
        String strBase64UrlDecodeToUtf8String = this.base64url.base64UrlDecodeToUtf8String(str);
        this.header = strBase64UrlDecodeToUtf8String;
        this.headerMap = JsonUtil.parseJson(strBase64UrlDecodeToUtf8String);
    }
}
