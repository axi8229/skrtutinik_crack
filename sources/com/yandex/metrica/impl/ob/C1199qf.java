package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import com.yandex.varioqub.config.model.ConfigValue;
import java.io.IOException;
import java.util.Arrays;
import org.pjsip.pjsua2.pjsip_status_code;

/* renamed from: com.yandex.metrica.impl.ob.qf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1199qf extends MessageNano {
    public d[] a;
    public c b;
    public a[] c;
    public e[] d;
    public String[] e;

    /* renamed from: com.yandex.metrica.impl.ob.qf$a */
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

    /* renamed from: com.yandex.metrica.impl.ob.qf$b */
    public static final class b extends MessageNano {
        public double a;
        public double b;
        public long c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public String i;

        public b() {
            a();
        }

        public b a() {
            this.a = ConfigValue.DOUBLE_DEFAULT_VALUE;
            this.b = ConfigValue.DOUBLE_DEFAULT_VALUE;
            this.c = 0L;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeDoubleSize(1, this.a) + CodedOutputByteBufferNano.computeDoubleSize(2, this.b);
            long j = this.c;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            int i = this.d;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
            }
            int i2 = this.e;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i2);
            }
            int i3 = this.f;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
            }
            int i4 = this.g;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i4);
            }
            int i5 = this.h;
            if (i5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i5);
            }
            return !this.i.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    break;
                }
                if (tag == 9) {
                    this.a = codedInputByteBufferNano.readDouble();
                } else if (tag == 17) {
                    this.b = codedInputByteBufferNano.readDouble();
                } else if (tag == 24) {
                    this.c = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.d = codedInputByteBufferNano.readUInt32();
                } else if (tag == 40) {
                    this.e = codedInputByteBufferNano.readUInt32();
                } else if (tag == 48) {
                    this.f = codedInputByteBufferNano.readUInt32();
                } else if (tag == 56) {
                    this.g = codedInputByteBufferNano.readInt32();
                } else if (tag == 64) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.h = int32;
                    }
                } else if (tag == 74) {
                    this.i = codedInputByteBufferNano.readString();
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            codedOutputByteBufferNano.writeDouble(1, this.a);
            codedOutputByteBufferNano.writeDouble(2, this.b);
            long j = this.c;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            int i = this.d;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            int i2 = this.e;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i2);
            }
            int i3 = this.f;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i3);
            }
            int i4 = this.g;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeInt32(7, i4);
            }
            int i5 = this.h;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeInt32(8, i5);
            }
            if (!this.i.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.qf$c */
    public static final class c extends MessageNano {
        public String a;
        public String b;
        public String c;
        public int d;
        public String e;
        public String f;
        public boolean g;
        public int h;
        public String i;
        public String j;
        public int k;
        public a[] l;
        public String m;

        /* renamed from: com.yandex.metrica.impl.ob.qf$c$a */
        public static final class a extends MessageNano {
            private static volatile a[] c;
            public String a;
            public long b;

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
                this.b = 0L;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            protected int computeSerializedSize() {
                return super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b);
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
                    } else if (tag == 16) {
                        this.b = codedInputByteBufferNano.readUInt64();
                    } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        break;
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                codedOutputByteBufferNano.writeString(1, this.a);
                codedOutputByteBufferNano.writeUInt64(2, this.b);
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public c() {
            a();
        }

        public c a() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = 0;
            this.e = "";
            this.f = "";
            this.g = false;
            this.h = 0;
            this.i = "";
            this.j = "";
            this.k = 0;
            this.l = a.b();
            this.m = "";
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
            if (!this.c.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.c);
            }
            int i = this.d;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i);
            }
            if (!this.e.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.e);
            }
            if (!this.f.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f);
            }
            boolean z = this.g;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(17, z);
            }
            int i2 = this.h;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(18, i2);
            }
            if (!this.i.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.i);
            }
            if (!this.j.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.j);
            }
            int i3 = this.k;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(22, i3);
            }
            a[] aVarArr = this.l;
            if (aVarArr != null && aVarArr.length > 0) {
                int i4 = 0;
                while (true) {
                    a[] aVarArr2 = this.l;
                    if (i4 >= aVarArr2.length) {
                        break;
                    }
                    a aVar = aVarArr2[i4];
                    if (aVar != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(23, aVar);
                    }
                    i4++;
                }
            }
            return !this.m.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(24, this.m) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.a = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.b = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.c = codedInputByteBufferNano.readString();
                        break;
                    case 40:
                        this.d = codedInputByteBufferNano.readUInt32();
                        break;
                    case 82:
                        this.e = codedInputByteBufferNano.readString();
                        break;
                    case 122:
                        this.f = codedInputByteBufferNano.readString();
                        break;
                    case 136:
                        this.g = codedInputByteBufferNano.readBool();
                        break;
                    case 144:
                        this.h = codedInputByteBufferNano.readUInt32();
                        break;
                    case 154:
                        this.i = codedInputByteBufferNano.readString();
                        break;
                    case 170:
                        this.j = codedInputByteBufferNano.readString();
                        break;
                    case 176:
                        this.k = codedInputByteBufferNano.readUInt32();
                        break;
                    case 186:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 186);
                        a[] aVarArr = this.l;
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
                        this.l = aVarArr2;
                        break;
                    case 194:
                        this.m = codedInputByteBufferNano.readString();
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
            if (!this.a.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.a);
            }
            if (!this.b.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.b);
            }
            if (!this.c.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.c);
            }
            int i = this.d;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i);
            }
            if (!this.e.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.e);
            }
            if (!this.f.equals("")) {
                codedOutputByteBufferNano.writeString(15, this.f);
            }
            boolean z = this.g;
            if (z) {
                codedOutputByteBufferNano.writeBool(17, z);
            }
            int i2 = this.h;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(18, i2);
            }
            if (!this.i.equals("")) {
                codedOutputByteBufferNano.writeString(19, this.i);
            }
            if (!this.j.equals("")) {
                codedOutputByteBufferNano.writeString(21, this.j);
            }
            int i3 = this.k;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(22, i3);
            }
            a[] aVarArr = this.l;
            if (aVarArr != null && aVarArr.length > 0) {
                int i4 = 0;
                while (true) {
                    a[] aVarArr2 = this.l;
                    if (i4 >= aVarArr2.length) {
                        break;
                    }
                    a aVar = aVarArr2[i4];
                    if (aVar != null) {
                        codedOutputByteBufferNano.writeMessage(23, aVar);
                    }
                    i4++;
                }
            }
            if (!this.m.equals("")) {
                codedOutputByteBufferNano.writeString(24, this.m);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.qf$d */
    public static final class d extends MessageNano {
        private static volatile d[] d;
        public long a;
        public b b;
        public a[] c;

        /* renamed from: com.yandex.metrica.impl.ob.qf$d$a */
        public static final class a extends MessageNano {
            private static volatile a[] y;
            public long a;
            public long b;
            public int c;
            public String d;
            public byte[] e;
            public b f;
            public c g;
            public String h;
            public C0293a i;
            public int j;
            public int k;
            public int l;
            public byte[] m;
            public int n;
            public long o;
            public long p;
            public int q;
            public int r;
            public int s;
            public int t;
            public int u;
            public boolean v;
            public long w;
            public b[] x;

            /* renamed from: com.yandex.metrica.impl.ob.qf$d$a$a, reason: collision with other inner class name */
            public static final class C0293a extends MessageNano {
                public String a;
                public String b;
                public String c;

                public C0293a() {
                    a();
                }

                public C0293a a() {
                    this.a = "";
                    this.b = "";
                    this.c = "";
                    this.cachedSize = -1;
                    return this;
                }

                @Override // com.google.protobuf.nano.ym.MessageNano
                protected int computeSerializedSize() {
                    int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.a);
                    if (!this.b.equals("")) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
                    }
                    return !this.c.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.c) : iComputeSerializedSize;
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
                            this.c = codedInputByteBufferNano.readString();
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
                    if (!this.c.equals("")) {
                        codedOutputByteBufferNano.writeString(3, this.c);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }
            }

            /* renamed from: com.yandex.metrica.impl.ob.qf$d$a$b */
            public static final class b extends MessageNano {
                private static volatile b[] c;
                public byte[] a;
                public byte[] b;

                public b() {
                    a();
                }

                public static b[] b() {
                    if (c == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            try {
                                if (c == null) {
                                    c = new b[0];
                                }
                            } finally {
                            }
                        }
                    }
                    return c;
                }

                public b a() {
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

            /* renamed from: com.yandex.metrica.impl.ob.qf$d$a$c */
            public static final class c extends MessageNano {
                public C1150of[] a;
                public C1222rf[] b;
                public int c;
                public String d;

                public c() {
                    a();
                }

                public c a() {
                    this.a = C1150of.b();
                    this.b = C1222rf.b();
                    this.c = 2;
                    this.d = "";
                    this.cachedSize = -1;
                    return this;
                }

                @Override // com.google.protobuf.nano.ym.MessageNano
                protected int computeSerializedSize() {
                    int iComputeSerializedSize = super.computeSerializedSize();
                    C1150of[] c1150ofArr = this.a;
                    int i = 0;
                    if (c1150ofArr != null && c1150ofArr.length > 0) {
                        int i2 = 0;
                        while (true) {
                            C1150of[] c1150ofArr2 = this.a;
                            if (i2 >= c1150ofArr2.length) {
                                break;
                            }
                            C1150of c1150of = c1150ofArr2[i2];
                            if (c1150of != null) {
                                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c1150of);
                            }
                            i2++;
                        }
                    }
                    C1222rf[] c1222rfArr = this.b;
                    if (c1222rfArr != null && c1222rfArr.length > 0) {
                        while (true) {
                            C1222rf[] c1222rfArr2 = this.b;
                            if (i >= c1222rfArr2.length) {
                                break;
                            }
                            C1222rf c1222rf = c1222rfArr2[i];
                            if (c1222rf != null) {
                                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c1222rf);
                            }
                            i++;
                        }
                    }
                    int i3 = this.c;
                    if (i3 != 2) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
                    }
                    return !this.d.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.d) : iComputeSerializedSize;
                }

                @Override // com.google.protobuf.nano.ym.MessageNano
                public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int tag = codedInputByteBufferNano.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                                C1150of[] c1150ofArr = this.a;
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
                                this.a = c1150ofArr2;
                            } else if (tag == 18) {
                                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                                C1222rf[] c1222rfArr = this.b;
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
                                this.b = c1222rfArr2;
                            } else if (tag == 24) {
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
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                        this.c = int32;
                                        break;
                                }
                            } else if (tag == 34) {
                                this.d = codedInputByteBufferNano.readString();
                            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            }
                        }
                    }
                    return this;
                }

                @Override // com.google.protobuf.nano.ym.MessageNano
                public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    C1150of[] c1150ofArr = this.a;
                    int i = 0;
                    if (c1150ofArr != null && c1150ofArr.length > 0) {
                        int i2 = 0;
                        while (true) {
                            C1150of[] c1150ofArr2 = this.a;
                            if (i2 >= c1150ofArr2.length) {
                                break;
                            }
                            C1150of c1150of = c1150ofArr2[i2];
                            if (c1150of != null) {
                                codedOutputByteBufferNano.writeMessage(1, c1150of);
                            }
                            i2++;
                        }
                    }
                    C1222rf[] c1222rfArr = this.b;
                    if (c1222rfArr != null && c1222rfArr.length > 0) {
                        while (true) {
                            C1222rf[] c1222rfArr2 = this.b;
                            if (i >= c1222rfArr2.length) {
                                break;
                            }
                            C1222rf c1222rf = c1222rfArr2[i];
                            if (c1222rf != null) {
                                codedOutputByteBufferNano.writeMessage(2, c1222rf);
                            }
                            i++;
                        }
                    }
                    int i3 = this.c;
                    if (i3 != 2) {
                        codedOutputByteBufferNano.writeInt32(3, i3);
                    }
                    if (!this.d.equals("")) {
                        codedOutputByteBufferNano.writeString(4, this.d);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }
            }

            public a() {
                a();
            }

            public static a[] b() {
                if (y == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        try {
                            if (y == null) {
                                y = new a[0];
                            }
                        } finally {
                        }
                    }
                }
                return y;
            }

            public a a() {
                this.a = 0L;
                this.b = 0L;
                this.c = 0;
                this.d = "";
                byte[] bArr = WireFormatNano.EMPTY_BYTES;
                this.e = bArr;
                this.f = null;
                this.g = null;
                this.h = "";
                this.i = null;
                this.j = 0;
                this.k = 0;
                this.l = -1;
                this.m = bArr;
                this.n = -1;
                this.o = 0L;
                this.p = 0L;
                this.q = 0;
                this.r = 0;
                this.s = -1;
                this.t = 0;
                this.u = 0;
                this.v = false;
                this.w = 1L;
                this.x = b.b();
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeUInt32Size(3, this.c);
                if (!this.d.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.d);
                }
                byte[] bArr = this.e;
                byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
                if (!Arrays.equals(bArr, bArr2)) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.e);
                }
                b bVar = this.f;
                if (bVar != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, bVar);
                }
                c cVar = this.g;
                if (cVar != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, cVar);
                }
                if (!this.h.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.h);
                }
                C0293a c0293a = this.i;
                if (c0293a != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, c0293a);
                }
                int i = this.j;
                if (i != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i);
                }
                int i2 = this.k;
                if (i2 != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i2);
                }
                int i3 = this.l;
                if (i3 != -1) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, i3);
                }
                if (!Arrays.equals(this.m, bArr2)) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(14, this.m);
                }
                int i4 = this.n;
                if (i4 != -1) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, i4);
                }
                long j = this.o;
                if (j != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(16, j);
                }
                long j2 = this.p;
                if (j2 != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(17, j2);
                }
                int i5 = this.q;
                if (i5 != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(18, i5);
                }
                int i6 = this.r;
                if (i6 != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(19, i6);
                }
                int i7 = this.s;
                if (i7 != -1) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(20, i7);
                }
                int i8 = this.t;
                if (i8 != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(21, i8);
                }
                int i9 = this.u;
                if (i9 != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(22, i9);
                }
                boolean z = this.v;
                if (z) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(23, z);
                }
                long j3 = this.w;
                if (j3 != 1) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(24, j3);
                }
                b[] bVarArr = this.x;
                if (bVarArr != null && bVarArr.length > 0) {
                    int i10 = 0;
                    while (true) {
                        b[] bVarArr2 = this.x;
                        if (i10 >= bVarArr2.length) {
                            break;
                        }
                        b bVar2 = bVarArr2[i10];
                        if (bVar2 != null) {
                            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(25, bVar2);
                        }
                        i10++;
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
                        case 8:
                            this.a = codedInputByteBufferNano.readUInt64();
                            break;
                        case 16:
                            this.b = codedInputByteBufferNano.readUInt64();
                            break;
                        case 24:
                            this.c = codedInputByteBufferNano.readUInt32();
                            break;
                        case 34:
                            this.d = codedInputByteBufferNano.readString();
                            break;
                        case 42:
                            this.e = codedInputByteBufferNano.readBytes();
                            break;
                        case 50:
                            if (this.f == null) {
                                this.f = new b();
                            }
                            codedInputByteBufferNano.readMessage(this.f);
                            break;
                        case 58:
                            if (this.g == null) {
                                this.g = new c();
                            }
                            codedInputByteBufferNano.readMessage(this.g);
                            break;
                        case 66:
                            this.h = codedInputByteBufferNano.readString();
                            break;
                        case 74:
                            if (this.i == null) {
                                this.i = new C0293a();
                            }
                            codedInputByteBufferNano.readMessage(this.i);
                            break;
                        case 80:
                            this.j = codedInputByteBufferNano.readUInt32();
                            break;
                        case 96:
                            int int32 = codedInputByteBufferNano.readInt32();
                            if (int32 != 0 && int32 != 1 && int32 != 2) {
                                break;
                            } else {
                                this.k = int32;
                                break;
                            }
                            break;
                        case 104:
                            int int322 = codedInputByteBufferNano.readInt32();
                            if (int322 != -1 && int322 != 0 && int322 != 1) {
                                break;
                            } else {
                                this.l = int322;
                                break;
                            }
                            break;
                        case 114:
                            this.m = codedInputByteBufferNano.readBytes();
                            break;
                        case 120:
                            int int323 = codedInputByteBufferNano.readInt32();
                            if (int323 != -1 && int323 != 0 && int323 != 1) {
                                break;
                            } else {
                                this.n = int323;
                                break;
                            }
                        case 128:
                            this.o = codedInputByteBufferNano.readUInt64();
                            break;
                        case 136:
                            this.p = codedInputByteBufferNano.readUInt64();
                            break;
                        case 144:
                            int int324 = codedInputByteBufferNano.readInt32();
                            if (int324 != 0 && int324 != 1 && int324 != 2 && int324 != 3 && int324 != 4) {
                                break;
                            } else {
                                this.q = int324;
                                break;
                            }
                        case 152:
                            int int325 = codedInputByteBufferNano.readInt32();
                            if (int325 != 0 && int325 != 1 && int325 != 2 && int325 != 3) {
                                break;
                            } else {
                                this.r = int325;
                                break;
                            }
                            break;
                        case 160:
                            int int326 = codedInputByteBufferNano.readInt32();
                            if (int326 != -1 && int326 != 0 && int326 != 1) {
                                break;
                            } else {
                                this.s = int326;
                                break;
                            }
                            break;
                        case 168:
                            int int327 = codedInputByteBufferNano.readInt32();
                            if (int327 != 0 && int327 != 1 && int327 != 2 && int327 != 3) {
                                break;
                            } else {
                                this.t = int327;
                                break;
                            }
                            break;
                        case 176:
                            int int328 = codedInputByteBufferNano.readInt32();
                            if (int328 != 0 && int328 != 1) {
                                break;
                            } else {
                                this.u = int328;
                                break;
                            }
                            break;
                        case 184:
                            this.v = codedInputByteBufferNano.readBool();
                            break;
                        case 192:
                            this.w = codedInputByteBufferNano.readUInt64();
                            break;
                        case pjsip_status_code.PJSIP_SC_ACCEPTED /* 202 */:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, pjsip_status_code.PJSIP_SC_ACCEPTED);
                            b[] bVarArr = this.x;
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
                            this.x = bVarArr2;
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
                codedOutputByteBufferNano.writeUInt32(3, this.c);
                if (!this.d.equals("")) {
                    codedOutputByteBufferNano.writeString(4, this.d);
                }
                byte[] bArr = this.e;
                byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
                if (!Arrays.equals(bArr, bArr2)) {
                    codedOutputByteBufferNano.writeBytes(5, this.e);
                }
                b bVar = this.f;
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, bVar);
                }
                c cVar = this.g;
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(7, cVar);
                }
                if (!this.h.equals("")) {
                    codedOutputByteBufferNano.writeString(8, this.h);
                }
                C0293a c0293a = this.i;
                if (c0293a != null) {
                    codedOutputByteBufferNano.writeMessage(9, c0293a);
                }
                int i = this.j;
                if (i != 0) {
                    codedOutputByteBufferNano.writeUInt32(10, i);
                }
                int i2 = this.k;
                if (i2 != 0) {
                    codedOutputByteBufferNano.writeInt32(12, i2);
                }
                int i3 = this.l;
                if (i3 != -1) {
                    codedOutputByteBufferNano.writeInt32(13, i3);
                }
                if (!Arrays.equals(this.m, bArr2)) {
                    codedOutputByteBufferNano.writeBytes(14, this.m);
                }
                int i4 = this.n;
                if (i4 != -1) {
                    codedOutputByteBufferNano.writeInt32(15, i4);
                }
                long j = this.o;
                if (j != 0) {
                    codedOutputByteBufferNano.writeUInt64(16, j);
                }
                long j2 = this.p;
                if (j2 != 0) {
                    codedOutputByteBufferNano.writeUInt64(17, j2);
                }
                int i5 = this.q;
                if (i5 != 0) {
                    codedOutputByteBufferNano.writeInt32(18, i5);
                }
                int i6 = this.r;
                if (i6 != 0) {
                    codedOutputByteBufferNano.writeInt32(19, i6);
                }
                int i7 = this.s;
                if (i7 != -1) {
                    codedOutputByteBufferNano.writeInt32(20, i7);
                }
                int i8 = this.t;
                if (i8 != 0) {
                    codedOutputByteBufferNano.writeInt32(21, i8);
                }
                int i9 = this.u;
                if (i9 != 0) {
                    codedOutputByteBufferNano.writeInt32(22, i9);
                }
                boolean z = this.v;
                if (z) {
                    codedOutputByteBufferNano.writeBool(23, z);
                }
                long j3 = this.w;
                if (j3 != 1) {
                    codedOutputByteBufferNano.writeUInt64(24, j3);
                }
                b[] bVarArr = this.x;
                if (bVarArr != null && bVarArr.length > 0) {
                    int i10 = 0;
                    while (true) {
                        b[] bVarArr2 = this.x;
                        if (i10 >= bVarArr2.length) {
                            break;
                        }
                        b bVar2 = bVarArr2[i10];
                        if (bVar2 != null) {
                            codedOutputByteBufferNano.writeMessage(25, bVar2);
                        }
                        i10++;
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        /* renamed from: com.yandex.metrica.impl.ob.qf$d$b */
        public static final class b extends MessageNano {
            public f a;
            public String b;
            public int c;

            public b() {
                a();
            }

            public b a() {
                this.a = null;
                this.b = "";
                this.c = 0;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                f fVar = this.a;
                if (fVar != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
                }
                int iComputeStringSize = iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.b);
                int i = this.c;
                return i != 0 ? iComputeStringSize + CodedOutputByteBufferNano.computeInt32Size(5, i) : iComputeStringSize;
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
                    } else if (tag == 18) {
                        this.b = codedInputByteBufferNano.readString();
                    } else if (tag == 40) {
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 == 0 || int32 == 1 || int32 == 2) {
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
                f fVar = this.a;
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, fVar);
                }
                codedOutputByteBufferNano.writeString(2, this.b);
                int i = this.c;
                if (i != 0) {
                    codedOutputByteBufferNano.writeInt32(5, i);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public d() {
            a();
        }

        public static d[] b() {
            if (d == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (d == null) {
                            d = new d[0];
                        }
                    } finally {
                    }
                }
            }
            return d;
        }

        public d a() {
            this.a = 0L;
            this.b = null;
            this.c = a.b();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a);
            b bVar = this.b;
            if (bVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
            }
            a[] aVarArr = this.c;
            if (aVarArr != null && aVarArr.length > 0) {
                int i = 0;
                while (true) {
                    a[] aVarArr2 = this.c;
                    if (i >= aVarArr2.length) {
                        break;
                    }
                    a aVar = aVarArr2[i];
                    if (aVar != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
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
                if (tag == 8) {
                    this.a = codedInputByteBufferNano.readUInt64();
                } else if (tag == 18) {
                    if (this.b == null) {
                        this.b = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    a[] aVarArr = this.c;
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
                    this.c = aVarArr2;
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            codedOutputByteBufferNano.writeUInt64(1, this.a);
            b bVar = this.b;
            if (bVar != null) {
                codedOutputByteBufferNano.writeMessage(2, bVar);
            }
            a[] aVarArr = this.c;
            if (aVarArr != null && aVarArr.length > 0) {
                int i = 0;
                while (true) {
                    a[] aVarArr2 = this.c;
                    if (i >= aVarArr2.length) {
                        break;
                    }
                    a aVar = aVarArr2[i];
                    if (aVar != null) {
                        codedOutputByteBufferNano.writeMessage(3, aVar);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.qf$e */
    public static final class e extends MessageNano {
        private static volatile e[] e;
        public int a;
        public int b;
        public String c;
        public boolean d;

        public e() {
            a();
        }

        public static e[] b() {
            if (e == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (e == null) {
                            e = new e[0];
                        }
                    } finally {
                    }
                }
            }
            return e;
        }

        public e a() {
            this.a = 0;
            this.b = 0;
            this.c = "";
            this.d = false;
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
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            if (!this.c.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.c);
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
                if (tag == 8) {
                    this.a = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.b = codedInputByteBufferNano.readUInt32();
                } else if (tag == 26) {
                    this.c = codedInputByteBufferNano.readString();
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
            int i = this.a;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            int i2 = this.b;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            if (!this.c.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.c);
            }
            boolean z = this.d;
            if (z) {
                codedOutputByteBufferNano.writeBool(4, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.qf$f */
    public static final class f extends MessageNano {
        public long a;
        public int b;
        public long c;
        public boolean d;

        public f() {
            a();
        }

        public f a() {
            this.a = 0L;
            this.b = 0;
            this.c = 0L;
            this.d = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.a) + CodedOutputByteBufferNano.computeSInt32Size(2, this.b);
            long j = this.c;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j);
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
                if (tag == 8) {
                    this.a = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.b = codedInputByteBufferNano.readSInt32();
                } else if (tag == 24) {
                    this.c = codedInputByteBufferNano.readInt64();
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
            codedOutputByteBufferNano.writeUInt64(1, this.a);
            codedOutputByteBufferNano.writeSInt32(2, this.b);
            long j = this.c;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(3, j);
            }
            boolean z = this.d;
            if (z) {
                codedOutputByteBufferNano.writeBool(4, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public C1199qf() {
        a();
    }

    public C1199qf a() {
        this.a = d.b();
        this.b = null;
        this.c = a.b();
        this.d = e.b();
        this.e = WireFormatNano.EMPTY_STRING_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        d[] dVarArr = this.a;
        int i = 0;
        if (dVarArr != null && dVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                d[] dVarArr2 = this.a;
                if (i2 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i2];
                if (dVar != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, dVar);
                }
                i2++;
            }
        }
        c cVar = this.b;
        if (cVar != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, cVar);
        }
        a[] aVarArr = this.c;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                a[] aVarArr2 = this.c;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, aVar);
                }
                i3++;
            }
        }
        e[] eVarArr = this.d;
        if (eVarArr != null && eVarArr.length > 0) {
            int i4 = 0;
            while (true) {
                e[] eVarArr2 = this.d;
                if (i4 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i4];
                if (eVar != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, eVar);
                }
                i4++;
            }
        }
        String[] strArr = this.e;
        if (strArr == null || strArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int iComputeStringSizeNoTag = 0;
        int i5 = 0;
        while (true) {
            String[] strArr2 = this.e;
            if (i >= strArr2.length) {
                return iComputeSerializedSize + iComputeStringSizeNoTag + i5;
            }
            String str = strArr2[i];
            if (str != null) {
                i5++;
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
            if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                d[] dVarArr = this.a;
                int length = dVarArr == null ? 0 : dVarArr.length;
                int i = repeatedFieldArrayLength + length;
                d[] dVarArr2 = new d[i];
                if (length != 0) {
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                }
                while (length < i - 1) {
                    d dVar = new d();
                    dVarArr2[length] = dVar;
                    codedInputByteBufferNano.readMessage(dVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                d dVar2 = new d();
                dVarArr2[length] = dVar2;
                codedInputByteBufferNano.readMessage(dVar2);
                this.a = dVarArr2;
            } else if (tag == 34) {
                if (this.b == null) {
                    this.b = new c();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag == 58) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                a[] aVarArr = this.c;
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
                this.c = aVarArr2;
            } else if (tag == 82) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                e[] eVarArr = this.d;
                int length3 = eVarArr == null ? 0 : eVarArr.length;
                int i3 = repeatedFieldArrayLength3 + length3;
                e[] eVarArr2 = new e[i3];
                if (length3 != 0) {
                    System.arraycopy(eVarArr, 0, eVarArr2, 0, length3);
                }
                while (length3 < i3 - 1) {
                    e eVar = new e();
                    eVarArr2[length3] = eVar;
                    codedInputByteBufferNano.readMessage(eVar);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                e eVar2 = new e();
                eVarArr2[length3] = eVar2;
                codedInputByteBufferNano.readMessage(eVar2);
                this.d = eVarArr2;
            } else if (tag == 90) {
                int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                String[] strArr = this.e;
                int length4 = strArr == null ? 0 : strArr.length;
                int i4 = repeatedFieldArrayLength4 + length4;
                String[] strArr2 = new String[i4];
                if (length4 != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length4);
                }
                while (length4 < i4 - 1) {
                    strArr2[length4] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length4++;
                }
                strArr2[length4] = codedInputByteBufferNano.readString();
                this.e = strArr2;
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                break;
            }
        }
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        d[] dVarArr = this.a;
        int i = 0;
        if (dVarArr != null && dVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                d[] dVarArr2 = this.a;
                if (i2 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i2];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, dVar);
                }
                i2++;
            }
        }
        c cVar = this.b;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(4, cVar);
        }
        a[] aVarArr = this.c;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                a[] aVarArr2 = this.c;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(7, aVar);
                }
                i3++;
            }
        }
        e[] eVarArr = this.d;
        if (eVarArr != null && eVarArr.length > 0) {
            int i4 = 0;
            while (true) {
                e[] eVarArr2 = this.d;
                if (i4 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i4];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(10, eVar);
                }
                i4++;
            }
        }
        String[] strArr = this.e;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.e;
                if (i >= strArr2.length) {
                    break;
                }
                String str = strArr2[i];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(11, str);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
