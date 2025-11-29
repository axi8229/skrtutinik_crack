package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class J extends Lambda implements Function2 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(String str, String str2, Function0 function0, int i, int i2) {
        super(2);
        this.a = str;
        this.b = str2;
        this.c = function0;
        this.d = i;
        this.e = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        O.a(this.a, this.b, this.c, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.d | 1), this.e);
        return Unit.INSTANCE;
    }
}
