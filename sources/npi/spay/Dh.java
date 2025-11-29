package npi.spay;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import spay.sdk.domain.model.response.SPaySdkConfig;

/* loaded from: classes4.dex */
public final class Dh extends SuspendLambda implements Function2 {
    public final /* synthetic */ InterfaceC1728l0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Dh(InterfaceC1728l0 interfaceC1728l0, Continuation continuation) {
        super(2, continuation);
        this.a = interfaceC1728l0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Dh(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new Dh(this.a, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        SPaySdkConfig sPaySdkConfig = ((O0) this.a).c;
        if (sPaySdkConfig != null) {
            return sPaySdkConfig.getLocalization().getPayLoading();
        }
        throw C1808o5.a;
    }
}
