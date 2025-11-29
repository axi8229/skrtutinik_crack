package sputnik.axmor.com.sputnik.ui.settings;

import com.sputnik.common.base.BaseViewModel;
import com.sputnik.common.base.VMState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: BaseViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@¨\u0006\u0005"}, d2 = {"<anonymous>", "", "T", "Lcom/sputnik/common/base/VMState;", "Lkotlinx/coroutines/CoroutineScope;", "com/sputnik/common/base/BaseViewModel$updateState$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.sputnik.common.base.BaseViewModel$updateState$1", f = "BaseViewModel.kt", l = {123}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class SettingsViewModel$bluetoothStateBroadcastReceiver$1$onReceive$$inlined$updateState$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ VMState $updatedState;
    int label;
    final /* synthetic */ BaseViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsViewModel$bluetoothStateBroadcastReceiver$1$onReceive$$inlined$updateState$2(VMState vMState, BaseViewModel baseViewModel, Continuation continuation) {
        super(2, continuation);
        this.$updatedState = vMState;
        this.this$0 = baseViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsViewModel$bluetoothStateBroadcastReceiver$1$onReceive$$inlined$updateState$2(this.$updatedState, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsViewModel$bluetoothStateBroadcastReceiver$1$onReceive$$inlined$updateState$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.$updatedState.equals(this.this$0.getCurrentState())) {
                MutableStateFlow uiState = this.this$0.getUiState();
                VMState vMState = this.$updatedState;
                this.label = 1;
                if (uiState.emit(vMState, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
