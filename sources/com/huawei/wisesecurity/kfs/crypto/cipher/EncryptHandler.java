package com.huawei.wisesecurity.kfs.crypto.cipher;

import com.huawei.wisesecurity.kfs.exception.CryptoException;

/* loaded from: classes3.dex */
public interface EncryptHandler {
    EncryptHandler from(byte[] bArr) throws CryptoException;

    byte[] to() throws CryptoException;
}
