package ru.yoomoney.sdk.kassa.payments.contract.savePayment;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class h extends Lambda implements Function2 {
    public final /* synthetic */ Modifier a;
    public final /* synthetic */ CharSequence b;
    public final /* synthetic */ CharSequence c;
    public final /* synthetic */ CharSequence d;
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Modifier modifier, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i) {
        super(2);
        this.a = modifier;
        this.b = charSequence;
        this.c = charSequence2;
        this.d = charSequence3;
        this.e = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        j.a(this.a, this.b, this.c, this.d, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.e | 1));
        return Unit.INSTANCE;
    }
}
