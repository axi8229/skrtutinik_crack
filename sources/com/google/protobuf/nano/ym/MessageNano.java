package com.google.protobuf.nano.ym;

import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class MessageNano {
    protected volatile int cachedSize = -1;

    public static final MessageNano mergeFrom(MessageNano messageNano, byte[] bArr) {
        return mergeFrom(messageNano, bArr, 0, bArr.length);
    }

    public static final MessageNano mergeFrom(MessageNano messageNano, byte[] bArr, int i, int i2) throws InvalidProtocolBufferNanoException {
        try {
            CodedInputByteBufferNano codedInputByteBufferNanoNewInstance = CodedInputByteBufferNano.newInstance(bArr, i, i2);
            messageNano.mergeFrom(codedInputByteBufferNanoNewInstance);
            codedInputByteBufferNanoNewInstance.checkLastTagWas(0);
            return messageNano;
        } catch (InvalidProtocolBufferNanoException e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final void toByteArray(MessageNano messageNano, byte[] bArr, int i, int i2) {
        try {
            CodedOutputByteBufferNano codedOutputByteBufferNanoNewInstance = CodedOutputByteBufferNano.newInstance(bArr, i, i2);
            messageNano.writeTo(codedOutputByteBufferNanoNewInstance);
            codedOutputByteBufferNanoNewInstance.checkNoSpaceLeft();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final byte[] toByteArray(MessageNano messageNano) {
        int serializedSize = messageNano.getSerializedSize();
        byte[] bArr = new byte[serializedSize];
        toByteArray(messageNano, bArr, 0, serializedSize);
        return bArr;
    }

    protected int computeSerializedSize() {
        return 0;
    }

    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getSerializedSize() {
        int iComputeSerializedSize = computeSerializedSize();
        this.cachedSize = iComputeSerializedSize;
        return iComputeSerializedSize;
    }

    public abstract MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano);

    public String toString() {
        return MessageNanoPrinter.print(this);
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) {
    }
}
