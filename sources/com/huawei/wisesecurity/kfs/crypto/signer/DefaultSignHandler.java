package com.huawei.wisesecurity.kfs.crypto.signer;

import com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.kfs.util.ByteUtil;
import com.huawei.wisesecurity.ucs_credential.f;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Mac;

/* loaded from: classes3.dex */
public class DefaultSignHandler implements SignHandler {
    private final Key key;
    private final AlgorithmParameterSpec parameterSpec;
    private final KeyStoreProvider provider;
    private final SignText signText;

    /* renamed from: com.huawei.wisesecurity.kfs.crypto.signer.DefaultSignHandler$1, reason: invalid class name */
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

    public DefaultSignHandler(KeyStoreProvider keyStoreProvider, Key key, SignText signText, AlgorithmParameterSpec algorithmParameterSpec) {
        this.provider = keyStoreProvider;
        this.key = key;
        this.parameterSpec = algorithmParameterSpec;
        this.signText = signText;
    }

    private void doAsymmSign() throws SignatureException, InvalidKeyException, CryptoException, InvalidAlgorithmParameterException {
        try {
            String transformation = this.signText.getAlgId().getTransformation();
            KeyStoreProvider keyStoreProvider = this.provider;
            Signature signature = keyStoreProvider == KeyStoreProvider.ANDROID_KEYSTORE ? Signature.getInstance(transformation) : Signature.getInstance(transformation, keyStoreProvider.getProviderName());
            AlgorithmParameterSpec algorithmParameterSpec = this.parameterSpec;
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            Key key = this.key;
            if (!(key instanceof PrivateKey)) {
                throw new CryptoException("sign key not private key");
            }
            signature.initSign((PrivateKey) key);
            signature.update(this.signText.getDataBytes());
            this.signText.setSignature(signature.sign());
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            StringBuilder sbA = f.a("Fail to sign : ");
            sbA.append(e.getMessage());
            throw new CryptoException(sbA.toString());
        } catch (InvalidKeyException e2) {
            e = e2;
            StringBuilder sbA2 = f.a("Fail to sign : ");
            sbA2.append(e.getMessage());
            throw new CryptoException(sbA2.toString());
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            StringBuilder sbA22 = f.a("Fail to sign : ");
            sbA22.append(e.getMessage());
            throw new CryptoException(sbA22.toString());
        } catch (NoSuchProviderException e4) {
            e = e4;
            StringBuilder sbA222 = f.a("Fail to sign : ");
            sbA222.append(e.getMessage());
            throw new CryptoException(sbA222.toString());
        } catch (SignatureException e5) {
            e = e5;
            StringBuilder sbA2222 = f.a("Fail to sign : ");
            sbA2222.append(e.getMessage());
            throw new CryptoException(sbA2222.toString());
        }
    }

    private void doSign() throws IllegalStateException, SignatureException, InvalidKeyException, CryptoException, InvalidAlgorithmParameterException {
        int i = AnonymousClass1.$SwitchMap$com$huawei$wisesecurity$kfs$crypto$signer$SignAlg[this.signText.getAlgId().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            doAsymmSign();
        } else if (i == 4) {
            doSymmSign();
        } else {
            StringBuilder sbA = f.a("unsupported sign alg : ");
            sbA.append(this.signText.getAlgId().getTransformation());
            throw new CryptoException(sbA.toString());
        }
    }

    private void doSymmSign() throws IllegalStateException, InvalidKeyException, CryptoException {
        try {
            String transformation = this.signText.getAlgId().getTransformation();
            KeyStoreProvider keyStoreProvider = this.provider;
            Mac mac = keyStoreProvider == KeyStoreProvider.ANDROID_KEYSTORE ? Mac.getInstance(transformation) : Mac.getInstance(transformation, keyStoreProvider.getProviderName());
            mac.init(this.key);
            mac.update(this.signText.getDataBytes());
            this.signText.setSignature(mac.doFinal());
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

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.SignHandler
    public DefaultSignHandler from(String str) throws CryptoException {
        return from(str.getBytes(StandardCharsets.UTF_8));
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.SignHandler
    public DefaultSignHandler from(byte[] bArr) throws CryptoException {
        this.signText.setDataBytes(ByteUtil.clone(bArr));
        return this;
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.signer.SignHandler
    public byte[] sign() throws IllegalStateException, SignatureException, InvalidKeyException, CryptoException, InvalidAlgorithmParameterException {
        doSign();
        return this.signText.getSignature();
    }
}
