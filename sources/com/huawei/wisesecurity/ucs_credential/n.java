package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.key.AESKeyStoreKeyManager;
import com.huawei.wisesecurity.kfs.util.RandomUtil;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.utils.SpUtil;
import com.huawei.wisesecurity.ucs.common.utils.StringUtil;
import com.huawei.wisesecurity.ucs.credential.entity.EcKeyPair;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import java.security.KeyStoreException;

/* loaded from: classes3.dex */
public class n {
    public static EcKeyPair a(Context context) throws UcsException, KeyStoreException {
        try {
            return b(context);
        } catch (UcsException unused) {
            EcKeyPair ecKeyPairGenerateEcKeyPair = UcsLib.generateEcKeyPair(context);
            if (ecKeyPairGenerateEcKeyPair == null) {
                throw new UcsException(1022L, "key is null");
            }
            if (m0.d == null) {
                m0.d = new AESKeyStoreKeyManager();
            }
            m0 m0Var = (m0) m0.b;
            m0Var.a("ucs_aes_alias_rootKey");
            byte[] bArrGenerateRandomBytes = RandomUtil.generateRandomBytes(CipherAlg.AES_GCM.getIvLen());
            m0Var.a = bArrGenerateRandomBytes;
            SpUtil.putString("ucs_ec_credential_enc_sp_key", StringUtil.base64EncodeToString(bArrGenerateRandomBytes, 2) + ":" + StringUtil.base64EncodeToString(m0Var.b("ucs_aes_alias_rootKey", ecKeyPairGenerateEcKeyPair.getPublicKey()), 10) + ":" + StringUtil.base64EncodeToString(m0Var.b("ucs_aes_alias_rootKey", ecKeyPairGenerateEcKeyPair.getPrivateKey()), 10), context);
            return ecKeyPairGenerateEcKeyPair;
        }
    }

    public static void a(EcKeyPair ecKeyPair) {
        byte[] privateKey = ecKeyPair.getPrivateKey();
        if (privateKey == null) {
            return;
        }
        int length = privateKey.length;
        for (int i = 0; i < length; i++) {
            privateKey[i] = 0;
        }
    }

    public static EcKeyPair b(Context context) throws UcsException {
        EcKeyPair.Builder builderNewBuilder = EcKeyPair.newBuilder();
        String string = SpUtil.getString("ucs_ec_credential_enc_sp_key", "", context);
        if (TextUtils.isEmpty(string)) {
            throw new UcsException(1022L, "no cache key");
        }
        String[] strArrSplit = string.split(":");
        if (strArrSplit.length != 3) {
            throw new UcsException(1022L, "invalid cache key");
        }
        if (m0.d == null) {
            m0.d = new AESKeyStoreKeyManager();
        }
        m0 m0Var = (m0) m0.b;
        m0Var.a("ucs_aes_alias_rootKey");
        m0Var.a = StringUtil.base64Decode(strArrSplit[0], 2);
        byte[] bArrA = m0Var.a("ucs_aes_alias_rootKey", StringUtil.base64Decode(strArrSplit[1], 10));
        byte[] bArrA2 = m0Var.a("ucs_aes_alias_rootKey", StringUtil.base64Decode(strArrSplit[2], 10));
        builderNewBuilder.publicKey(bArrA);
        builderNewBuilder.privateKey(bArrA2);
        return builderNewBuilder.build();
    }
}
