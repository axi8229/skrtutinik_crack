package androidx.compose.ui.graphics.layer;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChildLayerDependenciesTracker.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "", "<init>", "()V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "graphicsLayer", "", "onDependencyAdded", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)Z", "dependency", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "oldDependency", "Landroidx/collection/MutableScatterSet;", "dependenciesSet", "Landroidx/collection/MutableScatterSet;", "oldDependenciesSet", "trackingInProgress", "Z", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChildLayerDependenciesTracker {
    private MutableScatterSet<GraphicsLayer> dependenciesSet;
    private GraphicsLayer dependency;
    private MutableScatterSet<GraphicsLayer> oldDependenciesSet;
    private GraphicsLayer oldDependency;
    private boolean trackingInProgress;

    public final boolean onDependencyAdded(GraphicsLayer graphicsLayer) {
        if (!this.trackingInProgress) {
            InlineClassHelperKt.throwIllegalArgumentException("Only add dependencies during a tracking");
        }
        MutableScatterSet<GraphicsLayer> mutableScatterSet = this.dependenciesSet;
        if (mutableScatterSet != null) {
            Intrinsics.checkNotNull(mutableScatterSet);
            mutableScatterSet.add(graphicsLayer);
        } else if (this.dependency != null) {
            MutableScatterSet<GraphicsLayer> mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            GraphicsLayer graphicsLayer2 = this.dependency;
            Intrinsics.checkNotNull(graphicsLayer2);
            mutableScatterSetMutableScatterSetOf.add(graphicsLayer2);
            mutableScatterSetMutableScatterSetOf.add(graphicsLayer);
            this.dependenciesSet = mutableScatterSetMutableScatterSetOf;
            this.dependency = null;
        } else {
            this.dependency = graphicsLayer;
        }
        MutableScatterSet<GraphicsLayer> mutableScatterSet2 = this.oldDependenciesSet;
        if (mutableScatterSet2 != null) {
            Intrinsics.checkNotNull(mutableScatterSet2);
            return !mutableScatterSet2.remove(graphicsLayer);
        }
        if (this.oldDependency != graphicsLayer) {
            return true;
        }
        this.oldDependency = null;
        return false;
    }
}
