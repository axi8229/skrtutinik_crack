package com.huawei.wisesecurity.kfs.crypto.key;

import android.util.Log;
import com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher;
import com.huawei.wisesecurity.kfs.crypto.signer.KfsSigner;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.kfs.exception.KfsKeyStoreException;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.util.HuksUtil;
import com.huawei.wisesecurity.kfs.util.RandomUtil;
import com.huawei.wisesecurity.kfs.validation.KfsValidator;
import com.huawei.wisesecurity.ucs_credential.e;
import com.huawei.wisesecurity.ucs_credential.f;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public abstract class KeyStoreKeyManager {
    private KeyStore mKeyStore;
    private final KeyStoreProvider provider;

    public KeyStoreKeyManager() {
        this(KeyStoreProvider.ANDROID_KEYSTORE);
    }

    public KeyStoreKeyManager(KeyStoreProvider keyStoreProvider) {
        this.provider = keyStoreProvider;
    }

    private void clearKey(String str) throws KfsException, KeyStoreException {
        if (hasAlias(str)) {
            try {
                this.mKeyStore.deleteEntry(str);
                Log.i("KeyStoreKeyManager", "keyEntry: " + str + " removed");
            } catch (KeyStoreException e) {
                StringBuilder sbA = f.a("delete key entry failed, ");
                sbA.append(e.getMessage());
                throw new KfsException(sbA.toString());
            }
        }
    }

    public void generate(KeyGenerateParam keyGenerateParam) throws KfsException, KeyStoreException {
        KfsValidator.validate(keyGenerateParam);
        validateParam(keyGenerateParam);
        generateKey(keyGenerateParam);
        try {
            validateKey(keyGenerateParam);
        } catch (KfsException e) {
            StringBuilder sbA = f.a("validate key failed, try to remove the key entry for alias:");
            sbA.append(keyGenerateParam.getAlias());
            Log.i("KeyStoreKeyManager", sbA.toString());
            clearKey(keyGenerateParam.getAlias());
            throw e;
        }
    }

    public abstract void generateKey(KeyGenerateParam keyGenerateParam) throws KfsException;

    public Certificate[] getCertificateChain(String str) throws KfsException, NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        initKeyStore();
        try {
            return this.mKeyStore.getCertificateChain(str);
        } catch (KeyStoreException e) {
            StringBuilder sbA = f.a("keystore get certificate chain failed, ");
            sbA.append(e.getMessage());
            throw new KfsException(sbA.toString());
        }
    }

    public Key getKey(String str) throws KfsException, NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        initKeyStore();
        try {
            return this.mKeyStore.getKey(str, null);
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            StringBuilder sbA = f.a("keystore get key failed, ");
            sbA.append(e.getMessage());
            throw new KfsException(sbA.toString());
        }
    }

    public KeyStoreProvider getProvider() {
        return this.provider;
    }

    public boolean hasAlias(String str) throws KfsException, NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        initKeyStore();
        try {
            return this.mKeyStore.containsAlias(str);
        } catch (KeyStoreException e) {
            StringBuilder sbA = f.a("keystore check alias failed, ");
            sbA.append(e.getMessage());
            throw new KfsException(sbA.toString());
        }
    }

    public void initKeyStore() throws KfsException, NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        if (this.mKeyStore != null) {
            return;
        }
        if (getProvider() == KeyStoreProvider.HUAWEI_KEYSTORE) {
            HuksUtil.getInstance();
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(this.provider.getName());
            this.mKeyStore = keyStore;
            keyStore.load(null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            throw new KfsException(e.a(e, f.a("init keystore failed, ")));
        }
    }

    public void validateCrypto(KfsCipher kfsCipher) throws KfsException {
        byte[] bArrGenerateRandomBytes = RandomUtil.generateRandomBytes(32);
        if (!Arrays.equals(bArrGenerateRandomBytes, kfsCipher.getDecryptHandler().from(kfsCipher.getEncryptHandler().from(bArrGenerateRandomBytes).to()).to())) {
            throw new KfsKeyStoreException("validate crypto key get bad result");
        }
    }

    public abstract void validateKey(KeyGenerateParam keyGenerateParam) throws KfsException;

    public abstract void validateParam(KeyGenerateParam keyGenerateParam) throws KfsValidationException;

    public void validateSign(KfsSigner kfsSigner) throws KfsException {
        byte[] bArrGenerateRandomBytes = RandomUtil.generateRandomBytes(32);
        if (!kfsSigner.getVerifyHandler().fromData(bArrGenerateRandomBytes).verify(kfsSigner.getSignHandler().from(bArrGenerateRandomBytes).sign())) {
            throw new KfsKeyStoreException("validate sign key get bad result");
        }
    }
}
