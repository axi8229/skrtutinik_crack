package androidx.paging;

import androidx.paging.LoadState;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PageEvent.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0004\u000e\u000f\u0010\u0011B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004JD\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u0005*\u00020\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ:\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0096@¢\u0006\u0004\b\r\u0010\n\u0082\u0001\u0004\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Landroidx/paging/PageEvent;", "", "T", "<init>", "()V", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "transform", "map", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "predicate", "filter", "Drop", "Insert", "LoadStateUpdate", "StaticList", "Landroidx/paging/PageEvent$Drop;", "Landroidx/paging/PageEvent$Insert;", "Landroidx/paging/PageEvent$LoadStateUpdate;", "Landroidx/paging/PageEvent$StaticList;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PageEvent<T> {
    public /* synthetic */ PageEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    static /* synthetic */ <T> Object filter$suspendImpl(PageEvent<T> pageEvent, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super PageEvent<T>> continuation) {
        return pageEvent;
    }

    public Object filter(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super PageEvent<T>> continuation) {
        return filter$suspendImpl(this, function2, continuation);
    }

    public <R> Object map(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super PageEvent<R>> continuation) {
        return map$suspendImpl(this, function2, continuation);
    }

    private PageEvent() {
    }

    /* compiled from: PageEvent.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B-\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJD\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\b\b\u0002\u0010\u000b*\u00020\u00012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J:\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0096@¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b#\u0010\"¨\u0006$"}, d2 = {"Landroidx/paging/PageEvent$StaticList;", "", "T", "Landroidx/paging/PageEvent;", "", RemoteMessageConst.DATA, "Landroidx/paging/LoadStates;", "sourceLoadStates", "mediatorLoadStates", "<init>", "(Ljava/util/List;Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "transform", "map", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "predicate", "filter", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getData", "()Ljava/util/List;", "Landroidx/paging/LoadStates;", "getSourceLoadStates", "()Landroidx/paging/LoadStates;", "getMediatorLoadStates", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class StaticList<T> extends PageEvent<T> {
        private final List<T> data;
        private final LoadStates mediatorLoadStates;
        private final LoadStates sourceLoadStates;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StaticList)) {
                return false;
            }
            StaticList staticList = (StaticList) other;
            return Intrinsics.areEqual(this.data, staticList.data) && Intrinsics.areEqual(this.sourceLoadStates, staticList.sourceLoadStates) && Intrinsics.areEqual(this.mediatorLoadStates, staticList.mediatorLoadStates);
        }

        public int hashCode() {
            int iHashCode = this.data.hashCode() * 31;
            LoadStates loadStates = this.sourceLoadStates;
            int iHashCode2 = (iHashCode + (loadStates == null ? 0 : loadStates.hashCode())) * 31;
            LoadStates loadStates2 = this.mediatorLoadStates;
            return iHashCode2 + (loadStates2 != null ? loadStates2.hashCode() : 0);
        }

        public final List<T> getData() {
            return this.data;
        }

        public final LoadStates getSourceLoadStates() {
            return this.sourceLoadStates;
        }

        public final LoadStates getMediatorLoadStates() {
            return this.mediatorLoadStates;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public StaticList(List<? extends T> data, LoadStates loadStates, LoadStates loadStates2) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.sourceLoadStates = loadStates;
            this.mediatorLoadStates = loadStates2;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007d -> B:21:0x0080). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public <R> java.lang.Object map(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>> r10) {
            /*
                r8 = this;
                boolean r0 = r10 instanceof androidx.paging.PageEvent$StaticList$map$1
                if (r0 == 0) goto L13
                r0 = r10
                androidx.paging.PageEvent$StaticList$map$1 r0 = (androidx.paging.PageEvent$StaticList$map$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.paging.PageEvent$StaticList$map$1 r0 = new androidx.paging.PageEvent$StaticList$map$1
                r0.<init>(r8, r10)
            L18:
                java.lang.Object r10 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L45
                if (r2 != r3) goto L3d
                java.lang.Object r9 = r0.L$4
                java.util.Collection r9 = (java.util.Collection) r9
                java.lang.Object r2 = r0.L$3
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r4 = r0.L$2
                java.util.Collection r4 = (java.util.Collection) r4
                java.lang.Object r5 = r0.L$1
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                java.lang.Object r6 = r0.L$0
                androidx.paging.PageEvent$StaticList r6 = (androidx.paging.PageEvent.StaticList) r6
                kotlin.ResultKt.throwOnFailure(r10)
                goto L80
            L3d:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L45:
                kotlin.ResultKt.throwOnFailure(r10)
                java.util.List<T> r10 = r8.data
                java.lang.Iterable r10 = (java.lang.Iterable) r10
                java.util.ArrayList r2 = new java.util.ArrayList
                r4 = 10
                int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r4)
                r2.<init>(r4)
                java.util.Iterator r10 = r10.iterator()
                r6 = r8
                r7 = r10
                r10 = r9
                r9 = r2
                r2 = r7
            L60:
                boolean r4 = r2.hasNext()
                if (r4 == 0) goto L86
                java.lang.Object r4 = r2.next()
                r0.L$0 = r6
                r0.L$1 = r10
                r0.L$2 = r9
                r0.L$3 = r2
                r0.L$4 = r9
                r0.label = r3
                java.lang.Object r4 = r10.invoke(r4, r0)
                if (r4 != r1) goto L7d
                return r1
            L7d:
                r5 = r10
                r10 = r4
                r4 = r9
            L80:
                r9.add(r10)
                r9 = r4
                r10 = r5
                goto L60
            L86:
                java.util.List r9 = (java.util.List) r9
                androidx.paging.LoadStates r10 = r6.sourceLoadStates
                androidx.paging.LoadStates r0 = r6.mediatorLoadStates
                androidx.paging.PageEvent$StaticList r1 = new androidx.paging.PageEvent$StaticList
                r1.<init>(r9, r10, r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.StaticList.map(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0073 -> B:21:0x0077). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object filter(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<T>> r10) {
            /*
                r8 = this;
                boolean r0 = r10 instanceof androidx.paging.PageEvent$StaticList$filter$1
                if (r0 == 0) goto L13
                r0 = r10
                androidx.paging.PageEvent$StaticList$filter$1 r0 = (androidx.paging.PageEvent$StaticList$filter$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.paging.PageEvent$StaticList$filter$1 r0 = new androidx.paging.PageEvent$StaticList$filter$1
                r0.<init>(r8, r10)
            L18:
                java.lang.Object r10 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L43
                if (r2 != r3) goto L3b
                java.lang.Object r9 = r0.L$4
                java.lang.Object r2 = r0.L$3
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r4 = r0.L$2
                java.util.Collection r4 = (java.util.Collection) r4
                java.lang.Object r5 = r0.L$1
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                java.lang.Object r6 = r0.L$0
                androidx.paging.PageEvent$StaticList r6 = (androidx.paging.PageEvent.StaticList) r6
                kotlin.ResultKt.throwOnFailure(r10)
                goto L77
            L3b:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L43:
                kotlin.ResultKt.throwOnFailure(r10)
                java.util.List<T> r10 = r8.data
                java.lang.Iterable r10 = (java.lang.Iterable) r10
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r10 = r10.iterator()
                r6 = r8
                r4 = r2
                r2 = r10
            L56:
                boolean r10 = r2.hasNext()
                if (r10 == 0) goto L84
                java.lang.Object r10 = r2.next()
                r0.L$0 = r6
                r0.L$1 = r9
                r0.L$2 = r4
                r0.L$3 = r2
                r0.L$4 = r10
                r0.label = r3
                java.lang.Object r5 = r9.invoke(r10, r0)
                if (r5 != r1) goto L73
                return r1
            L73:
                r7 = r5
                r5 = r9
                r9 = r10
                r10 = r7
            L77:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto L82
                r4.add(r9)
            L82:
                r9 = r5
                goto L56
            L84:
                java.util.List r4 = (java.util.List) r4
                androidx.paging.LoadStates r9 = r6.sourceLoadStates
                androidx.paging.LoadStates r10 = r6.mediatorLoadStates
                androidx.paging.PageEvent$StaticList r0 = new androidx.paging.PageEvent$StaticList
                r0.<init>(r4, r9, r10)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.StaticList.filter(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public String toString() {
            LoadStates loadStates = this.mediatorLoadStates;
            String str = "PageEvent.StaticList with " + this.data.size() + " items (\n                    |   first item: " + CollectionsKt.firstOrNull((List) this.data) + "\n                    |   last item: " + CollectionsKt.lastOrNull((List) this.data) + "\n                    |   sourceLoadStates: " + this.sourceLoadStates + "\n                    ";
            if (loadStates != null) {
                str = str + "|   mediatorLoadStates: " + loadStates + '\n';
            }
            return StringsKt.trimMargin$default(str + "|)", null, 1, null);
        }
    }

    /* compiled from: PageEvent.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\b\u0018\u0000 1*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003:\u00011BI\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\b\b\u0002\u0010\u0011*\u00020\u00012\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J:\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0096@¢\u0006\u0004\b\u0019\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ`\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\"\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010&R#\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010 R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b,\u0010 R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010-\u001a\u0004\b0\u0010/¨\u00062"}, d2 = {"Landroidx/paging/PageEvent$Insert;", "", "T", "Landroidx/paging/PageEvent;", "Landroidx/paging/LoadType;", "loadType", "", "Landroidx/paging/TransformablePage;", "pages", "", "placeholdersBefore", "placeholdersAfter", "Landroidx/paging/LoadStates;", "sourceLoadStates", "mediatorLoadStates", "<init>", "(Landroidx/paging/LoadType;Ljava/util/List;IILandroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "transform", "map", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "predicate", "filter", "", "toString", "()Ljava/lang/String;", "copy", "(Landroidx/paging/LoadType;Ljava/util/List;IILandroidx/paging/LoadStates;Landroidx/paging/LoadStates;)Landroidx/paging/PageEvent$Insert;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/paging/LoadType;", "getLoadType", "()Landroidx/paging/LoadType;", "Ljava/util/List;", "getPages", "()Ljava/util/List;", "I", "getPlaceholdersBefore", "getPlaceholdersAfter", "Landroidx/paging/LoadStates;", "getSourceLoadStates", "()Landroidx/paging/LoadStates;", "getMediatorLoadStates", "Companion", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Insert<T> extends PageEvent<T> {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private static final Insert<Object> EMPTY_REFRESH_LOCAL;
        private final LoadType loadType;
        private final LoadStates mediatorLoadStates;
        private final List<TransformablePage<T>> pages;
        private final int placeholdersAfter;
        private final int placeholdersBefore;
        private final LoadStates sourceLoadStates;

        public /* synthetic */ Insert(LoadType loadType, List list, int i, int i2, LoadStates loadStates, LoadStates loadStates2, DefaultConstructorMarker defaultConstructorMarker) {
            this(loadType, list, i, i2, loadStates, loadStates2);
        }

        public static /* synthetic */ Insert copy$default(Insert insert, LoadType loadType, List list, int i, int i2, LoadStates loadStates, LoadStates loadStates2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                loadType = insert.loadType;
            }
            if ((i3 & 2) != 0) {
                list = insert.pages;
            }
            List list2 = list;
            if ((i3 & 4) != 0) {
                i = insert.placeholdersBefore;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                i2 = insert.placeholdersAfter;
            }
            int i5 = i2;
            if ((i3 & 16) != 0) {
                loadStates = insert.sourceLoadStates;
            }
            LoadStates loadStates3 = loadStates;
            if ((i3 & 32) != 0) {
                loadStates2 = insert.mediatorLoadStates;
            }
            return insert.copy(loadType, list2, i4, i5, loadStates3, loadStates2);
        }

        public final Insert<T> copy(LoadType loadType, List<TransformablePage<T>> pages, int placeholdersBefore, int placeholdersAfter, LoadStates sourceLoadStates, LoadStates mediatorLoadStates) {
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            Intrinsics.checkNotNullParameter(pages, "pages");
            Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
            return new Insert<>(loadType, pages, placeholdersBefore, placeholdersAfter, sourceLoadStates, mediatorLoadStates);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Insert)) {
                return false;
            }
            Insert insert = (Insert) other;
            return this.loadType == insert.loadType && Intrinsics.areEqual(this.pages, insert.pages) && this.placeholdersBefore == insert.placeholdersBefore && this.placeholdersAfter == insert.placeholdersAfter && Intrinsics.areEqual(this.sourceLoadStates, insert.sourceLoadStates) && Intrinsics.areEqual(this.mediatorLoadStates, insert.mediatorLoadStates);
        }

        public int hashCode() {
            int iHashCode = ((((((((this.loadType.hashCode() * 31) + this.pages.hashCode()) * 31) + Integer.hashCode(this.placeholdersBefore)) * 31) + Integer.hashCode(this.placeholdersAfter)) * 31) + this.sourceLoadStates.hashCode()) * 31;
            LoadStates loadStates = this.mediatorLoadStates;
            return iHashCode + (loadStates == null ? 0 : loadStates.hashCode());
        }

        public final LoadType getLoadType() {
            return this.loadType;
        }

        public final List<TransformablePage<T>> getPages() {
            return this.pages;
        }

        public final int getPlaceholdersBefore() {
            return this.placeholdersBefore;
        }

        public final int getPlaceholdersAfter() {
            return this.placeholdersAfter;
        }

        public final LoadStates getSourceLoadStates() {
            return this.sourceLoadStates;
        }

        public final LoadStates getMediatorLoadStates() {
            return this.mediatorLoadStates;
        }

        private Insert(LoadType loadType, List<TransformablePage<T>> list, int i, int i2, LoadStates loadStates, LoadStates loadStates2) {
            super(null);
            this.loadType = loadType;
            this.pages = list;
            this.placeholdersBefore = i;
            this.placeholdersAfter = i2;
            this.sourceLoadStates = loadStates;
            this.mediatorLoadStates = loadStates2;
            if (loadType != LoadType.APPEND && i < 0) {
                throw new IllegalArgumentException(("Prepend insert defining placeholdersBefore must be > 0, but was " + i).toString());
            }
            if (loadType != LoadType.PREPEND && i2 < 0) {
                throw new IllegalArgumentException(("Append insert defining placeholdersAfter must be > 0, but was " + i2).toString());
            }
            if (loadType == LoadType.REFRESH && list.isEmpty()) {
                throw new IllegalArgumentException("Cannot create a REFRESH Insert event with no TransformablePages as this could permanently stall pagination. Note that this check does not prevent empty LoadResults and is instead usually an indication of an internal error in Paging itself.");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0108  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /* JADX WARN: Type inference failed for: r13v9, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r7v10, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r9v8, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0091 -> B:18:0x00b4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00de -> B:24:0x00e6). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public <R> java.lang.Object map(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r18, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>> r19) {
            /*
                Method dump skipped, instructions count: 292
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.map(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:17:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /* JADX WARN: Type inference failed for: r10v10, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r11v8, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r14v4, types: [java.util.Collection] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x009b -> B:18:0x00bd). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00f2 -> B:27:0x00ff). Please report as a decompilation issue!!! */
        @Override // androidx.paging.PageEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object filter(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r19, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<T>> r20) {
            /*
                Method dump skipped, instructions count: 343
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.filter(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* compiled from: PageEvent.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJF\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJN\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Landroidx/paging/PageEvent$Insert$Companion;", "", "()V", "EMPTY_REFRESH_LOCAL", "Landroidx/paging/PageEvent$Insert;", "getEMPTY_REFRESH_LOCAL", "()Landroidx/paging/PageEvent$Insert;", "Append", "T", "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersAfter", "", "sourceLoadStates", "Landroidx/paging/LoadStates;", "mediatorLoadStates", "Prepend", "placeholdersBefore", "Refresh", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ Insert Refresh$default(Companion companion, List list, int i, int i2, LoadStates loadStates, LoadStates loadStates2, int i3, Object obj) {
                if ((i3 & 16) != 0) {
                    loadStates2 = null;
                }
                return companion.Refresh(list, i, i2, loadStates, loadStates2);
            }

            public final <T> Insert<T> Refresh(List<TransformablePage<T>> pages, int placeholdersBefore, int placeholdersAfter, LoadStates sourceLoadStates, LoadStates mediatorLoadStates) {
                Intrinsics.checkNotNullParameter(pages, "pages");
                Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
                return new Insert<>(LoadType.REFRESH, pages, placeholdersBefore, placeholdersAfter, sourceLoadStates, mediatorLoadStates, null);
            }

            public final <T> Insert<T> Prepend(List<TransformablePage<T>> pages, int placeholdersBefore, LoadStates sourceLoadStates, LoadStates mediatorLoadStates) {
                Intrinsics.checkNotNullParameter(pages, "pages");
                Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
                return new Insert<>(LoadType.PREPEND, pages, placeholdersBefore, -1, sourceLoadStates, mediatorLoadStates, null);
            }

            public final <T> Insert<T> Append(List<TransformablePage<T>> pages, int placeholdersAfter, LoadStates sourceLoadStates, LoadStates mediatorLoadStates) {
                Intrinsics.checkNotNullParameter(pages, "pages");
                Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
                return new Insert<>(LoadType.APPEND, pages, -1, placeholdersAfter, sourceLoadStates, mediatorLoadStates, null);
            }

            public final Insert<Object> getEMPTY_REFRESH_LOCAL() {
                return Insert.EMPTY_REFRESH_LOCAL;
            }
        }

        static {
            Companion companion = new Companion(null);
            INSTANCE = companion;
            List listListOf = CollectionsKt.listOf(TransformablePage.INSTANCE.getEMPTY_INITIAL_PAGE());
            LoadState.NotLoading.Companion companion2 = LoadState.NotLoading.INSTANCE;
            EMPTY_REFRESH_LOCAL = Companion.Refresh$default(companion, listListOf, 0, 0, new LoadStates(companion2.getIncomplete$paging_common_release(), companion2.getComplete$paging_common_release(), companion2.getComplete$paging_common_release()), null, 16, null);
        }

        public String toString() {
            List<T> data;
            List<T> data2;
            Iterator<T> it = this.pages.iterator();
            int size = 0;
            while (it.hasNext()) {
                size += ((TransformablePage) it.next()).getData().size();
            }
            int i = this.placeholdersBefore;
            String strValueOf = i != -1 ? String.valueOf(i) : "none";
            int i2 = this.placeholdersAfter;
            String strValueOf2 = i2 != -1 ? String.valueOf(i2) : "none";
            LoadStates loadStates = this.mediatorLoadStates;
            StringBuilder sb = new StringBuilder();
            sb.append("PageEvent.Insert for ");
            sb.append(this.loadType);
            sb.append(", with ");
            sb.append(size);
            sb.append(" items (\n                    |   first item: ");
            TransformablePage transformablePage = (TransformablePage) CollectionsKt.firstOrNull((List) this.pages);
            sb.append((transformablePage == null || (data2 = transformablePage.getData()) == null) ? null : CollectionsKt.firstOrNull((List) data2));
            sb.append("\n                    |   last item: ");
            TransformablePage transformablePage2 = (TransformablePage) CollectionsKt.lastOrNull((List) this.pages);
            sb.append((transformablePage2 == null || (data = transformablePage2.getData()) == null) ? null : CollectionsKt.lastOrNull((List) data));
            sb.append("\n                    |   placeholdersBefore: ");
            sb.append(strValueOf);
            sb.append("\n                    |   placeholdersAfter: ");
            sb.append(strValueOf2);
            sb.append("\n                    |   sourceLoadStates: ");
            sb.append(this.sourceLoadStates);
            sb.append("\n                    ");
            String string = sb.toString();
            if (loadStates != null) {
                string = string + "|   mediatorLoadStates: " + loadStates + '\n';
            }
            return StringsKt.trimMargin$default(string + "|)", null, 1, null);
        }
    }

    /* compiled from: PageEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B'\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0010R\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010\u001d\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010¨\u0006\u001e"}, d2 = {"Landroidx/paging/PageEvent$Drop;", "", "T", "Landroidx/paging/PageEvent;", "Landroidx/paging/LoadType;", "loadType", "", "minPageOffset", "maxPageOffset", "placeholdersRemaining", "<init>", "(Landroidx/paging/LoadType;III)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/paging/LoadType;", "getLoadType", "()Landroidx/paging/LoadType;", "I", "getMinPageOffset", "getMaxPageOffset", "getPlaceholdersRemaining", "getPageCount", "pageCount", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Drop<T> extends PageEvent<T> {
        private final LoadType loadType;
        private final int maxPageOffset;
        private final int minPageOffset;
        private final int placeholdersRemaining;

        /* compiled from: PageEvent.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LoadType.values().length];
                try {
                    iArr[LoadType.APPEND.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LoadType.PREPEND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Drop)) {
                return false;
            }
            Drop drop = (Drop) other;
            return this.loadType == drop.loadType && this.minPageOffset == drop.minPageOffset && this.maxPageOffset == drop.maxPageOffset && this.placeholdersRemaining == drop.placeholdersRemaining;
        }

        public int hashCode() {
            return (((((this.loadType.hashCode() * 31) + Integer.hashCode(this.minPageOffset)) * 31) + Integer.hashCode(this.maxPageOffset)) * 31) + Integer.hashCode(this.placeholdersRemaining);
        }

        public final LoadType getLoadType() {
            return this.loadType;
        }

        public final int getMinPageOffset() {
            return this.minPageOffset;
        }

        public final int getMaxPageOffset() {
            return this.maxPageOffset;
        }

        public final int getPlaceholdersRemaining() {
            return this.placeholdersRemaining;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Drop(LoadType loadType, int i, int i2, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            this.loadType = loadType;
            this.minPageOffset = i;
            this.maxPageOffset = i2;
            this.placeholdersRemaining = i3;
            if (loadType == LoadType.REFRESH) {
                throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND");
            }
            if (getPageCount() <= 0) {
                throw new IllegalArgumentException(("Drop count must be > 0, but was " + getPageCount()).toString());
            }
            if (i3 >= 0) {
                return;
            }
            throw new IllegalArgumentException(("Invalid placeholdersRemaining " + i3).toString());
        }

        public final int getPageCount() {
            return (this.maxPageOffset - this.minPageOffset) + 1;
        }

        public String toString() {
            String str;
            int i = WhenMappings.$EnumSwitchMapping$0[this.loadType.ordinal()];
            if (i == 1) {
                str = "end";
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND");
                }
                str = "front";
            }
            return StringsKt.trimMargin$default("PageEvent.Drop from the " + str + " (\n                    |   minPageOffset: " + this.minPageOffset + "\n                    |   maxPageOffset: " + this.maxPageOffset + "\n                    |   placeholdersRemaining: " + this.placeholdersRemaining + "\n                    |)", null, 1, null);
        }
    }

    /* compiled from: PageEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Landroidx/paging/PageEvent$LoadStateUpdate;", "", "T", "Landroidx/paging/PageEvent;", "Landroidx/paging/LoadStates;", "source", "mediator", "<init>", "(Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/paging/LoadStates;", "getSource", "()Landroidx/paging/LoadStates;", "getMediator", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class LoadStateUpdate<T> extends PageEvent<T> {
        private final LoadStates mediator;
        private final LoadStates source;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadStateUpdate)) {
                return false;
            }
            LoadStateUpdate loadStateUpdate = (LoadStateUpdate) other;
            return Intrinsics.areEqual(this.source, loadStateUpdate.source) && Intrinsics.areEqual(this.mediator, loadStateUpdate.mediator);
        }

        public int hashCode() {
            int iHashCode = this.source.hashCode() * 31;
            LoadStates loadStates = this.mediator;
            return iHashCode + (loadStates == null ? 0 : loadStates.hashCode());
        }

        public /* synthetic */ LoadStateUpdate(LoadStates loadStates, LoadStates loadStates2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(loadStates, (i & 2) != 0 ? null : loadStates2);
        }

        public final LoadStates getSource() {
            return this.source;
        }

        public final LoadStates getMediator() {
            return this.mediator;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadStateUpdate(LoadStates source, LoadStates loadStates) {
            super(null);
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
            this.mediator = loadStates;
        }

        public String toString() {
            LoadStates loadStates = this.mediator;
            String str = "PageEvent.LoadStateUpdate (\n                    |   sourceLoadStates: " + this.source + "\n                    ";
            if (loadStates != null) {
                str = str + "|   mediatorLoadStates: " + loadStates + '\n';
            }
            return StringsKt.trimMargin$default(str + "|)", null, 1, null);
        }
    }

    static /* synthetic */ <T, R> Object map$suspendImpl(PageEvent<T> pageEvent, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super PageEvent<R>> continuation) {
        Intrinsics.checkNotNull(pageEvent, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.PageEvent.map>");
        return pageEvent;
    }
}
