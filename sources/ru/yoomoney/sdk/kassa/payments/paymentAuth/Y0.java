package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public final class Y0 extends Lambda implements Function2 {
    public final /* synthetic */ ru.yoomoney.sdk.kassa.payments.errorFormatter.b a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Amount c;
    public final /* synthetic */ ViewModelProvider.Factory d;
    public final /* synthetic */ Function0 e;
    public final /* synthetic */ Function0 f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y0(ru.yoomoney.sdk.kassa.payments.errorFormatter.b bVar, boolean z, Amount amount, ViewModelProvider.Factory factory, Function0 function0, Function0 function02, int i) {
        super(2);
        this.a = bVar;
        this.b = z;
        this.c = amount;
        this.d = factory;
        this.e = function0;
        this.f = function02;
        this.g = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        ((Number) obj2).intValue();
        p1.a(this.a, this.b, this.c, this.d, this.e, this.f, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.g | 1));
        return Unit.INSTANCE;
    }
}
