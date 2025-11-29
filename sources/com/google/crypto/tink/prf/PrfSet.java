package com.google.crypto.tink.prf;

import java.security.GeneralSecurityException;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class PrfSet {
    public abstract Map<Integer, Prf> getPrfs() throws GeneralSecurityException;

    public abstract int getPrimaryId();

    public byte[] computePrimary(byte[] input, int outputLength) throws GeneralSecurityException {
        return getPrfs().get(Integer.valueOf(getPrimaryId())).compute(input, outputLength);
    }
}
