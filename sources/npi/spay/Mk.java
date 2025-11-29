package npi.spay;

import java.util.Iterator;
import java.util.Map;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes4.dex */
public final class Mk extends ContinuationImpl {
    public C1824ol a;
    public Map b;
    public Iterator c;
    public String d;
    public /* synthetic */ Object e;
    public final /* synthetic */ C1824ol f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Mk(C1824ol c1824ol, Continuation continuation) {
        super(continuation);
        this.f = c1824ol;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.a(null, this);
    }
}
