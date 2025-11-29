package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Li extends Lambda implements Function1 {
    public final /* synthetic */ Tk a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Li(Tk tk) {
        super(1);
        this.a = tk;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.a.e = ((Number) obj).longValue();
        return Unit.INSTANCE;
    }
}
