package ru.yoomoney.sdk.kassa.payments.threeDS;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class l extends Lambda implements Function2 {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Function0 function0, boolean z, int i) {
        super(2);
        this.a = function0;
        this.b = z;
        this.c = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        m.a(this.a, this.b, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.c | 1));
        return Unit.INSTANCE;
    }
}
