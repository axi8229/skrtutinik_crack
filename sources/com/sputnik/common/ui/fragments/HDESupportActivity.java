package com.sputnik.common.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContract;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;
import com.sputnik.common.base.BaseActivity;
import com.sputnik.common.di.CommonComponentKt;
import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.common.entities.localization.HelpLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.help.HelpBody;
import com.sputnik.common.entities.localization.entities.help.ViewSupport;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.ProfileViewModel;
import com.sputnik.common.viewmodels.SubscriptionsViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.prefs.ProfileSettings;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* compiled from: HDESupportActivity.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\bJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0003R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106R \u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000609088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R$\u0010>\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020=09\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lcom/sputnik/common/ui/fragments/HDESupportActivity;", "Lcom/sputnik/common/base/BaseActivity;", "<init>", "()V", "", "selectImageFromGallery", "", "getComment", "()Ljava/lang/String;", "getOsVersion", "getModel", "getAppVersion", "getSubscriptionInfo", "getStore", "getCurrentAddress", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "onSupportNavigateUp", "()Z", "initViews", "localize", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "factory", "Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "getFactory", "()Lcom/sputnik/common/viewmodels/MultiViewModelFactory;", "setFactory", "(Lcom/sputnik/common/viewmodels/MultiViewModelFactory;)V", "Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel$delegate", "Lkotlin/Lazy;", "getProfileViewModel", "()Lcom/sputnik/common/viewmodels/ProfileViewModel;", "profileViewModel", "Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel$delegate", "getSubscriptionsViewModel", "()Lcom/sputnik/common/viewmodels/SubscriptionsViewModel;", "subscriptionsViewModel", "Landroidx/activity/result/ActivityResultLauncher;", "", "selectImageFromGalleryResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/webkit/ValueCallback;", "Landroid/net/Uri;", "lastFilePathCallback", "Landroid/webkit/ValueCallback;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HDESupportActivity extends BaseActivity {
    public MultiViewModelFactory factory;
    private ValueCallback<Uri[]> lastFilePathCallback;
    public LocalizationStorage localizationScreen;
    public PrefManager prefManager;

    /* renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    private final ActivityResultLauncher<String[]> selectImageFromGalleryResult;

    /* renamed from: subscriptionsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionsViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(Boolean bool) {
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void initViews() {
    }

    @Override // com.sputnik.common.base.IBaseMethods
    public void localize() {
    }

    public HDESupportActivity() {
        super(R$layout.fragment_hde_support);
        final Function0 function0 = null;
        this.profileViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.common.ui.fragments.HDESupportActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.common.ui.fragments.HDESupportActivity$profileViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.common.ui.fragments.HDESupportActivity$special$$inlined$viewModels$default$3
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
        this.subscriptionsViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SubscriptionsViewModel.class), new Function0<ViewModelStore>() { // from class: com.sputnik.common.ui.fragments.HDESupportActivity$special$$inlined$viewModels$default$5
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.sputnik.common.ui.fragments.HDESupportActivity$subscriptionsViewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return this.this$0.getFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.sputnik.common.ui.fragments.HDESupportActivity$special$$inlined$viewModels$default$6
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
        this.selectImageFromGalleryResult = registerForActivityResult(new ActivityResultContract<String[], Uri>() { // from class: androidx.activity.result.contract.ActivityResultContracts$OpenDocument
            @Override // androidx.view.result.contract.ActivityResultContract
            public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String[] input) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(input, "input");
                return null;
            }

            @Override // androidx.view.result.contract.ActivityResultContract
            public Intent createIntent(Context context, String[] input) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(input, "input");
                Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).setType("*/*");
                Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
                return type;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.view.result.contract.ActivityResultContract
            public final Uri parseResult(int resultCode, Intent intent) {
                if (resultCode != -1) {
                    intent = null;
                }
                if (intent != null) {
                    return intent.getData();
                }
                return null;
            }
        }, new ActivityResultCallback() { // from class: com.sputnik.common.ui.fragments.HDESupportActivity$$ExternalSyntheticLambda2
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                HDESupportActivity.selectImageFromGalleryResult$lambda$0(this.f$0, (Uri) obj);
            }
        });
    }

    public final PrefManager getPrefManager() {
        PrefManager prefManager = this.prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
        return null;
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    public final MultiViewModelFactory getFactory() {
        MultiViewModelFactory multiViewModelFactory = this.factory;
        if (multiViewModelFactory != null) {
            return multiViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    private final SubscriptionsViewModel getSubscriptionsViewModel() {
        return (SubscriptionsViewModel) this.subscriptionsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectImageFromGallery() {
        this.selectImageFromGalleryResult.launch(new String[]{"image/*", "video/*"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selectImageFromGalleryResult$lambda$0(HDESupportActivity this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (uri != null) {
            ValueCallback<Uri[]> valueCallback = this$0.lastFilePathCallback;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(new Uri[]{uri});
                return;
            }
            return;
        }
        ValueCallback<Uri[]> valueCallback2 = this$0.lastFilePathCallback;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(null);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String title;
        LocalizationLocalModel data;
        HelpLocale help;
        HelpBody body;
        ViewSupport viewSupport;
        super.onCreate(savedInstanceState);
        CommonComponentKt.commonComponent(this).inject(this);
        setContentView(R$layout.fragment_hde_support);
        TextView textView = (TextView) findViewById(R$id.textView2);
        LocalizationStorage localizationScreen = getLocalizationScreen();
        if (localizationScreen == null || (data = localizationScreen.getData()) == null || (help = data.getHelp()) == null || (body = help.getBody()) == null || (viewSupport = body.getViewSupport()) == null || (title = viewSupport.getTitle()) == null) {
            title = "";
        }
        textView.setText(title);
        ((ImageView) findViewById(R$id.imageView5)).setOnClickListener(new View.OnClickListener() { // from class: com.sputnik.common.ui.fragments.HDESupportActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HDESupportActivity.onCreate$lambda$1(this.f$0, view);
            }
        });
        WebView.setWebContentsDebuggingEnabled(true);
        View viewFindViewById = findViewById(R$id.webview_chat);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        WebView webView = (WebView) viewFindViewById;
        webView.clearCache(true);
        webView.setWebChromeClient(new WebChromeClient() { // from class: com.sputnik.common.ui.fragments.HDESupportActivity.onCreate.2
            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView2, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                Intrinsics.checkNotNullParameter(webView2, "webView");
                Intrinsics.checkNotNullParameter(filePathCallback, "filePathCallback");
                Intrinsics.checkNotNullParameter(fileChooserParams, "fileChooserParams");
                HDESupportActivity.this.lastFilePathCallback = null;
                HDESupportActivity.this.lastFilePathCallback = filePathCallback;
                HDESupportActivity.this.selectImageFromGallery();
                return true;
            }
        });
        webView.setDownloadListener(new DownloadListener() { // from class: com.sputnik.common.ui.fragments.HDESupportActivity.onCreate.3
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String url, String userAgent, String contentDescription, String mimeType, long contentLength) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(url));
                try {
                    HDESupportActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        webView.setOverScrollMode(2);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        if (Intrinsics.areEqual(getPrefManager().getProfileSettings().getNeedToClearSupportScreen(), Boolean.TRUE)) {
            WebStorage.getInstance().deleteAllData();
            CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();
            webView.clearCache(true);
            webView.clearFormData();
            webView.clearHistory();
            webView.clearSslPreferences();
            getApplicationContext().deleteDatabase("webview.db");
            getApplicationContext().deleteDatabase("webviewCache.db");
            CookieManager.getInstance().removeAllCookies(new ValueCallback() { // from class: com.sputnik.common.ui.fragments.HDESupportActivity$$ExternalSyntheticLambda1
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    HDESupportActivity.onCreate$lambda$2((Boolean) obj);
                }
            });
            PrefManager prefManager = getPrefManager();
            ProfileSettings profileSettings = getPrefManager().getProfileSettings();
            profileSettings.setNeedToClearSupportScreen(Boolean.FALSE);
            prefManager.setProfileSettings(profileSettings);
        }
        String phone = getPrefManager().getPhone();
        LoginState.Session currentSession = getProfileViewModel().getCurrentSession();
        String name = currentSession != null ? currentSession.getName() : null;
        UserAddress currentAddress = getProfileViewModel().getCurrentAddress();
        String flatUUID = currentAddress != null ? currentAddress.getFlatUUID() : null;
        webView.setWebViewClient(new ChatClient(phone, name, flatUUID != null ? flatUUID : ""));
        String str = "https://sputniksystems.helpdeskeddy.com/ru/omnichannel/chat?comment=" + StringsKt.replace$default(getComment(), "\n", "%0A", false, 4, (Object) null);
        LogUtilsKt.writeLog("GGGG: " + str);
        webView.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(HDESupportActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    private final String getComment() {
        return "Версия ОС: " + getOsVersion() + "\nМодель: " + getModel() + "\nПриложение: " + getAppVersion() + "\nПодписка: " + getSubscriptionInfo() + "\nСтор: " + getStore() + "\nflat_uuid:  " + getCurrentAddress() + "\n";
    }

    private final String getOsVersion() {
        return "Android " + Build.VERSION.RELEASE;
    }

    private final String getModel() {
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    private final String getAppVersion() {
        return getProfileViewModel().getAppVersion();
    }

    private final String getSubscriptionInfo() {
        return getSubscriptionsViewModel().getSubscriptionInfo();
    }

    private final String getStore() {
        return getProfileViewModel().getStore();
    }

    private final String getCurrentAddress() {
        UserAddress currentAddress = getProfileViewModel().getCurrentAddress();
        if (currentAddress != null) {
            return currentAddress.getFlatUUID();
        }
        return null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
