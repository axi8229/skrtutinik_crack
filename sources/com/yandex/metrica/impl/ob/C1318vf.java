package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import com.yandex.varioqub.config.model.ConfigValue;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.yandex.metrica.impl.ob.vf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1318vf extends MessageNano {
    public a[] a;

    /* renamed from: com.yandex.metrica.impl.ob.vf$a */
    public static final class a extends MessageNano {
        private static volatile a[] e;
        public byte[] a;
        public int b;
        public b c;
        public c d;

        public a() {
            a();
        }

        public static a[] b() {
            if (e == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (e == null) {
                            e = new a[0];
                        }
                    } finally {
                    }
                }
            }
            return e;
        }

        public a a() {
            this.a = WireFormatNano.EMPTY_BYTES;
            this.b = 0;
            this.c = null;
            this.d = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeBytesSize(1, this.a) + CodedOutputByteBufferNano.computeInt32Size(2, this.b);
            b bVar = this.c;
            if (bVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, bVar);
            }
            c cVar = this.d;
            return cVar != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, cVar) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    break;
                }
                if (tag == 10) {
                    this.a = codedInputByteBufferNano.readBytes();
                } else if (tag == 16) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.b = int32;
                    }
                } else if (tag == 26) {
                    if (this.c == null) {
                        this.c = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.c);
                } else if (tag == 34) {
                    if (this.d == null) {
                        this.d = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.d);
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            codedOutputByteBufferNano.writeBytes(1, this.a);
            codedOutputByteBufferNano.writeInt32(2, this.b);
            b bVar = this.c;
            if (bVar != null) {
                codedOutputByteBufferNano.writeMessage(3, bVar);
            }
            c cVar = this.d;
            if (cVar != null) {
                codedOutputByteBufferNano.writeMessage(4, cVar);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.vf$b */
    public static final class b extends MessageNano {
        public boolean a;
        public boolean b;

        public b() {
            a();
        }

        public b a() {
            this.a = false;
            this.b = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.a;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            boolean z2 = this.b;
            return z2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, z2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    break;
                }
                if (tag == 8) {
                    this.a = codedInputByteBufferNano.readBool();
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
            boolean z = this.a;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            boolean z2 = this.b;
            if (z2) {
                codedOutputByteBufferNano.writeBool(2, z2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.vf$c */
    public static final class c extends MessageNano {
        public byte[] a;
        public double b;
        public double c;
        public boolean d;

        public c() {
            a();
        }

        public c a() {
            this.a = WireFormatNano.EMPTY_BYTES;
            this.b = ConfigValue.DOUBLE_DEFAULT_VALUE;
            this.c = ConfigValue.DOUBLE_DEFAULT_VALUE;
            this.d = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.a);
            }
            if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(ConfigValue.DOUBLE_DEFAULT_VALUE)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, this.b);
            }
            if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(ConfigValue.DOUBLE_DEFAULT_VALUE)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, this.c);
            }
            boolean z = this.d;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    break;
                }
                if (tag == 10) {
                    this.a = codedInputByteBufferNano.readBytes();
                } else if (tag == 17) {
                    this.b = codedInputByteBufferNano.readDouble();
                } else if (tag == 25) {
                    this.c = codedInputByteBufferNano.readDouble();
                } else if (tag == 32) {
                    this.d = codedInputByteBufferNano.readBool();
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES)) {
                codedOutputByteBufferNano.writeBytes(1, this.a);
            }
            if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(ConfigValue.DOUBLE_DEFAULT_VALUE)) {
                codedOutputByteBufferNano.writeDouble(2, this.b);
            }
            if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(ConfigValue.DOUBLE_DEFAULT_VALUE)) {
                codedOutputByteBufferNano.writeDouble(3, this.c);
            }
            boolean z = this.d;
            if (z) {
                codedOutputByteBufferNano.writeBool(4, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public C1318vf() {
        a();
    }

    public C1318vf a() {
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
