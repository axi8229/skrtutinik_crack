package com.huawei.wisesecurity.ucs_credential;

import android.annotation.SuppressLint;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.rsa.RSACipher;
import com.huawei.wisesecurity.kfs.crypto.key.KeyGenerateParam;
import com.huawei.wisesecurity.kfs.crypto.key.KfsKeyPurpose;
import com.huawei.wisesecurity.kfs.crypto.key.RSAKeyStoreKeyManager;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.rsa.RSASigner;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsKeyStoreException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider;
import java.security.cert.Certificate;

/* loaded from: classes3.dex */
public class p0 implements o0 {
    public static RSAKeyStoreKeyManager a;
    public static final p0 b = new p0();
    public static final Object c = new Object();

    public void a(UcsKeyStoreProvider ucsKeyStoreProvider) {
        a = new RSAKeyStoreKeyManager();
    }

    @SuppressLint({"NewApi"})
    public void a(String str) throws UcsKeyStoreException {
        try {
            if (a.hasAlias(str)) {
                LogUcs.i("KeyStoreManager", "the alias exists", new Object[0]);
                return;
            }
            try {
                a.generate(new KeyGenerateParam.Builder().alias(str).purpose(KfsKeyPurpose.PURPOSE_ALL).keyLen(3072).build());
                LogUcs.i("KeyStoreManager", "generateKeyPair OK", new Object[0]);
            } catch (KfsException e) {
                LogUcs.e("KeyStoreManager", l0.a(e, f.a("generateKeyPair failed, ")), new Object[0]);
                throw new UcsKeyStoreException(l0.a(e, f.a("generateKeyPair failed , exception ")));
            }
        } catch (KfsException e2) {
            LogUcs.e("KeyStoreManager", l0.a(e2, f.a("containsAlias failed, ")), new Object[0]);
            throw new UcsKeyStoreException(l0.a(e2, f.a("containsAlias failed , exception ")));
        }
    }

    @Override // com.huawei.wisesecurity.ucs_credential.o0
    public byte[] a(String str, String str2) throws UcsKeyStoreException {
        byte[] bArrSign;
        synchronized (c) {
            try {
                try {
                    bArrSign = new RSASigner.Builder(a.getProvider()).withAlg(SignAlg.RSA_SHA256_PSS).withKeyStoreAlias(str).build().getSignHandler().from(str2).sign();
                } catch (KfsException e) {
                    LogUcs.e("KeyStoreManager", "doSign failed, " + e.getMessage(), new Object[0]);
                    throw new UcsKeyStoreException("doSign failed , exception " + e.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrSign;
    }

    public byte[] a(String str, byte[] bArr) throws UcsKeyStoreException {
        byte[] bArr2;
        synchronized (c) {
            try {
                try {
                    bArr2 = new RSACipher.Builder(a.getProvider()).withAlg(CipherAlg.RSA_OAEP).withKeyStoreAlias(str).build().getDecryptHandler().from(bArr).to();
                } catch (KfsException e) {
                    LogUcs.e("KeyStoreManager", "doDecrypt failed, " + e.getMessage(), new Object[0]);
                    throw new UcsKeyStoreException("doDecrypt failed , exception " + e.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArr2;
    }

    public Certificate[] b(String str) throws UcsKeyStoreException {
        try {
            return a.getCertificateChain(str);
        } catch (KfsException e) {
            LogUcs.e("KeyStoreManager", l0.a(e, f.a("getCertificateChain failed, ")), new Object[0]);
            throw new UcsKeyStoreException(l0.a(e, f.a("getCertificateChain failed , exception ")));
        }
    }
}
