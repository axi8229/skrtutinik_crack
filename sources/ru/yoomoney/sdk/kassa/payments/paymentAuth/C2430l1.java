package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.l1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2430l1 extends Lambda implements Function2 {
    public final /* synthetic */ C2326j a;
    public final /* synthetic */ Integer b;
    public final /* synthetic */ Integer c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ Function0 e;
    public final /* synthetic */ Function1 f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2430l1(C2326j c2326j, Integer num, Integer num2, Function0 function0, Function0 function02, Function1 function1, int i) {
        super(2);
        this.a = c2326j;
        this.b = num;
        this.c = num2;
        this.d = function0;
        this.e = function02;
        this.f = function1;
        this.g = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        ((Number) obj2).intValue();
        p1.a(this.a, this.b, this.c, this.d, this.e, this.f, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.g | 1));
        return Unit.INSTANCE;
    }
}
