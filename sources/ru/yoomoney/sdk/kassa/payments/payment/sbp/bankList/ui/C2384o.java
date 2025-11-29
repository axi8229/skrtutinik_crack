package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2384o extends Lambda implements Function2 {
    public final /* synthetic */ a0 a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2384o(a0 a0Var, Function1 function1, int i) {
        super(2);
        this.a = a0Var;
        this.b = function1;
        this.c = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        O.a(this.a, this.b, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.c | 1));
        return Unit.INSTANCE;
    }
}
