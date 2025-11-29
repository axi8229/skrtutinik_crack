package ru.yoomoney.sdk.guiCompose.views.topbar;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.ContentAlphaKt;
import androidx.compose.material.ContentColorKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.theme.RippleThemeKt;
import ru.yoomoney.sdk.guiCompose.theme.RippleType;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;

/* compiled from: TopBar.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u001a\u0080\u0001\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u008e\u0001\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0016\u001az\u0010\u001a\u001a\u00020\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0084\u0001\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0003ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/painter/Painter;", "navigationPainter", "navigationContentDescription", "Lkotlin/Function0;", "", "onNavigationClick", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "actions", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "contentColor", "", "isElevated", "TopBarDefault-wqdebIU", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;JJZLandroidx/compose/runtime/Composer;II)V", "TopBarDefault", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;JJZLandroidx/compose/runtime/Composer;II)V", "isInverse", "TitleTopBar-wqdebIU", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;JJZZLandroidx/compose/runtime/Composer;I)V", "TitleTopBar", "TopBar-wqdebIU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;JJZZLandroidx/compose/runtime/Composer;I)V", "TopBar", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TopBarKt {
    /* JADX WARN: Removed duplicated region for block: B:112:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0126  */
    /* renamed from: TopBarDefault-wqdebIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m3460TopBarDefaultwqdebIU(final java.lang.String r31, androidx.compose.ui.Modifier r32, androidx.compose.ui.graphics.painter.Painter r33, java.lang.String r34, kotlin.jvm.functions.Function0<kotlin.Unit> r35, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, long r37, long r39, boolean r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt.m3460TopBarDefaultwqdebIU(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.painter.Painter, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, long, long, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0123  */
    /* renamed from: TopBarDefault-wqdebIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m3459TopBarDefaultwqdebIU(androidx.compose.ui.Modifier r32, androidx.compose.ui.graphics.painter.Painter r33, java.lang.String r34, kotlin.jvm.functions.Function0<kotlin.Unit> r35, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, long r38, long r40, boolean r42, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
        /*
            Method dump skipped, instructions count: 567
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt.m3459TopBarDefaultwqdebIU(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.painter.Painter, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, long, long, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TitleTopBar-wqdebIU, reason: not valid java name */
    public static final void m3457TitleTopBarwqdebIU(final String str, final Modifier modifier, final Painter painter, final String str2, final Function0<Unit> function0, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final long j, final long j2, final boolean z, final boolean z2, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1344836448);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1344836448, i, -1, "ru.yoomoney.sdk.guiCompose.views.topbar.TitleTopBar (TopBar.kt:154)");
        }
        int i2 = i >> 3;
        m3458TopBarwqdebIU(modifier, painter, str2, function0, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1464611593, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt$TitleTopBar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                invoke(rowScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope TopBar, Composer composer2, int i3) {
                Intrinsics.checkNotNullParameter(TopBar, "$this$TopBar");
                if ((i3 & 81) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1464611593, i3, -1, "ru.yoomoney.sdk.guiCompose.views.topbar.TitleTopBar.<anonymous> (TopBar.kt:161)");
                    }
                    String str3 = str;
                    if (str3 != null) {
                        boolean z3 = z2;
                        long primary = j2;
                        Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "TopBar.title");
                        YooTheme yooTheme = YooTheme.INSTANCE;
                        Modifier modifierM313paddingqDBjuR0$default = PaddingKt.m313paddingqDBjuR0$default(modifierTestTag, 0.0f, 0.0f, yooTheme.getDimens(composer2, 6).getSpaceM(), 0.0f, 11, null);
                        composer2.startReplaceableGroup(206480191);
                        if (!z3) {
                            primary = yooTheme.getColors(composer2, 6).getType().getPrimary();
                        }
                        long j3 = primary;
                        composer2.endReplaceableGroup();
                        TextKt.m685Text4IGK_g(str3, modifierM313paddingqDBjuR0$default, j3, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m2070getEllipsisgIe3tQ8(), false, 1, 0, null, yooTheme.getTypography(composer2, 6).getTitle3(), composer2, 0, 3120, 55288);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), function3, j, j2, z, z2, composerStartRestartGroup, (i2 & 7168) | (i2 & 14) | 24640 | (i2 & 896) | (458752 & i) | (3670016 & i) | (29360128 & i) | (234881024 & i) | (1879048192 & i));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt$TitleTopBar$2
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

                public final void invoke(Composer composer2, int i3) {
                    TopBarKt.m3457TitleTopBarwqdebIU(str, modifier, painter, str2, function0, function3, j, j2, z, z2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TopBar-wqdebIU, reason: not valid java name */
    public static final void m3458TopBarwqdebIU(final Modifier modifier, final Painter painter, final String str, final Function0<Unit> function0, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32, final long j, final long j2, final boolean z, final boolean z2, Composer composer, final int i) {
        float fM2102constructorimpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(-100158196);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-100158196, i, -1, "ru.yoomoney.sdk.guiCompose.views.topbar.TopBar (TopBar.kt:194)");
        }
        Modifier modifierTestTag = TestTagKt.testTag(modifier, "TopBar.root");
        composerStartRestartGroup.startReplaceableGroup(-1744737303);
        if (z) {
            fM2102constructorimpl = YooTheme.INSTANCE.getDimens(composerStartRestartGroup, 6).getElevationS();
        } else {
            fM2102constructorimpl = Dp.m2102constructorimpl(0);
        }
        float f = fM2102constructorimpl;
        composerStartRestartGroup.endReplaceableGroup();
        int i2 = i >> 15;
        AppBarKt.m594TopAppBarHsRjFd4(modifierTestTag, j, j2, f, PaddingKt.m306PaddingValuesYgX7TsA$default(YooTheme.INSTANCE.getDimens(composerStartRestartGroup, 6).getSpaceM(), 0.0f, 2, null), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -95739139, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt$TopBar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                invoke(rowScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final RowScope TopAppBar, Composer composer2, int i3) {
                Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                if ((i3 & 14) == 0) {
                    i3 |= composer2.changed(TopAppBar) ? 4 : 2;
                }
                if ((i3 & 91) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-95739139, i3, -1, "ru.yoomoney.sdk.guiCompose.views.topbar.TopBar.<anonymous> (TopBar.kt:202)");
                    }
                    RippleType rippleType = z2 ? RippleType.AlwaysBlack : RippleType.Colored;
                    final long j3 = j2;
                    final Painter painter2 = painter;
                    final Function3<RowScope, Composer, Integer, Unit> function33 = function3;
                    final Function3<RowScope, Composer, Integer, Unit> function34 = function32;
                    final String str2 = str;
                    final Function0<Unit> function02 = function0;
                    RippleThemeKt.RippleTheme(rippleType, ComposableLambdaKt.composableLambda(composer2, -368637904, true, new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt$TopBar$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i4) {
                            if ((i4 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-368637904, i4, -1, "ru.yoomoney.sdk.guiCompose.views.topbar.TopBar.<anonymous>.<anonymous> (TopBar.kt:203)");
                                }
                                ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m971boximpl(j3)), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(1.0f))};
                                final Painter painter3 = painter2;
                                final RowScope rowScope = TopAppBar;
                                final Function3<RowScope, Composer, Integer, Unit> function35 = function33;
                                final Function3<RowScope, Composer, Integer, Unit> function36 = function34;
                                final String str3 = str2;
                                final Function0<Unit> function03 = function02;
                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(composer3, 438541552, true, new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt.TopBar.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i5) {
                                        if ((i5 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(438541552, i5, -1, "ru.yoomoney.sdk.guiCompose.views.topbar.TopBar.<anonymous>.<anonymous>.<anonymous> (TopBar.kt:207)");
                                            }
                                            Painter painter4 = painter3;
                                            composer4.startReplaceableGroup(-419434773);
                                            if (painter4 != null) {
                                                String str4 = str3;
                                                Function0<Unit> function04 = function03;
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                Modifier modifierTestTag2 = TestTagKt.testTag(companion, "TopBar.navigation");
                                                composer4.startReplaceableGroup(1273120869);
                                                Object objRememberedValue = composer4.rememberedValue();
                                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                    composer4.updateRememberedValue(objRememberedValue);
                                                }
                                                composer4.endReplaceableGroup();
                                                IconKt.m648Iconww6aTOc(painter4, str4, ClickableKt.m170clickableO2vRcR0$default(modifierTestTag2, (MutableInteractionSource) objRememberedValue, RippleKt.m698rememberRipple9IZ8Weo(false, 0.0f, 0L, composer4, 6, 6), false, null, null, function04, 28, null), 0L, composer4, 8, 8);
                                                SpacerKt.Spacer(PaddingKt.m313paddingqDBjuR0$default(companion, 0.0f, 0.0f, YooTheme.INSTANCE.getDimens(composer4, 6).getSpace2XL(), 0.0f, 11, null), composer4, 0);
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer4.endReplaceableGroup();
                                            RowScope rowScope2 = rowScope;
                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                            Modifier modifierWeight$default = RowScope.weight$default(rowScope2, companion2, 1.0f, false, 2, null);
                                            Alignment.Companion companion3 = Alignment.INSTANCE;
                                            Alignment.Vertical centerVertically = companion3.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function37 = function35;
                                            composer4.startReplaceableGroup(693286680);
                                            Arrangement arrangement = Arrangement.INSTANCE;
                                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composer4, 48);
                                            composer4.startReplaceableGroup(-1323940314);
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierWeight$default);
                                            if (composer4.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer composerM727constructorimpl = Updater.m727constructorimpl(composer4);
                                            Updater.m728setimpl(composerM727constructorimpl, measurePolicyRowMeasurePolicy, companion4.getSetMeasurePolicy());
                                            Updater.m728setimpl(composerM727constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                            if (composerM727constructorimpl.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                composerM727constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                composerM727constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            function3ModifierMaterializerOf.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composer4)), composer4, 0);
                                            composer4.startReplaceableGroup(2058660585);
                                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                            function37.invoke(rowScopeInstance, composer4, 6);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            Alignment.Vertical centerVertically2 = companion3.getCenterVertically();
                                            Arrangement.Horizontal horizontalM294spacedByD5KLDUw = arrangement.m294spacedByD5KLDUw(YooTheme.INSTANCE.getDimens(composer4, 6).getSpaceM(), companion3.getEnd());
                                            Function3<RowScope, Composer, Integer, Unit> function38 = function36;
                                            composer4.startReplaceableGroup(693286680);
                                            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalM294spacedByD5KLDUw, centerVertically2, composer4, 48);
                                            composer4.startReplaceableGroup(-1323940314);
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
                                            if (composer4.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor2);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer composerM727constructorimpl2 = Updater.m727constructorimpl(composer4);
                                            Updater.m728setimpl(composerM727constructorimpl2, measurePolicyRowMeasurePolicy2, companion4.getSetMeasurePolicy());
                                            Updater.m728setimpl(composerM727constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                                            if (composerM727constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM727constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                composerM727constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                composerM727constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                            }
                                            function3ModifierMaterializerOf2.invoke(SkippableUpdater.m721boximpl(SkippableUpdater.m722constructorimpl(composer4)), composer4, 0);
                                            composer4.startReplaceableGroup(2058660585);
                                            function38.invoke(rowScopeInstance, composer4, 6);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 56);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, 48, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), composerStartRestartGroup, (i2 & 112) | 196608 | (i2 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.topbar.TopBarKt$TopBar$2
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

                public final void invoke(Composer composer2, int i3) {
                    TopBarKt.m3458TopBarwqdebIU(modifier, painter, str, function0, function3, function32, j, j2, z, z2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
