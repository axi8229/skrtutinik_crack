package ru.yoomoney.sdk.guiCompose.views.icons;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
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
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;

/* compiled from: IconLargeViews.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a5\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a:\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/graphics/painter/Painter;", "painter", "Landroidx/compose/ui/Modifier;", "modifier", "", "scaleIcon", "enabled", "", "IconVectorFadeLargeView", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/graphics/Color;", RemoteMessageConst.Notification.COLOR, "backgroundColor", "VectorElement-eaDK9VM", "(Landroidx/compose/ui/graphics/painter/Painter;ZJJLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "VectorElement", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IconLargeViewsKt {
    public static final void IconVectorFadeLargeView(final Painter painter, Modifier modifier, boolean z, boolean z2, Composer composer, final int i, final int i2) {
        long disable;
        long actionRipple;
        Intrinsics.checkNotNullParameter(painter, "painter");
        Composer composerStartRestartGroup = composer.startRestartGroup(-48101035);
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z3 = (i2 & 4) != 0 ? false : z;
        boolean z4 = (i2 & 8) != 0 ? true : z2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-48101035, i, -1, "ru.yoomoney.sdk.guiCompose.views.icons.IconVectorFadeLargeView (IconLargeViews.kt:20)");
        }
        if (z4) {
            composerStartRestartGroup.startReplaceableGroup(-1673370065);
            disable = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getTheme().getTintFade();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1673370030);
            disable = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getType().getDisable();
        }
        composerStartRestartGroup.endReplaceableGroup();
        long j = disable;
        if (z4) {
            composerStartRestartGroup.startReplaceableGroup(-1673369960);
            actionRipple = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getTheme().getTintGhost();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-1673369918);
            actionRipple = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground().getActionRipple();
        }
        composerStartRestartGroup.endReplaceableGroup();
        m3436VectorElementeaDK9VM(painter, z3, j, actionRipple, modifier2, composerStartRestartGroup, ((i >> 3) & 112) | 8 | ((i << 9) & 57344));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final boolean z5 = z3;
            final boolean z6 = z4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.icons.IconLargeViewsKt.IconVectorFadeLargeView.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    IconLargeViewsKt.IconVectorFadeLargeView(painter, modifier3, z5, z6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: VectorElement-eaDK9VM, reason: not valid java name */
    public static final void m3436VectorElementeaDK9VM(final Painter painter, final boolean z, final long j, final long j2, final Modifier modifier, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1371820648);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1371820648, i, -1, "ru.yoomoney.sdk.guiCompose.views.icons.VectorElement (IconLargeViews.kt:69)");
        }
        YooTheme yooTheme = YooTheme.INSTANCE;
        Modifier modifierM165backgroundbw27NRU = BackgroundKt.m165backgroundbw27NRU(SizeKt.m330size3ABfNKs(modifier, yooTheme.getDimens(composerStartRestartGroup, 6).getIconViewLargeSize()), j2, RoundedCornerShapeKt.getCircleShape());
        composerStartRestartGroup.startReplaceableGroup(733328855);
        Alignment.Companion companion = Alignment.INSTANCE;
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM165backgroundbw27NRU);
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
        Modifier modifierM330size3ABfNKs = Modifier.INSTANCE;
        Modifier modifierAlign = boxScopeInstance.align(modifierM330size3ABfNKs, companion.getCenter());
        composerStartRestartGroup.startReplaceableGroup(-1771492529);
        if (z) {
            modifierM330size3ABfNKs = SizeKt.m330size3ABfNKs(modifierM330size3ABfNKs, yooTheme.getDimens(composerStartRestartGroup, 6).getIconViewLargeIconSize());
        }
        composerStartRestartGroup.endReplaceableGroup();
        IconKt.m648Iconww6aTOc(painter, null, modifierAlign.then(modifierM330size3ABfNKs), j, composerStartRestartGroup, ((i << 3) & 7168) | 56, 0);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.icons.IconLargeViewsKt$VectorElement$2
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
                    IconLargeViewsKt.m3436VectorElementeaDK9VM(painter, z, j, j2, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
