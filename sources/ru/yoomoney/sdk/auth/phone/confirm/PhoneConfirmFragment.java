package ru.yoomoney.sdk.auth.phone.confirm;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import flussonic.media.FFmpegMediaMetadataRetriever;
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
import org.threeten.bp.Duration;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.model.Failure;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.base.BaseFragment;
import ru.yoomoney.sdk.auth.databinding.AuthPhoneConfirmBinding;
import ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm;
import ru.yoomoney.sdk.auth.phone.confirm.utils.PatternSmsParser;
import ru.yoomoney.sdk.auth.phone.confirm.utils.RetrieverSmsObserver;
import ru.yoomoney.sdk.auth.phone.confirm.utils.SmsObserver;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.ui.AlertDialog;
import ru.yoomoney.sdk.auth.ui.FlatButtonView;
import ru.yoomoney.sdk.auth.ui.ProgressBar;
import ru.yoomoney.sdk.auth.ui.TextInputView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.NumberExtensionsKt;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.auth.utils.YmCountDownTimer;
import ru.yoomoney.sdk.gui.dialog.YmAlertDialog;
import ru.yoomoney.sdk.gui.utils.extensions.ViewExtensions;
import ru.yoomoney.sdk.gui.widget.ConfirmCodeInputView;
import ru.yoomoney.sdk.gui.widget.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.text.TextBodyView;
import ru.yoomoney.sdk.gui.widget.text.TextCaption2View;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010V\u001a\u00020WH\u0002J\u0010\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0010\u0010[\u001a\u00020W2\u0006\u0010Y\u001a\u00020\\H\u0002J\b\u0010]\u001a\u00020WH\u0002J\u0018\u0010^\u001a\u00020W2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020bH\u0017J$\u0010c\u001a\u00020d2\u0006\u0010a\u001a\u00020e2\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010iH\u0016J\b\u0010j\u001a\u00020WH\u0016J\u0010\u0010k\u001a\u00020\u001f2\u0006\u0010l\u001a\u00020mH\u0017J\b\u0010n\u001a\u00020WH\u0016J\b\u0010o\u001a\u00020WH\u0016J\u0010\u0010p\u001a\u00020W2\u0006\u0010q\u001a\u00020&H\u0016J\b\u0010r\u001a\u00020WH\u0002J\u0010\u0010s\u001a\u00020W2\u0006\u0010t\u001a\u00020uH\u0002J\u001a\u0010v\u001a\u00020W2\u0006\u0010w\u001a\u00020d2\b\u0010h\u001a\u0004\u0018\u00010iH\u0016J\u0010\u0010x\u001a\u00020W2\u0006\u0010y\u001a\u00020&H\u0002J\b\u0010z\u001a\u00020WH\u0002J\u0010\u0010{\u001a\u00020W2\u0006\u0010|\u001a\u00020QH\u0002J\u0010\u0010}\u001a\u00020W2\u0006\u0010~\u001a\u00020\u007fH\u0002J\u0011\u0010\u0080\u0001\u001a\u00020W2\u0006\u0010Y\u001a\u00020OH\u0002J\u0013\u0010\u0081\u0001\u001a\u00020W2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\u0012\u0010\u0084\u0001\u001a\u00020W2\u0007\u0010\u0085\u0001\u001a\u00020\u001fH\u0002J$\u0010\u0086\u0001\u001a\u00020W2\u0007\u0010\u0087\u0001\u001a\u00020u2\u0007\u0010\u0088\u0001\u001a\u00020&2\u0007\u0010\u0089\u0001\u001a\u00020&H\u0002R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\u001e\u0010 R\u001b\u0010\"\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b#\u0010\u001bR\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b+\u0010(R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u001d\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u001d\u001a\u0004\b6\u00107R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001b\u0010=\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u001d\u001a\u0004\b?\u0010@R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010B\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u001d\u001a\u0004\bD\u0010ER\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\u00020J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR1\u0010M\u001a\u0018\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020Q0Nj\u0002`R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u001d\u001a\u0004\bS\u0010TR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008a\u0001"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirmFragment;", "Lru/yoomoney/sdk/auth/base/BaseFragment;", "Lru/yoomoney/sdk/auth/phone/confirm/utils/SmsObserver$Listener;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "config", "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "router", "Lru/yoomoney/sdk/auth/router/Router;", "processMapper", "Lru/yoomoney/sdk/auth/router/ProcessMapper;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lkotlin/Lazy;Lru/yoomoney/sdk/auth/ResultData;Lru/yoomoney/sdk/auth/router/Router;Lru/yoomoney/sdk/auth/router/ProcessMapper;Lru/yoomoney/sdk/auth/utils/ResourceMapper;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "_binding", "Lru/yoomoney/sdk/auth/databinding/AuthPhoneConfirmBinding;", "binding", "getBinding", "()Lru/yoomoney/sdk/auth/databinding/AuthPhoneConfirmBinding;", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "getExpireAt", "()Lorg/threeten/bp/OffsetDateTime;", "expireAt$delegate", "Lkotlin/Lazy;", "isLongSecretCode", "", "()Z", "isLongSecretCode$delegate", "nextResendFrom", "getNextResendFrom", "nextResendFrom$delegate", "phone", "", "getPhone", "()Ljava/lang/String;", "phone$delegate", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "getProcessId", "processId$delegate", "getProcessMapper", "()Lru/yoomoney/sdk/auth/router/ProcessMapper;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "getProcessType", "()Lru/yoomoney/sdk/auth/api/ProcessType;", "processType$delegate", "productType", "Lru/yoomoney/sdk/auth/Config$ProductType;", "getProductType", "()Lru/yoomoney/sdk/auth/Config$ProductType;", "productType$delegate", "getResourceMapper", "()Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "getRouter", "()Lru/yoomoney/sdk/auth/router/Router;", "secretLength", "", "getSecretLength", "()I", "secretLength$delegate", "smsObserver", "Lru/yoomoney/sdk/auth/phone/confirm/utils/RetrieverSmsObserver;", "getSmsObserver", "()Lru/yoomoney/sdk/auth/phone/confirm/utils/RetrieverSmsObserver;", "smsObserver$delegate", "timer", "Lru/yoomoney/sdk/auth/utils/YmCountDownTimer;", "topBar", "Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/gui/widget/TopBarDefault;", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect;", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirmViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "enableInput", "", "handleContentState", "state", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State$Content;", "handleProgressState", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State$Progress;", "hideError", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPause", "onResume", "onSmsAnswer", "answer", "onTimerFinish", "onTimerTick", "millisUntilFinished", "", "onViewCreated", "view", "setCode", "code", "setupViews", "showEffect", "effect", "showError", YooMoneyAuth.KEY_FAILURE, "Lru/yoomoney/sdk/auth/api/model/Failure;", "showState", "startTimer", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "Lorg/threeten/bp/Duration;", "updateCodeContentDescription", "showDefaultDescription", "updateTimerContentDescription", "secondsNow", "minutes", "seconds", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneConfirmFragment extends BaseFragment implements SmsObserver.Listener {
    private AuthPhoneConfirmBinding _binding;
    private final Lazy<Config> config;

    /* renamed from: expireAt$delegate, reason: from kotlin metadata */
    private final Lazy expireAt;

    /* renamed from: isLongSecretCode$delegate, reason: from kotlin metadata */
    private final Lazy isLongSecretCode;

    /* renamed from: nextResendFrom$delegate, reason: from kotlin metadata */
    private final Lazy nextResendFrom;

    /* renamed from: phone$delegate, reason: from kotlin metadata */
    private final Lazy phone;

    /* renamed from: processId$delegate, reason: from kotlin metadata */
    private final Lazy processId;
    private final ProcessMapper processMapper;

    /* renamed from: processType$delegate, reason: from kotlin metadata */
    private final Lazy processType;

    /* renamed from: productType$delegate, reason: from kotlin metadata */
    private final Lazy productType;
    private final ResourceMapper resourceMapper;
    private final ResultData resultData;
    private final Router router;

    /* renamed from: secretLength$delegate, reason: from kotlin metadata */
    private final Lazy secretLength;
    private final ServerTimeRepository serverTimeRepository;

    /* renamed from: smsObserver$delegate, reason: from kotlin metadata */
    private final Lazy smsObserver;
    private final YmCountDownTimer timer;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public static final class a extends Lambda implements Function0<OffsetDateTime> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final OffsetDateTime invoke() {
            OffsetDateTime expireAt = PhoneConfirmFragmentArgs.fromBundle(PhoneConfirmFragment.this.requireArguments()).getExpireAt();
            Intrinsics.checkNotNullExpressionValue(expireAt, "getExpireAt(...)");
            return expireAt;
        }
    }

    public static final class b extends Lambda implements Function0<Boolean> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(PhoneConfirmFragment.this.getSecretLength() > 6);
        }
    }

    public static final class c extends Lambda implements Function0<OffsetDateTime> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final OffsetDateTime invoke() {
            OffsetDateTime nextResendFrom = PhoneConfirmFragmentArgs.fromBundle(PhoneConfirmFragment.this.requireArguments()).getNextResendFrom();
            Intrinsics.checkNotNullExpressionValue(nextResendFrom, "getNextResendFrom(...)");
            return nextResendFrom;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<PhoneConfirm.State, Unit> {
        public d(Object obj) {
            super(1, obj, PhoneConfirmFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PhoneConfirm.State state) {
            PhoneConfirm.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PhoneConfirmFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function1<PhoneConfirm.Effect, Unit> {
        public e(Object obj) {
            super(1, obj, PhoneConfirmFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PhoneConfirm.Effect effect) throws Resources.NotFoundException {
            PhoneConfirm.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PhoneConfirmFragment) this.receiver).showEffect(p0);
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
            ConstraintLayout parent = PhoneConfirmFragment.this.getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            String string = PhoneConfirmFragment.this.getString(R.string.auth_default_error);
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
            return PhoneConfirmFragmentArgs.fromBundle(PhoneConfirmFragment.this.requireArguments()).getPhone();
        }
    }

    public static final class h extends Lambda implements Function0<String> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String processId = PhoneConfirmFragmentArgs.fromBundle(PhoneConfirmFragment.this.requireArguments()).getProcessId();
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
            ProcessType processType = PhoneConfirmFragmentArgs.fromBundle(PhoneConfirmFragment.this.requireArguments()).getProcessType();
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
            return ((Config) PhoneConfirmFragment.this.config.getValue()).getProductType();
        }
    }

    public static final class k extends Lambda implements Function0<Integer> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(PhoneConfirmFragmentArgs.fromBundle(PhoneConfirmFragment.this.requireArguments()).getSecretLength());
        }
    }

    public static final class l extends Lambda implements Function1<String, Unit> {
        public l() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String str) {
            String value = str;
            Intrinsics.checkNotNullParameter(value, "value");
            PhoneConfirmFragment.this.updateCodeContentDescription(value.length() == 0);
            PhoneConfirmFragment.this.getViewModel().handleAction(new PhoneConfirm.Action.CodeChanged(value, PhoneConfirmFragment.this.getSecretLength(), PhoneConfirmFragment.this.getProcessType(), PhoneConfirmFragment.this.getProcessId(), PhoneConfirmFragment.this.getExpireAt()));
            return Unit.INSTANCE;
        }
    }

    public static final class m extends Lambda implements Function0<RetrieverSmsObserver> {
        public m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final RetrieverSmsObserver invoke() {
            Context contextRequireContext = PhoneConfirmFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            return new RetrieverSmsObserver(contextRequireContext);
        }
    }

    public /* synthetic */ class n extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public n(Object obj) {
            super(1, obj, PhoneConfirmFragment.class, "onTimerTick", "onTimerTick(J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Long l) throws Resources.NotFoundException {
            ((PhoneConfirmFragment) this.receiver).onTimerTick(l.longValue());
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class o extends FunctionReferenceImpl implements Function0<Unit> {
        public o(Object obj) {
            super(0, obj, PhoneConfirmFragment.class, "onTimerFinish", "onTimerFinish()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ((PhoneConfirmFragment) this.receiver).onTimerFinish();
            return Unit.INSTANCE;
        }
    }

    public static final class p extends Lambda implements Function0<ViewModelProvider.Factory> {
        public p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return PhoneConfirmFragment.this.viewModelFactory;
        }
    }

    public PhoneConfirmFragment(ViewModelProvider.Factory viewModelFactory, Lazy<Config> config, ResultData resultData, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(processMapper, "processMapper");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.viewModelFactory = viewModelFactory;
        this.config = config;
        this.resultData = resultData;
        this.router = router;
        this.processMapper = processMapper;
        this.resourceMapper = resourceMapper;
        this.serverTimeRepository = serverTimeRepository;
        p pVar = new p();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirmFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirmFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirmFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirmFragment$special$$inlined$viewModels$default$4
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
        }, pVar);
        this.smsObserver = LazyKt.lazy(new m());
        this.phone = LazyKt.lazy(new g());
        this.secretLength = LazyKt.lazy(new k());
        this.nextResendFrom = LazyKt.lazy(new c());
        this.processId = LazyKt.lazy(new h());
        this.isLongSecretCode = LazyKt.lazy(new b());
        this.processType = LazyKt.lazy(new i());
        this.expireAt = LazyKt.lazy(new a());
        this.productType = LazyKt.lazy(new j());
        this.timer = new YmCountDownTimer(new n(this), new o(this));
    }

    private final void enableInput() {
        if (isLongSecretCode()) {
            getBinding().confirmCodeDefault.getEditText().setEnabled(true);
        } else {
            getBinding().confirmCodeCustom.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthPhoneConfirmBinding getBinding() {
        AuthPhoneConfirmBinding authPhoneConfirmBinding = this._binding;
        Intrinsics.checkNotNull(authPhoneConfirmBinding);
        return authPhoneConfirmBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OffsetDateTime getExpireAt() {
        return (OffsetDateTime) this.expireAt.getValue();
    }

    private final OffsetDateTime getNextResendFrom() {
        return (OffsetDateTime) this.nextResendFrom.getValue();
    }

    private final String getPhone() {
        return (String) this.phone.getValue();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSecretLength() {
        return ((Number) this.secretLength.getValue()).intValue();
    }

    private final RetrieverSmsObserver getSmsObserver() {
        return (RetrieverSmsObserver) this.smsObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<PhoneConfirm.State, PhoneConfirm.Action, PhoneConfirm.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void handleContentState(PhoneConfirm.State.Content state) {
        Unit unit;
        enableInput();
        setCode(state.getConfirmCode());
        Failure error = state.getError();
        if (error != null) {
            showError(error);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            hideError();
        }
        OffsetDateTime nextResendFrom = state.getNextResendFrom();
        if (nextResendFrom != null) {
            Duration durationBetween = Duration.between(this.serverTimeRepository.getCurrentDateTime(), nextResendFrom);
            Intrinsics.checkNotNullExpressionValue(durationBetween, "between(...)");
            startTimer(durationBetween);
        }
        if (state.isEnabledRetryAction()) {
            getBinding().retryAction.setText(getString(R.string.auth_phone_confirm_retry_action_text));
            getBinding().retryAction.setImportantForAccessibility(1);
        }
        getBinding().retryAction.setEnabled(state.isEnabledRetryAction());
        ProgressBar progressBar = getBinding().progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        ViewExtensions.hide(progressBar);
    }

    private final void handleProgressState(PhoneConfirm.State.Progress state) {
        if (state.isEnabledRetryAction()) {
            getBinding().retryAction.setText(getString(R.string.auth_phone_confirm_retry_action_text));
            getBinding().retryAction.setImportantForAccessibility(1);
        }
        if (isLongSecretCode()) {
            getBinding().confirmCodeDefault.getEditText().setEnabled(false);
        } else {
            getBinding().confirmCodeCustom.setEnabled(false);
        }
        getBinding().retryAction.setEnabled(false);
        ProgressBar progressBar = getBinding().progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        ViewExtensions.show(progressBar);
    }

    private final void hideError() {
        if (isLongSecretCode()) {
            getBinding().confirmCodeDefault.setError(null);
            return;
        }
        getBinding().errorCustom.setText((CharSequence) null);
        TextCaption2View errorCustom = getBinding().errorCustom;
        Intrinsics.checkNotNullExpressionValue(errorCustom, "errorCustom");
        ViewExtensions.hide(errorCustom);
    }

    private final boolean isLongSecretCode() {
        return ((Boolean) this.isLongSecretCode.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTimerFinish() {
        getViewModel().handleAction(PhoneConfirm.Action.StopTimer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTimerTick(long millisUntilFinished) throws Resources.NotFoundException {
        if (isVisible()) {
            long j2 = millisUntilFinished / 1000;
            long j3 = 60;
            String timeString = NumberExtensionsKt.toTimeString(j2 / j3);
            String timeString2 = NumberExtensionsKt.toTimeString(j2 % j3);
            getBinding().retryAction.setText(getString(R.string.auth_phone_confirm_retry_timer_text, timeString + ":" + timeString2));
            updateTimerContentDescription(j2, timeString, timeString2);
        }
    }

    private final void setCode(String code) {
        if (isLongSecretCode()) {
            if (Intrinsics.areEqual(String.valueOf(getBinding().confirmCodeDefault.getEditText().getText()), code)) {
                return;
            }
            getBinding().confirmCodeDefault.getEditText().setText(code);
        } else {
            if (Intrinsics.areEqual(getBinding().confirmCodeCustom.getValue(), code)) {
                return;
            }
            getBinding().confirmCodeCustom.setValue(code);
        }
    }

    private final void setupViews() {
        updateCodeContentDescription(true);
        if (isLongSecretCode()) {
            ConfirmCodeInputView confirmCodeCustom = getBinding().confirmCodeCustom;
            Intrinsics.checkNotNullExpressionValue(confirmCodeCustom, "confirmCodeCustom");
            ViewExtensions.hide(confirmCodeCustom);
            TextBodyView descriptionCustom = getBinding().descriptionCustom;
            Intrinsics.checkNotNullExpressionValue(descriptionCustom, "descriptionCustom");
            ViewExtensions.hide(descriptionCustom);
            if (getPhone() != null) {
                getBinding().descriptionDefault.setText(getString(R.string.auth_phone_confirm_description, getPhone()));
                TextBodyView descriptionDefault = getBinding().descriptionDefault;
                Intrinsics.checkNotNullExpressionValue(descriptionDefault, "descriptionDefault");
                ViewExtensions.show(descriptionDefault);
            }
            getBinding().confirmCodeDefault.setLabel(getString(R.string.auth_phone_confirm_default_input_label, String.valueOf(getSecretLength())));
            getBinding().confirmCodeDefault.getEditText().setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(getSecretLength())});
            getBinding().confirmCodeDefault.getEditText().addTextChangedListener(new TextWatcher() { // from class: ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirmFragment$setupViews$$inlined$addTextChangedListener$default$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    this.this$0.updateCodeContentDescription(String.valueOf(s).length() == 0);
                    this.this$0.getViewModel().handleAction(new PhoneConfirm.Action.CodeChanged(String.valueOf(s), this.this$0.getSecretLength(), this.this$0.getProcessType(), this.this$0.getProcessId(), this.this$0.getExpireAt()));
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence text, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence text, int start, int before, int count) {
                }
            });
            TextInputView confirmCodeDefault = getBinding().confirmCodeDefault;
            Intrinsics.checkNotNullExpressionValue(confirmCodeDefault, "confirmCodeDefault");
            ViewExtensions.show(confirmCodeDefault);
        } else {
            if (getPhone() != null) {
                getBinding().descriptionCustom.setText(getString(R.string.auth_phone_confirm_description, getPhone()));
            }
            getBinding().confirmCodeCustom.setMaxLength(getSecretLength());
            getBinding().confirmCodeCustom.setOnValueChangedListener(new l());
        }
        getBinding().retryAction.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirmFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneConfirmFragment.setupViews$lambda$3(this.f$0, view);
            }
        });
        FlatButtonView flatButtonView = getBinding().forgotAction;
        Intrinsics.checkNotNull(flatButtonView);
        flatButtonView.setVisibility(getProcessType() == ProcessType.CHANGE_EMAIL ? 0 : 8);
        flatButtonView.setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirmFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneConfirmFragment.setupViews$lambda$5$lambda$4(this.f$0, view);
            }
        });
        RetrieverSmsObserver smsObserver = getSmsObserver();
        smsObserver.setListener(this);
        smsObserver.init(new PatternSmsParser(getSecretLength()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$3(PhoneConfirmFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new PhoneConfirm.Action.Retry(this$0.getProcessType(), this$0.getProcessId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$5$lambda$4(PhoneConfirmFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(new PhoneConfirm.Action.Forgot(this$0.getProcessType(), this$0.getProcessId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(PhoneConfirm.Effect effect) throws Resources.NotFoundException {
        if (effect instanceof PhoneConfirm.Effect.ShowNextStep) {
            this.resultData.setPhone(getPhone());
            BaseFragment.navigate$auth_release$default(this, ((PhoneConfirm.Effect.ShowNextStep) effect).getProcess(), (Function1) null, 2, (Object) null);
            return;
        }
        if (effect instanceof PhoneConfirm.Effect.ShowFailure) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            ConstraintLayout parent = getBinding().parent;
            Intrinsics.checkNotNullExpressionValue(parent, "parent");
            CoreFragmentExtensions.handleFailure(this, childFragmentManager, parent, ((PhoneConfirm.Effect.ShowFailure) effect).getFailure(), getResourceMapper());
            return;
        }
        if (!(effect instanceof PhoneConfirm.Effect.ShowExpireDialog)) {
            if (effect instanceof PhoneConfirm.Effect.ResetProcess) {
                FragmentKt.findNavController(this).navigate(getRouter().reset());
                return;
            } else {
                if (Intrinsics.areEqual(effect, PhoneConfirm.Effect.ShowHelp.INSTANCE)) {
                    FragmentKt.findNavController(this).navigate(R.id.confirmationHelpFragment, BundleKt.bundleOf(TuplesKt.to(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, getString(R.string.auth_phone_confirmation_help_title)), TuplesKt.to("description", getString(R.string.auth_phone_confirmation_help_description))), getNavOptions());
                    return;
                }
                return;
            }
        }
        YmAlertDialog.DialogContent dialogContent = new YmAlertDialog.DialogContent(getString(R.string.auth_reset_process_dialog_title), getResourceMapper().resetProcessDialog(getProcessType()), getString(R.string.auth_reset_process_dialog_action), null, false, false, 56, null);
        AlertDialog.Companion companion = AlertDialog.INSTANCE;
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        AlertDialog alertDialogCreate = companion.create(childFragmentManager2, dialogContent);
        alertDialogCreate.attachListener(new YmAlertDialog.DialogListener() { // from class: ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirmFragment$showEffect$1$1
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
                this.this$0.getViewModel().handleAction(PhoneConfirm.Action.RestartProcess.INSTANCE);
            }
        });
        FragmentManager childFragmentManager3 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager3, "getChildFragmentManager(...)");
        alertDialogCreate.show(childFragmentManager3);
    }

    private final void showError(Failure failure) {
        String map = getResourceMapper().map(failure);
        if (isLongSecretCode()) {
            getBinding().confirmCodeDefault.setError(map);
            return;
        }
        getBinding().errorCustom.setText(map);
        TextCaption2View errorCustom = getBinding().errorCustom;
        Intrinsics.checkNotNullExpressionValue(errorCustom, "errorCustom");
        ViewExtensions.show(errorCustom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(PhoneConfirm.State state) {
        if (state instanceof PhoneConfirm.State.Content) {
            handleContentState((PhoneConfirm.State.Content) state);
        } else if (state instanceof PhoneConfirm.State.Progress) {
            handleProgressState((PhoneConfirm.State.Progress) state);
        }
    }

    private final void startTimer(Duration duration) {
        YmCountDownTimer ymCountDownTimer = this.timer;
        long millis = duration.toMillis();
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
        YmCountDownTimer.startTimer$default(ymCountDownTimer, millis, LifecycleKt.getCoroutineScope(lifecycle), 0L, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCodeContentDescription(boolean showDefaultDescription) {
        getBinding().confirmCodeCustom.setContentDescription(showDefaultDescription ? getString(R.string.auth_login_enter_sms_code_description) : null);
    }

    private final void updateTimerContentDescription(long secondsNow, String minutes, String seconds) throws Resources.NotFoundException {
        getBinding().retryAction.setText(getString(R.string.auth_phone_confirm_retry_timer_text, minutes + ":" + seconds));
        getBinding().retryAction.setImportantForAccessibility(4);
        long j2 = (long) 60;
        int i2 = (int) (secondsNow / j2);
        int i3 = (int) (secondsNow % j2);
        getBinding().linearForRetryAction.setContentDescription(getString(R.string.auth_phone_confirm_retry_timer_text_content_description) + getResources().getQuantityString(R.plurals.time_minute, i2, Integer.valueOf(i2)) + getResources().getQuantityString(R.plurals.time_second, i3, Integer.valueOf(i3)));
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
            inflater.inflate(R.menu.phone_confirm_menu, menu);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AuthPhoneConfirmBinding.inflate(inflater, container, false);
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
    @Deprecated
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == R.id.help) {
            getViewModel().handleAction(PhoneConfirm.Action.ShowHelp.INSTANCE);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getSmsObserver().stopObserver();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getSmsObserver().startObserver();
    }

    @Override // ru.yoomoney.sdk.auth.phone.confirm.utils.SmsObserver.Listener
    public void onSmsAnswer(String answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        getViewModel().handleAction(new PhoneConfirm.Action.CodeChanged(answer, getSecretLength(), getProcessType(), getProcessId(), getExpireAt()));
    }

    @Override // ru.yoomoney.sdk.auth.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupViews();
        Duration durationBetween = Duration.between(this.serverTimeRepository.getCurrentDateTime(), getNextResendFrom());
        Intrinsics.checkNotNullExpressionValue(durationBetween, "between(...)");
        startTimer(durationBetween);
        RuntimeViewModel<PhoneConfirm.State, PhoneConfirm.Action, PhoneConfirm.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new d(this), new e(this), new f());
        getViewModel().handleAction(new PhoneConfirm.Action.SendAnalyticsForScreen(getProcessType()));
    }
}
