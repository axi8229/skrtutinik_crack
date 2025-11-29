package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import android.content.res.Resources;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class r extends Lambda implements Function4 {
    public final /* synthetic */ List a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Function0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(List list, Function1 function1, Function0 function0) {
        super(4);
        this.a = list;
        this.b = function1;
        this.c = function0;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) throws Resources.NotFoundException {
        int i;
        LazyItemScope lazyItemScope = (LazyItemScope) obj;
        int iIntValue = ((Number) obj2).intValue();
        Composer composer = (Composer) obj3;
        int iIntValue2 = ((Number) obj4).intValue();
        if ((iIntValue2 & 14) == 0) {
            i = (composer.changed(lazyItemScope) ? 4 : 2) | iIntValue2;
        } else {
            i = iIntValue2;
        }
        if ((iIntValue2 & 112) == 0) {
            i |= composer.changed(iIntValue) ? 32 : 16;
        }
        if ((i & 731) == 146 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-632812321, i, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:148)");
            }
            e0 e0Var = (e0) this.a.get(iIntValue);
            composer.startReplaceableGroup(-727390901);
            O.a(e0Var, this.b, this.c, composer, 0);
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
