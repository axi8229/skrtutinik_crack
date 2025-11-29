package com.sputnik.oboarding.ui.registration;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import com.sputnik.common.analytics.AnalyticsTracker;
import com.sputnik.common.base.Notify;
import com.sputnik.common.delegates.ViewBindingFragmentDelegate;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.common.TextErrorPlaceHolder;
import com.sputnik.common.entities.localization.entities.login.RegisterBody;
import com.sputnik.common.entities.localization.entities.login.RegisterLocale;
import com.sputnik.common.extensions.NavControllerKt;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.InvitesViewModel;
import com.sputnik.common.viewmodels.MainProfileData;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.SettingsProfileViewModel;
import com.sputnik.common.viewmodels.SettingsProfileViewState;
import com.sputnik.domain.common.Event;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;
import com.sputnik.oboarding.analytics.yandex.OnBoardingEvents;
import com.sputnik.oboarding.databinding.FragmentRegRegistrationBinding;
import com.sputnik.oboarding.di.OnBoardingComponentKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: EnterNameFragment.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\"\u00108\u001a\u0002078\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00103\u001a\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/sputnik/oboarding/ui/registration/EnterNameFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "localize", "Lcom/sputnik/common/viewmodels/MainProfileData;", RemoteMessageConst.DATA, "renderUi", "(Lcom/sputnik/common/viewmodels/MainProfileData;)V", "initView", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onResume", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/sputnik/oboarding/databinding/FragmentRegRegistrationBinding;", "binding$delegate", "Lcom/sputnik/common/delegates/ViewBindingFragmentDelegate;", "getBinding", "()Lcom/sputnik/oboarding/databinding/FragmentRegRegistrationBinding;", "binding", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;", "settingsProfileViewModelFactory", "Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;", "getSettingsProfileViewModelFactory", "()Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;", "setSettingsProfileViewModelFactory", "(Lcom/sputnik/common/viewmodels/SettingsProfileViewModel$Factory$AssistFactory;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/viewmodels/SettingsProfileViewModel;", "settingsProfileViewModel$delegate", "Lkotlin/Lazy;", "getSettingsProfileViewModel", "()Lcom/sputnik/common/viewmodels/SettingsProfileViewModel;", "settingsProfileViewModel", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel$delegate", "getInvitesViewModel", "()Lcom/sputnik/common/viewmodels/InvitesViewModel;", "invitesViewModel", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EnterNameFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(EnterNameFragment.class, "binding", "getBinding()Lcom/sputnik/oboarding/databinding/FragmentRegRegistrationBinding;", 0))};
    public Analytics analytics;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingFragmentDelegate binding;
    public MultiViewModelFactory factory;

    /* renamed from: invitesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy invitesViewModel;
    public LocalizationStorage localizationScreen;

    /* renamed from: settingsProfileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingsProfileViewModel;
    public SettingsProfileViewModel.Factory.AssistFactory settingsProfileViewModelFactory;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentRegRegistrationBinding getBinding() {
        return (FragmentRegRegistrationBinding) this.binding.getValue2((Fragment) this, $$delegatedProperties[0]);
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    public final SettingsProfileViewModel.Factory.AssistFactory getSettingsProfileViewModelFactory() {
        SettingsProfileViewModel.Factory.AssistFactory assistFactory = this.settingsProfileViewModelFactory;
        if (assistFactory != null) {
            return assistFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("settingsProfileViewModelFactory");
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
    public final SettingsProfileViewModel getSettingsProfileViewModel() {
        return (SettingsProfileViewModel) this.settingsProfileViewModel.getValue();
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final InvitesViewModel getInvitesViewModel() {
        return (InvitesViewModel) this.invitesViewModel.getValue();
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
        requireActivity().getWindow().setSoftInputMode(16);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getAnalytics().trackLogEvent(new AnalyticsTracker.Event("userData", "show", null, 4, null));
        localize();
        SettingsProfileViewModel settingsProfileViewModel = getSettingsProfileViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        settingsProfileViewModel.observeSubState(viewLifecycleOwner, new AnonymousClass1(MainProfileData.INSTANCE), new AnonymousClass2(this));
        SettingsProfileViewModel settingsProfileViewModel2 = getSettingsProfileViewModel();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        settingsProfileViewModel2.observeSubState(viewLifecycleOwner2, new Function1<SettingsProfileViewState, Event<? extends Boolean>>() { // from class: com.sputnik.oboarding.ui.registration.EnterNameFragment.onViewCreated.3
            @Override // kotlin.jvm.functions.Function1
            public final Event<Boolean> invoke(SettingsProfileViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.isSavedData();
            }
        }, new Function1<Event<? extends Boolean>, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterNameFragment.onViewCreated.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Event<? extends Boolean> event) throws Resources.NotFoundException {
                invoke2((Event<Boolean>) event);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Event<Boolean> it) throws Resources.NotFoundException {
                Intrinsics.checkNotNullParameter(it, "it");
                Boolean contentIfNotHandled = it.getContentIfNotHandled();
                if (contentIfNotHandled != null) {
                    EnterNameFragment enterNameFragment = EnterNameFragment.this;
                    if (contentIfNotHandled.booleanValue()) {
                        NavControllerKt.safeNavigate$default(FragmentKt.findNavController(enterNameFragment), R$id.enterNameFragment, R$id.action_enterNameFragment_to_startRegistrationFragment, null, null, 12, null);
                    }
                }
            }
        });
        SettingsProfileViewModel settingsProfileViewModel3 = getSettingsProfileViewModel();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        settingsProfileViewModel3.observeNotifications(viewLifecycleOwner3, new Function1<Notify, Unit>() { // from class: com.sputnik.oboarding.ui.registration.EnterNameFragment.onViewCreated.5
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
                EnterNameFragment enterNameFragment = EnterNameFragment.this;
                NestedScrollView root = enterNameFragment.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(enterNameFragment, root, it);
            }
        });
        initView();
    }

    /* compiled from: EnterNameFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterNameFragment$onViewCreated$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<SettingsProfileViewState, MainProfileData> {
        AnonymousClass1(Object obj) {
            super(1, obj, MainProfileData.Companion.class, "toMainProfileData", "toMainProfileData(Lcom/sputnik/common/viewmodels/SettingsProfileViewState;)Lcom/sputnik/common/viewmodels/MainProfileData;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final MainProfileData invoke(SettingsProfileViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((MainProfileData.Companion) this.receiver).toMainProfileData(p0);
        }
    }

    /* compiled from: EnterNameFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.sputnik.oboarding.ui.registration.EnterNameFragment$onViewCreated$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<MainProfileData, Unit> {
        AnonymousClass2(Object obj) {
            super(1, obj, EnterNameFragment.class, "renderUi", "renderUi(Lcom/sputnik/common/viewmodels/MainProfileData;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MainProfileData mainProfileData) {
            invoke2(mainProfileData);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MainProfileData p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EnterNameFragment) this.receiver).renderUi(p0);
        }
    }

    private final void localize() {
        RegisterLocale register;
        RegisterBody body;
        FragmentRegRegistrationBinding binding = getBinding();
        LocalizationLocalModel data = getLocalizationScreen().getData();
        if (data == null || (register = data.getRegister()) == null || (body = register.getBody()) == null) {
            return;
        }
        binding.tvTitle.setText(body.getTitle());
        binding.tvNotice.setText(body.getSubtitle());
        binding.tvTitleName.setText(body.getFirstNameTextField().getTitle());
        binding.etName.setHint(body.getFirstNameTextField().getPlaceholder());
        binding.btnAccept.setText(body.getContinueButton().getTitle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(MainProfileData data) {
        FragmentRegRegistrationBinding binding = getBinding();
        if (Intrinsics.areEqual(binding.etName.getText().toString(), data.getName())) {
            return;
        }
        binding.etName.setText(data.getName());
    }

    private final void initView() {
        final FragmentRegRegistrationBinding binding = getBinding();
        binding.btnAccept.setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.oboarding.ui.registration.EnterNameFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EnterNameFragment.initView$lambda$5$lambda$3(this.f$0, binding, view);
            }
        });
        EditText etName = binding.etName;
        Intrinsics.checkNotNullExpressionValue(etName, "etName");
        etName.addTextChangedListener(new TextWatcher() { // from class: com.sputnik.oboarding.ui.registration.EnterNameFragment$initView$lambda$5$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.this$0.getSettingsProfileViewModel().handleName(String.valueOf(s));
            }
        });
        ConstraintLayout rootView = binding.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ViewKt.addSystemWindowInsetToPadding(rootView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5$lambda$3(EnterNameFragment this$0, FragmentRegRegistrationBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this$0.getInvitesViewModel().loadInvites();
        this$0.getAnalytics().trackLogEvent(new OnBoardingEvents.RegistrationStepTwoNextEvent());
        String string = this_with.etName.getText().toString();
        Intrinsics.checkNotNull(view);
        ViewKt.hideKeyboard(view);
        this$0.getSettingsProfileViewModel().saveProfileData(string);
    }

    public EnterNameFragment() {
        super(R$layout.fragment_reg_registration);
        this.binding = new ViewBindingFragmentDelegate(this, EnterNameFragment$binding$2.INSTANCE);
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterNameFragment$settingsProfileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                RegisterLocale register;
                RegisterBody body;
                TextErrorPlaceHolder firstNameTextField;
                SettingsProfileViewModel.Factory.AssistFactory settingsProfileViewModelFactory = this.this$0.getSettingsProfileViewModelFactory();
                LocalizationLocalModel data = this.this$0.getLocalizationScreen().getData();
                return SettingsProfileViewModel.Factory.AssistFactory.DefaultImpls.create$default(settingsProfileViewModelFactory, null, null, (data == null || (register = data.getRegister()) == null || (body = register.getBody()) == null || (firstNameTextField = body.getFirstNameTextField()) == null) ? null : firstNameTextField.getError(), 3, null);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.sputnik.oboarding.ui.registration.EnterNameFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: com.sputnik.oboarding.ui.registration.EnterNameFragment$special$$inlined$viewModels$default$2
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
        this.settingsProfileViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingsProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterNameFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterNameFragment$special$$inlined$viewModels$default$4
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
        this.invitesViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(InvitesViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.oboarding.ui.registration.EnterNameFragment$special$$inlined$activityViewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.sputnik.oboarding.ui.registration.EnterNameFragment$special$$inlined$activityViewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.oboarding.ui.registration.EnterNameFragment$invitesViewModel$2
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
}
