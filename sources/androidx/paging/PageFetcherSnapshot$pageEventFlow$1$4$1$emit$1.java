package androidx.paging;

import androidx.paging.PageFetcherSnapshot$pageEventFlow$1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: PageFetcherSnapshot.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$1", f = "PageFetcherSnapshot.kt", l = {646, 658, 125, 669, 128, 680, 692, 125, 703, 128, 714, 726, 125, 737, 128, 748}, m = "emit")
/* loaded from: classes.dex */
final class PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PageFetcherSnapshot$pageEventFlow$1.AnonymousClass4.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1(PageFetcherSnapshot$pageEventFlow$1.AnonymousClass4.AnonymousClass1<? super T> anonymousClass1, Continuation<? super PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Unit) null, (Continuation<? super Unit>) this);
    }
}
