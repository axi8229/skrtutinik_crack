package ru.yoomoney.sdk.gui.utils.extensions;

import android.view.ViewGroup;
import android.view.WindowInsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewGroupExtensions.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/view/ViewGroup;", "Landroid/view/WindowInsets;", "insets", "dispatchWindowInsets", "(Landroid/view/ViewGroup;Landroid/view/WindowInsets;)Landroid/view/WindowInsets;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewGroupExtensionsKt {
    public static final WindowInsets dispatchWindowInsets(ViewGroup viewGroup, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).dispatchApplyWindowInsets(insets);
        }
        return insets;
    }
}
