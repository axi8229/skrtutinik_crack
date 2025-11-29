package ru.yoomoney.sdk.auth.api.account;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import retrofit2.Call;
import retrofit2.Response;
import ru.yoomoney.sdk.auth.api.ApiExtentionsKt;
import ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt;
import ru.yoomoney.sdk.auth.api.account.method.DisplayNameRequest;
import ru.yoomoney.sdk.auth.api.account.method.LanguageRequest;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\b\u001a\u00020\tH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u000bJ#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/AccountRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/account/AccountRepository;", "api", "Lru/yoomoney/sdk/auth/api/account/AccountApi;", "(Lru/yoomoney/sdk/auth/api/account/AccountApi;)V", "account", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "token", "", "account-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayName", "nickname", "displayName-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FFmpegMediaMetadataRetriever.METADATA_KEY_LANGUAGE, "request", "Lru/yoomoney/sdk/auth/api/account/method/LanguageRequest;", "language-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/method/LanguageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareAuthorizationHeader", "revoke", "", "revoke-gIAlu-s", "revokeAll", "revokeAll-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountRepositoryImpl implements AccountRepository {
    private final AccountApi api;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl", f = "AccountRepositoryImpl.kt", l = {15}, m = "account-gIAlu-s")
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
            Object objMo3209accountgIAlus = AccountRepositoryImpl.this.mo3209accountgIAlus(null, this);
            return objMo3209accountgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3209accountgIAlus : Result.m2627boximpl(objMo3209accountgIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$account$2", f = "AccountRepositoryImpl.kt", l = {16}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function1<Continuation<? super Result<? extends UserAccount>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, Continuation<? super b> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AccountRepositoryImpl.this.new b(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends UserAccount>> continuation) {
            return AccountRepositoryImpl.this.new b(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AccountApi accountApi = AccountRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = AccountRepositoryImpl.this.prepareAuthorizationHeader(this.c);
                this.a = 1;
                obj = accountApi.account(strPrepareAuthorizationHeader, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl", f = "AccountRepositoryImpl.kt", l = {24}, m = "displayName-0E7RQCE")
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
            Object objMo3210displayName0E7RQCE = AccountRepositoryImpl.this.mo3210displayName0E7RQCE(null, null, this);
            return objMo3210displayName0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3210displayName0E7RQCE : Result.m2627boximpl(objMo3210displayName0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$displayName$2", f = "AccountRepositoryImpl.kt", l = {25}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements Function1<Continuation<? super Result<? extends UserAccount>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, String str2, Continuation<? super d> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AccountRepositoryImpl.this.new d(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends UserAccount>> continuation) {
            return ((d) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AccountApi accountApi = AccountRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = AccountRepositoryImpl.this.prepareAuthorizationHeader(this.c);
                DisplayNameRequest displayNameRequest = new DisplayNameRequest(this.d);
                this.a = 1;
                obj = accountApi.displayName(strPrepareAuthorizationHeader, displayNameRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl", f = "AccountRepositoryImpl.kt", l = {34}, m = "language-0E7RQCE")
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
            Object objMo3211language0E7RQCE = AccountRepositoryImpl.this.mo3211language0E7RQCE(null, null, this);
            return objMo3211language0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3211language0E7RQCE : Result.m2627boximpl(objMo3211language0E7RQCE);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$language$2", f = "AccountRepositoryImpl.kt", l = {35}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements Function1<Continuation<? super Result<? extends UserAccount>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ LanguageRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, LanguageRequest languageRequest, Continuation<? super f> continuation) {
            super(1, continuation);
            this.c = str;
            this.d = languageRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AccountRepositoryImpl.this.new f(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends UserAccount>> continuation) {
            return ((f) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AccountApi accountApi = AccountRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = AccountRepositoryImpl.this.prepareAuthorizationHeader(this.c);
                LanguageRequest languageRequest = this.d;
                this.a = 1;
                obj = accountApi.language(strPrepareAuthorizationHeader, languageRequest, this);
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

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl", f = "AccountRepositoryImpl.kt", l = {43}, m = "revoke-gIAlu-s")
    public static final class g extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objMo3212revokegIAlus = AccountRepositoryImpl.this.mo3212revokegIAlus(null, this);
            return objMo3212revokegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo3212revokegIAlus : Result.m2627boximpl(objMo3212revokegIAlus);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$revoke$2", f = "AccountRepositoryImpl.kt", l = {44}, m = "invokeSuspend")
    public static final class h extends SuspendLambda implements Function1<Continuation<? super Result<? extends Unit>>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, Continuation<? super h> continuation) {
            super(1, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AccountRepositoryImpl.this.new h(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Result<? extends Unit>> continuation) {
            return AccountRepositoryImpl.this.new h(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AccountApi accountApi = AccountRepositoryImpl.this.api;
                String strPrepareAuthorizationHeader = AccountRepositoryImpl.this.prepareAuthorizationHeader(this.c);
                this.a = 1;
                obj = accountApi.revoke(strPrepareAuthorizationHeader, this);
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

    public static final class i extends Lambda implements Function0<Call<Unit>> {
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str) {
            super(0);
            this.b = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Call<Unit> invoke() {
            return AccountRepositoryImpl.this.api.revokeAll(AccountRepositoryImpl.this.prepareAuthorizationHeader(this.b));
        }
    }

    public AccountRepositoryImpl(AccountApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String prepareAuthorizationHeader(String token) {
        return "Bearer " + token;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.AccountRepository
    /* renamed from: account-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3209accountgIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.account.model.UserAccount>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl.a
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$a r0 = (ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$a r0 = new ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$a
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
            ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$b r6 = new ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$b
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl.mo3209accountgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.AccountRepository
    /* renamed from: displayName-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3210displayName0E7RQCE(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.account.model.UserAccount>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl.c
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$c r0 = (ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$c r0 = new ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$c
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
            ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$d r7 = new ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$d
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl.mo3210displayName0E7RQCE(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.AccountRepository
    /* renamed from: language-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3211language0E7RQCE(java.lang.String r5, ru.yoomoney.sdk.auth.api.account.method.LanguageRequest r6, kotlin.coroutines.Continuation<? super kotlin.Result<ru.yoomoney.sdk.auth.api.account.model.UserAccount>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl.e
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$e r0 = (ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$e r0 = new ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$e
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
            ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$f r7 = new ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$f
            r2 = 0
            r7.<init>(r5, r6, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r7, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl.mo3211language0E7RQCE(java.lang.String, ru.yoomoney.sdk.auth.api.account.method.LanguageRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.auth.api.account.AccountRepository
    /* renamed from: revoke-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo3212revokegIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<kotlin.Unit>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl.g
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$g r0 = (ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$g r0 = new ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$g
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
            ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$h r6 = new ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl$h
            r2 = 0
            r6.<init>(r5, r2)
            r0.c = r3
            java.lang.Object r5 = ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt.executeWithResult(r6, r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl.mo3212revokegIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // ru.yoomoney.sdk.auth.api.account.AccountRepository
    /* renamed from: revokeAll-IoAF18A */
    public Object mo3213revokeAllIoAF18A(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return ApiExtentionsKt.executeCall(new i(token));
    }
}
