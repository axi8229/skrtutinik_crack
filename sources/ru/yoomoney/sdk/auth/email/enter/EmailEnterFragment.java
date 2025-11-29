package ru.yoomoney.sdk.auth.email.enter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
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
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$StartActivityForResult;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.ComposeStyle;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ConfigKt;
import ru.yoomoney.sdk.auth.PrefilledData;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.Style;
import ru.yoomoney.sdk.auth.ThemeScheme;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.FeatureFailure;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.model.RegistrationProcessError;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthEmailEnterBinding;
import ru.yoomoney.sdk.auth.email.enter.EmailEnter;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.AlertDialog;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.ui.ItemSecondarySwitchView;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.TextInputView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.utils.StringExtensionsKt;
import ru.yoomoney.sdk.auth.utils.TextViewExtentionsKt;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.guiCompose.theme.Palette;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.two_fa.FontResource;
import ru.yoomoney.sdk.two_fa.YooMoneyTwoFa;
import ru.yoomoney.sdk.two_fa.analytics.AnalyticsEvent;
import ru.yoomoney.sdk.two_fa.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.two_fa.parcelable.PaletteParcelable;
import ru.yoomoney.sdk.two_fa.utils.ContextExtensionsKt;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020'H\u0002J\u0010\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010Q\u001a\u00020L2\u0006\u0010O\u001a\u00020RH\u0002J$\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010[\u001a\u00020LH\u0016J\u001a\u0010\\\u001a\u00020L2\u0006\u0010]\u001a\u00020T2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010^\u001a\u00020LH\u0002J\u0010\u0010_\u001a\u00020L2\u0006\u0010`\u001a\u00020FH\u0002J\b\u0010a\u001a\u00020LH\u0002J\u0010\u0010b\u001a\u00020L2\u0006\u0010c\u001a\u00020DH\u0002R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b\"\u0010$R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010!\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010!\u001a\u0004\b,\u0010)R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010!\u001a\u0004\b2\u00103R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010!\u001a\u0004\b7\u00108R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR1\u0010B\u001a\u0018\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F0Cj\u0002`G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010!\u001a\u0004\bH\u0010IR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/EmailEnterFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "remoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "config", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/ResultData;Lru/yoomoney/sdk/auth/RemoteConfig;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthEmailEnterBinding;", "analyticsLogger", "Lru/yoomoney/sdk/two_fa/analytics/AnalyticsLogger;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthEmailEnterBinding;", "confirmLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "expireAt$delegate", "Lkotlin/Lazy;", "isAddedToBackStack", "", "()Z", "isAddedToBackStack$delegate", "prefilledEmail", "", "getPrefilledEmail", "()Ljava/lang/String;", "prefilledEmail$delegate", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "getProcessId", "processId$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "productType", "Lru/yoomoney/sdk/auth/Config$ProductType;", "getProductType", "()Lru/yoomoney/sdk/auth/Config$ProductType;", "productType$delegate", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect;", "Lru/yoomoney/sdk/auth/email/enter/EmailEnterViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "launch2fa", "", "authProcessId", "navigateToNextRegistrationStep", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "navigateToNextStep", "Lru/yoomoney/sdk/auth/api/Process;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupEmail", "showEffect", "effect", "showExpireDialog", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailEnterFragment extends BaseFragment {
    private AuthEmailEnterBinding _binding;
    private final AnalyticsLogger analyticsLogger;
    private final Config config;
    private final ActivityResultLauncher<Intent> confirmLauncher;

    /* renamed from: expireAt$delegate, reason: from kotlin metadata */
    private final Lazy expireAt;

    /* renamed from: isAddedToBackStack$delegate, reason: from kotlin metadata */
    private final Lazy isAddedToBackStack;

    /* renamed from: prefilledEmail$delegate, reason: from kotlin metadata */
    private final Lazy prefilledEmail;

    /* renamed from: processId$delegate, reason: from kotlin metadata */
    private final Lazy processId;
    private final ProcessMapper processMapper;

    /* renamed from: processType$delegate, reason: from kotlin metadata */
    private final Lazy processType;

    /* renamed from: productType$delegate, reason: from kotlin metadata */
    private final Lazy productType;
    private final RemoteConfig remoteConfig;
    private final ResourceMapper resourceMapper;
    private final ResultData resultData;
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
            return EmailEnterFragmentArgs.fromBundle(EmailEnterFragment.this.requireArguments()).getExpireAt();
        }
    }

    public static final class b extends Lambda implements Function0<Boolean> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(EmailEnterFragmentArgs.fromBundle(EmailEnterFragment.this.requireArguments()).getIsAddedToBackStack());
        }
    }

    public static final class c extends Lambda implements Function1<Bundle, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Bundle bundle) {
            Bundle it = bundle;
            Intrinsics.checkNotNullParameter(it, "it");
            it.putString(Scopes.EMAIL, String.valueOf(EmailEnterFragment.this.getBinding().email.getText()));
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Bundle, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Bundle bundle) {
            Bundle it = bundle;
            Intrinsics.checkNotNullParameter(it, "it");
            it.putString(Scopes.EMAIL, String.valueOf(EmailEnterFragment.this.getBinding().email.getText()));
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function1<EmailEnter.State, Unit> {
        public e(Object obj) {
            super(1, obj, EmailEnterFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/email/enter/EmailEnter$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(EmailEnter.State state) {
            EmailEnter.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EmailEnterFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class f extends FunctionReferenceImpl implements Function1<EmailEnter.Effect, Unit> {
        public f(Object obj) {
            super(1, obj, EmailEnterFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(EmailEnter.Effect effect) throws Resources.NotFoundException {
            EmailEnter.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EmailEnterFragment) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Throwable, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            ConstraintLayout parent = EmailEnterFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = EmailEnterFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function0<String> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return EmailEnterFragmentArgs.fromBundle(EmailEnterFragment.this.requireArguments()).getPrefilledEmail();
        }
    }

    public static final class i extends Lambda implements Function0<String> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String processId = EmailEnterFragmentArgs.fromBundle(EmailEnterFragment.this.requireArguments()).getProcessId();
            Intrinsics.checkNotNullExpressionValue(processId, "getProcessId(...)");
            return processId;
        }
    }

    public static final class j extends Lambda implements Function0<ProcessType> {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ProcessType invoke() {
            ProcessType processType = EmailEnterFragmentArgs.fromBundle(EmailEnterFragment.this.requireArguments()).getProcessType();
            Intrinsics.checkNotNullExpressionValue(processType, "getProcessType(...)");
            return processType;
        }
    }

    public static final class k extends Lambda implements Function0<Config.ProductType> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Config.ProductType invoke() {
            return EmailEnterFragment.this.config.getProductType();
        }
    }

    public static final class l extends Lambda implements Function0<ViewModelProvider.Factory> {
        public l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return EmailEnterFragment.this.viewModelFactory;
        }
    }

    public EmailEnterFragment(ViewModelProvider.Factory viewModelFactory, ResultData resultData, RemoteConfig remoteConfig, Config config, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.viewModelFactory = viewModelFactory;
        this.resultData = resultData;
        this.remoteConfig = remoteConfig;
        this.config = config;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        this.productType = LazyKt.lazy(new k());
        l lVar = new l();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.email.enter.EmailEnterFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.email.enter.EmailEnterFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.email.enter.EmailEnterFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.email.enter.EmailEnterFragment$special$$inlined$viewModels$default$4
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
        }, lVar);
        this.processId = LazyKt.lazy(new i());
        this.processType = LazyKt.lazy(new j());
        this.expireAt = LazyKt.lazy(new a());
        this.prefilledEmail = LazyKt.lazy(new h());
        this.isAddedToBackStack = LazyKt.lazy(new b());
        this.analyticsLogger = new AnalyticsLogger() { // from class: ru.yoomoney.sdk.auth.email.enter.EmailEnterFragment$analyticsLogger$1
            @Override // ru.yoomoney.sdk.two_fa.analytics.AnalyticsLogger
            public void onNewEvent(AnalyticsEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                this.this$0.getViewModel().handleAction(new EmailEnter.Action.SendAnalyticsFromTwoFa(this.this$0.getProcessType()));
            }
        };
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: ru.yoomoney.sdk.auth.email.enter.EmailEnterFragment$$ExternalSyntheticLambda2
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                EmailEnterFragment.confirmLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.confirmLauncher = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void confirmLauncher$lambda$0(EmailEnterFragment this$0, ActivityResult it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResultCode() == -1) {
            this$0.getViewModel().handleAction(new EmailEnter.Action.ConfirmEmail(this$0.getProcessId()));
        } else {
            if (this$0.isAddedToBackStack()) {
                return;
            }
            FragmentKt.findNavController(this$0).popBackStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthEmailEnterBinding getBinding() {
        AuthEmailEnterBinding authEmailEnterBinding = this._binding;
        Intrinsics.checkNotNull(authEmailEnterBinding);
        return authEmailEnterBinding;
    }

    private final OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.expireAt.getValue();
    }

    private final String getPrefilledEmail() {
        return (String) this.prefilledEmail.getValue();
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
    public final RuntimeViewModel<EmailEnter.State, EmailEnter.Action, EmailEnter.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final boolean isAddedToBackStack() {
        return ((Boolean) this.isAddedToBackStack.getValue()).booleanValue();
    }

    private final void launch2fa(String authProcessId) {
        Palette paletteCurrentThemeToComposePalette;
        PaletteParcelable paletteParcelable;
        ThemeScheme themeScheme;
        ComposeStyle composeStyle;
        List<FontResource> fontResources;
        ComposeStyle composeStyle2;
        ComposeStyle composeStyle3;
        YooMoneyTwoFa yooMoneyTwoFa = YooMoneyTwoFa.INSTANCE;
        yooMoneyTwoFa.initTwoFaAnalyticsLogger(this.analyticsLogger);
        ActivityResultLauncher<Intent> activityResultLauncher = this.confirmLauncher;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String apiHost = this.config.getApiHost();
        String accessToken = this.config.getAccessToken();
        ArrayList arrayList = null;
        String str = (accessToken == null || accessToken.length() == 0) ? null : accessToken;
        boolean confirmationHelpActionVisible = this.config.getConfirmationHelpActionVisible();
        Style style = this.config.getStyle();
        boolean darkTheme = (style == null || (composeStyle3 = style.getComposeStyle()) == null) ? false : composeStyle3.getDarkTheme();
        Style style2 = this.config.getStyle();
        if (((style2 == null || (composeStyle2 = style2.getComposeStyle()) == null) ? null : composeStyle2.getPalette()) != null) {
            paletteParcelable = this.config.getStyle().getComposeStyle().getPalette();
        } else {
            Style style3 = this.config.getStyle();
            if (((style3 == null || (themeScheme = style3.getThemeScheme()) == null) ? null : themeScheme.getAccentColor()) != null) {
                ColorScheme colorScheme = ColorScheme.INSTANCE;
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                paletteCurrentThemeToComposePalette = ContextExtensionsKt.accentColorToComposePalette(colorScheme.getAccentColor(contextRequireContext2));
            } else {
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                paletteCurrentThemeToComposePalette = ContextExtensionsKt.currentThemeToComposePalette(contextRequireContext3);
            }
            paletteParcelable = new PaletteParcelable(paletteCurrentThemeToComposePalette);
        }
        Style style4 = this.config.getStyle();
        if (style4 != null && (composeStyle = style4.getComposeStyle()) != null && (fontResources = composeStyle.getFontResources()) != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fontResources, 10));
            for (FontResource fontResource : fontResources) {
                arrayList.add(new FontResource(fontResource.getResId(), fontResource.getWeight()));
            }
        }
        activityResultLauncher.launch(yooMoneyTwoFa.confirm(contextRequireContext, new ru.yoomoney.sdk.two_fa.Config(authProcessId, apiHost, str, confirmationHelpActionVisible, new ru.yoomoney.sdk.two_fa.Style(darkTheme, paletteParcelable, arrayList))));
    }

    private final void navigateToNextRegistrationStep(RegistrationProcess process) throws Resources.NotFoundException {
        String authProcessId;
        this.resultData.setMarketingNewsLetterByEmailAccepted(getBinding().offers.isChecked());
        if (process instanceof RegistrationProcess.Require2faEmail) {
            authProcessId = ((RegistrationProcess.Require2faEmail) process).getAuthProcessId();
        } else {
            if (!(process instanceof RegistrationProcess.Require2faPhone)) {
                navigate$auth_release(process, new c());
                return;
            }
            authProcessId = ((RegistrationProcess.Require2faPhone) process).getAuthProcessId();
        }
        launch2fa(authProcessId);
    }

    private final void navigateToNextStep(Process process) throws Resources.NotFoundException {
        this.resultData.setMarketingNewsLetterByEmailAccepted(getBinding().offers.isChecked());
        navigate$auth_release(process, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$lambda$3(EmailEnterFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new EmailEnter.Action.OffersChecked(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(EmailEnterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new EmailEnter.Action.CheckExpiration(this$0.getProcessType(), this$0.getProcessId(), this$0.getExpireAt()));
    }

    private final void setupEmail() {
        getBinding().email.getEditText().addTextChangedListener(new TextWatcher() { // from class: ru.yoomoney.sdk.auth.email.enter.EmailEnterFragment$setupEmail$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.this$0.getViewModel().handleAction(new EmailEnter.Action.ChangeEmail(String.valueOf(s)));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }
        });
        String prefilledEmail = getPrefilledEmail();
        if (prefilledEmail == null) {
            PrefilledData prefilledData = this.config.getPrefilledData();
            prefilledEmail = prefilledData != null ? prefilledData.getEmail() : null;
        }
        if (prefilledEmail != null) {
            getBinding().email.getEditText().setText(prefilledEmail);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(EmailEnter.Effect effect) throws Resources.NotFoundException {
        if (effect instanceof EmailEnter.Effect.ShowNextStep) {
            navigateToNextStep(((EmailEnter.Effect.ShowNextStep) effect).getProcess());
            return;
        }
        if (effect instanceof EmailEnter.Effect.ShowNextRegistrationStep) {
            navigateToNextRegistrationStep(((EmailEnter.Effect.ShowNextRegistrationStep) effect).getProcess());
            return;
        }
        if (effect instanceof EmailEnter.Effect.ShowFailure) {
            EmailEnter.Effect.ShowFailure showFailure = (EmailEnter.Effect.ShowFailure) effect;
            if (!(showFailure.getFailure() instanceof FeatureFailure) || !(((FeatureFailure) showFailure.getFailure()).getError() instanceof RegistrationProcessError.ProcessExpired)) {
                FragmentManager childFragmentManager = getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                View viewRequireView = requireView();
                Intrinsics.checkNotNullExpressionValue(viewRequireView, "requireView(...)");
                CoreFragmentExtensions.handleFailure(this, childFragmentManager, viewRequireView, showFailure.getFailure(), getResourceMapper());
                return;
            }
        } else if (!(effect instanceof EmailEnter.Effect.ShowExpireDialog)) {
            if (effect instanceof EmailEnter.Effect.ResetProcess) {
                FragmentKt.findNavController(this).navigate(getRouter().reset());
                return;
            }
            return;
        }
        showExpireDialog();
    }

    private final void showExpireDialog() {
        YmAlertDialog.DialogContent dialogContent = new YmAlertDialog.DialogContent(getString(R.string.auth_reset_process_dialog_title), getResourceMapper().resetProcessDialog(getProcessType()), getString(R.string.auth_reset_process_dialog_action), null, false, false, 56, null);
        AlertDialog.Companion companion = AlertDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        AlertDialog alertDialogCreate = companion.create(childFragmentManager, dialogContent);
        alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.email.enter.EmailEnterFragment$showExpireDialog$1$1
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
                this.this$0.getViewModel().handleAction(EmailEnter.Action.RestartProcess.INSTANCE);
            }
        });
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        alertDialogCreate.show(childFragmentManager2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(EmailEnter.State state) {
        if (!(state instanceof EmailEnter.State.Content)) {
            if (state instanceof EmailEnter.State.Loading) {
                getBinding().email.setError(null);
                getBinding().offers.setEnabled(false);
                getBinding().email.setEnabled(false);
                getBinding().action.showProgress(true);
                return;
            }
            return;
        }
        getBinding().email.setEnabled(true);
        TextInputView textInputView = getBinding().email;
        EmailEnter.State.Content content = (EmailEnter.State.Content) state;
        ProcessError error = content.getError();
        textInputView.setError(error != null ? getResourceMapper().map(ProcessErrorExtensionsKt.toFailure(error)) : null);
        getBinding().action.showProgress(false);
        getBinding().offers.setEnabled(true);
        getBinding().action.setEnabled(content.getEmailIsValid());
        getBinding().offers.setChecked(content.getOffersIsChecked());
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
        this._binding = AuthEmailEnterBinding.inflate(inflater, container, false);
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
        PrimaryButtonView primaryButtonView;
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().appBar.setTitle("");
        if (getProductType() == Config.ProductType.WEBBANKIR) {
            getBinding().title.setText(this.remoteConfig.getEmailEnterScreenTitle());
            TextBodyView textBodyView = getBinding().subtitle;
            Intrinsics.checkNotNull(textBodyView);
            ViewExtensions.setVisible(textBodyView, true);
            textBodyView.setText(this.remoteConfig.getEmailEnterScreenSubtitle());
            ItemSecondarySwitchView offers = getBinding().offers;
            Intrinsics.checkNotNullExpressionValue(offers, "offers");
            ViewExtensions.setVisible(offers, false);
            primaryButtonView = getBinding().action;
            string = this.remoteConfig.getEmailEnterActionText();
        } else {
            getBinding().title.setText(getString(R.string.auth_email_enter_screen_title));
            TextBodyView textBodyView2 = getBinding().subtitle;
            Intrinsics.checkNotNull(textBodyView2);
            ViewExtensions.setVisible(textBodyView2, true);
            textBodyView2.setText(getString(this.config.getEmailFillingReason() == Config.EmailFillingReason.UPGRADE_STATUS ? R.string.auth_email_enter_info_upgrade_status_reason : R.string.auth_email_enter_info_other_reason));
            ItemSecondarySwitchView itemSecondarySwitchView = getBinding().offers;
            Intrinsics.checkNotNull(itemSecondarySwitchView);
            itemSecondarySwitchView.setVisibility(this.remoteConfig.getEmailCheckboxVisible() ? 0 : 8);
            String emailCheckboxTitle = this.remoteConfig.getEmailCheckboxTitle();
            if (emailCheckboxTitle == null) {
                emailCheckboxTitle = getString(R.string.auth_email_enter_legal_terms, ConfigKt.getBaseHost());
                Intrinsics.checkNotNullExpressionValue(emailCheckboxTitle, "getString(...)");
            }
            itemSecondarySwitchView.setText(StringExtensionsKt.parseHtml(emailCheckboxTitle));
            itemSecondarySwitchView.setMovementMethod(LinkMovementMethod.getInstance());
            ColorScheme colorScheme = ColorScheme.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            itemSecondarySwitchView.setLinkTextColor(colorScheme.getAccentColor(contextRequireContext));
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            itemSecondarySwitchView.setHighlightColor(colorScheme.getAccentGhostColor(contextRequireContext2));
            TextViewExtentionsKt.removeLinkUnderline(itemSecondarySwitchView);
            itemSecondarySwitchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.yoomoney.sdk.auth.email.enter.EmailEnterFragment$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    EmailEnterFragment.onViewCreated$lambda$4$lambda$3(this.f$0, compoundButton, z);
                }
            });
            primaryButtonView = getBinding().action;
            string = getString(R.string.auth_email_enter_action_text);
        }
        primaryButtonView.setText(string);
        getBinding().action.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.email.enter.EmailEnterFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EmailEnterFragment.onViewCreated$lambda$5(this.f$0, view2);
            }
        });
        String addEmailTitle = this.remoteConfig.getAddEmailTitle();
        if (addEmailTitle != null) {
            getBinding().title.setText(addEmailTitle);
        }
        setupEmail();
        RuntimeViewModel<EmailEnter.State, EmailEnter.Action, EmailEnter.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new e(this), new f(this), new g());
        getViewModel().handleAction(new EmailEnter.Action.SendAnalyticsForScreen(getProcessType()));
    }
}
