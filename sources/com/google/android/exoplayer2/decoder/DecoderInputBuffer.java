package com.google.android.exoplayer2.decoder;

import java.nio.ByteBuffer;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;

/* loaded from: classes2.dex */
public class DecoderInputBuffer extends Buffer {
    private final int bufferReplacementMode;
    public final CryptoInfo cryptoInfo = new CryptoInfo();
    public ByteBuffer data;
    public ByteBuffer supplementalData;
    public long timeUs;
    public boolean waitingForKeys;

    public static DecoderInputBuffer newFlagsOnlyInstance() {
        return new DecoderInputBuffer(0);
    }

    public DecoderInputBuffer(int bufferReplacementMode) {
        this.bufferReplacementMode = bufferReplacementMode;
    }

    public void resetSupplementalData(int length) {
        ByteBuffer byteBuffer = this.supplementalData;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            this.supplementalData = ByteBuffer.allocate(length);
        } else {
            this.supplementalData.clear();
        }
    }

    public void ensureSpaceForWrite(int length) {
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null) {
            this.data = createReplacementByteBuffer(length);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = this.data.position();
        int i = length + iPosition;
        if (iCapacity >= i) {
            return;
        }
        ByteBuffer byteBufferCreateReplacementByteBuffer = createReplacementByteBuffer(i);
        byteBufferCreateReplacementByteBuffer.order(this.data.order());
        if (iPosition > 0) {
            this.data.flip();
            byteBufferCreateReplacementByteBuffer.put(this.data);
        }
        this.data = byteBufferCreateReplacementByteBuffer;
    }

    public final boolean isFlagsOnly() {
        return this.data == null && this.bufferReplacementMode == 0;
    }

    public final boolean isEncrypted() {
        return getFlag(pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH);
    }

    public final void flip() {
        this.data.flip();
        ByteBuffer byteBuffer = this.supplementalData;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Buffer
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.supplementalData;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.waitingForKeys = false;
    }

    private ByteBuffer createReplacementByteBuffer(int requiredCapacity) {
        int i = this.bufferReplacementMode;
        if (i == 1) {
            return ByteBuffer.allocate(requiredCapacity);
        }
        if (i == 2) {
            return ByteBuffer.allocateDirect(requiredCapacity);
        }
        ByteBuffer byteBuffer = this.data;
        throw new IllegalStateException("Buffer too small (" + (byteBuffer == null ? 0 : byteBuffer.capacity()) + " < " + requiredCapacity + ")");
    }
}
