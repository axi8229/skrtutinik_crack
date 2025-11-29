package sputnik.axmor.com.sputnik.ui.gorserv;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBinding;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.GorservEvents;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.WindowUtilsKt;
import com.sputnik.common.viewmodels.GorservViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sputnik.axmor.com.databinding.DialogGorservErrorBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: GorservErrorDialog.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0003R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u0002028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/gorserv/GorservErrorDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onDestroy", "Landroidx/viewbinding/ViewBinding;", "_binding", "Landroidx/viewbinding/ViewBinding;", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/GorservViewModel;", "gorservViewModel$delegate", "Lkotlin/Lazy;", "getGorservViewModel", "()Lcom/sputnik/common/viewmodels/GorservViewModel;", "gorservViewModel", "", "newPhone", "Ljava/lang/String;", "Lsputnik/axmor/com/databinding/DialogGorservErrorBinding;", "getBinding", "()Lsputnik/axmor/com/databinding/DialogGorservErrorBinding;", "binding", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GorservErrorDialog extends DialogFragment {
    private ViewBinding _binding;
    public Analytics analytics;
    public MultiViewModelFactory factory;

    /* renamed from: gorservViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gorservViewModel;
    public LocalizationStorage localizationStorage;
    private String newPhone = "";

    private final DialogGorservErrorBinding getBinding() {
        ViewBinding viewBinding = this._binding;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.DialogGorservErrorBinding");
        return (DialogGorservErrorBinding) viewBinding;
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

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    private final GorservViewModel getGorservViewModel() {
        return (GorservViewModel) this.gorservViewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this._binding = DialogGorservErrorBinding.inflate(getLayoutInflater(), null, false);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(getBinding().getRoot()).create();
        if (alertDialogCreate != null && alertDialogCreate.getWindow() != null) {
            Window window = alertDialogCreate.getWindow();
            Intrinsics.checkNotNull(window);
            window.setBackgroundDrawable(new ColorDrawable(0));
            Window window2 = alertDialogCreate.getWindow();
            Intrinsics.checkNotNull(window2);
            WindowUtilsKt.requestFeatureSafe(window2, 1);
        }
        alertDialogCreate.setCanceledOnTouchOutside(true);
        localize();
        initView();
        getAnalytics().trackLogEvent(new GorservEvents.ShowErrorScreen());
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "apply(...)");
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    private final void initView() {
        final DialogGorservErrorBinding binding = getBinding();
        binding.btnComplete.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.GorservErrorDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GorservErrorDialog.initView$lambda$3$lambda$1(binding, this, view);
            }
        });
        binding.btnHelp.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.GorservErrorDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GorservErrorDialog.initView$lambda$3$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$1(DialogGorservErrorBinding this_with, GorservErrorDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = this_with.btnComplete.getText().toString();
        try {
            this$0.startActivity(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", string, null)));
            this$0.dismiss();
            this$0.getAnalytics().trackLogEvent(new GorservEvents.ClickErrorPhoneNumber());
        } catch (Exception unused) {
            this$0.dismiss();
            this$0.getGorservViewModel().notifyErrorMessage("Попробуйте позвонить вручную, номер скопирован в буфер обмена");
            try {
                Object systemService = this$0.requireActivity().getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ClipData clipDataNewPlainText = ClipData.newPlainText("Phone", string);
                Intrinsics.checkNotNullExpressionValue(clipDataNewPlainText, "newPlainText(...)");
                ((ClipboardManager) systemService).setPrimaryClip(clipDataNewPlainText);
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(GorservErrorDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void localize() {
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data != null) {
            data.getOurHomeUpdatePopup();
        }
        DialogGorservErrorBinding binding = getBinding();
        binding.title.setText("Что-то пошло не так...");
        binding.subtitle.setText("Попробуйте повторно отправить заявку или позвоните по бесплатному номеру");
        binding.btnComplete.setText("8 (800) 333-10-37");
        binding.btnHelp.setText("Вернуться");
    }

    public GorservErrorDialog() {
        final Function0 function0 = null;
        this.gorservViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GorservViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.GorservErrorDialog$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.GorservErrorDialog$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.gorserv.GorservErrorDialog$gorservViewModel$2
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
