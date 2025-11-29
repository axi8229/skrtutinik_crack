package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.pjsip.pjsua2.pjsip_status_code;

/* compiled from: AsyncPagingDataDiffer.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$presenter$1", f = "AsyncPagingDataDiffer.kt", l = {pjsip_status_code.PJSIP_SC_QUEUED}, m = "presentPagingDataEvent")
/* loaded from: classes.dex */
final class AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncPagingDataDiffer$presenter$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$1(AsyncPagingDataDiffer$presenter$1 asyncPagingDataDiffer$presenter$1, Continuation continuation) {
        super(continuation);
        this.this$0 = asyncPagingDataDiffer$presenter$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.presentPagingDataEvent(null, this);
    }
}
