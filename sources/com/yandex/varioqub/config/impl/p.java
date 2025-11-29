package com.yandex.varioqub.config.impl;

import com.yandex.varioqub.protobuf.nano.CodedInputByteBufferNano;
import com.yandex.varioqub.protobuf.nano.CodedOutputByteBufferNano;
import com.yandex.varioqub.protobuf.nano.InternalNano;
import com.yandex.varioqub.protobuf.nano.MessageNano;
import com.yandex.varioqub.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class p extends MessageNano {
    public String a;
    public String b;
    public n[] c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public o[] j;
    public String k;
    public String l;
    public String m;
    public String n;

    public p() {
        a();
    }

    public final void a() {
        this.a = "";
        this.b = "";
        if (n.c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (n.c == null) {
                        n.c = new n[0];
                    }
                } finally {
                }
            }
        }
        this.c = n.c;
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = o.b();
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.cachedSize = -1;
    }

    @Override // com.yandex.varioqub.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.a.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
        }
        if (!this.b.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        n[] nVarArr = this.c;
        int i = 0;
        if (nVarArr != null && nVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                n[] nVarArr2 = this.c;
                if (i2 >= nVarArr2.length) {
                    break;
                }
                n nVar = nVarArr2[i2];
                if (nVar != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(3, nVar) + iComputeSerializedSize;
                }
                i2++;
            }
        }
        if (!this.d.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.d);
        }
        if (!this.e.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.e);
        }
        if (!this.f.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f);
        }
        if (!this.g.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.g);
        }
        if (!this.h.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.h);
        }
        if (!this.i.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.i);
        }
        o[] oVarArr = this.j;
        if (oVarArr != null && oVarArr.length > 0) {
            while (true) {
                o[] oVarArr2 = this.j;
                if (i >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i];
                if (oVar != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(10, oVar) + iComputeSerializedSize;
                }
                i++;
            }
        }
        if (!this.k.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.k);
        }
        if (!this.l.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.l);
        }
        if (!this.m.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.m);
        }
        return !this.n.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(14, this.n) : iComputeSerializedSize;
    }

    @Override // com.yandex.varioqub.protobuf.nano.MessageNano
    public final MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    n[] nVarArr = this.c;
                    int length = nVarArr == null ? 0 : nVarArr.length;
                    int i = repeatedFieldArrayLength + length;
                    n[] nVarArr2 = new n[i];
                    if (length != 0) {
                        System.arraycopy(nVarArr, 0, nVarArr2, 0, length);
                    }
                    while (length < i - 1) {
                        n nVar = new n();
                        nVarArr2[length] = nVar;
                        codedInputByteBufferNano.readMessage(nVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    n nVar2 = new n();
                    nVarArr2[length] = nVar2;
                    codedInputByteBufferNano.readMessage(nVar2);
                    this.c = nVarArr2;
                    break;
                case 34:
                    this.d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    o[] oVarArr = this.j;
                    int length2 = oVarArr == null ? 0 : oVarArr.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    o[] oVarArr2 = new o[i2];
                    if (length2 != 0) {
                        System.arraycopy(oVarArr, 0, oVarArr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        o oVar = new o();
                        oVarArr2[length2] = oVar;
                        codedInputByteBufferNano.readMessage(oVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    o oVar2 = new o();
                    oVarArr2[length2] = oVar2;
                    codedInputByteBufferNano.readMessage(oVar2);
                    this.j = oVarArr2;
                    break;
                case 90:
                    this.k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.l = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.m = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.n = codedInputByteBufferNano.readString();
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

    @Override // com.yandex.varioqub.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.a);
        }
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        n[] nVarArr = this.c;
        int i = 0;
        if (nVarArr != null && nVarArr.length > 0) {
            int i2 = 0;
            while (true) {
                n[] nVarArr2 = this.c;
                if (i2 >= nVarArr2.length) {
                    break;
                }
                n nVar = nVarArr2[i2];
                if (nVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, nVar);
                }
                i2++;
            }
        }
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.d);
        }
        if (!this.e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.e);
        }
        if (!this.f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f);
        }
        if (!this.g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.g);
        }
        if (!this.h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.h);
        }
        if (!this.i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.i);
        }
        o[] oVarArr = this.j;
        if (oVarArr != null && oVarArr.length > 0) {
            while (true) {
                o[] oVarArr2 = this.j;
                if (i >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i];
                if (oVar != null) {
                    codedOutputByteBufferNano.writeMessage(10, oVar);
                }
                i++;
            }
        }
        if (!this.k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.k);
        }
        if (!this.l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.l);
        }
        if (!this.m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.m);
        }
        if (!this.n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.n);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
