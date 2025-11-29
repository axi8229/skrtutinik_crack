package kotlinx.coroutines.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* compiled from: ThreadSafeHeap.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0082\u0010¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0082\u0010¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00028\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u001b\u0010\u0015J\u0017\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\bH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u001f\u0010 R \u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010'\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b8F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\fR\u0011\u0010(\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000b\u0010+\u001a\u00020*8\u0002X\u0082\u0004¨\u0006,"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", "", "i", "", "siftUpFrom", "(I)V", "siftDownFrom", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "j", "swap", "(II)V", "peek", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "node", "", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "firstImpl", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", AppMeasurementSdk.ConditionalUserProperty.VALUE, "getSize", "()I", "setSize", "size", "isEmpty", "()Z", "Lkotlinx/atomicfu/AtomicInt;", "_size", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private static final AtomicIntegerFieldUpdater _size$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size");
    private volatile int _size;
    private T[] a;

    public final T peek() {
        T t;
        synchronized (this) {
            t = (T) firstImpl();
        }
        return t;
    }

    public final boolean remove(T node) {
        boolean z;
        synchronized (this) {
            if (node.getHeap() == null) {
                z = false;
            } else {
                removeAtImpl(node.getIndex());
                z = true;
            }
        }
        return z;
    }

    public final T removeFirstOrNull() {
        T t;
        synchronized (this) {
            t = getSize() > 0 ? (T) removeAtImpl(0) : null;
        }
        return t;
    }

    public final int getSize() {
        return _size$FU.get(this);
    }

    private final void setSize(int i) {
        _size$FU.set(this, i);
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final T firstImpl() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T removeAtImpl(int r6) {
        /*
            r5 = this;
            T extends kotlinx.coroutines.internal.ThreadSafeHeapNode & java.lang.Comparable<? super T>[] r0 = r5.a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r1 = r5.getSize()
            r2 = -1
            int r1 = r1 + r2
            r5.setSize(r1)
            int r1 = r5.getSize()
            if (r6 >= r1) goto L3d
            int r1 = r5.getSize()
            r5.swap(r6, r1)
            int r1 = r6 + (-1)
            int r1 = r1 / 2
            if (r6 <= 0) goto L3a
            r3 = r0[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r0[r1]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L3a
            r5.swap(r6, r1)
            r5.siftUpFrom(r1)
            goto L3d
        L3a:
            r5.siftDownFrom(r6)
        L3d:
            int r6 = r5.getSize()
            r6 = r0[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r1 = 0
            r6.setHeap(r1)
            r6.setIndex(r2)
            int r2 = r5.getSize()
            r0[r2] = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ThreadSafeHeap.removeAtImpl(int):kotlinx.coroutines.internal.ThreadSafeHeapNode");
    }

    public final void addImpl(T node) {
        node.setHeap(this);
        ThreadSafeHeapNode[] threadSafeHeapNodeArrRealloc = realloc();
        int size = getSize();
        setSize(size + 1);
        threadSafeHeapNodeArrRealloc[size] = node;
        node.setIndex(size);
        siftUpFrom(size);
    }

    private final void siftUpFrom(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            Intrinsics.checkNotNull(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            Intrinsics.checkNotNull(t);
            T t2 = tArr[i];
            Intrinsics.checkNotNull(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            swap(i, i2);
            i = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void siftDownFrom(int r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.getSize()
            if (r1 < r2) goto Lb
            return
        Lb:
            T extends kotlinx.coroutines.internal.ThreadSafeHeapNode & java.lang.Comparable<? super T>[] r2 = r5.a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r0 = r0 + 2
            int r3 = r5.getSize()
            if (r0 >= r3) goto L2b
            r3 = r2[r0]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L2b
            goto L2c
        L2b:
            r0 = r1
        L2c:
            r1 = r2[r6]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L3f
            return
        L3f:
            r5.swap(r6, r0)
            r6 = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ThreadSafeHeap.siftDownFrom(int):void");
    }

    private final T[] realloc() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeapNode[4];
            this.a = tArr2;
            return tArr2;
        }
        if (getSize() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, getSize() * 2);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((ThreadSafeHeapNode[]) objArrCopyOf);
        this.a = tArr3;
        return tArr3;
    }

    private final void swap(int i, int j) {
        T[] tArr = this.a;
        Intrinsics.checkNotNull(tArr);
        T t = tArr[j];
        Intrinsics.checkNotNull(t);
        T t2 = tArr[i];
        Intrinsics.checkNotNull(t2);
        tArr[i] = t;
        tArr[j] = t2;
        t.setIndex(i);
        t2.setIndex(j);
    }
}
