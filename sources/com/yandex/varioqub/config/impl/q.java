package com.yandex.varioqub.config.impl;

import com.yandex.varioqub.protobuf.nano.CodedInputByteBufferNano;
import com.yandex.varioqub.protobuf.nano.CodedOutputByteBufferNano;
import com.yandex.varioqub.protobuf.nano.InternalNano;
import com.yandex.varioqub.protobuf.nano.MessageNano;
import com.yandex.varioqub.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class q extends MessageNano {
    public static volatile q[] c;
    public String a;
    public s[] b;

    public q() {
        a();
    }

    public final void a() {
        this.a = "";
        if (s.d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (s.d == null) {
                        s.d = new s[0];
                    }
                } finally {
                }
            }
        }
        this.b = s.d;
        this.cachedSize = -1;
    }

    @Override // com.yandex.varioqub.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.a.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
        }
        s[] sVarArr = this.b;
        if (sVarArr != null && sVarArr.length > 0) {
            int i = 0;
            while (true) {
                s[] sVarArr2 = this.b;
                if (i >= sVarArr2.length) {
                    break;
                }
                s sVar = sVarArr2[i];
                if (sVar != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, sVar) + iComputeSerializedSize;
                }
                i++;
            }
        }
        return iComputeSerializedSize;
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
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                s[] sVarArr = this.b;
                int length = sVarArr == null ? 0 : sVarArr.length;
                int i = repeatedFieldArrayLength + length;
                s[] sVarArr2 = new s[i];
                if (length != 0) {
                    System.arraycopy(sVarArr, 0, sVarArr2, 0, length);
                }
                while (length < i - 1) {
                    s sVar = new s();
                    sVarArr2[length] = sVar;
                    codedInputByteBufferNano.readMessage(sVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                s sVar2 = new s();
                sVarArr2[length] = sVar2;
                codedInputByteBufferNano.readMessage(sVar2);
                this.b = sVarArr2;
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
        s[] sVarArr = this.b;
        if (sVarArr != null && sVarArr.length > 0) {
            int i = 0;
            while (true) {
                s[] sVarArr2 = this.b;
                if (i >= sVarArr2.length) {
                    break;
                }
                s sVar = sVarArr2[i];
                if (sVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, sVar);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
