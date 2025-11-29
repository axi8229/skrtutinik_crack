package ru.yoomoney.sdk.auth.api.account.socialAccount;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Response;
import ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.ConnectSocialAccountResponse;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.EnterOauthCodeResponse;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0002J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\n2\u0006\u0010\u0013\u001a\u00020\u001aH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/SocialAccountRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/SocialAccountRepository;", "api", "Lru/yoomoney/sdk/auth/api/account/socialAccount/SocialAccountApi;", "token", "", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/SocialAccountApi;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "deleteSocialAccount", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "oauthService", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "deleteSocialAccount-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOAuthCode", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/EnterOauthCodeResponse;", "connectSocialAccountProcessId", "request", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeRequest;", "enterOAuthCode-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareAuthorizationHeader", "socialAccount", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/ConnectSocialAccountResponse;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountRequest;", "socialAccount-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SocialAccountRepositoryImpl implements SocialAccountRepository {
    private final SocialAccountApi api;
    private final String token;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl", f = "SocialAccountRepositoryImpl.kt", l = {18}, m = "deleteSocialAccount-gIAlu-s")
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
            Object objMo3238deleteSocialAccountgIAlus = SocialAccountRepositoryImpl.this.mo3238deleteSocialAccountgIAlus(null, this);
            return objMo3238deleteSocialAccountgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3238deleteSocialAccountgIAlus : Result.m2627boximpl(objMo3238deleteSocialAccountgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$deleteSocialAccount$2", f = "SocialAccountRepositoryImpl.kt", l = {19}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends UserAccount>>, Object> {
        public int a;
        public final /* synthetic */ OauthServiceProvider c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(OauthServiceProvider oauthServiceProvider, Continuation<? super b> continuation) {
            super(1, continuation);
            this.c = oauthServiceProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SocialAccountRepositoryImpl.this.new b(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends UserAccount>> continuation) {
            return SocialAccountRepositoryImpl.this.new b(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SocialAccountApi socialAccountApi = SocialAccountRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = SocialAccountRepositoryImpl.this.prepareAuthorizationHeader();
                OauthServiceProvider oauthServiceProvider = this.c;
                this.a = 1;
                obj = socialAccountApi.deleteSocialAccount(strPrepareAuthorizationHeader, oauthServiceProvider, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(ApiV2ExtentionsKt.parseResponseToResult((Response) obj));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl", f = "SocialAccountRepositoryImpl.kt", l = {37}, m = "enterOAuthCode-0E7RQCE")
    public static final class c extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3239enterOAuthCode0E7RQCE = SocialAccountRepositoryImpl.this.mo3239enterOAuthCode0E7RQCE(null, null, this);
            return objMo3239enterOAuthCode0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3239enterOAuthCode0E7RQCE : Result.m2627boximpl(objMo3239enterOAuthCode0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$enterOAuthCode$2", f = "SocialAccountRepositoryImpl.kt", l = {38}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Result<? extends EnterOauthCodeResponse>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ SocialAccountEnterOauthCodeRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, SocialAccountEnterOauthCodeRequest socialAccountEnterOauthCodeRequest, Continuation<? super d> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = socialAccountEnterOauthCodeRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SocialAccountRepositoryImpl.this.new d(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends EnterOauthCodeResponse>> continuation) {
            return ((d) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SocialAccountApi socialAccountApi = SocialAccountRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = SocialAccountRepositoryImpl.this.prepareAuthorizationHeader();
                String str = this.c;
                SocialAccountEnterOauthCodeRequest socialAccountEnterOauthCodeRequest = this.d;
                this.a = 1;
                obj = socialAccountApi.enterOAuthCode(strPrepareAuthorizationHeader, str, socialAccountEnterOauthCodeRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(ApiV2ExtentionsKt.parseResponseToResult((Response) obj));
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl", f = "SocialAccountRepositoryImpl.kt", l = {27}, m = "socialAccount-gIAlu-s")
    public static final class e extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3240socialAccountgIAlus = SocialAccountRepositoryImpl.this.mo3240socialAccountgIAlus(null, this);
            return objMo3240socialAccountgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3240socialAccountgIAlus : Result.m2627boximpl(objMo3240socialAccountgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$socialAccount$2", f = "SocialAccountRepositoryImpl.kt", l = {28}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements Function1<Continuation<? super Result<? extends ConnectSocialAccountResponse>>, Object> {
        public int a;
        public final /* synthetic */ SocialAccountRequest c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SocialAccountRequest socialAccountRequest, Continuation<? super f> continuation) {
            super(1, continuation);
            this.c = socialAccountRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SocialAccountRepositoryImpl.this.new f(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends ConnectSocialAccountResponse>> continuation) {
            return SocialAccountRepositoryImpl.this.new f(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SocialAccountApi socialAccountApi = SocialAccountRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = SocialAccountRepositoryImpl.this.prepareAuthorizationHeader();
                SocialAccountRequest socialAccountRequest = this.c;
                this.a = 1;
                obj = socialAccountApi.socialAccount(strPrepareAuthorizationHeader, socialAccountRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Result.m2627boximpl(ApiV2ExtentionsKt.parseResponseToResult((Response) obj));
        }
    }

    public SocialAccountRepositoryImpl(SocialAccountApi api, String token) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(token, "token");
        this.api = api;
        this.token = token;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String prepareAuthorizationHeader() {
        return "Bearer " + getToken();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepository
    /* renamed from: deleteSocialAccount-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3238deleteSocialAccountgIAlus(ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider r5, kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.account.model.UserAccount>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$b r6 = new ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$b
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl.mo3238deleteSocialAccountgIAlus(ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepository
    /* renamed from: enterOAuthCode-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3239enterOAuthCode0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.socialAccount.method.EnterOauthCodeResponse>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl.c
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$c r0 = (ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$c r0 = new ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$d r7 = new ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$d
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl.mo3239enterOAuthCode0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepository
    public String getToken() {
        return this.token;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepository
    /* renamed from: socialAccount-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3240socialAccountgIAlus(ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountRequest r5, kotlin.coroutines.Continuation<? super kotlin.Result<? extends ru.yoomoney.sdk.auth.api.account.socialAccount.method.ConnectSocialAccountResponse>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl.e
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$e r0 = (ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$e r0 = new ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.getValue()
            goto L49
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$f r6 = new ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl$f
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.socialAccount.SocialAccountRepositoryImpl.mo3240socialAccountgIAlus(ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
