package ru.yoomoney.sdk.kassa.payments.unbind.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class o extends Lambda implements Function2 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(int i, String str, boolean z) {
        super(2);
        this.a = z;
        this.b = str;
        this.c = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        u.a(this.a, this.b, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.c | 1));
        return Unit.INSTANCE;
    }
}
