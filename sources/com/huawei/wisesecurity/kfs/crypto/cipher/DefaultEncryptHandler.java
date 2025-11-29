package com.huawei.wisesecurity.kfs.crypto.cipher;

import com.huawei.wisesecurity.kfs.crypto.key.KeyStoreProvider;
import com.huawei.wisesecurity.kfs.exception.CryptoException;
import com.huawei.wisesecurity.kfs.util.ByteUtil;
import com.huawei.wisesecurity.ucs_credential.f;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes3.dex */
public class DefaultEncryptHandler implements EncryptHandler {
    private final CipherText cipherText;
    private final Key key;
    private final AlgorithmParameterSpec parameterSpec;
    private final KeyStoreProvider provider;

    public DefaultEncryptHandler(KeyStoreProvider keyStoreProvider, Key key, CipherText cipherText, AlgorithmParameterSpec algorithmParameterSpec) {
        this.provider = keyStoreProvider;
        this.key = key;
        this.parameterSpec = algorithmParameterSpec;
        this.cipherText = cipherText;
    }

    private void doEncrypt() throws InvalidKeyException, CryptoException, InvalidAlgorithmParameterException {
        try {
            String transformation = this.cipherText.getAlgId().getTransformation();
            KeyStoreProvider keyStoreProvider = this.provider;
            Cipher cipher = keyStoreProvider == KeyStoreProvider.ANDROID_KEYSTORE ? Cipher.getInstance(transformation) : Cipher.getInstance(transformation, keyStoreProvider.getProviderName());
            cipher.init(1, this.key, this.parameterSpec);
            CipherText cipherText = this.cipherText;
            cipherText.setCipherBytes(cipher.doFinal(cipherText.getPlainBytes()));
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            StringBuilder sbA = f.a("Fail to encrypt: ");
            sbA.append(e.getMessage());
            throw new CryptoException(sbA.toString());
        } catch (InvalidKeyException e2) {
            e = e2;
            StringBuilder sbA2 = f.a("Fail to encrypt: ");
            sbA2.append(e.getMessage());
            throw new CryptoException(sbA2.toString());
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            StringBuilder sbA22 = f.a("Fail to encrypt: ");
            sbA22.append(e.getMessage());
            throw new CryptoException(sbA22.toString());
        } catch (NoSuchProviderException e4) {
            e = e4;
            StringBuilder sbA222 = f.a("Fail to encrypt: ");
            sbA222.append(e.getMessage());
            throw new CryptoException(sbA222.toString());
        } catch (BadPaddingException e5) {
            e = e5;
            StringBuilder sbA2222 = f.a("Fail to encrypt: ");
            sbA2222.append(e.getMessage());
            throw new CryptoException(sbA2222.toString());
        } catch (IllegalBlockSizeException e6) {
            e = e6;
            StringBuilder sbA22222 = f.a("Fail to encrypt: ");
            sbA22222.append(e.getMessage());
            throw new CryptoException(sbA22222.toString());
        } catch (NoSuchPaddingException e7) {
            e = e7;
            StringBuilder sbA222222 = f.a("Fail to encrypt: ");
            sbA222222.append(e.getMessage());
            throw new CryptoException(sbA222222.toString());
        }
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.cipher.EncryptHandler
    public DefaultEncryptHandler from(byte[] bArr) throws CryptoException {
        this.cipherText.setPlainBytes(ByteUtil.clone(bArr));
        return this;
    }

    @Override // com.huawei.wisesecurity.kfs.crypto.cipher.EncryptHandler
    public byte[] to() throws InvalidKeyException, CryptoException, InvalidAlgorithmParameterException {
        doEncrypt();
        return this.cipherText.getCipherBytes();
    }
}
