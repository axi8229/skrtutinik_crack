package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Ki extends Lambda implements Function0 {
    public final /* synthetic */ Tk a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ki(Tk tk) {
        super(0);
        this.a = tk;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((Jh) this.a.c).a(C1975un.a);
        return Unit.INSTANCE;
    }
}
