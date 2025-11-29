package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2388t extends Lambda implements Function2 {
    public final /* synthetic */ Modifier a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2388t(Modifier modifier, List list, Function1 function1, Function0 function0, int i, int i2) {
        super(2);
        this.a = modifier;
        this.b = list;
        this.c = function1;
        this.d = function0;
        this.e = i;
        this.f = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        O.a(this.a, this.b, this.c, this.d, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.e | 1), this.f);
        return Unit.INSTANCE;
    }
}
