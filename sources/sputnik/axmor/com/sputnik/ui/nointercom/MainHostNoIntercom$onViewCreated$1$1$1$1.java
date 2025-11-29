package sputnik.axmor.com.sputnik.ui.nointercom;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sputnik.common.GlobalVariables;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.pjsip.pjsua2.pjsip_transport_type_e;

/* compiled from: MainHostNoIntercom.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.nointercom.MainHostNoIntercom$onViewCreated$1$1$1$1", f = "MainHostNoIntercom.kt", l = {pjsip_transport_type_e.PJSIP_TRANSPORT_UDP6}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class MainHostNoIntercom$onViewCreated$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $it;
    int label;
    final /* synthetic */ MainHostNoIntercom this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainHostNoIntercom$onViewCreated$1$1$1$1(int i, MainHostNoIntercom mainHostNoIntercom, Continuation<? super MainHostNoIntercom$onViewCreated$1$1$1$1> continuation) {
        super(2, continuation);
        this.$it = i;
        this.this$0 = mainHostNoIntercom;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainHostNoIntercom$onViewCreated$1$1$1$1(this.$it, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainHostNoIntercom$onViewCreated$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(100L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        BottomNavigationView bottomNavigationView = GlobalVariables.INSTANCE.getBottomNavigationView();
        if (bottomNavigationView != null) {
            bottomNavigationView.setSelectedItemId(this.$it);
        }
        this.this$0.getNavigationViewModel().clearBottom();
        return Unit.INSTANCE;
    }
}
