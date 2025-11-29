package com.yandex.metrica.impl.ob;

import com.google.protobuf.nano.ym.CodedInputByteBufferNano;
import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ym.InternalNano;
import com.google.protobuf.nano.ym.MessageNano;
import com.google.protobuf.nano.ym.WireFormatNano;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class Ef extends MessageNano {
    public a a;
    public boolean b;

    public static final class a extends MessageNano {
        public C0283a[] a;

        /* renamed from: com.yandex.metrica.impl.ob.Ef$a$a, reason: collision with other inner class name */
        public static final class C0283a extends MessageNano {
            private static volatile C0283a[] c;
            public String a;
            public String b;

            public C0283a() {
                a();
            }

            public static C0283a[] b() {
                if (c == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        try {
                            if (c == null) {
                                c = new C0283a[0];
                            }
                        } finally {
                        }
                    }
                }
                return c;
            }

            public C0283a a() {
                this.a = "";
                this.b = "";
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.ym.MessageNano
            protected int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.a);
                return !this.b.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.b) : iComputeSerializedSize;
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
                if (!this.b.equals("")) {
                    codedOutputByteBufferNano.writeString(2, this.b);
                }
                super.writeTo(codedOutputByteBufferNano);
            }
        }

        public a() {
            a();
        }

        public a a() {
            this.a = C0283a.b();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        protected int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            C0283a[] c0283aArr = this.a;
            if (c0283aArr != null && c0283aArr.length > 0) {
                int i = 0;
                while (true) {
                    C0283a[] c0283aArr2 = this.a;
                    if (i >= c0283aArr2.length) {
                        break;
                    }
                    C0283a c0283a = c0283aArr2[i];
                    if (c0283a != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0283a);
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
                    C0283a[] c0283aArr = this.a;
                    int length = c0283aArr == null ? 0 : c0283aArr.length;
                    int i = repeatedFieldArrayLength + length;
                    C0283a[] c0283aArr2 = new C0283a[i];
                    if (length != 0) {
                        System.arraycopy(c0283aArr, 0, c0283aArr2, 0, length);
                    }
                    while (length < i - 1) {
                        C0283a c0283a = new C0283a();
                        c0283aArr2[length] = c0283a;
                        codedInputByteBufferNano.readMessage(c0283a);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    C0283a c0283a2 = new C0283a();
                    c0283aArr2[length] = c0283a2;
                    codedInputByteBufferNano.readMessage(c0283a2);
                    this.a = c0283aArr2;
                } else if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    break;
                }
            }
            return this;
        }

        @Override // com.google.protobuf.nano.ym.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            C0283a[] c0283aArr = this.a;
            if (c0283aArr != null && c0283aArr.length > 0) {
                int i = 0;
                while (true) {
                    C0283a[] c0283aArr2 = this.a;
                    if (i >= c0283aArr2.length) {
                        break;
                    }
                    C0283a c0283a = c0283aArr2[i];
                    if (c0283a != null) {
                        codedOutputByteBufferNano.writeMessage(1, c0283a);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public Ef() {
        a();
    }

    public Ef a() {
        this.a = null;
        this.b = false;
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
        boolean z = this.b;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, z) : iComputeSerializedSize;
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
        a aVar = this.a;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aVar);
        }
        boolean z = this.b;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
