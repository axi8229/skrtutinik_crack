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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.AuthorizationBody;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.AuthorizationLimitExceededBody;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.AuthorizationPhone;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.AuthorizationVoiced;
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
import com.sputnik.data.local.PrefManager;
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
import com.sputnik.oboarding.databinding.FragmentRegEnterCodeBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment;
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
import kotlin.text.StringsKt;
import me.ibrahimsn.lib.PhoneNumberKit;
import me.ibrahimsn.lib.api.Phone;

/* compiled from: EnterListenedCodeFragment.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\u0003J!\u0010)\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u00102\u001a\u0002018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001d\u0010=\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001d\u0010A\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010:\u001a\u0004\b?\u0010@R\"\u0010C\u001a\u00020B8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010J\u001a\u00020I8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010Q\u001a\u00020P8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010X\u001a\u00020W8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010:\u001a\u0004\b_\u0010@R\u001d\u0010b\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010:\u001a\u0004\ba\u0010@R\u001b\u0010g\u001a\u00020c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010:\u001a\u0004\be\u0010fR\u001b\u0010l\u001a\u00020h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010:\u001a\u0004\bj\u0010kR\"\u0010n\u001a\u00020m8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001b\u0010x\u001a\u00020t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010:\u001a\u0004\bv\u0010wR\u001b\u0010}\u001a\u00020y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bz\u0010:\u001a\u0004\b{\u0010|¨\u0006~"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/EnterListenedCodeFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/LoginViewState;", RemoteMessageConst.DATA, "", "renderLogin", "(Lcom/sputnik/common/viewmodels/LoginViewState;)V", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "way", "navigateWithWay", "(Lcom/sputnik/domain/entities/auth/RegistrationWay;)V", "Lcom/sputnik/common/viewmodels/ErrorContainer;", "errorContainer", "renderError", "(Lcom/sputnik/common/viewmodels/ErrorContainer;)V", "showCodeExpiredError", "showCodeError", "hideCodeError", "Lcom/sputnik/common/viewmodels/CallCodeViewState;", "renderUi", "(Lcom/sputnik/common/viewmodels/CallCodeViewState;)V", "", "phone", "initPhone", "(Ljava/lang/String;)V", "initView", "setUpCodeField", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onResume", "onStart", "onStop", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentRegEnterCodeBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentRegEnterCodeBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationLimitExceededBody;", "locale$delegate", "Lkotlin/Lazy;", "getLocale", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/AuthorizationLimitExceededBody;", "locale", "localeForTimer$delegate", "getLocaleForTimer", "()Ljava/lang/String;", "localeForTimer", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "callCodeFactoryBuilder", "Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "getCallCodeFactoryBuilder", "()Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "setCallCodeFactoryBuilder", "(Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "phone$delegate", "getPhone", "prettyPhone$delegate", "getPrettyPhone", "prettyPhone", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/CallCodeViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/sputnik/common/viewmodels/CallCodeViewModel;", "viewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel$delegate", "getLoginViewModel", "()Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EnterListenedCodeFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(EnterListenedCodeFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentRegEnterCodeBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public CallCodeViewModel.Factory.AssistFactory callCodeFactoryBuilder;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public MultiViewModelFactory factory;

    /* renamed from: locale$delegate, reason: from kotlin metadata */
    private final Lazy locale;

    /* renamed from: localeForTimer$delegate, reason: from kotlin metadata */
    private final Lazy localeForTimer;
    public LocalizationStorage localizationScreen;

    /* renamed from: loginViewModel$delegate, reason: from kotlin metadata */
    private final Lazy loginViewModel;

    /* renamed from: phone$delegate, reason: from kotlin metadata */
    private final Lazy phone;
    public PrefManager prefManager;

    /* renamed from: prettyPhone$delegate, reason: from kotlin metadata */
    private final Lazy prettyPhone;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: EnterListenedCodeFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Resource.Status.values().length];
            try {
                iArr[Resource.Status.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Resource.Status.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Resource.Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Resource.Status.LOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[RegistrationWay.values().length];
            try {
                iArr2[RegistrationWay.phone.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[RegistrationWay.user_sms.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[RegistrationWay.sms.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[RegistrationWay.voiced.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[RegistrationWay.telegram_gateway.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentRegEnterCodeBinding getBinding() {
        return (FragmentRegEnterCodeBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    private final String getLocaleForTimer() {
        return (String) this.localeForTimer.getValue();
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    public final CallCodeViewModel.Factory.AssistFactory getCallCodeFactoryBuilder() {
        CallCodeViewModel.Factory.AssistFactory assistFactory = this.callCodeFactoryBuilder;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("callCodeFactoryBuilder");
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
    public final String getPhone() {
        return (String) this.phone.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPrettyPhone() {
        return (String) this.prettyPhone.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CallCodeViewModel getViewModel() {
        return (CallCodeViewModel) this.viewModel.getValue();
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
    public void onResume() {
        super.onResume();
        Window window = requireActivity().getWindow();
        window.setNavigationBarColor(0);
        window.setSoftInputMode(16);
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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        localize();
        CallCodeViewModel viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        viewModel.observeState(viewLifecycleOwner, new C07541(this));
        CallCodeViewModel viewModel2 = getViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        viewModel2.observeSubState(viewLifecycleOwner2, new Function1<CallCodeViewState, Event<? extends Boolean>>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(CallCodeViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isLoaded();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment.onViewCreated.3
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
                    final EnterListenedCodeFragment enterListenedCodeFragment = EnterListenedCodeFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        enterListenedCodeFragment.getProfileViewModel().delayRequest(500L, new Function0<Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$onViewCreated$3$1$1
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
                                IProfileViewModel.DefaultImpls.loadProfile$default(enterListenedCodeFragment.getProfileViewModel(), false, 1, null);
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
        viewModel4.observeNotifications(viewLifecycleOwner4, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment.onViewCreated.6
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
                EnterListenedCodeFragment enterListenedCodeFragment = EnterListenedCodeFragment.this;
                NestedScrollView root = enterListenedCodeFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(enterListenedCodeFragment, root, it);
            }
        });
        LoginViewModel loginViewModel = getLoginViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        loginViewModel.observeState(viewLifecycleOwner5, new AnonymousClass7(this));
        LoginViewModel loginViewModel2 = getLoginViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        loginViewModel2.observeNotifications(viewLifecycleOwner6, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment.onViewCreated.8
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
                EnterListenedCodeFragment enterListenedCodeFragment = EnterListenedCodeFragment.this;
                NestedScrollView root = enterListenedCodeFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(enterListenedCodeFragment, root, it);
            }
        });
        initView();
        setUpCodeField();
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        profileViewModel.observeSubState(viewLifecycleOwner7, new Function1<ProfileViewState, Resource.Status>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment.onViewCreated.9
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileServerState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment.onViewCreated.10
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
                    LinearLayout layoutProgress = EnterListenedCodeFragment.this.getBinding().layoutProgress;
                    Intrinsics.checkNotNullExpressionValue(layoutProgress, "layoutProgress");
                    ViewKt.gone(layoutProgress);
                }
            }
        });
        ProfileViewModel profileViewModel2 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "getViewLifecycleOwner(...)");
        profileViewModel2.observeSubState(viewLifecycleOwner8, new Function1<ProfileViewState, Event<? extends ProfileNavigationState>>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment.onViewCreated.11
            @Override // kotlin.jvm.functions.Function1
            public final Event<ProfileNavigationState> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileState();
            }
        }, new Function1<Event<? extends ProfileNavigationState>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment.onViewCreated.12
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
                    EnterListenedCodeFragment enterListenedCodeFragment = EnterListenedCodeFragment.this;
                    enterListenedCodeFragment.getLoginViewModel().clearToRequestCode();
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToRegistrationState) {
                        PinView viewPin = enterListenedCodeFragment.getBinding().viewPin;
                        Intrinsics.checkNotNullExpressionValue(viewPin, "viewPin");
                        ViewKt.hideKeyboard(viewPin);
                        enterListenedCodeFragment.getAnalytics().trackLogEvent(new AnalyticsTracker.Event("account_state", "unregistered", null, 4, null));
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(enterListenedCodeFragment), R$id.action_to_enterNameFragment, null, null, 6, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToVerifyAddressState) {
                        PinView viewPin2 = enterListenedCodeFragment.getBinding().viewPin;
                        Intrinsics.checkNotNullExpressionValue(viewPin2, "viewPin");
                        ViewKt.hideKeyboard(viewPin2);
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(enterListenedCodeFragment), R$id.action_to_confirmAddressFragment, null, null, 6, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToEnterFlatNumberState) {
                        PinView viewPin3 = enterListenedCodeFragment.getBinding().viewPin;
                        Intrinsics.checkNotNullExpressionValue(viewPin3, "viewPin");
                        ViewKt.hideKeyboard(viewPin3);
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(enterListenedCodeFragment), R$id.action_to_enterFlatNumberFragment, null, null, 6, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToIntercomState) {
                        PinView viewPin4 = enterListenedCodeFragment.getBinding().viewPin;
                        Intrinsics.checkNotNullExpressionValue(viewPin4, "viewPin");
                        ViewKt.hideKeyboard(viewPin4);
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(enterListenedCodeFragment), R$id.action_to_connectToIntercomFragment, null, null, 6, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToActivatedState) {
                        PinView viewPin5 = enterListenedCodeFragment.getBinding().viewPin;
                        Intrinsics.checkNotNullExpressionValue(viewPin5, "viewPin");
                        ViewKt.hideKeyboard(viewPin5);
                        Uri uri = Uri.parse(enterListenedCodeFragment.getString(R$string.deeplink_main));
                        enterListenedCodeFragment.getCamerasViewModel().setNeedLoadCameras(true);
                        FragmentKt.findNavController(enterListenedCodeFragment).popBackStack(R$id.selectAccountFragment, true);
                        NavController navControllerFindNavController = FragmentKt.findNavController(enterListenedCodeFragment);
                        Intrinsics.checkNotNull(uri);
                        navControllerFindNavController.navigate(uri);
                    }
                }
            }
        });
    }

    /* compiled from: EnterListenedCodeFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$onViewCreated$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C07541 extends FunctionReferenceImpl implements Function1<CallCodeViewState, Unit> {
        C07541(Object obj) {
            super(1, obj, EnterListenedCodeFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/CallCodeViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CallCodeViewState callCodeViewState) {
            invoke2(callCodeViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CallCodeViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EnterListenedCodeFragment) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: EnterListenedCodeFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$onViewCreated$4, reason: invalid class name */
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

    /* compiled from: EnterListenedCodeFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$onViewCreated$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<ErrorContainer, Unit> {
        AnonymousClass5(Object obj) {
            super(1, obj, EnterListenedCodeFragment.class, "renderError", "renderError(Lcom/sputnik/common/viewmodels/ErrorContainer;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ErrorContainer errorContainer) {
            invoke2(errorContainer);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ErrorContainer p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EnterListenedCodeFragment) this.receiver).renderError(p0);
        }
    }

    /* compiled from: EnterListenedCodeFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$onViewCreated$7, reason: invalid class name */
    /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<LoginViewState, Unit> {
        AnonymousClass7(Object obj) {
            super(1, obj, EnterListenedCodeFragment.class, "renderLogin", "renderLogin(Lcom/sputnik/common/viewmodels/LoginViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LoginViewState loginViewState) {
            invoke2(loginViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LoginViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EnterListenedCodeFragment) this.receiver).renderLogin(p0);
        }
    }

    public EnterListenedCodeFragment() {
        super(R$layout.fragment_reg_enter_code);
        this.binding = new ViewBindingFragmentDelegate(this, EnterListenedCodeFragment$binding$2.INSTANCE);
        this.locale = LazyKt.lazy(new Function0<AuthorizationLimitExceededBody>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$locale$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AuthorizationLimitExceededBody invoke() {
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                if (data != null) {
                    return data.getAuthorizationLimitExceeded();
                }
                return null;
            }
        });
        this.localeForTimer = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$localeForTimer$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                AuthorizationBody authorizationCode;
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                if (data == null || (authorizationCode = data.getAuthorizationCode()) == null) {
                    return null;
                }
                return authorizationCode.getTimer();
            }
        });
        this.phone = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$phone$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("phone") : null);
            }
        });
        this.prettyPhone = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$prettyPhone$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Bundle arguments = this.this$0.getArguments();
                return (String) (arguments != null ? arguments.get("pretty_phone") : null);
            }
        });
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getCallCodeFactoryBuilder().create(this.this$0.getPhone());
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CallCodeViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$special$$inlined$viewModels$default$4
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
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$camerasViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                WidgetsLocale widgets;
                AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory = this.this$0.getCameraViewModelFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                return cameraViewModelFactory.create((data == null || (widgets = data.getWidgets()) == null) ? null : widgets.getFailureTitle());
            }
        });
        this.loginViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$special$$inlined$activityViewModels$default$7
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$loginViewModel$2
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderLogin(LoginViewState data) {
        AuthorizationBody authorizationCode;
        if (data.getServerState() == Resource.Status.SUCCESS || data.getServerState() == Resource.Status.ERROR) {
            TextView btnLoginBySms = getBinding().btnLoginBySms;
            Intrinsics.checkNotNullExpressionValue(btnLoginBySms, "btnLoginBySms");
            LocalizationLocalModel data2 = getLocalizationScreen().getData();
            ButtonsExtensionsKt.hideProgress(btnLoginBySms, String.valueOf((data2 == null || (authorizationCode = data2.getAuthorizationCode()) == null) ? null : authorizationCode.getChangeMethodButton()));
        }
        if (data.isLimitExceeded().peekContent().booleanValue() && Intrinsics.areEqual(data.isLimitExceeded().getContentIfNotHandled(), Boolean.TRUE)) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.action_to_limitExceededFragment, null, null, 6, null);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[data.getServerState().ordinal()];
        if (i == 1) {
            ProgressBar pbRequestSms = getBinding().pbRequestSms;
            Intrinsics.checkNotNullExpressionValue(pbRequestSms, "pbRequestSms");
            ViewKt.gone(pbRequestSms);
            TextView tvAboutCode = getBinding().tvAboutCode;
            Intrinsics.checkNotNullExpressionValue(tvAboutCode, "tvAboutCode");
            ViewKt.visible(tvAboutCode);
            TextView btnLoginBySms2 = getBinding().btnLoginBySms;
            Intrinsics.checkNotNullExpressionValue(btnLoginBySms2, "btnLoginBySms");
            ViewKt.gone(btnLoginBySms2);
        } else if (i == 2) {
            ProgressBar pbRequestSms2 = getBinding().pbRequestSms;
            Intrinsics.checkNotNullExpressionValue(pbRequestSms2, "pbRequestSms");
            ViewKt.gone(pbRequestSms2);
            TextView tvAboutCode2 = getBinding().tvAboutCode;
            Intrinsics.checkNotNullExpressionValue(tvAboutCode2, "tvAboutCode");
            ViewKt.visible(tvAboutCode2);
            TextView btnLoginBySms3 = getBinding().btnLoginBySms;
            Intrinsics.checkNotNullExpressionValue(btnLoginBySms3, "btnLoginBySms");
            ViewKt.gone(btnLoginBySms3);
            getViewModel().startCountDownNew(getPhone());
        } else if (i == 3) {
            ProgressBar pbRequestSms3 = getBinding().pbRequestSms;
            Intrinsics.checkNotNullExpressionValue(pbRequestSms3, "pbRequestSms");
            ViewKt.gone(pbRequestSms3);
            TextView tvAboutCode3 = getBinding().tvAboutCode;
            Intrinsics.checkNotNullExpressionValue(tvAboutCode3, "tvAboutCode");
            ViewKt.visible(tvAboutCode3);
        } else if (i == 4) {
            TextView tvAboutCode4 = getBinding().tvAboutCode;
            Intrinsics.checkNotNullExpressionValue(tvAboutCode4, "tvAboutCode");
            ViewKt.gone(tvAboutCode4);
            TextView btnLoginBySms4 = getBinding().btnLoginBySms;
            Intrinsics.checkNotNullExpressionValue(btnLoginBySms4, "btnLoginBySms");
            ViewKt.gone(btnLoginBySms4);
            ProgressBar pbRequestSms4 = getBinding().pbRequestSms;
            Intrinsics.checkNotNullExpressionValue(pbRequestSms4, "pbRequestSms");
            ViewKt.visible(pbRequestSms4);
        }
        Boolean contentIfNotHandled = data.getToRequestCode().getContentIfNotHandled();
        if (contentIfNotHandled == null || !contentIfNotHandled.booleanValue()) {
            return;
        }
        ApplyRegistration applyRegistration = data.getApplyRegistration();
        navigateWithWay(applyRegistration != null ? applyRegistration.getWay() : null);
    }

    private final void navigateWithWay(RegistrationWay way) {
        Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("phone", getPhone()), TuplesKt.to("pretty_phone", getPrettyPhone()));
        int i = way == null ? -1 : WhenMappings.$EnumSwitchMapping$1[way.ordinal()];
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
            LocalizationLocalModel data = getLocalizationScreen().getData();
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

    /* compiled from: EnterListenedCodeFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dialog", "Landroid/app/AlertDialog;", "view", "Lcom/sputnik/common/databinding/DialogErrorSplashBinding;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$showCodeExpiredError$2, reason: invalid class name and case insensitive filesystem */
    static final class C07562 extends Lambda implements Function2<AlertDialog, DialogErrorSplashBinding, Unit> {
        C07562() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AlertDialog alertDialog, DialogErrorSplashBinding dialogErrorSplashBinding) {
            invoke2(alertDialog, dialogErrorSplashBinding);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final AlertDialog dialog, DialogErrorSplashBinding view) {
            AlertLocale alert;
            TextTitle okButton;
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            Intrinsics.checkNotNullParameter(view, "view");
            final EnterListenedCodeFragment enterListenedCodeFragment = EnterListenedCodeFragment.this;
            LocalizationLocalModel data = enterListenedCodeFragment.getLocalizationScreen().getData();
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
            view.btnRepeat.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$showCodeExpiredError$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    EnterListenedCodeFragment.C07562.invoke$lambda$2$lambda$1(dialog, enterListenedCodeFragment, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2$lambda$1(AlertDialog dialog, EnterListenedCodeFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            dialog.dismiss();
            FragmentKt.findNavController(this$0).navigateUp();
        }
    }

    /* compiled from: EnterListenedCodeFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$showCodeExpiredError$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C07551 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, DialogErrorSplashBinding> {
        public static final C07551 INSTANCE = new C07551();

        C07551() {
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
        companion.newInstance(contextRequireContext, C07551.INSTANCE, new C07562());
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideCodeError() {
        getBinding().viewPin.setTextColor(ContextCompat.getColor(requireContext(), R$color.black));
        getBinding().viewPin.setLineColor(ContextCompat.getColor(requireContext(), R$color.track_gray));
        TextView tvErrorCode = getBinding().tvErrorCode;
        Intrinsics.checkNotNullExpressionValue(tvErrorCode, "tvErrorCode");
        ViewKt.gone(tvErrorCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(CallCodeViewState data) {
        FragmentRegEnterCodeBinding binding = getBinding();
        if (data.getHandleCodeServerState() == Resource.Status.ERROR) {
            LinearLayout layoutProgress = binding.layoutProgress;
            Intrinsics.checkNotNullExpressionValue(layoutProgress, "layoutProgress");
            ViewKt.gone(layoutProgress);
        }
        TextView tvAboutCode = binding.tvAboutCode;
        Intrinsics.checkNotNullExpressionValue(tvAboutCode, "tvAboutCode");
        ViewBindingUtilsKt.visibilityBasedOn(tvAboutCode, Boolean.valueOf(!data.getNeedSendSms()));
        TextView btnLoginBySms = binding.btnLoginBySms;
        Intrinsics.checkNotNullExpressionValue(btnLoginBySms, "btnLoginBySms");
        ViewBindingUtilsKt.visibilityBasedOn(btnLoginBySms, Boolean.valueOf(data.getNeedSendSms()));
        binding.tvAboutCode.setText(data.getSmsSendRestricted() ? data.getSmsTimer() : StringUtilsKt.formatSafe(String.valueOf(getLocaleForTimer()), data.getSmsTimer()));
    }

    private final void initPhone(String phone) {
        AuthorizationBody authorizationCode;
        AuthorizationPhone phone2;
        Integer countryCode;
        String string;
        Log.e("phone", phone);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Phone phoneNumber = new PhoneNumberKit.Builder(contextRequireContext).build().parsePhoneNumber(phone, null);
        Mask.Result resultApply = new Mask("[" + StringsKt.repeat("0", (phoneNumber == null || (countryCode = phoneNumber.getCountryCode()) == null || (string = countryCode.toString()) == null) ? 1 : string.length()) + "] ([000]) [000] [00] [00999999]").apply(new CaretString(phone, phone.length(), new CaretString.CaretGravity.FORWARD(true)));
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (authorizationCode = data.getAuthorizationCode()) == null || (phone2 = authorizationCode.getPhone()) == null) {
            return;
        }
        TextWithParam numberInfo = phone2.getNumberInfo();
        String strValueOf = String.valueOf(numberInfo != null ? numberInfo.getText() : null);
        String str = "+" + resultApply.getFormattedText().getString();
        TextWithParam numberInfo2 = phone2.getNumberInfo();
        SpannableString spannableString = new SpannableString(String.format(strValueOf, str, numberInfo2 != null ? numberInfo2.getParam() : null));
        TextWithParam numberInfo3 = phone2.getNumberInfo();
        SpansKt.addColorSpan(spannableString, String.valueOf(numberInfo3 != null ? numberInfo3.getParam() : null), ContextCompat.getColor(requireContext(), R$color.sputnik_pink));
        TextWithParam numberInfo4 = phone2.getNumberInfo();
        SpansKt.addClickableSpan(spannableString, String.valueOf(numberInfo4 != null ? numberInfo4.getParam() : null), new Function1<View, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$initPhone$1$str$1$1
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
    }

    private final void initView() {
        String phone = getPhone();
        Intrinsics.checkNotNull(phone);
        initPhone(phone);
        TextView btnLoginBySms = getBinding().btnLoginBySms;
        Intrinsics.checkNotNullExpressionValue(btnLoginBySms, "btnLoginBySms");
        SafeClickListenerKt.setSafeOnClickListener$default(btnLoginBySms, 0L, new Function1<View, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment.initView.1
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
                ApplyRegistration applyRegistration = EnterListenedCodeFragment.this.getLoginViewModel().getCurrentState().getApplyRegistration();
                if (!(applyRegistration != null ? Intrinsics.areEqual(applyRegistration.getShowHelpOnFail(), Boolean.TRUE) : false)) {
                    TextView btnLoginBySms2 = EnterListenedCodeFragment.this.getBinding().btnLoginBySms;
                    Intrinsics.checkNotNullExpressionValue(btnLoginBySms2, "btnLoginBySms");
                    ButtonsExtensionsKt.showProgress(btnLoginBySms2, ContextCompat.getColor(EnterListenedCodeFragment.this.requireContext(), R$color.sputnik_blue));
                    EnterListenedCodeFragment.this.getLoginViewModel().handleDataNew(EnterListenedCodeFragment.this.getPhone(), EnterListenedCodeFragment.this.getPrettyPhone());
                    TextView tvAboutCode = EnterListenedCodeFragment.this.getBinding().tvAboutCode;
                    Intrinsics.checkNotNullExpressionValue(tvAboutCode, "tvAboutCode");
                    ViewKt.gone(tvAboutCode);
                    TextView btnLoginBySms3 = EnterListenedCodeFragment.this.getBinding().btnLoginBySms;
                    Intrinsics.checkNotNullExpressionValue(btnLoginBySms3, "btnLoginBySms");
                    ViewKt.gone(btnLoginBySms3);
                    ProgressBar pbRequestSms = EnterListenedCodeFragment.this.getBinding().pbRequestSms;
                    Intrinsics.checkNotNullExpressionValue(pbRequestSms, "pbRequestSms");
                    ViewKt.visible(pbRequestSms);
                    return;
                }
                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(EnterListenedCodeFragment.this), R$id.action_to_needHelpFragment, BundleKt.bundleOf(TuplesKt.to("phone", EnterListenedCodeFragment.this.getPhone()), TuplesKt.to("pretty_phone", EnterListenedCodeFragment.this.getPrettyPhone())), null, 4, null);
            }
        }, 1, null);
        FrameLayout rootView = getBinding().rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }

    private final void setUpCodeField() {
        PinView pinView = getBinding().viewPin;
        pinView.addTextChangedListener(new TextWatcher() { // from class: com.sputnik.oboarding.ui.registration.EnterListenedCodeFragment$setUpCodeField$1$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                this.this$0.hideCodeError();
                if (s == null || s.length() != 4) {
                    return;
                }
                LinearLayout layoutProgress = this.this$0.getBinding().layoutProgress;
                Intrinsics.checkNotNullExpressionValue(layoutProgress, "layoutProgress");
                ViewKt.visible(layoutProgress);
                NestedScrollView root = this.this$0.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.hideKeyboard(root);
                this.this$0.getViewModel().handleCodeNew(s.toString(), String.valueOf(this.this$0.getLoginViewModel().getCurrentState().getPrettyPhone()), String.valueOf(this.this$0.getLoginViewModel().getCurrentState().getCountryCode()), this.this$0.getPhone());
            }
        });
        pinView.requestFocus();
        Intrinsics.checkNotNull(pinView);
        ViewKt.showKeyboard(pinView);
    }

    private final void localize() {
        AuthorizationBody authorizationCode;
        TextWithParam title;
        TextWithParam title2;
        FragmentRegEnterCodeBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (authorizationCode = data.getAuthorizationCode()) == null) {
            return;
        }
        AuthorizationVoiced voiced = authorizationCode.getVoiced();
        String param = null;
        String strValueOf = String.valueOf((voiced == null || (title2 = voiced.getTitle()) == null) ? null : title2.getText());
        AuthorizationVoiced voiced2 = authorizationCode.getVoiced();
        if (voiced2 != null && (title = voiced2.getTitle()) != null) {
            param = title.getParam();
        }
        binding.tvTitle.setText(ViewUtilsKt.highlightText(strValueOf, String.valueOf(param), ContextCompat.getColor(requireContext(), R$color.sputnik_pink)));
        binding.tvErrorCode.setText(authorizationCode.getError());
    }
}
