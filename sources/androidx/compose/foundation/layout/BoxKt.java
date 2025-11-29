package androidx.compose.foundation.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Box.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a3\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u000b\u0010\f\u001aC\u0010\u0018\u001a\u00020\u0017*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\"0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f\"0\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001f\"\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"\"\u001a\u0010#\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010\"\u001a\u0004\b$\u0010%\"\u001a\u0010)\u001a\u0004\u0018\u00010&*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\"\u0018\u0010,\u001a\u00020\u0000*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"", "propagateMinConstraints", "Ljava/util/HashMap;", "Landroidx/compose/ui/Alignment;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Lkotlin/collections/HashMap;", "cacheFor", "(Z)Ljava/util/HashMap;", "alignment", "maybeCachedBoxMeasurePolicy", "(Landroidx/compose/ui/Alignment;Z)Landroidx/compose/ui/layout/MeasurePolicy;", "rememberBoxMeasurePolicy", "(Landroidx/compose/ui/Alignment;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/layout/Placeable;", "placeable", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "", "boxWidth", "boxHeight", "", "placeInBox", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/unit/LayoutDirection;IILandroidx/compose/ui/Alignment;)V", "Landroidx/compose/ui/Modifier;", "modifier", "Box", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "cache1", "Ljava/util/HashMap;", "cache2", "DefaultBoxMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "EmptyBoxMeasurePolicy", "getEmptyBoxMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/foundation/layout/BoxChildDataNode;", "getBoxChildDataNode", "(Landroidx/compose/ui/layout/Measurable;)Landroidx/compose/foundation/layout/BoxChildDataNode;", "boxChildDataNode", "getMatchesParentSize", "(Landroidx/compose/ui/layout/Measurable;)Z", "matchesParentSize", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BoxKt {
    private static final HashMap<Alignment, MeasurePolicy> cache1 = cacheFor(true);
    private static final HashMap<Alignment, MeasurePolicy> cache2 = cacheFor(false);
    private static final MeasurePolicy DefaultBoxMeasurePolicy = new BoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
    private static final MeasurePolicy EmptyBoxMeasurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.BoxKt$EmptyBoxMeasurePolicy$1
        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* renamed from: measure-3p2s80s */
        public final MeasureResult mo87measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
            return MeasureScope.layout$default(measureScope, Constraints.m2086getMinWidthimpl(j), Constraints.m2085getMinHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$EmptyBoxMeasurePolicy$1.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }, 4, null);
        }
    };

    private static final HashMap<Alignment, MeasurePolicy> cacheFor(boolean z) {
        HashMap<Alignment, MeasurePolicy> map = new HashMap<>(9);
        Alignment.Companion companion = Alignment.INSTANCE;
        cacheFor$lambda$1$putAlignment(map, z, companion.getTopStart());
        cacheFor$lambda$1$putAlignment(map, z, companion.getTopCenter());
        cacheFor$lambda$1$putAlignment(map, z, companion.getTopEnd());
        cacheFor$lambda$1$putAlignment(map, z, companion.getCenterStart());
        cacheFor$lambda$1$putAlignment(map, z, companion.getCenter());
        cacheFor$lambda$1$putAlignment(map, z, companion.getCenterEnd());
        cacheFor$lambda$1$putAlignment(map, z, companion.getBottomStart());
        cacheFor$lambda$1$putAlignment(map, z, companion.getBottomCenter());
        cacheFor$lambda$1$putAlignment(map, z, companion.getBottomEnd());
        return map;
    }

    private static final void cacheFor$lambda$1$putAlignment(HashMap<Alignment, MeasurePolicy> map, boolean z, Alignment alignment) {
        map.put(alignment, new BoxMeasurePolicy(alignment, z));
    }

    public static final MeasurePolicy maybeCachedBoxMeasurePolicy(Alignment alignment, boolean z) {
        MeasurePolicy measurePolicy = (z ? cache1 : cache2).get(alignment);
        return measurePolicy == null ? new BoxMeasurePolicy(alignment, z) : measurePolicy;
    }

    public static final MeasurePolicy rememberBoxMeasurePolicy(Alignment alignment, boolean z, Composer composer, int i) {
        MeasurePolicy measurePolicy;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(56522820, i, -1, "androidx.compose.foundation.layout.rememberBoxMeasurePolicy (Box.kt:113)");
        }
        if (Intrinsics.areEqual(alignment, Alignment.INSTANCE.getTopStart()) && !z) {
            composer.startReplaceGroup(-1710139705);
            composer.endReplaceGroup();
            measurePolicy = DefaultBoxMeasurePolicy;
        } else {
            composer.startReplaceGroup(-1710100211);
            boolean z2 = ((((i & 14) ^ 6) > 4 && composer.changed(alignment)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(z)) || (i & 48) == 32);
            Object objRememberedValue = composer.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new BoxMeasurePolicy(alignment, z);
                composer.updateRememberedValue(objRememberedValue);
            }
            measurePolicy = (BoxMeasurePolicy) objRememberedValue;
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return measurePolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeInBox(Placeable.PlacementScope placementScope, Placeable placeable, Measurable measurable, LayoutDirection layoutDirection, int i, int i2, Alignment alignment) {
        Alignment alignment2;
        BoxChildDataNode boxChildDataNode = getBoxChildDataNode(measurable);
        Placeable.PlacementScope.m1444place70tqf50$default(placementScope, placeable, ((boxChildDataNode == null || (alignment2 = boxChildDataNode.getAlignment()) == null) ? alignment : alignment2).mo752alignKFBX0sM(IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight()), IntSizeKt.IntSize(i, i2), layoutDirection), 0.0f, 2, null);
    }

    public static final void Box(final Modifier modifier, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-211209833);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-211209833, i2, -1, "androidx.compose.foundation.layout.Box (Box.kt:236)");
            }
            MeasurePolicy measurePolicy = EmptyBoxMeasurePolicy;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            Updater.m728setimpl(composerM727constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Updater.m728setimpl(composerM727constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt.Box.2
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
                    BoxKt.Box(modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final BoxChildDataNode getBoxChildDataNode(Measurable measurable) {
        Object parentData = measurable.getParentData();
        if (parentData instanceof BoxChildDataNode) {
            return (BoxChildDataNode) parentData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getMatchesParentSize(Measurable measurable) {
        BoxChildDataNode boxChildDataNode = getBoxChildDataNode(measurable);
        if (boxChildDataNode != null) {
            return boxChildDataNode.getMatchParentSize();
        }
        return false;
    }
}
