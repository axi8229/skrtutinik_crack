package ru.yoomoney.sdk.two_fa.utils;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDateTime;
import ru.yoomoney.sdk.guiCompose.views.buttons.ButtonsKt;

/* compiled from: ResendTimerButton.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aG\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"ResendTimerButton", "", "modifier", "Landroidx/compose/ui/Modifier;", "enabledTextRes", "", "disabledTextRes", "availableFrom", "Lorg/threeten/bp/LocalDateTime;", "isEnabled", "", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;IILorg/threeten/bp/LocalDateTime;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResendTimerButtonKt {
    public static final void ResendTimerButton(final Modifier modifier, final int i, final int i2, final LocalDateTime availableFrom, final boolean z, final Function0<Unit> onClick, Composer composer, final int i3) throws Resources.NotFoundException {
        String strStringResource;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(availableFrom, "availableFrom");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1328479354);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1328479354, i3, -1, "ru.yoomoney.sdk.two_fa.utils.ResendTimerButton (ResendTimerButton.kt:22)");
        }
        composerStartRestartGroup.startReplaceableGroup(-1759512733);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(-1759512652);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        final MutableState mutableState2 = (MutableState) objRememberedValue2;
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(-1759512560);
        Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new Function1<String, Unit>() { // from class: ru.yoomoney.sdk.two_fa.utils.ResendTimerButtonKt$ResendTimerButton$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    mutableState.setValue(it);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
        }
        Function1 function1 = (Function1) objRememberedValue3;
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(-1759512514);
        Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue4 == companion.getEmpty()) {
            objRememberedValue4 = new Function0<Unit>() { // from class: ru.yoomoney.sdk.two_fa.utils.ResendTimerButtonKt$ResendTimerButton$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    mutableState2.setValue(Boolean.TRUE);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
        }
        composerStartRestartGroup.endReplaceableGroup();
        new CountDownTimerManager(function1, (Function0) objRememberedValue4).startTimerIfNeed(availableFrom);
        mutableState2.setValue(Boolean.valueOf(availableFrom.isBefore(LocalDateTime.now())));
        if (((Boolean) mutableState2.getValue()).booleanValue()) {
            composerStartRestartGroup.startReplaceableGroup(-1759512304);
            strStringResource = StringResources_androidKt.stringResource(i, composerStartRestartGroup, (i3 >> 3) & 14);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1759512252);
            strStringResource = StringResources_androidKt.stringResource(i2, new Object[]{mutableState.getValue()}, composerStartRestartGroup, ((i3 >> 6) & 14) | 64);
            composerStartRestartGroup.endReplaceableGroup();
        }
        ButtonsKt.FlatButtonView(strStringResource, modifier, ((Boolean) mutableState2.getValue()).booleanValue() && z, onClick, composerStartRestartGroup, ((i3 << 3) & 112) | ((i3 >> 6) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.utils.ResendTimerButtonKt.ResendTimerButton.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) throws Resources.NotFoundException {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) throws Resources.NotFoundException {
                    ResendTimerButtonKt.ResendTimerButton(modifier, i, i2, availableFrom, z, onClick, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
                }
            });
        }
    }
}
