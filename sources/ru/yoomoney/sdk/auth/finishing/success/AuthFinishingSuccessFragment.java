package ru.yoomoney.sdk.auth.finishing.success;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.BindSocialAccountResult;
import ru.yoomoney.sdk.auth.api.model.ApplicationInfo;
import ru.yoomoney.sdk.auth.api.model.Scope;
import ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthFinishingSuccessBinding;
import ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.AlertDialog;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.state_screen.EmptyStateLargeView;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020<2\u0006\u0010>\u001a\u00020AH\u0002J$\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\b\u0010J\u001a\u00020<H\u0016J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0017J\u001a\u0010O\u001a\u00020<2\u0006\u0010P\u001a\u00020C2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010Q\u001a\u00020<2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010R\u001a\u00020<2\u0006\u0010S\u001a\u000206H\u0002J\u0010\u0010T\u001a\u00020<2\u0006\u0010U\u001a\u000204H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b!\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b'\u0010(R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R1\u00102\u001a\u0018\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020603j\u0002`78BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0012\u001a\u0004\b8\u00109R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccessFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthFinishingSuccessBinding;", YooMoneyAuth.KEY_ACCESS_TOKEN, "", "getAccessToken", "()Ljava/lang/String;", "accessToken$delegate", "Lkotlin/Lazy;", "applicationInfo", "Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "getApplicationInfo", "()Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "applicationInfo$delegate", "bindSocialAccountResult", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", "getBindSocialAccountResult", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/BindSocialAccountResult;", "bindSocialAccountResult$delegate", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthFinishingSuccessBinding;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "getProcessId", "processId$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Effect;", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "initErrorView", "", "navigateToNextRegistrationStep", "process", "Lru/yoomoney/sdk/auth/api/registrationV2/domain/RegistrationProcess;", "navigateToNextStep", "Lru/yoomoney/sdk/auth/api/Process;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "setupContentView", "showEffect", "effect", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthFinishingSuccessFragment extends BaseFragment {
    private AuthFinishingSuccessBinding _binding;

    /* renamed from: accessToken$delegate, reason: from kotlin metadata */
    private final Lazy accessToken;

    /* renamed from: applicationInfo$delegate, reason: from kotlin metadata */
    private final Lazy applicationInfo;

    /* renamed from: bindSocialAccountResult$delegate, reason: from kotlin metadata */
    private final Lazy bindSocialAccountResult;

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

    public static final class a extends Lambda implements Function0<String> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return AuthFinishingSuccessFragmentArgs.fromBundle(AuthFinishingSuccessFragment.this.requireArguments()).getAccessToken();
        }
    }

    public static final class b extends Lambda implements Function0<ApplicationInfo> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ApplicationInfo invoke() {
            Bundle arguments = AuthFinishingSuccessFragment.this.getArguments();
            if (arguments != null) {
                return AuthFinishingSuccessFragmentArgs.fromBundle(arguments).getApplicationInfo();
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    public static final class c extends Lambda implements Function0<BindSocialAccountResult> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final BindSocialAccountResult invoke() {
            Bundle arguments = AuthFinishingSuccessFragment.this.getArguments();
            if (arguments != null) {
                return AuthFinishingSuccessFragmentArgs.fromBundle(arguments).getBindSocialAccountResult();
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<AuthFinishingSuccess.State, Unit> {
        public d(Object obj) {
            super(1, obj, AuthFinishingSuccessFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(AuthFinishingSuccess.State state) {
            AuthFinishingSuccess.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AuthFinishingSuccessFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function1<AuthFinishingSuccess.Effect, Unit> {
        public e(Object obj) {
            super(1, obj, AuthFinishingSuccessFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(AuthFinishingSuccess.Effect effect) throws Resources.NotFoundException {
            AuthFinishingSuccess.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AuthFinishingSuccessFragment) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Throwable, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            FrameLayout root = AuthFinishingSuccessFragment.this.getBinding().root;
            Intrinsics.checkNotNullExpressionValue(root, "root");
            String string = AuthFinishingSuccessFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(root, string);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function0<String> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = AuthFinishingSuccessFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            String processId = AuthFinishingSuccessFragmentArgs.fromBundle(arguments).getProcessId();
            Intrinsics.checkNotNullExpressionValue(processId, "getProcessId(...)");
            return processId;
        }
    }

    public static final class h extends Lambda implements Function0<ProcessType> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ProcessType invoke() {
            Bundle arguments = AuthFinishingSuccessFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            ProcessType processType = AuthFinishingSuccessFragmentArgs.fromBundle(arguments).getProcessType();
            Intrinsics.checkNotNullExpressionValue(processType, "getProcessType(...)");
            return processType;
        }
    }

    public static final class i extends Lambda implements Function1<String, CharSequence> {
        public static final i a = new i();

        public i() {
            super(1);
        }

        public static String a(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return "— " + it + "\n";
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ CharSequence invoke(String str) {
            return a(str);
        }
    }

    public static final class j extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AuthFinishingSuccess.State b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(AuthFinishingSuccess.State state) {
            super(0);
            this.b = state;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            AuthFinishingSuccessFragment.this.getViewModel().handleAction(new AuthFinishingSuccess.Action.LoadAccount(AuthFinishingSuccessFragment.this.getProcessType(), ((AuthFinishingSuccess.State.ErrorAccount) this.b).getAccessToken(), AuthFinishingSuccessFragment.this.getBindSocialAccountResult()));
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function0<Unit> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            AuthFinishingSuccessFragment.this.getViewModel().handleAction(new AuthFinishingSuccess.Action.LoadAcquire(AuthFinishingSuccessFragment.this.getProcessType(), AuthFinishingSuccessFragment.this.getProcessId()));
            return Unit.INSTANCE;
        }
    }

    public static final class l extends Lambda implements Function0<ViewModelProvider.Factory> {
        public l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return AuthFinishingSuccessFragment.this.viewModelFactory;
        }
    }

    public AuthFinishingSuccessFragment(ViewModelProvider.Factory viewModelFactory, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.viewModelFactory = viewModelFactory;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        this.accessToken = LazyKt.lazy(new a());
        this.processId = LazyKt.lazy(new g());
        this.processType = LazyKt.lazy(new h());
        this.bindSocialAccountResult = LazyKt.lazy(new c());
        this.applicationInfo = LazyKt.lazy(new b());
        l lVar = new l();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccessFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccessFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccessFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccessFragment$special$$inlined$viewModels$default$4
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
    }

    private final String getAccessToken() {
        return (String) this.accessToken.getValue();
    }

    private final ApplicationInfo getApplicationInfo() {
        return (ApplicationInfo) this.applicationInfo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BindSocialAccountResult getBindSocialAccountResult() {
        return (BindSocialAccountResult) this.bindSocialAccountResult.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthFinishingSuccessBinding getBinding() {
        AuthFinishingSuccessBinding authFinishingSuccessBinding = this._binding;
        Intrinsics.checkNotNull(authFinishingSuccessBinding);
        return authFinishingSuccessBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getProcessId() {
        return (String) this.processId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProcessType getProcessType() {
        return (ProcessType) this.processType.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<AuthFinishingSuccess.State, AuthFinishingSuccess.Action, AuthFinishingSuccess.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void initErrorView() {
        EmptyStateLargeView emptyStateLargeView = getBinding().errorContainer;
        emptyStateLargeView.setIcon(AppCompatResources.getDrawable(requireContext(), R.drawable.ic_close_m));
        emptyStateLargeView.setAction(getString(R.string.auth_action_try_again));
    }

    private final void navigateToNextRegistrationStep(RegistrationProcess process) throws Resources.NotFoundException {
        BaseFragment.navigate$auth_release$default(this, process, (Function1) null, 2, (Object) null);
    }

    private final void navigateToNextStep(Process process) throws Resources.NotFoundException {
        BaseFragment.navigate$auth_release$default(this, process, (Function1) null, 2, (Object) null);
    }

    private final void setupContentView(ApplicationInfo applicationInfo) {
        getTopBar().getToolbar().setNavigationIcon((Drawable) null);
        ConstraintLayout constraintLayout = getBinding().contentContainer;
        getBinding().title.setText(getString(R.string.auth_allow_access_title));
        TextBodyView textBodyView = getBinding().subtitle;
        String string = getString(R.string.auth_allow_access_subtitle, applicationInfo.getTitle());
        List<Scope> scopes = applicationInfo.getScopes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = scopes.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((Scope) it.next()).getTitles());
        }
        textBodyView.setText(string + CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, i.a, 30, null));
        getBinding().primaryAction.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccessFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthFinishingSuccessFragment.setupContentView$lambda$5$lambda$2(this.f$0, view);
            }
        });
        getBinding().secondaryAction.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccessFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthFinishingSuccessFragment.setupContentView$lambda$5$lambda$4(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupContentView$lambda$5$lambda$2(AuthFinishingSuccessFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new AuthFinishingSuccess.Action.LoadAcquire(this$0.getProcessType(), this$0.getProcessId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupContentView$lambda$5$lambda$4(final AuthFinishingSuccessFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        YmAlertDialog.DialogContent dialogContent = new YmAlertDialog.DialogContent(this$0.getString(R.string.auth_allow_access_dialog_title), this$0.getString(R.string.auth_allow_access_dialog_message), this$0.getString(R.string.auth_allow_access_dialog_negative_action), this$0.getString(R.string.auth_allow_access_dialog_positive_action), true, false, 32, null);
        AlertDialog.Companion companion = AlertDialog.INSTANCE;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        final AlertDialog alertDialogCreate = companion.create(childFragmentManager, dialogContent);
        alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccessFragment$setupContentView$1$4$1$1
            @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
            public void onDismiss() {
                YmAlertDialog.DialogListener.DefaultImpls.onDismiss(this);
            }

            @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
            public void onNegativeClick() {
                this$0.getViewModel().handleAction(new AuthFinishingSuccess.Action.LoadAcquire(this$0.getProcessType(), this$0.getProcessId()));
            }

            @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
            public void onPositiveClick() throws Resources.NotFoundException {
                FragmentKt.findNavController(alertDialogCreate).navigate(this$0.getRouter().reset());
            }
        });
        FragmentManager childFragmentManager2 = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        alertDialogCreate.show(childFragmentManager2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(AuthFinishingSuccess.Effect effect) throws Resources.NotFoundException {
        if (effect instanceof AuthFinishingSuccess.Effect.ShowNextStep) {
            navigateToNextStep(((AuthFinishingSuccess.Effect.ShowNextStep) effect).getProcess());
            return;
        }
        if (effect instanceof AuthFinishingSuccess.Effect.ShowNextRegistrationStep) {
            navigateToNextRegistrationStep(((AuthFinishingSuccess.Effect.ShowNextRegistrationStep) effect).getProcess());
        } else if (effect instanceof AuthFinishingSuccess.Effect.Finish) {
            AuthFinishingSuccess.Effect.Finish finish = (AuthFinishingSuccess.Effect.Finish) effect;
            finishAuthWithResult$auth_release(finish.getAccessToken(), finish.getUserAccount(), getProcessType() == ProcessType.MIGRATION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(AuthFinishingSuccess.State state) {
        if (state instanceof AuthFinishingSuccess.State.Content) {
            setupContentView(((AuthFinishingSuccess.State.Content) state).getApplicationInfo());
            getBinding().stateFlipper.showContent();
            return;
        }
        if (state instanceof AuthFinishingSuccess.State.Progress) {
            getBinding().stateFlipper.showProgress();
            return;
        }
        if (state instanceof AuthFinishingSuccess.State.ErrorAccount) {
            getBinding().errorContainer.setSubtitle(getResourceMapper().map(((AuthFinishingSuccess.State.ErrorAccount) state).getFailure()));
            getBinding().errorContainer.setActionListener(new j(state));
        } else {
            if (!(state instanceof AuthFinishingSuccess.State.ErrorAcquire)) {
                return;
            }
            getBinding().errorContainer.setSubtitle(getResourceMapper().map(((AuthFinishingSuccess.State.ErrorAcquire) state).getFailure()));
            getBinding().errorContainer.setActionListener(new k());
        }
        getBinding().stateFlipper.showError();
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
        this._binding = AuthFinishingSuccessBinding.inflate(inflater, container, false);
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

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initErrorView();
        RuntimeViewModel<AuthFinishingSuccess.State, AuthFinishingSuccess.Action, AuthFinishingSuccess.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new d(this), new e(this), new f());
        String accessToken = getAccessToken();
        Intrinsics.checkNotNullExpressionValue(accessToken, "<get-accessToken>(...)");
        if (StringsKt.isBlank(accessToken)) {
            ApplicationInfo applicationInfo = getApplicationInfo();
            getViewModel().handleAction(applicationInfo != null ? new AuthFinishingSuccess.Action.LoadAppInfo(applicationInfo) : new AuthFinishingSuccess.Action.LoadAcquire(getProcessType(), getProcessId()));
            return;
        }
        RuntimeViewModel<AuthFinishingSuccess.State, AuthFinishingSuccess.Action, AuthFinishingSuccess.Effect> viewModel2 = getViewModel();
        ProcessType processType = getProcessType();
        String accessToken2 = getAccessToken();
        Intrinsics.checkNotNullExpressionValue(accessToken2, "<get-accessToken>(...)");
        viewModel2.handleAction(new AuthFinishingSuccess.Action.LoadAccount(processType, accessToken2, getBindSocialAccountResult()));
    }
}
