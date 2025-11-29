package spay.sdk;

import android.app.Application;
import android.content.Context;
import com.jakewharton.threetenabp.AndroidThreeTen;
import dagger.internal.Preconditions;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import npi.spay.A8;
import npi.spay.C1482b3;
import npi.spay.C1511c7;
import npi.spay.C1557e3;
import npi.spay.C1599fk;
import npi.spay.C1815oc;
import npi.spay.C1832p4;
import npi.spay.C1910s8;
import npi.spay.C1985v8;
import npi.spay.C2048xl;
import npi.spay.Di;
import npi.spay.Fi;
import npi.spay.Ih;
import npi.spay.Ik;
import npi.spay.Im;
import npi.spay.InterfaceC1728l0;
import npi.spay.InterfaceC1943tg;
import npi.spay.Jc;
import npi.spay.L5;
import npi.spay.Le;
import npi.spay.O0;
import npi.spay.Rl;
import npi.spay.Wg;
import spay.sdk.api.InitializationResult;
import spay.sdk.api.PaymentResult;
import spay.sdk.api.SPayStage;
import spay.sdk.b;
import spay.sdk.domain.model.PayPartsStatus;
import timber.log.Timber;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 32\u00020\u0001:\u00013B\t\b\u0002¢\u0006\u0004\b2\u00101J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ]\u0010\u0016\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\u0004\b\u0016\u0010\u0017J]\u0010\u0018\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\u0004\b\u0018\u0010\u0017Ja\u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\u0004\b\u0019\u0010\u0017R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010#\u001a\u00020\"8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010*\u001a\u00020)8\u0000@\u0000X\u0081.¢\u0006\u0018\n\u0004\b*\u0010+\u0012\u0004\b0\u00101\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00064"}, d2 = {"Lspay/sdk/SPaySdkApp;", "", "Lspay/sdk/SPaySdkInitConfig;", "config", "", "initialize", "(Lspay/sdk/SPaySdkInitConfig;)V", "Landroid/content/Context;", "context", "", "isReadyForSPaySdk", "(Landroid/content/Context;)Z", "", "apiKey", "merchantLogin", "bankInvoiceId", "orderNumber", "appPackage", FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, "Lkotlin/Function1;", "Lspay/sdk/api/PaymentResult;", "callback", "payWithoutRefresh", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "payWithPartPay", "payWithBankInvoiceId", "Lnpi/spay/Im;", "a", "Lnpi/spay/Im;", "getSdkComponent$SPaySDK_release", "()Lnpi/spay/Im;", "setSdkComponent$SPaySDK_release", "(Lnpi/spay/Im;)V", "sdkComponent", "Lnpi/spay/l0;", "sPaySdkConfigRepository", "Lnpi/spay/l0;", "getSPaySdkConfigRepository$SPaySDK_release", "()Lnpi/spay/l0;", "setSPaySdkConfigRepository$SPaySDK_release", "(Lnpi/spay/l0;)V", "Lnpi/spay/tg;", "_secureSharedPreferences", "Lnpi/spay/tg;", "get_secureSharedPreferences$SPaySDK_release", "()Lnpi/spay/tg;", "set_secureSharedPreferences$SPaySDK_release", "(Lnpi/spay/tg;)V", "get_secureSharedPreferences$SPaySDK_release$annotations", "()V", "<init>", "Companion", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes5.dex */
public final class SPaySdkApp {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static volatile SPaySdkApp b;
    public InterfaceC1943tg _secureSharedPreferences;

