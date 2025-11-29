package ru.yoomoney.sdk.auth.api.auxAuthorization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import ru.yoomoney.sdk.auth.api.ApiV2ExtentionsKt;
import ru.yoomoney.sdk.auth.api.auxAuthorization.method.AuxAuthorizationInfoRequest;
import ru.yoomoney.sdk.auth.api.auxAuthorization.method.AuxAuthorizationRequest;
import ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxToken;
import ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxTokenScope;
import ru.yoomoney.sdk.auth.api.model.ApplicationInfo;
import ru.yoomoney.sdk.auth.api.model.Failure;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J<\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ:\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\tH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationRepositoryImpl;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationRepository;", "api", "Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationApi;", "(Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationApi;)V", "auxAuthorization", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxToken;", "token", "", "scopes", "", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxTokenScope;", "authCenterClientId", "auxAuthorization-BWLJW6A", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auxAuthorizationInfo", "Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "auxAuthorizationInfo-BWLJW6A", "prepareAuthorizationHeader", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuxAuthorizationRepositoryImpl implements AuxAuthorizationRepository {
    private final AuxAuthorizationApi api;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepositoryImpl$auxAuthorization$response$1", f = "AuxAuthorizationRepositoryImpl.kt", l = {23}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends AuxToken>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ List<AuxTokenScope> e;

        @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepositoryImpl$auxAuthorization$response$1$1", f = "AuxAuthorizationRepositoryImpl.kt", l = {24}, m = "invokeSuspend")
        /* renamed from: ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepositoryImpl$a$a, reason: collision with other inner class name */
        public static final class C0302a extends SuspendLambda implements Function1<Continuation<? super Result<? extends AuxToken>>, Object> {
            public int a;
            public final /* synthetic */ AuxAuthorizationRepositoryImpl b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ List<AuxTokenScope> e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0302a(AuxAuthorizationRepositoryImpl auxAuthorizationRepositoryImpl, String str, String str2, List<? extends AuxTokenScope> list, Continuation<? super C0302a> continuation) {
                super(1, continuation);
                this.b = auxAuthorizationRepositoryImpl;
                this.c = str;
                this.d = str2;
                this.e = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C0302a(this.b, this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Result<? extends AuxToken>> continuation) {
                return ((C0302a) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AuxAuthorizationApi auxAuthorizationApi = this.b.api;
                    String strPrepareAuthorizationHeader = this.b.prepareAuthorizationHeader(this.c);
                    String str = this.d;
                    List<AuxTokenScope> list = this.e;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((AuxTokenScope) it.next()).toString());
                    }
                    AuxAuthorizationRequest auxAuthorizationRequest = new AuxAuthorizationRequest(str, arrayList);
                    this.a = 1;
                    obj = auxAuthorizationApi.auxAuthorization(strPrepareAuthorizationHeader, auxAuthorizationRequest, this);
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(String str, String str2, List<? extends AuxTokenScope> list, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = str;
            this.d = str2;
            this.e = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AuxAuthorizationRepositoryImpl.this.new a(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends AuxToken>> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objExecuteWithResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C0302a c0302a = new C0302a(AuxAuthorizationRepositoryImpl.this, this.c, this.d, this.e, null);
                this.a = 1;
                objExecuteWithResult = ApiV2ExtentionsKt.executeWithResult(c0302a, this);
                if (objExecuteWithResult == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objExecuteWithResult = ((Result) obj).getValue();
            }
            return Result.m2627boximpl(objExecuteWithResult);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepositoryImpl$auxAuthorizationInfo$response$1", f = "AuxAuthorizationRepositoryImpl.kt", l = {45}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ApplicationInfo>>, Object> {
        public int a;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ List<AuxTokenScope> e;

        @DebugMetadata(c = "ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepositoryImpl$auxAuthorizationInfo$response$1$1", f = "AuxAuthorizationRepositoryImpl.kt", l = {46}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements Function1<Continuation<? super Result<? extends ApplicationInfo>>, Object> {
            public int a;
            public final /* synthetic */ AuxAuthorizationRepositoryImpl b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ List<AuxTokenScope> e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(AuxAuthorizationRepositoryImpl auxAuthorizationRepositoryImpl, String str, String str2, List<? extends AuxTokenScope> list, Continuation<? super a> continuation) {
                super(1, continuation);
                this.b = auxAuthorizationRepositoryImpl;
                this.c = str;
                this.d = str2;
                this.e = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Result<? extends ApplicationInfo>> continuation) {
                return ((a) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AuxAuthorizationApi auxAuthorizationApi = this.b.api;
                    String strPrepareAuthorizationHeader = this.b.prepareAuthorizationHeader(this.c);
                    String str = this.d;
                    List<AuxTokenScope> list = this.e;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((AuxTokenScope) it.next()).toString());
                    }
                    AuxAuthorizationInfoRequest auxAuthorizationInfoRequest = new AuxAuthorizationInfoRequest(str, arrayList);
                    this.a = 1;
                    obj = auxAuthorizationApi.auxAuthorizationInfo(strPrepareAuthorizationHeader, auxAuthorizationInfoRequest, this);
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(String str, String str2, List<? extends AuxTokenScope> list, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = str;
            this.d = str2;
            this.e = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AuxAuthorizationRepositoryImpl.this.new b(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends ApplicationInfo>> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objExecuteWithResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                a aVar = new a(AuxAuthorizationRepositoryImpl.this, this.c, this.d, this.e, null);
                this.a = 1;
                objExecuteWithResult = ApiV2ExtentionsKt.executeWithResult(aVar, this);
                if (objExecuteWithResult == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objExecuteWithResult = ((Result) obj).getValue();
            }
            return Result.m2627boximpl(objExecuteWithResult);
        }
    }

    public AuxAuthorizationRepositoryImpl(AuxAuthorizationApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String prepareAuthorizationHeader(String token) {
        return "Bearer " + token;
    }

    @Override // ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepository
    /* renamed from: auxAuthorization-BWLJW6A */
    public Object mo3241auxAuthorizationBWLJW6A(String str, List<? extends AuxTokenScope> list, String str2, Continuation<? super Result<AuxToken>> continuation) {
        Object value = ((Result) BuildersKt__BuildersKt.runBlocking$default(null, new a(str, str2, list, null), 1, null)).getValue();
        Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(value);
        if (thM2631exceptionOrNullimpl == null) {
            AuxToken auxToken = (AuxToken) value;
            return Result.m2628constructorimpl(new AuxToken(auxToken.getAccessToken(), auxToken.getExpireAt()));
        }
        Intrinsics.checkNotNull(thM2631exceptionOrNullimpl, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure");
        return Result.m2628constructorimpl(ResultKt.createFailure((Failure) thM2631exceptionOrNullimpl));
    }

    @Override // ru.yoomoney.sdk.auth.api.auxAuthorization.AuxAuthorizationRepository
    /* renamed from: auxAuthorizationInfo-BWLJW6A */
    public Object mo3242auxAuthorizationInfoBWLJW6A(String str, List<? extends AuxTokenScope> list, String str2, Continuation<? super Result<ApplicationInfo>> continuation) {
        Object objCreateFailure;
        Object value = ((Result) BuildersKt__BuildersKt.runBlocking$default(null, new b(str, str2, list, null), 1, null)).getValue();
        Throwable thM2631exceptionOrNullimpl = Result.m2631exceptionOrNullimpl(value);
        if (thM2631exceptionOrNullimpl == null) {
            objCreateFailure = (ApplicationInfo) value;
        } else {
            Intrinsics.checkNotNull(thM2631exceptionOrNullimpl, "null cannot be cast to non-null type ru.yoomoney.sdk.auth.api.model.Failure");
            objCreateFailure = ResultKt.createFailure((Failure) thM2631exceptionOrNullimpl);
        }
        return Result.m2628constructorimpl(objCreateFailure);
    }
}
