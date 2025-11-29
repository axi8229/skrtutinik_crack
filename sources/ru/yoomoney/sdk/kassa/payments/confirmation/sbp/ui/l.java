package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.guiCompose.views.notice.Notice;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeService;

/* loaded from: classes5.dex */
public final class l extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;
    public final /* synthetic */ NoticeService b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(NoticeService noticeService, Continuation continuation) {
        super(2, continuation);
        this.b = noticeService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        l lVar = new l(this.b, continuation);
        lVar.a = obj;
        return lVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        l lVar = new l(this.b, (Continuation) obj2);
        lVar.a = (Notice) obj;
        return lVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        ((Notice) this.a).show(this.b);
        return Unit.INSTANCE;
    }
}
