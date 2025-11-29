package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import spay.sdk.data.dto.MerchantDataWithOrderId;

/* renamed from: npi.spay.vd, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1990vd extends ContinuationImpl {
    public MerchantDataWithOrderId a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public B0 g;
    public /* synthetic */ Object h;
    public final /* synthetic */ spay.sdk.a i;
    public int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1990vd(spay.sdk.a aVar, Continuation continuation) {
        super(continuation);
        this.i = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.h = obj;
        this.j |= Integer.MIN_VALUE;
        return spay.sdk.a.a(this.i, null, this);
    }
}
