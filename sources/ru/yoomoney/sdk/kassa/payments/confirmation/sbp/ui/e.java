package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.YooKassaViewModelProvider;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import ru.yoomoney.sdk.kassa.payments.confirmation.sbp.r;
import ru.yoomoney.sdk.kassa.payments.confirmation.sbp.s;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt;

/* loaded from: classes5.dex */
public abstract class e {
    public static final void a(Function2 navigateToBankList, Function0 navigateToSuccessful, String confirmationData, ru.yoomoney.sdk.kassa.payments.errorFormatter.b errorFormatter, s viewModelFactory, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(navigateToBankList, "navigateToBankList");
        Intrinsics.checkNotNullParameter(navigateToSuccessful, "navigateToSuccessful");
        Intrinsics.checkNotNullParameter(confirmationData, "confirmationData");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Composer composerStartRestartGroup = composer.startRestartGroup(903543604);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(navigateToBankList) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(navigateToSuccessful) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(confirmationData) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(errorFormatter) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(viewModelFactory) ? 16384 : 8192;
        }
        if ((46811 & i2) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(903543604, i2, -1, "ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui.SBPConfirmationController (SBPConfirmationController.kt:46)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            composerStartRestartGroup.startReplaceableGroup(-1020985694);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = ChannelKt.Channel$default(0, null, null, 7, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Channel channel = (Channel) objRememberedValue;
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-1162961104);
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
            if (current == null) {
                throw new IllegalStateException("CompositionLocal LocalViewModelStoreOwner not present");
            }
            ViewModel viewModel = new YooKassaViewModelProvider(current.getViewModelStore(), new r((ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.s) viewModelFactory.a.a.get(), confirmationData)).get("PaymentDetails", (Class<ViewModel>) RuntimeViewModel.class);
            composerStartRestartGroup.endReplaceableGroup();
            RuntimeViewModel runtimeViewModel = (RuntimeViewModel) viewModel;
            ReceiveChannel effects = runtimeViewModel.getEffects();
            composerStartRestartGroup.startReplaceableGroup(-1020985483);
            boolean z = ((i2 & 14) == 4) | ((i2 & 112) == 32);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new a(navigateToBankList, navigateToSuccessful, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ObservingExtensionsKt.observe(effects, (Function2) objRememberedValue2, composerStartRestartGroup, 72);
            n.a((q) ObservingExtensionsKt.observeAsUiState(runtimeViewModel.getStates(), p.a, new c(errorFormatter, context, runtimeViewModel, confirmationData), composerStartRestartGroup, 56).getValue(), channel, composerStartRestartGroup, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new d(navigateToBankList, navigateToSuccessful, confirmationData, errorFormatter, viewModelFactory, i));
        }
    }
}
