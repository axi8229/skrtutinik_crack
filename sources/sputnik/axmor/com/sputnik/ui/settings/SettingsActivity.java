package sputnik.axmor.com.sputnik.ui.settings;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$StartActivityForResult;
import com.google.gson.Gson;
import com.sputnik.activationautomation.data.files.ILogger;
import com.sputnik.common.base.BaseActivity;
import com.sputnik.common.base.Notify;
import com.sputnik.common.extensions.ViewKt;
import com.sputnik.common.ui.utils.ButtonsExtensionsKt;
import com.sputnik.common.ui.utils.SnackbarUtilsKt;
import com.sputnik.common.utils.IntentUtilsKt;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.entities.prefs.DebugToolsSettings;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.scancameraidentifiers.data.files.FileManager;
import com.yandex.varioqub.config.Varioqub;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import ru.yoomoney.sdk.kassa.payments.Checkout;
import ru.yoomoney.sdk.kassa.payments.TokenizationResult;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ActivitySettingsBinding;
import sputnik.axmor.com.sputnik.core.push.PushTokenManager;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.ui.main.market.subscription.viewmodel.SubscriptionViewModel;
import sputnik.axmor.com.sputnik.ui.settings.push.PushSettingsActivity;

/* compiled from: SettingsActivity.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0003R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/settings/SettingsActivity;", "Lcom/sputnik/common/base/BaseActivity;", "<init>", "()V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;", "state", "", "renderUi", "(Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;)V", "saveSettings", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initViews", "localize", "Lsputnik/axmor/com/databinding/ActivitySettingsBinding;", "_binding", "Lsputnik/axmor/com/databinding/ActivitySettingsBinding;", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "viewModel", "Lsputnik/axmor/com/sputnik/ui/main/market/subscription/viewmodel/SubscriptionViewModel;", "subscriptionViewModel$delegate", "getSubscriptionViewModel", "()Lsputnik/axmor/com/sputnik/ui/main/market/subscription/viewmodel/SubscriptionViewModel;", "subscriptionViewModel", "", "newJwt", "Ljava/lang/String;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "startGetPaymentTokenResult", "Landroidx/activity/result/ActivityResultLauncher;", "getBinding", "()Lsputnik/axmor/com/databinding/ActivitySettingsBinding;", "binding", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsActivity extends BaseActivity {
    private ActivitySettingsBinding _binding;
    public MultiViewModelFactory factory;
    private String newJwt = "";
    private final ActivityResultLauncher<Intent> startGetPaymentTokenResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity$$ExternalSyntheticLambda26
        @Override // androidx.view.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            SettingsActivity.startGetPaymentTokenResult$lambda$1(this.f$0, (ActivityResult) obj);
        }
    });

    /* renamed from: subscriptionViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
    }

    public SettingsActivity() {
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SettingsViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity$special$$inlined$viewModels$default$3
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
        this.subscriptionViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SubscriptionViewModel.class), new Function0<ViewModelStore>() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity$special$$inlined$viewModels$default$5
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity$subscriptionViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        }, new Function0<CreationExtras>() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity$special$$inlined$viewModels$default$6
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

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivitySettingsBinding getBinding() {
        ActivitySettingsBinding activitySettingsBinding = this._binding;
        Intrinsics.checkNotNull(activitySettingsBinding);
        return activitySettingsBinding;
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsViewModel getViewModel() {
        return (SettingsViewModel) this.viewModel.getValue();
    }

    private final SubscriptionViewModel getSubscriptionViewModel() {
        return (SubscriptionViewModel) this.subscriptionViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startGetPaymentTokenResult$lambda$1(SettingsActivity this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            TokenizationResult tokenizationResultCreateTokenizationResult = data != null ? Checkout.createTokenizationResult(data) : null;
            Button btnGeneratePaymentToken = this$0.getBinding().btnGeneratePaymentToken;
            Intrinsics.checkNotNullExpressionValue(btnGeneratePaymentToken, "btnGeneratePaymentToken");
            ButtonsExtensionsKt.hideProgress(btnGeneratePaymentToken, "Generate & Copy");
            Object systemService = this$0.getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            ClipData clipDataNewPlainText = ClipData.newPlainText("Payment token", tokenizationResultCreateTokenizationResult != null ? tokenizationResultCreateTokenizationResult.getPaymentToken() : null);
            Intrinsics.checkNotNullExpressionValue(clipDataNewPlainText, "newPlainText(...)");
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
            this$0.getViewModel().notifySuccessMessage("Token copied to clipboard");
            return;
        }
        Button btnGeneratePaymentToken2 = this$0.getBinding().btnGeneratePaymentToken;
        Intrinsics.checkNotNullExpressionValue(btnGeneratePaymentToken2, "btnGeneratePaymentToken");
        ButtonsExtensionsKt.hideProgress(btnGeneratePaymentToken2, "Generate & Copy");
        this$0.getViewModel().notifyErrorMessage("Error");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContextKt.getAppComponent(this).inject(this);
        this._binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(getBinding().getRoot());
        getViewModel().observeState(this, new AnonymousClass1(this));
        getViewModel().observeNotifications(this, new Function1<Notify, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity.onCreate.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Notify notify) {
                invoke2(notify);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Notify it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SettingsActivity settingsActivity = SettingsActivity.this;
                ConstraintLayout root = settingsActivity.getBinding().getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ViewKt.renderNotifications(settingsActivity, root, it);
            }
        });
    }

    /* compiled from: SettingsActivity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity$onCreate$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<SettingsViewState, Unit> {
        AnonymousClass1(Object obj) {
            super(1, obj, SettingsActivity.class, "renderUi", "renderUi(Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsViewState settingsViewState) {
            invoke2(settingsViewState);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsViewState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SettingsActivity) this.receiver).renderUi(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderUi(SettingsViewState state) {
        Boolean isAccountLimitsEnabled;
        ActivitySettingsBinding binding = getBinding();
        binding.etBaseUrl.setText(state.getBaseUrl());
        binding.etLastAccrualDate.setText(state.getLastAccruedDate());
        binding.etAppVersion.setText(state.getAppVersion());
        binding.etJwt.setText(state.getJwt());
        binding.rbGroupPaymentsEnvironment.check(state.getIsPaymentsEnvironmentEnabled() ? R.id.rb_payments_stage : R.id.rb_payments_prod);
        if (Intrinsics.areEqual(state.getBaseUrl(), "https://api-mobile-gorod.sputnik.systems/api/mobile/v2/") || Intrinsics.areEqual(state.getBaseUrl(), "https://citizen-app.stage.sputnik.systems/api/mobile/v2/")) {
            AppCompatEditText etBaseUrl = binding.etBaseUrl;
            Intrinsics.checkNotNullExpressionValue(etBaseUrl, "etBaseUrl");
            ViewKt.disable(etBaseUrl);
        }
        CheckBox checkBox = binding.cbAccountLimitsEnabled;
        DebugToolsSettings debugToolsSettings = state.getDebugToolsSettings();
        checkBox.setChecked((debugToolsSettings == null || (isAccountLimitsEnabled = debugToolsSettings.getIsAccountLimitsEnabled()) == null) ? true : isAccountLimitsEnabled.booleanValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x019f  */
    @Override // com.sputnik.common.base.IBaseMethods
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initViews() {
        /*
            Method dump skipped, instructions count: 483
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity.initViews():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$3(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) PushSettingsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$4(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object systemService = this$0.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipData clipDataNewPlainText = ClipData.newPlainText("Varioqub ID", Varioqub.getId());
        Intrinsics.checkNotNullExpressionValue(clipDataNewPlainText, "newPlainText(...)");
        ((ClipboardManager) systemService).setPrimaryClip(clipDataNewPlainText);
        this$0.getViewModel().notifySuccessMessage("Varioqub ID copied to clipboard");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$5(final SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PushTokenManager.INSTANCE.requestToken(new Function1<String, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity$initViews$1$4$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String token) {
                Intrinsics.checkNotNullParameter(token, "token");
                PushTokenManager.Companion companion = PushTokenManager.INSTANCE;
                final SettingsActivity settingsActivity = this.this$0;
                Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity$initViews$1$4$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object systemService = settingsActivity.getSystemService("clipboard");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                        ClipData clipDataNewPlainText = ClipData.newPlainText("Push token", it);
                        Intrinsics.checkNotNullExpressionValue(clipDataNewPlainText, "newPlainText(...)");
                        ((ClipboardManager) systemService).setPrimaryClip(clipDataNewPlainText);
                        settingsActivity.getViewModel().notifySuccessMessage("Push token copied to clipboard");
                    }
                };
                final SettingsActivity settingsActivity2 = this.this$0;
                companion.requestToken(function1, new Function1<Exception, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity$initViews$1$4$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                        invoke2(exc);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Exception it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object systemService = settingsActivity2.getSystemService("clipboard");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                        String string = Arrays.toString(it.getStackTrace());
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        ClipData clipDataNewPlainText = ClipData.newPlainText("Push token", string);
                        Intrinsics.checkNotNullExpressionValue(clipDataNewPlainText, "newPlainText(...)");
                        ((ClipboardManager) systemService).setPrimaryClip(clipDataNewPlainText);
                        settingsActivity2.getViewModel().notifySuccessMessage("Push token error copied to clipboard");
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$6(SettingsActivity this$0, ActivitySettingsBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        FileManager.Companion companion = FileManager.INSTANCE;
        String absolutePath = this$0.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        FileManager.Companion.getInstance$default(companion, absolutePath, null, 2, null).write(((Object) this_with.etLog.getText()) + "\n");
        this_with.etLog.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$7(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String absolutePath = FileManager.Companion.getFile$default(FileManager.INSTANCE, this$0, null, 2, null).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        IntentUtilsKt.sendFile(absolutePath, this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$9(SettingsActivity this$0, View view) throws IOException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = "";
        for (StackTraceElement[] stackTraceElementArr : Thread.getAllStackTraces().values()) {
            str = str + "==========\n";
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                str = str + stackTraceElement.toString() + "\n";
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -b main -d").getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line);
                sb.append('\n');
                sb.append("-----------");
            } else {
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                File file = FileManager.INSTANCE.getFile(this$0, "logs-all.csv");
                FilesKt.writeText$default(file, string, null, 2, null);
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                IntentUtilsKt.sendFile(absolutePath, this$0);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$10(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileManager.Companion companion = FileManager.INSTANCE;
        FileManager.Companion.getFile$default(companion, this$0, null, 2, null).delete();
        companion.getFile(this$0, "logs-all.csv").delete();
        this$0.getViewModel().notify(new Notify.TextMessage("Logs deleted"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$11(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.saveSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$14$lambda$12(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.saveSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initViews$lambda$41$lambda$14$lambda$13(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().notify(new Notify.TextMessage("Hate this buttons"));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$15(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) BleSettingsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$16(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$17(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().clearSplashData();
        this$0.getViewModel().notify(new Notify.TextMessage("Deleted"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$18(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().clearAccounts();
        this$0.getViewModel().notify(new Notify.TextMessage("Deleted"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$19(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().clearSessions();
        this$0.getViewModel().notify(new Notify.TextMessage("Cleared!"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$20(SettingsActivity this$0, ActivitySettingsBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this$0.getViewModel().updateLastShowingDebtDate(string);
        this_with.etLastAccrualDate.setText(this$0.getViewModel().getLastAccrualDate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$22(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().clearMarketRedPoint();
        this$0.getViewModel().notify(new Notify.TextMessage("Cleared!\nJust restart the app"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.lang.String] */
    public static final void initViews$lambda$41$lambda$23(SettingsActivity this$0, View view) throws InterruptedException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Gson gson = new Gson();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = gson.toJson(this$0.getViewModel().getPrefs().getLoginState()) + "\n" + this$0.getViewModel().getPrefs().getProfileSettings() + "\n" + this$0.getViewModel().getPrefs().getPhone();
        FileManager.Companion companion = FileManager.INSTANCE;
        String absolutePath = this$0.getApplicationContext().getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        ILogger companion2 = companion.getInstance(absolutePath, "prefs.txt");
        companion2.clear();
        BuildersKt__BuildersKt.runBlocking$default(null, new SettingsActivity$initViews$1$19$1(companion2, ref$ObjectRef, this$0, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$24(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().clearVisitsHistoryPopup();
        this$0.getViewModel().clearOnboarding();
        this$0.getViewModel().notify(new Notify.TextMessage("Cleared!"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$25(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().notify(new Notify.TextMessage("Test"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$26(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View rootView = this$0.getWindow().getDecorView().getRootView();
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        SnackbarUtilsKt.showSnackbarMessage("Test error", (ViewGroup) rootView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$29(final SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Button btnGeneratePaymentToken = this$0.getBinding().btnGeneratePaymentToken;
        Intrinsics.checkNotNullExpressionValue(btnGeneratePaymentToken, "btnGeneratePaymentToken");
        ButtonsExtensionsKt.showProgress$default(btnGeneratePaymentToken, 0, 1, null);
        if (StringsKt.toIntOrNull(this$0.getBinding().etPaymentTokenAmount.getText().toString()) == null) {
            this$0.getViewModel().notifyErrorMessage("Amount can't be null");
            Button btnGeneratePaymentToken2 = this$0.getBinding().btnGeneratePaymentToken;
            Intrinsics.checkNotNullExpressionValue(btnGeneratePaymentToken2, "btnGeneratePaymentToken");
            ButtonsExtensionsKt.hideProgress(btnGeneratePaymentToken2, "Generate & Copy");
            return;
        }
        this$0.runOnUiThread(new Runnable() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                SettingsActivity.initViews$lambda$41$lambda$29$lambda$28(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$29$lambda$28(final SettingsActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSubscriptionViewModel().handleSubscribe(Integer.parseInt(this$0.getBinding().etPaymentTokenAmount.getText().toString()), "Generating token", new Function1<Intent, Unit>() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsActivity$initViews$1$24$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Intent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.startGetPaymentTokenResult.launch(it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$34(SettingsActivity this$0, ActivitySettingsBinding this_with, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        switch (i) {
            case R.id.rb_other /* 2131363550 */:
                AppCompatEditText etBaseUrl = this_with.etBaseUrl;
                Intrinsics.checkNotNullExpressionValue(etBaseUrl, "etBaseUrl");
                ViewKt.enable(etBaseUrl);
                etBaseUrl.setFocusable(true);
                etBaseUrl.setFocusableInTouchMode(true);
                etBaseUrl.setClickable(true);
                etBaseUrl.setTextColor(ContextCompat.getColor(etBaseUrl.getContext(), R.color.black));
                break;
            case R.id.rb_prod /* 2131363553 */:
                this$0.getViewModel().saveBaseUrl("https://api-mobile-gorod.sputnik.systems/api/mobile/v2/");
                AppCompatEditText etBaseUrl2 = this_with.etBaseUrl;
                Intrinsics.checkNotNullExpressionValue(etBaseUrl2, "etBaseUrl");
                ViewKt.disable(etBaseUrl2);
                AppCompatEditText appCompatEditText = this_with.etBaseUrl;
                appCompatEditText.setFocusable(false);
                appCompatEditText.setFocusableInTouchMode(false);
                appCompatEditText.setClickable(false);
                appCompatEditText.setTextColor(ContextCompat.getColor(appCompatEditText.getContext(), R.color.back_gray));
                break;
            case R.id.rb_stage /* 2131363554 */:
                this$0.getViewModel().saveBaseUrl("https://citizen-app.stage.sputnik.systems/api/mobile/v2/");
                AppCompatEditText etBaseUrl3 = this_with.etBaseUrl;
                Intrinsics.checkNotNullExpressionValue(etBaseUrl3, "etBaseUrl");
                ViewKt.disable(etBaseUrl3);
                AppCompatEditText appCompatEditText2 = this_with.etBaseUrl;
                appCompatEditText2.setFocusable(false);
                appCompatEditText2.setFocusableInTouchMode(false);
                appCompatEditText2.setClickable(false);
                appCompatEditText2.setTextColor(ContextCompat.getColor(appCompatEditText2.getContext(), R.color.back_gray));
                break;
            case R.id.rb_stage2 /* 2131363555 */:
                this$0.getViewModel().saveBaseUrl("https://citizen-app-second.stage.sputnik.systems/api/mobile/v2/");
                AppCompatEditText etBaseUrl4 = this_with.etBaseUrl;
                Intrinsics.checkNotNullExpressionValue(etBaseUrl4, "etBaseUrl");
                ViewKt.disable(etBaseUrl4);
                AppCompatEditText appCompatEditText3 = this_with.etBaseUrl;
                appCompatEditText3.setFocusable(false);
                appCompatEditText3.setFocusableInTouchMode(false);
                appCompatEditText3.setClickable(false);
                appCompatEditText3.setTextColor(ContextCompat.getColor(appCompatEditText3.getContext(), R.color.back_gray));
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$35(SettingsActivity this$0, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (i) {
            case R.id.rb_payments_prod /* 2131363551 */:
                this$0.getViewModel().disablePaymentsTestEnvironment();
                break;
            case R.id.rb_payments_stage /* 2131363552 */:
                this$0.getViewModel().enablePaymentsTestEnvironment();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$36(SettingsActivity this$0, CompoundButton view, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.getViewModel().setDebugToolsSettings(new DebugToolsSettings(Boolean.valueOf(z), (Boolean) null, 2, (DefaultConstructorMarker) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$41$lambda$40(SettingsActivity this$0, View view) {
        List mutableList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PrefManager prefs = this$0.getViewModel().getPrefs();
        LoginState loginState = this$0.getViewModel().getPrefs().getLoginState();
        List<LoginState.Session> sessions = loginState.getSessions();
        if (sessions != null) {
            List<LoginState.Session> list = sessions;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (LoginState.Session session : list) {
                List<LoginState.Session.Address> addresses = session.getAddresses();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(addresses, 10));
                for (LoginState.Session.Address address : addresses) {
                    arrayList2.add(address.copy((383 & 1) != 0 ? address.id : null, (383 & 2) != 0 ? address.fullAddress : null, (383 & 4) != 0 ? address.fullAddressWithApartment : null, (383 & 8) != 0 ? address.addressVerificationRequired : null, (383 & 16) != 0 ? address.apartment : null, (383 & 32) != 0 ? address.flatUUID : null, (383 & 64) != 0 ? address.entryUUID : null, (383 & 128) != 0 ? address.isSelected : false, (383 & 256) != 0 ? address.status : null));
                }
                session.setAddresses(arrayList2);
                arrayList.add(session);
            }
            mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        } else {
            mutableList = null;
        }
        LoginState.copy$default(loginState, null, null, null, false, null, null, mutableList, 63, null);
        prefs.setLoginState(loginState);
    }

    private final void saveSettings() {
        ActivitySettingsBinding binding = getBinding();
        String str = this.newJwt;
        LogUtilsKt.writeLog(str);
        if (StringsKt.isBlank(str)) {
            getViewModel().notify(new Notify.TextMessage("Empty jwt, really?!"));
            binding.etJwt.setText(getViewModel().getCurrentState().getJwt());
        } else {
            LogUtilsKt.writeLog(str);
            getViewModel().notify(new Notify.TextMessage("JWT Saved"));
            getViewModel().updateJwt(str);
        }
        String strValueOf = String.valueOf(binding.etBaseUrl.getText());
        if (StringsKt.isBlank(strValueOf)) {
            strValueOf = null;
        }
        if (strValueOf != null) {
            getViewModel().saveBaseUrl(strValueOf);
        }
        getViewModel().updateLastShowingDebtDate(binding.etLastAccrualDate.getText().toString());
        getViewModel().reloadPreferences();
        String string = binding.etAppVersion.getText().toString();
        LogUtilsKt.writeLog(string);
        getViewModel().updateAppVersion(string);
    }
}
