package com.huawei.location.crowdsourcing.upload.http;

import com.huawei.location.crowdsourcing.upload.http.Vw;
import com.huawei.location.lite.common.log.LogLocation;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class FB extends Vw {
    private final SortedMap<String, String> E5;
    private String d2;
    private String zp;

    public FB(String str, String str2) {
        super(Vw.yn.POST, str, str2);
        this.E5 = new TreeMap();
        this.d2 = "";
        this.zp = "";
        yn("Charset", "UTF-8").yn("Content-Type", "application/x-www-form-urlencoded").yn("Connection", "close");
    }

    public FB FB(String str, String str2) {
        return LW(Vw.yn(str), Vw.yn(str2));
    }

    public FB LW(String str, String str2) {
        if (!str.isEmpty() && !str2.isEmpty()) {
            this.E5.put(str, str2);
        }
        return this;
    }

    @Override // com.huawei.location.crowdsourcing.upload.http.Vw
    protected InputStream LW() {
        return new ByteArrayInputStream(Vw.yn(this.E5).getBytes(StandardCharsets.UTF_8));
    }

    public FB dC(String str, String str2) {
        this.d2 = str;
        this.zp = str2;
        return this;
    }

    @Override // com.huawei.location.crowdsourcing.upload.http.Vw
    protected boolean dC() throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        if (!super.dC()) {
            return false;
        }
        String str = "";
        if (this.d2.isEmpty()) {
            LogLocation.d("QueryRequest", "no need authorization");
        } else if (this.zp.isEmpty()) {
            LogLocation.e("QueryRequest", "appId empty, can not gen authorization");
        } else {
            String strYn = com.huawei.location.crowdsourcing.common.util.FB.yn(String.format(Locale.ENGLISH, "%s&%s&%s&%s&appID=%s", Vw(), FB(), yn(), Vw.yn(this.E5), this.zp), this.d2.getBytes(StandardCharsets.UTF_8));
            if (strYn == null) {
                LogLocation.e("QueryRequest", "HMAC-SHA256 failed");
            } else {
                str = strYn;
            }
            str = MessageFormat.format("HMAC-SHA256 appID={0}, signature=\"{1}\"", this.zp, str);
        }
        if (str.isEmpty()) {
            return true;
        }
        yn("Authorization", str);
        return true;
    }

    public FB yn(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            FB(entry.getKey(), entry.getValue());
        }
        return this;
    }
}
