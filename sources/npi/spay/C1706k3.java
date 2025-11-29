package npi.spay;

import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* renamed from: npi.spay.k3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1706k3 extends SuspendLambda implements Function3 {
    public /* synthetic */ Map a;
    public /* synthetic */ String b;

    public C1706k3(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        C1706k3 c1706k3 = new C1706k3((Continuation) obj3);
        c1706k3.a = (Map) obj;
        c1706k3.b = (String) obj2;
        return c1706k3.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Map map = this.a;
        String str = this.b;
        if (str == null || map == null) {
            return null;
        }
        return (String) map.get(str);
    }
}
