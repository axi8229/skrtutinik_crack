package ru.yoomoney.sdk.kassa.payments.ui.color;

import kotlin.Metadata;
import org.pjsip.pjsua2.pjmedia_tp_proto;
import ru.yoomoney.sdk.guiCompose.theme.BackgroundColors;
import ru.yoomoney.sdk.guiCompose.theme.Palette;
import ru.yoomoney.sdk.guiCompose.theme.ThemeColors;
import ru.yoomoney.sdk.guiCompose.theme.TypeColors;
import ru.yoomoney.sdk.guiCompose.theme.YooColors;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"MSDKTheme", "Lru/yoomoney/sdk/guiCompose/theme/Palette;", "getMSDKTheme", "()Lru/yoomoney/sdk/guiCompose/theme/Palette;", "library_metricaRealRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaletteKt {
    private static final Palette MSDKTheme;

    static {
        YooColors.Companion companion = YooColors.INSTANCE;
        YooColors defaultColorsLight = companion.getDefaultColorsLight();
        ThemeColors theme = companion.getDefaultColorsLight().getTheme();
        Colors colors = Colors.INSTANCE;
        ThemeColors themeColorsM3410copytNS2XkQ = theme.m3410copytNS2XkQ((32 & 1) != 0 ? theme.tint : colors.m3487getTint0d7_KjU$library_metricaRealRelease(), (32 & 2) != 0 ? theme.tintFade : colors.m3477getFadeTint0d7_KjU$library_metricaRealRelease(), (32 & 4) != 0 ? theme.tintGhost : colors.m3478getGhostTint0d7_KjU$library_metricaRealRelease(), (32 & 8) != 0 ? theme.tintBg : colors.m3488getTintBg0d7_KjU$library_metricaRealRelease(), (32 & 16) != 0 ? theme.tintCard : colors.m3478getGhostTint0d7_KjU$library_metricaRealRelease(), (32 & 32) != 0 ? theme.tintSelection : 0L);
        BackgroundColors background = companion.getDefaultColorsLight().getBackground();
        BackgroundColors backgroundColorsM3360copyQ_H9qLU = background.m3360copyQ_H9qLU((64496 & 1) != 0 ? background.default : colors.m3473getDefault0d7_KjU$library_metricaRealRelease(), (64496 & 2) != 0 ? background.card : colors.m3471getCard0d7_KjU$library_metricaRealRelease(), (64496 & 4) != 0 ? background.divider : colors.m3475getDivider0d7_KjU$library_metricaRealRelease(), (64496 & 8) != 0 ? background.border : colors.m3469getBoarder0d7_KjU$library_metricaRealRelease(), (64496 & 16) != 0 ? background.ghost : 0L, (64496 & 32) != 0 ? background.tone : 0L, (64496 & 64) != 0 ? background.inverse : 0L, (64496 & 128) != 0 ? background.success : 0L, (64496 & 256) != 0 ? background.alert : 0L, (64496 & 512) != 0 ? background.ghostAlert : 0L, (64496 & 1024) != 0 ? background.actionRipple : colors.m3466getActionRipple0d7_KjU$library_metricaRealRelease(), (64496 & 2048) != 0 ? background.actionRippleInverse : 0L, (64496 & 4096) != 0 ? background.white : 0L, (64496 & 8192) != 0 ? background.black : 0L, (64496 & 16384) != 0 ? background.cardInverse : 0L, (64496 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? background.iconBar : 0L);
        TypeColors type = companion.getDefaultColorsLight().getType();
        YooColors yooColorsCopy = defaultColorsLight.copy(type.m3418copyK518z4((1008 & 1) != 0 ? type.primary : colors.m3481getPrimary0d7_KjU$library_metricaRealRelease(), (1008 & 2) != 0 ? type.secondary : colors.m3483getSecondary0d7_KjU$library_metricaRealRelease(), (1008 & 4) != 0 ? type.ghost : colors.m3485getSecondaryInverse0d7_KjU$library_metricaRealRelease(), (1008 & 8) != 0 ? type.inverse : colors.m3479getInverse0d7_KjU$library_metricaRealRelease(), (1008 & 16) != 0 ? type.secondaryInverse : 0L, (1008 & 32) != 0 ? type.ghostInverse : 0L, (1008 & 64) != 0 ? type.success : 0L, (1008 & 128) != 0 ? type.alert : 0L, (1008 & 256) != 0 ? type.black : 0L, (1008 & 512) != 0 ? type.disable : 0L), backgroundColorsM3360copyQ_H9qLU, themeColorsM3410copytNS2XkQ);
        YooColors defaultColorsDark = companion.getDefaultColorsDark();
        ThemeColors theme2 = companion.getDefaultColorsDark().getTheme();
        ThemeColors themeColorsM3410copytNS2XkQ2 = theme2.m3410copytNS2XkQ((32 & 1) != 0 ? theme2.tint : colors.m3487getTint0d7_KjU$library_metricaRealRelease(), (32 & 2) != 0 ? theme2.tintFade : colors.m3477getFadeTint0d7_KjU$library_metricaRealRelease(), (32 & 4) != 0 ? theme2.tintGhost : colors.m3478getGhostTint0d7_KjU$library_metricaRealRelease(), (32 & 8) != 0 ? theme2.tintBg : colors.m3489getTintBgDark0d7_KjU$library_metricaRealRelease(), (32 & 16) != 0 ? theme2.tintCard : colors.m3478getGhostTint0d7_KjU$library_metricaRealRelease(), (32 & 32) != 0 ? theme2.tintSelection : 0L);
        BackgroundColors background2 = companion.getDefaultColorsDark().getBackground();
        BackgroundColors backgroundColorsM3360copyQ_H9qLU2 = background2.m3360copyQ_H9qLU((64496 & 1) != 0 ? background2.default : colors.m3474getDefaultDark0d7_KjU$library_metricaRealRelease(), (64496 & 2) != 0 ? background2.card : colors.m3472getCardDark0d7_KjU$library_metricaRealRelease(), (64496 & 4) != 0 ? background2.divider : colors.m3476getDividerDark0d7_KjU$library_metricaRealRelease(), (64496 & 8) != 0 ? background2.border : colors.m3470getBoarderDark0d7_KjU$library_metricaRealRelease(), (64496 & 16) != 0 ? background2.ghost : 0L, (64496 & 32) != 0 ? background2.tone : 0L, (64496 & 64) != 0 ? background2.inverse : 0L, (64496 & 128) != 0 ? background2.success : 0L, (64496 & 256) != 0 ? background2.alert : 0L, (64496 & 512) != 0 ? background2.ghostAlert : 0L, (64496 & 1024) != 0 ? background2.actionRipple : colors.m3467getActionRippleDark0d7_KjU$library_metricaRealRelease(), (64496 & 2048) != 0 ? background2.actionRippleInverse : 0L, (64496 & 4096) != 0 ? background2.white : 0L, (64496 & 8192) != 0 ? background2.black : 0L, (64496 & 16384) != 0 ? background2.cardInverse : 0L, (64496 & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? background2.iconBar : 0L);
        TypeColors type2 = companion.getDefaultColorsDark().getType();
        MSDKTheme = new Palette(yooColorsCopy, defaultColorsDark.copy(type2.m3418copyK518z4((1008 & 1) != 0 ? type2.primary : colors.m3482getPrimaryDark0d7_KjU$library_metricaRealRelease(), (1008 & 2) != 0 ? type2.secondary : colors.m3484getSecondaryDark0d7_KjU$library_metricaRealRelease(), (1008 & 4) != 0 ? type2.ghost : colors.m3486getSecondaryInverseDark0d7_KjU$library_metricaRealRelease(), (1008 & 8) != 0 ? type2.inverse : colors.m3480getInverseDark0d7_KjU$library_metricaRealRelease(), (1008 & 16) != 0 ? type2.secondaryInverse : 0L, (1008 & 32) != 0 ? type2.ghostInverse : 0L, (1008 & 64) != 0 ? type2.success : 0L, (1008 & 128) != 0 ? type2.alert : 0L, (1008 & 256) != 0 ? type2.black : 0L, (1008 & 512) != 0 ? type2.disable : 0L), backgroundColorsM3360copyQ_H9qLU2, themeColorsM3410copytNS2XkQ2));
    }

    public static final Palette getMSDKTheme() {
        return MSDKTheme;
    }
}
