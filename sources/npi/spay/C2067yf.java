package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.yf, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2067yf extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2067yf(String endPoint) {
        super("Body from this service ---" + endPoint + "--- can not be null");
        Intrinsics.checkNotNullParameter(endPoint, "endPoint");
    }
}
