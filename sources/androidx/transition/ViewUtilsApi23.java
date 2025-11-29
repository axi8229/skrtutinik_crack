package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
class ViewUtilsApi23 extends ViewUtilsApi22 {
    private static boolean sTryHiddenSetTransitionVisibility = true;

    ViewUtilsApi23() {
    }

    @Override // androidx.transition.ViewUtilsApi19
    @SuppressLint({"NewApi"})
    public void setTransitionVisibility(View view, int i) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT == 28) {
            super.setTransitionVisibility(view, i);
        } else if (sTryHiddenSetTransitionVisibility) {
            try {
                Api29Impl.setTransitionVisibility(view, i);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetTransitionVisibility = false;
            }
        }
    }

    static class Api29Impl {
        static void setTransitionVisibility(View view, int i) {
            view.setTransitionVisibility(i);
        }
    }
}
