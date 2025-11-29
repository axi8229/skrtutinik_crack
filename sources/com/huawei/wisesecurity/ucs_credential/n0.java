package com.huawei.wisesecurity.ucs_credential;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.crypto.key.ECKeyStoreKeyManager;
import com.huawei.wisesecurity.kfs.crypto.key.KeyGenerateParam;
import com.huawei.wisesecurity.kfs.crypto.key.KeyStoreKeyManager;
import com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider;
import com.huawei.wisesecurity.kfs.crypto.key.KfsKeyPurpose;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.ec.ECSigner;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.ucs.common.exception.UcsKeyStoreException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider;
import java.security.cert.Certificate;

/* loaded from: classes3.dex */
public class n0 implements o0 {
    public static KeyStoreKeyManager a;
    public static final o0 b = new n0();
    public static final Object c = new Object();

    @SuppressLint({"NewApi"})
    public void a(String str) throws UcsKeyStoreException {
        try {
            if (a.hasAlias(str)) {
                LogUcs.i("KeyStoreManager", "the alias exists", new Object[0]);
                return;
            }
            try {
                a.generate(new KeyGenerateParam.Builder().alias(str).purpose(KfsKeyPurpose.PURPOSE_SIGN).keyLen(256).build());
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
                    bArrSign = new ECSigner.Builder(a.getProvider()).withAlg(SignAlg.ECDSA).withKeyStoreAlias(str).build().getSignHandler().from(str2).sign();
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

    public void b(UcsKeyStoreProvider ucsKeyStoreProvider) throws UcsKeyStoreException {
        String name = ucsKeyStoreProvider.getName();
        KeyStoreProvider keyStoreProvider = KeyStoreProvider.ANDROID_KEYSTORE;
        if (!TextUtils.equals(name, keyStoreProvider.getName())) {
            keyStoreProvider = KeyStoreProvider.HUAWEI_KEYSTORE;
        }
        a = new ECKeyStoreKeyManager(keyStoreProvider);
    }

    public Certificate[] b(String str) throws UcsKeyStoreException {
        try {
            return a.getCertificateChain(str);
        } catch (KfsException e) {
            LogUcs.e("KeyStoreManager", l0.a(e, f.a("getCertificateChain failed, ")), new Object[0]);
            throw new UcsKeyStoreException(l0.a(e, f.a("getCertificateChain failed , exception ")));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.wisesecurity.ucs_credential.o0 a(com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider r4) throws com.huawei.wisesecurity.ucs.common.exception.UcsKeyStoreException {
        /*
            com.huawei.wisesecurity.kfs.crypto.key.KeyStoreKeyManager r0 = com.huawei.wisesecurity.ucs_credential.n0.a
            if (r0 == 0) goto L1d
            com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider r0 = r0.getProvider()
            java.lang.String r1 = r4.getName()
            com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider r2 = com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider.ANDROID_KEYSTORE
            java.lang.String r3 = r2.getName()
            boolean r1 = android.text.TextUtils.equals(r1, r3)
            if (r1 == 0) goto L19
            goto L1b
        L19:
            com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider r2 = com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider.HUAWEI_KEYSTORE
        L1b:
            if (r0 == r2) goto L24
        L1d:
            com.huawei.wisesecurity.ucs_credential.o0 r0 = com.huawei.wisesecurity.ucs_credential.n0.b
            com.huawei.wisesecurity.ucs_credential.n0 r0 = (com.huawei.wisesecurity.ucs_credential.n0) r0
            r0.b(r4)
        L24:
            com.huawei.wisesecurity.ucs_credential.o0 r4 = com.huawei.wisesecurity.ucs_credential.n0.b
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisesecurity.ucs_credential.n0.a(com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider):com.huawei.wisesecurity.ucs_credential.o0");
    }
}
