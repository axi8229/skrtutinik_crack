package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.RuntimeViewModel;

/* loaded from: classes5.dex */
public final class d extends Lambda implements Function2 {
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.errorFormatter.b a;
    public final /* synthetic */ RuntimeViewModel b;
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.payment.tokenize.i c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ Function2 e;
    public final /* synthetic */ Function2 f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar, RuntimeViewModel runtimeViewModel, ru.yoomoney.sdk.kassa.payments.payment.tokenize.i iVar, Function0 function0, Function2 function2, Function2 function22, int i) {
        super(2);
        this.a = bVar;
        this.b = runtimeViewModel;
        this.c = iVar;
        this.d = function0;
        this.e = function2;
        this.f = function22;
        this.g = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        e.a(this.a, this.b, this.c, this.d, this.e, this.f, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.g | 1));
        return Unit.INSTANCE;
    }
}
