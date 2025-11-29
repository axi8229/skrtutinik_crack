package com.google.crypto.tink.signature;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.annotations.Alpha;
import com.google.crypto.tink.util.Bytes;

@Alpha
/* loaded from: classes2.dex */
public abstract class SignaturePublicKey extends Key {
    public abstract Bytes getOutputPrefix();

    @Override // com.google.crypto.tink.Key
    public abstract SignatureParameters getParameters();
}
