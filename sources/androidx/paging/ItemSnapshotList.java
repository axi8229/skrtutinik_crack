package androidx.paging;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ItemSnapshotList.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002B)\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0010\u0010\u000fR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u0016"}, d2 = {"Landroidx/paging/ItemSnapshotList;", "T", "Lkotlin/collections/AbstractList;", "", "placeholdersBefore", "placeholdersAfter", "", "items", "<init>", "(IILjava/util/List;)V", "index", "get", "(I)Ljava/lang/Object;", "I", "getPlaceholdersBefore", "()I", "getPlaceholdersAfter", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "getSize", "size", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ItemSnapshotList<T> extends AbstractList<T> {
    private final List<T> items;
    private final int placeholdersAfter;
    private final int placeholdersBefore;

    public final List<T> getItems() {
        return this.items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemSnapshotList(int i, int i2, List<? extends T> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.placeholdersBefore = i;
        this.placeholdersAfter = i2;
        this.items = items;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.placeholdersBefore + this.items.size() + this.placeholdersAfter;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int index) {
        if (index >= 0 && index < this.placeholdersBefore) {
            return null;
        }
        int i = this.placeholdersBefore;
        if (index < this.items.size() + i && i <= index) {
            return this.items.get(index - this.placeholdersBefore);
        }
        int size = this.placeholdersBefore + this.items.size();
        if (index < size() && size <= index) {
            return null;
        }
        throw new IndexOutOfBoundsException("Illegal attempt to access index " + index + " in ItemSnapshotList of size " + size());
    }
}
