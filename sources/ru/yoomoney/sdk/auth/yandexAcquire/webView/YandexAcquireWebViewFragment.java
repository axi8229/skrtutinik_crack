package ru.yoomoney.sdk.auth.yandexAcquire.webView;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
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
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthYandexAcquireWebviewBinding;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.AlertDialog;
import ru.yoomoney.sdk.auth.ui.EmptyStateLargeView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.YandexAcquireWebView;
import ru.yoomoney.sdk.auth.yandexAcquire.webView.utils.AuthWebViewClient;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u000209H\u0002J$\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020CH\u0016J\u001a\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020;2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010F\u001a\u00020C2\u0006\u0010G\u001a\u00020\u0019H\u0002J\b\u0010H\u001a\u00020CH\u0002J\b\u0010I\u001a\u00020CH\u0003J\u0010\u0010J\u001a\u00020C2\u0006\u0010K\u001a\u000200H\u0002J\u0010\u0010L\u001a\u00020C2\u0006\u00108\u001a\u00020.H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b!\u0010\"R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R1\u0010,\u001a\u0018\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000-j\u0002`18BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0017\u001a\u0004\b2\u00103R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebViewFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "config", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthYandexAcquireWebviewBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthYandexAcquireWebviewBinding;", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "expireAt$delegate", "Lkotlin/Lazy;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "getProcessId", "()Ljava/lang/String;", "processId$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Action;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Effect;", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebViewViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "webViewClient", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/utils/AuthWebViewClient;", "getUrl", "state", "Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State$Init;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "setupErrorCodeView", "token", "setupErrorMigrationView", "setupWebView", "showEffect", "effect", "showState", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireWebViewFragment extends BaseFragment {
    private AuthYandexAcquireWebviewBinding _binding;
    private final Config config;

    /* renamed from: expireAt$delegate, reason: from kotlin metadata */
    private final Lazy expireAt;

    /* renamed from: processId$delegate, reason: from kotlin metadata */
    private final Lazy processId;
    private final ProcessMapper processMapper;

    /* renamed from: processType$delegate, reason: from kotlin metadata */
    private final Lazy processType;
    private final ResourceMapper resourceMapper;
    private final Router router;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;
    private final AuthWebViewClient webViewClient;

    public static final class a extends Lambda implements Function0<OffsetDateTime> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final OffsetDateTime invoke() {
            OffsetDateTime expireAt = YandexAcquireWebViewFragmentArgs.fromBundle(YandexAcquireWebViewFragment.this.requireArguments()).getExpireAt();
            Intrinsics.checkNotNullExpressionValue(expireAt, "getExpireAt(...)");
            return expireAt;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<YandexAcquireWebView.State, Unit> {
        public b(Object obj) {
            super(1, obj, YandexAcquireWebViewFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(YandexAcquireWebView.State state) {
            YandexAcquireWebView.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((YandexAcquireWebViewFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<YandexAcquireWebView.Effect, Unit> {
        public c(Object obj) {
            super(1, obj, YandexAcquireWebViewFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/yandexAcquire/webView/YandexAcquireWebView$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(YandexAcquireWebView.Effect effect) throws Resources.NotFoundException {
            YandexAcquireWebView.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((YandexAcquireWebViewFragment) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Throwable, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            LinearLayout parent = YandexAcquireWebViewFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = YandexAcquireWebViewFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function0<String> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = YandexAcquireWebViewFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            String processId = YandexAcquireWebViewFragmentArgs.fromBundle(arguments).getProcessId();
            Intrinsics.checkNotNullExpressionValue(processId, "getProcessId(...)");
            return processId;
        }
    }

    public static final class f extends Lambda implements Function0<ProcessType> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ProcessType invoke() {
            Bundle arguments = YandexAcquireWebViewFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            ProcessType processType = YandexAcquireWebViewFragmentArgs.fromBundle(arguments).getProcessType();
            Intrinsics.checkNotNullExpressionValue(processType, "getProcessType(...)");
            return processType;
        }
    }

    public static final class g extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(0);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            YandexAcquireWebViewFragment.this.getViewModel().handleAction(new YandexAcquireWebView.Action.SetYandexToken(YandexAcquireWebViewFragment.this.getProcessId(), this.b, YandexAcquireWebViewFragment.this.getExpireAt()));
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function0<ViewModelProvider.Factory> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return YandexAcquireWebViewFragment.this.viewModelFactory;
        }
    }

    public static final class i extends Lambda implements Function0<Unit> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            YandexAcquireWebViewFragment.this.getViewModel().handleAction(YandexAcquireWebView.Action.PageLoaded.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<String, Unit> {
        public j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String str) {
            String token = str;
            Intrinsics.checkNotNullParameter(token, "token");
            YandexAcquireWebViewFragment.this.getViewModel().handleAction(new YandexAcquireWebView.Action.SetYandexToken(YandexAcquireWebViewFragment.this.getProcessId(), token, YandexAcquireWebViewFragment.this.getExpireAt()));
            return Unit.INSTANCE;
        }
    }

    public YandexAcquireWebViewFragment(ViewModelProvider.Factory viewModelFactory, Config config, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.viewModelFactory = viewModelFactory;
        this.config = config;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        h hVar = new h();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.webView.YandexAcquireWebViewFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.webView.YandexAcquireWebViewFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.webView.YandexAcquireWebViewFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.webView.YandexAcquireWebViewFragment$special$$inlined$viewModels$default$4
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
        }, hVar);
        this.processId = LazyKt.lazy(new e());
        this.processType = LazyKt.lazy(new f());
        this.expireAt = LazyKt.lazy(new a());
        this.webViewClient = new AuthWebViewClient(config.isDebugMode(), new i(), new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthYandexAcquireWebviewBinding getBinding() {
        AuthYandexAcquireWebviewBinding authYandexAcquireWebviewBinding = this._binding;
        Intrinsics.checkNotNull(authYandexAcquireWebviewBinding);
        return authYandexAcquireWebviewBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.expireAt.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getProcessId() {
        return (String) this.processId.getValue();
    }

    private final ProcessType getProcessType() {
        return (ProcessType) this.processType.getValue();
    }

    private final String getUrl(YandexAcquireWebView.State.Init state) {
        return (this.config.isDebugMode() ? "https://oauth-test.yandex.ru/authorize?response_type=token&force_confirm=yes&client_id=" : "https://oauth.yandex.ru/authorize?response_type=token&force_confirm=yes&client_id=") + state.getClientId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<YandexAcquireWebView.State, YandexAcquireWebView.Action, YandexAcquireWebView.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void setupErrorCodeView(String token) {
        EmptyStateLargeView emptyStateLargeView = getBinding().errorContainer;
        emptyStateLargeView.setIcon(AppCompatResources.getDrawable(requireContext(), R.drawable.ic_close_m));
        emptyStateLargeView.setAction(getString(R.string.auth_action_try_again));
        emptyStateLargeView.setSubtitle(getString(R.string.auth_phone_confirm_retry_action_text));
        emptyStateLargeView.setActionListener(new g(token));
    }

    private final void setupErrorMigrationView() {
        EmptyStateLargeView emptyStateLargeView = getBinding().errorContainer;
        emptyStateLargeView.setIcon(AppCompatResources.getDrawable(requireContext(), R.drawable.ic_close_m));
        emptyStateLargeView.setSubtitle(getString(R.string.auth_migration_go_to_yoomoney));
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void setupWebView() {
        getBinding().contentContainer.setWebViewClient(this.webViewClient);
        getBinding().contentContainer.getSettings().setJavaScriptEnabled(true);
        CookieManager.getInstance().removeAllCookies(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(YandexAcquireWebView.Effect effect) throws Resources.NotFoundException {
        if (effect instanceof YandexAcquireWebView.Effect.ShowNextStep) {
            BaseFragment.navigate$auth_release$default(this, ((YandexAcquireWebView.Effect.ShowNextStep) effect).getProcess(), (Function1) null, 2, (Object) null);
            return;
        }
        if (!(effect instanceof YandexAcquireWebView.Effect.ShowExpireDialog)) {
            if (effect instanceof YandexAcquireWebView.Effect.ResetProcess) {
                FragmentKt.findNavController(this).navigate(getRouter().reset());
                return;
            }
            return;
        }
        YmAlertDialog.DialogContent dialogContent = new YmAlertDialog.DialogContent(getString(R.string.auth_reset_process_dialog_title), getResourceMapper().resetProcessDialog(getProcessType()), getString(R.string.auth_reset_process_dialog_action), null, false, false, 56, null);
        AlertDialog.Companion companion = AlertDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        AlertDialog alertDialogCreate = companion.create(childFragmentManager, dialogContent);
        alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.webView.YandexAcquireWebViewFragment$showEffect$1$1
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
                this.this$0.getViewModel().handleAction(YandexAcquireWebView.Action.RestartProcess.INSTANCE);
            }
        });
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        alertDialogCreate.show(childFragmentManager2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(YandexAcquireWebView.State state) {
        if (state instanceof YandexAcquireWebView.State.Init) {
            YandexAcquireWebView.State.Init init = (YandexAcquireWebView.State.Init) state;
            if (init.getClientId() == null) {
                getBinding().stateFlipper.showError();
                setupErrorMigrationView();
                return;
            } else {
                getBinding().stateFlipper.showProgress();
                getBinding().contentContainer.loadUrl(getUrl(init));
                return;
            }
        }
        if (Intrinsics.areEqual(state, YandexAcquireWebView.State.Content.INSTANCE)) {
            getBinding().stateFlipper.showContent();
            return;
        }
        if (state instanceof YandexAcquireWebView.State.Loading) {
            getBinding().stateFlipper.showProgress();
        } else if (state instanceof YandexAcquireWebView.State.Error) {
            setupErrorCodeView(((YandexAcquireWebView.State.Error) state).getToken());
            getBinding().stateFlipper.showError();
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
        this._binding = AuthYandexAcquireWebviewBinding.inflate(inflater, container, false);
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
        setupWebView();
        RuntimeViewModel<YandexAcquireWebView.State, YandexAcquireWebView.Action, YandexAcquireWebView.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new b(this), new c(this), new d());
        String yandexPassportToken = this.config.getYandexPassportToken();
        if (yandexPassportToken != null) {
            getViewModel().handleAction(new YandexAcquireWebView.Action.SetYandexToken(getProcessId(), yandexPassportToken, getExpireAt()));
        }
    }
}
