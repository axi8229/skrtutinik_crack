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
public final class h extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ YooProfilerImpl b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ProfileEventType d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(YooProfilerImpl yooProfilerImpl, String str, ProfileEventType profileEventType, String str2, String str3, Continuation continuation) {
        super(2, continuation);
        this.b = yooProfilerImpl;
        this.c = str;
        this.d = profileEventType;
        this.e = str2;
        this.f = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new h(this.b, this.c, this.d, this.e, this.f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((h) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                g gVar = new g(this.b, this.c, this.d, this.e, this.f, null);
                this.a = 1;
                obj = TimeoutKt.withTimeout(YooProfilerImpl.TIMER_LIMIT, gVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return (YooProfiler.Result) obj;
        } catch (TimeoutCancellationException unused) {
            this.b.stopGibSdk();
            return new YooProfiler.Result.Success(this.b.prepareSessionId(this.c));
        } catch (Exception e) {
            this.b.stopGibSdk();
            e.printStackTrace();
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "CONNECTION_ERROR";
            }
            return new YooProfiler.Result.Fail(localizedMessage);
        }
    }
}
