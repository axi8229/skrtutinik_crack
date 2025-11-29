package sputnik.axmor.com.sputnik.ui.main.profile.localization;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.sputnik.common.entities.localization.ChangeLanguageBody;
import com.sputnik.common.entities.localization.ChangeLanguagePopUpLocale;
import com.sputnik.common.entities.localization.Localization;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.viewmodels.LocalizationViewModel;
import com.sputnik.common.viewmodels.LocalizationViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.domain.common.Event;
import com.sputnik.oboarding.databinding.BottomSheetChooseLanguageBinding;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: LocalizationBottomSheet.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0003R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u001d\u00108\u001a\u0004\u0018\u0001048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010+\u001a\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/localization/LocalizationBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "Landroidx/viewbinding/ViewBinding;", "_binding", "Landroidx/viewbinding/ViewBinding;", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel$delegate", "Lkotlin/Lazy;", "getLocalizationViewModel", "()Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/entities/localization/Localization;", "currentLanguage$delegate", "getCurrentLanguage", "()Lcom/sputnik/common/entities/localization/Localization;", "currentLanguage", "Lcom/sputnik/oboarding/databinding/BottomSheetChooseLanguageBinding;", "getBinding", "()Lcom/sputnik/oboarding/databinding/BottomSheetChooseLanguageBinding;", "binding", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalizationBottomSheet extends BottomSheetDialogFragment {
    private ViewBinding _binding;

    /* renamed from: currentLanguage$delegate, reason: from kotlin metadata */
    private final Lazy currentLanguage = LazyKt.lazy(new Function0<Localization>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet$currentLanguage$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Localization invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return (Localization) arguments.getParcelable(FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE);
            }
            return null;
        }
    });
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: localizationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy localizationViewModel;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    private final BottomSheetChooseLanguageBinding getBinding() {
        ViewBinding viewBinding = this._binding;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type com.sputnik.oboarding.databinding.BottomSheetChooseLanguageBinding");
        return (BottomSheetChooseLanguageBinding) viewBinding;
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
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

    private final LocalizationViewModel getLocalizationViewModel() {
        return (LocalizationViewModel) this.localizationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Localization getCurrentLanguage() {
        return (Localization) this.currentLanguage.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = BottomSheetChooseLanguageBinding.inflate(getLayoutInflater(), container, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        LocalizationViewModel localizationViewModel = getLocalizationViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        localizationViewModel.observeState(viewLifecycleOwner, new Function1<LocalizationViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet.onViewCreated.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LocalizationViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LocalizationViewState localizationViewState) {
                invoke2(localizationViewState);
                return Unit.INSTANCE;
            }
        });
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        profileViewModel.observeSubState(viewLifecycleOwner2, new Function1<ProfileViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getLocalizationNeedUpdate();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet.onViewCreated.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) throws Resources.NotFoundException {
                invoke2((Event<Boolean>) event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<Boolean> it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    LocalizationBottomSheet localizationBottomSheet = LocalizationBottomSheet.this;
                    if (contentIfNotHandled.booleanValue()) {
                        Localization currentLanguage = localizationBottomSheet.getCurrentLanguage();
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(localizationBottomSheet), R.id.localization_bottom_sheet, R.id.action_localization_bottom_sheet_to_localizationSplash, BundleKt.bundleOf(TuplesKt.to("locale", currentLanguage != null ? currentLanguage.getTag() : null)), null, 8, null);
                    }
                }
            }
        });
        initView();
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet.onViewCreated.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) this.getDialog();
                FrameLayout frameLayout = bottomSheetDialog != null ? (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet) : null;
                Intrinsics.checkNotNull(frameLayout, "null cannot be cast to non-null type android.widget.FrameLayout");
                BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(frameLayout);
                Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
                bottomSheetBehaviorFrom.setState(3);
                bottomSheetBehaviorFrom.setPeekHeight(0);
                final LocalizationBottomSheet localizationBottomSheet = this;
                bottomSheetBehaviorFrom.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet$onViewCreated$4$onGlobalLayout$1
                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public void onSlide(View bottomSheet, float slideOffset) {
                        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                    }

                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public void onStateChanged(View bottomSheet, int newState) {
                        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                        if (newState == 4) {
                            localizationBottomSheet.dismiss();
                        }
                    }
                });
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this._binding = null;
        super.onDestroy();
    }

    private final void initView() {
        BottomSheetChooseLanguageBinding binding = getBinding();
        TextView textView = binding.choosingLanguage;
        Localization currentLanguage = getCurrentLanguage();
        textView.setText(currentLanguage != null ? currentLanguage.getName() : null);
        TextView textView2 = binding.choosingLanguage;
        Localization currentLanguage2 = getCurrentLanguage();
        Integer numValueOf = currentLanguage2 != null ? Integer.valueOf(currentLanguage2.getFlag()) : null;
        Intrinsics.checkNotNull(numValueOf);
        textView2.setCompoundDrawablesWithIntrinsicBounds(numValueOf.intValue(), 0, 0, 0);
        binding.btnReject.setOnClickListener(new View.OnClickListener() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalizationBottomSheet.initView$lambda$1$lambda$0(this.f$0, view);
            }
        });
        AppCompatButton btnAccept = binding.btnAccept;
        Intrinsics.checkNotNullExpressionValue(btnAccept, "btnAccept");
        SafeClickListenerKt.setSafeOnClickListener$default(btnAccept, 0L, new Function1<View, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet$initView$1$2
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
                ProfileViewModel profileViewModel = this.this$0.getProfileViewModel();
                Localization currentLanguage3 = this.this$0.getCurrentLanguage();
                String tag = currentLanguage3 != null ? currentLanguage3.getTag() : null;
                Intrinsics.checkNotNull(tag);
                profileViewModel.setLocalization(tag);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(LocalizationBottomSheet this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void localize() {
        ChangeLanguagePopUpLocale changeLanguagePopup;
        ChangeLanguageBody body;
        TextTitle cancelButton;
        ChangeLanguagePopUpLocale changeLanguagePopup2;
        ChangeLanguageBody body2;
        TextTitle changeButton;
        ChangeLanguagePopUpLocale changeLanguagePopup3;
        ChangeLanguageBody body3;
        List<String> titles;
        ChangeLanguagePopUpLocale changeLanguagePopup4;
        ChangeLanguageBody body4;
        List<String> titles2;
        ChangeLanguagePopUpLocale changeLanguagePopup5;
        ChangeLanguageBody body5;
        List<String> titles3;
        BottomSheetChooseLanguageBinding binding = getBinding();
        TextView textView = binding.tvTitle;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = null;
        textView.setText((data == null || (changeLanguagePopup5 = data.getChangeLanguagePopup()) == null || (body5 = changeLanguagePopup5.getBody()) == null || (titles3 = body5.getTitles()) == null) ? null : (String) CollectionsKt.first((List) titles3));
        TextView textView2 = binding.tvActionChange;
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        textView2.setText((data2 == null || (changeLanguagePopup4 = data2.getChangeLanguagePopup()) == null || (body4 = changeLanguagePopup4.getBody()) == null || (titles2 = body4.getTitles()) == null) ? null : titles2.get(1));
        TextView textView3 = binding.tvNotice;
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        textView3.setText((data3 == null || (changeLanguagePopup3 = data3.getChangeLanguagePopup()) == null || (body3 = changeLanguagePopup3.getBody()) == null || (titles = body3.getTitles()) == null) ? null : (String) CollectionsKt.last((List) titles));
        AppCompatButton appCompatButton = binding.btnAccept;
        LocalizationLocalModel data4 = getLocalizationScreen().getData();
        appCompatButton.setText((data4 == null || (changeLanguagePopup2 = data4.getChangeLanguagePopup()) == null || (body2 = changeLanguagePopup2.getBody()) == null || (changeButton = body2.getChangeButton()) == null) ? null : changeButton.getTitle());
        AppCompatButton appCompatButton2 = binding.btnReject;
        LocalizationLocalModel data5 = getLocalizationScreen().getData();
        if (data5 != null && (changeLanguagePopup = data5.getChangeLanguagePopup()) != null && (body = changeLanguagePopup.getBody()) != null && (cancelButton = body.getCancelButton()) != null) {
            title = cancelButton.getTitle();
        }
        appCompatButton2.setText(title);
    }

    public LocalizationBottomSheet() {
        final Function0 function0 = null;
        this.localizationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LocalizationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet$localizationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationBottomSheet$profileViewModel$2
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
