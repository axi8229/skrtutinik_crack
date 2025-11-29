package ru.yoomoney.sdk.kassa.payments.tokenize;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class m extends Lambda implements Function1 {
    public final /* synthetic */ z a;
    public final /* synthetic */ s b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(s sVar, z zVar) {
        super(1);
        this.a = zVar;
        this.b = sVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.output(invoke, new l(this.b, new C(((y) this.a).a, ((F) invoke.getState()).a.a()), null));
        CoreKt.input(invoke, this.b.c);
        return Unit.INSTANCE;
    }
}
