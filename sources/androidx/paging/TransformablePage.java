package androidx.paging;

import androidx.paging.ViewportHint;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: TransformablePage.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0080\b\u0018\u0000 (*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001(B5\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bB\u001f\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\n\u0010\rJ5\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b&\u0010\u001bR\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b'\u0010$¨\u0006)"}, d2 = {"Landroidx/paging/TransformablePage;", "", "T", "", "originalPageOffsets", "", RemoteMessageConst.DATA, "", "hintOriginalPageOffset", "hintOriginalIndices", "<init>", "([ILjava/util/List;ILjava/util/List;)V", "originalPageOffset", "(ILjava/util/List;)V", "index", "presentedItemsBefore", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "Landroidx/paging/ViewportHint$Access;", "viewportHintFor", "(IIIII)Landroidx/paging/ViewportHint$Access;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "[I", "getOriginalPageOffsets", "()[I", "Ljava/util/List;", "getData", "()Ljava/util/List;", "I", "getHintOriginalPageOffset", "getHintOriginalIndices", "Companion", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TransformablePage<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TransformablePage<Object> EMPTY_INITIAL_PAGE = new TransformablePage<>(0, CollectionsKt.emptyList());
    private final List<T> data;
    private final List<Integer> hintOriginalIndices;
    private final int hintOriginalPageOffset;
    private final int[] originalPageOffsets;

    public String toString() {
        return "TransformablePage(originalPageOffsets=" + Arrays.toString(this.originalPageOffsets) + ", data=" + this.data + ", hintOriginalPageOffset=" + this.hintOriginalPageOffset + ", hintOriginalIndices=" + this.hintOriginalIndices + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransformablePage(int[] originalPageOffsets, List<? extends T> data, int i, List<Integer> list) {
        Intrinsics.checkNotNullParameter(originalPageOffsets, "originalPageOffsets");
        Intrinsics.checkNotNullParameter(data, "data");
        this.originalPageOffsets = originalPageOffsets;
        this.data = data;
        this.hintOriginalPageOffset = i;
        this.hintOriginalIndices = list;
        if (originalPageOffsets.length == 0) {
            throw new IllegalArgumentException("originalPageOffsets cannot be empty when constructing TransformablePage");
        }
        if (list == null || list.size() == data.size()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("If originalIndices (size = ");
        Intrinsics.checkNotNull(list);
        sb.append(list.size());
        sb.append(") is provided, it must be same length as data (size = ");
        sb.append(data.size());
        sb.append(')');
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public final int[] getOriginalPageOffsets() {
        return this.originalPageOffsets;
    }

    public final List<T> getData() {
        return this.data;
    }

    public final int getHintOriginalPageOffset() {
        return this.hintOriginalPageOffset;
    }

    public final List<Integer> getHintOriginalIndices() {
        return this.hintOriginalIndices;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransformablePage(int i, List<? extends T> data) {
        this(new int[]{i}, data, i, null);
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public final ViewportHint.Access viewportHintFor(int index, int presentedItemsBefore, int presentedItemsAfter, int originalPageOffsetFirst, int originalPageOffsetLast) {
        IntRange indices;
        int i = this.hintOriginalPageOffset;
        List<Integer> list = this.hintOriginalIndices;
        if (list != null && (indices = CollectionsKt.getIndices(list)) != null && indices.contains(index)) {
            index = this.hintOriginalIndices.get(index).intValue();
        }
        return new ViewportHint.Access(i, index, presentedItemsBefore, presentedItemsAfter, originalPageOffsetFirst, originalPageOffsetLast);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || TransformablePage.class != other.getClass()) {
            return false;
        }
        TransformablePage transformablePage = (TransformablePage) other;
        return Arrays.equals(this.originalPageOffsets, transformablePage.originalPageOffsets) && Intrinsics.areEqual(this.data, transformablePage.data) && this.hintOriginalPageOffset == transformablePage.hintOriginalPageOffset && Intrinsics.areEqual(this.hintOriginalIndices, transformablePage.hintOriginalIndices);
    }

    public int hashCode() {
        int iHashCode = ((((Arrays.hashCode(this.originalPageOffsets) * 31) + this.data.hashCode()) * 31) + this.hintOriginalPageOffset) * 31;
        List<Integer> list = this.hintOriginalIndices;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    /* compiled from: TransformablePage.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/paging/TransformablePage$Companion;", "", "<init>", "()V", "Landroidx/paging/TransformablePage;", "EMPTY_INITIAL_PAGE", "Landroidx/paging/TransformablePage;", "getEMPTY_INITIAL_PAGE", "()Landroidx/paging/TransformablePage;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TransformablePage<Object> getEMPTY_INITIAL_PAGE() {
            return TransformablePage.EMPTY_INITIAL_PAGE;
        }
    }
}
