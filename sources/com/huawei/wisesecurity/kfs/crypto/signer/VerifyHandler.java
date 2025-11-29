package com.huawei.wisesecurity.kfs.crypto.signer;

import com.huawei.wisesecurity.kfs.exception.CryptoException;

/* loaded from: classes3.dex */
public interface VerifyHandler {
    VerifyHandler fromData(byte[] bArr) throws CryptoException;

    boolean verify(byte[] bArr) throws CryptoException;
}
