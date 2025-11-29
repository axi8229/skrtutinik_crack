package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.confirmation.sbp.s;

/* loaded from: classes5.dex */
public final class d extends Lambda implements Function2 {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.errorFormatter.b d;
    public final /* synthetic */ s e;
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Function2 function2, Function0 function0, String str, ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar, s sVar, int i) {
        super(2);
        this.a = function2;
        this.b = function0;
        this.c = str;
        this.d = bVar;
        this.e = sVar;
        this.f = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        e.a(this.a, this.b, this.c, this.d, this.e, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.f | 1));
        return Unit.INSTANCE;
    }
}
