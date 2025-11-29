package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import java.io.IOException;

/* renamed from: com.yandex.metrica.impl.ob.yf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1390yf extends MessageNano {
    public a a;
    public a[] b;

    /* renamed from: com.yandex.metrica.impl.ob.yf$a */
    public static final class a extends MessageNano {
        private static volatile a[] c;
        public b a;
        public int b;

        public a() {
            a();
        }

        public static a[] b() {
            if (c == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (c == null) {
                            c = new a[0];
                        }
                    } finally {
                    }
                }
            }
            return c;
        }

        public a a() {
            this.a = null;
            this.b = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            b bVar = this.a;
            if (bVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
            }
            int i = this.b;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
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
                        this.a = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.a);
                } else if (tag == 16) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.b = int32;
                    }
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            b bVar = this.a;
            if (bVar != null) {
                codedOutputByteBufferNano.writeMessage(1, bVar);
            }
            int i = this.b;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.yf$b */
    public static final class b extends MessageNano {
        public a[] a;

        /* renamed from: com.yandex.metrica.impl.ob.yf$b$a */
        public static final class a extends MessageNano {
            private static volatile a[] c;
            public String a;
            public String b;

            public a() {
                a();
            }

            public static a[] b() {
                if (c == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        try {
                            if (c == null) {
                                c = new a[0];
                            }
                        } finally {
                        }
                    }
                }
                return c;
            }

            public a a() {
                this.a = "";
                this.b = "";
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                if (!this.a.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
                }
                return !this.b.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.b) : iComputeSerializedSize;
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
                if (!this.a.equals("")) {
                    codedOutputByteBufferNano.writeString(1, this.a);
                }
                if (!this.b.equals("")) {
                    codedOutputByteBufferNano.writeString(2, this.b);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public b() {
            a();
        }

        public b a() {
            this.a = a.b();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            a[] aVarArr = this.a;
            if (aVarArr != null && aVarArr.length > 0) {
                int i = 0;
                while (true) {
                    a[] aVarArr2 = this.a;
                    if (i >= aVarArr2.length) {
                        break;
                    }
                    a aVar = aVarArr2[i];
                    if (aVar != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
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
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            a[] aVarArr = this.a;
            if (aVarArr != null && aVarArr.length > 0) {
                int i = 0;
                while (true) {
                    a[] aVarArr2 = this.a;
                    if (i >= aVarArr2.length) {
                        break;
                    }
                    a aVar = aVarArr2[i];
                    if (aVar != null) {
                        codedOutputByteBufferNano.writeMessage(1, aVar);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public C1390yf() {
        a();
    }

    public C1390yf a() {
        this.a = null;
        this.b = a.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        a aVar = this.a;
        if (aVar != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
        }
        a[] aVarArr = this.b;
        if (aVarArr != null && aVarArr.length > 0) {
            int i = 0;
            while (true) {
                a[] aVarArr2 = this.b;
                if (i >= aVarArr2.length) {
                    break;
                }
                a aVar2 = aVarArr2[i];
                if (aVar2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar2);
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
                if (this.a == null) {
                    this.a = new a();
                }
                codedInputByteBufferNano.readMessage(this.a);
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                a[] aVarArr = this.b;
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
                this.b = aVarArr2;
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                break;
            }
        }
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        a aVar = this.a;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aVar);
        }
        a[] aVarArr = this.b;
        if (aVarArr != null && aVarArr.length > 0) {
            int i = 0;
            while (true) {
                a[] aVarArr2 = this.b;
                if (i >= aVarArr2.length) {
                    break;
                }
                a aVar2 = aVarArr2[i];
                if (aVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(2, aVar2);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
