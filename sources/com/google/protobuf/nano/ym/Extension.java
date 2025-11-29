package com.google.protobuf.nano.ym;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Extension {
    public static final int TYPE_BOOL = 8;
    public static final int TYPE_BYTES = 12;
    public static final int TYPE_DOUBLE = 1;
    public static final int TYPE_ENUM = 14;
    public static final int TYPE_FIXED32 = 7;
    public static final int TYPE_FIXED64 = 6;
    public static final int TYPE_FLOAT = 2;
    public static final int TYPE_GROUP = 10;
    public static final int TYPE_INT32 = 5;
    public static final int TYPE_INT64 = 3;
    public static final int TYPE_MESSAGE = 11;
    public static final int TYPE_SFIXED32 = 15;
    public static final int TYPE_SFIXED64 = 16;
    public static final int TYPE_SINT32 = 17;
    public static final int TYPE_SINT64 = 18;
    public static final int TYPE_STRING = 9;
    public static final int TYPE_UINT32 = 13;
    public static final int TYPE_UINT64 = 4;
    protected final Class clazz;
    protected final boolean repeated;
    protected final int tag;
    protected final int type;

    class PrimitiveExtension extends Extension {
        private final int nonPackedTag;
        private final int packedTag;

        public PrimitiveExtension(int i, Class cls, int i2, boolean z, int i3, int i4) {
            super(i, cls, i2, z);
            this.nonPackedTag = i3;
            this.packedTag = i4;
        }

        private int computePackedDataSize(Object obj) {
            int iComputeInt64SizeNoTag;
            int length = Array.getLength(obj);
            int i = 0;
            switch (this.type) {
                case 1:
                case 6:
                case 16:
                    return length * 8;
                case 2:
                case 7:
                case 15:
                    return length * 4;
                case 3:
                    iComputeInt64SizeNoTag = 0;
                    while (i < length) {
                        iComputeInt64SizeNoTag += CodedOutputByteBufferNano.computeInt64SizeNoTag(Array.getLong(obj, i));
                        i++;
                    }
                    break;
                case 4:
                    iComputeInt64SizeNoTag = 0;
                    while (i < length) {
                        iComputeInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(Array.getLong(obj, i));
                        i++;
                    }
                    break;
                case 5:
                    iComputeInt64SizeNoTag = 0;
                    while (i < length) {
                        iComputeInt64SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(Array.getInt(obj, i));
                        i++;
                    }
                    break;
                case 8:
                    return length;
                case 9:
                case 10:
                case 11:
                case 12:
                default:
                    throw new IllegalArgumentException("Unexpected non-packable type " + this.type);
                case 13:
                    iComputeInt64SizeNoTag = 0;
                    while (i < length) {
                        iComputeInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(Array.getInt(obj, i));
                        i++;
                    }
                    break;
                case 14:
                    iComputeInt64SizeNoTag = 0;
                    while (i < length) {
                        iComputeInt64SizeNoTag += CodedOutputByteBufferNano.computeEnumSizeNoTag(Array.getInt(obj, i));
                        i++;
                    }
                    break;
                case 17:
                    iComputeInt64SizeNoTag = 0;
                    while (i < length) {
                        iComputeInt64SizeNoTag += CodedOutputByteBufferNano.computeSInt32SizeNoTag(Array.getInt(obj, i));
                        i++;
                    }
                    break;
                case 18:
                    iComputeInt64SizeNoTag = 0;
                    while (i < length) {
                        iComputeInt64SizeNoTag += CodedOutputByteBufferNano.computeSInt64SizeNoTag(Array.getLong(obj, i));
                        i++;
                    }
                    break;
            }
            return iComputeInt64SizeNoTag;
        }

        @Override // com.google.protobuf.nano.ym.Extension
        protected int computeRepeatedSerializedSize(Object obj) {
            int i = this.tag;
            if (i == this.nonPackedTag) {
                return super.computeRepeatedSerializedSize(obj);
            }
            if (i == this.packedTag) {
                int iComputePackedDataSize = computePackedDataSize(obj);
                return iComputePackedDataSize + CodedOutputByteBufferNano.computeRawVarint32Size(iComputePackedDataSize) + CodedOutputByteBufferNano.computeRawVarint32Size(this.tag);
            }
            throw new IllegalArgumentException("Unexpected repeated extension tag " + this.tag + ", unequal to both non-packed variant " + this.nonPackedTag + " and packed variant " + this.packedTag);
        }

        @Override // com.google.protobuf.nano.ym.Extension
        protected final int computeSingularSerializedSize(Object obj) {
            int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
            switch (this.type) {
                case 1:
                    return CodedOutputByteBufferNano.computeDoubleSize(tagFieldNumber, ((Double) obj).doubleValue());
                case 2:
                    return CodedOutputByteBufferNano.computeFloatSize(tagFieldNumber, ((Float) obj).floatValue());
                case 3:
                    return CodedOutputByteBufferNano.computeInt64Size(tagFieldNumber, ((Long) obj).longValue());
                case 4:
                    return CodedOutputByteBufferNano.computeUInt64Size(tagFieldNumber, ((Long) obj).longValue());
                case 5:
                    return CodedOutputByteBufferNano.computeInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 6:
                    return CodedOutputByteBufferNano.computeFixed64Size(tagFieldNumber, ((Long) obj).longValue());
                case 7:
                    return CodedOutputByteBufferNano.computeFixed32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 8:
                    return CodedOutputByteBufferNano.computeBoolSize(tagFieldNumber, ((Boolean) obj).booleanValue());
                case 9:
                    return CodedOutputByteBufferNano.computeStringSize(tagFieldNumber, (String) obj);
                case 10:
                case 11:
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
                case 12:
                    return CodedOutputByteBufferNano.computeBytesSize(tagFieldNumber, (byte[]) obj);
                case 13:
                    return CodedOutputByteBufferNano.computeUInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 14:
                    return CodedOutputByteBufferNano.computeEnumSize(tagFieldNumber, ((Integer) obj).intValue());
                case 15:
                    return CodedOutputByteBufferNano.computeSFixed32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 16:
                    return CodedOutputByteBufferNano.computeSFixed64Size(tagFieldNumber, ((Long) obj).longValue());
                case 17:
                    return CodedOutputByteBufferNano.computeSInt32Size(tagFieldNumber, ((Integer) obj).intValue());
                case 18:
                    return CodedOutputByteBufferNano.computeSInt64Size(tagFieldNumber, ((Long) obj).longValue());
            }
        }

        @Override // com.google.protobuf.nano.ym.Extension
        protected Object readData(CodedInputByteBufferNano codedInputByteBufferNano) {
            try {
                switch (this.type) {
                    case 1:
                        return Double.valueOf(codedInputByteBufferNano.readDouble());
                    case 2:
                        return Float.valueOf(codedInputByteBufferNano.readFloat());
                    case 3:
                        return Long.valueOf(codedInputByteBufferNano.readInt64());
                    case 4:
                        return Long.valueOf(codedInputByteBufferNano.readUInt64());
                    case 5:
                        return Integer.valueOf(codedInputByteBufferNano.readInt32());
                    case 6:
                        return Long.valueOf(codedInputByteBufferNano.readFixed64());
                    case 7:
                        return Integer.valueOf(codedInputByteBufferNano.readFixed32());
                    case 8:
                        return Boolean.valueOf(codedInputByteBufferNano.readBool());
                    case 9:
                        return codedInputByteBufferNano.readString();
                    case 10:
                    case 11:
                    default:
                        throw new IllegalArgumentException("Unknown type " + this.type);
                    case 12:
                        return codedInputByteBufferNano.readBytes();
                    case 13:
                        return Integer.valueOf(codedInputByteBufferNano.readUInt32());
                    case 14:
                        return Integer.valueOf(codedInputByteBufferNano.readEnum());
                    case 15:
                        return Integer.valueOf(codedInputByteBufferNano.readSFixed32());
                    case 16:
                        return Long.valueOf(codedInputByteBufferNano.readSFixed64());
                    case 17:
                        return Integer.valueOf(codedInputByteBufferNano.readSInt32());
                    case 18:
                        return Long.valueOf(codedInputByteBufferNano.readSInt64());
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("Error reading extension field", e);
            }
        }

        @Override // com.google.protobuf.nano.ym.Extension
        protected void readDataInto(UnknownFieldData unknownFieldData, List list) {
            int i = unknownFieldData.tag;
            int i2 = this.nonPackedTag;
            byte[] bArr = unknownFieldData.bytes;
            if (i == i2) {
                list.add(readData(CodedInputByteBufferNano.newInstance(bArr)));
                return;
            }
            CodedInputByteBufferNano codedInputByteBufferNanoNewInstance = CodedInputByteBufferNano.newInstance(bArr);
            try {
                codedInputByteBufferNanoNewInstance.pushLimit(codedInputByteBufferNanoNewInstance.readRawVarint32());
                while (!codedInputByteBufferNanoNewInstance.isAtEnd()) {
                    list.add(readData(codedInputByteBufferNanoNewInstance));
                }
            } catch (IOException e) {
                throw new IllegalArgumentException("Error reading extension field", e);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.protobuf.nano.ym.Extension
        protected void writeRepeatedData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
            int i = this.tag;
            if (i == this.nonPackedTag) {
                super.writeRepeatedData(obj, codedOutputByteBufferNano);
                return;
            }
            if (i != this.packedTag) {
                throw new IllegalArgumentException("Unexpected repeated extension tag " + this.tag + ", unequal to both non-packed variant " + this.nonPackedTag + " and packed variant " + this.packedTag);
            }
            int length = Array.getLength(obj);
            int iComputePackedDataSize = computePackedDataSize(obj);
            try {
                codedOutputByteBufferNano.writeRawVarint32(this.tag);
                codedOutputByteBufferNano.writeRawVarint32(iComputePackedDataSize);
                int i2 = 0;
                switch (this.type) {
                    case 1:
                        while (i2 < length) {
                            codedOutputByteBufferNano.writeDoubleNoTag(Array.getDouble(obj, i2));
                            i2++;
                        }
                        return;
                    case 2:
                        while (i2 < length) {
                            codedOutputByteBufferNano.writeFloatNoTag(Array.getFloat(obj, i2));
                            i2++;
                        }
                        return;
                    case 3:
                        while (i2 < length) {
                            codedOutputByteBufferNano.writeInt64NoTag(Array.getLong(obj, i2));
                            i2++;
                        }
                        return;
                    case 4:
                        while (i2 < length) {
                            codedOutputByteBufferNano.writeUInt64NoTag(Array.getLong(obj, i2));
                            i2++;
                        }
                        return;
                    case 5:
                        while (i2 < length) {
                            codedOutputByteBufferNano.writeInt32NoTag(Array.getInt(obj, i2));
                            i2++;
                        }
                        return;
                    case 6:
                        while (i2 < length) {
                            codedOutputByteBufferNano.writeFixed64NoTag(Array.getLong(obj, i2));
                            i2++;
                        }
                        return;
                    case 7:
                        while (i2 < length) {
                            codedOutputByteBufferNano.writeFixed32NoTag(Array.getInt(obj, i2));
                            i2++;
                        }
                        return;
                    case 8:
                        while (i2 < length) {
                            codedOutputByteBufferNano.writeBoolNoTag(Array.getBoolean(obj, i2));
                            i2++;
                        }
                        return;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    default:
                        throw new IllegalArgumentException("Unpackable type " + this.type);
                    case 13:
                        while (i2 < length) {
                            codedOutputByteBufferNano.writeUInt32NoTag(Array.getInt(obj, i2));
                            i2++;
                        }
                        return;
                    case 14:
                        while (i2 < length) {
                            codedOutputByteBufferNano.writeEnumNoTag(Array.getInt(obj, i2));
                            i2++;
                        }
                        return;
                    case 15:
                        while (i2 < length) {
                            codedOutputByteBufferNano.writeSFixed32NoTag(Array.getInt(obj, i2));
                            i2++;
                        }
                        return;
                    case 16:
                        while (i2 < length) {
                            codedOutputByteBufferNano.writeSFixed64NoTag(Array.getLong(obj, i2));
                            i2++;
                        }
                        return;
                    case 17:
                        while (i2 < length) {
                            codedOutputByteBufferNano.writeSInt32NoTag(Array.getInt(obj, i2));
                            i2++;
                        }
                        return;
                    case 18:
                        while (i2 < length) {
                            codedOutputByteBufferNano.writeSInt64NoTag(Array.getLong(obj, i2));
                            i2++;
                        }
                        return;
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override // com.google.protobuf.nano.ym.Extension
        protected final void writeSingularData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
            try {
                codedOutputByteBufferNano.writeRawVarint32(this.tag);
                switch (this.type) {
                    case 1:
                        codedOutputByteBufferNano.writeDoubleNoTag(((Double) obj).doubleValue());
                        return;
                    case 2:
                        codedOutputByteBufferNano.writeFloatNoTag(((Float) obj).floatValue());
                        return;
                    case 3:
                        codedOutputByteBufferNano.writeInt64NoTag(((Long) obj).longValue());
                        return;
                    case 4:
                        codedOutputByteBufferNano.writeUInt64NoTag(((Long) obj).longValue());
                        return;
                    case 5:
                        codedOutputByteBufferNano.writeInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 6:
                        codedOutputByteBufferNano.writeFixed64NoTag(((Long) obj).longValue());
                        return;
                    case 7:
                        codedOutputByteBufferNano.writeFixed32NoTag(((Integer) obj).intValue());
                        return;
                    case 8:
                        codedOutputByteBufferNano.writeBoolNoTag(((Boolean) obj).booleanValue());
                        return;
                    case 9:
                        codedOutputByteBufferNano.writeStringNoTag((String) obj);
                        return;
                    case 10:
                    case 11:
                    default:
                        throw new IllegalArgumentException("Unknown type " + this.type);
                    case 12:
                        codedOutputByteBufferNano.writeBytesNoTag((byte[]) obj);
                        return;
                    case 13:
                        codedOutputByteBufferNano.writeUInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 14:
                        codedOutputByteBufferNano.writeEnumNoTag(((Integer) obj).intValue());
                        return;
                    case 15:
                        codedOutputByteBufferNano.writeSFixed32NoTag(((Integer) obj).intValue());
                        return;
                    case 16:
                        codedOutputByteBufferNano.writeSFixed64NoTag(((Long) obj).longValue());
                        return;
                    case 17:
                        codedOutputByteBufferNano.writeSInt32NoTag(((Integer) obj).intValue());
                        return;
                    case 18:
                        codedOutputByteBufferNano.writeSInt64NoTag(((Long) obj).longValue());
                        return;
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private Extension(int i, Class cls, int i2, boolean z) {
        this.type = i;
        this.clazz = cls;
        this.tag = i2;
        this.repeated = z;
    }

    public static Extension createMessageTyped(int i, Class cls, int i2) {
        return new Extension(i, cls, i2, false);
    }

    public static Extension createPrimitiveTyped(int i, Class cls, int i2) {
        return new PrimitiveExtension(i, cls, i2, false, 0, 0);
    }

    public static Extension createRepeatedMessageTyped(int i, Class cls, int i2) {
        return new Extension(i, cls, i2, true);
    }

    public static Extension createRepeatedPrimitiveTyped(int i, Class cls, int i2, int i3, int i4) {
        return new PrimitiveExtension(i, cls, i2, true, i3, i4);
    }

    private Object getRepeatedValueFrom(List list) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            UnknownFieldData unknownFieldData = (UnknownFieldData) list.get(i);
            if (unknownFieldData.bytes.length != 0) {
                readDataInto(unknownFieldData, arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        Class cls = this.clazz;
        Object objCast = cls.cast(Array.newInstance(cls.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(objCast, i2, arrayList.get(i2));
        }
        return objCast;
    }

    private Object getSingularValueFrom(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.clazz.cast(readData(CodedInputByteBufferNano.newInstance(((UnknownFieldData) list.get(list.size() - 1)).bytes)));
    }

    protected int computeRepeatedSerializedSize(Object obj) {
        int length = Array.getLength(obj);
        int iComputeSingularSerializedSize = 0;
        for (int i = 0; i < length; i++) {
            if (Array.get(obj, i) != null) {
                iComputeSingularSerializedSize += computeSingularSerializedSize(Array.get(obj, i));
            }
        }
        return iComputeSingularSerializedSize;
    }

    int computeSerializedSize(Object obj) {
        return this.repeated ? computeRepeatedSerializedSize(obj) : computeSingularSerializedSize(obj);
    }

    protected int computeSingularSerializedSize(Object obj) {
        int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
        int i = this.type;
        if (i == 10) {
            return CodedOutputByteBufferNano.computeGroupSize(tagFieldNumber, (MessageNano) obj);
        }
        if (i == 11) {
            return CodedOutputByteBufferNano.computeMessageSize(tagFieldNumber, (MessageNano) obj);
        }
        throw new IllegalArgumentException("Unknown type " + this.type);
    }

    final Object getValueFrom(List list) {
        if (list == null) {
            return null;
        }
        return this.repeated ? getRepeatedValueFrom(list) : getSingularValueFrom(list);
    }

    protected Object readData(CodedInputByteBufferNano codedInputByteBufferNano) {
        Class<?> componentType = this.repeated ? this.clazz.getComponentType() : this.clazz;
        try {
            int i = this.type;
            if (i == 10) {
                MessageNano messageNano = (MessageNano) componentType.newInstance();
                codedInputByteBufferNano.readGroup(messageNano, WireFormatNano.getTagFieldNumber(this.tag));
                return messageNano;
            }
            if (i == 11) {
                MessageNano messageNano2 = (MessageNano) componentType.newInstance();
                codedInputByteBufferNano.readMessage(messageNano2);
                return messageNano2;
            }
            throw new IllegalArgumentException("Unknown type " + this.type);
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading extension field", e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (InstantiationException e3) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e3);
        }
    }

    protected void readDataInto(UnknownFieldData unknownFieldData, List list) {
        list.add(readData(CodedInputByteBufferNano.newInstance(unknownFieldData.bytes)));
    }

    protected void writeRepeatedData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                writeSingularData(obj2, codedOutputByteBufferNano);
            }
        }
    }

    protected void writeSingularData(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) {
        try {
            codedOutputByteBufferNano.writeRawVarint32(this.tag);
            int i = this.type;
            if (i == 10) {
                int tagFieldNumber = WireFormatNano.getTagFieldNumber(this.tag);
                codedOutputByteBufferNano.writeGroupNoTag((MessageNano) obj);
                codedOutputByteBufferNano.writeTag(tagFieldNumber, 4);
            } else {
                if (i == 11) {
                    codedOutputByteBufferNano.writeMessageNoTag((MessageNano) obj);
                    return;
                }
                throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    void writeTo(Object obj, CodedOutputByteBufferNano codedOutputByteBufferNano) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (this.repeated) {
            writeRepeatedData(obj, codedOutputByteBufferNano);
        } else {
            writeSingularData(obj, codedOutputByteBufferNano);
        }
    }
}
