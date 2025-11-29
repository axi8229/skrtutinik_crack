package com.sputnik.oboarding.ui.registration;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
import com.chaos.view.PinView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.redmadrobot.inputmask.helper.Mask;
import com.redmadrobot.inputmask.model.CaretString;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.AnalyticsTracker;
import com.sputnik.common.base.Notify;
import com.sputnik.common.base.SimpleDialog;
import com.sputnik.common.databinding.DialogErrorSplashBinding;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.auth.ApplyRegistration;
import com.sputnik.common.entities.localization.AlertData;
import com.sputnik.common.entities.localization.AlertLocale;
import com.sputnik.common.entities.localization.ArchivePopUpBody;
import com.sputnik.common.entities.localization.ArchivePopUpLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TextWithParam;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import com.sputnik.common.entities.localization.entities.login.EnterCodeBody;
import com.sputnik.common.entities.localization.entities.login.EnterCodeLocale;
import com.sputnik.common.entities.localization.entities.login.EnterCodeTitle;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.AuthorizationBody;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.AuthorizationSms;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.SpansKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.ButtonsExtensionsKt;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.utils.ViewUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.CallCodeViewModel;
import com.sputnik.common.viewmodels.CallCodeViewState;
import com.sputnik.common.viewmodels.ErrorContainer;
import com.sputnik.common.viewmodels.LoginViewModel;
import com.sputnik.common.viewmodels.LoginViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.common.viewmodels.interfaces.IProfileViewModel;
import com.sputnik.domain.common.ErrorCodes;
import com.sputnik.domain.common.Errors;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.auth.RegistrationWay;
import com.sputnik.domain.entities.empty.DomainEmpty;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import com.sputnik.oboarding.R$color;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.R$string;
import com.sputnik.oboarding.analytics.yandex.OnBoardingEvents;
import com.sputnik.oboarding.databinding.FragmentRegEnterCodeSmsBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
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
import okhttp3.internal.Util;

