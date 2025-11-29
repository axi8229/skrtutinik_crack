package sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel;

import com.sputnik.domain.entities.call.CallState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistoryUi;

/* compiled from: CallHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;", "before", "after"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$callHistory$4$1", f = "CallHistoryViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class CallHistoryViewModel$callHistory$4$1 extends SuspendLambda implements Function3<CallHistoryUi, CallHistoryUi, Continuation<? super CallHistoryUi>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    CallHistoryViewModel$callHistory$4$1(Continuation<? super CallHistoryViewModel$callHistory$4$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CallHistoryUi callHistoryUi, CallHistoryUi callHistoryUi2, Continuation<? super CallHistoryUi> continuation) {
        CallHistoryViewModel$callHistory$4$1 callHistoryViewModel$callHistory$4$1 = new CallHistoryViewModel$callHistory$4$1(continuation);
        callHistoryViewModel$callHistory$4$1.L$0 = callHistoryUi;
        callHistoryViewModel$callHistory$4$1.L$1 = callHistoryUi2;
        return callHistoryViewModel$callHistory$4$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CallHistoryUi callHistoryUi = (CallHistoryUi) this.L$0;
        CallHistoryUi callHistoryUi2 = (CallHistoryUi) this.L$1;
        CallHistoryUi.DateItem dateItem = null;
        if (callHistoryUi2 == null) {
            return null;
        }
        if (callHistoryUi == null && (callHistoryUi2 instanceof CallHistoryUi.CallHistoryItem)) {
            CallHistoryUi.CallHistoryItem callHistoryItem = (CallHistoryUi.CallHistoryItem) callHistoryUi2;
            String date = callHistoryItem.getItem().getDate();
            Intrinsics.checkNotNull(date);
            CallState state = callHistoryItem.getItem().getState();
            if (state == null) {
                state = CallState.unknown;
            }
            return new CallHistoryUi.DateItem(date, state);
        }
        if ((callHistoryUi instanceof CallHistoryUi.CallHistoryItem) && (callHistoryUi2 instanceof CallHistoryUi.CallHistoryItem)) {
            CallHistoryUi.CallHistoryItem callHistoryItem2 = (CallHistoryUi.CallHistoryItem) callHistoryUi2;
            if (!Intrinsics.areEqual(((CallHistoryUi.CallHistoryItem) callHistoryUi).getItem().getCompareDate(), callHistoryItem2.getItem().getCompareDate())) {
                String date2 = callHistoryItem2.getItem().getDate();
                Intrinsics.checkNotNull(date2);
                CallState state2 = callHistoryItem2.getItem().getState();
                if (state2 == null) {
                    state2 = CallState.unknown;
                }
                dateItem = new CallHistoryUi.DateItem(date2, state2);
            }
        }
        return dateItem;
    }
}
