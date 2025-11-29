package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineDispatcher;

/* renamed from: npi.spay.ck, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1524ck extends SuspendLambda implements Function3 {
    public /* synthetic */ AbstractC1855q2 a;
    public /* synthetic */ AbstractC1855q2 b;
    public final /* synthetic */ C1697jj c;
    public final /* synthetic */ Uk d;
    public final /* synthetic */ CoroutineDispatcher e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1524ck(C1697jj c1697jj, Uk uk, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        super(3, continuation);
        this.c = c1697jj;
        this.d = uk;
        this.e = coroutineDispatcher;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        C1524ck c1524ck = new C1524ck(this.c, this.d, this.e, (Continuation) obj3);
        c1524ck.a = (AbstractC1855q2) obj;
        c1524ck.b = (AbstractC1855q2) obj2;
        return c1524ck.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ca A[PHI: r11
  0x01ca: PHI (r11v33 spay.sdk.api.SPayHelpers) = 
  (r11v29 spay.sdk.api.SPayHelpers)
  (r11v29 spay.sdk.api.SPayHelpers)
  (r11v29 spay.sdk.api.SPayHelpers)
  (r11v29 spay.sdk.api.SPayHelpers)
  (r11v32 spay.sdk.api.SPayHelpers)
  (r11v31 spay.sdk.api.SPayHelpers)
  (r11v30 spay.sdk.api.SPayHelpers)
  (r11v29 spay.sdk.api.SPayHelpers)
 binds: [B:56:0x0168, B:58:0x0177, B:63:0x0189, B:65:0x018f, B:80:0x01c8, B:75:0x01b5, B:70:0x01a2, B:54:0x0154] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) {
        /*
            Method dump skipped, instructions count: 1580
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1524ck.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
