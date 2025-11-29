package com.huawei.wisesecurity.ucs_credential;

import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;

/* loaded from: classes3.dex */
public final /* synthetic */ class h {
    public static UcsException a(String str, String str2, Object[] objArr, long j, String str3) {
        LogUcs.e(str, str2, objArr);
        return new UcsException(j, str3);
    }
}
