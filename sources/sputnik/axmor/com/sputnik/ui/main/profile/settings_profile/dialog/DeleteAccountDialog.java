package sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.gms.common.Scopes;
import com.sputnik.common.base.BaseDialog;
import com.sputnik.common.databinding.DialogBaseBinding;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.ProfileSettingsDeletePopUp;
import com.sputnik.common.entities.localization.ProfileSettingsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: DeleteAccountDialog.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/settings_profile/dialog/DeleteAccountDialog;", "Lcom/sputnik/common/base/BaseDialog;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeleteAccountDialog extends BaseDialog {
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.BaseDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProfileSettingsLocale profileSettings;
        ProfileSettingsDeletePopUp deletePopup;
        TextTitle yesButton;
        ProfileSettingsLocale profileSettings2;
        ProfileSettingsDeletePopUp deletePopup2;
        TextTitle cancelButton;
        ProfileSettingsLocale profileSettings3;
        ProfileSettingsDeletePopUp deletePopup3;
        ProfileSettingsLocale profileSettings4;
        ProfileSettingsDeletePopUp deletePopup4;
        final Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        SputnikApp.INSTANCE.getAnalyticsService().send(Scopes.PROFILE, "delete_account_modal", "show");
        DialogBaseBinding binding = getBinding();
        TextView textView = binding.dialogTitle;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = null;
        textView.setText((data == null || (profileSettings4 = data.getProfileSettings()) == null || (deletePopup4 = profileSettings4.getDeletePopup()) == null) ? null : deletePopup4.getTitle());
        TextView textView2 = binding.dialogNotice;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        textView2.setText((data2 == null || (profileSettings3 = data2.getProfileSettings()) == null || (deletePopup3 = profileSettings3.getDeletePopup()) == null) ? null : deletePopup3.getSubtitle());
        TextView textView3 = binding.btnReject;
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        textView3.setText((data3 == null || (profileSettings2 = data3.getProfileSettings()) == null || (deletePopup2 = profileSettings2.getDeletePopup()) == null || (cancelButton = deletePopup2.getCancelButton()) == null) ? null : cancelButton.getTitle());
        TextView textView4 = binding.btnAccept;
        LocalizationLocalModel data4 = getLocalizationScreen().getData();
        if (data4 != null && (profileSettings = data4.getProfileSettings()) != null && (deletePopup = profileSettings.getDeletePopup()) != null && (yesButton = deletePopup.getYesButton()) != null) {
            title = yesButton.getTitle();
        }
        textView4.setText(title);
        binding.btnReject.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.dialog.DeleteAccountDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeleteAccountDialog.onCreateDialog$lambda$2$lambda$1$lambda$0(dialogOnCreateDialog, view);
            }
        });
        TextView btnAccept = binding.btnAccept;
        Intrinsics.checkNotNullExpressionValue(btnAccept, "btnAccept");
        SafeClickListenerKt.setSafeOnClickListener$default(btnAccept, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.dialog.DeleteAccountDialog$onCreateDialog$1$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getProfileViewModel().deleteAccount();
                SputnikApp.INSTANCE.getAnalyticsService().send(Scopes.PROFILE, "delete_account_modal", "delete");
                dialogOnCreateDialog.dismiss();
            }
        }, 1, null);
        return dialogOnCreateDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$2$lambda$1$lambda$0(Dialog this_apply, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        SputnikApp.INSTANCE.getAnalyticsService().send(Scopes.PROFILE, "delete_account_modal", "cancel");
        this_apply.dismiss();
    }

    public DeleteAccountDialog() {
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.dialog.DeleteAccountDialog$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.dialog.DeleteAccountDialog$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? this.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.dialog.DeleteAccountDialog$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
    }
}
