package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class C extends Lambda implements Function2 {
    public final /* synthetic */ Z a;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.errorFormatter.b b;
    public final /* synthetic */ RuntimeViewModel c;
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C(Z z, ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar, RuntimeViewModel runtimeViewModel, int i) {
        super(2);
        this.a = z;
        this.b = bVar;
        this.c = runtimeViewModel;
        this.d = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        ((Number) obj2).intValue();
        O.a(this.a, this.b, this.c, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.d | 1));
        return Unit.INSTANCE;
    }
}
