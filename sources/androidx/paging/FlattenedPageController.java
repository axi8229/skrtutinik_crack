package androidx.paging;

import androidx.paging.PageEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: CachedPageEventFlow.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bJ \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e0\rH\u0086@¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000eH\u0086@¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/paging/FlattenedPageController;", "T", "", "()V", "list", "Landroidx/paging/FlattenedPageEventStorage;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "maxEventIndex", "", "getCachedEvent", "Landroidx/paging/PageEvent$Insert;", "getStateAsEvents", "", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "record", "", "event", "(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class FlattenedPageController<T> {
    private final FlattenedPageEventStorage<T> list = new FlattenedPageEventStorage<>();
    private final Mutex lock = MutexKt.Mutex$default(false, 1, null);
    private int maxEventIndex = -1;

    /* compiled from: CachedPageEventFlow.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.FlattenedPageController", f = "CachedPageEventFlow.kt", l = {287}, m = "getStateAsEvents")
    /* renamed from: androidx.paging.FlattenedPageController$getStateAsEvents$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlattenedPageController<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FlattenedPageController<T> flattenedPageController, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = flattenedPageController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getStateAsEvents(this);
        }
    }

    /* compiled from: CachedPageEventFlow.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.FlattenedPageController", f = "CachedPageEventFlow.kt", l = {287}, m = "record")
    /* renamed from: androidx.paging.FlattenedPageController$record$1, reason: invalid class name and case insensitive filesystem */
    static final class C04801 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FlattenedPageController<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04801(FlattenedPageController<T> flattenedPageController, Continuation<? super C04801> continuation) {
            super(continuation);
            this.this$0 = flattenedPageController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.record(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object record(kotlin.collections.IndexedValue<? extends androidx.paging.PageEvent<T>> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.paging.FlattenedPageController.C04801
            if (r0 == 0) goto L13
            r0 = r7
            androidx.paging.FlattenedPageController$record$1 r0 = (androidx.paging.FlattenedPageController.C04801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.paging.FlattenedPageController$record$1 r0 = new androidx.paging.FlattenedPageController$record$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r1 = r0.L$1
            kotlin.collections.IndexedValue r1 = (kotlin.collections.IndexedValue) r1
            java.lang.Object r0 = r0.L$0
            androidx.paging.FlattenedPageController r0 = (androidx.paging.FlattenedPageController) r0
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            r6 = r1
            goto L55
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.sync.Mutex r7 = r5.lock
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r0 = r7.lock(r4, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            int r1 = r6.getIndex()     // Catch: java.lang.Throwable -> L6e
            r0.maxEventIndex = r1     // Catch: java.lang.Throwable -> L6e
            androidx.paging.FlattenedPageEventStorage<T> r0 = r0.list     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r6 = r6.getValue()     // Catch: java.lang.Throwable -> L6e
            androidx.paging.PageEvent r6 = (androidx.paging.PageEvent) r6     // Catch: java.lang.Throwable -> L6e
            r0.add(r6)     // Catch: java.lang.Throwable -> L6e
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L6e
            r7.unlock(r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L6e:
            r6 = move-exception
            r7.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlattenedPageController.record(kotlin.collections.IndexedValue, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getStateAsEvents(kotlin.coroutines.Continuation<? super java.util.List<? extends kotlin.collections.IndexedValue<? extends androidx.paging.PageEvent<T>>>> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.paging.FlattenedPageController.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.paging.FlattenedPageController$getStateAsEvents$1 r0 = (androidx.paging.FlattenedPageController.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.paging.FlattenedPageController$getStateAsEvents$1 r0 = new androidx.paging.FlattenedPageController$getStateAsEvents$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.L$0
            androidx.paging.FlattenedPageController r0 = (androidx.paging.FlattenedPageController) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L4e
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3a:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.sync.Mutex r9 = r8.lock
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r0 = r9.lock(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            r0 = r8
            r1 = r9
        L4e:
            androidx.paging.FlattenedPageEventStorage<T> r9 = r0.list     // Catch: java.lang.Throwable -> L80
            java.util.List r9 = r9.getAsEvents()     // Catch: java.lang.Throwable -> L80
            int r0 = r0.maxEventIndex     // Catch: java.lang.Throwable -> L80
            int r2 = r9.size()     // Catch: java.lang.Throwable -> L80
            int r0 = r0 - r2
            int r0 = r0 + r3
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch: java.lang.Throwable -> L80
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L80
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r3)     // Catch: java.lang.Throwable -> L80
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L80
            java.util.Iterator r9 = r9.iterator()     // Catch: java.lang.Throwable -> L80
            r3 = 0
        L6e:
            boolean r5 = r9.hasNext()     // Catch: java.lang.Throwable -> L80
            if (r5 == 0) goto L8f
            java.lang.Object r5 = r9.next()     // Catch: java.lang.Throwable -> L80
            int r6 = r3 + 1
            if (r3 >= 0) goto L82
            kotlin.collections.CollectionsKt.throwIndexOverflow()     // Catch: java.lang.Throwable -> L80
            goto L82
        L80:
            r9 = move-exception
            goto L93
        L82:
            androidx.paging.PageEvent r5 = (androidx.paging.PageEvent) r5     // Catch: java.lang.Throwable -> L80
            kotlin.collections.IndexedValue r7 = new kotlin.collections.IndexedValue     // Catch: java.lang.Throwable -> L80
            int r3 = r3 + r0
            r7.<init>(r3, r5)     // Catch: java.lang.Throwable -> L80
            r2.add(r7)     // Catch: java.lang.Throwable -> L80
            r3 = r6
            goto L6e
        L8f:
            r1.unlock(r4)
            return r2
        L93:
            r1.unlock(r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlattenedPageController.getStateAsEvents(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final PageEvent.Insert<T> getCachedEvent() {
        PageEvent pageEvent = (PageEvent) CollectionsKt.firstOrNull((List) this.list.getAsEvents());
        if (pageEvent == null || !(pageEvent instanceof PageEvent.Insert)) {
            return null;
        }
        PageEvent.Insert<T> insert = (PageEvent.Insert) pageEvent;
        if (insert.getLoadType() == LoadType.REFRESH) {
            return insert;
        }
        return null;
    }
}
