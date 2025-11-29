package com.sputnik.oboarding.ui.localization;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LanguageLoaderBody;
import com.sputnik.common.entities.localization.LanguageLoaderLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.OnBoardingLanguageLoaderBody;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.OnBoardingLanguageLoaderLocale;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.LocalizationViewModel;
import com.sputnik.common.viewmodels.LocalizationViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.oboarding.R$anim;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.databinding.FragmentStartSplashLanguageBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: LoadingLanguageSplashFragment.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/sputnik/oboarding/ui/localization/LoadingLanguageSplashFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "setupText", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentStartSplashLanguageBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentStartSplashLanguageBinding;", "binding", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel$delegate", "Lkotlin/Lazy;", "getLocalizationViewModel", "()Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel", "", "newLocale$delegate", "getNewLocale", "()Ljava/lang/String;", "newLocale", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LoadingLanguageSplashFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LoadingLanguageSplashFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentStartSplashLanguageBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    /* renamed from: localizationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy localizationViewModel;

    /* renamed from: newLocale$delegate, reason: from kotlin metadata */
    private final Lazy newLocale;
    public PrefManager prefManager;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentStartSplashLanguageBinding getBinding() {
        return (FragmentStartSplashLanguageBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final PrefManager getPrefManager() {
        PrefManager prefManager = this.prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
        return null;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final LocalizationViewModel getLocalizationViewModel() {
        return (LocalizationViewModel) this.localizationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getNewLocale() {
        return (String) this.newLocale.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        OnBoardingComponentKt.onBoardingComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupText();
        localize();
        initView();
        getLocalizationViewModel().delayRequest(300L, new Function0<Unit>() { // from class: com.sputnik.oboarding.ui.localization.LoadingLanguageSplashFragment.onViewCreated.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LoadingLanguageSplashFragment.this.getLocalizationViewModel().loadLocalization(LoadingLanguageSplashFragment.this.getNewLocale());
                LoadingLanguageSplashFragment.this.getPrefManager().updateUserLocale(LoadingLanguageSplashFragment.this.getNewLocale());
            }
        });
        getLocalizationViewModel().handleChangingLanguage();
        LocalizationViewModel localizationViewModel = getLocalizationViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        localizationViewModel.observeSubState(viewLifecycleOwner, new Function1<LocalizationViewState, Integer>() { // from class: com.sputnik.oboarding.ui.localization.LoadingLanguageSplashFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(LocalizationViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.getCurLoaderIndex());
            }
        }, new Function1<Integer, Unit>() { // from class: com.sputnik.oboarding.ui.localization.LoadingLanguageSplashFragment.onViewCreated.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                LanguageLoaderLocale languageLoader;
                LanguageLoaderBody body;
                List<String> bottomTitles;
                String str;
                LanguageLoaderLocale languageLoader2;
                LanguageLoaderBody body2;
                List<String> bottomTitles2;
                TextSwitcher textSwitcher = LoadingLanguageSplashFragment.this.getBinding().tvTitleSplash;
                LocalizationLocalModel data = LoadingLanguageSplashFragment.this.getLocalizationStorage().getData();
                String str2 = null;
                if (data != null && (languageLoader = data.getLanguageLoader()) != null && (body = languageLoader.getBody()) != null && (bottomTitles = body.getBottomTitles()) != null) {
                    LoadingLanguageSplashFragment loadingLanguageSplashFragment = LoadingLanguageSplashFragment.this;
                    if (i < 0 || i > CollectionsKt.getLastIndex(bottomTitles)) {
                        LocalizationLocalModel data2 = loadingLanguageSplashFragment.getLocalizationStorage().getData();
                        if (data2 != null && (languageLoader2 = data2.getLanguageLoader()) != null && (body2 = languageLoader2.getBody()) != null && (bottomTitles2 = body2.getBottomTitles()) != null) {
                            str2 = (String) CollectionsKt.firstOrNull((List) bottomTitles2);
                        }
                        str = str2;
                    } else {
                        str = bottomTitles.get(i);
                    }
                    str2 = str;
                }
                textSwitcher.setText(str2);
            }
        });
        LocalizationViewModel localizationViewModel2 = getLocalizationViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        localizationViewModel2.observeSubState(viewLifecycleOwner2, new Function1<LocalizationViewState, Event<? extends Boolean>>() { // from class: com.sputnik.oboarding.ui.localization.LoadingLanguageSplashFragment.onViewCreated.4
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(LocalizationViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isLoaded();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: com.sputnik.oboarding.ui.localization.LoadingLanguageSplashFragment.onViewCreated.5
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
                    LoadingLanguageSplashFragment loadingLanguageSplashFragment = LoadingLanguageSplashFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        loadingLanguageSplashFragment.requireActivity().recreate();
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(loadingLanguageSplashFragment), R$id.loadingLanguageSplashFragment, R$id.action_loadingLanguageSplashFragment_to_localizationListFinishFragment, null, null, 12, null);
                    }
                }
            }
        });
    }

    private final void setupText() {
        getBinding().tvTitleSplash.setInAnimation(getContext(), R$anim.slide_in_up);
        getBinding().tvTitleSplash.setOutAnimation(getContext(), R$anim.slide_out_down);
    }

    private final void initView() {
        getPrefManager().updateUserLocale(getNewLocale());
        ConstraintLayout rootView = getBinding().rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }

    private final void localize() {
        OnBoardingLanguageLoaderLocale onBoardingLanguageLoader;
        OnBoardingLanguageLoaderBody body;
        TextView textView = getBinding().title;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        textView.setText((data == null || (onBoardingLanguageLoader = data.getOnBoardingLanguageLoader()) == null || (body = onBoardingLanguageLoader.getBody()) == null) ? null : body.getTitle());
    }

    public LoadingLanguageSplashFragment() {
        super(R$layout.fragment_start_splash_language);
        this.binding = new ViewBindingFragmentDelegate(this, LoadingLanguageSplashFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.localizationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LocalizationViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.localization.LoadingLanguageSplashFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.localization.LoadingLanguageSplashFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.localization.LoadingLanguageSplashFragment$localizationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.newLocale = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.localization.LoadingLanguageSplashFragment$newLocale$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String curLocale;
                Bundle arguments = this.this$0.getArguments();
                if (arguments == null || (curLocale = arguments.getString("locale")) == null) {
                    curLocale = this.this$0.getPrefManager().getCurLocale();
                }
                Intrinsics.checkNotNull(curLocale);
                return curLocale;
            }
        });
    }
}
