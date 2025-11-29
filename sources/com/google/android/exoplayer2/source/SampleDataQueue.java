package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.upstream.Allocation;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
class SampleDataQueue {
    private final int allocationLength;
    private final Allocator allocator;
    private AllocationNode firstAllocationNode;
    private AllocationNode readAllocationNode;
    private final ParsableByteArray scratch;
    private long totalBytesWritten;
    private AllocationNode writeAllocationNode;

    public SampleDataQueue(Allocator allocator) {
        this.allocator = allocator;
        int individualAllocationLength = allocator.getIndividualAllocationLength();
        this.allocationLength = individualAllocationLength;
        this.scratch = new ParsableByteArray(32);
        AllocationNode allocationNode = new AllocationNode(0L, individualAllocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
    }

    public void reset() {
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode = new AllocationNode(0L, this.allocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
        this.totalBytesWritten = 0L;
        this.allocator.trim();
    }

    public void discardUpstreamSampleBytes(long totalBytesWritten) {
        this.totalBytesWritten = totalBytesWritten;
        if (totalBytesWritten != 0) {
            AllocationNode allocationNode = this.firstAllocationNode;
            if (totalBytesWritten != allocationNode.startPosition) {
                while (this.totalBytesWritten > allocationNode.endPosition) {
                    allocationNode = allocationNode.next;
                }
                AllocationNode allocationNode2 = allocationNode.next;
                clearAllocationNodes(allocationNode2);
                AllocationNode allocationNode3 = new AllocationNode(allocationNode.endPosition, this.allocationLength);
                allocationNode.next = allocationNode3;
                if (this.totalBytesWritten == allocationNode.endPosition) {
                    allocationNode = allocationNode3;
                }
                this.writeAllocationNode = allocationNode;
                if (this.readAllocationNode == allocationNode2) {
                    this.readAllocationNode = allocationNode3;
                    return;
                }
                return;
            }
        }
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode4 = new AllocationNode(this.totalBytesWritten, this.allocationLength);
        this.firstAllocationNode = allocationNode4;
        this.readAllocationNode = allocationNode4;
        this.writeAllocationNode = allocationNode4;
    }

    public void rewind() {
        this.readAllocationNode = this.firstAllocationNode;
    }

    public void readToBuffer(DecoderInputBuffer buffer, SampleQueue.SampleExtrasHolder extrasHolder) {
        if (buffer.isEncrypted()) {
            readEncryptionData(buffer, extrasHolder);
        }
        if (buffer.hasSupplementalData()) {
            this.scratch.reset(4);
            readData(extrasHolder.offset, this.scratch.data, 4);
            int unsignedIntToInt = this.scratch.readUnsignedIntToInt();
            extrasHolder.offset += 4;
            extrasHolder.size -= 4;
            buffer.ensureSpaceForWrite(unsignedIntToInt);
            readData(extrasHolder.offset, buffer.data, unsignedIntToInt);
            extrasHolder.offset += unsignedIntToInt;
            int i = extrasHolder.size - unsignedIntToInt;
            extrasHolder.size = i;
            buffer.resetSupplementalData(i);
            readData(extrasHolder.offset, buffer.supplementalData, extrasHolder.size);
            return;
        }
        buffer.ensureSpaceForWrite(extrasHolder.size);
        readData(extrasHolder.offset, buffer.data, extrasHolder.size);
    }

    public void discardDownstreamTo(long absolutePosition) {
        AllocationNode allocationNode;
        if (absolutePosition == -1) {
            return;
        }
        while (true) {
            allocationNode = this.firstAllocationNode;
            if (absolutePosition < allocationNode.endPosition) {
                break;
            }
            this.allocator.release(allocationNode.allocation);
            this.firstAllocationNode = this.firstAllocationNode.clear();
        }
        if (this.readAllocationNode.startPosition < allocationNode.startPosition) {
            this.readAllocationNode = allocationNode;
        }
    }

    public long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public int sampleData(DataReader input, int length, boolean allowEndOfInput) throws IOException {
        int iPreAppend = preAppend(length);
        AllocationNode allocationNode = this.writeAllocationNode;
        int i = input.read(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), iPreAppend);
        if (i != -1) {
            postAppend(i);
            return i;
        }
        if (allowEndOfInput) {
            return -1;
        }
        throw new EOFException();
    }

    public void sampleData(ParsableByteArray buffer, int length) {
        while (length > 0) {
            int iPreAppend = preAppend(length);
            AllocationNode allocationNode = this.writeAllocationNode;
            buffer.readBytes(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), iPreAppend);
            length -= iPreAppend;
            postAppend(iPreAppend);
        }
    }

