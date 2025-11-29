package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import spay.sdk.data.dto.MerchantDataWithOrderId;
import spay.sdk.domain.model.response.listOfCards.ListOfCardsResponseBody;

/* loaded from: classes4.dex */
public final class O9 extends ContinuationImpl {
    public Object a;
    public ListOfCardsResponseBody.PaymentToolInfo.Tool b;
    public MerchantDataWithOrderId c;
    public MerchantDataWithOrderId d;
    public String e;
    public String f;
    public boolean g;
    public /* synthetic */ Object h;
    public final /* synthetic */ spay.sdk.a i;
    public int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O9(spay.sdk.a aVar, Continuation continuation) {
        super(continuation);
        this.i = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.h = obj;
        this.j |= Integer.MIN_VALUE;
        return spay.sdk.a.a(this.i, null, false, this);
    }
}
