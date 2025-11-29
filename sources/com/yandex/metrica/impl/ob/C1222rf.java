package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import java.io.IOException;

/* renamed from: com.yandex.metrica.impl.ob.rf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1222rf extends MessageNano {
    private static volatile C1222rf[] f;
    public String a;
    public int b;
    public String c;
    public boolean d;
    public long e;

    public C1222rf() {
        a();
    }

    public static C1222rf[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (f == null) {
                        f = new C1222rf[0];
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public C1222rf a() {
        this.a = "";
        this.b = 0;
        this.c = "";
        this.d = false;
        this.e = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.a);
        int i = this.b;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeSInt32Size(2, i);
        }
        if (!this.c.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.c);
        }
        boolean z = this.d;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z);
        }
        long j = this.e;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j) : iComputeSerializedSize;
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
                this.b = codedInputByteBufferNano.readSInt32();
            } else if (tag == 26) {
                this.c = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.d = codedInputByteBufferNano.readBool();
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
        codedOutputByteBufferNano.writeString(1, this.a);
        int i = this.b;
        if (i != 0) {
            codedOutputByteBufferNano.writeSInt32(2, i);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        boolean z = this.d;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
        }
        long j = this.e;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
