package androidx.compose.ui.draganddrop;

import kotlin.Metadata;

/* compiled from: DragAndDrop.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "event", "", "onDrop", "(Landroidx/compose/ui/draganddrop/DragAndDropEvent;)Z", "", "onStarted", "(Landroidx/compose/ui/draganddrop/DragAndDropEvent;)V", "onEntered", "onMoved", "onExited", "onEnded", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DragAndDropTarget {
    boolean onDrop(DragAndDropEvent event);

    default void onEnded(DragAndDropEvent event) {
    }

    default void onEntered(DragAndDropEvent event) {
    }

    default void onExited(DragAndDropEvent event) {
    }

    default void onMoved(DragAndDropEvent event) {
    }

    default void onStarted(DragAndDropEvent event) {
    }
}
