package com.huawei.wisesecurity.ucs_credential;

import android.annotation.SuppressLint;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.aes.AESCipher;
import com.huawei.wisesecurity.kfs.crypto.key.AESKeyStoreKeyManager;
import com.huawei.wisesecurity.kfs.crypto.key.KeyGenerateParam;
import com.huawei.wisesecurity.kfs.crypto.key.KfsKeyPurpose;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsKeyStoreException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import java.security.KeyStoreException;

/* loaded from: classes3.dex */
public class m0 implements o0 {
    public static final o0 b = new m0();
    public static final Object c = new Object();
    public static AESKeyStoreKeyManager d;
    public byte[] a;

    @SuppressLint({"NewApi"})
    public void a(String str) throws UcsKeyStoreException, KeyStoreException {
        try {
            if (d.hasAlias(str)) {
                LogUcs.i("KeyStoreManager", "the alias exists", new Object[0]);
                return;
            }
            try {
                d.generate(new KeyGenerateParam(str, 256, KfsKeyPurpose.PURPOSE_CRYPTO));
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
        return new byte[0];
    }

    public byte[] a(String str, byte[] bArr) throws UcsKeyStoreException {
        byte[] bArr2;
        synchronized (c) {
            try {
                byte[] bArr3 = this.a;
                if (bArr3 == null || bArr3.length <= 0) {
                    throw new UcsKeyStoreException("iv must be set before AES decrypt");
                }
                try {
                    bArr2 = new AESCipher.Builder(d.getProvider()).withAlg(CipherAlg.AES_GCM).withKey(d.getKey(str)).withIv(this.a).build().getDecryptHandler().from(bArr).to();
                } catch (KfsException e) {
                    LogUcs.e("KeyStoreManager", "AES doDecrypt failed, " + e.getMessage(), new Object[0]);
                    throw new UcsKeyStoreException("AES doDecrypt failed , exception " + e.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArr2;
    }

    public byte[] b(String str, byte[] bArr) throws UcsKeyStoreException {
        byte[] bArr2;
        synchronized (c) {
            try {
                byte[] bArr3 = this.a;
                if (bArr3 == null || bArr3.length <= 0) {
                    throw new UcsKeyStoreException("iv must be set before AES encrypt");
                }
                try {
                    bArr2 = new AESCipher.Builder(d.getProvider()).withAlg(CipherAlg.AES_GCM).withKey(d.getKey(str)).withIv(this.a).build().getEncryptHandler().from(bArr).to();
                } catch (KfsException e) {
                    LogUcs.e("KeyStoreManager", "AES doEncrypt failed, " + e.getMessage(), new Object[0]);
                    throw new UcsKeyStoreException("AES doEncrypt failed , exception " + e.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArr2;
    }
}
