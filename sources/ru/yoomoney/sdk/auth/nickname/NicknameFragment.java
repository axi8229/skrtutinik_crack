package ru.yoomoney.sdk.auth.nickname;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Iterator;
import java.util.List;
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
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.IllegalParametersFailure;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthNicknameBinding;
import ru.yoomoney.sdk.auth.nickname.Nickname;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010.\u001a\u00020/H\u0014J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u0016H\u0002J\u0018\u00105\u001a\u00020/2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0017J$\u0010:\u001a\u00020;2\u0006\u00108\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010A\u001a\u00020/H\u0016J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0017J\u001a\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020;2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010H\u001a\u00020/H\u0002J\u0010\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020)H\u0002J\u0010\u0010K\u001a\u00020/2\u0006\u0010L\u001a\u00020'H\u0002R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R1\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0&j\u0002`*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u001a\u001a\u0004\b+\u0010,R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lru/yoomoney/sdk/auth/nickname/NicknameFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "config", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Lru/yoomoney/sdk/auth/ResultData;Landroidx/lifecycle/ViewModelProvider$Factory;Lkotlin/Lazy;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthNicknameBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthNicknameBinding;", "currentNickname", "", "getCurrentNickname", "()Ljava/lang/String;", "currentNickname$delegate", "Lkotlin/Lazy;", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/auth/ui/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/auth/ui/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/nickname/Nickname$State;", "Lru/yoomoney/sdk/auth/nickname/Nickname$Action;", "Lru/yoomoney/sdk/auth/nickname/Nickname$Effect;", "Lru/yoomoney/sdk/auth/nickname/NicknameViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "back", "", "getErrorMessage", "", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "getSuccessMessage", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "setupViews", "showEffect", "effect", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NicknameFragment extends BaseFragment {
    private AuthNicknameBinding _binding;
    private final Lazy<Config> config;

    /* renamed from: currentNickname$delegate, reason: from kotlin metadata */
    private final Lazy currentNickname;
    private final ProcessMapper processMapper;
    private final ResourceMapper resourceMapper;
    private final ResultData resultData;
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
            return NicknameFragmentArgs.fromBundle(NicknameFragment.this.requireArguments()).getNickname();
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<Nickname.State, Unit> {
        public b(Object obj) {
            super(1, obj, NicknameFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/nickname/Nickname$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Nickname.State state) {
            Nickname.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((NicknameFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<Nickname.Effect, Unit> {
        public c(Object obj) {
            super(1, obj, NicknameFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/nickname/Nickname$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Nickname.Effect effect) throws Resources.NotFoundException {
            Nickname.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((NicknameFragment) this.receiver).showEffect(p0);
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
            ConstraintLayout parent = NicknameFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = NicknameFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function0<ViewModelProvider.Factory> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return NicknameFragment.this.viewModelFactory;
        }
    }

    public NicknameFragment(ResultData resultData, ViewModelProvider.Factory viewModelFactory, Lazy<Config> config, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.resultData = resultData;
        this.viewModelFactory = viewModelFactory;
        this.config = config;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        e eVar = new e();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.nickname.NicknameFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.nickname.NicknameFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.nickname.NicknameFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.nickname.NicknameFragment$special$$inlined$viewModels$default$4
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
        this.currentNickname = LazyKt.lazy(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthNicknameBinding getBinding() {
        AuthNicknameBinding authNicknameBinding = this._binding;
        Intrinsics.checkNotNull(authNicknameBinding);
        return authNicknameBinding;
    }

    private final String getCurrentNickname() {
        return (String) this.currentNickname.getValue();
    }

    private final CharSequence getErrorMessage(Failure failure) {
        List<String> parameterNames;
        Object next;
        if ((failure instanceof IllegalParametersFailure) && (parameterNames = ((IllegalParametersFailure) failure).getParameterNames()) != null) {
            Iterator<T> it = parameterNames.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual((String) next, AppMeasurementSdk.ConditionalUserProperty.VALUE)) {
                    break;
                }
            }
            if (((String) next) != null) {
                String string = getString(R.string.auth_nickname_illegal_nickname_error);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
        }
        return getResourceMapper().map(failure);
    }

    private final String getSuccessMessage() {
        String string = getCurrentNickname() != null ? getString(R.string.auth_nickname_new_name_success_message) : null;
        if (string != null) {
            return string;
        }
        String string2 = getString(R.string.auth_nickname_create_name_success_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        return string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<Nickname.State, Nickname.Action, Nickname.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void setupViews() {
        String string;
        TextTitle1View textTitle1View = getBinding().title;
        if (getCurrentNickname() == null || (string = getString(R.string.auth_nickname_title_change_name)) == null) {
            string = getString(R.string.auth_nickname_title_new_name);
        }
        textTitle1View.setText(string);
        getBinding().nickname.setLabel(getString(R.string.auth_nickname_input_label));
        getBinding().action.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.nickname.NicknameFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NicknameFragment.setupViews$lambda$1(this.f$0, view);
            }
        });
        getBinding().nickname.getEditText().addTextChangedListener(new TextWatcher() { // from class: ru.yoomoney.sdk.auth.nickname.NicknameFragment$setupViews$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.this$0.getViewModel().handleAction(new Nickname.Action.NicknameChanged(String.valueOf(s)));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$1(NicknameFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RuntimeViewModel<Nickname.State, Nickname.Action, Nickname.Effect> viewModel = this$0.getViewModel();
        String accessToken = this$0.config.getValue().getAccessToken();
        if (accessToken == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        viewModel.handleAction(new Nickname.Action.Submit(accessToken));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(Nickname.Effect effect) throws Resources.NotFoundException {
        if (effect instanceof Nickname.Effect.Finish) {
            this.resultData.setUserAccountWasUpdated(true);
            FragmentKt.findNavController(this).navigate(R.id.passportProfileFragment, BundleKt.bundleOf(TuplesKt.to("account", ((Nickname.Effect.Finish) effect).getUserAccount()), TuplesKt.to("successMessage", getSuccessMessage())), getNavOptions());
        } else if (effect instanceof Nickname.Effect.ShowError) {
            ConstraintLayout parent = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            CoreFragmentExtensions.noticeError(parent, getErrorMessage(((Nickname.Effect.ShowError) effect).getFailure()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(Nickname.State state) {
        if (state instanceof Nickname.State.Content) {
            getBinding().nickname.setEnabled(true);
            getBinding().action.showProgress(false);
            getBinding().action.setEnabled(((Nickname.State.Content) state).getNewNickname().length() > 0);
        } else if (state instanceof Nickname.State.Progress) {
            getBinding().action.showProgress(true);
            getBinding().nickname.setEnabled(false);
        }
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment
    public void back() {
        FragmentKt.findNavController(this).popBackStack(R.id.passportProfileFragment, false);
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
    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        inflater.inflate(R.menu.auth_menu_nickname, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthNicknameBinding.inflate(inflater, container, false);
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
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == R.id.cancel) {
            back();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupViews();
        RuntimeViewModel<Nickname.State, Nickname.Action, Nickname.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new b(this), new c(this), new d());
    }
}
