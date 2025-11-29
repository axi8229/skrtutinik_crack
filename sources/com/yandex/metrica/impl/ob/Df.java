package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class Df extends MessageNano {
    public a[] a;
    public String[] b;

    public static final class a extends MessageNano {
        private static volatile a[] g;
        public String a;
        public String b;
        public String c;
        public C0282a[] d;
        public long e;
        public int[] f;

        /* renamed from: com.yandex.metrica.impl.ob.Df$a$a, reason: collision with other inner class name */
        public static final class C0282a extends MessageNano {
            private static volatile C0282a[] c;
            public String a;
            public String b;

            public C0282a() {
                a();
            }

            public static C0282a[] b() {
                if (c == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        try {
                            if (c == null) {
                                c = new C0282a[0];
                            }
                        } finally {
                        }
                    }
                }
                return c;
            }

            public C0282a a() {
                this.a = "";
                this.b = "";
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            protected int computeSerializedSize() {
                return super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.a) + CodedOutputByteBufferNano.computeStringSize(2, this.b);
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
                    } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        break;
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                codedOutputByteBufferNano.writeString(1, this.a);
                codedOutputByteBufferNano.writeString(2, this.b);
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public a() {
            a();
        }

        public static a[] b() {
            if (g == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (g == null) {
                            g = new a[0];
                        }
                    } finally {
                    }
                }
            }
            return g;
        }

        public a a() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = C0282a.b();
            this.e = 0L;
            this.f = WireFormatNano.EMPTY_INT_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.a) + CodedOutputByteBufferNano.computeStringSize(2, this.b) + CodedOutputByteBufferNano.computeStringSize(3, this.c);
            C0282a[] c0282aArr = this.d;
            int i = 0;
            if (c0282aArr != null && c0282aArr.length > 0) {
                int i2 = 0;
                while (true) {
                    C0282a[] c0282aArr2 = this.d;
                    if (i2 >= c0282aArr2.length) {
                        break;
                    }
                    C0282a c0282a = c0282aArr2[i2];
                    if (c0282a != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c0282a);
                    }
                    i2++;
                }
            }
            int iComputeUInt64Size = iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, this.e);
            int[] iArr = this.f;
            if (iArr == null || iArr.length <= 0) {
                return iComputeUInt64Size;
            }
            int iComputeInt32SizeNoTag = 0;
            while (true) {
                int[] iArr2 = this.f;
                if (i >= iArr2.length) {
                    return iComputeUInt64Size + iComputeInt32SizeNoTag + iArr2.length;
                }
                iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i]);
                i++;
            }
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    break;
                }
                if (tag != 10) {
                    if (tag != 18) {
                        if (tag != 26) {
                            if (tag != 34) {
                                if (tag != 40) {
                                    if (tag != 48) {
                                        if (tag != 50) {
                                            if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                                                break;
                                            }
                                        } else {
                                            int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                                            int position = codedInputByteBufferNano.getPosition();
                                            int i = 0;
                                            while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                                int int32 = codedInputByteBufferNano.readInt32();
                                                if (int32 == 1 || int32 == 2) {
                                                    i++;
                                                }
                                            }
                                            if (i != 0) {
                                                codedInputByteBufferNano.rewindToPosition(position);
                                                int[] iArr = this.f;
                                                int length = iArr == null ? 0 : iArr.length;
                                                int[] iArr2 = new int[i + length];
                                                if (length != 0) {
                                                    System.arraycopy(iArr, 0, iArr2, 0, length);
                                                }
                                                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                                    int int322 = codedInputByteBufferNano.readInt32();
                                                    if (int322 == 1 || int322 == 2) {
                                                        iArr2[length] = int322;
                                                        length++;
                                                    }
                                                }
                                                this.f = iArr2;
                                            }
                                            codedInputByteBufferNano.popLimit(iPushLimit);
                                        }
                                    } else {
                                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 48);
                                        int[] iArr3 = new int[repeatedFieldArrayLength];
                                        int i2 = 0;
                                        for (int i3 = 0; i3 < repeatedFieldArrayLength; i3++) {
                                            if (i3 != 0) {
                                                codedInputByteBufferNano.readTag();
                                            }
                                            int int323 = codedInputByteBufferNano.readInt32();
                                            if (int323 == 1 || int323 == 2) {
                                                iArr3[i2] = int323;
                                                i2++;
                                            }
                                        }
                                        if (i2 != 0) {
                                            int[] iArr4 = this.f;
                                            int length2 = iArr4 == null ? 0 : iArr4.length;
                                            if (length2 == 0 && i2 == repeatedFieldArrayLength) {
                                                this.f = iArr3;
                                            } else {
                                                int[] iArr5 = new int[length2 + i2];
                                                if (length2 != 0) {
                                                    System.arraycopy(iArr4, 0, iArr5, 0, length2);
                                                }
                                                System.arraycopy(iArr3, 0, iArr5, length2, i2);
                                                this.f = iArr5;
                                            }
                                        }
                                    }
                                } else {
                                    this.e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                C0282a[] c0282aArr = this.d;
                                int length3 = c0282aArr == null ? 0 : c0282aArr.length;
                                int i4 = repeatedFieldArrayLength2 + length3;
                                C0282a[] c0282aArr2 = new C0282a[i4];
                                if (length3 != 0) {
                                    System.arraycopy(c0282aArr, 0, c0282aArr2, 0, length3);
                                }
                                while (length3 < i4 - 1) {
                                    C0282a c0282a = new C0282a();
                                    c0282aArr2[length3] = c0282a;
                                    codedInputByteBufferNano.readMessage(c0282a);
                                    codedInputByteBufferNano.readTag();
                                    length3++;
                                }
                                C0282a c0282a2 = new C0282a();
                                c0282aArr2[length3] = c0282a2;
                                codedInputByteBufferNano.readMessage(c0282a2);
                                this.d = c0282aArr2;
                            }
                        } else {
                            this.c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.a = codedInputByteBufferNano.readString();
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            codedOutputByteBufferNano.writeString(1, this.a);
            codedOutputByteBufferNano.writeString(2, this.b);
            codedOutputByteBufferNano.writeString(3, this.c);
            C0282a[] c0282aArr = this.d;
            int i = 0;
            if (c0282aArr != null && c0282aArr.length > 0) {
                int i2 = 0;
                while (true) {
                    C0282a[] c0282aArr2 = this.d;
                    if (i2 >= c0282aArr2.length) {
                        break;
                    }
                    C0282a c0282a = c0282aArr2[i2];
                    if (c0282a != null) {
                        codedOutputByteBufferNano.writeMessage(4, c0282a);
                    }
                    i2++;
                }
            }
            codedOutputByteBufferNano.writeUInt64(5, this.e);
            int[] iArr = this.f;
            if (iArr != null && iArr.length > 0) {
                while (true) {
                    int[] iArr2 = this.f;
                    if (i >= iArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeInt32(6, iArr2[i]);
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public Df() {
        a();
    }

    public Df a() {
        this.a = a.b();
        this.b = WireFormatNano.EMPTY_STRING_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        a[] aVarArr = this.a;
        int i = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                a[] aVarArr2 = this.a;
                if (i2 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i2];
                if (aVar != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
                }
                i2++;
            }
        }
        String[] strArr = this.b;
        if (strArr == null || strArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int iComputeStringSizeNoTag = 0;
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.b;
            if (i >= strArr2.length) {
                return iComputeSerializedSize + iComputeStringSizeNoTag + i3;
            }
            String str = strArr2[i];
            if (str != null) {
                i3++;
                iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
            }
            i++;
        }
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
                a[] aVarArr = this.a;
                int length = aVarArr == null ? 0 : aVarArr.length;
                int i = repeatedFieldArrayLength + length;
                a[] aVarArr2 = new a[i];
                if (length != 0) {
                    System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                }
                while (length < i - 1) {
                    a aVar = new a();
                    aVarArr2[length] = aVar;
                    codedInputByteBufferNano.readMessage(aVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                a aVar2 = new a();
                aVarArr2[length] = aVar2;
                codedInputByteBufferNano.readMessage(aVar2);
                this.a = aVarArr2;
            } else if (tag == 18) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                String[] strArr = this.b;
                int length2 = strArr == null ? 0 : strArr.length;
                int i2 = repeatedFieldArrayLength2 + length2;
                String[] strArr2 = new String[i2];
                if (length2 != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length2);
                }
                while (length2 < i2 - 1) {
                    strArr2[length2] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                strArr2[length2] = codedInputByteBufferNano.readString();
                this.b = strArr2;
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                break;
            }
        }
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        a[] aVarArr = this.a;
        int i = 0;
        if (aVarArr != null && aVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                a[] aVarArr2 = this.a;
                if (i2 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i2];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, aVar);
                }
                i2++;
            }
        }
        String[] strArr = this.b;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.b;
                if (i >= strArr2.length) {
                    break;
                }
                String str = strArr2[i];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(2, str);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
