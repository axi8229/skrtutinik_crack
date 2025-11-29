package ru.yoomoney.sdk.kassa.payments.contract.savePayment;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pjsip_status_code;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;
import ru.yoomoney.sdk.guiCompose.views.buttons.ButtonsKt;
import ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt;
import ru.yoomoney.sdk.kassa.payments.R$drawable;

/* loaded from: classes5.dex */
public abstract class j {
    public static final void a(String str, Composer composer, int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1687642488);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1687642488, i2, -1, "ru.yoomoney.sdk.kassa.payments.contract.savePayment.BodyText (SavePaymentethodScreen.kt:102)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            YooTheme yooTheme = YooTheme.INSTANCE;
            int i3 = YooTheme.$stable;
            composer2 = composerStartRestartGroup;
            TextKt.m685Text4IGK_g(str, PaddingKt.m309padding3ABfNKs(modifierFillMaxWidth$default, yooTheme.getDimens(composerStartRestartGroup, i3).getSpaceS()), yooTheme.getColors(composerStartRestartGroup, i3).getType().getPrimary(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, yooTheme.getTypography(composerStartRestartGroup, i3).getBody(), composer2, i2 & 14, 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new e(str, i));
        }
    }

    public static final void b(String str, Composer composer, int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1086809646);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1086809646, i2, -1, "ru.yoomoney.sdk.kassa.payments.contract.savePayment.TitleText (SavePaymentethodScreen.kt:90)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            YooTheme yooTheme = YooTheme.INSTANCE;
            int i3 = YooTheme.$stable;
            composer2 = composerStartRestartGroup;
            TextKt.m685Text4IGK_g(str, PaddingKt.m309padding3ABfNKs(modifierFillMaxWidth$default, yooTheme.getDimens(composerStartRestartGroup, i3).getSpaceS()), yooTheme.getColors(composerStartRestartGroup, i3).getType().getPrimary(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, yooTheme.getTypography(composerStartRestartGroup, i3).getTitle1(), composer2, i2 & 14, 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new i(str, i));
        }
    }

    public static final void a(CharSequence title, CharSequence info, Function0 onBack, String actionText, Function0 onButtonClick, CharSequence charSequence, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        Intrinsics.checkNotNullParameter(onButtonClick, "onButtonClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1997856638);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1997856638, i, -1, "ru.yoomoney.sdk.kassa.payments.contract.savePayment.SavePaymentMethodScreen (SavePaymentethodScreen.kt:48)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
        YooTheme yooTheme = YooTheme.INSTANCE;
        int i2 = YooTheme.$stable;
        Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(BackgroundKt.m166backgroundbw27NRU$default(modifierFillMaxSize$default, yooTheme.getColors(composerStartRestartGroup, i2).getTheme().getTintBg(), null, 2, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierVerticalScroll$default);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM727constructorimpl = Updater.m727constructorimpl(composerStartRestartGroup);
        Updater.m728setimpl(composerM727constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        TopBarKt.m3459TopBarDefaultwqdebIU((Modifier) null, PainterResources_androidKt.painterResource(R$drawable.ym_ic_close, composerStartRestartGroup, 0), (String) null, (Function0<Unit>) onBack, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, 0L, 0L, false, composerStartRestartGroup, ((i << 3) & 7168) | 64, pjsip_status_code.PJSIP_SC_NOT_IMPLEMENTED);
        boolean z = true;
        a(ColumnScope.weight$default(columnScopeInstance, ScrollKt.verticalScroll$default(companion, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), 1.0f, false, 2, null), title, info, charSequence, composerStartRestartGroup, 4672);
        Modifier modifierM309padding3ABfNKs = PaddingKt.m309padding3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), yooTheme.getDimens(composerStartRestartGroup, i2).getSpaceS());
        composerStartRestartGroup.startReplaceableGroup(-240437412);
        if ((((57344 & i) ^ 24576) <= 16384 || !composerStartRestartGroup.changed(onButtonClick)) && (i & 24576) != 16384) {
            z = false;
        }
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new f(onButtonClick);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        ButtonsKt.PrimaryButtonView(actionText, modifierM309padding3ABfNKs, false, false, (Function0) objRememberedValue, composerStartRestartGroup, (i >> 9) & 14, 12);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new g(title, info, onBack, actionText, onButtonClick, charSequence, i));
        }
    }

    public static final void a(Modifier modifier, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1810564064);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1810564064, i, -1, "ru.yoomoney.sdk.kassa.payments.contract.savePayment.TextInfoContent (SavePaymentethodScreen.kt:79)");
        }
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM727constructorimpl = Updater.m727constructorimpl(composerStartRestartGroup);
        Updater.m728setimpl(composerM727constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        b(charSequence.toString(), composerStartRestartGroup, 0);
        a(charSequence2.toString(), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2059542149);
        if (charSequence3 != null) {
            a(charSequence3.toString(), composerStartRestartGroup, 0);
        }
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new h(modifier, charSequence, charSequence2, charSequence3, i));
        }
    }
}
