package com.google.crypto.tink.jwt;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public interface JwtPublicKeySign {
    String signAndEncode(RawJwt token) throws GeneralSecurityException;
}
