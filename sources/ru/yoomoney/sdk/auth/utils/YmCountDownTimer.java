package ru.yoomoney.sdk.auth.utils;

import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0010\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001d¨\u0006\u001f"}, d2 = {"Lru/yoomoney/sdk/auth/utils/YmCountDownTimer;", "", "Lkotlin/Function1;", "", "", "onTick", "Lkotlin/Function0;", "onFinish", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, "Lkotlinx/coroutines/CoroutineScope;", "scope", "stepValue", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "startTimer", "(JLkotlinx/coroutines/CoroutineScope;JLkotlinx/coroutines/CoroutineDispatcher;)Lru/yoomoney/sdk/auth/utils/YmCountDownTimer;", "stopTimer", "()Lru/yoomoney/sdk/auth/utils/YmCountDownTimer;", "pauseTimer", "resumeTimer", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)Lru/yoomoney/sdk/auth/utils/YmCountDownTimer;", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function0;", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/Job;", "safeDuration", "J", "safeStepValue", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class YmCountDownTimer {
    private Job job;
    private final Function0<Unit> onFinish;
    private final Function1<Long, Unit> onTick;
    private long safeDuration;
    private long safeStepValue;

    @DebugMetadata(c = "ru.yoomoney.sdk.auth.utils.YmCountDownTimer$startTimer$1", f = "YmCountDownTimer.kt", l = {37}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public int b;
        public YmCountDownTimer c;
        public long d;
        public long e;
        public int f;
        public final /* synthetic */ int g;
        public final /* synthetic */ YmCountDownTimer h;
        public final /* synthetic */ long i;
        public final /* synthetic */ long j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, YmCountDownTimer ymCountDownTimer, long j, long j2, Continuation<? super a> continuation) {
            super(2, continuation);
            this.g = i;
            this.h = ymCountDownTimer;
            this.i = j;
            this.j = j2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0061  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x005c -> B:13:0x005f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.f
                r2 = 1
                if (r1 == 0) goto L21
                if (r1 != r2) goto L19
                int r1 = r13.b
                long r3 = r13.e
                long r5 = r13.d
                int r7 = r13.a
                ru.yoomoney.sdk.auth.utils.YmCountDownTimer r8 = r13.c
                kotlin.ResultKt.throwOnFailure(r14)
                goto L5f
            L19:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L21:
                kotlin.ResultKt.throwOnFailure(r14)
                int r14 = r13.g
                int r14 = r14 + r2
                ru.yoomoney.sdk.auth.utils.YmCountDownTimer r1 = r13.h
                long r3 = r13.i
                long r5 = r13.j
                r7 = 0
                r8 = r1
                r1 = r7
                r7 = r14
                r11 = r3
                r3 = r5
                r5 = r11
            L34:
                if (r1 >= r7) goto L61
                long r9 = (long) r1
                long r9 = r9 * r3
                long r9 = r5 - r9
                ru.yoomoney.sdk.auth.utils.YmCountDownTimer.access$setSafeDuration$p(r8, r9)
                kotlin.jvm.functions.Function1 r14 = ru.yoomoney.sdk.auth.utils.YmCountDownTimer.access$getOnTick$p(r8)
                long r9 = ru.yoomoney.sdk.auth.utils.YmCountDownTimer.access$getSafeDuration$p(r8)
                java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r9)
                r14.invoke(r9)
                r13.c = r8
                r13.a = r7
                r13.d = r5
                r13.e = r3
                r13.b = r1
                r13.f = r2
                java.lang.Object r14 = kotlinx.coroutines.DelayKt.delay(r3, r13)
                if (r14 != r0) goto L5f
                return r0
            L5f:
                int r1 = r1 + r2
                goto L34
            L61:
                ru.yoomoney.sdk.auth.utils.YmCountDownTimer r14 = r13.h
                kotlin.jvm.functions.Function0 r14 = ru.yoomoney.sdk.auth.utils.YmCountDownTimer.access$getOnFinish$p(r14)
                r14.invoke()
                ru.yoomoney.sdk.auth.utils.YmCountDownTimer r14 = r13.h
                r0 = 0
                ru.yoomoney.sdk.auth.utils.YmCountDownTimer.access$setJob$p(r14, r0)
                kotlin.Unit r14 = kotlin.Unit.INSTANCE
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.auth.utils.YmCountDownTimer.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public YmCountDownTimer(Function1<? super Long, Unit> onTick, Function0<Unit> onFinish) {
        Intrinsics.checkNotNullParameter(onTick, "onTick");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        this.onTick = onTick;
        this.onFinish = onFinish;
    }

    public static /* synthetic */ YmCountDownTimer resumeTimer$default(YmCountDownTimer ymCountDownTimer, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineDispatcher = Dispatchers.getMain();
        }
        return ymCountDownTimer.resumeTimer(coroutineScope, coroutineDispatcher);
    }

    public static /* synthetic */ YmCountDownTimer startTimer$default(YmCountDownTimer ymCountDownTimer, long j, CoroutineScope coroutineScope, long j2, CoroutineDispatcher coroutineDispatcher, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1000;
        }
        long j3 = j2;
        if ((i & 8) != 0) {
            coroutineDispatcher = Dispatchers.getMain();
        }
        return ymCountDownTimer.startTimer(j, coroutineScope, j3, coroutineDispatcher);
    }

    public final YmCountDownTimer pauseTimer() {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.job = null;
        return this;
    }

    public final YmCountDownTimer resumeTimer(CoroutineScope scope, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.job = null;
        startTimer(this.safeDuration, scope, this.safeStepValue, dispatcher);
        return this;
    }

    public final YmCountDownTimer startTimer(long duration, CoroutineScope scope, long stepValue, CoroutineDispatcher dispatcher) {
        Job job;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.safeStepValue = stepValue;
        int i = (int) (duration / stepValue);
        Job job2 = this.job;
        if (job2 != null && job2.isActive() && (job = this.job) != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.job = BuildersKt__Builders_commonKt.launch$default(scope, dispatcher, null, new a(i, this, duration, stepValue, null), 2, null);
        return this;
    }

    public final YmCountDownTimer stopTimer() {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.job = null;
        this.safeDuration = 0L;
        this.safeStepValue = 0L;
        return this;
    }
}
