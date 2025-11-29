package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PageFetcherSnapshot.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/paging/GenerationalViewportHint;", "", "", "generationId", "Landroidx/paging/ViewportHint;", "hint", "<init>", "(ILandroidx/paging/ViewportHint;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getGenerationId", "Landroidx/paging/ViewportHint;", "getHint", "()Landroidx/paging/ViewportHint;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GenerationalViewportHint {
    private final int generationId;
    private final ViewportHint hint;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GenerationalViewportHint)) {
            return false;
        }
        GenerationalViewportHint generationalViewportHint = (GenerationalViewportHint) other;
        return this.generationId == generationalViewportHint.generationId && Intrinsics.areEqual(this.hint, generationalViewportHint.hint);
    }

    public int hashCode() {
        return (Integer.hashCode(this.generationId) * 31) + this.hint.hashCode();
    }

    public String toString() {
        return "GenerationalViewportHint(generationId=" + this.generationId + ", hint=" + this.hint + ')';
    }

    public GenerationalViewportHint(int i, ViewportHint hint) {
        Intrinsics.checkNotNullParameter(hint, "hint");
        this.generationId = i;
        this.hint = hint;
    }

    public final int getGenerationId() {
        return this.generationId;
    }

    public final ViewportHint getHint() {
        return this.hint;
    }
}
