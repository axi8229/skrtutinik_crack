package npi.spay;

import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import spay.sdk.domain.model.BnplPaymentData;
import spay.sdk.domain.model.PaymentModel;
import spay.sdk.domain.model.request.PaymentOrderRequestBody;

/* loaded from: classes4.dex */
public final class Zf extends SuspendLambda implements Function2 {
    public Object a;
    public int b;
    public final /* synthetic */ spay.sdk.a c;
    public final /* synthetic */ PaymentModel d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Zf(spay.sdk.a aVar, PaymentModel paymentModel, Continuation continuation) {
        super(2, continuation);
        this.c = aVar;
        this.d = paymentModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Zf(this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new Zf(this.c, this.d, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Object objWithContext;
        String authorization;
        String merchantLogin;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C1937ta c1937ta = this.c.i;
            str = "ip";
            this.a = "ip";
            this.b = 1;
            CoroutineDispatcher io2 = Dispatchers.getIO();
            c1937ta.getClass();
            objWithContext = BuildersKt.withContext(io2, new C1912sa(c1937ta, null), this);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            String str2 = (String) this.a;
            ResultKt.throwOnFailure(obj);
            str = str2;
            objWithContext = obj;
        }
        Map mapMapOf = MapsKt.mapOf(new Pair(str, objWithContext));
        PaymentModel paymentModel = this.d;
        spay.sdk.a aVar = this.c;
        r rVar = aVar.e;
        C1993vg c1993vg = aVar.k;
        EnumC1628h tag = EnumC1628h.BNPL;
        c1993vg.getClass();
        Intrinsics.checkNotNullParameter(tag, "tag");
        InterfaceC2089zc interfaceC2089zc = (InterfaceC2089zc) c1993vg.c.get(tag);
        if (interfaceC2089zc == null || !((Boolean) interfaceC2089zc.a(EnumC1908s6.BY_USER)).booleanValue()) {
            authorization = paymentModel.getAuthorization();
        } else {
            ((Di) aVar.b).getClass();
            authorization = BnplPaymentData.INSTANCE.getBnplPaymentData().getApiKey();
        }
        String str3 = authorization;
        C1993vg c1993vg2 = aVar.k;
        c1993vg2.getClass();
        Intrinsics.checkNotNullParameter(tag, "tag");
        InterfaceC2089zc interfaceC2089zc2 = (InterfaceC2089zc) c1993vg2.c.get(tag);
        if (interfaceC2089zc2 == null || !((Boolean) interfaceC2089zc2.a(EnumC1908s6.BY_USER)).booleanValue()) {
            merchantLogin = paymentModel.getMerchantLogin();
        } else {
            ((Di) aVar.b).getClass();
            merchantLogin = BnplPaymentData.INSTANCE.getBnplPaymentData().getMerchantLogin();
        }
        String str4 = merchantLogin;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        String strReplace$default = StringsKt.replace$default(string, "-", "", false, 4, (Object) null);
        String orderId = ((Di) aVar.b).m;
        if (orderId == null) {
            orderId = paymentModel.getOrderId();
        }
        D0 d0 = new D0(str3, new PaymentOrderRequestBody(strReplace$default, str4, orderId, paymentModel.getPaymentToken(), null, mapMapOf, null, null, null, 464, null));
        this.a = paymentModel;
        this.b = 2;
        if (rVar.a(d0, Dispatchers.getIO(), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
