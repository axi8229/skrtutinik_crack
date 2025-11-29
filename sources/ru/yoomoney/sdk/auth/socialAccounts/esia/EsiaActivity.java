package ru.yoomoney.sdk.auth.socialAccounts.esia;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.WindowManager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.Style;
import ru.yoomoney.sdk.auth.ThemeScheme;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.EsiaOauthCodeParameters;
import ru.yoomoney.sdk.auth.socialAccounts.esia.Esia;
import ru.yoomoney.sdk.auth.socialAccounts.esia.impl.EsiaViewModelFactoryImpl;
import ru.yoomoney.sdk.auth.ui.EmptyStateLargeView;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.auth.utils.EsiaUtilsKt;
import ru.yoomoney.sdk.gui.widget.StateFlipViewGroup;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 @2\u00020\u0001:\u0001@B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020(H\u0002J\u0012\u0010,\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0010\u0010/\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0014J\u0010\u00102\u001a\u00020\r2\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020(H\u0014J\u0010\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020.H\u0014J\u0010\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\rH\u0002J\u0010\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020\rH\u0002J\u0010\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020\u001dH\u0002J\u0010\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020\u001bH\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0014\u001a\n \u0010*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017R1\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001aj\u0002`\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\u001f\u0010 R#\u0010\"\u001a\n \u0010*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b$\u0010%¨\u0006A"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/EsiaActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", EsiaActivity.KEY_CONFIG, "Lkotlin/Lazy;", "Lru/yoomoney/sdk/auth/Config;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "factory$delegate", "Lkotlin/Lazy;", EsiaActivity.KEY_IS_INITIALIZED, "", "stateFlipper", "Lru/yoomoney/sdk/gui/widget/StateFlipViewGroup;", "kotlin.jvm.PlatformType", "getStateFlipper", "()Lru/yoomoney/sdk/gui/widget/StateFlipViewGroup;", "stateFlipper$delegate", "topBar", "Lru/yoomoney/sdk/auth/ui/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/auth/ui/TopBarDefault;", "topBar$delegate", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Action;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Effect;", "Lru/yoomoney/sdk/auth/socialAccounts/esia/impl/EsiaViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "waitingView", "Lru/yoomoney/sdk/auth/ui/EmptyStateLargeView;", "getWaitingView", "()Lru/yoomoney/sdk/auth/ui/EmptyStateLargeView;", "waitingView$delegate", "finishWithResult", "", RemoteMessageConst.DATA, "Landroid/net/Uri;", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onResume", "onSaveInstanceState", "outState", "setContainerVisibility", "isVisible", "setDimEnabled", "isEnabled", "showEffect", "effect", "showState", "state", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EsiaActivity extends AppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float DIALOG_DIM_AMOUNT = 0.6f;
    private static final String EXTRA_ESIA_OAUTH_CODE_PARAMETERS = "ru.yoomoney.sdk.auth.esiaOauthCodeParameters";
    private static final long FINISH_VIEW_DELAY = 200;
    private static final String KEY_CONFIG = "config";
    private static final String KEY_IS_INITIALIZED = "isInitialized";
    private static final long SHOW_WAITING_VIEW_DELAY = 400;
    private static final float TRANSPARENT_DIM_AMOUNT = 0.0f;
    private boolean isInitialized;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: factory$delegate, reason: from kotlin metadata */
    private final Lazy factory = LazyKt.lazy(b.a);

    /* renamed from: stateFlipper$delegate, reason: from kotlin metadata */
    private final Lazy stateFlipper = LazyKt.lazy(new g());

    /* renamed from: waitingView$delegate, reason: from kotlin metadata */
    private final Lazy waitingView = LazyKt.lazy(new j());

    /* renamed from: topBar$delegate, reason: from kotlin metadata */
    private final Lazy topBar = LazyKt.lazy(new h());
    private final Lazy<Config> config = LazyKt.lazy(new a());

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/esia/EsiaActivity$Companion;", "", "()V", "DIALOG_DIM_AMOUNT", "", "EXTRA_ESIA_OAUTH_CODE_PARAMETERS", "", "FINISH_VIEW_DELAY", "", "KEY_CONFIG", "KEY_IS_INITIALIZED", "SHOW_WAITING_VIEW_DELAY", "TRANSPARENT_DIM_AMOUNT", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", EsiaActivity.KEY_CONFIG, "Lru/yoomoney/sdk/auth/Config;", "parameters", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/EsiaOauthCodeParameters;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent createIntent(Context context, Config config, EsiaOauthCodeParameters parameters) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            Intent intent = new Intent(context, (Class<?>) EsiaActivity.class);
            intent.putExtra(EsiaActivity.EXTRA_ESIA_OAUTH_CODE_PARAMETERS, parameters);
            intent.putExtra(EsiaActivity.KEY_CONFIG, config);
            return intent;
        }
    }

    public static final class a extends Lambda implements Function0<Config> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Config invoke() {
            return (Config) EsiaActivity.this.getIntent().getParcelableExtra(EsiaActivity.KEY_CONFIG);
        }
    }

    public static final class b extends Lambda implements Function0<EsiaViewModelFactoryImpl> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final EsiaViewModelFactoryImpl invoke() {
            return new EsiaViewModelFactoryImpl();
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            EsiaActivity.this.getViewModel().handleAction(Esia.Action.Open.INSTANCE);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<Esia.State, Unit> {
        public d(Object obj) {
            super(1, obj, EsiaActivity.class, "showState", "showState(Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Esia.State state) {
            Esia.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EsiaActivity) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function1<Esia.Effect, Unit> {
        public e(Object obj) {
            super(1, obj, EsiaActivity.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/socialAccounts/esia/Esia$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Esia.Effect effect) {
            Esia.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((EsiaActivity) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Throwable, Unit> {
        public static final f a = new f();

        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function0<StateFlipViewGroup> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final StateFlipViewGroup invoke() {
            return (StateFlipViewGroup) EsiaActivity.this.findViewById(R.id.stateFlipper);
        }
    }

    public static final class h extends Lambda implements Function0<TopBarDefault> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final TopBarDefault invoke() {
            return (TopBarDefault) EsiaActivity.this.findViewById(R.id.top_bar);
        }
    }

    public static final class i extends Lambda implements Function0<ViewModelProvider.Factory> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return EsiaActivity.this.getFactory();
        }
    }

    public static final class j extends Lambda implements Function0<EmptyStateLargeView> {
        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final EmptyStateLargeView invoke() {
            return (EmptyStateLargeView) EsiaActivity.this.findViewById(R.id.waiting);
        }
    }

    public EsiaActivity() {
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.socialAccounts.esia.EsiaActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new i(), new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.socialAccounts.esia.EsiaActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? this.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    private final void finishWithResult(Uri data) {
        Intent intent = new Intent();
        intent.setData(data);
        Unit unit = Unit.INSTANCE;
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewModelProvider.Factory getFactory() {
        return (ViewModelProvider.Factory) this.factory.getValue();
    }

    private final StateFlipViewGroup getStateFlipper() {
        return (StateFlipViewGroup) this.stateFlipper.getValue();
    }

    private final TopBarDefault getTopBar() {
        return (TopBarDefault) this.topBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RuntimeViewModel<Esia.State, Esia.Action, Esia.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final EmptyStateLargeView getWaitingView() {
        return (EmptyStateLargeView) this.waitingView.getValue();
    }

    private final void initViews() {
        TopBarDefault topBar = getTopBar();
        setSupportActionBar(topBar != null ? topBar.getToolbar() : null);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setTitle("");
        }
        EmptyStateLargeView waitingView = getWaitingView();
        if (waitingView == null) {
            return;
        }
        waitingView.setActionListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$0(EsiaActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = this$0.getIntent();
        if ((intent != null ? intent.getData() : null) == null) {
            this$0.getViewModel().handleAction(Esia.Action.WaitForDeeplink.INSTANCE);
        }
    }

    private final void setContainerVisibility(boolean isVisible) {
        if (isVisible) {
            StateFlipViewGroup stateFlipper = getStateFlipper();
            if (stateFlipper != null) {
                stateFlipper.showContent();
                return;
            }
            return;
        }
        StateFlipViewGroup stateFlipper2 = getStateFlipper();
        if (stateFlipper2 != null) {
            stateFlipper2.showEmpty();
        }
    }

    private final void setDimEnabled(boolean isEnabled) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(getWindow().getAttributes());
        layoutParams.dimAmount = isEnabled ? DIALOG_DIM_AMOUNT : 0.0f;
        getWindow().setAttributes(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(final Esia.Effect effect) {
        if (effect instanceof Esia.Effect.Finish) {
            finish();
            return;
        }
        if (effect instanceof Esia.Effect.FinishWithData) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: ru.yoomoney.sdk.auth.socialAccounts.esia.EsiaActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    EsiaActivity.showEffect$lambda$3(this.f$0, effect);
                }
            }, FINISH_VIEW_DELAY);
            return;
        }
        if (effect instanceof Esia.Effect.Open) {
            EsiaOauthCodeParameters esiaOauthCodeParameters = (EsiaOauthCodeParameters) getIntent().getParcelableExtra(EXTRA_ESIA_OAUTH_CODE_PARAMETERS);
            if (esiaOauthCodeParameters != null) {
                EsiaUtilsKt.openEsia(this, esiaOauthCodeParameters);
            } else {
                getViewModel().handleAction(Esia.Action.Cancel.INSTANCE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showEffect$lambda$3(EsiaActivity this$0, Esia.Effect effect) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(effect, "$effect");
        this$0.finishWithResult(((Esia.Effect.FinishWithData) effect).getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(Esia.State state) {
        if (state instanceof Esia.State.Empty) {
            setDimEnabled(false);
            setContainerVisibility(false);
        } else if (state instanceof Esia.State.Waiting) {
            setDimEnabled(false);
            setContainerVisibility(true);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Style style;
        ThemeScheme themeScheme;
        Integer themeRes;
        Config value = this.config.getValue();
        setTheme((value == null || (style = value.getStyle()) == null || (themeScheme = style.getThemeScheme()) == null || (themeRes = themeScheme.getThemeRes()) == null) ? R.style.Theme_Yoo : themeRes.intValue());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esia);
        CodeKt.observe(getViewModel(), this, new d(this), new e(this), f.a);
        this.isInitialized = savedInstanceState != null ? savedInstanceState.getBoolean(KEY_IS_INITIALIZED) : false;
        initViews();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Uri data = intent.getData();
        if (data != null) {
            getViewModel().handleAction(new Esia.Action.DeeplinkReceived(data));
        } else {
            getViewModel().handleAction(Esia.Action.WaitForDeeplink.INSTANCE);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        getViewModel().handleAction(Esia.Action.Cancel.INSTANCE);
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isInitialized) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: ru.yoomoney.sdk.auth.socialAccounts.esia.EsiaActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    EsiaActivity.onResume$lambda$0(this.f$0);
                }
            }, SHOW_WAITING_VIEW_DELAY);
        } else {
            getViewModel().handleAction(Esia.Action.Open.INSTANCE);
            this.isInitialized = true;
        }
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_IS_INITIALIZED, this.isInitialized);
    }
}
