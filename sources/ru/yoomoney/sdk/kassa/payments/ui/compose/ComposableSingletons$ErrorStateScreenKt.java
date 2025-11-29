package ru.yoomoney.sdk.kassa.payments.ui.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$ErrorStateScreenKt {
    public static final ComposableSingletons$ErrorStateScreenKt INSTANCE = new ComposableSingletons$ErrorStateScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f42lambda1 = ComposableLambdaKt.composableLambdaInstance(650859461, false, new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.compose.ComposableSingletons$ErrorStateScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(650859461, i, -1, "ru.yoomoney.sdk.kassa.payments.ui.compose.ComposableSingletons$ErrorStateScreenKt.lambda-1.<anonymous> (ErrorStateScreen.kt:58)");
            }
            ErrorStateScreenKt.ErrorStateScreen(null, 0, "try again", "unknown error", "follow the instuctions, please", new Function0<Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.compose.ComposableSingletons$ErrorStateScreenKt$lambda-1$1.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, composer, 224640, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f43lambda2 = ComposableLambdaKt.composableLambdaInstance(2096399343, false, new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.compose.ComposableSingletons$ErrorStateScreenKt$lambda-2$1
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
                ComposerKt.traceEventStart(2096399343, i, -1, "ru.yoomoney.sdk.kassa.payments.ui.compose.ComposableSingletons$ErrorStateScreenKt.lambda-2.<anonymous> (ErrorStateScreen.kt:70)");
            }
            ErrorStateScreenKt.ErrorStateScreen(null, 0, "try again", "unknown error", "follow the instuctions, please", new Function0<Unit>() { // from class: ru.yoomoney.sdk.kassa.payments.ui.compose.ComposableSingletons$ErrorStateScreenKt$lambda-2$1.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, composer, 224640, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$library_metricaRealRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3490getLambda1$library_metricaRealRelease() {
        return f42lambda1;
    }

    /* renamed from: getLambda-2$library_metricaRealRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3491getLambda2$library_metricaRealRelease() {
        return f43lambda2;
    }
}
