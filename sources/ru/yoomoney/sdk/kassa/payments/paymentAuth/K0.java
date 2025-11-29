package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class K0 extends Lambda implements Function0 {
    public final /* synthetic */ O0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K0(O0 o0) {
        super(0);
        this.a = o0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        O0 o0 = this.a;
        ru.yoomoney.sdk.kassa.payments.navigation.h hVar = ru.yoomoney.sdk.kassa.payments.navigation.h.a;
        int i = O0.$r8$clinit;
        o0.getClass();
        FragmentKt.setFragmentResult(o0, "ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.PAYMENT_AUTH_RESULT_KEY", BundleKt.bundleOf(TuplesKt.to("ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.PAYMENT_AUTH_RESULT_EXTRA", hVar)));
        o0.getParentFragmentManager().popBackStack();
        return Unit.INSTANCE;
    }
}
