package ru.yoomoney.sdk.auth.socialAccounts.vkId;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.vk.auth.api.models.AuthResult;
import com.vk.auth.main.SignUpData;
import com.vk.auth.main.VkClientAuthCallback;
import com.vk.auth.main.VkClientAuthLib;
import com.vk.auth.migration.VkMigrationResult;
import com.vk.auth.oauth.VkOAuthConnectionResult;
import com.vk.auth.oauth.VkOAuthService;
import com.vk.auth.oauth.model.AdditionalOauthAuthResult;
import com.vk.auth.ui.fastloginbutton.VkFastLoginButton;
import com.vk.auth.validation.VkPhoneValidationCompleteResult;
import com.vk.auth.validation.VkPhoneValidationErrorReason;
import com.vk.superapp.SuperappKit;
import com.vk.superapp.SuperappKitConfig;
import com.vk.superapp.bridges.LogoutReason;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.Style;
import ru.yoomoney.sdk.auth.ThemeScheme;
import ru.yoomoney.sdk.auth.socialAccounts.vkId.VkId;
import ru.yoomoney.sdk.auth.socialAccounts.vkId.domain.VkIdSdkParameters;
import ru.yoomoney.sdk.auth.socialAccounts.vkId.impl.VkIdViewModelFactoryImpl;
import ru.yoomoney.sdk.auth.ui.TopBarDefault;
import ru.yoomoney.sdk.gui.widget.StateFlipViewGroup;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0004\b\u0000\u0018\u0000 >2\u00020\u0001:\u0001>B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020(H\u0002J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020/H\u0002J\u0012\u00100\u001a\u00020(2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020(H\u0014J\u0010\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020(2\u0006\u00108\u001a\u000202H\u0014J\b\u00109\u001a\u00020(H\u0002J\u0010\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020\"H\u0002J\u0010\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020 H\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0019\u001a\n \u0015*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001b\u0010\u001cR1\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0\u001fj\u0002`#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b$\u0010%¨\u0006?"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkIdActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "authCallback", "ru/yoomoney/sdk/auth/socialAccounts/vkId/VkIdActivity$authCallback$1", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkIdActivity$authCallback$1;", VkIdActivity.KEY_CONFIG, "Lru/yoomoney/sdk/auth/Config;", "getConfig", "()Lru/yoomoney/sdk/auth/Config;", "config$delegate", "Lkotlin/Lazy;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "factory$delegate", VkIdActivity.KEY_IS_INITIALIZED, "", "stateFlipper", "Lru/yoomoney/sdk/gui/widget/StateFlipViewGroup;", "kotlin.jvm.PlatformType", "getStateFlipper", "()Lru/yoomoney/sdk/gui/widget/StateFlipViewGroup;", "stateFlipper$delegate", "topBar", "Lru/yoomoney/sdk/auth/ui/TopBarDefault;", "getTopBar", "()Lru/yoomoney/sdk/auth/ui/TopBarDefault;", "topBar$delegate", "viewModel", "Lru/yoomoney/sdk/march/RuntimeViewModel;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$State;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Action;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect;", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/impl/VkIdViewModel;", "getViewModel", "()Lru/yoomoney/sdk/march/RuntimeViewModel;", "viewModel$delegate", "finishWithResult", "", "token", "", "uuid", "initViews", "initVkSdk", "parameters", "Lru/yoomoney/sdk/auth/socialAccounts/vkId/domain/VkIdSdkParameters;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onSaveInstanceState", "outState", "openVk", "showEffect", "effect", "showState", "state", "Companion", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VkIdActivity extends AppCompatActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_VK_ID_SILENT_TOKEN = "ru.yoomoney.sdk.auth.VkIdSilentToken";
    public static final String EXTRA_VK_ID_UUID = "ru.yoomoney.sdk.auth.VkIdUuid";
    private static final String KEY_CONFIG = "config";
    private static final String KEY_IS_INITIALIZED = "isInitialized";
    private static final long VK_LOGIN_BUTTON_INIT_DELAY = 750;
    private static final String VK_SERVICE_PRIVACY_POLICY_LINK = "https://id.vk.com/privacy";
    private static final String VK_SERVICE_USER_AGREEMENT_LINK = "https://id.vk.com/terms";
    private boolean isInitialized;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: config$delegate, reason: from kotlin metadata */
    private final Lazy config = LazyKt.lazy(new a());

    /* renamed from: factory$delegate, reason: from kotlin metadata */
    private final Lazy factory = LazyKt.lazy(new b());

    /* renamed from: stateFlipper$delegate, reason: from kotlin metadata */
    private final Lazy stateFlipper = LazyKt.lazy(new g());

    /* renamed from: topBar$delegate, reason: from kotlin metadata */
    private final Lazy topBar = LazyKt.lazy(new h());
    private final VkIdActivity$authCallback$1 authCallback = new VkClientAuthCallback() { // from class: ru.yoomoney.sdk.auth.socialAccounts.vkId.VkIdActivity$authCallback$1
        public void onAccessApproved(String str) {
            VkClientAuthCallback.DefaultImpls.onAccessApproved(this, str);
        }

        public void onAccessFlowCancel() {
            VkClientAuthCallback.DefaultImpls.onAccessFlowCancel(this);
        }

        public void onAdditionalOAuthAuth(AdditionalOauthAuthResult additionalOauthAuthResult) {
            VkClientAuthCallback.DefaultImpls.onAdditionalOAuthAuth(this, additionalOauthAuthResult);
        }

        public void onAdditionalSignUpError() {
            VkClientAuthCallback.DefaultImpls.onAdditionalSignUpError(this);
        }

        public void onAnotherWayToLogin() {
            VkClientAuthCallback.DefaultImpls.onAnotherWayToLogin(this);
        }

        public void onAuth(AuthResult authResult) {
            VkClientAuthCallback.DefaultImpls.onAuth(this, authResult);
        }

        public void onCancel() {
            VkClientAuthCallback.DefaultImpls.onCancel(this);
        }

        public void onCancelEnterPassword() {
            VkClientAuthCallback.DefaultImpls.onCancelEnterPassword(this);
        }

        public void onEmailSignUpError() {
            VkClientAuthCallback.DefaultImpls.onEmailSignUpError(this);
        }

        public void onExternalServiceAuth(VkOAuthService vkOAuthService) {
            VkClientAuthCallback.DefaultImpls.onExternalServiceAuth(this, vkOAuthService);
        }

        public void onLogout(LogoutReason logoutReason) {
            VkClientAuthCallback.DefaultImpls.onLogout(this, logoutReason);
        }

        public void onMigrationResult(VkMigrationResult vkMigrationResult) {
            VkClientAuthCallback.DefaultImpls.onMigrationResult(this, vkMigrationResult);
        }

        public void onOAuthConnectResult(VkOAuthConnectionResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            VkClientAuthCallback.DefaultImpls.onOAuthConnectResult(this, result);
            if (result instanceof VkOAuthConnectionResult.Error) {
                this.this$0.getViewModel().handleAction(VkId.Action.Cancel.INSTANCE);
            }
        }

        public void onPhoneValidationCompleted(VkPhoneValidationCompleteResult vkPhoneValidationCompleteResult) {
            VkClientAuthCallback.DefaultImpls.onPhoneValidationCompleted(this, vkPhoneValidationCompleteResult);
        }

        public void onPhoneValidationError(VkPhoneValidationErrorReason vkPhoneValidationErrorReason) {
            VkClientAuthCallback.DefaultImpls.onPhoneValidationError(this, vkPhoneValidationErrorReason);
        }

        public void onRestoreBannedUserError() {
            VkClientAuthCallback.DefaultImpls.onRestoreBannedUserError(this);
        }

        public void onRestoreDeactivatedUserError() {
            VkClientAuthCallback.DefaultImpls.onRestoreDeactivatedUserError(this);
        }

        public void onSignUp(long j, SignUpData signUpData) {
            VkClientAuthCallback.DefaultImpls.onSignUp(this, j, signUpData);
        }

        public void onTertiaryButtonClick() {
            VkClientAuthCallback.DefaultImpls.onTertiaryButtonClick(this);
        }

        public void onValidatePhoneError() {
            VkClientAuthCallback.DefaultImpls.onValidatePhoneError(this);
        }
    };

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkIdActivity$Companion;", "", "()V", "EXTRA_VK_ID_SILENT_TOKEN", "", "EXTRA_VK_ID_UUID", "KEY_CONFIG", "KEY_IS_INITIALIZED", "VK_LOGIN_BUTTON_INIT_DELAY", "", "VK_SERVICE_PRIVACY_POLICY_LINK", "VK_SERVICE_USER_AGREEMENT_LINK", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", VkIdActivity.KEY_CONFIG, "Lru/yoomoney/sdk/auth/Config;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent createIntent(Context context, Config config) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Intent intent = new Intent(context, (Class<?>) VkIdActivity.class);
            intent.putExtra(VkIdActivity.KEY_CONFIG, config);
            return intent;
        }
    }

    public static final class a extends Lambda implements Function0<Config> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Config invoke() {
            Parcelable parcelableExtra = VkIdActivity.this.getIntent().getParcelableExtra(VkIdActivity.KEY_CONFIG);
            if (parcelableExtra != null) {
                return (Config) parcelableExtra;
            }
            throw new IllegalArgumentException("Required value was null.");
        }
    }

    public static final class b extends Lambda implements Function0<VkIdViewModelFactoryImpl> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final VkIdViewModelFactoryImpl invoke() {
            Application application = VkIdActivity.this.getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
            return new VkIdViewModelFactoryImpl(application, VkIdActivity.this.getConfig().getOauthParams());
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<VkId.State, Unit> {
        public c(Object obj) {
            super(1, obj, VkIdActivity.class, "showState", "showState(Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(VkId.State state) {
            VkId.State p0 = state;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((VkIdActivity) this.receiver).showState(p0);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<VkId.Effect, Unit> {
        public d(Object obj) {
            super(1, obj, VkIdActivity.class, "showEffect", "showEffect(Lru/yoomoney/sdk/auth/socialAccounts/vkId/VkId$Effect;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(VkId.Effect effect) {
            VkId.Effect p0 = effect;
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((VkIdActivity) this.receiver).showEffect(p0);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Throwable, Unit> {
        public static final e a = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable th) {
            Throwable it = th;
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function2<String, String, Unit> {
        public f() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(String str, String str2) {
            String token = str;
            String uuid = str2;
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(uuid, "uuid");
            VkIdActivity.this.getViewModel().handleAction(new VkId.Action.DataReceived(token, uuid));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function0<StateFlipViewGroup> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final StateFlipViewGroup invoke() {
            return (StateFlipViewGroup) VkIdActivity.this.findViewById(R.id.stateFlipper);
        }
    }

    public static final class h extends Lambda implements Function0<TopBarDefault> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final TopBarDefault invoke() {
            return (TopBarDefault) VkIdActivity.this.findViewById(R.id.top_bar);
        }
    }

    public static final class i extends Lambda implements Function0<ViewModelProvider.Factory> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return VkIdActivity.this.getFactory();
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [ru.yoomoney.sdk.auth.socialAccounts.vkId.VkIdActivity$authCallback$1] */
    public VkIdActivity() {
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(RuntimeViewModel.class), new Function0<ViewModelStore>() { // from class: ru.yoomoney.sdk.auth.socialAccounts.vkId.VkIdActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new i(), new Function0<CreationExtras>() { // from class: ru.yoomoney.sdk.auth.socialAccounts.vkId.VkIdActivity$special$$inlined$viewModels$default$3
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

    private final void finishWithResult(String token, String uuid) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_VK_ID_SILENT_TOKEN, token);
        intent.putExtra(EXTRA_VK_ID_UUID, uuid);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Config getConfig() {
        return (Config) this.config.getValue();
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
    public final RuntimeViewModel<VkId.State, VkId.Action, VkId.Effect> getViewModel() {
        return (RuntimeViewModel) this.viewModel.getValue();
    }

    private final void initViews() {
        TopBarDefault topBar = getTopBar();
        setSupportActionBar(topBar != null ? topBar.getToolbar() : null);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setTitle("");
        }
    }

    private final void initVkSdk(VkIdSdkParameters parameters) {
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        SuperappKitConfig superappKitConfigBuild = SuperappKitConfig.Builder.setLegalInfoLinks$default(SuperappKitConfig.Builder.setAuthUiManagerData$default(new SuperappKitConfig.Builder(application).setAuthModelData(parameters.getAuthModelData()), parameters.getUiInfo(), false, 2, (Object) null).setApplicationInfo(parameters.getAppInfo()), VK_SERVICE_USER_AGREEMENT_LINK, VK_SERVICE_PRIVACY_POLICY_LINK, (String) null, 4, (Object) null).setSilentTokenExchanger(SilentTokenExchangerHelper.INSTANCE.getExchanger$auth_release()).build();
        if (!SuperappKit.isInitialized()) {
            SuperappKit.init(superappKitConfigBuild);
        }
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;
        VkClientAuthLib.INSTANCE.addAuthCallback(this.authCallback);
        getViewModel().handleAction(VkId.Action.Open.INSTANCE);
    }

    private final void openVk() {
        final VkFastLoginButton vkFastLoginButton = new VkFastLoginButton(this, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: ru.yoomoney.sdk.auth.socialAccounts.vkId.VkIdActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                vkFastLoginButton.callOnClick();
            }
        }, VK_LOGIN_BUTTON_INIT_DELAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEffect(VkId.Effect effect) {
        if (effect instanceof VkId.Effect.Init) {
            initVkSdk(((VkId.Effect.Init) effect).getParameters());
            return;
        }
        if (effect instanceof VkId.Effect.Finish) {
            finish();
            return;
        }
        if (effect instanceof VkId.Effect.FinishWithData) {
            VkId.Effect.FinishWithData finishWithData = (VkId.Effect.FinishWithData) effect;
            finishWithResult(finishWithData.getToken(), finishWithData.getUuid());
        } else if (effect instanceof VkId.Effect.Open) {
            openVk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showState(VkId.State state) {
        StateFlipViewGroup stateFlipper;
        if (!(state instanceof VkId.State.Progress) || (stateFlipper = getStateFlipper()) == null) {
            return;
        }
        stateFlipper.showProgress();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        ThemeScheme themeScheme;
        Integer themeRes;
        super.onCreate(savedInstanceState);
        Style style = getConfig().getStyle();
        setTheme((style == null || (themeScheme = style.getThemeScheme()) == null || (themeRes = themeScheme.getThemeRes()) == null) ? R.style.Theme_Yoo : themeRes.intValue());
        setContentView(R.layout.activity_vk_id);
        CodeKt.observe(getViewModel(), this, new c(this), new d(this), e.a);
        SilentTokenExchangerHelper.INSTANCE.setOnTokenReceived$auth_release(new f());
        this.isInitialized = savedInstanceState != null ? savedInstanceState.getBoolean(KEY_IS_INITIALIZED) : false;
        initViews();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        VkClientAuthLib.INSTANCE.removeAuthCallback(this.authCallback);
        SilentTokenExchangerHelper.INSTANCE.setOnTokenReceived$auth_release(null);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        getViewModel().handleAction(VkId.Action.Cancel.INSTANCE);
        return true;
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_IS_INITIALIZED, this.isInitialized);
    }
}
