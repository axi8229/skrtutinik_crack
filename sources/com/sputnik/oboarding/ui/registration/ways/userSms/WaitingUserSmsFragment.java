package com.sputnik.oboarding.ui.registration.ways.userSms;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.base.Notify;
import com.sputnik.common.base.SimpleDialog;
import com.sputnik.common.databinding.DialogErrorSplashBinding;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.auth.ApplyRegistration;
import com.sputnik.common.entities.localization.AlertData;
import com.sputnik.common.entities.localization.AlertLocale;
import com.sputnik.common.entities.localization.ArchivePopUpBody;
import com.sputnik.common.entities.localization.ArchivePopUpLocale;
import com.sputnik.common.entities.localization.CommonLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.AuthorizationBody;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.UserSms;
import com.sputnik.common.entities.localization.entities.onboarding_localization_screens.WaitingScreen;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.ButtonsExtensionsKt;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.DateConvertersKt;
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
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import com.sputnik.oboarding.R$color;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.R$string;
import com.sputnik.oboarding.databinding.FragmentRegWaitingUserSmsBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment;
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

/* compiled from: WaitingUserSmsFragment.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\b\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0003R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001b\u0010J\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010G\u001a\u0004\bM\u0010NR\"\u0010Q\u001a\u00020P8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001b\u0010[\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010G\u001a\u0004\bY\u0010ZR\u001b\u0010`\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010G\u001a\u0004\b^\u0010_R\u001d\u0010e\u001a\u0004\u0018\u00010a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010G\u001a\u0004\bc\u0010dR\u001d\u0010h\u001a\u0004\u0018\u00010a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010G\u001a\u0004\bg\u0010d¨\u0006i"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/ways/userSms/WaitingUserSmsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "initView", "Lcom/sputnik/common/viewmodels/LoginViewState;", RemoteMessageConst.DATA, "renderUi", "(Lcom/sputnik/common/viewmodels/LoginViewState;)V", "Lcom/sputnik/common/viewmodels/ErrorContainer;", "errorContainer", "renderError", "(Lcom/sputnik/common/viewmodels/ErrorContainer;)V", "Lcom/sputnik/common/viewmodels/CallCodeViewState;", "(Lcom/sputnik/common/viewmodels/CallCodeViewState;)V", "showCodeError", "showCodeExpiredError", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "way", "navigateWithWay", "(Lcom/sputnik/domain/entities/auth/RegistrationWay;)V", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "onStop", "Lcom/sputnik/oboarding/databinding/FragmentRegWaitingUserSmsBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentRegWaitingUserSmsBinding;", "binding", "Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "callCodeFactoryBuilder", "Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "getCallCodeFactoryBuilder", "()Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;", "setCallCodeFactoryBuilder", "(Lcom/sputnik/common/viewmodels/CallCodeViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/CallCodeViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/sputnik/common/viewmodels/CallCodeViewModel;", "viewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel$delegate", "getLoginViewModel", "()Lcom/sputnik/common/viewmodels/LoginViewModel;", "loginViewModel", "", "phone$delegate", "getPhone", "()Ljava/lang/String;", "phone", "prettyPhone$delegate", "getPrettyPhone", "prettyPhone", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WaitingUserSmsFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(WaitingUserSmsFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentRegWaitingUserSmsBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public CallCodeViewModel.Factory.AssistFactory callCodeFactoryBuilder;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
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

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WaitingUserSmsFragment.kt */
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

    private final void showCodeError() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentRegWaitingUserSmsBinding getBinding() {
        return (FragmentRegWaitingUserSmsBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
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
        getViewModel().startCountDown(60);
        CallCodeViewModel viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        viewModel.observeState(viewLifecycleOwner, new AnonymousClass1(this));
        CallCodeViewModel viewModel2 = getViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        viewModel2.observeSubState(viewLifecycleOwner2, new Function1<CallCodeViewState, Event<? extends Boolean>>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment.onViewCreated.2
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(CallCodeViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isLoaded();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment.onViewCreated.3
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
                    WaitingUserSmsFragment waitingUserSmsFragment = WaitingUserSmsFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        FragmentRegWaitingUserSmsBinding binding = waitingUserSmsFragment.getBinding();
                        AppCompatButton btnDone = binding.btnDone;
                        Intrinsics.checkNotNullExpressionValue(btnDone, "btnDone");
                        ViewKt.visible(btnDone);
                        TextView btnChangeAuthMethod = binding.btnChangeAuthMethod;
                        Intrinsics.checkNotNullExpressionValue(btnChangeAuthMethod, "btnChangeAuthMethod");
                        ViewKt.gone(btnChangeAuthMethod);
                        ImageView ivDone = binding.ivDone;
                        Intrinsics.checkNotNullExpressionValue(ivDone, "ivDone");
                        ViewKt.visible(ivDone);
                        TextView tvDone = binding.tvDone;
                        Intrinsics.checkNotNullExpressionValue(tvDone, "tvDone");
                        ViewKt.visible(tvDone);
                        TextView tvTimer = binding.tvTimer;
                        Intrinsics.checkNotNullExpressionValue(tvTimer, "tvTimer");
                        ViewKt.gone(tvTimer);
                        TextView tvTitle = binding.tvTitle;
                        Intrinsics.checkNotNullExpressionValue(tvTitle, "tvTitle");
                        ViewKt.gone(tvTitle);
                        ProgressBar progressBar2 = binding.progressBar2;
                        Intrinsics.checkNotNullExpressionValue(progressBar2, "progressBar2");
                        ViewKt.gone(progressBar2);
                    }
                }
            }
        });
        CallCodeViewModel viewModel3 = getViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        viewModel3.observeSubState(viewLifecycleOwner3, new AnonymousClass4(ErrorContainer.INSTANCE), new AnonymousClass5(this));
        LoginViewModel loginViewModel = getLoginViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        loginViewModel.observeNotifications(viewLifecycleOwner4, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment.onViewCreated.6
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
                WaitingUserSmsFragment waitingUserSmsFragment = WaitingUserSmsFragment.this;
                NestedScrollView root = waitingUserSmsFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(waitingUserSmsFragment, root, it);
            }
        });
        LoginViewModel loginViewModel2 = getLoginViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        loginViewModel2.observeState(viewLifecycleOwner5, new AnonymousClass7(this));
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        profileViewModel.observeSubState(viewLifecycleOwner6, new Function1<ProfileViewState, Event<? extends ProfileNavigationState>>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment.onViewCreated.8
            @Override // kotlin.jvm.functions.Function1
            public final Event<ProfileNavigationState> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileState();
            }
        }, new Function1<Event<? extends ProfileNavigationState>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment.onViewCreated.9
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
                AuthorizationBody authorizationCode;
                UserSms userSms;
                WaitingScreen waitingScreen;
                TextTitle continueButton;
                Intrinsics.checkNotNullParameter(it, "it");
                ProfileNavigationState contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    WaitingUserSmsFragment waitingUserSmsFragment = WaitingUserSmsFragment.this;
                    AppCompatButton btnDone = waitingUserSmsFragment.getBinding().btnDone;
                    Intrinsics.checkNotNullExpressionValue(btnDone, "btnDone");
                    LocalizationLocalModel data = waitingUserSmsFragment.getLocalizationStorage().getData();
                    ButtonsExtensionsKt.hideProgress(btnDone, String.valueOf((data == null || (authorizationCode = data.getAuthorizationCode()) == null || (userSms = authorizationCode.getUserSms()) == null || (waitingScreen = userSms.getWaitingScreen()) == null || (continueButton = waitingScreen.getContinueButton()) == null) ? null : continueButton.getTitle()));
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToRegistrationState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(waitingUserSmsFragment), R$id.action_to_enterNameFragment, null, null, 6, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToVerifyAddressState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(waitingUserSmsFragment), R$id.action_to_confirmAddressFragment, null, null, 6, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToEnterFlatNumberState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(waitingUserSmsFragment), R$id.action_to_enterFlatNumberFragment, null, null, 6, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToIntercomState) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(waitingUserSmsFragment), R$id.action_to_connectToIntercomFragment, null, null, 6, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToActivatedState) {
                        waitingUserSmsFragment.getCamerasViewModel().setNeedLoadCameras(true);
                        Uri uri = Uri.parse(waitingUserSmsFragment.getString(R$string.deeplink_main));
                        FragmentKt.findNavController(waitingUserSmsFragment).popBackStack(R$id.startRegistrationFragment, true);
                        NavController navControllerFindNavController = FragmentKt.findNavController(waitingUserSmsFragment);
                        Intrinsics.checkNotNull(uri);
                        navControllerFindNavController.navigate(uri);
                    }
                }
            }
        });
    }

    /* compiled from: WaitingUserSmsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<CallCodeViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, WaitingUserSmsFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/CallCodeViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CallCodeViewState callCodeViewState) {
            invoke2(callCodeViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CallCodeViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((WaitingUserSmsFragment) this.receiver).renderUi(p0);
        }
    }

    /* compiled from: WaitingUserSmsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$onViewCreated$4, reason: invalid class name */
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

    /* compiled from: WaitingUserSmsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$onViewCreated$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<ErrorContainer, Unit> {
        AnonymousClass5(Object obj) {
            super(1, obj, WaitingUserSmsFragment.class, "renderError", "renderError(Lcom/sputnik/common/viewmodels/ErrorContainer;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ErrorContainer errorContainer) {
            invoke2(errorContainer);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ErrorContainer p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((WaitingUserSmsFragment) this.receiver).renderError(p0);
        }
    }

    /* compiled from: WaitingUserSmsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$onViewCreated$7, reason: invalid class name */
    /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<LoginViewState, Unit> {
        AnonymousClass7(Object obj) {
            super(1, obj, WaitingUserSmsFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/LoginViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LoginViewState loginViewState) {
            invoke2(loginViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LoginViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((WaitingUserSmsFragment) this.receiver).renderUi(p0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        LoginViewState currentState;
        LoginViewState currentState2;
        super.onStart();
        LoginState.Session sessionByPhone = getLoginViewModel().getSessionByPhone();
        CallCodeViewModel viewModel = getViewModel();
        String countryCode = null;
        String requestId = sessionByPhone != null ? sessionByPhone.getRequestId() : null;
        String userSmsCode = sessionByPhone != null ? sessionByPhone.getUserSmsCode() : null;
        LoginViewModel loginViewModel = getLoginViewModel();
        String prettyPhone = (loginViewModel == null || (currentState2 = loginViewModel.getCurrentState()) == null) ? null : currentState2.getPrettyPhone();
        LoginViewModel loginViewModel2 = getLoginViewModel();
        if (loginViewModel2 != null && (currentState = loginViewModel2.getCurrentState()) != null) {
            countryCode = currentState.getCountryCode();
        }
        viewModel.startProfileJob(requestId, userSmsCode, prettyPhone, countryCode);
    }

    public WaitingUserSmsFragment() {
        super(R$layout.fragment_reg_waiting_user_sms);
        this.binding = new ViewBindingFragmentDelegate(this, WaitingUserSmsFragment$binding$2.INSTANCE);
        final Function0 function0 = null;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        Function0<ViewModelProvider.Factory> function02 = new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                CallCodeViewModel.Factory.AssistFactory callCodeFactoryBuilder = this.this$0.getCallCodeFactoryBuilder();
                Bundle arguments = this.this$0.getArguments();
                return callCodeFactoryBuilder.create(arguments != null ? arguments.getString("phone") : null);
            }
        };
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CallCodeViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$special$$inlined$viewModels$default$4
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
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$camerasViewModel$2
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
        this.loginViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$special$$inlined$activityViewModels$default$7
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$loginViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.phone = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$phone$2
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
        this.prettyPhone = LazyKt.lazy(new Function0<String>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$prettyPhone$2
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

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getViewModel().stopJob();
    }

    private final void initView() {
        final FragmentRegWaitingUserSmsBinding binding = getBinding();
        FrameLayout rootView = binding.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
        TextView btnChangeAuthMethod = binding.btnChangeAuthMethod;
        Intrinsics.checkNotNullExpressionValue(btnChangeAuthMethod, "btnChangeAuthMethod");
        SafeClickListenerKt.setSafeOnClickListener$default(btnChangeAuthMethod, 0L, new Function1<View, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$initView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                CallCodeViewState currentState = this.this$0.getViewModel().getCurrentState();
                if ((currentState != null ? currentState.getCount() : 0) <= 0) {
                    this.this$0.getViewModel().stopJob();
                    ApplyRegistration applyRegistration = this.this$0.getLoginViewModel().getCurrentState().getApplyRegistration();
                    if (applyRegistration != null ? Intrinsics.areEqual(applyRegistration.getShowHelpOnFail(), Boolean.TRUE) : false) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this.this$0), R$id.action_to_needHelpFragment, BundleKt.bundleOf(TuplesKt.to("phone", this.this$0.getPhone()), TuplesKt.to("pretty_phone", this.this$0.getLoginViewModel().getCurrentState().getPrettyPhone())), null, 4, null);
                        return;
                    }
                    TextView btnChangeAuthMethod2 = binding.btnChangeAuthMethod;
                    Intrinsics.checkNotNullExpressionValue(btnChangeAuthMethod2, "btnChangeAuthMethod");
                    ButtonsExtensionsKt.showProgress(btnChangeAuthMethod2, ContextCompat.getColor(this.this$0.requireContext(), R$color.sputnik_blue));
                    this.this$0.getLoginViewModel().handleDataNew(this.this$0.getPhone(), this.this$0.getLoginViewModel().getCurrentState().getPrettyPhone());
                    return;
                }
                NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this.this$0), R$id.action_to_sendUserSmsFromOtherDeviceFragment, BundleKt.bundleOf(TuplesKt.to("phone", this.this$0.getPhone()), TuplesKt.to("pretty_phone", this.this$0.getPrettyPhone()), TuplesKt.to("is_from_waiting_screen", Boolean.TRUE)), null, 4, null);
            }
        }, 1, null);
        AppCompatButton btnDone = binding.btnDone;
        Intrinsics.checkNotNullExpressionValue(btnDone, "btnDone");
        SafeClickListenerKt.setSafeOnClickListener$default(btnDone, 0L, new Function1<View, Unit>() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$initView$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                IProfileViewModel.DefaultImpls.loadProfile$default(this.this$0.getProfileViewModel(), false, 1, null);
                AppCompatButton btnDone2 = binding.btnDone;
                Intrinsics.checkNotNullExpressionValue(btnDone2, "btnDone");
                ButtonsExtensionsKt.showProgress$default(btnDone2, 0, 1, null);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(LoginViewState data) {
        AuthorizationBody authorizationCode;
        if (data.getServerState() == Resource.Status.ERROR) {
            TextView btnChangeAuthMethod = getBinding().btnChangeAuthMethod;
            Intrinsics.checkNotNullExpressionValue(btnChangeAuthMethod, "btnChangeAuthMethod");
            LocalizationLocalModel data2 = getLocalizationStorage().getData();
            ButtonsExtensionsKt.hideProgress(btnChangeAuthMethod, String.valueOf((data2 == null || (authorizationCode = data2.getAuthorizationCode()) == null) ? null : authorizationCode.getChangeMethodButton()));
        }
        Boolean contentIfNotHandled = data.getToRequestCode().getContentIfNotHandled();
        if (contentIfNotHandled != null && contentIfNotHandled.booleanValue()) {
            ApplyRegistration applyRegistration = data.getApplyRegistration();
            navigateWithWay(applyRegistration != null ? applyRegistration.getWay() : null);
        }
        if (data.isLimitExceeded().peekContent().booleanValue() && Intrinsics.areEqual(data.isLimitExceeded().getContentIfNotHandled(), Boolean.TRUE)) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.action_enterPhoneFragment_to_limitExceededFragment, null, null, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderError(ErrorContainer errorContainer) {
        Integer code;
        ArchivePopUpLocale archivePopUp;
        ArchivePopUpBody body;
        TextTitle doneButton;
        DomainEmpty parsedError = errorContainer.getParsedError();
        if (parsedError != null && (code = parsedError.getCode()) != null && code.intValue() == ErrorCodes.INSTANCE.getSESSION_EXPIRED()) {
            FragmentKt.findNavController(this).popBackStack(R$id.enterPhoneFragment, false);
            NavController navControllerFindNavController = FragmentKt.findNavController(this);
            int i = R$id.action_to_singleButtonDialog;
            DomainEmpty parsedError2 = getViewModel().getCurrentState().getParsedError();
            Pair pair = TuplesKt.to("subtitle", parsedError2 != null ? parsedError2.getMessage() : null);
            LocalizationLocalModel data = getLocalizationStorage().getData();
            NavControllerKt.safeNavigate$default(navControllerFindNavController, i, BundleKt.bundleOf(pair, TuplesKt.to("button_text", (data == null || (archivePopUp = data.getArchivePopUp()) == null || (body = archivePopUp.getBody()) == null || (doneButton = body.getDoneButton()) == null) ? null : doneButton.getTitle())), null, 4, null);
            getViewModel().clearError();
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
        AuthorizationBody authorizationCode;
        UserSms userSms;
        WaitingScreen waitingScreen;
        TextTitle instructionsButton;
        CommonLocale common;
        AuthorizationBody authorizationCode2;
        FragmentRegWaitingUserSmsBinding binding = getBinding();
        String title = null;
        if (data.getCount() == 0) {
            TextView tvTimer = binding.tvTimer;
            Intrinsics.checkNotNullExpressionValue(tvTimer, "tvTimer");
            ViewKt.gone(tvTimer);
            TextView textView = binding.btnChangeAuthMethod;
            LocalizationLocalModel data2 = getLocalizationStorage().getData();
            if (data2 != null && (authorizationCode2 = data2.getAuthorizationCode()) != null) {
                title = authorizationCode2.getChangeMethodButton();
            }
            textView.setText(title);
        } else {
            TextView textView2 = binding.btnChangeAuthMethod;
            LocalizationLocalModel data3 = getLocalizationStorage().getData();
            if (data3 != null && (authorizationCode = data3.getAuthorizationCode()) != null && (userSms = authorizationCode.getUserSms()) != null && (waitingScreen = userSms.getWaitingScreen()) != null && (instructionsButton = waitingScreen.getInstructionsButton()) != null) {
                title = instructionsButton.getTitle();
            }
            textView2.setText(title);
        }
        LocalizationLocalModel data4 = getLocalizationStorage().getData();
        if (data4 == null || (common = data4.getCommon()) == null) {
            return;
        }
        binding.tvTimer.setText(data.getCount() + " " + DateConvertersKt.getSecondsInString(data.getCount(), common));
    }

    /* compiled from: WaitingUserSmsFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dialog", "Landroid/app/AlertDialog;", "view", "Lcom/sputnik/common/databinding/DialogErrorSplashBinding;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$showCodeExpiredError$2, reason: invalid class name and case insensitive filesystem */
    static final class C07712 extends Lambda implements Function2<AlertDialog, DialogErrorSplashBinding, Unit> {
        C07712() {
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
            final WaitingUserSmsFragment waitingUserSmsFragment = WaitingUserSmsFragment.this;
            LocalizationLocalModel data = waitingUserSmsFragment.getLocalizationStorage().getData();
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
            view.btnRepeat.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$showCodeExpiredError$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WaitingUserSmsFragment.C07712.invoke$lambda$2$lambda$1(waitingUserSmsFragment, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2$lambda$1(WaitingUserSmsFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FragmentKt.findNavController(this$0).navigateUp();
        }
    }

    /* compiled from: WaitingUserSmsFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.ways.userSms.WaitingUserSmsFragment$showCodeExpiredError$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C07701 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, DialogErrorSplashBinding> {
        public static final C07701 INSTANCE = new C07701();

        C07701() {
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
        companion.newInstance(contextRequireContext, C07701.INSTANCE, new C07712());
    }

    private final void navigateWithWay(RegistrationWay way) {
        Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("phone", getLoginViewModel().getCurrentState().getPhone()), TuplesKt.to("pretty_phone", getLoginViewModel().getCurrentState().getPrettyPhone()));
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
        AuthorizationBody authorizationCode;
        UserSms userSms;
        WaitingScreen waitingScreen;
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data == null || (authorizationCode = data.getAuthorizationCode()) == null || (userSms = authorizationCode.getUserSms()) == null || (waitingScreen = userSms.getWaitingScreen()) == null) {
            return;
        }
        FragmentRegWaitingUserSmsBinding binding = getBinding();
        binding.tvTitle.setText(waitingScreen.getTitle());
        AppCompatButton appCompatButton = binding.btnDone;
        TextTitle continueButton = waitingScreen.getContinueButton();
        appCompatButton.setText(continueButton != null ? continueButton.getTitle() : null);
        TextView textView = binding.tvDone;
        TextTitle doneButton = waitingScreen.getDoneButton();
        textView.setText(doneButton != null ? doneButton.getTitle() : null);
        TextView textView2 = binding.btnChangeAuthMethod;
        TextTitle instructionsButton = waitingScreen.getInstructionsButton();
        textView2.setText(instructionsButton != null ? instructionsButton.getTitle() : null);
    }
}
