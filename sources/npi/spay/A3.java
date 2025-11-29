package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class A3 extends Lambda implements Function1 {
    public final /* synthetic */ C1979v2 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A3(C1979v2 c1979v2) {
        super(1);
        this.a = c1979v2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String it = (String) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.a.invoke(it);
        return Unit.INSTANCE;
    }
}
