package com.huawei.wisesecurity.ucs.credential.crypto.cipher;

/* loaded from: classes3.dex */
public enum CredentialCipherAlg {
    AES_GCM(1);

    private int id;

    CredentialCipherAlg(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }
}
