package com.sputnik.oboarding.ui.registration;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.login.ConfirmAddressBodyLocale;
import com.sputnik.common.entities.localization.entities.login.ConfirmAddressLocale;
import com.sputnik.common.entities.localization.entities.login.WrongApartmentPopup;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.domain.common.Resource;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.analytics.yandex.OnBoardingEvents;
import com.sputnik.oboarding.databinding.FragmentRegSmtWrongBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import com.sputnik.oboarding.entities.entry.Entry;
import com.sputnik.oboarding.ui.registration.viewmodel.EntryViewModel;
import com.sputnik.oboarding.ui.registration.viewmodel.EntryViewState;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.internal.Util;

/* compiled from: SomethingWentWrongFragment.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001d\u0010=\u001a\u0004\u0018\u0001098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/SomethingWentWrongFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentRegSmtWrongBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentRegSmtWrongBinding;", "binding", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/support/ISupportManager;", "supportManager", "Lcom/sputnik/common/support/ISupportManager;", "getSupportManager", "()Lcom/sputnik/common/support/ISupportManager;", "setSupportManager", "(Lcom/sputnik/common/support/ISupportManager;)V", "Lcom/sputnik/oboarding/ui/registration/viewmodel/EntryViewModel;", "entryViewModel$delegate", "Lkotlin/Lazy;", "getEntryViewModel", "()Lcom/sputnik/oboarding/ui/registration/viewmodel/EntryViewModel;", "entryViewModel", "", "wrongApartment$delegate", "getWrongApartment", "()Ljava/lang/String;", "wrongApartment", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SomethingWentWrongFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SomethingWentWrongFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentRegSmtWrongBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;

    /* renamed from: entryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy entryViewModel;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;
    public ISupportManager supportManager;

    /* renamed from: wrongApartment$delegate, reason: from kotlin metadata */
    private final Lazy wrongApartment;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentRegSmtWrongBinding getBinding() {
        return (FragmentRegSmtWrongBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
        return null;
    }

    public final ISupportManager getSupportManager() {
        ISupportManager iSupportManager = this.supportManager;
        if (iSupportManager != null) {
            return iSupportManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("supportManager");
        return null;
    }

    private final EntryViewModel getEntryViewModel() {
        return (EntryViewModel) this.entryViewModel.getValue();
    }

    private final String getWrongApartment() {
        return (String) this.wrongApartment.getValue();
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
        localize();
        initView();
    }

    private final void initView() {
        FragmentRegSmtWrongBinding binding = getBinding();
        binding.btnChangeApartmentNumber.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.SomethingWentWrongFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SomethingWentWrongFragment.initView$lambda$2$lambda$0(this.f$0, view);
            }
        });
        binding.tvSupport.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.SomethingWentWrongFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SomethingWentWrongFragment.initView$lambda$2$lambda$1(this.f$0, view);
            }
        });
        EntryViewModel entryViewModel = getEntryViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        entryViewModel.observeState(viewLifecycleOwner, new Function1<EntryViewState, Unit>() { // from class: com.sputnik.oboarding.ui.registration.SomethingWentWrongFragment.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EntryViewState entryViewState) {
                invoke2(entryViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EntryViewState serverData) {
                ConfirmAddressLocale confirmAddress;
                ConfirmAddressBodyLocale body;
                Intrinsics.checkNotNullParameter(serverData, "serverData");
                if (serverData.getServerState() == Resource.Status.SUCCESS) {
                    LocalizationLocalModel data = SomethingWentWrongFragment.this.getLocalizationStorage().getData();
                    WrongApartmentPopup wrongApartmentPopup = (data == null || (confirmAddress = data.getConfirmAddress()) == null || (body = confirmAddress.getBody()) == null) ? null : body.getWrongApartmentPopup();
                    Intrinsics.checkNotNull(wrongApartmentPopup);
                    TextView textView = SomethingWentWrongFragment.this.getBinding().tvError;
                    String str = (String) CollectionsKt.last((List) wrongApartmentPopup.getBodies());
                    Entry entry = serverData.getEntry();
                    String strValueOf = String.valueOf(entry != null ? Integer.valueOf(entry.getFirstFlat()) : null);
                    Entry entry2 = serverData.getEntry();
                    textView.setText(Util.format(str, strValueOf, String.valueOf(entry2 != null ? Integer.valueOf(entry2.getLastFlat()) : null)));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$0(SomethingWentWrongFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationChangeFlatNumberEvent());
        FragmentKt.findNavController(this$0).navigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1(SomethingWentWrongFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationWrongAddressTpEvent());
        ISupportManager.DefaultImpls.displayMessenger$default(this$0.getSupportManager(), null, 1, null);
    }

    private final void localize() {
        ConfirmAddressLocale confirmAddress;
        ConfirmAddressBodyLocale body;
        FragmentRegSmtWrongBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        WrongApartmentPopup wrongApartmentPopup = (data == null || (confirmAddress = data.getConfirmAddress()) == null || (body = confirmAddress.getBody()) == null) ? null : body.getWrongApartmentPopup();
        Intrinsics.checkNotNull(wrongApartmentPopup);
        binding.title.setText(wrongApartmentPopup.getTitle());
        String wrongApartment = getWrongApartment();
        if (wrongApartment != null) {
            binding.tvApartmentNotFound.setText(Util.format((String) CollectionsKt.first((List) wrongApartmentPopup.getBodies()), wrongApartment));
        }
        binding.btnChangeApartmentNumber.setText(wrongApartmentPopup.getChangeButton().getTitle());
        binding.tvSupport.setText(wrongApartmentPopup.getSupportButton().getTitle());
    }

    public SomethingWentWrongFragment() {
        super(R$layout.fragment_reg_smt_wrong);
        this.binding = new ViewBindingFragmentDelegate(this, SomethingWentWrongFragment$binding$2.INSTANCE);
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.SomethingWentWrongFragment$entryViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.sputnik.oboarding.ui.registration.SomethingWentWrongFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: com.sputnik.oboarding.ui.registration.SomethingWentWrongFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function02.invoke();
            }
        });
        final Function0 function03 = null;
        this.entryViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(EntryViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.SomethingWentWrongFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.SomethingWentWrongFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM2230viewModels$lambda1 = FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM2230viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM2230viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function0);
        this.wrongApartment = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.SomethingWentWrongFragment$wrongApartment$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("apartment");
                }
                return null;
            }
        });
    }
}
