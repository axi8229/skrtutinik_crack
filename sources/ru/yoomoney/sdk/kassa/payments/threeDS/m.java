package ru.yoomoney.sdk.kassa.payments.threeDS;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.gui.gui.R$color;
import ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt;
import ru.yoomoney.sdk.kassa.payments.R$drawable;

/* loaded from: classes5.dex */
public abstract class m {
    public static final void a(Function0 onNavigationClick, boolean z, Composer composer, int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onNavigationClick, "onNavigationClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1936766795);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onNavigationClick) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1936766795, i2, -1, "ru.yoomoney.sdk.kassa.payments.threeDS.WebViewTopBar (WebViewScreen.kt:45)");
            }
            composer2 = composerStartRestartGroup;
            TopBarKt.m3459TopBarDefaultwqdebIU((Modifier) null, PainterResources_androidKt.painterResource(R$drawable.ym_ic_close, composerStartRestartGroup, 0), (String) null, (Function0<Unit>) onNavigationClick, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2040460503, true, new k(z)), (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, ColorResources_androidKt.colorResource(R$color.color_default, composerStartRestartGroup, 0), 0L, false, composerStartRestartGroup, ((i2 << 9) & 7168) | 24640, 421);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new l(onNavigationClick, z, i));
        }
    }
}
