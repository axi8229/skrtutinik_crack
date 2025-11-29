package ru.yoomoney.sdk.kassa.payments.contract.savePayment;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class i extends Lambda implements Function2 {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(String str, int i) {
        super(2);
        this.a = str;
        this.b = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        j.b(this.a, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.b | 1));
        return Unit.INSTANCE;
    }
}
