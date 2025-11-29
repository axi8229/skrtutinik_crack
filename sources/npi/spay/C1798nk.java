package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import spay.sdk.domain.model.request.PayOnlineRequestBody;

/* renamed from: npi.spay.nk, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1798nk extends ContinuationImpl {
    public C1972uk a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C1972uk c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1798nk(C1972uk c1972uk, Continuation continuation) {
        super(continuation);
        this.c = c1972uk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a((String) null, (PayOnlineRequestBody) null, this);
    }
}
