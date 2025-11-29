package com.huawei.wisesecurity.ucs_credential;

import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;

@Deprecated
/* loaded from: classes3.dex */
public class a {
    public String a;
    public String b;
    public String c;

    public String a() throws UcsException {
        if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) {
            throw new UcsException(2001L, "get  AppAuthtication JWS is empty...");
        }
        return b() + "." + this.c;
    }

    public String b() throws UcsException {
        if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) {
            throw new UcsException(2001L, "Get AppAuthtication signStr error");
        }
        return this.a + "." + this.b;
    }
}
