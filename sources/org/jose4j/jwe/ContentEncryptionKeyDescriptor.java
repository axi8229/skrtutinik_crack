package org.jose4j.jwe;

/* loaded from: classes4.dex */
public class ContentEncryptionKeyDescriptor {
    private final String contentEncryptionKeyAlgorithm;
    private final int contentEncryptionKeyByteLength;

    public ContentEncryptionKeyDescriptor(int i, String str) {
        this.contentEncryptionKeyByteLength = i;
        this.contentEncryptionKeyAlgorithm = str;
    }

    public int getContentEncryptionKeyByteLength() {
        return this.contentEncryptionKeyByteLength;
    }

    public String getContentEncryptionKeyAlgorithm() {
        return this.contentEncryptionKeyAlgorithm;
    }
}
