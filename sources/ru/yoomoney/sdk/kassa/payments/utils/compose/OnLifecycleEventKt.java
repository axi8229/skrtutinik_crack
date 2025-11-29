package ru.yoomoney.sdk.kassa.payments.utils.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a)\u0010\u0005\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/Function2;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Lifecycle$Event;", "", "onEvent", "OnLifecycleEvent", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "library_metricaRealRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnLifecycleEventKt {
    public static final void OnLifecycleEvent(Function2<? super LifecycleOwner, ? super Lifecycle.Event, Unit> onEvent, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerStartRestartGroup = composer.startRestartGroup(-485006323);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onEvent) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-485006323, i2, -1, "ru.yoomoney.sdk.kassa.payments.utils.compose.OnLifecycleEvent (OnLifecycleEvent.kt:31)");
            }
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onEvent, composerStartRestartGroup, i2 & 14);
            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()), composerStartRestartGroup, 8);
            Object value = stateRememberUpdatedState2.getValue();
            composerStartRestartGroup.startReplaceableGroup(-1656109483);
            boolean zChanged = composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changed(stateRememberUpdatedState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new b(stateRememberUpdatedState2, stateRememberUpdatedState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(value, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composerStartRestartGroup, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new c(onEvent, i));
        }
    }
}