    private void readEncryptionData(DecoderInputBuffer buffer, SampleQueue.SampleExtrasHolder extrasHolder) {
        long j = extrasHolder.offset;
        int unsignedShort = 1;
        this.scratch.reset(1);
        readData(j, this.scratch.data, 1);
        long j2 = j + 1;
        byte b = this.scratch.data[0];
        boolean z = (b & 128) != 0;
        int i = b & 127;
        CryptoInfo cryptoInfo = buffer.cryptoInfo;
        byte[] bArr = cryptoInfo.iv;
        if (bArr == null) {
            cryptoInfo.iv = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        readData(j2, cryptoInfo.iv, i);
        long j3 = j2 + i;
        if (z) {
            this.scratch.reset(2);
            readData(j3, this.scratch.data, 2);
            j3 += 2;
            unsignedShort = this.scratch.readUnsignedShort();
        }
        int i2 = unsignedShort;
        int[] iArr = cryptoInfo.numBytesOfClearData;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo.numBytesOfEncryptedData;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i2 * 6;
            this.scratch.reset(i3);
            readData(j3, this.scratch.data, i3);
            j3 += i3;
            this.scratch.setPosition(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = this.scratch.readUnsignedShort();
                iArr4[i4] = this.scratch.readUnsignedIntToInt();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = extrasHolder.size - ((int) (j3 - extrasHolder.offset));
        }
        TrackOutput.CryptoData cryptoData = (TrackOutput.CryptoData) Util.castNonNull(extrasHolder.cryptoData);
        cryptoInfo.set(i2, iArr2, iArr4, cryptoData.encryptionKey, cryptoInfo.iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        long j4 = extrasHolder.offset;
        int i5 = (int) (j3 - j4);
        extrasHolder.offset = j4 + i5;
        extrasHolder.size -= i5;
    }

    private void readData(long absolutePosition, ByteBuffer target, int length) {
        advanceReadTo(absolutePosition);
        while (length > 0) {
            int iMin = Math.min(length, (int) (this.readAllocationNode.endPosition - absolutePosition));
            AllocationNode allocationNode = this.readAllocationNode;
            target.put(allocationNode.allocation.data, allocationNode.translateOffset(absolutePosition), iMin);
            length -= iMin;
            absolutePosition += iMin;
            AllocationNode allocationNode2 = this.readAllocationNode;
            if (absolutePosition == allocationNode2.endPosition) {
                this.readAllocationNode = allocationNode2.next;
            }
        }
    }

    private void readData(long absolutePosition, byte[] target, int length) {
        advanceReadTo(absolutePosition);
        int i = length;
        while (i > 0) {
            int iMin = Math.min(i, (int) (this.readAllocationNode.endPosition - absolutePosition));
            AllocationNode allocationNode = this.readAllocationNode;
            System.arraycopy(allocationNode.allocation.data, allocationNode.translateOffset(absolutePosition), target, length - i, iMin);
            i -= iMin;
            absolutePosition += iMin;
            AllocationNode allocationNode2 = this.readAllocationNode;
            if (absolutePosition == allocationNode2.endPosition) {
                this.readAllocationNode = allocationNode2.next;
            }
        }
    }

    private void advanceReadTo(long absolutePosition) {
        while (true) {
            AllocationNode allocationNode = this.readAllocationNode;
            if (absolutePosition < allocationNode.endPosition) {
                return;
            } else {
                this.readAllocationNode = allocationNode.next;
            }
        }
    }

    private void clearAllocationNodes(AllocationNode allocationNode) {
        if (allocationNode.wasInitialized) {
            AllocationNode allocationNode2 = this.writeAllocationNode;
            boolean z = allocationNode2.wasInitialized;
            int i = (z ? 1 : 0) + (((int) (allocationNode2.startPosition - allocationNode.startPosition)) / this.allocationLength);
            Allocation[] allocationArr = new Allocation[i];
            for (int i2 = 0; i2 < i; i2++) {
                allocationArr[i2] = allocationNode.allocation;
                allocationNode = allocationNode.clear();
            }
            this.allocator.release(allocationArr);
        }
    }

    private int preAppend(int length) {
        AllocationNode allocationNode = this.writeAllocationNode;
        if (!allocationNode.wasInitialized) {
            allocationNode.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
        }
        return Math.min(length, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
    }

    private void postAppend(int length) {
        long j = this.totalBytesWritten + length;
        this.totalBytesWritten = j;
        AllocationNode allocationNode = this.writeAllocationNode;
        if (j == allocationNode.endPosition) {
            this.writeAllocationNode = allocationNode.next;
        }
    }

    private static final class AllocationNode {
        public Allocation allocation;
        public final long endPosition;
        public AllocationNode next;
        public final long startPosition;
        public boolean wasInitialized;

        public AllocationNode(long startPosition, int allocationLength) {
            this.startPosition = startPosition;
            this.endPosition = startPosition + allocationLength;
        }

        public void initialize(Allocation allocation, AllocationNode next) {
            this.allocation = allocation;
            this.next = next;
            this.wasInitialized = true;
        }

        public int translateOffset(long absolutePosition) {
            return ((int) (absolutePosition - this.startPosition)) + this.allocation.offset;
        }

        public AllocationNode clear() {
            this.allocation = null;
            AllocationNode allocationNode = this.next;
            this.next = null;
            return allocationNode;
        }
    }
}
