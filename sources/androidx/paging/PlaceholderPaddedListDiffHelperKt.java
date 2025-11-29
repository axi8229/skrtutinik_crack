package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PlaceholderPaddedListDiffHelper.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000\u001a:\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a,\u0010\r\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\f\u001a\u00020\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¨\u0006\u0010"}, d2 = {"computeDiff", "Landroidx/paging/PlaceholderPaddedDiffResult;", "T", "", "Landroidx/paging/PlaceholderPaddedList;", "newList", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "dispatchDiff", "", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "diffResult", "transformAnchorIndex", "", "oldPosition", "paging-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlaceholderPaddedListDiffHelperKt {
    public static final <T> PlaceholderPaddedDiffResult computeDiff(final PlaceholderPaddedList<T> placeholderPaddedList, final PlaceholderPaddedList<T> newList, final DiffUtil.ItemCallback<T> diffCallback) {
        Intrinsics.checkNotNullParameter(placeholderPaddedList, "<this>");
        Intrinsics.checkNotNullParameter(newList, "newList");
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        final int dataCount = placeholderPaddedList.getDataCount();
        final int dataCount2 = newList.getDataCount();
        DiffUtil.Callback callback = new DiffUtil.Callback() { // from class: androidx.paging.PlaceholderPaddedListDiffHelperKt$computeDiff$diffResult$1
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public Object getChangePayload(int oldItemPosition, int newItemPosition) {
                Object item = placeholderPaddedList.getItem(oldItemPosition);
                Object item2 = newList.getItem(newItemPosition);
                if (item == item2) {
                    return Boolean.TRUE;
                }
                return diffCallback.getChangePayload(item, item2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            /* renamed from: getOldListSize, reason: from getter */
            public int get$oldSize() {
                return dataCount;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            /* renamed from: getNewListSize, reason: from getter */
            public int get$newSize() {
                return dataCount2;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                Object item = placeholderPaddedList.getItem(oldItemPosition);
                Object item2 = newList.getItem(newItemPosition);
                if (item == item2) {
                    return true;
                }
                return diffCallback.areItemsTheSame(item, item2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                Object item = placeholderPaddedList.getItem(oldItemPosition);
                Object item2 = newList.getItem(newItemPosition);
                if (item == item2) {
                    return true;
                }
                return diffCallback.areContentsTheSame(item, item2);
            }
        };
        boolean z = true;
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(callback, true);
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "PlaceholderPaddedList<T>…    },\n        true\n    )");
        Iterable iterableUntil = RangesKt.until(0, placeholderPaddedList.getDataCount());
        if ((iterableUntil instanceof Collection) && ((Collection) iterableUntil).isEmpty()) {
            z = false;
        } else {
            Iterator<T> it = iterableUntil.iterator();
            while (it.hasNext()) {
                if (diffResultCalculateDiff.convertOldPositionToNew(((IntIterator) it).nextInt()) != -1) {
                    break;
                }
            }
            z = false;
        }
        return new PlaceholderPaddedDiffResult(diffResultCalculateDiff, z);
    }

    public static final <T> void dispatchDiff(PlaceholderPaddedList<T> placeholderPaddedList, ListUpdateCallback callback, PlaceholderPaddedList<T> newList, PlaceholderPaddedDiffResult diffResult) {
        Intrinsics.checkNotNullParameter(placeholderPaddedList, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(newList, "newList");
        Intrinsics.checkNotNullParameter(diffResult, "diffResult");
        if (diffResult.getHasOverlap()) {
            OverlappingListsDiffDispatcher.INSTANCE.dispatchDiff(placeholderPaddedList, newList, callback, diffResult);
        } else {
            DistinctListsDiffDispatcher.INSTANCE.dispatchDiff(callback, placeholderPaddedList, newList);
        }
    }

    public static final int transformAnchorIndex(PlaceholderPaddedList<?> placeholderPaddedList, PlaceholderPaddedDiffResult diffResult, PlaceholderPaddedList<?> newList, int i) {
        int iConvertOldPositionToNew;
        Intrinsics.checkNotNullParameter(placeholderPaddedList, "<this>");
        Intrinsics.checkNotNullParameter(diffResult, "diffResult");
        Intrinsics.checkNotNullParameter(newList, "newList");
        if (!diffResult.getHasOverlap()) {
            return RangesKt.coerceIn(i, RangesKt.until(0, newList.getSize()));
        }
        int placeholdersBefore = i - placeholderPaddedList.getPlaceholdersBefore();
        int dataCount = placeholderPaddedList.getDataCount();
        if (placeholdersBefore >= 0 && placeholdersBefore < dataCount) {
            for (int i2 = 0; i2 < 30; i2++) {
                int i3 = ((i2 / 2) * (i2 % 2 == 1 ? -1 : 1)) + placeholdersBefore;
                if (i3 >= 0 && i3 < placeholderPaddedList.getDataCount() && (iConvertOldPositionToNew = diffResult.getDiff().convertOldPositionToNew(i3)) != -1) {
                    return iConvertOldPositionToNew + newList.getPlaceholdersBefore();
                }
            }
        }
        return RangesKt.coerceIn(i, RangesKt.until(0, newList.getSize()));
    }
}
