package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SparseArrayCompat.jvm.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001a\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J!\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u000bJ\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\rH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b#\u0010\u0013J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00168\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0,8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u0014\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0014\u00100R\u0011\u0010\u0017\u001a\u00020\u00168G¢\u0006\u0006\u001a\u0004\b1\u0010\u0018¨\u00062"}, d2 = {"Landroidx/collection/SparseArrayCompat;", "E", "", "", "initialCapacity", "<init>", "(I)V", "clone", "()Landroidx/collection/SparseArrayCompat;", "key", "get", "(I)Ljava/lang/Object;", "index", "", "removeAt", AppMeasurementSdk.ConditionalUserProperty.VALUE, "replace", "(ILjava/lang/Object;)Ljava/lang/Object;", "put", "(ILjava/lang/Object;)V", "size", "()I", "", "isEmpty", "()Z", "keyAt", "(I)I", "valueAt", "indexOfKey", "indexOfValue", "(Ljava/lang/Object;)I", "containsKey", "(I)Z", "clear", "()V", "append", "", "toString", "()Ljava/lang/String;", "garbage", "Z", "", "keys", "[I", "", "", "values", "[Ljava/lang/Object;", "I", "getIsEmpty", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ int[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public SparseArrayCompat() {
        this(0, 1, null);
    }

    public SparseArrayCompat(int i) {
        if (i == 0) {
            this.keys = ContainerHelpersKt.EMPTY_INTS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i);
            this.keys = new int[iIdealIntArraySize];
            this.values = new Object[iIdealIntArraySize];
        }
    }

    public /* synthetic */ SparseArrayCompat(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10 : i);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SparseArrayCompat<E> m84clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) objClone;
        sparseArrayCompat.keys = (int[]) this.keys.clone();
        sparseArrayCompat.values = (Object[]) this.values.clone();
        return sparseArrayCompat;
    }

    public E get(int key) {
        return (E) SparseArrayCompatKt.commonGet(this, key);
    }

    public final boolean getIsEmpty() {
        return isEmpty();
    }

    public void removeAt(int index) {
        if (this.values[index] != SparseArrayCompatKt.DELETED) {
            this.values[index] = SparseArrayCompatKt.DELETED;
            this.garbage = true;
        }
    }

    public E replace(int key, E value) {
        int iIndexOfKey = indexOfKey(key);
        if (iIndexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.values;
        E e = (E) objArr[iIndexOfKey];
        objArr[iIndexOfKey] = value;
        return e;
    }

    public void put(int key, E value) {
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, key);
        if (iBinarySearch >= 0) {
            this.values[iBinarySearch] = value;
            return;
        }
        int i = ~iBinarySearch;
        if (i < this.size && this.values[i] == SparseArrayCompatKt.DELETED) {
            this.keys[i] = key;
            this.values[i] = value;
            return;
        }
        if (this.garbage && this.size >= this.keys.length) {
            SparseArrayCompatKt.gc(this);
            i = ~ContainerHelpersKt.binarySearch(this.keys, this.size, key);
        }
        int i2 = this.size;
        if (i2 >= this.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i2 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.keys, iIdealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.keys = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.values = objArrCopyOf;
        }
        int i3 = this.size;
        if (i3 - i != 0) {
            int[] iArr = this.keys;
            int i4 = i + 1;
            ArraysKt.copyInto(iArr, iArr, i4, i, i3);
            Object[] objArr = this.values;
            ArraysKt.copyInto(objArr, objArr, i4, i, this.size);
        }
        this.keys[i] = key;
        this.values[i] = value;
        this.size++;
    }

    public int size() {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int keyAt(int index) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.keys[index];
    }

    public E valueAt(int index) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return (E) this.values[index];
    }

    public int indexOfKey(int key) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, key);
    }

    public int indexOfValue(E value) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.values[i2] == value) {
                return i2;
            }
        }
        return -1;
    }

    public boolean containsKey(int key) {
        return indexOfKey(key) >= 0;
    }

    public void clear() {
        int i = this.size;
        Object[] objArr = this.values;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.size = 0;
        this.garbage = false;
    }

    public void append(int key, E value) {
        int i = this.size;
        if (i != 0 && key <= this.keys[i - 1]) {
            put(key, value);
            return;
        }
        if (this.garbage && i >= this.keys.length) {
            SparseArrayCompatKt.gc(this);
        }
        int i2 = this.size;
        if (i2 >= this.keys.length) {
            int iIdealIntArraySize = ContainerHelpersKt.idealIntArraySize(i2 + 1);
            int[] iArrCopyOf = Arrays.copyOf(this.keys, iIdealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.keys = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.values, iIdealIntArraySize);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.values = objArrCopyOf;
        }
        this.keys[i2] = key;
        this.values[i2] = value;
        this.size = i2 + 1;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i2));
            sb.append('=');
            E eValueAt = valueAt(i2);
            if (eValueAt != this) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "buffer.toString()");
        return string;
    }
}
