package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: AsyncPagingDataDiffer.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/paging/AsyncPagingDataDiffer$presenter$1", "Landroidx/paging/PagingDataPresenter;", "presentPagingDataEvent", "", "event", "Landroidx/paging/PagingDataEvent;", "(Landroidx/paging/PagingDataEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AsyncPagingDataDiffer$presenter$1<T> extends PagingDataPresenter<T> {
    final /* synthetic */ AsyncPagingDataDiffer<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncPagingDataDiffer$presenter$1(AsyncPagingDataDiffer<T> asyncPagingDataDiffer, CoroutineContext coroutineContext) {
        super(coroutineContext, null, 2, 0 == true ? 1 : 0);
        this.this$0 = asyncPagingDataDiffer;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.paging.PagingDataPresenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object presentPagingDataEvent(androidx.paging.PagingDataEvent<T> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            Method dump skipped, instructions count: 573
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.AsyncPagingDataDiffer$presenter$1.presentPagingDataEvent(androidx.paging.PagingDataEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
