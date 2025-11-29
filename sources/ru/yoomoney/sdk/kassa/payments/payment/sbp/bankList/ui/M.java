package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class M extends Lambda implements Function2 {
    public final /* synthetic */ S a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ Function1 e;
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(S s, Function1 function1, Function0 function0, Function0 function02, Function1 function12, int i) {
        super(2);
        this.a = s;
        this.b = function1;
        this.c = function0;
        this.d = function02;
        this.e = function12;
        this.f = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        ((Number) obj2).intValue();
        O.a(this.a, this.b, this.c, this.d, this.e, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.f | 1));
        return Unit.INSTANCE;
    }
}
