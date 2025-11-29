package androidx.paging;

import androidx.paging.PagingSource;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PagingState.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B=\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R)\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\"¨\u0006#"}, d2 = {"Landroidx/paging/PagingState;", "", "Key", "Value", "", "Landroidx/paging/PagingSource$LoadResult$Page;", "pages", "", "anchorPosition", "Landroidx/paging/PagingConfig;", "config", "leadingPlaceholderCount", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Landroidx/paging/PagingConfig;I)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "closestPageToPosition", "(I)Landroidx/paging/PagingSource$LoadResult$Page;", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getPages", "()Ljava/util/List;", "Ljava/lang/Integer;", "getAnchorPosition", "()Ljava/lang/Integer;", "Landroidx/paging/PagingConfig;", "getConfig", "()Landroidx/paging/PagingConfig;", "I", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagingState<Key, Value> {
    private final Integer anchorPosition;
    private final PagingConfig config;
    private final int leadingPlaceholderCount;
    private final List<PagingSource.LoadResult.Page<Key, Value>> pages;

    public PagingState(List<PagingSource.LoadResult.Page<Key, Value>> pages, Integer num, PagingConfig config, int i) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(config, "config");
        this.pages = pages;
        this.anchorPosition = num;
        this.config = config;
        this.leadingPlaceholderCount = i;
    }

    public final List<PagingSource.LoadResult.Page<Key, Value>> getPages() {
        return this.pages;
    }

    public final Integer getAnchorPosition() {
        return this.anchorPosition;
    }

    public boolean equals(Object other) {
        if (other instanceof PagingState) {
            PagingState pagingState = (PagingState) other;
            if (Intrinsics.areEqual(this.pages, pagingState.pages) && Intrinsics.areEqual(this.anchorPosition, pagingState.anchorPosition) && Intrinsics.areEqual(this.config, pagingState.config) && this.leadingPlaceholderCount == pagingState.leadingPlaceholderCount) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.pages.hashCode();
        Integer num = this.anchorPosition;
        return iHashCode + (num != null ? num.hashCode() : 0) + this.config.hashCode() + Integer.hashCode(this.leadingPlaceholderCount);
    }

    public final PagingSource.LoadResult.Page<Key, Value> closestPageToPosition(int anchorPosition) {
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((PagingSource.LoadResult.Page) it.next()).getData().isEmpty()) {
                int size = anchorPosition - this.leadingPlaceholderCount;
                int i = 0;
                while (i < CollectionsKt.getLastIndex(getPages()) && size > CollectionsKt.getLastIndex(getPages().get(i).getData())) {
                    size -= getPages().get(i).getData().size();
                    i++;
                }
                if (size < 0) {
                    return (PagingSource.LoadResult.Page) CollectionsKt.first((List) this.pages);
                }
                return this.pages.get(i);
            }
        }
        return null;
    }

    public String toString() {
        return "PagingState(pages=" + this.pages + ", anchorPosition=" + this.anchorPosition + ", config=" + this.config + ", leadingPlaceholderCount=" + this.leadingPlaceholderCount + ')';
    }
}
