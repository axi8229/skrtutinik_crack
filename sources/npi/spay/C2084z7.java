package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;

/* renamed from: npi.spay.z7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2084z7 extends ContinuationImpl {
    public C7 a;
    public N8 b;
    public CoroutineDispatcher c;
    public C7 d;
    public /* synthetic */ Object e;
    public final /* synthetic */ C7 f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2084z7(C7 c7, Continuation continuation) {
        super(continuation);
        this.f = c7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.a((N8) null, (CoroutineDispatcher) null, (Continuation) this);
    }
}
