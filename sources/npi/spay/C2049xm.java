package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import spay.sdk.domain.model.request.ListOfCardsWithOrderIdRequestBody;

/* renamed from: npi.spay.xm, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2049xm extends ContinuationImpl {
    public Hm a;
    public ListOfCardsWithOrderIdRequestBody b;
    public /* synthetic */ Object c;
    public final /* synthetic */ Hm d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2049xm(Hm hm, Continuation continuation) {
        super(continuation);
        this.d = hm;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a((String) null, (ListOfCardsWithOrderIdRequestBody) null, this);
    }
}
