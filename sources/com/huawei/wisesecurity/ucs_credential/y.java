package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.SpUtil;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.entity.EcKeyPair;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;

/* loaded from: classes3.dex */
public class y extends l {
    @Override // com.huawei.wisesecurity.ucs_credential.l
    public byte[] a(Credential credential, Context context) throws UcsException {
        try {
            String[] strArrSplit = credential.getKekString().split(":");
            if (strArrSplit.length < 3) {
                LogUcs.e("KeyStoreECIESParseHandler", "EC kek doDecrypt failure. kek string invalid", new Object[0]);
                throw new UcsException(1020L, "EC kek doDecrypt failure. kek string invalid");
            }
            byte[] bArrBase64Decode = StringUtil.base64Decode(strArrSplit[0], 0);
            byte[] bArrBase64Decode2 = StringUtil.base64Decode(strArrSplit[1], 0);
            byte[] bArrBase64Decode3 = StringUtil.base64Decode(strArrSplit[2], 0);
            EcKeyPair ecKeyPairB = n.b(context);
            byte[] bArrDecryptKekWithEc = UcsLib.decryptKekWithEc(bArrBase64Decode3, 1, bArrBase64Decode, bArrBase64Decode2, ecKeyPairB.getPrivateKey());
            if (bArrDecryptKekWithEc == null || bArrDecryptKekWithEc.length == 0) {
                LogUcs.e("KeyStoreECIESParseHandler", "KeyStore doDecrypt failure.", new Object[0]);
                throw new UcsException(1020L, "KeyStore doDecrypt failure.");
            }
            n.a(ecKeyPairB);
            return bArrDecryptKekWithEc;
        } catch (UcsException e) {
            if (credential.getKekVersion() == 6) {
                d0.a(context);
            } else {
                SpUtil.putInt("ucs_ec_huks_sp_key_t", 0, context);
            }
            StringBuilder sbA = f.a("decrypt kek get exception : ");
            sbA.append(e.getMessage());
            String string = sbA.toString();
            throw h.a("KeyStoreECIESParseHandler", string, new Object[0], 1020L, string);
        }
    }
}
