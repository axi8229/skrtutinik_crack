package ru.yoomoney.sdk.guiCompose.views.emptystates;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;
import ru.yoomoney.sdk.guiCompose.views.icons.IconLargeViewsKt;

/* compiled from: EmptyStateLargeView.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001ac\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001aK\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0003¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "action", "", "scaleIcon", "Lkotlin/Function0;", "", "onClick", "EmptyStateLargeView", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "EmptyStateLarge", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EmptyStateLargeViewKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void EmptyStateLargeView(androidx.compose.ui.Modifier r19, androidx.compose.ui.graphics.painter.Painter r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, boolean r24, kotlin.jvm.functions.Function0<kotlin.Unit> r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.guiCompose.views.emptystates.EmptyStateLargeViewKt.EmptyStateLargeView(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.painter.Painter, java.lang.String, java.lang.String, java.lang.String, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EmptyStateLarge(final Modifier modifier, final Painter painter, final String str, final String str2, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(199107141);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(199107141, i, -1, "ru.yoomoney.sdk.guiCompose.views.emptystates.EmptyStateLarge (EmptyStateLargeView.kt:88)");
        }
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(TestTagKt.testTag(modifier, "EmptyStateLargeView.root"), 0.0f, 1, null);
        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
        composerStartRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
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
        composerStartRestartGroup.startReplaceableGroup(-1519936322);
        if (painter != null) {
            IconLargeViewsKt.IconVectorFadeLargeView(painter, null, z, false, composerStartRestartGroup, ((i >> 6) & 896) | 8, 10);
        }
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(-1519936172);
        if (str != null) {
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "EmptyStateLargeView.title");
            YooTheme yooTheme = YooTheme.INSTANCE;
            TextKt.m685Text4IGK_g(str, PaddingKt.m313paddingqDBjuR0$default(modifierTestTag, yooTheme.getDimens(composerStartRestartGroup, 6).getSpaceM(), yooTheme.getDimens(composerStartRestartGroup, 6).getSpaceM(), yooTheme.getDimens(composerStartRestartGroup, 6).getSpaceM(), 0.0f, 8, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2027boximpl(TextAlign.INSTANCE.m2034getCentere0LSkKk()), 0L, 0, false, 0, 0, null, yooTheme.getTypography(composerStartRestartGroup, 6).getTitle3(), composerStartRestartGroup, 0, 0, 65020);
        }
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(-1519935666);
        if (str2 != null) {
            Modifier modifierTestTag2 = TestTagKt.testTag(Modifier.INSTANCE, "EmptyStateLargeView.subtitle");
            YooTheme yooTheme2 = YooTheme.INSTANCE;
            TextKt.m685Text4IGK_g(str2, PaddingKt.m313paddingqDBjuR0$default(modifierTestTag2, yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceM(), yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceM(), yooTheme2.getDimens(composerStartRestartGroup, 6).getSpaceM(), 0.0f, 8, null), yooTheme2.getColors(composerStartRestartGroup, 6).getType().getGhost(), 0L, null, null, null, 0L, null, TextAlign.m2027boximpl(TextAlign.INSTANCE.m2034getCentere0LSkKk()), 0L, 0, false, 0, 0, null, yooTheme2.getTypography(composerStartRestartGroup, 6).getBody(), composerStartRestartGroup, 0, 0, 65016);
        }
        composerStartRestartGroup.endReplaceableGroup();
        function2.invoke(composerStartRestartGroup, Integer.valueOf((i >> 15) & 14));
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.emptystates.EmptyStateLargeViewKt.EmptyStateLarge.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    EmptyStateLargeViewKt.EmptyStateLarge(modifier, painter, str, str2, z, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
