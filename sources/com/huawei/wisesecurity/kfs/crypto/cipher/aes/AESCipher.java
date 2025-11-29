package com.huawei.wisesecurity.kfs.crypto.cipher.aes;

import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherText;
import com.huawei.wisesecurity.kfs.crypto.cipher.DecryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.DefaultDecryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.DefaultEncryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.EncryptHandler;
import com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher;
import com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.kfs.util.ByteUtil;
import com.huawei.wisesecurity.ucs_credential.e;
import com.huawei.wisesecurity.ucs_credential.f;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: classes3.dex */
public class AESCipher implements KfsCipher {
    private final CipherAlg cipherAlg;
    private final Key key;
    private final AlgorithmParameterSpec parameterSpec;
    private final KeyStoreProvider provider;

    /* renamed from: com.huawei.wisesecurity.kfs.crypto.cipher.aes.AESCipher$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$huawei$wisesecurity$kfs$crypto$cipher$CipherAlg;

        static {
            int[] iArr = new int[CipherAlg.values().length];
            $SwitchMap$com$huawei$wisesecurity$kfs$crypto$cipher$CipherAlg = iArr;
            try {
                iArr[CipherAlg.AES_GCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$huawei$wisesecurity$kfs$crypto$cipher$CipherAlg[CipherAlg.AES_CBC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$huawei$wisesecurity$kfs$crypto$cipher$CipherAlg[CipherAlg.KEY_STORE_AES_CBC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class Builder {
        private CipherAlg cipherAlg;
        private Key key;
        private final KeyStoreProvider keyStoreProvider;
        private AlgorithmParameterSpec parameterSpec;

        public Builder() {
            this.cipherAlg = CipherAlg.getPreferredAlg("AES");
            this.keyStoreProvider = KeyStoreProvider.ANDROID_KEYSTORE;
        }

        public Builder(KeyStoreProvider keyStoreProvider) {
            this.cipherAlg = CipherAlg.getPreferredAlg("AES");
            this.keyStoreProvider = keyStoreProvider;
        }

        public AESCipher build() throws CryptoException {
            AlgorithmParameterSpec algorithmParameterSpec;
            Key key = this.key;
            if (key == null || (algorithmParameterSpec = this.parameterSpec) == null) {
                throw new CryptoException("key | parameterSpec cannot be null");
            }
            return new AESCipher(this.keyStoreProvider, this.cipherAlg, key, algorithmParameterSpec, null);
        }

        public Builder withAlg(CipherAlg cipherAlg) {
            this.cipherAlg = cipherAlg;
            return this;
        }

        public Builder withIv(byte[] bArr) throws CryptoException {
            AlgorithmParameterSpec gCMParameterSpec;
            int i = AnonymousClass1.$SwitchMap$com$huawei$wisesecurity$kfs$crypto$cipher$CipherAlg[this.cipherAlg.ordinal()];
            if (i == 1) {
                gCMParameterSpec = new GCMParameterSpec(128, ByteUtil.clone(bArr));
            } else {
                if (i != 2 && i != 3) {
                    throw new CryptoException("unsupported cipher alg");
                }
                gCMParameterSpec = new IvParameterSpec(ByteUtil.clone(bArr));
            }
            this.parameterSpec = gCMParameterSpec;
            return this;
        }

        public Builder withKey(Key key) {
            this.key = key;
            return this;
        }

        public Builder withKeyStoreAlias(String str) throws NoSuchAlgorithmException, KfsException, IOException, KeyStoreException, CertificateException {
            try {
                KeyStore keyStore = KeyStore.getInstance(this.keyStoreProvider.getName());
                keyStore.load(null);
                this.key = keyStore.getKey(str, null);
                return this;
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e) {
                throw new KfsException(e.a(e, f.a("keystore get key with alias failed, ")));
            }
        }
    }

    private AESCipher(KeyStoreProvider keyStoreProvider, CipherAlg cipherAlg, Key key, AlgorithmParameterSpec algorithmParameterSpec) {
        this.provider = keyStoreProvider;
        this.cipherAlg = cipherAlg;
        this.key = key;
        this.parameterSpec = algorithmParameterSpec;
    }

    public /* synthetic */ AESCipher(KeyStoreProvider keyStoreProvider, CipherAlg cipherAlg, Key key, AlgorithmParameterSpec algorithmParameterSpec, AnonymousClass1 anonymousClass1) {
        this(keyStoreProvider, cipherAlg, key, algorithmParameterSpec);
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher
    public DecryptHandler getDecryptHandler() throws CryptoException {
        CipherText cipherText = new CipherText();
        cipherText.setAlgId(this.cipherAlg);
        return new DefaultDecryptHandler(this.provider, this.key, cipherText, this.parameterSpec);
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.cipher.KfsCipher
    public EncryptHandler getEncryptHandler() throws CryptoException {
        CipherText cipherText = new CipherText();
        cipherText.setAlgId(this.cipherAlg);
        return new DefaultEncryptHandler(this.provider, this.key, cipherText, this.parameterSpec);
    }
}
