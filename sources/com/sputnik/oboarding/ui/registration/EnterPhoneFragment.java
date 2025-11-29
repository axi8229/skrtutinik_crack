package com.sputnik.oboarding.ui.registration;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
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
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.redmadrobot.inputmask.MaskedTextChangedListener;
import com.redmadrobot.inputmask.helper.AffinityCalculationStrategy;
import com.sputnik.common.AndroidConstants;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.analytics.AnalyticsTracker;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.auth.ApplyRegistration;
import com.sputnik.common.entities.country_code.CountryCode;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.WidgetsLocale;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.login.PhoneLoginBody;
import com.sputnik.common.entities.localization.entities.login.PhoneLoginLocale;
import com.sputnik.common.entities.localization.entities.login.PhoneLoginPrivacy;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.SpansKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.ui.utils.ButtonsExtensionsKt;
import com.sputnik.common.ui.utils.SafeClickListenerKt;
import com.sputnik.common.utils.ValidatorsKt;
import com.sputnik.common.utils.ViewBindingUtilsKt;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.LoginViewModel;
import com.sputnik.common.viewmodels.LoginViewState;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.ProfileViewState;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.auth.RegistrationWay;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.R$string;
import com.sputnik.oboarding.analytics.yandex.OnBoardingEvents;
import com.sputnik.oboarding.databinding.FragmentRegNumberBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.internal.Util;

