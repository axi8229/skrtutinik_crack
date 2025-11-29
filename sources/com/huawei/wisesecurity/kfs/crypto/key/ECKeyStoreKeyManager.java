package com.huawei.wisesecurity.kfs.crypto.key;

import android.annotation.SuppressLint;
import android.security.keystore.KeyGenParameterSpec;
import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;
import com.huawei.wisesecurity.kfs.crypto.signer.ec.ECSigner;
import com.huawei.wisesecurity.kfs.exception.KfsException;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.ucs_credential.e;
import com.huawei.wisesecurity.ucs_credential.f;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.ProviderException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;

/* loaded from: classes3.dex */
public class ECKeyStoreKeyManager extends KeyStoreKeyManager {
    private static final AlgorithmParameterSpec EC_PRIME256_PARAMETER_SPEC = new ECGenParameterSpec("secp256r1");

    public ECKeyStoreKeyManager(KeyStoreProvider keyStoreProvider) {
        super(keyStoreProvider);
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.key.KeyStoreKeyManager
    @SuppressLint({"WrongConstant"})
    public void generateKey(KeyGenerateParam keyGenerateParam) throws NoSuchAlgorithmException, KfsException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC", getProvider().getProviderName());
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(keyGenerateParam.getAlias(), keyGenerateParam.getPurpose().getValue()).setAttestationChallenge(keyGenerateParam.isAttestationChallengeEnable() ? getProvider().getName().getBytes(StandardCharsets.UTF_8) : null).setDigests("SHA-256", "SHA-384", "SHA-512").setAlgorithmParameterSpec(EC_PRIME256_PARAMETER_SPEC).setKeySize(keyGenerateParam.getKeyLen()).build());
            if (keyPairGenerator.generateKeyPair() != null) {
            } else {
                throw new KfsException("generate ec key pair failed with bad key");
            }
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            throw new KfsException(e.a(e, f.a("generate ec key pair failed, ")));
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new KfsException(e.a(e, f.a("generate ec key pair failed, ")));
        } catch (NoSuchProviderException e3) {
            e = e3;
            throw new KfsException(e.a(e, f.a("generate ec key pair failed, ")));
        } catch (ProviderException e4) {
            e = e4;
            throw new KfsException(e.a(e, f.a("generate ec key pair failed, ")));
        }
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.key.KeyStoreKeyManager
    public void validateKey(KeyGenerateParam keyGenerateParam) throws KfsException {
        validateSign(new ECSigner.Builder(getProvider()).withAlg(SignAlg.ECDSA).withKeyStoreAlias(keyGenerateParam.getAlias()).build());
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.key.KeyStoreKeyManager
    public void validateParam(KeyGenerateParam keyGenerateParam) throws KfsValidationException {
        if (keyGenerateParam.getKeyLen() != 256) {
            throw new KfsValidationException("bad ec key len, only ec prime 256 is supported");
        }
        if (keyGenerateParam.getPurpose() != KfsKeyPurpose.PURPOSE_SIGN) {
            throw new KfsValidationException("bad purpose for ec key, only sign is supported");
        }
    }
}
