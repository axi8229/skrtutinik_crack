package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.util.Bytes;

/* loaded from: classes2.dex */
interface HpkeKemPrivateKey {
    Bytes getSerializedPrivate();

    Bytes getSerializedPublic();
}
