package com.sputnik.oboarding.ui.registration;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.work.Data;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.AnalyticsTracker;
import com.sputnik.common.analytics.MultiAddressEvents;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.common.entities.invites.Invite;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.NotificationLocale;
import com.sputnik.common.entities.localization.NotificationLocaleBody;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TextWith1Param;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import com.sputnik.common.entities.localization.entities.registration.StartRegistrationBodyLocale;
import com.sputnik.common.entities.localization.entities.registration.StartRegistrationLocale;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.InvitesViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import com.sputnik.oboarding.R$color;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.R$string;
import com.sputnik.oboarding.analytics.yandex.OnBoardingEvents;
import com.sputnik.oboarding.databinding.FragmentStartRegistrationBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import com.sputnik.oboarding.workmanager.ReminderRegistrationWork;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: StartRegistrationFragment.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0003J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b@\u0010AR\"\u0010D\u001a\u00020C8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010:\u001a\u0004\bL\u0010MR\u001b\u0010Q\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010:\u001a\u0004\bQ\u0010RR\u001d\u0010W\u001a\u0004\u0018\u00010S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010:\u001a\u0004\bU\u0010V¨\u0006X"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/StartRegistrationFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "initRegistrationReminder", "updateOnBoardingIsShown", "localize", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onResume", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentStartRegistrationBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentStartRegistrationBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel$delegate", "getInvitesViewModel", "()Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "", "isFromAddingAddress$delegate", "isFromAddingAddress", "()Z", "Lcom/sputnik/common/entities/addresses/UserAddress;", "address$delegate", "getAddress", "()Lcom/sputnik/common/entities/addresses/UserAddress;", "address", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StartRegistrationFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(StartRegistrationFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentStartRegistrationBinding;", 0))};

    /* renamed from: address$delegate, reason: from kotlin metadata */
    private final Lazy address;
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public MultiViewModelFactory factory;

    /* renamed from: invitesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy invitesViewModel;

    /* renamed from: isFromAddingAddress$delegate, reason: from kotlin metadata */
    private final Lazy isFromAddingAddress;
    public LocalizationStorage localizationStorage;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentStartRegistrationBinding getBinding() {
        return (FragmentStartRegistrationBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    public final PrefManager getPrefManager() {
        PrefManager prefManager = this.prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InvitesViewModel getInvitesViewModel() {
        return (InvitesViewModel) this.invitesViewModel.getValue();
    }

    public final AllCamerasViewModel.Factory.AssistFactory getCameraViewModelFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.cameraViewModelFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cameraViewModelFactory");
        return null;
    }

    private final AllCamerasViewModel getCamerasViewModel() {
        return (AllCamerasViewModel) this.camerasViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFromAddingAddress() {
        return ((Boolean) this.isFromAddingAddress.getValue()).booleanValue();
    }

    private final UserAddress getAddress() {
        return (UserAddress) this.address.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) throws Throwable {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            initRegistrationReminder();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        OnBoardingComponentKt.onBoardingComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Log.e("saved language", getPrefManager().getCurLocale());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        updateOnBoardingIsShown();
        initView();
        if (isFromAddingAddress()) {
            UserAddress address = getAddress();
            ProfileNavigationState navigationStateForAddress = address != null ? address.getNavigationStateForAddress() : null;
            if (navigationStateForAddress != null) {
                if (navigationStateForAddress instanceof ProfileNavigationState.ToRegistrationState) {
                    getAnalytics().trackLogEvent(new AnalyticsTracker.Event("account_state", "unregistered", null, 4, null));
                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.startRegistrationFragment, R$id.action_startRegistrationFragment_to_enterNameFragment, BundleKt.bundleOf(TuplesKt.to("item", getAddress()), TuplesKt.to("is_adding_address", Boolean.valueOf(isFromAddingAddress()))), null, 8, null);
                    return;
                } else if (navigationStateForAddress instanceof ProfileNavigationState.ToVerifyAddressState) {
                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.startRegistrationFragment, R$id.action_startRegistrationFragment_to_confirmAddressFragment, BundleKt.bundleOf(TuplesKt.to("item", getAddress()), TuplesKt.to("is_adding_address", Boolean.valueOf(isFromAddingAddress()))), null, 8, null);
                    return;
                } else if (navigationStateForAddress instanceof ProfileNavigationState.ToEnterFlatNumberState) {
                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.startRegistrationFragment, R$id.action_startRegistrationFragment_to_enterFlatNumberFragment, BundleKt.bundleOf(TuplesKt.to("item", getAddress()), TuplesKt.to("is_adding_address", Boolean.valueOf(isFromAddingAddress()))), null, 8, null);
                    return;
                } else {
                    if (navigationStateForAddress instanceof ProfileNavigationState.ToIntercomState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.startRegistrationFragment, R$id.action_startRegistrationFragment_to_connectToIntercomFragment, BundleKt.bundleOf(TuplesKt.to("item", getAddress()), TuplesKt.to("is_adding_address", Boolean.valueOf(isFromAddingAddress()))), null, 8, null);
                        return;
                    }
                    return;
                }
            }
        }
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        profileViewModel.observeSubState(viewLifecycleOwner, new Function1<ProfileViewState, Event<? extends ProfileNavigationState>>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Event<ProfileNavigationState> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileState();
            }
        }, new Function1<Event<? extends ProfileNavigationState>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment.onViewCreated.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends ProfileNavigationState> event) throws Resources.NotFoundException {
                invoke2(event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<? extends ProfileNavigationState> it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                if (StartRegistrationFragment.this.isFromAddingAddress()) {
                    return;
                }
                if (Intrinsics.areEqual(StartRegistrationFragment.this.getProfileViewModel().getCurrentState().getNeedToClearNavigationState().getContentIfNotHandled(), Boolean.TRUE)) {
                    StartRegistrationFragment.this.getProfileViewModel().cleanEvents();
                }
                ProfileNavigationState contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    StartRegistrationFragment startRegistrationFragment = StartRegistrationFragment.this;
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToRegistrationState) {
                        startRegistrationFragment.getAnalytics().trackLogEvent(new AnalyticsTracker.Event("account_state", "unregistered", null, 4, null));
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(startRegistrationFragment), R$id.startRegistrationFragment, R$id.action_startRegistrationFragment_to_enterNameFragment, null, null, 12, null);
                    } else if (contentIfNotHandled instanceof ProfileNavigationState.ToVerifyAddressState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(startRegistrationFragment), R$id.startRegistrationFragment, R$id.action_startRegistrationFragment_to_confirmAddressFragment, null, null, 12, null);
                    } else if (contentIfNotHandled instanceof ProfileNavigationState.ToEnterFlatNumberState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(startRegistrationFragment), R$id.startRegistrationFragment, R$id.action_startRegistrationFragment_to_enterFlatNumberFragment, null, null, 12, null);
                    } else if (contentIfNotHandled instanceof ProfileNavigationState.ToIntercomState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(startRegistrationFragment), R$id.startRegistrationFragment, R$id.action_startRegistrationFragment_to_connectToIntercomFragment, null, null, 12, null);
                    }
                }
            }
        });
        InvitesViewModel invitesViewModel = getInvitesViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        invitesViewModel.observeState(viewLifecycleOwner2, new Function1<InvitesViewState, Unit>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment.onViewCreated.4

            /* compiled from: StartRegistrationFragment.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.oboarding.ui.registration.StartRegistrationFragment$onViewCreated$4$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Resource.Status.values().length];
                    try {
                        iArr[Resource.Status.SUCCESS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InvitesViewState invitesViewState) {
                invoke2(invitesViewState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InvitesViewState it) {
                List<Invite> contentIfNotHandled;
                Intrinsics.checkNotNullParameter(it, "it");
                if (WhenMappings.$EnumSwitchMapping$0[it.getServerState().ordinal()] == 1 && (contentIfNotHandled = it.getInvites().getContentIfNotHandled()) != null && (!contentIfNotHandled.isEmpty())) {
                    StartRegistrationFragment.this.getInvitesViewModel().clearState();
                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(StartRegistrationFragment.this), R$id.action_to_inviteFragment, null, null, 6, null);
                }
            }
        });
        InvitesViewModel invitesViewModel2 = getInvitesViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        invitesViewModel2.observeNotifications(viewLifecycleOwner3, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment.onViewCreated.5
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
                StartRegistrationFragment startRegistrationFragment = StartRegistrationFragment.this;
                NestedScrollView root = startRegistrationFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(startRegistrationFragment, root, it);
            }
        });
        getInvitesViewModel().loadInvites();
    }

    public StartRegistrationFragment() {
        super(R$layout.fragment_start_registration);
        this.binding = new ViewBindingFragmentDelegate(this, StartRegistrationFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.invitesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InvitesViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment$invitesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment$special$$inlined$activityViewModels$default$7
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment$camerasViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                WidgetsLocale widgets;
                AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory = this.this$0.getCameraViewModelFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationStorage().getData();
                return cameraViewModelFactory.create((data == null || (widgets = data.getWidgets()) == null) ? null : widgets.getFailureTitle());
            }
        });
        this.isFromAddingAddress = LazyKt.lazy(new Function0<Boolean>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment.isFromAddingAddress.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle arguments = StartRegistrationFragment.this.getArguments();
                return Boolean.valueOf(arguments != null ? arguments.getBoolean("is_adding_address", false) : false);
            }
        });
        this.address = LazyKt.lazy(new Function0<UserAddress>() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment$address$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UserAddress invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (UserAddress) (arguments != null ? arguments.get("item") : null);
            }
        });
    }

    private final void initView() {
        FragmentStartRegistrationBinding binding = getBinding();
        ImageView btnClose = binding.btnClose;
        Intrinsics.checkNotNullExpressionValue(btnClose, "btnClose");
        ViewBindingUtilsKt.visibilityBasedOn(btnClose, Boolean.valueOf(isFromAddingAddress()));
        AppCompatButton btnHasAccount = binding.btnHasAccount;
        Intrinsics.checkNotNullExpressionValue(btnHasAccount, "btnHasAccount");
        ViewBindingUtilsKt.visibilityBasedOn(btnHasAccount, Boolean.valueOf(!isFromAddingAddress()));
        binding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StartRegistrationFragment.initView$lambda$4$lambda$1(this.f$0, view);
            }
        });
        binding.btnAccept.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                StartRegistrationFragment.initView$lambda$4$lambda$2(this.f$0, view);
            }
        });
        binding.btnHasAccount.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.StartRegistrationFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                StartRegistrationFragment.initView$lambda$4$lambda$3(this.f$0, view);
            }
        });
        ConstraintLayout rootView = binding.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$1(StartRegistrationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).popBackStack(R$id.mainHostFragment, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$2(StartRegistrationFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new MultiAddressEvents.ClickNearToIntercomBtn(this$0.getPrefManager().getCurrentAddresses().isEmpty()));
        this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationStartEvent());
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.startRegistrationFragment, R$id.action_startRegistrationFragment_to_connectToIntercomFragment, BundleKt.bundleOf(TuplesKt.to("is_adding_address", Boolean.valueOf(this$0.isFromAddingAddress()))), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$3(StartRegistrationFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationUserHasAccEvent());
        Uri uri = Uri.parse(this$0.getString(R$string.deeplink_main_no_intercom));
        this$0.getCamerasViewModel().setNeedLoadCameras(true);
        this$0.getProfileViewModel().stopProfileJob();
        FragmentKt.findNavController(this$0).popBackStack(R$id.new_registration_navigation, true);
        NavController navControllerFindNavController = FragmentKt.findNavController(this$0);
        Intrinsics.checkNotNull(uri);
        navControllerFindNavController.navigate(uri);
    }

    private final void initRegistrationReminder() throws Throwable {
        NotificationLocale notification;
        NotificationLocaleBody register;
        NotificationLocale notification2;
        NotificationLocaleBody register2;
        ReminderRegistrationWork.Companion companion = ReminderRegistrationWork.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Pair pair = TuplesKt.to("reminderRegistrationWork_deeplink", getString(R$string.deeplink_splash));
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String body = null;
        Pair pair2 = TuplesKt.to("reminderRegistrationWork_title", (data == null || (notification2 = data.getNotification()) == null || (register2 = notification2.getRegister()) == null) ? null : register2.getTitle());
        LocalizationLocalModel data2 = getLocalizationStorage().getData();
        if (data2 != null && (notification = data2.getNotification()) != null && (register = notification.getRegister()) != null) {
            body = register.getBody();
        }
        Pair[] pairArr = {pair, pair2, TuplesKt.to("reminderRegistrationWork_subtitle", body)};
        Data.Builder builder = new Data.Builder();
        int i = 0;
        while (i < 3) {
            Pair pair3 = pairArr[i];
            i++;
            builder.put((String) pair3.getFirst(), pair3.getSecond());
        }
        Data dataBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(dataBuild, "dataBuilder.build()");
        companion.createRegistrationReminder(contextRequireContext, dataBuild);
    }

    private final void updateOnBoardingIsShown() {
        getPrefManager().updateShowStartOnBoarding(false);
    }

    private final void localize() {
        TextTitle setupLaterButton;
        TextTitle startButton;
        TitleWithParam step3;
        TitleWithParam step32;
        TextWith1Param subtitle;
        TextWith1Param subtitle2;
        StartRegistrationLocale startRegistration;
        FragmentStartRegistrationBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String title = null;
        StartRegistrationBodyLocale body = (data == null || (startRegistration = data.getStartRegistration()) == null) ? null : startRegistration.getBody();
        binding.title.setText(body != null ? body.getTitle() : null);
        TextView textView = binding.tvInfo;
        String strValueOf = String.valueOf((body == null || (subtitle2 = body.getSubtitle()) == null) ? null : subtitle2.getText());
        String strValueOf2 = String.valueOf((body == null || (subtitle = body.getSubtitle()) == null) ? null : subtitle.getParam1());
        Context contextRequireContext = requireContext();
        int i = R$color.sputnik_blue;
        textView.setText(ViewUtilsKt.highlightText(strValueOf, strValueOf2, ContextCompat.getColor(contextRequireContext, i)));
        ViewUtilsKt.highlightText(String.valueOf((body == null || (step32 = body.getStep3()) == null) ? null : step32.getTitle()), String.valueOf((body == null || (step3 = body.getStep3()) == null) ? null : step3.getParam1()), ContextCompat.getColor(requireContext(), i));
        binding.btnAccept.setText((body == null || (startButton = body.getStartButton()) == null) ? null : startButton.getTitle());
        AppCompatButton appCompatButton = binding.btnHasAccount;
        if (body != null && (setupLaterButton = body.getSetupLaterButton()) != null) {
            title = setupLaterButton.getTitle();
        }
        appCompatButton.setText(title);
    }
}
