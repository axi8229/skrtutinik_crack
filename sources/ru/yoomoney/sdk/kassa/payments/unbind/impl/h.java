package ru.yoomoney.sdk.kassa.payments.unbind.impl;

import android.content.Context;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.YooKassaViewModelProvider;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.view.compose.BackHandlerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pjsip_status_code;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeCommonKt;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeService;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.model.LinkedCard;
import ru.yoomoney.sdk.kassa.payments.model.Q;
import ru.yoomoney.sdk.march.RuntimeViewModel;
import ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt;

/* loaded from: classes5.dex */
public abstract class h {
    public static final void a(F reporter, LinkedCard linkedCard, Q q, ViewModelProvider.Factory viewModelFactory, Function1 onUnbindSuccess, Function0 onCloseScreen, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        Intrinsics.checkNotNullParameter(onUnbindSuccess, "onUnbindSuccess");
        Intrinsics.checkNotNullParameter(onCloseScreen, "onCloseScreen");
        Composer composerStartRestartGroup = composer.startRestartGroup(-209343970);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-209343970, i, -1, "ru.yoomoney.sdk.kassa.payments.unbind.impl.UnbindCardScreenController (UnbindBankCardController.kt:54)");
        }
        composerStartRestartGroup.startReplaceableGroup(-1162961104);
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("CompositionLocal LocalViewModelStoreOwner not present");
        }
        ViewModel viewModel = new YooKassaViewModelProvider(current.getViewModelStore(), viewModelFactory).get("UNBIND_CARD", (Class<ViewModel>) RuntimeViewModel.class);
        composerStartRestartGroup.endReplaceableGroup();
        RuntimeViewModel runtimeViewModel = (RuntimeViewModel) viewModel;
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new b(runtimeViewModel, linkedCard, q, null), composerStartRestartGroup, 70);
        composerStartRestartGroup.startReplaceableGroup(1740170272);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        f fVar = new f(runtimeViewModel);
        Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        composerStartRestartGroup.startReplaceableGroup(1740170571);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new SnackbarHostState();
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue2;
        composerStartRestartGroup.endReplaceableGroup();
        NoticeService noticeServiceRememberNoticeService = NoticeCommonKt.rememberNoticeService(snackbarHostState, composerStartRestartGroup, 6);
        ObservingExtensionsKt.observe(runtimeViewModel.getEffects(), new c(onUnbindSuccess, mutableState, noticeServiceRememberNoticeService, context, null), composerStartRestartGroup, 72);
        ru.yoomoney.sdk.kassa.payments.unbind.ui.u.a(reporter, onCloseScreen, fVar, (ru.yoomoney.sdk.kassa.payments.unbind.ui.y) ObservingExtensionsKt.observeAsUiState(runtimeViewModel.getStates(), ru.yoomoney.sdk.kassa.payments.unbind.ui.x.a, g.a, composerStartRestartGroup, pjsip_status_code.PJSIP_SC_MAX_BREADTH_EXCEEDED).getValue(), snackbarHostState, noticeServiceRememberNoticeService, composerStartRestartGroup, (i & 14) | 24576 | ((i >> 12) & 112) | (NoticeService.$stable << 15));
        composerStartRestartGroup.startReplaceableGroup(1740171489);
        boolean z = (((458752 & i) ^ 196608) > 131072 && composerStartRestartGroup.changed(onCloseScreen)) || (i & 196608) == 131072;
        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
        if (z || objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new d(onCloseScreen);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
        }
        composerStartRestartGroup.endReplaceableGroup();
        BackHandlerKt.BackHandler(false, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new e(reporter, linkedCard, q, viewModelFactory, onUnbindSuccess, onCloseScreen, i));
        }
    }
}
