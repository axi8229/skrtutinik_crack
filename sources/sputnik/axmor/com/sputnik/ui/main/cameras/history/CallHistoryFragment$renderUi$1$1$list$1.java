package sputnik.axmor.com.sputnik.ui.main.cameras.history;

import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.common.utils.StringUtilsKt;
import com.sputnik.domain.entities.call.CallState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistory;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistoryUi;

/* compiled from: CallHistoryFragment.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;", "elem"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.cameras.history.CallHistoryFragment$renderUi$1$1$list$1", f = "CallHistoryFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class CallHistoryFragment$renderUi$1$1$list$1 extends SuspendLambda implements Function2<CallHistoryUi, Continuation<? super CallHistoryUi>, Object> {
    final /* synthetic */ Ref$ObjectRef<List<CallHistoryUi>> $fullList;
    final /* synthetic */ Ref$BooleanRef $needToShowPromo;
    final /* synthetic */ Ref$IntRef $size;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CallHistoryFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallHistoryFragment$renderUi$1$1$list$1(Ref$ObjectRef<List<CallHistoryUi>> ref$ObjectRef, Ref$BooleanRef ref$BooleanRef, CallHistoryFragment callHistoryFragment, Ref$IntRef ref$IntRef, Continuation<? super CallHistoryFragment$renderUi$1$1$list$1> continuation) {
        super(2, continuation);
        this.$fullList = ref$ObjectRef;
        this.$needToShowPromo = ref$BooleanRef;
        this.this$0 = callHistoryFragment;
        this.$size = ref$IntRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CallHistoryFragment$renderUi$1$1$list$1 callHistoryFragment$renderUi$1$1$list$1 = new CallHistoryFragment$renderUi$1$1$list$1(this.$fullList, this.$needToShowPromo, this.this$0, this.$size, continuation);
        callHistoryFragment$renderUi$1$1$list$1.L$0 = obj;
        return callHistoryFragment$renderUi$1$1$list$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CallHistoryUi callHistoryUi, Continuation<? super CallHistoryUi> continuation) {
        return ((CallHistoryFragment$renderUi$1$1$list$1) create(callHistoryUi, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CallHistoryUi callHistoryUi = (CallHistoryUi) this.L$0;
        this.$fullList.element.add(callHistoryUi);
        if (!(callHistoryUi instanceof CallHistoryUi.CallHistoryItem)) {
            return callHistoryUi;
        }
        CallHistoryUi.CallHistoryItem callHistoryItem = (CallHistoryUi.CallHistoryItem) callHistoryUi;
        if (callHistoryItem.getItem().getState() == CallState.history_date) {
            this.$needToShowPromo.element = true;
            this.this$0.getBinding().tvDatePromo.setText(String.valueOf(callHistoryItem.getItem().getDate()));
        }
        this.$size.element++;
        CallHistory item = callHistoryItem.getItem();
        UserAddress currentAddress = this.this$0.getProfileViewModel().getCurrentAddress();
        return new CallHistoryUi.CallHistoryItem(item.copy((8175 & 1) != 0 ? item.imageUrl : null, (8175 & 2) != 0 ? item.videoUrl : null, (8175 & 4) != 0 ? item.flatUUID : null, (8175 & 8) != 0 ? item.state : null, (8175 & 16) != 0 ? item.address : StringUtilsKt.orEmpty(currentAddress != null ? currentAddress.getFullAddress() : null), (8175 & 32) != 0 ? item.callId : null, (8175 & 64) != 0 ? item.creationDate : null, (8175 & 128) != 0 ? item.time : null, (8175 & 256) != 0 ? item.date : null, (8175 & 512) != 0 ? item.compareDate : null, (8175 & 1024) != 0 ? item.deviceUuid : null, (8175 & 2048) != 0 ? item.rawDateTime : null, (8175 & 4096) != 0 ? item.hasArchive : false));
    }
}
