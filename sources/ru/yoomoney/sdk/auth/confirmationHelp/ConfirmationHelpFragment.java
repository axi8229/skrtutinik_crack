package ru.yoomoney.sdk.auth.confirmationHelp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.confirmationHelp.ConfirmationHelp;
import ru.yoomoney.sdk.auth.databinding.ConfirmationHelpBinding;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010.\u001a\u00020/H\u0014J\b\u00100\u001a\u00020/H\u0002J$\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020/H\u0016J\u001a\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010<\u001a\u00020/H\u0002J\u0010\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u00020)H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R1\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0&j\u0002`*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u001d\u001a\u0004\b+\u0010,R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lru/yoomoney/sdk/auth/confirmationHelp/ConfirmationHelpFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "config", "Lru/yoomoney/sdk/auth/Config;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Lru/yoomoney/sdk/auth/Config;Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/ConfirmationHelpBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/ConfirmationHelpBinding;", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "screenDescription", "", "getScreenDescription", "()Ljava/lang/String;", "screenDescription$delegate", "Lkotlin/Lazy;", "screenTitle", "getScreenTitle", "screenTitle$delegate", "topBar", "Lru/yoomoney/sdk/auth/ui/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/auth/ui/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/confirmationHelp/ConfirmationHelp$State;", "Lru/yoomoney/sdk/auth/confirmationHelp/ConfirmationHelp$Action;", "Lru/yoomoney/sdk/auth/confirmationHelp/ConfirmationHelp$Effect;", "Lru/yoomoney/sdk/auth/confirmationHelp/ConfirmationHelpViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "back", "", "initToolbar", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupViews", "showEffect", "effect", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConfirmationHelpFragment extends BaseFragment {
    private ConfirmationHelpBinding _binding;
    private final Config config;
    private final ProcessMapper processMapper;
    private final ResourceMapper resourceMapper;
    private final Router router;

    /* renamed from: screenDescription$delegate, reason: from kotlin metadata */
    private final Lazy screenDescription;

    /* renamed from: screenTitle$delegate, reason: from kotlin metadata */
    private final Lazy screenTitle;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public static final class a extends Lambda implements Function1<ConfirmationHelp.State, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(ConfirmationHelp.State state) {
            ConfirmationHelp.State it = state;
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<ConfirmationHelp.Effect, Unit> {
        public b(Object obj) {
            super(1, obj, ConfirmationHelpFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/confirmationHelp/ConfirmationHelp$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(ConfirmationHelp.Effect effect) {
            ConfirmationHelp.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ConfirmationHelpFragment) this.receiver).showEffect(p0);
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
            ConstraintLayout parent = ConfirmationHelpFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = ConfirmationHelpFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0<String> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String description = ConfirmationHelpFragmentArgs.fromBundle(ConfirmationHelpFragment.this.requireArguments()).getDescription();
            Intrinsics.checkNotNullExpressionValue(description, "getDescription(...)");
            return description;
        }
    }

    public static final class e extends Lambda implements Function0<String> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String title = ConfirmationHelpFragmentArgs.fromBundle(ConfirmationHelpFragment.this.requireArguments()).getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
            return title;
        }
    }

    public static final class f extends Lambda implements Function0<ViewModelProvider.Factory> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return ConfirmationHelpFragment.this.viewModelFactory;
        }
    }

    public ConfirmationHelpFragment(Config config, ViewModelProvider.Factory viewModelFactory, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.config = config;
        this.viewModelFactory = viewModelFactory;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        f fVar = new f();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.confirmationHelp.ConfirmationHelpFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.confirmationHelp.ConfirmationHelpFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.confirmationHelp.ConfirmationHelpFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.confirmationHelp.ConfirmationHelpFragment$special$$inlined$viewModels$default$4
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
        }, fVar);
        this.screenTitle = LazyKt.lazy(new e());
        this.screenDescription = LazyKt.lazy(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConfirmationHelpBinding getBinding() {
        ConfirmationHelpBinding confirmationHelpBinding = this._binding;
        Intrinsics.checkNotNull(confirmationHelpBinding);
        return confirmationHelpBinding;
    }

    private final String getScreenDescription() {
        return (String) this.screenDescription.getValue();
    }

    private final String getScreenTitle() {
        return (String) this.screenTitle.getValue();
    }

    private final RuntimeViewModel<ConfirmationHelp.State, ConfirmationHelp.Action, ConfirmationHelp.Effect> getViewModel() {
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

    private final void setupViews() {
        getBinding().title.setText(getScreenTitle());
        getBinding().subtitle.setText(getScreenDescription());
        if (this.config.getConfirmationHelpActionVisible()) {
            FrameLayout actionContainer = getBinding().actionContainer;
            Intrinsics.checkNotNullExpressionValue(actionContainer, "actionContainer");
            ViewExtensions.show(actionContainer);
            getBinding().action.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.confirmationHelp.ConfirmationHelpFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConfirmationHelpFragment.setupViews$lambda$1(this.f$0, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$1(ConfirmationHelpFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(ConfirmationHelp.Action.ShowSupport.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(ConfirmationHelp.Effect effect) {
        if (effect instanceof ConfirmationHelp.Effect.ShowSupport) {
            View viewRequireView = requireView();
            Intrinsics.checkNotNullExpressionValue(viewRequireView, "requireView(...)");
            CoreFragmentExtensions.openLinkInBrowser(this, viewRequireView, ConfirmationHelpFragmentKt.FEEDBACK_URL);
        }
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public void back() {
        FragmentKt.findNavController(this).popBackStack();
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
        TopBarDefault appBar = getBinding().appBar;
        Intrinsics.checkNotNullExpressionValue(appBar, "appBar");
        return appBar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = ConfirmationHelpBinding.inflate(inflater, container, false);
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
        initToolbar();
        setupViews();
        RuntimeViewModel<ConfirmationHelp.State, ConfirmationHelp.Action, ConfirmationHelp.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, a.a, new b(this), new c());
    }
}
