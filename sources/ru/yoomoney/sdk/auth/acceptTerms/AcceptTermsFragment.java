package ru.yoomoney.sdk.auth.acceptTerms;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Deprecated;
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
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.acceptTerms.AcceptTerms;
import ru.yoomoney.sdk.auth.acceptTerms.impl.AcceptTermsViewModelFactory;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AcceptTermsBinding;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.utils.StringExtensionsKt;
import ru.yoomoney.sdk.auth.utils.TextViewExtentionsKt;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle2View;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000206H\u0002J$\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u000206H\u0016J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0017J\u001a\u0010E\u001a\u0002062\u0006\u0010F\u001a\u0002092\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010G\u001a\u0002062\u0006\u0010H\u001a\u000200H\u0002J\u0010\u0010I\u001a\u0002062\u0006\u0010J\u001a\u00020.H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b!\u0010\"R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R1\u0010,\u001a\u0018\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000-j\u0002`18BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0017\u001a\u0004\b2\u00103R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lru/yoomoney/sdk/auth/acceptTerms/AcceptTermsFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "viewModelFactory", "Lru/yoomoney/sdk/auth/acceptTerms/impl/AcceptTermsViewModelFactory;", "config", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Lru/yoomoney/sdk/auth/acceptTerms/impl/AcceptTermsViewModelFactory;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AcceptTermsBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AcceptTermsBinding;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "getProcessId", "()Ljava/lang/String;", "processId$delegate", "Lkotlin/Lazy;", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "remoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "getRemoteConfig", "()Lru/yoomoney/sdk/auth/RemoteConfig;", "remoteConfig$delegate", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$State;", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$Action;", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$Effect;", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTermsViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "initToolbar", "", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "showEffect", "effect", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AcceptTermsFragment extends BaseFragment {
    private AcceptTermsBinding _binding;
    private final Config config;

    /* renamed from: processId$delegate, reason: from kotlin metadata */
    private final Lazy processId;
    private final ProcessMapper processMapper;

    /* renamed from: processType$delegate, reason: from kotlin metadata */
    private final Lazy processType;

    /* renamed from: remoteConfig$delegate, reason: from kotlin metadata */
    private final Lazy remoteConfig;
    private final ResourceMapper resourceMapper;
    private final Router router;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final AcceptTermsViewModelFactory viewModelFactory;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<AcceptTerms.State, Unit> {
        public a(Object obj) {
            super(1, obj, AcceptTermsFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(AcceptTerms.State state) {
            AcceptTerms.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AcceptTermsFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<AcceptTerms.Effect, Unit> {
        public b(Object obj) {
            super(1, obj, AcceptTermsFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(AcceptTerms.Effect effect) throws Resources.NotFoundException {
            AcceptTerms.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((AcceptTermsFragment) this.receiver).showEffect(p0);
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
            LinearLayout root = AcceptTermsFragment.this.getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            String string = AcceptTermsFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(root, string);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0<String> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String processId = AcceptTermsFragmentArgs.fromBundle(AcceptTermsFragment.this.requireArguments()).getProcessId();
            Intrinsics.checkNotNullExpressionValue(processId, "getProcessId(...)");
            return processId;
        }
    }

    public static final class e extends Lambda implements Function0<ProcessType> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ProcessType invoke() {
            Bundle arguments = AcceptTermsFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            ProcessType processType = AcceptTermsFragmentArgs.fromBundle(arguments).getProcessType();
            Intrinsics.checkNotNullExpressionValue(processType, "getProcessType(...)");
            return processType;
        }
    }

    public static final class f extends Lambda implements Function0<RemoteConfig> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final RemoteConfig invoke() {
            return AcceptTermsFragment.this.config.getRemoteConfig();
        }
    }

    public static final class g extends Lambda implements Function0<ViewModelProvider.Factory> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return AcceptTermsFragment.this.viewModelFactory;
        }
    }

    public AcceptTermsFragment(AcceptTermsViewModelFactory viewModelFactory, Config config, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
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
        g gVar = new g();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.acceptTerms.AcceptTermsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.acceptTerms.AcceptTermsFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.acceptTerms.AcceptTermsFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.acceptTerms.AcceptTermsFragment$special$$inlined$viewModels$default$4
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
        this.processId = LazyKt.lazy(new d());
        this.processType = LazyKt.lazy(new e());
        this.remoteConfig = LazyKt.lazy(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AcceptTermsBinding getBinding() {
        AcceptTermsBinding acceptTermsBinding = this._binding;
        Intrinsics.checkNotNull(acceptTermsBinding);
        return acceptTermsBinding;
    }

    private final String getProcessId() {
        return (String) this.processId.getValue();
    }

    private final ProcessType getProcessType() {
        return (ProcessType) this.processType.getValue();
    }

    private final RemoteConfig getRemoteConfig() {
        return (RemoteConfig) this.remoteConfig.getValue();
    }

    private final RuntimeViewModel<AcceptTerms.State, AcceptTerms.Action, AcceptTerms.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void initToolbar() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle("");
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_close_m);
        }
    }

    private final void initView() {
        String acceptTermsScreenDescription;
        AcceptTermsBinding binding = getBinding();
        TextTitle2View textTitle2View = binding.title;
        RemoteConfig remoteConfig = getRemoteConfig();
        textTitle2View.setText(remoteConfig != null ? remoteConfig.getAcceptTermsScreenTitle() : null);
        TextBodyView textBodyView = binding.description;
        RemoteConfig remoteConfig2 = getRemoteConfig();
        textBodyView.setText((remoteConfig2 == null || (acceptTermsScreenDescription = remoteConfig2.getAcceptTermsScreenDescription()) == null) ? null : StringExtensionsKt.parseHtml(acceptTermsScreenDescription));
        textBodyView.setMovementMethod(LinkMovementMethod.getInstance());
        ColorScheme colorScheme = ColorScheme.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        textBodyView.setLinkTextColor(colorScheme.getAccentColor(contextRequireContext));
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        textBodyView.setHighlightColor(colorScheme.getAccentGhostColor(contextRequireContext2));
        Intrinsics.checkNotNull(textBodyView);
        TextViewExtentionsKt.removeLinkUnderline(textBodyView);
        PrimaryButtonView primaryButtonView = binding.action;
        RemoteConfig remoteConfig3 = getRemoteConfig();
        primaryButtonView.setText(remoteConfig3 != null ? remoteConfig3.getAcceptTermsScreenActionText() : null);
        binding.action.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.acceptTerms.AcceptTermsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AcceptTermsFragment.initView$lambda$3$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(AcceptTermsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new AcceptTerms.Action.Accept(this$0.getProcessId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(AcceptTerms.Effect effect) throws Resources.NotFoundException {
        if (effect instanceof AcceptTerms.Effect.ShowEnrollment) {
            BaseFragment.navigate$auth_release$default(this, ((AcceptTerms.Effect.ShowEnrollment) effect).getProcess(), (Function1) null, 2, (Object) null);
        } else if (effect instanceof AcceptTerms.Effect.ShowError) {
            ConstraintLayout parent = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            CoreFragmentExtensions.noticeError(parent, getResourceMapper().map(((AcceptTerms.Effect.ShowError) effect).getFailure()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(AcceptTerms.State state) {
        PrimaryButtonView primaryButtonView;
        boolean z;
        if (state instanceof AcceptTerms.State.Progress) {
            primaryButtonView = getBinding().action;
            z = true;
        } else {
            if (!(state instanceof AcceptTerms.State.Content)) {
                return;
            }
            primaryButtonView = getBinding().action;
            z = false;
        }
        primaryButtonView.showProgress(z);
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
        this._binding = AcceptTermsBinding.inflate(inflater, container, false);
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
        RuntimeViewModel<AcceptTerms.State, AcceptTerms.Action, AcceptTerms.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new a(this), new b(this), new c());
        initToolbar();
        initView();
        getViewModel().handleAction(new AcceptTerms.Action.SendAnalyticsForScreen(getProcessType()));
    }
}
