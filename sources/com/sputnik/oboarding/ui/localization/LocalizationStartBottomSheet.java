package com.sputnik.oboarding.ui.localization;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.sputnik.common.base.BaseBottomSheetDialogFragment;
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
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.databinding.BottomSheetChooseLanguageBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: LocalizationStartBottomSheet.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0004R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/sputnik/oboarding/ui/localization/LocalizationStartBottomSheet;", "Lcom/sputnik/common/base/BaseBottomSheetDialogFragment;", "Lcom/sputnik/oboarding/databinding/BottomSheetChooseLanguageBinding;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel$delegate", "Lkotlin/Lazy;", "getLocalizationViewModel", "()Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel", "Lcom/sputnik/common/entities/localization/Localization;", "currentLanguage$delegate", "getCurrentLanguage", "()Lcom/sputnik/common/entities/localization/Localization;", "currentLanguage", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocalizationStartBottomSheet extends BaseBottomSheetDialogFragment<BottomSheetChooseLanguageBinding> {

    /* renamed from: currentLanguage$delegate, reason: from kotlin metadata */
    private final Lazy currentLanguage;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: localizationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy localizationViewModel;

    /* compiled from: LocalizationStartBottomSheet.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.localization.LocalizationStartBottomSheet$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, BottomSheetChooseLanguageBinding> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(3, BottomSheetChooseLanguageBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/sputnik/oboarding/databinding/BottomSheetChooseLanguageBinding;", 0);
        }

        public final BottomSheetChooseLanguageBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return BottomSheetChooseLanguageBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ BottomSheetChooseLanguageBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public final LocalizationViewModel getLocalizationViewModel() {
        return (LocalizationViewModel) this.localizationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Localization getCurrentLanguage() {
        return (Localization) this.currentLanguage.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        OnBoardingComponentKt.onBoardingComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LocalizationViewModel localizationViewModel = getLocalizationViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        localizationViewModel.observeState(viewLifecycleOwner, new Function1<LocalizationViewState, Unit>() { // from class: com.sputnik.oboarding.ui.localization.LocalizationStartBottomSheet.onViewCreated.1
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
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        BottomSheetChooseLanguageBinding binding = getBinding();
        TextView textView = binding.choosingLanguage;
        Localization currentLanguage = getCurrentLanguage();
        textView.setText(currentLanguage != null ? currentLanguage.getName() : null);
        TextView textView2 = binding.choosingLanguage;
        Localization currentLanguage2 = getCurrentLanguage();
        Integer numValueOf = currentLanguage2 != null ? Integer.valueOf(currentLanguage2.getFlag()) : null;
        Intrinsics.checkNotNull(numValueOf);
        textView2.setCompoundDrawablesWithIntrinsicBounds(numValueOf.intValue(), 0, 0, 0);
        binding.btnReject.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.localization.LocalizationStartBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalizationStartBottomSheet.initViews$lambda$1$lambda$0(this.f$0, view);
            }
        });
        AppCompatButton btnAccept = binding.btnAccept;
        Intrinsics.checkNotNullExpressionValue(btnAccept, "btnAccept");
        SafeClickListenerKt.setSafeOnClickListener$default(btnAccept, 0L, new Function1<View, Unit>() { // from class: com.sputnik.oboarding.ui.localization.LocalizationStartBottomSheet$initViews$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) throws Resources.NotFoundException {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                Localization currentLanguage3 = this.this$0.getCurrentLanguage();
                Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("locale", currentLanguage3 != null ? currentLanguage3.getTag() : null));
                LocalizationViewModel localizationViewModel = this.this$0.getLocalizationViewModel();
                Localization currentLanguage4 = this.this$0.getCurrentLanguage();
                localizationViewModel.handleCurrentTag(currentLanguage4 != null ? currentLanguage4.getTag() : null);
                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this.this$0), R$id.startChooseLanguageBottomSheet, R$id.action_startChooseLanguageBottomSheet_to_loadingLanguageSplashFragment, bundleBundleOf, null, 8, null);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1$lambda$0(LocalizationStartBottomSheet this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
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

    public LocalizationStartBottomSheet() {
        super(AnonymousClass1.INSTANCE);
        final Function0 function0 = null;
        this.localizationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LocalizationViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.localization.LocalizationStartBottomSheet$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.localization.LocalizationStartBottomSheet$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.localization.LocalizationStartBottomSheet$localizationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.currentLanguage = LazyKt.lazy(new Function0<Localization>() { // from class: com.sputnik.oboarding.ui.localization.LocalizationStartBottomSheet$currentLanguage$2
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
    }
}
