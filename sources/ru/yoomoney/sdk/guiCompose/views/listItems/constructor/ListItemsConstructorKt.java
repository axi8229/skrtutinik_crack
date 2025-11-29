package ru.yoomoney.sdk.guiCompose.views.listItems.constructor;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;
import ru.yoomoney.sdk.guiCompose.views.listItems.constructor.ContentElement;
import ru.yoomoney.sdk.guiCompose.views.listItems.constructor.RightElement;

/* compiled from: ListItemsConstructor.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a]\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a/\u0010\u0011\u001a\u00020\f*\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0011\u0010\u0012\u001a3\u0010\u0016\u001a\u00020\f*\u00020\u00132\u0006\u0010\u0001\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a²\u0006\u000e\u0010\u0019\u001a\u00020\u00188\n@\nX\u008a\u008e\u0002"}, d2 = {"Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/ContentElement;", "contentElement", "Landroidx/compose/ui/Modifier;", "modifier", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement;", "leftElement", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement;", "rightElement", "", "enabled", "hasDivider", "Lkotlin/Function0;", "", "onClick", "ListItem", "(Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/ContentElement;Landroidx/compose/ui/Modifier;Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement;Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement;ZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/BoxScope;", "Content", "(Landroidx/compose/foundation/layout/BoxScope;Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/ContentElement;Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement;ZLandroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/ContentElement$Large;", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement$Detail;", "LargeDetailContent", "(Landroidx/compose/foundation/layout/RowScope;Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/ContentElement$Large;Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/RightElement$Detail;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;I)V", "", "textMaxWidth", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ListItemsConstructorKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void ListItem(final ru.yoomoney.sdk.guiCompose.views.listItems.constructor.ContentElement r20, androidx.compose.ui.Modifier r21, ru.yoomoney.sdk.guiCompose.views.listItems.constructor.LeftElement r22, ru.yoomoney.sdk.guiCompose.views.listItems.constructor.RightElement r23, boolean r24, boolean r25, kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.guiCompose.views.listItems.constructor.ListItemsConstructorKt.ListItem(ru.yoomoney.sdk.guiCompose.views.listItems.constructor.ContentElement, androidx.compose.ui.Modifier, ru.yoomoney.sdk.guiCompose.views.listItems.constructor.LeftElement, ru.yoomoney.sdk.guiCompose.views.listItems.constructor.RightElement, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float Content$lambda$1(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0269  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Content(final androidx.compose.foundation.layout.BoxScope r22, final ru.yoomoney.sdk.guiCompose.views.listItems.constructor.ContentElement r23, ru.yoomoney.sdk.guiCompose.views.listItems.constructor.RightElement r24, final boolean r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 721
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.guiCompose.views.listItems.constructor.ListItemsConstructorKt.Content(androidx.compose.foundation.layout.BoxScope, ru.yoomoney.sdk.guiCompose.views.listItems.constructor.ContentElement, ru.yoomoney.sdk.guiCompose.views.listItems.constructor.RightElement, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Content$lambda$2(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LargeDetailContent(final RowScope rowScope, final ContentElement.Large large, final RightElement.Detail detail, final Modifier modifier, final boolean z, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(692119467);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(large) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(detail) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((46811 & i2) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(692119467, i2, -1, "ru.yoomoney.sdk.guiCompose.views.listItems.constructor.LargeDetailContent (ListItemsConstructor.kt:169)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierAlpha = AlphaKt.alpha(RowScope.weight$default(rowScope, companion, 1.0f, false, 2, null), z ? 1.0f : 0.3f);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM293spacedBy0680j_4 = arrangement.m293spacedBy0680j_4(YooTheme.INSTANCE.getDimens(composerStartRestartGroup, 6).getSpace3XS());
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM293spacedBy0680j_4, companion2.getStart(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierAlpha);
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
            Updater.m728setimpl(composerM727constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
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
            Updater.m728setimpl(composerM727constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m728setimpl(composerM727constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (composerM727constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM727constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM727constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            function3ModifierMaterializerOf2.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ListItemsCommonKt.m3444ListItemTitleTextSj8uqqQ(large.getTitle(), RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), large.getTitleType(), null, true, composerStartRestartGroup, 24576, 8);
            int i3 = (i2 >> 6) & 112;
            ListItemsCommonKt.m3444ListItemTitleTextSj8uqqQ(detail.getValue(), modifier, null, null, false, composerStartRestartGroup, i3, 28);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion);
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
            Updater.m728setimpl(composerM727constructorimpl3, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m728setimpl(composerM727constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (composerM727constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM727constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM727constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            function3ModifierMaterializerOf3.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ListItemsCommonKt.m3443ListItemSubtitleTextSj8uqqQ(large.getSubtitle(), RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), null, null, true, composerStartRestartGroup, 24576, 12);
            String subvalue = detail.getSubvalue();
            composerStartRestartGroup.startReplaceableGroup(-450771584);
            if (subvalue != null) {
                ListItemsCommonKt.m3443ListItemSubtitleTextSj8uqqQ(detail.getSubvalue(), modifier, null, null, false, composerStartRestartGroup, i3, 28);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.listItems.constructor.ListItemsConstructorKt.LargeDetailContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ListItemsConstructorKt.LargeDetailContent(rowScope, large, detail, modifier, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
