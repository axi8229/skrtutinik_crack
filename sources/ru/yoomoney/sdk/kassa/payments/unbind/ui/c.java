package ru.yoomoney.sdk.kassa.payments.unbind.ui;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class c extends Lambda implements Function1 {
    public final /* synthetic */ g a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(g gVar) {
        super(1);
        this.a = gVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String last4 = (String) obj;
        Intrinsics.checkNotNullParameter(last4, "last4");
        g gVar = this.a;
        int i = g.$r8$clinit;
        gVar.getClass();
        FragmentKt.setFragmentResult(gVar, "ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.UNBIND_CARD_RESULT_KEY", BundleKt.bundleOf(TuplesKt.to("ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.UNBIND_CARD_RESULT_EXTRA", new ru.yoomoney.sdk.kassa.payments.navigation.s(last4))));
        g gVar2 = this.a;
        gVar2.getParentFragmentManager().popBackStack();
        ru.yoomoney.sdk.kassa.payments.navigation.c cVar = gVar2.b;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
            cVar = null;
        }
        ((ru.yoomoney.sdk.kassa.payments.navigation.a) cVar).a(new ru.yoomoney.sdk.kassa.payments.navigation.j(null));
        return Unit.INSTANCE;
    }
}
