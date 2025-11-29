package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.yandex.metrica.impl.ob.cf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0851cf extends MessageNano {
    private static byte[] l;
    private static volatile boolean m;
    public byte[] a;
    public a b;
    public byte[] c;
    public int d;
    public byte[] e;
    public byte[] f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public byte[] j;
    public byte[] k;

    /* renamed from: com.yandex.metrica.impl.ob.cf$a */
    public static final class a extends MessageNano {
        public long a;
        public int b;

        public a() {
            a();
        }

        public a a() {
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

    public C0851cf() {
        if (!m) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (!m) {
                        l = InternalNano.bytesDefaultValue("manual");
                        m = true;
                    }
                } finally {
                }
            }
        }
        a();
    }

    public C0851cf a() {
        this.a = (byte[]) l.clone();
        this.b = null;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.c = bArr;
        this.d = 0;
        this.e = bArr;
        this.f = bArr;
        this.g = bArr;
        this.h = bArr;
        this.i = bArr;
        this.j = bArr;
        this.k = bArr;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!Arrays.equals(this.a, l)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.a);
        }
        a aVar = this.b;
        if (aVar != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
        }
        byte[] bArr = this.c;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.c);
        }
        int i = this.d;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        if (!Arrays.equals(this.e, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.e);
        }
        if (!Arrays.equals(this.f, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.f);
        }
        if (!Arrays.equals(this.g, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(7, this.g);
        }
        if (!Arrays.equals(this.h, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(8, this.h);
        }
        if (!Arrays.equals(this.i, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.i);
        }
        if (!Arrays.equals(this.j, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(10, this.j);
        }
        return !Arrays.equals(this.k, bArr2) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(11, this.k) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.a = codedInputByteBufferNano.readBytes();
                    break;
                case 18:
                    if (this.b == null) {
                        this.b = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                    break;
                case 26:
                    this.c = codedInputByteBufferNano.readBytes();
                    break;
                case 32:
                    int int32 = codedInputByteBufferNano.readInt32();
                    switch (int32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.d = int32;
                            break;
                    }
                case 42:
                    this.e = codedInputByteBufferNano.readBytes();
                    break;
                case 50:
                    this.f = codedInputByteBufferNano.readBytes();
                    break;
                case 58:
                    this.g = codedInputByteBufferNano.readBytes();
                    break;
                case 66:
                    this.h = codedInputByteBufferNano.readBytes();
                    break;
                case 74:
                    this.i = codedInputByteBufferNano.readBytes();
                    break;
                case 82:
                    this.j = codedInputByteBufferNano.readBytes();
                    break;
                case 90:
                    this.k = codedInputByteBufferNano.readBytes();
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
        if (!Arrays.equals(this.a, l)) {
            codedOutputByteBufferNano.writeBytes(1, this.a);
        }
        a aVar = this.b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        byte[] bArr = this.c;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.c);
        }
        int i = this.d;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        if (!Arrays.equals(this.e, bArr2)) {
            codedOutputByteBufferNano.writeBytes(5, this.e);
        }
        if (!Arrays.equals(this.f, bArr2)) {
            codedOutputByteBufferNano.writeBytes(6, this.f);
        }
        if (!Arrays.equals(this.g, bArr2)) {
            codedOutputByteBufferNano.writeBytes(7, this.g);
        }
        if (!Arrays.equals(this.h, bArr2)) {
            codedOutputByteBufferNano.writeBytes(8, this.h);
        }
        if (!Arrays.equals(this.i, bArr2)) {
            codedOutputByteBufferNano.writeBytes(9, this.i);
        }
        if (!Arrays.equals(this.j, bArr2)) {
            codedOutputByteBufferNano.writeBytes(10, this.j);
        }
        if (!Arrays.equals(this.k, bArr2)) {
            codedOutputByteBufferNano.writeBytes(11, this.k);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