/* compiled from: EnterPhoneFragment.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J!\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001d\u0010:\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u00109\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u00109\u001a\u0004\bC\u0010DR\"\u0010G\u001a\u00020F8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u00109\u001a\u0004\bO\u0010PR#\u0010W\u001a\n S*\u0004\u0018\u00010R0R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u00109\u001a\u0004\bU\u0010V¨\u0006X"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/EnterPhoneFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Lcom/sputnik/common/viewmodels/LoginViewState;", RemoteMessageConst.DATA, "", "renderUi", "(Lcom/sputnik/common/viewmodels/LoginViewState;)V", "setUpButtons", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "way", "navigateWithWay", "(Lcom/sputnik/domain/entities/auth/RegistrationWay;)V", "login", "setEditText", "localize", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onResume", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentRegNumberBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentRegNumberBinding;", "binding", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "", "isAuth$delegate", "Lkotlin/Lazy;", "isAuth", "()Ljava/lang/Boolean;", "Lcom/sputnik/common/viewmodels/LoginViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/sputnik/common/viewmodels/LoginViewModel;", "viewModel", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "cameraViewModelFactory", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "getCameraViewModelFactory", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;", "setCameraViewModelFactory", "(Lcom/sputnik/common/viewmodels/AllCamerasViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel$delegate", "getCamerasViewModel", "()Lcom/sputnik/common/viewmodels/AllCamerasViewModel;", "camerasViewModel", "Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "kotlin.jvm.PlatformType", "phoneNumberUtil$delegate", "getPhoneNumberUtil", "()Lio/michaelrocks/libphonenumber/android/PhoneNumberUtil;", "phoneNumberUtil", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EnterPhoneFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(EnterPhoneFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentRegNumberBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public AllCamerasViewModel.Factory.AssistFactory cameraViewModelFactory;

    /* renamed from: camerasViewModel$delegate, reason: from kotlin metadata */
    private final Lazy camerasViewModel;
    public MultiViewModelFactory factory;

    /* renamed from: isAuth$delegate, reason: from kotlin metadata */
    private final Lazy isAuth;
    public LocalizationStorage localizationStorage;

    /* renamed from: phoneNumberUtil$delegate, reason: from kotlin metadata */
    private final Lazy phoneNumberUtil;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: EnterPhoneFragment.kt */
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
    public final FragmentRegNumberBinding getBinding() {
        return (FragmentRegNumberBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
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

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final Boolean isAuth() {
        return (Boolean) this.isAuth.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoginViewModel getViewModel() {
        return (LoginViewModel) this.viewModel.getValue();
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

    private final PhoneNumberUtil getPhoneNumberUtil() {
        return (PhoneNumberUtil) this.phoneNumberUtil.getValue();
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
        getViewModel().loadAccounts();
        Window window = requireActivity().getWindow();
        window.setNavigationBarColor(0);
        window.setSoftInputMode(16);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getAnalytics().trackLogEvent(new AnalyticsTracker.Event("phoneEnter", "show", null, 4, null));
        localize();
        setUpButtons();
        setEditText();
        LoginViewModel viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        viewModel.observeNotifications(viewLifecycleOwner, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment.onViewCreated.1
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
                EnterPhoneFragment enterPhoneFragment = EnterPhoneFragment.this;
                NestedScrollView root = enterPhoneFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(enterPhoneFragment, root, it);
                EnterPhoneFragment.this.getBinding().btnAccept.setEnabled(true);
            }
        });
        LoginViewModel viewModel2 = getViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        viewModel2.observeState(viewLifecycleOwner2, new C07572(this));
        getViewModel().cleanCamerasInWidget();
        LoginViewModel viewModel3 = getViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        viewModel3.observeSubState(viewLifecycleOwner3, new Function1<LoginViewState, Event<? extends Boolean>>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(LoginViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isLoaded();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment.onViewCreated.4
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
                    final EnterPhoneFragment enterPhoneFragment = EnterPhoneFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        enterPhoneFragment.getProfileViewModel().delayRequest(500L, new Function0<Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$onViewCreated$4$1$1
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
                                enterPhoneFragment.getProfileViewModel().loadProfile(false);
                            }
                        });
                    }
                }
            }
        });
        ProfileViewModel profileViewModel = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        profileViewModel.observeSubState(viewLifecycleOwner4, new Function1<ProfileViewState, Resource.Status>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment.onViewCreated.5
            @Override // kotlin.jvm.functions.Function1
            public final Resource.Status invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileServerState();
            }
        }, new Function1<Resource.Status, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment.onViewCreated.6
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
                PhoneLoginLocale phoneLogin;
                PhoneLoginBody body;
                TextTitle continueButton;
                Intrinsics.checkNotNullParameter(it, "it");
                AppCompatButton btnAccept = EnterPhoneFragment.this.getBinding().btnAccept;
                Intrinsics.checkNotNullExpressionValue(btnAccept, "btnAccept");
                boolean z = it == Resource.Status.LOADING;
                LocalizationLocalModel data = EnterPhoneFragment.this.getLocalizationStorage().getData();
                ViewBindingUtilsKt.showProgressBasedOn$default(btnAccept, z, String.valueOf((data == null || (phoneLogin = data.getPhoneLogin()) == null || (body = phoneLogin.getBody()) == null || (continueButton = body.getContinueButton()) == null) ? null : continueButton.getTitle()), 0, false, 12, null);
            }
        });
        ProfileViewModel profileViewModel2 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        profileViewModel2.observeSubState(viewLifecycleOwner5, new Function1<ProfileViewState, Event<? extends Boolean>>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment.onViewCreated.7
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isAccountDeleted();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment.onViewCreated.8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) throws NumberFormatException {
                invoke2((Event<Boolean>) event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<Boolean> it) throws NumberFormatException {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.getContentIfNotHandled() != null) {
                    EnterPhoneFragment.this.login();
                }
            }
        });
        ProfileViewModel profileViewModel3 = getProfileViewModel();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        profileViewModel3.observeSubState(viewLifecycleOwner6, new Function1<ProfileViewState, Event<? extends ProfileNavigationState>>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment.onViewCreated.9
            @Override // kotlin.jvm.functions.Function1
            public final Event<ProfileNavigationState> invoke(ProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getProfileState();
            }
        }, new Function1<Event<? extends ProfileNavigationState>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment.onViewCreated.10
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
                    EnterPhoneFragment enterPhoneFragment = EnterPhoneFragment.this;
                    enterPhoneFragment.getViewModel().clearToRequestCode();
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToRegistrationState) {
                        EditText etEnterPhone = enterPhoneFragment.getBinding().etEnterPhone;
                        Intrinsics.checkNotNullExpressionValue(etEnterPhone, "etEnterPhone");
                        ViewKt.hideKeyboard(etEnterPhone);
                        enterPhoneFragment.getAnalytics().trackLogEvent(new AnalyticsTracker.Event("account_state", "unregistered", null, 4, null));
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(enterPhoneFragment), R$id.action_to_enterNameFragment, null, null, 6, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToVerifyAddressState) {
                        EditText etEnterPhone2 = enterPhoneFragment.getBinding().etEnterPhone;
                        Intrinsics.checkNotNullExpressionValue(etEnterPhone2, "etEnterPhone");
                        ViewKt.hideKeyboard(etEnterPhone2);
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(enterPhoneFragment), R$id.action_to_confirmAddressFragment, null, null, 6, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToEnterFlatNumberState) {
                        EditText etEnterPhone3 = enterPhoneFragment.getBinding().etEnterPhone;
                        Intrinsics.checkNotNullExpressionValue(etEnterPhone3, "etEnterPhone");
                        ViewKt.hideKeyboard(etEnterPhone3);
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(enterPhoneFragment), R$id.action_to_enterFlatNumberFragment, null, null, 6, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToIntercomState) {
                        EditText etEnterPhone4 = enterPhoneFragment.getBinding().etEnterPhone;
                        Intrinsics.checkNotNullExpressionValue(etEnterPhone4, "etEnterPhone");
                        ViewKt.hideKeyboard(etEnterPhone4);
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(enterPhoneFragment), R$id.action_to_connectToIntercomFragment, null, null, 6, null);
                        return;
                    }
                    if (contentIfNotHandled instanceof ProfileNavigationState.ToActivatedState) {
                        EditText etEnterPhone5 = enterPhoneFragment.getBinding().etEnterPhone;
                        Intrinsics.checkNotNullExpressionValue(etEnterPhone5, "etEnterPhone");
                        ViewKt.hideKeyboard(etEnterPhone5);
                        Uri uri = Uri.parse(enterPhoneFragment.getString(R$string.deeplink_main));
                        enterPhoneFragment.getCamerasViewModel().setNeedLoadCameras(true);
                        FragmentKt.findNavController(enterPhoneFragment).popBackStack(R$id.selectAccountFragment, true);
                        NavController navControllerFindNavController = FragmentKt.findNavController(enterPhoneFragment);
                        Intrinsics.checkNotNull(uri);
                        navControllerFindNavController.navigate(uri);
                    }
                }
            }
        });
    }

    /* compiled from: EnterPhoneFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$onViewCreated$2, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C07572 extends FunctionReferenceImpl implements Function1<LoginViewState, Unit> {
        C07572(Object obj) {
            super(1, obj, EnterPhoneFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/LoginViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LoginViewState loginViewState) {
            invoke2(loginViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LoginViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EnterPhoneFragment) this.receiver).renderUi(p0);
        }
    }

    public EnterPhoneFragment() {
        super(R$layout.fragment_reg_number);
        this.binding = new ViewBindingFragmentDelegate(this, EnterPhoneFragment$binding$2.INSTANCE);
        this.isAuth = LazyKt.lazy(new Function0<Boolean>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment.isAuth.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle arguments = EnterPhoneFragment.this.getArguments();
                return (Boolean) (arguments != null ? arguments.get("is_auth") : null);
            }
        });
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LoginViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$special$$inlined$activityViewModels$default$4
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$special$$inlined$activityViewModels$default$5
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        });
        this.camerasViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AllCamerasViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$special$$inlined$activityViewModels$default$7
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$special$$inlined$activityViewModels$default$8
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$camerasViewModel$2
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
        this.phoneNumberUtil = LazyKt.lazy(new Function0<PhoneNumberUtil>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$phoneNumberUtil$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PhoneNumberUtil invoke() {
                return PhoneNumberUtil.createInstance(this.this$0.requireContext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(LoginViewState data) {
        PhoneLoginLocale phoneLogin;
        PhoneLoginBody body;
        TextTitle continueButton;
        Object next;
        AppCompatButton appCompatButton = getBinding().btnAccept;
        PhoneNumberUtil phoneNumberUtil = getPhoneNumberUtil();
        Intrinsics.checkNotNullExpressionValue(phoneNumberUtil, "<get-phoneNumberUtil>(...)");
        appCompatButton.setEnabled(ValidatorsKt.isValidPhone(phoneNumberUtil, getBinding().tvEditCountryCode.getText().toString(), data.getRawPhone()));
        String code = null;
        if (data.getServerState() == Resource.Status.SUCCESS || data.getServerState() == Resource.Status.ERROR) {
            AppCompatButton btnAccept = getBinding().btnAccept;
            Intrinsics.checkNotNullExpressionValue(btnAccept, "btnAccept");
            LocalizationLocalModel data2 = getLocalizationStorage().getData();
            ButtonsExtensionsKt.hideProgress(btnAccept, String.valueOf((data2 == null || (phoneLogin = data2.getPhoneLogin()) == null || (body = phoneLogin.getBody()) == null || (continueButton = body.getContinueButton()) == null) ? null : continueButton.getTitle()));
        }
        Boolean contentIfNotHandled = data.getToRequestCode().getContentIfNotHandled();
        if (contentIfNotHandled != null && contentIfNotHandled.booleanValue()) {
            getProfileViewModel().postClearingSupportChat();
            ApplyRegistration applyRegistration = data.getApplyRegistration();
            navigateWithWay(applyRegistration != null ? applyRegistration.getWay() : null);
        }
        TextView textView = getBinding().tvEditCountryCode;
        String countryCode = data.getCountryCode();
        if (countryCode == null) {
            List<CountryCode> countryCodeList = data.getCountryCodeList();
            if (countryCodeList != null) {
                Iterator<T> it = countryCodeList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (Intrinsics.areEqual(((CountryCode) next).getIsoCode(), AndroidConstants.INSTANCE.getPhoneCountry())) {
                            break;
                        }
                    }
                }
                CountryCode countryCode2 = (CountryCode) next;
                if (countryCode2 != null) {
                    code = countryCode2.getCode();
                }
            }
            countryCode = code != null ? code : "+7";
        }
        textView.setText(countryCode);
        if (data.isLimitExceeded().peekContent().booleanValue() && Intrinsics.areEqual(data.isLimitExceeded().getContentIfNotHandled(), Boolean.TRUE)) {
            NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this), R$id.action_to_limitExceededFragment, null, null, 6, null);
        }
    }

    private final void setUpButtons() {
        final FragmentRegNumberBinding binding = getBinding();
        AppCompatButton btnAccept = binding.btnAccept;
        Intrinsics.checkNotNullExpressionValue(btnAccept, "btnAccept");
        SafeClickListenerKt.setSafeOnClickListener$default(btnAccept, 0L, new Function1<View, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$setUpButtons$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) throws NumberFormatException {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) throws NumberFormatException {
                String str;
                Long codeExpiresAt;
                PhoneLoginLocale phoneLogin;
                PhoneLoginBody body;
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationStepOneNextEvent());
                String str2 = ((Object) binding.tvEditCountryCode.getText()) + " " + ((Object) binding.etEnterPhone.getText());
                incorrectPhoneError = null;
                incorrectPhoneError = null;
                String incorrectPhoneError = null;
                if (this.this$0.getViewModel().checkSessionByPhone(str2)) {
                    LoginViewModel viewModel = this.this$0.getViewModel();
                    String string = binding.tvEditCountryCode.getText().toString();
                    Editable text = binding.etEnterPhone.getText();
                    viewModel.selectSessionByPhone(str2, string, text != null ? text.toString() : null);
                    AppCompatButton btnAccept2 = this.this$0.getBinding().btnAccept;
                    Intrinsics.checkNotNullExpressionValue(btnAccept2, "btnAccept");
                    ButtonsExtensionsKt.showProgress$default(btnAccept2, 0, 1, null);
                    return;
                }
                Editable text2 = binding.etEnterPhone.getText();
                Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
                if (text2.length() == 0) {
                    str = null;
                } else {
                    str = Integer.parseInt(binding.tvEditCountryCode.getText().toString()) + this.this$0.getViewModel().getCurrentState().getRawPhone();
                }
                if (str == null) {
                    LoginViewModel viewModel2 = this.this$0.getViewModel();
                    LocalizationLocalModel data = this.this$0.getLocalizationStorage().getData();
                    if (data != null && (phoneLogin = data.getPhoneLogin()) != null && (body = phoneLogin.getBody()) != null) {
                        incorrectPhoneError = body.getIncorrectPhoneError();
                    }
                    viewModel2.notifyErrorMessage(incorrectPhoneError);
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                LoginState.Session sessionByPhone = this.this$0.getViewModel().getSessionByPhone();
                if (jCurrentTimeMillis - ((sessionByPhone == null || (codeExpiresAt = sessionByPhone.getCodeExpiresAt()) == null) ? jCurrentTimeMillis : codeExpiresAt.longValue()) < 0) {
                    this.this$0.getViewModel().handleRawPhone(binding.etEnterPhone.getText().toString());
                    this.this$0.getViewModel().handlePrettyPhone(str2);
                    this.this$0.getViewModel().handleCountryCode(binding.tvEditCountryCode.getText().toString());
                    this.this$0.getViewModel().checkoutSessionByPhone();
                    this.this$0.navigateWithWay(sessionByPhone != null ? sessionByPhone.getWay() : null);
                } else {
                    AppCompatButton btnAccept3 = binding.btnAccept;
                    Intrinsics.checkNotNullExpressionValue(btnAccept3, "btnAccept");
                    ButtonsExtensionsKt.showProgress$default(btnAccept3, 0, 1, null);
                    this.this$0.getViewModel().handleData(str, str2);
                }
                binding.btnAccept.setEnabled(false);
            }
        }, 1, null);
        binding.tvEditCountryCode.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                EnterPhoneFragment.setUpButtons$lambda$5$lambda$4(this.f$0, view);
            }
        });
        ConstraintLayout rootView = binding.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpButtons$lambda$5$lambda$4(EnterPhoneFragment this$0, View view) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(this$0), R$id.enterPhoneFragment, R$id.action_enterPhoneFragment_to_countryPickerFragment, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateWithWay(RegistrationWay way) {
        Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("phone", getViewModel().getCurrentState().getPhone()), TuplesKt.to("pretty_phone", getViewModel().getCurrentState().getPrettyPhone()));
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void login() throws NumberFormatException {
        String str;
        Long codeExpiresAt;
        PhoneLoginLocale phoneLogin;
        PhoneLoginBody body;
        FragmentRegNumberBinding binding = getBinding();
        getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationStepOneNextEvent());
        String str2 = ((Object) binding.tvEditCountryCode.getText()) + " " + ((Object) binding.etEnterPhone.getText());
        Editable text = binding.etEnterPhone.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        incorrectPhoneError = null;
        incorrectPhoneError = null;
        String incorrectPhoneError = null;
        if (text.length() == 0) {
            str = null;
        } else {
            str = Integer.parseInt(binding.tvEditCountryCode.getText().toString()) + getViewModel().getCurrentState().getRawPhone();
        }
        if (str == null) {
            LoginViewModel viewModel = getViewModel();
            LocalizationLocalModel data = getLocalizationStorage().getData();
            if (data != null && (phoneLogin = data.getPhoneLogin()) != null && (body = phoneLogin.getBody()) != null) {
                incorrectPhoneError = body.getIncorrectPhoneError();
            }
            viewModel.notifyErrorMessage(incorrectPhoneError);
            return;
        }
        LoginState.Session sessionByPhone = getViewModel().getSessionByPhone();
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = jCurrentTimeMillis - ((sessionByPhone == null || (codeExpiresAt = sessionByPhone.getCodeExpiresAt()) == null) ? jCurrentTimeMillis : codeExpiresAt.longValue()) < 0;
        BundleKt.bundleOf(TuplesKt.to("phone", str));
        if (z) {
            getViewModel().handleRawPhone(binding.etEnterPhone.getText().toString());
            getViewModel().handlePrettyPhone(str2);
            getViewModel().handleCountryCode(binding.tvEditCountryCode.getText().toString());
            navigateWithWay(sessionByPhone != null ? sessionByPhone.getWay() : null);
        } else {
            getViewModel().handleData(str, str2);
        }
        binding.btnAccept.setEnabled(false);
    }

    private final void setEditText() {
        MaskedTextChangedListener.Companion companion = MaskedTextChangedListener.INSTANCE;
        EditText editText = getBinding().etEnterPhone;
        MaskedTextChangedListener.ValueListener valueListener = new MaskedTextChangedListener.ValueListener() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$setEditText$phoneNumberListener$1
            @Override // com.redmadrobot.inputmask.MaskedTextChangedListener.ValueListener
            public void onTextChanged(boolean maskFilled, String extractedValue, String formattedValue) {
                Intrinsics.checkNotNullParameter(extractedValue, "extractedValue");
                Intrinsics.checkNotNullParameter(formattedValue, "formattedValue");
                this.this$0.getViewModel().handleRawPhone(extractedValue);
                this.this$0.getViewModel().handlePhone(this.this$0.getViewModel().getCurrentState().getRawPhone(), this.this$0.getBinding().tvEditCountryCode.getText().toString());
            }
        };
        Intrinsics.checkNotNull(editText);
        MaskedTextChangedListener maskedTextChangedListenerInstallOn = companion.installOn(editText, "([000]) [000]-[00]-[00999999]", (220 & 4) != 0 ? CollectionsKt.emptyList() : null, (220 & 8) != 0 ? CollectionsKt.emptyList() : null, (220 & 16) != 0 ? AffinityCalculationStrategy.WHOLE_STRING : null, (220 & 32) != 0, (220 & 64) != 0 ? false : false, (220 & 128) != 0 ? null : null, (220 & 256) != 0 ? null : valueListener);
        getBinding().etEnterPhone.removeTextChangedListener(maskedTextChangedListenerInstallOn);
        getBinding().etEnterPhone.addTextChangedListener(maskedTextChangedListenerInstallOn);
    }

    private final void localize() {
        PhoneLoginLocale phoneLogin;
        PhoneLoginBody body;
        FragmentRegNumberBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data == null || (phoneLogin = data.getPhoneLogin()) == null || (body = phoneLogin.getBody()) == null) {
            return;
        }
        binding.title.setText(body.getTitle());
        if (Intrinsics.areEqual(isAuth(), Boolean.TRUE)) {
            binding.tvEnterPhone.setText(body.getLoginSubtitle());
            TextView title = binding.title;
            Intrinsics.checkNotNullExpressionValue(title, "title");
            ViewKt.invisible(title);
        } else {
            binding.tvEnterPhone.setText(body.getSubtitle());
            TextView title2 = binding.title;
            Intrinsics.checkNotNullExpressionValue(title2, "title");
            ViewKt.visible(title2);
        }
        binding.tvTitlePhone.setText(body.getPhoneNumberTitle());
        binding.etEnterPhone.setHint(body.getPhoneTextField().getPlaceholder());
        binding.btnAccept.setText(body.getContinueButton().getTitle());
        TextView textView = binding.tvLicences;
        PhoneLoginPrivacy documents = body.getDocuments();
        SpannableString spannableString = new SpannableString(Util.format(documents.getTitle(), documents.getParam1(), documents.getParam2(), documents.getParam3()));
        SpansKt.addLink(spannableString, documents.getParam1(), "https://storage.yandexcloud.net/sputnik-systems-citizen-app/mobile_privacy.html", new Function0<Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$localize$1$1$1$1$1
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
                Log.e("TRACKER", "policy");
                this.this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationLinkRulesEvent());
            }
        });
        SpansKt.addLink(spannableString, documents.getParam2(), "https://sso.sputnik.systems/mobile_licence.pdf", new Function0<Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$localize$1$1$1$1$2
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
                Log.e("TRACKER", "license");
                this.this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationLinkLicenceEvent());
            }
        });
        SpansKt.addLink(spannableString, documents.getParam3(), "https://api-mobile-gorod.sputnik.systems/static/private_data_agreement", new Function0<Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterPhoneFragment$localize$1$1$1$1$3
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
                Log.e("TRACKER", "license");
                this.this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationLinkLicenceEvent());
            }
        });
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
