package sputnik.axmor.com.sputnik.ui.main.profile.family;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBinding;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.FamilyEvents;
import com.sputnik.common.base.Notify;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.family_invites.FamilyInvitesLocale;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.WindowUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sputnik.axmor.com.databinding.DialogRemoveFromFamilyBinding;
import sputnik.axmor.com.sputnik.entities.family.Family;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewModel;
import sputnik.axmor.com.sputnik.ui.main.profile.family.viewmodel.FamilyViewState;

/* compiled from: RemoveFromFamilyDialog.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/family/RemoveFromFamilyDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "Landroidx/viewbinding/ViewBinding;", "_binding", "Landroidx/viewbinding/ViewBinding;", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel$delegate", "Lkotlin/Lazy;", "getFamilyViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/profile/family/viewmodel/FamilyViewModel;", "familyViewModel", "Lsputnik/axmor/com/sputnik/entities/family/Family;", "person$delegate", "getPerson", "()Lsputnik/axmor/com/sputnik/entities/family/Family;", "person", "Lsputnik/axmor/com/databinding/DialogRemoveFromFamilyBinding;", "getBinding", "()Lsputnik/axmor/com/databinding/DialogRemoveFromFamilyBinding;", "binding", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RemoveFromFamilyDialog extends DialogFragment {
    private ViewBinding _binding;
    public Analytics analytics;
    public MultiViewModelFactory factory;

    /* renamed from: familyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy familyViewModel;
    public LocalizationStorage localizationStorage;

    /* renamed from: person$delegate, reason: from kotlin metadata */
    private final Lazy person = LazyKt.lazy(new Function0<Family>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.RemoveFromFamilyDialog$person$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Family invoke() {
            Bundle arguments = this.this$0.getArguments();
            Object obj = arguments != null ? arguments.get("item") : null;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type sputnik.axmor.com.sputnik.entities.family.Family");
            return (Family) obj;
        }
    });

    private final DialogRemoveFromFamilyBinding getBinding() {
        ViewBinding viewBinding = this._binding;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type sputnik.axmor.com.databinding.DialogRemoveFromFamilyBinding");
        return (DialogRemoveFromFamilyBinding) viewBinding;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final FamilyViewModel getFamilyViewModel() {
        return (FamilyViewModel) this.familyViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Family getPerson() {
        return (Family) this.person.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this._binding = DialogRemoveFromFamilyBinding.inflate(getLayoutInflater(), null, false);
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
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "apply(...)");
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FamilyViewModel familyViewModel = getFamilyViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        familyViewModel.observeState(viewLifecycleOwner, new Function1<FamilyViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.RemoveFromFamilyDialog.onViewCreated.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FamilyViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FamilyViewState familyViewState) {
                invoke2(familyViewState);
                return Unit.INSTANCE;
            }
        });
        FamilyViewModel familyViewModel2 = getFamilyViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        familyViewModel2.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.RemoveFromFamilyDialog.onViewCreated.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notify notify) {
                invoke2(notify);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Notify it) {
                Intrinsics.checkNotNullParameter(it, "it");
                RemoveFromFamilyDialog removeFromFamilyDialog = RemoveFromFamilyDialog.this;
                View rootView = view.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
                ViewKt.renderNotifications(removeFromFamilyDialog, rootView, it);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    private final void initView() {
        FamilyInvitesLocale familyInvites;
        FamilyInvitesLocale.RemoveFromFamilyLocale removeFromFamily;
        DialogRemoveFromFamilyBinding binding = getBinding();
        AppCompatButton btnApply = binding.btnApply;
        Intrinsics.checkNotNullExpressionValue(btnApply, "btnApply");
        SafeClickListenerKt.setSafeOnClickListener$default(btnApply, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.RemoveFromFamilyDialog$initView$1$1
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
                Integer id;
                Intrinsics.checkNotNullParameter(it, "it");
                Family person = this.this$0.getPerson();
                if (person != null && (id = person.getId()) != null) {
                    RemoveFromFamilyDialog removeFromFamilyDialog = this.this$0;
                    int iIntValue = id.intValue();
                    removeFromFamilyDialog.getAnalytics().trackLogEvent(new FamilyEvents.ClickFamilyRemoveFromTheFamilyConfirm());
                    removeFromFamilyDialog.getFamilyViewModel().deleteFromFamily(iIntValue);
                }
                this.this$0.dismiss();
            }
        }, 1, null);
        binding.btnBack.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.RemoveFromFamilyDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RemoveFromFamilyDialog.initView$lambda$2$lambda$1(this.f$0, view);
            }
        });
        TextView textView = binding.tvBody;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String subtitle = (data == null || (familyInvites = data.getFamilyInvites()) == null || (removeFromFamily = familyInvites.getRemoveFromFamily()) == null) ? null : removeFromFamily.getSubtitle();
        if (subtitle == null) {
            subtitle = "";
        }
        textView.setText(StringUtilsKt.formatSafe(subtitle, getPerson().getFullName() + " " + getPerson().getPhone()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1(RemoveFromFamilyDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new FamilyEvents.ClickFamilyRemoveFromTheFamilyCancel());
        this$0.dismiss();
    }

    private final void localize() {
        FamilyInvitesLocale familyInvites;
        FamilyInvitesLocale.RemoveFromFamilyLocale removeFromFamily;
        DialogRemoveFromFamilyBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data == null || (familyInvites = data.getFamilyInvites()) == null || (removeFromFamily = familyInvites.getRemoveFromFamily()) == null) {
            return;
        }
        TextView textView = binding.tvTitle;
        String title = removeFromFamily.getTitle();
        if (title == null) {
            title = "";
        }
        textView.setText(title);
        AppCompatButton appCompatButton = binding.btnApply;
        TextTitle okButton = removeFromFamily.getOkButton();
        String title2 = okButton != null ? okButton.getTitle() : null;
        if (title2 == null) {
            title2 = "";
        }
        appCompatButton.setText(title2);
        AppCompatButton appCompatButton2 = binding.btnBack;
        TextTitle cancelButton = removeFromFamily.getCancelButton();
        String title3 = cancelButton != null ? cancelButton.getTitle() : null;
        appCompatButton2.setText(title3 != null ? title3 : "");
    }

    public RemoveFromFamilyDialog() {
        final Function0 function0 = null;
        this.familyViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FamilyViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.RemoveFromFamilyDialog$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.RemoveFromFamilyDialog$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.family.RemoveFromFamilyDialog$familyViewModel$2
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
