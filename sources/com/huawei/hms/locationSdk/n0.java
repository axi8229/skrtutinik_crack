package com.huawei.hms.locationSdk;

import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;

/* loaded from: classes3.dex */
public abstract class n0<ClientT extends AnyClient, ResultT> extends TaskApiCall<ClientT, ResultT> {
    public final String a;

    public n0(String str, String str2, String str3) {
        super(str, str2);
        this.a = str3;
    }

    public n0(String str, String str2, String str3, String str4) {
        super(str, str2, str4);
        this.a = str3;
    }

    public void a(boolean z) {
    }

    protected boolean a(int i) {
        return i >= 8 && ((i >> 3) & 1) == 1;
    }
}
