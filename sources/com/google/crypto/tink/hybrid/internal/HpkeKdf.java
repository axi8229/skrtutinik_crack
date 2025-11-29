package com.google.crypto.tink.hybrid.internal;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
interface HpkeKdf {
    byte[] extractAndExpand(byte[] salt, byte[] ikm, String ikmLabel, byte[] info, String infoLabel, byte[] suiteId, int length) throws GeneralSecurityException;

    byte[] getKdfId() throws GeneralSecurityException;

    byte[] labeledExpand(byte[] prk, byte[] info, String infoLabel, byte[] suiteId, int length) throws GeneralSecurityException;

    byte[] labeledExtract(byte[] salt, byte[] ikm, String ikmLabel, byte[] suiteId) throws GeneralSecurityException;
}
