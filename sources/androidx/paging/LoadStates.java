package androidx.paging;

import androidx.paging.LoadState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadStates.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\fJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u00178G¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\u0017\u0010\"\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b\"\u0010!¨\u0006$"}, d2 = {"Landroidx/paging/LoadStates;", "", "Landroidx/paging/LoadState;", "refresh", "prepend", "append", "<init>", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;)V", "Landroidx/paging/LoadType;", "loadType", "newState", "modifyState$paging_common_release", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)Landroidx/paging/LoadStates;", "modifyState", "copy", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;)Landroidx/paging/LoadStates;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/paging/LoadState;", "getRefresh", "()Landroidx/paging/LoadState;", "getPrepend", "getAppend", "hasError", "Z", "()Z", "isIdle", "Companion", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LoadStates {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LoadStates IDLE;
    private final LoadState append;
    private final boolean hasError;
    private final boolean isIdle;
    private final LoadState prepend;
    private final LoadState refresh;

    /* compiled from: LoadStates.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.APPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ LoadStates copy$default(LoadStates loadStates, LoadState loadState, LoadState loadState2, LoadState loadState3, int i, Object obj) {
        if ((i & 1) != 0) {
            loadState = loadStates.refresh;
        }
        if ((i & 2) != 0) {
            loadState2 = loadStates.prepend;
        }
        if ((i & 4) != 0) {
            loadState3 = loadStates.append;
        }
        return loadStates.copy(loadState, loadState2, loadState3);
    }

    public final LoadStates copy(LoadState refresh, LoadState prepend, LoadState append) {
        Intrinsics.checkNotNullParameter(refresh, "refresh");
        Intrinsics.checkNotNullParameter(prepend, "prepend");
        Intrinsics.checkNotNullParameter(append, "append");
        return new LoadStates(refresh, prepend, append);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadStates)) {
            return false;
        }
        LoadStates loadStates = (LoadStates) other;
        return Intrinsics.areEqual(this.refresh, loadStates.refresh) && Intrinsics.areEqual(this.prepend, loadStates.prepend) && Intrinsics.areEqual(this.append, loadStates.append);
    }

    public int hashCode() {
        return (((this.refresh.hashCode() * 31) + this.prepend.hashCode()) * 31) + this.append.hashCode();
    }

    public String toString() {
        return "LoadStates(refresh=" + this.refresh + ", prepend=" + this.prepend + ", append=" + this.append + ')';
    }

    public LoadStates(LoadState refresh, LoadState prepend, LoadState append) {
        Intrinsics.checkNotNullParameter(refresh, "refresh");
        Intrinsics.checkNotNullParameter(prepend, "prepend");
        Intrinsics.checkNotNullParameter(append, "append");
        this.refresh = refresh;
        this.prepend = prepend;
        this.append = append;
        this.hasError = (refresh instanceof LoadState.Error) || (append instanceof LoadState.Error) || (prepend instanceof LoadState.Error);
        this.isIdle = (refresh instanceof LoadState.NotLoading) && (append instanceof LoadState.NotLoading) && (prepend instanceof LoadState.NotLoading);
    }

    public final LoadState getRefresh() {
        return this.refresh;
    }

    public final LoadState getPrepend() {
        return this.prepend;
    }

    public final LoadState getAppend() {
        return this.append;
    }

    public final LoadStates modifyState$paging_common_release(LoadType loadType, LoadState newState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(newState, "newState");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i == 1) {
            return copy$default(this, null, null, newState, 3, null);
        }
        if (i == 2) {
            return copy$default(this, null, newState, null, 5, null);
        }
        if (i == 3) {
            return copy$default(this, newState, null, null, 6, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: hasError, reason: from getter */
    public final boolean getHasError() {
        return this.hasError;
    }

    /* renamed from: isIdle, reason: from getter */
    public final boolean getIsIdle() {
        return this.isIdle;
    }

    /* compiled from: LoadStates.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/LoadStates$Companion;", "", "()V", "IDLE", "Landroidx/paging/LoadStates;", "getIDLE", "()Landroidx/paging/LoadStates;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoadStates getIDLE() {
            return LoadStates.IDLE;
        }
    }

    static {
        LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
        IDLE = new LoadStates(companion.getIncomplete$paging_common_release(), companion.getIncomplete$paging_common_release(), companion.getIncomplete$paging_common_release());
    }
}
