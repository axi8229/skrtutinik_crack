package ru.yoomoney.sdk.yooprofiler;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes5.dex */
public final class c extends SuspendLambda implements Function2 {
    public String a;
    public int b;
    public final /* synthetic */ YooProfilerImpl c;
    public final /* synthetic */ ProfileEventType d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(YooProfilerImpl yooProfilerImpl, ProfileEventType profileEventType, String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.c = yooProfilerImpl;
        this.d = profileEventType;
        this.e = str;
        this.f = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new c(this.c, this.d, this.e, this.f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fail;
        String strGenerateSessionId;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                strGenerateSessionId = this.c.generateSessionId();
                try {
                    b bVar = new b(this.c, strGenerateSessionId, this.d, this.e, this.f, null);
                    this.a = strGenerateSessionId;
                    this.b = 1;
                    Object objWithTimeout = TimeoutKt.withTimeout(YooProfilerImpl.TIMER_LIMIT, bVar, this);
                    if (objWithTimeout == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = strGenerateSessionId;
                    obj = objWithTimeout;
                } catch (TimeoutCancellationException unused) {
                    this.c.stopGibSdk();
                    fail = new YooProfiler.Result.Success(this.c.prepareSessionId(strGenerateSessionId));
                    return fail;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = this.a;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (TimeoutCancellationException unused2) {
                    strGenerateSessionId = str;
                    this.c.stopGibSdk();
                    fail = new YooProfiler.Result.Success(this.c.prepareSessionId(strGenerateSessionId));
                    return fail;
                }
            }
            return (YooProfiler.Result) obj;
        } catch (Exception e) {
            this.c.stopGibSdk();
            e.printStackTrace();
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "CONNECTION_ERROR";
            }
            fail = new YooProfiler.Result.Fail(localizedMessage);
        }
    }
}