    /* renamed from: a, reason: from kotlin metadata */
    public Im sdkComponent;
    public InterfaceC1728l0 sPaySdkConfigRepository;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lspay/sdk/SPaySdkApp$Companion;", "", "()V", "instance", "Lspay/sdk/SPaySdkApp;", "getInstance", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized SPaySdkApp getInstance() {
            SPaySdkApp sPaySdkApp;
            try {
                if (SPaySdkApp.b == null) {
                    SPaySdkApp.b = new SPaySdkApp(null);
                }
                sPaySdkApp = SPaySdkApp.b;
                Intrinsics.checkNotNull(sPaySdkApp);
            } catch (Throwable th) {
                throw th;
            }
            return sPaySdkApp;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SPayStage.values().length];
            try {
                iArr[SPayStage.SandboxRealBankApp.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SPayStage.SandBoxWithoutBankApp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public SPaySdkApp() {
        CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    public static /* synthetic */ void get_secureSharedPreferences$SPaySDK_release$annotations() {
    }

    public final synchronized void a(Application application) {
        if (this.sdkComponent != null) {
            return;
        }
        Context context = (Context) Preconditions.checkNotNull(application);
        Preconditions.checkBuilderRequirement(context, Context.class);
        this.sdkComponent = new Ik(new C1910s8(), new C1985v8(), new C1482b3(), new C1557e3(), new Wg(), new C2048xl(), new Rl(), new L5(), new Jc(), new A8(), new Le(), new C1832p4(), context);
    }

    public final InterfaceC1728l0 getSPaySdkConfigRepository$SPaySDK_release() {
        InterfaceC1728l0 interfaceC1728l0 = this.sPaySdkConfigRepository;
        if (interfaceC1728l0 != null) {
            return interfaceC1728l0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sPaySdkConfigRepository");
        return null;
    }

    /* renamed from: getSdkComponent$SPaySDK_release, reason: from getter */
    public final Im getSdkComponent() {
        return this.sdkComponent;
    }

    public final InterfaceC1943tg get_secureSharedPreferences$SPaySDK_release() {
        InterfaceC1943tg interfaceC1943tg = this._secureSharedPreferences;
        if (interfaceC1943tg != null) {
            return interfaceC1943tg;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_secureSharedPreferences");
        return null;
    }

    public final void initialize(SPaySdkInitConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        try {
            a(config.getApplication());
            Im im = this.sdkComponent;
            if (im != null) {
                Ik ik = (Ik) im;
                this.sPaySdkConfigRepository = (InterfaceC1728l0) ik.s.get();
                this._secureSharedPreferences = (InterfaceC1943tg) ik.h.get();
            }
            Application application = config.getApplication();
            SPayStage stage = config.getStage();
            boolean enableLogging = config.getEnableLogging();
            AndroidThreeTen.init(application);
            if ((stage == SPayStage.SandBoxWithoutBankApp || stage == SPayStage.SandboxRealBankApp) && enableLogging) {
                Timber.INSTANCE.plant(new C1599fk());
            }
            int i = a.a[config.getStage().ordinal()];
            int i2 = 1;
            if (i == 1) {
                i2 = 7;
            } else if (i == 2) {
                i2 = 6;
            }
            C1815oc.b = i2;
            O0 o0 = (O0) getSPaySdkConfigRepository$SPaySDK_release();
            o0.getClass();
            Intrinsics.checkNotNullParameter(config, "options");
            o0.d = config;
            InterfaceC1943tg interfaceC1943tg = get_secureSharedPreferences$SPaySDK_release();
            Intrinsics.checkNotNull(interfaceC1943tg, "null cannot be cast to non-null type spay.sdk.utils.storage.SecureSharedPreferences");
            ((Fi) interfaceC1943tg).d();
            SPaySdkInitConfig sPaySdkInitConfig = ((O0) getSPaySdkConfigRepository$SPaySDK_release()).d;
            if (sPaySdkInitConfig == null) {
                throw C1511c7.a;
            }
            sPaySdkInitConfig.getInitializationResult().invoke(InitializationResult.Success.INSTANCE);
        } catch (Exception e) {
            SPaySdkInitConfig sPaySdkInitConfig2 = ((O0) getSPaySdkConfigRepository$SPaySDK_release()).d;
            if (sPaySdkInitConfig2 == null) {
                throw C1511c7.a;
            }
            sPaySdkInitConfig2.getInitializationResult().invoke(new InitializationResult.ConfigError("SPaySdkApp initialize with exception : " + e.getMessage()));
        }
    }

    public final boolean isReadyForSPaySdk(Context context) {
        d dVar;
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (b.a.a) {
            try {
                dVar = d.f;
                if (dVar == null) {
                    d.f = new d();
                    dVar = d.f;
                    Intrinsics.checkNotNull(dVar);
                }
            } finally {
            }
        }
        return dVar.b(context);
    }

    public final void payWithBankInvoiceId(Context context, String apiKey, String merchantLogin, String bankInvoiceId, String orderNumber, String appPackage, String language, Function1<? super PaymentResult, Unit> callback) {
        d dVar;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(bankInvoiceId, "bankInvoiceId");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(appPackage, "appPackage");
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (b.a.a) {
            try {
                dVar = d.f;
                if (dVar == null) {
                    d.f = new d();
                    dVar = d.f;
                    Intrinsics.checkNotNull(dVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        dVar.a(context, apiKey, merchantLogin, bankInvoiceId, orderNumber, appPackage, language, callback);
    }

    public final void payWithPartPay(Context context, String apiKey, String merchantLogin, String bankInvoiceId, String orderNumber, String appPackage, String language, Function1<? super PaymentResult, Unit> callback) {
        d dVar;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(bankInvoiceId, "bankInvoiceId");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(appPackage, "appPackage");
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (b.a.a) {
            try {
                dVar = d.f;
                if (dVar == null) {
                    d.f = new d();
                    dVar = d.f;
                    Intrinsics.checkNotNull(dVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        dVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(bankInvoiceId, "bankInvoiceId");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(appPackage, "appPackage");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Ih ihA = dVar.a();
        PayPartsStatus status = PayPartsStatus.ONLY_PARTS_PAY;
        Di di = (Di) ihA;
        di.getClass();
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(status, "<set-?>");
        di.y = status;
        dVar.a(context, apiKey, merchantLogin, bankInvoiceId, orderNumber, appPackage, language, callback);
    }

    public final void payWithoutRefresh(Context context, String apiKey, String merchantLogin, String bankInvoiceId, String orderNumber, String appPackage, String language, Function1<? super PaymentResult, Unit> callback) {
        d dVar;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(bankInvoiceId, "bankInvoiceId");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(appPackage, "appPackage");
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (b.a.a) {
            try {
                dVar = d.f;
                if (dVar == null) {
                    d.f = new d();
                    dVar = d.f;
                    Intrinsics.checkNotNull(dVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        dVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(bankInvoiceId, "bankInvoiceId");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(appPackage, "appPackage");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Ih ihA = dVar.a();
        PayPartsStatus status = PayPartsStatus.PARTS_START_PAY;
        Di di = (Di) ihA;
        di.getClass();
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(status, "<set-?>");
        di.y = status;
        dVar.a(context, apiKey, merchantLogin, bankInvoiceId, orderNumber, appPackage, language, callback);
    }

    public final void setSPaySdkConfigRepository$SPaySDK_release(InterfaceC1728l0 interfaceC1728l0) {
        Intrinsics.checkNotNullParameter(interfaceC1728l0, "<set-?>");
        this.sPaySdkConfigRepository = interfaceC1728l0;
    }

    public final void setSdkComponent$SPaySDK_release(Im im) {
        this.sdkComponent = im;
    }

    public final void set_secureSharedPreferences$SPaySDK_release(InterfaceC1943tg interfaceC1943tg) {
        Intrinsics.checkNotNullParameter(interfaceC1943tg, "<set-?>");
        this._secureSharedPreferences = interfaceC1943tg;
    }

    public /* synthetic */ SPaySdkApp(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
