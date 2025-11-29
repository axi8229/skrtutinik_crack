package ru.yoomoney.sdk.gui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.push.constant.RemoteMessageConst;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.base.BaseNoTitleDialogFragment;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.widget.button.PrimaryButtonView;

/* compiled from: YmAlertDialog.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 (2\u00020\u0001:\u0003()*B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\u001a\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\nJ\u000e\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006+"}, d2 = {"Lru/yoomoney/sdk/gui/dialog/YmAlertDialog;", "Lru/yoomoney/sdk/gui/base/BaseNoTitleDialogFragment;", "()V", "additionalContentView", "Landroid/view/View;", "dialogView", "Lru/yoomoney/sdk/gui/dialog/YmAlertDialogView;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/yoomoney/sdk/gui/dialog/YmAlertDialog$DialogListener;", "negativeButtonTextColor", "", "Ljava/lang/Integer;", "positiveButtonTextColor", "attachListener", "", "detachListener", "initAdditionalContent", "initButtons", "content", "Lru/yoomoney/sdk/gui/dialog/YmAlertDialog$DialogContent;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onStart", "onViewCreated", "view", "setAdditionalContentView", "setNegativeButtonColor", RemoteMessageConst.Notification.COLOR, "setPositiveButtonColor", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "Companion", "DialogContent", "DialogListener", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class YmAlertDialog extends BaseNoTitleDialogFragment {
    public static final String CONTENT_KEY = "content";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "YmAlertDialog";
    private View additionalContentView;
    private YmAlertDialogView dialogView;
    private DialogListener listener;
    private Integer negativeButtonTextColor;
    private Integer positiveButtonTextColor;

    /* compiled from: YmAlertDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"Lru/yoomoney/sdk/gui/dialog/YmAlertDialog$DialogListener;", "", "onDismiss", "", "onNegativeClick", "onPositiveClick", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface DialogListener {

        /* compiled from: YmAlertDialog.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onDismiss(DialogListener dialogListener) {
            }

            public static void onNegativeClick(DialogListener dialogListener) {
            }
        }

        void onDismiss();

        void onNegativeClick();

        void onPositiveClick();
    }

    @JvmStatic
    public static final YmAlertDialog create(FragmentManager fragmentManager, DialogContent dialogContent) {
        return INSTANCE.create(fragmentManager, dialogContent);
    }

    @JvmStatic
    public static final YmAlertDialog getIfShown(FragmentManager fragmentManager) {
        return INSTANCE.getIfShown(fragmentManager);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        YmAlertDialogView ymAlertDialogView = new YmAlertDialogView(contextRequireContext, null, 2, 0 == true ? 1 : 0);
        this.dialogView = ymAlertDialogView;
        return ymAlertDialogView;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        Bundle arguments = getArguments();
        YmAlertDialogView ymAlertDialogView = null;
        Serializable serializable = arguments != null ? arguments.getSerializable("content") : null;
        DialogContent dialogContent = serializable instanceof DialogContent ? (DialogContent) serializable : null;
        if (dialogContent != null) {
            YmAlertDialogView ymAlertDialogView2 = this.dialogView;
            if (ymAlertDialogView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogView");
                ymAlertDialogView2 = null;
            }
            AppCompatTextView titleView = ymAlertDialogView2.getTitleView();
            String title = dialogContent.getTitle();
            ViewExtensions.setVisible(titleView, !(title == null || title.length() == 0));
            YmAlertDialogView ymAlertDialogView3 = this.dialogView;
            if (ymAlertDialogView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogView");
                ymAlertDialogView3 = null;
            }
            ymAlertDialogView3.getTitleView().setText(dialogContent.getTitle());
            YmAlertDialogView ymAlertDialogView4 = this.dialogView;
            if (ymAlertDialogView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogView");
                ymAlertDialogView4 = null;
            }
            AppCompatTextView messageView = ymAlertDialogView4.getMessageView();
            String content = dialogContent.getContent();
            ViewExtensions.setVisible(messageView, !(content == null || content.length() == 0));
            YmAlertDialogView ymAlertDialogView5 = this.dialogView;
            if (ymAlertDialogView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogView");
            } else {
                ymAlertDialogView = ymAlertDialogView5;
            }
            ymAlertDialogView.getMessageView().setText(dialogContent.getContent());
            initButtons(dialogContent);
            initAdditionalContent();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        DialogListener dialogListener = this.listener;
        if (dialogListener != null) {
            dialogListener.onDismiss();
        }
    }

    public final void attachListener(DialogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void detachListener() {
        this.listener = null;
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        manager.executePendingTransactions();
        Fragment fragmentFindFragmentByTag = manager.findFragmentByTag(TAG);
        if (fragmentFindFragmentByTag != null && fragmentFindFragmentByTag.isAdded() && (fragmentFindFragmentByTag instanceof YmAlertDialog)) {
            ((YmAlertDialog) fragmentFindFragmentByTag).dismissAllowingStateLoss();
        }
        super.show(manager, TAG);
    }

    public final void setNegativeButtonColor(int color) {
        this.negativeButtonTextColor = Integer.valueOf(color);
    }

    public final void setPositiveButtonColor(int color) {
        this.positiveButtonTextColor = Integer.valueOf(color);
    }

    public final void setAdditionalContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.additionalContentView = view;
    }

    private final void initButtons(DialogContent content) {
        PrimaryButtonView buttonPositive;
        PrimaryButtonView buttonNegative;
        YmAlertDialogView ymAlertDialogView = this.dialogView;
        if (ymAlertDialogView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogView");
            ymAlertDialogView = null;
        }
        if (content.getIsPositiveActionAlert()) {
            buttonPositive = ymAlertDialogView.getButtonPositiveAlert();
        } else {
            buttonPositive = ymAlertDialogView.getButtonPositive();
        }
        ViewExtensions.setVisible(buttonPositive, content.getActionPositiveText() != null);
        String actionPositiveText = content.getActionPositiveText();
        if (actionPositiveText != null) {
            buttonPositive.setText(actionPositiveText);
            buttonPositive.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.gui.dialog.YmAlertDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YmAlertDialog.initButtons$lambda$10$lambda$5$lambda$3$lambda$2(this.f$0, view);
                }
            });
        }
        Integer num = this.positiveButtonTextColor;
        if (num != null) {
            buttonPositive.setTextColor(num.intValue());
        }
        if (content.getIsNegativeActionAlert()) {
            buttonNegative = ymAlertDialogView.getButtonNegativeAlert();
        } else {
            buttonNegative = ymAlertDialogView.getButtonNegative();
        }
        ViewExtensions.setVisible(buttonNegative, content.getActionNegativeText() != null);
        String actionNegativeText = content.getActionNegativeText();
        if (actionNegativeText != null) {
            buttonNegative.setText(actionNegativeText);
            buttonNegative.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.gui.dialog.YmAlertDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YmAlertDialog.initButtons$lambda$10$lambda$9$lambda$7$lambda$6(this.f$0, view);
                }
            });
        }
        Integer num2 = this.negativeButtonTextColor;
        if (num2 != null) {
            buttonNegative.setTextColor(num2.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtons$lambda$10$lambda$5$lambda$3$lambda$2(YmAlertDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogListener dialogListener = this$0.listener;
        if (dialogListener != null) {
            dialogListener.onPositiveClick();
        }
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtons$lambda$10$lambda$9$lambda$7$lambda$6(YmAlertDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogListener dialogListener = this$0.listener;
        if (dialogListener != null) {
            dialogListener.onNegativeClick();
        }
        this$0.dismiss();
    }

    private final void initAdditionalContent() {
        View view = this.additionalContentView;
        if (view != null) {
            YmAlertDialogView ymAlertDialogView = this.dialogView;
            if (ymAlertDialogView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogView");
                ymAlertDialogView = null;
            }
            ymAlertDialogView.getAdditionalContentView().addView(view);
        }
    }

    /* compiled from: YmAlertDialog.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/gui/dialog/YmAlertDialog$Companion;", "", "()V", "CONTENT_KEY", "", "TAG", "create", "Lru/yoomoney/sdk/gui/dialog/YmAlertDialog;", "manager", "Landroidx/fragment/app/FragmentManager;", "content", "Lru/yoomoney/sdk/gui/dialog/YmAlertDialog$DialogContent;", "getIfShown", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final YmAlertDialog create(FragmentManager manager, DialogContent content) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(content, "content");
            YmAlertDialog ifShown = getIfShown(manager);
            if (ifShown != null) {
                return ifShown;
            }
            YmAlertDialog ymAlertDialog = new YmAlertDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("content", content);
            ymAlertDialog.setArguments(bundle);
            return ymAlertDialog;
        }

        @JvmStatic
        public final YmAlertDialog getIfShown(FragmentManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            return (YmAlertDialog) manager.findFragmentByTag(YmAlertDialog.TAG);
        }
    }

    /* compiled from: YmAlertDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001BK\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/gui/dialog/YmAlertDialog$DialogContent;", "Ljava/io/Serializable;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "content", "actionPositiveText", "actionNegativeText", "isPositiveActionAlert", "", "isNegativeActionAlert", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getActionNegativeText", "()Ljava/lang/String;", "getActionPositiveText", "getContent", "()Z", "getTitle", "ru.yoomoney.sdk.gui.ui-lib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DialogContent implements Serializable {
        private final String actionNegativeText;
        private final String actionPositiveText;
        private final String content;
        private final boolean isNegativeActionAlert;
        private final boolean isPositiveActionAlert;
        private final String title;

        public DialogContent() {
            this(null, null, null, null, false, false, 63, null);
        }

        public DialogContent(String str, String str2, String str3, String str4, boolean z, boolean z2) {
            this.title = str;
            this.content = str2;
            this.actionPositiveText = str3;
            this.actionNegativeText = str4;
            this.isPositiveActionAlert = z;
            this.isNegativeActionAlert = z2;
        }

        public /* synthetic */ DialogContent(String str, String str2, String str3, String str4, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) == 0 ? str4 : null, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getActionPositiveText() {
            return this.actionPositiveText;
        }

        public final String getActionNegativeText() {
            return this.actionNegativeText;
        }

        /* renamed from: isPositiveActionAlert, reason: from getter */
        public final boolean getIsPositiveActionAlert() {
            return this.isPositiveActionAlert;
        }

        /* renamed from: isNegativeActionAlert, reason: from getter */
        public final boolean getIsNegativeActionAlert() {
            return this.isNegativeActionAlert;
        }
    }
}
