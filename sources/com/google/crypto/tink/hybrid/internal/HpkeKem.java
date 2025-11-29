package com.google.crypto.tink.hybrid.internal;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
interface HpkeKem {
    byte[] decapsulate(byte[] encapsulatedKey, HpkeKemPrivateKey recipientPrivateKey) throws GeneralSecurityException;

    HpkeKemEncapOutput encapsulate(byte[] recipientPublicKey) throws GeneralSecurityException;

    byte[] getKemId() throws GeneralSecurityException;
}
