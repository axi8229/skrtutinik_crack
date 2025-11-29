package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui;

import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.SnackbarHostState;
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
import kotlinx.coroutines.channels.ReceiveChannel;
import ru.yoomoney.sdk.guiCompose.views.notice.NoticeCommonKt;
import ru.yoomoney.sdk.kassa.payments.ui.compose.CustomDimens;
import ru.yoomoney.sdk.kassa.payments.ui.compose.ErrorStateScreenKt;
import ru.yoomoney.sdk.kassa.payments.ui.compose.LoadingStateScreenKt;
import ru.yoomoney.sdk.kassa.payments.utils.compose.BottomSheetCornersKt;
import ru.yoomoney.sdk.marchcompose.extensions.ObservingExtensionsKt;

/* loaded from: classes5.dex */
public abstract class n {
    public static final void a(Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2128931924);
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2128931924, i, -1, "ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui.LoadingScreen (SBPConfirmationScreen.kt:76)");
            }
            Modifier modifierM323height3ABfNKs = SizeKt.m323height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), CustomDimens.INSTANCE.m3494getBottomDialogMaxHeightD9Ej5fM());
            Alignment center = Alignment.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM323height3ABfNKs);
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
            Updater.m728setimpl(composerM727constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            LoadingStateScreenKt.LoadingStateScreen(null, composerStartRestartGroup, 0, 1);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new k(i));
        }
    }

    public static final void a(q state, ReceiveChannel notices, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(notices, "notices");
        Composer composerStartRestartGroup = composer.startRestartGroup(1261058531);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1261058531, i, -1, "ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui.SBPConfirmationScreen (SBPConfirmationScreen.kt:47)");
        }
        composerStartRestartGroup.startReplaceableGroup(1600303507);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new SnackbarHostState();
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        ObservingExtensionsKt.observe(notices, new l(NoticeCommonKt.rememberNoticeService((SnackbarHostState) objRememberedValue, composerStartRestartGroup, 6), null), composerStartRestartGroup, 72);
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier modifierRoundBottomSheetCorners = BottomSheetCornersKt.roundBottomSheetCorners(AnimationModifierKt.animateContentSize$default(NestedScrollModifierKt.nestedScroll$default(companion, NestedScrollInteropConnectionKt.rememberNestedScrollInteropConnection(null, composerStartRestartGroup, 0, 1), null, 2, null), null, null, 3, null), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierRoundBottomSheetCorners);
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
        if (state instanceof p) {
            composerStartRestartGroup.startReplaceableGroup(-1302375067);
            a(composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            if (state instanceof o) {
                composerStartRestartGroup.startReplaceableGroup(-1302374888);
                Modifier modifierM323height3ABfNKs = SizeKt.m323height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), CustomDimens.INSTANCE.m3494getBottomDialogMaxHeightD9Ej5fM());
                o oVar = (o) state;
                ErrorStateScreenKt.ErrorStateScreen(modifierM323height3ABfNKs, 0, oVar.b, null, oVar.a, oVar.c, composerStartRestartGroup, 6, 10);
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1302374690);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new m(state, notices, i));
        }
    }
}
