package com.huawei.wisesecurity.kfs.crypto.key;

import android.annotation.SuppressLint;
import android.security.keystore.KeyGenParameterSpec;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.rsa.RSACipher;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.rsa.RSASigner;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.ucs_credential.f;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/* loaded from: classes3.dex */
public class RSAKeyStoreKeyManager extends KeyStoreKeyManager {
    private boolean isValidRsaKeyLen(int i) {
        return (i == 2048 || i == 3072 || i == 4096) ? false : true;
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.key.KeyStoreKeyManager
    @SuppressLint({"WrongConstant"})
    public void generateKey(KeyGenerateParam keyGenerateParam) throws NoSuchAlgorithmException, KfsException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", getProvider().getProviderName());
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(keyGenerateParam.getAlias(), keyGenerateParam.getPurpose().getValue()).setAttestationChallenge(getProvider().getName().getBytes(StandardCharsets.UTF_8)).setSignaturePaddings("PKCS1", "PSS").setEncryptionPaddings("PKCS1Padding", "OAEPPadding").setDigests("SHA-256", "SHA-384", "SHA-512").setKeySize(keyGenerateParam.getKeyLen()).build());
            if (keyPairGenerator.generateKeyPair() != null) {
            } else {
                throw new KfsException("generate rsa key pair failed with bad key");
            }
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e) {
            StringBuilder sbA = f.a("generate rsa key pair failed, ");
            sbA.append(e.getMessage());
            throw new KfsException(sbA.toString());
        }
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.key.KeyStoreKeyManager
    public void validateKey(KeyGenerateParam keyGenerateParam) throws KfsException {
        if (KfsKeyPurpose.containsPurpose(keyGenerateParam.getPurpose(), KfsKeyPurpose.PURPOSE_CRYPTO)) {
            validateCrypto(new RSACipher.Builder(getProvider()).withAlg(CipherAlg.RSA_OAEP).withKeyStoreAlias(keyGenerateParam.getAlias()).build());
        }
        if (KfsKeyPurpose.containsPurpose(keyGenerateParam.getPurpose(), KfsKeyPurpose.PURPOSE_SIGN)) {
            validateSign(new RSASigner.Builder(getProvider()).withAlg(SignAlg.RSA_SHA256).withKeyStoreAlias(keyGenerateParam.getAlias()).build());
        }
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.key.KeyStoreKeyManager
    public void validateParam(KeyGenerateParam keyGenerateParam) throws KfsValidationException {
        if (isValidRsaKeyLen(keyGenerateParam.getKeyLen())) {
            throw new KfsValidationException("bad rsa key len");
        }
    }
}
