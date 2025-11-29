package com.huawei.location.crowdsourcing.upload;

import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.Map;
import ru.yoomoney.sdk.auth.YooMoneyAuth;

/* loaded from: classes3.dex */
public class yn {

    /* renamed from: com.huawei.location.crowdsourcing.upload.yn$yn, reason: collision with other inner class name */
    private static class C0087yn extends com.huawei.location.crowdsourcing.upload.http.yn {

        @SerializedName("serverDomain")
        private String FB;

        @SerializedName(YooMoneyAuth.KEY_ACCESS_TOKEN)
        private String LW;

        @SerializedName("resCode")
        private int Vw = -1;

        @SerializedName("reason")
        private String yn;

        private C0087yn() {
        }

        public String FB() {
            String str = this.LW;
            return str == null ? "" : str;
        }

        public String LW() {
            String str = this.FB;
            return str == null ? "" : str;
        }

        @Override // com.huawei.location.crowdsourcing.upload.http.yn
        protected boolean Vw() {
            return com.huawei.location.activity.model.Vw.Vw(this.Vw);
        }

        @Override // com.huawei.location.crowdsourcing.upload.http.yn
        protected String yn() {
            return com.huawei.location.activity.model.Vw.yn(this.Vw);
        }
    }

    public com.huawei.location.crowdsourcing.upload.entity.Vw yn(com.huawei.location.crowdsourcing.upload.entity.Vw vw, Map<String, String> map, String str) {
        LogLocation.i("GetServerDomain", "getDomainFromCloud start");
        com.huawei.location.crowdsourcing.upload.http.FB fb = new com.huawei.location.crowdsourcing.upload.http.FB(vw.yn, "/v2/getServerDomain");
        fb.yn(map).dC(vw.Vw, str).Vw("appID", str);
        C0087yn c0087yn = (C0087yn) fb.yn(C0087yn.class);
        if (c0087yn != null) {
            return new com.huawei.location.crowdsourcing.upload.entity.Vw(c0087yn.LW(), c0087yn.FB());
        }
        LogLocation.i("GetServerDomain", "resp is null:");
        return null;
    }
}
