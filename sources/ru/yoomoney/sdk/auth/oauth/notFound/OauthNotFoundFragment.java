package ru.yoomoney.sdk.auth.oauth.notFound;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
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
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.api.model.ErrorOauthAccountNotConnected;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthOauthNotFoundBinding;
import ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.SecondaryButtonView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;
import ru.yoomoney.sdk.gui.widgetV2.list.item_tag_large.ItemImageRoundTagLargeView;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u00100\u001a\u000201H\u0002J$\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u000201H\u0016J\u001a\u0010;\u001a\u0002012\u0006\u0010<\u001a\u0002032\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010=\u001a\u000201H\u0002J\u0010\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020+H\u0002J\u0010\u0010@\u001a\u0002012\u0006\u0010A\u001a\u00020)H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R1\u0010'\u001a\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0(j\u0002`,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0017\u001a\u0004\b-\u0010.R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFoundFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "remoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Lru/yoomoney/sdk/auth/RemoteConfig;Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthOauthNotFoundBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthOauthNotFoundBinding;", "processError", "Lru/yoomoney/sdk/auth/api/model/ErrorOauthAccountNotConnected;", "getProcessError", "()Lru/yoomoney/sdk/auth/api/model/ErrorOauthAccountNotConnected;", "processError$delegate", "Lkotlin/Lazy;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "getProcessId", "()Ljava/lang/String;", "processId$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$State;", "Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$Action;", "Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$Effect;", "Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFoundViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "initViews", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupIconClose", "showEffect", "effect", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OauthNotFoundFragment extends BaseFragment {
    private AuthOauthNotFoundBinding _binding;

    /* renamed from: processError$delegate, reason: from kotlin metadata */
    private final Lazy processError;

    /* renamed from: processId$delegate, reason: from kotlin metadata */
    private final Lazy processId;
    private final ProcessMapper processMapper;
    private final RemoteConfig remoteConfig;
    private final ResourceMapper resourceMapper;
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

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<OauthNotFound.State, Unit> {
        public a(Object obj) {
            super(1, obj, OauthNotFoundFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(OauthNotFound.State state) {
            OauthNotFound.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((OauthNotFoundFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<OauthNotFound.Effect, Unit> {
        public b(Object obj) {
            super(1, obj, OauthNotFoundFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(OauthNotFound.Effect effect) throws Resources.NotFoundException {
            OauthNotFound.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((OauthNotFoundFragment) this.receiver).showEffect(p0);
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
            ConstraintLayout parent = OauthNotFoundFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = OauthNotFoundFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0<ErrorOauthAccountNotConnected> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ErrorOauthAccountNotConnected invoke() {
            ProcessError processError = OauthNotFoundFragmentArgs.fromBundle(OauthNotFoundFragment.this.requireArguments()).getProcessError();
            Intrinsics.checkNotNull(processError, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.ErrorOauthAccountNotConnected");
            return (ErrorOauthAccountNotConnected) processError;
        }
    }

    public static final class e extends Lambda implements Function0<String> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String processId = OauthNotFoundFragmentArgs.fromBundle(OauthNotFoundFragment.this.requireArguments()).getProcessId();
            Intrinsics.checkNotNullExpressionValue(processId, "getProcessId(...)");
            return processId;
        }
    }

    public static final class f extends Lambda implements Function0<ViewModelProvider.Factory> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return OauthNotFoundFragment.this.viewModelFactory;
        }
    }

    public OauthNotFoundFragment(RemoteConfig remoteConfig, ViewModelProvider.Factory viewModelFactory, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.remoteConfig = remoteConfig;
        this.viewModelFactory = viewModelFactory;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        f fVar = new f();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFoundFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFoundFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFoundFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFoundFragment$special$$inlined$viewModels$default$4
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
        this.processId = LazyKt.lazy(new e());
        this.processError = LazyKt.lazy(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthOauthNotFoundBinding getBinding() {
        AuthOauthNotFoundBinding authOauthNotFoundBinding = this._binding;
        Intrinsics.checkNotNull(authOauthNotFoundBinding);
        return authOauthNotFoundBinding;
    }

    private final ErrorOauthAccountNotConnected getProcessError() {
        return (ErrorOauthAccountNotConnected) this.processError.getValue();
    }

    private final String getProcessId() {
        return (String) this.processId.getValue();
    }

    private final RuntimeViewModel<OauthNotFound.State, OauthNotFound.Action, OauthNotFound.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void initViews() {
        int i;
        String strMapServiceProviderToStringName = getResourceMapper().mapServiceProviderToStringName(getProcessError().getService());
        TextTitle1View textTitle1View = getBinding().title;
        String oauthNotFoundTitle = this.remoteConfig.getOauthNotFoundTitle();
        if (oauthNotFoundTitle == null) {
            oauthNotFoundTitle = getString(R.string.auth_oauth_not_found_title, strMapServiceProviderToStringName);
        }
        textTitle1View.setText(oauthNotFoundTitle);
        TextBodyView textBodyView = getBinding().subtitle;
        String oauthNotFoundText = this.remoteConfig.getOauthNotFoundText();
        if (oauthNotFoundText == null) {
            oauthNotFoundText = getString(R.string.auth_oauth_not_found_subtitle, strMapServiceProviderToStringName);
        }
        textBodyView.setText(oauthNotFoundText);
        PrimaryButtonView primaryButtonView = getBinding().action;
        String oauthNotFoundEnrollmentTitle = this.remoteConfig.getOauthNotFoundEnrollmentTitle();
        if (oauthNotFoundEnrollmentTitle == null) {
            oauthNotFoundEnrollmentTitle = getString(R.string.auth_oauth_not_found_action_text);
        }
        primaryButtonView.setText(oauthNotFoundEnrollmentTitle);
        SecondaryButtonView secondaryButtonView = getBinding().secondaryAction;
        String oauthNotFoundLoginTitle = this.remoteConfig.getOauthNotFoundLoginTitle();
        if (oauthNotFoundLoginTitle == null) {
            oauthNotFoundLoginTitle = getString(R.string.auth_oauth_not_found_secondary_action_text);
        }
        secondaryButtonView.setText(oauthNotFoundLoginTitle);
        ItemImageRoundTagLargeView itemImageRoundTagLargeView = getBinding().info;
        int i2 = WhenMappings.$EnumSwitchMapping$0[getProcessError().getService().ordinal()];
        if (i2 == 1) {
            i = R.drawable.ic_sber_logo;
        } else if (i2 == 2) {
            i = R.drawable.ic_vk_logo;
        } else {
            if (i2 != 3) {
                Intrinsics.checkNotNull(itemImageRoundTagLargeView);
                itemImageRoundTagLargeView.setVisibility(8);
                getBinding().action.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFoundFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OauthNotFoundFragment.initViews$lambda$1(this.f$0, view);
                    }
                });
                getBinding().secondaryAction.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFoundFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OauthNotFoundFragment.initViews$lambda$2(this.f$0, view);
                    }
                });
            }
            i = R.drawable.ic_esia_logo;
        }
        itemImageRoundTagLargeView.setLeftImage(AppCompatResources.getDrawable(itemImageRoundTagLargeView.getContext(), i));
        itemImageRoundTagLargeView.setTitle(strMapServiceProviderToStringName);
        String phone = getProcessError().getPhone();
        if (phone == null) {
            phone = getProcessError().getEmail();
        }
        itemImageRoundTagLargeView.setSubTitle(phone);
        getBinding().action.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFoundFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OauthNotFoundFragment.initViews$lambda$1(this.f$0, view);
            }
        });
        getBinding().secondaryAction.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFoundFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OauthNotFoundFragment.initViews$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(OauthNotFoundFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new OauthNotFound.Action.StartRegistration(this$0.getProcessId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2(OauthNotFoundFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new OauthNotFound.Action.StartLogin(this$0.getProcessId()));
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
    public final void showEffect(OauthNotFound.Effect effect) throws Resources.NotFoundException {
        if (effect instanceof OauthNotFound.Effect.ShowNextStep) {
            BaseFragment.navigate$auth_release$default(this, ((OauthNotFound.Effect.ShowNextStep) effect).getProcess(), (Function1) null, 2, (Object) null);
            return;
        }
        if (effect instanceof OauthNotFound.Effect.ShowNextRegistrationStep) {
            BaseFragment.navigate$auth_release$default(this, ((OauthNotFound.Effect.ShowNextRegistrationStep) effect).getProcess(), (Function1) null, 2, (Object) null);
        } else if (effect instanceof OauthNotFound.Effect.ShowFailure) {
            ConstraintLayout parent = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            CoreFragmentExtensions.noticeError(parent, getResourceMapper().map(((OauthNotFound.Effect.ShowFailure) effect).getFailure()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(OauthNotFound.State state) {
        View view;
        if (state instanceof OauthNotFound.State.Content) {
            getBinding().action.showProgress(false);
            getBinding().secondaryAction.showProgress(false);
            getBinding().action.setClickable(true);
            getBinding().secondaryAction.setClickable(true);
            return;
        }
        if (Intrinsics.areEqual(state, OauthNotFound.State.ProgressRegistration.INSTANCE)) {
            getBinding().action.showProgress(true);
            view = getBinding().secondaryAction;
        } else {
            if (!Intrinsics.areEqual(state, OauthNotFound.State.ProgressLogin.INSTANCE)) {
                return;
            }
            getBinding().secondaryAction.showProgress(true);
            view = getBinding().action;
        }
        view.setClickable(false);
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
        this._binding = AuthOauthNotFoundBinding.inflate(inflater, container, false);
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
        initViews();
        setupIconClose();
        RuntimeViewModel<OauthNotFound.State, OauthNotFound.Action, OauthNotFound.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new a(this), new b(this), new c());
    }
}
