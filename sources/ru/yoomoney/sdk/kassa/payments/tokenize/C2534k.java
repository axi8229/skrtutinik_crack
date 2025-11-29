package ru.yoomoney.sdk.kassa.payments.tokenize;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* renamed from: ru.yoomoney.sdk.kassa.payments.tokenize.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2534k extends Lambda implements Function1 {
    public final /* synthetic */ s a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2534k(s sVar) {
        super(1);
        this.a = sVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new C2532i(this.a, invoke, null));
        CoreKt.output(invoke, new C2533j(this.a, null));
        return Unit.INSTANCE;
    }
}
