package sputnik.axmor.com.sputnik.ui.main.profile.localization;

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
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LanguageLoaderBody;
import com.sputnik.common.entities.localization.LanguageLoaderLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.LocalizationViewModel;
import com.sputnik.common.viewmodels.LocalizationViewState;
import com.sputnik.common.viewmodels.MarketViewModel;
import com.sputnik.common.viewmodels.MarketViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
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
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.FragmentSplashLanguageBinding;
import sputnik.axmor.com.sputnik.extensions.ContextKt;

/* compiled from: LocalizationSplash.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0003R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00106\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00105R\u001d\u0010;\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010.\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/main/profile/localization/LocalizationSplash;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/FragmentSplashLanguageBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lsputnik/axmor/com/databinding/FragmentSplashLanguageBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel$delegate", "Lkotlin/Lazy;", "getLocalizationViewModel", "()Lcom/sputnik/common/viewmodels/LocalizationViewModel;", "localizationViewModel", "Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel$delegate", "getMarketViewModel", "()Lcom/sputnik/common/viewmodels/MarketViewModel;", "marketViewModel", "", "newLocale$delegate", "getNewLocale", "()Ljava/lang/String;", "newLocale", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalizationSplash extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LocalizationSplash.class, "binding", "getBinding()Lsputnik/axmor/com/databinding/FragmentSplashLanguageBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationScreen;

    /* renamed from: localizationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy localizationViewModel;

    /* renamed from: marketViewModel$delegate, reason: from kotlin metadata */
    private final Lazy marketViewModel;

    /* renamed from: newLocale$delegate, reason: from kotlin metadata */
    private final Lazy newLocale;
    public PrefManager prefManager;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSplashLanguageBinding getBinding() {
        return (FragmentSplashLanguageBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    public final PrefManager getPrefManager() {
        PrefManager prefManager = this.prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
        return null;
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    private final LocalizationViewModel getLocalizationViewModel() {
        return (LocalizationViewModel) this.localizationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MarketViewModel getMarketViewModel() {
        return (MarketViewModel) this.marketViewModel.getValue();
    }

    private final String getNewLocale() {
        return (String) this.newLocale.getValue();
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextKt.getAppComponent(context).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String newLocale = getNewLocale();
        if (newLocale != null) {
            getLocalizationViewModel().loadLocalization(newLocale);
            getPrefManager().updateUserLocale(newLocale);
        }
        MarketViewModel marketViewModel = getMarketViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        marketViewModel.observeState(viewLifecycleOwner, new Function1<MarketViewState, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash.onViewCreated.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MarketViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MarketViewState marketViewState) {
                invoke2(marketViewState);
                return Unit.INSTANCE;
            }
        });
        getLocalizationViewModel().handleChangingLanguage();
        LocalizationViewModel localizationViewModel = getLocalizationViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        localizationViewModel.observeSubState(viewLifecycleOwner2, new Function1<LocalizationViewState, Integer>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(LocalizationViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.getCurLoaderIndex());
            }
        }, new Function1<Integer, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash.onViewCreated.4
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
                TextSwitcher textSwitcher = LocalizationSplash.this.getBinding().tvTitleSplash;
                LocalizationLocalModel data = LocalizationSplash.this.getLocalizationScreen().getData();
                String str2 = null;
                if (data != null && (languageLoader = data.getLanguageLoader()) != null && (body = languageLoader.getBody()) != null && (bottomTitles = body.getBottomTitles()) != null) {
                    LocalizationSplash localizationSplash = LocalizationSplash.this;
                    if (i < 0 || i > CollectionsKt.getLastIndex(bottomTitles)) {
                        LocalizationLocalModel data2 = localizationSplash.getLocalizationScreen().getData();
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
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        localizationViewModel2.observeSubState(viewLifecycleOwner3, new Function1<LocalizationViewState, Event<? extends Boolean>>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(LocalizationViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isLoaded();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash.onViewCreated.6
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
                    LocalizationSplash localizationSplash = LocalizationSplash.this;
                    if (contentIfNotHandled.booleanValue()) {
                        localizationSplash.requireActivity().recreate();
                        localizationSplash.getMarketViewModel().handleNeedUpdate(true);
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(localizationSplash), R.id.localizationSplash, R.id.action_localizationSplash_to_localizationList, null, null, 12, null);
                    }
                }
            }
        });
        ConstraintLayout rootView = getBinding().rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true, true, true, true);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        getBinding().tvTitleSplash.setInAnimation(getContext(), R.anim.slide_in_up);
        getBinding().tvTitleSplash.setOutAnimation(getContext(), R.anim.slide_out_down);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        LanguageLoaderLocale languageLoader;
        LanguageLoaderBody body;
        TextView textView = getBinding().infoNoClos;
        LocalizationLocalModel data = getLocalizationScreen().getData();
        textView.setText((data == null || (languageLoader = data.getLanguageLoader()) == null || (body = languageLoader.getBody()) == null) ? null : body.getTitle());
    }

    public LocalizationSplash() {
        super(R.layout.fragment_splash_language);
        this.binding = new ViewBindingFragmentDelegate(this, LocalizationSplash$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.localizationViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LocalizationViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash$localizationViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.marketViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MarketViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash$marketViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.newLocale = LazyKt.lazy(new Function0<String>() { // from class: sputnik.axmor.com.sputnik.ui.main.profile.localization.LocalizationSplash$newLocale$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("locale");
                }
                return null;
            }
        });
    }
}
