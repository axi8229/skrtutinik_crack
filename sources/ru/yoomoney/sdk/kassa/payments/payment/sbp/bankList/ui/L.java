package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class L extends Lambda implements Function1 {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ MutableState b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(Function1 function1, MutableState mutableState) {
        super(1);
        this.a = function1;
        this.b = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String it = (String) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.b.setValue(it);
        this.a.invoke(it);
        return Unit.INSTANCE;
    }
}
