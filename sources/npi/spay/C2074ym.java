package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import spay.sdk.domain.model.request.ListOfCardsWithPurchaseRequestBody;

/* renamed from: npi.spay.ym, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2074ym extends ContinuationImpl {
    public Hm a;
    public ListOfCardsWithPurchaseRequestBody b;
    public /* synthetic */ Object c;
    public final /* synthetic */ Hm d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2074ym(Hm hm, Continuation continuation) {
        super(continuation);
        this.d = hm;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a((String) null, (ListOfCardsWithPurchaseRequestBody) null, this);
    }
}
