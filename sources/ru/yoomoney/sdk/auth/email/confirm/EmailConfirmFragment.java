package ru.yoomoney.sdk.auth.email.confirm;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.google.android.gms.common.Scopes;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.threeten.bp.Duration;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.enrollment.model.EnrollmentProcessSetEmail;
import ru.yoomoney.sdk.auth.api.model.ProcessError;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthEmailConfirmBinding;
import ru.yoomoney.sdk.auth.email.confirm.EmailConfirm;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.AlertDialog;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.ui.FlatButtonView;
import ru.yoomoney.sdk.auth.ui.ItemSecondarySwitchView;
import ru.yoomoney.sdk.auth.ui.ItemVectorFadeDetailView;
import ru.yoomoney.sdk.auth.ui.PrimaryButtonView;
import ru.yoomoney.sdk.auth.ui.ProgressBar;
import ru.yoomoney.sdk.auth.ui.TextInputView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.NumberExtensionsKt;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.utils.StringExtensionsKt;
import ru.yoomoney.sdk.auth.utils.TextViewExtentionsKt;
import ru.yoomoney.sdk.auth.utils.YmCountDownTimer;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextTitle1View;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\b\u0010Z\u001a\u00020@H\u0002J\u0018\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`H\u0017J$\u0010a\u001a\u00020b2\u0006\u0010_\u001a\u00020c2\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J\b\u0010h\u001a\u00020\\H\u0016J\u0010\u0010i\u001a\u00020#2\u0006\u0010j\u001a\u00020kH\u0017J\b\u0010l\u001a\u00020\\H\u0002J\u0010\u0010m\u001a\u00020\\2\u0006\u0010n\u001a\u00020oH\u0002J\u001a\u0010p\u001a\u00020\\2\u0006\u0010q\u001a\u00020b2\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J\b\u0010r\u001a\u00020\\H\u0002J\u0010\u0010s\u001a\u00020\\2\u0006\u0010t\u001a\u00020#H\u0002J\b\u0010u\u001a\u00020\\H\u0002J\u0010\u0010v\u001a\u00020\\2\u0006\u0010w\u001a\u00020UH\u0002J\u0010\u0010x\u001a\u00020\\2\u0006\u0010y\u001a\u00020SH\u0002J\u0010\u0010z\u001a\u00020\\2\u0006\u0010y\u001a\u00020{H\u0002J\b\u0010|\u001a\u00020\\H\u0002J\u0010\u0010}\u001a\u00020\\2\u0006\u0010y\u001a\u00020~H\u0002J\u0012\u0010\u007f\u001a\u00020\\2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0002R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010!\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b\"\u0010$R\u001b\u0010&\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\b'\u0010\u001fR\u001b\u0010)\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001b\u001a\u0004\b*\u0010\u0019R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u001b\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u001b\u001a\u0004\b5\u00106R\u001d\u00108\u001a\u0004\u0018\u0001098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u001b\u001a\u0004\b:\u0010;R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u001b\u001a\u0004\bA\u0010BR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u001b\u001a\u0004\bH\u0010IR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\u00020N8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR1\u0010Q\u001a\u0018\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020U0Rj\u0002`V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u001b\u001a\u0004\bW\u0010XR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/EmailConfirmFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "config", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lkotlin/Lazy;Lru/yoomoney/sdk/auth/ResultData;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "binding", "Lru/yoomoney/sdk/auth/databinding/AuthEmailConfirmBinding;", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthEmailConfirmBinding;", Scopes.EMAIL, "", "getEmail", "()Ljava/lang/String;", "email$delegate", "Lkotlin/Lazy;", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "expireAt$delegate", "fragmentBinding", "isCurrentUserAccountEmail", "", "()Z", "isCurrentUserAccountEmail$delegate", "nextResendFrom", "getNextResendFrom", "nextResendFrom$delegate", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "getProcessId", "processId$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "productType", "Lru/yoomoney/sdk/auth/Config$ProductType;", "getProductType", "()Lru/yoomoney/sdk/auth/Config$ProductType;", "productType$delegate", "remoteConfig", "Lru/yoomoney/sdk/auth/RemoteConfig;", "getRemoteConfig", "()Lru/yoomoney/sdk/auth/RemoteConfig;", "remoteConfig$delegate", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "retryActionView", "Lru/yoomoney/sdk/auth/ui/FlatButtonView;", "getRetryActionView", "()Lru/yoomoney/sdk/auth/ui/FlatButtonView;", "retryActionView$delegate", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "secretLength", "", "getSecretLength", "()I", "secretLength$delegate", "timer", "Lru/yoomoney/sdk/auth/utils/YmCountDownTimer;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect;", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirmViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "createRetryActionView", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onTimerFinish", "onTimerTick", "millisUntilFinished", "", "onViewCreated", "view", "setRetryAction", "setupRetry", "isEnabled", "setupViews", "showEffect", "effect", "showState", "state", "showStateInvalid", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State$Invalid;", "showStateProgress", "showStateValid", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State$Valid;", "startTimer", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "Lorg/threeten/bp/Duration;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EmailConfirmFragment extends BaseFragment {
    private final Lazy<Config> config;

    /* renamed from: email$delegate, reason: from kotlin metadata */
    private final Lazy email;

    /* renamed from: expireAt$delegate, reason: from kotlin metadata */
    private final Lazy expireAt;
    private AuthEmailConfirmBinding fragmentBinding;

    /* renamed from: isCurrentUserAccountEmail$delegate, reason: from kotlin metadata */
    private final Lazy isCurrentUserAccountEmail;

    /* renamed from: nextResendFrom$delegate, reason: from kotlin metadata */
    private final Lazy nextResendFrom;

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
    private final ResultData resultData;

    /* renamed from: retryActionView$delegate, reason: from kotlin metadata */
    private final Lazy retryActionView;
    private final Router router;

    /* renamed from: secretLength$delegate, reason: from kotlin metadata */
    private final Lazy secretLength;
    private final ServerTimeRepository serverTimeRepository;
    private final YmCountDownTimer timer;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public static final class a extends Lambda implements Function0<String> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = EmailConfirmFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            String email = EmailConfirmFragmentArgs.fromBundle(arguments).getEmail();
            Intrinsics.checkNotNullExpressionValue(email, "getEmail(...)");
            return email;
        }
    }

    public static final class b extends Lambda implements Function0<OffsetDateTime> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final OffsetDateTime invoke() {
            OffsetDateTime expireAt = EmailConfirmFragmentArgs.fromBundle(EmailConfirmFragment.this.requireArguments()).getExpireAt();
            Intrinsics.checkNotNullExpressionValue(expireAt, "getExpireAt(...)");
            return expireAt;
        }
    }

    public static final class c extends Lambda implements Function0<Boolean> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(EmailConfirmFragmentArgs.fromBundle(EmailConfirmFragment.this.requireArguments()).getIsCurrentUserAccountEmail());
        }
    }

    public static final class d extends Lambda implements Function0<OffsetDateTime> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final OffsetDateTime invoke() {
            Bundle arguments = EmailConfirmFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            OffsetDateTime nextResendFrom = EmailConfirmFragmentArgs.fromBundle(arguments).getNextResendFrom();
            Intrinsics.checkNotNullExpressionValue(nextResendFrom, "getNextResendFrom(...)");
            return nextResendFrom;
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function1<EmailConfirm.State, Unit> {
        public e(Object obj) {
            super(1, obj, EmailConfirmFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(EmailConfirm.State state) {
            EmailConfirm.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EmailConfirmFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class f extends FunctionReferenceImpl implements Function1<EmailConfirm.Effect, Unit> {
        public f(Object obj) {
            super(1, obj, EmailConfirmFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(EmailConfirm.Effect effect) throws Resources.NotFoundException {
            EmailConfirm.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EmailConfirmFragment) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Throwable, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            ConstraintLayout parent = EmailConfirmFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = EmailConfirmFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function0<String> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = EmailConfirmFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            String processId = EmailConfirmFragmentArgs.fromBundle(arguments).getProcessId();
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
            Bundle arguments = EmailConfirmFragment.this.getArguments();
            if (arguments == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            ProcessType processType = EmailConfirmFragmentArgs.fromBundle(arguments).getProcessType();
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
            return ((Config) EmailConfirmFragment.this.config.getValue()).getProductType();
        }
    }

    public static final class k extends Lambda implements Function0<RemoteConfig> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final RemoteConfig invoke() {
            return ((Config) EmailConfirmFragment.this.config.getValue()).getRemoteConfig();
        }
    }

    public static final class l extends Lambda implements Function0<FlatButtonView> {
        public l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final FlatButtonView invoke() {
            return (FlatButtonView) EmailConfirmFragment.this.requireView().findViewById(R.id.retry_action);
        }
    }

    public static final class m extends Lambda implements Function0<Integer> {
        public m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            Bundle arguments = EmailConfirmFragment.this.getArguments();
            if (arguments != null) {
                return Integer.valueOf(EmailConfirmFragmentArgs.fromBundle(arguments).getSecretLength());
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    public static final class n extends Lambda implements Function1<Bundle, Unit> {
        public n() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Bundle bundle) {
            Bundle it = bundle;
            Intrinsics.checkNotNullParameter(it, "it");
            it.putString(Scopes.EMAIL, EmailConfirmFragment.this.getEmail());
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class o extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public o(Object obj) {
            super(1, obj, EmailConfirmFragment.class, "onTimerTick", "onTimerTick(J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Long l) {
            ((EmailConfirmFragment) this.receiver).onTimerTick(l.longValue());
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class p extends FunctionReferenceImpl implements Function0<Unit> {
        public p(Object obj) {
            super(0, obj, EmailConfirmFragment.class, "onTimerFinish", "onTimerFinish()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ((EmailConfirmFragment) this.receiver).onTimerFinish();
            return Unit.INSTANCE;
        }
    }

    public static final class q extends Lambda implements Function0<ViewModelProvider.Factory> {
        public q() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return EmailConfirmFragment.this.viewModelFactory;
        }
    }

    public EmailConfirmFragment(ViewModelProvider.Factory viewModelFactory, Lazy<Config> config, ResultData resultData, ServerTimeRepository serverTimeRepository, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.viewModelFactory = viewModelFactory;
        this.config = config;
        this.resultData = resultData;
        this.serverTimeRepository = serverTimeRepository;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        q qVar = new q();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.email.confirm.EmailConfirmFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.email.confirm.EmailConfirmFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.email.confirm.EmailConfirmFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.email.confirm.EmailConfirmFragment$special$$inlined$viewModels$default$4
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
        }, qVar);
        this.email = LazyKt.lazy(new a());
        this.secretLength = LazyKt.lazy(new m());
        this.nextResendFrom = LazyKt.lazy(new d());
        this.processId = LazyKt.lazy(new h());
        this.processType = LazyKt.lazy(new i());
        this.expireAt = LazyKt.lazy(new b());
        this.isCurrentUserAccountEmail = LazyKt.lazy(new c());
        this.timer = new YmCountDownTimer(new o(this), new p(this));
        this.productType = LazyKt.lazy(new j());
        this.remoteConfig = LazyKt.lazy(new k());
        this.retryActionView = LazyKt.lazy(new l());
    }

    private final FlatButtonView createRetryActionView() {
        if (getProductType() == Config.ProductType.WEBBANKIR) {
            return new FlatButtonView(new ContextThemeWrapper(requireContext(), R.style.YmButton_Flat_Webbankir), null, 0, 2, null);
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        return new FlatButtonView(contextRequireContext, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthEmailConfirmBinding getBinding() {
        AuthEmailConfirmBinding authEmailConfirmBinding = this.fragmentBinding;
        if (authEmailConfirmBinding != null) {
            return authEmailConfirmBinding;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getEmail() {
        return (String) this.email.getValue();
    }

    private final OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.expireAt.getValue();
    }

    private final OffsetDateTime getNextResendFrom() {
        return (OffsetDateTime) this.nextResendFrom.getValue();
    }

    private final String getProcessId() {
        return (String) this.processId.getValue();
    }

    private final ProcessType getProcessType() {
        return (ProcessType) this.processType.getValue();
    }

    private final Config.ProductType getProductType() {
        return (Config.ProductType) this.productType.getValue();
    }

    private final RemoteConfig getRemoteConfig() {
        return (RemoteConfig) this.remoteConfig.getValue();
    }

    private final FlatButtonView getRetryActionView() {
        Object value = this.retryActionView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (FlatButtonView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSecretLength() {
        return ((Number) this.secretLength.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final boolean isCurrentUserAccountEmail() {
        return ((Boolean) this.isCurrentUserAccountEmail.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTimerFinish() {
        getViewModel().handleAction(EmailConfirm.Action.StopTimer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTimerTick(long millisUntilFinished) {
        long j2 = millisUntilFinished / 1000;
        long j3 = 60;
        String timeString = NumberExtensionsKt.toTimeString(j2 / j3);
        String timeString2 = NumberExtensionsKt.toTimeString(j2 % j3);
        getRetryActionView().setText(getString(R.string.auth_email_confirm_retry_timer_text, timeString + ":" + timeString2));
    }

    private final void setRetryAction() {
        FrameLayout frameLayout = getBinding().retryActionContainer;
        FlatButtonView flatButtonViewCreateRetryActionView = createRetryActionView();
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        flatButtonViewCreateRetryActionView.setId(R.id.retry_action);
        flatButtonViewCreateRetryActionView.setEnabled(false);
        flatButtonViewCreateRetryActionView.setLayoutParams(marginLayoutParams);
        frameLayout.addView(flatButtonViewCreateRetryActionView);
    }

    private final void setupRetry(boolean isEnabled) {
        getRetryActionView().setEnabled(isEnabled);
        if (isEnabled) {
            getRetryActionView().setText(getString(R.string.auth_email_confirm_retry_action_text));
        }
    }

    private final void setupViews() {
        String string;
        String string2;
        String emailConfirmOffersTitle;
        getBinding().appBar.setTitle("");
        TextTitle1View textTitle1View = getBinding().title;
        RemoteConfig remoteConfig = getRemoteConfig();
        if (remoteConfig == null || (string = remoteConfig.getEmailConfirmScreenTitle()) == null) {
            string = getString(R.string.auth_email_confirm_screen_title);
        }
        textTitle1View.setText(string);
        setRetryAction();
        Config.ProductType productType = getProductType();
        Config.ProductType productType2 = Config.ProductType.WEBBANKIR;
        if (productType == productType2 && getProcessType() != ProcessType.PASSWORD_RECOVERY) {
            getBinding().webbankirContainer.setVisibility(0);
            TextBodyView textBodyView = getBinding().description;
            RemoteConfig remoteConfig2 = getRemoteConfig();
            Spanned html = null;
            textBodyView.setText(remoteConfig2 != null ? remoteConfig2.getEmailConfirmScreenDescription() : null);
            ItemVectorFadeDetailView itemVectorFadeDetailView = getBinding().emailView;
            itemVectorFadeDetailView.setTitle(getEmail());
            itemVectorFadeDetailView.setLeftImage(AppCompatResources.getDrawable(requireContext(), R.drawable.auth_ic_contact_l));
            TextBodyView textBodyView2 = getBinding().otherEmail;
            RemoteConfig remoteConfig3 = getRemoteConfig();
            textBodyView2.setText(remoteConfig3 != null ? remoteConfig3.getEmailConfirmScreenOtherEmailTitle() : null);
            ColorScheme colorScheme = ColorScheme.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            textBodyView2.setTextColor(colorScheme.getAccentColor(contextRequireContext));
            textBodyView2.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.email.confirm.EmailConfirmFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmailConfirmFragment.setupViews$lambda$2$lambda$1(this.f$0, view);
                }
            });
            ItemSecondarySwitchView itemSecondarySwitchView = getBinding().offers;
            itemSecondarySwitchView.setVisibility(0);
            RemoteConfig remoteConfig4 = getRemoteConfig();
            if (remoteConfig4 != null && (emailConfirmOffersTitle = remoteConfig4.getEmailConfirmOffersTitle()) != null) {
                html = StringExtensionsKt.parseHtml(emailConfirmOffersTitle);
            }
            itemSecondarySwitchView.setText(html);
            itemSecondarySwitchView.setMovementMethod(LinkMovementMethod.getInstance());
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            itemSecondarySwitchView.setLinkTextColor(colorScheme.getAccentColor(contextRequireContext2));
            Context contextRequireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
            itemSecondarySwitchView.setHighlightColor(colorScheme.getAccentGhostColor(contextRequireContext3));
            Intrinsics.checkNotNull(itemSecondarySwitchView);
            TextViewExtentionsKt.removeLinkUnderline(itemSecondarySwitchView);
            itemSecondarySwitchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.yoomoney.sdk.auth.email.confirm.EmailConfirmFragment$$ExternalSyntheticLambda1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    EmailConfirmFragment.setupViews$lambda$4$lambda$3(this.f$0, compoundButton, z);
                }
            });
        }
        TextInputView textInputView = getBinding().code;
        if (getProcessType() == ProcessType.PASSWORD_RECOVERY) {
            string2 = getString(R.string.auth_email_confirm_label, getEmail());
        } else {
            RemoteConfig remoteConfig5 = getRemoteConfig();
            if (remoteConfig5 == null || (string2 = remoteConfig5.getEmailConfirmLabel()) == null) {
                string2 = getString(R.string.auth_email_confirm_label, getEmail());
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            }
        }
        textInputView.setLabel(string2);
        getBinding().code.getEditText().addTextChangedListener(new TextWatcher() { // from class: ru.yoomoney.sdk.auth.email.confirm.EmailConfirmFragment$setupViews$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.this$0.getViewModel().handleAction(new EmailConfirm.Action.CodeChanged(String.valueOf(s), this.this$0.getSecretLength()));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }
        });
        getRetryActionView().setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.email.confirm.EmailConfirmFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailConfirmFragment.setupViews$lambda$6(this.f$0, view);
            }
        });
        PrimaryButtonView primaryButtonView = getBinding().action;
        primaryButtonView.setText(getString(R.string.auth_email_confirm_action_text));
        primaryButtonView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.email.confirm.EmailConfirmFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailConfirmFragment.setupViews$lambda$8$lambda$7(this.f$0, view);
            }
        });
        if (getProductType() != productType2) {
            FlatButtonView flatButtonView = getBinding().forgotAction;
            Intrinsics.checkNotNull(flatButtonView);
            flatButtonView.setVisibility((getProcessType() == ProcessType.CHANGE_EMAIL && isCurrentUserAccountEmail()) ? 0 : 8);
            flatButtonView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.email.confirm.EmailConfirmFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmailConfirmFragment.setupViews$lambda$10$lambda$9(this.f$0, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$10$lambda$9(EmailConfirmFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new EmailConfirm.Action.Forgot(this$0.getProcessType(), this$0.getProcessId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$2$lambda$1(EmailConfirmFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(EmailConfirm.Action.ToEmailEntered.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$4$lambda$3(EmailConfirmFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new EmailConfirm.Action.OffersChecked(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$6(EmailConfirmFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new EmailConfirm.Action.Retry(this$0.getProcessType(), this$0.getProcessId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$8$lambda$7(EmailConfirmFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new EmailConfirm.Action.CheckExpiration(this$0.getProcessType(), this$0.getProcessId(), this$0.getExpireAt()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(EmailConfirm.Effect effect) throws Resources.NotFoundException {
        if (effect instanceof EmailConfirm.Effect.ShowNextStep) {
            this.resultData.setMarketingNewsLetterByEmailAccepted(getBinding().offers.isChecked());
            navigate$auth_release(((EmailConfirm.Effect.ShowNextStep) effect).getProcess(), new n());
            return;
        }
        if (effect instanceof EmailConfirm.Effect.ShowFailure) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            ConstraintLayout parent = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            CoreFragmentExtensions.handleFailure(this, childFragmentManager, parent, ((EmailConfirm.Effect.ShowFailure) effect).getFailure(), getResourceMapper());
            return;
        }
        if (effect instanceof EmailConfirm.Effect.ShowExpireDialog) {
            YmAlertDialog.DialogContent dialogContent = new YmAlertDialog.DialogContent(getString(R.string.auth_reset_process_dialog_title), getResourceMapper().resetProcessDialog(getProcessType()), getString(R.string.auth_reset_process_dialog_action), null, false, false, 56, null);
            AlertDialog.Companion companion = AlertDialog.INSTANCE;
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
            AlertDialog alertDialogCreate = companion.create(childFragmentManager2, dialogContent);
            alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.email.confirm.EmailConfirmFragment$showEffect$2$1
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
                    this.this$0.getViewModel().handleAction(EmailConfirm.Action.RestartProcess.INSTANCE);
                }
            });
            FragmentManager childFragmentManager3 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager3, "getChildFragmentManager(...)");
            alertDialogCreate.show(childFragmentManager3);
            return;
        }
        if (effect instanceof EmailConfirm.Effect.ResetProcess) {
            FragmentKt.findNavController(this).navigate(getRouter().reset());
        } else if (effect instanceof EmailConfirm.Effect.ShowHelp) {
            FragmentKt.findNavController(this).navigate(R.id.confirmationHelpFragment, BundleKt.bundleOf(TuplesKt.to(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, getString(R.string.auth_email_confirmation_help_title)), TuplesKt.to("description", getString(R.string.auth_email_confirmation_help_description))), getNavOptions());
        } else if (effect instanceof EmailConfirm.Effect.ToEmailEntered) {
            BaseFragment.navigate$auth_release$default(this, new EnrollmentProcessSetEmail(getProcessId(), getExpireAt(), false, null), (Function1) null, 2, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(EmailConfirm.State state) {
        if (state instanceof EmailConfirm.State.Valid) {
            showStateValid((EmailConfirm.State.Valid) state);
        } else if (state instanceof EmailConfirm.State.Invalid) {
            showStateInvalid((EmailConfirm.State.Invalid) state);
        } else {
            if (!(state instanceof EmailConfirm.State.Progress)) {
                throw new NoWhenBranchMatchedException();
            }
            showStateProgress();
        }
    }

    private final void showStateInvalid(EmailConfirm.State.Invalid state) {
        setupRetry(state.isEnabledRetry());
        getBinding().otherEmail.setEnabled(true);
        TextInputView textInputView = getBinding().code;
        ProcessError error = state.getError();
        textInputView.setError(error != null ? getResourceMapper().map(ProcessErrorExtensionsKt.toFailure(error)) : null);
        OffsetDateTime nextResendFrom = state.getNextResendFrom();
        if (nextResendFrom != null) {
            Duration durationBetween = Duration.between(this.serverTimeRepository.getCurrentDateTime(), nextResendFrom);
            Intrinsics.checkNotNullExpressionValue(durationBetween, "between(...)");
            startTimer(durationBetween);
        }
        getBinding().code.getEditText().setEnabled(true);
        ItemSecondarySwitchView itemSecondarySwitchView = getBinding().offers;
        itemSecondarySwitchView.setEnabled(true);
        itemSecondarySwitchView.setChecked(state.getOffersIsChecked());
        getBinding().action.setEnabled(false);
        ProgressBar progressBar = getBinding().progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        ViewExtensions.hide(progressBar);
    }

    private final void showStateProgress() {
        getBinding().otherEmail.setEnabled(false);
        getBinding().code.getEditText().setEnabled(false);
        getRetryActionView().setEnabled(false);
        getBinding().offers.setEnabled(false);
        getBinding().action.setEnabled(false);
        ProgressBar progressBar = getBinding().progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        ViewExtensions.show(progressBar);
    }

    private final void showStateValid(EmailConfirm.State.Valid state) {
        setupRetry(state.isEnabledRetry());
        TextInputView textInputView = getBinding().code;
        ProcessError error = state.getError();
        textInputView.setError(error != null ? getResourceMapper().map(ProcessErrorExtensionsKt.toFailure(error)) : null);
        OffsetDateTime nextResendFrom = state.getNextResendFrom();
        if (nextResendFrom != null) {
            Duration durationBetween = Duration.between(this.serverTimeRepository.getCurrentDateTime(), nextResendFrom);
            Intrinsics.checkNotNullExpressionValue(durationBetween, "between(...)");
            startTimer(durationBetween);
        }
        getBinding().otherEmail.setEnabled(true);
        getBinding().code.getEditText().setEnabled(true);
        getBinding().action.setEnabled(true);
        ItemSecondarySwitchView itemSecondarySwitchView = getBinding().offers;
        itemSecondarySwitchView.setEnabled(true);
        itemSecondarySwitchView.setChecked(state.getOffersIsChecked());
        ProgressBar progressBar = getBinding().progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        ViewExtensions.hide(progressBar);
    }

    private final void startTimer(Duration duration) {
        YmCountDownTimer ymCountDownTimer = this.timer;
        long millis = duration.toMillis();
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
        YmCountDownTimer.startTimer$default(ymCountDownTimer, millis, LifecycleKt.getCoroutineScope(lifecycle), 0L, null, 12, null);
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (getProductType() != Config.ProductType.WEBBANKIR) {
            inflater.inflate(R.menu.email_confirm_menu, menu);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.fragmentBinding = AuthEmailConfirmBinding.inflate(inflater, container, false);
        CoordinatorLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.timer.stopTimer();
        this.fragmentBinding = null;
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment, androidx.fragment.app.Fragment
    @Deprecated
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == R.id.help) {
            getViewModel().handleAction(EmailConfirm.Action.ShowHelp.INSTANCE);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupViews();
        Duration durationBetween = Duration.between(this.serverTimeRepository.getCurrentDateTime(), getNextResendFrom());
        Intrinsics.checkNotNullExpressionValue(durationBetween, "between(...)");
        startTimer(durationBetween);
        RuntimeViewModel<EmailConfirm.State, EmailConfirm.Action, EmailConfirm.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new e(this), new f(this), new g());
        getViewModel().handleAction(new EmailConfirm.Action.SendAnalyticsForScreen(getProcessType()));
    }
}
