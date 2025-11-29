package ru.yoomoney.sdk.kassa.payments.contract;

import android.widget.ViewAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.ContextExtensionsKt;
import ru.yoomoney.sdk.kassa.payments.ui.SharedElementTransitionUtilsKt;

/* loaded from: classes5.dex */
public final /* synthetic */ class W extends FunctionReferenceImpl implements Function1 {
    public W(Object obj) {
        super(1, obj, C2264y0.class, "showState", "showState(Lru/yoomoney/sdk/kassa/payments/contract/Contract$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        AbstractC2251s p0 = (AbstractC2251s) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        C2264y0 c2264y0 = (C2264y0) this.receiver;
        int i = C2264y0.$r8$clinit;
        c2264y0.getClass();
        boolean zIsTablet = ContextExtensionsKt.isTablet(c2264y0);
        C2256u0 c2256u0 = new C2256u0(p0, c2264y0);
        if (zIsTablet) {
            c2256u0.invoke();
        } else {
            ViewAnimator rootContainer = c2264y0.a().n;
            Intrinsics.checkNotNullExpressionValue(rootContainer, "rootContainer");
            SharedElementTransitionUtilsKt.changeViewWithAnimation(c2264y0, rootContainer, c2256u0);
        }
        return Unit.INSTANCE;
    }
}
