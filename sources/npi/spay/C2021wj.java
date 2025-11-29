package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* renamed from: npi.spay.wj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2021wj extends SuspendLambda implements Function3 {
    public /* synthetic */ B4 a;
    public /* synthetic */ B4 b;

    public C2021wj(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        C2021wj c2021wj = new C2021wj((Continuation) obj3);
        c2021wj.a = (B4) obj;
        c2021wj.b = (B4) obj2;
        return c2021wj.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        B4 b4 = this.a;
        return b4 == null ? this.b : b4;
    }
}
