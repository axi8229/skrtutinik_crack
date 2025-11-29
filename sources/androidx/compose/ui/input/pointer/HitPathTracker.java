package androidx.compose.ui.input.pointer;

import androidx.collection.MutableLongObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;

/* compiled from: HitPathTracker.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\f\u0010\rJ0\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u001a\u0010\"\u001a\u00020!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R \u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Landroidx/compose/ui/input/pointer/HitPathTracker;", "", "Landroidx/compose/ui/layout/LayoutCoordinates;", "rootCoordinates", "<init>", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "", "pointerId", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/input/pointer/Node;", "hitNodes", "", "removeInvalidPointerIdsAndChanges", "(JLandroidx/collection/MutableObjectList;)V", "Landroidx/compose/ui/input/pointer/PointerId;", "", "Landroidx/compose/ui/Modifier$Node;", "pointerInputNodes", "", "prunePointerIdsAndChangesNotInNodesList", "addHitPath-QJqDSyo", "(JLjava/util/List;Z)V", "addHitPath", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "internalPointerEvent", "isInBounds", "dispatchChanges", "(Landroidx/compose/ui/input/pointer/InternalPointerEvent;Z)Z", "clearPreviouslyHitModifierNodeCache", "()V", "processCancel", "removeDetachedPointerInputNodes", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/input/pointer/NodeParent;", "root", "Landroidx/compose/ui/input/pointer/NodeParent;", "getRoot$ui_release", "()Landroidx/compose/ui/input/pointer/NodeParent;", "Landroidx/collection/MutableLongObjectMap;", "hitPointerIdsAndNodes", "Landroidx/collection/MutableLongObjectMap;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HitPathTracker {
    private final LayoutCoordinates rootCoordinates;
    private final NodeParent root = new NodeParent();
    private final MutableLongObjectMap<MutableObjectList<Node>> hitPointerIdsAndNodes = new MutableLongObjectMap<>(10);

    public HitPathTracker(LayoutCoordinates layoutCoordinates) {
        this.rootCoordinates = layoutCoordinates;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    /* renamed from: addHitPath-QJqDSyo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1318addHitPathQJqDSyo(long r18, java.util.List<? extends androidx.compose.ui.Modifier.Node> r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.HitPathTracker.m1318addHitPathQJqDSyo(long, java.util.List, boolean):void");
    }

    private final void removeInvalidPointerIdsAndChanges(long pointerId, MutableObjectList<Node> hitNodes) {
        this.root.removeInvalidPointerIdsAndChanges(pointerId, hitNodes);
    }

    public final boolean dispatchChanges(InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        if (this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, isInBounds)) {
            return this.root.dispatchFinalEventPass(internalPointerEvent) || this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, isInBounds);
        }
        return false;
    }

    public final void clearPreviouslyHitModifierNodeCache() {
        this.root.clear();
    }

    public final void processCancel() {
        this.root.dispatchCancel();
        clearPreviouslyHitModifierNodeCache();
    }

    public final void removeDetachedPointerInputNodes() {
        this.root.removeDetachedPointerInputModifierNodes();
    }
}
