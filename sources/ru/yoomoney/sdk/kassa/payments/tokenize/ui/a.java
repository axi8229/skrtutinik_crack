package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import ru.yoomoney.sdk.kassa.payments.tokenize.A;
import ru.yoomoney.sdk.kassa.payments.tokenize.B;
import ru.yoomoney.sdk.kassa.payments.tokenize.C;
import ru.yoomoney.sdk.kassa.payments.tokenize.D;

/* loaded from: classes5.dex */
public final class a extends SuspendLambda implements Function2 {
    public /* synthetic */ Object a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function2 c;
    public final /* synthetic */ Function2 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Function0 function0, Function2 function2, Function2 function22, Continuation continuation) {
        super(2, continuation);
        this.b = function0;
        this.c = function2;
        this.d = function22;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        a aVar = new a(this.b, this.c, this.d, continuation);
        aVar.a = obj;
        return aVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((a) create((D) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        D d = (D) this.a;
        if (d instanceof A) {
            this.b.invoke();
        } else if (d instanceof C) {
            C c = (C) d;
            this.c.invoke(c.a, Boxing.boxBoolean(c.b));
        } else if (d instanceof B) {
            B b = (B) d;
            this.d.invoke(b.a, Boxing.boxBoolean(b.b));
        }
        return Unit.INSTANCE;
    }
}
