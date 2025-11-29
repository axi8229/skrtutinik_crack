package com.google.protobuf.nano.ym;

import com.google.protobuf.nano.ym.CodedOutputByteBufferNano;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class FieldData {
    private Extension cachedExtension;
    private List unknownFieldData;
    private Object value;

    FieldData() {
        this.unknownFieldData = new ArrayList();
    }

    FieldData(Extension extension, Object obj) {
        this.cachedExtension = extension;
        this.value = obj;
    }

    private byte[] toByteArray() throws CodedOutputByteBufferNano.OutOfSpaceException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        byte[] bArr = new byte[computeSerializedSize()];
        writeTo(CodedOutputByteBufferNano.newInstance(bArr));
        return bArr;
    }

    void addUnknownField(UnknownFieldData unknownFieldData) {
        this.unknownFieldData.add(unknownFieldData);
    }

    int computeSerializedSize() {
        Object obj = this.value;
        if (obj != null) {
            return this.cachedExtension.computeSerializedSize(obj);
        }
        Iterator it = this.unknownFieldData.iterator();
        int iComputeSerializedSize = 0;
        while (it.hasNext()) {
            iComputeSerializedSize += ((UnknownFieldData) it.next()).computeSerializedSize();
        }
        return iComputeSerializedSize;
    }

    public boolean equals(Object obj) {
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldData)) {
            return false;
        }
        FieldData fieldData = (FieldData) obj;
        if (this.value == null || fieldData.value == null) {
            List list2 = this.unknownFieldData;
            if (list2 != null && (list = fieldData.unknownFieldData) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(toByteArray(), fieldData.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        Extension extension = this.cachedExtension;
        if (extension != fieldData.cachedExtension) {
            return false;
        }
        if (!extension.clazz.isArray()) {
            return this.value.equals(fieldData.value);
        }
        Object obj2 = this.value;
        return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) fieldData.value) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) fieldData.value) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) fieldData.value) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) fieldData.value) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) fieldData.value) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) fieldData.value) : Arrays.deepEquals((Object[]) obj2, (Object[]) fieldData.value);
    }

    Object getValue(Extension extension) {
        if (this.value == null) {
            this.cachedExtension = extension;
            this.value = extension.getValueFrom(this.unknownFieldData);
            this.unknownFieldData = null;
        } else if (this.cachedExtension != extension) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return this.value;
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    void setValue(Extension extension, Object obj) {
        this.cachedExtension = extension;
        this.value = obj;
        this.unknownFieldData = null;
    }

    void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        Object obj = this.value;
        if (obj != null) {
            this.cachedExtension.writeTo(obj, codedOutputByteBufferNano);
            return;
        }
        Iterator it = this.unknownFieldData.iterator();
        while (it.hasNext()) {
            ((UnknownFieldData) it.next()).writeTo(codedOutputByteBufferNano);
        }
    }
}
