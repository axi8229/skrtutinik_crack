package com.google.crypto.tink.jwt;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public interface JwtPublicKeyVerify {
    VerifiedJwt verifyAndDecode(String compact, JwtValidator validator) throws GeneralSecurityException;
}
