package ru.yoomoney.sdk.auth.loading;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$StartActivityForResult;
import java.util.List;
import kotlin.Deprecated;
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
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.EsiaOauthCodeParameters;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthCodeParameters;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.SberOauthCodeParameters;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.VkOauthCodeParameters;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcess;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessConfirmPhone;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessEnterOauthCode;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessEnterPassword;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.RuleViolationType;
import ru.yoomoney.sdk.auth.api.model.RulesViolationFailure;
import ru.yoomoney.sdk.auth.api.model.SocialAccountAuthFailure;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthLoadingBinding;
import ru.yoomoney.sdk.auth.loading.AuthLoading;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.socialAccounts.esia.EsiaActivity;
import ru.yoomoney.sdk.auth.socialAccounts.sberId.SberIdActivity;
import ru.yoomoney.sdk.auth.socialAccounts.vkId.VkIdActivity;
import ru.yoomoney.sdk.auth.ui.EmptyStateLargeView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.utils.SberIdUtilsKt;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 Y2\u00020\u0001:\u0001YB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u000208H\u0002J\u0018\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0017H\u0002J$\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010H\u001a\u000208H\u0016J\u0010\u0010I\u001a\u00020\u00172\u0006\u0010J\u001a\u00020KH\u0017J\u0010\u0010L\u001a\u0002082\u0006\u0010M\u001a\u00020GH\u0016J\u001a\u0010N\u001a\u0002082\u0006\u0010O\u001a\u00020A2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0010\u0010P\u001a\u0002082\u0006\u0010Q\u001a\u000202H\u0002J\u0010\u0010R\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010S\u001a\u0002082\u0006\u0010T\u001a\u000200H\u0002J\u0010\u0010U\u001a\u0002082\u0006\u0010=\u001a\u00020\u001dH\u0002J\u0010\u0010V\u001a\u0002082\u0006\u0010=\u001a\u00020\u001dH\u0002J\u0010\u0010W\u001a\u0002082\u0006\u0010=\u001a\u00020\u001dH\u0002J\u0010\u0010X\u001a\u0002082\u0006\u0010=\u001a\u00020\u001dH\u0002R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0016\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010$0$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010$0$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010$0$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R1\u0010.\u001a\u0018\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002020/j\u0002`38BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u001a\u001a\u0004\b4\u00105R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lru/yoomoney/sdk/auth/loading/AuthLoadingFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "config", "Lru/yoomoney/sdk/auth/Config;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "remoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/auth/ResultData;Lru/yoomoney/sdk/auth/RemoteConfig;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthLoadingBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthLoadingBinding;", "isForcedRegistration", "", "()Z", "isForcedRegistration$delegate", "Lkotlin/Lazy;", AuthLoadingFragment.KEY_IS_INITIALIZED, "loginProcess", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcessEnterOauthCode;", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "resultEsiaLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "resultSberIdActivityLauncher", "resultVkIdLauncher", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$State;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect;", "Lru/yoomoney/sdk/auth/loading/AuthLoadingViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "handleError", "", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "initErrorView", "navigateLogin", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "isForceLogin", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onSaveInstanceState", "outState", "onViewCreated", "view", "showEffect", "effect", "showError", "showState", "state", "startEsia", "startSberId", "startSocialAccount", "startVkId", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthLoadingFragment extends BaseFragment {
    private static final String KEY_IS_INITIALIZED = "isInitialized";
    private static final String KEY_LOGIN_PROCESS_ENTER_OAUTH_CODE = "LoginProcessEnterOauthCode";
    private AuthLoadingBinding _binding;
    private final Config config;

    /* renamed from: isForcedRegistration$delegate, reason: from kotlin metadata */
    private final Lazy isForcedRegistration;
    private boolean isInitialized;
    private LoginProcessEnterOauthCode loginProcess;
    private final ProcessMapper processMapper;
    private final RemoteConfig remoteConfig;
    private final ResourceMapper resourceMapper;
    private final ResultData resultData;
    private final ActivityResultLauncher<Intent> resultEsiaLauncher;
    private final ActivityResultLauncher<Intent> resultSberIdActivityLauncher;
    private final ActivityResultLauncher<Intent> resultVkIdLauncher;
    private final Router router;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OauthServiceProvider.values().length];
            try {
                iArr[OauthServiceProvider.SBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OauthServiceProvider.VK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OauthServiceProvider.ESIA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            AuthLoadingFragment.this.getViewModel().handleAction(new AuthLoading.Action.Load(AuthLoadingFragment.this.isForcedRegistration()));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Boolean> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(AuthLoadingFragmentArgs.fromBundle(AuthLoadingFragment.this.requireArguments()).getIsForcedRegistration());
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<AuthLoading.State, Unit> {
        public c(Object obj) {
            super(1, obj, AuthLoadingFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/loading/AuthLoading$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(AuthLoading.State state) {
            AuthLoading.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AuthLoadingFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<AuthLoading.Effect, Unit> {
        public d(Object obj) {
            super(1, obj, AuthLoadingFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/loading/AuthLoading$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(AuthLoading.Effect effect) throws Resources.NotFoundException {
            AuthLoading.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AuthLoadingFragment) this.receiver).showEffect(p0);
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
            FrameLayout root = AuthLoadingFragment.this.getBinding().root;
            Intrinsics.checkNotNullExpressionValue(root, "root");
            String string = AuthLoadingFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(root, string);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function0<Unit> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            AuthLoadingFragment.this.getViewModel().handleAction(AuthLoading.Action.Finish.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function0<ViewModelProvider.Factory> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return AuthLoadingFragment.this.viewModelFactory;
        }
    }

    public AuthLoadingFragment(ViewModelProvider.Factory viewModelFactory, Config config, ResultData resultData, RemoteConfig remoteConfig, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.viewModelFactory = viewModelFactory;
        this.config = config;
        this.resultData = resultData;
        this.remoteConfig = remoteConfig;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        g gVar = new g();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.loading.AuthLoadingFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.loading.AuthLoadingFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.loading.AuthLoadingFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.loading.AuthLoadingFragment$special$$inlined$viewModels$default$4
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
        }, gVar);
        this.isForcedRegistration = LazyKt.lazy(new b());
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: ru.yoomoney.sdk.auth.loading.AuthLoadingFragment$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AuthLoadingFragment.resultSberIdActivityLauncher$lambda$1(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.resultSberIdActivityLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: ru.yoomoney.sdk.auth.loading.AuthLoadingFragment$$ExternalSyntheticLambda1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AuthLoadingFragment.resultVkIdLauncher$lambda$3(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.resultVkIdLauncher = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: ru.yoomoney.sdk.auth.loading.AuthLoadingFragment$$ExternalSyntheticLambda2
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AuthLoadingFragment.resultEsiaLauncher$lambda$5(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.resultEsiaLauncher = activityResultLauncherRegisterForActivityResult3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthLoadingBinding getBinding() {
        AuthLoadingBinding authLoadingBinding = this._binding;
        Intrinsics.checkNotNull(authLoadingBinding);
        return authLoadingBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<AuthLoading.State, AuthLoading.Action, AuthLoading.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void handleError(Failure failure) {
        List listListOf = CollectionsKt.listOf((Object[]) new RuleViolationType[]{RuleViolationType.PROCESS_NOT_FOUND, RuleViolationType.ILLEGAL_PROCESS_STATE, RuleViolationType.INVALID_CLIENT_ID, RuleViolationType.REGISTRATION_FORBIDDEN});
        if ((failure instanceof RulesViolationFailure) && listListOf.contains(((RulesViolationFailure) failure).getRule())) {
            cancelProcess$auth_release();
        } else {
            showError(failure);
        }
    }

    private final void initErrorView() {
        EmptyStateLargeView emptyStateLargeView = getBinding().errorContainer;
        emptyStateLargeView.setIcon(AppCompatResources.getDrawable(requireContext(), R.drawable.ic_close_m));
        emptyStateLargeView.setActionListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isForcedRegistration() {
        return ((Boolean) this.isForcedRegistration.getValue()).booleanValue();
    }

    private final void navigateLogin(LoginProcess process, boolean isForceLogin) throws Resources.NotFoundException {
        if (process instanceof LoginProcessConfirmPhone) {
            this.resultData.setPhone(((LoginProcessConfirmPhone) process).getPhone());
        }
        if (process instanceof LoginProcessEnterPassword) {
            this.resultData.setForceLogin(Boolean.valueOf(isForceLogin));
        }
        BaseFragment.navigate$auth_release$default(this, process, (Function1) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resultEsiaLauncher$lambda$5(AuthLoadingFragment this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        Uri data2 = data != null ? data.getData() : null;
        if (result.getResultCode() != -1 || data2 == null) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        LoginProcessEnterOauthCode loginProcessEnterOauthCode = this$0.loginProcess;
        if (loginProcessEnterOauthCode != null) {
            this$0.getViewModel().handleAction(new AuthLoading.Action.HandleEsiaResponse(loginProcessEnterOauthCode, data2));
            this$0.loginProcess = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resultSberIdActivityLauncher$lambda$1(AuthLoadingFragment this$0, ActivityResult result) {
        String sberIdReturnUrl;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        Uri data2 = data != null ? data.getData() : null;
        if (result.getResultCode() != -1 || data2 == null) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        LoginProcessEnterOauthCode loginProcessEnterOauthCode = this$0.loginProcess;
        if (loginProcessEnterOauthCode != null) {
            RuntimeViewModel<AuthLoading.State, AuthLoading.Action, AuthLoading.Effect> viewModel = this$0.getViewModel();
            Context context = this$0.getContext();
            if (context != null) {
                Intrinsics.checkNotNull(context);
                sberIdReturnUrl = SberIdUtilsKt.getSberIdReturnUrl(context);
            } else {
                sberIdReturnUrl = null;
            }
            viewModel.handleAction(new AuthLoading.Action.HandleSberIdResponse(loginProcessEnterOauthCode, data2, sberIdReturnUrl));
            this$0.loginProcess = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resultVkIdLauncher$lambda$3(AuthLoadingFragment this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() != -1) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        Intent data = result.getData();
        String stringExtra = data != null ? data.getStringExtra(VkIdActivity.EXTRA_VK_ID_SILENT_TOKEN) : null;
        Intent data2 = result.getData();
        String stringExtra2 = data2 != null ? data2.getStringExtra(VkIdActivity.EXTRA_VK_ID_UUID) : null;
        String string = this$0.getString(R.string.vk_external_oauth_redirect_url);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        LoginProcessEnterOauthCode loginProcessEnterOauthCode = this$0.loginProcess;
        if (loginProcessEnterOauthCode != null) {
            this$0.getViewModel().handleAction(new AuthLoading.Action.HandleVkIdResponse(loginProcessEnterOauthCode, stringExtra, stringExtra2, string));
            this$0.loginProcess = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(AuthLoading.Effect effect) throws Resources.NotFoundException {
        FragmentActivity activity;
        Process process;
        if (effect instanceof AuthLoading.Effect.ShowRegistration) {
            BaseFragment.navigate$auth_release$default(this, ((AuthLoading.Effect.ShowRegistration) effect).getProcess(), (Function1) null, 2, (Object) null);
            return;
        }
        if (effect instanceof AuthLoading.Effect.ShowLogin) {
            AuthLoading.Effect.ShowLogin showLogin = (AuthLoading.Effect.ShowLogin) effect;
            navigateLogin(showLogin.getProcess(), showLogin.isForceLogin());
            return;
        }
        if (effect instanceof AuthLoading.Effect.ShowMigration) {
            process = ((AuthLoading.Effect.ShowMigration) effect).getProcess();
        } else {
            if (!(effect instanceof AuthLoading.Effect.ShowEnrollment)) {
                if (!(effect instanceof AuthLoading.Effect.Close) || (activity = getActivity()) == null) {
                    return;
                }
                activity.finish();
                return;
            }
            process = ((AuthLoading.Effect.ShowEnrollment) effect).getProcess();
        }
        BaseFragment.navigate$auth_release$default(this, process, (Function1) null, 2, (Object) null);
    }

    private final void showError(Failure failure) {
        EmptyStateLargeView emptyStateLargeView = getBinding().errorContainer;
        emptyStateLargeView.setSubtitle(getResourceMapper().map(failure));
        if (Intrinsics.areEqual(failure, SocialAccountAuthFailure.INSTANCE)) {
            emptyStateLargeView.setTitle(getString(R.string.auth_oauth_failure_title));
            emptyStateLargeView.setAction(getString(R.string.auth_oauth_failure_action));
            emptyStateLargeView.setActionListener(new f());
        } else {
            emptyStateLargeView.setAction(getString(R.string.auth_action_try_again));
        }
        getBinding().stateFlipper.showError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(AuthLoading.State state) {
        if (state instanceof AuthLoading.State.Progress) {
            getBinding().stateFlipper.showProgress();
        } else if (state instanceof AuthLoading.State.Error) {
            handleError(((AuthLoading.State.Error) state).getFailure());
        } else if (state instanceof AuthLoading.State.SocialAccountAuth) {
            startSocialAccount(((AuthLoading.State.SocialAccountAuth) state).getProcess());
        }
    }

    private final void startEsia(LoginProcessEnterOauthCode process) {
        OauthCodeParameters oauthCodeParameters = process.getOauthCodeParameters();
        Intrinsics.checkNotNull(oauthCodeParameters, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.account.socialAccount.model.EsiaOauthCodeParameters");
        EsiaActivity.Companion companion = EsiaActivity.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Intent intentCreateIntent = companion.createIntent(contextRequireContext, this.config, (EsiaOauthCodeParameters) oauthCodeParameters);
        this.isInitialized = true;
        this.loginProcess = process;
        this.resultEsiaLauncher.launch(intentCreateIntent);
    }

    private final void startSberId(LoginProcessEnterOauthCode process) {
        OauthCodeParameters oauthCodeParameters = process.getOauthCodeParameters();
        SberOauthCodeParameters sberOauthCodeParameters = oauthCodeParameters instanceof SberOauthCodeParameters ? (SberOauthCodeParameters) oauthCodeParameters : null;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        String sberIdReturnUrl = SberIdUtilsKt.getSberIdReturnUrl(contextRequireContext);
        if (sberOauthCodeParameters == null || sberIdReturnUrl == null) {
            return;
        }
        SberIdActivity.Companion companion = SberIdActivity.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        Intent intentCreateIntent = companion.createIntent(contextRequireContext2, this.config, sberOauthCodeParameters, sberIdReturnUrl, this.remoteConfig.getOpenSberIdDialogText());
        this.isInitialized = true;
        this.loginProcess = process;
        this.resultSberIdActivityLauncher.launch(intentCreateIntent);
    }

    private final void startSocialAccount(LoginProcessEnterOauthCode process) {
        int i = WhenMappings.$EnumSwitchMapping$0[process.getOauthService().ordinal()];
        if (i == 1) {
            startSberId(process);
        } else if (i == 2) {
            startVkId(process);
        } else {
            if (i != 3) {
                return;
            }
            startEsia(process);
        }
    }

    private final void startVkId(LoginProcessEnterOauthCode process) {
        OauthCodeParameters oauthCodeParameters = process.getOauthCodeParameters();
        if ((oauthCodeParameters instanceof VkOauthCodeParameters ? (VkOauthCodeParameters) oauthCodeParameters : null) != null) {
            VkIdActivity.Companion companion = VkIdActivity.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            Intent intentCreateIntent = companion.createIntent(contextRequireContext, this.config);
            this.isInitialized = true;
            this.loginProcess = process;
            this.resultVkIdLauncher.launch(intentCreateIntent);
        }
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
        this._binding = AuthLoadingBinding.inflate(inflater, container, false);
        FrameLayout root = getBinding().root;
        Intrinsics.checkNotNullExpressionValue(root, "root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment, androidx.fragment.app.Fragment
    @Deprecated
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332 && (activity = getActivity()) != null) {
            activity.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_IS_INITIALIZED, this.isInitialized);
        outState.putParcelable(KEY_LOGIN_PROCESS_ENTER_OAUTH_CODE, this.loginProcess);
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initErrorView();
        RuntimeViewModel<AuthLoading.State, AuthLoading.Action, AuthLoading.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new c(this), new d(this), new e());
        this.isInitialized = savedInstanceState != null ? savedInstanceState.getBoolean(KEY_IS_INITIALIZED) : false;
        LoginProcessEnterOauthCode loginProcessEnterOauthCode = savedInstanceState != null ? (LoginProcessEnterOauthCode) savedInstanceState.getParcelable(KEY_LOGIN_PROCESS_ENTER_OAUTH_CODE) : null;
        this.loginProcess = loginProcessEnterOauthCode != null ? loginProcessEnterOauthCode : null;
        if (this.isInitialized) {
            return;
        }
        getViewModel().handleAction(new AuthLoading.Action.Load(isForcedRegistration()));
    }
}
