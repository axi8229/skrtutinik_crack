package ru.yoomoney.sdk.auth.logout;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ru.yoomoney.sdk.auth.api.ApiClientUtilsKt;
import ru.yoomoney.sdk.auth.api.account.AccountRepositoryImpl;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/logout/LogoutWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LogoutWorker extends CoroutineWorker {

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.logout.LogoutWorker", f = "LogoutWorker.kt", l = {20}, m = "doWork")
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
            return LogoutWorker.this.doWork(this);
        }
    }

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.logout.LogoutWorker$doWork$2", f = "LogoutWorker.kt", l = {}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
        public /* synthetic */ Object a;

        @DebugMetadata(c = "ru.yoomoney.sdk.auth.logout.LogoutWorker$doWork$2$1", f = "LogoutWorker.kt", l = {30}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ AccountRepositoryImpl b;
            public final /* synthetic */ String c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(AccountRepositoryImpl accountRepositoryImpl, String str, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = accountRepositoryImpl;
                this.c = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AccountRepositoryImpl accountRepositoryImpl = this.b;
                    String str = this.c;
                    this.a = 1;
                    if (accountRepositoryImpl.mo3212revokegIAlus(str, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                }
                return Unit.INSTANCE;
            }
        }

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = LogoutWorker.this.new b(continuation);
            bVar.a = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
            b bVar = LogoutWorker.this.new b(continuation);
            bVar.a = coroutineScope;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.a;
            String string = LogoutWorker.this.getInputData().getString("logoutBaseURL");
            if (string == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Intrinsics.checkNotNullExpressionValue(string, "requireNotNull(...)");
            boolean z = LogoutWorker.this.getInputData().getBoolean("isDebugMode", false);
            Context applicationContext = LogoutWorker.this.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            AccountRepositoryImpl accountRepositoryImpl = new AccountRepositoryImpl(ApiClientUtilsKt.createApiClient$default(applicationContext, string, z, null, 8, null).getAccountApi());
            String string2 = LogoutWorker.this.getInputData().getString("logoutToken");
            if (string2 == null) {
                string2 = "";
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new a(accountRepositoryImpl, string2, null), 3, null);
            return ListenableWorker.Result.success();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogoutWorker(Context context, WorkerParameters params) {
        super(context, params);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ru.yoomoney.sdk.auth.logout.LogoutWorker.a
            if (r0 == 0) goto L13
            r0 = r5
            ru.yoomoney.sdk.auth.logout.LogoutWorker$a r0 = (ru.yoomoney.sdk.auth.logout.LogoutWorker.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.auth.logout.LogoutWorker$a r0 = new ru.yoomoney.sdk.auth.logout.LogoutWorker$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            ru.yoomoney.sdk.auth.logout.LogoutWorker$b r5 = new ru.yoomoney.sdk.auth.logout.LogoutWorker$b
            r2 = 0
            r5.<init>(r2)
            r0.c = r3
            java.lang.Object r5 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r5, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            java.lang.String r0 = "coroutineScope(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.logout.LogoutWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
