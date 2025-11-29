package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import com.yandex.varioqub.config.model.ConfigValue;
import java.io.IOException;

/* renamed from: com.yandex.metrica.impl.ob.pf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1175pf extends MessageNano {
    public b[] a;
    public a[] b;

    /* renamed from: com.yandex.metrica.impl.ob.pf$a */
    public static final class a extends MessageNano {
        private static volatile a[] h;
        public long a;
        public long b;
        public C1150of[] c;
        public C1222rf[] d;
        public long e;
        public int f;
        public int g;

        public a() {
            a();
        }

        public static a[] b() {
            if (h == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (h == null) {
                            h = new a[0];
                        }
                    } finally {
                    }
                }
            }
            return h;
        }

        public a a() {
            this.a = 0L;
            this.b = 0L;
            this.c = C1150of.b();
            this.d = C1222rf.b();
            this.e = 0L;
            this.f = 0;
            this.g = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b);
            C1150of[] c1150ofArr = this.c;
            int i = 0;
            if (c1150ofArr != null && c1150ofArr.length > 0) {
                int i2 = 0;
                while (true) {
                    C1150of[] c1150ofArr2 = this.c;
                    if (i2 >= c1150ofArr2.length) {
                        break;
                    }
                    C1150of c1150of = c1150ofArr2[i2];
                    if (c1150of != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c1150of);
                    }
                    i2++;
                }
            }
            C1222rf[] c1222rfArr = this.d;
            if (c1222rfArr != null && c1222rfArr.length > 0) {
                while (true) {
                    C1222rf[] c1222rfArr2 = this.d;
                    if (i >= c1222rfArr2.length) {
                        break;
                    }
                    C1222rf c1222rf = c1222rfArr2[i];
                    if (c1222rf != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c1222rf);
                    }
                    i++;
                }
            }
            long j = this.e;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
            }
            int i3 = this.f;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i3);
            }
            int i4 = this.g;
            return i4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i4) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    break;
                }
                if (tag == 8) {
                    this.a = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.b = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    C1150of[] c1150ofArr = this.c;
                    int length = c1150ofArr == null ? 0 : c1150ofArr.length;
                    int i = repeatedFieldArrayLength + length;
                    C1150of[] c1150ofArr2 = new C1150of[i];
                    if (length != 0) {
                        System.arraycopy(c1150ofArr, 0, c1150ofArr2, 0, length);
                    }
                    while (length < i - 1) {
                        C1150of c1150of = new C1150of();
                        c1150ofArr2[length] = c1150of;
                        codedInputByteBufferNano.readMessage(c1150of);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    C1150of c1150of2 = new C1150of();
                    c1150ofArr2[length] = c1150of2;
                    codedInputByteBufferNano.readMessage(c1150of2);
                    this.c = c1150ofArr2;
                } else if (tag == 34) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    C1222rf[] c1222rfArr = this.d;
                    int length2 = c1222rfArr == null ? 0 : c1222rfArr.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    C1222rf[] c1222rfArr2 = new C1222rf[i2];
                    if (length2 != 0) {
                        System.arraycopy(c1222rfArr, 0, c1222rfArr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        C1222rf c1222rf = new C1222rf();
                        c1222rfArr2[length2] = c1222rf;
                        codedInputByteBufferNano.readMessage(c1222rf);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    C1222rf c1222rf2 = new C1222rf();
                    c1222rfArr2[length2] = c1222rf2;
                    codedInputByteBufferNano.readMessage(c1222rf2);
                    this.d = c1222rfArr2;
                } else if (tag == 40) {
                    this.e = codedInputByteBufferNano.readUInt64();
                } else if (tag == 48) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
                        this.f = int32;
                    }
                } else if (tag == 56) {
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 == 0 || int322 == 1 || int322 == 2 || int322 == 3) {
                        this.g = int322;
                    }
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            codedOutputByteBufferNano.writeUInt64(1, this.a);
            codedOutputByteBufferNano.writeUInt64(2, this.b);
            C1150of[] c1150ofArr = this.c;
            int i = 0;
            if (c1150ofArr != null && c1150ofArr.length > 0) {
                int i2 = 0;
                while (true) {
                    C1150of[] c1150ofArr2 = this.c;
                    if (i2 >= c1150ofArr2.length) {
                        break;
                    }
                    C1150of c1150of = c1150ofArr2[i2];
                    if (c1150of != null) {
                        codedOutputByteBufferNano.writeMessage(3, c1150of);
                    }
                    i2++;
                }
            }
            C1222rf[] c1222rfArr = this.d;
            if (c1222rfArr != null && c1222rfArr.length > 0) {
                while (true) {
                    C1222rf[] c1222rfArr2 = this.d;
                    if (i >= c1222rfArr2.length) {
                        break;
                    }
                    C1222rf c1222rf = c1222rfArr2[i];
                    if (c1222rf != null) {
                        codedOutputByteBufferNano.writeMessage(4, c1222rf);
                    }
                    i++;
                }
            }
            long j = this.e;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j);
            }
            int i3 = this.f;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(6, i3);
            }
            int i4 = this.g;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeInt32(7, i4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.pf$b */
    public static final class b extends MessageNano {
        private static volatile b[] n;
        public long a;
        public long b;
        public long c;
        public double d;
        public double e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public long l;
        public int m;

        public b() {
            a();
        }

        public static b[] b() {
            if (n == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (n == null) {
                            n = new b[0];
                        }
                    } finally {
                    }
                }
            }
            return n;
        }

        public b a() {
            this.a = 0L;
            this.b = 0L;
            this.c = 0L;
            this.d = ConfigValue.DOUBLE_DEFAULT_VALUE;
            this.e = ConfigValue.DOUBLE_DEFAULT_VALUE;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0L;
            this.m = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b);
            long j = this.c;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            int iComputeDoubleSize = iComputeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(4, this.d) + CodedOutputByteBufferNano.computeDoubleSize(5, this.e);
            int i = this.f;
            if (i != 0) {
                iComputeDoubleSize += CodedOutputByteBufferNano.computeUInt32Size(6, i);
            }
            int i2 = this.g;
            if (i2 != 0) {
                iComputeDoubleSize += CodedOutputByteBufferNano.computeUInt32Size(7, i2);
            }
            int i3 = this.h;
            if (i3 != 0) {
                iComputeDoubleSize += CodedOutputByteBufferNano.computeUInt32Size(8, i3);
            }
            int i4 = this.i;
            if (i4 != 0) {
                iComputeDoubleSize += CodedOutputByteBufferNano.computeInt32Size(9, i4);
            }
            int i5 = this.j;
            if (i5 != 0) {
                iComputeDoubleSize += CodedOutputByteBufferNano.computeInt32Size(10, i5);
            }
            int i6 = this.k;
            if (i6 != 0) {
                iComputeDoubleSize += CodedOutputByteBufferNano.computeInt32Size(11, i6);
            }
            long j2 = this.l;
            if (j2 != 0) {
                iComputeDoubleSize += CodedOutputByteBufferNano.computeUInt64Size(12, j2);
            }
            int i7 = this.m;
            return i7 != 0 ? iComputeDoubleSize + CodedOutputByteBufferNano.computeInt32Size(13, i7) : iComputeDoubleSize;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.a = codedInputByteBufferNano.readUInt64();
                        break;
                    case 16:
                        this.b = codedInputByteBufferNano.readUInt64();
                        break;
                    case 24:
                        this.c = codedInputByteBufferNano.readUInt64();
                        break;
                    case 33:
                        this.d = codedInputByteBufferNano.readDouble();
                        break;
                    case 41:
                        this.e = codedInputByteBufferNano.readDouble();
                        break;
                    case 48:
                        this.f = codedInputByteBufferNano.readUInt32();
                        break;
                    case 56:
                        this.g = codedInputByteBufferNano.readUInt32();
                        break;
                    case 64:
                        this.h = codedInputByteBufferNano.readUInt32();
                        break;
                    case 72:
                        this.i = codedInputByteBufferNano.readInt32();
                        break;
                    case 80:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3) {
                            break;
                        } else {
                            this.j = int32;
                            break;
                        }
                        break;
                    case 88:
                        int int322 = codedInputByteBufferNano.readInt32();
                        if (int322 != 0 && int322 != 1 && int322 != 2 && int322 != 3) {
                            break;
                        } else {
                            this.k = int322;
                            break;
                        }
                        break;
                    case 96:
                        this.l = codedInputByteBufferNano.readUInt64();
                        break;
                    case 104:
                        int int323 = codedInputByteBufferNano.readInt32();
                        if (int323 != 0 && int323 != 1 && int323 != 2 && int323 != 3 && int323 != 4) {
                            break;
                        } else {
                            this.m = int323;
                            break;
                        }
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
            codedOutputByteBufferNano.writeUInt64(1, this.a);
            codedOutputByteBufferNano.writeUInt64(2, this.b);
            long j = this.c;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            codedOutputByteBufferNano.writeDouble(4, this.d);
            codedOutputByteBufferNano.writeDouble(5, this.e);
            int i = this.f;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i);
            }
            int i2 = this.g;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(7, i2);
            }
            int i3 = this.h;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(8, i3);
            }
            int i4 = this.i;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeInt32(9, i4);
            }
            int i5 = this.j;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeInt32(10, i5);
            }
            int i6 = this.k;
            if (i6 != 0) {
                codedOutputByteBufferNano.writeInt32(11, i6);
            }
            long j2 = this.l;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(12, j2);
            }
            int i7 = this.m;
            if (i7 != 0) {
                codedOutputByteBufferNano.writeInt32(13, i7);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public C1175pf() {
        a();
    }

    public C1175pf a() {
        this.a = b.b();
        this.b = a.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        b[] bVarArr = this.a;
        int i = 0;
        if (bVarArr != null && bVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                b[] bVarArr2 = this.a;
                if (i2 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i2];
                if (bVar != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
                }
                i2++;
            }
        }
        a[] aVarArr = this.b;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.b;
                if (i >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i];
                if (aVar != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
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
                b[] bVarArr = this.a;
                int length = bVarArr == null ? 0 : bVarArr.length;
                int i = repeatedFieldArrayLength + length;
                b[] bVarArr2 = new b[i];
                if (length != 0) {
                    System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                }
                while (length < i - 1) {
                    b bVar = new b();
                    bVarArr2[length] = bVar;
                    codedInputByteBufferNano.readMessage(bVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                b bVar2 = new b();
                bVarArr2[length] = bVar2;
                codedInputByteBufferNano.readMessage(bVar2);
                this.a = bVarArr2;
            } else if (tag == 18) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                a[] aVarArr = this.b;
                int length2 = aVarArr == null ? 0 : aVarArr.length;
                int i2 = repeatedFieldArrayLength2 + length2;
                a[] aVarArr2 = new a[i2];
                if (length2 != 0) {
                    System.arraycopy(aVarArr, 0, aVarArr2, 0, length2);
                }
                while (length2 < i2 - 1) {
                    a aVar = new a();
                    aVarArr2[length2] = aVar;
                    codedInputByteBufferNano.readMessage(aVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                a aVar2 = new a();
                aVarArr2[length2] = aVar2;
                codedInputByteBufferNano.readMessage(aVar2);
                this.b = aVarArr2;
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                break;
            }
        }
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b[] bVarArr = this.a;
        int i = 0;
        if (bVarArr != null && bVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                b[] bVarArr2 = this.a;
                if (i2 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i2];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bVar);
                }
                i2++;
            }
        }
        a[] aVarArr = this.b;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.b;
                if (i >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, aVar);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
