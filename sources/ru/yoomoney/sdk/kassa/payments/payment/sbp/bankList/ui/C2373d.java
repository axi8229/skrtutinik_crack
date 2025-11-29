package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.q0;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.x0;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2373d extends Lambda implements Function2 {
    public final /* synthetic */ q0 a;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.errorFormatter.b b;
    public final /* synthetic */ x0 c;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.d0 d;
    public final /* synthetic */ Function0 e;
    public final /* synthetic */ Function0 f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2373d(q0 q0Var, ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar, x0 x0Var, ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.d0 d0Var, Function0 function0, Function0 function02, int i) {
        super(2);
        this.a = q0Var;
        this.b = bVar;
        this.c = x0Var;
        this.d = d0Var;
        this.e = function0;
        this.f = function02;
        this.g = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        AbstractC2374e.a(this.a, this.b, this.c, this.d, this.e, this.f, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.g | 1));
        return Unit.INSTANCE;
    }
}
