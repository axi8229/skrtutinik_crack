package com.huawei.wisesecurity.kfs.crypto.key;

import android.annotation.SuppressLint;
import android.security.keystore.KeyGenParameterSpec;
import com.google.android.gms.stats.CodePackage;
import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;
import com.huawei.wisesecurity.kfs.crypto.cipher.aes.AESCipher;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.util.RandomUtil;
import com.huawei.wisesecurity.ucs_credential.f;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.KeyGenerator;

/* loaded from: classes3.dex */
public class AESKeyStoreKeyManager extends KeyStoreKeyManager {
    private boolean isValidAesKeyLen(int i) {
        return (i == 128 || i == 192 || i == 256) ? false : true;
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.key.KeyStoreKeyManager
    @SuppressLint({"WrongConstant"})
    public void generateKey(KeyGenerateParam keyGenerateParam) throws NoSuchAlgorithmException, KfsException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", getProvider().getProviderName());
            keyGenerator.init(new KeyGenParameterSpec.Builder(keyGenerateParam.getAlias(), keyGenerateParam.getPurpose().getValue()).setKeySize(keyGenerateParam.getKeyLen()).setAttestationChallenge(getProvider().getName().getBytes(StandardCharsets.UTF_8)).setRandomizedEncryptionRequired(false).setBlockModes(CodePackage.GCM, "CBC").setEncryptionPaddings("NoPadding", "PKCS7Padding").build());
            if (keyGenerator.generateKey() != null) {
            } else {
                throw new KfsException("generate aes key failed with bad key");
            }
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e) {
            StringBuilder sbA = f.a("generate aes key failed, ");
            sbA.append(e.getMessage());
            throw new KfsException(sbA.toString());
        }
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.key.KeyStoreKeyManager
    public void validateKey(KeyGenerateParam keyGenerateParam) throws KfsException {
        CipherAlg cipherAlg = CipherAlg.AES_GCM;
        validateCrypto(new AESCipher.Builder(getProvider()).withAlg(cipherAlg).withKeyStoreAlias(keyGenerateParam.getAlias()).withIv(RandomUtil.generateRandomBytes(cipherAlg.getIvLen())).build());
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.key.KeyStoreKeyManager
    public void validateParam(KeyGenerateParam keyGenerateParam) throws KfsValidationException {
        if (isValidAesKeyLen(keyGenerateParam.getKeyLen())) {
            throw new KfsValidationException("bad aes key len");
        }
        if (keyGenerateParam.getPurpose() != KfsKeyPurpose.PURPOSE_CRYPTO) {
            throw new KfsValidationException("bad purpose for aes key, only crypto is supported");
        }
    }
}
