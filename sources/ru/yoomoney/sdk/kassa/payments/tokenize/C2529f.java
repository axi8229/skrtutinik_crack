package ru.yoomoney.sdk.kassa.payments.tokenize;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* renamed from: ru.yoomoney.sdk.kassa.payments.tokenize.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2529f extends Lambda implements Function1 {
    public final /* synthetic */ s a;
    public final /* synthetic */ z b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2529f(s sVar, z zVar) {
        super(1);
        this.a = sVar;
        this.b = zVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, this.a.c);
        CoreKt.output(invoke, new C2528e(this.a, this.b, invoke, null));
        return Unit.INSTANCE;
    }
}
