package ru.yoomoney.sdk.auth.select;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
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
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
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
import ru.yoomoney.sdk.auth.api.Process;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.Account;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthSelectAccountBinding;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.select.SelectAccount;
import ru.yoomoney.sdk.auth.select.adapter.AccountItem;
import ru.yoomoney.sdk.auth.select.adapter.HeaderItem;
import ru.yoomoney.sdk.auth.select.adapter.NewAccountItem;
import ru.yoomoney.sdk.auth.select.adapter.SelectAccountAdapter;
import ru.yoomoney.sdk.auth.ui.AlertDialog;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.PaddingItemDecoration;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.utils.StringExtensionsKt;
import ru.yoomoney.sdk.auth.utils.TextViewExtentionsKt;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption1View;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ$\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010[\u001a\u00020\\H\u0016J\u001a\u0010]\u001a\u00020\\2\u0006\u0010^\u001a\u00020T2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010_\u001a\u00020\\H\u0002J\u0010\u0010`\u001a\u00020\\2\u0006\u0010a\u001a\u00020NH\u0002J\u0010\u0010b\u001a\u00020\\2\u0006\u0010c\u001a\u00020LH\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R?\u0010\u000f\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011 \u0012*\u0012\u0012\u000e\b\u0001\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0016\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0016\u001a\u0004\b*\u0010'R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0016\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0016\u001a\u0004\b5\u00106R\u001d\u00108\u001a\u0004\u0018\u0001098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u0016\u001a\u0004\b:\u0010;R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0016\u001a\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020G8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR1\u0010J\u001a\u0018\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020N0Kj\u0002`O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u0016\u001a\u0004\bP\u0010QR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lru/yoomoney/sdk/auth/select/SelectAccountFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "config", "Lru/yoomoney/sdk/auth/Config;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthSelectAccountBinding;", "accounts", "", "Lru/yoomoney/sdk/auth/api/model/Account;", "kotlin.jvm.PlatformType", "getAccounts", "()[Lru/yoomoney/sdk/auth/api/model/Account;", "accounts$delegate", "Lkotlin/Lazy;", "adapter", "Lru/yoomoney/sdk/auth/select/adapter/SelectAccountAdapter;", "getAdapter", "()Lru/yoomoney/sdk/auth/select/adapter/SelectAccountAdapter;", "adapter$delegate", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthSelectAccountBinding;", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "expireAt$delegate", "prefilledEmail", "", "getPrefilledEmail", "()Ljava/lang/String;", "prefilledEmail$delegate", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "getProcessId", "processId$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "productType", "Lru/yoomoney/sdk/auth/Config$ProductType;", "getProductType", "()Lru/yoomoney/sdk/auth/Config$ProductType;", "productType$delegate", "remoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "getRemoteConfig", "()Lru/yoomoney/sdk/auth/RemoteConfig;", "remoteConfig$delegate", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "shouldRegistrationBeAddedToBackstack", "", "getShouldRegistrationBeAddedToBackstack", "()Z", "shouldRegistrationBeAddedToBackstack$delegate", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/select/SelectAccount$State;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", "Lru/yoomoney/sdk/auth/select/SelectAccount$Effect;", "Lru/yoomoney/sdk/auth/select/SelectAccountViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "setStaticElementsText", "showEffect", "effect", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SelectAccountFragment extends BaseFragment {
    private AuthSelectAccountBinding _binding;

    /* renamed from: accounts$delegate, reason: from kotlin metadata */
    private final Lazy accounts;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private final Config config;

    /* renamed from: expireAt$delegate, reason: from kotlin metadata */
    private final Lazy expireAt;

    /* renamed from: prefilledEmail$delegate, reason: from kotlin metadata */
    private final Lazy prefilledEmail;

    /* renamed from: processId$delegate, reason: from kotlin metadata */
    private final Lazy processId;
    private final ProcessMapper processMapper;

    /* renamed from: processType$delegate, reason: from kotlin metadata */
    private final Lazy processType;

    /* renamed from: productType$delegate, reason: from kotlin metadata */
    private final Lazy productType;

    /* renamed from: remoteConfig$delegate, reason: from kotlin metadata */
    private final Lazy remoteConfig;
    private final ResourceMapper resourceMapper;
    private final Router router;

    /* renamed from: shouldRegistrationBeAddedToBackstack$delegate, reason: from kotlin metadata */
    private final Lazy shouldRegistrationBeAddedToBackstack;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public static final class a extends Lambda implements Function0<Account[]> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Account[] invoke() {
            Bundle arguments = SelectAccountFragment.this.getArguments();
            if (arguments != null) {
                return SelectAccountFragmentArgs.fromBundle(arguments).getAccounts();
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    public static final class b extends Lambda implements Function0<SelectAccountAdapter> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final SelectAccountAdapter invoke() {
            return new SelectAccountAdapter(new ru.yoomoney.sdk.auth.select.a(SelectAccountFragment.this), new ru.yoomoney.sdk.auth.select.b(SelectAccountFragment.this), new ru.yoomoney.sdk.auth.select.c(SelectAccountFragment.this));
        }
    }

    public static final class c extends Lambda implements Function0<OffsetDateTime> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final OffsetDateTime invoke() {
            return SelectAccountFragmentArgs.fromBundle(SelectAccountFragment.this.requireArguments()).getExpireAt();
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<SelectAccount.State, Unit> {
        public d(Object obj) {
            super(1, obj, SelectAccountFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/select/SelectAccount$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(SelectAccount.State state) {
            SelectAccount.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SelectAccountFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function1<SelectAccount.Effect, Unit> {
        public e(Object obj) {
            super(1, obj, SelectAccountFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/select/SelectAccount$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(SelectAccount.Effect effect) throws Resources.NotFoundException {
            SelectAccount.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SelectAccountFragment) this.receiver).showEffect(p0);
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
            ConstraintLayout parent = SelectAccountFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = SelectAccountFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function0<String> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = SelectAccountFragment.this.getArguments();
            if (arguments != null) {
                return SelectAccountFragmentArgs.fromBundle(arguments).getPrefilledEmail();
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    public static final class h extends Lambda implements Function0<String> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = SelectAccountFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            String processId = SelectAccountFragmentArgs.fromBundle(arguments).getProcessId();
            Intrinsics.checkNotNullExpressionValue(processId, "getProcessId(...)");
            return processId;
        }
    }

    public static final class i extends Lambda implements Function0<ProcessType> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ProcessType invoke() {
            Bundle arguments = SelectAccountFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            ProcessType processType = SelectAccountFragmentArgs.fromBundle(arguments).getProcessType();
            Intrinsics.checkNotNullExpressionValue(processType, "getProcessType(...)");
            return processType;
        }
    }

    public static final class j extends Lambda implements Function0<Config.ProductType> {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Config.ProductType invoke() {
            return SelectAccountFragment.this.config.getProductType();
        }
    }

    public static final class k extends Lambda implements Function0<RemoteConfig> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final RemoteConfig invoke() {
            return SelectAccountFragment.this.config.getRemoteConfig();
        }
    }

    public static final class l extends Lambda implements Function0<Boolean> {
        public l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(SelectAccountFragmentArgs.fromBundle(SelectAccountFragment.this.requireArguments()).getShouldRegistrationBeAddedToBackstack());
        }
    }

    public static final class m extends Lambda implements Function0<ViewModelProvider.Factory> {
        public m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return SelectAccountFragment.this.viewModelFactory;
        }
    }

    public SelectAccountFragment(ViewModelProvider.Factory viewModelFactory, Config config, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
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
        this.processId = LazyKt.lazy(new h());
        this.processType = LazyKt.lazy(new i());
        this.accounts = LazyKt.lazy(new a());
        this.prefilledEmail = LazyKt.lazy(new g());
        this.expireAt = LazyKt.lazy(new c());
        this.productType = LazyKt.lazy(new j());
        this.remoteConfig = LazyKt.lazy(new k());
        this.shouldRegistrationBeAddedToBackstack = LazyKt.lazy(new l());
        m mVar = new m();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.select.SelectAccountFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.select.SelectAccountFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.select.SelectAccountFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.select.SelectAccountFragment$special$$inlined$viewModels$default$4
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
        }, mVar);
        this.adapter = LazyKt.lazy(new b());
    }

    private final Account[] getAccounts() {
        return (Account[]) this.accounts.getValue();
    }

    private final SelectAccountAdapter getAdapter() {
        return (SelectAccountAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthSelectAccountBinding getBinding() {
        AuthSelectAccountBinding authSelectAccountBinding = this._binding;
        Intrinsics.checkNotNull(authSelectAccountBinding);
        return authSelectAccountBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.expireAt.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPrefilledEmail() {
        return (String) this.prefilledEmail.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getProcessId() {
        return (String) this.processId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProcessType getProcessType() {
        return (ProcessType) this.processType.getValue();
    }

    private final Config.ProductType getProductType() {
        return (Config.ProductType) this.productType.getValue();
    }

    private final RemoteConfig getRemoteConfig() {
        return (RemoteConfig) this.remoteConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldRegistrationBeAddedToBackstack() {
        return ((Boolean) this.shouldRegistrationBeAddedToBackstack.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<SelectAccount.State, SelectAccount.Action, SelectAccount.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void setStaticElementsText() {
        TextTitle1View textTitle1View;
        int i2;
        String selectAccountEnrollmentScreenAgreementTitle;
        TextBodyView subtitle = getBinding().subtitle;
        Intrinsics.checkNotNullExpressionValue(subtitle, "subtitle");
        ViewExtensions.setVisible(subtitle, false);
        if (getProcessType() != ProcessType.REGISTRATION && getProcessType() != ProcessType.ENROLLMENT) {
            textTitle1View = getBinding().title;
            i2 = R.string.auth_select_account_login_screen_title;
        } else {
            if (getProductType() == Config.ProductType.WEBBANKIR) {
                TextTitle1View textTitle1View2 = getBinding().title;
                RemoteConfig remoteConfig = getRemoteConfig();
                Spanned html = null;
                textTitle1View2.setText(remoteConfig != null ? remoteConfig.getSelectAccountEnrollmentScreenTitle() : null);
                TextBodyView textBodyView = getBinding().subtitle;
                RemoteConfig remoteConfig2 = getRemoteConfig();
                textBodyView.setText(remoteConfig2 != null ? remoteConfig2.getSelectAccountEnrollmentScreenSubtitle() : null);
                Intrinsics.checkNotNull(textBodyView);
                ViewExtensions.setVisible(textBodyView, true);
                TextCaption1View textCaption1View = getBinding().agreement;
                RemoteConfig remoteConfig3 = getRemoteConfig();
                if (remoteConfig3 != null && (selectAccountEnrollmentScreenAgreementTitle = remoteConfig3.getSelectAccountEnrollmentScreenAgreementTitle()) != null) {
                    html = StringExtensionsKt.parseHtml(selectAccountEnrollmentScreenAgreementTitle);
                }
                textCaption1View.setText(html);
                textCaption1View.setMovementMethod(LinkMovementMethod.getInstance());
                ColorScheme colorScheme = ColorScheme.INSTANCE;
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                textCaption1View.setLinkTextColor(colorScheme.getAccentColor(contextRequireContext));
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                textCaption1View.setHighlightColor(colorScheme.getAccentGhostColor(contextRequireContext2));
                Intrinsics.checkNotNull(textCaption1View);
                TextViewExtentionsKt.removeLinkUnderline(textCaption1View);
                return;
            }
            textTitle1View = getBinding().title;
            i2 = R.string.auth_select_account_enrollment_screen_title;
        }
        textTitle1View.setText(getString(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(SelectAccount.Effect effect) throws Resources.NotFoundException {
        Process passwordRecoveryProcess;
        if (effect instanceof SelectAccount.Effect.ShowEnrollmentStep) {
            passwordRecoveryProcess = ((SelectAccount.Effect.ShowEnrollmentStep) effect).getEnrollmentProcess();
        } else if (effect instanceof SelectAccount.Effect.ShowLoginStep) {
            passwordRecoveryProcess = ((SelectAccount.Effect.ShowLoginStep) effect).getLoginProcess();
        } else {
            if (effect instanceof SelectAccount.Effect.ShowRegistrationStep) {
                BaseFragment.navigate$auth_release$default(this, ((SelectAccount.Effect.ShowRegistrationStep) effect).getRegistrationProcess(), (Function1) null, 2, (Object) null);
                return;
            }
            if (!(effect instanceof SelectAccount.Effect.ShowPasswordRecoveryStep)) {
                if (effect instanceof SelectAccount.Effect.ShowMigrationStep) {
                    SelectAccount.Effect.ShowMigrationStep showMigrationStep = (SelectAccount.Effect.ShowMigrationStep) effect;
                    FragmentKt.findNavController(this).navigate(R.id.hardMigrationFragment, BundleKt.bundleOf(TuplesKt.to("processType", showMigrationStep.getProcessType()), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, showMigrationStep.getProcessId()), TuplesKt.to("uid", showMigrationStep.getUid()), TuplesKt.to("expireAt", showMigrationStep.getExpireAt())), getNavOptions());
                    return;
                }
                if (effect instanceof SelectAccount.Effect.ShowFailure) {
                    ConstraintLayout parent = getBinding().parent;
                    Intrinsics.checkNotNullExpressionValue(parent, "parent");
                    CoreFragmentExtensions.noticeError(parent, getResourceMapper().map(((SelectAccount.Effect.ShowFailure) effect).getFailure()));
                    return;
                } else {
                    if (!(effect instanceof SelectAccount.Effect.ShowExpireDialog)) {
                        if (effect instanceof SelectAccount.Effect.ResetProcess) {
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
                    alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.select.SelectAccountFragment$showEffect$1$1
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
                            this.this$0.getViewModel().handleAction(SelectAccount.Action.RestartProcess.INSTANCE);
                        }
                    });
                    FragmentManager childFragmentManager2 = getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
                    alertDialogCreate.show(childFragmentManager2);
                    return;
                }
            }
            passwordRecoveryProcess = ((SelectAccount.Effect.ShowPasswordRecoveryStep) effect).getPasswordRecoveryProcess();
        }
        BaseFragment.navigate$auth_release$default(this, passwordRecoveryProcess, (Function1) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(SelectAccount.State state) {
        if (state instanceof SelectAccount.State.Content) {
            setStaticElementsText();
            ArrayList arrayList = new ArrayList();
            if (getProcessType() == ProcessType.REGISTRATION || getProcessType() == ProcessType.ENROLLMENT) {
                arrayList.add(NewAccountItem.INSTANCE);
            }
            Account[] accounts = getAccounts();
            Intrinsics.checkNotNullExpressionValue(accounts, "<get-accounts>(...)");
            ArrayList<Account> arrayList2 = new ArrayList();
            for (Account account : accounts) {
                if (!Intrinsics.areEqual(account.getMigrationRequired(), Boolean.TRUE)) {
                    arrayList2.add(account);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (Account account2 : arrayList2) {
                Intrinsics.checkNotNull(account2);
                arrayList3.add(new AccountItem(account2, this.config.getShowServices()));
            }
            if (!arrayList3.isEmpty()) {
                String string = getString(R.string.auth_select_account_actives);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                arrayList.add(new HeaderItem(string));
                arrayList.addAll(arrayList3);
            }
            Account[] accounts2 = getAccounts();
            Intrinsics.checkNotNullExpressionValue(accounts2, "<get-accounts>(...)");
            ArrayList<Account> arrayList4 = new ArrayList();
            for (Account account3 : accounts2) {
                if (Intrinsics.areEqual(account3.getMigrationRequired(), Boolean.TRUE)) {
                    arrayList4.add(account3);
                }
            }
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            for (Account account4 : arrayList4) {
                Intrinsics.checkNotNull(account4);
                arrayList5.add(new AccountItem(account4, this.config.getShowServices()));
            }
            if (!arrayList5.isEmpty()) {
                String string2 = getString(R.string.auth_select_account_need_migration);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                arrayList.add(new HeaderItem(string2));
                arrayList.addAll(arrayList5);
            }
            getAdapter().submitList(arrayList);
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
        this._binding = AuthSelectAccountBinding.inflate(inflater, container, false);
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
    public void onViewCreated(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().list.setAdapter(getAdapter());
        RecyclerView recyclerView = getBinding().list;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ym_space5XL);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNull(contextRequireContext);
        recyclerView.addItemDecoration(new PaddingItemDecoration(contextRequireContext, dimensionPixelSize, 0, 4, null));
        RuntimeViewModel<SelectAccount.State, SelectAccount.Action, SelectAccount.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new d(this), new e(this), new f());
        getViewModel().handleAction(new SelectAccount.Action.SendAnalyticsForScreen(getProcessType()));
        getViewModel().handleAction(SelectAccount.Action.ShowContent.INSTANCE);
    }
}
