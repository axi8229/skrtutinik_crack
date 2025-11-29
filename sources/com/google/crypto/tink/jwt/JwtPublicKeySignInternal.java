package com.google.crypto.tink.jwt;

import java.security.GeneralSecurityException;
import java.util.Optional;

/* loaded from: classes2.dex */
public interface JwtPublicKeySignInternal {
    String signAndEncodeWithKid(RawJwt token, Optional<String> kid) throws GeneralSecurityException;
}
