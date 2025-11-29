package sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel;

import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms__PagingDataTransformsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistoryUi;

/* compiled from: CallHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "Landroidx/paging/PagingData;", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistoryUi;", "pagingData", "mod", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel$callHistory$3", f = "CallHistoryViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class CallHistoryViewModel$callHistory$3 extends SuspendLambda implements Function3<PagingData<CallHistoryUi>, List<? extends String>, Continuation<? super PagingData<CallHistoryUi>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    CallHistoryViewModel$callHistory$3(Continuation<? super CallHistoryViewModel$callHistory$3> continuation) {
        super(3, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(PagingData<CallHistoryUi> pagingData, List<String> list, Continuation<? super PagingData<CallHistoryUi>> continuation) {
        CallHistoryViewModel$callHistory$3 callHistoryViewModel$callHistory$3 = new CallHistoryViewModel$callHistory$3(continuation);
        callHistoryViewModel$callHistory$3.L$0 = pagingData;
        callHistoryViewModel$callHistory$3.L$1 = list;
        return callHistoryViewModel$callHistory$3.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(PagingData<CallHistoryUi> pagingData, List<? extends String> list, Continuation<? super PagingData<CallHistoryUi>> continuation) {
        return invoke2(pagingData, (List<String>) list, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        PagingData pagingDataFilter = (PagingData) this.L$0;
        Iterator it = ((List) this.L$1).iterator();
        while (it.hasNext()) {
            pagingDataFilter = PagingDataTransforms__PagingDataTransformsKt.filter(pagingDataFilter, new CallHistoryViewModel$callHistory$3$1$1((String) it.next(), null));
        }
        return pagingDataFilter;
    }
}
