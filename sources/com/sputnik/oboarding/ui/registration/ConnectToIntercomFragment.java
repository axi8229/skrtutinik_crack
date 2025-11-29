package com.sputnik.oboarding.ui.registration;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.work.Data;
import com.chaos.view.PinView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.AnalyticsTracker;
import com.sputnik.common.base.BaseFragment;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.common.entities.invites.Invite;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.NotificationLocale;
import com.sputnik.common.entities.localization.NotificationLocaleBody;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.login.DomofonBody;
import com.sputnik.common.entities.localization.entities.login.DomofonCode;
import com.sputnik.common.entities.localization.entities.login.DomofonLocale;
import com.sputnik.common.entities.localization.entities.login.DomofonTiming;
import com.sputnik.common.entities.localization.entities.login.DomofonTimingStatus;
import com.sputnik.common.entities.profile.Profile;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.InvitesViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.R$string;
import com.sputnik.oboarding.analytics.yandex.OnBoardingEvents;
import com.sputnik.oboarding.databinding.FragmentRegConnectIntercomBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import com.sputnik.oboarding.entities.connect_intercom.ActivationCode;
import com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewModel;
import com.sputnik.oboarding.ui.registration.viewmodel.ConnectIntercomViewState;
import com.sputnik.oboarding.workmanager.ReminderRegistrationWork;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