/* compiled from: EnterSmsCodeFragment.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\f\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010\u0003J!\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00104\u001a\u0002038\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020:8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010B\u001a\u00020A8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001b\u0010T\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\"\u0010V\u001a\u00020U8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001b\u0010`\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010Q\u001a\u0004\b^\u0010_R\u001b\u0010e\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010Q\u001a\u0004\bc\u0010dR\u001b\u0010j\u001a\u00020f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010Q\u001a\u0004\bh\u0010iR\u001d\u0010n\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010Q\u001a\u0004\bl\u0010mR\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010Q\u001a\u0004\bp\u0010mR\u001d\u0010s\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010Q\u001a\u0004\br\u0010m¨\u0006t"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/EnterSmsCodeFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "Lcom/sputnik/common/viewmodels/ErrorContainer;", "errorContainer", "renderError", "(Lcom/sputnik/common/viewmodels/ErrorContainer;)V", "Lcom/sputnik/common/viewmodels/CallCodeViewState;", RemoteMessageConst.DATA, "renderUi", "(Lcom/sputnik/common/viewmodels/CallCodeViewState;)V", "Lcom/sputnik/common/viewmodels/LoginViewState;", "(Lcom/sputnik/common/viewmodels/LoginViewState;)V", "showCodeExpiredError", "hideCodeError", "setupButtons", "showCodeError", "setUpCodeField", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "way", "navigateWithWay", "(Lcom/sputnik/domain/entities/auth/RegistrationWay;)V", "", "phone", "initPhone", "(Ljava/lang/String;)V", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "onStop", "onResume", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentRegEnterCodeSmsBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentRegEnterCodeSmsBinding;", "binding", "Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "callCodeFactoryBuilder", "Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "getCallCodeFactoryBuilder", "()Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "setCallCodeFactoryBuilder", "(Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lcom/sputnik/common/viewmodels/CallCodeViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/sputnik/common/viewmodels/CallCodeViewModel;", "viewModel", "Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel$delegate", "getLoginViewModel", "()Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel", "localeForTimer$delegate", "getLocaleForTimer", "()Ljava/lang/String;", "localeForTimer", "phone$delegate", "getPhone", "prettyPhone$delegate", "getPrettyPhone", "prettyPhone", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EnterSmsCodeFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(EnterSmsCodeFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentRegEnterCodeSmsBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public CallCodeViewModel.Factory.AssistFactory callCodeFactoryBuilder;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public MultiViewModelFactory factory;

    /* renamed from: localeForTimer$delegate, reason: from kotlin metadata */
    private final Lazy localeForTimer;
    public LocalizationStorage localizationStorage;

    /* renamed from: loginViewModel$delegate, reason: from kotlin metadata */
    private final Lazy loginViewModel;

    /* renamed from: phone$delegate, reason: from kotlin metadata */
    private final Lazy phone;

    /* renamed from: prettyPhone$delegate, reason: from kotlin metadata */
    private final Lazy prettyPhone;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: EnterSmsCodeFragment.kt */
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
    public final FragmentRegEnterCodeSmsBinding getBinding() {
        return (FragmentRegEnterCodeSmsBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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
    public final CallCodeViewModel getViewModel() {
        return (CallCodeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoginViewModel getLoginViewModel() {
        return (LoginViewModel) this.loginViewModel.getValue();
    }

    private final String getLocaleForTimer() {
        return (String) this.localeForTimer.getValue();
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getViewModel().startCountDownNew(getPhone());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getViewModel().clearTimer();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Window window = requireActivity().getWindow();
        window.setNavigationBarColor(0);
        window.setSoftInputMode(16);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getAnalytics().trackLogEvent(new AnalyticsTracker.Event("codeEnter", "show", null, 4, null));
        localize();
        initView();
        CallCodeViewModel viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        viewModel.observeState(viewLifecycleOwner, new C07581(this));
        LoginViewModel loginViewModel = getLoginViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        loginViewModel.observeState(viewLifecycleOwner2, new AnonymousClass2(this));
        CallCodeViewModel viewModel2 = getViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        viewModel2.observeSubState(viewLifecycleOwner3, new Function1<CallCodeViewState, Event<? extends Boolean>>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(CallCodeViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isLoaded();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment.onViewCreated.4
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
                    final EnterSmsCodeFragment enterSmsCodeFragment = EnterSmsCodeFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        enterSmsCodeFragment.getProfileViewModel().delayRequest(500L, new Function0<Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$onViewCreated$4$1$1
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
                                IProfileViewModel.DefaultImpls.loadProfile$default(enterSmsCodeFragment.getProfileViewModel(), false, 1, null);
                            }
                        });
                    }
                }
            }
        });
        CallCodeViewModel viewModel3 = getViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        viewModel3.observeSubState(viewLifecycleOwner4, new AnonymousClass5(ErrorContainer.INSTANCE), new AnonymousClass6(this));
        CallCodeViewModel viewModel4 = getViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        viewModel4.observeNotifications(viewLifecycleOwner5, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment.onViewCreated.7
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
                EnterSmsCodeFragment enterSmsCodeFragment = EnterSmsCodeFragment.this;
                NestedScrollView root = enterSmsCodeFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(enterSmsCodeFragment, root, it);
            }
        });
        setupButtons();
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        profileViewModel.observeSubState(viewLifecycleOwner6, new Function1<ProfileViewState, Resource.Status>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment.onViewCreated.8
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileServerState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment.onViewCreated.9
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
                if (it == Resource.Status.ERROR) {
                    LinearLayout layoutProgress = EnterSmsCodeFragment.this.getBinding().layoutProgress;
                    Intrinsics.checkNotNullExpressionValue(layoutProgress, "layoutProgress");
                    ViewKt.gone(layoutProgress);
                }
            }
        });
        ProfileViewModel profileViewModel2 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        profileViewModel2.observeSubState(viewLifecycleOwner7, new Function1<ProfileViewState, Event<? extends ProfileNavigationState>>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment.onViewCreated.10
            @Override // kotlin.jvm.functions.Function1
            public final Event<ProfileNavigationState> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileState();
            }
        }, new Function1<Event<? extends ProfileNavigationState>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment.onViewCreated.11
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
                    EnterSmsCodeFragment enterSmsCodeFragment = EnterSmsCodeFragment.this;
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToRegistrationState) {
                        PinView viewPin = enterSmsCodeFragment.getBinding().viewPin;
                        Intrinsics.checkNotNullExpressionValue(viewPin, "viewPin");
                        ViewKt.hideKeyboard(viewPin);
                        enterSmsCodeFragment.getAnalytics().trackLogEvent(new AnalyticsTracker.Event("account_state", "unregistered", null, 4, null));
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(enterSmsCodeFragment), R$id.enterSmsCodeFragment, R$id.action_enterSmsCodeFragment_to_enterNameFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToVerifyAddressState) {
                        PinView viewPin2 = enterSmsCodeFragment.getBinding().viewPin;
                        Intrinsics.checkNotNullExpressionValue(viewPin2, "viewPin");
                        ViewKt.hideKeyboard(viewPin2);
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(enterSmsCodeFragment), R$id.enterSmsCodeFragment, R$id.action_enterSmsCodeFragment_to_confirmAddressFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToEnterFlatNumberState) {
                        PinView viewPin3 = enterSmsCodeFragment.getBinding().viewPin;
                        Intrinsics.checkNotNullExpressionValue(viewPin3, "viewPin");
                        ViewKt.hideKeyboard(viewPin3);
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(enterSmsCodeFragment), R$id.enterSmsCodeFragment, R$id.action_enterSmsCodeFragment_to_enterFlatNumberFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToIntercomState) {
                        PinView viewPin4 = enterSmsCodeFragment.getBinding().viewPin;
                        Intrinsics.checkNotNullExpressionValue(viewPin4, "viewPin");
                        ViewKt.hideKeyboard(viewPin4);
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(enterSmsCodeFragment), R$id.enterSmsCodeFragment, R$id.action_enterSmsCodeFragment_to_connectToIntercomFragment, null, null, 12, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToActivatedState) {
                        PinView viewPin5 = enterSmsCodeFragment.getBinding().viewPin;
                        Intrinsics.checkNotNullExpressionValue(viewPin5, "viewPin");
                        ViewKt.hideKeyboard(viewPin5);
                        Uri uri = Uri.parse(enterSmsCodeFragment.getString(R$string.deeplink_main));
                        enterSmsCodeFragment.getCamerasViewModel().setNeedLoadCameras(true);
                        FragmentKt.findNavController(enterSmsCodeFragment).popBackStack(R$id.selectAccountFragment, true);
                        NavController navControllerFindNavController = FragmentKt.findNavController(enterSmsCodeFragment);
                        Intrinsics.checkNotNull(uri);
                        navControllerFindNavController.navigate(uri);
                    }
                }
            }
        });
    }

    /* compiled from: EnterSmsCodeFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C07581 extends FunctionReferenceImpl implements Function1<CallCodeViewState, Unit> {
        C07581(Object obj) {
            super(1, obj, EnterSmsCodeFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/CallCodeViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CallCodeViewState callCodeViewState) {
            invoke2(callCodeViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CallCodeViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EnterSmsCodeFragment) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: EnterSmsCodeFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$onViewCreated$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<LoginViewState, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, EnterSmsCodeFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/LoginViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LoginViewState loginViewState) {
            invoke2(loginViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LoginViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EnterSmsCodeFragment) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: EnterSmsCodeFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$onViewCreated$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<CallCodeViewState, ErrorContainer> {
        AnonymousClass5(Object obj) {
            super(1, obj, ErrorContainer.Companion.class, "toErrorContainer", "toErrorContainer(Lcom/sputnik/common/viewmodels/CallCodeViewState;)Lcom/sputnik/common/viewmodels/ErrorContainer;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ErrorContainer invoke(CallCodeViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((ErrorContainer.Companion) this.receiver).toErrorContainer(p0);
        }
    }

    /* compiled from: EnterSmsCodeFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$onViewCreated$6, reason: invalid class name */
    /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<ErrorContainer, Unit> {
        AnonymousClass6(Object obj) {
            super(1, obj, EnterSmsCodeFragment.class, "renderError", "renderError(Lcom/sputnik/common/viewmodels/ErrorContainer;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ErrorContainer errorContainer) {
            invoke2(errorContainer);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ErrorContainer p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EnterSmsCodeFragment) this.receiver).renderError(p0);
        }
    }

    public EnterSmsCodeFragment() {
        super(R$layout.fragment_reg_enter_code_sms);
        this.binding = new ViewBindingFragmentDelegate(this, EnterSmsCodeFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$camerasViewModel$2
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
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$viewModel$2
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
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CallCodeViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$special$$inlined$viewModels$default$4
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
        this.loginViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$special$$inlined$activityViewModels$default$7
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$loginViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.localeForTimer = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$localeForTimer$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                AuthorizationBody authorizationCode;
                LocalizationLocalModel data = this.this$0.getLocalizationStorage().getData();
                if (data == null || (authorizationCode = data.getAuthorizationCode()) == null) {
                    return null;
                }
                return authorizationCode.getTimer();
            }
        });
        this.phone = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$phone$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("phone") : null);
            }
        });
        this.prettyPhone = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$prettyPhone$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("pretty_phone") : null);
            }
        });
    }

    private final void initView() {
        setUpCodeField();
        TextView btnLoginBySms = getBinding().btnLoginBySms;
        Intrinsics.checkNotNullExpressionValue(btnLoginBySms, "btnLoginBySms");
        SafeClickListenerKt.setSafeOnClickListener$default(btnLoginBySms, 0L, new Function1<View, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment.initView.1
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
                ApplyRegistration applyRegistration = EnterSmsCodeFragment.this.getLoginViewModel().getCurrentState().getApplyRegistration();
                if (!(applyRegistration != null ? Intrinsics.areEqual(applyRegistration.getShowHelpOnFail(), Boolean.TRUE) : false)) {
                    TextView btnLoginBySms2 = EnterSmsCodeFragment.this.getBinding().btnLoginBySms;
                    Intrinsics.checkNotNullExpressionValue(btnLoginBySms2, "btnLoginBySms");
                    ButtonsExtensionsKt.showProgress(btnLoginBySms2, ContextCompat.getColor(EnterSmsCodeFragment.this.requireContext(), R$color.sputnik_blue));
                    EnterSmsCodeFragment.this.getLoginViewModel().handleDataNew(EnterSmsCodeFragment.this.getPhone(), EnterSmsCodeFragment.this.getPrettyPhone());
                    return;
                }
                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(EnterSmsCodeFragment.this), R$id.action_to_needHelpFragment, BundleKt.bundleOf(TuplesKt.to("phone", EnterSmsCodeFragment.this.getPhone()), TuplesKt.to("pretty_phone", EnterSmsCodeFragment.this.getPrettyPhone())), null, 4, null);
            }
        }, 1, null);
        FrameLayout rootView = getBinding().rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderError(ErrorContainer errorContainer) {
        Integer code;
        ArchivePopUpLocale archivePopUp;
        ArchivePopUpBody body;
        TextTitle doneButton;
        DomainEmpty parsedError = errorContainer.getParsedError();
        if (parsedError != null && (code = parsedError.getCode()) != null && code.intValue() == ErrorCodes.INSTANCE.getATTEMPS_EXCEEDED()) {
            FragmentKt.findNavController(this).popBackStack(R$id.enterPhoneFragment, false);
            NavController navControllerFindNavController = FragmentKt.findNavController(this);
            int i = R$id.action_to_singleButtonDialog;
            DomainEmpty parsedError2 = getViewModel().getCurrentState().getParsedError();
            Pair pair = TuplesKt.to("subtitle", parsedError2 != null ? parsedError2.getMessage() : null);
            LocalizationLocalModel data = getLocalizationStorage().getData();
            NavControllerKt.safeNavigate$default(navControllerFindNavController, i, BundleKt.bundleOf(pair, TuplesKt.to("button_text", (data == null || (archivePopUp = data.getArchivePopUp()) == null || (body = archivePopUp.getBody()) == null || (doneButton = body.getDoneButton()) == null) ? null : doneButton.getTitle())), null, 4, null);
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(CallCodeViewState data) {
        initPhone(data.getPhone());
        FragmentRegEnterCodeSmsBinding binding = getBinding();
        if (data.getHandleCodeServerState() == Resource.Status.ERROR) {
            LinearLayout layoutProgress = binding.layoutProgress;
            Intrinsics.checkNotNullExpressionValue(layoutProgress, "layoutProgress");
            ViewKt.gone(layoutProgress);
        }
        TextView btnLoginBySms = binding.btnLoginBySms;
        Intrinsics.checkNotNullExpressionValue(btnLoginBySms, "btnLoginBySms");
        ViewBindingUtilsKt.visibilityBasedOn(btnLoginBySms, Boolean.valueOf(data.getNeedSendSms()));
        TextView tvWait = binding.tvWait;
        Intrinsics.checkNotNullExpressionValue(tvWait, "tvWait");
        ViewBindingUtilsKt.visibilityBasedOn(tvWait, Boolean.valueOf(!data.getNeedSendSms()));
        binding.tvWait.setText(data.getSmsSendRestricted() ? data.getSmsTimer() : StringUtilsKt.formatSafe(String.valueOf(getLocaleForTimer()), data.getSmsTimer()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(LoginViewState data) {
        AuthorizationBody authorizationCode;
        if (data.getServerState() == Resource.Status.SUCCESS || data.getServerState() == Resource.Status.ERROR) {
            TextView btnResendCode = getBinding().btnResendCode;
            Intrinsics.checkNotNullExpressionValue(btnResendCode, "btnResendCode");
            LocalizationLocalModel data2 = getLocalizationStorage().getData();
            ButtonsExtensionsKt.hideProgress(btnResendCode, String.valueOf((data2 == null || (authorizationCode = data2.getAuthorizationCode()) == null) ? null : authorizationCode.getChangeMethodButton()));
        }
        Boolean contentIfNotHandled = data.getToRequestCode().getContentIfNotHandled();
        if (contentIfNotHandled != null && contentIfNotHandled.booleanValue()) {
            ApplyRegistration applyRegistration = data.getApplyRegistration();
            navigateWithWay(applyRegistration != null ? applyRegistration.getWay() : null);
        }
        if (data.isLimitExceeded().peekContent().booleanValue() && Intrinsics.areEqual(data.isLimitExceeded().getContentIfNotHandled(), Boolean.TRUE)) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.action_to_limitExceededFragment, null, null, 6, null);
        }
    }

    /* compiled from: EnterSmsCodeFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dialog", "Landroid/app/AlertDialog;", "view", "Lcom/sputnik/common/databinding/DialogErrorSplashBinding;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$showCodeExpiredError$2, reason: invalid class name and case insensitive filesystem */
    static final class C07612 extends Lambda implements Function2<AlertDialog, DialogErrorSplashBinding, Unit> {
        C07612() {
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
            final EnterSmsCodeFragment enterSmsCodeFragment = EnterSmsCodeFragment.this;
            LocalizationLocalModel data = enterSmsCodeFragment.getLocalizationStorage().getData();
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
            view.btnRepeat.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$showCodeExpiredError$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    EnterSmsCodeFragment.C07612.invoke$lambda$2$lambda$1(enterSmsCodeFragment, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2$lambda$1(EnterSmsCodeFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FragmentKt.findNavController(this$0).navigateUp();
        }
    }

    private final void showCodeExpiredError() {
        SimpleDialog.Companion companion = SimpleDialog.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        companion.newInstance(contextRequireContext, C07601.INSTANCE, new C07612());
    }

    /* compiled from: EnterSmsCodeFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$showCodeExpiredError$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C07601 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, DialogErrorSplashBinding> {
        public static final C07601 INSTANCE = new C07601();

        C07601() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideCodeError() {
        getBinding().viewPin.setTextColor(ContextCompat.getColor(requireContext(), R$color.black));
        getBinding().viewPin.setLineColor(ContextCompat.getColor(requireContext(), R$color.track_gray));
        TextView tvErrorCode = getBinding().tvErrorCode;
        Intrinsics.checkNotNullExpressionValue(tvErrorCode, "tvErrorCode");
        ViewKt.gone(tvErrorCode);
    }

    private final void setupButtons() {
        TextView btnResendCode = getBinding().btnResendCode;
        Intrinsics.checkNotNullExpressionValue(btnResendCode, "btnResendCode");
        SafeClickListenerKt.setSafeOnClickListener$default(btnResendCode, 0L, new Function1<View, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment.setupButtons.1
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
                ApplyRegistration applyRegistration = EnterSmsCodeFragment.this.getLoginViewModel().getCurrentState().getApplyRegistration();
                if (!(applyRegistration != null ? Intrinsics.areEqual(applyRegistration.getShowHelpOnFail(), Boolean.TRUE) : false)) {
                    TextView btnResendCode2 = EnterSmsCodeFragment.this.getBinding().btnResendCode;
                    Intrinsics.checkNotNullExpressionValue(btnResendCode2, "btnResendCode");
                    ButtonsExtensionsKt.showProgress(btnResendCode2, ContextCompat.getColor(EnterSmsCodeFragment.this.requireContext(), R$color.sputnik_blue));
                    EnterSmsCodeFragment.this.getLoginViewModel().handleDataNew(EnterSmsCodeFragment.this.getPhone(), EnterSmsCodeFragment.this.getPrettyPhone());
                    return;
                }
                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(EnterSmsCodeFragment.this), R$id.action_to_needHelpFragment, BundleKt.bundleOf(TuplesKt.to("phone", EnterSmsCodeFragment.this.getPhone()), TuplesKt.to("pretty_phone", EnterSmsCodeFragment.this.getPrettyPhone())), null, 4, null);
            }
        }, 1, null);
    }

    private final void showCodeError() {
        PinView pinView = getBinding().viewPin;
        Context contextRequireContext = requireContext();
        int i = R$color.sputnik_error;
        pinView.setTextColor(ContextCompat.getColor(contextRequireContext, i));
        getBinding().viewPin.setLineColor(ContextCompat.getColor(requireContext(), i));
        TextView tvErrorCode = getBinding().tvErrorCode;
        Intrinsics.checkNotNullExpressionValue(tvErrorCode, "tvErrorCode");
        ViewKt.visible(tvErrorCode);
    }

    private final void setUpCodeField() {
        PinView pinView = getBinding().viewPin;
        Intrinsics.checkNotNull(pinView);
        pinView.addTextChangedListener(new TextWatcher() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$setUpCodeField$lambda$8$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                this.this$0.hideCodeError();
                if (text == null || text.length() != 4) {
                    return;
                }
                LinearLayout layoutProgress = this.this$0.getBinding().layoutProgress;
                Intrinsics.checkNotNullExpressionValue(layoutProgress, "layoutProgress");
                ViewKt.visible(layoutProgress);
                NestedScrollView root = this.this$0.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.hideKeyboard(root);
                this.this$0.getViewModel().handleCodeNew(text.toString(), String.valueOf(this.this$0.getLoginViewModel().getCurrentState().getPrettyPhone()), String.valueOf(this.this$0.getLoginViewModel().getCurrentState().getCountryCode()), this.this$0.getPhone());
            }
        });
        pinView.requestFocus();
        ViewKt.showKeyboard(pinView);
    }

    private final void navigateWithWay(RegistrationWay way) {
        Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("phone", getPhone()), TuplesKt.to("pretty_phone", getPrettyPhone()));
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

    private final void initPhone(String phone) {
        EnterCodeLocale enterCode;
        EnterCodeBody body;
        EnterCodeTitle subtitle;
        TitleWithParam sms;
        Mask.Result resultApply = AndroidConstants.INSTANCE.getMask().apply(new CaretString(phone, phone.length(), new CaretString.CaretGravity.FORWARD(true)));
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data == null || (enterCode = data.getEnterCode()) == null || (body = enterCode.getBody()) == null || (subtitle = body.getSubtitle()) == null || (sms = subtitle.getSms()) == null) {
            return;
        }
        SpannableString spannableString = new SpannableString(Util.format(sms.getTitle(), String.valueOf(resultApply.getFormattedText().getString()), sms.getParam1()));
        SpansKt.addColorSpan(spannableString, sms.getParam1(), ContextCompat.getColor(requireContext(), R$color.sputnik_pink));
        SpansKt.addClickableSpan(spannableString, sms.getParam1(), new Function1<View, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterSmsCodeFragment$initPhone$1$str$1$1
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
                this.this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationChangeNumberEvent());
                FragmentKt.findNavController(this.this$0).popBackStack(R$id.enterPhoneFragment, false);
            }
        });
        getBinding().tvInfo.setText(spannableString);
        getBinding().tvInfo.setMovementMethod(LinkMovementMethod.getInstance());
        TextView tvInfo = getBinding().tvInfo;
        Intrinsics.checkNotNullExpressionValue(tvInfo, "tvInfo");
        ViewKt.visible(tvInfo);
    }

    private final void localize() {
        AuthorizationBody authorizationCode;
        TextWithParam title;
        TextWithParam title2;
        FragmentRegEnterCodeSmsBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data == null || (authorizationCode = data.getAuthorizationCode()) == null) {
            return;
        }
        TextView textView = binding.tvTitle;
        AuthorizationSms sms = authorizationCode.getSms();
        String param = null;
        String strValueOf = String.valueOf((sms == null || (title2 = sms.getTitle()) == null) ? null : title2.getText());
        AuthorizationSms sms2 = authorizationCode.getSms();
        if (sms2 != null && (title = sms2.getTitle()) != null) {
            param = title.getParam();
        }
        textView.setText(ViewUtilsKt.highlightText(strValueOf, String.valueOf(param), ContextCompat.getColor(requireContext(), R$color.sputnik_pink)));
        binding.tvErrorCode.setText(String.valueOf(authorizationCode.getError()));
        binding.btnLoginBySms.setText(String.valueOf(authorizationCode.getChangeMethodButton()));
    }
}
