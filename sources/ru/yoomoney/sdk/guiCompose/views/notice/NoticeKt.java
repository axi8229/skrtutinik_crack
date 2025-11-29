package ru.yoomoney.sdk.guiCompose.views.notice;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.SnackbarData;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;

/* compiled from: Notice.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0006\u0010\u0004\u001a2\u0010\r\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010²\u0006\u000e\u0010\u000f\u001a\u00020\u000e8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/material/SnackbarData;", RemoteMessageConst.DATA, "", "NoticeSuccessView", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/runtime/Composer;I)V", "NoticeAlertView", "NoticeNormalView", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "actionColor", "textColor", "Notice-EtIuwbw", "(Landroidx/compose/material/SnackbarData;JJJLandroidx/compose/runtime/Composer;I)V", "Notice", "", "actionOnNewLine", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NoticeKt {
    public static final void NoticeSuccessView(final SnackbarData data, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1740154550);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1740154550, i, -1, "ru.yoomoney.sdk.guiCompose.views.notice.NoticeSuccessView (Notice.kt:38)");
        }
        YooTheme yooTheme = YooTheme.INSTANCE;
        m3452NoticeEtIuwbw(data, yooTheme.getColors(composerStartRestartGroup, 6).getBackground().getSuccess(), Color.m975copywmQWz5c$default(yooTheme.getColors(composerStartRestartGroup, 6).getType().getInverse(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), yooTheme.getColors(composerStartRestartGroup, 6).getType().getInverse(), composerStartRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.notice.NoticeKt.NoticeSuccessView.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    NoticeKt.NoticeSuccessView(data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void NoticeAlertView(final SnackbarData data, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(1785754621);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1785754621, i, -1, "ru.yoomoney.sdk.guiCompose.views.notice.NoticeAlertView (Notice.kt:46)");
        }
        YooTheme yooTheme = YooTheme.INSTANCE;
        m3452NoticeEtIuwbw(data, yooTheme.getColors(composerStartRestartGroup, 6).getBackground().getAlert(), Color.m975copywmQWz5c$default(yooTheme.getColors(composerStartRestartGroup, 6).getType().getInverse(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), yooTheme.getColors(composerStartRestartGroup, 6).getType().getInverse(), composerStartRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.notice.NoticeKt.NoticeAlertView.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    NoticeKt.NoticeAlertView(data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void NoticeNormalView(final SnackbarData data, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1879349434);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1879349434, i, -1, "ru.yoomoney.sdk.guiCompose.views.notice.NoticeNormalView (Notice.kt:54)");
        }
        YooTheme yooTheme = YooTheme.INSTANCE;
        m3452NoticeEtIuwbw(data, yooTheme.getColors(composerStartRestartGroup, 6).getTheme().getTintFade(), Color.m975copywmQWz5c$default(yooTheme.getColors(composerStartRestartGroup, 6).getType().getInverse(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), yooTheme.getColors(composerStartRestartGroup, 6).getType().getInverse(), composerStartRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.notice.NoticeKt.NoticeNormalView.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    NoticeKt.NoticeNormalView(data, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Notice-EtIuwbw, reason: not valid java name */
    public static final void m3452NoticeEtIuwbw(final SnackbarData snackbarData, final long j, final long j2, final long j3, Composer composer, final int i) {
        String str;
        YooTheme yooTheme;
        Composer composerStartRestartGroup = composer.startRestartGroup(1883473495);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1883473495, i, -1, "ru.yoomoney.sdk.guiCompose.views.notice.Notice (Notice.kt:67)");
        }
        composerStartRestartGroup.startReplaceableGroup(-1579936934);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        composerStartRestartGroup.endReplaceableGroup();
        String actionLabel = snackbarData.getActionLabel();
        boolean z = actionLabel == null || actionLabel.length() == 0;
        Modifier.Companion companion2 = Modifier.INSTANCE;
        Modifier modifierTestTag = TestTagKt.testTag(companion2, "Notice.root");
        YooTheme yooTheme2 = YooTheme.INSTANCE;
        Modifier modifierM166backgroundbw27NRU$default = BackgroundKt.m166backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(PaddingKt.m313paddingqDBjuR0$default(modifierTestTag, yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceM(), 0.0f, yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceM(), yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceM(), 2, null), 0.0f, 1, null), RoundedCornerShapeKt.m399RoundedCornerShape0680j_4(yooTheme2.getDimens(composerStartRestartGroup, 6).getRadiusNotice())), j, null, 2, null);
        Arrangement arrangement = Arrangement.INSTANCE;
        Arrangement.HorizontalOrVertical center = arrangement.getCenter();
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        Alignment.Companion companion3 = Alignment.INSTANCE;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, companion3.getStart(), composerStartRestartGroup, 6);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion4.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM166backgroundbw27NRU$default);
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
        Updater.m728setimpl(composerM727constructorimpl, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
        Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
        if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        Alignment.Vertical centerVertically = companion3.getCenterVertically();
        composerStartRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
        if (composerStartRestartGroup.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor2);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM727constructorimpl2 = Updater.m727constructorimpl(composerStartRestartGroup);
        Updater.m728setimpl(composerM727constructorimpl2, measurePolicyRowMeasurePolicy, companion4.getSetMeasurePolicy());
        Updater.m728setimpl(composerM727constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
        if (composerM727constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            composerM727constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM727constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        function3ModifierMaterializerOf2.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        String message = snackbarData.getMessage();
        Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, TestTagKt.testTag(companion2, "Notice.message"), 1.0f, false, 2, null);
        float spaceXL = yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceXL();
        float spaceS = yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceS();
        composerStartRestartGroup.startReplaceableGroup(-1377012011);
        float spaceXL2 = (Notice_EtIuwbw$lambda$1(mutableState) || z) ? yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceXL() : Dp.m2102constructorimpl(0);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(-1377011908);
        float spaceS2 = (!Notice_EtIuwbw$lambda$1(mutableState) || z) ? yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceS() : Dp.m2102constructorimpl(0);
        composerStartRestartGroup.endReplaceableGroup();
        Modifier modifierM312paddingqDBjuR0 = PaddingKt.m312paddingqDBjuR0(modifierWeight$default, spaceXL, spaceS, spaceXL2, spaceS2);
        TextOverflow.Companion companion5 = TextOverflow.INSTANCE;
        int iM2070getEllipsisgIe3tQ8 = companion5.m2070getEllipsisgIe3tQ8();
        composerStartRestartGroup.startReplaceableGroup(-1377011632);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function1<TextLayoutResult, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.notice.NoticeKt$Notice$1$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                    invoke2(textLayoutResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextLayoutResult it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.getLineCount() > 1) {
                        NoticeKt.Notice_EtIuwbw$lambda$2(mutableState, true);
                    }
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        composerStartRestartGroup.endReplaceableGroup();
        TextKt.m685Text4IGK_g(message, modifierM312paddingqDBjuR0, j3, 0L, null, null, null, 0L, null, null, 0L, iM2070getEllipsisgIe3tQ8, false, 3, 0, (Function1) objRememberedValue2, yooTheme2.getTypography(composerStartRestartGroup, 6).getBody(), composerStartRestartGroup, (i >> 3) & 896, 199728, 22520);
        composerStartRestartGroup.startReplaceableGroup(-1512587860);
        if (Notice_EtIuwbw$lambda$1(mutableState) || z) {
            str = "Notice.actionLabel";
            yooTheme = yooTheme2;
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1377011325);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM312paddingqDBjuR02 = PaddingKt.m312paddingqDBjuR0(ClickableKt.m170clickableO2vRcR0$default(companion2, (MutableInteractionSource) objRememberedValue3, null, false, null, null, new NoticeKt$Notice$1$1$3(snackbarData), 28, null), yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceS(), yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceS(), yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceXL(), yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceS());
            Alignment center2 = companion3.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierM312paddingqDBjuR02);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM727constructorimpl3 = Updater.m727constructorimpl(composerStartRestartGroup);
            Updater.m728setimpl(composerM727constructorimpl3, measurePolicyRememberBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m728setimpl(composerM727constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
            if (composerM727constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM727constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM727constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            function3ModifierMaterializerOf3.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            String actionLabel2 = snackbarData.getActionLabel();
            if (actionLabel2 == null) {
                actionLabel2 = "";
            }
            yooTheme = yooTheme2;
            str = "Notice.actionLabel";
            TextKt.m685Text4IGK_g(actionLabel2, TestTagKt.testTag(companion2, "Notice.actionLabel"), j2, 0L, null, null, null, 0L, null, null, 0L, companion5.m2070getEllipsisgIe3tQ8(), false, 1, 0, null, yooTheme2.getTypography(composerStartRestartGroup, 6).getCaption1Medium(), composerStartRestartGroup, (i & 896) | 48, 3120, 55288);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        }
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(-1579934290);
        if (Notice_EtIuwbw$lambda$1(mutableState) && !z) {
            composerStartRestartGroup.startReplaceableGroup(-1512586508);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            YooTheme yooTheme3 = yooTheme;
            Modifier modifierAlign = columnScopeInstance.align(PaddingKt.m310paddingVpY3zN4(ClickableKt.m170clickableO2vRcR0$default(companion2, (MutableInteractionSource) objRememberedValue4, null, false, null, null, new NoticeKt$Notice$1$3(snackbarData), 28, null), yooTheme3.getDimens(composerStartRestartGroup, 6).getSpaceXL(), yooTheme3.getDimens(composerStartRestartGroup, 6).getSpaceS()), companion3.getEnd());
            Alignment center3 = companion3.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center3, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor4 = companion4.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(modifierAlign);
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM727constructorimpl4 = Updater.m727constructorimpl(composerStartRestartGroup);
            Updater.m728setimpl(composerM727constructorimpl4, measurePolicyRememberBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m728setimpl(composerM727constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion4.getSetCompositeKeyHash();
            if (composerM727constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composerM727constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM727constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            function3ModifierMaterializerOf4.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            String actionLabel3 = snackbarData.getActionLabel();
            TextKt.m685Text4IGK_g(actionLabel3 == null ? "" : actionLabel3, TestTagKt.testTag(companion2, str), j2, 0L, null, null, null, 0L, null, null, 0L, companion5.m2070getEllipsisgIe3tQ8(), false, 1, 0, null, yooTheme3.getTypography(composerStartRestartGroup, 6).getCaption1Medium(), composerStartRestartGroup, (i & 896) | 48, 3120, 55288);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.notice.NoticeKt$Notice$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    NoticeKt.m3452NoticeEtIuwbw(snackbarData, j, j2, j3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Notice_EtIuwbw$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean Notice_EtIuwbw$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }
}
