package com.sputnik.oboarding.ui.registration.ways.userSms;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
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
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.AnalyticsTracker;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.AuthorizationBody;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.ManualSendSmsScreen;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.UserSms;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.SpansKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.CallCodeViewModel;
import com.sputnik.common.viewmodels.LoginViewModel;
import com.sputnik.common.viewmodels.LoginViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import com.sputnik.oboarding.R$color;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.R$string;
import com.sputnik.oboarding.databinding.FragmentRegSendUserSmsFromOtherDeviceBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: SendUserSmsFromOtherDeviceFragment.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u00109\u001a\u0004\b?\u0010@R\u001d\u0010F\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u00109\u001a\u0004\bD\u0010ER\u001d\u0010I\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u00109\u001a\u0004\bH\u0010ER\u001b\u0010L\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u00109\u001a\u0004\bL\u0010M¨\u0006N"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/ways/userSms/SendUserSmsFromOtherDeviceFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "Lcom/sputnik/common/viewmodels/LoginViewState;", RemoteMessageConst.DATA, "renderUi", "(Lcom/sputnik/common/viewmodels/LoginViewState;)V", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentRegSendUserSmsFromOtherDeviceBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentRegSendUserSmsFromOtherDeviceBinding;", "binding", "Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "callCodeFactoryBuilder", "Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "getCallCodeFactoryBuilder", "()Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "setCallCodeFactoryBuilder", "(Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel$delegate", "getLoginViewModel", "()Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel", "", "phone$delegate", "getPhone", "()Ljava/lang/String;", "phone", "prettyPhone$delegate", "getPrettyPhone", "prettyPhone", "", "isFromWaitingScreen$delegate", "isFromWaitingScreen", "()Z", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SendUserSmsFromOtherDeviceFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SendUserSmsFromOtherDeviceFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentRegSendUserSmsFromOtherDeviceBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public CallCodeViewModel.Factory.AssistFactory callCodeFactoryBuilder;
    public MultiViewModelFactory factory;

    /* renamed from: isFromWaitingScreen$delegate, reason: from kotlin metadata */
    private final Lazy isFromWaitingScreen;
    public LocalizationStorage localizationStorage;

    /* renamed from: loginViewModel$delegate, reason: from kotlin metadata */
    private final Lazy loginViewModel;

    /* renamed from: phone$delegate, reason: from kotlin metadata */
    private final Lazy phone;

    /* renamed from: prettyPhone$delegate, reason: from kotlin metadata */
    private final Lazy prettyPhone;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentRegSendUserSmsFromOtherDeviceBinding getBinding() {
        return (FragmentRegSendUserSmsFromOtherDeviceBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    private final LoginViewModel getLoginViewModel() {
        return (LoginViewModel) this.loginViewModel.getValue();
    }

    private final String getPhone() {
        return (String) this.phone.getValue();
    }

    private final String getPrettyPhone() {
        return (String) this.prettyPhone.getValue();
    }

    private final boolean isFromWaitingScreen() {
        return ((Boolean) this.isFromWaitingScreen.getValue()).booleanValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        OnBoardingComponentKt.onBoardingComponent(this).inject(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        initView();
        LoginViewModel loginViewModel = getLoginViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        loginViewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
        LoginViewModel loginViewModel2 = getLoginViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        loginViewModel2.observeSubState(viewLifecycleOwner2, new Function1<LoginViewState, Event<? extends Boolean>>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(LoginViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isLoaded();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment.onViewCreated.3
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
                    final SendUserSmsFromOtherDeviceFragment sendUserSmsFromOtherDeviceFragment = SendUserSmsFromOtherDeviceFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        sendUserSmsFromOtherDeviceFragment.getProfileViewModel().delayRequest(500L, new Function0<Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment$onViewCreated$3$1$1
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
                                IProfileViewModel.DefaultImpls.loadProfile$default(sendUserSmsFromOtherDeviceFragment.getProfileViewModel(), false, 1, null);
                            }
                        });
                    }
                }
            }
        });
        LoginViewModel loginViewModel3 = getLoginViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        loginViewModel3.observeNotifications(viewLifecycleOwner3, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment.onViewCreated.4
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
                SendUserSmsFromOtherDeviceFragment sendUserSmsFromOtherDeviceFragment = SendUserSmsFromOtherDeviceFragment.this;
                NestedScrollView root = sendUserSmsFromOtherDeviceFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(sendUserSmsFromOtherDeviceFragment, root, it);
            }
        });
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        profileViewModel.observeSubState(viewLifecycleOwner4, new Function1<ProfileViewState, Event<? extends ProfileNavigationState>>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final Event<ProfileNavigationState> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileState();
            }
        }, new Function1<Event<? extends ProfileNavigationState>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment.onViewCreated.6
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
                    SendUserSmsFromOtherDeviceFragment sendUserSmsFromOtherDeviceFragment = SendUserSmsFromOtherDeviceFragment.this;
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToRegistrationState) {
                        sendUserSmsFromOtherDeviceFragment.getAnalytics().trackLogEvent(new AnalyticsTracker.Event("account_state", "unregistered", null, 4, null));
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(sendUserSmsFromOtherDeviceFragment), R$id.enterSmsCodeFragment, R$id.action_enterSmsCodeFragment_to_enterNameFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToVerifyAddressState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(sendUserSmsFromOtherDeviceFragment), R$id.enterSmsCodeFragment, R$id.action_enterSmsCodeFragment_to_confirmAddressFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToEnterFlatNumberState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(sendUserSmsFromOtherDeviceFragment), R$id.enterSmsCodeFragment, R$id.action_enterSmsCodeFragment_to_enterFlatNumberFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToIntercomState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(sendUserSmsFromOtherDeviceFragment), R$id.enterSmsCodeFragment, R$id.action_enterSmsCodeFragment_to_connectToIntercomFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToActivatedState) {
                        Uri uri = Uri.parse(sendUserSmsFromOtherDeviceFragment.getString(R$string.deeplink_main));
                        FragmentKt.findNavController(sendUserSmsFromOtherDeviceFragment).popBackStack(R$id.startRegistrationFragment, true);
                        NavController navControllerFindNavController = FragmentKt.findNavController(sendUserSmsFromOtherDeviceFragment);
                        Intrinsics.checkNotNull(uri);
                        navControllerFindNavController.navigate(uri);
                    }
                }
            }
        });
    }

    /* compiled from: SendUserSmsFromOtherDeviceFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<LoginViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, SendUserSmsFromOtherDeviceFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/LoginViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LoginViewState loginViewState) {
            invoke2(loginViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LoginViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SendUserSmsFromOtherDeviceFragment) this.receiver).renderUi(p0);
        }
    }

    private final void initView() {
        getBinding().btnDone.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendUserSmsFromOtherDeviceFragment.initView$lambda$0(this.f$0, view);
            }
        });
        FrameLayout rootView = getBinding().rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SendUserSmsFromOtherDeviceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isFromWaitingScreen()) {
            FragmentKt.findNavController(this$0).navigateUp();
        } else {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.action_sendUserSmsFromOtherDeviceFragment_to_waitingUserSmsFragment, BundleKt.bundleOf(TuplesKt.to("phone", this$0.getPhone()), TuplesKt.to("pretty_phone", this$0.getPrettyPhone())), null, 4, null);
        }
    }

    public SendUserSmsFromOtherDeviceFragment() {
        super(R$layout.fragment_reg_send_user_sms_from_other_device);
        this.binding = new ViewBindingFragmentDelegate(this, SendUserSmsFromOtherDeviceFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.loginViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment$loginViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.phone = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment$phone$2
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
        this.prettyPhone = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment$prettyPhone$2
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
        this.isFromWaitingScreen = LazyKt.lazy(new Function0<Boolean>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment.isFromWaitingScreen.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle arguments = SendUserSmsFromOtherDeviceFragment.this.getArguments();
                return Boolean.valueOf(arguments != null ? arguments.getBoolean("is_from_waiting_screen", false) : false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(LoginViewState data) {
        AuthorizationBody authorizationCode;
        UserSms userSms;
        SpannableString spannableString;
        TitleWithParam fromNumber;
        TitleWithParam fromNumber2;
        TitleWithParam fromNumber3;
        LocalizationLocalModel data2 = getLocalizationStorage().getData();
        if (data2 == null || (authorizationCode = data2.getAuthorizationCode()) == null || (userSms = authorizationCode.getUserSms()) == null) {
            return;
        }
        FragmentRegSendUserSmsFromOtherDeviceBinding binding = getBinding();
        LoginState.Session sessionByPhone = getLoginViewModel().getSessionByPhone();
        binding.viewPin.setText(String.valueOf(sessionByPhone != null ? sessionByPhone.getUserSmsCode() : null));
        try {
            PhoneNumberUtil phoneNumberUtilCreateInstance = PhoneNumberUtil.createInstance(requireContext());
            Intrinsics.checkNotNullExpressionValue(phoneNumberUtilCreateInstance, "createInstance(...)");
            String str = phoneNumberUtilCreateInstance.format(phoneNumberUtilCreateInstance.parse(String.valueOf(sessionByPhone != null ? sessionByPhone.getUserSmsPhone() : null), "RU"), PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
            TextView textView = binding.tvTitle2;
            ManualSendSmsScreen manualSendSmsScreen = userSms.getManualSendSmsScreen();
            textView.setText(ViewUtilsKt.highlightText(StringUtilsKt.formatSafe(String.valueOf(manualSendSmsScreen != null ? manualSendSmsScreen.getToNumber() : null), str.toString()), str.toString(), ContextCompat.getColor(requireContext(), R$color.sputnik_pink)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isFromWaitingScreen()) {
            ManualSendSmsScreen manualSendSmsScreen2 = userSms.getManualSendSmsScreen();
            spannableString = new SpannableString(StringUtilsKt.formatSafe(String.valueOf(manualSendSmsScreen2 != null ? manualSendSmsScreen2.getFromNumberWithoutChanging() : null), String.valueOf(getPrettyPhone())));
        } else {
            ManualSendSmsScreen manualSendSmsScreen3 = userSms.getManualSendSmsScreen();
            spannableString = new SpannableString(StringUtilsKt.formatSafe(String.valueOf((manualSendSmsScreen3 == null || (fromNumber3 = manualSendSmsScreen3.getFromNumber()) == null) ? null : fromNumber3.getTitle()), String.valueOf(getPrettyPhone())));
            ManualSendSmsScreen manualSendSmsScreen4 = userSms.getManualSendSmsScreen();
            SpansKt.addColorSpan(spannableString, String.valueOf((manualSendSmsScreen4 == null || (fromNumber2 = manualSendSmsScreen4.getFromNumber()) == null) ? null : fromNumber2.getParam1()), ContextCompat.getColor(requireContext(), R$color.sputnik_pink));
            ManualSendSmsScreen manualSendSmsScreen5 = userSms.getManualSendSmsScreen();
            if (manualSendSmsScreen5 != null && (fromNumber = manualSendSmsScreen5.getFromNumber()) != null) {
                param1 = fromNumber.getParam1();
            }
            SpansKt.addClickableSpan(spannableString, String.valueOf(param1), new Function1<View, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.SendUserSmsFromOtherDeviceFragment$renderUi$1$1$str$1$1
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
                    FragmentKt.findNavController(this.this$0).popBackStack(R$id.enterPhoneFragment, false);
                }
            });
        }
        binding.tvDescription2.setText(spannableString);
        binding.tvDescription2.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void localize() {
        AuthorizationBody authorizationCode;
        UserSms userSms;
        ManualSendSmsScreen manualSendSmsScreen;
        TextTitle doneButton;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data == null || (authorizationCode = data.getAuthorizationCode()) == null || (userSms = authorizationCode.getUserSms()) == null || (manualSendSmsScreen = userSms.getManualSendSmsScreen()) == null) {
            return;
        }
        FragmentRegSendUserSmsFromOtherDeviceBinding binding = getBinding();
        TextView textView = binding.tvTitle;
        TitleWithParam title = manualSendSmsScreen.getTitle();
        String title2 = null;
        String strValueOf = String.valueOf(title != null ? title.getTitle() : null);
        TitleWithParam title3 = manualSendSmsScreen.getTitle();
        String safe = StringUtilsKt.formatSafe(strValueOf, String.valueOf(title3 != null ? title3.getParam1() : null));
        TitleWithParam title4 = manualSendSmsScreen.getTitle();
        textView.setText(ViewUtilsKt.highlightText(safe, String.valueOf(title4 != null ? title4.getParam1() : null), ContextCompat.getColor(requireContext(), R$color.sputnik_pink)));
        AppCompatButton appCompatButton = binding.btnDone;
        if (!isFromWaitingScreen() ? (doneButton = manualSendSmsScreen.getDoneButton()) != null : (doneButton = manualSendSmsScreen.getUnderstoodButton()) != null) {
            title2 = doneButton.getTitle();
        }
        appCompatButton.setText(String.valueOf(title2));
        binding.tvDescription.setText(String.valueOf(manualSendSmsScreen.getHint()));
    }
}
