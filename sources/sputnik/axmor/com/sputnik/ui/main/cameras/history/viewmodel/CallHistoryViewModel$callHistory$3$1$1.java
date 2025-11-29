package sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistory;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistoryUi;

/* compiled from: CallHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$callHistory$3$1$1", f = "CallHistoryViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class CallHistoryViewModel$callHistory$3$1$1 extends SuspendLambda implements Function2<CallHistoryUi, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $callId;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallHistoryViewModel$callHistory$3$1$1(String str, Continuation<? super CallHistoryViewModel$callHistory$3$1$1> continuation) {
        super(2, continuation);
        this.$callId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CallHistoryViewModel$callHistory$3$1$1 callHistoryViewModel$callHistory$3$1$1 = new CallHistoryViewModel$callHistory$3$1$1(this.$callId, continuation);
        callHistoryViewModel$callHistory$3$1$1.L$0 = obj;
        return callHistoryViewModel$callHistory$3$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CallHistoryUi callHistoryUi, Continuation<? super Boolean> continuation) {
        return ((CallHistoryViewModel$callHistory$3$1$1) create(callHistoryUi, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CallHistory item;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CallHistoryUi callHistoryUi = (CallHistoryUi) this.L$0;
        String callId = null;
        CallHistoryUi.CallHistoryItem callHistoryItem = callHistoryUi instanceof CallHistoryUi.CallHistoryItem ? (CallHistoryUi.CallHistoryItem) callHistoryUi : null;
        if (callHistoryItem != null && (item = callHistoryItem.getItem()) != null) {
            callId = item.getCallId();
        }
        return Boxing.boxBoolean(!Intrinsics.areEqual(callId, this.$callId));
    }
}
