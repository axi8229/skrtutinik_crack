package com.google.crypto.tink.jwt;

import java.security.GeneralSecurityException;
import java.util.Optional;

/* loaded from: classes2.dex */
interface JwtMacInternal {
    String computeMacAndEncodeWithKid(RawJwt token, Optional<String> kid) throws GeneralSecurityException;

    VerifiedJwt verifyMacAndDecodeWithKid(String compact, JwtValidator validator, Optional<String> kid) throws GeneralSecurityException;
}
