package ru.yoomoney.sdk.gui.utils.extensions;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewExtensions.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\f\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\f\u0010\u000b\u001a\u0019\u0010\u000f\u001a\u00020\r*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroid/view/View;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "removeOnGlobalLayoutListener", "(Landroid/view/View;Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V", "", "visible", "setVisible", "(Landroid/view/View;Z)V", "show", "(Landroid/view/View;)V", "hide", "", "res", "getDimensionPixelOffset", "(Landroid/view/View;I)I", "ru.yoomoney.sdk.gui.ui-lib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewExtensions {
    public static final void removeOnGlobalLayoutListener(View view, ViewTreeObserver.OnGlobalLayoutListener listener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        view.getViewTreeObserver().removeOnGlobalLayoutListener(listener);
    }

    public static final void setVisible(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(z ? 0 : 8);
    }

    public static final void show(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        setVisible(view, true);
    }

    public static final void hide(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        setVisible(view, false);
    }

    public static final int getDimensionPixelOffset(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getContext().getResources().getDimensionPixelOffset(i);
    }
}
