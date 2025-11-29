package ru.yoomoney.sdk.kassa.payments.extensions;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.R$id;
import com.google.android.material.snackbar.Snackbar;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$dimen;

/* loaded from: classes5.dex */
public abstract class l {
    public static final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        InputMethodManager inputMethodManager = (InputMethodManager) (context != null ? context.getSystemService("input_method") : null);
        if (inputMethodManager == null || !inputMethodManager.isActive()) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static final void a(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(z ? 0 : 8);
    }

    public static final void a(View view, String message, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Snackbar snackbarMake = Snackbar.make(view, message, -1);
        Intrinsics.checkNotNullExpressionValue(snackbarMake, "make(...)");
        snackbarMake.getView().setElevation(view.getResources().getDimension(R$dimen.ym_elevationL));
        ((TextView) snackbarMake.getView().findViewById(R$id.snackbar_text)).setTextColor(ContextCompat.getColor(snackbarMake.getContext(), i));
        snackbarMake.getView().setBackgroundColor(ContextCompat.getColor(snackbarMake.getView().getContext(), i2));
        snackbarMake.show();
    }
}
