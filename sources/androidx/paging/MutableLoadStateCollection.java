package androidx.paging;

import androidx.paging.LoadState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MutableLoadStateCollection.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0012R\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018¨\u0006\u001f"}, d2 = {"Landroidx/paging/MutableLoadStateCollection;", "", "<init>", "()V", "Landroidx/paging/LoadStates;", "snapshot", "()Landroidx/paging/LoadStates;", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/LoadState;", "get", "(Landroidx/paging/LoadType;)Landroidx/paging/LoadState;", "type", "state", "", "set", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "states", "(Landroidx/paging/LoadStates;)V", "refresh", "Landroidx/paging/LoadState;", "getRefresh", "()Landroidx/paging/LoadState;", "setRefresh", "(Landroidx/paging/LoadState;)V", "prepend", "getPrepend", "setPrepend", "append", "getAppend", "setAppend", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableLoadStateCollection {
    private LoadState append;
    private LoadState prepend;
    private LoadState refresh;

    /* compiled from: MutableLoadStateCollection.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MutableLoadStateCollection() {
        LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
        this.refresh = companion.getIncomplete$paging_common_release();
        this.prepend = companion.getIncomplete$paging_common_release();
        this.append = companion.getIncomplete$paging_common_release();
    }

    public final LoadStates snapshot() {
        return new LoadStates(this.refresh, this.prepend, this.append);
    }

    public final LoadState get(LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i == 1) {
            return this.refresh;
        }
        if (i == 2) {
            return this.append;
        }
        if (i == 3) {
            return this.prepend;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void set(LoadType type, LoadState state) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            this.refresh = state;
        } else if (i == 2) {
            this.append = state;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            this.prepend = state;
        }
    }

    public final void set(LoadStates states) {
        Intrinsics.checkNotNullParameter(states, "states");
        this.refresh = states.getRefresh();
        this.append = states.getAppend();
        this.prepend = states.getPrepend();
    }
}
