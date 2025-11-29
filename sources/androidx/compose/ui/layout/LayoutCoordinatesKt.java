package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

/* compiled from: LayoutCoordinates.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\t\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Offset;", "positionInRoot", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInWindow", "Landroidx/compose/ui/geometry/Rect;", "boundsInRoot", "(Landroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/geometry/Rect;", "boundsInWindow", "boundsInParent", "findRootCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/layout/LayoutCoordinates;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutCoordinatesKt {
    public static final long positionInRoot(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo1425localToRootMKHz9U(Offset.INSTANCE.m854getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo1426localToWindowMKHz9U(Offset.INSTANCE.m854getZeroF1C5BW0());
    }

    public static final Rect boundsInRoot(LayoutCoordinates layoutCoordinates) {
        return LayoutCoordinates.localBoundingBoxOf$default(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = findRootCoordinates(layoutCoordinates);
        float fM2156getWidthimpl = IntSize.m2156getWidthimpl(layoutCoordinatesFindRootCoordinates.mo1422getSizeYbymL2g());
        float fM2155getHeightimpl = IntSize.m2155getHeightimpl(layoutCoordinatesFindRootCoordinates.mo1422getSizeYbymL2g());
        Rect rectBoundsInRoot = boundsInRoot(layoutCoordinates);
        float left = rectBoundsInRoot.getLeft();
        if (left < 0.0f) {
            left = 0.0f;
        }
        if (left > fM2156getWidthimpl) {
            left = fM2156getWidthimpl;
        }
        float top = rectBoundsInRoot.getTop();
        if (top < 0.0f) {
            top = 0.0f;
        }
        if (top > fM2155getHeightimpl) {
            top = fM2155getHeightimpl;
        }
        float right = rectBoundsInRoot.getRight();
        if (right < 0.0f) {
            right = 0.0f;
        }
        if (right <= fM2156getWidthimpl) {
            fM2156getWidthimpl = right;
        }
        float bottom = rectBoundsInRoot.getBottom();
        float f = bottom >= 0.0f ? bottom : 0.0f;
        if (f <= fM2155getHeightimpl) {
            fM2155getHeightimpl = f;
        }
        if (left == fM2156getWidthimpl || top == fM2155getHeightimpl) {
            return Rect.INSTANCE.getZero();
        }
        long jMo1426localToWindowMKHz9U = layoutCoordinatesFindRootCoordinates.mo1426localToWindowMKHz9U(OffsetKt.Offset(left, top));
        long jMo1426localToWindowMKHz9U2 = layoutCoordinatesFindRootCoordinates.mo1426localToWindowMKHz9U(OffsetKt.Offset(fM2156getWidthimpl, top));
        long jMo1426localToWindowMKHz9U3 = layoutCoordinatesFindRootCoordinates.mo1426localToWindowMKHz9U(OffsetKt.Offset(fM2156getWidthimpl, fM2155getHeightimpl));
        long jMo1426localToWindowMKHz9U4 = layoutCoordinatesFindRootCoordinates.mo1426localToWindowMKHz9U(OffsetKt.Offset(left, fM2155getHeightimpl));
        float fM842getXimpl = Offset.m842getXimpl(jMo1426localToWindowMKHz9U);
        float fM842getXimpl2 = Offset.m842getXimpl(jMo1426localToWindowMKHz9U2);
        float fM842getXimpl3 = Offset.m842getXimpl(jMo1426localToWindowMKHz9U4);
        float fM842getXimpl4 = Offset.m842getXimpl(jMo1426localToWindowMKHz9U3);
        float fMin = Math.min(fM842getXimpl, Math.min(fM842getXimpl2, Math.min(fM842getXimpl3, fM842getXimpl4)));
        float fMax = Math.max(fM842getXimpl, Math.max(fM842getXimpl2, Math.max(fM842getXimpl3, fM842getXimpl4)));
        float fM843getYimpl = Offset.m843getYimpl(jMo1426localToWindowMKHz9U);
        float fM843getYimpl2 = Offset.m843getYimpl(jMo1426localToWindowMKHz9U2);
        float fM843getYimpl3 = Offset.m843getYimpl(jMo1426localToWindowMKHz9U4);
        float fM843getYimpl4 = Offset.m843getYimpl(jMo1426localToWindowMKHz9U3);
        return new Rect(fMin, Math.min(fM843getYimpl, Math.min(fM843getYimpl2, Math.min(fM843getYimpl3, fM843getYimpl4))), fMax, Math.max(fM843getYimpl, Math.max(fM843getYimpl2, Math.max(fM843getYimpl3, fM843getYimpl4))));
    }

    public static final Rect boundsInParent(LayoutCoordinates layoutCoordinates) {
        Rect rectLocalBoundingBoxOf$default;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (rectLocalBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(parentLayoutCoordinates, layoutCoordinates, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m2156getWidthimpl(layoutCoordinates.mo1422getSizeYbymL2g()), IntSize.m2155getHeightimpl(layoutCoordinates.mo1422getSizeYbymL2g())) : rectLocalBoundingBoxOf$default;
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator wrappedBy = nodeCoordinator.getWrappedBy();
        while (true) {
            NodeCoordinator nodeCoordinator2 = wrappedBy;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator == null) {
                return nodeCoordinator3;
            }
            wrappedBy = nodeCoordinator.getWrappedBy();
        }
    }
}
