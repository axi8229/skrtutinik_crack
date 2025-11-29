package ru.yoomoney.sdk.march;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import ru.yoomoney.sdk.march.Effect;

/* compiled from: Core.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "INPUT", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.yoomoney.sdk.march.CoreKt$createSourcesListener$1$3$1", f = "Core.kt", l = {148}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class CoreKt$createSourcesListener$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SendChannel<INPUT> $inputs;
    final /* synthetic */ Effect.Input.Sub<INPUT> $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CoreKt$createSourcesListener$1$3$1(Effect.Input.Sub<? extends INPUT> sub, SendChannel<? super INPUT> sendChannel, Continuation<? super CoreKt$createSourcesListener$1$3$1> continuation) {
        super(2, continuation);
        this.$it = sub;
        this.$inputs = sendChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoreKt$createSourcesListener$1$3$1(this.$it, this.$inputs, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoreKt$createSourcesListener$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flow = this.$it.getFlow();
            final SendChannel<INPUT> sendChannel = this.$inputs;
            FlowCollector flowCollector = new FlowCollector() { // from class: ru.yoomoney.sdk.march.CoreKt$createSourcesListener$1$3$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(INPUT input, Continuation<? super Unit> continuation) {
                    Object objSend = sendChannel.send(input, continuation);
                    return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (flow.collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
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
