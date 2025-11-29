package com.google.crypto.tink.tinkkey;

@Deprecated
/* loaded from: classes2.dex */
public final class SecretKeyAccess {
    private SecretKeyAccess() {
    }

    public static KeyAccess insecureSecretAccess() {
        return KeyAccess.secretAccess();
    }
}
