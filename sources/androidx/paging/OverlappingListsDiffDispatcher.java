package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PlaceholderPaddedListDiffHelper.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher;", "", "()V", "dispatchDiff", "", "T", "oldList", "Landroidx/paging/PlaceholderPaddedList;", "newList", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "diffResult", "Landroidx/paging/PlaceholderPaddedDiffResult;", "PlaceholderUsingUpdateCallback", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OverlappingListsDiffDispatcher {
    public static final OverlappingListsDiffDispatcher INSTANCE = new OverlappingListsDiffDispatcher();

    private OverlappingListsDiffDispatcher() {
    }

    public final <T> void dispatchDiff(PlaceholderPaddedList<T> oldList, PlaceholderPaddedList<T> newList, ListUpdateCallback callback, PlaceholderPaddedDiffResult diffResult) {
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        Intrinsics.checkNotNullParameter(newList, "newList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(diffResult, "diffResult");
        PlaceholderUsingUpdateCallback placeholderUsingUpdateCallback = new PlaceholderUsingUpdateCallback(oldList, newList, callback);
        diffResult.getDiff().dispatchUpdatesTo(placeholderUsingUpdateCallback);
        placeholderUsingUpdateCallback.fixPlaceholders();
    }

    /* compiled from: PlaceholderPaddedListDiffHelper.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\r\b\u0002\u0018\u0000 )*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001)B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\r\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u000bJ\u001f\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001c\u0010\u0018J)\u0010\u001f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010!R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\"R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010&\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010'\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010$R\u0016\u0010(\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010$¨\u0006*"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher$PlaceholderUsingUpdateCallback;", "T", "Landroidx/recyclerview/widget/ListUpdateCallback;", "Landroidx/paging/PlaceholderPaddedList;", "oldList", "newList", "callback", "<init>", "(Landroidx/paging/PlaceholderPaddedList;Landroidx/paging/PlaceholderPaddedList;Landroidx/recyclerview/widget/ListUpdateCallback;)V", "", "fixTrailingPlaceholders", "()V", "fixLeadingPlaceholders", "", "position", "count", "", "dispatchInsertAsPlaceholderBefore", "(II)Z", "dispatchInsertAsPlaceholderAfter", "dispatchRemovalAsPlaceholdersBefore", "dispatchRemovalAsPlaceholdersAfter", "fixPlaceholders", "onInserted", "(II)V", "onRemoved", "fromPosition", "toPosition", "onMoved", "", "payload", "onChanged", "(IILjava/lang/Object;)V", "Landroidx/paging/PlaceholderPaddedList;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "placeholdersBefore", "I", "placeholdersAfter", "storageCount", "placeholdersBeforeState", "placeholdersAfterState", "Companion", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class PlaceholderUsingUpdateCallback<T> implements ListUpdateCallback {
        private final ListUpdateCallback callback;
        private final PlaceholderPaddedList<T> newList;
        private final PlaceholderPaddedList<T> oldList;
        private int placeholdersAfter;
        private int placeholdersAfterState;
        private int placeholdersBefore;
        private int placeholdersBeforeState;
        private int storageCount;

        public PlaceholderUsingUpdateCallback(PlaceholderPaddedList<T> oldList, PlaceholderPaddedList<T> newList, ListUpdateCallback callback) {
            Intrinsics.checkNotNullParameter(oldList, "oldList");
            Intrinsics.checkNotNullParameter(newList, "newList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.oldList = oldList;
            this.newList = newList;
            this.callback = callback;
            this.placeholdersBefore = oldList.getPlaceholdersBefore();
            this.placeholdersAfter = oldList.getPlaceholdersAfter();
            this.storageCount = oldList.getDataCount();
            this.placeholdersBeforeState = 1;
            this.placeholdersAfterState = 1;
        }

        public final void fixPlaceholders() {
            fixLeadingPlaceholders();
            fixTrailingPlaceholders();
        }

        private final void fixTrailingPlaceholders() {
            int iMin = Math.min(this.oldList.getPlaceholdersAfter(), this.placeholdersAfter);
            int placeholdersAfter = this.newList.getPlaceholdersAfter();
            int i = this.placeholdersAfter;
            int i2 = placeholdersAfter - i;
            int i3 = this.placeholdersBefore + this.storageCount + i;
            int i4 = i3 - iMin;
            boolean z = i4 != this.oldList.getSize() - iMin;
            if (i2 > 0) {
                this.callback.onInserted(i3, i2);
            } else if (i2 < 0) {
                this.callback.onRemoved(i3 + i2, -i2);
                iMin += i2;
            }
            if (iMin > 0 && z) {
                this.callback.onChanged(i4, iMin, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
            }
            this.placeholdersAfter = this.newList.getPlaceholdersAfter();
        }

        private final void fixLeadingPlaceholders() {
            int iMin = Math.min(this.oldList.getPlaceholdersBefore(), this.placeholdersBefore);
            int placeholdersBefore = this.newList.getPlaceholdersBefore() - this.placeholdersBefore;
            if (placeholdersBefore > 0) {
                if (iMin > 0) {
                    this.callback.onChanged(0, iMin, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
                this.callback.onInserted(0, placeholdersBefore);
            } else if (placeholdersBefore < 0) {
                this.callback.onRemoved(0, -placeholdersBefore);
                int i = iMin + placeholdersBefore;
                if (i > 0) {
                    this.callback.onChanged(0, i, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
            }
            this.placeholdersBefore = this.newList.getPlaceholdersBefore();
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int position, int count) {
            if (!dispatchInsertAsPlaceholderAfter(position, count) && !dispatchInsertAsPlaceholderBefore(position, count)) {
                this.callback.onInserted(position + this.placeholdersBefore, count);
            }
            this.storageCount += count;
        }

        private final boolean dispatchInsertAsPlaceholderBefore(int position, int count) {
            if (position > 0 || this.placeholdersBeforeState == 2) {
                return false;
            }
            int iMin = Math.min(count, this.placeholdersBefore);
            if (iMin > 0) {
                this.placeholdersBeforeState = 3;
                this.callback.onChanged((0 - iMin) + this.placeholdersBefore, iMin, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                this.placeholdersBefore -= iMin;
            }
            int i = count - iMin;
            if (i <= 0) {
                return true;
            }
            this.callback.onInserted(this.placeholdersBefore, i);
            return true;
        }

        private final boolean dispatchInsertAsPlaceholderAfter(int position, int count) {
            if (position < this.storageCount || this.placeholdersAfterState == 2) {
                return false;
            }
            int iMin = Math.min(count, this.placeholdersAfter);
            if (iMin > 0) {
                this.placeholdersAfterState = 3;
                this.callback.onChanged(this.placeholdersBefore + position, iMin, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                this.placeholdersAfter -= iMin;
            }
            int i = count - iMin;
            if (i <= 0) {
                return true;
            }
            this.callback.onInserted(position + iMin + this.placeholdersBefore, i);
            return true;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int position, int count) {
            if (!dispatchRemovalAsPlaceholdersAfter(position, count) && !dispatchRemovalAsPlaceholdersBefore(position, count)) {
                this.callback.onRemoved(position + this.placeholdersBefore, count);
            }
            this.storageCount -= count;
        }

        private final boolean dispatchRemovalAsPlaceholdersBefore(int position, int count) {
            if (position > 0 || this.placeholdersBeforeState == 3) {
                return false;
            }
            int iCoerceAtLeast = RangesKt.coerceAtLeast(Math.min(this.newList.getPlaceholdersBefore() - this.placeholdersBefore, count), 0);
            int i = count - iCoerceAtLeast;
            if (i > 0) {
                this.callback.onRemoved(this.placeholdersBefore, i);
            }
            if (iCoerceAtLeast <= 0) {
                return true;
            }
            this.placeholdersBeforeState = 2;
            this.callback.onChanged(this.placeholdersBefore, iCoerceAtLeast, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
            this.placeholdersBefore += iCoerceAtLeast;
            return true;
        }

        private final boolean dispatchRemovalAsPlaceholdersAfter(int position, int count) {
            if (position + count < this.storageCount || this.placeholdersAfterState == 3) {
                return false;
            }
            int iCoerceAtLeast = RangesKt.coerceAtLeast(Math.min(this.newList.getPlaceholdersAfter() - this.placeholdersAfter, count), 0);
            int i = count - iCoerceAtLeast;
            if (iCoerceAtLeast > 0) {
                this.placeholdersAfterState = 2;
                this.callback.onChanged(this.placeholdersBefore + position, iCoerceAtLeast, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
                this.placeholdersAfter += iCoerceAtLeast;
            }
            if (i <= 0) {
                return true;
            }
            this.callback.onRemoved(position + iCoerceAtLeast + this.placeholdersBefore, i);
            return true;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int fromPosition, int toPosition) {
            ListUpdateCallback listUpdateCallback = this.callback;
            int i = this.placeholdersBefore;
            listUpdateCallback.onMoved(fromPosition + i, toPosition + i);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int position, int count, Object payload) {
            this.callback.onChanged(position + this.placeholdersBefore, count, payload);
        }
    }
}
