package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u000e\u001a\u00020\u0006*\u00020\bø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0010\u001a\u00020\u0006*\u00020\bø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\rJ%\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/gestures/TouchSlopDetector;", "", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "<init>", "(Landroidx/compose/foundation/gestures/Orientation;)V", "", "touchSlop", "Landroidx/compose/ui/geometry/Offset;", "calculatePostSlopOffset-tuRUvjQ", "(F)J", "calculatePostSlopOffset", "mainAxis-k-4lQ0M", "(J)F", "mainAxis", "crossAxis-k-4lQ0M", "crossAxis", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "dragEvent", "addPointerInputChange-GcwITfU", "(Landroidx/compose/ui/input/pointer/PointerInputChange;F)Landroidx/compose/ui/geometry/Offset;", "addPointerInputChange", "", "reset", "()V", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "totalPositionChange", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TouchSlopDetector {
    private final Orientation orientation;
    private long totalPositionChange;

    public TouchSlopDetector() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public TouchSlopDetector(Orientation orientation) {
        this.orientation = orientation;
        this.totalPositionChange = Offset.INSTANCE.m854getZeroF1C5BW0();
    }

    public /* synthetic */ TouchSlopDetector(Orientation orientation, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : orientation);
    }

    /* renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    public final float m284mainAxisk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m842getXimpl(j) : Offset.m843getYimpl(j);
    }

    /* renamed from: crossAxis-k-4lQ0M, reason: not valid java name */
    public final float m283crossAxisk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m843getYimpl(j) : Offset.m842getXimpl(j);
    }

    /* renamed from: addPointerInputChange-GcwITfU, reason: not valid java name */
    public final Offset m282addPointerInputChangeGcwITfU(PointerInputChange dragEvent, float touchSlop) {
        float fAbs;
        long jM847plusMKHz9U = Offset.m847plusMKHz9U(this.totalPositionChange, Offset.m846minusMKHz9U(dragEvent.getPosition(), dragEvent.getPreviousPosition()));
        this.totalPositionChange = jM847plusMKHz9U;
        if (this.orientation == null) {
            fAbs = Offset.m840getDistanceimpl(jM847plusMKHz9U);
        } else {
            fAbs = Math.abs(m284mainAxisk4lQ0M(jM847plusMKHz9U));
        }
        if (fAbs >= touchSlop) {
            return Offset.m833boximpl(m281calculatePostSlopOffsettuRUvjQ(touchSlop));
        }
        return null;
    }

    public final void reset() {
        this.totalPositionChange = Offset.INSTANCE.m854getZeroF1C5BW0();
    }

    /* renamed from: calculatePostSlopOffset-tuRUvjQ, reason: not valid java name */
    private final long m281calculatePostSlopOffsettuRUvjQ(float touchSlop) {
        if (this.orientation == null) {
            long j = this.totalPositionChange;
            return Offset.m846minusMKHz9U(this.totalPositionChange, Offset.m848timestuRUvjQ(Offset.m837divtuRUvjQ(j, Offset.m840getDistanceimpl(j)), touchSlop));
        }
        float fM284mainAxisk4lQ0M = m284mainAxisk4lQ0M(this.totalPositionChange) - (Math.signum(m284mainAxisk4lQ0M(this.totalPositionChange)) * touchSlop);
        float fM283crossAxisk4lQ0M = m283crossAxisk4lQ0M(this.totalPositionChange);
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset(fM284mainAxisk4lQ0M, fM283crossAxisk4lQ0M);
        }
        return OffsetKt.Offset(fM283crossAxisk4lQ0M, fM284mainAxisk4lQ0M);
    }
}
