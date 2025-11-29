package androidx.core.view.accessibility;

import android.annotation.SuppressLint;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public final class AccessibilityEventCompat {
    public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }

    @SuppressLint({"WrongConstant"})
    public static int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }
}
