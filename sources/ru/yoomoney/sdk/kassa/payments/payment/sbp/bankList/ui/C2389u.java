package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.u, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2389u extends Lambda implements Function2 {
    public final /* synthetic */ e0 a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2389u(e0 e0Var, Function1 function1, Function0 function0, int i) {
        super(2);
        this.a = e0Var;
        this.b = function1;
        this.c = function0;
        this.d = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        ((Number) obj2).intValue();
        O.a(this.a, this.b, this.c, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.d | 1));
        return Unit.INSTANCE;
    }
}
