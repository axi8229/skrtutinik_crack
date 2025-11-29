package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class g extends Lambda implements Function2 {
    public final /* synthetic */ n a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(n nVar) {
        super(2);
        this.a = nVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ru.yoomoney.sdk.kassa.payments.payment.tokenize.l tokenizeOutputModel = (ru.yoomoney.sdk.kassa.payments.payment.tokenize.l) obj;
        ((Boolean) obj2).getClass();
        Intrinsics.checkNotNullParameter(tokenizeOutputModel, "tokenizeOutputModel");
        ru.yoomoney.sdk.kassa.payments.navigation.c cVar = this.a.b;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
            cVar = null;
        }
        ((ru.yoomoney.sdk.kassa.payments.navigation.a) cVar).a(new ru.yoomoney.sdk.kassa.payments.navigation.q(tokenizeOutputModel));
        return Unit.INSTANCE;
    }
}
