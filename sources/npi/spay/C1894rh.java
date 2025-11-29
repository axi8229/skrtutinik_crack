package npi.spay;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;

/* renamed from: npi.spay.rh, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1894rh extends SuspendLambda implements Function2 {
    public final /* synthetic */ C2094zh a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1894rh(C2094zh c2094zh, Continuation continuation) {
        super(2, continuation);
        this.a = c2094zh;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1894rh(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new C1894rh(this.a, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        MutableStateFlow mutableStateFlow = this.a.k;
        mutableStateFlow.setValue(CollectionsKt.minus((Iterable<? extends Object>) mutableStateFlow.getValue(), CollectionsKt.first((List) this.a.k.getValue())));
        return Unit.INSTANCE;
    }
}
