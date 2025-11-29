package npi.spay;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.R$string;

/* renamed from: npi.spay.g4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1608g4 extends Lambda implements Function0 {
    public final /* synthetic */ C1807o4 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1608g4(C1807o4 c1807o4) {
        super(0);
        this.a = c1807o4;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.k.setValue(new C1460a6(new C2097zk(R$string.spay_wait_a_second, CollectionsKt.emptyList())));
        return Unit.INSTANCE;
    }
}
