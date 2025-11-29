package com.huawei.wisesecurity.kfs.crypto.signer;

import com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.ucs_credential.f;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Mac;

/* loaded from: classes3.dex */
public class DefaultVerifyHandler implements VerifyHandler {
    private final Key key;
    private final AlgorithmParameterSpec parameterSpec;
    private final KeyStoreProvider provider;
    private final SignText signText;

    /* renamed from: com.huawei.wisesecurity.kfs.crypto.signer.DefaultVerifyHandler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg;

        static {
            int[] iArr = new int[SignAlg.values().length];
            $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg = iArr;
            try {
                iArr[SignAlg.ECDSA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg[SignAlg.RSA_SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg[SignAlg.RSA_SHA256_PSS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg[SignAlg.HMAC_SHA256.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public DefaultVerifyHandler(KeyStoreProvider keyStoreProvider, Key key, SignText signText, AlgorithmParameterSpec algorithmParameterSpec) {
        this.provider = keyStoreProvider;
        this.key = key;
        this.parameterSpec = algorithmParameterSpec;
        this.signText = signText;
    }

    private boolean checkSignature(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean doAsymmVerify() throws SignatureException, InvalidKeyException, CryptoException, InvalidAlgorithmParameterException {
        try {
            String transformation = this.signText.getAlgId().getTransformation();
            KeyStoreProvider keyStoreProvider = this.provider;
            Signature signature = keyStoreProvider == KeyStoreProvider.ANDROID_KEYSTORE ? Signature.getInstance(transformation) : Signature.getInstance(transformation, keyStoreProvider.getProviderName());
            AlgorithmParameterSpec algorithmParameterSpec = this.parameterSpec;
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            Key key = this.key;
            if (!(key instanceof PublicKey)) {
                throw new CryptoException("verify key not public key");
            }
            signature.initVerify((PublicKey) key);
            signature.update(this.signText.getDataBytes());
            return signature.verify(this.signText.getSignature());
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            StringBuilder sbA = f.a("Fail to decrypt: ");
            sbA.append(e.getMessage());
            throw new CryptoException(sbA.toString());
        } catch (InvalidKeyException e2) {
            e = e2;
            StringBuilder sbA2 = f.a("Fail to decrypt: ");
            sbA2.append(e.getMessage());
            throw new CryptoException(sbA2.toString());
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            StringBuilder sbA22 = f.a("Fail to decrypt: ");
            sbA22.append(e.getMessage());
            throw new CryptoException(sbA22.toString());
        } catch (NoSuchProviderException e4) {
            e = e4;
            StringBuilder sbA222 = f.a("Fail to decrypt: ");
            sbA222.append(e.getMessage());
            throw new CryptoException(sbA222.toString());
        } catch (SignatureException e5) {
            e = e5;
            StringBuilder sbA2222 = f.a("Fail to decrypt: ");
            sbA2222.append(e.getMessage());
            throw new CryptoException(sbA2222.toString());
        }
    }

    private boolean doSymmVerify() throws IllegalStateException, InvalidKeyException, CryptoException {
        try {
            String transformation = this.signText.getAlgId().getTransformation();
            KeyStoreProvider keyStoreProvider = this.provider;
            Mac mac = keyStoreProvider == KeyStoreProvider.ANDROID_KEYSTORE ? Mac.getInstance(transformation) : Mac.getInstance(transformation, keyStoreProvider.getProviderName());
            mac.init(this.key);
            mac.update(this.signText.getDataBytes());
            return checkSignature(this.signText.getSignature(), mac.doFinal());
        } catch (InvalidKeyException e) {
            e = e;
            StringBuilder sbA = f.a("Fail to sign : ");
            sbA.append(e.getMessage());
            throw new CryptoException(sbA.toString());
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            StringBuilder sbA2 = f.a("Fail to sign : ");
            sbA2.append(e.getMessage());
            throw new CryptoException(sbA2.toString());
        } catch (NoSuchProviderException e3) {
            e = e3;
            StringBuilder sbA22 = f.a("Fail to sign : ");
            sbA22.append(e.getMessage());
            throw new CryptoException(sbA22.toString());
        }
    }

    private boolean doVerify() throws CryptoException {
        int i = AnonymousClass1.$SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg[this.signText.getAlgId().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return doAsymmVerify();
        }
        if (i == 4) {
            return doSymmVerify();
        }
        StringBuilder sbA = f.a("unsupported sign alg : ");
        sbA.append(this.signText.getAlgId().getTransformation());
        throw new CryptoException(sbA.toString());
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.VerifyHandler
    public DefaultVerifyHandler fromData(byte[] bArr) throws CryptoException {
        this.signText.setDataBytes(bArr);
        return this;
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.VerifyHandler
    public boolean verify(byte[] bArr) throws CryptoException {
        this.signText.setSignature(bArr);
        return doVerify();
    }
}
