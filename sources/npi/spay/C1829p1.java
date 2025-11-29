package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.p1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1829p1 extends SuspendLambda implements Function2 {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C1731l3 c;
    public final /* synthetic */ C1483b4 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1829p1(C1731l3 c1731l3, C1483b4 c1483b4, Continuation continuation) {
        super(2, continuation);
        this.c = c1731l3;
        this.d = c1483b4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C1829p1 c1829p1 = new C1829p1(this.c, this.d, continuation);
        c1829p1.b = obj;
        return c1829p1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C1829p1) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1829p1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
