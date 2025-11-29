package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C2342a;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2370a extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ RuntimeViewModel c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ Function0 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2370a(Context context, RuntimeViewModel runtimeViewModel, Function0 function0, Function0 function02, Continuation continuation) {
        super(2, continuation);
        this.b = context;
        this.c = runtimeViewModel;
        this.d = function0;
        this.e = function02;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C2370a c2370a = new C2370a(this.b, this.c, this.d, this.e, continuation);
        c2370a.a = obj;
        return c2370a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((C2370a) create((ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.s) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Function0 function0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.s sVar = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.s) this.a;
        if (sVar instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.r) {
            Context context = this.b;
            String str = ((ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.r) sVar).a;
            RuntimeViewModel runtimeViewModel = this.c;
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setFlags(268468224);
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                runtimeViewModel.handleAction(new C2342a(e));
            }
        } else {
            if (sVar instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.p) {
                function0 = this.d;
            } else if (sVar instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.q) {
                function0 = this.e;
            }
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
