package ru.yoomoney.sdk.kassa.payments.unbind.impl;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.model.LinkedCard;
import ru.yoomoney.sdk.kassa.payments.model.Q;

/* loaded from: classes5.dex */
public final class e extends Lambda implements Function2 {
    public final /* synthetic */ F a;
    public final /* synthetic */ LinkedCard b;
    public final /* synthetic */ Q c;
    public final /* synthetic */ ViewModelProvider.Factory d;
    public final /* synthetic */ Function1 e;
    public final /* synthetic */ Function0 f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(F f, LinkedCard linkedCard, Q q, ViewModelProvider.Factory factory, Function1 function1, Function0 function0, int i) {
        super(2);
        this.a = f;
        this.b = linkedCard;
        this.c = q;
        this.d = factory;
        this.e = function1;
        this.f = function0;
        this.g = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        h.a(this.a, this.b, this.c, this.d, this.e, this.f, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.g | 1));
        return Unit.INSTANCE;
    }
}
