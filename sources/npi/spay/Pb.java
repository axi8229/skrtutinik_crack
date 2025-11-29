package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Pb extends SuspendLambda implements Function2 {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ Dc c;
    public final /* synthetic */ C1493be d;
    public final /* synthetic */ CoroutineDispatcher e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pb(Dc dc, C1493be c1493be, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(2, continuation);
        this.c = dc;
        this.d = c1493be;
        this.e = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Pb pb = new Pb(this.c, this.d, this.e, continuation);
        pb.b = obj;
        return pb;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((Pb) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ec  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.Pb.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
