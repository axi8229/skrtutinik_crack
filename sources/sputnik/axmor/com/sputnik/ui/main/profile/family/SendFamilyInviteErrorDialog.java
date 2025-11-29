package sputnik.axmor.com.sputnik.ui.main.profile.family;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBinding;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.FamilyEvents;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.WindowUtilsKt;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.DialogSendFamilyInviteErrorBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: SendFamilyInviteErrorDialog.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u0003R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00060"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/family/SendFamilyInviteErrorDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onStart", "Landroidx/viewbinding/ViewBinding;", "_binding", "Landroidx/viewbinding/ViewBinding;", "", "title$delegate", "Lkotlin/Lazy;", "getTitle", "()Ljava/lang/String;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle$delegate", "getSubtitle", "subtitle", "buttonText$delegate", "getButtonText", "buttonText", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lsputnik/axmor/com/databinding/DialogSendFamilyInviteErrorBinding;", "getBinding", "()Lsputnik/axmor/com/databinding/DialogSendFamilyInviteErrorBinding;", "binding", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendFamilyInviteErrorDialog extends DialogFragment {
    private ViewBinding _binding;
    public Analytics analytics;
    public LocalizationStorage localizationScreen;

    /* renamed from: title$delegate, reason: from kotlin metadata */
    private final Lazy title = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.SendFamilyInviteErrorDialog$title$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getString(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE);
            }
            return null;
        }
    });

    /* renamed from: subtitle$delegate, reason: from kotlin metadata */
    private final Lazy subtitle = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.SendFamilyInviteErrorDialog$subtitle$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getString("subtitle");
            }
            return null;
        }
    });

    /* renamed from: buttonText$delegate, reason: from kotlin metadata */
    private final Lazy buttonText = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.SendFamilyInviteErrorDialog$buttonText$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getString("button_text");
            }
            return null;
        }
    });

    private final DialogSendFamilyInviteErrorBinding getBinding() {
        ViewBinding viewBinding = this._binding;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.DialogSendFamilyInviteErrorBinding");
        return (DialogSendFamilyInviteErrorBinding) viewBinding;
    }

    private final String getTitle() {
        return (String) this.title.getValue();
    }

    private final String getSubtitle() {
        return (String) this.subtitle.getValue();
    }

    private final String getButtonText() {
        return (String) this.buttonText.getValue();
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this._binding = DialogSendFamilyInviteErrorBinding.inflate(getLayoutInflater(), null, false);
        getAnalytics().trackLogEvent(new FamilyEvents.ShowInviteToTheFamilyErrorScreen());
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(getBinding().getRoot()).create();
        setStyle(2, 0);
        if (alertDialogCreate != null && alertDialogCreate.getWindow() != null) {
            Window window = alertDialogCreate.getWindow();
            Intrinsics.checkNotNull(window);
            window.setBackgroundDrawable(new ColorDrawable(0));
            Window window2 = alertDialogCreate.getWindow();
            Intrinsics.checkNotNull(window2);
            WindowUtilsKt.requestFeatureSafe(window2, 1);
        }
        alertDialogCreate.setCanceledOnTouchOutside(true);
        DialogSendFamilyInviteErrorBinding binding = getBinding();
        binding.dialogTitle.setText(getTitle());
        binding.dialogNotice.setText(getSubtitle());
        binding.btnComplete.setText(getButtonText());
        binding.btnComplete.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.SendFamilyInviteErrorDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "apply(...)");
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, -2);
    }
}
