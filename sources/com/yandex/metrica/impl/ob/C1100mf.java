package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.yandex.metrica.impl.ob.mf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1100mf extends MessageNano {
    public int a;
    public q b;
    public o c;
    public p d;
    public b e;
    public h f;

    /* renamed from: com.yandex.metrica.impl.ob.mf$a */
    public static final class a extends MessageNano {
        private static volatile a[] c;
        public byte[] a;
        public e b;

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
            this.a = WireFormatNano.EMPTY_BYTES;
            this.b = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.a);
            }
            e eVar = this.b;
            return eVar != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, eVar) : iComputeSerializedSize;
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
                    if (this.b == null) {
                        this.b = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
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
            e eVar = this.b;
            if (eVar != null) {
                codedOutputByteBufferNano.writeMessage(2, eVar);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$b */
    public static final class b extends MessageNano {
        public c a;

        public b() {
            a();
        }

        public b a() {
            this.a = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            c cVar = this.a;
            return cVar != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, cVar) : iComputeSerializedSize;
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
                        this.a = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.a);
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            c cVar = this.a;
            if (cVar != null) {
                codedOutputByteBufferNano.writeMessage(1, cVar);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$c */
    public static final class c extends MessageNano {
        public k a;
        public m b;
        public e c;
        public j d;

        public c() {
            a();
        }

        public c a() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            k kVar = this.a;
            if (kVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, kVar);
            }
            m mVar = this.b;
            if (mVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, mVar);
            }
            e eVar = this.c;
            if (eVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
            }
            j jVar = this.d;
            return jVar != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, jVar) : iComputeSerializedSize;
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
                        this.a = new k();
                    }
                    codedInputByteBufferNano.readMessage(this.a);
                } else if (tag == 18) {
                    if (this.b == null) {
                        this.b = new m();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                } else if (tag == 26) {
                    if (this.c == null) {
                        this.c = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.c);
                } else if (tag == 34) {
                    if (this.d == null) {
                        this.d = new j();
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
            k kVar = this.a;
            if (kVar != null) {
                codedOutputByteBufferNano.writeMessage(1, kVar);
            }
            m mVar = this.b;
            if (mVar != null) {
                codedOutputByteBufferNano.writeMessage(2, mVar);
            }
            e eVar = this.c;
            if (eVar != null) {
                codedOutputByteBufferNano.writeMessage(3, eVar);
            }
            j jVar = this.d;
            if (jVar != null) {
                codedOutputByteBufferNano.writeMessage(4, jVar);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$d */
    public static final class d extends MessageNano {
        public byte[][] a;

        public d() {
            a();
        }

        public d a() {
            this.a = WireFormatNano.EMPTY_BYTES_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            byte[][] bArr = this.a;
            if (bArr == null || bArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int i = 0;
            int iComputeBytesSizeNoTag = 0;
            int i2 = 0;
            while (true) {
                byte[][] bArr2 = this.a;
                if (i >= bArr2.length) {
                    return iComputeSerializedSize + iComputeBytesSizeNoTag + i2;
                }
                byte[] bArr3 = bArr2[i];
                if (bArr3 != null) {
                    i2++;
                    iComputeBytesSizeNoTag += CodedOutputByteBufferNano.computeBytesSizeNoTag(bArr3);
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
                    byte[][] bArr = this.a;
                    int length = bArr == null ? 0 : bArr.length;
                    int i = repeatedFieldArrayLength + length;
                    byte[][] bArr2 = new byte[i][];
                    if (length != 0) {
                        System.arraycopy(bArr, 0, bArr2, 0, length);
                    }
                    while (length < i - 1) {
                        bArr2[length] = codedInputByteBufferNano.readBytes();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    bArr2[length] = codedInputByteBufferNano.readBytes();
                    this.a = bArr2;
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            byte[][] bArr = this.a;
            if (bArr != null && bArr.length > 0) {
                int i = 0;
                while (true) {
                    byte[][] bArr2 = this.a;
                    if (i >= bArr2.length) {
                        break;
                    }
                    byte[] bArr3 = bArr2[i];
                    if (bArr3 != null) {
                        codedOutputByteBufferNano.writeBytes(1, bArr3);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$e */
    public static final class e extends MessageNano {
        public long a;
        public int b;

        public e() {
            a();
        }

        public e a() {
            this.a = 0L;
            this.b = 0;
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
                if (tag == 8) {
                    this.a = codedInputByteBufferNano.readInt64();
                } else if (tag == 16) {
                    this.b = codedInputByteBufferNano.readInt32();
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
            int i = this.b;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$f */
    public static final class f extends MessageNano {
        public byte[] a;
        public byte[] b;
        public i c;
        public g[] d;
        public int e;

        public f() {
            a();
        }

        public f a() {
            byte[] bArr = WireFormatNano.EMPTY_BYTES;
            this.a = bArr;
            this.b = bArr;
            this.c = null;
            this.d = g.b();
            this.e = 0;
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
            if (!Arrays.equals(this.b, bArr2)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
            }
            i iVar = this.c;
            if (iVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, iVar);
            }
            g[] gVarArr = this.d;
            if (gVarArr != null && gVarArr.length > 0) {
                int i = 0;
                while (true) {
                    g[] gVarArr2 = this.d;
                    if (i >= gVarArr2.length) {
                        break;
                    }
                    g gVar = gVarArr2[i];
                    if (gVar != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, gVar);
                    }
                    i++;
                }
            }
            int i2 = this.e;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i2) : iComputeSerializedSize;
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
                } else if (tag == 26) {
                    if (this.c == null) {
                        this.c = new i();
                    }
                    codedInputByteBufferNano.readMessage(this.c);
                } else if (tag == 34) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    g[] gVarArr = this.d;
                    int length = gVarArr == null ? 0 : gVarArr.length;
                    int i = repeatedFieldArrayLength + length;
                    g[] gVarArr2 = new g[i];
                    if (length != 0) {
                        System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        g gVar = new g();
                        gVarArr2[length] = gVar;
                        codedInputByteBufferNano.readMessage(gVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    g gVar2 = new g();
                    gVarArr2[length] = gVar2;
                    codedInputByteBufferNano.readMessage(gVar2);
                    this.d = gVarArr2;
                } else if (tag == 40) {
                    this.e = codedInputByteBufferNano.readUInt32();
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
            i iVar = this.c;
            if (iVar != null) {
                codedOutputByteBufferNano.writeMessage(3, iVar);
            }
            g[] gVarArr = this.d;
            if (gVarArr != null && gVarArr.length > 0) {
                int i = 0;
                while (true) {
                    g[] gVarArr2 = this.d;
                    if (i >= gVarArr2.length) {
                        break;
                    }
                    g gVar = gVarArr2[i];
                    if (gVar != null) {
                        codedOutputByteBufferNano.writeMessage(4, gVar);
                    }
                    i++;
                }
            }
            int i2 = this.e;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$g */
    public static final class g extends MessageNano {
        private static volatile g[] c;
        public int a;
        public c b;

        public g() {
            a();
        }

        public static g[] b() {
            if (c == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (c == null) {
                            c = new g[0];
                        }
                    } finally {
                    }
                }
            }
            return c;
        }

        public g a() {
            this.a = 0;
            this.b = null;
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
            c cVar = this.b;
            return cVar != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, cVar) : iComputeSerializedSize;
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
                } else if (tag == 18) {
                    if (this.b == null) {
                        this.b = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
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
            c cVar = this.b;
            if (cVar != null) {
                codedOutputByteBufferNano.writeMessage(2, cVar);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$h */
    public static final class h extends MessageNano {
        public f a;

        public h() {
            a();
        }

        public h a() {
            this.a = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            f fVar = this.a;
            return fVar != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, fVar) : iComputeSerializedSize;
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
                        this.a = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.a);
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            f fVar = this.a;
            if (fVar != null) {
                codedOutputByteBufferNano.writeMessage(1, fVar);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$i */
    public static final class i extends MessageNano {
        public a[] a;
        public int b;

        /* renamed from: com.yandex.metrica.impl.ob.mf$i$a */
        public static final class a extends MessageNano {
            private static volatile a[] c;
            public byte[] a;
            public byte[] b;

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

        public i() {
            a();
        }

        public i a() {
            this.a = a.b();
            this.b = 0;
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
            int i2 = this.b;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i2) : iComputeSerializedSize;
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
                    this.b = codedInputByteBufferNano.readUInt32();
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
            int i2 = this.b;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$j */
    public static final class j extends MessageNano {
        public a a;
        public a[] b;

        public j() {
            a();
        }

        public j a() {
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

    /* renamed from: com.yandex.metrica.impl.ob.mf$k */
    public static final class k extends MessageNano {
        public byte[] a;
        public byte[] b;
        public d c;
        public i d;
        public j e;
        public j f;
        public l[] g;

        public k() {
            a();
        }

        public k a() {
            byte[] bArr = WireFormatNano.EMPTY_BYTES;
            this.a = bArr;
            this.b = bArr;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = l.b();
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
            if (!Arrays.equals(this.b, bArr2)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
            }
            d dVar = this.c;
            if (dVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, dVar);
            }
            i iVar = this.d;
            if (iVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, iVar);
            }
            j jVar = this.e;
            if (jVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, jVar);
            }
            j jVar2 = this.f;
            if (jVar2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, jVar2);
            }
            l[] lVarArr = this.g;
            if (lVarArr != null && lVarArr.length > 0) {
                int i = 0;
                while (true) {
                    l[] lVarArr2 = this.g;
                    if (i >= lVarArr2.length) {
                        break;
                    }
                    l lVar = lVarArr2[i];
                    if (lVar != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, lVar);
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
                    this.a = codedInputByteBufferNano.readBytes();
                } else if (tag == 18) {
                    this.b = codedInputByteBufferNano.readBytes();
                } else if (tag == 26) {
                    if (this.c == null) {
                        this.c = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.c);
                } else if (tag == 34) {
                    if (this.d == null) {
                        this.d = new i();
                    }
                    codedInputByteBufferNano.readMessage(this.d);
                } else if (tag == 42) {
                    if (this.e == null) {
                        this.e = new j();
                    }
                    codedInputByteBufferNano.readMessage(this.e);
                } else if (tag == 50) {
                    if (this.f == null) {
                        this.f = new j();
                    }
                    codedInputByteBufferNano.readMessage(this.f);
                } else if (tag == 58) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    l[] lVarArr = this.g;
                    int length = lVarArr == null ? 0 : lVarArr.length;
                    int i = repeatedFieldArrayLength + length;
                    l[] lVarArr2 = new l[i];
                    if (length != 0) {
                        System.arraycopy(lVarArr, 0, lVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        l lVar = new l();
                        lVarArr2[length] = lVar;
                        codedInputByteBufferNano.readMessage(lVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    l lVar2 = new l();
                    lVarArr2[length] = lVar2;
                    codedInputByteBufferNano.readMessage(lVar2);
                    this.g = lVarArr2;
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
            d dVar = this.c;
            if (dVar != null) {
                codedOutputByteBufferNano.writeMessage(3, dVar);
            }
            i iVar = this.d;
            if (iVar != null) {
                codedOutputByteBufferNano.writeMessage(4, iVar);
            }
            j jVar = this.e;
            if (jVar != null) {
                codedOutputByteBufferNano.writeMessage(5, jVar);
            }
            j jVar2 = this.f;
            if (jVar2 != null) {
                codedOutputByteBufferNano.writeMessage(6, jVar2);
            }
            l[] lVarArr = this.g;
            if (lVarArr != null && lVarArr.length > 0) {
                int i = 0;
                while (true) {
                    l[] lVarArr2 = this.g;
                    if (i >= lVarArr2.length) {
                        break;
                    }
                    l lVar = lVarArr2[i];
                    if (lVar != null) {
                        codedOutputByteBufferNano.writeMessage(7, lVar);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$l */
    public static final class l extends MessageNano {
        private static volatile l[] b;
        public byte[] a;

        public l() {
            a();
        }

        public static l[] b() {
            if (b == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (b == null) {
                            b = new l[0];
                        }
                    } finally {
                    }
                }
            }
            return b;
        }

        public l a() {
            this.a = WireFormatNano.EMPTY_BYTES;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !Arrays.equals(this.a, WireFormatNano.EMPTY_BYTES) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(1, this.a) : iComputeSerializedSize;
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
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$m */
    public static final class m extends MessageNano {
        public byte[] a;
        public byte[] b;
        public n c;

        public m() {
            a();
        }

        public m a() {
            byte[] bArr = WireFormatNano.EMPTY_BYTES;
            this.a = bArr;
            this.b = bArr;
            this.c = null;
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
            if (!Arrays.equals(this.b, bArr2)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
            }
            n nVar = this.c;
            return nVar != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, nVar) : iComputeSerializedSize;
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
                } else if (tag == 26) {
                    if (this.c == null) {
                        this.c = new n();
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
            byte[] bArr = this.a;
            byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
            if (!Arrays.equals(bArr, bArr2)) {
                codedOutputByteBufferNano.writeBytes(1, this.a);
            }
            if (!Arrays.equals(this.b, bArr2)) {
                codedOutputByteBufferNano.writeBytes(2, this.b);
            }
            n nVar = this.c;
            if (nVar != null) {
                codedOutputByteBufferNano.writeMessage(3, nVar);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$n */
    public static final class n extends MessageNano {
        public byte[] a;
        public d b;
        public byte[] c;
        public i d;

        public n() {
            a();
        }

        public n a() {
            byte[] bArr = WireFormatNano.EMPTY_BYTES;
            this.a = bArr;
            this.b = null;
            this.c = bArr;
            this.d = null;
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
            d dVar = this.b;
            if (dVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, dVar);
            }
            if (!Arrays.equals(this.c, bArr2)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.c);
            }
            i iVar = this.d;
            return iVar != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, iVar) : iComputeSerializedSize;
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
                    if (this.b == null) {
                        this.b = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                } else if (tag == 26) {
                    this.c = codedInputByteBufferNano.readBytes();
                } else if (tag == 34) {
                    if (this.d == null) {
                        this.d = new i();
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
            byte[] bArr = this.a;
            byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
            if (!Arrays.equals(bArr, bArr2)) {
                codedOutputByteBufferNano.writeBytes(1, this.a);
            }
            d dVar = this.b;
            if (dVar != null) {
                codedOutputByteBufferNano.writeMessage(2, dVar);
            }
            if (!Arrays.equals(this.c, bArr2)) {
                codedOutputByteBufferNano.writeBytes(3, this.c);
            }
            i iVar = this.d;
            if (iVar != null) {
                codedOutputByteBufferNano.writeMessage(4, iVar);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$o */
    public static final class o extends MessageNano {
        public k a;
        public n b;

        public o() {
            a();
        }

        public o a() {
            this.a = null;
            this.b = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            k kVar = this.a;
            if (kVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, kVar);
            }
            n nVar = this.b;
            return nVar != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, nVar) : iComputeSerializedSize;
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
                        this.a = new k();
                    }
                    codedInputByteBufferNano.readMessage(this.a);
                } else if (tag == 18) {
                    if (this.b == null) {
                        this.b = new n();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            k kVar = this.a;
            if (kVar != null) {
                codedOutputByteBufferNano.writeMessage(1, kVar);
            }
            n nVar = this.b;
            if (nVar != null) {
                codedOutputByteBufferNano.writeMessage(2, nVar);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$p */
    public static final class p extends MessageNano {
        public k a;
        public m b;

        public p() {
            a();
        }

        public p a() {
            this.a = null;
            this.b = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            k kVar = this.a;
            if (kVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, kVar);
            }
            m mVar = this.b;
            return mVar != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, mVar) : iComputeSerializedSize;
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
                        this.a = new k();
                    }
                    codedInputByteBufferNano.readMessage(this.a);
                } else if (tag == 18) {
                    if (this.b == null) {
                        this.b = new m();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            k kVar = this.a;
            if (kVar != null) {
                codedOutputByteBufferNano.writeMessage(1, kVar);
            }
            m mVar = this.b;
            if (mVar != null) {
                codedOutputByteBufferNano.writeMessage(2, mVar);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.mf$q */
    public static final class q extends MessageNano {
        public n a;

        public q() {
            a();
        }

        public q a() {
            this.a = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            n nVar = this.a;
            return nVar != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, nVar) : iComputeSerializedSize;
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
                        this.a = new n();
                    }
                    codedInputByteBufferNano.readMessage(this.a);
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            n nVar = this.a;
            if (nVar != null) {
                codedOutputByteBufferNano.writeMessage(1, nVar);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public C1100mf() {
        a();
    }

    public C1100mf a() {
        this.a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i2 = this.a;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i2);
        }
        q qVar = this.b;
        if (qVar != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, qVar);
        }
        o oVar = this.c;
        if (oVar != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, oVar);
        }
        p pVar = this.d;
        if (pVar != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, pVar);
        }
        b bVar = this.e;
        if (bVar != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, bVar);
        }
        h hVar = this.f;
        return hVar != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, hVar) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag != 0) {
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    switch (int32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            this.a = int32;
                            break;
                    }
                } else if (tag == 18) {
                    if (this.b == null) {
                        this.b = new q();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                } else if (tag == 26) {
                    if (this.c == null) {
                        this.c = new o();
                    }
                    codedInputByteBufferNano.readMessage(this.c);
                } else if (tag == 34) {
                    if (this.d == null) {
                        this.d = new p();
                    }
                    codedInputByteBufferNano.readMessage(this.d);
                } else if (tag == 42) {
                    if (this.e == null) {
                        this.e = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.e);
                } else if (tag == 50) {
                    if (this.f == null) {
                        this.f = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f);
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                }
            }
        }
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i2 = this.a;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i2);
        }
        q qVar = this.b;
        if (qVar != null) {
            codedOutputByteBufferNano.writeMessage(2, qVar);
        }
        o oVar = this.c;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(3, oVar);
        }
        p pVar = this.d;
        if (pVar != null) {
            codedOutputByteBufferNano.writeMessage(4, pVar);
        }
        b bVar = this.e;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(5, bVar);
        }
        h hVar = this.f;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(6, hVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
