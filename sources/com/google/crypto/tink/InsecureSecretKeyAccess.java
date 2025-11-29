package com.google.crypto.tink;

import com.google.crypto.tink.annotations.Alpha;

@Alpha
/* loaded from: classes2.dex */
public final class InsecureSecretKeyAccess {
    private InsecureSecretKeyAccess() {
    }

    public static SecretKeyAccess get() {
        return SecretKeyAccess.instance();
    }
}
