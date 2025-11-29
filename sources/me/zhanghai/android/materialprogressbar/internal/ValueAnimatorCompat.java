package me.zhanghai.android.materialprogressbar.internal;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class ValueAnimatorCompat {
    private static Method sValueAnimatorGetDurationScaleMethod;
    private static boolean sValueAnimatorGetDurationScaleMethodInitialized;
    private static Field sValueAnimatorSDurationScaleField;
    private static boolean sValueAnimatorSDurationScaleFieldInitialized;
    private static final Object sValueAnimatorGetDurationScaleMethodLock = new Object();
    private static final Object sValueAnimatorSDurationScaleFieldLock = new Object();

    private ValueAnimatorCompat() {
    }

    public static boolean areAnimatorsEnabled() {
        if (Build.VERSION.SDK_INT >= 26) {
            return ValueAnimator.areAnimatorsEnabled();
        }
        Method valueAnimatorGetDurationScaleMethod = getValueAnimatorGetDurationScaleMethod();
        if (valueAnimatorGetDurationScaleMethod != null) {
            try {
                return ((Float) valueAnimatorGetDurationScaleMethod.invoke(null, null)).floatValue() != 0.0f;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Field valueAnimatorSDurationScaleField = getValueAnimatorSDurationScaleField();
        if (valueAnimatorSDurationScaleField != null) {
            try {
                return ((Float) valueAnimatorSDurationScaleField.get(null)).floatValue() != 0.0f;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    @SuppressLint({"PrivateApi"})
    private static Method getValueAnimatorGetDurationScaleMethod() {
        Method method;
        synchronized (sValueAnimatorGetDurationScaleMethodLock) {
            if (!sValueAnimatorGetDurationScaleMethodInitialized) {
                try {
                    Method declaredMethod = ValueAnimator.class.getDeclaredMethod("getDurationScale", null);
                    sValueAnimatorGetDurationScaleMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sValueAnimatorGetDurationScaleMethodInitialized = true;
                method = sValueAnimatorGetDurationScaleMethod;
            } else {
                method = sValueAnimatorGetDurationScaleMethod;
            }
        }
        return method;
    }

    private static Field getValueAnimatorSDurationScaleField() {
        Field field;
        synchronized (sValueAnimatorSDurationScaleFieldLock) {
            if (!sValueAnimatorSDurationScaleFieldInitialized) {
                try {
                    Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                    sValueAnimatorSDurationScaleField = declaredField;
                    declaredField.setAccessible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sValueAnimatorSDurationScaleFieldInitialized = true;
                field = sValueAnimatorSDurationScaleField;
            } else {
                field = sValueAnimatorSDurationScaleField;
            }
        }
        return field;
    }
}
