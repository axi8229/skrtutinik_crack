package androidx.compose.runtime.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;

/* compiled from: MutableVector.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u0003JKLB!\b\u0001\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\f\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\u0010J#\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u0013\u0010\u0015J#\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b\u0013\u0010\u0017J\u001b\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b\u0013\u0010\u0018J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u001e\u0010\rJ\u001b\u0010\u001f\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b\u001f\u0010\u0018J\u0015\u0010!\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00028\u0000¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u000b¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u000b¢\u0006\u0004\b)\u0010(J\r\u0010*\u001a\u00028\u0000¢\u0006\u0004\b*\u0010$J\u0015\u0010+\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b+\u0010&J\u0015\u0010,\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b,\u0010\rJ\u001b\u0010-\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b-\u0010\u0018J\u0015\u0010.\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b.\u0010/J\u001d\u00102\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u0006H\u0001¢\u0006\u0004\b5\u0010\"J\u001b\u00106\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b6\u0010\u0018J \u00107\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b7\u00108J%\u0010<\u001a\u00020\u000f2\u0016\u0010;\u001a\u0012\u0012\u0004\u0012\u00028\u000009j\b\u0012\u0004\u0012\u00028\u0000`:¢\u0006\u0004\b<\u0010=R0\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b\u0005\u0010>\u0012\u0004\bC\u0010\u001d\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001e\u0010D\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER$\u0010\u0007\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0007\u0010G\u001a\u0004\bH\u0010I¨\u0006M"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector;", "T", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "content", "", "size", "<init>", "([Ljava/lang/Object;I)V", "element", "", "add", "(Ljava/lang/Object;)Z", "index", "", "(ILjava/lang/Object;)V", "", "elements", "addAll", "(ILjava/util/List;)Z", "(ILandroidx/compose/runtime/collection/MutableVector;)Z", "", "(ILjava/util/Collection;)Z", "(Ljava/util/Collection;)Z", "", "asMutableList", "()Ljava/util/List;", "clear", "()V", "contains", "containsAll", "capacity", "ensureCapacity", "(I)V", "first", "()Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "()Z", "isNotEmpty", "last", "lastIndexOf", "remove", "removeAll", "removeAt", "(I)Ljava/lang/Object;", "start", "end", "removeRange", "(II)V", "newSize", "setSize", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "sortWith", "(Ljava/util/Comparator;)V", "[Ljava/lang/Object;", "getContent", "()[Ljava/lang/Object;", "setContent", "([Ljava/lang/Object;)V", "getContent$annotations", "list", "Ljava/util/List;", "<set-?>", "I", "getSize", "()I", "MutableVectorList", "SubList", "VectorListIterator", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableVector<T> implements RandomAccess {
    public static final int $stable = 8;
    private T[] content;
    private List<T> list;
    private int size;

    public MutableVector(T[] tArr, int i) {
        this.content = tArr;
        this.size = i;
    }

    public final T[] getContent() {
        return this.content;
    }

    public final int getSize() {
        return this.size;
    }

    public final boolean contains(T element) {
        int size = getSize() - 1;
        if (size >= 0) {
            for (int i = 0; !Intrinsics.areEqual(getContent()[i], element); i++) {
                if (i != size) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean add(T element) {
        ensureCapacity(this.size + 1);
        T[] tArr = this.content;
        int i = this.size;
        tArr[i] = element;
        this.size = i + 1;
        return true;
    }

    public final void add(int index, T element) {
        ensureCapacity(this.size + 1);
        T[] tArr = this.content;
        int i = this.size;
        if (index != i) {
            ArraysKt.copyInto(tArr, tArr, index + 1, index, i);
        }
        tArr[index] = element;
        this.size++;
    }

    public final boolean addAll(int index, List<? extends T> elements) {
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + elements.size());
        T[] tArr = this.content;
        if (index != this.size) {
            ArraysKt.copyInto(tArr, tArr, elements.size() + index, index, this.size);
        }
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            tArr[index + i] = elements.get(i);
        }
        this.size += elements.size();
        return true;
    }

    public final boolean addAll(int index, MutableVector<T> elements) {
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + elements.size);
        T[] tArr = this.content;
        int i = this.size;
        if (index != i) {
            ArraysKt.copyInto(tArr, tArr, elements.size + index, index, i);
        }
        ArraysKt.copyInto(elements.content, tArr, index, 0, elements.size);
        this.size += elements.size;
        return true;
    }

    public final boolean addAll(int index, Collection<? extends T> elements) {
        int i = 0;
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + elements.size());
        T[] tArr = this.content;
        if (index != this.size) {
            ArraysKt.copyInto(tArr, tArr, elements.size() + index, index, this.size);
        }
        for (T t : elements) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            tArr[i + index] = t;
            i = i2;
        }
        this.size += elements.size();
        return true;
    }

    public final boolean addAll(Collection<? extends T> elements) {
        return addAll(this.size, elements);
    }

    public final List<T> asMutableList() {
        List<T> list = this.list;
        if (list != null) {
            return list;
        }
        MutableVectorList mutableVectorList = new MutableVectorList(this);
        this.list = mutableVectorList;
        return mutableVectorList;
    }

    public final void clear() {
        T[] tArr = this.content;
        int size = getSize();
        while (true) {
            size--;
            if (-1 < size) {
                tArr[size] = null;
            } else {
                this.size = 0;
                return;
            }
        }
    }

    public final boolean containsAll(Collection<? extends T> elements) {
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void ensureCapacity(int capacity) {
        T[] tArr = this.content;
        if (tArr.length < capacity) {
            T[] tArr2 = (T[]) Arrays.copyOf(tArr, Math.max(capacity, tArr.length * 2));
            Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(this, newSize)");
            this.content = tArr2;
        }
    }

    public final T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("MutableVector is empty.");
        }
        return getContent()[0];
    }

    public final int indexOf(T element) {
        int i = this.size;
        if (i <= 0) {
            return -1;
        }
        T[] tArr = this.content;
        int i2 = 0;
        while (!Intrinsics.areEqual(element, tArr[i2])) {
            i2++;
            if (i2 >= i) {
                return -1;
            }
        }
        return i2;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isNotEmpty() {
        return this.size != 0;
    }

    public final T last() {
        if (!isEmpty()) {
            return getContent()[getSize() - 1];
        }
        throw new NoSuchElementException("MutableVector is empty.");
    }

    public final int lastIndexOf(T element) {
        int i = this.size;
        if (i <= 0) {
            return -1;
        }
        int i2 = i - 1;
        T[] tArr = this.content;
        while (!Intrinsics.areEqual(element, tArr[i2])) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
        }
        return i2;
    }

    public final boolean remove(T element) {
        int iIndexOf = indexOf(element);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(Collection<? extends T> elements) {
        if (elements.isEmpty()) {
            return false;
        }
        int i = this.size;
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return i != this.size;
    }

    public final T removeAt(int index) {
        T[] tArr = this.content;
        T t = tArr[index];
        if (index != getSize() - 1) {
            ArraysKt.copyInto(tArr, tArr, index, index + 1, this.size);
        }
        int i = this.size - 1;
        this.size = i;
        tArr[i] = null;
        return t;
    }

    public final void removeRange(int start, int end) {
        if (end > start) {
            int i = this.size;
            if (end < i) {
                T[] tArr = this.content;
                ArraysKt.copyInto(tArr, tArr, start, end, i);
            }
            int i2 = this.size - (end - start);
            int size = getSize() - 1;
            if (i2 <= size) {
                int i3 = i2;
                while (true) {
                    this.content[i3] = null;
                    if (i3 == size) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            this.size = i2;
        }
    }

    public final void setSize(int newSize) {
        this.size = newSize;
    }

    public final boolean retainAll(Collection<? extends T> elements) {
        int i = this.size;
        for (int size = getSize() - 1; -1 < size; size--) {
            if (!elements.contains(getContent()[size])) {
                removeAt(size);
            }
        }
        return i != this.size;
    }

    public final T set(int index, T element) {
        T[] tArr = this.content;
        T t = tArr[index];
        tArr[index] = element;
        return t;
    }

    public final void sortWith(Comparator<T> comparator) {
        ArraysKt.sortWith(this.content, comparator, 0, this.size);
    }

    /* compiled from: MutableVector.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bJ\t\u0010\f\u001a\u00020\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u000f\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\r\u0010\u0012\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0015\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$VectorListIterator;", "T", "", "list", "", "index", "", "(Ljava/util/List;I)V", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class VectorListIterator<T> implements ListIterator<T>, KMappedMarker {
        private int index;
        private final List<T> list;

        public VectorListIterator(List<T> list, int i) {
            this.list = list;
            this.index = i;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < this.list.size();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> list = this.list;
            int i = this.index;
            this.index = i + 1;
            return list.get(i);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i = this.index - 1;
            this.index = i;
            this.list.remove(i);
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public T previous() {
            int i = this.index - 1;
            this.index = i;
            return this.list.get(i);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator
        public void add(T element) {
            this.list.add(this.index, element);
            this.index++;
        }

        @Override // java.util.ListIterator
        public void set(T element) {
            this.list.set(this.index, element);
        }
    }

    /* compiled from: MutableVector.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u001d\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\rJ\u0016\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dH\u0096\u0002J\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0015\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u0016\u0010\"\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0015\u0010#\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0018J\u0016\u0010$\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u001e\u0010%\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$MutableVectorList;", "T", "", "vector", "Landroidx/compose/runtime/collection/MutableVector;", "(Landroidx/compose/runtime/collection/MutableVector;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class MutableVectorList<T> implements List<T>, KMutableList {
        private final MutableVector<T> vector;

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) CollectionToArray.toArray(this, tArr);
        }

        public MutableVectorList(MutableVector<T> mutableVector) {
            this.vector = mutableVector;
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        public int getSize() {
            return this.vector.getSize();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object element) {
            return this.vector.contains(element);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> elements) {
            return this.vector.containsAll(elements);
        }

        @Override // java.util.List
        public T get(int index) {
            MutableVectorKt.checkIndex(this, index);
            return this.vector.getContent()[index];
        }

        @Override // java.util.List
        public int indexOf(Object element) {
            return this.vector.indexOf(element);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.vector.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object element) {
            return this.vector.lastIndexOf(element);
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T element) {
            return this.vector.add(element);
        }

        @Override // java.util.List
        public void add(int index, T element) {
            this.vector.add(index, element);
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends T> elements) {
            return this.vector.addAll(index, elements);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> elements) {
            return this.vector.addAll(elements);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.vector.clear();
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int index) {
            return new VectorListIterator(this, index);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object element) {
            return this.vector.remove(element);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> elements) {
            return this.vector.removeAll(elements);
        }

        public T removeAt(int index) {
            MutableVectorKt.checkIndex(this, index);
            return this.vector.removeAt(index);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> elements) {
            return this.vector.retainAll(elements);
        }

        @Override // java.util.List
        public T set(int index, T element) {
            MutableVectorKt.checkIndex(this, index);
            return this.vector.set(index, element);
        }

        @Override // java.util.List
        public List<T> subList(int fromIndex, int toIndex) {
            MutableVectorKt.checkSubIndex(this, fromIndex, toIndex);
            return new SubList(this, fromIndex, toIndex);
        }
    }

    /* compiled from: MutableVector.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0017\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\fH\u0016J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u001eH\u0096\u0002J\u0015\u0010\u001f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u0016\u0010#\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0015\u0010$\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010%\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u001e\u0010&\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$SubList;", "T", "", "list", "start", "", "end", "(Ljava/util/List;II)V", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SubList<T> implements List<T>, KMutableList {
        private int end;
        private final List<T> list;
        private final int start;

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) CollectionToArray.toArray(this, tArr);
        }

        public SubList(List<T> list, int i, int i2) {
            this.list = list;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object element) {
            int i = this.end;
            for (int i2 = this.start; i2 < i; i2++) {
                if (Intrinsics.areEqual(this.list.get(i2), element)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> elements) {
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public T get(int index) {
            MutableVectorKt.checkIndex(this, index);
            return this.list.get(index + this.start);
        }

        @Override // java.util.List
        public int indexOf(Object element) {
            int i = this.end;
            for (int i2 = this.start; i2 < i; i2++) {
                if (Intrinsics.areEqual(this.list.get(i2), element)) {
                    return i2 - this.start;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.end == this.start;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object element) {
            int i = this.end - 1;
            int i2 = this.start;
            if (i2 > i) {
                return -1;
            }
            while (!Intrinsics.areEqual(this.list.get(i), element)) {
                if (i == i2) {
                    return -1;
                }
                i--;
            }
            return i - this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T element) {
            List<T> list = this.list;
            int i = this.end;
            this.end = i + 1;
            list.add(i, element);
            return true;
        }

        @Override // java.util.List
        public void add(int index, T element) {
            this.list.add(index + this.start, element);
            this.end++;
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends T> elements) {
            this.list.addAll(index + this.start, elements);
            this.end += elements.size();
            return elements.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> elements) {
            this.list.addAll(this.end, elements);
            this.end += elements.size();
            return elements.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i = this.end - 1;
            int i2 = this.start;
            if (i2 <= i) {
                while (true) {
                    this.list.remove(i);
                    if (i == i2) {
                        break;
                    } else {
                        i--;
                    }
                }
            }
            this.end = this.start;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int index) {
            return new VectorListIterator(this, index);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object element) {
            int i = this.end;
            for (int i2 = this.start; i2 < i; i2++) {
                if (Intrinsics.areEqual(this.list.get(i2), element)) {
                    this.list.remove(i2);
                    this.end--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> elements) {
            int i = this.end;
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i != this.end;
        }

        public T removeAt(int index) {
            MutableVectorKt.checkIndex(this, index);
            this.end--;
            return this.list.remove(index + this.start);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> elements) {
            int i = this.end;
            int i2 = i - 1;
            int i3 = this.start;
            if (i3 <= i2) {
                while (true) {
                    if (!elements.contains(this.list.get(i2))) {
                        this.list.remove(i2);
                        this.end--;
                    }
                    if (i2 == i3) {
                        break;
                    }
                    i2--;
                }
            }
            return i != this.end;
        }

        @Override // java.util.List
        public T set(int index, T element) {
            MutableVectorKt.checkIndex(this, index);
            return this.list.set(index + this.start, element);
        }

        @Override // java.util.List
        public List<T> subList(int fromIndex, int toIndex) {
            MutableVectorKt.checkSubIndex(this, fromIndex, toIndex);
            return new SubList(this, fromIndex, toIndex);
        }
    }
}
