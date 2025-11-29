package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SparseArray.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"T", "Landroidx/collection/SparseArrayCompat;", "Lkotlin/collections/IntIterator;", "keyIterator", "(Landroidx/collection/SparseArrayCompat;)Lkotlin/collections/IntIterator;", "", "valueIterator", "(Landroidx/collection/SparseArrayCompat;)Ljava/util/Iterator;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SparseArrayKt {
    public static final <T> IntIterator keyIterator(final SparseArrayCompat<T> sparseArrayCompat) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        return new IntIterator() { // from class: androidx.collection.SparseArrayKt.keyIterator.1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArrayCompat.size();
            }

            @Override // kotlin.collections.IntIterator
            public int nextInt() {
                SparseArrayCompat<T> sparseArrayCompat2 = sparseArrayCompat;
                int i = this.index;
                this.index = i + 1;
                return sparseArrayCompat2.keyAt(i);
            }
        };
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SparseArray.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"androidx/collection/SparseArrayKt$valueIterator$1", "", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.collection.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03741<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ SparseArrayCompat<T> $this_valueIterator;
        private int index;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        C03741(SparseArrayCompat<T> sparseArrayCompat) {
            this.$this_valueIterator = sparseArrayCompat;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArrayCompat<T> sparseArrayCompat = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return sparseArrayCompat.valueAt(i);
        }
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> sparseArrayCompat) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        return new C03741(sparseArrayCompat);
    }
}
