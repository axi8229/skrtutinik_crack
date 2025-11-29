package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Gd extends Lambda implements Function0 {
    public final /* synthetic */ C1889rc a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Gd(C1889rc c1889rc) {
        super(0);
        this.a = c1889rc;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.e.a.a(new String[]{"X-Sdk-Refresh-Data", "X-Sdk-Id-Key"});
        ((Jh) this.a.c).a(C1975un.a);
        return Unit.INSTANCE;
    }
}
