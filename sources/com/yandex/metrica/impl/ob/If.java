package com.yandex.metrica.impl.ob;

import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.IOException;
import java.util.Arrays;
import org.pjsip.pjsua2.pjsip_status_code;
import org.pjsip.pjsua2.pjsip_transport_type_e;

/* loaded from: classes3.dex */
public final class If extends MessageNano {
    public String A;
    public String B;
    public long C;
    public long D;
    public boolean E;
    public n F;
    public j G;
    public int H;
    public int I;
    public w J;
    public v K;
    public v L;
    public v M;
    public t N;
    public c O;
    public f P;
    public String[] Q;
    public b R;
    public a S;
    public h T;
    public g U;
    public r V;
    public l[] W;
    public String a;
    public long b;
    public String[] c;
    public String d;
    public String e;
    public String[] f;
    public String[] g;
    public String[] h;
    public String[] i;
    public d[] j;
    public i k;
    public k[] l;
    public q m;
    public o[] n;
    public String o;
    public String p;
    public String q;
    public boolean r;
    public String s;
    public String[] t;
    public s u;
    public boolean v;
    public m[] w;
    public p x;
    public String y;
    public String z;

    public static final class a extends MessageNano {
        public b[] a;

        /* renamed from: com.yandex.metrica.impl.ob.If$a$a, reason: collision with other inner class name */
        public static final class C0284a extends MessageNano {
            public String a;

            public C0284a() {
                a();
            }

