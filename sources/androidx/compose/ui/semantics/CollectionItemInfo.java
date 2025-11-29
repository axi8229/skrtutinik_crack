package androidx.compose.ui.semantics;

import kotlin.Metadata;

/* compiled from: SemanticsProperties.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Landroidx/compose/ui/semantics/CollectionItemInfo;", "", "", "rowIndex", "I", "getRowIndex", "()I", "rowSpan", "getRowSpan", "columnIndex", "getColumnIndex", "columnSpan", "getColumnSpan", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CollectionItemInfo {
    private final int columnIndex;
    private final int columnSpan;
    private final int rowIndex;
    private final int rowSpan;

    public final int getRowIndex() {
        return this.rowIndex;
    }

    public final int getRowSpan() {
        return this.rowSpan;
    }

    public final int getColumnIndex() {
        return this.columnIndex;
    }

    public final int getColumnSpan() {
        return this.columnSpan;
    }
}
