package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import spay.sdk.domain.model.request.ListOfCardsWithOrderIdRequestBody;

/* renamed from: npi.spay.kk, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1723kk extends ContinuationImpl {
    public C1972uk a;
    public ListOfCardsWithOrderIdRequestBody b;
    public /* synthetic */ Object c;
    public final /* synthetic */ C1972uk d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1723kk(C1972uk c1972uk, Continuation continuation) {
        super(continuation);
        this.d = c1972uk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a((String) null, (ListOfCardsWithOrderIdRequestBody) null, this);
    }
}
