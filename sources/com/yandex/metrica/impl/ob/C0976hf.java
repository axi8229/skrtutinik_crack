package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.yandex.metrica.impl.ob.hf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0976hf extends MessageNano {
    private static byte[] l;
    private static volatile boolean m;
    public C1075lf a;
    public C0876df b;
    public String c;
    public int d;
    public C1025jf[] e;
    public String f;
    public int g;
    public a h;
    public byte[] i;
    public byte[] j;
    public C0926ff[] k;

    /* renamed from: com.yandex.metrica.impl.ob.hf$a */
    public static final class a extends MessageNano {
        public String a;

        public a() {
            a();
        }

        public a a() {
            this.a = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            return super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.a);
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
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            codedOutputByteBufferNano.writeString(1, this.a);
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public C0976hf() {
        if (!m) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (!m) {
                        l = InternalNano.bytesDefaultValue("JVM");
                        m = true;
                    }
                } finally {
                }
            }
        }
        a();
    }

    public C0976hf a() {
        this.a = null;
        this.b = null;
        this.c = "";
        this.d = -1;
        this.e = C1025jf.b();
        this.f = "";
        this.g = 0;
        this.h = null;
        this.i = (byte[]) l.clone();
        this.j = WireFormatNano.EMPTY_BYTES;
        this.k = C0926ff.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C1075lf c1075lf = this.a;
        if (c1075lf != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c1075lf);
        }
        C0876df c0876df = this.b;
        if (c0876df != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0876df);
        }
        if (!this.c.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        C1025jf[] c1025jfArr = this.e;
        int i2 = 0;
        if (c1025jfArr != null && c1025jfArr.length > 0) {
            int i3 = 0;
            while (true) {
                C1025jf[] c1025jfArr2 = this.e;
                if (i3 >= c1025jfArr2.length) {
                    break;
                }
                C1025jf c1025jf = c1025jfArr2[i3];
                if (c1025jf != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c1025jf);
                }
                i3++;
            }
        }
        if (!this.f.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f);
        }
        int i4 = this.g;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i4);
        }
        a aVar = this.h;
        if (aVar != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, aVar);
        }
        if (!Arrays.equals(this.i, l)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.i);
        }
        if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(10, this.j);
        }
        C0926ff[] c0926ffArr = this.k;
        if (c0926ffArr != null && c0926ffArr.length > 0) {
            while (true) {
                C0926ff[] c0926ffArr2 = this.k;
                if (i2 >= c0926ffArr2.length) {
                    break;
                }
                C0926ff c0926ff = c0926ffArr2[i2];
                if (c0926ff != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, c0926ff);
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
            switch (tag) {
                case 0:
                    break;
                case 10:
                    if (this.a == null) {
                        this.a = new C1075lf();
                    }
                    codedInputByteBufferNano.readMessage(this.a);
                    break;
                case 18:
                    if (this.b == null) {
                        this.b = new C0876df();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                    break;
                case 26:
                    this.c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != -1 && int32 != 0 && int32 != 1) {
                        break;
                    } else {
                        this.d = int32;
                        break;
                    }
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    C1025jf[] c1025jfArr = this.e;
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
                    this.e = c1025jfArr2;
                    break;
                case 50:
                    this.f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1) {
                        break;
                    } else {
                        this.g = int322;
                        break;
                    }
                case 66:
                    if (this.h == null) {
                        this.h = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.h);
                    break;
                case 74:
                    this.i = codedInputByteBufferNano.readBytes();
                    break;
                case 82:
                    this.j = codedInputByteBufferNano.readBytes();
                    break;
                case 90:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    C0926ff[] c0926ffArr = this.k;
                    int length2 = c0926ffArr == null ? 0 : c0926ffArr.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    C0926ff[] c0926ffArr2 = new C0926ff[i2];
                    if (length2 != 0) {
                        System.arraycopy(c0926ffArr, 0, c0926ffArr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        C0926ff c0926ff = new C0926ff();
                        c0926ffArr2[length2] = c0926ff;
                        codedInputByteBufferNano.readMessage(c0926ff);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    C0926ff c0926ff2 = new C0926ff();
                    c0926ffArr2[length2] = c0926ff2;
                    codedInputByteBufferNano.readMessage(c0926ff2);
                    this.k = c0926ffArr2;
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C1075lf c1075lf = this.a;
        if (c1075lf != null) {
            codedOutputByteBufferNano.writeMessage(1, c1075lf);
        }
        C0876df c0876df = this.b;
        if (c0876df != null) {
            codedOutputByteBufferNano.writeMessage(2, c0876df);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        C1025jf[] c1025jfArr = this.e;
        int i2 = 0;
        if (c1025jfArr != null && c1025jfArr.length > 0) {
            int i3 = 0;
            while (true) {
                C1025jf[] c1025jfArr2 = this.e;
                if (i3 >= c1025jfArr2.length) {
                    break;
                }
                C1025jf c1025jf = c1025jfArr2[i3];
                if (c1025jf != null) {
                    codedOutputByteBufferNano.writeMessage(5, c1025jf);
                }
                i3++;
            }
        }
        if (!this.f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f);
        }
        int i4 = this.g;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i4);
        }
        a aVar = this.h;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(8, aVar);
        }
        if (!Arrays.equals(this.i, l)) {
            codedOutputByteBufferNano.writeBytes(9, this.i);
        }
        if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(10, this.j);
        }
        C0926ff[] c0926ffArr = this.k;
        if (c0926ffArr != null && c0926ffArr.length > 0) {
            while (true) {
                C0926ff[] c0926ffArr2 = this.k;
                if (i2 >= c0926ffArr2.length) {
                    break;
                }
                C0926ff c0926ff = c0926ffArr2[i2];
                if (c0926ff != null) {
                    codedOutputByteBufferNano.writeMessage(11, c0926ff);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
