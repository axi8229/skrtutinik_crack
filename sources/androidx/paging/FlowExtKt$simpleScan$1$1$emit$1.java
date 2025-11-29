package androidx.paging;

import androidx.paging.FlowExtKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FlowExt.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.FlowExtKt$simpleScan$1$1", f = "FlowExt.kt", l = {56, 57}, m = "emit")
/* loaded from: classes.dex */
final class FlowExtKt$simpleScan$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowExtKt.C04811.C00531<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowExtKt$simpleScan$1$1$emit$1(FlowExtKt.C04811.C00531<? super T> c00531, Continuation<? super FlowExtKt$simpleScan$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c00531;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
