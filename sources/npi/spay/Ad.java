package npi.spay;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ad extends Bd {
    public final List b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ad(List value) {
        super(value, 0);
        Intrinsics.checkNotNullParameter(value, "value");
        this.b = value;
    }
}
