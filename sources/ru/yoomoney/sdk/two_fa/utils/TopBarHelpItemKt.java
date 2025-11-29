package ru.yoomoney.sdk.two_fa.utils;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;
import ru.yoomoney.sdk.two_fa.R;

/* compiled from: TopBarHelpItem.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"TopBarHelpItem", "", "onClick", "Lkotlin/Function0;", "enabled", "", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TopBarHelpItemKt {
    public static final void TopBarHelpItem(final Function0<Unit> onClick, final boolean z, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1125485);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1125485, i2, -1, "ru.yoomoney.sdk.two_fa.utils.TopBarHelpItem (TopBarHelpItem.kt:22)");
            }
            Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.ic_hint_l, composerStartRestartGroup, 0);
            Modifier.Companion companion = Modifier.INSTANCE;
            YooTheme yooTheme = YooTheme.INSTANCE;
            int i3 = YooTheme.$stable;
            Modifier modifierM330size3ABfNKs = SizeKt.m330size3ABfNKs(companion, yooTheme.getDimens(composerStartRestartGroup, i3).getSpaceXL());
            composerStartRestartGroup.startReplaceableGroup(593871394);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            IconKt.m648Iconww6aTOc(painterPainterResource, null, TestTagKt.testTag(ClickableKt.m170clickableO2vRcR0$default(modifierM330size3ABfNKs, (MutableInteractionSource) objRememberedValue, RippleKt.m698rememberRipple9IZ8Weo(false, 0.0f, 0L, composerStartRestartGroup, 6, 6), z, null, null, onClick, 24, null), HelpItemTestTags.helpButton), yooTheme.getColors(composerStartRestartGroup, i3).getTheme().getTint(), composerStartRestartGroup, 56, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.two_fa.utils.TopBarHelpItemKt.TopBarHelpItem.2
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
                    TopBarHelpItemKt.TopBarHelpItem(onClick, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
