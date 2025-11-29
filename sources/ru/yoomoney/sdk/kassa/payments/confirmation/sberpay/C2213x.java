package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.ui.ContextExtensionsKt;
import ru.yoomoney.sdk.kassa.payments.ui.SharedElementTransitionUtilsKt;

/* renamed from: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.x, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C2213x extends FunctionReferenceImpl implements Function1 {
    public C2213x(Object obj) {
        super(1, obj, H.class, "handleState", "handleState(Lru/yoomoney/sdk/kassa/payments/confirmation/sberpay/SberPayConfirmationContract$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        AbstractC2210u p0 = (AbstractC2210u) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        H h = (H) this.receiver;
        int i = H.$r8$clinit;
        h.getClass();
        boolean zIsTablet = ContextExtensionsKt.isTablet(h);
        C2212w c2212w = new C2212w(p0, h);
        if (zIsTablet) {
            c2212w.invoke();
        } else {
            FrameLayout rootContainer = h.a().b;
            Intrinsics.checkNotNullExpressionValue(rootContainer, "rootContainer");
            SharedElementTransitionUtilsKt.changeViewWithAnimation(h, rootContainer, c2212w);
        }
        return Unit.INSTANCE;
    }
}
