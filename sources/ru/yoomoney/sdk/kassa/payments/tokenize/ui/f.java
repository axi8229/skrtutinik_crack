package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class f extends Lambda implements Function0 {
    public final /* synthetic */ n a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(n nVar) {
        super(0);
        this.a = nVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        n nVar = this.a;
        int i = n.$r8$clinit;
        nVar.getClass();
        FragmentKt.setFragmentResult(nVar, "ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.TOKENIZE_RESULT_KEY", BundleKt.bundleOf(TuplesKt.to("ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.TOKENIZE_RESULT_EXTRA", ru.yoomoney.sdk.kassa.payments.navigation.n.a)));
        nVar.getParentFragmentManager().popBackStack();
        return Unit.INSTANCE;
    }
}
