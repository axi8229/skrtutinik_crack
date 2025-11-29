package com.huawei.location.crowdsourcing.upload;

import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.Map;

/* loaded from: classes3.dex */
public class FB {

    private static class yn extends com.huawei.location.crowdsourcing.upload.http.yn {

        @SerializedName("resCode")
        private int yn = -1;

        private yn() {
        }

        @Override // com.huawei.location.crowdsourcing.upload.http.yn
        public boolean Vw() {
            return com.huawei.location.activity.model.Vw.Vw(this.yn);
        }

        @Override // com.huawei.location.crowdsourcing.upload.http.yn
        protected String yn() {
            return com.huawei.location.activity.model.Vw.yn(this.yn);
        }
    }

    public boolean yn(Map<String, String> map, com.huawei.location.crowdsourcing.upload.entity.Vw vw, String str, String str2, String str3) {
        LogLocation.i("NotifySuccess", "doNotifySuccess start");
        com.huawei.location.crowdsourcing.upload.http.FB fb = new com.huawei.location.crowdsourcing.upload.http.FB(vw.yn, "/v2/notifyUploadSucc");
        fb.yn(map).FB("fileUniqueFlag", str2).FB("uploadTime", str3).dC(vw.Vw, str).Vw("appID", str);
        yn ynVar = (yn) fb.yn(yn.class);
        return ynVar != null && ynVar.Vw();
    }
}
