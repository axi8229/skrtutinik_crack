package com.google.crypto.tink.signature;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.PrivateKey;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.util.Bytes;

@Alpha
/* loaded from: classes2.dex */
public abstract class SignaturePrivateKey extends Key implements PrivateKey {
    @Override // com.google.crypto.tink.PrivateKey
    public abstract SignaturePublicKey getPublicKey();

    public final Bytes getOutputPrefix() {
        return getPublicKey().getOutputPrefix();
    }

    @Override // com.google.crypto.tink.Key
    public Integer getIdRequirementOrNull() {
        return getPublicKey().getIdRequirementOrNull();
    }

    @Override // com.google.crypto.tink.Key
    public SignatureParameters getParameters() {
        return getPublicKey().getParameters();
    }
}
