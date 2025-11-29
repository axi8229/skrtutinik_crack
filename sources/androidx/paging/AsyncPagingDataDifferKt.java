package androidx.paging;

import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: AsyncPagingDataDiffer.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "T", "Landroidx/paging/PlaceholderPaddedList;", "", "index", "get", "(Landroidx/paging/PlaceholderPaddedList;I)Ljava/lang/Object;", "Landroidx/paging/ItemSnapshotList;", "snapshot", "(Landroidx/paging/PlaceholderPaddedList;)Landroidx/paging/ItemSnapshotList;", "paging-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AsyncPagingDataDifferKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T get(PlaceholderPaddedList<T> placeholderPaddedList, int i) {
        if (i < 0 || i >= placeholderPaddedList.getSize()) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + placeholderPaddedList.getSize());
        }
        int placeholdersBefore = i - placeholderPaddedList.getPlaceholdersBefore();
        if (placeholdersBefore < 0 || placeholdersBefore >= placeholderPaddedList.getDataCount()) {
            return null;
        }
        return placeholderPaddedList.getItem(placeholdersBefore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> ItemSnapshotList<T> snapshot(PlaceholderPaddedList<T> placeholderPaddedList) {
        int dataCount = placeholderPaddedList.getDataCount() - 1;
        ArrayList arrayList = new ArrayList();
        if (dataCount >= 0) {
            int i = 0;
            while (true) {
                arrayList.add(placeholderPaddedList.getItem(i));
                if (i == dataCount) {
                    break;
                }
                i++;
            }
        }
        return new ItemSnapshotList<>(placeholderPaddedList.getPlaceholdersBefore(), placeholderPaddedList.getPlaceholdersAfter(), arrayList);
    }
}
