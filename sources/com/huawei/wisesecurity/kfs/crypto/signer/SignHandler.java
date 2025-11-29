package com.huawei.wisesecurity.kfs.crypto.signer;

import com.huawei.wisesecurity.kfs.exception.CryptoException;

/* loaded from: classes3.dex */
public interface SignHandler {
    SignHandler from(String str) throws CryptoException;

    SignHandler from(byte[] bArr) throws CryptoException;

    byte[] sign() throws CryptoException;
}
