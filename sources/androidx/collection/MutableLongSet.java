package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;

/* compiled from: LongSet.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u000bJ\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Landroidx/collection/MutableLongSet;", "Landroidx/collection/LongSet;", "", "initialCapacity", "<init>", "(I)V", "", "initializeStorage", "capacity", "initializeMetadata", "initializeGrowth", "()V", "index", "removeElementAt", "", "element", "findAbsoluteInsertIndex", "(J)I", "hash1", "findFirstAvailableSlot", "(I)I", "adjustStorage", "dropDeletes", "newCapacity", "resizeStorage", "plusAssign", "(J)V", "", "remove", "(J)Z", "growthLimit", "I", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableLongSet extends LongSet {
    private int growthLimit;

    public MutableLongSet(int i) {
        super(null);
        if (!(i >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    private final void initializeStorage(int initialCapacity) {
        int iMax = initialCapacity > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(initialCapacity)) : 0;
        this._capacity = iMax;
        initializeMetadata(iMax);
        this.elements = new long[iMax];
    }

    private final void initializeMetadata(int capacity) {
        long[] jArr;
        if (capacity == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            jArr = new long[((capacity + 15) & (-8)) >> 3];
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
        }
        this.metadata = jArr;
        int i = capacity >> 3;
        long j = 255 << ((capacity & 7) << 3);
        jArr[i] = (jArr[i] & (~j)) | j;
        initializeGrowth();
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
    }

    public final void plusAssign(long element) {
        this.elements[findAbsoluteInsertIndex(element)] = element;
    }

    private final void removeElementAt(int index) {
        this._size--;
        long[] jArr = this.metadata;
        int i = this._capacity;
        int i2 = index >> 3;
        int i3 = (index & 7) << 3;
        long j = (jArr[i2] & (~(255 << i3))) | (254 << i3);
        jArr[i2] = j;
        jArr[(((index - 7) & i) + (i & 7)) >> 3] = j;
    }

    private final int findFirstAvailableSlot(int hash1) {
        int i = this._capacity;
        int i2 = hash1 & i;
        int i3 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i4 = i2 >> 3;
            int i5 = (i2 & 7) << 3;
            long j = ((jArr[i4 + 1] << (64 - i5)) & ((-i5) >> 63)) | (jArr[i4] >>> i5);
            long j2 = j & ((~j) << 7) & (-9187201950435737472L);
            if (j2 != 0) {
                return (i2 + (Long.numberOfTrailingZeros(j2) >> 3)) & i;
            }
            i3 += 8;
            i2 = (i2 + i3) & i;
        }
    }

    private final void adjustStorage() {
        if (this._capacity > 8 && Long.compare(ULong.m2682constructorimpl(ULong.m2682constructorimpl(this._size) * 32) ^ Long.MIN_VALUE, ULong.m2682constructorimpl(ULong.m2682constructorimpl(this._capacity) * 25) ^ Long.MIN_VALUE) <= 0) {
            dropDeletes();
        } else {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        }
    }

    private final void dropDeletes() {
        int i;
        long[] jArr = this.metadata;
        int i2 = this._capacity;
        long[] jArr2 = this.elements;
        ScatterMapKt.convertMetadataForCleanup(jArr, i2);
        char c = 0;
        int i3 = 0;
        int iFindEmptySlot = -1;
        while (i3 != i2) {
            int i4 = i3 >> 3;
            int i5 = (i3 & 7) << 3;
            long j = (jArr[i4] >> i5) & 255;
            if (j == 128) {
                iFindEmptySlot = i3;
                i3++;
            } else {
                if (j == 254) {
                    int iHashCode = Long.hashCode(jArr2[i3]) * (-862048943);
                    int i6 = (iHashCode ^ (iHashCode << 16)) >>> 7;
                    int iFindFirstAvailableSlot = findFirstAvailableSlot(i6);
                    int i7 = i6 & i2;
                    if (((iFindFirstAvailableSlot - i7) & i2) / 8 == ((i3 - i7) & i2) / 8) {
                        jArr[i4] = ((r9 & 127) << i5) | ((~(255 << i5)) & jArr[i4]);
                        jArr[ArraysKt.getLastIndex(jArr)] = (jArr[c] & 72057594037927935L) | Long.MIN_VALUE;
                    } else {
                        int i8 = iFindFirstAvailableSlot >> 3;
                        long j2 = jArr[i8];
                        int i9 = (iFindFirstAvailableSlot & 7) << 3;
                        if (((j2 >> i9) & 255) == 128) {
                            int i10 = i3;
                            jArr[i8] = ((r9 & 127) << i9) | (j2 & (~(255 << i9)));
                            jArr[i4] = (jArr[i4] & (~(255 << i5))) | (128 << i5);
                            jArr2[iFindFirstAvailableSlot] = jArr2[i10];
                            jArr2[i10] = 0;
                            i = i10;
                            iFindEmptySlot = i;
                        } else {
                            int i11 = i3;
                            jArr[i8] = ((r9 & 127) << i9) | (j2 & (~(255 << i9)));
                            if (iFindEmptySlot == -1) {
                                iFindEmptySlot = ScatterMapKt.findEmptySlot(jArr, i11 + 1, i2);
                            }
                            jArr2[iFindEmptySlot] = jArr2[iFindFirstAvailableSlot];
                            jArr2[iFindFirstAvailableSlot] = jArr2[i11];
                            jArr2[i11] = jArr2[iFindEmptySlot];
                            i = i11 - 1;
                        }
                        jArr[ArraysKt.getLastIndex(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                        i3 = i + 1;
                        c = 0;
                    }
                }
                i3++;
            }
        }
        initializeGrowth();
    }

    private final void resizeStorage(int newCapacity) {
        long[] jArr = this.metadata;
        long[] jArr2 = this.elements;
        int i = this._capacity;
        initializeStorage(newCapacity);
        long[] jArr3 = this.metadata;
        long[] jArr4 = this.elements;
        int i2 = this._capacity;
        for (int i3 = 0; i3 < i; i3++) {
            if (((jArr[i3 >> 3] >> ((i3 & 7) << 3)) & 255) < 128) {
                long j = jArr2[i3];
                int iHashCode = Long.hashCode(j) * (-862048943);
                int i4 = iHashCode ^ (iHashCode << 16);
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i4 >>> 7);
                long j2 = i4 & 127;
                int i5 = iFindFirstAvailableSlot >> 3;
                int i6 = (iFindFirstAvailableSlot & 7) << 3;
                long j3 = (jArr3[i5] & (~(255 << i6))) | (j2 << i6);
                jArr3[i5] = j3;
                jArr3[(((iFindFirstAvailableSlot - 7) & i2) + (i2 & 7)) >> 3] = j3;
                jArr4[iFindFirstAvailableSlot] = j;
            }
        }
    }

    private final int findAbsoluteInsertIndex(long element) {
        int iHashCode = Long.hashCode(element) * (-862048943);
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i >>> 7;
        int i3 = i & 127;
        int i4 = this._capacity;
        int i5 = i2 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = i3;
            int i9 = i6;
            long j3 = j ^ (j2 * 72340172838076673L);
            for (long j4 = (~j3) & (j3 - 72340172838076673L) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j4) >> 3) + i5) & i4;
                if (this.elements[iNumberOfTrailingZeros] == element) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i2);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i2);
                }
                this._size++;
                int i10 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i11 = iFindFirstAvailableSlot >> 3;
                long j5 = jArr2[i11];
                int i12 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i10 - (((j5 >> i12) & 255) == 128 ? 1 : 0);
                int i13 = this._capacity;
                long j6 = ((~(255 << i12)) & j5) | (j2 << i12);
                jArr2[i11] = j6;
                jArr2[(((iFindFirstAvailableSlot - 7) & i13) + (i13 & 7)) >> 3] = j6;
                return iFindFirstAvailableSlot;
            }
            i6 = i9 + 8;
            i5 = (i5 + i6) & i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0066, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean remove(long r18) {
        /*
            r17 = this;
            r0 = r17
            int r1 = java.lang.Long.hashCode(r18)
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0._capacity
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
            r5 = r4
        L16:
            long[] r6 = r0.metadata
            int r7 = r1 >> 3
            r8 = r1 & 7
            int r8 = r8 << 3
            r9 = r6[r7]
            long r9 = r9 >>> r8
            r11 = 1
            int r7 = r7 + r11
            r12 = r6[r7]
            int r6 = 64 - r8
            long r6 = r12 << r6
            long r12 = (long) r8
            long r12 = -r12
            r8 = 63
            long r12 = r12 >> r8
            long r6 = r6 & r12
            long r6 = r6 | r9
            long r8 = (long) r2
            r12 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r8 = r8 * r12
            long r8 = r8 ^ r6
            long r12 = r8 - r12
            long r8 = ~r8
            long r8 = r8 & r12
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r12
        L42:
            r14 = 0
            int r10 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r10 == 0) goto L5f
            int r10 = java.lang.Long.numberOfTrailingZeros(r8)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            long[] r14 = r0.elements
            r15 = r14[r10]
            int r14 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r14 != 0) goto L59
            goto L69
        L59:
            r14 = 1
            long r14 = r8 - r14
            long r8 = r8 & r14
            goto L42
        L5f:
            long r8 = ~r6
            r10 = 6
            long r8 = r8 << r10
            long r6 = r6 & r8
            long r6 = r6 & r12
            int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r6 == 0) goto L72
            r10 = -1
        L69:
            if (r10 < 0) goto L6c
            r4 = r11
        L6c:
            if (r4 == 0) goto L71
            r0.removeElementAt(r10)
        L71:
            return r4
        L72:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableLongSet.remove(long):boolean");
    }
}
