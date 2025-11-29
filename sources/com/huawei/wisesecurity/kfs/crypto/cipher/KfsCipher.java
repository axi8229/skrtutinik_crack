package com.huawei.wisesecurity.kfs.crypto.cipher;

import com.huawei.wisesecurity.kfs.exception.CryptoException;

/* loaded from: classes3.dex */
public interface KfsCipher {
    DecryptHandler getDecryptHandler() throws CryptoException;

    EncryptHandler getEncryptHandler() throws CryptoException;
}
