package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class Cf extends MessageNano {
    public a a;
    public b[] b;

    public static final class a extends MessageNano {
        public String a;
        public String b;
        public boolean c;
        public boolean d;
        public int e;

        public a() {
            a();
        }

        public a a() {
            this.a = "";
            this.b = "";
            this.c = false;
            this.d = false;
            this.e = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.a.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
            }
            if (!this.b.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
            }
            boolean z = this.c;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
            }
            boolean z2 = this.d;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z2);
            }
            return iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, this.e);
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
                } else if (tag == 24) {
                    this.c = codedInputByteBufferNano.readBool();
                } else if (tag == 32) {
                    this.d = codedInputByteBufferNano.readBool();
                } else if (tag == 40) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.e = int32;
                    }
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
            boolean z = this.c;
            if (z) {
                codedOutputByteBufferNano.writeBool(3, z);
            }
            boolean z2 = this.d;
            if (z2) {
                codedOutputByteBufferNano.writeBool(4, z2);
            }
            codedOutputByteBufferNano.writeInt32(5, this.e);
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class b extends MessageNano {
        private static volatile b[] d;
        public String a;
        public String b;
        public int c;

        public b() {
            a();
        }

        public static b[] b() {
            if (d == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (d == null) {
                            d = new b[0];
                        }
                    } finally {
                    }
                }
            }
            return d;
        }

        public b a() {
            this.a = "";
            this.b = "";
            this.c = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.a.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
            }
            if (!this.b.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
            }
            return iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, this.c);
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
                } else if (tag == 24) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.c = int32;
                    }
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
            codedOutputByteBufferNano.writeInt32(3, this.c);
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public Cf() {
        a();
    }

    public Cf a() {
        this.a = null;
        this.b = b.b();
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
        b[] bVarArr = this.b;
        if (bVarArr != null && bVarArr.length > 0) {
            int i = 0;
            while (true) {
                b[] bVarArr2 = this.b;
                if (i >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i];
                if (bVar != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
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
                b[] bVarArr = this.b;
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
                this.b = bVarArr2;
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
        b[] bVarArr = this.b;
        if (bVarArr != null && bVarArr.length > 0) {
            int i = 0;
            while (true) {
                b[] bVarArr2 = this.b;
                if (i >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, bVar);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
