package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import com.yandex.varioqub.config.model.ConfigValue;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.yandex.metrica.impl.ob.uf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1294uf extends MessageNano {
    public int a;
    public double b;
    public byte[] c;
    public byte[] d;
    public byte[] e;
    public a f;
    public long g;
    public boolean h;
    public int i;
    public int j;
    public c k;
    public b l;

    /* renamed from: com.yandex.metrica.impl.ob.uf$a */
    public static final class a extends MessageNano {
        public byte[] a;
        public byte[] b;

        public a() {
            a();
        }

        public a a() {
            byte[] bArr = WireFormatNano.EMPTY_BYTES;
            this.a = bArr;
            this.b = bArr;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            byte[] bArr = this.a;
            byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
            if (!Arrays.equals(bArr, bArr2)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.a);
            }
            return !Arrays.equals(this.b, bArr2) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(2, this.b) : iComputeSerializedSize;
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
                } else if (tag == 18) {
                    this.b = codedInputByteBufferNano.readBytes();
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            byte[] bArr = this.a;
            byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
            if (!Arrays.equals(bArr, bArr2)) {
                codedOutputByteBufferNano.writeBytes(1, this.a);
            }
            if (!Arrays.equals(this.b, bArr2)) {
                codedOutputByteBufferNano.writeBytes(2, this.b);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.uf$b */
    public static final class b extends MessageNano {
        public boolean a;
        public C0295b b;
        public a c;

        /* renamed from: com.yandex.metrica.impl.ob.uf$b$a */
        public static final class a extends MessageNano {
            public long a;
            public C0295b b;
            public int c;
            public byte[] d;

            public a() {
                a();
            }

            public a a() {
                this.a = 0L;
                this.b = null;
                this.c = 0;
                this.d = WireFormatNano.EMPTY_BYTES;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                long j = this.a;
                if (j != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
                }
                C0295b c0295b = this.b;
                if (c0295b != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0295b);
                }
                int i = this.c;
                if (i != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
                }
                return !Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(4, this.d) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        break;
                    }
                    if (tag == 8) {
                        this.a = codedInputByteBufferNano.readInt64();
                    } else if (tag == 18) {
                        if (this.b == null) {
                            this.b = new C0295b();
                        }
                        codedInputByteBufferNano.readMessage(this.b);
                    } else if (tag == 24) {
                        this.c = codedInputByteBufferNano.readUInt32();
                    } else if (tag == 34) {
                        this.d = codedInputByteBufferNano.readBytes();
                    } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        break;
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                long j = this.a;
                if (j != 0) {
                    codedOutputByteBufferNano.writeInt64(1, j);
                }
                C0295b c0295b = this.b;
                if (c0295b != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0295b);
                }
                int i = this.c;
                if (i != 0) {
                    codedOutputByteBufferNano.writeUInt32(3, i);
                }
                if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
                    codedOutputByteBufferNano.writeBytes(4, this.d);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.uf$b$b, reason: collision with other inner class name */
        public static final class C0295b extends MessageNano {
            public int a;
            public int b;

            public C0295b() {
                a();
            }

            public C0295b a() {
                this.a = 0;
                this.b = 0;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                int i = this.a;
                if (i != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
                }
                int i2 = this.b;
                return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i2) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        break;
                    }
                    if (tag == 8) {
                        this.a = codedInputByteBufferNano.readUInt32();
                    } else if (tag == 16) {
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
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
                int i = this.a;
                if (i != 0) {
                    codedOutputByteBufferNano.writeUInt32(1, i);
                }
                int i2 = this.b;
                if (i2 != 0) {
                    codedOutputByteBufferNano.writeInt32(2, i2);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public b() {
            a();
        }

        public b a() {
            this.a = false;
            this.b = null;
            this.c = null;
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
            C0295b c0295b = this.b;
            if (c0295b != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0295b);
            }
            a aVar = this.c;
            return aVar != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, aVar) : iComputeSerializedSize;
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
                } else if (tag == 18) {
                    if (this.b == null) {
                        this.b = new C0295b();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                } else if (tag == 26) {
                    if (this.c == null) {
                        this.c = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.c);
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
            C0295b c0295b = this.b;
            if (c0295b != null) {
                codedOutputByteBufferNano.writeMessage(2, c0295b);
            }
            a aVar = this.c;
            if (aVar != null) {
                codedOutputByteBufferNano.writeMessage(3, aVar);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.uf$c */
    public static final class c extends MessageNano {
        public byte[] a;
        public long b;
        public int c;
        public byte[] d;
        public long e;

        public c() {
            a();
        }

        public c a() {
            byte[] bArr = WireFormatNano.EMPTY_BYTES;
            this.a = bArr;
            this.b = 0L;
            this.c = 0;
            this.d = bArr;
            this.e = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            byte[] bArr = this.a;
            byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
            if (!Arrays.equals(bArr, bArr2)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.a);
            }
            long j = this.b;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            int i = this.c;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
            }
            if (!Arrays.equals(this.d, bArr2)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(4, this.d);
            }
            long j2 = this.e;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j2) : iComputeSerializedSize;
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
                    this.b = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.c = int32;
                    }
                } else if (tag == 34) {
                    this.d = codedInputByteBufferNano.readBytes();
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
            byte[] bArr = this.a;
            byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
            if (!Arrays.equals(bArr, bArr2)) {
                codedOutputByteBufferNano.writeBytes(1, this.a);
            }
            long j = this.b;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            int i = this.c;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            if (!Arrays.equals(this.d, bArr2)) {
                codedOutputByteBufferNano.writeBytes(4, this.d);
            }
            long j2 = this.e;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public C1294uf() {
        a();
    }

    public C1294uf a() {
        this.a = 1;
        this.b = ConfigValue.DOUBLE_DEFAULT_VALUE;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.c = bArr;
        this.d = bArr;
        this.e = bArr;
        this.f = null;
        this.g = 0L;
        this.h = false;
        this.i = 0;
        this.j = 1;
        this.k = null;
        this.l = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.a;
        if (i != 1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(ConfigValue.DOUBLE_DEFAULT_VALUE)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, this.b);
        }
        int iComputeBytesSize = iComputeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(3, this.c);
        byte[] bArr = this.d;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            iComputeBytesSize += CodedOutputByteBufferNano.computeBytesSize(4, this.d);
        }
        if (!Arrays.equals(this.e, bArr2)) {
            iComputeBytesSize += CodedOutputByteBufferNano.computeBytesSize(5, this.e);
        }
        a aVar = this.f;
        if (aVar != null) {
            iComputeBytesSize += CodedOutputByteBufferNano.computeMessageSize(6, aVar);
        }
        long j = this.g;
        if (j != 0) {
            iComputeBytesSize += CodedOutputByteBufferNano.computeInt64Size(7, j);
        }
        boolean z = this.h;
        if (z) {
            iComputeBytesSize += CodedOutputByteBufferNano.computeBoolSize(8, z);
        }
        int i2 = this.i;
        if (i2 != 0) {
            iComputeBytesSize += CodedOutputByteBufferNano.computeInt32Size(9, i2);
        }
        int i3 = this.j;
        if (i3 != 1) {
            iComputeBytesSize += CodedOutputByteBufferNano.computeInt32Size(10, i3);
        }
        c cVar = this.k;
        if (cVar != null) {
            iComputeBytesSize += CodedOutputByteBufferNano.computeMessageSize(11, cVar);
        }
        b bVar = this.l;
        return bVar != null ? iComputeBytesSize + CodedOutputByteBufferNano.computeMessageSize(12, bVar) : iComputeBytesSize;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.a = codedInputByteBufferNano.readUInt32();
                    break;
                case 17:
                    this.b = codedInputByteBufferNano.readDouble();
                    break;
                case 26:
                    this.c = codedInputByteBufferNano.readBytes();
                    break;
                case 34:
                    this.d = codedInputByteBufferNano.readBytes();
                    break;
                case 42:
                    this.e = codedInputByteBufferNano.readBytes();
                    break;
                case 50:
                    if (this.f == null) {
                        this.f = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f);
                    break;
                case 56:
                    this.g = codedInputByteBufferNano.readInt64();
                    break;
                case 64:
                    this.h = codedInputByteBufferNano.readBool();
                    break;
                case 72:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.i = int32;
                        break;
                    }
                    break;
                case 80:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 1 && int322 != 2) {
                        break;
                    } else {
                        this.j = int322;
                        break;
                    }
                    break;
                case 90:
                    if (this.k == null) {
                        this.k = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.k);
                    break;
                case 98:
                    if (this.l == null) {
                        this.l = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.l);
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
        int i = this.a;
        if (i != 1) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(ConfigValue.DOUBLE_DEFAULT_VALUE)) {
            codedOutputByteBufferNano.writeDouble(2, this.b);
        }
        codedOutputByteBufferNano.writeBytes(3, this.c);
        byte[] bArr = this.d;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(4, this.d);
        }
        if (!Arrays.equals(this.e, bArr2)) {
            codedOutputByteBufferNano.writeBytes(5, this.e);
        }
        a aVar = this.f;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(6, aVar);
        }
        long j = this.g;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(7, j);
        }
        boolean z = this.h;
        if (z) {
            codedOutputByteBufferNano.writeBool(8, z);
        }
        int i2 = this.i;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i2);
        }
        int i3 = this.j;
        if (i3 != 1) {
            codedOutputByteBufferNano.writeInt32(10, i3);
        }
        c cVar = this.k;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(11, cVar);
        }
        b bVar = this.l;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(12, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
