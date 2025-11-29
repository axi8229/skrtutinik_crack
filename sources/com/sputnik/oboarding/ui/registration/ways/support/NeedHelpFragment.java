package com.sputnik.oboarding.ui.registration.ways.support;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
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
import androidx.navigation.fragment.FragmentKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.auth.ApplyRegistration;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.authorization.AuthorizationNeedHelpBodyLocale;
import com.sputnik.common.entities.localization.entities.authorization.AuthorizationNeedHelpLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.ui.utils.ButtonsExtensionsKt;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.CallCodeViewModel;
import com.sputnik.common.viewmodels.LoginViewModel;
import com.sputnik.common.viewmodels.LoginViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.auth.RegistrationWay;
import com.sputnik.oboarding.R$color;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.databinding.FragmentNeedHelpBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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

/* compiled from: NeedHelpFragment.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010@\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010@\u001a\u0004\bK\u0010LR\u001d\u0010R\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010@\u001a\u0004\bP\u0010QR\u001d\u0010U\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010@\u001a\u0004\bT\u0010Q¨\u0006V"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/ways/support/NeedHelpFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "Lcom/sputnik/common/viewmodels/LoginViewState;", RemoteMessageConst.DATA, "renderUi", "(Lcom/sputnik/common/viewmodels/LoginViewState;)V", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentNeedHelpBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentNeedHelpBinding;", "binding", "Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "callCodeFactoryBuilder", "Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "getCallCodeFactoryBuilder", "()Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "setCallCodeFactoryBuilder", "(Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/support/ISupportManager;", "supportManager", "Lcom/sputnik/common/support/ISupportManager;", "getSupportManager", "()Lcom/sputnik/common/support/ISupportManager;", "setSupportManager", "(Lcom/sputnik/common/support/ISupportManager;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/CallCodeViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/sputnik/common/viewmodels/CallCodeViewModel;", "viewModel", "Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel$delegate", "getLoginViewModel", "()Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel", "", "phone$delegate", "getPhone", "()Ljava/lang/String;", "phone", "prettyPhone$delegate", "getPrettyPhone", "prettyPhone", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NeedHelpFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(NeedHelpFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentNeedHelpBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public CallCodeViewModel.Factory.AssistFactory callCodeFactoryBuilder;
    public MultiViewModelFactory factory;
    public LocalizationStorage localizationStorage;

    /* renamed from: loginViewModel$delegate, reason: from kotlin metadata */
    private final Lazy loginViewModel;

    /* renamed from: phone$delegate, reason: from kotlin metadata */
    private final Lazy phone;

    /* renamed from: prettyPhone$delegate, reason: from kotlin metadata */
    private final Lazy prettyPhone;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    public ISupportManager supportManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: NeedHelpFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RegistrationWay.values().length];
            try {
                iArr[RegistrationWay.phone.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RegistrationWay.user_sms.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RegistrationWay.sms.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RegistrationWay.voiced.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RegistrationWay.telegram_gateway.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentNeedHelpBinding getBinding() {
        return (FragmentNeedHelpBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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

    public final ISupportManager getSupportManager() {
        ISupportManager iSupportManager = this.supportManager;
        if (iSupportManager != null) {
            return iSupportManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("supportManager");
        return null;
    }

    private final CallCodeViewModel getViewModel() {
        return (CallCodeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoginViewModel getLoginViewModel() {
        return (LoginViewModel) this.loginViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPhone() {
        return (String) this.phone.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPrettyPhone() {
        return (String) this.prettyPhone.getValue();
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
        CallCodeViewModel viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        viewModel.observeNotifications(viewLifecycleOwner2, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment.onViewCreated.2
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
                NeedHelpFragment needHelpFragment = NeedHelpFragment.this;
                NestedScrollView root = needHelpFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(needHelpFragment, root, it);
            }
        });
        getLoginViewModel().registerCurrentSessionInIntercom();
    }

    /* compiled from: NeedHelpFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<LoginViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, NeedHelpFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/LoginViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LoginViewState loginViewState) {
            invoke2(loginViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LoginViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((NeedHelpFragment) this.receiver).renderUi(p0);
        }
    }

    private final void initView() {
        FragmentNeedHelpBinding binding = getBinding();
        binding.btnSupport.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NeedHelpFragment.initView$lambda$1$lambda$0(this.f$0, view);
            }
        });
        AppCompatButton btnResendCode = binding.btnResendCode;
        Intrinsics.checkNotNullExpressionValue(btnResendCode, "btnResendCode");
        SafeClickListenerKt.setSafeOnClickListener$default(btnResendCode, 0L, new Function1<View, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$initView$1$2
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
                AppCompatButton btnResendCode2 = this.this$0.getBinding().btnResendCode;
                Intrinsics.checkNotNullExpressionValue(btnResendCode2, "btnResendCode");
                ButtonsExtensionsKt.showProgress(btnResendCode2, ContextCompat.getColor(this.this$0.requireContext(), R$color.sputnik_blue));
                this.this$0.getLoginViewModel().handleDataNew(this.this$0.getPhone(), this.this$0.getPrettyPhone());
            }
        }, 1, null);
        FrameLayout rootView = binding.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(NeedHelpFragment this$0, View view) {
        AuthorizationNeedHelpBodyLocale authNeedHelp;
        AuthorizationNeedHelpLocale body;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String supportText = null;
        if (this$0.getLoginViewModel().isIntercomOpenedForCurrentSession()) {
            ISupportManager.DefaultImpls.displayMessenger$default(this$0.getSupportManager(), null, 1, null);
            return;
        }
        this$0.getLoginViewModel().markIntercomAsOpenedForCurrentSession();
        ISupportManager supportManager = this$0.getSupportManager();
        LocalizationLocalModel data = this$0.getLocalizationStorage().getData();
        if (data != null && (authNeedHelp = data.getAuthNeedHelp()) != null && (body = authNeedHelp.getBody()) != null) {
            supportText = body.getSupportText();
        }
        supportManager.displayMessenger(String.valueOf(supportText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(LoginViewState data) {
        AuthorizationNeedHelpBodyLocale authNeedHelp;
        AuthorizationNeedHelpLocale body;
        TextTitle otherMethodButton;
        if (data.getServerState() == Resource.Status.SUCCESS || data.getServerState() == Resource.Status.ERROR) {
            AppCompatButton btnResendCode = getBinding().btnResendCode;
            Intrinsics.checkNotNullExpressionValue(btnResendCode, "btnResendCode");
            LocalizationLocalModel data2 = getLocalizationStorage().getData();
            ButtonsExtensionsKt.hideProgress(btnResendCode, String.valueOf((data2 == null || (authNeedHelp = data2.getAuthNeedHelp()) == null || (body = authNeedHelp.getBody()) == null || (otherMethodButton = body.getOtherMethodButton()) == null) ? null : otherMethodButton.getTitle()));
        }
        Boolean contentIfNotHandled = data.getToRequestCode().getContentIfNotHandled();
        if (contentIfNotHandled == null || !contentIfNotHandled.booleanValue()) {
            return;
        }
        Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("phone", getPhone()), TuplesKt.to("pretty_phone", getPrettyPhone()));
        ApplyRegistration applyRegistration = data.getApplyRegistration();
        RegistrationWay way = applyRegistration != null ? applyRegistration.getWay() : null;
        int i = way == null ? -1 : WhenMappings.$EnumSwitchMapping$0[way.ordinal()];
        if (i == 1) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.action_to_enterCodeFragment, bundleBundleOf, null, 4, null);
            return;
        }
        if (i == 2) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.action_to_sendUserSmsFragment, bundleBundleOf, null, 4, null);
            return;
        }
        if (i == 3) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.action_to_enterSmsCodeFragment, bundleBundleOf, null, 4, null);
        } else if (i == 4) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.action_to_enterListenedCodeFragment, bundleBundleOf, null, 4, null);
        } else {
            if (i != 5) {
                return;
            }
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.action_to_enterTelegramCodeFragment, bundleBundleOf, null, 4, null);
        }
    }

    private final void localize() {
        AuthorizationNeedHelpBodyLocale authNeedHelp;
        AuthorizationNeedHelpLocale body;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data == null || (authNeedHelp = data.getAuthNeedHelp()) == null || (body = authNeedHelp.getBody()) == null) {
            return;
        }
        FragmentNeedHelpBinding binding = getBinding();
        TextView textView = binding.tvTitle;
        TitleWithParam mainText = body.getMainText();
        String strValueOf = String.valueOf(mainText != null ? mainText.getTitle() : null);
        TitleWithParam mainText2 = body.getMainText();
        textView.setText(ViewUtilsKt.highlightText(strValueOf, String.valueOf(mainText2 != null ? mainText2.getParam1() : null), ContextCompat.getColor(requireContext(), R$color.sputnik_pink)));
        AppCompatButton appCompatButton = binding.btnResendCode;
        TextTitle otherMethodButton = body.getOtherMethodButton();
        appCompatButton.setText(String.valueOf(otherMethodButton != null ? otherMethodButton.getTitle() : null));
        TextView textView2 = binding.btnSupport;
        TextTitle supportButton = body.getSupportButton();
        textView2.setText(String.valueOf(supportButton != null ? supportButton.getTitle() : null));
    }

    public NeedHelpFragment() {
        super(R$layout.fragment_need_help);
        this.binding = new ViewBindingFragmentDelegate(this, NeedHelpFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$viewModel$2
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
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CallCodeViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$special$$inlined$viewModels$default$4
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
        this.loginViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$loginViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.phone = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$phone$2
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
        this.prettyPhone = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.ways.support.NeedHelpFragment$prettyPhone$2
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
}
