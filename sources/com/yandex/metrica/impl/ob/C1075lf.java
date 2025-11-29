package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import java.io.IOException;

/* renamed from: com.yandex.metrica.impl.ob.lf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1075lf extends MessageNano {
    private static volatile C1075lf[] f;
    public String a;
    public String b;
    public C1025jf[] c;
    public C1075lf d;
    public C1075lf[] e;

    public C1075lf() {
        a();
    }

    public C1075lf a() {
        this.a = "";
        this.b = "";
        this.c = C1025jf.b();
        this.d = null;
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (f == null) {
                        f = new C1075lf[0];
                    }
                } finally {
                }
            }
        }
        this.e = f;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.a);
        if (!this.b.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        C1025jf[] c1025jfArr = this.c;
        int i = 0;
        if (c1025jfArr != null && c1025jfArr.length > 0) {
            int i2 = 0;
            while (true) {
                C1025jf[] c1025jfArr2 = this.c;
                if (i2 >= c1025jfArr2.length) {
                    break;
                }
                C1025jf c1025jf = c1025jfArr2[i2];
                if (c1025jf != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c1025jf);
                }
                i2++;
            }
        }
        C1075lf c1075lf = this.d;
        if (c1075lf != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c1075lf);
        }
        C1075lf[] c1075lfArr = this.e;
        if (c1075lfArr != null && c1075lfArr.length > 0) {
            while (true) {
                C1075lf[] c1075lfArr2 = this.e;
                if (i >= c1075lfArr2.length) {
                    break;
                }
                C1075lf c1075lf2 = c1075lfArr2[i];
                if (c1075lf2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c1075lf2);
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
                this.a = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C1025jf[] c1025jfArr = this.c;
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
                this.c = c1025jfArr2;
            } else if (tag == 34) {
                if (this.d == null) {
                    this.d = new C1075lf();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (tag == 42) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                C1075lf[] c1075lfArr = this.e;
                int length2 = c1075lfArr == null ? 0 : c1075lfArr.length;
                int i2 = repeatedFieldArrayLength2 + length2;
                C1075lf[] c1075lfArr2 = new C1075lf[i2];
                if (length2 != 0) {
                    System.arraycopy(c1075lfArr, 0, c1075lfArr2, 0, length2);
                }
                while (length2 < i2 - 1) {
                    C1075lf c1075lf = new C1075lf();
                    c1075lfArr2[length2] = c1075lf;
                    codedInputByteBufferNano.readMessage(c1075lf);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                C1075lf c1075lf2 = new C1075lf();
                c1075lfArr2[length2] = c1075lf2;
                codedInputByteBufferNano.readMessage(c1075lf2);
                this.e = c1075lfArr2;
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                break;
            }
        }
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.a);
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        C1025jf[] c1025jfArr = this.c;
        int i = 0;
        if (c1025jfArr != null && c1025jfArr.length > 0) {
            int i2 = 0;
            while (true) {
                C1025jf[] c1025jfArr2 = this.c;
                if (i2 >= c1025jfArr2.length) {
                    break;
                }
                C1025jf c1025jf = c1025jfArr2[i2];
                if (c1025jf != null) {
                    codedOutputByteBufferNano.writeMessage(3, c1025jf);
                }
                i2++;
            }
        }
        C1075lf c1075lf = this.d;
        if (c1075lf != null) {
            codedOutputByteBufferNano.writeMessage(4, c1075lf);
        }
        C1075lf[] c1075lfArr = this.e;
        if (c1075lfArr != null && c1075lfArr.length > 0) {
            while (true) {
                C1075lf[] c1075lfArr2 = this.e;
                if (i >= c1075lfArr2.length) {
                    break;
                }
                C1075lf c1075lf2 = c1075lfArr2[i];
                if (c1075lf2 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c1075lf2);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
