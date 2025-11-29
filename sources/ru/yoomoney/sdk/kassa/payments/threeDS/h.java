package ru.yoomoney.sdk.kassa.payments.threeDS;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.ui.compose.FragmentComposeViewKt;

/* loaded from: classes5.dex */
public final class h extends Lambda implements Function2 {
    public final /* synthetic */ WebViewFragment a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(WebViewFragment webViewFragment) {
        super(2);
        this.a = webViewFragment;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Composer composer = (Composer) obj;
        int iIntValue = ((Number) obj2).intValue();
        if ((iIntValue & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-13502801, iIntValue, -1, "ru.yoomoney.sdk.kassa.payments.threeDS.WebViewFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (WebViewFragment.kt:126)");
            }
            FragmentComposeViewKt.MoneyPaymentComposeContent(false, ComposableLambdaKt.composableLambda(composer, -1381971020, true, new g((Boolean) LiveDataAdapterKt.observeAsState(this.a.progress, Boolean.FALSE, composer, 56).getValue(), this.a)), composer, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
