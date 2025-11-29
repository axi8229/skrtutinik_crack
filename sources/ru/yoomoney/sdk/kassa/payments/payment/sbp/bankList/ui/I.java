package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class I extends Lambda implements Function2 {
    public final /* synthetic */ d0 a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(d0 d0Var, Function0 function0, int i) {
        super(2);
        this.a = d0Var;
        this.b = function0;
        this.c = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        O.a(this.a, this.b, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.c | 1));
        return Unit.INSTANCE;
    }
}
