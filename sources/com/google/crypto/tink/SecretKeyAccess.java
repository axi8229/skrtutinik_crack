package com.google.crypto.tink;

import com.google.crypto.tink.annotations.Alpha;
import java.security.GeneralSecurityException;

@Alpha
/* loaded from: classes2.dex */
public final class SecretKeyAccess {
    private static final SecretKeyAccess INSTANCE = new SecretKeyAccess();

    private SecretKeyAccess() {
    }

    static SecretKeyAccess instance() {
        return INSTANCE;
    }

    public static SecretKeyAccess requireAccess(SecretKeyAccess access) throws GeneralSecurityException {
        if (access != null) {
            return access;
        }
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }
}
