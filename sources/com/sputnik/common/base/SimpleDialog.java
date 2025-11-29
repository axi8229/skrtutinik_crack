package com.sputnik.common.base;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBinding;
import com.sputnik.common.utils.WindowUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleDialog.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/sputnik/common/base/SimpleDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "Companion", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SimpleDialog extends DialogFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: SimpleDialog.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\u0003\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u00050\n2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00040\u000f¨\u0006\u0011"}, d2 = {"Lcom/sputnik/common/base/SimpleDialog$Companion;", "", "()V", "newInstance", "", "V", "Landroidx/viewbinding/ViewBinding;", "context", "Landroid/content/Context;", "bindingInflater", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "bindingViews", "Lkotlin/Function2;", "Landroid/app/AlertDialog;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <V extends ViewBinding> void newInstance(Context context, Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends V> bindingInflater, Function2<? super AlertDialog, ? super V, Unit> bindingViews) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(bindingInflater, "bindingInflater");
            Intrinsics.checkNotNullParameter(bindingViews, "bindingViews");
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
            Intrinsics.checkNotNullExpressionValue(layoutInflaterFrom, "from(...)");
            V vInvoke = bindingInflater.invoke(layoutInflaterFrom, null, Boolean.FALSE);
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setView(vInvoke.getRoot());
            AlertDialog alertDialogCreate = builder.create();
            Intrinsics.checkNotNull(alertDialogCreate);
            bindingViews.invoke(alertDialogCreate, vInvoke);
            if (alertDialogCreate.getWindow() != null) {
                Window window = alertDialogCreate.getWindow();
                Intrinsics.checkNotNull(window);
                window.setBackgroundDrawable(new ColorDrawable(0));
                Window window2 = alertDialogCreate.getWindow();
                Intrinsics.checkNotNull(window2);
                WindowUtilsKt.requestFeatureSafe(window2, 1);
            }
            alertDialogCreate.setCanceledOnTouchOutside(false);
            alertDialogCreate.show();
        }
    }
}
