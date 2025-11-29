package ru.yoomoney.sdk.auth.api.login;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.squareup.picasso.Picasso;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.PhoneIdentifier;
import ru.yoomoney.sdk.auth.PrefilledData;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.login.LoginEnter;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcess;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessConfirmEmail;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessConfirmPhone;
import ru.yoomoney.sdk.auth.api.model.ErrorAccountNotFound;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.model.FeatureFailure;
import ru.yoomoney.sdk.auth.api.model.IllegalParametersFailure;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthLoginEnterBinding;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.AlertDialog;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.EditTextExtensionsKt;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widgetV2.dialog.DialogVisibleListener;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020>H\u0002J+\u0010B\u001a\u00020>2\u001c\u0010C\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0E\u0012\u0006\u0012\u0004\u0018\u00010F0DH\u0002¢\u0006\u0002\u0010GJ$\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\b\u0010P\u001a\u00020>H\u0016J\b\u0010Q\u001a\u00020>H\u0016J\u001a\u0010R\u001a\u00020>2\u0006\u0010S\u001a\u00020I2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\b\u0010T\u001a\u00020>H\u0002J\u0010\u0010U\u001a\u00020>2\u0006\u0010V\u001a\u000208H\u0002J\u0010\u0010W\u001a\u00020>2\u0006\u0010X\u001a\u000206H\u0002J\u001c\u0010Y\u001a\u00020>*\u00020O2\u0006\u0010Z\u001a\u00020!2\u0006\u0010[\u001a\u00020\\H\u0002R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b\"\u0010#R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001a\u001a\u0004\b)\u0010*R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u0002018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R1\u00104\u001a\u0018\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020805j\u0002`98BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u001a\u001a\u0004\b:\u0010;R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginEnterFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "Lru/yoomoney/sdk/gui/widgetV2/dialog/DialogVisibleListener;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "config", "Lru/yoomoney/sdk/auth/Config;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/auth/ResultData;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthLoginEnterBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthLoginEnterBinding;", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "expireAt$delegate", "Lkotlin/Lazy;", "passwordRecoverySuccess", "", "getPasswordRecoverySuccess", "()Z", "passwordRecoverySuccess$delegate", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "getProcessId", "()Ljava/lang/String;", "processId$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$State;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Action;", "Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect;", "Lru/yoomoney/sdk/auth/api/login/LoginEnterViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "handleFailure", "", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "initMigrationBanner", "launch", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onStart", "onViewCreated", "view", "setupViews", "showEffect", "effect", "showState", "state", "putLogin", "login", "process", "Lru/yoomoney/sdk/auth/api/login/model/LoginProcess;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoginEnterFragment extends BaseFragment implements DialogVisibleListener {
    private AuthLoginEnterBinding _binding;
    private final Config config;

    /* renamed from: expireAt$delegate, reason: from kotlin metadata */
    private final Lazy expireAt;

    /* renamed from: passwordRecoverySuccess$delegate, reason: from kotlin metadata */
    private final Lazy passwordRecoverySuccess;

    /* renamed from: processId$delegate, reason: from kotlin metadata */
    private final Lazy processId;
    private final ProcessMapper processMapper;

    /* renamed from: processType$delegate, reason: from kotlin metadata */
    private final Lazy processType;
    private final ResourceMapper resourceMapper;
    private final ResultData resultData;
    private final Router router;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public static final class a extends Lambda implements Function0<OffsetDateTime> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final OffsetDateTime invoke() {
            OffsetDateTime expireAt = LoginEnterFragmentArgs.fromBundle(LoginEnterFragment.this.requireArguments()).getExpireAt();
            Intrinsics.checkNotNullExpressionValue(expireAt, "getExpireAt(...)");
            return expireAt;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginEnterFragment$launch$1", f = "LoginEnterFragment.kt", l = {258}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ Function1<Continuation<? super Unit>, Object> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new b(this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super Unit>, Object> function1 = this.b;
                this.a = 1;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<LoginEnter.State, Unit> {
        public c(Object obj) {
            super(1, obj, LoginEnterFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/api/login/LoginEnter$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(LoginEnter.State state) {
            LoginEnter.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((LoginEnterFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<LoginEnter.Effect, Unit> {
        public d(Object obj) {
            super(1, obj, LoginEnterFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/api/login/LoginEnter$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(LoginEnter.Effect effect) throws Resources.NotFoundException {
            LoginEnter.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((LoginEnterFragment) this.receiver).showEffect(p0);
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
            ConstraintLayout parent = LoginEnterFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = LoginEnterFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function0<Boolean> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(LoginEnterFragmentArgs.fromBundle(LoginEnterFragment.this.requireArguments()).getPasswordRecoverySuccess());
        }
    }

    public static final class g extends Lambda implements Function0<String> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = LoginEnterFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            String processId = LoginEnterFragmentArgs.fromBundle(arguments).getProcessId();
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
            Bundle arguments = LoginEnterFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            ProcessType processType = LoginEnterFragmentArgs.fromBundle(arguments).getProcessType();
            Intrinsics.checkNotNullExpressionValue(processType, "getProcessType(...)");
            return processType;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.login.LoginEnterFragment$setupViews$2$1", f = "LoginEnterFragment.kt", l = {}, m = "invokeSuspend")
    public static final class i extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        public i(Continuation<? super i> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LoginEnterFragment.this.new i(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return LoginEnterFragment.this.new i(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            LoginEnterFragment.this.getViewModel().handleAction(new LoginEnter.Action.CheckExpiration(LoginEnterFragment.this.getProcessId(), LoginEnterFragment.this.getExpireAt()));
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Bundle, Unit> {
        public final /* synthetic */ LoginEnter.Effect b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(LoginEnter.Effect effect) {
            super(1);
            this.b = effect;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Bundle bundle) {
            Bundle it = bundle;
            Intrinsics.checkNotNullParameter(it, "it");
            LoginEnterFragment loginEnterFragment = LoginEnterFragment.this;
            loginEnterFragment.putLogin(it, String.valueOf(loginEnterFragment.getBinding().login.getText()), ((LoginEnter.Effect.ShowNextStep) this.b).getProcess());
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function0<ViewModelProvider.Factory> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return LoginEnterFragment.this.viewModelFactory;
        }
    }

    public LoginEnterFragment(ViewModelProvider.Factory viewModelFactory, Config config, ResultData resultData, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
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
        k kVar = new k();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.api.login.LoginEnterFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.api.login.LoginEnterFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.api.login.LoginEnterFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.api.login.LoginEnterFragment$special$$inlined$viewModels$default$4
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
        }, kVar);
        this.processId = LazyKt.lazy(new g());
        this.processType = LazyKt.lazy(new h());
        this.expireAt = LazyKt.lazy(new a());
        this.passwordRecoverySuccess = LazyKt.lazy(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthLoginEnterBinding getBinding() {
        AuthLoginEnterBinding authLoginEnterBinding = this._binding;
        Intrinsics.checkNotNull(authLoginEnterBinding);
        return authLoginEnterBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.expireAt.getValue();
    }

    private final boolean getPasswordRecoverySuccess() {
        return ((Boolean) this.passwordRecoverySuccess.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getProcessId() {
        return (String) this.processId.getValue();
    }

    private final ProcessType getProcessType() {
        return (ProcessType) this.processType.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<LoginEnter.State, LoginEnter.Action, LoginEnter.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void handleFailure(Failure failure) throws Resources.NotFoundException {
        Object next;
        if (!(failure instanceof IllegalParametersFailure)) {
            if (this.config.getEnableAutoEnrollment() && (failure instanceof FeatureFailure) && (((FeatureFailure) failure).getError() instanceof ErrorAccountNotFound)) {
                FragmentKt.findNavController(this).navigate(R.id.authLoadingFragment, BundleKt.bundleOf(TuplesKt.to("isForcedRegistration", Boolean.TRUE)), getNavOptions());
                return;
            }
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            ConstraintLayout parent = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            CoreFragmentExtensions.handleFailure(this, childFragmentManager, parent, failure, getResourceMapper());
            return;
        }
        List<String> parameterNames = ((IllegalParametersFailure) failure).getParameterNames();
        if (parameterNames != null) {
            Iterator<T> it = parameterNames.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual((String) next, AppMeasurementSdk.ConditionalUserProperty.VALUE)) {
                        break;
                    }
                }
            }
            if (((String) next) != null) {
                ConstraintLayout parent2 = getBinding().parent;
                Intrinsics.checkNotNullExpressionValue(parent2, "parent");
                String string = getString(R.string.auth_login_illegal_value_error);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CoreFragmentExtensions.noticeError(parent2, string);
            }
        }
    }

    private final void initMigrationBanner() {
        Unit unit;
        CardView cardView = getBinding().bannerAction.messageCard;
        Intrinsics.checkNotNull(cardView);
        ViewExtensions.setVisible(cardView, this.config.getMigrationBannerVisible());
        if (this.config.getMigrationBannerVisible()) {
            Integer migrationBannerTextColor = this.config.getMigrationBannerTextColor();
            if (migrationBannerTextColor != null) {
                int iIntValue = migrationBannerTextColor.intValue();
                getBinding().bannerAction.message.setTextColor(iIntValue);
                getBinding().bannerAction.informerAction.setTextColor(iIntValue);
            }
            getBinding().bannerAction.message.setText(this.config.getMigrationBannerText());
            String migrationBannerButtonText = this.config.getMigrationBannerButtonText();
            if (migrationBannerButtonText != null) {
                TextBodyView informerAction = getBinding().bannerAction.informerAction;
                Intrinsics.checkNotNullExpressionValue(informerAction, "informerAction");
                ViewExtensions.show(informerAction);
                getBinding().bannerAction.informerAction.setText(migrationBannerButtonText);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                TextBodyView informerAction2 = getBinding().bannerAction.informerAction;
                Intrinsics.checkNotNullExpressionValue(informerAction2, "informerAction");
                ViewExtensions.hide(informerAction2);
            }
            ColorScheme colorScheme = ColorScheme.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            cardView.setCardBackgroundColor(colorScheme.getAccentColor(contextRequireContext));
            cardView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.api.login.LoginEnterFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginEnterFragment.initMigrationBanner$lambda$9$lambda$7(this.f$0, view);
                }
            });
            String migrationBannerImageUrl = this.config.getMigrationBannerImageUrl();
            if (migrationBannerImageUrl != null) {
                Picasso.get().load(Uri.parse(migrationBannerImageUrl)).into(getBinding().bannerAction.bannerImage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initMigrationBanner$lambda$9$lambda$7(LoginEnterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(LoginEnter.Action.ShowMigrationDescriptionScreen.INSTANCE);
    }

    private final void launch(Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getIO(), null, new b(block, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void putLogin(Bundle bundle, String str, LoginProcess loginProcess) {
        if (loginProcess instanceof LoginProcessConfirmPhone) {
            this.resultData.setPhone(((LoginProcessConfirmPhone) loginProcess).getPhone());
        } else if (loginProcess instanceof LoginProcessConfirmEmail) {
            bundle.putString(Scopes.EMAIL, str);
        }
    }

    private final void setupViews() {
        initMigrationBanner();
        AppCompatEditText editText = getBinding().login.getEditText();
        EditTextExtensionsKt.applyUserNameAutofillHint(editText);
        editText.addTextChangedListener(new TextWatcher() { // from class: ru.yoomoney.sdk.auth.api.login.LoginEnterFragment$setupViews$lambda$2$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.this$0.getViewModel().handleAction(new LoginEnter.Action.LoginChanged(String.valueOf(s)));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }
        });
        getBinding().action.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.api.login.LoginEnterFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginEnterFragment.setupViews$lambda$3(this.f$0, view);
            }
        });
        if (getPasswordRecoverySuccess()) {
            YmAlertDialog.DialogContent dialogContent = new YmAlertDialog.DialogContent(getString(R.string.auth_password_recovery_success_dialog_title), getString(R.string.auth_password_recovery_success_dialog_description), getString(R.string.auth_password_recovery_success_dialog_action), null, false, false, 56, null);
            AlertDialog.Companion companion = AlertDialog.INSTANCE;
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            final AlertDialog alertDialogCreate = companion.create(childFragmentManager, dialogContent);
            alertDialogCreate.setCancelable(false);
            alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.api.login.LoginEnterFragment$setupViews$3$1
                @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
                public void onDismiss() {
                    YmAlertDialog.DialogListener.DefaultImpls.onDismiss(this);
                }

                @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
                public void onNegativeClick() {
                    YmAlertDialog.DialogListener.DefaultImpls.onNegativeClick(this);
                }

                @Override // ru.yoomoney.sdk.gui.dialog.YmAlertDialog.DialogListener
                public void onPositiveClick() throws Resources.NotFoundException {
                    FragmentKt.findNavController(alertDialogCreate).navigate(this.getRouter().reset());
                    onDismiss();
                }
            });
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            alertDialogCreate.show(childFragmentManager2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$3(LoginEnterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.launch(this$0.new i(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(LoginEnter.Effect effect) throws Resources.NotFoundException {
        if (effect instanceof LoginEnter.Effect.ShowNextStep) {
            navigate$auth_release(((LoginEnter.Effect.ShowNextStep) effect).getProcess(), new j(effect));
            return;
        }
        if (effect instanceof LoginEnter.Effect.ShowFailure) {
            handleFailure(((LoginEnter.Effect.ShowFailure) effect).getFailure());
            return;
        }
        if (!(effect instanceof LoginEnter.Effect.ShowExpireDialog)) {
            if (effect instanceof LoginEnter.Effect.ResetProcess) {
                FragmentKt.findNavController(this).navigate(getRouter().reset());
                return;
            } else {
                if (effect instanceof LoginEnter.Effect.OpenMigrationDescriptionScreen) {
                    FragmentKt.findNavController(this).navigate(R.id.softMigrationFragment, BundleKt.bundleOf(), getNavOptions());
                    return;
                }
                return;
            }
        }
        YmAlertDialog.DialogContent dialogContent = new YmAlertDialog.DialogContent(getString(R.string.auth_reset_process_dialog_title), getResourceMapper().resetProcessDialog(getProcessType()), getString(R.string.auth_reset_process_dialog_action), null, false, false, 56, null);
        AlertDialog.Companion companion = AlertDialog.INSTANCE;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        AlertDialog alertDialogCreate = companion.create(childFragmentManager, dialogContent);
        alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.api.login.LoginEnterFragment$showEffect$2$1
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
                this.this$0.getViewModel().handleAction(LoginEnter.Action.RestartProcess.INSTANCE);
            }
        });
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        alertDialogCreate.show(childFragmentManager2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(LoginEnter.State state) {
        if (state instanceof LoginEnter.State.Content) {
            getBinding().action.showProgress(false);
            getBinding().login.setEnabled(true);
            getBinding().action.setEnabled(((LoginEnter.State.Content) state).getValue().length() > 0);
        } else if (state instanceof LoginEnter.State.Progress) {
            getBinding().action.showProgress(true);
            getBinding().login.setEnabled(false);
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
        this._binding = AuthLoginEnterBinding.inflate(inflater, container, false);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.DialogVisibleListener
    public void onDismiss(String str) {
        DialogVisibleListener.DefaultImpls.onDismiss(this, str);
    }

    @Override // ru.yoomoney.sdk.gui.widgetV2.dialog.DialogVisibleListener
    public void onShow(String str) {
        DialogVisibleListener.DefaultImpls.onShow(this, str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        CharSequence text = getBinding().login.getText();
        if (text == null || text.length() == 0) {
            return;
        }
        getBinding().login.displayAction(1);
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String email;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().appBar.setTitle(getString(R.string.auth_login_enter_screen_title));
        setupViews();
        PrefilledData prefilledData = this.config.getPrefilledData();
        if (prefilledData != null) {
            PhoneIdentifier phone = prefilledData.getPhone();
            if (phone == null || (email = phone.getPhone()) == null) {
                email = prefilledData.getEmail();
            }
            getBinding().login.getEditText().setText(email);
        }
        RuntimeViewModel<LoginEnter.State, LoginEnter.Action, LoginEnter.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new c(this), new d(this), new e());
    }
}
