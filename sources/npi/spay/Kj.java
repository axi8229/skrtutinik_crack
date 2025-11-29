package npi.spay;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class Kj extends SuspendLambda implements Function2 {
    public final /* synthetic */ Lj a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Kj(Lj lj, Continuation continuation) {
        super(2, continuation);
        this.a = lj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Kj(this.a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new Kj(this.a, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws JSONException, NoSuchPaddingException, zone.bi.mobile.fingerprint.api.serialize.b, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        AbstractC1727l c1702k;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        C1955u3 c1955u3 = this.a.c;
        EnumC1577en enumC1577en = EnumC1577en.SC_BIZONE;
        EnumC1877r0 enumC1877r0 = EnumC1877r0.MERCHANT_VIEW;
        C0 c0 = C0.SC;
        c1955u3.a(new C1560e6(enumC1577en, enumC1877r0, c0, null, null, null, null, 120));
        Vm vmA = ((C2022wk) this.a.a).a();
        if (vmA.a) {
            this.a.c.a(new C1560e6(EnumC1577en.SC_GOOD_BIZONE, enumC1877r0, c0, null, null, null, null, 120));
            c1702k = C1677j.a;
        } else {
            this.a.c.a(new C1560e6(EnumC1577en.SC_FAIL_BIZONE, enumC1877r0, c0, vmA.b, null, null, null, 112));
            c1702k = new C1702k(vmA.b);
        }
        ((Jh) this.a.b).a(new Kn(c1702k));
        return Unit.INSTANCE;
    }
}
