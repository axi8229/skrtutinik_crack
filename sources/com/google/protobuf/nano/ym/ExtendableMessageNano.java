package com.google.protobuf.nano.ym;

import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;

/* loaded from: classes3.dex */
public abstract class ExtendableMessageNano extends MessageNano {
    protected FieldArray unknownFieldData;

    @Override // com.google.protobuf.nano.ym.MessageNano
    protected int computeSerializedSize() {
        if (this.unknownFieldData == null) {
            return 0;
        }
        int iComputeSerializedSize = 0;
        for (int i = 0; i < this.unknownFieldData.size(); i++) {
            iComputeSerializedSize += this.unknownFieldData.dataAt(i).computeSerializedSize();
        }
        return iComputeSerializedSize;
    }

    public final Object getExtension(Extension extension) {
        FieldData fieldData;
        FieldArray fieldArray = this.unknownFieldData;
        if (fieldArray == null || (fieldData = fieldArray.get(WireFormatNano.getTagFieldNumber(extension.tag))) == null) {
            return null;
        }
        return fieldData.getValue(extension);
    }

    public final boolean hasExtension(Extension extension) {
        FieldArray fieldArray = this.unknownFieldData;
        return (fieldArray == null || fieldArray.get(WireFormatNano.getTagFieldNumber(extension.tag)) == null) ? false : true;
    }

    public final ExtendableMessageNano setExtension(Extension extension, Object obj) {
        int tagFieldNumber = WireFormatNano.getTagFieldNumber(extension.tag);
        FieldData fieldData = null;
        if (obj == null) {
            FieldArray fieldArray = this.unknownFieldData;
            if (fieldArray != null) {
                fieldArray.remove(tagFieldNumber);
                if (this.unknownFieldData.isEmpty()) {
                    this.unknownFieldData = null;
                }
            }
        } else {
            FieldArray fieldArray2 = this.unknownFieldData;
            if (fieldArray2 == null) {
                this.unknownFieldData = new FieldArray();
            } else {
                fieldData = fieldArray2.get(tagFieldNumber);
            }
            if (fieldData == null) {
                this.unknownFieldData.put(tagFieldNumber, new FieldData(extension, obj));
            } else {
                fieldData.setValue(extension, obj);
            }
        }
        return this;
    }

    protected final boolean storeUnknownField(CodedInputByteBufferNano codedInputByteBufferNano, int i) {
        FieldData fieldData;
        int position = codedInputByteBufferNano.getPosition();
        if (!codedInputByteBufferNano.skipField(i)) {
            return false;
        }
        int tagFieldNumber = WireFormatNano.getTagFieldNumber(i);
        UnknownFieldData unknownFieldData = new UnknownFieldData(i, codedInputByteBufferNano.getData(position, codedInputByteBufferNano.getPosition() - position));
        FieldArray fieldArray = this.unknownFieldData;
        if (fieldArray == null) {
            this.unknownFieldData = new FieldArray();
            fieldData = null;
        } else {
            fieldData = fieldArray.get(tagFieldNumber);
        }
        if (fieldData == null) {
            fieldData = new FieldData();
            this.unknownFieldData.put(tagFieldNumber, fieldData);
        }
        fieldData.addUnknownField(unknownFieldData);
        return true;
    }

    protected final boolean unknownFieldDataEquals(ExtendableMessageNano extendableMessageNano) {
        FieldArray fieldArray = this.unknownFieldData;
        if (fieldArray != null && !fieldArray.isEmpty()) {
            return this.unknownFieldData.equals(extendableMessageNano.unknownFieldData);
        }
        FieldArray fieldArray2 = extendableMessageNano.unknownFieldData;
        return fieldArray2 == null || fieldArray2.isEmpty();
    }

    protected final int unknownFieldDataHashCode() {
        FieldArray fieldArray = this.unknownFieldData;
        if (fieldArray == null || fieldArray.isEmpty()) {
            return 0;
        }
        return this.unknownFieldData.hashCode();
    }

    @Override // com.google.protobuf.nano.ym.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (this.unknownFieldData == null) {
            return;
        }
        for (int i = 0; i < this.unknownFieldData.size(); i++) {
            this.unknownFieldData.dataAt(i).writeTo(codedOutputByteBufferNano);
        }
    }
}
