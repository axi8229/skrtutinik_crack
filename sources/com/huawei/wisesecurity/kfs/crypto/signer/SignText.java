package com.huawei.wisesecurity.kfs.crypto.signer;

import com.huawei.wisesecurity.kfs.util.ByteUtil;

/* loaded from: classes3.dex */
public class SignText {
    private SignAlg algId = SignAlg.UNKNOWN;
    private byte[] dataBytes;
    private byte[] signature;

    public SignAlg getAlgId() {
        return this.algId;
    }

    public byte[] getDataBytes() {
        return ByteUtil.clone(this.dataBytes);
    }

    public byte[] getSignature() {
        return ByteUtil.clone(this.signature);
    }

    public void setAlgId(SignAlg signAlg) {
        this.algId = signAlg;
    }

    public void setDataBytes(byte[] bArr) {
        this.dataBytes = ByteUtil.clone(bArr);
    }

    public void setSignature(byte[] bArr) {
        this.signature = ByteUtil.clone(bArr);
    }
}
