package npi.spay;

import coil.request.ImageRequest;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class K5 extends Lambda implements Function1 {
    public static final K5 a = new K5();

    public K5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Intrinsics.checkNotNullParameter((ImageRequest.Builder) obj, "$this$null");
        return Unit.INSTANCE;
    }
}
