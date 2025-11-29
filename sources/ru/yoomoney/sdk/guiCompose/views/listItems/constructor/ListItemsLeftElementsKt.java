package ru.yoomoney.sdk.guiCompose.views.listItems.constructor;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.views.icons.IconViewsKt;
import ru.yoomoney.sdk.guiCompose.views.listItems.constructor.LeftElement;

/* compiled from: ListItemsLeftElements.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"View", "", "Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement;", "enabled", "", "(Lru/yoomoney/sdk/guiCompose/views/listItems/constructor/LeftElement;ZLandroidx/compose/runtime/Composer;I)V", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ListItemsLeftElementsKt {
    public static final void View(final LeftElement leftElement, final boolean z, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(leftElement, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(2070685103);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(leftElement) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2070685103, i2, -1, "ru.yoomoney.sdk.guiCompose.views.listItems.constructor.View (ListItemsLeftElements.kt:13)");
            }
            if (leftElement instanceof LeftElement.Image) {
                composerStartRestartGroup.startReplaceableGroup(-2120928050);
                IconViewsKt.IconImageView(((LeftElement.Image) leftElement).getPainter(), null, z, composerStartRestartGroup, ((i2 << 3) & 896) | 8, 2);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (leftElement instanceof LeftElement.ImageRound) {
                composerStartRestartGroup.startReplaceableGroup(-2120927961);
                IconViewsKt.IconImageRoundView(((LeftElement.ImageRound) leftElement).getPainter(), null, z, composerStartRestartGroup, ((i2 << 3) & 896) | 8, 2);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (leftElement instanceof LeftElement.Vector) {
                composerStartRestartGroup.startReplaceableGroup(-2120927871);
                IconViewsKt.IconVectorView(((LeftElement.Vector) leftElement).getPainter(), null, z, composerStartRestartGroup, ((i2 << 3) & 896) | 8, 2);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (leftElement instanceof LeftElement.VectorFade) {
                composerStartRestartGroup.startReplaceableGroup(-2120927781);
                IconViewsKt.IconVectorFadeView(((LeftElement.VectorFade) leftElement).getPainter(), null, z, composerStartRestartGroup, ((i2 << 3) & 896) | 8, 2);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (leftElement instanceof LeftElement.VectorPrimary) {
                composerStartRestartGroup.startReplaceableGroup(-2120927684);
                IconViewsKt.IconVectorPrimaryView(((LeftElement.VectorPrimary) leftElement).getPainter(), null, z, composerStartRestartGroup, ((i2 << 3) & 896) | 8, 2);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (leftElement instanceof LeftElement.Value) {
                composerStartRestartGroup.startReplaceableGroup(-2120927592);
                IconViewsKt.IconValueView(((LeftElement.Value) leftElement).getText(), null, z, composerStartRestartGroup, (i2 << 3) & 896, 2);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (leftElement instanceof LeftElement.ValueFade) {
                composerStartRestartGroup.startReplaceableGroup(-2120927510);
                IconViewsKt.IconValueFadeView(((LeftElement.ValueFade) leftElement).getText(), null, z, composerStartRestartGroup, (i2 << 3) & 896, 2);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (leftElement instanceof LeftElement.ValuePrimary) {
                composerStartRestartGroup.startReplaceableGroup(-2120927421);
                IconViewsKt.IconValuePrimaryView(((LeftElement.ValuePrimary) leftElement).getText(), null, z, composerStartRestartGroup, (i2 << 3) & 896, 2);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-2120927363);
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.listItems.constructor.ListItemsLeftElementsKt.View.1
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
                    ListItemsLeftElementsKt.View(leftElement, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
