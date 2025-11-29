package ru.yoomoney.sdk.auth.password.create;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.ErrorPasswordRequirementsViolated;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.api.model.RegistrationProcessError;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthPasswordCreateBinding;
import ru.yoomoney.sdk.auth.password.create.PasswordCreate;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.AlertDialog;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.ui.PasswordInputView;
import ru.yoomoney.sdk.auth.ui.ProgressBar;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.utils.StringExtensionsKt;
import ru.yoomoney.sdk.auth.utils.TextViewExtentionsKt;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.utils.text.SimpleTextWatcher;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption2View;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\u001f\"\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020G2\u0006\u0010I\u001a\u00020LH\u0002J$\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\b\u0010U\u001a\u00020GH\u0016J\u001a\u0010V\u001a\u00020G2\u0006\u0010W\u001a\u00020N2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\b\u0010X\u001a\u00020GH\u0002J\b\u0010Y\u001a\u00020GH\u0002J\u0010\u0010Z\u001a\u00020G2\u0006\u0010[\u001a\u00020AH\u0002J\u0010\u0010\\\u001a\u00020G2\u0006\u0010]\u001a\u00020^H\u0002J\b\u0010_\u001a\u00020GH\u0002J\u0010\u0010`\u001a\u00020G2\u0006\u0010a\u001a\u00020bH\u0002J\b\u0010c\u001a\u00020GH\u0002J\u0010\u0010d\u001a\u00020G2\u0006\u0010a\u001a\u00020?H\u0002J\u0018\u0010e\u001a\u00020G2\u0006\u0010f\u001a\u00020\u001b2\u0006\u0010g\u001a\u00020\u001bH\u0002J\u0014\u0010h\u001a\u00020G*\u00020i2\u0006\u0010j\u001a\u00020%H\u0002R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001a\u0010\u001cR\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b&\u0010'R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0019\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0019\u001a\u0004\b2\u00103R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0014\u00109\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R1\u0010=\u001a\u0018\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A0>j\u0002`B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0019\u001a\u0004\bC\u0010DR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/PasswordCreateFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "remoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "config", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Lru/yoomoney/sdk/auth/RemoteConfig;Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthPasswordCreateBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthPasswordCreateBinding;", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "expireAt$delegate", "Lkotlin/Lazy;", "isEmailSet", "", "()Z", "isEmailSet$delegate", "passwordFirstWatcher", "ru/yoomoney/sdk/auth/password/create/PasswordCreateFragment$passwordFirstWatcher$1", "Lru/yoomoney/sdk/auth/password/create/PasswordCreateFragment$passwordFirstWatcher$1;", "passwordSecondWatcher", "ru/yoomoney/sdk/auth/password/create/PasswordCreateFragment$passwordSecondWatcher$1", "Lru/yoomoney/sdk/auth/password/create/PasswordCreateFragment$passwordSecondWatcher$1;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "getProcessId", "()Ljava/lang/String;", "processId$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "productType", "Lru/yoomoney/sdk/auth/Config$ProductType;", "getProductType", "()Lru/yoomoney/sdk/auth/Config$ProductType;", "productType$delegate", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreateViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "addPasswordEditWatchers", "", "navigateToNextRegistrationStep", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "navigateToNextStep", "Lru/yoomoney/sdk/auth/api/Process;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "removePasswordEditWatchers", "setupViews", "showEffect", "effect", "showError", "error", "Lru/yoomoney/sdk/auth/api/model/ProcessError;", "showExpireDialog", "showFillingPasswordState", "state", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State$Content;", "showProgressState", "showState", "showValidations", "isValidFirstPassword", "isValidSecondPassword", "showGeneratedPassword", "Landroid/widget/EditText;", "password", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordCreateFragment extends BaseFragment {
    private AuthPasswordCreateBinding _binding;
    private final Config config;

    /* renamed from: expireAt$delegate, reason: from kotlin metadata */
    private final Lazy expireAt;

    /* renamed from: isEmailSet$delegate, reason: from kotlin metadata */
    private final Lazy isEmailSet;
    private final PasswordCreateFragment$passwordFirstWatcher$1 passwordFirstWatcher;
    private final PasswordCreateFragment$passwordSecondWatcher$1 passwordSecondWatcher;

    /* renamed from: processId$delegate, reason: from kotlin metadata */
    private final Lazy processId;
    private final ProcessMapper processMapper;

    /* renamed from: processType$delegate, reason: from kotlin metadata */
    private final Lazy processType;

    /* renamed from: productType$delegate, reason: from kotlin metadata */
    private final Lazy productType;
    private final RemoteConfig remoteConfig;
    private final ResourceMapper resourceMapper;
    private final Router router;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public static final class a extends Lambda implements Function0<OffsetDateTime> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final OffsetDateTime invoke() {
            return PasswordCreateFragmentArgs.fromBundle(PasswordCreateFragment.this.requireArguments()).getExpireAt();
        }
    }

    public static final class b extends Lambda implements Function0<Boolean> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Bundle arguments = PasswordCreateFragment.this.getArguments();
            if (arguments != null) {
                return Boolean.valueOf(PasswordCreateFragmentArgs.fromBundle(arguments).getIsEmailSet());
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<PasswordCreate.State, Unit> {
        public c(Object obj) {
            super(1, obj, PasswordCreateFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PasswordCreate.State state) {
            PasswordCreate.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PasswordCreateFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<PasswordCreate.Effect, Unit> {
        public d(Object obj) {
            super(1, obj, PasswordCreateFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PasswordCreate.Effect effect) throws Resources.NotFoundException {
            PasswordCreate.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PasswordCreateFragment) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Throwable, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            ConstraintLayout parent = PasswordCreateFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = PasswordCreateFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function0<String> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = PasswordCreateFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            String processId = PasswordCreateFragmentArgs.fromBundle(arguments).getProcessId();
            Intrinsics.checkNotNullExpressionValue(processId, "getProcessId(...)");
            return processId;
        }
    }

    public static final class g extends Lambda implements Function0<ProcessType> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ProcessType invoke() {
            Bundle arguments = PasswordCreateFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            ProcessType processType = PasswordCreateFragmentArgs.fromBundle(arguments).getProcessType();
            Intrinsics.checkNotNullExpressionValue(processType, "getProcessType(...)");
            return processType;
        }
    }

    public static final class h extends Lambda implements Function0<Config.ProductType> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Config.ProductType invoke() {
            return PasswordCreateFragment.this.config.getProductType();
        }
    }

    public static final class i extends Lambda implements Function1<Boolean, Unit> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Boolean bool) {
            bool.booleanValue();
            PasswordCreateFragment.this.getViewModel().handleAction(new PasswordCreate.Action.DisplayPassword(PasswordCreateFragment.this.getProcessType()));
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Boolean, Unit> {
        public j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Boolean bool) {
            bool.booleanValue();
            PasswordCreateFragment.this.getViewModel().handleAction(new PasswordCreate.Action.DisplayPassword(PasswordCreateFragment.this.getProcessType()));
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function0<ViewModelProvider.Factory> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return PasswordCreateFragment.this.viewModelFactory;
        }
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [ru.yoomoney.sdk.auth.password.create.PasswordCreateFragment$passwordFirstWatcher$1] */
    /* JADX WARN: Type inference failed for: r2v14, types: [ru.yoomoney.sdk.auth.password.create.PasswordCreateFragment$passwordSecondWatcher$1] */
    public PasswordCreateFragment(RemoteConfig remoteConfig, ViewModelProvider.Factory viewModelFactory, Config config, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.remoteConfig = remoteConfig;
        this.viewModelFactory = viewModelFactory;
        this.config = config;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        k kVar = new k();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.password.create.PasswordCreateFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.password.create.PasswordCreateFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function02 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.password.create.PasswordCreateFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.password.create.PasswordCreateFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function03 = function02;
                if (function03 != null && (creationExtras = (CreationExtras) function03.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM2230viewModels$lambda1 = FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM2230viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM2230viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, kVar);
        this.processId = LazyKt.lazy(new f());
        this.processType = LazyKt.lazy(new g());
        this.expireAt = LazyKt.lazy(new a());
        this.isEmailSet = LazyKt.lazy(new b());
        this.productType = LazyKt.lazy(new h());
        this.passwordFirstWatcher = new SimpleTextWatcher() { // from class: ru.yoomoney.sdk.auth.password.create.PasswordCreateFragment$passwordFirstWatcher$1
            @Override // ru.yoomoney.sdk.gui.utils.text.SimpleTextWatcher, android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.this$0.getViewModel().handleAction(new PasswordCreate.Action.FirstPasswordChanged(String.valueOf(s)));
            }
        };
        this.passwordSecondWatcher = new SimpleTextWatcher() { // from class: ru.yoomoney.sdk.auth.password.create.PasswordCreateFragment$passwordSecondWatcher$1
            @Override // ru.yoomoney.sdk.gui.utils.text.SimpleTextWatcher, android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.this$0.getViewModel().handleAction(new PasswordCreate.Action.SecondPasswordChanged(String.valueOf(s)));
            }
        };
    }

    private final void addPasswordEditWatchers() {
        AuthPasswordCreateBinding binding = getBinding();
        binding.passwordFirst.getEditText().addTextChangedListener(this.passwordFirstWatcher);
        binding.passwordSecond.getEditText().addTextChangedListener(this.passwordSecondWatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthPasswordCreateBinding getBinding() {
        AuthPasswordCreateBinding authPasswordCreateBinding = this._binding;
        Intrinsics.checkNotNull(authPasswordCreateBinding);
        return authPasswordCreateBinding;
    }

    private final OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.expireAt.getValue();
    }

    private final String getProcessId() {
        return (String) this.processId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProcessType getProcessType() {
        return (ProcessType) this.processType.getValue();
    }

    private final Config.ProductType getProductType() {
        return (Config.ProductType) this.productType.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<PasswordCreate.State, PasswordCreate.Action, PasswordCreate.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final boolean isEmailSet() {
        return ((Boolean) this.isEmailSet.getValue()).booleanValue();
    }

    private final void navigateToNextRegistrationStep(RegistrationProcess process) throws Resources.NotFoundException {
        BaseFragment.navigate$auth_release$default(this, process, (Function1) null, 2, (Object) null);
    }

    private final void navigateToNextStep(Process process) throws Resources.NotFoundException {
        BaseFragment.navigate$auth_release$default(this, process, (Function1) null, 2, (Object) null);
    }

    private final void removePasswordEditWatchers() {
        AuthPasswordCreateBinding binding = getBinding();
        binding.passwordFirst.getEditText().removeTextChangedListener(this.passwordFirstWatcher);
        binding.passwordSecond.getEditText().removeTextChangedListener(this.passwordSecondWatcher);
    }

    private final void setupViews() {
        PasswordInputView passwordInputView = getBinding().passwordFirst;
        passwordInputView.getEditText().addTextChangedListener(this.passwordFirstWatcher);
        passwordInputView.setDisplayPasswordListener(new i());
        PasswordInputView passwordInputView2 = getBinding().passwordSecond;
        passwordInputView2.getEditText().addTextChangedListener(this.passwordSecondWatcher);
        passwordInputView2.setDisplayPasswordListener(new j());
        getBinding().action.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.password.create.PasswordCreateFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PasswordCreateFragment.setupViews$lambda$2(this.f$0, view);
            }
        });
        TextCaption2View textCaption2View = getBinding().agreement;
        Intrinsics.checkNotNull(textCaption2View);
        textCaption2View.setVisibility((getProcessType() == ProcessType.CHANGE_PASSWORD || getProcessType() == ProcessType.PASSWORD_RECOVERY) ? 8 : 0);
        textCaption2View.setText(StringExtensionsKt.parseHtml(isEmailSet() ? this.remoteConfig.getUserWithEmailAgreementTitle() : this.remoteConfig.getUserAgreementTitle()));
        textCaption2View.setMovementMethod(LinkMovementMethod.getInstance());
        ColorScheme colorScheme = ColorScheme.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        textCaption2View.setLinkTextColor(colorScheme.getAccentColor(contextRequireContext));
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        textCaption2View.setHighlightColor(colorScheme.getAccentGhostColor(contextRequireContext2));
        TextViewExtentionsKt.removeLinkUnderline(textCaption2View);
        if (getProductType() == Config.ProductType.WEBBANKIR) {
            TextBodyView textBodyView = getBinding().generatePassword;
            Intrinsics.checkNotNull(textBodyView);
            ViewExtensions.setVisible(textBodyView, true);
            textBodyView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.password.create.PasswordCreateFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PasswordCreateFragment.setupViews$lambda$5$lambda$4(this.f$0, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$2(PasswordCreateFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new PasswordCreate.Action.ValidateBeforeSubmit(this$0.getProcessType(), this$0.getProcessId(), this$0.getExpireAt()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$5$lambda$4(PasswordCreateFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(PasswordCreate.Action.GeneratePassword.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(PasswordCreate.Effect effect) throws Resources.NotFoundException {
        if (effect instanceof PasswordCreate.Effect.ShowValidations) {
            PasswordCreate.Effect.ShowValidations showValidations = (PasswordCreate.Effect.ShowValidations) effect;
            showValidations(showValidations.isValidFirstPassword(), showValidations.isValidSecondPassword());
            return;
        }
        if (effect instanceof PasswordCreate.Effect.ShowNextStep) {
            navigateToNextStep(((PasswordCreate.Effect.ShowNextStep) effect).getProcess());
            return;
        }
        if (effect instanceof PasswordCreate.Effect.ShowRegistrationNextStep) {
            navigateToNextRegistrationStep(((PasswordCreate.Effect.ShowRegistrationNextStep) effect).getProcess());
            return;
        }
        if (effect instanceof PasswordCreate.Effect.ShowFailure) {
            ConstraintLayout parent = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            CoreFragmentExtensions.noticeError(parent, getResourceMapper().map(((PasswordCreate.Effect.ShowFailure) effect).getFailure()));
            return;
        }
        if (effect instanceof PasswordCreate.Effect.ShowError) {
            showError(((PasswordCreate.Effect.ShowError) effect).getError());
            return;
        }
        if (effect instanceof PasswordCreate.Effect.ShowExpireDialog) {
            showExpireDialog();
            return;
        }
        if (effect instanceof PasswordCreate.Effect.ResetProcess) {
            FragmentKt.findNavController(this).navigate(getRouter().reset());
            return;
        }
        if (effect instanceof PasswordCreate.Effect.ShowGeneratedPassword) {
            removePasswordEditWatchers();
            AuthPasswordCreateBinding binding = getBinding();
            PasswordCreate.Effect.ShowGeneratedPassword showGeneratedPassword = (PasswordCreate.Effect.ShowGeneratedPassword) effect;
            showGeneratedPassword(binding.passwordFirst.getEditText(), showGeneratedPassword.getPassword());
            showGeneratedPassword(binding.passwordSecond.getEditText(), showGeneratedPassword.getPassword());
            addPasswordEditWatchers();
        }
    }

    private final void showError(ProcessError error) {
        if (error instanceof RegistrationProcessError.ProcessExpired) {
            showExpireDialog();
            return;
        }
        if (error instanceof ErrorPasswordRequirementsViolated) {
            ConstraintLayout parent = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            CoreFragmentExtensions.noticeError(parent, ((ErrorPasswordRequirementsViolated) error).getTitle());
        } else {
            ConstraintLayout parent2 = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent2, "parent");
            String string = getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent2, string);
        }
    }

    private final void showExpireDialog() {
        YmAlertDialog.DialogContent dialogContent = new YmAlertDialog.DialogContent(getString(R.string.auth_reset_process_dialog_title), getResourceMapper().resetProcessDialog(getProcessType()), getString(R.string.auth_reset_process_dialog_action), null, false, false, 56, null);
        AlertDialog.Companion companion = AlertDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        AlertDialog alertDialogCreate = companion.create(childFragmentManager, dialogContent);
        alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.password.create.PasswordCreateFragment$showExpireDialog$1$1
            @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
            public void onDismiss() {
                YmAlertDialog.DialogListener.DefaultImpls.onDismiss(this);
            }

            @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
            public void onNegativeClick() {
                YmAlertDialog.DialogListener.DefaultImpls.onNegativeClick(this);
            }

            @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
            public void onPositiveClick() {
                this.this$0.getViewModel().handleAction(PasswordCreate.Action.RestartProcess.INSTANCE);
            }
        });
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        alertDialogCreate.show(childFragmentManager2);
    }

    private final void showFillingPasswordState(PasswordCreate.State.Content state) {
        getBinding().passwordFirst.setEnabled(true);
        getBinding().passwordSecond.setEnabled(true);
        getBinding().passwordFirst.setError(null);
        getBinding().passwordSecond.setError(null);
        getBinding().validateLetters.setEnabled(state.isValidLetters());
        getBinding().validateLength.setEnabled(state.isValidLength());
        getBinding().validateNumbersContains.setEnabled(state.isValidNumbersContains());
        getBinding().action.setEnabled(true);
        ProgressBar progressBar = getBinding().progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        ViewExtensions.hide(progressBar);
    }

    private final void showGeneratedPassword(EditText editText, String str) {
        editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        editText.setText(str);
    }

    private final void showProgressState() {
        ProgressBar progressBar = getBinding().progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        ViewExtensions.show(progressBar);
        getBinding().action.setEnabled(false);
        getBinding().passwordFirst.setEnabled(false);
        getBinding().passwordSecond.setEnabled(false);
        getBinding().validateLetters.setEnabled(true);
        getBinding().validateLength.setEnabled(true);
        getBinding().validateNumbersContains.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(PasswordCreate.State state) {
        if (state instanceof PasswordCreate.State.Content) {
            showFillingPasswordState((PasswordCreate.State.Content) state);
        } else if (state instanceof PasswordCreate.State.Progress) {
            showProgressState();
        }
    }

    private final void showValidations(boolean isValidFirstPassword, boolean isValidSecondPassword) {
        String string;
        PasswordInputView passwordInputView = getBinding().passwordFirst;
        String string2 = null;
        if (isValidFirstPassword) {
            string = null;
        } else {
            passwordInputView.requestFocus();
            getBinding().scroll.scrollTo(0, passwordInputView.getTop());
            string = getString(R.string.auth_password_create_first_password_error);
        }
        passwordInputView.setError(string);
        PasswordInputView passwordInputView2 = getBinding().passwordSecond;
        if (!isValidSecondPassword) {
            CharSequence error = getBinding().passwordFirst.getError();
            if (error == null || error.length() == 0) {
                passwordInputView2.requestFocus();
                getBinding().scroll.scrollTo(0, passwordInputView2.getBottom());
            }
            CharSequence text = getBinding().passwordSecond.getText();
            string2 = getString((text == null || text.length() == 0) ? R.string.auth_password_create_second_password_empty_error : R.string.auth_password_create_second_password_equality_error);
        }
        passwordInputView2.setError(string2);
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public ProcessMapper getProcessMapper() {
        return this.processMapper;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public ResourceMapper getResourceMapper() {
        return this.resourceMapper;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public Router getRouter() {
        return this.router;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public TopBarDefault getTopBar() {
        ru.yoomoney.sdk.auth.ui.TopBarDefault appBar = getBinding().appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        return appBar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthPasswordCreateBinding.inflate(inflater, container, false);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().appBar.setTitle(getString(getProcessType() == ProcessType.CHANGE_PASSWORD ? R.string.auth_password_change_screen_title : R.string.auth_password_create_screen_title));
        setupViews();
        RuntimeViewModel<PasswordCreate.State, PasswordCreate.Action, PasswordCreate.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new c(this), new d(this), new e());
        getViewModel().handleAction(new PasswordCreate.Action.SendAnalyticsForScreen(getProcessType()));
    }
}
