package npi.spay;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import spay.sdk.api.SPayHelpers;

/* renamed from: npi.spay.m3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1756m3 extends Lambda implements Function1 {
    public static final C1756m3 a = new C1756m3();

    public C1756m3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SPayHelpers it = (SPayHelpers) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return it.name();
    }
}
