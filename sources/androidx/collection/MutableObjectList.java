package androidx.collection;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObjectList.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/collection/MutableObjectList;", "E", "Landroidx/collection/ObjectList;", "", "initialCapacity", "<init>", "(I)V", "element", "", "add", "(Ljava/lang/Object;)Z", "", "clear", "()V", "capacity", "ensureCapacity", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableObjectList<E> extends ObjectList<E> {
    public MutableObjectList() {
        this(0, 1, null);
    }

    public /* synthetic */ MutableObjectList(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public MutableObjectList(int i) {
        super(i, null);
    }

    public final boolean add(E element) {
        ensureCapacity(this._size + 1);
        Object[] objArr = this.content;
        int i = this._size;
        objArr[i] = element;
        this._size = i + 1;
        return true;
    }

    public final void clear() {
        ArraysKt.fill(this.content, (Object) null, 0, this._size);
        this._size = 0;
    }

    public final void ensureCapacity(int capacity) {
        Object[] objArr = this.content;
        if (objArr.length < capacity) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, Math.max(capacity, (objArr.length * 3) / 2));
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.content = objArrCopyOf;
        }
    }
}
