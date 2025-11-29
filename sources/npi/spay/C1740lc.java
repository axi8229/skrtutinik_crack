package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* renamed from: npi.spay.lc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1740lc {
    public final H4 a;
    public final Regex b;

    public C1740lc(H4 setCookieHandlerImpl) {
        Intrinsics.checkNotNullParameter(setCookieHandlerImpl, "setCookieHandlerImpl");
        this.a = setCookieHandlerImpl;
        this.b = new Regex("X.*?=.*?(?=[,;])");
    }
}
