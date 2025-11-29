package com.huawei.wisesecurity.kfs.crypto.signer;

import com.huawei.wisesecurity.kfs.exception.CryptoException;

/* loaded from: classes3.dex */
public interface KfsSigner {
    SignHandler getSignHandler() throws CryptoException;

    VerifyHandler getVerifyHandler() throws CryptoException;
}
