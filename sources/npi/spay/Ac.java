package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes4.dex */
public final class Ac extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ Cc b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ac(Cc cc, Continuation continuation) {
        super(2, continuation);
        this.b = cc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Ac(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new Ac(this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r3.a
            r2 = 1
            if (r1 == 0) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.throwOnFailure(r4)
            goto L7b
        L10:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L18:
            kotlin.ResultKt.throwOnFailure(r4)
            npi.spay.Cc r4 = r3.b
            r3.a = r2
            npi.spay.W1 r1 = r4.e
            npi.spay.M8 r1 = r1.a
            boolean r2 = r1 instanceof npi.spay.H8
            if (r2 == 0) goto L36
            kotlinx.coroutines.flow.MutableStateFlow r4 = r4.f
            npi.spay.Bc r1 = npi.spay.Bc.DENY_BLOCK_MODE
            java.lang.Object r4 = r4.emit(r1, r3)
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r1) goto L6f
            goto L78
        L36:
            boolean r2 = r1 instanceof npi.spay.I8
            if (r2 == 0) goto L49
            kotlinx.coroutines.flow.MutableStateFlow r4 = r4.f
            npi.spay.Bc r1 = npi.spay.Bc.DENY_MODE
            java.lang.Object r4 = r4.emit(r1, r3)
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r1) goto L6f
            goto L78
        L49:
            boolean r2 = r1 instanceof npi.spay.K8
            if (r2 == 0) goto L5c
            kotlinx.coroutines.flow.MutableStateFlow r4 = r4.f
            npi.spay.Bc r1 = npi.spay.Bc.OTP_REVIEW_MODE
            java.lang.Object r4 = r4.emit(r1, r3)
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r1) goto L6f
            goto L78
        L5c:
            boolean r2 = r1 instanceof npi.spay.L8
            if (r2 == 0) goto L72
            kotlinx.coroutines.flow.MutableStateFlow r4 = r4.f
            npi.spay.Bc r1 = npi.spay.Bc.REVIEW_HINT_MODE
            java.lang.Object r4 = r4.emit(r1, r3)
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r1) goto L6f
            goto L78
        L6f:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L78
        L72:
            npi.spay.J8 r4 = npi.spay.J8.b
            kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
            goto L6f
        L78:
            if (r4 != r0) goto L7b
            return r0
        L7b:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.Ac.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
