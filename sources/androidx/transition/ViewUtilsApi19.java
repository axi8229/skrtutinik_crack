package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
class ViewUtilsApi19 {
    private static boolean sTryHiddenTransitionAlpha = true;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;

    public void clearNonTransitionAlpha(View view) {
    }

    public void saveNonTransitionAlpha(View view) {
    }

    public void setAnimationMatrix(View view, Matrix matrix) {
        throw null;
    }

    @SuppressLint({"BanUncheckedReflection"})
    public void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        throw null;
    }

    public void transformMatrixToGlobal(View view, Matrix matrix) {
        throw null;
    }

    public void transformMatrixToLocal(View view, Matrix matrix) {
        throw null;
    }

    ViewUtilsApi19() {
    }

    @SuppressLint({"NewApi"})
    public void setTransitionAlpha(View view, float f) {
        if (sTryHiddenTransitionAlpha) {
            try {
                Api29Impl.setTransitionAlpha(view, f);
                return;
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        view.setAlpha(f);
    }

    @SuppressLint({"NewApi"})
    public float getTransitionAlpha(View view) {
        if (sTryHiddenTransitionAlpha) {
            try {
                return Api29Impl.getTransitionAlpha(view);
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        return view.getAlpha();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public void setTransitionVisibility(View view, int i) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (!sViewFlagsFieldFetched) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                sViewFlagsField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            sViewFlagsFieldFetched = true;
        }
        Field field = sViewFlagsField;
        if (field != null) {
            try {
                sViewFlagsField.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    static class Api29Impl {
        static void setTransitionAlpha(View view, float f) {
            view.setTransitionAlpha(f);
        }

        static float getTransitionAlpha(View view) {
            return view.getTransitionAlpha();
        }
    }
}
