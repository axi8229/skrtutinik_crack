package com.google.crypto.tink.util;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.annotations.Alpha;
import java.math.BigInteger;
import java.security.MessageDigest;

@Alpha
/* loaded from: classes2.dex */
public final class SecretBigInteger {
    private final BigInteger value;

    private SecretBigInteger(BigInteger value) {
        this.value = value;
    }

    public static SecretBigInteger fromBigInteger(BigInteger value, SecretKeyAccess access) {
        if (access == null) {
            throw new NullPointerException("SecretKeyAccess required");
        }
        return new SecretBigInteger(value);
    }

    public BigInteger getBigInteger(SecretKeyAccess access) {
        if (access == null) {
            throw new NullPointerException("SecretKeyAccess required");
        }
        return this.value;
    }

    public boolean equalsSecretBigInteger(SecretBigInteger other) {
        return MessageDigest.isEqual(this.value.toByteArray(), other.value.toByteArray());
    }
}
