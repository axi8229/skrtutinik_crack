package sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel;

import androidx.lifecycle.ViewModelKt;
import com.sputnik.domain.entities.call.CallState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistory;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistoryUi;

/* compiled from: CallHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;", "it", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistory;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$callHistory$2$1", f = "CallHistoryViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class CallHistoryViewModel$callHistory$2$1 extends SuspendLambda implements Function2<CallHistory, Continuation<? super CallHistoryUi>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CallHistoryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallHistoryViewModel$callHistory$2$1(CallHistoryViewModel callHistoryViewModel, Continuation<? super CallHistoryViewModel$callHistory$2$1> continuation) {
        super(2, continuation);
        this.this$0 = callHistoryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CallHistoryViewModel$callHistory$2$1 callHistoryViewModel$callHistory$2$1 = new CallHistoryViewModel$callHistory$2$1(this.this$0, continuation);
        callHistoryViewModel$callHistory$2$1.L$0 = obj;
        return callHistoryViewModel$callHistory$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CallHistory callHistory, Continuation<? super CallHistoryUi> continuation) {
        return ((CallHistoryViewModel$callHistory$2$1) create(callHistory, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CallHistory callHistory = (CallHistory) this.L$0;
        if (callHistory.getState() == CallState.history_date) {
            CallHistoryViewModel callHistoryViewModel = this.this$0;
            CallHistoryViewState callHistoryViewStateCopy$default = CallHistoryViewState.copy$default(callHistoryViewModel.getCurrentState(), null, null, true, 3, null);
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(callHistoryViewModel), null, null, new CallHistoryViewModel$callHistory$2$1$invokeSuspend$$inlined$updateState$1(callHistoryViewStateCopy$default, callHistoryViewModel, null), 3, null);
            callHistoryViewModel.getState().setValue(callHistoryViewStateCopy$default);
            return CallHistoryUi.Promo.INSTANCE;
        }
        return new CallHistoryUi.CallHistoryItem(callHistory);
    }
}
