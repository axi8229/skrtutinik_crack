package androidx.camera.core.resolutionselector;

import android.util.Size;

/* loaded from: classes.dex */
public final class ResolutionStrategy {
    public static final ResolutionStrategy HIGHEST_AVAILABLE_STRATEGY = new ResolutionStrategy();
    private Size mBoundSize;
    private int mFallbackRule;

    private ResolutionStrategy() {
        this.mBoundSize = null;
        this.mFallbackRule = 0;
    }

    public ResolutionStrategy(Size size, int i) {
        this.mBoundSize = size;
        this.mFallbackRule = i;
    }

    public Size getBoundSize() {
        return this.mBoundSize;
    }

    public int getFallbackRule() {
        return this.mFallbackRule;
    }
}
