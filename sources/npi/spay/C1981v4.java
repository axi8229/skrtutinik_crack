package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: npi.spay.v4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1981v4 extends Lambda implements Function0 {
    public final /* synthetic */ C2081z4 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1981v4(C2081z4 c2081z4) {
        super(0);
        this.a = c2081z4;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.j.setValue(-1L);
        return Unit.INSTANCE;
    }
}
