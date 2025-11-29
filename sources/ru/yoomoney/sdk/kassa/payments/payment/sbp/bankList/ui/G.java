package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class G extends Lambda implements Function2 {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(int i) {
        super(2);
        this.a = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        ((Number) obj2).intValue();
        O.b((Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.a | 1));
        return Unit.INSTANCE;
    }
}
