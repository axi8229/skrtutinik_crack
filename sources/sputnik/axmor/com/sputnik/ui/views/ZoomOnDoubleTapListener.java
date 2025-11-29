package sputnik.axmor.com.sputnik.ui.views;

import com.shopgun.android.zoomlayout.ZoomLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ZoomOnDoubleTapListener.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0003\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0003\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/views/ZoomOnDoubleTapListener;", "Lcom/shopgun/android/zoomlayout/ZoomLayout$OnDoubleTapListener;", "", "threeStep", "", "multiplicator", "<init>", "(ZF)V", "Lcom/shopgun/android/zoomlayout/ZoomLayout;", "view", "x", "y", "", "twoStep", "(Lcom/shopgun/android/zoomlayout/ZoomLayout;FF)V", "Lcom/shopgun/android/zoomlayout/ZoomLayout$TapInfo;", "info", "onDoubleTap", "(Lcom/shopgun/android/zoomlayout/ZoomLayout;Lcom/shopgun/android/zoomlayout/ZoomLayout$TapInfo;)Z", "F", "getMultiplicator", "()F", "mThreeStep", "Z", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ZoomOnDoubleTapListener implements ZoomLayout.OnDoubleTapListener {
    private boolean mThreeStep;
    private final float multiplicator;

    public ZoomOnDoubleTapListener(boolean z, float f) {
        this.multiplicator = f;
        this.mThreeStep = z;
    }

    @Override // com.shopgun.android.zoomlayout.ZoomLayout.OnDoubleTapListener
    public boolean onDoubleTap(ZoomLayout view, ZoomLayout.TapInfo info) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(info, "info");
        try {
            if (this.mThreeStep) {
                threeStep(view, info.getX(), info.getY());
            } else {
                twoStep(view, info.getX(), info.getY());
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException unused) {
            return true;
        }
    }

    private final void twoStep(ZoomLayout view, float x, float y) {
        if (view.getScale() > view.getMinScale()) {
            view.setScale(view.getMinScale(), true);
        } else {
            view.setScale(view.getMaxScale() * this.multiplicator, x, y, true);
        }
    }

    private final void threeStep(ZoomLayout view, float x, float y) {
        float scale = view.getScale();
        float minScale = view.getMinScale() + ((view.getMaxScale() - view.getMinScale()) * 0.3f);
        if (scale < minScale) {
            view.setScale(minScale, x, y, true);
        } else if (scale >= minScale && scale < view.getMaxScale()) {
            view.setScale(view.getMaxScale(), x, y, true);
        } else {
            view.setScale(view.getMinScale(), true);
        }
    }
}
