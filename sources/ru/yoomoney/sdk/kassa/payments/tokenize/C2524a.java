package ru.yoomoney.sdk.kassa.payments.tokenize;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.UiParameters;
import ru.yoomoney.sdk.kassa.payments.metrics.C2298g;
import ru.yoomoney.sdk.kassa.payments.metrics.C2307p;
import ru.yoomoney.sdk.kassa.payments.metrics.C2312v;
import ru.yoomoney.sdk.kassa.payments.metrics.InterfaceC2309s;
import ru.yoomoney.sdk.kassa.payments.metrics.O;
import ru.yoomoney.sdk.kassa.payments.metrics.P;
import ru.yoomoney.sdk.kassa.payments.metrics.V;
import ru.yoomoney.sdk.kassa.payments.metrics.b0;
import ru.yoomoney.sdk.kassa.payments.metrics.c0;
import ru.yoomoney.sdk.kassa.payments.metrics.e0;
import ru.yoomoney.sdk.kassa.payments.metrics.k0;
import ru.yoomoney.sdk.kassa.payments.ui.color.ColorScheme;
import ru.yoomoney.sdk.kassa.payments.userAuth.U;

/* renamed from: ru.yoomoney.sdk.kassa.payments.tokenize.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2524a implements Function2 {
    public final ru.yoomoney.sdk.kassa.payments.metrics.F a;
    public final InterfaceC2309s b;
    public final Function2 c;
    public final Function0 d;
    public final U e;
    public final Function0 f;
    public final PaymentParameters g;
    public final UiParameters h;

    public C2524a(ru.yoomoney.sdk.kassa.payments.metrics.F reporter, InterfaceC2309s errorScreenReporter, s businessLogic, e0 getUserAuthType, ru.yoomoney.sdk.kassa.payments.secure.j userAuthInfoRepository, V getTokenizeScheme, PaymentParameters paymentParameters, UiParameters uiParameters) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(errorScreenReporter, "errorScreenReporter");
        Intrinsics.checkNotNullParameter(businessLogic, "businessLogic");
        Intrinsics.checkNotNullParameter(getUserAuthType, "getUserAuthType");
        Intrinsics.checkNotNullParameter(userAuthInfoRepository, "userAuthInfoRepository");
        Intrinsics.checkNotNullParameter(getTokenizeScheme, "getTokenizeScheme");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(uiParameters, "uiParameters");
        this.a = reporter;
        this.b = errorScreenReporter;
        this.c = businessLogic;
        this.d = getUserAuthType;
        this.e = userAuthInfoRepository;
        this.f = getTokenizeScheme;
        this.g = paymentParameters;
        this.h = uiParameters;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List a(P p) {
        ru.yoomoney.sdk.kassa.payments.metrics.I g;
        ru.yoomoney.sdk.kassa.payments.metrics.E[] eArr = new ru.yoomoney.sdk.kassa.payments.metrics.E[6];
        eArr[0] = this.d.invoke();
        eArr[1] = p;
        PaymentParameters parameters = this.g;
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        int i = ru.yoomoney.sdk.kassa.payments.metrics.J.a[parameters.getSavePaymentMethod().ordinal()];
        if (i == 1) {
            g = new ru.yoomoney.sdk.kassa.payments.metrics.G();
        } else if (i == 2) {
            g = new ru.yoomoney.sdk.kassa.payments.metrics.H();
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            g = new ru.yoomoney.sdk.kassa.payments.metrics.K();
        }
        eArr[2] = g;
        UiParameters uiParameters = this.h;
        Intrinsics.checkNotNullParameter(uiParameters, "uiParameters");
        eArr[3] = uiParameters.getShowLogo() ? new O() : new C2312v();
        UiParameters uiParameters2 = this.h;
        Intrinsics.checkNotNullParameter(uiParameters2, "uiParameters");
        eArr[4] = uiParameters2.getColorScheme().getPrimaryColor() == ColorScheme.INSTANCE.getDefaultPrimaryColor() ? new c0() : new b0();
        U userAuthInfoRepository = this.e;
        Intrinsics.checkNotNullParameter(userAuthInfoRepository, "userAuthInfoRepository");
        PaymentParameters paymentParameters = this.g;
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        eArr[5] = (paymentParameters.getCustomerId() == null || ((ru.yoomoney.sdk.kassa.payments.secure.j) userAuthInfoRepository).e() == null) ? paymentParameters.getCustomerId() != null ? new C2307p() : ((ru.yoomoney.sdk.kassa.payments.secure.j) userAuthInfoRepository).e() != null ? new k0() : new ru.yoomoney.sdk.kassa.payments.metrics.D() : new C2298g();
        return CollectionsKt.listOf((Object[]) eArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    @Override // kotlin.jvm.functions.Function2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invoke(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            ru.yoomoney.sdk.kassa.payments.tokenize.H r7 = (ru.yoomoney.sdk.kassa.payments.tokenize.H) r7
            ru.yoomoney.sdk.kassa.payments.tokenize.z r8 = (ru.yoomoney.sdk.kassa.payments.tokenize.z) r8
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = r8 instanceof ru.yoomoney.sdk.kassa.payments.tokenize.w
            r1 = 0
            if (r0 == 0) goto L36
            kotlin.jvm.functions.Function0 r0 = r6.f
            java.lang.Object r0 = r0.invoke()
            ru.yoomoney.sdk.kassa.payments.metrics.P r0 = (ru.yoomoney.sdk.kassa.payments.metrics.P) r0
            if (r0 == 0) goto L2d
            java.util.List r0 = r6.a(r0)
            java.lang.String r2 = "actionTryTokenize"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r2, r0)
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            if (r0 != 0) goto L5f
        L2d:
            kotlin.Pair r0 = kotlin.TuplesKt.to(r1, r1)
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            goto L5f
        L36:
            boolean r0 = r8 instanceof ru.yoomoney.sdk.kassa.payments.tokenize.y
            if (r0 == 0) goto L5a
            kotlin.jvm.functions.Function0 r0 = r6.f
            java.lang.Object r0 = r0.invoke()
            ru.yoomoney.sdk.kassa.payments.metrics.P r0 = (ru.yoomoney.sdk.kassa.payments.metrics.P) r0
            r2 = r8
            ru.yoomoney.sdk.kassa.payments.tokenize.y r2 = (ru.yoomoney.sdk.kassa.payments.tokenize.y) r2
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.l r2 = r2.a
            if (r2 == 0) goto L5a
            if (r0 == 0) goto L5a
            java.util.List r0 = r6.a(r0)
            java.lang.String r2 = "actionTokenize"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r2, r0)
        L55:
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            goto L5f
        L5a:
            kotlin.Pair r0 = kotlin.TuplesKt.to(r1, r1)
            goto L55
        L5f:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L65:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L85
            java.lang.Object r2 = r0.next()
            kotlin.Pair r2 = (kotlin.Pair) r2
            java.lang.Object r3 = r2.getFirst()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L65
            ru.yoomoney.sdk.kassa.payments.metrics.F r4 = r6.a
            java.lang.Object r2 = r2.getSecond()
            java.util.List r2 = (java.util.List) r2
            r4.a(r3, r2)
            goto L65
        L85:
            ru.yoomoney.sdk.kassa.payments.metrics.s r0 = r6.b
            boolean r2 = r8 instanceof ru.yoomoney.sdk.kassa.payments.tokenize.x
            if (r2 == 0) goto L8c
            r1 = r0
        L8c:
            if (r1 == 0) goto Lc0
            ru.yoomoney.sdk.kassa.payments.metrics.t r1 = (ru.yoomoney.sdk.kassa.payments.metrics.C2310t) r1
            ru.yoomoney.sdk.kassa.payments.metrics.F r0 = r1.c
            kotlin.jvm.functions.Function0 r2 = r1.b
            java.lang.Object r2 = r2.invoke()
            ru.yoomoney.sdk.kassa.payments.metrics.P r2 = (ru.yoomoney.sdk.kassa.payments.metrics.P) r2
            if (r2 == 0) goto Lb1
            r3 = 2
            ru.yoomoney.sdk.kassa.payments.metrics.E[] r3 = new ru.yoomoney.sdk.kassa.payments.metrics.E[r3]
            kotlin.jvm.functions.Function0 r4 = r1.a
            java.lang.Object r4 = r4.invoke()
            r5 = 0
            r3[r5] = r4
            r4 = 1
            r3[r4] = r2
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r3)
            if (r2 != 0) goto Lbb
        Lb1:
            kotlin.jvm.functions.Function0 r1 = r1.a
            java.lang.Object r1 = r1.invoke()
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r1)
        Lbb:
            java.lang.String r1 = "screenErrorContract"
            r0.a(r1, r2)
        Lc0:
            kotlin.jvm.functions.Function2 r0 = r6.c
            java.lang.Object r7 = r0.invoke(r7, r8)
            ru.yoomoney.sdk.march.Out r7 = (ru.yoomoney.sdk.march.Out) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.tokenize.C2524a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
