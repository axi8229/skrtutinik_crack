package ru.yoomoney.sdk.kassa.payments.contract.savePayment;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class g extends Lambda implements Function2 {
    public final /* synthetic */ CharSequence a;
    public final /* synthetic */ CharSequence b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Function0 e;
    public final /* synthetic */ CharSequence f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(CharSequence charSequence, CharSequence charSequence2, Function0 function0, String str, Function0 function02, CharSequence charSequence3, int i) {
        super(2);
        this.a = charSequence;
        this.b = charSequence2;
        this.c = function0;
        this.d = str;
        this.e = function02;
        this.f = charSequence3;
        this.g = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        j.a(this.a, this.b, this.c, this.d, this.e, this.f, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.g | 1));
        return Unit.INSTANCE;
    }
}
