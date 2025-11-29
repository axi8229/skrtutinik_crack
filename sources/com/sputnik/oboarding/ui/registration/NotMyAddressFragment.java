package com.sputnik.oboarding.ui.registration;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.login.BadAddressPopup;
import com.sputnik.common.entities.localization.entities.login.ConfirmAddressBodyLocale;
import com.sputnik.common.entities.localization.entities.login.ConfirmAddressLocale;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.domain.common.Event;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.analytics.yandex.OnBoardingEvents;
import com.sputnik.oboarding.databinding.FragmentRegNotMyAddressBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: NotMyAddressFragment.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/NotMyAddressFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentRegNotMyAddressBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentRegNotMyAddressBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/support/ISupportManager;", "supportManager", "Lcom/sputnik/common/support/ISupportManager;", "getSupportManager", "()Lcom/sputnik/common/support/ISupportManager;", "setSupportManager", "(Lcom/sputnik/common/support/ISupportManager;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NotMyAddressFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(NotMyAddressFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentRegNotMyAddressBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    public ISupportManager supportManager;

    private final FragmentRegNotMyAddressBinding getBinding() {
        return (FragmentRegNotMyAddressBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    public final ISupportManager getSupportManager() {
        ISupportManager iSupportManager = this.supportManager;
        if (iSupportManager != null) {
            return iSupportManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("supportManager");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
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
        FragmentRegNotMyAddressBinding binding = getBinding();
        binding.btnReconnect.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.NotMyAddressFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotMyAddressFragment.initView$lambda$2$lambda$0(this.f$0, view);
            }
        });
        binding.tvSupport.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.NotMyAddressFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotMyAddressFragment.initView$lambda$2$lambda$1(this.f$0, view);
            }
        });
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        profileViewModel.observeSubState(viewLifecycleOwner, new Function1<ProfileViewState, Event<? extends Boolean>>() { // from class: com.sputnik.oboarding.ui.registration.NotMyAddressFragment.initView.2
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isDeactivated();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.NotMyAddressFragment.initView.3
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
                    NotMyAddressFragment notMyAddressFragment = NotMyAddressFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        IProfileViewModel.DefaultImpls.loadProfile$default(notMyAddressFragment.getProfileViewModel(), false, 1, null);
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(notMyAddressFragment), R$id.notMyAddressFragment, R$id.action_notMyAddressFragment_to_connectToIntercomFragment, null, null, 12, null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$0(NotMyAddressFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationAddressRejoinEvent());
        this$0.getProfileViewModel().declineBindToFlat();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1(NotMyAddressFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationWrongAddressTpEvent());
        ISupportManager.DefaultImpls.displayMessenger$default(this$0.getSupportManager(), null, 1, null);
    }

    private final void localize() {
        ConfirmAddressLocale confirmAddress;
        ConfirmAddressBodyLocale body;
        FragmentRegNotMyAddressBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        BadAddressPopup badAddressPopup = (data == null || (confirmAddress = data.getConfirmAddress()) == null || (body = confirmAddress.getBody()) == null) ? null : body.getBadAddressPopup();
        Intrinsics.checkNotNull(badAddressPopup);
        binding.title.setText(badAddressPopup.getTitle());
        binding.tvError.setText(badAddressPopup.getBody());
        binding.tvSupport.setText(badAddressPopup.getSupportButton().getTitle());
        binding.btnReconnect.setText(badAddressPopup.getCancelButton().getTitle());
    }

    public NotMyAddressFragment() {
        super(R$layout.fragment_reg_not_my_address);
        this.binding = new ViewBindingFragmentDelegate(this, NotMyAddressFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.NotMyAddressFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.NotMyAddressFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.NotMyAddressFragment$profileViewModel$2
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
