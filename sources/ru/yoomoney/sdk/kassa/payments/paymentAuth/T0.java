package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
public final class T0 extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;
    public final /* synthetic */ SoftwareKeyboardController b;
    public final /* synthetic */ Function0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T0(SoftwareKeyboardController softwareKeyboardController, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.b = softwareKeyboardController;
        this.c = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        T0 t0 = new T0(this.b, this.c, continuation);
        t0.a = obj;
        return t0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((T0) create((G) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        if (((G) this.a) instanceof F) {
            SoftwareKeyboardController softwareKeyboardController = this.b;
            if (softwareKeyboardController != null) {
                softwareKeyboardController.hide();
            }
            this.c.invoke();
        }
        return Unit.INSTANCE;
    }
}
