package ru.yoomoney.sdk.kassa.payments.confirmation;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.ui.CheckoutActivityKt;

/* loaded from: classes5.dex */
public final class g extends Lambda implements Function0 {
    public final /* synthetic */ ConfirmationActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ConfirmationActivity confirmationActivity) {
        super(0);
        this.a = confirmationActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        TestParameters testParameters = (TestParameters) this.a.getIntent().getParcelableExtra(CheckoutActivityKt.EXTRA_TEST_PARAMETERS);
        return testParameters == null ? new TestParameters(false, false, null, null, null, 31, null) : testParameters;
    }
}
