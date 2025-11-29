package npi.spay;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.v0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1977v0 {
    public static final int a(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static final int b(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDimensionPixelSize(i);
    }

    public static final void a(FragmentActivity fragmentActivity, View view) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        Object systemService = fragmentActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static final void a(Context context, View view) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.requestFocus()) {
            Object systemService = context.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).showSoftInput(view, 1);
        }
    }
}
