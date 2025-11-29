package ru.yoomoney.sdk.auth.password.finish;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import okhttp3.internal.http2.Http2Connection;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjmedia_tp_proto;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthPasswordFinishBinding;
import ru.yoomoney.sdk.auth.password.finish.PasswordFinish;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.EmptyStateLargeView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010+\u001a\u00020,H\u0014J\u0014\u0010-\u001a\u00020,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/H\u0002J\"\u00100\u001a\u00020,2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\b\u0010.\u001a\u0004\u0018\u00010/H\u0017J$\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020,H\u0016J\u001a\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u0002052\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010?\u001a\u00020,H\u0002J\u0010\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020&H\u0002J\u0010\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020$H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R1\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0#j\u0002`'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0019\u001a\u0004\b(\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lru/yoomoney/sdk/auth/password/finish/PasswordFinishFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "config", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthPasswordFinishBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthPasswordFinishBinding;", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "Lkotlin/Lazy;", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$State;", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$Action;", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$Effect;", "Lru/yoomoney/sdk/auth/password/finish/PasswordFinishViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "back", "", "finishProcess", RemoteMessageConst.DATA, "Landroid/content/Intent;", "onActivityResult", "requestCode", "", "resultCode", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupIconClose", "showEffect", "effect", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordFinishFragment extends BaseFragment {
    private AuthPasswordFinishBinding _binding;
    private final Config config;
    private final ProcessMapper processMapper;

    /* renamed from: processType$delegate, reason: from kotlin metadata */
    private final Lazy processType;
    private final ResourceMapper resourceMapper;
    private final Router router;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<PasswordFinish.State, Unit> {
        public a(Object obj) {
            super(1, obj, PasswordFinishFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PasswordFinish.State state) {
            PasswordFinish.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PasswordFinishFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<PasswordFinish.Effect, Unit> {
        public b(Object obj) {
            super(1, obj, PasswordFinishFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/password/finish/PasswordFinish$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PasswordFinish.Effect effect) throws Resources.NotFoundException {
            PasswordFinish.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PasswordFinishFragment) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Throwable, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            ConstraintLayout parent = PasswordFinishFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = PasswordFinishFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0<ProcessType> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ProcessType invoke() {
            Bundle arguments = PasswordFinishFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            ProcessType processType = PasswordFinishFragmentArgs.fromBundle(arguments).getProcessType();
            Intrinsics.checkNotNullExpressionValue(processType, "getProcessType(...)");
            return processType;
        }
    }

    public static final class e extends Lambda implements Function0<ViewModelProvider.Factory> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return PasswordFinishFragment.this.viewModelFactory;
        }
    }

    public PasswordFinishFragment(ViewModelProvider.Factory viewModelFactory, Config config, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
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
        e eVar = new e();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.password.finish.PasswordFinishFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.password.finish.PasswordFinishFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.password.finish.PasswordFinishFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.password.finish.PasswordFinishFragment$special$$inlined$viewModels$default$4
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
        }, eVar);
        this.processType = LazyKt.lazy(new d());
    }

    private final void finishProcess(Intent data) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(100, data);
            activity.finish();
        }
    }

    public static /* synthetic */ void finishProcess$default(PasswordFinishFragment passwordFinishFragment, Intent intent, int i, Object obj) {
        if ((i & 1) != 0) {
            intent = null;
        }
        passwordFinishFragment.finishProcess(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthPasswordFinishBinding getBinding() {
        AuthPasswordFinishBinding authPasswordFinishBinding = this._binding;
        Intrinsics.checkNotNull(authPasswordFinishBinding);
        return authPasswordFinishBinding;
    }

    private final ProcessType getProcessType() {
        return (ProcessType) this.processType.getValue();
    }

    private final RuntimeViewModel<PasswordFinish.State, PasswordFinish.Action, PasswordFinish.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void setupIconClose() {
        ActionBar supportActionBar;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        AppCompatActivity appCompatActivity = fragmentActivityRequireActivity instanceof AppCompatActivity ? (AppCompatActivity) fragmentActivityRequireActivity : null;
        if (appCompatActivity == null || (supportActionBar = appCompatActivity.getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.setHomeAsUpIndicator(R.drawable.ic_close_m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(PasswordFinish.Effect effect) throws Resources.NotFoundException {
        if (!Intrinsics.areEqual(effect, PasswordFinish.Effect.ShowLogin.INSTANCE)) {
            if (effect instanceof PasswordFinish.Effect.FinishWithResult) {
                finishProcess(((PasswordFinish.Effect.FinishWithResult) effect).getData());
            }
        } else {
            if (this.config.getProductType() == Config.ProductType.WEBBANKIR) {
                FragmentKt.findNavController(this).navigate(R.id.authLoadingFragment, BundleKt.bundleOf(TuplesKt.to("isForcedRegistration", Boolean.FALSE)), getNavOptions());
                return;
            }
            YooMoneyAuth yooMoneyAuth = YooMoneyAuth.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            Config config = this.config;
            startActivityForResult(yooMoneyAuth.auth(contextRequireContext, config.copy(((-65) & 1) != 0 ? config.origin : null, ((-65) & 2) != 0 ? config.authCenterClientId : null, ((-65) & 4) != 0 ? config.authCenterClientSecret : null, ((-65) & 8) != 0 ? config.yandexClientId : null, ((-65) & 16) != 0 ? config.accessToken : null, ((-65) & 32) != 0 ? config.yandexPassportToken : null, ((-65) & 64) != 0 ? config.processType : Config.ProcessType.LOGIN, ((-65) & 128) != 0 ? config.productType : null, ((-65) & 256) != 0 ? config.phoneIdentifier : null, ((-65) & 512) != 0 ? config.style : null, ((-65) & 1024) != 0 ? config.apiHost : null, ((-65) & 2048) != 0 ? config.isDebugMode : false, ((-65) & 4096) != 0 ? config.supportEmail : null, ((-65) & 8192) != 0 ? config.supportHelpUrl : null, ((-65) & 16384) != 0 ? config.supportPhone : null, ((-65) & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? config.migrationBannerVisible : false, ((-65) & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? config.migrationBannerText : null, ((-65) & 131072) != 0 ? config.migrationBannerTextColor : null, ((-65) & 262144) != 0 ? config.migrationBannerButtonText : null, ((-65) & 524288) != 0 ? config.migrationBannerImageUrl : null, ((-65) & 1048576) != 0 ? config.applicationUserAgent : null, ((-65) & 2097152) != 0 ? config.remoteConfig : null, ((-65) & 4194304) != 0 ? config.prefilledData : null, ((-65) & 8388608) != 0 ? config.enableAutoEnrollment : false, ((-65) & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? config.oauthParams : null, ((-65) & 33554432) != 0 ? config.qrAuthConfig : null, ((-65) & 67108864) != 0 ? config.identificationAccessible : false, ((-65) & 134217728) != 0 ? config.confirmationHelpActionVisible : false, ((-65) & 268435456) != 0 ? config.availableSocialAccounts : null, ((-65) & 536870912) != 0 ? config.loginContextId : null, ((-65) & pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH) != 0 ? config.emailFillingReason : null, ((-65) & Integer.MIN_VALUE) != 0 ? config.showServices : false)), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(PasswordFinish.State state) {
        if (!(state instanceof PasswordFinish.State.Content)) {
            if (state instanceof PasswordFinish.State.Login) {
                ConstraintLayout parent = getBinding().parent;
                Intrinsics.checkNotNullExpressionValue(parent, "parent");
                parent.setVisibility(8);
                return;
            }
            return;
        }
        ConstraintLayout parent2 = getBinding().parent;
        Intrinsics.checkNotNullExpressionValue(parent2, "parent");
        parent2.setVisibility(0);
        EmptyStateLargeView emptyStateLargeView = getBinding().content;
        emptyStateLargeView.setTitle(getString(R.string.auth_change_password_finish_title));
        emptyStateLargeView.setSubtitle(getString(R.string.auth_change_password_finish_text));
        emptyStateLargeView.setIcon(AppCompatResources.getDrawable(requireContext(), R.drawable.ic_apply_m));
        getBinding().button.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.password.finish.PasswordFinishFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PasswordFinishFragment.showState$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showState$lambda$1(PasswordFinishFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(PasswordFinish.Action.Login.INSTANCE);
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public void back() {
        finishProcess$default(this, null, 1, null);
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
    @Deprecated
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        RuntimeViewModel<PasswordFinish.State, PasswordFinish.Action, PasswordFinish.Effect> viewModel;
        PasswordFinish.Action closeWithResult;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 1 || resultCode != -1) {
            viewModel = getViewModel();
            closeWithResult = PasswordFinish.Action.CancelLogin.INSTANCE;
        } else {
            if (data == null) {
                return;
            }
            viewModel = getViewModel();
            closeWithResult = new PasswordFinish.Action.CloseWithResult(data);
        }
        viewModel.handleAction(closeWithResult);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthPasswordFinishBinding.inflate(inflater, container, false);
        ConstraintLayout root = getBinding().getRoot();
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
        setupIconClose();
        RuntimeViewModel<PasswordFinish.State, PasswordFinish.Action, PasswordFinish.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new a(this), new b(this), new c());
        if (savedInstanceState == null) {
            getViewModel().handleAction(new PasswordFinish.Action.SendAnalyticsForScreen(getProcessType()));
            getViewModel().handleAction(PasswordFinish.Action.ShowContent.INSTANCE);
        }
    }
}
