package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObjectLongMap.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00112\u0006\u0010\b\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u00020\u001b8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u0012\u0004\b\u001e\u0010\u0004R$\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001f8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b \u0010!\u0012\u0004\b\"\u0010\u0004R\u001c\u0010#\u001a\u00020\u001b8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b#\u0010\u001d\u0012\u0004\b$\u0010\u0004R\u001c\u0010%\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b%\u0010&\u0012\u0004\b'\u0010\u0004R\u001c\u0010(\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b(\u0010&\u0012\u0004\b)\u0010\u0004R\u0011\u0010+\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b*\u0010\u0013R\u0011\u0010-\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b,\u0010\u0013\u0082\u0001\u0001.¨\u0006/"}, d2 = {"Landroidx/collection/ObjectLongMap;", "K", "", "<init>", "()V", "", "isEmpty", "()Z", "key", "", "get", "(Ljava/lang/Object;)J", "defaultValue", "getOrDefault", "(Ljava/lang/Object;J)J", "contains", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "other", "equals", "", "toString", "()Ljava/lang/String;", "findKeyIndex", "(Ljava/lang/Object;)I", "", "metadata", "[J", "getMetadata$annotations", "", "keys", "[Ljava/lang/Object;", "getKeys$annotations", "values", "getValues$annotations", "_capacity", "I", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "getCapacity", "capacity", "getSize", "size", "Landroidx/collection/MutableObjectLongMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ObjectLongMap<K> {
    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public long[] values;

    public /* synthetic */ ObjectLongMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ObjectLongMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = LongSetKt.getEmptyLongArray();
    }

    /* renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final long get(K key) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex < 0) {
            throw new NoSuchElementException("There is no key " + key + " in the map");
        }
        return this.values[iFindKeyIndex];
    }

    public final long getOrDefault(K key, long defaultValue) {
        int iFindKeyIndex = findKeyIndex(key);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : defaultValue;
    }

    public int hashCode() {
        Object[] objArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        int i = 0;
        if (length >= 0) {
            int i2 = 0;
            int iHashCode = 0;
            while (true) {
                long j = jArr2[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            Object obj = objArr[i5];
                            iHashCode += (obj != null ? obj.hashCode() : 0) ^ Long.hashCode(jArr[i5]);
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        return iHashCode;
                    }
                }
                if (i2 == length) {
                    i = iHashCode;
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    public final boolean contains(K key) {
        return findKeyIndex(key) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 1
            if (r1 != r0) goto L8
            return r2
        L8:
            boolean r3 = r1 instanceof androidx.collection.ObjectLongMap
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            androidx.collection.ObjectLongMap r1 = (androidx.collection.ObjectLongMap) r1
            int r3 = r1.get_size()
            int r5 = r18.get_size()
            if (r3 == r5) goto L1b
            return r4
        L1b:
            java.lang.Object[] r3 = r0.keys
            long[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L67
            r8 = r4
        L27:
            r9 = r6[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L62
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r4
        L41:
            if (r13 >= r11) goto L60
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.32E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L5c
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r3[r14]
            r16 = r5[r14]
            long r14 = r1.get(r15)
            int r14 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r14 == 0) goto L5c
            return r4
        L5c:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L41
        L60:
            if (r11 != r12) goto L67
        L62:
            if (r8 == r7) goto L67
            int r8 = r8 + 1
            goto L27
        L67:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectLongMap.equals(java.lang.Object):boolean");
    }

    public String toString() {
        int i;
        int i2;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Object[] objArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                long j = jArr2[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((255 & j) < 128) {
                            int i7 = (i3 << 3) + i6;
                            Object obj = objArr[i7];
                            i2 = i3;
                            long j2 = jArr[i7];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
                            sb.append(j2);
                            i4++;
                            if (i4 < this._size) {
                                sb.append(',');
                                sb.append(' ');
                            }
                        } else {
                            i2 = i3;
                        }
                        j >>= 8;
                        i6++;
                        i3 = i2;
                    }
                    int i8 = i3;
                    if (i5 != 8) {
                        break;
                    }
                    i = i8;
                } else {
                    i = i3;
                }
                if (i == length) {
                    break;
                }
                i3 = i + 1;
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "s.append('}').toString()");
        return string;
    }

    public final int findKeyIndex(K key) {
        int i = 0;
        int iHashCode = (key != null ? key.hashCode() : 0) * (-862048943);
        int i2 = iHashCode ^ (iHashCode << 16);
        int i3 = i2 & 127;
        int i4 = this._capacity;
        int i5 = i2 >>> 7;
        while (true) {
            int i6 = i5 & i4;
            long[] jArr = this.metadata;
            int i7 = i6 >> 3;
            int i8 = (i6 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (i3 * 72340172838076673L) ^ j;
            for (long j3 = (~j2) & (j2 - 72340172838076673L) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i6) & i4;
                if (Intrinsics.areEqual(this.keys[iNumberOfTrailingZeros], key)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i += 8;
            i5 = i6 + i;
        }
    }
}
