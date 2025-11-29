package ru.yoomoney.sdk.auth.passport.impl;

import android.net.Uri;
import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.api.ClientAppParams;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;
import ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository;
import ru.yoomoney.sdk.auth.api.account.model.ConnectSocialAccountEnterOAuthCode;
import ru.yoomoney.sdk.auth.api.account.model.ConnectSocialAccountFailure;
import ru.yoomoney.sdk.auth.api.account.model.ConnectSocialAccountProcess;
import ru.yoomoney.sdk.auth.api.account.model.ConnectSocialAccountSuccess;
import ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository;
import ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository;
import ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepository;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.ConnectSocialAccountErrorResponse;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.ConnectSocialAccountResponse;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.ConnectSocialAccountSuccessResponse;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.EnterOauthCodeErrorResponse;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.EnterOauthCodeResponse;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.EnterOauthCodeSuccessResponse;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeEsiaRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeSberRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeVkRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.api.model.ProcessErrorExtensionsKt;
import ru.yoomoney.sdk.auth.api.model.TechnicalFailure;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.passport.PassportProfile;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u001fJ\u000e\u0010!\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u001fJ\u0018\u0010\"\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\u0015H\u0096@¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\u0015H\u0096@¢\u0006\u0002\u0010$J \u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0015H\u0096@¢\u0006\u0002\u0010+J*\u0010,\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u00152\b\u0010-\u001a\u0004\u0018\u00010\u0015H\u0096@¢\u0006\u0002\u0010.J&\u0010/\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u00152\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0082@¢\u0006\u0002\u00104J<\u00105\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u00152\b\u00106\u001a\u0004\u0018\u00010\u00152\u0006\u00107\u001a\u00020\u00152\b\u00108\u001a\u0004\u0018\u00010\u00152\b\u00109\u001a\u0004\u0018\u00010\u0015H\u0096@¢\u0006\u0002\u0010:J\u0018\u0010;\u001a\u00020\u00182\u0006\u0010<\u001a\u00020=2\u0006\u00100\u001a\u000201H\u0002J\u0018\u0010>\u001a\u00020\u00182\u0006\u0010<\u001a\u00020?2\u0006\u00100\u001a\u000201H\u0002J\u0010\u0010@\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020AH\u0016J\u0018\u0010B\u001a\u00020\u00182\u0006\u0010<\u001a\u00020C2\u0006\u00100\u001a\u000201H\u0002J\u0016\u0010D\u001a\u00020\u00182\u0006\u00100\u001a\u000201H\u0096@¢\u0006\u0002\u0010EJ\u0016\u0010F\u001a\u00020\u00182\u0006\u00100\u001a\u000201H\u0096@¢\u0006\u0002\u0010ER\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lru/yoomoney/sdk/auth/passport/impl/PassportProfileInteractorImpl;", "Lru/yoomoney/sdk/auth/passport/impl/PassportProfileInteractor;", "accountRepository", "Lru/yoomoney/sdk/auth/api/account/AccountRepository;", "emailChangeRepository", "Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;", "phoneChangeRepository", "Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeRepository;", "passwordChangeRepository", "Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;", "socialAccountRepository", "Lru/yoomoney/sdk/auth/api/account/socialAccount/SocialAccountRepository;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "config", "Lru/yoomoney/sdk/auth/Config;", "profiler", "Lru/yoomoney/sdk/yooprofiler/YooProfiler;", "clientAppParams", "Lru/yoomoney/sdk/auth/api/ClientAppParams;", "esiaReturnUrl", "", "(Lru/yoomoney/sdk/auth/api/account/AccountRepository;Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeRepository;Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;Lru/yoomoney/sdk/auth/api/account/socialAccount/SocialAccountRepository;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;Lru/yoomoney/sdk/auth/Config;Lru/yoomoney/sdk/yooprofiler/YooProfiler;Lru/yoomoney/sdk/auth/api/ClientAppParams;Ljava/lang/String;)V", "account", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;", "action", "(Lru/yoomoney/sdk/auth/passport/PassportProfile$Action;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountSuccess", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$HandleAccountSuccess;", "(Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$HandleAccountSuccess;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeEmail", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changePassword", "changePhone", "checkEmail", Scopes.EMAIL, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkPhone", "phone", "enterOauthCodeEsia", "uri", "Landroid/net/Uri;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "(Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOauthCodeSberId", "returnUrl", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOauthCodeSocialAccount", "serviceProvider", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "request", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeRequest;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOauthCodeVkId", "code", "state", "redirectUrl", "uuid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleConnectSocialAccountProcess", "result", "Lru/yoomoney/sdk/auth/api/account/model/ConnectSocialAccountProcess;", "handleConnectSocialAccountResponse", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/ConnectSocialAccountResponse;", "handleEmailChange", "Lru/yoomoney/sdk/auth/passport/PassportProfile$Action$AccountSuccess;", "handleEnterOauthCodeResponse", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/EnterOauthCodeResponse;", "startBindingSocialAccount", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unbindSocialAccount", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PassportProfileInteractorImpl implements PassportProfileInteractor {
    private final AccountRepository accountRepository;
    private final ClientAppParams clientAppParams;
    private final Config config;
    private final EmailChangeRepository emailChangeRepository;
    private final String esiaReturnUrl;
    private final PasswordChangeRepository passwordChangeRepository;
    private final PhoneChangeRepository phoneChangeRepository;
    private final YooProfiler profiler;
    private final ServerTimeRepository serverTimeRepository;
    private final SocialAccountRepository socialAccountRepository;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessType.values().length];
            try {
                iArr[ProcessType.CHANGE_PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessType.CHANGE_EMAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl", f = "PassportProfileInteractor.kt", l = {90, 94}, m = "account")
    public static final class a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return PassportProfileInteractorImpl.this.account(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl", f = "PassportProfileInteractor.kt", l = {124, 125}, m = "changeEmail")
    public static final class b extends ContinuationImpl {
        public PassportProfileInteractorImpl a;
        public /* synthetic */ Object b;
        public int d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return PassportProfileInteractorImpl.this.changeEmail(this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl", f = "PassportProfileInteractor.kt", l = {159, 160}, m = "changePassword")
    public static final class c extends ContinuationImpl {
        public PassportProfileInteractorImpl a;
        public /* synthetic */ Object b;
        public int d;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return PassportProfileInteractorImpl.this.changePassword(this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl", f = "PassportProfileInteractor.kt", l = {142, 143}, m = "changePhone")
    public static final class d extends ContinuationImpl {
        public PassportProfileInteractorImpl a;
        public /* synthetic */ Object b;
        public int d;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return PassportProfileInteractorImpl.this.changePhone(this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl", f = "PassportProfileInteractor.kt", l = {299, 303}, m = "enterOauthCodeSocialAccount")
    public static final class e extends ContinuationImpl {
        public PassportProfileInteractorImpl a;
        public String b;
        public OauthServiceProvider c;
        public SocialAccountEnterOauthCodeRequest d;
        public int e;
        public /* synthetic */ Object f;
        public int h;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return PassportProfileInteractorImpl.this.enterOauthCodeSocialAccount(null, null, null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl", f = "PassportProfileInteractor.kt", l = {193, 197}, m = "startBindingSocialAccount")
    public static final class f extends ContinuationImpl {
        public PassportProfileInteractorImpl a;
        public OauthServiceProvider b;
        public SocialAccountRequest c;
        public int d;
        public /* synthetic */ Object e;
        public int g;

        public f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return PassportProfileInteractorImpl.this.startBindingSocialAccount(null, this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl", f = "PassportProfileInteractor.kt", l = {215}, m = "unbindSocialAccount")
    public static final class g extends ContinuationImpl {
        public OauthServiceProvider a;
        public /* synthetic */ Object b;
        public int d;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return PassportProfileInteractorImpl.this.unbindSocialAccount(null, this);
        }
    }

    public PassportProfileInteractorImpl(AccountRepository accountRepository, EmailChangeRepository emailChangeRepository, PhoneChangeRepository phoneChangeRepository, PasswordChangeRepository passwordChangeRepository, SocialAccountRepository socialAccountRepository, ServerTimeRepository serverTimeRepository, Config config, YooProfiler profiler, ClientAppParams clientAppParams, String str) {
        Intrinsics.checkNotNullParameter(accountRepository, "accountRepository");
        Intrinsics.checkNotNullParameter(emailChangeRepository, "emailChangeRepository");
        Intrinsics.checkNotNullParameter(phoneChangeRepository, "phoneChangeRepository");
        Intrinsics.checkNotNullParameter(passwordChangeRepository, "passwordChangeRepository");
        Intrinsics.checkNotNullParameter(socialAccountRepository, "socialAccountRepository");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(clientAppParams, "clientAppParams");
        this.accountRepository = accountRepository;
        this.emailChangeRepository = emailChangeRepository;
        this.phoneChangeRepository = phoneChangeRepository;
        this.passwordChangeRepository = passwordChangeRepository;
        this.socialAccountRepository = socialAccountRepository;
        this.serverTimeRepository = serverTimeRepository;
        this.config = config;
        this.profiler = profiler;
        this.clientAppParams = clientAppParams;
        this.esiaReturnUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00b8 -> B:13:0x0036). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object enterOauthCodeSocialAccount(java.lang.String r12, ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider r13, ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeRequest r14, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.passport.PassportProfile.Action> r15) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.enterOauthCodeSocialAccount(java.lang.String, ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider, ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final PassportProfile.Action handleConnectSocialAccountProcess(ConnectSocialAccountProcess result, OauthServiceProvider serviceProvider) {
        PassportProfile.Action bindSocialAccountSuccess;
        if (result instanceof ConnectSocialAccountEnterOAuthCode) {
            return new PassportProfile.Action.StartBindingSocialAccountSuccess((ConnectSocialAccountEnterOAuthCode) result);
        }
        if (result instanceof ConnectSocialAccountFailure) {
            bindSocialAccountSuccess = new PassportProfile.Action.BindSocialAccountError(ProcessErrorExtensionsKt.toSocialAccountFailure(((ConnectSocialAccountFailure) result).getError(), serviceProvider));
        } else {
            if (!(result instanceof ConnectSocialAccountSuccess)) {
                throw new NoWhenBranchMatchedException();
            }
            bindSocialAccountSuccess = new PassportProfile.Action.BindSocialAccountSuccess(((ConnectSocialAccountSuccess) result).getAccount(), serviceProvider);
        }
        return bindSocialAccountSuccess;
    }

    private final PassportProfile.Action handleConnectSocialAccountResponse(ConnectSocialAccountResponse result, OauthServiceProvider serviceProvider) {
        if (result instanceof ConnectSocialAccountSuccessResponse) {
            return handleConnectSocialAccountProcess(((ConnectSocialAccountSuccessResponse) result).getProcess(), serviceProvider);
        }
        if (result instanceof ConnectSocialAccountErrorResponse) {
            return new PassportProfile.Action.BindSocialAccountError(ProcessErrorExtensionsKt.toFailure(((ConnectSocialAccountErrorResponse) result).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final PassportProfile.Action handleEnterOauthCodeResponse(EnterOauthCodeResponse result, OauthServiceProvider serviceProvider) {
        if (result instanceof EnterOauthCodeSuccessResponse) {
            return handleConnectSocialAccountProcess(((EnterOauthCodeSuccessResponse) result).getProcess(), serviceProvider);
        }
        if (result instanceof EnterOauthCodeErrorResponse) {
            return new PassportProfile.Action.BindSocialAccountError(ProcessErrorExtensionsKt.toFailure(((EnterOauthCodeErrorResponse) result).getError()));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object account(ru.yoomoney.sdk.auth.passport.PassportProfile.Action r7, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.passport.PassportProfile.Action> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.a
            if (r0 == 0) goto L13
            r0 = r8
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$a r0 = (ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$a r0 = new ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            java.lang.String r3 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            r4 = 1
            r5 = 2
            if (r2 == 0) goto L46
            if (r2 == r4) goto L3c
            if (r2 != r5) goto L34
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r7 = r8.getValue()
            goto L8e
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r7 = r8.getValue()
            goto L5e
        L46:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r7 instanceof ru.yoomoney.sdk.auth.passport.PassportProfile.Action.Init
            if (r8 == 0) goto L79
            ru.yoomoney.sdk.auth.api.account.AccountRepository r8 = r6.accountRepository
            ru.yoomoney.sdk.auth.passport.PassportProfile$Action$Init r7 = (ru.yoomoney.sdk.auth.passport.PassportProfile.Action.Init) r7
            java.lang.String r7 = r7.getAccountToken()
            r0.c = r4
            java.lang.Object r7 = r8.mo3209accountgIAlus(r7, r0)
            if (r7 != r1) goto L5e
            return r1
        L5e:
            java.lang.Throwable r8 = kotlin.Result.m2631exceptionOrNullimpl(r7)
            if (r8 != 0) goto L6d
            ru.yoomoney.sdk.auth.api.account.model.UserAccount r7 = (ru.yoomoney.sdk.auth.api.account.model.UserAccount) r7
            ru.yoomoney.sdk.auth.passport.PassportProfile$Action$AccountSuccess r8 = new ru.yoomoney.sdk.auth.passport.PassportProfile$Action$AccountSuccess
            r0 = 0
            r8.<init>(r7, r0, r5, r0)
            goto La7
        L6d:
            ru.yoomoney.sdk.auth.passport.PassportProfile$Action$AccountFailed r7 = new ru.yoomoney.sdk.auth.passport.PassportProfile$Action$AccountFailed
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r3)
            ru.yoomoney.sdk.auth.api.model.Failure r8 = (ru.yoomoney.sdk.auth.api.model.Failure) r8
            r7.<init>(r8)
        L77:
            r8 = r7
            goto La7
        L79:
            boolean r8 = r7 instanceof ru.yoomoney.sdk.auth.passport.PassportProfile.Action.InitEmailProcess
            if (r8 == 0) goto La8
            ru.yoomoney.sdk.auth.api.account.AccountRepository r8 = r6.accountRepository
            ru.yoomoney.sdk.auth.passport.PassportProfile$Action$InitEmailProcess r7 = (ru.yoomoney.sdk.auth.passport.PassportProfile.Action.InitEmailProcess) r7
            java.lang.String r7 = r7.getAccountToken()
            r0.c = r5
            java.lang.Object r7 = r8.mo3209accountgIAlus(r7, r0)
            if (r7 != r1) goto L8e
            return r1
        L8e:
            java.lang.Throwable r8 = kotlin.Result.m2631exceptionOrNullimpl(r7)
            if (r8 != 0) goto L9c
            ru.yoomoney.sdk.auth.api.account.model.UserAccount r7 = (ru.yoomoney.sdk.auth.api.account.model.UserAccount) r7
            ru.yoomoney.sdk.auth.passport.PassportProfile$Action$StartEmailProcess r8 = new ru.yoomoney.sdk.auth.passport.PassportProfile$Action$StartEmailProcess
            r8.<init>(r7)
            goto La7
        L9c:
            ru.yoomoney.sdk.auth.passport.PassportProfile$Action$AccountFailed r7 = new ru.yoomoney.sdk.auth.passport.PassportProfile$Action$AccountFailed
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r3)
            ru.yoomoney.sdk.auth.api.model.Failure r8 = (ru.yoomoney.sdk.auth.api.model.Failure) r8
            r7.<init>(r8)
            goto L77
        La7:
            return r8
        La8:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "no command for process "
            r8.append(r0)
            r8.append(r6)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.account(ru.yoomoney.sdk.auth.passport.PassportProfile$Action, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor
    public Object accountSuccess(PassportProfile.Action.HandleAccountSuccess handleAccountSuccess, Continuation<? super PassportProfile.Action> continuation) {
        Object changePhoneSuccess;
        ProcessType processType = handleAccountSuccess.getProcessType();
        int i = processType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[processType.ordinal()];
        if (i == 1) {
            changePhoneSuccess = new PassportProfile.Action.ChangePhoneSuccess(handleAccountSuccess.getAccount().getPhone().getTitle());
        } else {
            if (i != 2) {
                return PassportProfile.Action.Nothing.INSTANCE;
            }
            changePhoneSuccess = new PassportProfile.Action.ChangeEmailSuccess(handleAccountSuccess.getAccount().getEmail().getTitle());
        }
        return changePhoneSuccess;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object changeEmail(kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.passport.PassportProfile.Action> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.b
            if (r0 == 0) goto L13
            r0 = r10
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$b r0 = (ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$b r0 = new ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$b
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r10 = r10.getValue()
            goto L61
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3c:
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl r2 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L53
        L42:
            kotlin.ResultKt.throwOnFailure(r10)
            ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository r10 = r9.serverTimeRepository
            r0.a = r9
            r0.d = r4
            java.lang.Object r10 = r10.init(r0)
            if (r10 != r1) goto L52
            return r1
        L52:
            r2 = r9
        L53:
            ru.yoomoney.sdk.auth.api.account.emailChange.EmailChangeRepository r10 = r2.emailChangeRepository
            r0.a = r2
            r0.d = r3
            java.lang.Object r10 = r10.mo3220emailIoAF18A(r0)
            if (r10 != r1) goto L60
            return r1
        L60:
            r0 = r2
        L61:
            boolean r1 = kotlin.Result.m2634isSuccessimpl(r10)
            if (r1 == 0) goto L7c
            r1 = r10
            ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailSuccessResponse r1 = (ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailSuccessResponse) r1
            java.lang.String r3 = r1.getTmxSessionId()
            if (r3 == 0) goto L7c
            ru.yoomoney.sdk.yooprofiler.YooProfiler r2 = r0.profiler
            ru.yoomoney.sdk.yooprofiler.ProfileEventType r4 = ru.yoomoney.sdk.yooprofiler.ProfileEventType.DETAILS_CHANGE
            r7 = 12
            r8 = 0
            r5 = 0
            r6 = 0
            ru.yoomoney.sdk.yooprofiler.YooProfiler.DefaultImpls.profileWithSessionId$default(r2, r3, r4, r5, r6, r7, r8)
        L7c:
            java.lang.Throwable r0 = kotlin.Result.m2631exceptionOrNullimpl(r10)
            if (r0 != 0) goto L8e
            ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailSuccessResponse r10 = (ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailSuccessResponse) r10
            ru.yoomoney.sdk.auth.passport.PassportProfile$Action$StartChangeSuccess r0 = new ru.yoomoney.sdk.auth.passport.PassportProfile$Action$StartChangeSuccess
            ru.yoomoney.sdk.auth.api.account.model.ChangeEmailProcess r10 = r10.getProcess()
            r0.<init>(r10)
            goto L9b
        L8e:
            ru.yoomoney.sdk.auth.passport.PassportProfile$Action$StartChangeFailed r10 = new ru.yoomoney.sdk.auth.passport.PassportProfile$Action$StartChangeFailed
            java.lang.String r1 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            ru.yoomoney.sdk.auth.api.model.Failure r0 = (ru.yoomoney.sdk.auth.api.model.Failure) r0
            r10.<init>(r0)
            r0 = r10
        L9b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.changeEmail(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object changePassword(kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.passport.PassportProfile.Action> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.c
            if (r0 == 0) goto L13
            r0 = r10
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$c r0 = (ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$c r0 = new ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$c
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r10 = r10.getValue()
            goto L61
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3c:
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl r2 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L53
        L42:
            kotlin.ResultKt.throwOnFailure(r10)
            ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository r10 = r9.serverTimeRepository
            r0.a = r9
            r0.d = r4
            java.lang.Object r10 = r10.init(r0)
            if (r10 != r1) goto L52
            return r1
        L52:
            r2 = r9
        L53:
            ru.yoomoney.sdk.auth.api.account.passwordChange.PasswordChangeRepository r10 = r2.passwordChangeRepository
            r0.a = r2
            r0.d = r3
            java.lang.Object r10 = r10.mo3231passwordIoAF18A(r0)
            if (r10 != r1) goto L60
            return r1
        L60:
            r0 = r2
        L61:
            boolean r1 = kotlin.Result.m2634isSuccessimpl(r10)
            if (r1 == 0) goto L7c
            r1 = r10
            ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordSuccessResponse r1 = (ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordSuccessResponse) r1
            java.lang.String r3 = r1.getTmxSessionId()
            if (r3 == 0) goto L7c
            ru.yoomoney.sdk.yooprofiler.YooProfiler r2 = r0.profiler
            ru.yoomoney.sdk.yooprofiler.ProfileEventType r4 = ru.yoomoney.sdk.yooprofiler.ProfileEventType.DETAILS_CHANGE
            r7 = 12
            r8 = 0
            r5 = 0
            r6 = 0
            ru.yoomoney.sdk.yooprofiler.YooProfiler.DefaultImpls.profileWithSessionId$default(r2, r3, r4, r5, r6, r7, r8)
        L7c:
            java.lang.Throwable r0 = kotlin.Result.m2631exceptionOrNullimpl(r10)
            if (r0 != 0) goto L8e
            ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordSuccessResponse r10 = (ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordSuccessResponse) r10
            ru.yoomoney.sdk.auth.passport.PassportProfile$Action$StartChangeSuccess r0 = new ru.yoomoney.sdk.auth.passport.PassportProfile$Action$StartChangeSuccess
            ru.yoomoney.sdk.auth.api.account.model.ChangePasswordProcess r10 = r10.getProcess()
            r0.<init>(r10)
            goto L9b
        L8e:
            ru.yoomoney.sdk.auth.passport.PassportProfile$Action$StartChangeFailed r10 = new ru.yoomoney.sdk.auth.passport.PassportProfile$Action$StartChangeFailed
            java.lang.String r1 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            ru.yoomoney.sdk.auth.api.model.Failure r0 = (ru.yoomoney.sdk.auth.api.model.Failure) r0
            r10.<init>(r0)
            r0 = r10
        L9b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.changePassword(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object changePhone(kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.passport.PassportProfile.Action> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.d
            if (r0 == 0) goto L13
            r0 = r10
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$d r0 = (ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$d r0 = new ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$d
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r10 = r10.getValue()
            goto L61
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3c:
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl r2 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L53
        L42:
            kotlin.ResultKt.throwOnFailure(r10)
            ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository r10 = r9.serverTimeRepository
            r0.a = r9
            r0.d = r4
            java.lang.Object r10 = r10.init(r0)
            if (r10 != r1) goto L52
            return r1
        L52:
            r2 = r9
        L53:
            ru.yoomoney.sdk.auth.api.account.phoneChange.PhoneChangeRepository r10 = r2.phoneChangeRepository
            r0.a = r2
            r0.d = r3
            java.lang.Object r10 = r10.mo3236phoneIoAF18A(r0)
            if (r10 != r1) goto L60
            return r1
        L60:
            r0 = r2
        L61:
            boolean r1 = kotlin.Result.m2634isSuccessimpl(r10)
            if (r1 == 0) goto L7a
            r1 = r10
            ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneSuccessResponse r1 = (ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneSuccessResponse) r1
            java.lang.String r3 = r1.getTmxSessionId()
            ru.yoomoney.sdk.yooprofiler.YooProfiler r2 = r0.profiler
            ru.yoomoney.sdk.yooprofiler.ProfileEventType r4 = ru.yoomoney.sdk.yooprofiler.ProfileEventType.DETAILS_CHANGE
            r7 = 12
            r8 = 0
            r5 = 0
            r6 = 0
            ru.yoomoney.sdk.yooprofiler.YooProfiler.DefaultImpls.profileWithSessionId$default(r2, r3, r4, r5, r6, r7, r8)
        L7a:
            java.lang.Throwable r0 = kotlin.Result.m2631exceptionOrNullimpl(r10)
            if (r0 != 0) goto L8c
            ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneSuccessResponse r10 = (ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneSuccessResponse) r10
            ru.yoomoney.sdk.auth.passport.PassportProfile$Action$StartChangeSuccess r0 = new ru.yoomoney.sdk.auth.passport.PassportProfile$Action$StartChangeSuccess
            ru.yoomoney.sdk.auth.api.account.model.ChangePhoneProcess r10 = r10.getProcess()
            r0.<init>(r10)
            goto L99
        L8c:
            ru.yoomoney.sdk.auth.passport.PassportProfile$Action$StartChangeFailed r10 = new ru.yoomoney.sdk.auth.passport.PassportProfile$Action$StartChangeFailed
            java.lang.String r1 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            ru.yoomoney.sdk.auth.api.model.Failure r0 = (ru.yoomoney.sdk.auth.api.model.Failure) r0
            r10.<init>(r0)
            r0 = r10
        L99:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.changePhone(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor
    public Object checkEmail(String str, Continuation<? super PassportProfile.Action> continuation) {
        return (str == null || StringsKt.isBlank(str)) ? PassportProfile.Action.ConfirmChangeEmail.INSTANCE : PassportProfile.Action.ShowChangeEmailDialog.INSTANCE;
    }

    @Override // ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor
    public Object checkPhone(String str, Continuation<? super PassportProfile.Action> continuation) {
        return (str == null || StringsKt.isBlank(str)) ? PassportProfile.Action.ConfirmChangePhone.INSTANCE : PassportProfile.Action.ShowChangePhoneDialog.INSTANCE;
    }

    @Override // ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor
    public Object enterOauthCodeEsia(Uri uri, String str, Continuation<? super PassportProfile.Action> continuation) {
        String queryParameter = uri.getQueryParameter("code");
        String queryParameter2 = uri.getQueryParameter("state");
        return (str == null || queryParameter == null || queryParameter2 == null) ? new PassportProfile.Action.BindingSocialAccountFailed(new TechnicalFailure(null, 1, null)) : enterOauthCodeSocialAccount(str, OauthServiceProvider.ESIA, new SocialAccountEnterOauthCodeEsiaRequest(queryParameter, queryParameter2), continuation);
    }

    @Override // ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor
    public Object enterOauthCodeSberId(Uri uri, String str, String str2, Continuation<? super PassportProfile.Action> continuation) {
        String queryParameter = uri.getQueryParameter("code");
        String queryParameter2 = uri.getQueryParameter("state");
        return (str2 == null || str == null || queryParameter == null || queryParameter2 == null) ? new PassportProfile.Action.BindingSocialAccountFailed(new TechnicalFailure(null, 1, null)) : enterOauthCodeSocialAccount(str, OauthServiceProvider.SBER, new SocialAccountEnterOauthCodeSberRequest(queryParameter, queryParameter2, str2), continuation);
    }

    @Override // ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor
    public Object enterOauthCodeVkId(String str, String str2, String str3, String str4, String str5, Continuation<? super PassportProfile.Action> continuation) {
        return (str2 == null || str4 == null || str5 == null) ? new PassportProfile.Action.BindingSocialAccountFailed(new TechnicalFailure(null, 1, null)) : enterOauthCodeSocialAccount(str, OauthServiceProvider.VK, new SocialAccountEnterOauthCodeVkRequest(str2, str3, str4, str5), continuation);
    }

    @Override // ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor
    public PassportProfile.Action handleEmailChange(PassportProfile.Action.AccountSuccess action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return (this.config.getEmailFillingReason() == Config.EmailFillingReason.UPGRADE_STATUS && action.getProcessType() == ProcessType.CHANGE_EMAIL) ? PassportProfile.Action.Finish.INSTANCE : new PassportProfile.Action.HandleAccountSuccess(action.getAccount(), action.getProcessType());
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x010c -> B:14:0x003b). Please report as a decompilation issue!!! */
    @Override // ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object startBindingSocialAccount(ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider r16, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.passport.PassportProfile.Action> r17) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.startBindingSocialAccount(ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object unbindSocialAccount(ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider r5, kotlin.coroutines.Continuation<? super ru.yoomoney.sdk.auth.passport.PassportProfile.Action> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.g
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$g r0 = (ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.g) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$g r0 = new ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl$g
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r6 = r6.getValue()
            goto L49
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepository r6 = r4.socialAccountRepository
            r0.a = r5
            r0.d = r3
            java.lang.Object r6 = r6.mo3238deleteSocialAccountgIAlus(r5, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            java.lang.Throwable r0 = kotlin.Result.m2631exceptionOrNullimpl(r6)
            if (r0 != 0) goto L57
            ru.yoomoney.sdk.auth.api.account.model.UserAccount r6 = (ru.yoomoney.sdk.auth.api.account.model.UserAccount) r6
            ru.yoomoney.sdk.auth.passport.PassportProfile$Action$UnbindSocialAccountSuccess r0 = new ru.yoomoney.sdk.auth.passport.PassportProfile$Action$UnbindSocialAccountSuccess
            r0.<init>(r6, r5)
            goto L64
        L57:
            ru.yoomoney.sdk.auth.passport.PassportProfile$Action$UnbindSocialAccountFailed r5 = new ru.yoomoney.sdk.auth.passport.PassportProfile$Action$UnbindSocialAccountFailed
            java.lang.String r6 = "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r6)
            ru.yoomoney.sdk.auth.api.model.Failure r0 = (ru.yoomoney.sdk.auth.api.model.Failure) r0
            r5.<init>(r0)
            r0 = r5
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractorImpl.unbindSocialAccount(ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
