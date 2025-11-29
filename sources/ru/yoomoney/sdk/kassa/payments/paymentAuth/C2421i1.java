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

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.i1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2421i1 extends Lambda implements Function2 {
    public final /* synthetic */ C2326j a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ Function0 g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ int i;
    public final /* synthetic */ int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2421i1(C2326j c2326j, String str, Function1 function1, Function0 function0, String str2, boolean z, Function0 function02, boolean z2, int i, int i2) {
        super(2);
        this.a = c2326j;
        this.b = str;
        this.c = function1;
        this.d = function0;
        this.e = str2;
        this.f = z;
        this.g = function02;
        this.h = z2;
        this.i = i;
        this.j = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
        ((Number) obj2).intValue();
        p1.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, (Composer) obj, RecomposeScopeImplKt.updateChangedFlags(this.i | 1), this.j);
        return Unit.INSTANCE;
    }
}
