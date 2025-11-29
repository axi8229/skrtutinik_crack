package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;
import kotlin.KotlinVersion;

/* loaded from: classes2.dex */
public final class VorbisBitArray {
    private int bitOffset;
    private final int byteLimit;
    private int byteOffset;
    private final byte[] data;

    public VorbisBitArray(byte[] data) {
        this.data = data;
        this.byteLimit = data.length;
    }

    public boolean readBit() {
        boolean z = (((this.data[this.byteOffset] & 255) >> this.bitOffset) & 1) == 1;
        skipBits(1);
        return z;
    }

    public int readBits(int numBits) {
        int i = this.byteOffset;
        int iMin = Math.min(numBits, 8 - this.bitOffset);
        int i2 = i + 1;
        int i3 = ((this.data[i] & 255) >> this.bitOffset) & (KotlinVersion.MAX_COMPONENT_VALUE >> (8 - iMin));
        while (iMin < numBits) {
            i3 |= (this.data[i2] & 255) << iMin;
            iMin += 8;
            i2++;
        }
        int i4 = i3 & ((-1) >>> (32 - numBits));
        skipBits(numBits);
        return i4;
    }

    public void skipBits(int numBits) {
        int i = numBits / 8;
        int i2 = this.byteOffset + i;
        this.byteOffset = i2;
        int i3 = this.bitOffset + (numBits - (i * 8));
        this.bitOffset = i3;
        if (i3 > 7) {
            this.byteOffset = i2 + 1;
            this.bitOffset = i3 - 8;
        }
        assertValidOffset();
    }

    public int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    private void assertValidOffset() {
        int i;
        int i2 = this.byteOffset;
        Assertions.checkState(i2 >= 0 && (i2 < (i = this.byteLimit) || (i2 == i && this.bitOffset == 0)));
    }
}
