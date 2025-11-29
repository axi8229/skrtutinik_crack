package ru.yoomoney.sdk.yooprofiler;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes5.dex */
public final class d extends Lambda implements Function1 {
    public final /* synthetic */ Job a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ YooProfilerImpl c;
    public final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Job job, Function1 function1, YooProfilerImpl yooProfilerImpl, String str) {
        super(1);
        this.a = job;
        this.b = function1;
        this.c = yooProfilerImpl;
        this.d = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String it = (String) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        if (this.a.isActive()) {
            Job.DefaultImpls.cancel$default(this.a, null, 1, null);
            this.b.invoke(new YooProfiler.Result.Success(this.c.prepareSessionId(this.d)));
        }
        return Unit.INSTANCE;
    }
}
