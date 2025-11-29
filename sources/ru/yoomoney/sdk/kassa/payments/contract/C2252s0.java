package ru.yoomoney.sdk.kassa.payments.contract;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.ui.compose.FragmentComposeViewKt;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.s0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2252s0 extends Lambda implements Function2 {
    public final /* synthetic */ C2264y0 a;
    public final /* synthetic */ Throwable b;
    public final /* synthetic */ Function0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2252s0(C2264y0 c2264y0, Throwable th, Function0 function0) {
        super(2);
        this.a = c2264y0;
        this.b = th;
        this.c = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Composer composer = (Composer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if ((iIntValue & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-366823341, iIntValue, -1, "ru.yoomoney.sdk.kassa.payments.contract.ContractFragment.showError.<anonymous>.<anonymous> (ContractFragment.kt:493)");
            }
            FragmentComposeViewKt.MoneyPaymentComposeContent(false, ComposableLambdaKt.composableLambda(composer, 74217326, true, new C2250r0(this.a, this.b, this.c)), composer, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
