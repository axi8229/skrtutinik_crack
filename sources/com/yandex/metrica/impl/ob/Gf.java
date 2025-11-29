package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class Gf extends MessageNano {
    public Hf[] a;

    public Gf() {
        a();
    }

    public Gf a() {
        this.a = Hf.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        Hf[] hfArr = this.a;
        if (hfArr != null && hfArr.length > 0) {
            int i = 0;
            while (true) {
                Hf[] hfArr2 = this.a;
                if (i >= hfArr2.length) {
                    break;
                }
                Hf hf = hfArr2[i];
                if (hf != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, hf);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                Hf[] hfArr = this.a;
                int length = hfArr == null ? 0 : hfArr.length;
                int i = repeatedFieldArrayLength + length;
                Hf[] hfArr2 = new Hf[i];
                if (length != 0) {
                    System.arraycopy(hfArr, 0, hfArr2, 0, length);
                }
                while (length < i - 1) {
                    Hf hf = new Hf();
                    hfArr2[length] = hf;
                    codedInputByteBufferNano.readMessage(hf);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Hf hf2 = new Hf();
                hfArr2[length] = hf2;
                codedInputByteBufferNano.readMessage(hf2);
                this.a = hfArr2;
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                break;
            }
        }
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Hf[] hfArr = this.a;
        if (hfArr != null && hfArr.length > 0) {
            int i = 0;
            while (true) {
                Hf[] hfArr2 = this.a;
                if (i >= hfArr2.length) {
                    break;
                }
                Hf hf = hfArr2[i];
                if (hf != null) {
                    codedOutputByteBufferNano.writeMessage(1, hf);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
