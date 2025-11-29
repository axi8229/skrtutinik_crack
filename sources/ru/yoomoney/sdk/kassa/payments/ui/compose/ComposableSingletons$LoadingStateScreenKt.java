package ru.yoomoney.sdk.kassa.payments.ui.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$LoadingStateScreenKt {
    public static final ComposableSingletons$LoadingStateScreenKt INSTANCE = new ComposableSingletons$LoadingStateScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f44lambda1 = ComposableLambdaKt.composableLambdaInstance(-1723844155, false, new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.compose.ComposableSingletons$LoadingStateScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1723844155, i, -1, "ru.yoomoney.sdk.kassa.payments.ui.compose.ComposableSingletons$LoadingStateScreenKt.lambda-1.<anonymous> (LoadingStateScreen.kt:53)");
            }
            LoadingStateScreenKt.LoadingStateScreen(null, composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f45lambda2 = ComposableLambdaKt.composableLambdaInstance(-1249386129, false, new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.compose.ComposableSingletons$LoadingStateScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1249386129, i, -1, "ru.yoomoney.sdk.kassa.payments.ui.compose.ComposableSingletons$LoadingStateScreenKt.lambda-2.<anonymous> (LoadingStateScreen.kt:61)");
            }
            LoadingStateScreenKt.LoadingStateScreen(null, composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$library_metricaRealRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3492getLambda1$library_metricaRealRelease() {
        return f44lambda1;
    }

    /* renamed from: getLambda-2$library_metricaRealRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3493getLambda2$library_metricaRealRelease() {
        return f45lambda2;
    }
}
