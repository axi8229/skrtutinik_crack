package ru.yoomoney.sdk.auth.password.enter;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
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
import java.io.UnsupportedEncodingException;
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
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.Account;
import ru.yoomoney.sdk.auth.api.model.ErrorInvalidPassword;
import ru.yoomoney.sdk.auth.api.model.ErrorInvalidPasswordOrAccount;
import ru.yoomoney.sdk.auth.api.model.FeatureFailure;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthPasswordEnterBinding;
import ru.yoomoney.sdk.auth.password.enter.PasswordEnter;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.AlertDialog;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.ui.ItemImageRoundIconServicesView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.EditTextExtensionsKt;
import ru.yoomoney.sdk.auth.utils.KeyboardObserverKt;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.widget.ContentScrollView;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ$\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020NH\u0016J\u001a\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020F2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010Q\u001a\u00020NH\u0002J\u0018\u0010R\u001a\u00020N2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010S\u001a\u00020TH\u0002J\u0010\u0010U\u001a\u00020N2\u0006\u0010V\u001a\u00020@H\u0002J\u0010\u0010W\u001a\u00020N2\u0006\u0010X\u001a\u00020YH\u0002J\u0018\u0010Z\u001a\u00020N2\u0006\u0010X\u001a\u00020Y2\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010]\u001a\u00020N2\u0006\u0010^\u001a\u00020>H\u0002R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b!\u0010\"R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0016\u001a\u0004\b(\u0010)R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0016\u001a\u0004\b-\u0010.R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u0002098VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R1\u0010<\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020@0=j\u0002`A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u0016\u001a\u0004\bB\u0010CR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lru/yoomoney/sdk/auth/password/enter/PasswordEnterFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "config", "Lru/yoomoney/sdk/auth/Config;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/auth/ResultData;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthPasswordEnterBinding;", "account", "Lru/yoomoney/sdk/auth/api/model/Account;", "getAccount", "()Lru/yoomoney/sdk/auth/api/model/Account;", "account$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthPasswordEnterBinding;", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "expireAt$delegate", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "getProcessId", "()Ljava/lang/String;", "processId$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "remoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "getRemoteConfig", "()Lru/yoomoney/sdk/auth/RemoteConfig;", "remoteConfig$delegate", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "scroll", "Lru/yoomoney/sdk/gui/widget/ContentScrollView;", "getScroll", "()Lru/yoomoney/sdk/gui/widget/ContentScrollView;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$State;", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action;", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Effect;", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnterViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "setupViews", "showAccount", "showServices", "", "showEffect", "effect", "showError", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/FeatureFailure;", "showErrorWithAttempts", "attemptsLeft", "", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PasswordEnterFragment extends BaseFragment {
    private AuthPasswordEnterBinding _binding;

    /* renamed from: account$delegate, reason: from kotlin metadata */
    private final Lazy account;
    private final Config config;

    /* renamed from: expireAt$delegate, reason: from kotlin metadata */
    private final Lazy expireAt;

    /* renamed from: processId$delegate, reason: from kotlin metadata */
    private final Lazy processId;
    private final ProcessMapper processMapper;

    /* renamed from: processType$delegate, reason: from kotlin metadata */
    private final Lazy processType;

    /* renamed from: remoteConfig$delegate, reason: from kotlin metadata */
    private final Lazy remoteConfig;
    private final ResourceMapper resourceMapper;
    private final ResultData resultData;
    private final Router router;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessType.values().length];
            try {
                iArr[ProcessType.CHANGE_PASSWORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final class a extends Lambda implements Function0<Account> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Account invoke() {
            return PasswordEnterFragmentArgs.fromBundle(PasswordEnterFragment.this.requireArguments()).getAccount();
        }
    }

    public static final class b extends Lambda implements Function0<OffsetDateTime> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final OffsetDateTime invoke() {
            OffsetDateTime expireAt = PasswordEnterFragmentArgs.fromBundle(PasswordEnterFragment.this.requireArguments()).getExpireAt();
            Intrinsics.checkNotNullExpressionValue(expireAt, "getExpireAt(...)");
            return expireAt;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<PasswordEnter.State, Unit> {
        public c(Object obj) {
            super(1, obj, PasswordEnterFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PasswordEnter.State state) {
            PasswordEnter.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PasswordEnterFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<PasswordEnter.Effect, Unit> {
        public d(Object obj) {
            super(1, obj, PasswordEnterFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PasswordEnter.Effect effect) throws Resources.NotFoundException, UnsupportedEncodingException {
            PasswordEnter.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PasswordEnterFragment) this.receiver).showEffect(p0);
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
            ConstraintLayout parent = PasswordEnterFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = PasswordEnterFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function0<String> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String processId = PasswordEnterFragmentArgs.fromBundle(PasswordEnterFragment.this.requireArguments()).getProcessId();
            Intrinsics.checkNotNullExpressionValue(processId, "getProcessId(...)");
            return processId;
        }
    }

    public static final class g extends Lambda implements Function0<ProcessType> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ProcessType invoke() {
            Bundle arguments = PasswordEnterFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            ProcessType processType = PasswordEnterFragmentArgs.fromBundle(arguments).getProcessType();
            Intrinsics.checkNotNullExpressionValue(processType, "getProcessType(...)");
            return processType;
        }
    }

    public static final class h extends Lambda implements Function0<RemoteConfig> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final RemoteConfig invoke() {
            return PasswordEnterFragment.this.config.getRemoteConfig();
        }
    }

    public static final class i extends Lambda implements Function1<Boolean, Unit> {
        public i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Boolean bool) {
            ContentScrollView scroll;
            if (bool.booleanValue() && (scroll = PasswordEnterFragment.this.getScroll()) != null) {
                scroll.smoothScrollTo(0, scroll.getBottom());
            }
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function0<ViewModelProvider.Factory> {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return PasswordEnterFragment.this.viewModelFactory;
        }
    }

    public PasswordEnterFragment(ViewModelProvider.Factory viewModelFactory, Config config, ResultData resultData, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.viewModelFactory = viewModelFactory;
        this.config = config;
        this.resultData = resultData;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        j jVar = new j();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.password.enter.PasswordEnterFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.password.enter.PasswordEnterFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.password.enter.PasswordEnterFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.password.enter.PasswordEnterFragment$special$$inlined$viewModels$default$4
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
        }, jVar);
        this.processId = LazyKt.lazy(new f());
        this.account = LazyKt.lazy(new a());
        this.processType = LazyKt.lazy(new g());
        this.expireAt = LazyKt.lazy(new b());
        this.remoteConfig = LazyKt.lazy(new h());
    }

    private final Account getAccount() {
        return (Account) this.account.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthPasswordEnterBinding getBinding() {
        AuthPasswordEnterBinding authPasswordEnterBinding = this._binding;
        Intrinsics.checkNotNull(authPasswordEnterBinding);
        return authPasswordEnterBinding;
    }

    private final OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.expireAt.getValue();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final ContentScrollView getScroll() {
        View view = getView();
        if (view != null) {
            return (ContentScrollView) view.findViewById(R.id.scroll);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<PasswordEnter.State, PasswordEnter.Action, PasswordEnter.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void setupViews() {
        TextBodyView textBodyView;
        TextBodyView textBodyView2 = getBinding().forgot;
        Intrinsics.checkNotNull(textBodyView2);
        RemoteConfig remoteConfig = this.config.getRemoteConfig();
        ViewExtensions.setVisible(textBodyView2, remoteConfig != null ? remoteConfig.getRestorePasswordEnabled() : true);
        ColorScheme colorScheme = ColorScheme.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        textBodyView2.setTextColor(colorScheme.getAccentColor(contextRequireContext));
        textBodyView2.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.password.enter.PasswordEnterFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PasswordEnterFragment.setupViews$lambda$1$lambda$0(this.f$0, view);
            }
        });
        AppCompatEditText editText = getBinding().password.getEditText();
        EditTextExtensionsKt.applyPasswordAutofillHint(editText);
        editText.addTextChangedListener(new TextWatcher() { // from class: ru.yoomoney.sdk.auth.password.enter.PasswordEnterFragment$setupViews$lambda$3$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.this$0.getViewModel().handleAction(new PasswordEnter.Action.PasswordChanged(String.valueOf(s)));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }
        });
        ConstraintLayout parent = getBinding().parent;
        Intrinsics.checkNotNullExpressionValue(parent, "parent");
        KeyboardObserverKt.addKeyboardListener(parent, this, new i());
        getBinding().action.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.password.enter.PasswordEnterFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PasswordEnterFragment.setupViews$lambda$4(this.f$0, view);
            }
        });
        Account account = getAccount();
        if (account != null) {
            showAccount(account, this.config.getShowServices());
        }
        if (WhenMappings.$EnumSwitchMapping$0[getProcessType().ordinal()] == 1) {
            getBinding().title.setText(getString(R.string.auth_password_enter_account_title));
            TextBodyView warning = getBinding().warning;
            Intrinsics.checkNotNullExpressionValue(warning, "warning");
            ViewExtensions.hide(warning);
            return;
        }
        if (this.config.getProductType() == Config.ProductType.WEBBANKIR) {
            TextTitle1View textTitle1View = getBinding().title;
            RemoteConfig remoteConfig2 = getRemoteConfig();
            String passwordEnterScreenWarning = null;
            textTitle1View.setText(remoteConfig2 != null ? remoteConfig2.getPasswordEnterScreenTitle() : null);
            textBodyView = getBinding().warning;
            if (Intrinsics.areEqual(this.resultData.getForceLogin(), Boolean.TRUE)) {
                RemoteConfig remoteConfig3 = getRemoteConfig();
                if (remoteConfig3 != null) {
                    passwordEnterScreenWarning = remoteConfig3.getPasswordEnterScreenForceLoginWarning();
                }
            } else {
                RemoteConfig remoteConfig4 = getRemoteConfig();
                if (remoteConfig4 != null) {
                    passwordEnterScreenWarning = remoteConfig4.getPasswordEnterScreenWarning();
                }
            }
            textBodyView.setText(passwordEnterScreenWarning);
        } else {
            getBinding().title.setText(getString(R.string.auth_password_enter_title));
            textBodyView = getBinding().warning;
            textBodyView.setText(getString(R.string.auth_password_enter_warning_text));
        }
        Intrinsics.checkNotNull(textBodyView);
        ViewExtensions.show(textBodyView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$1$lambda$0(PasswordEnterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(PasswordEnter.Action.PasswordRecovery.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$4(PasswordEnterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new PasswordEnter.Action.CheckExpiration(String.valueOf(this$0.getBinding().password.getEditText().getText()), this$0.getProcessType(), this$0.getProcessId(), this$0.getExpireAt()));
    }

    private final void showAccount(Account account, boolean showServices) {
        ItemImageRoundIconServicesView itemImageRoundIconServicesView = getBinding().accountView;
        String logoUrl = account.getLogoUrl();
        if (logoUrl == null) {
            logoUrl = "";
        }
        itemImageRoundIconServicesView.setLeftImageUrl(logoUrl);
        itemImageRoundIconServicesView.setTitle(account.getTitle());
        itemImageRoundIconServicesView.setServices(showServices ? account.getServices() : CollectionsKt.emptyList());
        Intrinsics.checkNotNull(itemImageRoundIconServicesView);
        ViewExtensions.show(itemImageRoundIconServicesView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(PasswordEnter.Effect effect) throws Resources.NotFoundException, UnsupportedEncodingException {
        if (effect instanceof PasswordEnter.Effect.ShowNextStep) {
            BaseFragment.navigate$auth_release$default(this, ((PasswordEnter.Effect.ShowNextStep) effect).getProcess(), (Function1) null, 2, (Object) null);
            return;
        }
        if (effect instanceof PasswordEnter.Effect.ShowFailure) {
            ConstraintLayout parent = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            CoreFragmentExtensions.noticeError(parent, getResourceMapper().map(((PasswordEnter.Effect.ShowFailure) effect).getFailure()));
            return;
        }
        if (effect instanceof PasswordEnter.Effect.SendEmail) {
            CoreFragmentExtensions.sendEmail$default(this, this.config.getSupportEmail(), null, null, 6, null);
            return;
        }
        if (!(effect instanceof PasswordEnter.Effect.ShowExpireDialog)) {
            if (effect instanceof PasswordEnter.Effect.ResetProcess) {
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
        alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.password.enter.PasswordEnterFragment$showEffect$1$1
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
                this.this$0.getViewModel().handleAction(PasswordEnter.Action.RestartProcess.INSTANCE);
            }
        });
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        alertDialogCreate.show(childFragmentManager2);
    }

    private final void showError(FeatureFailure failure) {
        int attemptsLeft;
        ProcessError error = failure.getError();
        if (error instanceof ErrorInvalidPassword) {
            attemptsLeft = ((ErrorInvalidPassword) error).getAttemptsLeft();
        } else {
            if (!(error instanceof ErrorInvalidPasswordOrAccount)) {
                ConstraintLayout parent = getBinding().parent;
                Intrinsics.checkNotNullExpressionValue(parent, "parent");
                CoreFragmentExtensions.noticeError(parent, getResourceMapper().map(failure));
                return;
            }
            attemptsLeft = ((ErrorInvalidPasswordOrAccount) error).getAttemptsLeft();
        }
        showErrorWithAttempts(failure, attemptsLeft);
    }

    private final void showErrorWithAttempts(FeatureFailure failure, int attemptsLeft) {
        String map = getResourceMapper().map(failure);
        getBinding().password.setError(attemptsLeft == 1 ? getString(R.string.auth_enter_password_error_last_attempt, map) : getString(R.string.auth_enter_password_error_many_attempts, map, Integer.valueOf(attemptsLeft)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(PasswordEnter.State state) {
        if (!(state instanceof PasswordEnter.State.Content)) {
            if (state instanceof PasswordEnter.State.Progress) {
                getBinding().action.showProgress(true);
                getBinding().password.setEnabled(false);
                getBinding().password.setError(null);
                return;
            }
            return;
        }
        PasswordEnter.State.Content content = (PasswordEnter.State.Content) state;
        getBinding().action.setEnabled(content.getPassword().length() > 0);
        getBinding().action.showProgress(false);
        getBinding().password.setEnabled(true);
        getBinding().password.setError(null);
        FeatureFailure error = content.getError();
        if (error != null) {
            showError(error);
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
        this._binding = AuthPasswordEnterBinding.inflate(inflater, container, false);
        CoordinatorLayout root = getBinding().getRoot();
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
        setupViews();
        RuntimeViewModel<PasswordEnter.State, PasswordEnter.Action, PasswordEnter.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new c(this), new d(this), new e());
        getViewModel().handleAction(new PasswordEnter.Action.SendAnalyticsForScreen(getProcessType()));
    }
}
