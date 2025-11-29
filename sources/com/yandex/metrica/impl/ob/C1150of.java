package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import java.io.IOException;

/* renamed from: com.yandex.metrica.impl.ob.of, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1150of extends MessageNano {
    private static volatile C1150of[] q;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public String f;
    public boolean g;
    public int h;
    public int i;
    public long j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;

    public C1150of() {
        a();
    }

    public static C1150of[] b() {
        if (q == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (q == null) {
                        q = new C1150of[0];
                    }
                } finally {
                }
            }
        }
        return q;
    }

    public C1150of a() {
        this.a = -1;
        this.b = 0;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = "";
        this.g = false;
        this.h = 0;
        this.i = -1;
        this.j = 0L;
        this.k = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.a;
        if (i != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.b;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeSInt32Size(2, i2);
        }
        int i3 = this.c;
        if (i3 != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i4 = this.d;
        if (i4 != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i4);
        }
        int i5 = this.e;
        if (i5 != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i5);
        }
        if (!this.f.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f);
        }
        boolean z = this.g;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
        }
        int i6 = this.h;
        if (i6 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i6);
        }
        int i7 = this.i;
        if (i7 != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i7);
        }
        long j = this.j;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j);
        }
        int i8 = this.k;
        if (i8 != Integer.MAX_VALUE) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeSInt32Size(11, i8);
        }
        int i9 = this.l;
        if (i9 != Integer.MAX_VALUE) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeSInt32Size(12, i9);
        }
        int i10 = this.m;
        if (i10 != Integer.MAX_VALUE) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeSInt32Size(13, i10);
        }
        int i11 = this.n;
        if (i11 != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i11);
        }
        int i12 = this.o;
        if (i12 != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(15, i12);
        }
        int i13 = this.p;
        return i13 != -1 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(16, i13) : iComputeSerializedSize;
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
                case 16:
                    this.b = codedInputByteBufferNano.readSInt32();
                    break;
                case 24:
                    this.c = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.e = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    this.f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.g = codedInputByteBufferNano.readBool();
                    break;
                case 64:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3 && int32 != 4) {
                        break;
                    } else {
                        this.h = int32;
                        break;
                    }
                    break;
                case 72:
                    this.i = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.j = codedInputByteBufferNano.readUInt64();
                    break;
                case 88:
                    this.k = codedInputByteBufferNano.readSInt32();
                    break;
                case 96:
                    this.l = codedInputByteBufferNano.readSInt32();
                    break;
                case 104:
                    this.m = codedInputByteBufferNano.readSInt32();
                    break;
                case 112:
                    this.n = codedInputByteBufferNano.readUInt32();
                    break;
                case 120:
                    this.o = codedInputByteBufferNano.readUInt32();
                    break;
                case 128:
                    this.p = codedInputByteBufferNano.readUInt32();
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
        if (i != -1) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.b;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeSInt32(2, i2);
        }
        int i3 = this.c;
        if (i3 != -1) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i4 = this.d;
        if (i4 != -1) {
            codedOutputByteBufferNano.writeUInt32(4, i4);
        }
        int i5 = this.e;
        if (i5 != -1) {
            codedOutputByteBufferNano.writeUInt32(5, i5);
        }
        if (!this.f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f);
        }
        boolean z = this.g;
        if (z) {
            codedOutputByteBufferNano.writeBool(7, z);
        }
        int i6 = this.h;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i6);
        }
        int i7 = this.i;
        if (i7 != -1) {
            codedOutputByteBufferNano.writeUInt32(9, i7);
        }
        long j = this.j;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j);
        }
        int i8 = this.k;
        if (i8 != Integer.MAX_VALUE) {
            codedOutputByteBufferNano.writeSInt32(11, i8);
        }
        int i9 = this.l;
        if (i9 != Integer.MAX_VALUE) {
            codedOutputByteBufferNano.writeSInt32(12, i9);
        }
        int i10 = this.m;
        if (i10 != Integer.MAX_VALUE) {
            codedOutputByteBufferNano.writeSInt32(13, i10);
        }
        int i11 = this.n;
        if (i11 != -1) {
            codedOutputByteBufferNano.writeUInt32(14, i11);
        }
        int i12 = this.o;
        if (i12 != -1) {
            codedOutputByteBufferNano.writeUInt32(15, i12);
        }
        int i13 = this.p;
        if (i13 != -1) {
            codedOutputByteBufferNano.writeUInt32(16, i13);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
