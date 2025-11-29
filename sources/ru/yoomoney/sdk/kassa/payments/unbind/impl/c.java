package ru.yoomoney.sdk.kassa.payments.unbind.impl;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeService;
import ru.yoomoney.sdk.kassa.payments.R$string;

/* loaded from: classes5.dex */
public final class c extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ MutableState c;
    public final /* synthetic */ NoticeService d;
    public final /* synthetic */ Context e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Function1 function1, MutableState mutableState, NoticeService noticeService, Context context, Continuation continuation) {
        super(2, continuation);
        this.b = function1;
        this.c = mutableState;
        this.d = noticeService;
        this.e = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        c cVar = new c(this.b, this.c, this.d, this.e, continuation);
        cVar.a = obj;
        return cVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((ru.yoomoney.sdk.kassa.payments.unbind.i) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        ru.yoomoney.sdk.kassa.payments.unbind.i iVar = (ru.yoomoney.sdk.kassa.payments.unbind.i) this.a;
        if (iVar instanceof ru.yoomoney.sdk.kassa.payments.unbind.g) {
            this.b.invoke(((ru.yoomoney.sdk.kassa.payments.unbind.g) iVar).a.b);
        } else if (iVar instanceof ru.yoomoney.sdk.kassa.payments.unbind.h) {
            this.c.setValue(Boxing.boxBoolean(false));
            NoticeService noticeService = this.d;
            String string = this.e.getString(R$string.ym_unbinding_card_failed, ((ru.yoomoney.sdk.kassa.payments.unbind.h) iVar).a.b);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            NoticeService.showAlertNotice$default(noticeService, string, null, null, 6, null);
        }
        return Unit.INSTANCE;
    }
}
