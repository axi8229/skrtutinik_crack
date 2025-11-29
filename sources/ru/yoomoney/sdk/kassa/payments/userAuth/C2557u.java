package ru.yoomoney.sdk.kassa.payments.userAuth;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* renamed from: ru.yoomoney.sdk.kassa.payments.userAuth.u, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2557u extends Lambda implements Function1 {
    public final /* synthetic */ K a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2557u(K k) {
        super(1);
        this.a = k;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        CoreKt.input(invoke, new C2556t(this.a, invoke, null));
        return Unit.INSTANCE;
    }
}
