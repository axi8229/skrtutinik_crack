package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public final class SessionProcessorSurface extends DeferrableSurface {
    private final Surface mSurface;

    @Override // androidx.camera.core.impl.DeferrableSurface
    public ListenableFuture<Surface> provideSurface() {
        return Futures.immediateFuture(this.mSurface);
    }
}
