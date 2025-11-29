package npi.spay;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: classes4.dex */
public final class Jc {
    public Pair a = new Pair("", "");

    public final Interceptor a(final C1523cj globalExceptionHandler, final Ih sPayDataContract, final C1740lc setCookieUtil) {
        Intrinsics.checkNotNullParameter(globalExceptionHandler, "globalExceptionHandler");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(setCookieUtil, "setCookieUtil");
        return new Interceptor() { // from class: npi.spay.Jc$$ExternalSyntheticLambda0
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return Jc.a(setCookieUtil, sPayDataContract, this, globalExceptionHandler, chain);
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final okhttp3.Response a(npi.spay.C1740lc r26, npi.spay.Ih r27, npi.spay.Jc r28, npi.spay.C1523cj r29, okhttp3.Interceptor.Chain r30) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.Jc.a(npi.spay.lc, npi.spay.Ih, npi.spay.Jc, npi.spay.cj, okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
