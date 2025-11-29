package com.huawei.wisesecurity.kfs.crypto;

import com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.ucs_credential.e;
import com.huawei.wisesecurity.ucs_credential.f;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: classes3.dex */
public abstract class AsymmetricBuilder<T> {
    public final KeyStoreProvider keyStoreProvider;
    public AlgorithmParameterSpec parameterSpec;
    public PrivateKey privateKey;
    public PublicKey publicKey;

    public AsymmetricBuilder(KeyStoreProvider keyStoreProvider) {
        this.keyStoreProvider = keyStoreProvider;
    }

    public abstract T build() throws CryptoException;

    public AsymmetricBuilder<T> withKeyStoreAlias(String str) throws NoSuchAlgorithmException, UnrecoverableKeyException, KfsException, IOException, KeyStoreException, CertificateException {
        try {
            KeyStore keyStore = KeyStore.getInstance(this.keyStoreProvider.getName());
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (!(key instanceof PrivateKey)) {
                throw new KfsException("bad private key type");
            }
            this.privateKey = (PrivateKey) key;
            this.publicKey = keyStore.getCertificate(str).getPublicKey();
            return this;
        } catch (IOException e) {
            e = e;
            throw new KfsException(e.a(e, f.a("keystore get key with alias failed, ")));
        } catch (KeyStoreException e2) {
            e = e2;
            throw new KfsException(e.a(e, f.a("keystore get key with alias failed, ")));
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            throw new KfsException(e.a(e, f.a("keystore get key with alias failed, ")));
        } catch (UnrecoverableKeyException e4) {
            e = e4;
            throw new KfsException(e.a(e, f.a("keystore get key with alias failed, ")));
        } catch (CertificateException e5) {
            e = e5;
            throw new KfsException(e.a(e, f.a("keystore get key with alias failed, ")));
        }
    }
}
