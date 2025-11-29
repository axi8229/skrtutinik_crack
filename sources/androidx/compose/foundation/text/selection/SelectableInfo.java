package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;

/* compiled from: SelectionLayout.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b \u0010\u001dR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0011\u0010+\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b*\u0010\u0017R\u0011\u0010-\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b,\u0010\u001dR\u0011\u00101\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectableInfo;", "", "", "selectableId", "", "slot", "rawStartHandleOffset", "rawEndHandleOffset", "rawPreviousHandleOffset", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "<init>", "(JIIIILandroidx/compose/ui/text/TextLayoutResult;)V", "other", "", "shouldRecomputeSelection", "(Landroidx/compose/foundation/text/selection/SelectableInfo;)Z", "offset", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "anchorForOffset", "(I)Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "", "toString", "()Ljava/lang/String;", "J", "getSelectableId", "()J", "I", "getSlot", "()I", "getRawStartHandleOffset", "getRawEndHandleOffset", "getRawPreviousHandleOffset", "Landroidx/compose/ui/text/TextLayoutResult;", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getStartRunDirection", "()Landroidx/compose/ui/text/style/ResolvedTextDirection;", "startRunDirection", "getEndRunDirection", "endRunDirection", "getInputText", "inputText", "getTextLength", "textLength", "Landroidx/compose/foundation/text/selection/CrossStatus;", "getRawCrossStatus", "()Landroidx/compose/foundation/text/selection/CrossStatus;", "rawCrossStatus", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectableInfo {
    public static final int $stable = TextLayoutResult.$stable;
    private final int rawEndHandleOffset;
    private final int rawPreviousHandleOffset;
    private final int rawStartHandleOffset;
    private final long selectableId;
    private final int slot;
    private final TextLayoutResult textLayoutResult;

    public SelectableInfo(long j, int i, int i2, int i3, int i4, TextLayoutResult textLayoutResult) {
        this.selectableId = j;
        this.slot = i;
        this.rawStartHandleOffset = i2;
        this.rawEndHandleOffset = i3;
        this.rawPreviousHandleOffset = i4;
        this.textLayoutResult = textLayoutResult;
    }

    public final long getSelectableId() {
        return this.selectableId;
    }

    public final int getSlot() {
        return this.slot;
    }

    public final int getRawStartHandleOffset() {
        return this.rawStartHandleOffset;
    }

    public final int getRawEndHandleOffset() {
        return this.rawEndHandleOffset;
    }

    public final int getRawPreviousHandleOffset() {
        return this.rawPreviousHandleOffset;
    }

    public final TextLayoutResult getTextLayoutResult() {
        return this.textLayoutResult;
    }

    public final String getInputText() {
        return this.textLayoutResult.getLayoutInput().getText().getText();
    }

    public final int getTextLength() {
        return getInputText().length();
    }

    public final CrossStatus getRawCrossStatus() {
        int i = this.rawStartHandleOffset;
        int i2 = this.rawEndHandleOffset;
        if (i < i2) {
            return CrossStatus.NOT_CROSSED;
        }
        if (i > i2) {
            return CrossStatus.CROSSED;
        }
        return CrossStatus.COLLAPSED;
    }

    private final ResolvedTextDirection getStartRunDirection() {
        return SelectionLayoutKt.getTextDirectionForOffset(this.textLayoutResult, this.rawStartHandleOffset);
    }

    private final ResolvedTextDirection getEndRunDirection() {
        return SelectionLayoutKt.getTextDirectionForOffset(this.textLayoutResult, this.rawEndHandleOffset);
    }

    public final boolean shouldRecomputeSelection(SelectableInfo other) {
        return (this.selectableId == other.selectableId && this.rawStartHandleOffset == other.rawStartHandleOffset && this.rawEndHandleOffset == other.rawEndHandleOffset) ? false : true;
    }

    public final Selection.AnchorInfo anchorForOffset(int offset) {
        return new Selection.AnchorInfo(SelectionLayoutKt.getTextDirectionForOffset(this.textLayoutResult, offset), offset, this.selectableId);
    }

    public String toString() {
        return "SelectionInfo(id=" + this.selectableId + ", range=(" + this.rawStartHandleOffset + '-' + getStartRunDirection() + ',' + this.rawEndHandleOffset + '-' + getEndRunDirection() + "), prevOffset=" + this.rawPreviousHandleOffset + ')';
    }
}
