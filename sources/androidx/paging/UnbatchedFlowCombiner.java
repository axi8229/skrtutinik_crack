package androidx.paging;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: FlowExt.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B7\u0012.\u0010\b\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0004\b\u000e\u0010\u000fR<\u0010\b\u001a*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00110\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/paging/UnbatchedFlowCombiner;", "T1", "T2", "", "Lkotlin/Function4;", "Landroidx/paging/CombineSource;", "Lkotlin/coroutines/Continuation;", "", "send", "<init>", "(Lkotlin/jvm/functions/Function4;)V", "", "index", AppMeasurementSdk.ConditionalUserProperty.VALUE, "onNext", "(ILjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/jvm/functions/Function4;", "Lkotlinx/coroutines/CompletableDeferred;", "initialDispatched", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/sync/Mutex;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "", "valueReceived", "[Lkotlinx/coroutines/CompletableDeferred;", "values", "[Ljava/lang/Object;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UnbatchedFlowCombiner<T1, T2> {
    private final CompletableDeferred<Unit> initialDispatched;
    private final Mutex lock;
    private final Function4<T1, T2, CombineSource, Continuation<? super Unit>, Object> send;
    private final CompletableDeferred<Unit>[] valueReceived;
    private final Object[] values;

    /* compiled from: FlowExt.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.UnbatchedFlowCombiner", f = "FlowExt.kt", l = {190, 230, 207}, m = "onNext")
    /* renamed from: androidx.paging.UnbatchedFlowCombiner$onNext$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ UnbatchedFlowCombiner<T1, T2> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UnbatchedFlowCombiner<T1, T2> unbatchedFlowCombiner, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = unbatchedFlowCombiner;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onNext(0, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UnbatchedFlowCombiner(Function4<? super T1, ? super T2, ? super CombineSource, ? super Continuation<? super Unit>, ? extends Object> send) {
        Intrinsics.checkNotNullParameter(send, "send");
        this.send = send;
        this.initialDispatched = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.lock = MutexKt.Mutex$default(false, 1, null);
        CompletableDeferred<Unit>[] completableDeferredArr = new CompletableDeferred[2];
        for (int i = 0; i < 2; i++) {
            completableDeferredArr[i] = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        }
        this.valueReceived = completableDeferredArr;
        Object[] objArr = new Object[2];
        for (int i2 = 0; i2 < 2; i2++) {
            objArr[i2] = FlowExtKt.NULL;
        }
        this.values = objArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2 A[Catch: all -> 0x00be, TryCatch #1 {all -> 0x00be, blocks: (B:34:0x00ab, B:36:0x00b2, B:43:0x00c2, B:45:0x00ca, B:48:0x00d4, B:50:0x00d8, B:54:0x00e2, B:52:0x00dd, B:53:0x00e0, B:39:0x00bc), top: B:66:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ca A[Catch: all -> 0x00be, TryCatch #1 {all -> 0x00be, blocks: (B:34:0x00ab, B:36:0x00b2, B:43:0x00c2, B:45:0x00ca, B:48:0x00d4, B:50:0x00d8, B:54:0x00e2, B:52:0x00dd, B:53:0x00e0, B:39:0x00bc), top: B:66:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d8 A[Catch: all -> 0x00be, TryCatch #1 {all -> 0x00be, blocks: (B:34:0x00ab, B:36:0x00b2, B:43:0x00c2, B:45:0x00ca, B:48:0x00d4, B:50:0x00d8, B:54:0x00e2, B:52:0x00dd, B:53:0x00e0, B:39:0x00bc), top: B:66:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onNext(int r17, java.lang.Object r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.UnbatchedFlowCombiner.onNext(int, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
