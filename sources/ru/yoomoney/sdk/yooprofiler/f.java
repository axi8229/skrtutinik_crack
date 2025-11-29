package ru.yoomoney.sdk.yooprofiler;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes5.dex */
public final class f extends Lambda implements Function1 {
    public final /* synthetic */ CancellableContinuation a;
    public final /* synthetic */ YooProfilerImpl b;
    public final /* synthetic */ String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(CancellableContinuationImpl cancellableContinuationImpl, YooProfilerImpl yooProfilerImpl, String str) {
        super(1);
        this.a = cancellableContinuationImpl;
        this.b = yooProfilerImpl;
        this.c = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String it = (String) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        CancellableContinuation cancellableContinuation = this.a;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m2628constructorimpl(new YooProfiler.Result.Success(this.b.prepareSessionId(this.c))));
        return Unit.INSTANCE;
    }
}
