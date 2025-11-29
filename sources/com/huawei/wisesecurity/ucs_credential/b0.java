package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider;

/* loaded from: classes3.dex */
public class b0 extends l {
    @Override // com.huawei.wisesecurity.ucs_credential.l
    public byte[] a(Credential credential, Context context) throws UcsException {
        try {
            if (p0.a == null) {
                p0.b.a((UcsKeyStoreProvider) null);
            }
            byte[] bArrA = p0.b.a("ucs_alias_rootKey", credential.getKekBytes());
            if (bArrA != null && bArrA.length != 0) {
                return bArrA;
            }
            d0.b(context);
            LogUcs.e("KeyStoreParseHandler", "KeyStore doDecrypt failure.", new Object[0]);
            throw new UcsException(1020L, "KeyStore doDecrypt failure.");
        } catch (Throwable th) {
            d0.b(context);
            String str = "decrypt kek get exception : " + th.getMessage();
            throw h.a("KeyStoreParseHandler", str, new Object[0], 1020L, str);
        }
    }
}
