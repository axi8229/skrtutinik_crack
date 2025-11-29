package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import java.io.IOException;

/* renamed from: com.yandex.metrica.impl.ob.df, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0876df extends MessageNano {
    public C1050kf a;
    public C1050kf[] b;
    public String c;

    public C0876df() {
        a();
    }

    public C0876df a() {
        this.a = null;
        this.b = C1050kf.b();
        this.c = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C1050kf c1050kf = this.a;
        if (c1050kf != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c1050kf);
        }
        C1050kf[] c1050kfArr = this.b;
        if (c1050kfArr != null && c1050kfArr.length > 0) {
            int i = 0;
            while (true) {
                C1050kf[] c1050kfArr2 = this.b;
                if (i >= c1050kfArr2.length) {
                    break;
                }
                C1050kf c1050kf2 = c1050kfArr2[i];
                if (c1050kf2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c1050kf2);
                }
                i++;
            }
        }
        return !this.c.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.c) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
            if (tag == 10) {
                if (this.a == null) {
                    this.a = new C1050kf();
                }
                codedInputByteBufferNano.readMessage(this.a);
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C1050kf[] c1050kfArr = this.b;
                int length = c1050kfArr == null ? 0 : c1050kfArr.length;
                int i = repeatedFieldArrayLength + length;
                C1050kf[] c1050kfArr2 = new C1050kf[i];
                if (length != 0) {
                    System.arraycopy(c1050kfArr, 0, c1050kfArr2, 0, length);
                }
                while (length < i - 1) {
                    C1050kf c1050kf = new C1050kf();
                    c1050kfArr2[length] = c1050kf;
                    codedInputByteBufferNano.readMessage(c1050kf);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C1050kf c1050kf2 = new C1050kf();
                c1050kfArr2[length] = c1050kf2;
                codedInputByteBufferNano.readMessage(c1050kf2);
                this.b = c1050kfArr2;
            } else if (tag == 26) {
                this.c = codedInputByteBufferNano.readString();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                break;
            }
        }
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C1050kf c1050kf = this.a;
        if (c1050kf != null) {
            codedOutputByteBufferNano.writeMessage(1, c1050kf);
        }
        C1050kf[] c1050kfArr = this.b;
        if (c1050kfArr != null && c1050kfArr.length > 0) {
            int i = 0;
            while (true) {
                C1050kf[] c1050kfArr2 = this.b;
                if (i >= c1050kfArr2.length) {
                    break;
                }
                C1050kf c1050kf2 = c1050kfArr2[i];
                if (c1050kf2 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c1050kf2);
                }
                i++;
            }
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
