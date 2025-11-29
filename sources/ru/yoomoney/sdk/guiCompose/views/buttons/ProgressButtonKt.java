package ru.yoomoney.sdk.guiCompose.views.buttons;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjmedia_tp_proto;
import ru.yoomoney.sdk.guiCompose.theme.YooTheme;

/* compiled from: ProgressButton.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\t\u001aM\u0010\n\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0001¢\u0006\u0002\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"ButtonProgress", "", RemoteMessageConst.Notification.COLOR, "Landroidx/compose/ui/graphics/Color;", "ButtonProgress-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)V", "ButtonText", "text", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ProgressButton", "modifier", "Landroidx/compose/ui/Modifier;", "buttonsColors", "Landroidx/compose/material/ButtonColors;", "isProgress", "", "enabled", "rippleType", "Lru/yoomoney/sdk/guiCompose/theme/RippleType;", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ButtonColors;ZZLru/yoomoney/sdk/guiCompose/theme/RippleType;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "guiCompose_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ProgressButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void ProgressButton(final java.lang.String r16, final androidx.compose.ui.Modifier r17, final androidx.compose.material.ButtonColors r18, final boolean r19, final boolean r20, ru.yoomoney.sdk.guiCompose.theme.RippleType r21, final kotlin.jvm.functions.Function0<kotlin.Unit> r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.guiCompose.views.buttons.ProgressButtonKt.ProgressButton(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.material.ButtonColors, boolean, boolean, ru.yoomoney.sdk.guiCompose.theme.RippleType, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ButtonProgress-ek8zF_U, reason: not valid java name */
    public static final void m3430ButtonProgressek8zF_U(final long j, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1227797391);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1227797391, i2, -1, "ru.yoomoney.sdk.guiCompose.views.buttons.ButtonProgress (ProgressButton.kt:59)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "Button.progress");
            YooTheme yooTheme = YooTheme.INSTANCE;
            ProgressIndicatorKt.m651CircularProgressIndicatorLxG7B9w(SizeKt.m330size3ABfNKs(PaddingKt.m311paddingVpY3zN4$default(modifierTestTag, yooTheme.getDimens(composerStartRestartGroup, 6).getSpaceS(), 0.0f, 2, null), yooTheme.getDimens(composerStartRestartGroup, 6).getButtonProgressSize()), j, yooTheme.getDimens(composerStartRestartGroup, 6).getButtonProgressStrokeWidth(), 0L, 0, composerStartRestartGroup, (i2 << 3) & 112, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.buttons.ProgressButtonKt$ButtonProgress$1
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
                    ProgressButtonKt.m3430ButtonProgressek8zF_U(j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ButtonText(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(296699885);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(296699885, i2, -1, "ru.yoomoney.sdk.guiCompose.views.buttons.ButtonText (ProgressButton.kt:71)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "Button.text");
            YooTheme yooTheme = YooTheme.INSTANCE;
            Modifier modifierM311paddingVpY3zN4$default = PaddingKt.m311paddingVpY3zN4$default(modifierTestTag, yooTheme.getDimens(composerStartRestartGroup, 6).getSpaceM(), 0.0f, 2, null);
            int iM2070getEllipsisgIe3tQ8 = TextOverflow.INSTANCE.m2070getEllipsisgIe3tQ8();
            TextStyle bodyMedium = yooTheme.getTypography(composerStartRestartGroup, 6).getBodyMedium();
            composer2 = composerStartRestartGroup;
            TextKt.m685Text4IGK_g(str, modifierM311paddingVpY3zN4$default, 0L, 0L, null, null, null, 0L, null, null, 0L, iM2070getEllipsisgIe3tQ8, false, 1, 0, null, bodyMedium.m1802copyp1EtxEg((15204351 & 1) != 0 ? bodyMedium.spanStyle.m1763getColor0d7_KjU() : Color.INSTANCE.m990getUnspecified0d7_KjU(), (15204351 & 2) != 0 ? bodyMedium.spanStyle.getFontSize() : 0L, (15204351 & 4) != 0 ? bodyMedium.spanStyle.getFontWeight() : null, (15204351 & 8) != 0 ? bodyMedium.spanStyle.getFontStyle() : null, (15204351 & 16) != 0 ? bodyMedium.spanStyle.getFontSynthesis() : null, (15204351 & 32) != 0 ? bodyMedium.spanStyle.getFontFamily() : null, (15204351 & 64) != 0 ? bodyMedium.spanStyle.getFontFeatureSettings() : null, (15204351 & 128) != 0 ? bodyMedium.spanStyle.getLetterSpacing() : 0L, (15204351 & 256) != 0 ? bodyMedium.spanStyle.getBaselineShift() : null, (15204351 & 512) != 0 ? bodyMedium.spanStyle.getTextGeometricTransform() : null, (15204351 & 1024) != 0 ? bodyMedium.spanStyle.getLocaleList() : null, (15204351 & 2048) != 0 ? bodyMedium.spanStyle.getBackground() : 0L, (15204351 & 4096) != 0 ? bodyMedium.spanStyle.getTextDecoration() : null, (15204351 & 8192) != 0 ? bodyMedium.spanStyle.getShadow() : null, (15204351 & 16384) != 0 ? bodyMedium.spanStyle.getDrawStyle() : null, (15204351 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? bodyMedium.paragraphStyle.getTextAlign() : 0, (15204351 & pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1) != 0 ? bodyMedium.paragraphStyle.getTextDirection() : 0, (15204351 & 131072) != 0 ? bodyMedium.paragraphStyle.getLineHeight() : 0L, (15204351 & 262144) != 0 ? bodyMedium.paragraphStyle.getTextIndent() : null, (15204351 & 524288) != 0 ? bodyMedium.platformStyle : null, (15204351 & 1048576) != 0 ? bodyMedium.paragraphStyle.getLineHeightStyle() : null, (15204351 & 2097152) != 0 ? bodyMedium.paragraphStyle.getLineBreak() : 0, (15204351 & 4194304) != 0 ? bodyMedium.paragraphStyle.getHyphens() : 0, (15204351 & 8388608) != 0 ? bodyMedium.paragraphStyle.getTextMotion() : null), composer2, i2 & 14, 3120, 55292);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: ru.yoomoney.sdk.guiCompose.views.buttons.ProgressButtonKt.ButtonText.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    ProgressButtonKt.ButtonText(str, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
