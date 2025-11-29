package ru.yoomoney.sdk.kassa.payments.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.gui.R$id;
import ru.yoomoney.sdk.gui.widget.button.PrimaryButtonView;
import ru.yoomoney.sdk.kassa.payments.ui.color.InMemoryColorSchemeRepository;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/CheckoutAlertDialog;", "Lru/yoomoney/sdk/gui/dialog/YmAlertDialog;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "Companion", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CheckoutAlertDialog extends YmAlertDialog {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DIM_AMOUNT = "DIM_AMOUNT";
    private static final String SHOULD_COLOR_POSITIVE_BUTTON = "SHOULD_COLOR_POSITIVE_BUTTON";
    private static final String TAG = "YmAlertDialog";

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/ui/CheckoutAlertDialog$Companion;", "", "()V", CheckoutAlertDialog.DIM_AMOUNT, "", CheckoutAlertDialog.SHOULD_COLOR_POSITIVE_BUTTON, "TAG", "create", "Lru/yoomoney/sdk/kassa/payments/ui/CheckoutAlertDialog;", "manager", "Landroidx/fragment/app/FragmentManager;", "content", "Lru/yoomoney/sdk/gui/dialog/YmAlertDialog$DialogContent;", "shouldColorPositiveColor", "", "dimAmount", "", "(Landroidx/fragment/app/FragmentManager;Lru/yoomoney/sdk/gui/dialog/YmAlertDialog$DialogContent;ZLjava/lang/Float;)Lru/yoomoney/sdk/kassa/payments/ui/CheckoutAlertDialog;", "getIfShown", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ CheckoutAlertDialog create$default(Companion companion, FragmentManager fragmentManager, YmAlertDialog.DialogContent dialogContent, boolean z, Float f, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                f = null;
            }
            return companion.create(fragmentManager, dialogContent, z, f);
        }

        @JvmStatic
        public final CheckoutAlertDialog create(FragmentManager manager, YmAlertDialog.DialogContent content, boolean shouldColorPositiveColor, Float dimAmount) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(content, "content");
            CheckoutAlertDialog ifShown = getIfShown(manager);
            if (ifShown == null) {
                ifShown = new CheckoutAlertDialog();
                Bundle bundle = new Bundle();
                bundle.putSerializable("content", content);
                bundle.putBoolean(CheckoutAlertDialog.SHOULD_COLOR_POSITIVE_BUTTON, shouldColorPositiveColor);
                if (dimAmount != null) {
                    bundle.putFloat(CheckoutAlertDialog.DIM_AMOUNT, dimAmount.floatValue());
                }
                ifShown.setArguments(bundle);
            }
            return ifShown;
        }

        @JvmStatic
        public final CheckoutAlertDialog getIfShown(FragmentManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            return (CheckoutAlertDialog) manager.findFragmentByTag(CheckoutAlertDialog.TAG);
        }
    }

    @JvmStatic
    public static final CheckoutAlertDialog create(FragmentManager fragmentManager, YmAlertDialog.DialogContent dialogContent, boolean z, Float f) {
        return INSTANCE.create(fragmentManager, dialogContent, z, f);
    }

    @JvmStatic
    public static final CheckoutAlertDialog getIfShown(FragmentManager fragmentManager) {
        return INSTANCE.getIfShown(fragmentManager);
    }

    @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle arguments;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        PrimaryButtonView primaryButtonView = (PrimaryButtonView) viewOnCreateView.findViewById(R$id.button_negative);
        if (primaryButtonView != null) {
            primaryButtonView.setTextColor(InMemoryColorSchemeRepository.INSTANCE.getColorScheme().getPrimaryColor());
        }
        PrimaryButtonView primaryButtonView2 = (PrimaryButtonView) viewOnCreateView.findViewById(R$id.button_positive);
        if (primaryButtonView2 == null || (arguments = getArguments()) == null || !arguments.getBoolean(SHOULD_COLOR_POSITIVE_BUTTON)) {
            primaryButtonView2 = null;
        }
        if (primaryButtonView2 != null) {
            primaryButtonView2.setTextColor(InMemoryColorSchemeRepository.INSTANCE.getColorScheme().getPrimaryColor());
        }
        return viewOnCreateView;
    }

    @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        Bundle arguments = getArguments();
        attributes.dimAmount = arguments != null ? arguments.getFloat(DIM_AMOUNT) : 0.3f;
        attributes.flags |= 2;
        window.setAttributes(attributes);
    }
}
