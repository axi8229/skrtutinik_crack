package ru.yoomoney.sdk.gui.widgetV2.dialog;

import android.app.Dialog;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetDialogExtentions.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "getBehavior", "(Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "ru.yoomoney.sdk.gui.ui-lib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BottomSheetDialogExtentionsKt {
    public static final BottomSheetBehavior<FrameLayout> getBehavior(BottomSheetDialogFragment bottomSheetDialogFragment) {
        Intrinsics.checkNotNullParameter(bottomSheetDialogFragment, "<this>");
        Dialog dialog = bottomSheetDialogFragment.getDialog();
        Intrinsics.checkNotNull(dialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        BottomSheetBehavior<FrameLayout> behavior = ((BottomSheetDialog) dialog).getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "getBehavior(...)");
        return behavior;
    }
}
