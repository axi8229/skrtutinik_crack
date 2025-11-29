package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Ai extends SuspendLambda implements Function2 {
    public int a;
    public int b;
    public int c;
    public /* synthetic */ Object d;

    public Ai(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Ai ai = new Ai(continuation);
        ai.d = obj;
        return ai;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Ai ai = new Ai((Continuation) obj2);
        ai.d = (FlowCollector) obj;
        return ai.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x003b -> B:13:0x003e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L1f
            if (r1 != r2) goto L17
            int r1 = r6.b
            int r3 = r6.a
            java.lang.Object r4 = r6.d
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L3e
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1f:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.d
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            r1 = 2
            r3 = 0
            r4 = r7
            r5 = r3
            r3 = r1
            r1 = r5
        L2c:
            if (r1 >= r3) goto L40
            r6.d = r4
            r6.a = r3
            r6.b = r1
            r6.c = r2
            r7 = 0
            java.lang.Object r7 = r4.emit(r7, r6)
            if (r7 != r0) goto L3e
            return r0
        L3e:
            int r1 = r1 + r2
            goto L2c
        L40:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.Ai.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
