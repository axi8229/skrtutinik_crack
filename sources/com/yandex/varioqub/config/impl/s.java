package com.yandex.varioqub.config.impl;

import com.yandex.varioqub.protobuf.nano.CodedInputByteBufferNano;
import com.yandex.varioqub.protobuf.nano.CodedOutputByteBufferNano;
import com.yandex.varioqub.protobuf.nano.MessageNano;
import com.yandex.varioqub.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class s extends MessageNano {
    public static volatile s[] d;
    public String a;
    public long b;
    public boolean c;

    public s() {
        a();
    }

    public final void a() {
        this.a = "";
        this.b = 0L;
        this.c = false;
        this.cachedSize = -1;
    }

    @Override // com.yandex.varioqub.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.a.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
        }
        long j = this.b;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
        }
        boolean z = this.c;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z) : iComputeSerializedSize;
    }

    @Override // com.yandex.varioqub.protobuf.nano.MessageNano
    public final MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
            if (tag == 10) {
                this.a = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.b = codedInputByteBufferNano.readInt64();
            } else if (tag == 24) {
                this.c = codedInputByteBufferNano.readBool();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                break;
            }
        }
        return this;
    }

    @Override // com.yandex.varioqub.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.a);
        }
        long j = this.b;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(2, j);
        }
        boolean z = this.c;
        if (z) {
            codedOutputByteBufferNano.writeBool(3, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
