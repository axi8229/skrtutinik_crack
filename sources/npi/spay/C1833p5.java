package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import spay.sdk.data.dto.MerchantDataWithOrderId;
import spay.sdk.domain.model.request.ListOfCardsWithOrderIdRequestBody;

/* renamed from: npi.spay.p5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1833p5 extends ContinuationImpl {
    public MerchantDataWithOrderId a;
    public ListOfCardsWithOrderIdRequestBody b;
    public C2085z8 c;
    public String d;
    public String e;
    public String f;
    public String g;
    public /* synthetic */ Object h;
    public final /* synthetic */ A2 i;
    public int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1833p5(A2 a2, Continuation continuation) {
        super(continuation);
        this.i = a2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.h = obj;
        this.j |= Integer.MIN_VALUE;
        return A2.a(this.i, null, null, this);
    }
}
