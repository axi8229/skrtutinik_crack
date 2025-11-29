package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.f1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2412f1 extends Lambda implements Function2 {
    public final /* synthetic */ t1 a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2412f1(t1 t1Var, Function1 function1, Function0 function0, Function0 function02, int i) {
        super(2);
        this.a = t1Var;
        this.b = function1;
        this.c = function0;
        this.d = function02;
        this.e = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        ((Number) obj2).intValue();
        p1.a(this.a, this.b, this.c, this.d, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.e | 1));
        return Unit.INSTANCE;
    }
}
