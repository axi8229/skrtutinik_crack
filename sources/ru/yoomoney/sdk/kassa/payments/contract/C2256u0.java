package ru.yoomoney.sdk.kassa.payments.contract;

import android.widget.ViewAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.model.C2319c;
import ru.yoomoney.sdk.kassa.payments.ui.SharedElementTransitionUtilsKt;
import ru.yoomoney.sdk.kassa.payments.ui.view.LoadingView;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.u0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2256u0 extends Lambda implements Function0 {
    public final /* synthetic */ AbstractC2251s a;
    public final /* synthetic */ C2264y0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2256u0(AbstractC2251s abstractC2251s, C2264y0 c2264y0) {
        super(0);
        this.a = abstractC2251s;
        this.b = c2264y0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ru.yoomoney.sdk.kassa.payments.navigation.c cVarB;
        ru.yoomoney.sdk.kassa.payments.navigation.j jVar;
        AbstractC2251s abstractC2251s = this.a;
        if (Intrinsics.areEqual(abstractC2251s, r.a)) {
            C2264y0 c2264y0 = this.b;
            int i = C2264y0.$r8$clinit;
            ViewAnimator rootContainer = c2264y0.a().n;
            Intrinsics.checkNotNullExpressionValue(rootContainer, "rootContainer");
            LoadingView child = c2264y0.a().j;
            Intrinsics.checkNotNullExpressionValue(child, "loadingView");
            Intrinsics.checkNotNullParameter(rootContainer, "<this>");
            Intrinsics.checkNotNullParameter(child, "child");
            rootContainer.setDisplayedChild(rootContainer.indexOfChild(child));
        } else if (abstractC2251s instanceof C2246p) {
            C2264y0 c2264y02 = this.b;
            C2246p c2246p = (C2246p) this.a;
            int i2 = C2264y0.$r8$clinit;
            c2264y02.a(c2246p);
        } else if (abstractC2251s instanceof C2248q) {
            C2264y0 c2264y03 = this.b;
            Throwable th = ((C2248q) this.a).a;
            C2254t0 c2254t0 = new C2254t0(c2264y03);
            int i3 = C2264y0.$r8$clinit;
            c2264y03.getClass();
            if (th instanceof C2319c) {
                C2319c c2319c = (C2319c) th;
                int iOrdinal = c2319c.a().a.ordinal();
                if (iOrdinal != 8) {
                    switch (iOrdinal) {
                        case 13:
                        case 14:
                        case 15:
                            cVarB = c2264y03.b();
                            jVar = new ru.yoomoney.sdk.kassa.payments.navigation.j(null);
                            break;
                        default:
                            c2264y03.a(c2319c, c2254t0);
                            break;
                    }
                } else {
                    cVarB = c2264y03.b();
                    jVar = new ru.yoomoney.sdk.kassa.payments.navigation.j(null);
                }
                ((ru.yoomoney.sdk.kassa.payments.navigation.a) cVarB).a(jVar);
            } else {
                c2264y03.a(th, c2254t0);
            }
            ViewAnimator rootContainer2 = c2264y03.a().n;
            Intrinsics.checkNotNullExpressionValue(rootContainer2, "rootContainer");
            SharedElementTransitionUtilsKt.resumePostponedTransition(c2264y03, rootContainer2);
        }
        return Unit.INSTANCE;
    }
}
