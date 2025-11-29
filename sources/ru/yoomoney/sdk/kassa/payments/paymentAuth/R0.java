package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class R0 extends Lambda implements Function2 {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public R0(int i) {
        super(2);
        this.a = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        p1.a((Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.a | 1));
        return Unit.INSTANCE;
    }
}
