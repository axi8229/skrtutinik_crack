package com.google.crypto.tink.aead.subtle;

import com.google.crypto.tink.Aead;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public interface AeadFactory {
    Aead createAead(final byte[] symmetricKey) throws GeneralSecurityException;

    int getKeySizeInBytes();
}
