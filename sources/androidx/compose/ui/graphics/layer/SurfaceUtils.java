package androidx.compose.ui.graphics.layer;

import kotlin.Metadata;

/* compiled from: LayerSnapshot.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/layer/SurfaceUtils;", "", "<init>", "()V", "", "isLockHardwareCanvasAvailable", "()Z", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SurfaceUtils {
    public static final SurfaceUtils INSTANCE = new SurfaceUtils();

    public final boolean isLockHardwareCanvasAvailable() {
        return true;
    }

    private SurfaceUtils() {
    }
}
