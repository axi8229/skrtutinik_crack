package com.yandex.metrica;

import com.yandex.metrica.impl.ob.A2;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class PreloadInfo {
    private String a;
    private Map<String, String> b;

    public static class Builder {
        private String a;
        private Map<String, String> b;

        public PreloadInfo build() {
            return new PreloadInfo(this);
        }

        public Builder setAdditionalParams(String str, String str2) {
            if (str != null && str2 != null) {
                this.b.put(str, str2);
            }
            return this;
        }

        private Builder(String str) {
            this.a = str;
            this.b = new HashMap();
        }
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public Map<String, String> getAdditionalParams() {
        return this.b;
    }

    public String getTrackingId() {
        return this.a;
    }

    private PreloadInfo(Builder builder) {
        this.a = builder.a;
        this.b = A2.d(builder.b);
    }
}
