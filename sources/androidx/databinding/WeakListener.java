package androidx.databinding;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class WeakListener<T> extends WeakReference<ViewDataBinding> {
    private T mTarget;

    public boolean unregister() {
        if (this.mTarget != null) {
            throw null;
        }
        this.mTarget = null;
        return false;
    }
}
