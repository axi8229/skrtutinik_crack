package ru.yoomoney.sdk.auth.loading.impl;

import android.content.Context;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pjsip_status_code;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ConfigKt;
import ru.yoomoney.sdk.auth.OauthParams;
import ru.yoomoney.sdk.auth.PhoneIdentifier;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.Origin;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.api.enrollment.EnrollmentRepository;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterOauthCodeErrorResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterOauthCodeResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterOauthCodeSuccessResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginIdentifierRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginRequest;
import ru.yoomoney.sdk.auth.api.login.model.LoginProcessEnterOauthCode;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.loading.AuthLoading;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.utils.EsiaUtilsKt;
import ru.yoomoney.sdk.yooprofiler.ProfileEventType;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ*\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0082@¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020$H\u0096@¢\u0006\u0002\u0010)J\u001e\u0010*\u001a\u00020\u00162\u0006\u0010(\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J(\u0010.\u001a\u00020\u00162\u0006\u0010(\u001a\u00020$2\u0006\u0010+\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010$H\u0096@¢\u0006\u0002\u00100J<\u00101\u001a\u00020\u00162\u0006\u0010(\u001a\u00020$2\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u00103\u001a\u00020$2\b\u00104\u001a\u0004\u0018\u00010$2\b\u00105\u001a\u0004\u0018\u00010$H\u0096@¢\u0006\u0002\u00106J\u0010\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u000209H\u0002J\u0016\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020<H\u0096@¢\u0006\u0002\u0010=J \u0010>\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0082@¢\u0006\u0002\u0010?J*\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020B2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010C\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010DJ4\u0010E\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\b\u0010F\u001a\u0004\u0018\u00010$2\u0006\u0010G\u001a\u00020H2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010$H\u0082@¢\u0006\u0002\u0010IJ\u0016\u0010J\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010KJ&\u0010L\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020$2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010MJ\u001e\u0010N\u001a\u00020\u00162\u0006\u0010(\u001a\u00020$2\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010OJ\u001e\u0010P\u001a\u00020\u00162\u0006\u0010(\u001a\u00020$2\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010OJ\u0016\u0010Q\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010RJ\u0014\u0010S\u001a\u00020T*\u00020$2\u0006\u0010U\u001a\u00020VH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lru/yoomoney/sdk/auth/loading/impl/AuthLoadingInteractorImpl;", "Lru/yoomoney/sdk/auth/loading/impl/AuthLoadingInteractor;", "enrollmentRepository", "Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "registrationV2Repository", "Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;", "loginRepository", "Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "migrationRepository", "Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "config", "Lru/yoomoney/sdk/auth/Config;", "context", "Landroid/content/Context;", "resultData", "Lru/yoomoney/sdk/auth/ResultData;", "(Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;Lru/yoomoney/sdk/auth/api/registrationV2/RegistrationV2Repository;Lru/yoomoney/sdk/auth/api/login/LoginRepository;Lru/yoomoney/sdk/auth/api/migration/MigrationRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;Lru/yoomoney/sdk/yooprofiler/YooProfiler;Lru/yoomoney/sdk/auth/Config;Landroid/content/Context;Lru/yoomoney/sdk/auth/ResultData;)V", "chooseLoading", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action;", "productType", "Lru/yoomoney/sdk/auth/Config$ProductType;", "processType", "Lru/yoomoney/sdk/auth/Config$ProcessType;", "isForcedRegistration", "", "(Lru/yoomoney/sdk/auth/Config$ProductType;Lru/yoomoney/sdk/auth/Config$ProcessType;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enrollment", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "Lru/yoomoney/sdk/auth/api/Origin;", "phoneIdentifier", "Lru/yoomoney/sdk/auth/PhoneIdentifier;", "loginContextId", "", "(Lru/yoomoney/sdk/auth/api/Origin;Lru/yoomoney/sdk/auth/PhoneIdentifier;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterIdentifier", "phone", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOauthCodeEsia", "uri", "Landroid/net/Uri;", "(Ljava/lang/String;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOauthCodeSberId", "returnUrl", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOauthCodeVkId", "code", "state", "redirectUrl", "uuid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleLoginEnterOauthCodeResponse", "response", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeResponse;", "handleLoginSuccess", "action", "Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$LoginSuccess;", "(Lru/yoomoney/sdk/auth/loading/AuthLoading$Action$LoginSuccess;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initRegistration", "(Lru/yoomoney/sdk/auth/api/Origin;Lru/yoomoney/sdk/auth/PhoneIdentifier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "loginRequest", "Lru/yoomoney/sdk/auth/api/login/method/LoginRequest;", "isForceLogin", "(Lru/yoomoney/sdk/auth/api/login/method/LoginRequest;Lru/yoomoney/sdk/auth/PhoneIdentifier;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginSocialAccount", "packageName", "oauthServiceProvider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/Origin;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migration", "(Lru/yoomoney/sdk/auth/api/Origin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhone", "(Lru/yoomoney/sdk/auth/Config$ProcessType;Ljava/lang/String;Lru/yoomoney/sdk/auth/PhoneIdentifier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhoneEnrollment", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/PhoneIdentifier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhoneRegistration", "startRegistrationByProductType", "(Lru/yoomoney/sdk/auth/Config$ProductType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTmxSessionId", "", "profileEventType", "Lru/yoomoney/sdk/yooprofiler/ProfileEventType;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthLoadingInteractorImpl implements AuthLoadingInteractor {
    private final Config config;
    private final Context context;
    private final EnrollmentRepository enrollmentRepository;
    private final LoginRepository loginRepository;
    private final MigrationRepository migrationRepository;
    private final YooProfiler profiler;
    private final RegistrationV2Repository registrationV2Repository;
    private final ResultData resultData;
    private final ServerTimeRepository serverTimeRepository;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Config.ProcessType.values().length];
            try {
                iArr[Config.ProcessType.ENROLLMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Config.ProcessType.REGISTRATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Config.ProductType.values().length];
            try {
                iArr2[Config.ProductType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Config.ProductType.WEBBANKIR.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl", f = "AuthLoadingInteractor.kt", l = {360, 366, 375}, m = "enrollment")
    public static final class a extends ContinuationImpl {
        public AuthLoadingInteractorImpl a;
        public Object b;
        public PhoneIdentifier c;
        public String d;
        public /* synthetic */ Object e;
        public int g;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return AuthLoadingInteractorImpl.this.enrollment(null, null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl", f = "AuthLoadingInteractor.kt", l = {232, 239}, m = "enterIdentifier")
    public static final class b extends ContinuationImpl {
        public AuthLoadingInteractorImpl a;
        public String b;
        public String c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return AuthLoadingInteractorImpl.this.enterIdentifier(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl", f = "AuthLoadingInteractor.kt", l = {333, 343}, m = "enterOauthCodeEsia")
    public static final class c extends ContinuationImpl {
        public AuthLoadingInteractorImpl a;
        public String b;
        public String c;
        public String d;
        public int e;
        public /* synthetic */ Object f;
        public int h;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return AuthLoadingInteractorImpl.this.enterOauthCodeEsia(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl", f = "AuthLoadingInteractor.kt", l = {265, 276}, m = "enterOauthCodeSberId")
    public static final class d extends ContinuationImpl {
        public AuthLoadingInteractorImpl a;
        public String b;
        public String c;
        public String d;
        public String e;
        public int f;
        public /* synthetic */ Object g;
        public int i;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return AuthLoadingInteractorImpl.this.enterOauthCodeSberId(null, null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl", f = "AuthLoadingInteractor.kt", l = {300, 312}, m = "enterOauthCodeVkId")
    public static final class e extends ContinuationImpl {
        public AuthLoadingInteractorImpl a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public int g;
        public /* synthetic */ Object h;
        public int j;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= Integer.MIN_VALUE;
            return AuthLoadingInteractorImpl.this.enterOauthCodeVkId(null, null, null, null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl", f = "AuthLoadingInteractor.kt", l = {398, 399}, m = "initRegistration")
    public static final class f extends ContinuationImpl {
        public AuthLoadingInteractorImpl a;
        public Object b;
        public PhoneIdentifier c;
        public /* synthetic */ Object d;
        public int f;

        public f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return AuthLoadingInteractorImpl.this.initRegistration(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl", f = "AuthLoadingInteractor.kt", l = {pjsip_status_code.PJSIP_SC_INTERVAL_TOO_BRIEF, pjsip_status_code.PJSIP_SC_BAD_LOCATION_INFORMATION}, m = "login")
    public static final class g extends ContinuationImpl {
        public AuthLoadingInteractorImpl a;
        public Object b;
        public PhoneIdentifier c;
        public boolean d;
        public /* synthetic */ Object e;
        public int g;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return AuthLoadingInteractorImpl.this.login(null, null, false, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl", f = "AuthLoadingInteractor.kt", l = {465, 466}, m = "loginSocialAccount")
    public static final class h extends ContinuationImpl {
        public AuthLoadingInteractorImpl a;
        public Origin b;
        public String c;
        public OauthServiceProvider d;
        public String e;
        public /* synthetic */ Object f;
        public int h;

        public h(Continuation<? super h> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return AuthLoadingInteractorImpl.this.loginSocialAccount(null, null, null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl", f = "AuthLoadingInteractor.kt", l = {445, 446}, m = "migration")
    public static final class i extends ContinuationImpl {
        public AuthLoadingInteractorImpl a;
        public Origin b;
        public /* synthetic */ Object c;
        public int e;

        public i(Continuation<? super i> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return AuthLoadingInteractorImpl.this.migration(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl", f = "AuthLoadingInteractor.kt", l = {174, pjsip_status_code.PJSIP_SC_PROGRESS}, m = "setPhoneEnrollment")
    public static final class j extends ContinuationImpl {
        public AuthLoadingInteractorImpl a;
        public String b;
        public PhoneIdentifier c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public j(Continuation<? super j> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return AuthLoadingInteractorImpl.this.setPhoneEnrollment(null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl", f = "AuthLoadingInteractor.kt", l = {205, 213}, m = "setPhoneRegistration")
    public static final class k extends ContinuationImpl {
        public AuthLoadingInteractorImpl a;
        public String b;
        public PhoneIdentifier c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public k(Continuation<? super k> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return AuthLoadingInteractorImpl.this.setPhoneRegistration(null, null, this);
        }
    }

    public AuthLoadingInteractorImpl(EnrollmentRepository enrollmentRepository, RegistrationV2Repository registrationV2Repository, LoginRepository loginRepository, MigrationRepository migrationRepository, ServerTimeRepository serverTimeRepository, YooProfiler profiler, Config config, Context context, ResultData resultData) {
        Intrinsics.checkNotNullParameter(enrollmentRepository, "enrollmentRepository");
        Intrinsics.checkNotNullParameter(registrationV2Repository, "registrationV2Repository");
        Intrinsics.checkNotNullParameter(loginRepository, "loginRepository");
        Intrinsics.checkNotNullParameter(migrationRepository, "migrationRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        this.enrollmentRepository = enrollmentRepository;
        this.registrationV2Repository = registrationV2Repository;
        this.loginRepository = loginRepository;
        this.migrationRepository = migrationRepository;
        this.serverTimeRepository = serverTimeRepository;
        this.profiler = profiler;
        this.config = config;
        this.context = context;
        this.resultData = resultData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object enrollment(ru.yoomoney.sdk.auth.api.Origin r9, ru.yoomoney.sdk.auth.PhoneIdentifier r10, java.lang.String r11, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.loading.AuthLoading.Action> r12) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.enrollment(ru.yoomoney.sdk.auth.api.Origin, ru.yoomoney.sdk.auth.PhoneIdentifier, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final AuthLoading.Action handleLoginEnterOauthCodeResponse(LoginEnterOauthCodeResponse response) {
        if (response instanceof LoginEnterOauthCodeSuccessResponse) {
            return new AuthLoading.Action.LoginSuccess(((LoginEnterOauthCodeSuccessResponse) response).getProcess(), false, 2, null);
        }
        if (response instanceof LoginEnterOauthCodeErrorResponse) {
            return new AuthLoading.Action.Fail(ProcessErrorExtensionsKt.toFailure(((LoginEnterOauthCodeErrorResponse) response).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initRegistration(ru.yoomoney.sdk.auth.api.Origin r7, ru.yoomoney.sdk.auth.PhoneIdentifier r8, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.loading.AuthLoading.Action> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.f
            if (r0 == 0) goto L13
            r0 = r9
            ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl$f r0 = (ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.f) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl$f r0 = new ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl$f
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4e
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.b
            ru.yoomoney.sdk.auth.PhoneIdentifier r7 = (ru.yoomoney.sdk.auth.PhoneIdentifier) r7
            ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl r8 = r0.a
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            java.lang.Object r9 = r9.getValue()
            goto L7e
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            ru.yoomoney.sdk.auth.PhoneIdentifier r8 = r0.c
            java.lang.Object r7 = r0.b
            ru.yoomoney.sdk.auth.api.Origin r7 = (ru.yoomoney.sdk.auth.api.Origin) r7
            ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl r2 = r0.a
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r8
            r8 = r2
            goto L64
        L4e:
            kotlin.ResultKt.throwOnFailure(r9)
            ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository r9 = r6.serverTimeRepository
            r0.a = r6
            r0.b = r7
            r0.c = r8
            r0.f = r4
            java.lang.Object r9 = r9.init(r0)
            if (r9 != r1) goto L62
            return r1
        L62:
            r9 = r8
            r8 = r6
        L64:
            ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository r2 = r8.registrationV2Repository
            ru.yoomoney.sdk.auth.api.registrationV2.domain.Registration$Identifier r4 = new ru.yoomoney.sdk.auth.api.registrationV2.domain.Registration$Identifier
            r4.<init>(r7)
            r0.a = r8
            r0.b = r9
            r7 = 0
            r0.c = r7
            r0.f = r3
            java.lang.Object r7 = r2.mo3297initRegistrationgIAlus(r4, r0)
            if (r7 != r1) goto L7b
            return r1
        L7b:
            r5 = r9
            r9 = r7
            r7 = r5
        L7e:
            boolean r0 = kotlin.Result.m2634isSuccessimpl(r9)
            if (r0 == 0) goto L92
            r0 = r9
            ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit r0 = (ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit) r0
            java.lang.String r0 = r0.getTmxSessionId()
            if (r0 == 0) goto L92
            ru.yoomoney.sdk.yooprofiler.ProfileEventType r1 = ru.yoomoney.sdk.yooprofiler.ProfileEventType.REGISTRATION
            r8.updateTmxSessionId(r0, r1)
        L92:
            java.lang.Throwable r8 = kotlin.Result.m2631exceptionOrNullimpl(r9)
            if (r8 != 0) goto Lb1
            ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit r9 = (ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationInit) r9
            if (r7 != 0) goto La6
            ru.yoomoney.sdk.auth.loading.AuthLoading$Action$RegistrationSuccess r7 = new ru.yoomoney.sdk.auth.loading.AuthLoading$Action$RegistrationSuccess
            ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess r8 = r9.getRegistrationProcess()
            r7.<init>(r8)
            goto Lbd
        La6:
            ru.yoomoney.sdk.auth.loading.AuthLoading$Action$ExecuteRegistrationSetPhone r8 = new ru.yoomoney.sdk.auth.loading.AuthLoading$Action$ExecuteRegistrationSetPhone
            ru.yoomoney.sdk.auth.api.registrationV2.domain.RegistrationProcess r9 = r9.getRegistrationProcess()
            r8.<init>(r7, r9)
            r7 = r8
            goto Lbd
        Lb1:
            ru.yoomoney.sdk.auth.loading.AuthLoading$Action$Fail r7 = new ru.yoomoney.sdk.auth.loading.AuthLoading$Action$Fail
            java.lang.String r9 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r9)
            ru.yoomoney.sdk.auth.api.model.Failure r8 = (ru.yoomoney.sdk.auth.api.model.Failure) r8
            r7.<init>(r8)
        Lbd:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.initRegistration(ru.yoomoney.sdk.auth.api.Origin, ru.yoomoney.sdk.auth.PhoneIdentifier, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object login(ru.yoomoney.sdk.auth.api.login.method.LoginRequest r8, ru.yoomoney.sdk.auth.PhoneIdentifier r9, boolean r10, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.loading.AuthLoading.Action> r11) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.login(ru.yoomoney.sdk.auth.api.login.method.LoginRequest, ru.yoomoney.sdk.auth.PhoneIdentifier, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object login$default(AuthLoadingInteractorImpl authLoadingInteractorImpl, LoginRequest loginRequest, PhoneIdentifier phoneIdentifier, boolean z, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return authLoadingInteractorImpl.login(loginRequest, phoneIdentifier, z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loginSocialAccount(ru.yoomoney.sdk.auth.api.Origin r7, java.lang.String r8, ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider r9, java.lang.String r10, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.loading.AuthLoading.Action> r11) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.loginSocialAccount(ru.yoomoney.sdk.auth.api.Origin, java.lang.String, ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object loginSocialAccount$default(AuthLoadingInteractorImpl authLoadingInteractorImpl, Origin origin, String str, OauthServiceProvider oauthServiceProvider, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        return authLoadingInteractorImpl.loginSocialAccount(origin, str, oauthServiceProvider, str2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object migration(ru.yoomoney.sdk.auth.api.Origin r7, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.loading.AuthLoading.Action> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.i
            if (r0 == 0) goto L13
            r0 = r8
            ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl$i r0 = (ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.i) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl$i r0 = new ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl$i
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 == r5) goto L3d
            if (r2 != r4) goto L35
            ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl r7 = r0.a
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r8 = r8.getValue()
            goto L6f
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            ru.yoomoney.sdk.auth.api.Origin r7 = r0.b
            ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl r2 = r0.a
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            r7 = r2
            goto L5b
        L47:
            kotlin.ResultKt.throwOnFailure(r8)
            ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository r8 = r6.serverTimeRepository
            r0.a = r6
            r0.b = r7
            r0.e = r5
            java.lang.Object r8 = r8.init(r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            r8 = r7
            r7 = r6
        L5b:
            ru.yoomoney.sdk.auth.api.migration.MigrationRepository r2 = r7.migrationRepository
            ru.yoomoney.sdk.auth.api.migration.method.MigrationSoffRequest r5 = new ru.yoomoney.sdk.auth.api.migration.method.MigrationSoffRequest
            r5.<init>(r8)
            r0.a = r7
            r0.b = r3
            r0.e = r4
            java.lang.Object r8 = r2.mo3276migrationgIAlus(r5, r0)
            if (r8 != r1) goto L6f
            return r1
        L6f:
            boolean r0 = kotlin.Result.m2634isSuccessimpl(r8)
            if (r0 == 0) goto L8c
            r0 = r8
            ru.yoomoney.sdk.auth.api.migration.method.MigrationResponse r0 = (ru.yoomoney.sdk.auth.api.migration.method.MigrationResponse) r0
            boolean r1 = r0 instanceof ru.yoomoney.sdk.auth.api.migration.method.MigrationSuccessResponse
            if (r1 == 0) goto L7f
            r3 = r0
            ru.yoomoney.sdk.auth.api.migration.method.MigrationSuccessResponse r3 = (ru.yoomoney.sdk.auth.api.migration.method.MigrationSuccessResponse) r3
        L7f:
            if (r3 == 0) goto L8c
            java.lang.String r0 = r3.getTmxSessionId()
            if (r0 == 0) goto L8c
            ru.yoomoney.sdk.yooprofiler.ProfileEventType r1 = ru.yoomoney.sdk.yooprofiler.ProfileEventType.DETAILS_CHANGE
            r7.updateTmxSessionId(r0, r1)
        L8c:
            java.lang.Throwable r7 = kotlin.Result.m2631exceptionOrNullimpl(r8)
            if (r7 != 0) goto La5
            ru.yoomoney.sdk.auth.api.migration.method.MigrationResponse r8 = (ru.yoomoney.sdk.auth.api.migration.method.MigrationResponse) r8
            ru.yoomoney.sdk.auth.loading.AuthLoading$Action$MigrationSuccess r7 = new ru.yoomoney.sdk.auth.loading.AuthLoading$Action$MigrationSuccess
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.migration.method.MigrationSuccessResponse"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r0)
            ru.yoomoney.sdk.auth.api.migration.method.MigrationSuccessResponse r8 = (ru.yoomoney.sdk.auth.api.migration.method.MigrationSuccessResponse) r8
            ru.yoomoney.sdk.auth.api.migration.model.MigrationProcess r8 = r8.getProcess()
            r7.<init>(r8)
            goto Lb2
        La5:
            ru.yoomoney.sdk.auth.loading.AuthLoading$Action$Fail r8 = new ru.yoomoney.sdk.auth.loading.AuthLoading$Action$Fail
            java.lang.String r0 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r0)
            ru.yoomoney.sdk.auth.api.model.Failure r7 = (ru.yoomoney.sdk.auth.api.model.Failure) r7
            r8.<init>(r7)
            r7 = r8
        Lb2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.migration(ru.yoomoney.sdk.auth.api.Origin, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00ba -> B:45:0x00bd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setPhoneEnrollment(java.lang.String r12, ru.yoomoney.sdk.auth.PhoneIdentifier r13, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.loading.AuthLoading.Action> r14) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.setPhoneEnrollment(java.lang.String, ru.yoomoney.sdk.auth.PhoneIdentifier, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x009f -> B:34:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setPhoneRegistration(java.lang.String r11, ru.yoomoney.sdk.auth.PhoneIdentifier r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.loading.AuthLoading.Action> r13) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.setPhoneRegistration(java.lang.String, ru.yoomoney.sdk.auth.PhoneIdentifier, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object startRegistrationByProductType(Config.ProductType productType, Continuation<? super AuthLoading.Action> continuation) {
        int i2 = WhenMappings.$EnumSwitchMapping$1[productType.ordinal()];
        if (i2 == 1) {
            return initRegistration(ConfigKt.toApiOrigin(this.config.getOrigin()), this.config.getPhoneIdentifier(), continuation);
        }
        if (i2 == 2) {
            return enrollment(ConfigKt.toApiOrigin(this.config.getOrigin()), this.config.getPhoneIdentifier(), this.config.getLoginContextId(), continuation);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void updateTmxSessionId(String str, ProfileEventType profileEventType) {
        YooProfiler.Result resultProfileWithSessionId$default = YooProfiler.DefaultImpls.profileWithSessionId$default(this.profiler, str, profileEventType, null, null, 12, null);
        ResultData resultData = this.resultData;
        if (resultProfileWithSessionId$default instanceof YooProfiler.Result.Success) {
            str = ((YooProfiler.Result.Success) resultProfileWithSessionId$default).getSessionId();
        } else if (!(resultProfileWithSessionId$default instanceof YooProfiler.Result.Fail)) {
            throw new NoWhenBranchMatchedException();
        }
        resultData.setTmxSessionId(str);
    }

    @Override // ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractor
    public Object chooseLoading(Config.ProductType productType, Config.ProcessType processType, boolean z, Continuation<? super AuthLoading.Action> continuation) {
        if (CollectionsKt.listOf((Object[]) new Config.ProcessType[]{Config.ProcessType.ENROLLMENT, Config.ProcessType.REGISTRATION}).contains(processType) || z) {
            return startRegistrationByProductType(productType, continuation);
        }
        if (processType == Config.ProcessType.LOGIN) {
            return login$default(this, new LoginIdentifierRequest(ConfigKt.toApiOrigin(this.config.getOrigin()), null), this.config.getPhoneIdentifier(), false, continuation, 4, null);
        }
        if (processType == Config.ProcessType.MIGRATION) {
            return migration(ConfigKt.toApiOrigin(this.config.getOrigin()), continuation);
        }
        if (processType == Config.ProcessType.LOGIN_SBER) {
            Origin apiOrigin = ConfigKt.toApiOrigin(this.config.getOrigin());
            OauthParams oauthParams = this.config.getOauthParams();
            return loginSocialAccount$default(this, apiOrigin, oauthParams != null ? oauthParams.getPackageName() : null, OauthServiceProvider.SBER, null, continuation, 8, null);
        }
        if (processType == Config.ProcessType.LOGIN_VK) {
            Origin apiOrigin2 = ConfigKt.toApiOrigin(this.config.getOrigin());
            OauthParams oauthParams2 = this.config.getOauthParams();
            return loginSocialAccount$default(this, apiOrigin2, oauthParams2 != null ? oauthParams2.getPackageName() : null, OauthServiceProvider.VK, null, continuation, 8, null);
        }
        if (processType == Config.ProcessType.LOGIN_ESIA) {
            Origin apiOrigin3 = ConfigKt.toApiOrigin(this.config.getOrigin());
            OauthParams oauthParams3 = this.config.getOauthParams();
            return loginSocialAccount(apiOrigin3, oauthParams3 != null ? oauthParams3.getPackageName() : null, OauthServiceProvider.ESIA, EsiaUtilsKt.getEsiaReturnUrl(this.context), continuation);
        }
        throw new IllegalArgumentException("process type is not supported = " + processType);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00af -> B:43:0x00b2). Please report as a decompilation issue!!! */
    @Override // ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object enterIdentifier(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.loading.AuthLoading.Action> r13) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.enterIdentifier(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00cb -> B:13:0x0036). Please report as a decompilation issue!!! */
    @Override // ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object enterOauthCodeEsia(java.lang.String r12, android.net.Uri r13, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.loading.AuthLoading.Action> r14) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.enterOauthCodeEsia(java.lang.String, android.net.Uri, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00d7 -> B:13:0x0038). Please report as a decompilation issue!!! */
    @Override // ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object enterOauthCodeSberId(java.lang.String r12, android.net.Uri r13, java.lang.String r14, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.loading.AuthLoading.Action> r15) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.enterOauthCodeSberId(java.lang.String, android.net.Uri, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00f9 -> B:13:0x0040). Please report as a decompilation issue!!! */
    @Override // ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object enterOauthCodeVkId(java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.loading.AuthLoading.Action> r25) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractorImpl.enterOauthCodeVkId(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractor
    public Object handleLoginSuccess(AuthLoading.Action.LoginSuccess loginSuccess, Continuation<? super AuthLoading.Action> continuation) {
        return ((loginSuccess.getProcess() instanceof LoginProcessEnterOauthCode) && (((LoginProcessEnterOauthCode) loginSuccess.getProcess()).getOauthService() == OauthServiceProvider.SBER || ((LoginProcessEnterOauthCode) loginSuccess.getProcess()).getOauthService() == OauthServiceProvider.VK || ((LoginProcessEnterOauthCode) loginSuccess.getProcess()).getOauthService() == OauthServiceProvider.ESIA)) ? new AuthLoading.Action.LoginSocialAccount((LoginProcessEnterOauthCode) loginSuccess.getProcess()) : new AuthLoading.Action.LoginDefault(loginSuccess.getProcess(), loginSuccess.isForceLogin());
    }

    @Override // ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractor
    public Object setPhone(Config.ProcessType processType, String str, PhoneIdentifier phoneIdentifier, Continuation<? super AuthLoading.Action> continuation) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[processType.ordinal()];
        if (i2 == 1) {
            return setPhoneEnrollment(str, phoneIdentifier, continuation);
        }
        if (i2 == 2) {
            return setPhoneRegistration(str, phoneIdentifier, continuation);
        }
        throw new IllegalArgumentException("process type is not supported = " + processType);
    }
}
