package ru.yoomoney.sdk.auth.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialogView;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/ui/AlertDialog;", "Lru/yoomoney/sdk/gui/dialog/YmAlertDialog;", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AlertDialog extends YmAlertDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "AlertDialog";

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/ui/AlertDialog$Companion;", "", "()V", "TAG", "", "create", "Lru/yoomoney/sdk/auth/ui/AlertDialog;", "manager", "Landroidx/fragment/app/FragmentManager;", "content", "Lru/yoomoney/sdk/gui/dialog/YmAlertDialog$DialogContent;", "getIfShown", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AlertDialog create(FragmentManager manager, YmAlertDialog.DialogContent content) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(content, "content");
            AlertDialog ifShown = getIfShown(manager);
            if (ifShown != null) {
                return ifShown;
            }
            AlertDialog alertDialog = new AlertDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("content", content);
            alertDialog.setArguments(bundle);
            return alertDialog;
        }

        @JvmStatic
        public final AlertDialog getIfShown(FragmentManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            return (AlertDialog) manager.findFragmentByTag(AlertDialog.TAG);
        }
    }

    @JvmStatic
    public static final AlertDialog create(FragmentManager fragmentManager, YmAlertDialog.DialogContent dialogContent) {
        return INSTANCE.create(fragmentManager, dialogContent);
    }

    @JvmStatic
    public static final AlertDialog getIfShown(FragmentManager fragmentManager) {
        return INSTANCE.getIfShown(fragmentManager);
    }

    @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        YmAlertDialogView ymAlertDialogView = (YmAlertDialogView) view;
        ru.yoomoney.sdk.gui.widget.button.FlatButtonView buttonPositive = ymAlertDialogView.getButtonPositive();
        ColorScheme colorScheme = ColorScheme.INSTANCE;
        Context context = ymAlertDialogView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        buttonPositive.setTextColor(colorScheme.typeColorStateList(context));
        ru.yoomoney.sdk.gui.widget.button.FlatButtonView buttonNegative = ymAlertDialogView.getButtonNegative();
        Context context2 = ymAlertDialogView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        buttonNegative.setTextColor(colorScheme.typeColorStateList(context2));
    }
}
