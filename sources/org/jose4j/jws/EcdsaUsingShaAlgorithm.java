package org.jose4j.jws;

import java.io.IOException;
import java.math.BigInteger;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.interfaces.ECKey;
import kotlin.KotlinVersion;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.CryptoPrimitive;
import org.jose4j.keys.BigEndianBigInteger;
import org.jose4j.keys.EllipticCurves;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.InvalidKeyException;
import org.jose4j.lang.JoseException;
import org.pjsip.pjsua2.pjsip_transport_type_e;

/* loaded from: classes4.dex */
public class EcdsaUsingShaAlgorithm extends BaseSignatureAlgorithm implements JsonWebSignatureAlgorithm {
    private final String curveName;
    private final int signatureByteLength;

    public EcdsaUsingShaAlgorithm(String str, String str2, String str3, int i) {
        super(str, str2, "EC");
        this.curveName = str3;
        this.signatureByteLength = i;
    }

    @Override // org.jose4j.jws.BaseSignatureAlgorithm, org.jose4j.jws.JsonWebSignatureAlgorithm
    public boolean verifySignature(byte[] bArr, Key key, byte[] bArr2, ProviderContext providerContext) throws JoseException {
        if (bArr.length > this.signatureByteLength) {
            return false;
        }
        BigInteger bigIntegerFromBytes = BigEndianBigInteger.fromBytes(ByteUtil.leftHalf(bArr));
        BigInteger bigIntegerFromBytes2 = BigEndianBigInteger.fromBytes(ByteUtil.rightHalf(bArr));
        BigInteger order = EllipticCurves.getSpec(this.curveName).getOrder();
        BigInteger bigIntegerMod = bigIntegerFromBytes.mod(order);
        BigInteger bigInteger = BigInteger.ZERO;
        if (bigIntegerMod.equals(bigInteger) || bigIntegerFromBytes2.mod(order).equals(bigInteger)) {
            return false;
        }
        try {
            return super.verifySignature(convertConcatenatedToDer(bArr), key, bArr2, providerContext);
        } catch (IOException e) {
            throw new JoseException("Unable to convert R and S as a concatenated byte array to DER encoding.", e);
        }
    }

    @Override // org.jose4j.jws.BaseSignatureAlgorithm, org.jose4j.jws.JsonWebSignatureAlgorithm
    public byte[] sign(CryptoPrimitive cryptoPrimitive, byte[] bArr) throws SignatureException, JoseException {
        try {
            return convertDerToConcatenated(super.sign(cryptoPrimitive, bArr), this.signatureByteLength);
        } catch (IOException e) {
            throw new JoseException("Unable to convert DER encoding to R and S as a concatenated byte array.", e);
        }
    }

    public static byte[] convertConcatenatedToDer(byte[] bArr) throws IOException {
        int i;
        byte[] bArr2;
        int length = bArr.length / 2;
        int i2 = length;
        while (true) {
            i = 1;
            if (i2 <= 1 || bArr[length - i2] != 0) {
                break;
            }
            i2--;
        }
        int i3 = length - i2;
        int i4 = bArr[i3] < 0 ? i2 + 1 : i2;
        int i5 = length;
        while (i5 > 1 && bArr[(length * 2) - i5] == 0) {
            i5--;
        }
        int i6 = (length * 2) - i5;
        int i7 = bArr[i6] < 0 ? i5 + 1 : i5;
        int i8 = i4 + 4 + i7;
        if (i8 > 255) {
            throw new IOException("Invalid format of ECDSA signature");
        }
        if (i8 < 128) {
            bArr2 = new byte[i4 + 6 + i7];
        } else {
            bArr2 = new byte[i4 + 7 + i7];
            bArr2[1] = -127;
            i = 2;
        }
        bArr2[0] = 48;
        bArr2[i] = (byte) i8;
        bArr2[i + 1] = 2;
        bArr2[i + 2] = (byte) i4;
        int i9 = i + 3 + i4;
        System.arraycopy(bArr, i3, bArr2, i9 - i2, i2);
        bArr2[i9] = 2;
        bArr2[i9 + 1] = (byte) i7;
        System.arraycopy(bArr, i6, bArr2, ((i9 + 2) + i7) - i5, i5);
        return bArr2;
    }

    public static byte[] convertDerToConcatenated(byte[] bArr, int i) throws IOException {
        int i2;
        if (bArr.length < 8 || bArr[0] != 48) {
            throw new IOException("Invalid format of ECDSA signature");
        }
        byte b = bArr[1];
        if (b > 0) {
            i2 = 2;
        } else {
            if (b != -127) {
                throw new IOException("Invalid format of ECDSA signature");
            }
            i2 = 3;
        }
        int i3 = bArr[i2 + 1];
        int i4 = i3;
        while (i4 > 0 && bArr[((i2 + 2) + i3) - i4] == 0) {
            i4--;
        }
        int i5 = i2 + 2 + i3;
        int i6 = bArr[i5 + 1];
        int i7 = i6;
        while (i7 > 0 && bArr[((i5 + 2) + i6) - i7] == 0) {
            i7--;
        }
        int iMax = Math.max(Math.max(i4, i7), i / 2);
        int i8 = bArr[i2 - 1];
        if ((i8 & KotlinVersion.MAX_COMPONENT_VALUE) != bArr.length - i2 || (i8 & KotlinVersion.MAX_COMPONENT_VALUE) != i3 + 4 + i6 || bArr[i2] != 2 || bArr[i5] != 2) {
            throw new IOException("Invalid format of ECDSA signature");
        }
        int i9 = iMax * 2;
        byte[] bArr2 = new byte[i9];
        System.arraycopy(bArr, i5 - i4, bArr2, iMax - i4, i4);
        System.arraycopy(bArr, ((i5 + 2) + i6) - i7, bArr2, i9 - i7, i7);
        return bArr2;
    }

    @Override // org.jose4j.jws.BaseSignatureAlgorithm
    public void validatePrivateKey(PrivateKey privateKey) throws InvalidKeyException {
        validateKeySpec(privateKey);
    }

    @Override // org.jose4j.jws.BaseSignatureAlgorithm
    public void validatePublicKey(PublicKey publicKey) throws InvalidKeyException {
        validateKeySpec(publicKey);
    }

    private void validateKeySpec(Key key) throws InvalidKeyException {
        if (key instanceof ECKey) {
            String name = EllipticCurves.getName(((ECKey) key).getParams().getCurve());
            if (getCurveName().equals(name)) {
                return;
            }
            throw new InvalidKeyException(getAlgorithmIdentifier() + "/" + getJavaAlgorithm() + " expects a key using " + getCurveName() + " but was " + name);
        }
    }

    public String getCurveName() {
        return this.curveName;
    }

    public static class EcdsaP256UsingSha256 extends EcdsaUsingShaAlgorithm {
        public EcdsaP256UsingSha256() {
            super("ES256", "SHA256withECDSA", "P-256", 64);
        }
    }

    public static class EcdsaP384UsingSha384 extends EcdsaUsingShaAlgorithm {
        public EcdsaP384UsingSha384() {
            super("ES384", "SHA384withECDSA", "P-384", 96);
        }
    }

    public static class EcdsaP521UsingSha512 extends EcdsaUsingShaAlgorithm {
        public EcdsaP521UsingSha512() {
            super("ES512", "SHA512withECDSA", "P-521", pjsip_transport_type_e.PJSIP_TRANSPORT_DTLS6);
        }
    }
}
