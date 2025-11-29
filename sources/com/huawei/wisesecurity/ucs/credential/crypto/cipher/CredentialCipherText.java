package com.huawei.wisesecurity.ucs.credential.crypto.cipher;

import com.huawei.wisesecurity.kfs.util.ByteUtil;
import com.huawei.wisesecurity.ucs.common.exception.UcsParamException;

/* loaded from: classes3.dex */
public class CredentialCipherText {
    private CredentialCipherAlg algId;
    private byte[] cipherBytes;
    private byte[] iv;
    private byte[] plainBytes;

    public void checkParam(boolean z) throws UcsParamException {
        byte[] bArr = this.iv;
        if (bArr == null || (this.algId == CredentialCipherAlg.AES_GCM && bArr.length != 12)) {
            throw new UcsParamException("illegal iv param..");
        }
        if (z) {
            byte[] bArr2 = this.plainBytes;
            if (bArr2 == null || bArr2.length == 0) {
                throw new UcsParamException("plainBytes data can not be empty..");
            }
            return;
        }
        byte[] bArr3 = this.cipherBytes;
        if (bArr3 == null || bArr3.length == 0) {
            throw new UcsParamException("cipherBytes data can not be empty..");
        }
    }

    public int getAlgId() {
        return this.algId.getId();
    }

    public byte[] getCipherBytes() {
        return ByteUtil.clone(this.cipherBytes);
    }

    public byte[] getIv() {
        return ByteUtil.clone(this.iv);
    }

    public byte[] getPlainBytes() {
        return ByteUtil.clone(this.plainBytes);
    }

    public void setAlgId(CredentialCipherAlg credentialCipherAlg) {
        this.algId = credentialCipherAlg;
    }

    public void setCipherBytes(byte[] bArr) {
        this.cipherBytes = ByteUtil.clone(bArr);
    }

    public void setIv(byte[] bArr) {
        this.iv = ByteUtil.clone(bArr);
    }

    public void setPlainBytes(byte[] bArr) {
        this.plainBytes = ByteUtil.clone(bArr);
    }
}
