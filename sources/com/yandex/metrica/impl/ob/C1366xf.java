package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import java.io.IOException;

/* renamed from: com.yandex.metrica.impl.ob.xf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1366xf extends MessageNano {
    public a[] a;
    public boolean b;

    /* renamed from: com.yandex.metrica.impl.ob.xf$a */
    public static final class a extends MessageNano {
        private static volatile a[] f;
        public int a;
        public String b;
        public String c;
        public long d;
        public long e;

        public a() {
            a();
        }

        public static a[] b() {
            if (f == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (f == null) {
                            f = new a[0];
                        }
                    } finally {
                    }
                }
            }
            return f;
        }

        public a a() {
            this.a = 1;
            this.b = "";
            this.c = "";
            this.d = 0L;
            this.e = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            return super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt32Size(1, this.a) + CodedOutputByteBufferNano.computeStringSize(2, this.b) + CodedOutputByteBufferNano.computeStringSize(3, this.c) + CodedOutputByteBufferNano.computeUInt64Size(4, this.d) + CodedOutputByteBufferNano.computeUInt64Size(5, this.e);
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    break;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 1 || int32 == 2 || int32 == 3) {
                        this.a = int32;
                    }
                } else if (tag == 18) {
                    this.b = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.c = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.d = codedInputByteBufferNano.readUInt64();
                } else if (tag == 40) {
                    this.e = codedInputByteBufferNano.readUInt64();
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            codedOutputByteBufferNano.writeInt32(1, this.a);
            codedOutputByteBufferNano.writeString(2, this.b);
            codedOutputByteBufferNano.writeString(3, this.c);
            codedOutputByteBufferNano.writeUInt64(4, this.d);
            codedOutputByteBufferNano.writeUInt64(5, this.e);
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public C1366xf() {
        a();
    }

    public C1366xf a() {
        this.a = a.b();
        this.b = false;
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
        return iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, this.b);
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
            } else if (tag == 16) {
                this.b = codedInputByteBufferNano.readBool();
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
        codedOutputByteBufferNano.writeBool(2, this.b);
        super.writeTo(codedOutputByteBufferNano);
    }
}
