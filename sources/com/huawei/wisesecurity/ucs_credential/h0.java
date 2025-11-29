package com.huawei.wisesecurity.ucs_credential;

import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.credential.outer.GrsCapability;

/* loaded from: classes3.dex */
public class h0 implements p {
    public GrsCapability a;

    public h0(GrsCapability grsCapability) {
        this.a = grsCapability;
    }

    @Override // com.huawei.wisesecurity.ucs_credential.p
    public String a() {
        return a("HA");
    }

    public final String a(String str) {
        String strSynGetGrsUrl = this.a.synGetGrsUrl("com.huawei.tsms", str);
        LogUcs.i("OuterGrsUrlImpl", "synGetGrsUrl : {0}", strSynGetGrsUrl);
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
