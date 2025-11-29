package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;

/* loaded from: classes3.dex */
public class r implements p {
    public GrsClient a;

    public r(Context context, String str) {
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setSerCountry(str);
        this.a = new GrsClient(context, grsBaseInfo);
    }

    @Override // com.huawei.wisesecurity.ucs_credential.p
    public String a() {
        return a("HA");
    }

    public final String a(String str) {
        String strSynGetGrsUrl = this.a.synGetGrsUrl("com.huawei.tsms", str);
        LogUcs.i("InnerGrsUrlImpl", "synGetGrsUrl : {0}", strSynGetGrsUrl);
        return strSynGetGrsUrl;
    }

    @Override // com.huawei.wisesecurity.ucs_credential.p
    public String a(String str, String str2) {
        return a("CDN") + "tsms/" + str + "/" + str2;
    }

    @Override // com.huawei.wisesecurity.ucs_credential.p
    public String b() {
        return a("ROOT") + "/tsms/v2/credentials";
    }
}
