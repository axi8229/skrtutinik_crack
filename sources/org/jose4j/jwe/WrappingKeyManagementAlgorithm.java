package org.jose4j.jwe;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwx.Headers;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.JoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes4.dex */
public abstract class WrappingKeyManagementAlgorithm extends AlgorithmInfo implements KeyManagementAlgorithm {
    private AlgorithmParameterSpec algorithmParameterSpec;
    protected final Logger log = LoggerFactory.getLogger(getClass());
    protected boolean useSuppliedKeyProviderContext = true;

    public WrappingKeyManagementAlgorithm(String str, String str2) {
        setJavaAlgorithm(str);
        setAlgorithmIdentifier(str2);
    }

    public void setAlgorithmParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
        this.algorithmParameterSpec = algorithmParameterSpec;
    }

    public ContentEncryptionKeys manageForEncrypt(Key key, ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor, Headers headers, byte[] bArr, ProviderContext providerContext) throws JoseException {
        if (bArr == null) {
            bArr = ByteUtil.randomBytes(contentEncryptionKeyDescriptor.getContentEncryptionKeyByteLength());
        }
        return manageForEnc(key, contentEncryptionKeyDescriptor, bArr, providerContext);
    }

    protected ContentEncryptionKeys manageForEnc(Key key, ContentEncryptionKeyDescriptor contentEncryptionKeyDescriptor, byte[] bArr, ProviderContext providerContext) throws JoseException {
        Cipher cipher = CipherUtil.getCipher(getJavaAlgorithm(), (this.useSuppliedKeyProviderContext ? providerContext.getSuppliedKeyProviderContext() : providerContext.getGeneralProviderContext()).getCipherProvider());
        try {
            initCipher(cipher, 3, key);
            return new ContentEncryptionKeys(bArr, cipher.wrap(new SecretKeySpec(bArr, contentEncryptionKeyDescriptor.getContentEncryptionKeyAlgorithm())));
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            throw new JoseException("Unable to encrypt (" + cipher.getAlgorithm() + ") the Content Encryption Key: " + e, e);
        } catch (InvalidKeyException e2) {
            throw new org.jose4j.lang.InvalidKeyException("Unable to encrypt (" + cipher.getAlgorithm() + ") the Content Encryption Key: " + e2, e2);
        } catch (IllegalBlockSizeException e3) {
            e = e3;
            throw new JoseException("Unable to encrypt (" + cipher.getAlgorithm() + ") the Content Encryption Key: " + e, e);
        }
    }

    void initCipher(Cipher cipher, int i, Key key) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec = this.algorithmParameterSpec;
        if (algorithmParameterSpec == null) {
            cipher.init(i, key);
        } else {
            cipher.init(i, key, algorithmParameterSpec);
        }
    }
}
