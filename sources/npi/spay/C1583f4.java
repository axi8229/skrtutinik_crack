package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* renamed from: npi.spay.f4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1583f4 extends SuspendLambda implements Function3 {
    public /* synthetic */ String a;
    public /* synthetic */ C1604g0 b;

    public C1583f4(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        C1583f4 c1583f4 = new C1583f4((Continuation) obj3);
        c1583f4.a = (String) obj;
        c1583f4.b = (C1604g0) obj2;
        return c1583f4.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.String r5 = r4.a
            npi.spay.g0 r0 = r4.b
            timber.log.Timber$Forest r1 = timber.log.Timber.INSTANCE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "LocalSessionId: "
            r2.<init>(r3)
            npi.spay.q2 r3 = r0.a
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r1.d(r2, r3)
            npi.spay.q2 r0 = r0.a
            boolean r1 = r0 instanceof npi.spay.C1531d2
            if (r1 == 0) goto L36
            r1 = r0
            npi.spay.d2 r1 = (npi.spay.C1531d2) r1
            npi.spay.d6 r1 = r1.a
            boolean r2 = r1 instanceof npi.spay.Y5
            if (r2 != 0) goto L44
            boolean r1 = r1 instanceof npi.spay.C1485b6
            if (r1 == 0) goto L36
            goto L44
        L36:
            boolean r1 = r0 instanceof npi.spay.N1
            if (r1 == 0) goto L3b
            goto L44
        L3b:
            boolean r1 = r0 instanceof npi.spay.C1
            if (r1 == 0) goto L40
            goto L44
        L40:
            boolean r0 = r0 instanceof npi.spay.E1
            if (r0 == 0) goto L49
        L44:
            java.lang.String r5 = npi.spay.AbstractC1946tj.c(r5)
            goto L4a
        L49:
            r5 = 0
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1583f4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
