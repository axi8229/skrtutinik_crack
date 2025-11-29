package npi.spay;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import spay.sdk.RedirectActivity;

/* renamed from: npi.spay.u7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1959u7 extends ContinuationImpl {
    public RedirectActivity a;
    public Iterator b;
    public /* synthetic */ Object c;
    public final /* synthetic */ C2009w7 d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1959u7(C2009w7 c2009w7, Continuation continuation) {
        super(continuation);
        this.d = c2009w7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(null, null, this);
    }
}
