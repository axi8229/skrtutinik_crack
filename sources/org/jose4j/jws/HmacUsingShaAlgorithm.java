package org.jose4j.jws;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmInfo;
import org.jose4j.jwa.CryptoPrimitive;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;
import org.jose4j.mac.MacUtil;
import ru.yoomoney.sdk.auth.utils.CipherChaCha20Poly1305Kt;

/* loaded from: classes4.dex */
public class HmacUsingShaAlgorithm extends AlgorithmInfo implements JsonWebSignatureAlgorithm {
    private int minimumKeyLength;

    public HmacUsingShaAlgorithm(String str, String str2, int i) {
        setAlgorithmIdentifier(str);
        setJavaAlgorithm(str2);
        setKeyPersuasion(KeyPersuasion.SYMMETRIC);
        setKeyType("oct");
        this.minimumKeyLength = i;
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public boolean verifySignature(byte[] bArr, Key key, byte[] bArr2, ProviderContext providerContext) throws JoseException {
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException(key.getClass() + " cannot be used for HMAC verification.");
        }
        return ByteUtil.secureEquals(bArr, getMacInstance(key, providerContext).doFinal(bArr2));
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public CryptoPrimitive prepareForSign(Key key, ProviderContext providerContext) throws JoseException {
        return new CryptoPrimitive(getMacInstance(key, providerContext));
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public byte[] sign(CryptoPrimitive cryptoPrimitive, byte[] bArr) throws JoseException {
        return cryptoPrimitive.getMac().doFinal(bArr);
    }

    private Mac getMacInstance(Key key, ProviderContext providerContext) throws JoseException {
        return MacUtil.getInitializedMac(getJavaAlgorithm(), key, providerContext.getSuppliedKeyProviderContext().getMacProvider());
    }

    void validateKey(Key key) throws InvalidKeyException {
        int iBitLength;
        if (key == null) {
            throw new InvalidKeyException("key is null");
        }
        if (key.getEncoded() == null || (iBitLength = ByteUtil.bitLength(key.getEncoded())) >= this.minimumKeyLength) {
            return;
        }
        throw new InvalidKeyException("A key of the same size as the hash output (i.e. " + this.minimumKeyLength + " bits for " + getAlgorithmIdentifier() + ") or larger MUST be used with the HMAC SHA algorithms but this key is only " + iBitLength + " bits");
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public void validateSigningKey(Key key) throws InvalidKeyException {
        validateKey(key);
    }

    @Override // org.jose4j.jws.JsonWebSignatureAlgorithm
    public void validateVerificationKey(Key key) throws InvalidKeyException {
        validateKey(key);
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() throws NoSuchAlgorithmException {
        try {
            Mac.getInstance(getJavaAlgorithm());
            return true;
        } catch (NoSuchAlgorithmException unused) {
            return false;
        }
    }

    public static class HmacSha256 extends HmacUsingShaAlgorithm {
        public HmacSha256() {
            super("HS256", CipherChaCha20Poly1305Kt.HASHING_ALGORITHM_HMAC_SHA_256, 256);
        }
    }

    public static class HmacSha384 extends HmacUsingShaAlgorithm {
        public HmacSha384() {
            super("HS384", "HmacSHA384", 384);
        }
    }

    public static class HmacSha512 extends HmacUsingShaAlgorithm {
        public HmacSha512() {
            super("HS512", "HmacSHA512", 512);
        }
    }
}
