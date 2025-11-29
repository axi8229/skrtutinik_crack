package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$string;

/* renamed from: npi.spay.t4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1931t4 extends SuspendLambda implements Function3 {
    public /* synthetic */ String a;
    public /* synthetic */ Bk b;

    public C1931t4(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        C1931t4 c1931t4 = new C1931t4((Continuation) obj3);
        c1931t4.a = (String) obj;
        c1931t4.b = (Bk) obj2;
        return c1931t4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        String str = this.a;
        Bk bk = this.b;
        return Boxing.boxBoolean(str != null && str.length() == 5 && (bk == null || Intrinsics.areEqual(bk, new C2097zk(R$string.spay_empty_string, CollectionsKt.emptyList()))));
    }
}
