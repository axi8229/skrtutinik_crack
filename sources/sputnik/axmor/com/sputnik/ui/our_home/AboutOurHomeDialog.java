package sputnik.axmor.com.sputnik.ui.our_home;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.viewbinding.ViewBinding;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.our_home.OurHomeUpdatePopup;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.WindowUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.OnboardingViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.DialogAboutOurHomeBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: AboutOurHomeDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020:8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/our_home/AboutOurHomeDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Landroidx/viewbinding/ViewBinding;", "_binding", "Landroidx/viewbinding/ViewBinding;", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel$delegate", "Lkotlin/Lazy;", "getOnboardingViewModel", "()Lcom/sputnik/common/viewmodels/OnboardingViewModel;", "onboardingViewModel", "", "isOnboardingParamsLocked", "Z", "Lsputnik/axmor/com/databinding/DialogAboutOurHomeBinding;", "getBinding", "()Lsputnik/axmor/com/databinding/DialogAboutOurHomeBinding;", "binding", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AboutOurHomeDialog extends DialogFragment {
    private ViewBinding _binding;
    public Analytics analytics;
    public MultiViewModelFactory factory;
    private boolean isOnboardingParamsLocked;
    public LocalizationStorage localizationStorage;

    /* renamed from: onboardingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy onboardingViewModel;

    private final DialogAboutOurHomeBinding getBinding() {
        ViewBinding viewBinding = this._binding;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.DialogAboutOurHomeBinding");
        return (DialogAboutOurHomeBinding) viewBinding;
    }

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
        return null;
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final OnboardingViewModel getOnboardingViewModel() {
        return (OnboardingViewModel) this.onboardingViewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this._binding = DialogAboutOurHomeBinding.inflate(getLayoutInflater(), null, false);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(getBinding().getRoot()).create();
        if (alertDialogCreate != null && alertDialogCreate.getWindow() != null) {
            Window window = alertDialogCreate.getWindow();
            Intrinsics.checkNotNull(window);
            window.setBackgroundDrawable(new ColorDrawable(0));
            Window window2 = alertDialogCreate.getWindow();
            Intrinsics.checkNotNull(window2);
            WindowUtilsKt.requestFeatureSafe(window2, 1);
        }
        alertDialogCreate.setCanceledOnTouchOutside(false);
        localize();
        initView();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "apply(...)");
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getOnboardingViewModel().delayOnboardingToOurHome();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    private final void initView() {
        DialogAboutOurHomeBinding binding = getBinding();
        binding.btnApply.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.our_home.AboutOurHomeDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutOurHomeDialog.initView$lambda$3$lambda$1(this.f$0, view);
            }
        });
        binding.btnDismiss.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.our_home.AboutOurHomeDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutOurHomeDialog.initView$lambda$3$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$1(AboutOurHomeDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getOnboardingViewModel().lockOnboardingToOurHome();
        this$0.isOnboardingParamsLocked = true;
        this$0.dismiss();
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R.id.action_to_our_home_update, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(AboutOurHomeDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getOnboardingViewModel().delayOnboardingToOurHome();
        this$0.dismiss();
    }

    private final void localize() {
        TextTitle laterButton;
        TextTitle okButton;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String title = null;
        OurHomeUpdatePopup ourHomeUpdatePopup = data != null ? data.getOurHomeUpdatePopup() : null;
        DialogAboutOurHomeBinding binding = getBinding();
        binding.tvTitle.setText(ourHomeUpdatePopup != null ? ourHomeUpdatePopup.getTitle() : null);
        binding.tvSubtitle.setText(ourHomeUpdatePopup != null ? ourHomeUpdatePopup.getBody() : null);
        binding.btnApply.setText((ourHomeUpdatePopup == null || (okButton = ourHomeUpdatePopup.getOkButton()) == null) ? null : okButton.getTitle());
        AppCompatButton appCompatButton = binding.btnDismiss;
        if (ourHomeUpdatePopup != null && (laterButton = ourHomeUpdatePopup.getLaterButton()) != null) {
            title = laterButton.getTitle();
        }
        appCompatButton.setText(title);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.isOnboardingParamsLocked) {
            return;
        }
        getOnboardingViewModel().delayOnboardingToOurHome();
    }

    public AboutOurHomeDialog() {
        final Function0 function0 = null;
        this.onboardingViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OnboardingViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.our_home.AboutOurHomeDialog$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.our_home.AboutOurHomeDialog$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.our_home.AboutOurHomeDialog$onboardingViewModel$2
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
