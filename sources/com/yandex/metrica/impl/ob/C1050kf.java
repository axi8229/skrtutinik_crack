package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import java.io.IOException;

/* renamed from: com.yandex.metrica.impl.ob.kf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1050kf extends MessageNano {
    private static volatile C1050kf[] g;
    public String a;
    public int b;
    public long c;
    public String d;
    public int e;
    public C1025jf[] f;

    public C1050kf() {
        a();
    }

    public static C1050kf[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (g == null) {
                        g = new C1050kf[0];
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public C1050kf a() {
        this.a = "";
        this.b = 0;
        this.c = 0L;
        this.d = "";
        this.e = 0;
        this.f = C1025jf.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.a) + CodedOutputByteBufferNano.computeSInt32Size(2, this.b) + CodedOutputByteBufferNano.computeSInt64Size(3, this.c);
        if (!this.d.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.d);
        }
        int i = this.e;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i);
        }
        C1025jf[] c1025jfArr = this.f;
        if (c1025jfArr != null && c1025jfArr.length > 0) {
            int i2 = 0;
            while (true) {
                C1025jf[] c1025jfArr2 = this.f;
                if (i2 >= c1025jfArr2.length) {
                    break;
                }
                C1025jf c1025jf = c1025jfArr2[i2];
                if (c1025jf != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, c1025jf);
                }
                i2++;
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
                this.a = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.b = codedInputByteBufferNano.readSInt32();
            } else if (tag == 24) {
                this.c = codedInputByteBufferNano.readSInt64();
            } else if (tag == 34) {
                this.d = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                this.e = codedInputByteBufferNano.readUInt32();
            } else if (tag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                C1025jf[] c1025jfArr = this.f;
                int length = c1025jfArr == null ? 0 : c1025jfArr.length;
                int i = repeatedFieldArrayLength + length;
                C1025jf[] c1025jfArr2 = new C1025jf[i];
                if (length != 0) {
                    System.arraycopy(c1025jfArr, 0, c1025jfArr2, 0, length);
                }
                while (length < i - 1) {
                    C1025jf c1025jf = new C1025jf();
                    c1025jfArr2[length] = c1025jf;
                    codedInputByteBufferNano.readMessage(c1025jf);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C1025jf c1025jf2 = new C1025jf();
                c1025jfArr2[length] = c1025jf2;
                codedInputByteBufferNano.readMessage(c1025jf2);
                this.f = c1025jfArr2;
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                break;
            }
        }
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.a);
        codedOutputByteBufferNano.writeSInt32(2, this.b);
        codedOutputByteBufferNano.writeSInt64(3, this.c);
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.d);
        }
        int i = this.e;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i);
        }
        C1025jf[] c1025jfArr = this.f;
        if (c1025jfArr != null && c1025jfArr.length > 0) {
            int i2 = 0;
            while (true) {
                C1025jf[] c1025jfArr2 = this.f;
                if (i2 >= c1025jfArr2.length) {
                    break;
                }
                C1025jf c1025jf = c1025jfArr2[i2];
                if (c1025jf != null) {
                    codedOutputByteBufferNano.writeMessage(6, c1025jf);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
