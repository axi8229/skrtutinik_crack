package ru.yoomoney.sdk.guiCompose.views.informers;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.style.TextAlign;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;

/* compiled from: Informers.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\r\u001aT\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"", CrashHianalyticsData.MESSAGE, "Landroidx/compose/ui/Modifier;", "modifier", "action", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "", "enabled", "Lkotlin/Function0;", "", "onClick", "InformerAlertView", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/ui/graphics/painter/Painter;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/graphics/Color;", "tint", "Informer-V-9fs2A", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/ui/graphics/painter/Painter;ZJLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Informer", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InformersKt {
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void InformerAlertView(final java.lang.String r19, androidx.compose.ui.Modifier r20, java.lang.String r21, androidx.compose.ui.graphics.painter.Painter r22, boolean r23, kotlin.jvm.functions.Function0<kotlin.Unit> r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.guiCompose.views.informers.InformersKt.InformerAlertView(java.lang.String, androidx.compose.ui.Modifier, java.lang.String, androidx.compose.ui.graphics.painter.Painter, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Informer-V-9fs2A, reason: not valid java name */
    public static final void m3442InformerV9fs2A(final String message, final Modifier modifier, final String str, final Painter painter, final boolean z, final long j, final Function0<Unit> onClick, Composer composer, final int i) {
        int i2;
        long disable;
        Composer composer2;
        int i3;
        long disable2;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(726129474);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(726129474, i, -1, "ru.yoomoney.sdk.guiCompose.views.informers.Informer (Informers.kt:77)");
        }
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(modifier, "Informer.root"), 0.0f, 1, null);
        YooTheme yooTheme = YooTheme.INSTANCE;
        Modifier modifierM309padding3ABfNKs = PaddingKt.m309padding3ABfNKs(BackgroundKt.m165backgroundbw27NRU(modifierFillMaxWidth$default, yooTheme.getColors(composerStartRestartGroup, 6).getBackground().getDivider(), RoundedCornerShapeKt.m399RoundedCornerShape0680j_4(yooTheme.getDimens(composerStartRestartGroup, 6).getRadiusInformer())), yooTheme.getDimens(composerStartRestartGroup, 6).getSpaceM());
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        Arrangement arrangement = Arrangement.INSTANCE;
        Arrangement.Vertical top = arrangement.getTop();
        Alignment.Companion companion = Alignment.INSTANCE;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM309padding3ABfNKs);
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
        composerStartRestartGroup.startReplaceableGroup(693286680);
        Modifier.Companion companion3 = Modifier.INSTANCE;
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
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
        Updater.m728setimpl(composerM727constructorimpl2, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m728setimpl(composerM727constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
        if (composerM727constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            composerM727constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM727constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        function3ModifierMaterializerOf2.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(1751309666);
        if (painter != null) {
            Modifier modifierM313paddingqDBjuR0$default = PaddingKt.m313paddingqDBjuR0$default(companion3, 0.0f, 0.0f, yooTheme.getDimens(composerStartRestartGroup, 6).getSpaceM(), 0.0f, 11, null);
            composerStartRestartGroup.startReplaceableGroup(1751309876);
            long disable3 = z ? j : yooTheme.getColors(composerStartRestartGroup, 6).getType().getDisable();
            composerStartRestartGroup.endReplaceableGroup();
            IconKt.m648Iconww6aTOc(painter, null, modifierM313paddingqDBjuR0$default, disable3, composerStartRestartGroup, 56, 0);
            Unit unit = Unit.INSTANCE;
        }
        composerStartRestartGroup.endReplaceableGroup();
        Modifier modifierTestTag = TestTagKt.testTag(companion3, "Informer.message");
        if (z) {
            composerStartRestartGroup.startReplaceableGroup(1751310139);
            i2 = 6;
            disable = yooTheme.getColors(composerStartRestartGroup, 6).getType().getSecondary();
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            i2 = 6;
            composerStartRestartGroup.startReplaceableGroup(1751310191);
            disable = yooTheme.getColors(composerStartRestartGroup, 6).getType().getDisable();
            composerStartRestartGroup.endReplaceableGroup();
        }
        TextKt.m685Text4IGK_g(message, modifierTestTag, disable, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, yooTheme.getTypography(composerStartRestartGroup, i2).getBody(), composerStartRestartGroup, (i & 14) | 48, 0, 65528);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(-916948217);
        if (str == null || str.length() <= 0) {
            composer2 = composerStartRestartGroup;
        } else {
            Modifier modifierM313paddingqDBjuR0$default2 = PaddingKt.m313paddingqDBjuR0$default(TestTagKt.testTag(companion3, "Informer.action"), 0.0f, yooTheme.getDimens(composerStartRestartGroup, 6).getSpaceXS(), 0.0f, 0.0f, 13, null);
            composerStartRestartGroup.startReplaceableGroup(1647641448);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierAlign = columnScopeInstance.align(ClickableKt.m170clickableO2vRcR0$default(modifierM313paddingqDBjuR0$default2, (MutableInteractionSource) objRememberedValue, null, z, null, null, onClick, 24, null), companion.getEnd());
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(1647641741);
                i3 = 6;
                disable2 = yooTheme.getColors(composerStartRestartGroup, 6).getTheme().getTint();
            } else {
                i3 = 6;
                composerStartRestartGroup.startReplaceableGroup(1647641772);
                disable2 = yooTheme.getColors(composerStartRestartGroup, 6).getType().getDisable();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            TextKt.m685Text4IGK_g(str, modifierAlign, disable2, 0L, null, null, null, 0L, null, TextAlign.m2027boximpl(TextAlign.INSTANCE.m2035getEnde0LSkKk()), 0L, 0, false, 0, 0, null, yooTheme.getTypography(composerStartRestartGroup, i3).getBodyMedium(), composer2, (i >> 6) & 14, 0, 65016);
        }
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        composer2.endNode();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.informers.InformersKt$Informer$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    InformersKt.m3442InformerV9fs2A(message, modifier, str, painter, z, j, onClick, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
