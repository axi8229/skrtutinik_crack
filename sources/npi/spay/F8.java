package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class F8 extends Lambda implements Function1 {
    public final /* synthetic */ G8 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F8(G8 g8) {
        super(1);
        this.a = g8;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.a.h = ((Number) obj).longValue();
        return Unit.INSTANCE;
    }
}
