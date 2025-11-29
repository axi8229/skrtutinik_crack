package ru.yoomoney.sdk.kassa.payments.tokenize.ui;

import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;
import ru.yoomoney.sdk.kassa.payments.ui.CustomDimens;
import ru.yoomoney.sdk.kassa.payments.ui.compose.ErrorStateScreenKt;
import ru.yoomoney.sdk.kassa.payments.ui.compose.LoadingStateScreenKt;
import ru.yoomoney.sdk.kassa.payments.utils.compose.BottomSheetCornersKt;

/* loaded from: classes5.dex */
public abstract class p {
    public static final void a(t state, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(1571128591);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1571128591, i2, -1, "ru.yoomoney.sdk.kassa.payments.tokenize.ui.TokenizeScreen (TokenizeScreen.kt:42)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            CustomDimens customDimens = CustomDimens.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(AnimationModifierKt.animateContentSize$default(SizeKt.wrapContentHeight$default(NestedScrollModifierKt.nestedScroll$default(BackgroundKt.m166backgroundbw27NRU$default(BottomSheetCornersKt.roundBottomSheetCorners(SizeKt.m322defaultMinSizeVpY3zN4$default(companion, 0.0f, customDimens.m3464getBottomDialogMinHeightD9Ej5fM(), 1, null), composerStartRestartGroup, 6), YooTheme.INSTANCE.getColors(composerStartRestartGroup, YooTheme.$stable).getTheme().getTintBg(), null, 2, null), NestedScrollInteropConnectionKt.rememberNestedScrollInteropConnection(null, composerStartRestartGroup, 0, 1), null, 2, null), null, false, 3, null), null, null, 3, null), 0.0f, 1, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierFillMaxWidth$default);
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
            Updater.m728setimpl(composerM727constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (state instanceof q) {
                composerStartRestartGroup.startReplaceableGroup(-1323574544);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                if (state instanceof s) {
                    composerStartRestartGroup.startReplaceableGroup(-1323574343);
                    Modifier modifierM323height3ABfNKs = SizeKt.m323height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), customDimens.m3464getBottomDialogMinHeightD9Ej5fM());
                    s sVar = (s) state;
                    ErrorStateScreenKt.ErrorStateScreen(modifierM323height3ABfNKs, 0, sVar.b, null, sVar.a, sVar.c, composerStartRestartGroup, 6, 10);
                } else if (state instanceof r) {
                    composerStartRestartGroup.startReplaceableGroup(-1323574116);
                    LoadingStateScreenKt.LoadingStateScreen(SizeKt.m323height3ABfNKs(companion, customDimens.m3464getBottomDialogMinHeightD9Ej5fM()), composerStartRestartGroup, 6, 0);
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1323574024);
                }
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new o(state, i));
        }
    }
}
