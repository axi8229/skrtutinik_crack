package ru.yoomoney.sdk.auth.qrAuth.info;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.os.BundleKt;
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
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcherKt;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.QrAuthConfig;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorker;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo;
import ru.yoomoney.sdk.auth.ui.ColorScheme;
import ru.yoomoney.sdk.auth.ui.EmptyStateLargeView;
import ru.yoomoney.sdk.auth.utils.CoreFragmentExtensions;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.gui.utils.extensions.DrawableExtensions;
import ru.yoomoney.sdk.gui.widget.StateFlipViewGroup;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010@\u001a\u00020AH\u0002J\u0012\u0010B\u001a\u00020A2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u001a\u0010E\u001a\u00020A2\u0006\u0010F\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010G\u001a\u00020AH\u0002J\b\u0010H\u001a\u00020AH\u0003J\u0010\u0010I\u001a\u00020A2\u0006\u0010J\u001a\u00020;H\u0002J\u0010\u0010K\u001a\u00020A2\u0006\u0010L\u001a\u000209H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0018\u0010\nR\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b \u0010\u0010R\u001b\u0010\"\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b#\u0010\nR\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\f\u001a\u0004\b'\u0010(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\f\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\f\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\f\u001a\u0004\b5\u00102R1\u00107\u001a\u0018\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;08j\u0002`<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\f\u001a\u0004\b=\u0010>R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfoFragment;", "Landroidx/fragment/app/Fragment;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "resourceMapper", "Lru/yoomoney/sdk/auth/utils/ResourceMapper;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lru/yoomoney/sdk/auth/utils/ResourceMapper;)V", "acceptButton", "Landroid/view/View;", "getAcceptButton", "()Landroid/view/View;", "acceptButton$delegate", "Lkotlin/Lazy;", "close", "Landroid/widget/ImageView;", "getClose", "()Landroid/widget/ImageView;", "close$delegate", "config", "Lru/yoomoney/sdk/auth/Config;", "getConfig", "()Lru/yoomoney/sdk/auth/Config;", "config$delegate", "denyButton", "getDenyButton", "denyButton$delegate", "errorContainer", "Lru/yoomoney/sdk/auth/ui/EmptyStateLargeView;", "getErrorContainer", "()Lru/yoomoney/sdk/auth/ui/EmptyStateLargeView;", "errorContainer$delegate", "logo", "getLogo", "logo$delegate", "parent", "getParent", "parent$delegate", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "getProcessId", "()Ljava/lang/String;", "processId$delegate", "stateFlipper", "Lru/yoomoney/sdk/gui/widget/StateFlipViewGroup;", "getStateFlipper", "()Lru/yoomoney/sdk/gui/widget/StateFlipViewGroup;", "stateFlipper$delegate", "subtitle", "Landroid/widget/TextView;", "getSubtitle", "()Landroid/widget/TextView;", "subtitle$delegate", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "title$delegate", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$State;", "Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$Action;", "Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$Effect;", "Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "enqueueDeclineWorker", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setUpClose", "setUpContent", "showEffect", "effect", "showState", "state", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrAuthInfoFragment extends Fragment {

    /* renamed from: acceptButton$delegate, reason: from kotlin metadata */
    private final Lazy acceptButton;

    /* renamed from: close$delegate, reason: from kotlin metadata */
    private final Lazy close;

    /* renamed from: config$delegate, reason: from kotlin metadata */
    private final Lazy config;

    /* renamed from: denyButton$delegate, reason: from kotlin metadata */
    private final Lazy denyButton;

    /* renamed from: errorContainer$delegate, reason: from kotlin metadata */
    private final Lazy errorContainer;

    /* renamed from: logo$delegate, reason: from kotlin metadata */
    private final Lazy logo;

    /* renamed from: parent$delegate, reason: from kotlin metadata */
    private final Lazy parent;

    /* renamed from: processId$delegate, reason: from kotlin metadata */
    private final Lazy processId;
    private final ResourceMapper resourceMapper;

    /* renamed from: stateFlipper$delegate, reason: from kotlin metadata */
    private final Lazy stateFlipper;

    /* renamed from: subtitle$delegate, reason: from kotlin metadata */
    private final Lazy subtitle;

    /* renamed from: title$delegate, reason: from kotlin metadata */
    private final Lazy title;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final ViewModelProvider.Factory viewModelFactory;

    public static final class a extends Lambda implements Function0<View> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            View viewFindViewById = QrAuthInfoFragment.this.requireView().findViewById(R.id.primaryAction);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.View");
            return viewFindViewById;
        }
    }

    public static final class b extends Lambda implements Function0<ImageView> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ImageView invoke() {
            View viewFindViewById = QrAuthInfoFragment.this.requireView().findViewById(R.id.close);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageView");
            return (ImageView) viewFindViewById;
        }
    }

    public static final class c extends Lambda implements Function0<Config> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Config invoke() {
            return QrAuthInfoFragmentArgs.fromBundle(QrAuthInfoFragment.this.requireArguments()).getConfig();
        }
    }

    public static final class d extends Lambda implements Function0<View> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            View viewFindViewById = QrAuthInfoFragment.this.requireView().findViewById(R.id.secondaryAction);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.View");
            return viewFindViewById;
        }
    }

    public static final class e extends Lambda implements Function0<EmptyStateLargeView> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final EmptyStateLargeView invoke() {
            View viewFindViewById = QrAuthInfoFragment.this.requireView().findViewById(R.id.error_container);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.ui.EmptyStateLargeView");
            return (EmptyStateLargeView) viewFindViewById;
        }
    }

    public static final class f extends Lambda implements Function0<ImageView> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ImageView invoke() {
            View viewFindViewById = QrAuthInfoFragment.this.requireView().findViewById(R.id.logo);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageView");
            return (ImageView) viewFindViewById;
        }
    }

    public static final class g extends Lambda implements Function1<OnBackPressedCallback, Unit> {
        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(OnBackPressedCallback onBackPressedCallback) {
            OnBackPressedCallback addCallback = onBackPressedCallback;
            Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
            QrAuthInfoFragment.this.getViewModel().handleAction(QrAuthInfo.Action.Close.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class h extends FunctionReferenceImpl implements Function1<QrAuthInfo.State, Unit> {
        public h(Object obj) {
            super(1, obj, QrAuthInfoFragment.class, "showState", "showState(Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(QrAuthInfo.State state) {
            QrAuthInfo.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((QrAuthInfoFragment) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class i extends FunctionReferenceImpl implements Function1<QrAuthInfo.Effect, Unit> {
        public i(Object obj) {
            super(1, obj, QrAuthInfoFragment.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(QrAuthInfo.Effect effect) throws Throwable {
            QrAuthInfo.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((QrAuthInfoFragment) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Throwable, Unit> {
        public j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            View parent = QrAuthInfoFragment.this.getParent();
            String string = QrAuthInfoFragment.this.getString(R.string.auth_default_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CoreFragmentExtensions.noticeError(parent, string);
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function0<View> {
        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            View viewFindViewById = QrAuthInfoFragment.this.requireView().findViewById(R.id.parent);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.View");
            return viewFindViewById;
        }
    }

    public static final class l extends Lambda implements Function0<String> {
        public l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return QrAuthInfoFragmentArgs.fromBundle(QrAuthInfoFragment.this.requireArguments()).getProcessId();
        }
    }

    public static final class m extends Lambda implements Function0<Unit> {
        public m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            RuntimeViewModel viewModel = QrAuthInfoFragment.this.getViewModel();
            String processId = QrAuthInfoFragment.this.getProcessId();
            Intrinsics.checkNotNullExpressionValue(processId, "access$getProcessId(...)");
            viewModel.handleAction(new QrAuthInfo.Action.LoadInfo(processId));
            return Unit.INSTANCE;
        }
    }

    public static final class n extends Lambda implements Function0<Unit> {
        public n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            RuntimeViewModel viewModel = QrAuthInfoFragment.this.getViewModel();
            String processId = QrAuthInfoFragment.this.getProcessId();
            Intrinsics.checkNotNullExpressionValue(processId, "access$getProcessId(...)");
            viewModel.handleAction(new QrAuthInfo.Action.Accept(processId));
            return Unit.INSTANCE;
        }
    }

    public static final class o extends Lambda implements Function0<StateFlipViewGroup> {
        public o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final StateFlipViewGroup invoke() {
            View viewFindViewById = QrAuthInfoFragment.this.requireView().findViewById(R.id.stateFlipper);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type ru.yoomoney.sdk.gui.widget.StateFlipViewGroup");
            return (StateFlipViewGroup) viewFindViewById;
        }
    }

    public static final class p extends Lambda implements Function0<TextView> {
        public p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final TextView invoke() {
            View viewFindViewById = QrAuthInfoFragment.this.requireView().findViewById(R.id.subtitle);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
            return (TextView) viewFindViewById;
        }
    }

    public static final class q extends Lambda implements Function0<TextView> {
        public q() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final TextView invoke() {
            View viewFindViewById = QrAuthInfoFragment.this.requireView().findViewById(R.id.title);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
            return (TextView) viewFindViewById;
        }
    }

    public static final class r extends Lambda implements Function0<ViewModelProvider.Factory> {
        public r() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return QrAuthInfoFragment.this.viewModelFactory;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrAuthInfoFragment(ViewModelProvider.Factory viewModelFactory, ResourceMapper resourceMapper) {
        super(R.layout.auth_qr_info);
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(resourceMapper, "resourceMapper");
        this.viewModelFactory = viewModelFactory;
        this.resourceMapper = resourceMapper;
        r rVar = new r();
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfoFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfoFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfoFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m2230viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfoFragment$special$$inlined$viewModels$default$4
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
        }, rVar);
        this.processId = LazyKt.lazy(new l());
        this.config = LazyKt.lazy(new c());
        this.parent = LazyKt.lazy(new k());
        this.stateFlipper = LazyKt.lazy(new o());
        this.logo = LazyKt.lazy(new f());
        this.title = LazyKt.lazy(new q());
        this.subtitle = LazyKt.lazy(new p());
        this.acceptButton = LazyKt.lazy(new a());
        this.denyButton = LazyKt.lazy(new d());
        this.errorContainer = LazyKt.lazy(new e());
        this.close = LazyKt.lazy(new b());
    }

    private final void enqueueDeclineWorker() throws Throwable {
        Pair[] pairArr = {TuplesKt.to(QrAuthDeclineWorkerKt.KEY_PROCESS_ID, getProcessId()), TuplesKt.to(QrAuthDeclineWorkerKt.KEY_APPLICATION_USER_AGENT, getConfig().getApplicationUserAgent()), TuplesKt.to("logoutToken", getConfig().getAccessToken()), TuplesKt.to("logoutBaseURL", getConfig().getApiHost()), TuplesKt.to("isDebugMode", Boolean.valueOf(getConfig().isDebugMode()))};
        Data.Builder builder = new Data.Builder();
        int i2 = 0;
        while (i2 < 5) {
            Pair pair = pairArr[i2];
            i2++;
            builder.put((String) pair.getFirst(), pair.getSecond());
        }
        Data dataBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(dataBuild, "dataBuilder.build()");
        OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(QrAuthDeclineWorker.class).setInputData(dataBuild).build();
        Intrinsics.checkNotNullExpressionValue(oneTimeWorkRequestBuild, "build(...)");
        WorkManager.getInstance(requireContext()).enqueue(oneTimeWorkRequestBuild);
    }

    private final View getAcceptButton() {
        return (View) this.acceptButton.getValue();
    }

    private final ImageView getClose() {
        return (ImageView) this.close.getValue();
    }

    private final Config getConfig() {
        return (Config) this.config.getValue();
    }

    private final View getDenyButton() {
        return (View) this.denyButton.getValue();
    }

    private final EmptyStateLargeView getErrorContainer() {
        return (EmptyStateLargeView) this.errorContainer.getValue();
    }

    private final ImageView getLogo() {
        return (ImageView) this.logo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getParent() {
        return (View) this.parent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getProcessId() {
        return (String) this.processId.getValue();
    }

    private final StateFlipViewGroup getStateFlipper() {
        return (StateFlipViewGroup) this.stateFlipper.getValue();
    }

    private final TextView getSubtitle() {
        return (TextView) this.subtitle.getValue();
    }

    private final TextView getTitle() {
        return (TextView) this.title.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<QrAuthInfo.State, QrAuthInfo.Action, QrAuthInfo.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void setUpClose() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ImageView close = getClose();
        Drawable drawable = AppCompatResources.getDrawable(contextRequireContext, R.drawable.ic_close);
        close.setImageDrawable(drawable != null ? DrawableExtensions.tint(drawable, ColorScheme.INSTANCE.getAccentColor(contextRequireContext)) : null);
        getClose().setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfoFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QrAuthInfoFragment.setUpClose$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpClose$lambda$2(QrAuthInfoFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(QrAuthInfo.Action.Close.INSTANCE);
    }

    @SuppressLint({"SetTextI18n"})
    private final void setUpContent() {
        getAcceptButton().setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfoFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QrAuthInfoFragment.setUpContent$lambda$0(this.f$0, view);
            }
        });
        getDenyButton().setOnClickListener(new View.OnClickListener() { // from class: ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfoFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QrAuthInfoFragment.setUpContent$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpContent$lambda$0(QrAuthInfoFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RuntimeViewModel<QrAuthInfo.State, QrAuthInfo.Action, QrAuthInfo.Effect> viewModel = this$0.getViewModel();
        String processId = this$0.getProcessId();
        Intrinsics.checkNotNullExpressionValue(processId, "<get-processId>(...)");
        viewModel.handleAction(new QrAuthInfo.Action.Accept(processId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpContent$lambda$1(QrAuthInfoFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().handleAction(QrAuthInfo.Action.Deny.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(QrAuthInfo.Effect effect) throws Throwable {
        if (Intrinsics.areEqual(effect, QrAuthInfo.Effect.CloseScreen.INSTANCE)) {
            enqueueDeclineWorker();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            fragmentActivityRequireActivity.setResult(0);
            fragmentActivityRequireActivity.finish();
            return;
        }
        if (effect instanceof QrAuthInfo.Effect.ShowFailureScreen) {
            enqueueDeclineWorker();
            FragmentKt.findNavController(this).navigate(R.id.qrAuthFailureFragment, BundleKt.bundleOf(TuplesKt.to(YooMoneyAuth.KEY_FAILURE, ((QrAuthInfo.Effect.ShowFailureScreen) effect).getFailure())));
        } else if (Intrinsics.areEqual(effect, QrAuthInfo.Effect.ShowSuccessScreen.INSTANCE)) {
            FragmentKt.findNavController(this).navigate(R.id.qrAuthSuccessFragment, BundleKt.bundleOf(TuplesKt.to("config", getConfig())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(QrAuthInfo.State state) {
        EmptyStateLargeView errorContainer;
        Function0<Unit> nVar;
        if (state instanceof QrAuthInfo.State.Loading) {
            getStateFlipper().showProgress();
            return;
        }
        if (state instanceof QrAuthInfo.State.Content) {
            QrAuthConfig qrAuthConfig = getConfig().getQrAuthConfig();
            if (qrAuthConfig != null) {
                getLogo().setImageDrawable(AppCompatResources.getDrawable(requireContext(), qrAuthConfig.getAuthQrInfoLogo()));
                getTitle().setText(qrAuthConfig.getAuthQrInfoTitle());
            } else {
                getLogo().setImageDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.ic_yoo_logo_round));
                getTitle().setText(getString(R.string.auth_qr_info_title));
            }
            getSubtitle().setText(getString(R.string.auth_qr_info_subtitle, ((QrAuthInfo.State.Content) state).getInfo()));
            getStateFlipper().showContent();
            return;
        }
        if (state instanceof QrAuthInfo.State.ErrorInfo) {
            getErrorContainer().setSubtitle(this.resourceMapper.map(((QrAuthInfo.State.ErrorInfo) state).getFailure()));
            errorContainer = getErrorContainer();
            nVar = new m();
        } else {
            if (!(state instanceof QrAuthInfo.State.ErrorAccept)) {
                return;
            }
            getErrorContainer().setSubtitle(this.resourceMapper.map(((QrAuthInfo.State.ErrorAccept) state).getFailure()));
            errorContainer = getErrorContainer();
            nVar = new n();
        }
        errorContainer.setActionListener(nVar);
        getStateFlipper().showError();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), this, false, new g(), 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUpContent();
        setUpClose();
        RuntimeViewModel<QrAuthInfo.State, QrAuthInfo.Action, QrAuthInfo.Effect> viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(viewModel, viewLifecycleOwner, new h(this), new i(this), new j());
        RuntimeViewModel<QrAuthInfo.State, QrAuthInfo.Action, QrAuthInfo.Effect> viewModel2 = getViewModel();
        String processId = getProcessId();
        Intrinsics.checkNotNullExpressionValue(processId, "<get-processId>(...)");
        viewModel2.handleAction(new QrAuthInfo.Action.LoadInfo(processId));
    }
}
