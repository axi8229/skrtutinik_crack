package com.sputnik.common.ui.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBinding;
import com.sputnik.common.databinding.DialogSingleButtonBinding;
import com.sputnik.common.di.CommonComponentKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.WindowUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.NavigationViewModel;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: SingleButtonDialog.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u001d\u0010%\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010!R\u001d\u0010*\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010)R\u001d\u0010/\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010.R\u001d\u00102\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u001a\u001a\u0004\b1\u0010.R\u001d\u00105\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u001a\u001a\u0004\b4\u0010.R\"\u00107\u001a\u0002068\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/sputnik/common/ui/dialogs/SingleButtonDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroidx/viewbinding/ViewBinding;", "_binding", "Landroidx/viewbinding/ViewBinding;", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "baseFactory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getBaseFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setBaseFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel$delegate", "Lkotlin/Lazy;", "getNavigationViewModel", "()Lcom/sputnik/common/viewmodels/NavigationViewModel;", "navigationViewModel", "", "navigationAction$delegate", "getNavigationAction", "()Ljava/lang/Integer;", "navigationAction", "popBackStackAction$delegate", "getPopBackStackAction", "popBackStackAction", "", "popBackStackInclusive$delegate", "getPopBackStackInclusive", "()Ljava/lang/Boolean;", "popBackStackInclusive", "", "title$delegate", "getTitle", "()Ljava/lang/String;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle$delegate", "getSubtitle", "subtitle", "btnText$delegate", "getBtnText", "btnText", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/databinding/DialogSingleButtonBinding;", "getBinding", "()Lcom/sputnik/common/databinding/DialogSingleButtonBinding;", "binding", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SingleButtonDialog extends DialogFragment {
    private ViewBinding _binding;
    public MultiViewModelFactory baseFactory;
    public LocalizationStorage localizationScreen;

    /* renamed from: navigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy navigationViewModel;

    /* renamed from: navigationAction$delegate, reason: from kotlin metadata */
    private final Lazy navigationAction = LazyKt.lazy(new Function0<Integer>() { // from class: com.sputnik.common.ui.dialogs.SingleButtonDialog$navigationAction$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return Integer.valueOf(arguments.getInt("navigation_action_id"));
            }
            return null;
        }
    });

    /* renamed from: popBackStackAction$delegate, reason: from kotlin metadata */
    private final Lazy popBackStackAction = LazyKt.lazy(new Function0<Integer>() { // from class: com.sputnik.common.ui.dialogs.SingleButtonDialog$popBackStackAction$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return Integer.valueOf(arguments.getInt("pop_back_stack"));
            }
            return null;
        }
    });

    /* renamed from: popBackStackInclusive$delegate, reason: from kotlin metadata */
    private final Lazy popBackStackInclusive = LazyKt.lazy(new Function0<Boolean>() { // from class: com.sputnik.common.ui.dialogs.SingleButtonDialog$popBackStackInclusive$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return Boolean.valueOf(arguments.getBoolean("pop_back_stack_inclusive", false));
            }
            return null;
        }
    });

    /* renamed from: title$delegate, reason: from kotlin metadata */
    private final Lazy title = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.common.ui.dialogs.SingleButtonDialog$title$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            return (String) (arguments != null ? arguments.get(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE) : null);
        }
    });

    /* renamed from: subtitle$delegate, reason: from kotlin metadata */
    private final Lazy subtitle = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.common.ui.dialogs.SingleButtonDialog$subtitle$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            return (String) (arguments != null ? arguments.get("subtitle") : null);
        }
    });

    /* renamed from: btnText$delegate, reason: from kotlin metadata */
    private final Lazy btnText = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.common.ui.dialogs.SingleButtonDialog$btnText$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            return (String) (arguments != null ? arguments.get("button_text") : null);
        }
    });

    private final DialogSingleButtonBinding getBinding() {
        ViewBinding viewBinding = this._binding;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type com.sputnik.common.databinding.DialogSingleButtonBinding");
        return (DialogSingleButtonBinding) viewBinding;
    }

    public final MultiViewModelFactory getBaseFactory() {
        MultiViewModelFactory multiViewModelFactory = this.baseFactory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("baseFactory");
        return null;
    }

    private final String getSubtitle() {
        return (String) this.subtitle.getValue();
    }

    private final String getBtnText() {
        return (String) this.btnText.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CommonComponentKt.commonComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this._binding = DialogSingleButtonBinding.inflate(getLayoutInflater(), null, false);
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(getBinding().getRoot()).create();
        if (alertDialogCreate != null && alertDialogCreate.getWindow() != null) {
            Window window = alertDialogCreate.getWindow();
            Intrinsics.checkNotNull(window);
            window.setBackgroundDrawable(new ColorDrawable(0));
            Window window2 = alertDialogCreate.getWindow();
            Intrinsics.checkNotNull(window2);
            WindowUtilsKt.requestFeatureSafe(window2, 1);
        }
        alertDialogCreate.setCanceledOnTouchOutside(true);
        DialogSingleButtonBinding binding = getBinding();
        binding.dialogTitle.setText(getSubtitle());
        binding.btnComplete.setText(getBtnText());
        binding.btnComplete.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.common.ui.dialogs.SingleButtonDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SingleButtonDialog.onCreateDialog$lambda$4$lambda$3$lambda$2(alertDialogCreate, this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "apply(...)");
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$4$lambda$3$lambda$2(AlertDialog alertDialog, SingleButtonDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        alertDialog.dismiss();
    }

    public SingleButtonDialog() {
        final Function0 function0 = null;
        this.navigationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NavigationViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.common.ui.dialogs.SingleButtonDialog$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = this.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.common.ui.dialogs.SingleButtonDialog$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.common.ui.dialogs.SingleButtonDialog$navigationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getBaseFactory();
            }
        });
    }
}
