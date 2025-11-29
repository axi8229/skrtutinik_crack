package com.sputnik.oboarding.ui.registration.ways.userSms;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
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
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.bumptech.glide.load.HttpException;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.AnalyticsTracker;
import com.sputnik.common.base.Notify;
import com.sputnik.common.base.SimpleDialog;
import com.sputnik.common.databinding.DialogErrorSplashBinding;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.AlertData;
import com.sputnik.common.entities.localization.AlertLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.AuthorizationBody;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.AutoSendSmsScreen;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.ManualSendSmsScreen;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.UserSms;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.CallCodeViewModel;
import com.sputnik.common.viewmodels.CallCodeViewState;
import com.sputnik.common.viewmodels.ErrorContainer;
import com.sputnik.common.viewmodels.LoginViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.domain.common.Errors;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import com.sputnik.oboarding.R$color;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.R$string;
import com.sputnik.oboarding.databinding.FragmentRegSendUserSmsBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: SendUserSmsFragment.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J!\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010@\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010@\u001a\u0004\bK\u0010LR\u001d\u0010R\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010@\u001a\u0004\bP\u0010QR\u001d\u0010U\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010@\u001a\u0004\bT\u0010QR\u0016\u0010W\u001a\u00020V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006Y"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/ways/userSms/SendUserSmsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "Lcom/sputnik/common/viewmodels/ErrorContainer;", "errorContainer", "renderError", "(Lcom/sputnik/common/viewmodels/ErrorContainer;)V", "Lcom/sputnik/common/viewmodels/CallCodeViewState;", RemoteMessageConst.DATA, "renderUi", "(Lcom/sputnik/common/viewmodels/CallCodeViewState;)V", "showCodeError", "showCodeExpiredError", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onResume", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentRegSendUserSmsBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentRegSendUserSmsBinding;", "binding", "Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "callCodeFactoryBuilder", "Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "getCallCodeFactoryBuilder", "()Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "setCallCodeFactoryBuilder", "(Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/CallCodeViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/sputnik/common/viewmodels/CallCodeViewModel;", "viewModel", "Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel$delegate", "getLoginViewModel", "()Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel", "", "phone$delegate", "getPhone", "()Ljava/lang/String;", "phone", "prettyPhone$delegate", "getPrettyPhone", "prettyPhone", "", "needNavigateToWaitingScreen", "Z", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SendUserSmsFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SendUserSmsFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentRegSendUserSmsBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public CallCodeViewModel.Factory.AssistFactory callCodeFactoryBuilder;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    /* renamed from: loginViewModel$delegate, reason: from kotlin metadata */
    private final Lazy loginViewModel;
    private boolean needNavigateToWaitingScreen;

    /* renamed from: phone$delegate, reason: from kotlin metadata */
    private final Lazy phone;

    /* renamed from: prettyPhone$delegate, reason: from kotlin metadata */
    private final Lazy prettyPhone;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(CallCodeViewState data) {
    }

    private final void showCodeError() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentRegSendUserSmsBinding getBinding() {
        return (FragmentRegSendUserSmsBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final CallCodeViewModel.Factory.AssistFactory getCallCodeFactoryBuilder() {
        CallCodeViewModel.Factory.AssistFactory assistFactory = this.callCodeFactoryBuilder;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callCodeFactoryBuilder");
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

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
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
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    private final CallCodeViewModel getViewModel() {
        return (CallCodeViewModel) this.viewModel.getValue();
    }

    private final LoginViewModel getLoginViewModel() {
        return (LoginViewModel) this.loginViewModel.getValue();
    }

    private final String getPhone() {
        return (String) this.phone.getValue();
    }

    private final String getPrettyPhone() {
        return (String) this.prettyPhone.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        OnBoardingComponentKt.onBoardingComponent(this).inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.needNavigateToWaitingScreen) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.action_sendUserSmsFragment_to_waitingUserSmsFragment, BundleKt.bundleOf(TuplesKt.to("phone", getPhone()), TuplesKt.to("pretty_phone", getPrettyPhone())), null, 4, null);
            this.needNavigateToWaitingScreen = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        initView();
        CallCodeViewModel viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        viewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
        CallCodeViewModel viewModel2 = getViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        viewModel2.observeSubState(viewLifecycleOwner2, new Function1<CallCodeViewState, Event<? extends Boolean>>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(CallCodeViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isLoaded();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment.onViewCreated.3
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
                Intrinsics.checkNotNullParameter(it, "it");
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    final SendUserSmsFragment sendUserSmsFragment = SendUserSmsFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        sendUserSmsFragment.getProfileViewModel().delayRequest(500L, new Function0<Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$onViewCreated$3$1$1
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
                                IProfileViewModel.DefaultImpls.loadProfile$default(sendUserSmsFragment.getProfileViewModel(), false, 1, null);
                            }
                        });
                    }
                }
            }
        });
        CallCodeViewModel viewModel3 = getViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        viewModel3.observeSubState(viewLifecycleOwner3, new AnonymousClass4(ErrorContainer.INSTANCE), new AnonymousClass5(this));
        CallCodeViewModel viewModel4 = getViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        viewModel4.observeNotifications(viewLifecycleOwner4, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment.onViewCreated.6
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
                SendUserSmsFragment sendUserSmsFragment = SendUserSmsFragment.this;
                NestedScrollView root = sendUserSmsFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(sendUserSmsFragment, root, it);
            }
        });
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        profileViewModel.observeSubState(viewLifecycleOwner5, new Function1<ProfileViewState, Event<? extends ProfileNavigationState>>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment.onViewCreated.7
            @Override // kotlin.jvm.functions.Function1
            public final Event<ProfileNavigationState> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileState();
            }
        }, new Function1<Event<? extends ProfileNavigationState>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment.onViewCreated.8
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
                ProfileNavigationState contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    SendUserSmsFragment sendUserSmsFragment = SendUserSmsFragment.this;
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToRegistrationState) {
                        sendUserSmsFragment.getAnalytics().trackLogEvent(new AnalyticsTracker.Event("account_state", "unregistered", null, 4, null));
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(sendUserSmsFragment), R$id.enterSmsCodeFragment, R$id.action_enterSmsCodeFragment_to_enterNameFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToVerifyAddressState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(sendUserSmsFragment), R$id.enterSmsCodeFragment, R$id.action_enterSmsCodeFragment_to_confirmAddressFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToEnterFlatNumberState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(sendUserSmsFragment), R$id.enterSmsCodeFragment, R$id.action_enterSmsCodeFragment_to_enterFlatNumberFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToIntercomState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(sendUserSmsFragment), R$id.enterSmsCodeFragment, R$id.action_enterSmsCodeFragment_to_connectToIntercomFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToActivatedState) {
                        Uri uri = Uri.parse(sendUserSmsFragment.getString(R$string.deeplink_main));
                        FragmentKt.findNavController(sendUserSmsFragment).popBackStack(R$id.startRegistrationFragment, true);
                        NavController navControllerFindNavController = FragmentKt.findNavController(sendUserSmsFragment);
                        Intrinsics.checkNotNull(uri);
                        navControllerFindNavController.navigate(uri);
                    }
                }
            }
        });
    }

    /* compiled from: SendUserSmsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<CallCodeViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, SendUserSmsFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/CallCodeViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CallCodeViewState callCodeViewState) {
            invoke2(callCodeViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CallCodeViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SendUserSmsFragment) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: SendUserSmsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$onViewCreated$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<CallCodeViewState, ErrorContainer> {
        AnonymousClass4(Object obj) {
            super(1, obj, ErrorContainer.Companion.class, "toErrorContainer", "toErrorContainer(Lcom/sputnik/common/viewmodels/CallCodeViewState;)Lcom/sputnik/common/viewmodels/ErrorContainer;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ErrorContainer invoke(CallCodeViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((ErrorContainer.Companion) this.receiver).toErrorContainer(p0);
        }
    }

    /* compiled from: SendUserSmsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$onViewCreated$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<ErrorContainer, Unit> {
        AnonymousClass5(Object obj) {
            super(1, obj, SendUserSmsFragment.class, "renderError", "renderError(Lcom/sputnik/common/viewmodels/ErrorContainer;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ErrorContainer errorContainer) {
            invoke2(errorContainer);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ErrorContainer p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SendUserSmsFragment) this.receiver).renderError(p0);
        }
    }

    private final void initView() {
        FragmentRegSendUserSmsBinding binding = getBinding();
        binding.btnRegisterOnTablet.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendUserSmsFragment.initView$lambda$2$lambda$0(this.f$0, view);
            }
        });
        binding.btnToSmsMessenger.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendUserSmsFragment.initView$lambda$2$lambda$1(this.f$0, view);
            }
        });
        FrameLayout rootView = binding.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }

    public SendUserSmsFragment() {
        super(R$layout.fragment_reg_send_user_sms);
        this.binding = new ViewBindingFragmentDelegate(this, SendUserSmsFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                CallCodeViewModel.Factory.AssistFactory callCodeFactoryBuilder = this.this$0.getCallCodeFactoryBuilder();
                Bundle arguments = this.this$0.getArguments();
                return callCodeFactoryBuilder.create((String) (arguments != null ? arguments.get("phone") : null));
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CallCodeViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function0;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM2230viewModels$lambda1 = FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM2230viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM2230viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function02);
        this.loginViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function0;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$loginViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.phone = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$phone$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("phone");
                }
                return null;
            }
        });
        this.prettyPhone = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$prettyPhone$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                if (arguments != null) {
                    return arguments.getString("pretty_phone");
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$0(SendUserSmsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.action_sendUserSmsFragment_to_sendUserSmsFromOtherDeviceFragment, BundleKt.bundleOf(TuplesKt.to("phone", this$0.getPhone()), TuplesKt.to("pretty_phone", this$0.getPrettyPhone())), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1(SendUserSmsFragment this$0, View view) {
        AuthorizationBody authorizationCode;
        UserSms userSms;
        AutoSendSmsScreen autoSendSmsScreen;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            LoginState.Session sessionByPhone = this$0.getLoginViewModel().getSessionByPhone();
            intent.setData(Uri.parse("smsto:" + (sessionByPhone != null ? sessionByPhone.getUserSmsPhone() : null)));
            LocalizationLocalModel data = this$0.getLocalizationStorage().getData();
            String safe = StringUtilsKt.formatSafe(String.valueOf((data == null || (authorizationCode = data.getAuthorizationCode()) == null || (userSms = authorizationCode.getUserSms()) == null || (autoSendSmsScreen = userSms.getAutoSendSmsScreen()) == null) ? null : autoSendSmsScreen.getSmsText()), String.valueOf(sessionByPhone != null ? sessionByPhone.getUserSmsCode() : null));
            intent.putExtra("sms_body", safe);
            intent.putExtra("text/plain", safe);
            this$0.startActivity(intent);
            this$0.needNavigateToWaitingScreen = true;
        } catch (Exception e) {
            this$0.needNavigateToWaitingScreen = false;
            e.printStackTrace();
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.action_sendUserSmsFragment_to_sendUserSmsFromOtherDeviceFragment, BundleKt.bundleOf(TuplesKt.to("phone", this$0.getPhone()), TuplesKt.to("pretty_phone", this$0.getPrettyPhone())), null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderError(ErrorContainer errorContainer) {
        Exception error = errorContainer.getError();
        if (error != null) {
            if (error instanceof Errors.Forbidden ? true : error instanceof Errors.UserInputError) {
                showCodeError();
            } else {
                HttpException httpException = error instanceof HttpException ? (HttpException) error : null;
                if ((httpException != null ? httpException.getStatusCode() : -1) == 422) {
                    showCodeExpiredError();
                }
            }
            getViewModel().clearError();
        }
    }

    /* compiled from: SendUserSmsFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dialog", "Landroid/app/AlertDialog;", "view", "Lcom/sputnik/common/databinding/DialogErrorSplashBinding;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$showCodeExpiredError$2, reason: invalid class name and case insensitive filesystem */
    static final class C07682 extends Lambda implements Function2<AlertDialog, DialogErrorSplashBinding, Unit> {
        C07682() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AlertDialog alertDialog, DialogErrorSplashBinding dialogErrorSplashBinding) {
            invoke2(alertDialog, dialogErrorSplashBinding);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AlertDialog dialog, DialogErrorSplashBinding view) {
            AlertLocale alert;
            TextTitle okButton;
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(view, "view");
            final SendUserSmsFragment sendUserSmsFragment = SendUserSmsFragment.this;
            LocalizationLocalModel data = sendUserSmsFragment.getLocalizationStorage().getData();
            if (data != null && (alert = data.getAlert()) != null) {
                TextView textView = view.errorName;
                AlertData attemptsExceeded = alert.getAttemptsExceeded();
                String title = null;
                textView.setText(attemptsExceeded != null ? attemptsExceeded.getTitle() : null);
                TextView textView2 = view.errorAdvice;
                AlertData attemptsExceeded2 = alert.getAttemptsExceeded();
                textView2.setText(attemptsExceeded2 != null ? attemptsExceeded2.getBody() : null);
                AppCompatButton appCompatButton = view.btnRepeat;
                AlertData attemptsExceeded3 = alert.getAttemptsExceeded();
                if (attemptsExceeded3 != null && (okButton = attemptsExceeded3.getOkButton()) != null) {
                    title = okButton.getTitle();
                }
                appCompatButton.setText(title);
            }
            view.btnRepeat.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$showCodeExpiredError$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SendUserSmsFragment.C07682.invoke$lambda$2$lambda$1(sendUserSmsFragment, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2$lambda$1(SendUserSmsFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FragmentKt.findNavController(this$0).navigateUp();
        }
    }

    /* compiled from: SendUserSmsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFragment$showCodeExpiredError$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C07671 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, DialogErrorSplashBinding> {
        public static final C07671 INSTANCE = new C07671();

        C07671() {
            super(3, DialogErrorSplashBinding.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/sputnik/common/databinding/DialogErrorSplashBinding;", 0);
        }

        public final DialogErrorSplashBinding invoke(LayoutInflater p0, ViewGroup viewGroup, boolean z) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return DialogErrorSplashBinding.inflate(p0, viewGroup, z);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ DialogErrorSplashBinding invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    private final void showCodeExpiredError() {
        SimpleDialog.Companion companion = SimpleDialog.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        companion.newInstance(contextRequireContext, C07671.INSTANCE, new C07682());
    }

    private final void localize() {
        AuthorizationBody authorizationCode;
        UserSms userSms;
        TitleWithParam title;
        TitleWithParam title2;
        TitleWithParam title3;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data == null || (authorizationCode = data.getAuthorizationCode()) == null || (userSms = authorizationCode.getUserSms()) == null) {
            return;
        }
        FragmentRegSendUserSmsBinding binding = getBinding();
        TextView textView = binding.tvTitle;
        AutoSendSmsScreen autoSendSmsScreen = userSms.getAutoSendSmsScreen();
        String strValueOf = String.valueOf((autoSendSmsScreen == null || (title3 = autoSendSmsScreen.getTitle()) == null) ? null : title3.getTitle());
        AutoSendSmsScreen autoSendSmsScreen2 = userSms.getAutoSendSmsScreen();
        String safe = StringUtilsKt.formatSafe(strValueOf, String.valueOf((autoSendSmsScreen2 == null || (title2 = autoSendSmsScreen2.getTitle()) == null) ? null : title2.getParam1()));
        AutoSendSmsScreen autoSendSmsScreen3 = userSms.getAutoSendSmsScreen();
        textView.setText(ViewUtilsKt.highlightText(safe, String.valueOf((autoSendSmsScreen3 == null || (title = autoSendSmsScreen3.getTitle()) == null) ? null : title.getParam1()), ContextCompat.getColor(requireContext(), R$color.sputnik_pink)));
        AppCompatButton appCompatButton = binding.btnToSmsMessenger;
        AutoSendSmsScreen autoSendSmsScreen4 = userSms.getAutoSendSmsScreen();
        appCompatButton.setText(String.valueOf(autoSendSmsScreen4 != null ? autoSendSmsScreen4.getSendSmsButton() : null));
        TextView textView2 = binding.tvDescription;
        ManualSendSmsScreen manualSendSmsScreen = userSms.getManualSendSmsScreen();
        textView2.setText(String.valueOf(manualSendSmsScreen != null ? manualSendSmsScreen.getHint() : null));
        TextView textView3 = binding.btnRegisterOnTablet;
        AutoSendSmsScreen autoSendSmsScreen5 = userSms.getAutoSendSmsScreen();
        textView3.setText(String.valueOf(autoSendSmsScreen5 != null ? autoSendSmsScreen5.getContinueOnTabletButton() : null));
    }
}
