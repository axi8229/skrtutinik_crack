package com.sputnik.oboarding.ui.registration;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.AnalyticsTracker;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.registration.AccountErrors;
import com.sputnik.common.entities.localization.entities.registration.AccountsBodyLocale;
import com.sputnik.common.entities.localization.entities.registration.AccountsLocale;
import com.sputnik.common.entities.sessions.LocalSession;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.LoginViewModel;
import com.sputnik.common.viewmodels.LoginViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.R$string;
import com.sputnik.oboarding.databinding.FragmentSelectAccountBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import com.sputnik.oboarding.ui.registration.adapter.AccountsAdapter;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: SelectAccountFragment.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010=\u001a\u0004\bC\u0010DR\u001b\u0010J\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010=\u001a\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006Q"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/SelectAccountFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "updateOnBoardingIsShown", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentSelectAccountBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentSelectAccountBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "Lkotlin/Lazy;", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel$delegate", "getLoginViewModel", "()Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel", "", "needToShowError", "Z", "Lcom/sputnik/oboarding/ui/registration/adapter/AccountsAdapter;", "accountsAdapter", "Lcom/sputnik/oboarding/ui/registration/adapter/AccountsAdapter;", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SelectAccountFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SelectAccountFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentSelectAccountBinding;", 0))};
    private AccountsAdapter accountsAdapter;
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    /* renamed from: loginViewModel$delegate, reason: from kotlin metadata */
    private final Lazy loginViewModel;
    private boolean needToShowError;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSelectAccountBinding getBinding() {
        return (FragmentSelectAccountBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    public final AllCamerasViewModel.Factory.AssistFactory getCameraViewModelFactory() {
        AllCamerasViewModel.Factory.AssistFactory assistFactory = this.cameraViewModelFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cameraViewModelFactory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AllCamerasViewModel getCamerasViewModel() {
        return (AllCamerasViewModel) this.camerasViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoginViewModel getLoginViewModel() {
        return (LoginViewModel) this.loginViewModel.getValue();
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
        updateOnBoardingIsShown();
        initView();
        LoginViewModel loginViewModel = getLoginViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        loginViewModel.observeNotifications(viewLifecycleOwner, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment.onViewCreated.1
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
                SelectAccountFragment selectAccountFragment = SelectAccountFragment.this;
                NestedScrollView root = selectAccountFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(selectAccountFragment, root, it);
            }
        });
        getLoginViewModel().loadAccounts();
        LoginViewModel loginViewModel2 = getLoginViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        loginViewModel2.observeState(viewLifecycleOwner2, new Function1<LoginViewState, Unit>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment.onViewCreated.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LoginViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LoginViewState loginViewState) {
                invoke2(loginViewState);
                return Unit.INSTANCE;
            }
        });
        LoginViewModel loginViewModel3 = getLoginViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        loginViewModel3.observeNotifications(viewLifecycleOwner3, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment.onViewCreated.3
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
                SelectAccountFragment selectAccountFragment = SelectAccountFragment.this;
                NestedScrollView root = selectAccountFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(selectAccountFragment, root, it);
            }
        });
        LoginViewModel loginViewModel4 = getLoginViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        loginViewModel4.observeSubState(viewLifecycleOwner4, new Function1<LoginViewState, Boolean>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment.onViewCreated.4
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LoginViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getSessionsState().getIsAddingAccountLocked());
            }
        }, new Function1<Boolean, Unit>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment.onViewCreated.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                ConstraintLayout btnCreateAccount = SelectAccountFragment.this.getBinding().btnCreateAccount;
                Intrinsics.checkNotNullExpressionValue(btnCreateAccount, "btnCreateAccount");
                ViewBindingUtilsKt.visibilityBasedOn(btnCreateAccount, Boolean.valueOf(!z));
            }
        });
        LoginViewModel loginViewModel5 = getLoginViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        loginViewModel5.observeSubState(viewLifecycleOwner5, new Function1<LoginViewState, List<? extends LocalSession>>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment.onViewCreated.6
            @Override // kotlin.jvm.functions.Function1
            public final List<LocalSession> invoke(LoginViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getSessionsState().getAccounts();
            }
        }, new Function1<List<? extends LocalSession>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment.onViewCreated.7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends LocalSession> list) {
                invoke2((List<LocalSession>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<LocalSession> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SelectAccountFragment.this.accountsAdapter.submitList(it);
                CardView layoutNoAccounts = SelectAccountFragment.this.getBinding().layoutNoAccounts;
                Intrinsics.checkNotNullExpressionValue(layoutNoAccounts, "layoutNoAccounts");
                ViewBindingUtilsKt.visibilityBasedOn(layoutNoAccounts, Boolean.valueOf(it.isEmpty()));
                ConstraintLayout layoutHasAccounts = SelectAccountFragment.this.getBinding().layoutHasAccounts;
                Intrinsics.checkNotNullExpressionValue(layoutHasAccounts, "layoutHasAccounts");
                ViewBindingUtilsKt.visibilityBasedOn(layoutHasAccounts, Boolean.valueOf(!it.isEmpty()));
            }
        });
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        profileViewModel.observeSubState(viewLifecycleOwner6, new Function1<ProfileViewState, Resource.Status>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment.onViewCreated.8
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileServerState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment.onViewCreated.9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource.Status status) {
                invoke2(status);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource.Status it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LinearLayout layoutProgress = SelectAccountFragment.this.getBinding().layoutProgress;
                Intrinsics.checkNotNullExpressionValue(layoutProgress, "layoutProgress");
                ViewBindingUtilsKt.visibilityBasedOn(layoutProgress, Boolean.valueOf(it == Resource.Status.LOADING));
            }
        });
        ProfileViewModel profileViewModel2 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        profileViewModel2.observeSubState(viewLifecycleOwner7, new Function1<ProfileViewState, Event<? extends ProfileNavigationState>>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment.onViewCreated.10
            @Override // kotlin.jvm.functions.Function1
            public final Event<ProfileNavigationState> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileState();
            }
        }, new Function1<Event<? extends ProfileNavigationState>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment.onViewCreated.11
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
                if (Intrinsics.areEqual(SelectAccountFragment.this.getProfileViewModel().getCurrentState().getNeedToClearNavigationState().getContentIfNotHandled(), Boolean.TRUE)) {
                    SelectAccountFragment.this.getProfileViewModel().cleanEvents();
                }
                ProfileNavigationState contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    SelectAccountFragment selectAccountFragment = SelectAccountFragment.this;
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToRegistrationState) {
                        selectAccountFragment.getAnalytics().trackLogEvent(new AnalyticsTracker.Event("account_state", "unregistered", null, 4, null));
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(selectAccountFragment), R$id.selectAccountFragment, R$id.action_selectAccountFragment_to_enterNameFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToVerifyAddressState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(selectAccountFragment), R$id.selectAccountFragment, R$id.action_selectAccountFragment_to_confirmAddressFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToEnterFlatNumberState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(selectAccountFragment), R$id.selectAccountFragment, R$id.action_selectAccountFragment_to_enterFlatNumberFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToIntercomState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(selectAccountFragment), R$id.selectAccountFragment, R$id.action_selectAccountFragment_to_connectToIntercomFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToActivatedState) {
                        Uri uri = Uri.parse(selectAccountFragment.getString(R$string.deeplink_main));
                        selectAccountFragment.getCamerasViewModel().setNeedLoadCameras(true);
                        FragmentKt.findNavController(selectAccountFragment).popBackStack(R$id.selectAccountFragment, true);
                        NavController navControllerFindNavController = FragmentKt.findNavController(selectAccountFragment);
                        Intrinsics.checkNotNull(uri);
                        navControllerFindNavController.navigate(uri);
                    }
                }
            }
        });
        ProfileViewModel profileViewModel3 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "getViewLifecycleOwner(...)");
        profileViewModel3.observeSubState(viewLifecycleOwner8, new Function1<ProfileViewState, Event<? extends Boolean>>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment.onViewCreated.12
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isAccountDeleted();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment.onViewCreated.13
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) {
                invoke2((Event<Boolean>) event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<Boolean> it) {
                AccountsLocale accounts;
                AccountErrors errors;
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getContentIfNotHandled() != null) {
                    SelectAccountFragment selectAccountFragment = SelectAccountFragment.this;
                    if (selectAccountFragment.needToShowError) {
                        selectAccountFragment.getProfileViewModel().clearAfterAccountCheck();
                        selectAccountFragment.getLoginViewModel().clearAccount();
                        LoginViewModel loginViewModel6 = selectAccountFragment.getLoginViewModel();
                        LocalizationLocalModel data = selectAccountFragment.getLocalizationStorage().getData();
                        loginViewModel6.notifyErrorMessage((data == null || (accounts = data.getAccounts()) == null || (errors = accounts.getErrors()) == null) ? null : errors.getAccountExpired());
                        selectAccountFragment.needToShowError = false;
                    }
                    selectAccountFragment.getLoginViewModel().loadAccounts();
                }
            }
        });
    }

    private final void initView() {
        FragmentSelectAccountBinding binding = getBinding();
        RecyclerView recyclerView = binding.rvAccounts;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.accountsAdapter);
        binding.btnCreateAccount.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectAccountFragment.initView$lambda$2$lambda$1(this.f$0, view);
            }
        });
        ConstraintLayout rootView = binding.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }

    public SelectAccountFragment() {
        super(R$layout.fragment_select_account);
        this.binding = new ViewBindingFragmentDelegate(this, SelectAccountFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment$camerasViewModel$2
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
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.loginViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment$special$$inlined$activityViewModels$default$7
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment$loginViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.accountsAdapter = new AccountsAdapter(new Function1<LocalSession, Unit>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment$accountsAdapter$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LocalSession localSession) {
                invoke2(localSession);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LocalSession it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (this.this$0.getLoginViewModel().checkSessionByPhone(it.getCountryCode() + it.getPhone())) {
                    this.this$0.needToShowError = true;
                    LinearLayout layoutProgress = this.this$0.getBinding().layoutProgress;
                    Intrinsics.checkNotNullExpressionValue(layoutProgress, "layoutProgress");
                    ViewKt.visible(layoutProgress);
                    this.this$0.getLoginViewModel().selectSession(it);
                    this.this$0.getProfileViewModel().loadProfile(false);
                }
            }
        }, new Function1<LocalSession, Unit>() { // from class: com.sputnik.oboarding.ui.registration.SelectAccountFragment$accountsAdapter$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LocalSession localSession) {
                invoke2(localSession);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LocalSession it) {
                Intrinsics.checkNotNullParameter(it, "it");
                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this.this$0), R$id.action_selectAccountFragment_to_deleteSessionBottomSheet, BundleKt.bundleOf(TuplesKt.to("session_jwt", it.getJwt())), null, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1(SelectAccountFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.action_selectAccountFragment_to_enterPhoneFragment, null, null, 6, null);
    }

    private final void updateOnBoardingIsShown() {
        getPrefManager().updateShowStartOnBoarding(false);
    }

    private final void localize() {
        TextTitle createButton;
        AccountsLocale accounts;
        FragmentSelectAccountBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        String title = null;
        AccountsBodyLocale body = (data == null || (accounts = data.getAccounts()) == null) ? null : accounts.getBody();
        binding.title.setText(body != null ? body.getTitle() : null);
        binding.tvNoAccount.setText(body != null ? body.getNoAccounts() : null);
        TextView textView = binding.tvCreateButton;
        if (body != null && (createButton = body.getCreateButton()) != null) {
            title = createButton.getTitle();
        }
        textView.setText(title);
    }
}
