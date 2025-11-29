package ru.yoomoney.sdk.kassa.payments.threeDS;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class g extends Lambda implements Function2 {
    public final /* synthetic */ Boolean a;
    public final /* synthetic */ WebViewFragment b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Boolean bool, WebViewFragment webViewFragment) {
        super(2);
        this.a = bool;
        this.b = webViewFragment;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Composer composer = (Composer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if ((iIntValue & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1381971020, iIntValue, -1, "ru.yoomoney.sdk.kassa.payments.threeDS.WebViewFragment.onCreateView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WebViewFragment.kt:128)");
            }
            f fVar = new f(this.b);
            Boolean progressState = this.a;
            Intrinsics.checkNotNullExpressionValue(progressState, "$progressState");
            m.a(fVar, progressState.booleanValue(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
