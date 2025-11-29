package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Size;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.impl.utils.Threads;

/* loaded from: classes.dex */
class PreviewViewMeteringPointFactory extends MeteringPointFactory {
    static final PointF INVALID_POINT = new PointF(2.0f, 2.0f);
    private Matrix mMatrix;
    private final PreviewTransformation mPreviewTransformation;

    PreviewViewMeteringPointFactory(PreviewTransformation previewTransformation) {
        this.mPreviewTransformation = previewTransformation;
    }

    void recalculate(Size size, int i) {
        Threads.checkMainThread();
        synchronized (this) {
            try {
                if (size.getWidth() != 0 && size.getHeight() != 0) {
                    this.mMatrix = this.mPreviewTransformation.getPreviewViewToNormalizedSurfaceMatrix(size, i);
                    return;
                }
                this.mMatrix = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
