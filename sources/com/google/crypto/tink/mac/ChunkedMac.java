package com.google.crypto.tink.mac;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public interface ChunkedMac {
    ChunkedMacComputation createComputation() throws GeneralSecurityException;

    ChunkedMacVerification createVerification(final byte[] tag) throws GeneralSecurityException;
}
