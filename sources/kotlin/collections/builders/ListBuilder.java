package kotlin.collections.builders;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;

/* compiled from: ListBuilder.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\"\b\u0000\u0018\u0000 g*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0002ghBO\b\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\b\u0011\u0010\u0012B\t\b\u0016¢\u0006\u0004\b\u0011\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0015J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\nH\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u001f\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b#\u0010\"J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0096\u0002¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0004\b(\u0010)J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'2\u0006\u0010\u001b\u001a\u00020\nH\u0016¢\u0006\u0004\b(\u0010*J\u0017\u0010+\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b+\u0010,J\u001f\u0010+\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b+\u0010.J\u001d\u00101\u001a\u00020\r2\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0016¢\u0006\u0004\b1\u00102J%\u00101\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\n2\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0016¢\u0006\u0004\b1\u00103J\u000f\u00104\u001a\u00020-H\u0016¢\u0006\u0004\b4\u0010\u0013J\u0017\u00105\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\nH\u0016¢\u0006\u0004\b5\u0010\u001dJ\u0017\u00106\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b6\u0010,J\u001d\u00107\u001a\u00020\r2\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0016¢\u0006\u0004\b7\u00102J\u001d\u00108\u001a\u00020\r2\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0016¢\u0006\u0004\b8\u00102J%\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nH\u0016¢\u0006\u0004\b;\u0010<J)\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0001\u0010=2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00010\bH\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010A0\bH\u0016¢\u0006\u0004\b?\u0010BJ\u001a\u0010D\u001a\u00020\r2\b\u0010C\u001a\u0004\u0018\u00010AH\u0096\u0002¢\u0006\u0004\bD\u0010,J\u000f\u0010E\u001a\u00020\nH\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010H\u001a\u00020GH\u0016¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020-H\u0002¢\u0006\u0004\bJ\u0010\u0013J\u000f\u0010K\u001a\u00020-H\u0002¢\u0006\u0004\bK\u0010\u0013J\u000f\u0010L\u001a\u00020-H\u0002¢\u0006\u0004\bL\u0010\u0013J\u0017\u0010N\u001a\u00020-2\u0006\u0010M\u001a\u00020\nH\u0002¢\u0006\u0004\bN\u0010\u0015J\u0017\u0010P\u001a\u00020-2\u0006\u0010O\u001a\u00020\nH\u0002¢\u0006\u0004\bP\u0010\u0015J\u001b\u0010Q\u001a\u00020\r2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002¢\u0006\u0004\bQ\u0010RJ\u001f\u0010T\u001a\u00020-2\u0006\u0010S\u001a\u00020\n2\u0006\u0010M\u001a\u00020\nH\u0002¢\u0006\u0004\bT\u0010UJ\u001f\u0010V\u001a\u00020-2\u0006\u0010S\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0004\bV\u0010.J-\u0010W\u001a\u00020-2\u0006\u0010S\u001a\u00020\n2\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/2\u0006\u0010M\u001a\u00020\nH\u0002¢\u0006\u0004\bW\u0010XJ\u0017\u0010Y\u001a\u00028\u00002\u0006\u0010S\u001a\u00020\nH\u0002¢\u0006\u0004\bY\u0010\u001dJ\u001f\u0010\\\u001a\u00020-2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\nH\u0002¢\u0006\u0004\b\\\u0010UJ5\u0010^\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/2\u0006\u0010]\u001a\u00020\rH\u0002¢\u0006\u0004\b^\u0010_R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010`R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010aR\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010aR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010bR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010cR\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010cR\u0014\u0010e\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010FR\u0014\u0010f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bf\u0010\u001a¨\u0006i"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "array", "", "offset", "length", "", "isReadOnly", "backing", "root", "<init>", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "()V", "initialCapacity", "(I)V", "", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Ljava/util/List;", "isEmpty", "()Z", "index", "get", "(I)Ljava/lang/Object;", "element", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "()Ljava/util/Iterator;", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "add", "(Ljava/lang/Object;)Z", "", "(ILjava/lang/Object;)V", "", "elements", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "clear", "removeAt", "remove", "removeAll", "retainAll", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "T", "destination", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "other", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "registerModification", "checkForComodification", "checkIsMutable", "n", "ensureExtraCapacity", "minCapacity", "ensureCapacityInternal", "contentEquals", "(Ljava/util/List;)Z", "i", "insertAtInternal", "(II)V", "addAtInternal", "addAllInternal", "(ILjava/util/Collection;I)V", "removeAtInternal", "rangeOffset", "rangeLength", "removeRangeInternal", "retain", "retainOrRemoveAllInternal", "(IILjava/util/Collection;Z)I", "[Ljava/lang/Object;", "I", "Z", "Lkotlin/collections/builders/ListBuilder;", "getSize", "size", "isEffectivelyReadOnly", "Companion", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
    private static final Companion Companion = new Companion(null);
    private static final ListBuilder Empty;
    private E[] array;
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;
    private final ListBuilder<E> root;

    /* compiled from: ListBuilder.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Companion;", "", "()V", "Empty", "Lkotlin/collections/builders/ListBuilder;", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private ListBuilder(E[] eArr, int i, int i2, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i;
        this.length = i2;
        this.isReadOnly = z;
        this.backing = listBuilder;
        this.root = listBuilder2;
        if (listBuilder != null) {
            ((AbstractList) this).modCount = ((AbstractList) listBuilder).modCount;
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.isReadOnly = true;
        Empty = listBuilder;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i) {
        this(ListBuilderKt.arrayOfUninitializedElements(i), 0, 0, false, null, null);
    }

    public final List<E> build() {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        checkIsMutable();
        this.isReadOnly = true;
        return this.length > 0 ? this : Empty;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        checkForComodification();
        return this.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        checkForComodification();
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        checkForComodification();
        kotlin.collections.AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
        return this.array[this.offset + index];
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
        E[] eArr = this.array;
        int i = this.offset;
        E e = eArr[i + index];
        eArr[i + index] = element;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        checkForComodification();
        for (int i = 0; i < this.length; i++) {
            if (Intrinsics.areEqual(this.array[this.offset + i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        checkForComodification();
        for (int i = this.length - 1; i >= 0; i--) {
            if (Intrinsics.areEqual(this.array[this.offset + i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int index) {
        checkForComodification();
        kotlin.collections.AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
        return new Itr(this, index);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        checkIsMutable();
        checkForComodification();
        addAtInternal(this.offset + this.length, element);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
        addAtInternal(this.offset + index, element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        checkForComodification();
        int size = elements.size();
        addAllInternal(this.offset + this.length, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
        int size = elements.size();
        addAllInternal(this.offset + index, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        checkForComodification();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int index) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
        return removeAtInternal(this.offset + index);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        checkIsMutable();
        checkForComodification();
        int iIndexOf = indexOf(element);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        checkForComodification();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, false) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        checkIsMutable();
        checkForComodification();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int fromIndex, int toIndex) {
        kotlin.collections.AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.length);
        E[] eArr = this.array;
        int i = this.offset + fromIndex;
        int i2 = toIndex - fromIndex;
        boolean z = this.isReadOnly;
        ListBuilder<E> listBuilder = this.root;
        return new ListBuilder(eArr, i, i2, z, this, listBuilder == null ? this : listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        checkForComodification();
        int length = destination.length;
        int i = this.length;
        if (length < i) {
            E[] eArr = this.array;
            int i2 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i2, i + i2, destination.getClass());
            Intrinsics.checkNotNullExpressionValue(tArr, "copyOfRange(...)");
            return tArr;
        }
        E[] eArr2 = this.array;
        int i3 = this.offset;
        ArraysKt.copyInto(eArr2, destination, 0, i3, i + i3);
        return (T[]) CollectionsKt.terminateCollectionToArray(this.length, destination);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        checkForComodification();
        E[] eArr = this.array;
        int i = this.offset;
        return ArraysKt.copyOfRange(eArr, i, this.length + i);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object other) {
        checkForComodification();
        return other == this || ((other instanceof List) && contentEquals((List) other));
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        checkForComodification();
        return ListBuilderKt.subarrayContentHashCode(this.array, this.offset, this.length);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        checkForComodification();
        return ListBuilderKt.subarrayContentToString(this.array, this.offset, this.length, this);
    }

    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    private final void checkForComodification() {
        ListBuilder<E> listBuilder = this.root;
        if (listBuilder != null && ((AbstractList) listBuilder).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    private final void checkIsMutable() {
        if (isEffectivelyReadOnly()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean isEffectivelyReadOnly() {
        ListBuilder<E> listBuilder;
        return this.isReadOnly || ((listBuilder = this.root) != null && listBuilder.isReadOnly);
    }

    private final void ensureExtraCapacity(int n) {
        ensureCapacityInternal(this.length + n);
    }

    private final void ensureCapacityInternal(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.array;
        if (minCapacity > eArr.length) {
            this.array = (E[]) ListBuilderKt.copyOfUninitializedElements(this.array, kotlin.collections.AbstractList.INSTANCE.newCapacity$kotlin_stdlib(eArr.length, minCapacity));
        }
    }

    private final boolean contentEquals(List<?> other) {
        return ListBuilderKt.subarrayContentEquals(this.array, this.offset, this.length, other);
    }

    private final void insertAtInternal(int i, int n) {
        ensureExtraCapacity(n);
        E[] eArr = this.array;
        ArraysKt.copyInto(eArr, eArr, i + n, i, this.offset + this.length);
        this.length += n;
    }

    private final void addAtInternal(int i, E element) {
        registerModification();
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAtInternal(i, element);
            this.array = this.backing.array;
            this.length++;
        } else {
            insertAtInternal(i, 1);
            this.array[i] = element;
        }
    }

    private final void addAllInternal(int i, Collection<? extends E> elements, int n) {
        registerModification();
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i, elements, n);
            this.array = this.backing.array;
            this.length += n;
        } else {
            insertAtInternal(i, n);
            Iterator<? extends E> it = elements.iterator();
            for (int i2 = 0; i2 < n; i2++) {
                this.array[i + i2] = it.next();
            }
        }
    }

    private final E removeAtInternal(int i) {
        registerModification();
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(i);
        }
        E[] eArr = this.array;
        E e = eArr[i];
        ArraysKt.copyInto(eArr, eArr, i, i + 1, this.offset + this.length);
        ListBuilderKt.resetAt(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e;
    }

    private final void removeRangeInternal(int rangeOffset, int rangeLength) {
        if (rangeLength > 0) {
            registerModification();
        }
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(rangeOffset, rangeLength);
        } else {
            E[] eArr = this.array;
            ArraysKt.copyInto(eArr, eArr, rangeOffset, rangeOffset + rangeLength, this.length);
            E[] eArr2 = this.array;
            int i = this.length;
            ListBuilderKt.resetRange(eArr2, i - rangeLength, i);
        }
        this.length -= rangeLength;
    }

    private final int retainOrRemoveAllInternal(int rangeOffset, int rangeLength, Collection<? extends E> elements, boolean retain) {
        int iRetainOrRemoveAllInternal;
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            iRetainOrRemoveAllInternal = listBuilder.retainOrRemoveAllInternal(rangeOffset, rangeLength, elements, retain);
        } else {
            int i = 0;
            int i2 = 0;
            while (i < rangeLength) {
                int i3 = rangeOffset + i;
                if (elements.contains(this.array[i3]) == retain) {
                    E[] eArr = this.array;
                    i++;
                    eArr[i2 + rangeOffset] = eArr[i3];
                    i2++;
                } else {
                    i++;
                }
            }
            int i4 = rangeLength - i2;
            E[] eArr2 = this.array;
            ArraysKt.copyInto(eArr2, eArr2, rangeOffset + i2, rangeLength + rangeOffset, this.length);
            E[] eArr3 = this.array;
            int i5 = this.length;
            ListBuilderKt.resetRange(eArr3, i5 - i4, i5);
            iRetainOrRemoveAllInternal = i4;
        }
        if (iRetainOrRemoveAllInternal > 0) {
            registerModification();
        }
        this.length -= iRetainOrRemoveAllInternal;
        return iRetainOrRemoveAllInternal;
    }

    /* compiled from: ListBuilder.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0002J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\r\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0015\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "(Lkotlin/collections/builders/ListBuilder;I)V", "expectedModCount", "lastIndex", "add", "", "element", "(Ljava/lang/Object;)V", "checkForComodification", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Itr<E> implements ListIterator<E>, KMappedMarker {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final ListBuilder<E> list;

        public Itr(ListBuilder<E> list, int i) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.index = i;
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) list).modCount;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < ((ListBuilder) this.list).length;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkForComodification();
            int i = this.index;
            if (i <= 0) {
                throw new NoSuchElementException();
            }
            int i2 = i - 1;
            this.index = i2;
            this.lastIndex = i2;
            return (E) ((ListBuilder) this.list).array[((ListBuilder) this.list).offset + this.lastIndex];
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkForComodification();
            if (this.index >= ((ListBuilder) this.list).length) {
                throw new NoSuchElementException();
            }
            int i = this.index;
            this.index = i + 1;
            this.lastIndex = i;
            return (E) ((ListBuilder) this.list).array[((ListBuilder) this.list).offset + this.lastIndex];
        }

        @Override // java.util.ListIterator
        public void set(E element) {
            checkForComodification();
            int i = this.lastIndex;
            if (i == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
            this.list.set(i, element);
        }

        @Override // java.util.ListIterator
        public void add(E element) {
            checkForComodification();
            ListBuilder<E> listBuilder = this.list;
            int i = this.index;
            this.index = i + 1;
            listBuilder.add(i, element);
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) this.list).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkForComodification();
            int i = this.lastIndex;
            if (i == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }
            this.list.remove(i);
            this.index = this.lastIndex;
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) this.list).modCount;
        }

        private final void checkForComodification() {
            if (((AbstractList) this.list).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
