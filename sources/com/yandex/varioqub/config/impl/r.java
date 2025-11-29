package com.yandex.varioqub.config.impl;

import com.yandex.varioqub.protobuf.nano.CodedInputByteBufferNano;
import com.yandex.varioqub.protobuf.nano.CodedOutputByteBufferNano;
import com.yandex.varioqub.protobuf.nano.InternalNano;
import com.yandex.varioqub.protobuf.nano.MessageNano;
import com.yandex.varioqub.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class r extends MessageNano {
    public String a;
    public String b;
    public q[] c;
    public String d;

    public r() {
        a();
    }

    public final void a() {
        this.a = "";
        this.b = "";
        if (q.c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (q.c == null) {
                        q.c = new q[0];
                    }
                } finally {
                }
            }
        }
        this.c = q.c;
        this.d = "";
        this.cachedSize = -1;
    }

    @Override // com.yandex.varioqub.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.a.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
        }
        if (!this.b.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        q[] qVarArr = this.c;
        if (qVarArr != null && qVarArr.length > 0) {
            int i = 0;
            while (true) {
                q[] qVarArr2 = this.c;
                if (i >= qVarArr2.length) {
                    break;
                }
                q qVar = qVarArr2[i];
                if (qVar != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(3, qVar) + iComputeSerializedSize;
                }
                i++;
            }
        }
        return !this.d.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.d) : iComputeSerializedSize;
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
                this.b = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                q[] qVarArr = this.c;
                int length = qVarArr == null ? 0 : qVarArr.length;
                int i = repeatedFieldArrayLength + length;
                q[] qVarArr2 = new q[i];
                if (length != 0) {
                    System.arraycopy(qVarArr, 0, qVarArr2, 0, length);
                }
                while (length < i - 1) {
                    q qVar = new q();
                    qVarArr2[length] = qVar;
                    codedInputByteBufferNano.readMessage(qVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                q qVar2 = new q();
                qVarArr2[length] = qVar2;
                codedInputByteBufferNano.readMessage(qVar2);
                this.c = qVarArr2;
            } else if (tag == 34) {
                this.d = codedInputByteBufferNano.readString();
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
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        q[] qVarArr = this.c;
        if (qVarArr != null && qVarArr.length > 0) {
            int i = 0;
            while (true) {
                q[] qVarArr2 = this.c;
                if (i >= qVarArr2.length) {
                    break;
                }
                q qVar = qVarArr2[i];
                if (qVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, qVar);
                }
                i++;
            }
        }
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
