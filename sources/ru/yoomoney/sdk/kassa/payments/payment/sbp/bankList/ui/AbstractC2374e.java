package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.YooKassaViewModelProvider;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjsip_status_code;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.q0;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.w0;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.x0;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.y0;
import ru.yoomoney.sdk.kassa.payments.utils.compose.OnLifecycleEventKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC2374e {
    public static final void a(q0 bankListParams, ru.yoomoney.sdk.kassa.payments.errorFormatter.b errorFormatter, x0 viewModelFactory, ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.d0 bankListInteractor, Function0 closeBankList, Function0 closeBankListWithFinish, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(bankListParams, "bankListParams");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(bankListInteractor, "bankListInteractor");
        Intrinsics.checkNotNullParameter(closeBankList, "closeBankList");
        Intrinsics.checkNotNullParameter(closeBankListWithFinish, "closeBankListWithFinish");
        Composer composerStartRestartGroup = composer.startRestartGroup(154980391);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(bankListParams) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(errorFormatter) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(viewModelFactory) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(bankListInteractor) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(closeBankList) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(closeBankListWithFinish) ? 131072 : pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1;
        }
        int i3 = i2;
        if ((374491 & i3) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(154980391, i3, -1, "ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.BankListController (BankListController.kt:48)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            composerStartRestartGroup.startReplaceableGroup(-1162961104);
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
            if (current == null) {
                throw new IllegalStateException("CompositionLocal LocalViewModelStoreOwner not present");
            }
            ViewModelStore viewModelStore = current.getViewModelStore();
            y0 y0Var = viewModelFactory.a;
            ViewModel viewModel = new YooKassaViewModelProvider(viewModelStore, new w0((ru.yoomoney.sdk.kassa.payments.metrics.F) y0Var.a.get(), (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.d0) y0Var.b.get(), bankListParams)).get("BankListViewModel", (Class<ViewModel>) RuntimeViewModel.class);
            composerStartRestartGroup.endReplaceableGroup();
            RuntimeViewModel runtimeViewModel = (RuntimeViewModel) viewModel;
            ObservingExtensionsKt.observe(runtimeViewModel.getEffects(), new C2370a(context, runtimeViewModel, closeBankList, closeBankListWithFinish, null), composerStartRestartGroup, 72);
            O.a((Z) ObservingExtensionsKt.observeAsUiState(runtimeViewModel.getStates(), W.a, C2371b.a, composerStartRestartGroup, pjsip_status_code.PJSIP_SC_MAX_BREADTH_EXCEEDED).getValue(), errorFormatter, runtimeViewModel, composerStartRestartGroup, (i3 & 112) | 512);
            OnLifecycleEventKt.OnLifecycleEvent(new C2372c(bankListInteractor, runtimeViewModel), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C2373d(bankListParams, errorFormatter, viewModelFactory, bankListInteractor, closeBankList, closeBankListWithFinish, i));
        }
    }
}
