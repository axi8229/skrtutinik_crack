package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;

/* loaded from: classes3.dex */
public class f0 extends l {
    @Override // com.huawei.wisesecurity.ucs_credential.l
    public byte[] a(Credential credential, Context context) throws UcsException {
        return UcsLib.decryptKek(credential.getKekBytes(), credential.getAlg());
    }
}