/* compiled from: ConnectToIntercomFragment.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u0003R\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010I\u001a\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010I\u001a\u0004\bT\u0010UR\u001b\u0010[\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010I\u001a\u0004\bY\u0010ZR\u001b\u0010^\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010I\u001a\u0004\b^\u0010_R\u001d\u0010d\u001a\u0004\u0018\u00010`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010I\u001a\u0004\bb\u0010cR\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020`0e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010g¨\u0006h"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/ConnectToIntercomFragment;", "Lcom/sputnik/common/base/BaseFragment;", "<init>", "()V", "", "initRegistrationReminder", "", "count", "renderCount", "(I)V", "Lcom/sputnik/oboarding/ui/registration/viewmodel/ConnectIntercomViewState;", RemoteMessageConst.DATA, "renderIntercomUi", "(Lcom/sputnik/oboarding/ui/registration/viewmodel/ConnectIntercomViewState;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "onStop", "initViews", "localize", "Lcom/sputnik/oboarding/databinding/FragmentRegConnectIntercomBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentRegConnectIntercomBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "camerasFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCamerasFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCamerasFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/oboarding/ui/registration/viewmodel/ConnectIntercomViewModel;", "connectIntercomViewModel$delegate", "Lkotlin/Lazy;", "getConnectIntercomViewModel", "()Lcom/sputnik/oboarding/ui/registration/viewmodel/ConnectIntercomViewModel;", "connectIntercomViewModel", "Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel$delegate", "getInvitesViewModel", "()Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "", "isFromAddingAddress$delegate", "isFromAddingAddress", "()Z", "Lcom/sputnik/common/entities/addresses/UserAddress;", "address$delegate", "getAddress", "()Lcom/sputnik/common/entities/addresses/UserAddress;", "address", "", "originalAddressesList", "Ljava/util/List;", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConnectToIntercomFragment extends BaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ConnectToIntercomFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentRegConnectIntercomBinding;", 0))};

    /* renamed from: address$delegate, reason: from kotlin metadata */
    private final Lazy address;
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public AllCamerasViewModel.Factory.AssistFactory camerasFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;

    /* renamed from: connectIntercomViewModel$delegate, reason: from kotlin metadata */
    private final Lazy connectIntercomViewModel;
    public MultiViewModelFactory factory;

    /* renamed from: invitesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy invitesViewModel;

    /* renamed from: isFromAddingAddress$delegate, reason: from kotlin metadata */
    private final Lazy isFromAddingAddress;
    public LocalizationStorage localizationScreen;
    private final List<UserAddress> originalAddressesList;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentRegConnectIntercomBinding getBinding() {
        return (FragmentRegConnectIntercomBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    public final AllCamerasViewModel.Factory.AssistFactory getCamerasFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.camerasFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("camerasFactory");
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

    private final ConnectIntercomViewModel getConnectIntercomViewModel() {
        return (ConnectIntercomViewModel) this.connectIntercomViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InvitesViewModel getInvitesViewModel() {
        return (InvitesViewModel) this.invitesViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AllCamerasViewModel getCamerasViewModel() {
        return (AllCamerasViewModel) this.camerasViewModel.getValue();
    }

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
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

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        OnBoardingComponentKt.onBoardingComponent(this).inject(this);
        super.onAttach(context);
    }

    @Override // com.sputnik.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        List<UserAddress> listEmptyList;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        List<UserAddress> list = this.originalAddressesList;
        list.clear();
        Profile profile = getProfileViewModel().getCurrentState().getProfile();
        if (profile == null || (listEmptyList = profile.getAddresses()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        list.addAll(listEmptyList);
        if (isFromAddingAddress()) {
            UserAddress address = getAddress();
            ProfileNavigationState navigationStateForAddress = address != null ? address.getNavigationStateForAddress() : null;
            if (navigationStateForAddress != null) {
                if (navigationStateForAddress instanceof ProfileNavigationState.ToVerifyAddressState) {
                    getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationStepThreeCheckEvent());
                    getCamerasViewModel().loadMainCameras();
                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.action_connectToIntercomFragment_to_confirmAddressFragment, BundleKt.bundleOf(TuplesKt.to("item", getAddress()), TuplesKt.to("is_adding_address", Boolean.valueOf(isFromAddingAddress()))), null, 4, null);
                } else if (navigationStateForAddress instanceof ProfileNavigationState.ToEnterFlatNumberState) {
                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.action_connectToIntercomFragment_to_enterFlatNumberFragment, BundleKt.bundleOf(TuplesKt.to("item", getAddress()), TuplesKt.to("is_adding_address", Boolean.valueOf(isFromAddingAddress()))), null, 4, null);
                }
            }
        } else {
            ProfileViewModel profileViewModel = getProfileViewModel();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            profileViewModel.observeState(viewLifecycleOwner, new Function1<ProfileViewState, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment.onViewCreated.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ProfileViewState profileViewState) throws Resources.NotFoundException {
                    invoke2(profileViewState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ProfileViewState it) throws Resources.NotFoundException {
                    List<UserAddress> addresses;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (ConnectToIntercomFragment.this.isFromAddingAddress()) {
                        Profile profile2 = it.getProfile();
                        if (profile2 == null || (addresses = profile2.getAddresses()) == null) {
                            return;
                        }
                        ConnectToIntercomFragment connectToIntercomFragment = ConnectToIntercomFragment.this;
                        if (addresses.size() != connectToIntercomFragment.originalAddressesList.size()) {
                            CollectionsKt.minus((Iterable) addresses, (Iterable) connectToIntercomFragment.originalAddressesList);
                            return;
                        }
                        return;
                    }
                    ProfileNavigationState contentIfNotHandled = it.getProfileState().getContentIfNotHandled();
                    if (contentIfNotHandled != null) {
                        ConnectToIntercomFragment connectToIntercomFragment2 = ConnectToIntercomFragment.this;
                        if (contentIfNotHandled instanceof ProfileNavigationState.ToVerifyAddressState) {
                            connectToIntercomFragment2.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationStepThreeCheckEvent());
                            connectToIntercomFragment2.getCamerasViewModel().loadMainCameras();
                            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(connectToIntercomFragment2), R$id.connectToIntercomFragment, R$id.action_connectToIntercomFragment_to_confirmAddressFragment, null, null, 12, null);
                        } else if (contentIfNotHandled instanceof ProfileNavigationState.ToEnterFlatNumberState) {
                            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(connectToIntercomFragment2), R$id.connectToIntercomFragment, R$id.action_connectToIntercomFragment_to_enterFlatNumberFragment, null, null, 12, null);
                        }
                    }
                }
            });
        }
        TextView tvSetupLater = getBinding().tvSetupLater;
        Intrinsics.checkNotNullExpressionValue(tvSetupLater, "tvSetupLater");
        ViewBindingUtilsKt.visibilityBasedOn(tvSetupLater, Boolean.valueOf(!isFromAddingAddress()));
        getBinding().tvSetupLater.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws Resources.NotFoundException {
                ConnectToIntercomFragment.onViewCreated$lambda$2(this.f$0, view2);
            }
        });
        ConnectIntercomViewModel connectIntercomViewModel = getConnectIntercomViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        connectIntercomViewModel.observeState(viewLifecycleOwner2, new AnonymousClass5(this));
        ConnectIntercomViewModel connectIntercomViewModel2 = getConnectIntercomViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        connectIntercomViewModel2.observeSubState(viewLifecycleOwner3, new Function1<ConnectIntercomViewState, Integer>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment.onViewCreated.6
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(ConnectIntercomViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.getCount());
            }
        }, new AnonymousClass7(this));
        ConnectIntercomViewModel connectIntercomViewModel3 = getConnectIntercomViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        connectIntercomViewModel3.observeNotifications(viewLifecycleOwner4, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment.onViewCreated.8
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
                ConnectToIntercomFragment connectToIntercomFragment = ConnectToIntercomFragment.this;
                NestedScrollView root = connectToIntercomFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(connectToIntercomFragment, root, it);
            }
        });
        ConstraintLayout rootView = getBinding().rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
        InvitesViewModel invitesViewModel = getInvitesViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        invitesViewModel.observeState(viewLifecycleOwner5, new Function1<InvitesViewState, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment.onViewCreated.9

            /* compiled from: ConnectToIntercomFragment.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$onViewCreated$9$WhenMappings */
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
                    ConnectToIntercomFragment.this.getInvitesViewModel().clearState();
                    NavControllerKt.safeNavigate$default(FragmentKt.findNavController(ConnectToIntercomFragment.this), R$id.action_to_inviteFragment, null, null, 6, null);
                }
            }
        });
        InvitesViewModel invitesViewModel2 = getInvitesViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        invitesViewModel2.observeNotifications(viewLifecycleOwner6, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment.onViewCreated.10
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
                ConnectToIntercomFragment connectToIntercomFragment = ConnectToIntercomFragment.this;
                NestedScrollView root = connectToIntercomFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(connectToIntercomFragment, root, it);
            }
        });
        if (getInvitesViewModel().getCurrentState().getInvites().peekContent().isEmpty()) {
            getInvitesViewModel().loadInvites();
        }
        getAnalytics().trackLogEvent(new AnalyticsTracker.Event("domofonConnection", "show", null, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(ConnectToIntercomFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationStepThreeLaterEvent());
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.connectToIntercomFragment, R$id.action_connectToIntercomFragment_to_noIntercomDialog, null, null, 12, null);
    }

    /* compiled from: ConnectToIntercomFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$onViewCreated$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<ConnectIntercomViewState, Unit> {
        AnonymousClass5(Object obj) {
            super(1, obj, ConnectToIntercomFragment.class, "renderIntercomUi", "renderIntercomUi(Lcom/sputnik/oboarding/ui/registration/viewmodel/ConnectIntercomViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ConnectIntercomViewState connectIntercomViewState) {
            invoke2(connectIntercomViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ConnectIntercomViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ConnectToIntercomFragment) this.receiver).renderIntercomUi(p0);
        }
    }

    /* compiled from: ConnectToIntercomFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$onViewCreated$7, reason: invalid class name */
    /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
        AnonymousClass7(Object obj) {
            super(1, obj, ConnectToIntercomFragment.class, "renderCount", "renderCount(I)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i) {
            ((ConnectToIntercomFragment) this.receiver).renderCount(i);
        }
    }

    public ConnectToIntercomFragment() {
        super(R$layout.fragment_reg_connect_intercom);
        this.binding = new ViewBindingFragmentDelegate(this, ConnectToIntercomFragment$binding$2.INSTANCE);
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$connectIntercomViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$special$$inlined$viewModels$default$2
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
        this.connectIntercomViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ConnectIntercomViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$special$$inlined$viewModels$default$4
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
        this.invitesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InvitesViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = this.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$invitesViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$special$$inlined$activityViewModels$default$5
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
                CreationExtras defaultViewModelCreationExtras = this.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$camerasViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                WidgetsLocale widgets;
                AllCamerasViewModel.Factory.AssistFactory camerasFactory = this.this$0.getCamerasFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                return camerasFactory.create((data == null || (widgets = data.getWidgets()) == null) ? null : widgets.getFailureTitle());
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$special$$inlined$activityViewModels$default$7
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$special$$inlined$activityViewModels$default$8
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
                CreationExtras defaultViewModelCreationExtras = this.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.isFromAddingAddress = LazyKt.lazy(new Function0<Boolean>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment.isFromAddingAddress.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle arguments = ConnectToIntercomFragment.this.getArguments();
                return Boolean.valueOf(arguments != null ? arguments.getBoolean("is_adding_address", false) : false);
            }
        });
        this.address = LazyKt.lazy(new Function0<UserAddress>() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$address$2
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
        this.originalAddressesList = new ArrayList();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getProfileViewModel().startProfileJob();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getProfileViewModel().stopProfileJob();
    }

    private final void initRegistrationReminder() throws Throwable {
        NotificationLocale notification;
        NotificationLocaleBody applyDomofon;
        NotificationLocale notification2;
        NotificationLocaleBody applyDomofon2;
        ReminderRegistrationWork.Companion companion = ReminderRegistrationWork.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Pair pair = TuplesKt.to("reminderRegistrationWork_deeplink", getString(R$string.deeplink_splash));
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String body = null;
        Pair pair2 = TuplesKt.to("reminderRegistrationWork_title", (data == null || (notification2 = data.getNotification()) == null || (applyDomofon2 = notification2.getApplyDomofon()) == null) ? null : applyDomofon2.getTitle());
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        if (data2 != null && (notification = data2.getNotification()) != null && (applyDomofon = notification.getApplyDomofon()) != null) {
            body = applyDomofon.getBody();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderCount(int count) {
        DomofonLocale domofon;
        DomofonBody body;
        DomofonCode enterCode;
        DomofonTimingStatus status;
        DomofonTiming timing;
        int countdown_intercom_time = ConnectIntercomViewModel.INSTANCE.getCOUNTDOWN_INTERCOM_TIME() - count;
        int iMax = Math.max(countdown_intercom_time / 60, 0);
        int iMax2 = Math.max(countdown_intercom_time % 60, 0);
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data != null && (domofon = data.getDomofon()) != null && (body = domofon.getBody()) != null && (enterCode = body.getEnterCode()) != null && (status = enterCode.getStatus()) != null && (timing = status.getTiming()) != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02d " + timing.getMin() + " %02d " + timing.getSec(), Arrays.copyOf(new Object[]{Integer.valueOf(iMax), Integer.valueOf(iMax2)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            getBinding().tvTimerConnectCode.setText(String.format(timing.getTitle(), str));
        }
        TextView tvTimerConnectCode = getBinding().tvTimerConnectCode;
        Intrinsics.checkNotNullExpressionValue(tvTimerConnectCode, "tvTimerConnectCode");
        ViewBindingUtilsKt.visibilityHideBasedOn(tvTimerConnectCode, count != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderIntercomUi(ConnectIntercomViewState data) {
        DomofonLocale domofon;
        DomofonBody body;
        DomofonCode enterCode;
        DomofonLocale domofon2;
        DomofonBody body2;
        DomofonCode enterCode2;
        DomofonTimingStatus status;
        Resource.Status serverState = data.getServerState();
        Resource.Status status2 = Resource.Status.SUCCESS;
        if (serverState != status2) {
            TextView textView = getBinding().tvCodeTitle;
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            textView.setText((data2 == null || (domofon2 = data2.getDomofon()) == null || (body2 = domofon2.getBody()) == null || (enterCode2 = body2.getEnterCode()) == null || (status = enterCode2.getStatus()) == null) ? null : status.getGetting());
            PinView llCodes = getBinding().llCodes;
            Intrinsics.checkNotNullExpressionValue(llCodes, "llCodes");
            ViewKt.invisible(llCodes);
        }
        if (data.getServerState() == status2) {
            FragmentRegConnectIntercomBinding binding = getBinding();
            TextView textView2 = binding.tvCodeTitle;
            LocalizationLocalModel data3 = getLocalizationScreen().getData();
            textView2.setText((data3 == null || (domofon = data3.getDomofon()) == null || (body = domofon.getBody()) == null || (enterCode = body.getEnterCode()) == null) ? null : enterCode.getTitle());
            PinView llCodes2 = binding.llCodes;
            Intrinsics.checkNotNullExpressionValue(llCodes2, "llCodes");
            ViewKt.visible(llCodes2);
            PinView pinView = binding.llCodes;
            ActivationCode codeResponse = data.getCodeResponse();
            pinView.setText(codeResponse != null ? codeResponse.getCode() : null);
        }
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
        FragmentRegConnectIntercomBinding binding = getBinding();
        ImageView btnClose = binding.btnClose;
        Intrinsics.checkNotNullExpressionValue(btnClose, "btnClose");
        ViewBindingUtilsKt.visibilityBasedOn(btnClose, Boolean.valueOf(isFromAddingAddress()));
        binding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.ConnectToIntercomFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectToIntercomFragment.initViews$lambda$6$lambda$5(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6$lambda$5(ConnectToIntercomFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).popBackStack(R$id.mainHostFragment, false);
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
        TextTitle noDomofonButton;
        DomofonLocale domofon;
        FragmentRegConnectIntercomBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        String title = null;
        DomofonBody body = (data == null || (domofon = data.getDomofon()) == null) ? null : domofon.getBody();
        binding.tvTitle.setText(body != null ? body.getTitle() : null);
        binding.tvCodeInfo.setText(body != null ? body.getSubtitle() : null);
        TextView textView = binding.tvSetupLater;
        if (body != null && (noDomofonButton = body.getNoDomofonButton()) != null) {
            title = noDomofonButton.getTitle();
        }
        textView.setText(title);
    }
}
