package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PlaceholderPaddedListDiffHelper.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0001H\u0002J4\u0010\r\u001a\u00020\u0004\"\b\b\u0000\u0010\u000e*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0010¨\u0006\u0012"}, d2 = {"Landroidx/paging/DistinctListsDiffDispatcher;", "", "()V", "dispatchChange", "", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "startBoundary", "", "endBoundary", "start", "end", "payload", "dispatchDiff", "T", "oldList", "Landroidx/paging/PlaceholderPaddedList;", "newList", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DistinctListsDiffDispatcher {
    public static final DistinctListsDiffDispatcher INSTANCE = new DistinctListsDiffDispatcher();

    private DistinctListsDiffDispatcher() {
    }

    public final <T> void dispatchDiff(ListUpdateCallback callback, PlaceholderPaddedList<T> oldList, PlaceholderPaddedList<T> newList) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        Intrinsics.checkNotNullParameter(newList, "newList");
        int iMax = Math.max(oldList.getPlaceholdersBefore(), newList.getPlaceholdersBefore());
        int iMin = Math.min(oldList.getPlaceholdersBefore() + oldList.getDataCount(), newList.getPlaceholdersBefore() + newList.getDataCount());
        int i = iMin - iMax;
        if (i > 0) {
            callback.onRemoved(iMax, i);
            callback.onInserted(iMax, i);
        }
        int iMin2 = Math.min(iMax, iMin);
        int iMax2 = Math.max(iMax, iMin);
        dispatchChange(callback, iMin2, iMax2, RangesKt.coerceAtMost(oldList.getPlaceholdersBefore(), newList.getSize()), RangesKt.coerceAtMost(oldList.getPlaceholdersBefore() + oldList.getDataCount(), newList.getSize()), DiffingChangePayload.ITEM_TO_PLACEHOLDER);
        dispatchChange(callback, iMin2, iMax2, RangesKt.coerceAtMost(newList.getPlaceholdersBefore(), oldList.getSize()), RangesKt.coerceAtMost(newList.getPlaceholdersBefore() + newList.getDataCount(), oldList.getSize()), DiffingChangePayload.PLACEHOLDER_TO_ITEM);
        int size = newList.getSize() - oldList.getSize();
        if (size > 0) {
            callback.onInserted(oldList.getSize(), size);
        } else if (size < 0) {
            callback.onRemoved(oldList.getSize() + size, -size);
        }
    }

    private final void dispatchChange(ListUpdateCallback callback, int startBoundary, int endBoundary, int start, int end, Object payload) {
        int i = startBoundary - start;
        if (i > 0) {
            callback.onChanged(start, i, payload);
        }
        int i2 = end - endBoundary;
        if (i2 > 0) {
            callback.onChanged(endBoundary, i2, payload);
        }
    }
}
