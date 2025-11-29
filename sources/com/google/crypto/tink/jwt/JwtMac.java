package com.google.crypto.tink.jwt;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public interface JwtMac {
    String computeMacAndEncode(RawJwt token) throws GeneralSecurityException;

    VerifiedJwt verifyMacAndDecode(String compact, JwtValidator validator) throws GeneralSecurityException;
}
