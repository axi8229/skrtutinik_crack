package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Si {
    public final D7 a;
    public final Oe b;

    public Si(D7 analyticsRepository, Oe eventBuilder) {
        Intrinsics.checkNotNullParameter(analyticsRepository, "analyticsRepository");
        Intrinsics.checkNotNullParameter(eventBuilder, "eventBuilder");
        this.a = analyticsRepository;
        this.b = eventBuilder;
    }
}
