package npi.spay;

import coil.request.ImageRequest;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class A6 extends Lambda implements Function1 {
    public static final A6 a = new A6();

    public A6() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Intrinsics.checkNotNullParameter((ImageRequest.Builder) obj, "$this$null");
        return Unit.INSTANCE;
    }
}
