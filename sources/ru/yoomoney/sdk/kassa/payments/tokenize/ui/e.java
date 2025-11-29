package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ReceiveChannel;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt;

/* loaded from: classes5.dex */
public abstract class e {
    public static final void a(ru.yoomoney.sdk.kassa.payments.errorFormatter.b errorFormatter, RuntimeViewModel viewModel, ru.yoomoney.sdk.kassa.payments.payment.tokenize.i tokenizeInputModel, Function0 cancelTokenizeAction, Function2 tokenizeCompleteAction, Function2 paymentAuthRequiredAction, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(tokenizeInputModel, "tokenizeInputModel");
        Intrinsics.checkNotNullParameter(cancelTokenizeAction, "cancelTokenizeAction");
        Intrinsics.checkNotNullParameter(tokenizeCompleteAction, "tokenizeCompleteAction");
        Intrinsics.checkNotNullParameter(paymentAuthRequiredAction, "paymentAuthRequiredAction");
        Composer composerStartRestartGroup = composer.startRestartGroup(1120809159);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1120809159, i, -1, "ru.yoomoney.sdk.kassa.payments.tokenize.ui.TokenizeController (TokenizeController.kt:41)");
        }
        Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ReceiveChannel effects = viewModel.getEffects();
        composerStartRestartGroup.startReplaceableGroup(1623975828);
        boolean z = true;
        boolean z2 = ((((i & 7168) ^ 3072) > 2048 && composerStartRestartGroup.changed(cancelTokenizeAction)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) > 16384 && composerStartRestartGroup.changed(tokenizeCompleteAction)) || (i & 24576) == 16384);
        if ((((458752 & i) ^ 196608) <= 131072 || !composerStartRestartGroup.changed(paymentAuthRequiredAction)) && (i & 196608) != 131072) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a(cancelTokenizeAction, tokenizeCompleteAction, paymentAuthRequiredAction, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        ObservingExtensionsKt.observe(effects, (Function2) objRememberedValue, composerStartRestartGroup, 72);
        p.a((t) ObservingExtensionsKt.observeAsUiState(viewModel.getStates(), q.a, new c(errorFormatter, context, viewModel, tokenizeInputModel), composerStartRestartGroup, 56).getValue(), composerStartRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new d(errorFormatter, viewModel, tokenizeInputModel, cancelTokenizeAction, tokenizeCompleteAction, paymentAuthRequiredAction, i));
        }
    }
}
