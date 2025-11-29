package androidx.paging;

import androidx.paging.CachedPageEventFlow$job$1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CachedPageEventFlow.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.CachedPageEventFlow$job$1$1", f = "CachedPageEventFlow.kt", l = {77, 78}, m = "emit")
/* loaded from: classes.dex */
final class CachedPageEventFlow$job$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CachedPageEventFlow$job$1.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CachedPageEventFlow$job$1$1$emit$1(CachedPageEventFlow$job$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super CachedPageEventFlow$job$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((IndexedValue) null, (Continuation<? super Unit>) this);
    }
}
