package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import spay.sdk.domain.model.response.ContentResponse;

/* loaded from: classes4.dex */
public final class P8 extends SuspendLambda implements Function2 {
    public ContentResponse a;
    public int b;
    public final /* synthetic */ C1987va c;
    public final /* synthetic */ Rb d;
    public final /* synthetic */ CoroutineDispatcher e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public P8(C1987va c1987va, Rb rb, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(2, continuation);
        this.c = c1987va;
        this.d = rb;
        this.e = coroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new P8(this.c, this.d, this.e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((P8) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.P8.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
