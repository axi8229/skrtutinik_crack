package ru.yoomoney.sdk.auth.yandexAcquire.login;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
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
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthYandexAcquireHasMigratedBinding;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.yandexAcquire.login.YandexAcquireLogin;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020-H\u0016J\u001a\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u001eH\u0002J\u0010\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020\u001cH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R1\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001bj\u0002`\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLoginFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthYandexAcquireHasMigratedBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthYandexAcquireHasMigratedBinding;", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$State;", "Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$Action;", "Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$Effect;", "Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLoginViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "showEffect", "effect", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class YandexAcquireLoginFragment extends BaseFragment {
    private AuthYandexAcquireHasMigratedBinding _binding;
    private final ProcessMapper processMapper;
    private final ResourceMapper resourceMapper;
    private final Router router;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<YandexAcquireLogin.State, Unit> {
        public a(Object obj) {
            super(1, obj, YandexAcquireLoginFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(YandexAcquireLogin.State state) {
            YandexAcquireLogin.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((YandexAcquireLoginFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<YandexAcquireLogin.Effect, Unit> {
        public b(Object obj) {
            super(1, obj, YandexAcquireLoginFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/yandexAcquire/login/YandexAcquireLogin$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(YandexAcquireLogin.Effect effect) throws Resources.NotFoundException {
            YandexAcquireLogin.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((YandexAcquireLoginFragment) this.receiver).showEffect(p0);
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
            ConstraintLayout parent = YandexAcquireLoginFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = YandexAcquireLoginFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0<ViewModelProvider.Factory> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return YandexAcquireLoginFragment.this.viewModelFactory;
        }
    }

    public YandexAcquireLoginFragment(ViewModelProvider.Factory viewModelFactory, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.viewModelFactory = viewModelFactory;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        d dVar = new d();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.login.YandexAcquireLoginFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.login.YandexAcquireLoginFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.login.YandexAcquireLoginFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.login.YandexAcquireLoginFragment$special$$inlined$viewModels$default$4
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
        }, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthYandexAcquireHasMigratedBinding getBinding() {
        AuthYandexAcquireHasMigratedBinding authYandexAcquireHasMigratedBinding = this._binding;
        Intrinsics.checkNotNull(authYandexAcquireHasMigratedBinding);
        return authYandexAcquireHasMigratedBinding;
    }

    private final RuntimeViewModel<YandexAcquireLogin.State, YandexAcquireLogin.Action, YandexAcquireLogin.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(YandexAcquireLoginFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(YandexAcquireLogin.Action.Confirm.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(YandexAcquireLogin.Effect effect) throws Resources.NotFoundException {
        if (effect instanceof YandexAcquireLogin.Effect.ShowNextStep) {
            BaseFragment.navigate$auth_release$default(this, ((YandexAcquireLogin.Effect.ShowNextStep) effect).getProcess(), (Function1) null, 2, (Object) null);
        } else if (effect instanceof YandexAcquireLogin.Effect.ShowFailure) {
            ConstraintLayout parent = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            CoreFragmentExtensions.noticeError(parent, getResourceMapper().map(((YandexAcquireLogin.Effect.ShowFailure) effect).getFailure()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(YandexAcquireLogin.State state) {
        PrimaryButtonView primaryButtonView;
        boolean z;
        if (Intrinsics.areEqual(state, YandexAcquireLogin.State.Content.INSTANCE)) {
            primaryButtonView = getBinding().action;
            z = false;
        } else {
            if (!Intrinsics.areEqual(state, YandexAcquireLogin.State.Progress.INSTANCE)) {
                return;
            }
            primaryButtonView = getBinding().action;
            z = true;
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
        this._binding = AuthYandexAcquireHasMigratedBinding.inflate(inflater, container, false);
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
        getBinding().title.setText(getString(R.string.auth_yandex_acquire_login_screen_title));
        getBinding().text.setText(getString(R.string.auth_yandex_acquire_login_text));
        getBinding().action.setText(getString(R.string.auth_yandex_acquire_login_ok));
        getBinding().action.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.yandexAcquire.login.YandexAcquireLoginFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YandexAcquireLoginFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        RuntimeViewModel<YandexAcquireLogin.State, YandexAcquireLogin.Action, YandexAcquireLogin.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new a(this), new b(this), new c());
    }
}
