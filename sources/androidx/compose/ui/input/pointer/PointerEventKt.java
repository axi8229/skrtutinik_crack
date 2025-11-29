package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: PointerEvent.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\u000b\u001a\u00020\b*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\n\u001a\u001d\u0010\r\u001a\u00020\b*\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u001e\u0010\u0013\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a$\u0010\u0013\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "changedToDown", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)Z", "changedToDownIgnoreConsumed", "changedToUp", "changedToUpIgnoreConsumed", "positionChangedIgnoreConsumed", "Landroidx/compose/ui/geometry/Offset;", "positionChange", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)J", "positionChangeIgnoreConsumed", "ignoreConsumed", "positionChangeInternal", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Z)J", "Landroidx/compose/ui/unit/IntSize;", "size", "isOutOfBounds-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)Z", "isOutOfBounds", "Landroidx/compose/ui/geometry/Size;", "extendedTouchPadding", "isOutOfBounds-jwHxaWs", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JJ)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerEventKt {
    public static final boolean changedToDown(PointerInputChange pointerInputChange) {
        return (pointerInputChange.isConsumed() || pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToDownIgnoreConsumed(PointerInputChange pointerInputChange) {
        return !pointerInputChange.getPreviousPressed() && pointerInputChange.getPressed();
    }

    public static final boolean changedToUp(PointerInputChange pointerInputChange) {
        return (pointerInputChange.isConsumed() || !pointerInputChange.getPreviousPressed() || pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToUpIgnoreConsumed(PointerInputChange pointerInputChange) {
        return pointerInputChange.getPreviousPressed() && !pointerInputChange.getPressed();
    }

    public static final boolean positionChangedIgnoreConsumed(PointerInputChange pointerInputChange) {
        return !Offset.m839equalsimpl0(positionChangeInternal(pointerInputChange, true), Offset.INSTANCE.m854getZeroF1C5BW0());
    }

    public static final long positionChange(PointerInputChange pointerInputChange) {
        return positionChangeInternal(pointerInputChange, false);
    }

    public static final long positionChangeIgnoreConsumed(PointerInputChange pointerInputChange) {
        return positionChangeInternal(pointerInputChange, true);
    }

    private static final long positionChangeInternal(PointerInputChange pointerInputChange, boolean z) {
        long jM846minusMKHz9U = Offset.m846minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange.getPreviousPosition());
        return (z || !pointerInputChange.isConsumed()) ? jM846minusMKHz9U : Offset.INSTANCE.m854getZeroF1C5BW0();
    }

    @Deprecated
    /* renamed from: isOutOfBounds-O0kMr_c, reason: not valid java name */
    public static final boolean m1327isOutOfBoundsO0kMr_c(PointerInputChange pointerInputChange, long j) {
        long position = pointerInputChange.getPosition();
        float fM842getXimpl = Offset.m842getXimpl(position);
        float fM843getYimpl = Offset.m843getYimpl(position);
        return fM842getXimpl < 0.0f || fM842getXimpl > ((float) IntSize.m2156getWidthimpl(j)) || fM843getYimpl < 0.0f || fM843getYimpl > ((float) IntSize.m2155getHeightimpl(j));
    }

    /* renamed from: isOutOfBounds-jwHxaWs, reason: not valid java name */
    public static final boolean m1328isOutOfBoundsjwHxaWs(PointerInputChange pointerInputChange, long j, long j2) {
        if (!PointerType.m1375equalsimpl0(pointerInputChange.getType(), PointerType.INSTANCE.m1381getTouchT8wyACA())) {
            return m1327isOutOfBoundsO0kMr_c(pointerInputChange, j);
        }
        long position = pointerInputChange.getPosition();
        float fM842getXimpl = Offset.m842getXimpl(position);
        float fM843getYimpl = Offset.m843getYimpl(position);
        return fM842getXimpl < (-Size.m878getWidthimpl(j2)) || fM842getXimpl > ((float) IntSize.m2156getWidthimpl(j)) + Size.m878getWidthimpl(j2) || fM843getYimpl < (-Size.m876getHeightimpl(j2)) || fM843getYimpl > ((float) IntSize.m2155getHeightimpl(j)) + Size.m876getHeightimpl(j2);
    }
}