            public C0284a a() {
                this.a = "";
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                return !this.a.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.a) : iComputeSerializedSize;
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
                if (!this.a.equals("")) {
                    codedOutputByteBufferNano.writeString(1, this.a);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public static final class b extends MessageNano {
            private static volatile b[] c;
            public String a;
            public C0284a b;

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
                this.a = "";
                this.b = null;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                if (!this.a.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
                }
                C0284a c0284a = this.b;
                return c0284a != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, c0284a) : iComputeSerializedSize;
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
                        if (this.b == null) {
                            this.b = new C0284a();
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
                if (!this.a.equals("")) {
                    codedOutputByteBufferNano.writeString(1, this.a);
                }
                C0284a c0284a = this.b;
                if (c0284a != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0284a);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public a() {
            a();
        }

        public a a() {
            this.a = b.b();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            b[] bVarArr = this.a;
            if (bVarArr != null && bVarArr.length > 0) {
                int i = 0;
                while (true) {
                    b[] bVarArr2 = this.a;
                    if (i >= bVarArr2.length) {
                        break;
                    }
                    b bVar = bVarArr2[i];
                    if (bVar != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
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
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            b[] bVarArr = this.a;
            if (bVarArr != null && bVarArr.length > 0) {
                int i = 0;
                while (true) {
                    b[] bVarArr2 = this.a;
                    if (i >= bVarArr2.length) {
                        break;
                    }
                    b bVar = bVarArr2[i];
                    if (bVar != null) {
                        codedOutputByteBufferNano.writeMessage(1, bVar);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class b extends MessageNano {
        public int a;
        public int b;

        public b() {
            a();
        }

        public b a() {
            this.a = RemoteMessageConst.DEFAULT_TTL;
            this.b = RemoteMessageConst.DEFAULT_TTL;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.a;
            if (i != 86400) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            int i2 = this.b;
            return i2 != 86400 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    break;
                }
                if (tag == 8) {
                    this.a = codedInputByteBufferNano.readInt32();
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
            int i = this.a;
            if (i != 86400) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            int i2 = this.b;
            if (i2 != 86400) {
                codedOutputByteBufferNano.writeInt32(2, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class c extends MessageNano {
        public long a;
        public long b;
        public long c;
        public long d;

        public c() {
            a();
        }

        public c a() {
            this.a = DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
            this.b = DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
            this.c = DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
            this.d = DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.a;
            if (j != DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
            }
            long j2 = this.b;
            if (j2 != DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j2);
            }
            long j3 = this.c;
            if (j3 != DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j3);
            }
            long j4 = this.d;
            return j4 != DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(4, j4) : iComputeSerializedSize;
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
                    this.b = codedInputByteBufferNano.readInt64();
                } else if (tag == 24) {
                    this.c = codedInputByteBufferNano.readInt64();
                } else if (tag == 32) {
                    this.d = codedInputByteBufferNano.readInt64();
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            long j = this.a;
            if (j != DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
                codedOutputByteBufferNano.writeInt64(1, j);
            }
            long j2 = this.b;
            if (j2 != DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
                codedOutputByteBufferNano.writeInt64(2, j2);
            }
            long j3 = this.c;
            if (j3 != DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
                codedOutputByteBufferNano.writeInt64(3, j3);
            }
            long j4 = this.d;
            if (j4 != DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
                codedOutputByteBufferNano.writeInt64(4, j4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class d extends MessageNano {
        private static volatile d[] c;
        public String a;
        public String[] b;

        public d() {
            a();
        }

        public static d[] b() {
            if (c == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (c == null) {
                            c = new d[0];
                        }
                    } finally {
                    }
                }
            }
            return c;
        }

        public d a() {
            this.a = "";
            this.b = WireFormatNano.EMPTY_STRING_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.a.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
            }
            String[] strArr = this.b;
            if (strArr == null || strArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int i = 0;
            int iComputeStringSizeNoTag = 0;
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.b;
                if (i >= strArr2.length) {
                    return iComputeSerializedSize + iComputeStringSizeNoTag + i2;
                }
                String str = strArr2[i];
                if (str != null) {
                    i2++;
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
                    this.a = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    String[] strArr = this.b;
                    int length = strArr == null ? 0 : strArr.length;
                    int i = repeatedFieldArrayLength + length;
                    String[] strArr2 = new String[i];
                    if (length != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length);
                    }
                    while (length < i - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.b = strArr2;
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
            String[] strArr = this.b;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
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

    public static final class e extends MessageNano {
        public long a;
        public int b;

        public e() {
            a();
        }

        public e a() {
            this.a = 0L;
            this.b = RemoteMessageConst.DEFAULT_TTL;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt64Size(1, this.a);
            int i = this.b;
            return i != 86400 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
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
            codedOutputByteBufferNano.writeInt64(1, this.a);
            int i = this.b;
            if (i != 86400) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class f extends MessageNano {
        public e a;
        public e b;
        public e c;

        public f() {
            a();
        }

        public f a() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            e eVar = this.a;
            if (eVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
            }
            e eVar2 = this.b;
            if (eVar2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, eVar2);
            }
            e eVar3 = this.c;
            return eVar3 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, eVar3) : iComputeSerializedSize;
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
                        this.a = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.a);
                } else if (tag == 18) {
                    if (this.b == null) {
                        this.b = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                } else if (tag == 26) {
                    if (this.c == null) {
                        this.c = new e();
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
            e eVar = this.a;
            if (eVar != null) {
                codedOutputByteBufferNano.writeMessage(1, eVar);
            }
            e eVar2 = this.b;
            if (eVar2 != null) {
                codedOutputByteBufferNano.writeMessage(2, eVar2);
            }
            e eVar3 = this.c;
            if (eVar3 != null) {
                codedOutputByteBufferNano.writeMessage(3, eVar3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class g extends MessageNano {
        public long a;

        public g() {
            a();
        }

        public g a() {
            this.a = 1209600L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.a;
            return j != 1209600 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
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
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            long j = this.a;
            if (j != 1209600) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class h extends MessageNano {
        public String a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;

        public h() {
            a();
        }

        public h a() {
            this.a = "";
            this.b = pjsip_status_code.PJSIP_SC_BUSY_EVERYWHERE;
            this.c = 300;
            this.d = false;
            this.e = true;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.a.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
            }
            int i = this.b;
            if (i != 600) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            int i2 = this.c;
            if (i2 != 300) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            boolean z = this.d;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z);
            }
            boolean z2 = this.e;
            return !z2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z2) : iComputeSerializedSize;
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
                    this.b = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.c = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.d = codedInputByteBufferNano.readBool();
                } else if (tag == 40) {
                    this.e = codedInputByteBufferNano.readBool();
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
            int i = this.b;
            if (i != 600) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            int i2 = this.c;
            if (i2 != 300) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            boolean z = this.d;
            if (z) {
                codedOutputByteBufferNano.writeBool(4, z);
            }
            boolean z2 = this.e;
            if (!z2) {
                codedOutputByteBufferNano.writeBool(5, z2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class i extends MessageNano {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public boolean q;
        public boolean r;
        public boolean s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public int x;

        public i() {
            a();
        }

        public i a() {
            this.a = false;
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = false;
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = true;
            this.l = false;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = false;
            this.q = false;
            this.r = false;
            this.s = false;
            this.t = true;
            this.u = false;
            this.v = false;
            this.w = false;
            this.x = -1;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeBoolSize(1, this.a) + CodedOutputByteBufferNano.computeBoolSize(2, this.b) + CodedOutputByteBufferNano.computeBoolSize(3, this.c) + CodedOutputByteBufferNano.computeBoolSize(4, this.d) + CodedOutputByteBufferNano.computeBoolSize(6, this.e) + CodedOutputByteBufferNano.computeBoolSize(8, this.f) + CodedOutputByteBufferNano.computeBoolSize(9, this.g) + CodedOutputByteBufferNano.computeBoolSize(11, this.h) + CodedOutputByteBufferNano.computeBoolSize(12, this.i) + CodedOutputByteBufferNano.computeBoolSize(15, this.j) + CodedOutputByteBufferNano.computeBoolSize(16, this.k) + CodedOutputByteBufferNano.computeBoolSize(18, this.l) + CodedOutputByteBufferNano.computeBoolSize(19, this.m) + CodedOutputByteBufferNano.computeBoolSize(21, this.n) + CodedOutputByteBufferNano.computeBoolSize(22, this.o) + CodedOutputByteBufferNano.computeBoolSize(23, this.p) + CodedOutputByteBufferNano.computeBoolSize(24, this.q) + CodedOutputByteBufferNano.computeBoolSize(25, this.r) + CodedOutputByteBufferNano.computeBoolSize(26, this.s) + CodedOutputByteBufferNano.computeBoolSize(27, this.t) + CodedOutputByteBufferNano.computeBoolSize(28, this.u);
            boolean z = this.v;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(29, z);
            }
            boolean z2 = this.w;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(33, z2);
            }
            int i = this.x;
            return i != -1 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(34, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.a = codedInputByteBufferNano.readBool();
                        break;
                    case 16:
                        this.b = codedInputByteBufferNano.readBool();
                        break;
                    case 24:
                        this.c = codedInputByteBufferNano.readBool();
                        break;
                    case 32:
                        this.d = codedInputByteBufferNano.readBool();
                        break;
                    case 48:
                        this.e = codedInputByteBufferNano.readBool();
                        break;
                    case 64:
                        this.f = codedInputByteBufferNano.readBool();
                        break;
                    case 72:
                        this.g = codedInputByteBufferNano.readBool();
                        break;
                    case 88:
                        this.h = codedInputByteBufferNano.readBool();
                        break;
                    case 96:
                        this.i = codedInputByteBufferNano.readBool();
                        break;
                    case 120:
                        this.j = codedInputByteBufferNano.readBool();
                        break;
                    case 128:
                        this.k = codedInputByteBufferNano.readBool();
                        break;
                    case 144:
                        this.l = codedInputByteBufferNano.readBool();
                        break;
                    case 152:
                        this.m = codedInputByteBufferNano.readBool();
                        break;
                    case 168:
                        this.n = codedInputByteBufferNano.readBool();
                        break;
                    case 176:
                        this.o = codedInputByteBufferNano.readBool();
                        break;
                    case 184:
                        this.p = codedInputByteBufferNano.readBool();
                        break;
                    case 192:
                        this.q = codedInputByteBufferNano.readBool();
                        break;
                    case 200:
                        this.r = codedInputByteBufferNano.readBool();
                        break;
                    case 208:
                        this.s = codedInputByteBufferNano.readBool();
                        break;
                    case 216:
                        this.t = codedInputByteBufferNano.readBool();
                        break;
                    case 224:
                        this.u = codedInputByteBufferNano.readBool();
                        break;
                    case 232:
                        this.v = codedInputByteBufferNano.readBool();
                        break;
                    case 264:
                        this.w = codedInputByteBufferNano.readBool();
                        break;
                    case 272:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != -1 && int32 != 0 && int32 != 1) {
                            break;
                        } else {
                            this.x = int32;
                            break;
                        }
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
            codedOutputByteBufferNano.writeBool(1, this.a);
            codedOutputByteBufferNano.writeBool(2, this.b);
            codedOutputByteBufferNano.writeBool(3, this.c);
            codedOutputByteBufferNano.writeBool(4, this.d);
            codedOutputByteBufferNano.writeBool(6, this.e);
            codedOutputByteBufferNano.writeBool(8, this.f);
            codedOutputByteBufferNano.writeBool(9, this.g);
            codedOutputByteBufferNano.writeBool(11, this.h);
            codedOutputByteBufferNano.writeBool(12, this.i);
            codedOutputByteBufferNano.writeBool(15, this.j);
            codedOutputByteBufferNano.writeBool(16, this.k);
            codedOutputByteBufferNano.writeBool(18, this.l);
            codedOutputByteBufferNano.writeBool(19, this.m);
            codedOutputByteBufferNano.writeBool(21, this.n);
            codedOutputByteBufferNano.writeBool(22, this.o);
            codedOutputByteBufferNano.writeBool(23, this.p);
            codedOutputByteBufferNano.writeBool(24, this.q);
            codedOutputByteBufferNano.writeBool(25, this.r);
            codedOutputByteBufferNano.writeBool(26, this.s);
            codedOutputByteBufferNano.writeBool(27, this.t);
            codedOutputByteBufferNano.writeBool(28, this.u);
            boolean z = this.v;
            if (z) {
                codedOutputByteBufferNano.writeBool(29, z);
            }
            boolean z2 = this.w;
            if (z2) {
                codedOutputByteBufferNano.writeBool(33, z2);
            }
            int i = this.x;
            if (i != -1) {
                codedOutputByteBufferNano.writeInt32(34, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class j extends MessageNano {
        public long a;

        public j() {
            a();
        }

        public j a() {
            this.a = 900L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            return super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt64Size(1, this.a);
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
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            codedOutputByteBufferNano.writeInt64(1, this.a);
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class k extends MessageNano {
        private static volatile k[] c;
        public a a;
        public b b;

        public static final class a extends MessageNano {
            public long a;
            public float b;
            public int c;
            public int d;
            public long e;
            public int f;
            public boolean g;
            public boolean h;
            public boolean i;
            public long j;
            public C0285a k;
            public C0285a l;
            public C0285a m;
            public C0285a n;
            public b o;
            public boolean p;
            public boolean q;

            /* renamed from: com.yandex.metrica.impl.ob.If$k$a$a, reason: collision with other inner class name */
            public static final class C0285a extends MessageNano {
                public boolean a;
                public boolean b;
                public C0286a c;

                /* renamed from: com.yandex.metrica.impl.ob.If$k$a$a$a, reason: collision with other inner class name */
                public static final class C0286a extends MessageNano {
                    public long a;
                    public long b;

                    public C0286a() {
                        a();
                    }

                    public C0286a a() {
                        this.a = 0L;
                        this.b = 0L;
                        this.cachedSize = -1;
                        return this;
                    }

                    @Override // com.google.protobuf.nano.ym.MessageNano
                    protected int computeSerializedSize() {
                        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt64Size(1, this.a) + CodedOutputByteBufferNano.computeInt64Size(2, this.b);
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
                                this.b = codedInputByteBufferNano.readInt64();
                            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                                break;
                            }
                        }
                        return this;
                    }

                    @Override // com.google.protobuf.nano.ym.MessageNano
                    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                        codedOutputByteBufferNano.writeInt64(1, this.a);
                        codedOutputByteBufferNano.writeInt64(2, this.b);
                        super.writeTo(codedOutputByteBufferNano);
                    }
                }

                public C0285a() {
                    a();
                }

                public C0285a a() {
                    this.a = true;
                    this.b = false;
                    this.c = null;
                    this.cachedSize = -1;
                    return this;
                }

                @Override // com.google.protobuf.nano.ym.MessageNano
                protected int computeSerializedSize() {
                    int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeBoolSize(1, this.a) + CodedOutputByteBufferNano.computeBoolSize(2, this.b);
                    C0286a c0286a = this.c;
                    return c0286a != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, c0286a) : iComputeSerializedSize;
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
                        } else if (tag == 26) {
                            if (this.c == null) {
                                this.c = new C0286a();
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
                    codedOutputByteBufferNano.writeBool(1, this.a);
                    codedOutputByteBufferNano.writeBool(2, this.b);
                    C0286a c0286a = this.c;
                    if (c0286a != null) {
                        codedOutputByteBufferNano.writeMessage(3, c0286a);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }
            }

            public static final class b extends MessageNano {
                public boolean a;
                public boolean b;
                public C0287a c;

                /* renamed from: com.yandex.metrica.impl.ob.If$k$a$b$a, reason: collision with other inner class name */
                public static final class C0287a extends MessageNano {
                    public long a;
                    public long b;
                    public int c;

                    public C0287a() {
                        a();
                    }

                    public C0287a a() {
                        this.a = 0L;
                        this.b = 0L;
                        this.c = 0;
                        this.cachedSize = -1;
                        return this;
                    }

                    @Override // com.google.protobuf.nano.ym.MessageNano
                    protected int computeSerializedSize() {
                        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt64Size(1, this.a) + CodedOutputByteBufferNano.computeInt64Size(2, this.b) + CodedOutputByteBufferNano.computeInt32Size(3, this.c);
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
                                this.b = codedInputByteBufferNano.readInt64();
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
                        codedOutputByteBufferNano.writeInt64(1, this.a);
                        codedOutputByteBufferNano.writeInt64(2, this.b);
                        codedOutputByteBufferNano.writeInt32(3, this.c);
                        super.writeTo(codedOutputByteBufferNano);
                    }
                }

                public b() {
                    a();
                }

                public b a() {
                    this.a = true;
                    this.b = false;
                    this.c = null;
                    this.cachedSize = -1;
                    return this;
                }

                @Override // com.google.protobuf.nano.ym.MessageNano
                protected int computeSerializedSize() {
                    int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeBoolSize(1, this.a) + CodedOutputByteBufferNano.computeBoolSize(2, this.b);
                    C0287a c0287a = this.c;
                    return c0287a != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, c0287a) : iComputeSerializedSize;
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
                        } else if (tag == 26) {
                            if (this.c == null) {
                                this.c = new C0287a();
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
                    codedOutputByteBufferNano.writeBool(1, this.a);
                    codedOutputByteBufferNano.writeBool(2, this.b);
                    C0287a c0287a = this.c;
                    if (c0287a != null) {
                        codedOutputByteBufferNano.writeMessage(3, c0287a);
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }
            }

            public a() {
                a();
            }

            public a a() {
                this.a = DeviceOrientationRequest.OUTPUT_PERIOD_FAST;
                this.b = 10.0f;
                this.c = 20;
                this.d = 200;
                this.e = 60000L;
                this.f = 10000;
                this.g = false;
                this.h = false;
                this.i = true;
                this.j = 60000L;
                this.k = null;
                this.l = null;
                this.m = null;
                this.n = null;
                this.o = null;
                this.p = false;
                this.q = false;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt64Size(1, this.a) + CodedOutputByteBufferNano.computeFloatSize(2, this.b) + CodedOutputByteBufferNano.computeInt32Size(3, this.c) + CodedOutputByteBufferNano.computeInt32Size(4, this.d) + CodedOutputByteBufferNano.computeInt64Size(5, this.e) + CodedOutputByteBufferNano.computeInt32Size(6, this.f) + CodedOutputByteBufferNano.computeBoolSize(7, this.g) + CodedOutputByteBufferNano.computeBoolSize(8, this.h) + CodedOutputByteBufferNano.computeInt64Size(9, this.j);
                C0285a c0285a = this.k;
                if (c0285a != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, c0285a);
                }
                C0285a c0285a2 = this.l;
                if (c0285a2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, c0285a2);
                }
                C0285a c0285a3 = this.m;
                if (c0285a3 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, c0285a3);
                }
                int iComputeBoolSize = iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(13, this.i);
                C0285a c0285a4 = this.n;
                if (c0285a4 != null) {
                    iComputeBoolSize += CodedOutputByteBufferNano.computeMessageSize(14, c0285a4);
                }
                b bVar = this.o;
                if (bVar != null) {
                    iComputeBoolSize += CodedOutputByteBufferNano.computeMessageSize(15, bVar);
                }
                boolean z = this.p;
                if (z) {
                    iComputeBoolSize += CodedOutputByteBufferNano.computeBoolSize(16, z);
                }
                boolean z2 = this.q;
                return z2 ? iComputeBoolSize + CodedOutputByteBufferNano.computeBoolSize(17, z2) : iComputeBoolSize;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    switch (tag) {
                        case 0:
                            break;
                        case 8:
                            this.a = codedInputByteBufferNano.readInt64();
                            break;
                        case 21:
                            this.b = codedInputByteBufferNano.readFloat();
                            break;
                        case 24:
                            this.c = codedInputByteBufferNano.readInt32();
                            break;
                        case 32:
                            this.d = codedInputByteBufferNano.readInt32();
                            break;
                        case 40:
                            this.e = codedInputByteBufferNano.readInt64();
                            break;
                        case 48:
                            this.f = codedInputByteBufferNano.readInt32();
                            break;
                        case 56:
                            this.g = codedInputByteBufferNano.readBool();
                            break;
                        case 64:
                            this.h = codedInputByteBufferNano.readBool();
                            break;
                        case 72:
                            this.j = codedInputByteBufferNano.readInt64();
                            break;
                        case 82:
                            if (this.k == null) {
                                this.k = new C0285a();
                            }
                            codedInputByteBufferNano.readMessage(this.k);
                            break;
                        case 90:
                            if (this.l == null) {
                                this.l = new C0285a();
                            }
                            codedInputByteBufferNano.readMessage(this.l);
                            break;
                        case 98:
                            if (this.m == null) {
                                this.m = new C0285a();
                            }
                            codedInputByteBufferNano.readMessage(this.m);
                            break;
                        case 104:
                            this.i = codedInputByteBufferNano.readBool();
                            break;
                        case 114:
                            if (this.n == null) {
                                this.n = new C0285a();
                            }
                            codedInputByteBufferNano.readMessage(this.n);
                            break;
                        case 122:
                            if (this.o == null) {
                                this.o = new b();
                            }
                            codedInputByteBufferNano.readMessage(this.o);
                            break;
                        case 128:
                            this.p = codedInputByteBufferNano.readBool();
                            break;
                        case 136:
                            this.q = codedInputByteBufferNano.readBool();
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
                codedOutputByteBufferNano.writeInt64(1, this.a);
                codedOutputByteBufferNano.writeFloat(2, this.b);
                codedOutputByteBufferNano.writeInt32(3, this.c);
                codedOutputByteBufferNano.writeInt32(4, this.d);
                codedOutputByteBufferNano.writeInt64(5, this.e);
                codedOutputByteBufferNano.writeInt32(6, this.f);
                codedOutputByteBufferNano.writeBool(7, this.g);
                codedOutputByteBufferNano.writeBool(8, this.h);
                codedOutputByteBufferNano.writeInt64(9, this.j);
                C0285a c0285a = this.k;
                if (c0285a != null) {
                    codedOutputByteBufferNano.writeMessage(10, c0285a);
                }
                C0285a c0285a2 = this.l;
                if (c0285a2 != null) {
                    codedOutputByteBufferNano.writeMessage(11, c0285a2);
                }
                C0285a c0285a3 = this.m;
                if (c0285a3 != null) {
                    codedOutputByteBufferNano.writeMessage(12, c0285a3);
                }
                codedOutputByteBufferNano.writeBool(13, this.i);
                C0285a c0285a4 = this.n;
                if (c0285a4 != null) {
                    codedOutputByteBufferNano.writeMessage(14, c0285a4);
                }
                b bVar = this.o;
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(15, bVar);
                }
                boolean z = this.p;
                if (z) {
                    codedOutputByteBufferNano.writeBool(16, z);
                }
                boolean z2 = this.q;
                if (z2) {
                    codedOutputByteBufferNano.writeBool(17, z2);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public static final class b extends MessageNano {
            public int[] a;
            public int[] b;

            public b() {
                a();
            }

            public b a() {
                int[] iArr = WireFormatNano.EMPTY_INT_ARRAY;
                this.a = iArr;
                this.b = iArr;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            protected int computeSerializedSize() {
                int[] iArr;
                int iComputeSerializedSize = super.computeSerializedSize();
                int[] iArr2 = this.a;
                int i = 0;
                if (iArr2 != null && iArr2.length > 0) {
                    int i2 = 0;
                    int iComputeInt32SizeNoTag = 0;
                    while (true) {
                        iArr = this.a;
                        if (i2 >= iArr.length) {
                            break;
                        }
                        iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i2]);
                        i2++;
                    }
                    iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag + iArr.length;
                }
                int[] iArr3 = this.b;
                if (iArr3 == null || iArr3.length <= 0) {
                    return iComputeSerializedSize;
                }
                int iComputeInt32SizeNoTag2 = 0;
                while (true) {
                    int[] iArr4 = this.b;
                    if (i >= iArr4.length) {
                        return iComputeSerializedSize + iComputeInt32SizeNoTag2 + iArr4.length;
                    }
                    iComputeInt32SizeNoTag2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr4[i]);
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
                    if (tag != 8) {
                        if (tag != 10) {
                            if (tag != 16) {
                                if (tag != 18) {
                                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                                        break;
                                    }
                                } else {
                                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                                    int position = codedInputByteBufferNano.getPosition();
                                    int i = 0;
                                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                        int int32 = codedInputByteBufferNano.readInt32();
                                        if (int32 == 0 || int32 == 2 || int32 == 3) {
                                            i++;
                                        }
                                    }
                                    if (i != 0) {
                                        codedInputByteBufferNano.rewindToPosition(position);
                                        int[] iArr = this.b;
                                        int length = iArr == null ? 0 : iArr.length;
                                        int[] iArr2 = new int[i + length];
                                        if (length != 0) {
                                            System.arraycopy(iArr, 0, iArr2, 0, length);
                                        }
                                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                            int int322 = codedInputByteBufferNano.readInt32();
                                            if (int322 == 0 || int322 == 2 || int322 == 3) {
                                                iArr2[length] = int322;
                                                length++;
                                            }
                                        }
                                        this.b = iArr2;
                                    }
                                    codedInputByteBufferNano.popLimit(iPushLimit);
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                                int[] iArr3 = new int[repeatedFieldArrayLength];
                                int i2 = 0;
                                for (int i3 = 0; i3 < repeatedFieldArrayLength; i3++) {
                                    if (i3 != 0) {
                                        codedInputByteBufferNano.readTag();
                                    }
                                    int int323 = codedInputByteBufferNano.readInt32();
                                    if (int323 == 0 || int323 == 2 || int323 == 3) {
                                        iArr3[i2] = int323;
                                        i2++;
                                    }
                                }
                                if (i2 != 0) {
                                    int[] iArr4 = this.b;
                                    int length2 = iArr4 == null ? 0 : iArr4.length;
                                    if (length2 == 0 && i2 == repeatedFieldArrayLength) {
                                        this.b = iArr3;
                                    } else {
                                        int[] iArr5 = new int[length2 + i2];
                                        if (length2 != 0) {
                                            System.arraycopy(iArr4, 0, iArr5, 0, length2);
                                        }
                                        System.arraycopy(iArr3, 0, iArr5, length2, i2);
                                        this.b = iArr5;
                                    }
                                }
                            }
                        } else {
                            int iPushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                            int position2 = codedInputByteBufferNano.getPosition();
                            int i4 = 0;
                            while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                int int324 = codedInputByteBufferNano.readInt32();
                                if (int324 == 0 || int324 == 1 || int324 == 2 || int324 == 3 || int324 == 4) {
                                    i4++;
                                }
                            }
                            if (i4 != 0) {
                                codedInputByteBufferNano.rewindToPosition(position2);
                                int[] iArr6 = this.a;
                                int length3 = iArr6 == null ? 0 : iArr6.length;
                                int[] iArr7 = new int[i4 + length3];
                                if (length3 != 0) {
                                    System.arraycopy(iArr6, 0, iArr7, 0, length3);
                                }
                                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                    int int325 = codedInputByteBufferNano.readInt32();
                                    if (int325 == 0 || int325 == 1 || int325 == 2 || int325 == 3 || int325 == 4) {
                                        iArr7[length3] = int325;
                                        length3++;
                                    }
                                }
                                this.a = iArr7;
                            }
                            codedInputByteBufferNano.popLimit(iPushLimit2);
                        }
                    } else {
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                        int[] iArr8 = new int[repeatedFieldArrayLength2];
                        int i5 = 0;
                        for (int i6 = 0; i6 < repeatedFieldArrayLength2; i6++) {
                            if (i6 != 0) {
                                codedInputByteBufferNano.readTag();
                            }
                            int int326 = codedInputByteBufferNano.readInt32();
                            if (int326 == 0 || int326 == 1 || int326 == 2 || int326 == 3 || int326 == 4) {
                                iArr8[i5] = int326;
                                i5++;
                            }
                        }
                        if (i5 != 0) {
                            int[] iArr9 = this.a;
                            int length4 = iArr9 == null ? 0 : iArr9.length;
                            if (length4 == 0 && i5 == repeatedFieldArrayLength2) {
                                this.a = iArr8;
                            } else {
                                int[] iArr10 = new int[length4 + i5];
                                if (length4 != 0) {
                                    System.arraycopy(iArr9, 0, iArr10, 0, length4);
                                }
                                System.arraycopy(iArr8, 0, iArr10, length4, i5);
                                this.a = iArr10;
                            }
                        }
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                int[] iArr = this.a;
                int i = 0;
                if (iArr != null && iArr.length > 0) {
                    int i2 = 0;
                    while (true) {
                        int[] iArr2 = this.a;
                        if (i2 >= iArr2.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeInt32(1, iArr2[i2]);
                        i2++;
                    }
                }
                int[] iArr3 = this.b;
                if (iArr3 != null && iArr3.length > 0) {
                    while (true) {
                        int[] iArr4 = this.b;
                        if (i >= iArr4.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeInt32(2, iArr4[i]);
                        i++;
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public k() {
            a();
        }

        public static k[] b() {
            if (c == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (c == null) {
                            c = new k[0];
                        }
                    } finally {
                    }
                }
            }
            return c;
        }

        public k a() {
            this.a = null;
            this.b = null;
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
            b bVar = this.b;
            return bVar != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, bVar) : iComputeSerializedSize;
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
                    if (this.b == null) {
                        this.b = new b();
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
            a aVar = this.a;
            if (aVar != null) {
                codedOutputByteBufferNano.writeMessage(1, aVar);
            }
            b bVar = this.b;
            if (bVar != null) {
                codedOutputByteBufferNano.writeMessage(2, bVar);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class l extends MessageNano {
        private static volatile l[] c;
        public String a;
        public byte[] b;

        public l() {
            a();
        }

        public static l[] b() {
            if (c == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (c == null) {
                            c = new l[0];
                        }
                    } finally {
                    }
                }
            }
            return c;
        }

        public l a() {
            this.a = "";
            this.b = WireFormatNano.EMPTY_BYTES;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.a.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
            }
            return !Arrays.equals(this.b, WireFormatNano.EMPTY_BYTES) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(2, this.b) : iComputeSerializedSize;
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
                    this.b = codedInputByteBufferNano.readBytes();
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
            if (!Arrays.equals(this.b, WireFormatNano.EMPTY_BYTES)) {
                codedOutputByteBufferNano.writeBytes(2, this.b);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class m extends MessageNano {
        private static volatile m[] c;
        public String a;
        public boolean b;

        public m() {
            a();
        }

        public static m[] b() {
            if (c == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (c == null) {
                            c = new m[0];
                        }
                    } finally {
                    }
                }
            }
            return c;
        }

        public m a() {
            this.a = "";
            this.b = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            return super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.a) + CodedOutputByteBufferNano.computeBoolSize(2, this.b);
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
                    this.b = codedInputByteBufferNano.readBool();
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            codedOutputByteBufferNano.writeString(1, this.a);
            codedOutputByteBufferNano.writeBool(2, this.b);
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class n extends MessageNano {
        public long a;
        public long b;

        public n() {
            a();
        }

        public n a() {
            this.a = 86400L;
            this.b = 432000L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            return super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt64Size(1, this.a) + CodedOutputByteBufferNano.computeInt64Size(2, this.b);
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
                    this.b = codedInputByteBufferNano.readInt64();
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            codedOutputByteBufferNano.writeInt64(1, this.a);
            codedOutputByteBufferNano.writeInt64(2, this.b);
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class o extends MessageNano {
        private static volatile o[] g;
        public String a;
        public String b;
        public String c;
        public a[] d;
        public long e;
        public int[] f;

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

        public o() {
            a();
        }

        public static o[] b() {
            if (g == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (g == null) {
                            g = new o[0];
                        }
                    } finally {
                    }
                }
            }
            return g;
        }

        public o a() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = a.b();
            this.e = 0L;
            this.f = WireFormatNano.EMPTY_INT_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.a) + CodedOutputByteBufferNano.computeStringSize(2, this.b) + CodedOutputByteBufferNano.computeStringSize(3, this.c);
            a[] aVarArr = this.d;
            int i = 0;
            if (aVarArr != null && aVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    a[] aVarArr2 = this.d;
                    if (i2 >= aVarArr2.length) {
                        break;
                    }
                    a aVar = aVarArr2[i2];
                    if (aVar != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aVar);
                    }
                    i2++;
                }
            }
            int iComputeInt64Size = iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(5, this.e);
            int[] iArr = this.f;
            if (iArr == null || iArr.length <= 0) {
                return iComputeInt64Size;
            }
            int iComputeInt32SizeNoTag = 0;
            while (true) {
                int[] iArr2 = this.f;
                if (i >= iArr2.length) {
                    return iComputeInt64Size + iComputeInt32SizeNoTag + iArr2.length;
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
                                    this.e = codedInputByteBufferNano.readInt64();
                                }
                            } else {
                                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                a[] aVarArr = this.d;
                                int length3 = aVarArr == null ? 0 : aVarArr.length;
                                int i4 = repeatedFieldArrayLength2 + length3;
                                a[] aVarArr2 = new a[i4];
                                if (length3 != 0) {
                                    System.arraycopy(aVarArr, 0, aVarArr2, 0, length3);
                                }
                                while (length3 < i4 - 1) {
                                    a aVar = new a();
                                    aVarArr2[length3] = aVar;
                                    codedInputByteBufferNano.readMessage(aVar);
                                    codedInputByteBufferNano.readTag();
                                    length3++;
                                }
                                a aVar2 = new a();
                                aVarArr2[length3] = aVar2;
                                codedInputByteBufferNano.readMessage(aVar2);
                                this.d = aVarArr2;
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
            a[] aVarArr = this.d;
            int i = 0;
            if (aVarArr != null && aVarArr.length > 0) {
                int i2 = 0;
                while (true) {
                    a[] aVarArr2 = this.d;
                    if (i2 >= aVarArr2.length) {
                        break;
                    }
                    a aVar = aVarArr2[i2];
                    if (aVar != null) {
                        codedOutputByteBufferNano.writeMessage(4, aVar);
                    }
                    i2++;
                }
            }
            codedOutputByteBufferNano.writeInt64(5, this.e);
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

    public static final class p extends MessageNano {
        public long a;
        public long b;
        public long c;
        public long d;

        public p() {
            a();
        }

        public p a() {
            this.a = 432000000L;
            this.b = 86400000L;
            this.c = DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
            this.d = 3600000L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.a;
            if (j != 432000000) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
            }
            long j2 = this.b;
            if (j2 != 86400000) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j2);
            }
            long j3 = this.c;
            if (j3 != DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j3);
            }
            long j4 = this.d;
            return j4 != 3600000 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(4, j4) : iComputeSerializedSize;
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
                    this.b = codedInputByteBufferNano.readInt64();
                } else if (tag == 24) {
                    this.c = codedInputByteBufferNano.readInt64();
                } else if (tag == 32) {
                    this.d = codedInputByteBufferNano.readInt64();
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            long j = this.a;
            if (j != 432000000) {
                codedOutputByteBufferNano.writeInt64(1, j);
            }
            long j2 = this.b;
            if (j2 != 86400000) {
                codedOutputByteBufferNano.writeInt64(2, j2);
            }
            long j3 = this.c;
            if (j3 != DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
                codedOutputByteBufferNano.writeInt64(3, j3);
            }
            long j4 = this.d;
            if (j4 != 3600000) {
                codedOutputByteBufferNano.writeInt64(4, j4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class q extends MessageNano {
        public long a;
        public String b;
        public int[] c;
        public int[] d;
        public long e;
        public int f;
        public long g;
        public long h;
        public long i;
        public long j;

        public q() {
            a();
        }

        public q a() {
            this.a = 0L;
            this.b = "";
            int[] iArr = WireFormatNano.EMPTY_INT_ARRAY;
            this.c = iArr;
            this.d = iArr;
            this.e = 259200L;
            this.f = 10;
            this.g = 43200L;
            this.h = 3600L;
            this.i = 86400L;
            this.j = 30L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int[] iArr;
            int[] iArr2;
            int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt64Size(1, this.a) + CodedOutputByteBufferNano.computeStringSize(2, this.b);
            int[] iArr3 = this.c;
            int i = 0;
            if (iArr3 != null && iArr3.length > 0) {
                int i2 = 0;
                int iComputeInt32SizeNoTag = 0;
                while (true) {
                    iArr2 = this.c;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i2]);
                    i2++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag + iArr2.length;
            }
            int iComputeInt64Size = iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(4, this.e) + CodedOutputByteBufferNano.computeInt32Size(5, this.f);
            long j = this.g;
            if (j != 43200) {
                iComputeInt64Size += CodedOutputByteBufferNano.computeInt64Size(6, j);
            }
            long j2 = this.h;
            if (j2 != 3600) {
                iComputeInt64Size += CodedOutputByteBufferNano.computeInt64Size(7, j2);
            }
            long j3 = this.i;
            if (j3 != 86400) {
                iComputeInt64Size += CodedOutputByteBufferNano.computeInt64Size(8, j3);
            }
            int[] iArr4 = this.d;
            if (iArr4 != null && iArr4.length > 0) {
                int iComputeInt32SizeNoTag2 = 0;
                while (true) {
                    iArr = this.d;
                    if (i >= iArr.length) {
                        break;
                    }
                    iComputeInt32SizeNoTag2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i]);
                    i++;
                }
                iComputeInt64Size = iComputeInt64Size + iComputeInt32SizeNoTag2 + iArr.length;
            }
            long j4 = this.j;
            return j4 != 30 ? iComputeInt64Size + CodedOutputByteBufferNano.computeInt64Size(10, j4) : iComputeInt64Size;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.a = codedInputByteBufferNano.readInt64();
                        break;
                    case 18:
                        this.b = codedInputByteBufferNano.readString();
                        break;
                    case 24:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                        int[] iArr = this.c;
                        int length = iArr == null ? 0 : iArr.length;
                        int i = repeatedFieldArrayLength + length;
                        int[] iArr2 = new int[i];
                        if (length != 0) {
                            System.arraycopy(iArr, 0, iArr2, 0, length);
                        }
                        while (length < i - 1) {
                            iArr2[length] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        iArr2[length] = codedInputByteBufferNano.readInt32();
                        this.c = iArr2;
                        break;
                    case 26:
                        int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position = codedInputByteBufferNano.getPosition();
                        int i2 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            i2++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr3 = this.c;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int i3 = i2 + length2;
                        int[] iArr4 = new int[i3];
                        if (length2 != 0) {
                            System.arraycopy(iArr3, 0, iArr4, 0, length2);
                        }
                        while (length2 < i3) {
                            iArr4[length2] = codedInputByteBufferNano.readInt32();
                            length2++;
                        }
                        this.c = iArr4;
                        codedInputByteBufferNano.popLimit(iPushLimit);
                        break;
                    case 32:
                        this.e = codedInputByteBufferNano.readInt64();
                        break;
                    case 40:
                        this.f = codedInputByteBufferNano.readInt32();
                        break;
                    case 48:
                        this.g = codedInputByteBufferNano.readInt64();
                        break;
                    case 56:
                        this.h = codedInputByteBufferNano.readInt64();
                        break;
                    case 64:
                        this.i = codedInputByteBufferNano.readInt64();
                        break;
                    case 72:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 72);
                        int[] iArr5 = this.d;
                        int length3 = iArr5 == null ? 0 : iArr5.length;
                        int i4 = repeatedFieldArrayLength2 + length3;
                        int[] iArr6 = new int[i4];
                        if (length3 != 0) {
                            System.arraycopy(iArr5, 0, iArr6, 0, length3);
                        }
                        while (length3 < i4 - 1) {
                            iArr6[length3] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        iArr6[length3] = codedInputByteBufferNano.readInt32();
                        this.d = iArr6;
                        break;
                    case 74:
                        int iPushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position2 = codedInputByteBufferNano.getPosition();
                        int i5 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            i5++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position2);
                        int[] iArr7 = this.d;
                        int length4 = iArr7 == null ? 0 : iArr7.length;
                        int i6 = i5 + length4;
                        int[] iArr8 = new int[i6];
                        if (length4 != 0) {
                            System.arraycopy(iArr7, 0, iArr8, 0, length4);
                        }
                        while (length4 < i6) {
                            iArr8[length4] = codedInputByteBufferNano.readInt32();
                            length4++;
                        }
                        this.d = iArr8;
                        codedInputByteBufferNano.popLimit(iPushLimit2);
                        break;
                    case 80:
                        this.j = codedInputByteBufferNano.readInt64();
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
            codedOutputByteBufferNano.writeInt64(1, this.a);
            codedOutputByteBufferNano.writeString(2, this.b);
            int[] iArr = this.c;
            int i = 0;
            if (iArr != null && iArr.length > 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.c;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeInt32(3, iArr2[i2]);
                    i2++;
                }
            }
            codedOutputByteBufferNano.writeInt64(4, this.e);
            codedOutputByteBufferNano.writeInt32(5, this.f);
            long j = this.g;
            if (j != 43200) {
                codedOutputByteBufferNano.writeInt64(6, j);
            }
            long j2 = this.h;
            if (j2 != 3600) {
                codedOutputByteBufferNano.writeInt64(7, j2);
            }
            long j3 = this.i;
            if (j3 != 86400) {
                codedOutputByteBufferNano.writeInt64(8, j3);
            }
            int[] iArr3 = this.d;
            if (iArr3 != null && iArr3.length > 0) {
                while (true) {
                    int[] iArr4 = this.d;
                    if (i >= iArr4.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeInt32(9, iArr4[i]);
                    i++;
                }
            }
            long j4 = this.j;
            if (j4 != 30) {
                codedOutputByteBufferNano.writeInt64(10, j4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class r extends MessageNano {
        public int a;

        public r() {
            a();
        }

        public r a() {
            this.a = RemoteMessageConst.DEFAULT_TTL;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.a;
            return i != 86400 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(1, i) : iComputeSerializedSize;
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
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            int i = this.a;
            if (i != 86400) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class s extends MessageNano {
        public long a;

        public s() {
            a();
        }

        public s a() {
            this.a = 18000000L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            return super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt64Size(1, this.a);
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
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            codedOutputByteBufferNano.writeInt64(1, this.a);
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class t extends MessageNano {
        public u a;
        public u b;

        public t() {
            a();
        }

        public t a() {
            this.a = null;
            this.b = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            u uVar = this.a;
            if (uVar != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, uVar);
            }
            u uVar2 = this.b;
            return uVar2 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, uVar2) : iComputeSerializedSize;
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
                        this.a = new u();
                    }
                    codedInputByteBufferNano.readMessage(this.a);
                } else if (tag == 18) {
                    if (this.b == null) {
                        this.b = new u();
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
            u uVar = this.a;
            if (uVar != null) {
                codedOutputByteBufferNano.writeMessage(1, uVar);
            }
            u uVar2 = this.b;
            if (uVar2 != null) {
                codedOutputByteBufferNano.writeMessage(2, uVar2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class u extends MessageNano {
        public int a;
        public long b;

        public u() {
            a();
        }

        public u a() {
            this.a = 100;
            this.b = 60L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.a;
            if (i != 100) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            long j = this.b;
            return j != 60 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    break;
                }
                if (tag == 8) {
                    this.a = codedInputByteBufferNano.readInt32();
                } else if (tag == 16) {
                    this.b = codedInputByteBufferNano.readInt64();
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            int i = this.a;
            if (i != 100) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            long j = this.b;
            if (j != 60) {
                codedOutputByteBufferNano.writeInt64(2, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class v extends MessageNano {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public int e;
        public int f;
        public int g;
        public int h;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean l;
        public y[] m;
        public boolean n;
        public boolean o;
        public int p;

        public v() {
            a();
        }

        public v a() {
            this.a = true;
            this.b = true;
            this.c = true;
            this.d = true;
            this.e = 10000;
            this.f = 1000;
            this.g = 1000;
            this.h = 200000;
            this.i = false;
            this.j = false;
            this.k = false;
            this.l = false;
            this.m = y.b();
            this.n = false;
            this.o = false;
            this.p = 4000;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.a;
            if (!z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            boolean z2 = this.b;
            if (!z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z2);
            }
            boolean z3 = this.c;
            if (!z3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z3);
            }
            boolean z4 = this.d;
            if (!z4) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z4);
            }
            int i = this.e;
            if (i != 10000) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i);
            }
            int i2 = this.f;
            if (i2 != 1000) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i2);
            }
            int i3 = this.g;
            if (i3 != 1000) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i3);
            }
            int i4 = this.h;
            if (i4 != 200000) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i4);
            }
            boolean z5 = this.i;
            if (z5) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z5);
            }
            boolean z6 = this.j;
            if (z6) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z6);
            }
            boolean z7 = this.k;
            if (z7) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z7);
            }
            boolean z8 = this.l;
            if (z8) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z8);
            }
            y[] yVarArr = this.m;
            if (yVarArr != null && yVarArr.length > 0) {
                int i5 = 0;
                while (true) {
                    y[] yVarArr2 = this.m;
                    if (i5 >= yVarArr2.length) {
                        break;
                    }
                    y yVar = yVarArr2[i5];
                    if (yVar != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, yVar);
                    }
                    i5++;
                }
            }
            boolean z9 = this.n;
            if (z9) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(14, z9);
            }
            boolean z10 = this.o;
            if (z10) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(15, z10);
            }
            int i6 = this.p;
            return i6 != 4000 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(16, i6) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.a = codedInputByteBufferNano.readBool();
                        break;
                    case 16:
                        this.b = codedInputByteBufferNano.readBool();
                        break;
                    case 24:
                        this.c = codedInputByteBufferNano.readBool();
                        break;
                    case 32:
                        this.d = codedInputByteBufferNano.readBool();
                        break;
                    case 40:
                        this.e = codedInputByteBufferNano.readInt32();
                        break;
                    case 48:
                        this.f = codedInputByteBufferNano.readInt32();
                        break;
                    case 56:
                        this.g = codedInputByteBufferNano.readInt32();
                        break;
                    case 64:
                        this.h = codedInputByteBufferNano.readInt32();
                        break;
                    case 72:
                        this.i = codedInputByteBufferNano.readBool();
                        break;
                    case 80:
                        this.j = codedInputByteBufferNano.readBool();
                        break;
                    case 88:
                        this.k = codedInputByteBufferNano.readBool();
                        break;
                    case 96:
                        this.l = codedInputByteBufferNano.readBool();
                        break;
                    case 106:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                        y[] yVarArr = this.m;
                        int length = yVarArr == null ? 0 : yVarArr.length;
                        int i = repeatedFieldArrayLength + length;
                        y[] yVarArr2 = new y[i];
                        if (length != 0) {
                            System.arraycopy(yVarArr, 0, yVarArr2, 0, length);
                        }
                        while (length < i - 1) {
                            y yVar = new y();
                            yVarArr2[length] = yVar;
                            codedInputByteBufferNano.readMessage(yVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        y yVar2 = new y();
                        yVarArr2[length] = yVar2;
                        codedInputByteBufferNano.readMessage(yVar2);
                        this.m = yVarArr2;
                        break;
                    case 112:
                        this.n = codedInputByteBufferNano.readBool();
                        break;
                    case 120:
                        this.o = codedInputByteBufferNano.readBool();
                        break;
                    case 128:
                        this.p = codedInputByteBufferNano.readInt32();
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
            boolean z = this.a;
            if (!z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            boolean z2 = this.b;
            if (!z2) {
                codedOutputByteBufferNano.writeBool(2, z2);
            }
            boolean z3 = this.c;
            if (!z3) {
                codedOutputByteBufferNano.writeBool(3, z3);
            }
            boolean z4 = this.d;
            if (!z4) {
                codedOutputByteBufferNano.writeBool(4, z4);
            }
            int i = this.e;
            if (i != 10000) {
                codedOutputByteBufferNano.writeInt32(5, i);
            }
            int i2 = this.f;
            if (i2 != 1000) {
                codedOutputByteBufferNano.writeInt32(6, i2);
            }
            int i3 = this.g;
            if (i3 != 1000) {
                codedOutputByteBufferNano.writeInt32(7, i3);
            }
            int i4 = this.h;
            if (i4 != 200000) {
                codedOutputByteBufferNano.writeInt32(8, i4);
            }
            boolean z5 = this.i;
            if (z5) {
                codedOutputByteBufferNano.writeBool(9, z5);
            }
            boolean z6 = this.j;
            if (z6) {
                codedOutputByteBufferNano.writeBool(10, z6);
            }
            boolean z7 = this.k;
            if (z7) {
                codedOutputByteBufferNano.writeBool(11, z7);
            }
            boolean z8 = this.l;
            if (z8) {
                codedOutputByteBufferNano.writeBool(12, z8);
            }
            y[] yVarArr = this.m;
            if (yVarArr != null && yVarArr.length > 0) {
                int i5 = 0;
                while (true) {
                    y[] yVarArr2 = this.m;
                    if (i5 >= yVarArr2.length) {
                        break;
                    }
                    y yVar = yVarArr2[i5];
                    if (yVar != null) {
                        codedOutputByteBufferNano.writeMessage(13, yVar);
                    }
                    i5++;
                }
            }
            boolean z9 = this.n;
            if (z9) {
                codedOutputByteBufferNano.writeBool(14, z9);
            }
            boolean z10 = this.o;
            if (z10) {
                codedOutputByteBufferNano.writeBool(15, z10);
            }
            int i6 = this.p;
            if (i6 != 4000) {
                codedOutputByteBufferNano.writeInt32(16, i6);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class w extends MessageNano {
        public int a;
        public int b;
        public int c;
        public long d;
        public boolean e;
        public boolean f;
        public boolean g;
        public y[] h;

        public w() {
            a();
        }

        public w a() {
            this.a = 10000;
            this.b = 1000;
            this.c = 100;
            this.d = DeviceOrientationRequest.OUTPUT_PERIOD_FAST;
            this.e = true;
            this.f = false;
            this.g = true;
            this.h = y.b();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt32Size(1, this.a) + CodedOutputByteBufferNano.computeInt32Size(2, this.b) + CodedOutputByteBufferNano.computeInt32Size(3, this.c) + CodedOutputByteBufferNano.computeInt64Size(4, this.d) + CodedOutputByteBufferNano.computeBoolSize(5, this.e) + CodedOutputByteBufferNano.computeBoolSize(6, this.f) + CodedOutputByteBufferNano.computeBoolSize(7, this.g);
            y[] yVarArr = this.h;
            if (yVarArr != null && yVarArr.length > 0) {
                int i = 0;
                while (true) {
                    y[] yVarArr2 = this.h;
                    if (i >= yVarArr2.length) {
                        break;
                    }
                    y yVar = yVarArr2[i];
                    if (yVar != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, yVar);
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
                    this.a = codedInputByteBufferNano.readInt32();
                } else if (tag == 16) {
                    this.b = codedInputByteBufferNano.readInt32();
                } else if (tag == 24) {
                    this.c = codedInputByteBufferNano.readInt32();
                } else if (tag == 32) {
                    this.d = codedInputByteBufferNano.readInt64();
                } else if (tag == 40) {
                    this.e = codedInputByteBufferNano.readBool();
                } else if (tag == 48) {
                    this.f = codedInputByteBufferNano.readBool();
                } else if (tag == 56) {
                    this.g = codedInputByteBufferNano.readBool();
                } else if (tag == 66) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    y[] yVarArr = this.h;
                    int length = yVarArr == null ? 0 : yVarArr.length;
                    int i = repeatedFieldArrayLength + length;
                    y[] yVarArr2 = new y[i];
                    if (length != 0) {
                        System.arraycopy(yVarArr, 0, yVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        y yVar = new y();
                        yVarArr2[length] = yVar;
                        codedInputByteBufferNano.readMessage(yVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    y yVar2 = new y();
                    yVarArr2[length] = yVar2;
                    codedInputByteBufferNano.readMessage(yVar2);
                    this.h = yVarArr2;
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            codedOutputByteBufferNano.writeInt32(1, this.a);
            codedOutputByteBufferNano.writeInt32(2, this.b);
            codedOutputByteBufferNano.writeInt32(3, this.c);
            codedOutputByteBufferNano.writeInt64(4, this.d);
            codedOutputByteBufferNano.writeBool(5, this.e);
            codedOutputByteBufferNano.writeBool(6, this.f);
            codedOutputByteBufferNano.writeBool(7, this.g);
            y[] yVarArr = this.h;
            if (yVarArr != null && yVarArr.length > 0) {
                int i = 0;
                while (true) {
                    y[] yVarArr2 = this.h;
                    if (i >= yVarArr2.length) {
                        break;
                    }
                    y yVar = yVarArr2[i];
                    if (yVar != null) {
                        codedOutputByteBufferNano.writeMessage(8, yVar);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class x extends MessageNano {
        public boolean a;
        public boolean b;

        public x() {
            a();
        }

        public x a() {
            this.a = true;
            this.b = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            return super.computeSerializedSize() + CodedOutputByteBufferNano.computeBoolSize(1, this.a) + CodedOutputByteBufferNano.computeBoolSize(2, this.b);
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
            codedOutputByteBufferNano.writeBool(1, this.a);
            codedOutputByteBufferNano.writeBool(2, this.b);
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public static final class y extends MessageNano {
        private static volatile y[] c;
        public int a;
        public String b;

        public y() {
            a();
        }

        public static y[] b() {
            if (c == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    try {
                        if (c == null) {
                            c = new y[0];
                        }
                    } finally {
                    }
                }
            }
            return c;
        }

        public y a() {
            this.a = 0;
            this.b = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            return super.computeSerializedSize() + CodedOutputByteBufferNano.computeInt32Size(1, this.a) + CodedOutputByteBufferNano.computeStringSize(2, this.b);
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
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.a = int32;
                    }
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
            codedOutputByteBufferNano.writeInt32(1, this.a);
            codedOutputByteBufferNano.writeString(2, this.b);
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public If() {
        a();
    }

    public If a() {
        this.a = "";
        this.b = 0L;
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.c = strArr;
        this.d = "";
        this.e = "";
        this.f = strArr;
        this.g = strArr;
        this.h = strArr;
        this.i = strArr;
        this.j = d.b();
        this.k = null;
        this.l = k.b();
        this.m = null;
        this.n = o.b();
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = false;
        this.s = "";
        this.t = strArr;
        this.u = null;
        this.v = false;
        this.w = m.b();
        this.x = null;
        this.y = "";
        this.z = "";
        this.A = "";
        this.B = "";
        this.C = 0L;
        this.D = 0L;
        this.E = false;
        this.F = null;
        this.G = null;
        this.H = pjsip_status_code.PJSIP_SC_BUSY_EVERYWHERE;
        this.I = 1;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = strArr;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = l.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.a.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
        }
        int iComputeInt64Size = iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, this.b);
        String[] strArr = this.c;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int iComputeStringSizeNoTag = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.c;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    i4++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i3++;
            }
            iComputeInt64Size = iComputeInt64Size + iComputeStringSizeNoTag + i4;
        }
        if (!this.d.equals("")) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeStringSize(5, this.d);
        }
        if (!this.e.equals("")) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeStringSize(6, this.e);
        }
        String[] strArr3 = this.f;
        if (strArr3 != null && strArr3.length > 0) {
            int i5 = 0;
            int iComputeStringSizeNoTag2 = 0;
            int i6 = 0;
            while (true) {
                String[] strArr4 = this.f;
                if (i5 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i5];
                if (str2 != null) {
                    i6++;
                    iComputeStringSizeNoTag2 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i5++;
            }
            iComputeInt64Size = iComputeInt64Size + iComputeStringSizeNoTag2 + i6;
        }
        String[] strArr5 = this.g;
        if (strArr5 != null && strArr5.length > 0) {
            int i7 = 0;
            int iComputeStringSizeNoTag3 = 0;
            int i8 = 0;
            while (true) {
                String[] strArr6 = this.g;
                if (i7 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i7];
                if (str3 != null) {
                    i8++;
                    iComputeStringSizeNoTag3 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                }
                i7++;
            }
            iComputeInt64Size = iComputeInt64Size + iComputeStringSizeNoTag3 + i8;
        }
        String[] strArr7 = this.h;
        if (strArr7 != null && strArr7.length > 0) {
            int i9 = 0;
            int iComputeStringSizeNoTag4 = 0;
            int i10 = 0;
            while (true) {
                String[] strArr8 = this.h;
                if (i9 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i9];
                if (str4 != null) {
                    i10++;
                    iComputeStringSizeNoTag4 += CodedOutputByteBufferNano.computeStringSizeNoTag(str4);
                }
                i9++;
            }
            iComputeInt64Size = iComputeInt64Size + iComputeStringSizeNoTag4 + i10;
        }
        i iVar = this.k;
        if (iVar != null) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeMessageSize(10, iVar);
        }
        k[] kVarArr = this.l;
        if (kVarArr != null && kVarArr.length > 0) {
            int i11 = 0;
            while (true) {
                k[] kVarArr2 = this.l;
                if (i11 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i11];
                if (kVar != null) {
                    iComputeInt64Size += CodedOutputByteBufferNano.computeMessageSize(11, kVar);
                }
                i11++;
            }
        }
        q qVar = this.m;
        if (qVar != null) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeMessageSize(13, qVar);
        }
        o[] oVarArr = this.n;
        if (oVarArr != null && oVarArr.length > 0) {
            int i12 = 0;
            while (true) {
                o[] oVarArr2 = this.n;
                if (i12 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i12];
                if (oVar != null) {
                    iComputeInt64Size += CodedOutputByteBufferNano.computeMessageSize(14, oVar);
                }
                i12++;
            }
        }
        if (!this.o.equals("")) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeStringSize(15, this.o);
        }
        if (!this.p.equals("")) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeStringSize(16, this.p);
        }
        int iComputeBoolSize = iComputeInt64Size + CodedOutputByteBufferNano.computeBoolSize(17, this.r);
        if (!this.s.equals("")) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeStringSize(19, this.s);
        }
        String[] strArr9 = this.t;
        if (strArr9 != null && strArr9.length > 0) {
            int i13 = 0;
            int iComputeStringSizeNoTag5 = 0;
            int i14 = 0;
            while (true) {
                String[] strArr10 = this.t;
                if (i13 >= strArr10.length) {
                    break;
                }
                String str5 = strArr10[i13];
                if (str5 != null) {
                    i14++;
                    iComputeStringSizeNoTag5 += CodedOutputByteBufferNano.computeStringSizeNoTag(str5);
                }
                i13++;
            }
            iComputeBoolSize = iComputeBoolSize + iComputeStringSizeNoTag5 + (i14 * 2);
        }
        s sVar = this.u;
        if (sVar != null) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeMessageSize(21, sVar);
        }
        boolean z = this.v;
        if (z) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeBoolSize(22, z);
        }
        m[] mVarArr = this.w;
        if (mVarArr != null && mVarArr.length > 0) {
            int i15 = 0;
            while (true) {
                m[] mVarArr2 = this.w;
                if (i15 >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i15];
                if (mVar != null) {
                    iComputeBoolSize += CodedOutputByteBufferNano.computeMessageSize(23, mVar);
                }
                i15++;
            }
        }
        p pVar = this.x;
        if (pVar != null) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeMessageSize(24, pVar);
        }
        if (!this.y.equals("")) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeStringSize(25, this.y);
        }
        if (!this.z.equals("")) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeStringSize(26, this.z);
        }
        if (!this.A.equals("")) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeStringSize(27, this.A);
        }
        int iComputeInt64Size2 = iComputeBoolSize + CodedOutputByteBufferNano.computeInt64Size(28, this.C) + CodedOutputByteBufferNano.computeInt64Size(29, this.D);
        boolean z2 = this.E;
        if (z2) {
            iComputeInt64Size2 += CodedOutputByteBufferNano.computeBoolSize(30, z2);
        }
        n nVar = this.F;
        if (nVar != null) {
            iComputeInt64Size2 += CodedOutputByteBufferNano.computeMessageSize(32, nVar);
        }
        j jVar = this.G;
        if (jVar != null) {
            iComputeInt64Size2 += CodedOutputByteBufferNano.computeMessageSize(33, jVar);
        }
        int iComputeInt32Size = iComputeInt64Size2 + CodedOutputByteBufferNano.computeInt32Size(35, this.H) + CodedOutputByteBufferNano.computeInt32Size(36, this.I);
        w wVar = this.J;
        if (wVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(37, wVar);
        }
        v vVar = this.K;
        if (vVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(38, vVar);
        }
        v vVar2 = this.L;
        if (vVar2 != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(39, vVar2);
        }
        t tVar = this.N;
        if (tVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(41, tVar);
        }
        c cVar = this.O;
        if (cVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(42, cVar);
        }
        v vVar3 = this.M;
        if (vVar3 != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(43, vVar3);
        }
        if (!this.q.equals("")) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeStringSize(44, this.q);
        }
        f fVar = this.P;
        if (fVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(45, fVar);
        }
        String[] strArr11 = this.i;
        if (strArr11 != null && strArr11.length > 0) {
            int i16 = 0;
            int iComputeStringSizeNoTag6 = 0;
            int i17 = 0;
            while (true) {
                String[] strArr12 = this.i;
                if (i16 >= strArr12.length) {
                    break;
                }
                String str6 = strArr12[i16];
                if (str6 != null) {
                    i17++;
                    iComputeStringSizeNoTag6 += CodedOutputByteBufferNano.computeStringSizeNoTag(str6);
                }
                i16++;
            }
            iComputeInt32Size = iComputeInt32Size + iComputeStringSizeNoTag6 + (i17 * 2);
        }
        String[] strArr13 = this.Q;
        if (strArr13 != null && strArr13.length > 0) {
            int i18 = 0;
            int iComputeStringSizeNoTag7 = 0;
            int i19 = 0;
            while (true) {
                String[] strArr14 = this.Q;
                if (i18 >= strArr14.length) {
                    break;
                }
                String str7 = strArr14[i18];
                if (str7 != null) {
                    i19++;
                    iComputeStringSizeNoTag7 += CodedOutputByteBufferNano.computeStringSizeNoTag(str7);
                }
                i18++;
            }
            iComputeInt32Size = iComputeInt32Size + iComputeStringSizeNoTag7 + (i19 * 2);
        }
        b bVar = this.R;
        if (bVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(48, bVar);
        }
        if (!this.B.equals("")) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeStringSize(49, this.B);
        }
        a aVar = this.S;
        if (aVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(51, aVar);
        }
        h hVar = this.T;
        if (hVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(52, hVar);
        }
        g gVar = this.U;
        if (gVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(53, gVar);
        }
        d[] dVarArr = this.j;
        if (dVarArr != null && dVarArr.length > 0) {
            int i20 = 0;
            while (true) {
                d[] dVarArr2 = this.j;
                if (i20 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i20];
                if (dVar != null) {
                    iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(54, dVar);
                }
                i20++;
            }
        }
        r rVar = this.V;
        if (rVar != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(55, rVar);
        }
        l[] lVarArr = this.W;
        if (lVarArr != null && lVarArr.length > 0) {
            while (true) {
                l[] lVarArr2 = this.W;
                if (i2 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i2];
                if (lVar != null) {
                    iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(56, lVar);
                }
                i2++;
            }
        }
        return iComputeInt32Size;
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
                case 24:
                    this.b = codedInputByteBufferNano.readInt64();
                    break;
                case 34:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    String[] strArr = this.c;
                    int length = strArr == null ? 0 : strArr.length;
                    int i2 = repeatedFieldArrayLength + length;
                    String[] strArr2 = new String[i2];
                    if (length != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length);
                    }
                    while (length < i2 - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.c = strArr2;
                    break;
                case 42:
                    this.d = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.e = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    String[] strArr3 = this.f;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
                    int i3 = repeatedFieldArrayLength2 + length2;
                    String[] strArr4 = new String[i3];
                    if (length2 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length2);
                    }
                    while (length2 < i3 - 1) {
                        strArr4[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr4[length2] = codedInputByteBufferNano.readString();
                    this.f = strArr4;
                    break;
                case 66:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    String[] strArr5 = this.g;
                    int length3 = strArr5 == null ? 0 : strArr5.length;
                    int i4 = repeatedFieldArrayLength3 + length3;
                    String[] strArr6 = new String[i4];
                    if (length3 != 0) {
                        System.arraycopy(strArr5, 0, strArr6, 0, length3);
                    }
                    while (length3 < i4 - 1) {
                        strArr6[length3] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    strArr6[length3] = codedInputByteBufferNano.readString();
                    this.g = strArr6;
                    break;
                case 74:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    String[] strArr7 = this.h;
                    int length4 = strArr7 == null ? 0 : strArr7.length;
                    int i5 = repeatedFieldArrayLength4 + length4;
                    String[] strArr8 = new String[i5];
                    if (length4 != 0) {
                        System.arraycopy(strArr7, 0, strArr8, 0, length4);
                    }
                    while (length4 < i5 - 1) {
                        strArr8[length4] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    strArr8[length4] = codedInputByteBufferNano.readString();
                    this.h = strArr8;
                    break;
                case 82:
                    if (this.k == null) {
                        this.k = new i();
                    }
                    codedInputByteBufferNano.readMessage(this.k);
                    break;
                case 90:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    k[] kVarArr = this.l;
                    int length5 = kVarArr == null ? 0 : kVarArr.length;
                    int i6 = repeatedFieldArrayLength5 + length5;
                    k[] kVarArr2 = new k[i6];
                    if (length5 != 0) {
                        System.arraycopy(kVarArr, 0, kVarArr2, 0, length5);
                    }
                    while (length5 < i6 - 1) {
                        k kVar = new k();
                        kVarArr2[length5] = kVar;
                        codedInputByteBufferNano.readMessage(kVar);
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    k kVar2 = new k();
                    kVarArr2[length5] = kVar2;
                    codedInputByteBufferNano.readMessage(kVar2);
                    this.l = kVarArr2;
                    break;
                case 106:
                    if (this.m == null) {
                        this.m = new q();
                    }
                    codedInputByteBufferNano.readMessage(this.m);
                    break;
                case 114:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 114);
                    o[] oVarArr = this.n;
                    int length6 = oVarArr == null ? 0 : oVarArr.length;
                    int i7 = repeatedFieldArrayLength6 + length6;
                    o[] oVarArr2 = new o[i7];
                    if (length6 != 0) {
                        System.arraycopy(oVarArr, 0, oVarArr2, 0, length6);
                    }
                    while (length6 < i7 - 1) {
                        o oVar = new o();
                        oVarArr2[length6] = oVar;
                        codedInputByteBufferNano.readMessage(oVar);
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    o oVar2 = new o();
                    oVarArr2[length6] = oVar2;
                    codedInputByteBufferNano.readMessage(oVar2);
                    this.n = oVarArr2;
                    break;
                case 122:
                    this.o = codedInputByteBufferNano.readString();
                    break;
                case pjsip_transport_type_e.PJSIP_TRANSPORT_TCP6 /* 130 */:
                    this.p = codedInputByteBufferNano.readString();
                    break;
                case 136:
                    this.r = codedInputByteBufferNano.readBool();
                    break;
                case 154:
                    this.s = codedInputByteBufferNano.readString();
                    break;
                case 162:
                    int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 162);
                    String[] strArr9 = this.t;
                    int length7 = strArr9 == null ? 0 : strArr9.length;
                    int i8 = repeatedFieldArrayLength7 + length7;
                    String[] strArr10 = new String[i8];
                    if (length7 != 0) {
                        System.arraycopy(strArr9, 0, strArr10, 0, length7);
                    }
                    while (length7 < i8 - 1) {
                        strArr10[length7] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length7++;
                    }
                    strArr10[length7] = codedInputByteBufferNano.readString();
                    this.t = strArr10;
                    break;
                case 170:
                    if (this.u == null) {
                        this.u = new s();
                    }
                    codedInputByteBufferNano.readMessage(this.u);
                    break;
                case 176:
                    this.v = codedInputByteBufferNano.readBool();
                    break;
                case 186:
                    int repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 186);
                    m[] mVarArr = this.w;
                    int length8 = mVarArr == null ? 0 : mVarArr.length;
                    int i9 = repeatedFieldArrayLength8 + length8;
                    m[] mVarArr2 = new m[i9];
                    if (length8 != 0) {
                        System.arraycopy(mVarArr, 0, mVarArr2, 0, length8);
                    }
                    while (length8 < i9 - 1) {
                        m mVar = new m();
                        mVarArr2[length8] = mVar;
                        codedInputByteBufferNano.readMessage(mVar);
                        codedInputByteBufferNano.readTag();
                        length8++;
                    }
                    m mVar2 = new m();
                    mVarArr2[length8] = mVar2;
                    codedInputByteBufferNano.readMessage(mVar2);
                    this.w = mVarArr2;
                    break;
                case 194:
                    if (this.x == null) {
                        this.x = new p();
                    }
                    codedInputByteBufferNano.readMessage(this.x);
                    break;
                case pjsip_status_code.PJSIP_SC_ACCEPTED /* 202 */:
                    this.y = codedInputByteBufferNano.readString();
                    break;
                case 210:
                    this.z = codedInputByteBufferNano.readString();
                    break;
                case 218:
                    this.A = codedInputByteBufferNano.readString();
                    break;
                case 224:
                    this.C = codedInputByteBufferNano.readInt64();
                    break;
                case 232:
                    this.D = codedInputByteBufferNano.readInt64();
                    break;
                case 240:
                    this.E = codedInputByteBufferNano.readBool();
                    break;
                case 258:
                    if (this.F == null) {
                        this.F = new n();
                    }
                    codedInputByteBufferNano.readMessage(this.F);
                    break;
                case 266:
                    if (this.G == null) {
                        this.G = new j();
                    }
                    codedInputByteBufferNano.readMessage(this.G);
                    break;
                case 280:
                    this.H = codedInputByteBufferNano.readInt32();
                    break;
                case 288:
                    this.I = codedInputByteBufferNano.readInt32();
                    break;
                case 298:
                    if (this.J == null) {
                        this.J = new w();
                    }
                    codedInputByteBufferNano.readMessage(this.J);
                    break;
                case 306:
                    if (this.K == null) {
                        this.K = new v();
                    }
                    codedInputByteBufferNano.readMessage(this.K);
                    break;
                case 314:
                    if (this.L == null) {
                        this.L = new v();
                    }
                    codedInputByteBufferNano.readMessage(this.L);
                    break;
                case 330:
                    if (this.N == null) {
                        this.N = new t();
                    }
                    codedInputByteBufferNano.readMessage(this.N);
                    break;
                case 338:
                    if (this.O == null) {
                        this.O = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.O);
                    break;
                case 346:
                    if (this.M == null) {
                        this.M = new v();
                    }
                    codedInputByteBufferNano.readMessage(this.M);
                    break;
                case 354:
                    this.q = codedInputByteBufferNano.readString();
                    break;
                case 362:
                    if (this.P == null) {
                        this.P = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.P);
                    break;
                case 370:
                    int repeatedFieldArrayLength9 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 370);
                    String[] strArr11 = this.i;
                    int length9 = strArr11 == null ? 0 : strArr11.length;
                    int i10 = repeatedFieldArrayLength9 + length9;
                    String[] strArr12 = new String[i10];
                    if (length9 != 0) {
                        System.arraycopy(strArr11, 0, strArr12, 0, length9);
                    }
                    while (length9 < i10 - 1) {
                        strArr12[length9] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length9++;
                    }
                    strArr12[length9] = codedInputByteBufferNano.readString();
                    this.i = strArr12;
                    break;
                case 378:
                    int repeatedFieldArrayLength10 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 378);
                    String[] strArr13 = this.Q;
                    int length10 = strArr13 == null ? 0 : strArr13.length;
                    int i11 = repeatedFieldArrayLength10 + length10;
                    String[] strArr14 = new String[i11];
                    if (length10 != 0) {
                        System.arraycopy(strArr13, 0, strArr14, 0, length10);
                    }
                    while (length10 < i11 - 1) {
                        strArr14[length10] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length10++;
                    }
                    strArr14[length10] = codedInputByteBufferNano.readString();
                    this.Q = strArr14;
                    break;
                case 386:
                    if (this.R == null) {
                        this.R = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.R);
                    break;
                case 394:
                    this.B = codedInputByteBufferNano.readString();
                    break;
                case pjsip_status_code.PJSIP_SC_GONE /* 410 */:
                    if (this.S == null) {
                        this.S = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.S);
                    break;
                case 418:
                    if (this.T == null) {
                        this.T = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.T);
                    break;
                case 426:
                    if (this.U == null) {
                        this.U = new g();
                    }
                    codedInputByteBufferNano.readMessage(this.U);
                    break;
                case 434:
                    int repeatedFieldArrayLength11 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 434);
                    d[] dVarArr = this.j;
                    int length11 = dVarArr == null ? 0 : dVarArr.length;
                    int i12 = repeatedFieldArrayLength11 + length11;
                    d[] dVarArr2 = new d[i12];
                    if (length11 != 0) {
                        System.arraycopy(dVarArr, 0, dVarArr2, 0, length11);
                    }
                    while (length11 < i12 - 1) {
                        d dVar = new d();
                        dVarArr2[length11] = dVar;
                        codedInputByteBufferNano.readMessage(dVar);
                        codedInputByteBufferNano.readTag();
                        length11++;
                    }
                    d dVar2 = new d();
                    dVarArr2[length11] = dVar2;
                    codedInputByteBufferNano.readMessage(dVar2);
                    this.j = dVarArr2;
                    break;
                case 442:
                    if (this.V == null) {
                        this.V = new r();
                    }
                    codedInputByteBufferNano.readMessage(this.V);
                    break;
                case 450:
                    int repeatedFieldArrayLength12 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 450);
                    l[] lVarArr = this.W;
                    int length12 = lVarArr == null ? 0 : lVarArr.length;
                    int i13 = repeatedFieldArrayLength12 + length12;
                    l[] lVarArr2 = new l[i13];
                    if (length12 != 0) {
                        System.arraycopy(lVarArr, 0, lVarArr2, 0, length12);
                    }
                    while (length12 < i13 - 1) {
                        l lVar = new l();
                        lVarArr2[length12] = lVar;
                        codedInputByteBufferNano.readMessage(lVar);
                        codedInputByteBufferNano.readTag();
                        length12++;
                    }
                    l lVar2 = new l();
                    lVarArr2[length12] = lVar2;
                    codedInputByteBufferNano.readMessage(lVar2);
                    this.W = lVarArr2;
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
        codedOutputByteBufferNano.writeInt64(3, this.b);
        String[] strArr = this.c;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.c;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(4, str);
                }
                i3++;
            }
        }
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.d);
        }
        if (!this.e.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.e);
        }
        String[] strArr3 = this.f;
        if (strArr3 != null && strArr3.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr4 = this.f;
                if (i4 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i4];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(7, str2);
                }
                i4++;
            }
        }
        String[] strArr5 = this.g;
        if (strArr5 != null && strArr5.length > 0) {
            int i5 = 0;
            while (true) {
                String[] strArr6 = this.g;
                if (i5 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i5];
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(8, str3);
                }
                i5++;
            }
        }
        String[] strArr7 = this.h;
        if (strArr7 != null && strArr7.length > 0) {
            int i6 = 0;
            while (true) {
                String[] strArr8 = this.h;
                if (i6 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i6];
                if (str4 != null) {
                    codedOutputByteBufferNano.writeString(9, str4);
                }
                i6++;
            }
        }
        i iVar = this.k;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(10, iVar);
        }
        k[] kVarArr = this.l;
        if (kVarArr != null && kVarArr.length > 0) {
            int i7 = 0;
            while (true) {
                k[] kVarArr2 = this.l;
                if (i7 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i7];
                if (kVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, kVar);
                }
                i7++;
            }
        }
        q qVar = this.m;
        if (qVar != null) {
            codedOutputByteBufferNano.writeMessage(13, qVar);
        }
        o[] oVarArr = this.n;
        if (oVarArr != null && oVarArr.length > 0) {
            int i8 = 0;
            while (true) {
                o[] oVarArr2 = this.n;
                if (i8 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i8];
                if (oVar != null) {
                    codedOutputByteBufferNano.writeMessage(14, oVar);
                }
                i8++;
            }
        }
        if (!this.o.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.o);
        }
        if (!this.p.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.p);
        }
        codedOutputByteBufferNano.writeBool(17, this.r);
        if (!this.s.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.s);
        }
        String[] strArr9 = this.t;
        if (strArr9 != null && strArr9.length > 0) {
            int i9 = 0;
            while (true) {
                String[] strArr10 = this.t;
                if (i9 >= strArr10.length) {
                    break;
                }
                String str5 = strArr10[i9];
                if (str5 != null) {
                    codedOutputByteBufferNano.writeString(20, str5);
                }
                i9++;
            }
        }
        s sVar = this.u;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(21, sVar);
        }
        boolean z = this.v;
        if (z) {
            codedOutputByteBufferNano.writeBool(22, z);
        }
        m[] mVarArr = this.w;
        if (mVarArr != null && mVarArr.length > 0) {
            int i10 = 0;
            while (true) {
                m[] mVarArr2 = this.w;
                if (i10 >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i10];
                if (mVar != null) {
                    codedOutputByteBufferNano.writeMessage(23, mVar);
                }
                i10++;
            }
        }
        p pVar = this.x;
        if (pVar != null) {
            codedOutputByteBufferNano.writeMessage(24, pVar);
        }
        if (!this.y.equals("")) {
            codedOutputByteBufferNano.writeString(25, this.y);
        }
        if (!this.z.equals("")) {
            codedOutputByteBufferNano.writeString(26, this.z);
        }
        if (!this.A.equals("")) {
            codedOutputByteBufferNano.writeString(27, this.A);
        }
        codedOutputByteBufferNano.writeInt64(28, this.C);
        codedOutputByteBufferNano.writeInt64(29, this.D);
        boolean z2 = this.E;
        if (z2) {
            codedOutputByteBufferNano.writeBool(30, z2);
        }
        n nVar = this.F;
        if (nVar != null) {
            codedOutputByteBufferNano.writeMessage(32, nVar);
        }
        j jVar = this.G;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(33, jVar);
        }
        codedOutputByteBufferNano.writeInt32(35, this.H);
        codedOutputByteBufferNano.writeInt32(36, this.I);
        w wVar = this.J;
        if (wVar != null) {
            codedOutputByteBufferNano.writeMessage(37, wVar);
        }
        v vVar = this.K;
        if (vVar != null) {
            codedOutputByteBufferNano.writeMessage(38, vVar);
        }
        v vVar2 = this.L;
        if (vVar2 != null) {
            codedOutputByteBufferNano.writeMessage(39, vVar2);
        }
        t tVar = this.N;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(41, tVar);
        }
        c cVar = this.O;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(42, cVar);
        }
        v vVar3 = this.M;
        if (vVar3 != null) {
            codedOutputByteBufferNano.writeMessage(43, vVar3);
        }
        if (!this.q.equals("")) {
            codedOutputByteBufferNano.writeString(44, this.q);
        }
        f fVar = this.P;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(45, fVar);
        }
        String[] strArr11 = this.i;
        if (strArr11 != null && strArr11.length > 0) {
            int i11 = 0;
            while (true) {
                String[] strArr12 = this.i;
                if (i11 >= strArr12.length) {
                    break;
                }
                String str6 = strArr12[i11];
                if (str6 != null) {
                    codedOutputByteBufferNano.writeString(46, str6);
                }
                i11++;
            }
        }
        String[] strArr13 = this.Q;
        if (strArr13 != null && strArr13.length > 0) {
            int i12 = 0;
            while (true) {
                String[] strArr14 = this.Q;
                if (i12 >= strArr14.length) {
                    break;
                }
                String str7 = strArr14[i12];
                if (str7 != null) {
                    codedOutputByteBufferNano.writeString(47, str7);
                }
                i12++;
            }
        }
        b bVar = this.R;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(48, bVar);
        }
        if (!this.B.equals("")) {
            codedOutputByteBufferNano.writeString(49, this.B);
        }
        a aVar = this.S;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(51, aVar);
        }
        h hVar = this.T;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(52, hVar);
        }
        g gVar = this.U;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(53, gVar);
        }
        d[] dVarArr = this.j;
        if (dVarArr != null && dVarArr.length > 0) {
            int i13 = 0;
            while (true) {
                d[] dVarArr2 = this.j;
                if (i13 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i13];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(54, dVar);
                }
                i13++;
            }
        }
        r rVar = this.V;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(55, rVar);
        }
        l[] lVarArr = this.W;
        if (lVarArr != null && lVarArr.length > 0) {
            while (true) {
                l[] lVarArr2 = this.W;
                if (i2 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i2];
                if (lVar != null) {
                    codedOutputByteBufferNano.writeMessage(56, lVar);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
