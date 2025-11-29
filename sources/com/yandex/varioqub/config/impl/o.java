package com.yandex.varioqub.config.impl;

import com.yandex.varioqub.config.model.ConfigValue;
import com.yandex.varioqub.protobuf.nano.CodedInputByteBufferNano;
import com.yandex.varioqub.protobuf.nano.CodedOutputByteBufferNano;
import com.yandex.varioqub.protobuf.nano.InternalNano;
import com.yandex.varioqub.protobuf.nano.MessageNano;
import com.yandex.varioqub.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class o extends MessageNano {
    public static volatile o[] c;
    public String a;
    public double b;

    public o() {
        a();
    }

    public static o[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                try {
                    if (c == null) {
                        c = new o[0];
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public final void a() {
        this.a = "";
        this.b = ConfigValue.DOUBLE_DEFAULT_VALUE;
        this.cachedSize = -1;
    }

    @Override // com.yandex.varioqub.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.a.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.a);
        }
        return Double.doubleToLongBits(this.b) != Double.doubleToLongBits(ConfigValue.DOUBLE_DEFAULT_VALUE) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(2, this.b) : iComputeSerializedSize;
    }

    @Override // com.yandex.varioqub.protobuf.nano.MessageNano
    public final MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
            if (tag == 10) {
                this.a = codedInputByteBufferNano.readString();
            } else if (tag == 17) {
                this.b = codedInputByteBufferNano.readDouble();
            } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                break;
            }
        }
        return this;
    }

    @Override // com.yandex.varioqub.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.a);
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(ConfigValue.DOUBLE_DEFAULT_VALUE)) {
            codedOutputByteBufferNano.writeDouble(2, this.b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
