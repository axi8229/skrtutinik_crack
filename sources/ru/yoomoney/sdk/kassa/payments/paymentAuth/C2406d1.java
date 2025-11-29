package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.d1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2406d1 extends Lambda implements Function2 {
    public final /* synthetic */ Modifier a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Function0 e;
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2406d1(Modifier modifier, boolean z, String str, boolean z2, Function0 function0, int i) {
        super(2);
        this.a = modifier;
        this.b = z;
        this.c = str;
        this.d = z2;
        this.e = function0;
        this.f = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        ((Number) obj2).intValue();
        p1.a(this.a, this.b, this.c, this.d, this.e, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.f | 1));
        return Unit.INSTANCE;
    }
}
