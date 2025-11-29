package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.KotlinVersion;
import org.apache.commons.compress.PasswordRequiredException;

/* loaded from: classes4.dex */
class AES256SHA256Decoder extends CoderBase {
    AES256SHA256Decoder() {
        super(new Class[0]);
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    InputStream decode(final String str, final InputStream inputStream, long j, final Coder coder, final byte[] bArr, int i) throws IOException {
        return new InputStream() { // from class: org.apache.commons.compress.archivers.sevenz.AES256SHA256Decoder.1
            private CipherInputStream cipherInputStream;
            private boolean isInitialized;

            private CipherInputStream init() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
                byte[] bArrDigest;
                if (this.isInitialized) {
                    return this.cipherInputStream;
                }
                byte[] bArr2 = coder.properties;
                if (bArr2 == null) {
                    throw new IOException("Missing AES256 properties in " + str);
                }
                if (bArr2.length < 2) {
                    throw new IOException("AES256 properties too short in " + str);
                }
                int i2 = bArr2[0];
                int i3 = i2 & KotlinVersion.MAX_COMPONENT_VALUE;
                int i4 = i2 & 63;
                int i5 = bArr2[1];
                int i6 = ((i3 >> 6) & 1) + (i5 & 15);
                int i7 = ((i3 >> 7) & 1) + ((i5 & KotlinVersion.MAX_COMPONENT_VALUE) >> 4);
                int i8 = i7 + 2;
                if (i8 + i6 > bArr2.length) {
                    throw new IOException("Salt size + IV size too long in " + str);
                }
                byte[] bArr3 = new byte[i7];
                System.arraycopy(bArr2, 2, bArr3, 0, i7);
                byte[] bArr4 = new byte[16];
                System.arraycopy(coder.properties, i8, bArr4, 0, i6);
                if (bArr == null) {
                    throw new PasswordRequiredException(str);
                }
                if (i4 == 63) {
                    bArrDigest = new byte[32];
                    System.arraycopy(bArr3, 0, bArrDigest, 0, i7);
                    byte[] bArr5 = bArr;
                    System.arraycopy(bArr5, 0, bArrDigest, i7, Math.min(bArr5.length, 32 - i7));
                } else {
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                        byte[] bArr6 = new byte[8];
                        for (long j2 = 0; j2 < (1 << i4); j2++) {
                            messageDigest.update(bArr3);
                            messageDigest.update(bArr);
                            messageDigest.update(bArr6);
                            for (int i9 = 0; i9 < 8; i9++) {
                                byte b = (byte) (bArr6[i9] + 1);
                                bArr6[i9] = b;
                                if (b != 0) {
                                    break;
                                }
                            }
                        }
                        bArrDigest = messageDigest.digest();
                    } catch (NoSuchAlgorithmException e) {
                        throw new IOException("SHA-256 is unsupported by your Java implementation", e);
                    }
                }
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArrDigest, "AES");
                try {
                    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                    cipher.init(2, secretKeySpec, new IvParameterSpec(bArr4));
                    CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
                    this.cipherInputStream = cipherInputStream;
                    this.isInitialized = true;
                    return cipherInputStream;
                } catch (GeneralSecurityException e2) {
                    throw new IOException("Decryption error (do you have the JCE Unlimited Strength Jurisdiction Policy Files installed?)", e2);
                }
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                return init().read();
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr2, int i2, int i3) throws IOException {
                return init().read(bArr2, i2, i3);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                CipherInputStream cipherInputStream = this.cipherInputStream;
                if (cipherInputStream != null) {
                    cipherInputStream.close();
                }
            }
        };
    }
}
