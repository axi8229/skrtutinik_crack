package androidx.paging;

import androidx.paging.SingleRunner;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.pjsip.pjsua2.pjsip_transport_type_e;

/* compiled from: SingleRunner.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.SingleRunner$Holder", f = "SingleRunner.kt", l = {pjsip_transport_type_e.PJSIP_TRANSPORT_TLS6, 102}, m = "tryEnqueue")
/* loaded from: classes.dex */
final class SingleRunner$Holder$tryEnqueue$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SingleRunner.Holder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SingleRunner$Holder$tryEnqueue$1(SingleRunner.Holder holder, Continuation<? super SingleRunner$Holder$tryEnqueue$1> continuation) {
        super(continuation);
        this.this$0 = holder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.tryEnqueue(0, null, this);
    }
}
