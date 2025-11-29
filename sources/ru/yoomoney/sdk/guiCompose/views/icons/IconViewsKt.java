package ru.yoomoney.sdk.guiCompose.views.icons;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
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

/* compiled from: IconViews.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u001a+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a+\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\b\u001a+\u0010\n\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\b\u001a+\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\b\u001a+\u0010\f\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\b\u001a+\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0010\u001a+\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0010\u001a2\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a2\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/graphics/painter/Painter;", "painter", "Landroidx/compose/ui/Modifier;", "modifier", "", "enabled", "", "IconImageView", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "IconImageRoundView", "IconVectorView", "IconVectorFadeView", "IconVectorPrimaryView", "", "text", "IconValueView", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "IconValueFadeView", "IconValuePrimaryView", "Landroidx/compose/ui/graphics/Color;", RemoteMessageConst.Notification.COLOR, "backgroundColor", "VectorElement-RIQooxk", "(Landroidx/compose/ui/graphics/painter/Painter;JJLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "VectorElement", "ValueElement-RIQooxk", "(Ljava/lang/String;JJLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "ValueElement", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IconViewsKt {
    public static final void IconImageView(final Painter painter, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(painter, "painter");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2004122499);
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2004122499, i, -1, "ru.yoomoney.sdk.guiCompose.views.icons.IconImageView (IconViews.kt:27)");
        }
        ImageKt.Image(painter, null, SizeKt.m330size3ABfNKs(modifier2, YooTheme.INSTANCE.getDimens(composerStartRestartGroup, 6).getIconViewMediumSize()), null, ContentScale.INSTANCE.getInside(), z2 ? 1.0f : 0.3f, null, composerStartRestartGroup, 24632, 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final boolean z3 = z2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.icons.IconViewsKt.IconImageView.1
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
                    IconViewsKt.IconImageView(painter, modifier3, z3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final void IconImageRoundView(final Painter painter, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(painter, "painter");
        Composer composerStartRestartGroup = composer.startRestartGroup(289342647);
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(289342647, i, -1, "ru.yoomoney.sdk.guiCompose.views.icons.IconImageRoundView (IconViews.kt:42)");
        }
        ImageKt.Image(painter, null, ClipKt.clip(SizeKt.m330size3ABfNKs(modifier2, YooTheme.INSTANCE.getDimens(composerStartRestartGroup, 6).getIconViewMediumSize()), RoundedCornerShapeKt.getCircleShape()), null, ContentScale.INSTANCE.getCrop(), z2 ? 1.0f : 0.3f, null, composerStartRestartGroup, 24632, 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final boolean z3 = z2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.icons.IconViewsKt.IconImageRoundView.1
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
                    IconViewsKt.IconImageRoundView(painter, modifier3, z3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final void IconVectorView(final Painter painter, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        long disable;
        Intrinsics.checkNotNullParameter(painter, "painter");
        Composer composerStartRestartGroup = composer.startRestartGroup(2134509287);
        if ((i2 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2134509287, i, -1, "ru.yoomoney.sdk.guiCompose.views.icons.IconVectorView (IconViews.kt:59)");
        }
        if (z) {
            composerStartRestartGroup.startReplaceableGroup(-198032495);
            disable = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getTheme().getTint();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-198032464);
            disable = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getType().getDisable();
        }
        composerStartRestartGroup.endReplaceableGroup();
        m3439VectorElementRIQooxk(painter, disable, Color.INSTANCE.m989getTransparent0d7_KjU(), modifier, composerStartRestartGroup, ((i << 6) & 7168) | 392);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier2 = modifier;
            final boolean z2 = z;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.icons.IconViewsKt.IconVectorView.1
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
                    IconViewsKt.IconVectorView(painter, modifier2, z2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final void IconVectorFadeView(final Painter painter, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        long disable;
        long actionRipple;
        Intrinsics.checkNotNullParameter(painter, "painter");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1151787573);
        if ((i2 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1151787573, i, -1, "ru.yoomoney.sdk.guiCompose.views.icons.IconVectorFadeView (IconViews.kt:101)");
        }
        if (z) {
            composerStartRestartGroup.startReplaceableGroup(175235608);
            disable = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getTheme().getTintFade();
        } else {
            composerStartRestartGroup.startReplaceableGroup(175235643);
            disable = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getType().getDisable();
        }
        composerStartRestartGroup.endReplaceableGroup();
        long j = disable;
        if (z) {
            composerStartRestartGroup.startReplaceableGroup(175235713);
            actionRipple = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getTheme().getTintGhost();
        } else {
            composerStartRestartGroup.startReplaceableGroup(175235755);
            actionRipple = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground().getActionRipple();
        }
        composerStartRestartGroup.endReplaceableGroup();
        m3439VectorElementRIQooxk(painter, j, actionRipple, modifier, composerStartRestartGroup, ((i << 6) & 7168) | 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier2 = modifier;
            final boolean z2 = z;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.icons.IconViewsKt.IconVectorFadeView.1
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
                    IconViewsKt.IconVectorFadeView(painter, modifier2, z2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final void IconVectorPrimaryView(final Painter painter, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        long disable;
        long actionRipple;
        Intrinsics.checkNotNullParameter(painter, "painter");
        Composer composerStartRestartGroup = composer.startRestartGroup(181663513);
        if ((i2 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(181663513, i, -1, "ru.yoomoney.sdk.guiCompose.views.icons.IconVectorPrimaryView (IconViews.kt:115)");
        }
        if (z) {
            composerStartRestartGroup.startReplaceableGroup(-2139356218);
            disable = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getType().getInverse();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-2139356184);
            disable = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getType().getDisable();
        }
        composerStartRestartGroup.endReplaceableGroup();
        long j = disable;
        if (z) {
            composerStartRestartGroup.startReplaceableGroup(-2139356114);
            actionRipple = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getTheme().getTint();
        } else {
            composerStartRestartGroup.startReplaceableGroup(-2139356077);
            actionRipple = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground().getActionRipple();
        }
        composerStartRestartGroup.endReplaceableGroup();
        m3439VectorElementRIQooxk(painter, j, actionRipple, modifier, composerStartRestartGroup, ((i << 6) & 7168) | 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier2 = modifier;
            final boolean z2 = z;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.icons.IconViewsKt.IconVectorPrimaryView.1
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
                    IconViewsKt.IconVectorPrimaryView(painter, modifier2, z2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final void IconValueView(final String text, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        long disable;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(605252367);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                z = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(605252367, i3, -1, "ru.yoomoney.sdk.guiCompose.views.icons.IconValueView (IconViews.kt:143)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(-899687405);
                disable = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getTheme().getTint();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-899687374);
                disable = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getType().getDisable();
            }
            composerStartRestartGroup.endReplaceableGroup();
            m3438ValueElementRIQooxk(text, disable, Color.INSTANCE.m989getTransparent0d7_KjU(), modifier, composerStartRestartGroup, (i3 & 14) | 384 | ((i3 << 6) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        final boolean z2 = z;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.icons.IconViewsKt.IconValueView.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    IconViewsKt.IconValueView(text, modifier2, z2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final void IconValueFadeView(final String text, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        long disable;
        long actionRipple;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1416673365);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                z = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1416673365, i3, -1, "ru.yoomoney.sdk.guiCompose.views.icons.IconValueFadeView (IconViews.kt:157)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(-403232061);
                disable = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getTheme().getTintFade();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-403232026);
                disable = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getType().getDisable();
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(-403231956);
                actionRipple = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getTheme().getTintGhost();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-403231914);
                actionRipple = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground().getActionRipple();
            }
            composerStartRestartGroup.endReplaceableGroup();
            m3438ValueElementRIQooxk(text, disable, actionRipple, modifier, composerStartRestartGroup, (i3 & 14) | ((i3 << 6) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        final boolean z2 = z;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.icons.IconViewsKt.IconValueFadeView.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    IconViewsKt.IconValueFadeView(text, modifier2, z2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final void IconValuePrimaryView(final String text, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        long disable;
        long actionRipple;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer composerStartRestartGroup = composer.startRestartGroup(1548450333);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i5 != 0) {
                z = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1548450333, i3, -1, "ru.yoomoney.sdk.guiCompose.views.icons.IconValuePrimaryView (IconViews.kt:171)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(386858289);
                disable = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getType().getInverse();
            } else {
                composerStartRestartGroup.startReplaceableGroup(386858323);
                disable = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getType().getDisable();
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (z) {
                composerStartRestartGroup.startReplaceableGroup(386858393);
                actionRipple = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getTheme().getTint();
            } else {
                composerStartRestartGroup.startReplaceableGroup(386858430);
                actionRipple = YooTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getBackground().getActionRipple();
            }
            composerStartRestartGroup.endReplaceableGroup();
            m3438ValueElementRIQooxk(text, disable, actionRipple, modifier, composerStartRestartGroup, (i3 & 14) | ((i3 << 6) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        final boolean z2 = z;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.icons.IconViewsKt.IconValuePrimaryView.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    IconViewsKt.IconValuePrimaryView(text, modifier2, z2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: VectorElement-RIQooxk, reason: not valid java name */
    public static final void m3439VectorElementRIQooxk(final Painter painter, final long j, final long j2, final Modifier modifier, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-206434015);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-206434015, i, -1, "ru.yoomoney.sdk.guiCompose.views.icons.VectorElement (IconViews.kt:227)");
        }
        Modifier modifierM165backgroundbw27NRU = BackgroundKt.m165backgroundbw27NRU(SizeKt.m330size3ABfNKs(modifier, YooTheme.INSTANCE.getDimens(composerStartRestartGroup, 6).getIconViewMediumSize()), j2, RoundedCornerShapeKt.getCircleShape());
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
        IconKt.m648Iconww6aTOc(painter, null, BoxScopeInstance.INSTANCE.align(Modifier.INSTANCE, companion.getCenter()), j, composerStartRestartGroup, ((i << 6) & 7168) | 56, 0);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.icons.IconViewsKt$VectorElement$2
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
                    IconViewsKt.m3439VectorElementRIQooxk(painter, j, j2, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ValueElement-RIQooxk, reason: not valid java name */
    public static final void m3438ValueElementRIQooxk(final String str, final long j, final long j2, final Modifier modifier, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1797482543);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1797482543, i2, -1, "ru.yoomoney.sdk.guiCompose.views.icons.ValueElement (IconViews.kt:248)");
            }
            YooTheme yooTheme = YooTheme.INSTANCE;
            Modifier modifierM165backgroundbw27NRU = BackgroundKt.m165backgroundbw27NRU(SizeKt.m330size3ABfNKs(modifier, yooTheme.getDimens(composerStartRestartGroup, 6).getIconViewMediumSize()), j2, RoundedCornerShapeKt.getCircleShape());
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
            TextKt.m685Text4IGK_g(str, BoxScopeInstance.INSTANCE.align(Modifier.INSTANCE, companion.getCenter()), j, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, yooTheme.getTypography(composerStartRestartGroup, 6).getCaption1Medium(), composerStartRestartGroup, (i2 & 14) | ((i2 << 3) & 896), 3072, 57336);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.icons.IconViewsKt$ValueElement$2
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
                    IconViewsKt.m3438ValueElementRIQooxk(str, j, j2, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
