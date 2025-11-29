package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CombinedLoadStates.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u0017\u0010!\u001a\u00020\f8G¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Landroidx/paging/CombinedLoadStates;", "", "Landroidx/paging/LoadState;", "refresh", "prepend", "append", "Landroidx/paging/LoadStates;", "source", "mediator", "<init>", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroidx/paging/LoadState;", "getRefresh", "()Landroidx/paging/LoadState;", "getPrepend", "getAppend", "Landroidx/paging/LoadStates;", "getSource", "()Landroidx/paging/LoadStates;", "getMediator", "isIdle", "Z", "()Z", "hasError", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CombinedLoadStates {
    private final LoadState append;
    private final boolean hasError;
    private final boolean isIdle;
    private final LoadStates mediator;
    private final LoadState prepend;
    private final LoadState refresh;
    private final LoadStates source;

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CombinedLoadStates(androidx.paging.LoadState r2, androidx.paging.LoadState r3, androidx.paging.LoadState r4, androidx.paging.LoadStates r5, androidx.paging.LoadStates r6) {
        /*
            r1 = this;
            java.lang.String r0 = "refresh"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "prepend"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "append"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r1.<init>()
            r1.refresh = r2
            r1.prepend = r3
            r1.append = r4
            r1.source = r5
            r1.mediator = r6
            boolean r2 = r5.getIsIdle()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r6 == 0) goto L33
            boolean r2 = r6.getIsIdle()
            goto L34
        L33:
            r2 = r4
        L34:
            if (r2 == 0) goto L38
            r2 = r4
            goto L39
        L38:
            r2 = r3
        L39:
            r1.isIdle = r2
            boolean r2 = r5.getHasError()
            if (r2 != 0) goto L4b
            if (r6 == 0) goto L48
            boolean r2 = r6.getHasError()
            goto L49
        L48:
            r2 = r3
        L49:
            if (r2 == 0) goto L4c
        L4b:
            r3 = r4
        L4c:
            r1.hasError = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.CombinedLoadStates.<init>(androidx.paging.LoadState, androidx.paging.LoadState, androidx.paging.LoadState, androidx.paging.LoadStates, androidx.paging.LoadStates):void");
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

    public final LoadStates getSource() {
        return this.source;
    }

    public final LoadStates getMediator() {
        return this.mediator;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || CombinedLoadStates.class != other.getClass()) {
            return false;
        }
        CombinedLoadStates combinedLoadStates = (CombinedLoadStates) other;
        return Intrinsics.areEqual(this.refresh, combinedLoadStates.refresh) && Intrinsics.areEqual(this.prepend, combinedLoadStates.prepend) && Intrinsics.areEqual(this.append, combinedLoadStates.append) && Intrinsics.areEqual(this.source, combinedLoadStates.source) && Intrinsics.areEqual(this.mediator, combinedLoadStates.mediator);
    }

    public int hashCode() {
        int iHashCode = ((((((this.refresh.hashCode() * 31) + this.prepend.hashCode()) * 31) + this.append.hashCode()) * 31) + this.source.hashCode()) * 31;
        LoadStates loadStates = this.mediator;
        return iHashCode + (loadStates != null ? loadStates.hashCode() : 0);
    }

    public String toString() {
        return "CombinedLoadStates(refresh=" + this.refresh + ", prepend=" + this.prepend + ", append=" + this.append + ", source=" + this.source + ", mediator=" + this.mediator + ')';
    }
}
